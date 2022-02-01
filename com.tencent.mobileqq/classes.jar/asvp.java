import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class asvp
  implements aspy
{
  asvp(asvn paramasvn) {}
  
  public View a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Asst.a());
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    asvn.a(this.a, paramBoolean);
  }
  
  public boolean a()
  {
    if (this.a.jdField_a_of_type_Asqp != null) {
      return this.a.jdField_a_of_type_Asqp.b();
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Asqq != null)) {
      this.a.jdField_a_of_type_Asqq.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Asst.e() == 10) {
        asqw.a(this.a.jdField_a_of_type_Asst.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Asst.d(), this);
      asvn.a(this.a, true);
      asvn.a(this.a);
      this.a.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvp
 * JD-Core Version:    0.7.0.1
 */