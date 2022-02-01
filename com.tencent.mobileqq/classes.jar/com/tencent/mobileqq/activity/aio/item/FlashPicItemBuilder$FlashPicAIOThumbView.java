package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BubbleImageView;

public class FlashPicItemBuilder$FlashPicAIOThumbView
  extends BubbleImageView
{
  boolean a;
  
  public FlashPicItemBuilder$FlashPicAIOThumbView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    ThreadManager.postImmediately(new FlashPicItemBuilder.FlashPicAIOThumbView.1(this), null, true);
  }
  
  void setCommonFlashPic(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView
 * JD-Core Version:    0.7.0.1
 */