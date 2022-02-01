import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class auab
  implements View.OnLongClickListener
{
  auab(auaa paramauaa) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a.a.b();
    auaa.a(this.a, paramView);
    String str = this.a.a() + "(" + FileUtil.filesizeToString(this.a.a.c()) + ")";
    this.a.a(paramView, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auab
 * JD-Core Version:    0.7.0.1
 */