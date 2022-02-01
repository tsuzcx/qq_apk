import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class babm
  extends BroadcastReceiver
{
  babm(babk parambabk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getBundleExtra("key_bundle_data");
    if (paramContext != null)
    {
      boolean bool = paramContext.getBoolean("onTagChanged");
      if (QLog.isColorLevel()) {
        QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onReceive addTag=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool) {
        ((azqg)babk.b(this.a).getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(((azrb)babk.k(this.a)).a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babm
 * JD-Core Version:    0.7.0.1
 */