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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class PhotoListPanelProvider
  implements PanelProvider<PhotoListPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PhotoListHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperPhotoListHelper;
  private PhotoListPanel.BottomBtnClickListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener = null;
  private PhotoListPanel.ImageCountChangedListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener = null;
  private PhotoListPanel.ImageSentListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = null;
  private PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PhotoListPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperPhotoListHelper = ((PhotoListHelper)paramBaseChatPie.a(7));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 4) && (paramInt2 != 4))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      if (localObject != null)
      {
        ((PhotoListPanel)localObject).a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
        }
      }
    }
    if ((paramInt2 == 4) && (paramInt1 != 4))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      if (localObject != null)
      {
        ((PhotoListPanel)localObject).c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) && (!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).a))
        {
          localObject = new ArrayList();
          localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(TextUtils.isEmpty((CharSequence)localObject) ^ true);
        }
      }
    }
  }
  
  private void a(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    if (paramDeviceMsgChatPie.J) {
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
    }
  }
  
  private void a(XPanelContainer paramXPanelContainer)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestPermissions(new PhotoListPanelProvider.4(this, paramXPanelContainer), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b(paramXPanelContainer);
  }
  
  private void b(XPanelContainer paramXPanelContainer)
  {
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(24);
    boolean bool = localFullScreenInputHelper.c();
    int j = localFullScreenInputHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPhotoListAction fullStatus:");
      localStringBuilder.append(bool);
      localStringBuilder.append(", cnt:");
      localStringBuilder.append(j);
      QLog.d("PhotoListPanelProvider", 2, localStringBuilder.toString());
    }
    int i = 0;
    if (bool)
    {
      if (j >= 20)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694875, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1034)) {
        i = 1;
      }
      paramXPanelContainer = (ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(119);
      if ((i == 0) && (!paramXPanelContainer.a()))
      {
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), j);
        paramXPanelContainer = (PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(7);
        if (paramXPanelContainer != null) {
          paramXPanelContainer.d();
        }
      }
      else
      {
        localFullScreenInputHelper.a(true);
      }
    }
    else
    {
      if (j > 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694848, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        return;
      }
      paramXPanelContainer.a(4);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  public PhotoListPanel a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperPhotoListHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a();
    localObject1 = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), (InputBarUI)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, (Intent)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener = new PhotoListPanelProvider.1(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener = new PhotoListPanelProvider.2(this);
    }
    ((PhotoListPanel)localObject1).setImageCountChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener);
    ((PhotoListPanel)localObject1).setCustomOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener);
    a(((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).a);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = new PhotoListPanelProvider.3(this);
    ((PhotoListPanel)localObject1).setImageSentListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = a();
    AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  }
  
  public void a(boolean paramBoolean)
  {
    PhotoListPanel localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    if (localPhotoListPanel == null) {
      return;
    }
    localPhotoListPanel.setReceiptMode(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new PhotoListPanelProvider.5(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
  }
  
  public PhotoListPanel b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
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
    if (4 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c())
    {
      PhotoListPanel localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof DeviceMsgChatPie)) {
      a((DeviceMsgChatPie)localBaseChatPie);
    }
    a(paramXPanelContainer);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider
 * JD-Core Version:    0.7.0.1
 */