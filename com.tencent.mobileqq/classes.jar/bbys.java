import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.KDSearchHistoryFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

class bbys
  implements View.OnClickListener
{
  bbys(bbyl parambbyl) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (bbyl.a(this.a) != null)
    {
      KDSearchHistoryFlowLayout localKDSearchHistoryFlowLayout = bbyl.a(this.a);
      if (bbyl.a(this.a).a) {
        break label111;
      }
      bool = true;
      localKDSearchHistoryFlowLayout.a = bool;
      if (!bbyl.a(this.a).a) {
        break label116;
      }
      bbyl.a(this.a).setImageResource(2130846033);
    }
    for (;;)
    {
      bbyl.a(this.a).a(bbyl.a(this.a).a(), bbyl.a(this.a).a);
      bbyl.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label111:
      bool = false;
      break;
      label116:
      bbyl.a(this.a).setImageResource(2130846034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbys
 * JD-Core Version:    0.7.0.1
 */