package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoItemBuilder$1
  implements View.OnClickListener
{
  VideoItemBuilder$1(VideoItemBuilder paramVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((VideoItemBuilder.a(this.a)) && (VcSystemInfo.isSupportSharpAudio()))
    {
      Object localObject = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
      if (localObject != null)
      {
        localObject = (MessageForVideo)((ChatItemBuilder.BaseHolder)localObject).a;
        VideoItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (MessageForVideo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (((MessageForVideo)localObject).istroop == 1044) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD93", "0X800AD93", 0, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */