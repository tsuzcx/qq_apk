import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aruu
  implements View.OnClickListener
{
  aruu(arut paramarut, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (asls)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Arut.a.e = ((asls)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_Arut.a.b.get(this.jdField_a_of_type_Arut.a.e);
    if ((!FileUtil.isFileExists(((FileInfo)localObject).c())) || (FileUtil.deleteFile(((FileInfo)localObject).c())))
    {
      aszt.d(((FileInfo)localObject).c());
      this.jdField_a_of_type_Arut.a.b.remove(this.jdField_a_of_type_Arut.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Arut.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aszk.a(2131692124);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruu
 * JD-Core Version:    0.7.0.1
 */