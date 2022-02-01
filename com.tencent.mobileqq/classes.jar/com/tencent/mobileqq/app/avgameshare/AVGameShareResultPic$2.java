package com.tencent.mobileqq.app.avgameshare;

import android.graphics.Bitmap;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareResultPic$2
  implements Runnable
{
  AVGameShareResultPic$2(AVGameShareResultPic paramAVGameShareResultPic, Map paramMap, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    Object localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str = AVGameShareResultPic.a(this.this$0);
    int i;
    if (this.jdField_a_of_type_Int == 9)
    {
      i = 0;
      localWXShareHelper.a(str, (Bitmap)localObject, i, false, this.this$0.jdField_a_of_type_JavaLangString);
      QLog.d("AVGameShareResultPic", 1, "shareToWeChat success");
      if (this.jdField_a_of_type_Int != 9) {
        break label211;
      }
      localObject = "3";
      label121:
      ReportController.b(null, "dc00898", "", "", "0X800B064", "0X800B064", 0, 0, (String)localObject, "", "", "");
      if (GameEngine.a().f())
      {
        if (!GameEngine.a().a().a.gameSur) {
          break label217;
        }
        i = 1;
        label170:
        if (this.jdField_a_of_type_Int != 9) {
          break label222;
        }
      }
    }
    label211:
    label217:
    label222:
    for (localObject = "3";; localObject = "4")
    {
      ReportController.b(null, "dc00898", "", "", "0X800B794", "0X800B794", i, 0, (String)localObject, "", "", "");
      return;
      i = 1;
      break;
      localObject = "4";
      break label121;
      i = 2;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic.2
 * JD-Core Version:    0.7.0.1
 */