package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public URLDrawable a;
  public BubbleImageView a;
  public MessageProgressView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public void a(View paramView)
  {
    if ((this.a != null) && (this.a.getStatus() == 1) && ((this.a.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      ((QQLiveDrawable)this.a.getCurrDrawable()).recyleAndKeepPostion();
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onMovedToScrapHeap(): recyleAndKeepPostion ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */