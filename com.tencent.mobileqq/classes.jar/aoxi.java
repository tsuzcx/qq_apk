import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoxi
  extends aouc
{
  public aoxi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void d()
  {
    Object localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject1 != null) && (((ChatFragment)localObject1).a() != null))
    {
      localObject1 = ((ChatFragment)localObject1).a();
      if ((localObject1 != null) && ((localObject1 instanceof TroopChatPie)))
      {
        localObject1 = (TroopChatPie)localObject1;
        Object localObject2 = (agkk)((TroopChatPie)localObject1).getHelper(43);
        if (localObject2 != null) {
          ((agkk)localObject2).b(2);
        }
        localObject2 = new HashMap();
        if ((((TroopChatPie)localObject1).sessionInfo != null) && (!TextUtils.isEmpty(((TroopChatPie)localObject1).sessionInfo.curFriendUin))) {
          ((HashMap)localObject2).put("qq_group_num", ((TroopChatPie)localObject1).sessionInfo.curFriendUin);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          ((HashMap)localObject2).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        bekv.a("click#aio_graybar", (HashMap)localObject2);
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      d();
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("TroopOneWayAction", 1, "doAction error: " + localException.getMessage());
      a("TroopOneWayAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxi
 * JD-Core Version:    0.7.0.1
 */