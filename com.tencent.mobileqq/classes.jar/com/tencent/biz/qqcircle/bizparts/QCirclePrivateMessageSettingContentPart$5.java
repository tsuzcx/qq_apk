package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;

class QCirclePrivateMessageSettingContentPart$5
  implements IphonePickerView.PickerViewAdapter
{
  QCirclePrivateMessageSettingContentPart$5(QCirclePrivateMessageSettingContentPart paramQCirclePrivateMessageSettingContentPart) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (QCirclePrivateMessageSettingContentPart.d(this.a) != null) {
      return QCirclePrivateMessageSettingContentPart.d(this.a).max.get() - QCirclePrivateMessageSettingContentPart.d(this.a).min.get() + 1;
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (QCirclePrivateMessageSettingContentPart.d(this.a) == null) {
      return "";
    }
    return String.valueOf(QCirclePrivateMessageSettingContentPart.d(this.a).min.get() + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart.5
 * JD-Core Version:    0.7.0.1
 */