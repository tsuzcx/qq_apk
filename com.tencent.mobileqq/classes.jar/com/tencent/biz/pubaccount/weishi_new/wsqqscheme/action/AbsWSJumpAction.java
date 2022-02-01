package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.c))) {
      WeishiUtils.m(this.c);
    }
  }
  
  protected abstract boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject);
  
  public boolean b(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramMap);
    boolean bool = a(paramContext, paramMap, paramObject);
    a(bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.AbsWSJumpAction
 * JD-Core Version:    0.7.0.1
 */