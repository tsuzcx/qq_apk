package com.tencent.biz.qqcircle.fragments.person.control;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleRankListManager;
import com.tencent.biz.qqcircle.widgets.QCircleRankTagListView;
import com.tencent.biz.qqcircle.widgets.QCircleRankTagListView.OnQCircleRankTagListActionListener;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StExternalMedalWallInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;

public class QCirclePersonHeaderRankListControl
  extends QCircleBasePersonalHeaderControl
  implements QCircleRankTagListView.OnQCircleRankTagListActionListener
{
  private ViewStub a;
  private QCircleRankTagListView b;
  private Context c;
  private QCirclePersonHeaderRankListControl.QCirclePersonRankListBroadcastReceiver d;
  private FeedCloudMeta.StUser e;
  
  private void b()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[inflateRankTagListView] rank tag view stub should be not null.");
      return;
    }
    if (this.b == null) {
      this.b = ((QCircleRankTagListView)((ViewStub)localObject).inflate().findViewById(2131441844));
    }
    localObject = this.b;
    if ((localObject != null) && (((QCircleRankTagListView)localObject).getVisibility() == 8)) {
      this.b.setVisibility(0);
    }
  }
  
  private void b(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[updateRankListViewInfo] rank tag list view should not be null..");
      return;
    }
    ((QCircleRankTagListView)localObject).setOnQCircleRankTagListActionListener(this);
    if (paramStGetMainPageRsp == null) {
      localObject = null;
    } else {
      localObject = paramStGetMainPageRsp.user;
    }
    this.e = ((FeedCloudMeta.StUser)localObject);
    this.b.setData(paramStGetMainPageRsp);
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
  
  private Activity c()
  {
    Context localContext = this.c;
    if (!(localContext instanceof Activity))
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[getCurrentActivity] context not is activity type, not handler.");
      return null;
    }
    return (Activity)localContext;
  }
  
  private void d()
  {
    if (!QCirclePluginUtil.b(this.e))
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[registerRankSwitchPageReceiver] current not is owner page, not register receiver.");
      return;
    }
    Activity localActivity = c();
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
    this.d = new QCirclePersonHeaderRankListControl.QCirclePersonRankListBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_user_wearing_medal_update");
    localActivity.registerReceiver(this.d, localIntentFilter);
  }
  
  private void e()
  {
    if (!QCirclePluginUtil.b(this.e))
    {
      QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] current not is owner page, not unregister receiver.");
      return;
    }
    if (this.d == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[unregisterRankSwitchPageReceiver] broadcast receiver should not be null.");
      return;
    }
    Activity localActivity = c();
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
    QCircleRankTagListView localQCircleRankTagListView = this.b;
    if (localQCircleRankTagListView != null)
    {
      localQCircleRankTagListView.setOnQCircleRankTagListActionListener(null);
      this.b = null;
    }
    e();
    this.c = null;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = paramContext;
    this.a = ((ViewStub)paramView.findViewById(2131437534));
  }
  
  public void a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramStGetMainPageRsp != null) && (paramStGetMainPageRsp.medalWall != null))
    {
      if (!paramStGetMainPageRsp.medalWall.needShowEntrance.get())
      {
        QLog.d("RANK-QCirclePersonHeaderRankListControl", 1, "[bindData] current server obtain no show entrance.");
        return;
      }
      b();
      b(paramStGetMainPageRsp);
      d();
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderRankListControl
 * JD-Core Version:    0.7.0.1
 */