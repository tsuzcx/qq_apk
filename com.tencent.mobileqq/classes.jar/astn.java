import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class astn
  implements BusinessObserver
{
  astn(aste paramaste) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        ((ascz)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label602;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyProfileDisplayPanel", 2, "retCode = [" + paramInt + "]");
        }
        if (paramInt == 0) {
          break label302;
        }
        paramBundle = paramBundle.optString("msg");
        if (!TextUtils.isEmpty(paramBundle))
        {
          bbmy.a(this.a.a, 1, "" + paramBundle, 1).a();
          return;
        }
        bbmy.a(this.a.a, 1, ajjy.a(2131641468), 1).a();
        return;
      }
      catch (Exception paramBundle)
      {
        bbmy.a(this.a.a, 1, ajjy.a(2131641571), 1).a();
        if (!QLog.isColorLevel()) {
          break label647;
        }
      }
      QLog.e("NearbyProfileDisplayPanel", 2, "未知异常，请稍后重试", paramBundle);
      return;
      label302:
      if (paramBundle.optInt("retcode") == 0)
      {
        paramBundle = this.a;
        if (aste.a(this.a)) {
          break label648;
        }
      }
    }
    label647:
    label648:
    for (paramBoolean = true;; paramBoolean = false)
    {
      aste.a(paramBundle, paramBoolean);
      localObject = this.a.a;
      if (aste.a(this.a)) {}
      for (paramBundle = ajjy.a(2131641577);; paramBundle = ajjy.a(2131641477))
      {
        bbmy.a((Context)localObject, 2, paramBundle, 1).a();
        ((askd)this.a.a.app.a(119)).notifyUI(1000, true, new Object[] { Boolean.valueOf(aste.a(this.a)), aste.a(this.a).uin });
        aste.a(this.a, 1, 60);
        if ((!aste.a(this.a)) && (aste.a(this.a).getChildAt(2).getVisibility() != 0))
        {
          paramBundle = (Button)aste.a(this.a).getChildAt(1).findViewById(2131312607);
          paramBundle.setTextColor(this.a.a.getResources().getColor(2131101290));
          paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130844604));
        }
        if (!aste.a(this.a)) {
          break;
        }
        paramBundle = (Button)aste.a(this.a).getChildAt(1).findViewById(2131312607);
        paramBundle.setTextColor(this.a.a.getResources().getColor(2131101292));
        paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130844605));
        return;
      }
      label602:
      bbmy.a(this.a.a, 1, ajjy.a(2131641462), 1).a();
      return;
      bbmy.a(this.a.a, 1, ajjy.a(2131641560), 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     astn
 * JD-Core Version:    0.7.0.1
 */