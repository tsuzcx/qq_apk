package com.tencent.av.ui;

import android.content.SharedPreferences;
import bbjn;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lgf;
import org.json.JSONException;
import org.json.JSONObject;

class DoubleVideoCtrlUI$6
  implements Runnable
{
  DoubleVideoCtrlUI$6(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        Object localObject = bbjn.c(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).getString("AvWeakNet_video_ConfigContent", "");
        if (((String)localObject).length() == 0)
        {
          QLog.d(this.this$0.c, 1, "cannot Read AvWeaknetConfig");
          return;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("ground_glass_switch_android"))
          {
            if (((JSONObject)localObject).getInt("ground_glass_switch_android") == 1) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aw = true;
            }
            if (((JSONObject)localObject).has("ground_glass_default_interval")) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R = ((JSONObject)localObject).getInt("ground_glass_default_interval");
            }
            if (((JSONObject)localObject).has("ground_glass_default_timeout_rule")) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S = ((JSONObject)localObject).getInt("ground_glass_default_timeout_rule");
            }
            QLog.d(this.this$0.c, 1, "AsyncReadDoubleGlassConfig mIsGlassCanUse=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aw + ", mCurrentVideoGlassWaitTime=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R + ", mCurrentDefaultTimeOutRule=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S);
            if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aw) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R > 0))
            {
              DoubleVideoCtrlUI.a(this.this$0, true);
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.6
 * JD-Core Version:    0.7.0.1
 */