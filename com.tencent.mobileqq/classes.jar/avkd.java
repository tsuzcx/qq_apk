import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class avkd
  implements View.OnClickListener
{
  public avkd(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    UniteSearchActivity.e = 1;
    this.a.a.setText("");
    this.a.a();
    avsv.a(this.a.app, 0, this.a.c, "0X8009D2B", 0, 0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkd
 * JD-Core Version:    0.7.0.1
 */