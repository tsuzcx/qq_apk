import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bmsn
  implements View.OnClickListener
{
  bmsn(bmsl parambmsl) {}
  
  public void onClick(View paramView)
  {
    bmsl.a(this.a);
    if ((bmsl.a(this.a) != null) && (bmsl.a(this.a).a() != null) && (bmsl.a(this.a).a().app != null) && (bmsl.a(this.a) != null)) {
      bmsk.a(bmsl.a(this.a).a().app, 122, String.valueOf(bmsl.a(this.a).iAdId.get()), bmsl.a(this.a).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsn
 * JD-Core Version:    0.7.0.1
 */