package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class StoryMsgNodeFrameLayout
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  public int a;
  public ImageView a;
  public TextView a;
  public RoundBorderImageView a;
  public int b;
  public ImageView b;
  public int c;
  public int d;
  @StoryMsgNodeFrameLayout.DisplayState
  public int e = -1;
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a()
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof AnimationDrawable))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (AnimationDrawable)localObject;
      if (!((AnimationDrawable)localObject).isRunning()) {
        ((AnimationDrawable)localObject).start();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setSegmentCount(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void a(Context paramContext)
  {
    inflate(paramContext, 2130971759, this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView = ((RoundBorderImageView)findViewById(2131375529));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375530));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375531));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375532));
    setDisplayState(0);
  }
  
  public void b()
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable instanceof AnimationDrawable))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadCanceled!");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadSuccessed!");
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof GifDrawable))
    {
      SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation reset drawable!");
      AbstractGifImage.resumeAll();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((GifDrawable)paramURLDrawable);
    }
  }
  
  public void setDisplayState(@StoryMsgNodeFrameLayout.DisplayState int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setSegmentColor(this.c, this.d);
      return;
      this.c = -12732161;
      this.d = -1644826;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.b(true);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      this.c = -103316;
      this.d = -1644826;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setBadgeIcon(2130843646, true);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.b(false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      this.c = -12732161;
      this.d = -1644826;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setBadgeIcon(2130843648, 1);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.b(true);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      this.c = -12732161;
      this.d = -1644826;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130843649);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(1.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.b(false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843649);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843647);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void setNodeName(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130843650), null);
    }
    for (;;)
    {
      int i = getContext().getResources().getColor(2131494225);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout
 * JD-Core Version:    0.7.0.1
 */