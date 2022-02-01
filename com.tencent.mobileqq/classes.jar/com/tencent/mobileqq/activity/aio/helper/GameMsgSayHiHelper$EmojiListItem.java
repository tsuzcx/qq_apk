package com.tencent.mobileqq.activity.aio.helper;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameMsgSayHiHelper$EmojiListItem
{
  public int a;
  public String b;
  public int c;
  public String d;
  public ArrayList<String> e;
  
  public GameMsgSayHiHelper$EmojiListItem()
  {
    this.a = 0;
    this.d = "";
    this.b = null;
    this.c = 0;
    this.e = new ArrayList();
  }
  
  public GameMsgSayHiHelper$EmojiListItem(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("configId");
    this.d = paramJSONObject.optString("desc", "");
    this.b = paramJSONObject.optString("imageUrl");
    int i = 0;
    this.c = 0;
    this.e = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("textList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      while (i < paramJSONObject.length())
      {
        this.e.add(paramJSONObject.optString(i, ""));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper.EmojiListItem
 * JD-Core Version:    0.7.0.1
 */