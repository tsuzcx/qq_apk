package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalPageOpenParams
{
  private final String a;
  private final String b;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private int h;
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private stCollection m;
  private Bundle n;
  private boolean o;
  private boolean p = false;
  private int q;
  private String r;
  private String s;
  private View t;
  private int u;
  private WSAutoShowCommentParams v;
  private List<stSimpleMetaFeed> w;
  private Context x;
  
  public WSVerticalPageOpenParams(Context paramContext, String paramString1, String paramString2)
  {
    this.x = paramContext;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public WSVerticalPageOpenParams(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public WSVerticalPageOpenParams a(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams a(Context paramContext)
  {
    this.x = paramContext;
    return this;
  }
  
  public WSVerticalPageOpenParams a(Bundle paramBundle)
  {
    this.n = paramBundle;
    return this;
  }
  
  public WSVerticalPageOpenParams a(View paramView)
  {
    this.t = paramView;
    return this;
  }
  
  public WSVerticalPageOpenParams a(@Nullable WSAutoShowCommentParams paramWSAutoShowCommentParams)
  {
    this.v = paramWSAutoShowCommentParams;
    return this;
  }
  
  public WSVerticalPageOpenParams a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams a(List<stSimpleMetaFeed> paramList)
  {
    this.w = paramList;
    return this;
  }
  
  public WSVerticalPageOpenParams a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public WSVerticalPageOpenParams b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams b(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Context c()
  {
    return this.x;
  }
  
  public WSVerticalPageOpenParams c(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams c(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public WSVerticalPageOpenParams d(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams d(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public WSVerticalPageOpenParams e(int paramInt)
  {
    this.u = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public WSVerticalPageOpenParams f(String paramString)
  {
    this.r = paramString;
    return this;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public WSVerticalPageOpenParams g(String paramString)
  {
    this.s = paramString;
    return this;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public int j()
  {
    return this.i;
  }
  
  public int k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.k;
  }
  
  public List<stSimpleMetaFeed> m()
  {
    return this.w;
  }
  
  public stCollection n()
  {
    return this.m;
  }
  
  public boolean o()
  {
    return this.l;
  }
  
  public Bundle p()
  {
    return this.n;
  }
  
  public boolean q()
  {
    return this.o;
  }
  
  public boolean r()
  {
    return this.p;
  }
  
  public int s()
  {
    return this.q;
  }
  
  public String t()
  {
    return this.r;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalPageOpenParams{from='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playScene='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTabId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needScrollToPosition=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", clearTop=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", isNeedCalcDeltaTime=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", collection=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", collectionId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", feeds=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", context=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", extBundle=");
    localStringBuilder.append(this.n);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String u()
  {
    return this.s;
  }
  
  public Intent v()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", a());
    localBundle.putString("key_play_scene", b());
    localBundle.putString("key_sub_tab_id", d());
    localBundle.putString("key_fall_list_feed_id", e());
    localBundle.putString("key_page_session", f());
    localBundle.putString("key_collection_id", g());
    localBundle.putString("key_feed_id", h());
    List localList = m();
    if ((localList != null) && (localList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(localList));
    }
    localBundle.putInt("key_feed_position", i());
    localBundle.putInt("key_fall_list_index", k());
    localBundle.putLong("key_start_time", SystemClock.uptimeMillis());
    localBundle.putBoolean("key_cal_delta_time", o());
    localBundle.putSerializable("key_collection", n());
    localBundle.putSerializable("auto_show_panel", Boolean.valueOf(r()));
    if (p() != null) {
      localBundle.putAll(p());
    }
    localBundle.putBoolean("key_is_show_open_ws_dialog", q());
    localBundle.putInt("page_type", s());
    localBundle.putString("person_id", t());
    localBundle.putString("share_data_key", u());
    localBundle.putSerializable("auto_show_comment_params", y());
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public View w()
  {
    return this.t;
  }
  
  public int x()
  {
    return this.u;
  }
  
  public WSAutoShowCommentParams y()
  {
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams
 * JD-Core Version:    0.7.0.1
 */