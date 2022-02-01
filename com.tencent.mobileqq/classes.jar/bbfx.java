import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.KDSearchHistoryFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

class bbfx
  implements View.OnClickListener
{
  bbfx(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (bbfs.a(this.a) != null)
    {
      KDSearchHistoryFlowLayout localKDSearchHistoryFlowLayout = bbfs.a(this.a);
      if (bbfs.a(this.a).a) {
        break label111;
      }
      bool = true;
      localKDSearchHistoryFlowLayout.a = bool;
      if (!bbfs.a(this.a).a) {
        break label116;
      }
      bbfs.a(this.a).setImageResource(2130846018);
    }
    for (;;)
    {
      bbfs.a(this.a).a(bbfs.a(this.a).a(), bbfs.a(this.a).a);
      bbfs.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label111:
      bool = false;
      break;
      label116:
      bbfs.a(this.a).setImageResource(2130846019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfx
 * JD-Core Version:    0.7.0.1
 */