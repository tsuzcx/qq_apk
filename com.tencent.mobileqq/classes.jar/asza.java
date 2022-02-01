import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class asza
  implements View.OnClickListener
{
  asza(asyz paramasyz, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (atpy)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Asyz.a.e = ((atpy)localObject).a;
    localObject = (FileInfo)this.jdField_a_of_type_Asyz.a.b.get(this.jdField_a_of_type_Asyz.a.e);
    if ((!FileUtil.isFileExists(((FileInfo)localObject).c())) || (FileUtil.deleteFile(((FileInfo)localObject).c())))
    {
      auea.d(((FileInfo)localObject).c());
      this.jdField_a_of_type_Asyz.a.b.remove(this.jdField_a_of_type_Asyz.a.e);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Asyz.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      audr.a(2131692214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asza
 * JD-Core Version:    0.7.0.1
 */