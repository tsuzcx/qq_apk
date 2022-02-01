package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.widget.BubbleImageView;

public class BasePicItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public BubbleImageView a;
  public PicProgressView b;
  public URLDrawable c;
  public ImageView d;
  public BasePicItemBuilder.DrawURL e;
  public View f;
  public boolean g = false;
  final int s = 0;
  final int t = 1;
  final int u = 2;
  final int v = 3;
  final int w = 4;
  final int x = 5;
  
  public BasePicItemBuilder$Holder(BasePicItemBuilder paramBasePicItemBuilder) {}
  
  int a(MessageForPic paramMessageForPic)
  {
    if (!paramMessageForPic.isSendFromLocal())
    {
      paramMessageForPic = this.c;
      if ((paramMessageForPic != null) && (paramMessageForPic.getStatus() == 1)) {
        return 1;
      }
      return 0;
    }
    if (paramMessageForPic.size > 0L) {
      return 2;
    }
    paramMessageForPic = ((ITransFileController)this.y.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    if ((paramMessageForPic instanceof BaseTransProcessor))
    {
      paramMessageForPic = (BaseTransProcessor)paramMessageForPic;
      long l = paramMessageForPic.getFileStatus();
      if ((l != 1005L) && (l != 1006L) && (l != 1004L) && (paramMessageForPic.getLastFileStatus() != 1003L)) {
        return 3;
      }
      return 4;
    }
    return 5;
  }
  
  public boolean a()
  {
    BasePicItemBuilder.DrawURL localDrawURL = this.e;
    if (localDrawURL != null) {
      return localDrawURL.c;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */