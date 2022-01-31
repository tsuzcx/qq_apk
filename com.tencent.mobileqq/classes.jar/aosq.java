import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aosq
  implements View.OnClickListener
{
  aosq(aosp paramaosp) {}
  
  public void onClick(View paramView)
  {
    Object localObject = apue.a((FileInfo)((aosr)paramView.getTag()).a);
    localObject = new apoe(aosp.a(this.a).app, aosp.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new apog(aosp.a(this.a), (apoj)localObject);
    ((apog)localObject).a(8);
    ((apog)localObject).a(xpx.a(paramView));
    ((apog)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosq
 * JD-Core Version:    0.7.0.1
 */