package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.util.concurrent.CopyOnWriteArraySet;

public class ShortVideoRealItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public ImageView a;
  public TextView a;
  public CropBubbleVideoView a;
  public MessageProgressView a;
  public ImageView b;
  public int e;
  
  public ShortVideoRealItemBuilder$Holder(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (localObject != null)
    {
      long l = ((CropBubbleVideoView)localObject).getCurPlayingPos();
      if (l > 0L)
      {
        localObject = AIOSingleReporter.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getId()));
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a((MessageForShortVideo)localObject, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.releasePlayer(true);
      ShortVideoRealItemBuilder.a.remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */