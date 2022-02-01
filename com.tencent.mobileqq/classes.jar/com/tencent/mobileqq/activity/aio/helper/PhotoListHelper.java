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
import com.tencent.mobileqq.utils.QQTheme;
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
  Map<Integer, Intent> a = new HashMap();
  private final AIOContext b;
  private BaseChatPie c;
  
  PhotoListHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.bv();
    this.c = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  private void g()
  {
    PhotoListPanel localPhotoListPanel = j();
    if (localPhotoListPanel == null) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).bm();
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() == 4))
      {
        localPhotoListPanel.c();
        localPhotoListPanel.postDelayed(new PhotoListHelper.2(this, localPhotoListPanel), 2000L);
        localPhotoListPanel.a(this.c);
      }
    }
  }
  
  private void h()
  {
    Intent localIntent = this.b.b().getIntent();
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
      AIOPanelUtiles.a(this.b.b(), (SessionInfo)this.b.O(), localIntent);
      if (((ReceiptHelper)this.b.a(118)).a) {
        ((ReceiptHelper)this.b.a(118)).a();
      }
    }
  }
  
  private void i()
  {
    PhotoListPanel localPhotoListPanel = j();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.q();
    }
  }
  
  private PhotoListPanel j()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      return (PhotoListPanel)localBaseChatPie.bq().d(4);
    }
    return null;
  }
  
  public Intent a(int paramInt)
  {
    return (Intent)this.a.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if (QQTheme.isNowSimpleUI()) {
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && ((this.c.f.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (this.c.f.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.c.f.requestPermissions(new PhotoListHelper.1(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.a.put(Integer.valueOf(paramInt), paramIntent);
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
  
  public void b()
  {
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.c.q(24);
    int j = localFullScreenInputHelper.o();
    boolean bool = localFullScreenInputHelper.e();
    int i = 0;
    if (bool)
    {
      if (j >= 20)
      {
        QQToast.makeText(this.c.d.getApp(), 2131892578, 0).show(this.c.d.getApp().getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if ((this.c.ah.a == 1033) || (this.c.ah.a == 1034)) {
        i = 1;
      }
      ReplyHelper localReplyHelper = (ReplyHelper)this.c.q(119);
      if ((i == 0) && (!localReplyHelper.b()))
      {
        PlusPanelUtils.a(this.c.aX(), j);
        e();
        return;
      }
      localFullScreenInputHelper.b(true);
      return;
    }
    if (j > 0)
    {
      QQToast.makeText(this.c.d.getApp(), 2131892551, 0).show(this.c.d.getApp().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (d())
    {
      ReportController.b(this.c.d, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.c.d, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
    PlusPanelUtils.a(this.c.d, this.c.f, this.c.ah, null, new Intent(), null);
  }
  
  public void b(int paramInt)
  {
    this.a.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeSelectedPhotoData code=");
      localStringBuilder.append(paramInt);
      QLog.d("PhotoListHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    PhotoListPanel localPhotoListPanel = j();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.a(true);
      this.c.aw();
    }
  }
  
  public boolean d()
  {
    PhotoListPanel localPhotoListPanel = j();
    if (localPhotoListPanel != null)
    {
      localPhotoListPanel.h();
      return true;
    }
    return false;
  }
  
  public void e()
  {
    PhotoListPanel localPhotoListPanel = j();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.l();
    }
  }
  
  public int f()
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.c.bq().d(4);
    int j = 0;
    int i;
    if (localPhotoListPanel != null) {
      i = localPhotoListPanel.getSelectedPhotoCount();
    } else {
      i = 0;
    }
    if (localPhotoListPanel != null) {
      j = localPhotoListPanel.getSelectedVideoCount();
    }
    return i + j;
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
    PhotoListPanel localPhotoListPanel = j();
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
          if ((paramInt1 == 10004) && (4 != this.c.aR())) {
            this.b.a(4, false);
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
            i();
            return;
          }
          h();
          return;
        }
        b(this.c.d.hashCode());
        e();
        return;
      }
      g();
      return;
    }
    b(this.c.d.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PhotoListHelper
 * JD-Core Version:    0.7.0.1
 */