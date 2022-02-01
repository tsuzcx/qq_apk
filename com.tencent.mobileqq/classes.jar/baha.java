import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class baha
  extends BroadcastReceiver
{
  baha(bagy parambagy) {}
  
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
        ((azww)bagy.b(this.a).a(112)).a(((azxr)bagy.k(this.a)).a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baha
 * JD-Core Version:    0.7.0.1
 */