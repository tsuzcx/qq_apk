import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

class bbfy
  implements View.OnClickListener
{
  bbfy(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    bbfs.a(this.a).findViewById(2131365328).setVisibility(0);
    bbfs.a(this.a).findViewById(2131365329).setVisibility(8);
    bbfs.a(this.a).a = false;
    bbfs.a(this.a).setImageResource(2130837507);
    bbfs.a(this.a).a(bbfs.a(this.a).a(), true);
    bbfs.a(this.a).notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfy
 * JD-Core Version:    0.7.0.1
 */