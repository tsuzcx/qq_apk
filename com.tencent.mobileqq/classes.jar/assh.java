import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class assh
  implements View.OnClickListener
{
  assh(assg paramassg, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (atho)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Assg.a.e = ((atho)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_Assg.a.b.get(this.jdField_a_of_type_Assg.a.e);
    if ((!atwl.a(((FileInfo)localObject).c())) || (atwl.c(((FileInfo)localObject).c())))
    {
      atvo.d(((FileInfo)localObject).c());
      this.jdField_a_of_type_Assg.a.b.remove(this.jdField_a_of_type_Assg.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Assg.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      atvf.a(2131692071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assh
 * JD-Core Version:    0.7.0.1
 */