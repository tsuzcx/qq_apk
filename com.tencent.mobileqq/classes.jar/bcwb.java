import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bcwb
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void service(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str != null) && ("gif_ui_show".equals(str)))
    {
      int i = paramIntent.getIntExtra("gif_ui_show_bid", 0);
      long l = paramIntent.getLongExtra("gif_ui_show_seq", 0L);
      paramIntent = new Bundle();
      paramIntent.putInt("gif_ui_show_bid", i);
      paramIntent.putLong("gif_ui_show_seq", l);
      notifyObserver(null, 0, true, paramIntent, ayxp.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwb
 * JD-Core Version:    0.7.0.1
 */