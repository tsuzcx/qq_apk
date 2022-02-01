package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oi.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public abstract interface w
  extends c
{
  @Nullable
  public abstract View a(@NonNull LayoutInflater paramLayoutInflater);
  
  public abstract RelativeLayout.LayoutParams a(@NonNull View paramView1, @Nullable View paramView2);
  
  @Nullable
  public abstract <T> T a(Class<T> paramClass);
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(@NonNull b paramb);
  
  public abstract void a(@NonNull Map<String, Object> paramMap, bg parambg);
  
  public abstract boolean a(String paramString);
  
  public abstract void b(@NonNull View paramView);
  
  @NonNull
  public abstract aq c();
  
  @NonNull
  public abstract ab d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract boolean i();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */