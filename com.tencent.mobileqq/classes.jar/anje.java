import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class anje
  extends bhhe
{
  anje(anjd paramanjd) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    parambhhf = parambhhf.a();
    if ((parambhhf.containsKey("version")) && (parambhhf.containsKey("json_name")))
    {
      int i = parambhhf.getInt("version", -1);
      parambhhf = parambhhf.getString("json_name");
      if (bgwh.e.d.equals(parambhhf))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bgwh.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bgmg.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bgwh.a(this.a.a.getApplication().getApplicationContext(), parambhhf, i);
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
              parambhhf = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambhhf.edit().putBoolean("enableX5Report", bool1).commit();
              parambhhf.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              anjd.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambhhf)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambhhf.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anje
 * JD-Core Version:    0.7.0.1
 */