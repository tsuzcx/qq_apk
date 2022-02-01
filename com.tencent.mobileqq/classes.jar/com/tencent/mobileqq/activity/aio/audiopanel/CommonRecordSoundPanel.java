package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvp.IBasePresenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, ICommonRecordSoundPanelView
{
  AppActivity a;
  Handler b;
  ICommonRecordSoundPanelPresenter c;
  int d = 0;
  private AppRuntime e;
  private TextView f;
  private ViewGroup g;
  private ViewGroup h;
  private VolumeIndicateSquareView i;
  private VolumeIndicateSquareView j;
  private TextView k;
  private ImageView l;
  private PopupWindow m;
  private View n;
  private String o = "common record panel";
  private int p;
  
  public CommonRecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonRecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private int getTitleBarHeight()
  {
    return this.a.getResources().getDimensionPixelSize(2131299920);
  }
  
  public void a(int paramInt)
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.c;
    if (localICommonRecordSoundPanelPresenter != null) {
      localICommonRecordSoundPanelPresenter.a(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new CommonRecordSoundPanel.2(this));
  }
  
  public void a(AppRuntime paramAppRuntime, AppActivity paramAppActivity, Handler paramHandler, int paramInt)
  {
    a(paramAppRuntime, paramAppActivity, paramHandler, paramInt, false);
  }
  
  public void a(AppRuntime paramAppRuntime, AppActivity paramAppActivity, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.e = paramAppRuntime;
    this.a = paramAppActivity;
    this.b = paramHandler;
    this.f = ((TextView)findViewById(2131440605));
    this.g = ((ViewGroup)findViewById(2131446307));
    this.h = ((ViewGroup)findViewById(2131435682));
    this.i = ((VolumeIndicateSquareView)findViewById(2131435684));
    this.j = ((VolumeIndicateSquareView)findViewById(2131435685));
    this.k = ((TextView)findViewById(2131444501));
    this.l = ((ImageView)findViewById(2131444495));
    this.l.setOnClickListener(this);
    paramAppRuntime = this.c;
    if (paramAppRuntime != null) {
      paramAppRuntime.d(paramInt);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new CommonRecordSoundPanel.1(this), 100L);
    }
  }
  
  public boolean a()
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.c;
    if (localICommonRecordSoundPanelPresenter != null) {
      return localICommonRecordSoundPanelPresenter.b();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    paramInt /= 1180;
    this.i.a(paramInt);
    this.j.a(paramInt);
  }
  
  public void b(String paramString)
  {
    setRequestedOrientation4Recording(true);
    this.a.getWindow().clearFlags(128);
  }
  
  public boolean b()
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      a(102);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      a(102);
    }
  }
  
  public void d()
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      a(1);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.l.setVisibility(0);
    this.l.setImageResource(2130846192);
    this.l.setContentDescription(HardCodeUtil.a(2131900431));
    Object localObject = this.c;
    if (localObject != null) {
      this.k.setText(((ICommonRecordSoundPanelPresenter)localObject).a(0.0D));
    }
    localObject = this.m;
    if (localObject != null)
    {
      if (((PopupWindow)localObject).isShowing()) {
        try
        {
          this.m.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.m = null;
    }
    View localView = this.n;
    if (localView != null)
    {
      if (localView.getParent() != null) {
        ((ViewGroup)this.n.getParent()).removeView(this.n);
      }
      this.n = null;
    }
  }
  
  public void f()
  {
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    this.h.setVisibility(8);
    this.l.setVisibility(0);
  }
  
  public void g()
  {
    VolumeIndicateSquareView localVolumeIndicateSquareView = this.i;
    if ((localVolumeIndicateSquareView != null) && (this.j != null))
    {
      localVolumeIndicateSquareView.a();
      this.j.a();
    }
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.l.setVisibility(0);
  }
  
  public AppRuntime getApp()
  {
    return this.e;
  }
  
  public Handler getCallBack()
  {
    return this.b;
  }
  
  public IBasePresenter getPresenter()
  {
    return this.c;
  }
  
  public double getRecordTime()
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.c;
    if (localICommonRecordSoundPanelPresenter != null) {
      return localICommonRecordSoundPanelPresenter.d();
    }
    return 0.0D;
  }
  
  public AppActivity getViewContext()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    if (i1 == 2131444495)
    {
      boolean bool2 = a();
      Object localObject;
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.a;
        if ((localObject != null) && (((AppActivity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
        {
          bool1 = false;
          break label72;
        }
      }
      boolean bool1 = true;
      label72:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRecording is:");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(" hasPermission is:");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (bool2)
      {
        a(102);
      }
      else
      {
        if (!bool1)
        {
          localObject = this.a;
          if (localObject != null)
          {
            ((AppActivity)localObject).requestPermissions(new CommonRecordSoundPanel.4(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
            a(102);
            break label400;
          }
        }
        bool1 = Environment.getExternalStorageState().equals("mounted");
        if (this.a != null)
        {
          i1 = getTitleBarHeight();
          if (bool1)
          {
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
            {
              localObject = this.c;
              if (localObject != null)
              {
                if (((ICommonRecordSoundPanelPresenter)localObject).g())
                {
                  this.l.setImageResource(2130846190);
                  this.l.setContentDescription(HardCodeUtil.a(2131900432));
                  this.c.f();
                  this.c.b(102);
                  getWindowVisibleDisplayFrame(new Rect());
                }
              }
              else {
                QLog.e(this.o, 1, "recorderInit mPresenter not find");
              }
            }
            else
            {
              QQToast.makeText(BaseApplication.getContext(), 2131916078, 0).show(i1);
            }
          }
          else {
            QQToast.makeText(BaseApplication.getContext(), 2131892169, 0).show(i1);
          }
        }
        ReportController.b(this.e, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      }
    }
    label400:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return a();
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if (paramIBasePresenter == null)
    {
      this.c = null;
      return;
    }
    if ((paramIBasePresenter instanceof ICommonRecordSoundPanelPresenter)) {
      this.c = ((ICommonRecordSoundPanelPresenter)paramIBasePresenter);
    }
  }
  
  public void setRecordTime(String paramString)
  {
    this.k.setText(paramString);
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.p = this.a.getRequestedOrientation();
      int i4 = getResources().getConfiguration().orientation;
      paramBoolean = VersionUtils.b();
      int i1 = 0;
      int i2 = 0;
      int i3 = 1;
      Object localObject;
      if (!paramBoolean)
      {
        if (i4 == 1)
        {
          localObject = this.a;
          i1 = i3;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((AppActivity)localObject).setRequestedOrientation(i1);
          return;
        }
        if (i4 == 2)
        {
          localObject = this.a;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 6;
          }
          ((AppActivity)localObject).setRequestedOrientation(i1);
        }
      }
      else
      {
        if (VersionUtils.f())
        {
          localObject = this.a.getWindowManager().getDefaultDisplay();
          i2 = ((Display)localObject).getRotation();
          Point localPoint = new Point();
          ((Display)localObject).getSize(localPoint);
          if ((i2 != 0) && (i2 != 2))
          {
            if (localPoint.x > localPoint.y)
            {
              if (i2 == 1) {
                break label224;
              }
            }
            else
            {
              if (i2 != 1) {
                break label216;
              }
              break label221;
            }
          }
          else
          {
            if (localPoint.x <= localPoint.y) {
              break label212;
            }
            if (i2 == 0) {
              break label224;
            }
          }
          i1 = 8;
          break label224;
          label212:
          if (i2 == 0) {
            label216:
            i1 = 1;
          } else {
            label221:
            i1 = 9;
          }
          label224:
          this.a.setRequestedOrientation(i1);
          return;
        }
        i1 = this.a.getWindowManager().getDefaultDisplay().getRotation();
        if ((i1 != 0) && (i1 != 1))
        {
          if ((i1 == 2) || (i1 == 3))
          {
            if (i4 == 1)
            {
              this.a.setRequestedOrientation(9);
              return;
            }
            if (i4 == 2) {
              this.a.setRequestedOrientation(8);
            }
          }
        }
        else
        {
          if (i4 == 1)
          {
            this.a.setRequestedOrientation(1);
            return;
          }
          if (i4 == 2) {
            this.a.setRequestedOrientation(0);
          }
        }
      }
    }
    else
    {
      this.a.setRequestedOrientation(this.p);
    }
  }
  
  public void setTimeOutTime(int paramInt)
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.c;
    if (localICommonRecordSoundPanelPresenter != null) {
      localICommonRecordSoundPanelPresenter.c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */