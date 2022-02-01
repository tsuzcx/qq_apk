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
    boolean bool = true;
    if (paramParsableByteArray.readUnsignedByte() == 1) {}
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
  
  private static Object readAmfData(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return readAmfDouble(paramParsableByteArray);
    case 1: 
      return readAmfBoolean(paramParsableByteArray);
    case 2: 
      return readAmfString(paramParsableByteArray);
    case 3: 
      return readAmfObject(paramParsableByteArray);
    case 8: 
      return readAmfEcmaArray(paramParsableByteArray);
    case 10: 
      return readAmfStrictArray(paramParsableByteArray);
    }
    return readAmfDate(paramParsableByteArray);
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
    if (readAmfType(paramParsableByteArray) != 2) {
      throw new ParserException();
    }
    if (!"onMetaData".equals(readAmfString(paramParsableByteArray))) {}
    double d;
    do
    {
      do
      {
        do
        {
          return;
        } while (readAmfType(paramParsableByteArray) != 8);
        paramParsableByteArray = readAmfEcmaArray(paramParsableByteArray);
      } while (!paramParsableByteArray.containsKey("duration"));
      d = ((Double)paramParsableByteArray.get("duration")).doubleValue();
    } while (d <= 0.0D);
    this.durationUs = ((d * 1000000.0D));
  }
  
  public void seek() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader
 * JD-Core Version:    0.7.0.1
 */