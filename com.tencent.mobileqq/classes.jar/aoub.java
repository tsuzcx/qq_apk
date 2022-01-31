import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class aoub
  extends aouf
{
  public aoub(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected CircleFileStateView a(acuj paramacuj)
  {
    if (paramacuj == null) {}
    while (!(paramacuj instanceof adwy)) {
      return null;
    }
    return ((adwy)paramacuj).a;
  }
  
  protected void a(acuj paramacuj, CircleFileStateView paramCircleFileStateView)
  {
    if (paramacuj == null) {}
    while (!(paramacuj instanceof adwy)) {
      return;
    }
    ((adwy)paramacuj).a = paramCircleFileStateView;
  }
  
  protected void a(View paramView, acuj paramacuj, ChatMessage paramChatMessage, int paramInt)
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
        } while ((paramInt == -1) || (!(paramChatMessage instanceof MessageForFile)));
        paramView = (MessageForFile)paramChatMessage;
        paramView = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      } while (paramView == null);
      if (paramInt == 0)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
        if (paramView.getCloudType() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.nSessionId);
        return;
      }
    } while (paramInt != 1);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
    aptd.a(paramView).a(false, this.jdField_a_of_type_AndroidContentContext, new aouc(this, paramView));
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool3 = true;
    if (paramChatMessage == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return false;
          } while (!(paramChatMessage instanceof MessageForFile));
          paramChatMessage = (MessageForFile)paramChatMessage;
          paramChatMessage = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        } while (paramChatMessage == null);
        i = apug.a(paramChatMessage.fileName);
      } while ((i == 0) || (i == 2));
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "] fileName[" + paramChatMessage.fileName + "] uniseq[" + paramChatMessage.uniseq + "]");
      }
    } while (16 == paramChatMessage.status);
    if ((paramChatMessage.nOpType == -1) && (paramChatMessage.status == -1)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
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
      if ((paramChatMessage.nOpType != 7) && (paramChatMessage.nOpType != 28) && (paramChatMessage.nOpType != 21) && (paramChatMessage.nOpType != 22) && (paramChatMessage.nOpType != 3) && (paramChatMessage.nOpType != 24))
      {
        bool1 = bool2;
        if (paramChatMessage.nOpType != 25) {}
      }
      else if (paramChatMessage.status != 1)
      {
        bool1 = bool2;
        if (paramChatMessage.status != -1) {}
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (paramChatMessage.nOpType == 1) {}
      switch (paramChatMessage.status)
      {
      default: 
        bool2 = bool1;
        label383:
        bool1 = bool2;
        if (paramChatMessage.nOpType == 0) {
          if (paramChatMessage.status != 1)
          {
            bool1 = bool2;
            if (paramChatMessage.status != -1) {
              break;
            }
          }
          else
          {
            if (bbdx.b(paramChatMessage.strFilePath)) {
              break label447;
            }
          }
        }
        break;
      }
      label447:
      for (boolean bool1 = bool3; (!bool1) || (!bbdx.b(paramChatMessage.strFilePath)); bool1 = false)
      {
        return bool1;
        bool2 = true;
        break label383;
      }
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
          do
          {
            return false;
          } while (!(paramChatMessage instanceof MessageForFile));
          paramChatMessage = (MessageForFile)paramChatMessage;
          paramChatMessage = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        } while (paramChatMessage == null);
        i = apug.a(paramChatMessage.fileName);
      } while ((i == 0) || (i == 2));
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
    } while ((paramChatMessage.nOpType != 1) || ((paramChatMessage.status != 2) && (paramChatMessage.status != 18)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoub
 * JD-Core Version:    0.7.0.1
 */