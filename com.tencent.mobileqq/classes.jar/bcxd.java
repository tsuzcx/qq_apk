import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.RichText;

public class bcxd
  implements awkh
{
  protected WeakReference<TroopPicEffectsEditActivity> a;
  
  public bcxd(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity)
  {
    this.a = new WeakReference(paramTroopPicEffectsEditActivity);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
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
    localTroopPicEffectsEditActivity.startActivity(aepi.a(localIntent, new int[] { 1 }));
    localTroopPicEffectsEditActivity.finish();
    localTroopPicEffectsEditActivity.a(localTroopPicEffectsEditActivity.a, (im_msg_body.CustomFace)paramawki.a, new bcxe(this, localTroopPicEffectsEditActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxd
 * JD-Core Version:    0.7.0.1
 */