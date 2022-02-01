package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppBrandActionMultipleHeaderView
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private int c;
  private String d;
  private String e;
  private String f;
  
  public AppBrandActionMultipleHeaderView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public AppBrandActionMultipleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131624242, this);
    this.a = ((ImageView)findViewById(2131428650));
    this.b = ((TextView)findViewById(2131428651));
  }
  
  public String getH5Url()
  {
    return this.d;
  }
  
  public ImageView getImageView()
  {
    return this.a;
  }
  
  public String getPath()
  {
    return this.f;
  }
  
  public int getType()
  {
    return this.c;
  }
  
  public String getUsername()
  {
    return this.e;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }
  
  public void setTextViewText(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionMultipleHeaderView
 * JD-Core Version:    0.7.0.1
 */