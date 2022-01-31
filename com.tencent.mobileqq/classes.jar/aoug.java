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

public class aoug
  extends aoub
{
  public aoug(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected CircleFileStateView a(acun paramacun)
  {
    if (paramacun == null) {}
    while (!(paramacun instanceof adxa)) {
      return null;
    }
    return ((adxa)paramacun).a;
  }
  
  protected void a(acun paramacun, CircleFileStateView paramCircleFileStateView)
  {
    if (paramacun == null) {}
    while (!(paramacun instanceof adxa)) {
      return;
    }
    ((adxa)paramacun).a = paramCircleFileStateView;
  }
  
  protected void a(View paramView, acun paramacun, ChatMessage paramChatMessage, int paramInt)
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
              paramacun = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
            } while (paramacun == null);
            int i = bbev.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
              return;
            }
          } while (paramacun.b != 8);
          localTroopFileTransferManager.d(paramacun.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new azpt(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramacun.b != 10) && (paramacun.b != 9)) {
          break;
        }
      } while (paramacun.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramacun.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramacun.b == 7)
      {
        paramChatMessage.a(paramView.url, paramacun.g, paramacun.c, paramacun.h);
        return;
      }
    } while ((paramacun.b != 6) || (bbdj.b(paramacun.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramacun.g, paramacun.c, paramacun.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    azqt localazqt;
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
            localazqt = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          } while ((localazqt == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = apue.a(localazqt.g);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localazqt.b + "]");
        }
        if ((localazqt.b != 10) && (localazqt.b != 9) && (localazqt.b != 7)) {
          break;
        }
      } while (bbdj.b(localazqt.jdField_a_of_type_JavaLangString));
      return true;
    } while ((localazqt.b != 6) || (bbdj.b(localazqt.jdField_a_of_type_JavaLangString)));
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
        paramChatMessage = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while (paramChatMessage == null);
      i = apue.a(paramChatMessage.g);
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
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */