import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auia
  implements View.OnClickListener
{
  auia(auhz paramauhz) {}
  
  public void onClick(View paramView)
  {
    Object localObject = auhz.a(this.a);
    String str = this.a.jdField_a_of_type_Augj.k();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((atrz)localObject).a(this.a.jdField_a_of_type_AndroidAppActivity, str, auhz.a(this.a))))
    {
      int i = auoo.b(this.a.jdField_a_of_type_Augj.e());
      bdll.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      localObject = this.a.jdField_a_of_type_Augj.a();
      if (localObject != null)
      {
        ((auey)localObject).a();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auia
 * JD-Core Version:    0.7.0.1
 */