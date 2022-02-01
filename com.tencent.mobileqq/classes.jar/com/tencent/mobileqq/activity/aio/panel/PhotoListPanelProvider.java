package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageCountChangedListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageSentListener;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class PhotoListPanelProvider
  implements PanelProvider<PhotoListPanel>
{
  private BaseChatPie a;
  private final QQAppInterface b;
  private PhotoListPanel c;
  private PhotoListHelper d;
  private PhotoListPanel.BottomBtnClickListener e = null;
  private PhotoListPanel.ImageSentListener f = null;
  private PhotoListPanel.ImageCountChangedListener g = null;
  
  public PhotoListPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.d;
    this.d = ((PhotoListHelper)paramBaseChatPie.q(7));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 4) && (paramInt2 != 4))
    {
      localObject = this.c;
      if (localObject != null)
      {
        ((PhotoListPanel)localObject).a(false);
        this.c.a(1019);
        if ((this.a.ah.a == 1) || (this.a.ah.a == 3000) || (this.a.ah.a == 0)) {
          this.c.setMixedMsgMode(false);
        }
      }
    }
    if ((paramInt2 == 4) && (paramInt1 != 4) && (this.c != null))
    {
      paramInt1 = PlusPanelUtils.a(this.a.ah);
      this.c.setMediaFileFilter(paramInt1);
      this.c.d();
      this.c.a(false);
      this.c.c();
      if (((this.a.ah.a == 1) || (this.a.ah.a == 3000) || (this.a.ah.a == 0)) && (!((ReceiptHelper)this.a.q(118)).a))
      {
        localObject = new ArrayList();
        localObject = AtTroopMemberSpan.a(this.a.Y.getEditableText(), (ArrayList)localObject);
        this.c.setMixedMsgMode(TextUtils.isEmpty((CharSequence)localObject) ^ true);
      }
    }
  }
  
  private void a(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    if (paramDeviceMsgChatPie.bu) {
      PlusPanelUtils.a(this.b, this.a.aX(), this.a.ah, null, null);
    }
  }
  
  private void a(XPanelContainer paramXPanelContainer)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && ((this.a.aX().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (this.a.aX().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.a.aX().requestPermissions(new PhotoListPanelProvider.4(this, paramXPanelContainer), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b(paramXPanelContainer);
  }
  
  private void b(XPanelContainer paramXPanelContainer)
  {
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.a.q(24);
    boolean bool = localFullScreenInputHelper.e();
    int j = localFullScreenInputHelper.o();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPhotoListAction fullStatus:");
      localStringBuilder.append(bool);
      localStringBuilder.append(", cnt:");
      localStringBuilder.append(j);
      QLog.d("PhotoListPanelProvider", 2, localStringBuilder.toString());
    }
    if (QQTheme.isNowSimpleUI())
    {
      if (bool) {
        PlusPanelUtils.a(this.a.aX(), j);
      } else {
        PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, null, new Intent(), null);
      }
      AIOPanelUtiles.a(this.b, "0X8004079", this.a.ah.a);
      return;
    }
    int i = 0;
    if (bool)
    {
      if (j >= 20)
      {
        QQToast.makeText(this.b.getApp(), 2131892578, 0).show(this.a.A());
        return;
      }
      if ((this.a.ah.a == 1033) || (this.a.ah.a == 1034)) {
        i = 1;
      }
      paramXPanelContainer = (ReplyHelper)this.a.q(119);
      if ((i == 0) && (!paramXPanelContainer.b()))
      {
        PlusPanelUtils.a(this.a.aX(), j);
        paramXPanelContainer = (PhotoListHelper)this.a.q(7);
        if (paramXPanelContainer != null) {
          paramXPanelContainer.e();
        }
      }
      else
      {
        localFullScreenInputHelper.b(true);
      }
    }
    else
    {
      if (j > 0)
      {
        QQToast.makeText(this.b.getApp(), 2131892551, 0).show(this.a.A());
        return;
      }
      paramXPanelContainer.a(4);
      AIOPanelUtiles.a(this.b, "0X8004079", this.a.ah.a);
    }
  }
  
  public PhotoListPanel a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.d.a(this.a.hashCode());
    Object localObject2 = this.a.bv().p().d().e();
    localObject1 = AIOPanelUtiles.a(this.a.d, this.a.bv(), (InputBarUI)localObject2, this.a.W, false, (Intent)localObject1);
    if (this.g == null) {
      this.g = new PhotoListPanelProvider.1(this);
    }
    if (this.e == null) {
      this.e = new PhotoListPanelProvider.2(this);
    }
    ((PhotoListPanel)localObject1).setImageCountChangedListener(this.g);
    ((PhotoListPanel)localObject1).setCustomOnClickListener(this.e);
    a(((ReceiptHelper)this.a.q(118)).a);
    this.f = new PhotoListPanelProvider.3(this);
    ((PhotoListPanel)localObject1).setImageSentListener(this.f);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OpenPhotolistPanel:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public PhotoListPanel a(Context paramContext)
  {
    this.c = a();
    AIODtReportHelper.a(this.c);
    return this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    PhotoListPanel localPhotoListPanel = this.c;
    if (localPhotoListPanel == null) {
      return;
    }
    localPhotoListPanel.setReceiptMode(paramBoolean, this.b);
    if (paramBoolean)
    {
      this.c.setSelectLimitListener(new PhotoListPanelProvider.5(this));
      return;
    }
    this.c.setSelectLimitListener(null);
  }
  
  public PhotoListPanel b()
  {
    return this.c;
  }
  
  public int getPanelId()
  {
    return 4;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    if (4 == this.a.aR())
    {
      PhotoListPanel localPhotoListPanel = this.c;
      if (localPhotoListPanel != null) {
        localPhotoListPanel.a(false);
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie instanceof DeviceMsgChatPie)) {
      a((DeviceMsgChatPie)localBaseChatPie);
    }
    a(paramXPanelContainer);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider
 * JD-Core Version:    0.7.0.1
 */