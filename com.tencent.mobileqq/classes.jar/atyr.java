import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atyr
  implements View.OnClickListener
{
  atyr(atyq paramatyq) {}
  
  public void onClick(View paramView)
  {
    Object localObject = atyq.a(this.a);
    String str = this.a.jdField_a_of_type_Atxa.k();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((atip)localObject).a(this.a.jdField_a_of_type_AndroidAppActivity, str, atyq.a(this.a))))
    {
      int i = aufd.b(this.a.jdField_a_of_type_Atxa.e());
      bdla.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      localObject = this.a.jdField_a_of_type_Atxa.a();
      if (localObject != null)
      {
        ((atvp)localObject).a();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyr
 * JD-Core Version:    0.7.0.1
 */