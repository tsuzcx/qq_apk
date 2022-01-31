import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class aqnj
  extends aqng
{
  public aqnj(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected ImageView a(aelt paramaelt)
  {
    if (paramaelt == null) {}
    while (!(paramaelt instanceof aftl)) {
      return null;
    }
    return ((aftl)paramaelt).a;
  }
  
  protected void a(aelt paramaelt, ImageView paramImageView)
  {
    if (paramaelt == null) {}
    while (!(paramaelt instanceof aftl)) {
      return;
    }
    ((aftl)paramaelt).a = paramImageView;
  }
  
  protected void a(View paramView, aelt paramaelt, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              QLog.i("TroopFileBubblePauseHandler", 1, "handlePauseClick: type[" + paramInt + "]");
            } while (paramInt == -1);
            paramaelt = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.a, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          paramaelt = bcjk.a(this.a, paramaelt);
        } while (paramaelt == null);
        if (paramInt != 0) {
          break;
        }
      } while ((paramaelt.b != 0) && (paramaelt.b != 1));
      azmj.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(paramaelt.a);
      return;
    } while ((paramInt != 1) || (paramaelt.b != 2));
    azmj.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    a(new aqnk(this, paramChatMessage.frienduin, paramaelt));
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = bcjk.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 0) && (paramChatMessage.b != 1));
    return true;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = bcjk.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 3) && (paramChatMessage.b != 2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnj
 * JD-Core Version:    0.7.0.1
 */