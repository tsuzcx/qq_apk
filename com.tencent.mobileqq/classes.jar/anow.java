import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;
import dov.com.qq.im.capture.view.ComboProviderView;

public class anow
  implements Runnable
{
  public anow(ComboProviderView paramComboProviderView, int paramInt) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.jdField_a_of_type_DovComQqImCaptureViewComboProviderView.a.a.get(this.jdField_a_of_type_DovComQqImCaptureViewComboProviderView.b());
    if (localGridView != null)
    {
      localGridView.setSelection(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("ComboProviderView", 2, "positon= " + this.jdField_a_of_type_Int);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ComboProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anow
 * JD-Core Version:    0.7.0.1
 */