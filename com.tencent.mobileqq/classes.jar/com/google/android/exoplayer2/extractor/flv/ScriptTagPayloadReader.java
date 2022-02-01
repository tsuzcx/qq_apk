package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class ScriptTagPayloadReader
  extends TagPayloadReader
{
  private static final int AMF_TYPE_BOOLEAN = 1;
  private static final int AMF_TYPE_DATE = 11;
  private static final int AMF_TYPE_ECMA_ARRAY = 8;
  private static final int AMF_TYPE_END_MARKER = 9;
  private static final int AMF_TYPE_NUMBER = 0;
  private static final int AMF_TYPE_OBJECT = 3;
  private static final int AMF_TYPE_STRICT_ARRAY = 10;
  private static final int AMF_TYPE_STRING = 2;
  private static final String KEY_DURATION = "duration";
  private static final String NAME_METADATA = "onMetaData";
  private long durationUs = -9223372036854775807L;
  
  public ScriptTagPayloadReader()
  {
    super(null);
  }
  
  private static Boolean readAmfBoolean(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readUnsignedByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private static Object readAmfData(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 8)
            {
              if (paramInt != 10)
              {
                if (paramInt != 11) {
                  return null;
                }
                return readAmfDate(paramParsableByteArray);
              }
              return readAmfStrictArray(paramParsableByteArray);
            }
            return readAmfEcmaArray(paramParsableByteArray);
          }
          return readAmfObject(paramParsableByteArray);
        }
        return readAmfString(paramParsableByteArray);
      }
      return readAmfBoolean(paramParsableByteArray);
    }
    return readAmfDouble(paramParsableByteArray);
  }
  
  private static Date readAmfDate(ParsableByteArray paramParsableByteArray)
  {
    Date localDate = new Date(readAmfDouble(paramParsableByteArray).doubleValue());
    paramParsableByteArray.skipBytes(2);
    return localDate;
  }
  
  private static Double readAmfDouble(ParsableByteArray paramParsableByteArray)
  {
    return Double.valueOf(Double.longBitsToDouble(paramParsableByteArray.readLong()));
  }
  
  private static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedIntToInt();
    HashMap localHashMap = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      localHashMap.put(readAmfString(paramParsableByteArray), readAmfData(paramParsableByteArray, readAmfType(paramParsableByteArray)));
      i += 1;
    }
    return localHashMap;
  }
  
  private static HashMap<String, Object> readAmfObject(ParsableByteArray paramParsableByteArray)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str = readAmfString(paramParsableByteArray);
      int i = readAmfType(paramParsableByteArray);
      if (i == 9) {
        return localHashMap;
      }
      localHashMap.put(str, readAmfData(paramParsableByteArray, i));
    }
  }
  
  private static ArrayList<Object> readAmfStrictArray(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedIntToInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(readAmfData(paramParsableByteArray, readAmfType(paramParsableByteArray)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static String readAmfString(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readUnsignedShort();
    int j = paramParsableByteArray.getPosition();
    paramParsableByteArray.skipBytes(i);
    return new String(paramParsableByteArray.data, j, i);
  }
  
  private static int readAmfType(ParsableByteArray paramParsableByteArray)
  {
    return paramParsableByteArray.readUnsignedByte();
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  protected boolean parseHeader(ParsableByteArray paramParsableByteArray)
  {
    return true;
  }
  
  protected void parsePayload(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    if (readAmfType(paramParsableByteArray) == 2)
    {
      if (!"onMetaData".equals(readAmfString(paramParsableByteArray))) {
        return;
      }
      if (readAmfType(paramParsableByteArray) != 8) {
        return;
      }
      paramParsableByteArray = readAmfEcmaArray(paramParsableByteArray);
      if (paramParsableByteArray.containsKey("duration"))
      {
        double d = ((Double)paramParsableByteArray.get("duration")).doubleValue();
        if (d > 0.0D) {
          this.durationUs = ((d * 1000000.0D));
        }
      }
      return;
    }
    throw new ParserException();
  }
  
  public void seek() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader
 * JD-Core Version:    0.7.0.1
 */