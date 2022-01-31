import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

class aqhy
  implements View.OnClickListener
{
  aqhy(aqhx paramaqhx, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (aqxu)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Aqhx.a.e = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Aqhx.a.b.get(this.jdField_a_of_type_Aqhx.a.e);
    if ((!arof.a(paramView.c())) || (arof.c(paramView.c())))
    {
      arni.d(paramView.c());
      this.jdField_a_of_type_Aqhx.a.b.remove(this.jdField_a_of_type_Aqhx.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Aqhx.a);
      return;
    }
    armz.a(2131692486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhy
 * JD-Core Version:    0.7.0.1
 */