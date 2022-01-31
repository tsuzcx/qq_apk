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

public class aqni
  extends aqnd
{
  public aqni(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected CircleFileStateView a(aelt paramaelt)
  {
    if (paramaelt == null) {}
    while (!(paramaelt instanceof aftl)) {
      return null;
    }
    return ((aftl)paramaelt).a;
  }
  
  protected void a(aelt paramaelt, CircleFileStateView paramCircleFileStateView)
  {
    if (paramaelt == null) {}
    while (!(paramaelt instanceof aftl)) {
      return;
    }
    ((aftl)paramaelt).a = paramCircleFileStateView;
  }
  
  protected void a(View paramView, aelt paramaelt, ChatMessage paramChatMessage, int paramInt)
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
              paramaelt = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
            } while (paramaelt == null);
            int i = bdee.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              bcig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698040));
              return;
            }
          } while (paramaelt.b != 8);
          localTroopFileTransferManager.d(paramaelt.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new bboe(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramaelt.b != 10) && (paramaelt.b != 9)) {
          break;
        }
      } while (paramaelt.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramaelt.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramaelt.b == 7)
      {
        paramChatMessage.a(paramView.url, paramaelt.g, paramaelt.c, paramaelt.h);
        return;
      }
    } while ((paramaelt.b != 6) || (bdcs.b(paramaelt.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramaelt.g, paramaelt.c, paramaelt.h);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    bbpe localbbpe;
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
            localbbpe = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          } while ((localbbpe == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = arni.a(localbbpe.g);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localbbpe.b + "]");
        }
        if ((localbbpe.b != 10) && (localbbpe.b != 9) && (localbbpe.b != 7)) {
          break;
        }
      } while (bdcs.b(localbbpe.jdField_a_of_type_JavaLangString));
      return true;
    } while ((localbbpe.b != 6) || (bdcs.b(localbbpe.jdField_a_of_type_JavaLangString)));
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
        paramChatMessage = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while (paramChatMessage == null);
      i = arni.a(paramChatMessage.g);
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
 * Qualified Name:     aqni
 * JD-Core Version:    0.7.0.1
 */