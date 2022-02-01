package com.tencent.biz.qqcircle.immersive.personal.control;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.person.control.QCircleBasePersonalHeaderControl;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView.OnQFSRankTagListActionListener;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleRankListManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StExternalMedalWallInfo;
import java.util.List;

public class QFSPersonHeaderRankListControl
  extends QCircleBasePersonalHeaderControl
  implements QFSRankTagListView.OnQFSRankTagListActionListener
{
  private ViewStub a;
  private QFSRankTagListView b;
  private Context c;
  private QFSPersonHeaderRankListControl.QFSPersonRankListBroadcastReceiver d;
  private QFSPersonalInfo e;
  
  private void b()
  {
    QFSRankTagListView localQFSRankTagListView = this.b;
    if (localQFSRankTagListView == null)
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[updateRankListViewInfo] rank tag list view should not be null..");
      return;
    }
    localQFSRankTagListView.setOnQFSRankTagListActionListener(this);
    this.b.setData(this.e);
  }
  
  private void b(String paramString)
  {
    if (this.b == null)
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[handlerRankListBroadcastReceiverMsg] rank tag list view should not be null.");
      return;
    }
    List localList = QCircleRankListManager.parseUserMedalSource(paramString);
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, new Object[] { "[handlerRankListBroadcastReceiverMsg] json: ", paramString, " | bean list size: ", Integer.valueOf(i) });
    this.b.a(localList);
  }
  
  private void c()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ViewStub)localObject).getParent() == null))
    {
      if (this.b == null) {
        this.b = ((QFSRankTagListView)this.a.inflate().findViewById(2131442024));
      }
      localObject = this.b;
      if ((localObject != null) && (((QFSRankTagListView)localObject).getVisibility() == 8)) {
        this.b.setVisibility(0);
      }
      return;
    }
    QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[inflateRankTagListView] rank tag view stub should be not null.");
  }
  
  private Activity d()
  {
    Context localContext = this.c;
    if (!(localContext instanceof Activity))
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[getCurrentActivity] context not is activity type, not handler.");
      return null;
    }
    return (Activity)localContext;
  }
  
  private void e()
  {
    if (!QCirclePluginUtil.d(this.e.c))
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[registerRankSwitchPageReceiver] current not is owner page, not register receiver.");
      return;
    }
    Activity localActivity = d();
    if (localActivity == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[initRankSwitchPageReceiver] activity should not be null.");
      return;
    }
    if (localActivity.isFinishing())
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[initRankSwitchPageReceiver] activity not is finishing.");
      return;
    }
    this.d = new QFSPersonHeaderRankListControl.QFSPersonRankListBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_user_wearing_medal_update");
    localActivity.registerReceiver(this.d, localIntentFilter);
  }
  
  private void f()
  {
    if (!QCirclePluginUtil.d(this.e.c))
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] current not is owner page, not unregister receiver.");
      return;
    }
    if (this.d == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] broadcast receiver should not be null.");
      return;
    }
    Activity localActivity = d();
    if (localActivity == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] activity should not be null.");
      return;
    }
    QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] clear broadcast receiver.");
    localActivity.unregisterReceiver(this.d);
  }
  
  public void a()
  {
    QFSRankTagListView localQFSRankTagListView = this.b;
    if (localQFSRankTagListView != null)
    {
      localQFSRankTagListView.setOnQFSRankTagListActionListener(null);
      this.b = null;
    }
    f();
    this.c = null;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = paramContext;
    this.a = ((ViewStub)paramView.findViewById(2131437534));
  }
  
  public void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if ((paramQFSPersonalInfo != null) && (paramQFSPersonalInfo.F != null))
    {
      this.e = paramQFSPersonalInfo;
      if (!paramQFSPersonalInfo.F.needShowEntrance.get())
      {
        QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[bindData] current server obtain no show entrance.");
        return;
      }
      c();
      b();
      e();
      return;
    }
    QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[bindDataSource] bind data source is null.");
  }
  
  public void a(String paramString)
  {
    if (this.c == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[onRankTagSwitchClick] context should not be null.");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[onRankTagSwitchClick] current jump url not is empty.");
      return;
    }
    QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, new Object[] { "[onRankTagSwitchClick] jump url: ", paramString });
    QCircleLauncher.a(this.c, paramString, null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.control.QFSPersonHeaderRankListControl
 * JD-Core Version:    0.7.0.1
 */