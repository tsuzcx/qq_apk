import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.BaseApplication;

public class asmj
  implements View.OnClickListener
{
  public asmj(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = "";
    if (this.a.a != null) {
      localObject = this.a.a(this.a.a.getCurrentItem());
    }
    aahi.a(akwd.a(), "769", "205037", (String)localObject, "76901", "1", "160", new String[] { this.a.a(), "", "20" });
    localObject = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
    ((Intent)localObject).putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_games");
    paramView.getContext().startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmj
 * JD-Core Version:    0.7.0.1
 */