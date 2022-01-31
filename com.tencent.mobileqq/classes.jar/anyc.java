import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

class anyc
  implements View.OnClickListener
{
  anyc(anyb paramanyb, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (aonx)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Anyb.a.e = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Anyb.a.b.get(this.jdField_a_of_type_Anyb.a.e);
    if ((!apdh.a(paramView.c())) || (apdh.c(paramView.c())))
    {
      apck.d(paramView.c());
      this.jdField_a_of_type_Anyb.a.b.remove(this.jdField_a_of_type_Anyb.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Anyb.a);
      return;
    }
    apcb.a(2131626809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyc
 * JD-Core Version:    0.7.0.1
 */