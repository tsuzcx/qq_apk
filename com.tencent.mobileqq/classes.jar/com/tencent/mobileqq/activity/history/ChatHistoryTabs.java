package com.tencent.mobileqq.activity.history;

import android.content.Context;
import java.util.ArrayList;

public class ChatHistoryTabs
{
  public int[] a;
  public String[] b;
  public ArrayList<ChatHistoryTabs.ChatHistoryTabInfo> c = new ArrayList();
  
  public void a(Context paramContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.a = paramArrayOfInt1;
    String[] arrayOfString = new String[paramArrayOfInt2.length];
    int i = 0;
    while (i < paramArrayOfInt2.length)
    {
      arrayOfString[i] = paramContext.getString(paramArrayOfInt2[i]);
      this.c.add(new ChatHistoryTabs.ChatHistoryTabInfo(paramArrayOfInt1[i], arrayOfString[i]));
      i += 1;
    }
    this.b = arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTabs
 * JD-Core Version:    0.7.0.1
 */