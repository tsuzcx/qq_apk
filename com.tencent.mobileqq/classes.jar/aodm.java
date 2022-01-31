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

public class aodm
  extends aodh
{
  public aodm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected CircleFileStateView a(acju paramacju)
  {
    if (paramacju == null) {}
    while (!(paramacju instanceof admb)) {
      return null;
    }
    return ((admb)paramacju).a;
  }
  
  protected void a(acju paramacju, CircleFileStateView paramCircleFileStateView)
  {
    if (paramacju == null) {}
    while (!(paramacju instanceof admb)) {
      return;
    }
    ((admb)paramacju).a = paramCircleFileStateView;
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
              paramacju = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
            } while (paramacju == null);
            int i = badq.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              azic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131632133));
              return;
            }
          } while (paramacju.b != 8);
          localTroopFileTransferManager.d(paramacju.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new aypd(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramacju.b != 10) && (paramacju.b != 9)) {
          break;
        }
      } while (paramacju.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramacju.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramacju.b == 7)
      {
        paramChatMessage.a(paramView.url, paramacju.g, paramacju.c, paramacju.h);
        return;
      }
    } while ((paramacju.b != 6) || (bace.b(paramacju.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramacju.g, paramacju.c, paramacju.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ayqd localayqd;
    do
    {
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
            } while (!(paramChatMessage instanceof MessageForTroopFile));
            paramChatMessage = (MessageForTroopFile)paramChatMessage;
            localayqd = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          } while ((localayqd == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = apck.a(localayqd.g);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localayqd.b + "]");
        }
        if ((localayqd.b != 10) && (localayqd.b != 9) && (localayqd.b != 7)) {
          break;
        }
      } while (bace.b(localayqd.jdField_a_of_type_JavaLangString));
      return true;
    } while ((localayqd.b != 6) || (bace.b(localayqd.jdField_a_of_type_JavaLangString)));
    return true;
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
        do
        {
          return false;
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while (paramChatMessage == null);
      i = apck.a(paramChatMessage.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aodm
 * JD-Core Version:    0.7.0.1
 */