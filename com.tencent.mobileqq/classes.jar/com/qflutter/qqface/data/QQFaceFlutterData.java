package com.qflutter.qqface.data;

import java.util.HashMap;
import java.util.Map;

public class QQFaceFlutterData
{
  public static final int FORMAT_BYTE_BUFFER = 3;
  public static final int FORMAT_PATH = 2;
  public static final int FORMAT_RAW_DATA = 1;
  public static final int FORMAT_SHARE_PTR = 0;
  public int bitmapHeight;
  public long bitmapPtr;
  public int bitmapWidth;
  public int dataFormat;
  public String faceId;
  public boolean isDefault;
  public String path;
  public String pixelsFormat;
  public byte[] rawData;
  
  public QQFaceFlutterData(String paramString)
  {
    this.faceId = paramString;
  }
  
  public Map<String, Object> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("faceId", this.faceId);
    localHashMap.put("dataFormat", Integer.valueOf(this.dataFormat));
    localHashMap.put("bitmapPtr", Long.valueOf(this.bitmapPtr));
    localHashMap.put("bitmapWidth", Integer.valueOf(this.bitmapWidth));
    localHashMap.put("bitmapHeight", Integer.valueOf(this.bitmapHeight));
    localHashMap.put("pixelsFormat", this.pixelsFormat);
    localHashMap.put("path", this.path);
    localHashMap.put("rawData", this.rawData);
    localHashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("isDefault", Boolean.valueOf(this.isDefault));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqface.data.QQFaceFlutterData
 * JD-Core Version:    0.7.0.1
 */