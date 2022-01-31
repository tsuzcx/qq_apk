import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;

public class aqsh
  implements View.OnClickListener
{
  public aqsh(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGamePubAccountFragment.a(this.a) != null)
    {
      QQGamePubAccountFragment.a(this.a).scrollToPosition(0);
      QQGamePubAccountFragment.a(this.a).setVisibility(8);
      if (this.a.a != null) {
        this.a.a.setCurrentItem(0);
      }
    }
    paramView = (String)QQGamePubAccountFragment.a(this.a).getTag();
    yod.a(ajae.a(), "769", "205031", "", "76901", "1", "160", new String[] { paramView, "", "20" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsh
 * JD-Core Version:    0.7.0.1
 */