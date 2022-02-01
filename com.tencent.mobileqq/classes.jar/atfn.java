import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class atfn
  extends atfk
{
  public atfn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected ImageView a(afqr paramafqr)
  {
    if (paramafqr == null) {}
    while (!(paramafqr instanceof ahdt)) {
      return null;
    }
    return ((ahdt)paramafqr).a;
  }
  
  protected void a(afqr paramafqr, ImageView paramImageView)
  {
    if (paramafqr == null) {}
    while (!(paramafqr instanceof ahdt)) {
      return;
    }
    ((ahdt)paramafqr).a = paramImageView;
  }
  
  protected void a(View paramView, afqr paramafqr, ChatMessage paramChatMessage, int paramInt)
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
            paramafqr = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.a, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          paramafqr = bgke.a(this.a, paramafqr);
        } while (paramafqr == null);
        if (paramInt != 0) {
          break;
        }
      } while ((paramafqr.b != 0) && (paramafqr.b != 1));
      bdla.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(paramafqr.a);
      return;
    } while ((paramInt != 1) || (paramafqr.b != 2));
    bdla.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    a(new atfo(this, paramChatMessage.frienduin, paramafqr));
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
        paramChatMessage = bgke.a(this.a, paramChatMessage);
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
        paramChatMessage = bgke.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 3) && (paramChatMessage.b != 2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfn
 * JD-Core Version:    0.7.0.1
 */