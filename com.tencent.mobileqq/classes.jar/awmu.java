import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

class awmu
  extends BroadcastReceiver
{
  awmu(awmt paramawmt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = this.a.mRuntime.a();
    } while ((paramContext == null) || (paramContext.isFinishing()));
    paramIntent = this.a.mRuntime.a(this.a.mRuntime.a());
    if ((paramIntent != null) && ((paramIntent instanceof behk)))
    {
      paramIntent = ((behk)paramIntent).b();
      if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("entryId"))) {
        break label232;
      }
    }
    label232:
    for (this.a.a = bhos.a(bhos.a(paramIntent), "entryId", 2);; this.a.a = 2)
    {
      paramContext.finish();
      paramContext = new Intent(this.a.mRuntime.a(), FriendProfileCardActivity.class);
      paramIntent = new ProfileActivity.AllInOne(this.a.mRuntime.a().getCurrentAccountUin(), 0);
      if (this.a.a == 0) {
        paramContext.setFlags(67108864);
      }
      paramContext.putExtra("AllInOne", paramIntent);
      this.a.mRuntime.a().startActivity(paramContext);
      paramContext = new Intent();
      paramContext.putExtra("closeSpecialLogic", true);
      this.a.mRuntime.a().setResult(-1, paramContext);
      this.a.mRuntime.a().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmu
 * JD-Core Version:    0.7.0.1
 */