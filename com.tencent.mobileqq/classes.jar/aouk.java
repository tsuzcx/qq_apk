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

public class aouk
  extends aouf
{
  public aouk(QQAppInterface paramQQAppInterface, Context paramContext)
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
              paramacuj = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
            } while (paramacuj == null);
            int i = bbfj.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              bajt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697863));
              return;
            }
          } while (paramacuj.b != 8);
          localTroopFileTransferManager.d(paramacuj.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new azpv(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramacuj.b != 10) && (paramacuj.b != 9)) {
          break;
        }
      } while (paramacuj.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramacuj.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramacuj.b == 7)
      {
        paramChatMessage.a(paramView.url, paramacuj.g, paramacuj.c, paramacuj.h);
        return;
      }
    } while ((paramacuj.b != 6) || (bbdx.b(paramacuj.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramacuj.g, paramacuj.c, paramacuj.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    azqv localazqv;
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
            localazqv = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          } while ((localazqv == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = apug.a(localazqv.g);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localazqv.b + "]");
        }
        if ((localazqv.b != 10) && (localazqv.b != 9) && (localazqv.b != 7)) {
          break;
        }
      } while (bbdx.b(localazqv.jdField_a_of_type_JavaLangString));
      return true;
    } while ((localazqv.b != 6) || (bbdx.b(localazqv.jdField_a_of_type_JavaLangString)));
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
        paramChatMessage = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while (paramChatMessage == null);
      i = apug.a(paramChatMessage.g);
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
 * Qualified Name:     aouk
 * JD-Core Version:    0.7.0.1
 */