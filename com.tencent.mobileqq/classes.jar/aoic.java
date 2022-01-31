import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.6.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aoic
  extends RecyclerView.OnScrollListener
{
  public aoic(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.a.jdField_a_of_type_Baxk != null)
    {
      if (paramInt != 0) {
        break label87;
      }
      this.a.c = false;
      this.a.jdField_a_of_type_Baxk.b();
      this.a.a();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        this.a.g();
        this.a.b(false);
      }
      return;
      label87:
      this.a.c = true;
      this.a.jdField_a_of_type_Baxk.c();
      this.a.jdField_a_of_type_Baxk.a();
      synchronized (ExtendFriendBaseFragment.a)
      {
        if (this.a.jdField_a_of_type_JavaUtilMap != null) {
          this.a.jdField_a_of_type_JavaUtilMap.clear();
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((!ExtendFriendSearchFragment.a(this.a)) && (!ExtendFriendSearchFragment.b(this.a)) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.a.jdField_a_of_type_Aoiu != null) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(this.a.jdField_a_of_type_Aoiu.getItemCount() - 2) != null))
    {
      this.a.a(true);
      ExtendFriendSearchFragment.a(this.a).post(new ExtendFriendSearchFragment.6.1(this));
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
    this.a.a(false, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoic
 * JD-Core Version:    0.7.0.1
 */