import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bmkz
  implements View.OnClickListener
{
  bmkz(bmkx parambmkx) {}
  
  public void onClick(View paramView)
  {
    bmkx.a(this.a);
    if ((bmkx.a(this.a) != null) && (bmkx.a(this.a).a() != null) && (bmkx.a(this.a).a().app != null) && (bmkx.a(this.a) != null)) {
      bmkw.a(bmkx.a(this.a).a().app, 122, String.valueOf(bmkx.a(this.a).iAdId.get()), bmkx.a(this.a).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkz
 * JD-Core Version:    0.7.0.1
 */