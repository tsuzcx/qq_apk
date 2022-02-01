import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.RichText;

public class bgbo
  implements ayyt
{
  protected WeakReference<TroopPicEffectsEditActivity> a;
  
  public bgbo(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity)
  {
    this.a = new WeakReference(paramTroopPicEffectsEditActivity);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    TroopPicEffectsEditActivity localTroopPicEffectsEditActivity = (TroopPicEffectsEditActivity)this.a.get();
    if (localTroopPicEffectsEditActivity == null) {
      return;
    }
    localTroopPicEffectsEditActivity.c();
    Intent localIntent = new Intent(localTroopPicEffectsEditActivity, SplashActivity.class);
    localIntent.putExtra("uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("friendUin"));
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("troopUin"));
    localIntent.putExtra("isFromTroopEffectPic", true);
    localTroopPicEffectsEditActivity.startActivity(afur.a(localIntent, new int[] { 1 }));
    localTroopPicEffectsEditActivity.finish();
    localTroopPicEffectsEditActivity.a(localTroopPicEffectsEditActivity.a, (im_msg_body.CustomFace)paramayyu.a, new bgbp(this, localTroopPicEffectsEditActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbo
 * JD-Core Version:    0.7.0.1
 */