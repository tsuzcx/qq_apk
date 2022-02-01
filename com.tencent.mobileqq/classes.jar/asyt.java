import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class asyt
  extends asyo
{
  public asyt(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected bety a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      return bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    QLog.i("TroopFileBubbleDownloadHandler", 1, "getTroopFileStatusInfoByMsg:  msg is not message for troop file.");
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
          TroopFileTransferManager localTroopFileTransferManager;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  QLog.i("TroopFileBubbleDownloadHandler", 1, "handlePauseClick: type[" + paramInt + "]");
                } while (paramInt == -1);
                paramView = (MessageForTroopFile)paramChatMessage;
                localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
              } while (localTroopFileTransferManager == null);
              paramafwr = a(paramChatMessage);
            } while (paramafwr == null);
            int i = bgnt.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              bfrh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696888));
              return;
            }
          } while (paramafwr.b != 8);
          localTroopFileTransferManager.d(paramafwr.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new besy(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramafwr.b != 10) && (paramafwr.b != 9)) {
          break;
        }
      } while (paramafwr.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramafwr.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramafwr.b == 7)
      {
        paramChatMessage.a(paramView.url, paramafwr.g, paramafwr.c, paramafwr.h);
        return;
      }
    } while ((paramafwr.b != 6) || (bgmg.b(paramafwr.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramafwr.g, paramafwr.c, paramafwr.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {
      return false;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    if ((localMessageForTroopFile.lastTime != 0L) && (localMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return false;
    }
    int i = atvo.a(paramChatMessage.g);
    if ((i == 0) || (i == 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + paramChatMessage.b + "]");
    }
    if ((paramChatMessage.b == 10) || (paramChatMessage.b == 9) || (paramChatMessage.b == 7)) {
      return !bgmg.b(paramChatMessage.jdField_a_of_type_JavaLangString);
    }
    return (paramChatMessage.b == 6) && (!bgmg.b(paramChatMessage.jdField_a_of_type_JavaLangString));
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    boolean bool = true;
    if (paramChatMessage == null) {}
    int i;
    do
    {
      do
      {
        return false;
        paramChatMessage = a(paramChatMessage);
      } while (paramChatMessage == null);
      i = atvo.a(paramChatMessage.g);
    } while ((i == 0) || (i == 2));
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.b + "]");
    }
    if (paramChatMessage.b == 8) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyt
 * JD-Core Version:    0.7.0.1
 */