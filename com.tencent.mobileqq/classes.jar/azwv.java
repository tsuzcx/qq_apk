import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;

public class azwv
  implements View.OnClickListener
{
  public azwv(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    QLog.i("IceBreak.HotPic", 2, "onClick.");
    URLImageView localURLImageView = (URLImageView)((CustomImgView)paramView).a;
    ahmw localahmw = (ahmw)paramView.getTag();
    if ((localURLImageView.getDrawable() instanceof URLDrawable))
    {
      if (((URLDrawable)localURLImageView.getDrawable()).getStatus() == 1) {
        AIOIceBreakView.a(this.a, localahmw);
      }
    }
    else if (abwz.a(AIOIceBreakView.a(this.a).sessionInfo.curType) != 1044) {
      if (AIOIceBreakView.a(this.a).sessionInfo.curType != 0) {
        break label179;
      }
    }
    for (;;)
    {
      bcef.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CB", "0X800A4CB", i, 0, "", "", "", "");
      if (AIOIceBreakView.a(this.a) != null) {
        AIOIceBreakView.a(this.a).a(localURLImageView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IceBreak.HotPic", 2, "onClick:URLDrawable status != successed");
      break;
      label179:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwv
 * JD-Core Version:    0.7.0.1
 */