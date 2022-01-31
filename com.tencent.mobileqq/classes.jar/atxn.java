import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import com.tencent.widget.AbsListView;

public final class atxn
{
  int jdField_a_of_type_Int;
  final Handler jdField_a_of_type_AndroidOsHandler;
  atxm jdField_a_of_type_Atxm;
  final ItemLoader<?, ?> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  void a()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void a(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_Atxm.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Atxm.a();
    if ((this.jdField_a_of_type_Int != 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  void a(atxm paramatxm)
  {
    this.jdField_a_of_type_Atxm = paramatxm;
    if (this.jdField_a_of_type_Atxm != null)
    {
      paramatxm = this.jdField_a_of_type_Atxm.a();
      paramatxm.setOnScrollListener(new atxq(this, null));
      paramatxm.setOnTouchListener(new atxp(this, null));
      paramatxm.setOnItemSelectedListener(new atxr(this, null));
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Atxm == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Atxm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxn
 * JD-Core Version:    0.7.0.1
 */