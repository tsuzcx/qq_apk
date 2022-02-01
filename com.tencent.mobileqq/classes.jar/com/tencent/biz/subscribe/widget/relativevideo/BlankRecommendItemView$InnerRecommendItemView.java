package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class BlankRecommendItemView$InnerRecommendItemView
{
  private int b;
  private View c;
  private RoundCornerImageView d;
  private TextView e;
  
  public BlankRecommendItemView$InnerRecommendItemView(BlankRecommendItemView paramBlankRecommendItemView, View paramView, int paramInt)
  {
    this.c = paramView;
    this.b = paramInt;
    this.d = ((RoundCornerImageView)this.c.findViewById(2131436373));
    this.e = ((TextView)this.c.findViewById(2131448448));
  }
  
  public void a()
  {
    this.d.setBackgroundColor(Color.parseColor("#252525"));
    this.d.invalidate();
    this.e.setTextColor(-5723992);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.c.setVisibility(0);
      int i = paramStFeed.cover.width.get();
      if (paramStFeed.cover.height.get() > i) {
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
      } else {
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      try
      {
        this.d.setImageURL(paramStFeed.cover.url.get());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData() set image url error! url: ");
        localStringBuilder.append(paramStFeed.cover.url.get());
        QLog.e("BlankRecommendItemView", 2, localStringBuilder.toString(), localThrowable);
      }
      if (paramStFeed.video.duration.get() > 0L)
      {
        i = paramStFeed.video.duration.get() / 1000 / 60;
        int j = paramStFeed.video.duration.get() / 1000;
        this.e.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
        this.e.setVisibility(0);
      }
      else
      {
        this.e.setVisibility(8);
      }
      this.c.setOnClickListener(new BlankRecommendItemView.InnerRecommendItemView.1(this, paramStFeed));
      return;
    }
    this.c.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.InnerRecommendItemView
 * JD-Core Version:    0.7.0.1
 */