package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.LimitContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XPanelContainer;

public class HotPicPanelProvider
  implements ILifeCycleHelper, PanelProvider<HotPicMainPanel>
{
  public HotPicMainPanel a;
  private AIOContext b;
  
  public HotPicPanelProvider(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  public HotPicMainPanel a()
  {
    return this.a;
  }
  
  public HotPicMainPanel a(Context paramContext)
  {
    this.a = ((HotPicMainPanel)View.inflate(paramContext, 2131624103, null));
    HotPicMainPanel localHotPicMainPanel = this.a;
    QQAppInterface localQQAppInterface = this.b.a();
    AIOContext localAIOContext = this.b;
    localHotPicMainPanel.a(localQQAppInterface, paramContext, localAIOContext, localAIOContext.C(), this.b.q().d());
    return this.a;
  }
  
  public int getPanelId()
  {
    return 24;
  }
  
  @NonNull
  public String getTag()
  {
    return "HotPicPanelProvider";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 11 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 11)
    {
      if (paramInt != 15) {
        return;
      }
      if (this.a != null)
      {
        localObject = HotPicManager.a(this.b.a());
        if (localObject != null) {
          ((HotPicManager)localObject).a(false);
        }
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((HotPicMainPanel)localObject).e();
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 24)
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      this.a.a(bool);
    }
    if (paramInt2 == 24) {
      this.a.g();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    this.b.q().a(24, true);
    if ((this.b instanceof LimitContext))
    {
      this.a.setOnHotPicItemClickListener(new HotPicPanelProvider.SendGifListener(this));
      ReportController.b(this.b.a(), "dc00898", "", "", "0X80096AC", "0X80096AC", ((LimitContext)this.b).P(), 0, "", "", "", "");
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((this.b.C() != null) && (paramInt2 == 24)) {
      this.b.C().setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.HotPicPanelProvider
 * JD-Core Version:    0.7.0.1
 */