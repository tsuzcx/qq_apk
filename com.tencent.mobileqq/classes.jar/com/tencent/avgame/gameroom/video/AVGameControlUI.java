package com.tencent.avgame.gameroom.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppActivity;

public abstract class AVGameControlUI
  implements View.OnClickListener, IAVControlUiPresenter
{
  protected final String a;
  int b = 0;
  WeakReference<Context> c = null;
  Resources d = null;
  ViewGroup e = null;
  boolean f = false;
  protected AVGameAppInterface g;
  protected AVGameVideoLayer h;
  protected IGameRoomPresenter i;
  
  public AVGameControlUI(AVGameAppInterface paramAVGameAppInterface, QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(QQAudioHelper.d());
    this.a = localStringBuilder.toString();
    this.g = paramAVGameAppInterface;
    this.c = new WeakReference(paramQBaseActivity);
    this.e = paramViewGroup;
    paramAVGameAppInterface = a();
    if (paramAVGameAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "AVGameControlUI-->can not get AVActivity");
      }
      return;
    }
    this.d = paramAVGameAppInterface.getResources();
    if (this.d == null)
    {
      AVLog.printAllUserLog(this.a, "mRes is null. exit video progress");
      paramQBaseActivity = new StringBuilder();
      paramQBaseActivity.append(paramAVGameAppInterface.getString(2131917844));
      paramQBaseActivity.append(" 0x08");
      paramQBaseActivity = paramQBaseActivity.toString();
      Toast.makeText(paramAVGameAppInterface.getApplicationContext(), paramQBaseActivity, 0).show();
      paramAVGameAppInterface.finish();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return true;
  }
  
  AppActivity a()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    if ((localWeakReference.get() instanceof IAVGameRootContainer)) {
      return (AppActivity)this.c.get();
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    this.b = 2;
  }
  
  abstract void a(long paramLong, int paramInt, View paramView);
  
  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString)
  {
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAppActivity.getString(2131893405);
      paramString = localAppActivity.getString(2131893406);
    }
    else
    {
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        return;
      }
      str = localAppActivity.getString(2131893415);
      paramString = localAppActivity.getString(2131893416);
    }
    a(paramLong, str, paramString);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (d()) {
      return;
    }
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    paramString1 = DialogUtil.a(localAppActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131887648, new AVGameControlUI.3(this, paramLong));
    int j;
    if (AVGameUtil.b(localAppActivity)) {
      j = 2131893417;
    } else {
      j = 2131893418;
    }
    paramString1.setPositiveButton(j, new AVGameControlUI.2(this, paramLong)).show();
  }
  
  public void a(RectF paramRectF) {}
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.i = paramIGameRoomPresenter;
  }
  
  public void a(AVGameVideoLayer paramAVGameVideoLayer)
  {
    this.h = paramAVGameVideoLayer;
    this.h.a(this);
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  boolean a(long paramLong, String paramString, View paramView, int paramInt)
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    int j;
    if (((AppActivity)localObject).checkSelfPermission(paramString) == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      if (a((Context)localObject))
      {
        AVGameControlUI.1 local1 = new AVGameControlUI.1(this, paramString, paramLong, paramInt, paramView);
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSelfPermission, begin, permission[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mRequestPermissionIng[");
        localStringBuilder.append(this.f);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.f = true;
        ((AppActivity)localObject).requestPermissions(local1, 0, new String[] { paramString });
        if ("android.permission.CAMERA".equals(paramString))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
          return false;
        }
        if ("android.permission.RECORD_AUDIO".equals(paramString))
        {
          b(paramLong, paramView);
          ReportController.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
          return false;
        }
      }
      else
      {
        paramView = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkSelfPermission, fail, permission[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject).toString());
        a(paramLong, paramString);
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.b = 1;
  }
  
  public void b(long paramLong)
  {
    this.b = 3;
  }
  
  abstract void b(long paramLong, View paramView);
  
  public void c() {}
  
  public void c(long paramLong)
  {
    this.b = 5;
  }
  
  public void d(long paramLong)
  {
    this.b = 6;
    this.g = null;
  }
  
  public boolean d()
  {
    return this.b == 6;
  }
  
  abstract void e();
  
  public void onClick(View paramView)
  {
    a(QQAudioHelper.d(), paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI
 * JD-Core Version:    0.7.0.1
 */