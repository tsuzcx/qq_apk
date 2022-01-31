package com.qflutter.resource_loader;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;

public class NativeImageReplyInfo
{
  static final String PixelsFormat_bgra8888 = "bgra8888";
  static final String PixelsFormat_rgba8888 = "rgba8888";
  static final int TYPE_COLOR = 6;
  static final int TYPE_ERROR = 0;
  static final int TYPE_PATH = 1;
  static final int TYPE_PIXELS_DATA = 3;
  static final int TYPE_RAW_DATA = 4;
  static final int TYPE_RAW_DATA_UINT8_LIST = 5;
  static final int TYPE_TEXTURE_ID = 7;
  static final int TYPE_URL = 2;
  Rect borderRadius;
  int color;
  NinePatchInfo ninePatchInfo;
  String path;
  long pixelsDataAddress;
  String pixelsDataFormat = "rgba8888";
  int pixelsDataHeight;
  int pixelsDataWidth;
  long rawDataAddress;
  int rawDataLength;
  double scale;
  int type = 0;
  String url;
  
  public Map<String, Object> buildFlutterReply()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", Integer.valueOf(this.type));
    if (this.type == 3)
    {
      localHashMap.put("pixelsDataAddress", Long.valueOf(this.pixelsDataAddress));
      localHashMap.put("pixelsDataWidth", Integer.valueOf(this.pixelsDataWidth));
      localHashMap.put("pixelsDataHeight", Integer.valueOf(this.pixelsDataHeight));
      localHashMap.put("pixelsDataFormat", this.pixelsDataFormat);
    }
    for (;;)
    {
      if (this.ninePatchInfo != null)
      {
        localHashMap.put("ninePatchCenterSlice", new int[] { this.ninePatchInfo.centerSlice.left, this.ninePatchInfo.centerSlice.top, this.ninePatchInfo.centerSlice.right, this.ninePatchInfo.centerSlice.bottom });
        if ((this.ninePatchInfo.mDivX != null) && (this.ninePatchInfo.mDivY != null))
        {
          localHashMap.put("ninePatchDivX", this.ninePatchInfo.mDivX);
          localHashMap.put("ninePatchDivY", this.ninePatchInfo.mDivY);
        }
      }
      if (this.scale > 0.01D) {
        localHashMap.put("scale", Double.valueOf(this.scale));
      }
      return localHashMap;
      if (this.type == 4)
      {
        localHashMap.put("rawDataAddress", Long.valueOf(this.rawDataAddress));
        localHashMap.put("rawDataLength", Integer.valueOf(this.rawDataLength));
      }
      else if (this.type == 1)
      {
        localHashMap.put("path", this.path);
      }
      else if (this.type == 2)
      {
        localHashMap.put("url", this.url);
      }
      else if (this.type == 6)
      {
        localHashMap.put("color", Integer.valueOf(this.color));
        if (this.borderRadius != null) {
          localHashMap.put("borderRadius", new int[] { this.borderRadius.left, this.borderRadius.top, this.borderRadius.right, this.borderRadius.bottom });
        }
      }
      else
      {
        int i = this.type;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.NativeImageReplyInfo
 * JD-Core Version:    0.7.0.1
 */