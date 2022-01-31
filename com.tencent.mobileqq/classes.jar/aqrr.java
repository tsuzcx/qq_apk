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

public class aqrr
  extends aqrm
{
  public aqrr(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected CircleFileStateView a(aeqi paramaeqi)
  {
    if (paramaeqi == null) {}
    while (!(paramaeqi instanceof afya)) {
      return null;
    }
    return ((afya)paramaeqi).a;
  }
  
  protected void a(aeqi paramaeqi, CircleFileStateView paramCircleFileStateView)
  {
    if (paramaeqi == null) {}
    while (!(paramaeqi instanceof afya)) {
      return;
    }
    ((afya)paramaeqi).a = paramCircleFileStateView;
  }
  
  protected void a(View paramView, aeqi paramaeqi, ChatMessage paramChatMessage, int paramInt)
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
              paramaeqi = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
            } while (paramaeqi == null);
            int i = bdin.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
              return;
            }
          } while (paramaeqi.b != 8);
          localTroopFileTransferManager.d(paramaeqi.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new bbsn(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramaeqi.b != 10) && (paramaeqi.b != 9)) {
          break;
        }
      } while (paramaeqi.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramaeqi.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramaeqi.b == 7)
      {
        paramChatMessage.a(paramView.url, paramaeqi.g, paramaeqi.c, paramaeqi.h);
        return;
      }
    } while ((paramaeqi.b != 6) || (bdhb.b(paramaeqi.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramaeqi.g, paramaeqi.c, paramaeqi.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    bbtn localbbtn;
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
            localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          } while ((localbbtn == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = arrr.a(localbbtn.g);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localbbtn.b + "]");
        }
        if ((localbbtn.b != 10) && (localbbtn.b != 9) && (localbbtn.b != 7)) {
          break;
        }
      } while (bdhb.b(localbbtn.jdField_a_of_type_JavaLangString));
      return true;
    } while ((localbbtn.b != 6) || (bdhb.b(localbbtn.jdField_a_of_type_JavaLangString)));
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
        paramChatMessage = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while (paramChatMessage == null);
      i = arrr.a(paramChatMessage.g);
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
 * Qualified Name:     aqrr
 * JD-Core Version:    0.7.0.1
 */