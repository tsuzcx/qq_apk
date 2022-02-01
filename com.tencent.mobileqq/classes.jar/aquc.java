import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aquc
  extends amzx
{
  public aquc(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "mRedpointObserver.onDataChange(): isSucc=" + paramBoolean);
    }
    if ((!this.a.d) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView == null) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    label141:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).tabType != 7) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label141;
        }
        BaseMsgBoxActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(i));
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquc
 * JD-Core Version:    0.7.0.1
 */