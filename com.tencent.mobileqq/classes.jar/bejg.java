import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper.1;
import com.tencent.qphone.base.util.QLog;

public class bejg
  implements agvc
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  bejo jdField_a_of_type_Bejo;
  public BaseChatPie a;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  
  public bejg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      if (this.jdField_a_of_type_Bejo == null) {
        this.jdField_a_of_type_Bejo = ((bejo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(368));
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!((anyw)localObject).b(this.jdField_a_of_type_JavaLangString)));
    boolean bool = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_Bejo;
    String str = this.jdField_a_of_type_JavaLangString;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((bejo)localObject).a(str, paramInt);
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 13, 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejg
 * JD-Core Version:    0.7.0.1
 */