package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.qroute.QRoute;

class GrayTipsItemBuilder$7
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$7(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = ((IFMConfig)QRoute.api(IFMConfig.class)).timGuideUrl();
    FileManagerUtil.c(this.a.c, paramView);
    FileManagerReporter.a("0X8007FA2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */