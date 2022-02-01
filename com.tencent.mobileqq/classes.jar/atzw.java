import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class atzw
  implements atuf
{
  atzw(atzu paramatzu) {}
  
  public View a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Atxa.a());
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    atzu.a(this.a, paramBoolean);
  }
  
  public boolean a()
  {
    if (this.a.jdField_a_of_type_Atuw != null) {
      return this.a.jdField_a_of_type_Atuw.b();
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Atux != null)) {
      this.a.jdField_a_of_type_Atux.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Atxa.e() == 10) {
        atvd.a(this.a.jdField_a_of_type_Atxa.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Atxa.d(), this);
      atzu.a(this.a, true);
      atzu.a(this.a);
      this.a.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzw
 * JD-Core Version:    0.7.0.1
 */