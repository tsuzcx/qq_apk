import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity.2;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity.2.1.1;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class aqpo
  implements EnterCallback
{
  public aqpo(ODLoadingActivity.2 param2) {}
  
  public void onCloseLoadingView()
  {
    ODLoadingActivity.a(this.a.this$0);
    this.a.this$0.finish();
    ODLoadingActivity.a(this.a.this$0).opType("onCloseLoadingView").report();
    aqmd.b("33669909");
  }
  
  public void onEnterComplete()
  {
    ODLoadingActivity.a(this.a.this$0).opType("onEnterComplete").report();
    aqmd.b("33669911");
  }
  
  public void onShowLoadingView(View paramView)
  {
    ODLoadingActivity.a(this.a.this$0, paramView);
    this.a.this$0.runOnUiThread(new ODLoadingActivity.2.1.1(this));
    ODLoadingActivity.a(this.a.this$0).opType("onShowLoadingView").report();
    aqmd.b("33669908");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqpo
 * JD-Core Version:    0.7.0.1
 */