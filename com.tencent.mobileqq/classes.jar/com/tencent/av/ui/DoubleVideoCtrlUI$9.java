package com.tencent.av.ui;

import android.content.SharedPreferences;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class DoubleVideoCtrlUI$9
  implements Runnable
{
  DoubleVideoCtrlUI$9(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        Object localObject = SharedPreUtils.c(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).getString("AvWeakNet_video_ConfigContent", "");
        if (((String)localObject).length() == 0)
        {
          QLog.d(this.this$0.d, 1, "cannot Read AvWeaknetConfig");
          return;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("ground_glass_switch_android"))
          {
            if (((JSONObject)localObject).getInt("ground_glass_switch_android") == 1) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aA = true;
            }
            if (((JSONObject)localObject).has("ground_glass_default_interval")) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S = ((JSONObject)localObject).getInt("ground_glass_default_interval");
            }
            if (((JSONObject)localObject).has("ground_glass_default_timeout_rule")) {
              this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().T = ((JSONObject)localObject).getInt("ground_glass_default_timeout_rule");
            }
            QLog.d(this.this$0.d, 1, "AsyncReadDoubleGlassConfig mIsGlassCanUse=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aA + ", mCurrentVideoGlassWaitTime=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S + ", mCurrentDefaultTimeOutRule=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().T);
            if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aA) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().S > 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.9
 * JD-Core Version:    0.7.0.1
 */