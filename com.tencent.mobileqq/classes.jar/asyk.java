import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class asyk
  extends asyo
{
  public asyk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return ((paramFileManagerEntity.nOpType == 7) || (paramFileManagerEntity.nOpType == 28) || (paramFileManagerEntity.nOpType == 21) || (paramFileManagerEntity.nOpType == 22) || (paramFileManagerEntity.nOpType == 3) || (paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 1) || (paramFileManagerEntity.status == -1));
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType != 1) {}
    while ((paramFileManagerEntity.status != -1) && (paramFileManagerEntity.status != 3) && (paramFileManagerEntity.status != 0) && (paramFileManagerEntity.status != 13)) {
      return false;
    }
    return true;
  }
  
  private boolean c(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity.nOpType != 0) {}
    while ((paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1)) {
      return false;
    }
    if (!bgmg.b(paramFileManagerEntity.getFilePath())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected FileManagerEntity a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForFile))
    {
      paramChatMessage = (MessageForFile)paramChatMessage;
      return atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    QLog.i("OfflineFileBubbleDownloadHandler", 1, "getFileManagerEntityByMsg:  msg is not message for file.");
    return null;
  }
  
  protected CircleFileStateView a(afwr paramafwr)
  {
    if (paramafwr == null) {}
    while (!(paramafwr instanceof ahfe)) {
      return null;
    }
    return ((ahfe)paramafwr).a;
  }
  
  protected void a(afwr paramafwr, CircleFileStateView paramCircleFileStateView)
  {
    if (paramafwr == null) {}
    while (!(paramafwr instanceof ahfe)) {
      return;
    }
    ((ahfe)paramafwr).a = paramCircleFileStateView;
  }
  
  protected void a(View paramView, afwr paramafwr, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("OfflineFileBubbleDownloadHandler", 1, "handleDownloadClick: type[" + paramInt + "]");
        } while (paramInt == -1);
        paramView = a(paramChatMessage);
      } while (paramView == null);
      if (paramInt == 0)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
        if (paramView.getCloudType() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
        return;
      }
    } while (paramInt != 1);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
    atul.a(paramView).a(false, this.jdField_a_of_type_AndroidContentContext, new asyl(this, paramView));
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return false;
          paramChatMessage = a(paramChatMessage);
        } while (paramChatMessage == null);
        i = atvo.a(paramChatMessage.fileName);
      } while ((i == 0) || (i == 2));
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "] fileName[" + paramChatMessage.fileName + "] uniseq[" + paramChatMessage.uniseq + "]");
      }
    } while (16 == paramChatMessage.status);
    if ((paramChatMessage.nOpType == -1) && (paramChatMessage.status == -1)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1;
      if (paramChatMessage.nOpType != 0)
      {
        bool1 = bool2;
        if (paramChatMessage.nOpType != 11) {}
      }
      else
      {
        bool1 = bool2;
        if (paramChatMessage.getCloudType() == 1)
        {
          bool1 = bool2;
          if (paramChatMessage.status == 1) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (paramChatMessage.nOpType == 11)
      {
        bool2 = bool1;
        if (paramChatMessage.getCloudType() == 1)
        {
          bool2 = bool1;
          if (paramChatMessage.status == 13) {
            bool2 = true;
          }
        }
      }
      if (a(paramChatMessage)) {
        bool2 = true;
      }
      if (b(paramChatMessage)) {
        bool2 = true;
      }
      if (c(paramChatMessage)) {
        bool2 = true;
      }
      if ((bool2) && (bgmg.b(paramChatMessage.getFilePath()))) {
        break;
      }
      return bool2;
    }
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return false;
          paramChatMessage = a(paramChatMessage);
        } while (paramChatMessage == null);
        i = atvo.a(paramChatMessage.fileName);
      } while ((i == 0) || (i == 2));
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
    } while ((paramChatMessage.nOpType != 1) || ((paramChatMessage.status != 2) && (paramChatMessage.status != 18)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyk
 * JD-Core Version:    0.7.0.1
 */