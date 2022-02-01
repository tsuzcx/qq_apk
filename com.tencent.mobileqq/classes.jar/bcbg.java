import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcbg
  implements View.OnClickListener
{
  public bcbg(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("keyword", this.a.f);
    this.a.setResult(2, localIntent);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbg
 * JD-Core Version:    0.7.0.1
 */