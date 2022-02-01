import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class asae
  implements Handler.Callback
{
  public asae(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label192:
    do
    {
      return false;
      if ((!this.a.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramMessage.obj != null))
      {
        paramMessage = (List)paramMessage.obj;
        this.a.jdField_a_of_type_Alms.a(paramMessage);
        this.a.jdField_a_of_type_JavaUtilList.clear();
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
        this.a.b();
        int j = this.a.a(paramMessage);
        axws.a(this.a.app.getCurrentAccountUin(), "nearby_msg_tab_last_num", Integer.valueOf(j));
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("BaseMsgBoxActivity, MSG_REFRESH_LIST_UI, lastUnReadNum=").append(this.a.jdField_c_of_type_Int).append(", newUnReadNum=").append(j).append(", msgList.size=");
          if (paramMessage == null)
          {
            i = 0;
            QLog.d("nearby.msgbox.tab", 2, i + ", showRedDot=" + this.a.e);
          }
        }
        else if (this.a.d)
        {
          localObject = this.a.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(1);
          this.a.jdField_b_of_type_MqqOsMqqHandler.removeMessages(1);
          ((Message)localObject).arg1 = j;
          this.a.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 500L);
          if (paramMessage.size() != 0) {
            break label403;
          }
          this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
          if (!BaseMsgBoxActivity.a(this.a)) {
            break label418;
          }
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        while (!this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
          this.a.jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "init ui cost time : " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
          return false;
          i = paramMessage.size();
          break label192;
          this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
          break label298;
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      this.a.jdField_b_of_type_Boolean = true;
      return false;
      this.a.e = true;
      int i = paramMessage.arg1;
      this.a.jdField_c_of_type_Int = i;
      if (this.a.jdField_c_of_type_Int < 0) {
        this.a.e = false;
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (!this.a.e));
    label298:
    NearbyActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.a.jdField_c_of_type_Int);
    label403:
    label418:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asae
 * JD-Core Version:    0.7.0.1
 */