import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class aodn
  extends aodk
{
  public aodn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected ImageView a(acju paramacju)
  {
    if (paramacju == null) {}
    while (!(paramacju instanceof admb)) {
      return null;
    }
    return ((admb)paramacju).a;
  }
  
  protected void a(acju paramacju, ImageView paramImageView)
  {
    if (paramacju == null) {}
    while (!(paramacju instanceof admb)) {
      return;
    }
    ((admb)paramacju).a = paramImageView;
  }
  
  protected void a(View paramView, acju paramacju, ChatMessage paramChatMessage, int paramInt)
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
            paramacju = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.a, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          paramacju = azjg.a(this.a, paramacju);
        } while (paramacju == null);
        if (paramInt != 0) {
          break;
        }
      } while ((paramacju.b != 0) && (paramacju.b != 1));
      awqx.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(paramacju.a);
      return;
    } while ((paramInt != 1) || (paramacju.b != 2));
    awqx.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    a(new aodo(this, paramChatMessage.frienduin, paramacju));
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
        paramChatMessage = azjg.a(this.a, paramChatMessage);
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
        paramChatMessage = azjg.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 3) && (paramChatMessage.b != 2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aodn
 * JD-Core Version:    0.7.0.1
 */