package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCircleFeedBase.StTabInfo;

class QCircleTopAuthPart$2
  implements ActionSheet.OnButtonClickListener
{
  QCircleTopAuthPart$2(QCircleTopAuthPart paramQCircleTopAuthPart, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showEnterAuthActionSheetClick"))
    {
      if (paramInt != 0)
      {
        if ((paramInt == 1) && (QCircleTopAuthPart.a(this.b) != null)) {
          QCircleLauncher.a(this.b.g(), QCircleJsUrlConfig.a(QCircleTopAuthPart.a(this.b).a.urlInfo.get(), "authCampanyUrl"), null, -1);
        }
      }
      else if (QCircleTopAuthPart.a(this.b) != null) {
        QCircleLauncher.a(this.b.g(), QCircleJsUrlConfig.a(QCircleTopAuthPart.a(this.b).a.urlInfo.get(), "authSchoolUrl"), null, -1);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart.2
 * JD-Core Version:    0.7.0.1
 */