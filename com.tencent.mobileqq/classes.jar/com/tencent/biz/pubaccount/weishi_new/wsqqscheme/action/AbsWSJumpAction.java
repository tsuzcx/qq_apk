package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import java.util.Map;

public abstract class AbsWSJumpAction
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  
  private void a(Map<String, String> paramMap)
  {
    this.a = ((String)paramMap.get("ext_data"));
    this.b = ((String)paramMap.get("src_type"));
    this.c = ((String)paramMap.get("scene"));
    this.d = ((String)paramMap.get("scenes_channel_from"));
  }
  
  protected abstract boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject);
  
  public boolean b(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramMap);
    return a(paramContext, paramMap, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.AbsWSJumpAction
 * JD-Core Version:    0.7.0.1
 */