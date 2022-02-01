import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;

public class bbde
  implements View.OnClickListener
{
  public bbde(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    QLog.i("IceBreak.HotPic", 2, "onClick.");
    Object localObject = (aihq)paramView.getTag();
    if ((paramView instanceof CustomImgView))
    {
      URLImageView localURLImageView = (URLImageView)((CustomImgView)paramView).a;
      if ((localURLImageView.getDrawable() instanceof URLDrawable))
      {
        if (((URLDrawable)localURLImageView.getDrawable()).getStatus() != 1) {
          break label164;
        }
        AIOIceBreakView.a(this.a, (aihq)localObject);
      }
    }
    if (AIOIceBreakView.a(this.a) != null) {
      AIOIceBreakView.a(this.a).a(paramView);
    }
    if (AIOIceBreakView.a(this.a) >= 3) {}
    for (localObject = "2";; localObject = "1")
    {
      int i = bbdk.a(AIOIceBreakView.a(this.a), AIOIceBreakView.a(this.a).sessionInfo);
      bdla.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800B577", "0X800B577", i, 0, (String)localObject, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label164:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IceBreak.HotPic", 2, "onClick:URLDrawable status != successed");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbde
 * JD-Core Version:    0.7.0.1
 */