package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class HotTroopFlashPicPanelProvider
  implements PanelProvider<PhotoListPanel>
{
  protected PhotoListPanel a;
  private AIOContext b;
  
  public HotTroopFlashPicPanelProvider(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  private boolean c()
  {
    Object localObject = this.b;
    if ((localObject instanceof HotChatContext))
    {
      localObject = ((AIOContext)localObject).a().getHotChatMng(true);
      boolean bool = ((HotChatManager)localObject).j();
      if (!((HotChatManager)localObject).j())
      {
        a();
        ReportController.b(this.b.a(), "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
      }
      return bool;
    }
    return false;
  }
  
  public PhotoListPanel a(Context paramContext)
  {
    if (!c()) {
      return null;
    }
    long l = System.currentTimeMillis();
    paramContext = ((PhotoListHelper)this.b.a(7)).a(this.b.hashCode());
    QQAppInterface localQQAppInterface = this.b.a();
    AIOContext localAIOContext = this.b;
    this.a = AIOPanelUtiles.a(localQQAppInterface, localAIOContext, localAIOContext.p().d().e(), this.b.C(), true, paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OpenFlashPicPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.a;
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.b.b(), 230);
    localQQCustomDialog.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.d(this.b.a())) }));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131903551), new HotTroopFlashPicPanelProvider.1(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131903545), new HotTroopFlashPicPanelProvider.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  public PhotoListPanel b()
  {
    return this.a;
  }
  
  public int getPanelId()
  {
    return 14;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(14);
    AIOPanelUtiles.a(this.b.a(), "0X8005977", this.b.O().a);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 14) && (paramInt1 != 14))
    {
      PhotoListPanel localPhotoListPanel = this.a;
      if (localPhotoListPanel != null) {
        localPhotoListPanel.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.HotTroopFlashPicPanelProvider
 * JD-Core Version:    0.7.0.1
 */