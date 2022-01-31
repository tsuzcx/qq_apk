import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

class aoov
  implements View.OnClickListener
{
  aoov(aoou paramaoou, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (apes)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Aoou.a.e = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Aoou.a.b.get(this.jdField_a_of_type_Aoou.a.e);
    if ((!apvb.a(paramView.c())) || (apvb.c(paramView.c())))
    {
      apue.d(paramView.c());
      this.jdField_a_of_type_Aoou.a.b.remove(this.jdField_a_of_type_Aoou.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Aoou.a);
      return;
    }
    aptv.a(2131692410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoov
 * JD-Core Version:    0.7.0.1
 */