import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class atoy
  extends atov
{
  public atoy(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected ImageView a(aggl paramaggl)
  {
    if (paramaggl == null) {}
    while (!(paramaggl instanceof ahoq)) {
      return null;
    }
    return ((ahoq)paramaggl).a;
  }
  
  protected void a(aggl paramaggl, ImageView paramImageView)
  {
    if (paramaggl == null) {}
    while (!(paramaggl instanceof ahoq)) {
      return;
    }
    ((ahoq)paramaggl).a = paramImageView;
  }
  
  protected void a(View paramView, aggl paramaggl, ChatMessage paramChatMessage, int paramInt)
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
            paramaggl = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.a, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          paramaggl = bgsk.a(this.a, paramaggl);
        } while (paramaggl == null);
        if (paramInt != 0) {
          break;
        }
      } while ((paramaggl.b != 0) && (paramaggl.b != 1));
      bdll.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(paramaggl.a);
      return;
    } while ((paramInt != 1) || (paramaggl.b != 2));
    bdll.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    a(new atoz(this, paramChatMessage.frienduin, paramaggl));
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
        paramChatMessage = bgsk.a(this.a, paramChatMessage);
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
        paramChatMessage = bgsk.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 3) && (paramChatMessage.b != 2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoy
 * JD-Core Version:    0.7.0.1
 */