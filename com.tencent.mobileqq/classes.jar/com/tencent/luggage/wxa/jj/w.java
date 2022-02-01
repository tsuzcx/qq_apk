package com.tencent.luggage.wxa.jj;

import java.util.LinkedList;
import org.json.JSONArray;

final class w
{
  static LinkedList<String> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.w
 * JD-Core Version:    0.7.0.1
 */