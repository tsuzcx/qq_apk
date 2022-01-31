import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

class aqmh
  implements View.OnClickListener
{
  aqmh(aqmg paramaqmg, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (arcd)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Aqmg.a.e = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Aqmg.a.b.get(this.jdField_a_of_type_Aqmg.a.e);
    if ((!arso.a(paramView.c())) || (arso.c(paramView.c())))
    {
      arrr.d(paramView.c());
      this.jdField_a_of_type_Aqmg.a.b.remove(this.jdField_a_of_type_Aqmg.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Aqmg.a);
      return;
    }
    arri.a(2131692487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmh
 * JD-Core Version:    0.7.0.1
 */