import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class anrw
  extends bhyn
{
  anrw(anrv paramanrv) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    parambhyo = parambhyo.a();
    if ((parambhyo.containsKey("version")) && (parambhyo.containsKey("json_name")))
    {
      int i = parambhyo.getInt("version", -1);
      parambhyo = parambhyo.getString("json_name");
      if (bhln.e.d.equals(parambhyo))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bhln.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = FileUtils.readFileContent((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bhln.a(this.a.a.getApplication().getApplicationContext(), parambhyo, i);
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update success!");
              }
              boolean bool1 = true;
              if (((JSONObject)localObject).has("enableX5Report"))
              {
                boolean bool2 = ((JSONObject)localObject).getBoolean("enableX5Report");
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.i("ClubContentUpdateHandler", 2, "json file got isEnableX5Report: " + bool2);
                  bool1 = bool2;
                }
              }
              parambhyo = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambhyo.edit().putBoolean("enableX5Report", bool1).commit();
              parambhyo.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              anrv.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambhyo)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambhyo.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrw
 * JD-Core Version:    0.7.0.1
 */