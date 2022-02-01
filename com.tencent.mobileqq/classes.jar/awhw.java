import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class awhw
  implements aasd
{
  awhw(awhv paramawhv, long paramLong1, long paramLong2, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = paramBundle.getString("videoPath");
    Object localObject;
    if (!TextUtils.isEmpty(paramBundle))
    {
      localObject = new File(paramBundle);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "previewRewardVideo: videoPath=" + paramBundle + ", " + bool);
      }
      try
      {
        localObject = new JSONObject();
        if (bool)
        {
          MediaApiPlugin.a(this.jdField_a_of_type_Awhv.mRuntime.a(), paramBundle, this.jdField_a_of_type_Long, this.b);
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("errMsg", "");
        }
        for (;;)
        {
          this.jdField_a_of_type_Awhv.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
          return;
          ((JSONObject)localObject).put("ret", -2);
          ((JSONObject)localObject).put("errMsg", anzj.a(2131713969));
        }
        QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramBundle);
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhw
 * JD-Core Version:    0.7.0.1
 */