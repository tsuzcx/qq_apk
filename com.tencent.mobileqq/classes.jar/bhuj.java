import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class bhuj
  extends BroadcastReceiver
{
  bhuj(bhui parambhui) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("intent is: ");
      if (paramIntent == null)
      {
        paramContext = "null";
        QLog.d("QZonePersonalizePlugin", 4, paramContext);
      }
    }
    else
    {
      if ((paramIntent == null) || (!"QZoneCardPreDownload".equals(paramIntent.getAction()))) {
        break label239;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, "QZoneCardPreDownload js receive setting action" + paramIntent.getAction());
      }
      localObject = paramIntent.getExtras();
      paramIntent = "";
      paramContext = "";
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getString("result");
        paramContext = ((Bundle)localObject).getString("cardurl");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, "QZoneCardPreDownload js receive cardurl:" + paramContext + "\n dowonload result:" + paramIntent);
      }
      if (this.a.mRuntime != null) {
        break label182;
      }
    }
    label182:
    label239:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramContext = "not null";
              break;
            } while (this.a.mRuntime.a() == null);
            paramIntent = this.a.mRuntime.a();
          } while (paramIntent == null);
          paramIntent.callJs("window.QzFeedDressJSInterface.onReceive({type:\"cardurl\",data:\"" + paramContext + "\"});window.QzFeedDressJSInterface.onReceive({type:\"result\",data:\"success\"});");
          return;
        } while ((paramIntent == null) || (!"action_facade_qzone2js".equals(paramIntent.getAction())));
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      i = paramIntent.getInt("ret");
      paramContext = paramIntent.getString("imgDir");
      paramIntent = paramIntent.getString("imgNameList");
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePersonalizePlugin", 4, "receive ret:" + i + "|imgDir:" + paramContext + "|imgNameList:" + paramIntent);
      }
    } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null));
    if (i == 0)
    {
      this.a.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"success\",imgDir:\"" + paramContext + "\",imgNameList:\"" + paramIntent + "\"});");
      return;
    }
    this.a.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"fail\"});");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuj
 * JD-Core Version:    0.7.0.1
 */