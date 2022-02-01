package com.tencent.biz.qqcircle.bizparts;

import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView;
import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.IphonePickListener;
import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class QCirclePrivateMessageSettingContentPart$3
  implements IphonePickerView.IphonePickListener
{
  QCirclePrivateMessageSettingContentPart$3(QCirclePrivateMessageSettingContentPart paramQCirclePrivateMessageSettingContentPart, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void a()
  {
    ActionSheet localActionSheet = this.b;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.b.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.a(0);
    QCirclePrivateMessageSettingContentPart.b(this.c).setText(QCirclePrivateMessageSettingContentPart.a(this.c).a(0, paramInt1));
    if (QCirclePrivateMessageSettingContentPart.c(this.c) == null) {
      QCirclePrivateMessageSettingContentPart.a(this.c, new QQCirclePrivateMsgShow.StPMSettingData());
    }
    QCirclePrivateMessageSettingContentPart.c(this.c).fuelCost.set(Integer.parseInt(QCirclePrivateMessageSettingContentPart.a(this.c).a(0, paramInt1)));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fuelUseNumSelect() setSelection  row : ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" , fuelCost : ");
    localStringBuilder.append(QCirclePrivateMessageSettingContentPart.c(this.c).fuelCost.get());
    QLog.i("QCirclePrivateMessageSettingContentPart", 1, localStringBuilder.toString());
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(String.valueOf(QCircleCommonUtil.getCurrentAccountLongUin())).setActionType(11).setSubActionType(39).setThrActionType(2).setExt1(QCirclePrivateMessageSettingContentPart.a(this.c).a(0, paramInt1)).setPageId(this.c.f()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart.3
 * JD-Core Version:    0.7.0.1
 */