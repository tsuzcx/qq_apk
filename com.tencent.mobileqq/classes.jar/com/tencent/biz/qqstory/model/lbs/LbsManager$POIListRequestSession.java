package com.tencent.biz.qqstory.model.lbs;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

public class LbsManager$POIListRequestSession
{
  final int a;
  boolean b = true;
  boolean c = true;
  String d = "";
  String e = "";
  HashSet<String> f = new HashSet();
  public final Bundle g = new Bundle();
  
  public LbsManager$POIListRequestSession(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static POIListRequestSession b()
  {
    return new POIListRequestSession(20);
  }
  
  public void a()
  {
    this.d = "";
    this.f.clear();
    this.c = true;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.e))
    {
      this.e = paramString;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession
 * JD-Core Version:    0.7.0.1
 */