package com.qflutter.superchannel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SuperChannelUtils
{
  static Map encodeEventResults(String paramString, Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString);
    localHashMap.put("params", paramMap);
    return localHashMap;
  }
  
  static Map encodeTaskResults(List paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", "batchTasks");
    localHashMap.put("results", paramList);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelUtils
 * JD-Core Version:    0.7.0.1
 */