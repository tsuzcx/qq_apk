package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhotoListHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  Map<Integer, Intent> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  PhotoListHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  private PhotoListPanel a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return (PhotoListPanel)localBaseChatPie.a().b(4);
    }
    return null;
  }
  
  private void e()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).a();
      if ((localObject != null) && (((XPanelContainer)localObject).a() == 4))
      {
        localPhotoListPanel.b();
        localPhotoListPanel.postDelayed(new PhotoListHelper.2(this, localPhotoListPanel), 2000L);
        localPhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
  }
  
  private void f()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getIntent();
    if (localIntent == null)
    {
      QLog.e("PhotoListHelper", 1, "onShow: intent == null");
      return;
    }
    boolean bool = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow, isPhotoPlusEditSend = ");
      localStringBuilder.append(bool);
      QLog.d("PhotoListHelper", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      localIntent.removeExtra("PhotoConst.SEND_FLAG");
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localIntent);
      if (((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).a) {
        ((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).a();
      }
    }
  }
  
  private void g()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.m();
    }
  }
  
  public int a()
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().b(4);
    int j = 0;
    int i;
    if (localPhotoListPanel != null) {
      i = localPhotoListPanel.b();
    } else {
      i = 0;
    }
    if (localPhotoListPanel != null) {
      j = localPhotoListPanel.c();
    }
    return i + j;
  }
  
  public Intent a(int paramInt)
  {
    return (Intent)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new PhotoListHelper.1(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeSelectedPhotoData code=");
      localStringBuilder.append(paramInt);
      QLog.d("PhotoListHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIntent);
    if (QLog.isColorLevel())
    {
      if (paramIntent == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("setSelectedPhotoData null, code=");
        paramIntent.append(paramInt);
        QLog.d("PhotoListHelper", 2, paramIntent.toString());
        return;
      }
      if (paramIntent.hasExtra("PhotoConst.SELECTED_PATHS"))
      {
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelectedPhotoData checked size=");
        int j = 0;
        int i;
        if (localArrayList == null) {
          i = 0;
        } else {
          i = localArrayList.size();
        }
        localStringBuilder.append(i);
        localStringBuilder.append(",checkedIndex size=");
        if (paramIntent == null) {
          i = j;
        } else {
          i = paramIntent.size();
        }
        localStringBuilder.append(i);
        localStringBuilder.append(", code=");
        localStringBuilder.append(paramInt);
        QLog.d("PhotoListHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.f();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(24);
    int j = localFullScreenInputHelper.b();
    boolean bool = localFullScreenInputHelper.c();
    int i = 0;
    if (bool)
    {
      if (j >= 20)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694875, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1034)) {
        i = 1;
      }
      ReplyHelper localReplyHelper = (ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(119);
      if ((i == 0) && (!localReplyHelper.a()))
      {
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), j);
        d();
        return;
      }
      localFullScreenInputHelper.a(true);
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694848, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, new Intent(), null);
  }
  
  public void c()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.Q();
    }
  }
  
  public void d()
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.h();
    }
  }
  
  public String getTag()
  {
    return "PhotoListHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 11, 7, 10 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = a();
    if (localPhotoListPanel != null)
    {
      if (paramInt2 == -1) {
        switch (paramInt1)
        {
        case 10007: 
        default: 
          break;
        case 10004: 
        case 10005: 
        case 10006: 
        case 10008: 
        case 10009: 
          localPhotoListPanel.a(paramInt1, paramIntent);
          if ((paramInt1 == 10004) && (4 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c())) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4, false);
          }
          break;
        }
      }
      localPhotoListPanel.setLastRequestCode(paramInt1);
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 15)
        {
          if (paramInt != 10)
          {
            if (paramInt != 11) {
              return;
            }
            g();
            return;
          }
          f();
          return;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.hashCode());
        d();
        return;
      }
      e();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PhotoListHelper
 * JD-Core Version:    0.7.0.1
 */