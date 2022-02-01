package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages
{
  private static HashMap wrapError(Exception paramException)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", paramException.toString());
    localHashMap.put("code", paramException.getClass().getSimpleName());
    localHashMap.put("details", null);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages
 * JD-Core Version:    0.7.0.1
 */