import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class atrq
  implements bhtv
{
  private int jdField_a_of_type_Int;
  
  atrq(atro paramatro) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.jdField_a_of_type_Int)
    {
      if (!atro.a(this.jdField_a_of_type_Atro).b()) {
        atro.a(this.jdField_a_of_type_Atro).a();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        atro.a(this.jdField_a_of_type_Atro).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt >= this.jdField_a_of_type_Int) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrq
 * JD-Core Version:    0.7.0.1
 */