import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class bbbc
  extends BroadcastReceiver
{
  public bbbc(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      this.a.a(i, 9);
    }
    do
    {
      return;
      if ("key_audio_delete_action".equals(paramContext))
      {
        this.a.a(0);
        this.a.a = null;
        bcht.a(this.a.o, this.a.p, "del_record", this.a.q, this.a.b, "", "");
        return;
      }
    } while (!"key_audio_play_action".equals(paramContext));
    bcht.a(this.a.o, this.a.p, "preview_record", this.a.q, this.a.b, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbc
 * JD-Core Version:    0.7.0.1
 */