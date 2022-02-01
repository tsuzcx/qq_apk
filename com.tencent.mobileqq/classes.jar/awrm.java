import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class awrm
  implements blih
{
  private int jdField_a_of_type_Int;
  
  awrm(awrk paramawrk) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.jdField_a_of_type_Int)
    {
      if (!awrk.a(this.jdField_a_of_type_Awrk).b()) {
        awrk.a(this.jdField_a_of_type_Awrk).a();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        awrk.a(this.jdField_a_of_type_Awrk).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrm
 * JD-Core Version:    0.7.0.1
 */