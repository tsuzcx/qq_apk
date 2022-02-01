package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class PlaceholderSegment
  extends SegmentView
{
  public static final String KEY = "PlaceholderSegment";
  private boolean a = false;
  private boolean b = false;
  private String c = null;
  private int d = 0;
  private int e = 0;
  private BaseViewHolder f;
  private String g;
  
  public PlaceholderSegment(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.m = false;
    this.g = paramString1;
    this.c = paramString2;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131442730);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131442731);
    if (TextUtils.isEmpty(this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905978));
      localStringBuilder.append(QQStoryConstant.a);
      localStringBuilder.append("\n拍摄一段小视频，分享眼前的世界");
      paramViewGroup.setText(localStringBuilder.toString());
    }
    else
    {
      paramViewGroup.setText(this.c);
    }
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null)) {
      localImageView.setImageResource(this.e);
    } else {
      localImageView.setImageResource(this.d);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.f = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628033, paramViewGroup, false));
    return this.f;
  }
  
  public String b()
  {
    return "PlaceholderSegment";
  }
  
  public void br_()
  {
    d();
  }
  
  protected void d()
  {
    SegmentView localSegmentView = w().b(this.g);
    if ((localSegmentView != null) && (localSegmentView.a() != 0))
    {
      c(false);
      return;
    }
    c(true);
  }
  
  protected void g()
  {
    d();
  }
  
  public void i()
  {
    super.i();
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (ImageView)((BaseViewHolder)localObject).a(2131442731);
    if (localObject == null) {
      return;
    }
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null))
    {
      ((ImageView)localObject).setImageResource(this.e);
      return;
    }
    ((ImageView)localObject).setImageResource(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment
 * JD-Core Version:    0.7.0.1
 */