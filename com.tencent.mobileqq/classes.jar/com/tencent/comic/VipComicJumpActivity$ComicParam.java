package com.tencent.comic;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

public class VipComicJumpActivity$ComicParam
{
  String A = "";
  boolean B = false;
  String C = "";
  Bundle D;
  VipComicJumpActivity.PageOpenTraceInfo E;
  public long a = 0L;
  long b = 0L;
  public int c = 0;
  String d = "";
  String e = "";
  String f = null;
  String g = null;
  String h = "com.qqcomic.activity.VipComicMainTabActivity";
  String i = "";
  VipComicJumpActivity.ComicInfo j = null;
  String k = null;
  String l = null;
  String m = null;
  boolean n = false;
  boolean o;
  boolean p = false;
  boolean q = false;
  boolean r = true;
  boolean s = false;
  Intent t = new Intent();
  boolean u = false;
  HashMap<String, Boolean> v = new HashMap();
  boolean w = false;
  String x = "";
  String y = "";
  String z = "";
  
  void a(String paramString, boolean paramBoolean)
  {
    this.v.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  boolean a(String paramString)
  {
    return (this.v.get(paramString) != null) && (((Boolean)this.v.get(paramString)).booleanValue());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicParam{clickTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sourceFrom=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", extUrlParam='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpConponentName='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpurl='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comicInfo=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", jumpMainTab='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpSubTab='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftViewText='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", returnDetail=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", returnToHome=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", returnHomeFromDetail=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", isPlayerLocked=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", needClearTop=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", isFullscreen=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", mIntent=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", mNeedLaunchPlugin=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", mIsTabRedMap=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", mIsNewFlag=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", mRedDotMissionIds='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsJumpActPage=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", mJumpActUrl='");
    localStringBuilder.append(this.C);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.ComicParam
 * JD-Core Version:    0.7.0.1
 */