import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity.3;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity.3.1.1;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class awdt
  implements EnterCallback
{
  public awdt(ODLoadingActivity.3 param3) {}
  
  public void onCloseLoadingView()
  {
    ODLoadingActivity.b(this.a.this$0);
    this.a.this$0.finish();
    ODLoadingActivity.a(this.a.this$0).opType("onCloseLoadingView").report();
    awbj.b("33669909");
  }
  
  public void onEnterComplete()
  {
    ODLoadingActivity.a(this.a.this$0).opType("onEnterComplete").report();
    awbj.b("33669911");
  }
  
  public void onShowLoadingView(View paramView)
  {
    ODLoadingActivity.a(this.a.this$0, paramView);
    this.a.this$0.runOnUiThread(new ODLoadingActivity.3.1.1(this));
    ODLoadingActivity.a(this.a.this$0).opType("onShowLoadingView").report();
    awbj.b("33669908");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdt
 * JD-Core Version:    0.7.0.1
 */