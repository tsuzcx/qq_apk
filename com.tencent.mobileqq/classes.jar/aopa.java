import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

class aopa
  implements View.OnClickListener
{
  aopa(aooz paramaooz, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (apew)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Aooz.a.e = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Aooz.a.b.get(this.jdField_a_of_type_Aooz.a.e);
    if ((!apvd.a(paramView.c())) || (apvd.c(paramView.c())))
    {
      apug.d(paramView.c());
      this.jdField_a_of_type_Aooz.a.b.remove(this.jdField_a_of_type_Aooz.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Aooz.a);
      return;
    }
    aptx.a(2131692410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aopa
 * JD-Core Version:    0.7.0.1
 */