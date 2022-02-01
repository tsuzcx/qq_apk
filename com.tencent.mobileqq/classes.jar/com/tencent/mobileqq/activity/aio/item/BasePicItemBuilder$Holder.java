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
  public ImageView a;
  public URLDrawable a;
  public BasePicItemBuilder.DrawURL a;
  public PicProgressView a;
  public BubbleImageView a;
  public boolean a;
  public View c;
  final int e = 0;
  final int f = 1;
  final int g = 2;
  final int h = 3;
  final int i = 4;
  final int j = 5;
  
  public BasePicItemBuilder$Holder(BasePicItemBuilder paramBasePicItemBuilder)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  int a(MessageForPic paramMessageForPic)
  {
    if (!paramMessageForPic.isSendFromLocal())
    {
      paramMessageForPic = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((paramMessageForPic != null) && (paramMessageForPic.getStatus() == 1)) {
        return 1;
      }
      return 0;
    }
    if (paramMessageForPic.size > 0L) {
      return 2;
    }
    paramMessageForPic = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.a.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
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
    BasePicItemBuilder.DrawURL localDrawURL = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL;
    if (localDrawURL != null) {
      return localDrawURL.b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */