package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.statistics.ReportController;

class GrayTipsItemBuilder$17
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$17(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    PermissionPrivacyFragment.a(this.a.c);
    ReportController.b(this.a.a, "dc00898", "", this.a.d.b, "0X800994C", "0X800994C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.17
 * JD-Core Version:    0.7.0.1
 */