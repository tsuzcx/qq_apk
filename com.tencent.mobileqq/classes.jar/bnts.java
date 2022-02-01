import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bnts
  implements View.OnClickListener
{
  bnts(bntq parambntq) {}
  
  public void onClick(View paramView)
  {
    bntq.a(this.a);
    if ((bntq.a(this.a) != null) && (bntq.a(this.a).a() != null) && (bntq.a(this.a).a().app != null) && (bntq.a(this.a) != null)) {
      bntp.a(bntq.a(this.a).a().app, 122, String.valueOf(bntq.a(this.a).iAdId.get()), bntq.a(this.a).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnts
 * JD-Core Version:    0.7.0.1
 */