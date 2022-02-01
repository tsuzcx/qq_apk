import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class awuw
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new awux(this);
  private awuy jdField_a_of_type_Awuy;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public awuw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public void a()
  {
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void a(awuy paramawuy)
  {
    this.jdField_a_of_type_Awuy = paramawuy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuw
 * JD-Core Version:    0.7.0.1
 */