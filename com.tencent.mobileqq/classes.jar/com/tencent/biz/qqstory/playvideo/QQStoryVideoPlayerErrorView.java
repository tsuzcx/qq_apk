package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;

public class QQStoryVideoPlayerErrorView
  extends RelativeLayout
{
  protected ImageView a;
  protected TextView a;
  
  public QQStoryVideoPlayerErrorView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQStoryVideoPlayerErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      setTipsText(StoryApi.a(2131432082));
      setTipsIcon(2130843288);
      setTipsTextSize(16.0F);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        setTipsText("加载失败，点击重试");
        setTipsIcon(2130843396);
        setTipsTextSize(14.0F);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130970844, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362710));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131363197));
  }
  
  public void setCloseViewVisibility(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTipsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
  }
  
  public void setTipsText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTipsTextSize(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView
 * JD-Core Version:    0.7.0.1
 */