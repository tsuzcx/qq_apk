import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class azge
  implements View.OnClickListener
{
  azge(azga paramazga) {}
  
  public final void onClick(View paramView)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a((Context)this.a.a(), 1, 2131718971, 0).a();
      this.a.a().a(1040);
      this.a.dismiss();
      azcl.a("0X800AF48", 0, null, null, 14, null);
      azcl.a("0X8009DE0", 1030, null, null, 12, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = this.a.a().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusManager");
    }
    localObject = (azbv)localObject;
    Intent localIntent = new Intent();
    if (azga.a(this.a) != null) {
      localIntent.putExtra("online_status_permission_item", (Serializable)azga.a(this.a));
    }
    if (!azga.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("from_modify", bool);
      if (QLog.isColorLevel()) {
        QLog.d("WeatherView", 2, new Object[] { "bindView: called. ", "needSwitchOnlineStatus: " + azga.a(this.a) });
      }
      ((azbv)localObject).b(8, localIntent);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azge
 * JD-Core Version:    0.7.0.1
 */