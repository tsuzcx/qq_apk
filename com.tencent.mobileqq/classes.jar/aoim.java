import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;

class aoim
  implements aobj
{
  aoim(aoil paramaoil) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Intent localIntent;
    if (paramBoolean)
    {
      QLog.d("AVGameShareJoinRoomAction", 1, "doAction success, roomId: " + paramLong1 + " shareUin: " + paramLong2);
      localIntent = aobd.a().a(this.a.a);
      if (localIntent == null) {
        QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: intent is null");
      }
    }
    for (;;)
    {
      return;
      localIntent.putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_join_room");
      localIntent.putExtra("thridparty_av_game_share_uin", paramLong2);
      localIntent.putExtra("thridparty_av_game_room_id", paramLong1);
      this.a.a.startActivity(localIntent);
      while ((this.a.a instanceof JumpActivity))
      {
        ((JumpActivity)this.a.a).finish();
        ((JumpActivity)this.a.a).overridePendingTransition(0, 0);
        return;
        QLog.e("AVGameShareJoinRoomAction", 1, "doAction fail");
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoim
 * JD-Core Version:    0.7.0.1
 */