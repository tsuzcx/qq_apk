import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import com.tencent.widget.AbsListView;

public final class aytl
{
  int jdField_a_of_type_Int;
  final Handler jdField_a_of_type_AndroidOsHandler;
  aytk jdField_a_of_type_Aytk;
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
    this.jdField_a_of_type_Aytk.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Aytk.a();
    if ((this.jdField_a_of_type_Int != 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  void a(aytk paramaytk)
  {
    this.jdField_a_of_type_Aytk = paramaytk;
    if (this.jdField_a_of_type_Aytk != null)
    {
      paramaytk = this.jdField_a_of_type_Aytk.a();
      paramaytk.setOnScrollListener(new ayto(this, null));
      paramaytk.setOnTouchListener(new aytn(this, null));
      paramaytk.setOnItemSelectedListener(new aytp(this, null));
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Aytk == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Aytk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytl
 * JD-Core Version:    0.7.0.1
 */