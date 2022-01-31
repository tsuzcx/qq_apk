import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ansd
  extends RecyclerView.OnScrollListener
{
  public ansd(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.a.jdField_a_of_type_Azwg != null)
    {
      if (paramInt != 0) {
        break label94;
      }
      this.a.c = false;
      this.a.jdField_a_of_type_Azwg.b();
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
      this.a.jdField_a_of_type_Azwg.c();
      this.a.jdField_a_of_type_Azwg.a();
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
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onScrolled mRecyclerViewScrollY: " + this.a.h + "  speed: " + f1 + "  dy: " + paramInt2);
    }
    this.a.d = System.currentTimeMillis();
    if (this.a.jdField_a_of_type_AndroidViewView != null)
    {
      ExtendFriendSquareFragment.a(this.a, this.a.h, f1);
      if (!this.a.e) {
        this.a.d(false);
      }
    }
    if ((!ExtendFriendSquareFragment.d(this.a)) && (!ExtendFriendSquareFragment.e(this.a)) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.a.jdField_a_of_type_Ansi != null) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(this.a.jdField_a_of_type_Ansi.getItemCount() - 2) != null))
    {
      this.a.a(true);
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.3.1(this));
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansd
 * JD-Core Version:    0.7.0.1
 */