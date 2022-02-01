import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.debug.VasAdvDebugFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/debug/VasAdvDebugFragment$initView$1$2"}, k=3, mv={1, 1, 16})
public final class arzc
  implements View.OnClickListener
{
  public arzc(VasAdvDebugFragment paramVasAdvDebugFragment) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "http://imgcache.qq.com/club/mTools/webview.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
    this.a.getActivity().startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzc
 * JD-Core Version:    0.7.0.1
 */