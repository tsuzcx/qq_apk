import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class arwl
  implements bfos
{
  private int jdField_a_of_type_Int;
  
  arwl(arwj paramarwj) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.jdField_a_of_type_Int)
    {
      if (!arwj.a(this.jdField_a_of_type_Arwj).b()) {
        arwj.a(this.jdField_a_of_type_Arwj).a();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        arwj.a(this.jdField_a_of_type_Arwj).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwl
 * JD-Core Version:    0.7.0.1
 */