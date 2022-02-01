import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atqf
  implements View.OnClickListener
{
  atqf(atqe paramatqe) {}
  
  public void onClick(View paramView)
  {
    Object localObject = atqe.a(this.a);
    String str = this.a.jdField_a_of_type_Atoo.k();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((atae)localObject).a(this.a.jdField_a_of_type_AndroidAppActivity, str, atqe.a(this.a))))
    {
      int i = atwt.b(this.a.jdField_a_of_type_Atoo.e());
      bcst.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      localObject = this.a.jdField_a_of_type_Atoo.a();
      if (localObject != null)
      {
        ((atnd)localObject).a();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqf
 * JD-Core Version:    0.7.0.1
 */