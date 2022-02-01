import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asuk
  implements View.OnClickListener
{
  asuk(asuj paramasuj) {}
  
  public void onClick(View paramView)
  {
    Object localObject = asuj.a(this.a);
    String str = this.a.jdField_a_of_type_Asst.k();
    if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((asej)localObject).a(this.a.jdField_a_of_type_AndroidAppActivity, str, asuj.a(this.a))))
    {
      int i = ataw.b(this.a.jdField_a_of_type_Asst.e());
      bcef.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      localObject = this.a.jdField_a_of_type_Asst.a();
      if (localObject != null)
      {
        ((asri)localObject).a();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuk
 * JD-Core Version:    0.7.0.1
 */