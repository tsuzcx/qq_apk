import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class avig
  implements BusinessObserver
{
  avig(avhw paramavhw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayTribePanel", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        ((auqc)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label544;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyProfileDisplayTribePanel", 2, "retCode = [" + paramInt + "]");
        }
        if (paramInt == 0) {
          break label302;
        }
        paramBundle = paramBundle.optString("msg");
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.a.a, 1, "" + paramBundle, 1).a();
          return;
        }
        QQToast.a(this.a.a, 1, alpo.a(2131707752), 1).a();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this.a.a, 1, alpo.a(2131707688), 1).a();
        if (!QLog.isColorLevel()) {
          break label587;
        }
      }
      QLog.e("NearbyProfileDisplayTribePanel", 2, "未知异常，请稍后重试", paramBundle);
      return;
      label302:
      if (paramBundle.optInt("retcode") == 0)
      {
        paramBundle = this.a;
        if (avhw.a(this.a)) {
          break label588;
        }
      }
    }
    label544:
    label587:
    label588:
    for (paramBoolean = true;; paramBoolean = false)
    {
      avhw.a(paramBundle, paramBoolean);
      localObject = this.a.a;
      if (avhw.a(this.a)) {}
      for (paramBundle = alpo.a(2131707717);; paramBundle = alpo.a(2131707675))
      {
        QQToast.a((Context)localObject, 2, paramBundle, 1).a();
        avhw.a(this.a, 1, 60);
        if ((!avhw.a(this.a)) && (avhw.a(this.a).getChildAt(2).getVisibility() != 0))
        {
          paramBundle = (Button)avhw.a(this.a).getChildAt(1).findViewById(2131379049);
          paramBundle.setTextColor(this.a.a.getResources().getColor(2131166932));
          paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839107));
        }
        if (!avhw.a(this.a)) {
          break;
        }
        paramBundle = (Button)avhw.a(this.a).getChildAt(1).findViewById(2131379049);
        paramBundle.setTextColor(this.a.a.getResources().getColor(2131166934));
        paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839146));
        return;
      }
      QQToast.a(this.a.a, 1, alpo.a(2131707684), 1).a();
      return;
      QQToast.a(this.a.a, 1, alpo.a(2131707690), 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avig
 * JD-Core Version:    0.7.0.1
 */