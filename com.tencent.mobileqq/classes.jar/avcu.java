import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avcu
  implements View.OnClickListener
{
  public avcu(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGamePubAccountFragment.a(this.a) != null)
    {
      QQGamePubAccountFragment.a(this.a).scrollToPosition(0);
      QQGamePubAccountFragment.a(this.a).setVisibility(8);
      if (QQGamePubAccountFragment.a(this.a) != null) {
        QQGamePubAccountFragment.a(this.a).setCurrentItem(0);
      }
    }
    String str = (String)QQGamePubAccountFragment.a(this.a).getTag();
    abuf.a(amwn.a(), "769", "205031", "", "76901", "1", "160", new String[] { str, "", "20" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcu
 * JD-Core Version:    0.7.0.1
 */