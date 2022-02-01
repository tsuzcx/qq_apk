import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbgd
  implements View.OnClickListener
{
  bbgd(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    bbfs localbbfs = this.a;
    boolean bool;
    if (!bbfs.a(this.a))
    {
      bool = true;
      bbfs.a(localbbfs, bool);
      if (!bbfs.a(this.a)) {
        break label110;
      }
      bbfs.a(this.a);
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putBoolean(this.a.a.getCurrentAccountUin() + "QQ_SEARCH_HIDE_HOTLIST", bbfs.a(this.a)).commit();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label110:
      bbfs.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgd
 * JD-Core Version:    0.7.0.1
 */