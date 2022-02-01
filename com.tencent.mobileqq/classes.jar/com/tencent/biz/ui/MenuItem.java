package com.tencent.biz.ui;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

public class MenuItem
{
  String a;
  String b;
  String c;
  String d;
  private Drawable e;
  private String f;
  private String g;
  private int h;
  private List<MenuItem> i = null;
  
  public MenuItem(String paramString1, String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.e = paramDrawable;
    this.f = paramString2;
    this.g = paramString1;
    this.h = paramInt;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public MenuItem a(int paramInt)
  {
    List localList = this.i;
    if (localList == null) {
      return null;
    }
    return (MenuItem)localList.get(paramInt);
  }
  
  public void a(MenuItem paramMenuItem)
  {
    if (paramMenuItem == null) {
      return;
    }
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramMenuItem);
  }
  
  public void a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo.logo_url.has()) {
      this.a = paramButtonInfo.logo_url.get();
    }
    if (paramButtonInfo.texture_url.has()) {
      this.d = paramButtonInfo.texture_url.get();
    }
    if (paramButtonInfo.bg_colors.has())
    {
      paramButtonInfo = paramButtonInfo.bg_colors.get().split("\\|");
      if (paramButtonInfo.length > 0) {
        this.b = paramButtonInfo[0];
      }
      if (paramButtonInfo.length > 1) {
        this.c = paramButtonInfo[1];
      }
    }
  }
  
  public String b()
  {
    return this.a;
  }
  
  public Drawable c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.i != null;
  }
  
  public int g()
  {
    List localList = this.i;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public List<MenuItem> h()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.MenuItem
 * JD-Core Version:    0.7.0.1
 */