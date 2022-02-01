import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper.1;
import com.tencent.qphone.base.util.QLog;

public class bejc
  implements agin
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  bejk jdField_a_of_type_Bejk;
  public BaseChatPie a;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  
  public bejc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ThreadManager.executeOnSubThread(new AIOTofuMsgHelper.1(this));
      return;
      QLog.i("Tofu_AIOTofuMsgHelper", 1, "onMoveToState show_first.");
      if (this.jdField_a_of_type_Bejk == null) {
        this.jdField_a_of_type_Bejk = ((bejk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOFUMSG_MANAGER));
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!((anvk)localObject).b(this.jdField_a_of_type_JavaLangString)));
    boolean bool = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_Bejk;
    String str = this.jdField_a_of_type_JavaLangString;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((bejk)localObject).a(str, paramInt);
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 14, 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejc
 * JD-Core Version:    0.7.0.1
 */