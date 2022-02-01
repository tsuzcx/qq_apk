import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhjj
  implements View.OnClickListener
{
  public bhjj(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void onClick(View paramView)
  {
    LiangHaoBuyFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjj
 * JD-Core Version:    0.7.0.1
 */