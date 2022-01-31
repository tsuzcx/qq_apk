import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class atrj
  implements View.OnClickListener
{
  private MessageForLocationShare a;
  public boolean a;
  
  public atrj()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "realClick: invoked. 屏蔽消息双击事件 messageForLocationShare: ", this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare });
    }
    LocationShareFragment.a(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare.frienduin, 2);
    azqs.b(null, "CliOper", "", "", "0X800A766", "0X800A766", 0, 0, "", "0", "0", "");
  }
  
  public void a(MessageForLocationShare paramMessageForLocationShare)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare = paramMessageForLocationShare;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. ", " v: ", paramView, " messageForLocationShare: ", this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare });
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. disable click in chat history", " v: ", paramView });
      }
    }
    do
    {
      do
      {
        return;
        if (!yxv.a("LocationMessageModule")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. 屏蔽消息双击事件", " v: ", paramView });
      return;
    } while ((BaseActivity.sTopActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForLocationShare.isSharingLocation));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrj
 * JD-Core Version:    0.7.0.1
 */