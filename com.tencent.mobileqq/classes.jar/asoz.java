import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.1;
import java.util.ArrayList;

public class asoz
  extends BroadcastReceiver
{
  private asoz(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!"action_qgame_tool_messgae".equals(paramContext));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      paramContext = (ArrayList)paramContext.getSerializable("key_get_msg");
    } while ((paramContext == null) || (paramContext.size() <= 0));
    ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.1(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoz
 * JD-Core Version:    0.7.0.1
 */