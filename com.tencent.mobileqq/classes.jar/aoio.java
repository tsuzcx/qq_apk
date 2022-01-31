import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.confess.BaseMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

public class aoio
  implements Handler.Callback
{
  public aoio(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label196:
    for (;;)
    {
      return false;
      if ((this.a.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {
        break;
      }
      this.a.jdField_a_of_type_Ajit.a(this.a.jdField_c_of_type_JavaUtilList);
      this.a.jdField_a_of_type_Ajit.a(17);
      this.a.c();
      if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_c_of_type_JavaUtilList.size() == 0)) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Boolean) {
          break label196;
        }
        this.a.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) }));
        return false;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    this.a.b = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoio
 * JD-Core Version:    0.7.0.1
 */