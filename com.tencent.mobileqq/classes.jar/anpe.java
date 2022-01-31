import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.view.MusicProviderView;

public class anpe
  implements Runnable
{
  public anpe(MusicProviderView paramMusicProviderView, int paramInt) {}
  
  public void run()
  {
    GridView localGridView = this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.a(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "position= " + this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    }
    if (localGridView != null) {
      localGridView.setSelection(this.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MusicProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */