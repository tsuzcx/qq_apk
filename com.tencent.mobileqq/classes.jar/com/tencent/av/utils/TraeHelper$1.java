package com.tencent.av.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeAudioSessionApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class TraeHelper$1
  implements AdapterView.OnItemClickListener
{
  TraeHelper$1(TraeHelper paramTraeHelper, Button paramButton, long paramLong, ActionSheet paramActionSheet) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (TraeHelper.a(this.d) != null)
    {
      paramAdapterView = (TraeHelper.SoundOutputRes.IconAndName)TraeHelper.a(this.d).getItem(paramInt);
      if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.a)) && (this.d.b != null))
      {
        if ("DEVICE_BLUETOOTH_HEADSET".equals(paramAdapterView.a))
        {
          TipsUtil.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
          paramView = this.a;
          if (paramView != null) {
            paramView.setClickable(false);
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Trae_DRP 0X8008D20 at: ");
            paramView.append(System.currentTimeMillis());
            QLog.d("TraeSessionHelper", 2, paramView.toString());
          }
          ReportController.b(null, "CliOper", "", "", "0X8008D20", "0X8008D20", 0, 0, "", "", "", "");
        }
        else if ("DEVICE_SPEAKERPHONE".equals(paramAdapterView.a))
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Trae_DRP 0X8008D1F at: ");
            paramView.append(System.currentTimeMillis());
            QLog.d("TraeSessionHelper", 2, paramView.toString());
          }
          ReportController.b(null, "CliOper", "", "", "0X8008D1F", "0X8008D1F", 0, 0, "", "", "", "");
        }
        else if ("DEVICE_EARPHONE".equals(paramAdapterView.a))
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Trae_DRP 0X8008D21-1 at: ");
            paramView.append(System.currentTimeMillis());
            QLog.d("TraeSessionHelper", 2, paramView.toString());
          }
          ReportController.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 1, 0, "", "", "", "");
        }
        else if ("DEVICE_WIRED_HEADSET".equals(paramAdapterView.a))
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Trae_DRP 0X8008D21-2 at: ");
            paramView.append(System.currentTimeMillis());
            QLog.d("TraeSessionHelper", 2, paramView.toString());
          }
          ReportController.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 2, 0, "", "", "", "");
        }
        TraeHelper.a(this.d, true);
        this.d.b.connectDevice(this.b, paramAdapterView.a);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.1
 * JD-Core Version:    0.7.0.1
 */