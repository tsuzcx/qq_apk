import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bjzw
  implements View.OnClickListener
{
  bjzw(bjzu parambjzu) {}
  
  public void onClick(View paramView)
  {
    bjzu.a(this.a);
    if ((bjzu.a(this.a) != null) && (bjzu.a(this.a).a() != null) && (bjzu.a(this.a).a().app != null) && (bjzu.a(this.a) != null)) {
      bjzt.a(bjzu.a(this.a).a().app, 122, String.valueOf(bjzu.a(this.a).iAdId.get()), bjzu.a(this.a).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzw
 * JD-Core Version:    0.7.0.1
 */