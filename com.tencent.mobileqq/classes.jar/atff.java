import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class atff
  extends atfk
{
  public atff(QQAppInterface paramQQAppInterface, Context paramContext)
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
    if ((paramChatMessage == null) || (paramChatMessage.isMultiMsg)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("OfflineFileBubblePauseHandler", 1, "handlePauseClick: type[" + paramInt + "]");
        } while ((paramInt == -1) || (!(paramChatMessage instanceof MessageForFile)));
        paramView = (MessageForFile)paramChatMessage;
        paramafqr = auea.a(this.a, paramView);
      } while (paramafqr == null);
      if (paramView.istroop == 3000) {}
      for (i = 3; paramInt == 0; i = 1)
      {
        bdla.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", i, 0, "", "", "", "");
        this.a.getFileManagerEngine().a(paramafqr.nSessionId);
        return;
      }
    } while (paramInt != 1);
    bdla.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", i, 0, "", "", "", "");
    a(new atfg(this, i, paramafqr));
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
        } while ((paramChatMessage.isMultiMsg) || (!(paramChatMessage instanceof MessageForFile)));
        paramChatMessage = (MessageForFile)paramChatMessage;
        paramChatMessage = auea.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubblePauseHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
      if ((paramChatMessage.nOpType == 0) && (paramChatMessage.status == 2)) {
        return true;
      }
    } while ((paramChatMessage.nOpType != 3) || (paramChatMessage.status != 2));
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
        } while ((paramChatMessage.isMultiMsg) || (!(paramChatMessage instanceof MessageForFile)));
        paramChatMessage = (MessageForFile)paramChatMessage;
        paramChatMessage = auea.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubblePauseHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
      if ((paramChatMessage.nOpType == 0) && (paramChatMessage.status == 3)) {
        return true;
      }
    } while ((paramChatMessage.nOpType != 3) || (paramChatMessage.status != 3));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atff
 * JD-Core Version:    0.7.0.1
 */