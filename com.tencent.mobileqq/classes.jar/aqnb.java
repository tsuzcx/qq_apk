import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqnb
  extends aqng
{
  public aqnb(QQAppInterface paramQQAppInterface, Context paramContext)
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
        paramaelt = arni.a(this.a, paramView);
      } while (paramaelt == null);
      if (paramView.istroop == 3000) {}
      for (i = 3; paramInt == 0; i = 1)
      {
        azmj.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", i, 0, "", "", "", "");
        this.a.a().a(paramaelt.nSessionId);
        return;
      }
    } while (paramInt != 1);
    azmj.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", i, 0, "", "", "", "");
    a(new aqnc(this, i, paramaelt));
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
        paramChatMessage = arni.a(this.a, paramChatMessage);
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
        paramChatMessage = arni.a(this.a, paramChatMessage);
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
 * Qualified Name:     aqnb
 * JD-Core Version:    0.7.0.1
 */