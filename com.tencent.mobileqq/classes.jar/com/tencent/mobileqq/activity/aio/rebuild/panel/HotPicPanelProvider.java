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
  private AIOContext a;
  public HotPicMainPanel a;
  
  public HotPicPanelProvider(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public HotPicMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  }
  
  public HotPicMainPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = ((HotPicMainPanel)View.inflate(paramContext, 2131558547, null));
    HotPicMainPanel localHotPicMainPanel = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    localHotPicMainPanel.a(localQQAppInterface, paramContext, localAIOContext, localAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a());
    return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
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
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
      {
        localObject = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
        if (localObject != null) {
          ((HotPicManager)localObject).a(false);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
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
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(bool);
    }
    if (paramInt2 == 24) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.f();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(24, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext instanceof LimitContext))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.setOnHotPicItemClickListener(new HotPicPanelProvider.SendGifListener(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "dc00898", "", "", "0X80096AC", "0X80096AC", ((LimitContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f(), 0, "", "", "", "");
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null) && (paramInt2 == 24)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.HotPicPanelProvider
 * JD-Core Version:    0.7.0.1
 */