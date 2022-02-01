package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.XPanelContainer;

public class TroopNotificationPanelProvider
  implements PanelProvider<View>
{
  private AIOContext a;
  
  public TroopNotificationPanelProvider(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void a()
  {
    Intent localIntent = new Intent(this.a.a(), QQBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
    Object localObject2 = localITroopLinkApi.getUrl("troop_homework_create_notice");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>";
    }
    localObject2 = new ITroopLinkApi.LinkParams();
    String str = this.a.a().a;
    ((ITroopLinkApi.LinkParams)localObject2).a = str;
    ((ITroopLinkApi.LinkParams)localObject2).c = "aio";
    ((ITroopLinkApi.LinkParams)localObject2).i = "";
    localIntent.putExtra("url", localITroopLinkApi.replaceParams((String)localObject1, (ITroopLinkApi.LinkParams)localObject2));
    this.a.a().startActivity(localIntent);
    this.a.a().overridePendingTransition(2130772342, 2130772004);
    TroopReportor.a(this.a.a(), str, "Grp_notice", "CreateNotice_Clk", 0, 0, new String[] { str, "", "", "" });
  }
  
  public View createPanel(Context paramContext)
  {
    return null;
  }
  
  public View getPanel()
  {
    return null;
  }
  
  public int getPanelId()
  {
    return 31;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    a();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.TroopNotificationPanelProvider
 * JD-Core Version:    0.7.0.1
 */