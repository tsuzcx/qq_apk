import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class berf
  extends beqz
{
  public berf(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 20;
  }
  
  @Nullable
  public bera a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    if (((paramList instanceof MessageForArkApp)) && (a(paramList, paramLong2, paramLong3))) {
      return new bera(true, aowk.a((MessageForArkApp)paramList), bdyo.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (!(paramObject instanceof bdyo)) {}
    do
    {
      do
      {
        return;
        paramObject = (bdyo)paramObject;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramObject.b);
      } while (!(paramObject instanceof MessageForArkApp));
      paramObject = ((MessageForArkApp)paramObject).ark_app_message;
    } while (paramObject == null);
    aovl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA11", "0X800AA11", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berf
 * JD-Core Version:    0.7.0.1
 */