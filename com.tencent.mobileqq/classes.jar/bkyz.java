import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bkyz
  implements View.OnClickListener
{
  bkyz(bkyx parambkyx) {}
  
  public void onClick(View paramView)
  {
    bkyx.a(this.a);
    if ((bkyx.a(this.a) != null) && (bkyx.a(this.a).a() != null) && (bkyx.a(this.a).a().app != null) && (bkyx.a(this.a) != null)) {
      bkyw.a(bkyx.a(this.a).a().app, 122, String.valueOf(bkyx.a(this.a).iAdId.get()), bkyx.a(this.a).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyz
 * JD-Core Version:    0.7.0.1
 */