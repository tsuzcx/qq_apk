package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ReadInJoyVideoAdHighLightBar
  extends FrameLayout
{
  private View a;
  private TextView b;
  
  public ReadInJoyVideoAdHighLightBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyVideoAdHighLightBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyVideoAdHighLightBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131626107, this);
    this.b = ((TextView)this.a.findViewById(2131435043));
  }
  
  public void setText(String paramString)
  {
    if (this.b != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.b.setText(paramString);
        return;
      }
      this.b.setText("查看详情");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar
 * JD-Core Version:    0.7.0.1
 */