package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageCountChangedListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageSentListener;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  PhotoListPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperPhotoListHelper = ((PhotoListHelper)paramBaseChatPie.a(7));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
      }
    }
    PhotoListPanel localPhotoListPanel;
    if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.F))
      {
        Object localObject = new ArrayList();
        localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
        localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label227;
        }
      }
    }
    for (;;)
    {
      localPhotoListPanel.setMixedMsgMode(bool);
      return;
      label227:
      bool = false;
    }
  }
  
  private void a(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    if (paramDeviceMsgChatPie.T) {
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
    }
  }
  
  private void a(XPanelContainer paramXPanelContainer)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestPermissions(new PhotoListPanelProvider.4(this, paramXPanelContainer), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        b(paramXPanelContainer);
        return;
        i = 1;
      }
    }
  }
  
  private void b(XPanelContainer paramXPanelContainer)
  {
    int i = 0;
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(24);
    boolean bool = localFullScreenInputHelper.b();
    int j = localFullScreenInputHelper.a();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelProvider", 2, "doPhotoListAction fullStatus:" + bool + ", cnt:" + j);
    }
    if (bool)
    {
      if (j >= 20) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694886, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      }
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1034)) {
          i = 1;
        }
        if ((i != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.m()))
        {
          localFullScreenInputHelper.a(true);
          return;
        }
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), j);
        paramXPanelContainer = (PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(7);
      } while (paramXPanelContainer == null);
      paramXPanelContainer.d();
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694861, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    paramXPanelContainer.a(4);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public PhotoListPanel a()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperPhotoListHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    localObject = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, (Intent)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener = new PhotoListPanelProvider.1(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener = new PhotoListPanelProvider.2(this);
    }
    ((PhotoListPanel)localObject).setImageCountChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener);
    ((PhotoListPanel)localObject).setCustomOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$BottomBtnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = new PhotoListPanelProvider.3(this);
    ((PhotoListPanel)localObject).setImageSentListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l));
    }
    return localObject;
  }
  
  public PhotoListPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = a();
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
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
    if ((4 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DeviceMsgChatPie)) {
      a((DeviceMsgChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    a(paramXPanelContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider
 * JD-Core Version:    0.7.0.1
 */