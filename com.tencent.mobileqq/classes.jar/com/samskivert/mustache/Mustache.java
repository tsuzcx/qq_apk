package com.samskivert.mustache;

import java.io.Reader;

public class Mustache
{
  protected static final Mustache.Formatter DEFAULT_FORMATTER = new Mustache.2();
  protected static final Mustache.TemplateLoader FAILING_LOADER = new Mustache.1();
  protected static final int MATCHING_END = 2;
  protected static final int MATCHING_START = 1;
  protected static final char NO_CHAR = '\000';
  protected static final int TAG = 3;
  protected static final int TEXT = 0;
  
  protected static boolean allowsWhitespace(char paramChar)
  {
    return (paramChar == '=') || (paramChar == '!');
  }
  
  protected static Template compile(Reader paramReader, Mustache.Compiler paramCompiler)
  {
    return new Template(trim(new Mustache.Parser(paramCompiler).parse(paramReader).finish(), true), paramCompiler);
  }
  
  public static Mustache.Compiler compiler()
  {
    return new Mustache.Compiler(false, false, null, false, false, false, DEFAULT_FORMATTER, Escapers.HTML, FAILING_LOADER, new DefaultCollector(), new Mustache.Delims());
  }
  
  protected static void restoreStartTag(StringBuilder paramStringBuilder, Mustache.Delims paramDelims)
  {
    paramStringBuilder.insert(0, paramDelims.start1);
    if (paramDelims.start2 != 0) {
      paramStringBuilder.insert(1, paramDelims.start2);
    }
  }
  
  protected static Template.Segment[] trim(Template.Segment[] paramArrayOfSegment, boolean paramBoolean)
  {
    int n = paramArrayOfSegment.length;
    int i = 0;
    while (i < n)
    {
      Object localObject = paramArrayOfSegment[i];
      Mustache.StringSegment localStringSegment2 = null;
      Template.Segment localSegment1;
      if (i > 0) {
        localSegment1 = paramArrayOfSegment[(i - 1)];
      } else {
        localSegment1 = null;
      }
      Template.Segment localSegment2;
      if (i < n - 1) {
        localSegment2 = paramArrayOfSegment[(i + 1)];
      } else {
        localSegment2 = null;
      }
      Mustache.StringSegment localStringSegment1;
      if ((localSegment1 instanceof Mustache.StringSegment)) {
        localStringSegment1 = (Mustache.StringSegment)localSegment1;
      } else {
        localStringSegment1 = null;
      }
      if ((localSegment2 instanceof Mustache.StringSegment)) {
        localStringSegment2 = (Mustache.StringSegment)localSegment2;
      }
      int m = 1;
      int j;
      if (((localSegment1 == null) && (paramBoolean)) || ((localStringSegment1 != null) && (localStringSegment1.trailsBlank()))) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if (localSegment2 == null)
      {
        k = m;
        if (paramBoolean) {}
      }
      else if ((localStringSegment2 != null) && (localStringSegment2.leadsBlank()))
      {
        k = m;
      }
      else
      {
        k = 0;
      }
      if ((localObject instanceof Mustache.BlockSegment))
      {
        localObject = (Mustache.BlockSegment)localObject;
        if ((j != 0) && (((Mustache.BlockSegment)localObject).firstLeadsBlank()))
        {
          if (localSegment1 != null) {
            paramArrayOfSegment[(i - 1)] = localStringSegment1.trimTrailBlank();
          }
          ((Mustache.BlockSegment)localObject).trimFirstBlank();
        }
        if ((k != 0) && (((Mustache.BlockSegment)localObject).lastTrailsBlank()))
        {
          ((Mustache.BlockSegment)localObject).trimLastBlank();
          if (localSegment2 != null) {
            paramArrayOfSegment[(i + 1)] = localStringSegment2.trimLeadBlank();
          }
        }
      }
      else if (((localObject instanceof Mustache.FauxSegment)) && (j != 0) && (k != 0))
      {
        if (localSegment1 != null) {
          paramArrayOfSegment[(i - 1)] = localStringSegment1.trimTrailBlank();
        }
        if (localSegment2 != null) {
          paramArrayOfSegment[(i + 1)] = localStringSegment2.trimLeadBlank();
        }
      }
      i += 1;
    }
    return paramArrayOfSegment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache
 * JD-Core Version:    0.7.0.1
 */