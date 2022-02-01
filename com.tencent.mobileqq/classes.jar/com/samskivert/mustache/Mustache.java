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
    int m = paramArrayOfSegment.length;
    int i = 0;
    if (i < m)
    {
      Object localObject = paramArrayOfSegment[i];
      Template.Segment localSegment1;
      label28:
      Template.Segment localSegment2;
      label43:
      Mustache.StringSegment localStringSegment1;
      label58:
      Mustache.StringSegment localStringSegment2;
      label73:
      int j;
      label97:
      int k;
      if (i > 0)
      {
        localSegment1 = paramArrayOfSegment[(i - 1)];
        if (i >= m - 1) {
          break label215;
        }
        localSegment2 = paramArrayOfSegment[(i + 1)];
        if (!(localSegment1 instanceof Mustache.StringSegment)) {
          break label221;
        }
        localStringSegment1 = (Mustache.StringSegment)localSegment1;
        if (!(localSegment2 instanceof Mustache.StringSegment)) {
          break label227;
        }
        localStringSegment2 = (Mustache.StringSegment)localSegment2;
        if (((localSegment1 != null) || (!paramBoolean)) && ((localStringSegment1 == null) || (!localStringSegment1.trailsBlank()))) {
          break label233;
        }
        j = 1;
        if (((localSegment2 != null) || (!paramBoolean)) && ((localStringSegment2 == null) || (!localStringSegment2.leadsBlank()))) {
          break label238;
        }
        k = 1;
        label122:
        if (!(localObject instanceof Mustache.BlockSegment)) {
          break label244;
        }
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
      for (;;)
      {
        i += 1;
        break;
        localSegment1 = null;
        break label28;
        label215:
        localSegment2 = null;
        break label43;
        label221:
        localStringSegment1 = null;
        break label58;
        label227:
        localStringSegment2 = null;
        break label73;
        label233:
        j = 0;
        break label97;
        label238:
        k = 0;
        break label122;
        label244:
        if (((localObject instanceof Mustache.FauxSegment)) && (j != 0) && (k != 0))
        {
          if (localSegment1 != null) {
            paramArrayOfSegment[(i - 1)] = localStringSegment1.trimTrailBlank();
          }
          if (localSegment2 != null) {
            paramArrayOfSegment[(i + 1)] = localStringSegment2.trimLeadBlank();
          }
        }
      }
    }
    return paramArrayOfSegment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache
 * JD-Core Version:    0.7.0.1
 */