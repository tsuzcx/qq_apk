import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import com.tencent.widget.AbsListView;

public final class avot
{
  int jdField_a_of_type_Int;
  final Handler jdField_a_of_type_AndroidOsHandler;
  avos jdField_a_of_type_Avos;
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
    this.jdField_a_of_type_Avos.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Avos.a();
    if ((this.jdField_a_of_type_Int != 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  void a(avos paramavos)
  {
    this.jdField_a_of_type_Avos = paramavos;
    if (this.jdField_a_of_type_Avos != null)
    {
      paramavos = this.jdField_a_of_type_Avos.a();
      paramavos.setOnScrollListener(new avow(this, null));
      paramavos.setOnTouchListener(new avov(this, null));
      paramavos.setOnItemSelectedListener(new avox(this, null));
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Avos == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Avos.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avot
 * JD-Core Version:    0.7.0.1
 */