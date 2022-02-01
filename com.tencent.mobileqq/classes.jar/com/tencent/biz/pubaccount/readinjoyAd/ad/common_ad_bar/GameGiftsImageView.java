package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class GameGiftsImageView
  extends FrameLayout
{
  private FrameLayout a;
  private FrameLayout b;
  private FrameLayout c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  
  public GameGiftsImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131626257, this);
    this.d = ((ImageView)localView.findViewById(2131435224));
    this.e = ((ImageView)localView.findViewById(2131435225));
    this.f = ((ImageView)localView.findViewById(2131435226));
    this.a = ((FrameLayout)localView.findViewById(2131431281));
    this.b = ((FrameLayout)localView.findViewById(2131431284));
    this.c = ((FrameLayout)localView.findViewById(2131431287));
  }
  
  private void a(ViewGroup paramViewGroup, ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramViewGroup.setVisibility(0);
    ReadInJoyCommonSoftAdUtils.a(paramImageView.getContext(), paramImageView, paramString, 0, AIOUtils.b(16.0F, getResources()), -1);
  }
  
  public void setImages(ArrayList<String> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (i == 0) {
        a(this.a, this.d, str);
      } else if (i == 1) {
        a(this.b, this.e, str);
      } else if (i == 2) {
        a(this.c, this.f, str);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.GameGiftsImageView
 * JD-Core Version:    0.7.0.1
 */