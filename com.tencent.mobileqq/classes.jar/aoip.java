import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aoip
  extends RecyclerView.OnScrollListener
{
  public aoip(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.a.jdField_a_of_type_Baxk != null)
    {
      if (paramInt != 0) {
        break label94;
      }
      this.a.c = false;
      this.a.jdField_a_of_type_Baxk.b();
      this.a.a();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        ExtendFriendSquareFragment.a(this.a);
        this.a.g();
        this.a.b(false);
      }
      return;
      label94:
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
    this.a.h = this.a.d();
    float f2 = 0.0F;
    float f1 = f2;
    if (this.a.d != -1L)
    {
      long l = System.currentTimeMillis() - this.a.d;
      f1 = f2;
      if (l > 0L)
      {
        f1 = f2;
        if (l < 2000L) {
          f1 = paramInt2 * 1.0F / (float)l;
        }
      }
    }
    this.a.d = System.currentTimeMillis();
    if (this.a.jdField_a_of_type_AndroidViewView != null)
    {
      ExtendFriendSquareFragment.a(this.a, this.a.h, f1);
      if (!this.a.e) {
        this.a.d(false);
      }
    }
    if ((!ExtendFriendSquareFragment.d(this.a)) && (!ExtendFriendSquareFragment.e(this.a)) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.a.jdField_a_of_type_Aoiu != null) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(this.a.jdField_a_of_type_Aoiu.getItemCount() - 2) != null))
    {
      this.a.a(true);
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.3.1(this));
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoip
 * JD-Core Version:    0.7.0.1
 */