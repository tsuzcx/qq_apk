import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class anvb
  extends biht
{
  anvb(anva paramanva) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    parambihu = parambihu.a();
    if ((parambihu.containsKey("version")) && (parambihu.containsKey("json_name")))
    {
      int i = parambihu.getInt("version", -1);
      parambihu = parambihu.getString("json_name");
      if (bhwl.e.d.equals(parambihu))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bhwl.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bhmi.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bhwl.a(this.a.a.getApplication().getApplicationContext(), parambihu, i);
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
              parambihu = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambihu.edit().putBoolean("enableX5Report", bool1).commit();
              parambihu.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              anva.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambihu)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambihu.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvb
 * JD-Core Version:    0.7.0.1
 */