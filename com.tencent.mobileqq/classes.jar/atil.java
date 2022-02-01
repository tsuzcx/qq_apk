import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class atil
  implements View.OnClickListener
{
  atil(atik paramatik, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (atzi)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Atik.a.e = ((atzi)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_Atik.a.b.get(this.jdField_a_of_type_Atik.a.e);
    if ((!auog.a(((FileInfo)localObject).c())) || (auog.c(((FileInfo)localObject).c())))
    {
      aunj.d(((FileInfo)localObject).c());
      this.jdField_a_of_type_Atik.a.b.remove(this.jdField_a_of_type_Atik.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Atik.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      auna.a(2131692076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atil
 * JD-Core Version:    0.7.0.1
 */