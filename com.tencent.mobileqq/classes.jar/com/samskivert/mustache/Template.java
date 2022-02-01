package com.samskivert.mustache;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Map;

public class Template
{
  protected static final String DOT_NAME = ".";
  protected static final String FIRST_NAME = "-first";
  protected static final String INDEX_NAME = "-index";
  protected static final String LAST_NAME = "-last";
  protected static Mustache.VariableFetcher NOT_FOUND_FETCHER = new Template.2();
  public static final Object NO_FETCHER_FOUND = new String("<no fetcher found>");
  protected static final String THIS_NAME = "this";
  protected final Mustache.Compiler _compiler;
  protected final Map<Template.Key, Mustache.VariableFetcher> _fcache;
  protected final Template.Segment[] _segs;
  
  protected Template(Template.Segment[] paramArrayOfSegment, Mustache.Compiler paramCompiler)
  {
    this._segs = paramArrayOfSegment;
    this._compiler = paramCompiler;
    this._fcache = paramCompiler.collector.createFetcherCache();
  }
  
  protected static boolean isThisName(String paramString)
  {
    return (".".equals(paramString)) || ("this".equals(paramString));
  }
  
  protected Object checkForMissing(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == NO_FETCHER_FOUND)
    {
      if (paramBoolean) {
        localObject = null;
      }
    }
    else {
      return localObject;
    }
    throw new MustacheException.Context("No method or field with name '" + paramString + "' on line " + paramInt, paramString, paramInt);
  }
  
  protected Template.Fragment createFragment(Template.Segment[] paramArrayOfSegment, Template.Context paramContext)
  {
    return new Template.1(this, paramContext, paramArrayOfSegment);
  }
  
  public String execute(Object paramObject)
  {
    StringWriter localStringWriter = new StringWriter();
    execute(paramObject, localStringWriter);
    return localStringWriter.toString();
  }
  
  public void execute(Object paramObject, Writer paramWriter)
  {
    executeSegs(new Template.Context(paramObject, null, 0, false, false), paramWriter);
  }
  
  public void execute(Object paramObject1, Object paramObject2, Writer paramWriter)
  {
    executeSegs(new Template.Context(paramObject1, new Template.Context(paramObject2, null, 0, false, false), 0, false, false), paramWriter);
  }
  
  protected void executeSegs(Template.Context paramContext, Writer paramWriter)
  {
    Template.Segment[] arrayOfSegment = this._segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].execute(this, paramContext, paramWriter);
      i += 1;
    }
  }
  
  protected Object getCompoundValue(Template.Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramString.split("\\.");
    paramContext = getValue(paramContext, arrayOfString[0], paramInt, paramBoolean);
    int i = 1;
    while (i < arrayOfString.length)
    {
      if (paramContext == NO_FETCHER_FOUND)
      {
        if (!paramBoolean) {
          throw new MustacheException.Context("Missing context for compound variable '" + paramString + "' on line " + paramInt + ". '" + arrayOfString[(i - 1)] + "' was not found.", paramString, paramInt);
        }
        return null;
      }
      if (paramContext == null) {
        return null;
      }
      paramContext = getValueIn(paramContext, arrayOfString[i], paramInt);
      i += 1;
    }
    return checkForMissing(paramString, paramInt, paramBoolean, paramContext);
  }
  
  protected Object getSectionValue(Template.Context paramContext, String paramString, int paramInt)
  {
    if (!this._compiler.strictSections) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = getValue(paramContext, paramString, paramInt, bool);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = Collections.emptyList();
      }
      return paramContext;
    }
  }
  
  protected Object getValue(Template.Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (paramString.equals("-first"))
    {
      localObject1 = Boolean.valueOf(paramContext.onFirst);
      return localObject1;
    }
    if (paramString.equals("-last")) {
      return Boolean.valueOf(paramContext.onLast);
    }
    if (paramString.equals("-index")) {
      return Integer.valueOf(paramContext.index);
    }
    if (this._compiler.standardsMode) {
      return checkForMissing(paramString, paramInt, paramBoolean, getValueIn(paramContext.data, paramString, paramInt));
    }
    for (Template.Context localContext = paramContext;; localContext = localContext.parent)
    {
      if (localContext == null) {
        break label127;
      }
      Object localObject2 = getValueIn(localContext.data, paramString, paramInt);
      localObject1 = localObject2;
      if (localObject2 != NO_FETCHER_FOUND) {
        break;
      }
    }
    label127:
    if ((!paramString.equals(".")) && (paramString.indexOf(".") != -1)) {
      return getCompoundValue(paramContext, paramString, paramInt, paramBoolean);
    }
    return checkForMissing(paramString, paramInt, paramBoolean, NO_FETCHER_FOUND);
  }
  
  protected Object getValueIn(Object paramObject, String paramString, int paramInt)
  {
    if (isThisName(paramString)) {
      return paramObject;
    }
    if (paramObject == null) {
      throw new NullPointerException("Null context for variable '" + paramString + "' on line " + paramInt);
    }
    Template.Key localKey = new Template.Key(paramObject.getClass(), paramString);
    Object localObject = (Mustache.VariableFetcher)this._fcache.get(localKey);
    Mustache.VariableFetcher localVariableFetcher1;
    if (localObject != null) {
      try
      {
        localObject = ((Mustache.VariableFetcher)localObject).get(paramObject, paramString);
        return localObject;
      }
      catch (Exception localException)
      {
        localVariableFetcher1 = this._compiler.collector.createFetcher(paramObject, localKey.name);
      }
    }
    for (;;)
    {
      Mustache.VariableFetcher localVariableFetcher2 = localVariableFetcher1;
      if (localVariableFetcher1 == null) {
        localVariableFetcher2 = NOT_FOUND_FETCHER;
      }
      try
      {
        paramObject = localVariableFetcher2.get(paramObject, paramString);
        this._fcache.put(localKey, localVariableFetcher2);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        throw new MustacheException.Context("Failure fetching variable '" + paramString + "' on line " + paramInt, paramString, paramInt, paramObject);
      }
      localVariableFetcher1 = this._compiler.collector.createFetcher(paramObject, localKey.name);
    }
  }
  
  protected Object getValueOrDefault(Template.Context paramContext, String paramString, int paramInt)
  {
    Object localObject = getValue(paramContext, paramString, paramInt, this._compiler.missingIsNull);
    paramContext = localObject;
    if (localObject == null) {
      paramContext = this._compiler.computeNullValue(paramString);
    }
    return paramContext;
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    Template.Segment[] arrayOfSegment = this._segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].visit(paramVisitor);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template
 * JD-Core Version:    0.7.0.1
 */