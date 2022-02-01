import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class asvu
  implements View.OnLongClickListener
{
  asvu(asvt paramasvt) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a.a.b();
    asvt.a(this.a, paramView);
    String str = this.a.a() + "(" + FileUtil.filesizeToString(this.a.a.c()) + ")";
    this.a.a(paramView, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvu
 * JD-Core Version:    0.7.0.1
 */