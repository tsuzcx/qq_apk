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
    if (this.this$0.al == null) {
      return;
    }
    if (this.this$0.am != null)
    {
      if (this.this$0.am.k() == null) {
        return;
      }
      Object localObject = SharedPreUtils.c(this.this$0.al.getCurrentAccountUin()).getString("AvWeakNet_video_ConfigContent", "");
      if (((String)localObject).length() == 0)
      {
        QLog.d(this.this$0.X, 1, "cannot Read AvWeaknetConfig");
        return;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("ground_glass_switch_android"))
        {
          if (((JSONObject)localObject).getInt("ground_glass_switch_android") == 1) {
            this.this$0.am.k().bR = true;
          }
          if (((JSONObject)localObject).has("ground_glass_default_interval")) {
            this.this$0.am.k().bT = ((JSONObject)localObject).getInt("ground_glass_default_interval");
          }
          if (((JSONObject)localObject).has("ground_glass_default_timeout_rule")) {
            this.this$0.am.k().bU = ((JSONObject)localObject).getInt("ground_glass_default_timeout_rule");
          }
          localObject = this.this$0.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AsyncReadDoubleGlassConfig mIsGlassCanUse=");
          localStringBuilder.append(this.this$0.am.k().bR);
          localStringBuilder.append(", mCurrentVideoGlassWaitTime=");
          localStringBuilder.append(this.this$0.am.k().bT);
          localStringBuilder.append(", mCurrentDefaultTimeOutRule=");
          localStringBuilder.append(this.this$0.am.k().bU);
          QLog.d((String)localObject, 1, localStringBuilder.toString());
          if ((this.this$0.am.k().bR) && (this.this$0.am.k().bT > 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.9
 * JD-Core Version:    0.7.0.1
 */