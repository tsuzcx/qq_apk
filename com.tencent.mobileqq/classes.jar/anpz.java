import android.widget.ListAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.HashMap;

public class anpz
  implements Runnable
{
  public anpz(QIMPtvTemplateProviderView paramQIMPtvTemplateProviderView, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.jdField_a_of_type_DovComQqImCaptureViewQIMPtvTemplateProviderView.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a.get(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureViewQIMPtvTemplateProviderView.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()));
    if (localGridView != null)
    {
      localListAdapter = localGridView.a();
      if ((localListAdapter instanceof QIMPtvTemplateAdapter))
      {
        i = ((QIMPtvTemplateAdapter)localListAdapter).a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        ((QIMPtvTemplateAdapter)localListAdapter).a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, i);
        localGridView.requestFocusFromTouch();
        localGridView.setFocusableInTouchMode(true);
        localGridView.setSelection(i);
        ((QIMPtvTemplateAdapter)localListAdapter).notifyDataSetChanged();
      }
    }
    while (!QLog.isColorLevel())
    {
      ListAdapter localListAdapter;
      int i;
      return;
    }
    QLog.d("PtvTemplateProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpz
 * JD-Core Version:    0.7.0.1
 */