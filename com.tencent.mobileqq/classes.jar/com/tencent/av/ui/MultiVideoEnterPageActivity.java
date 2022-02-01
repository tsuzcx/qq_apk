package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  int A = 0;
  int B = 0;
  int C = 0;
  long D = 0L;
  boolean E = false;
  boolean F = false;
  MultiVideoMembersClickListener G = new MultiVideoEnterPageActivity.1(this);
  GAudioUIObserver H = new MultiVideoEnterPageActivity.5(this);
  VideoObserver I = new MultiVideoEnterPageActivity.MyVideoObserver(this);
  final int J = 0;
  final int K = 1;
  final String a;
  MultiVideoEnterPageActivity.MainUI b = new MultiVideoEnterPageActivity.MainUI();
  MultiVideoEnterPageMembersControlUI[] c = null;
  LinearLayout d = null;
  RelativeLayout e = null;
  MultiMembersAudioUI f = null;
  ProgressBar g = null;
  TextView h = null;
  String i = null;
  String j = null;
  long k;
  long[] l = null;
  int m;
  int n;
  int o;
  int p;
  int q = 0;
  int r = 0;
  String s;
  VideoAppInterface t = null;
  VideoController u = null;
  MultiVideoEnterPageActivity.TimeoutRunnable v = null;
  Runnable w = null;
  Runnable x = null;
  Runnable y = null;
  boolean z = false;
  
  public MultiVideoEnterPageActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiVideoEnterPageActivity_");
    localStringBuilder.append(QQAudioHelper.d());
    this.a = localStringBuilder.toString();
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((paramInt == 3000) && (QAVHrMeeting.a(this.t.f(this.i))))
    {
      ChatActivityUtils.ConfIdownloadTask.a(this.a, this.i, new MultiVideoEnterPageActivity.9(this));
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt == 0) {
      d(10);
    }
  }
  
  private void g()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
    int i1 = AIOUtils.b(88.0F, this.f.getResources());
    if (localMarginLayoutParams.topMargin == i1) {
      return;
    }
    localMarginLayoutParams.topMargin = i1;
    this.f.setLayoutParams(localMarginLayoutParams);
  }
  
  private void h()
  {
    Object localObject = new RelativeLayout.LayoutParams(ImmersiveUtils.getScreenWidth(), AIOUtils.b(74.0F, getResources()));
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.b.d.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((TextView)findViewById(2131441175)).getLayoutParams();
    float f1;
    if (Build.MODEL.equalsIgnoreCase("SM-G8870")) {
      f1 = 50.0F;
    } else {
      f1 = 30.0F;
    }
    int i1 = AIOUtils.b(f1, getResources());
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = i1;
    localMarginLayoutParams.topMargin = i1;
    this.b.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((TextView)findViewById(2131441175)).setLayoutParams(localMarginLayoutParams);
  }
  
  private boolean i()
  {
    if (this.t.m())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "startMultipVideo phone is calling!");
      }
      String str = getResources().getString(2131893193);
      DialogUtil.a(this, 230, getResources().getString(2131893450), str, 2131887648, 2131892267, new MultiVideoEnterPageActivity.10(this), null).show();
      return true;
    }
    return false;
  }
  
  private void j()
  {
    if (this.t.i == true)
    {
      this.t.i = false;
      VideoNodeManager.h();
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131441073)
    {
      if (i1 != 2131441080)
      {
        if (i1 != 2131441175) {
          return;
        }
        j();
        i1 = this.n;
        if (i1 == 1)
        {
          if (this.r == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
          }
        }
        else if (i1 == 3000) {
          ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
        }
        finish();
        super.overridePendingTransition(0, 2130772257);
        return;
      }
      if (i()) {
        return;
      }
      QAVGroupConfig.Report.c();
      a(this.n, this.j);
      return;
    }
    a(paramView);
  }
  
  void a()
  {
    Object localObject;
    if ((ThemeUtil.isInNightMode(this.t)) && (this.F))
    {
      findViewById(2131441202).setBackgroundColor(Color.parseColor("#181818"));
      localObject = getResources().getDrawable(2130843193);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      ((TextView)findViewById(2131441175)).setCompoundDrawables((Drawable)localObject, null, null, null);
      ((TextView)findViewById(2131441175)).setCompoundDrawablePadding(0);
      ((TextView)findViewById(2131441175)).setTextColor(Color.parseColor("#737373"));
    }
    this.e = ((RelativeLayout)findViewById(2131441285));
    this.h = ((TextView)findViewById(2131441079));
    this.f = ((MultiMembersAudioUI)findViewById(2131432570));
    this.f.setIsEnterpage(true);
    this.f.a(this.k, this.o, true);
    this.f.setOnItemClickListener(this.G);
    g();
    this.g = ((ProgressBar)findViewById(2131441077));
    this.g.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.g.setVisibility(0);
    this.d = ((LinearLayout)super.findViewById(2131432569));
    this.b.a(this);
    h();
    if ((ThemeUtil.isInNightMode(this.t)) && (this.F))
    {
      this.b.d.setTextColor(Color.parseColor("#757575"));
      this.h.setTextColor(Color.parseColor("#A8A8A8"));
      this.b.b.setTextColor(Color.parseColor("#737373"));
      this.b.b.setBackgroundDrawable(getResources().getDrawable(2130843267));
      this.b.a.setTextColor(Color.parseColor("#FFFFFF"));
      this.b.a.setBackgroundDrawable(getResources().getDrawable(2130843269));
    }
    if (this.u != null)
    {
      if (this.z)
      {
        this.b.a(4);
        this.c = new MultiVideoEnterPageMembersControlUI[2];
        this.c[0] = new MultiVideoEnterPageMembersControlUI(this);
        localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
        this.d.addView(this.c[0], (ViewGroup.LayoutParams)localObject);
        this.c[0].a(this.k, this.o, true);
        this.c[0].setMode(MultiVideoEnterPageMembersControlUI.r);
        localObject = this.c;
        localObject[0].o = true;
        localObject[0].A.setVisibility(0);
        this.c[0].setLowHeightMode();
        this.c[0].w.setOnClickListener(new MultiVideoEnterPageActivity.2(this));
        this.c[1] = new MultiVideoEnterPageMembersControlUI(this);
        localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
        this.d.addView(this.c[1], (ViewGroup.LayoutParams)localObject);
        this.c[1].a(this.k, this.o, true);
        this.c[1].setMode(MultiVideoEnterPageMembersControlUI.s);
        localObject = this.c;
        localObject[1].o = true;
        localObject[1].w.setOnClickListener(new MultiVideoEnterPageActivity.3(this));
        this.c[1].x.setOnClickListener(new MultiVideoEnterPageActivity.4(this));
      }
      else
      {
        this.b.a(0);
        this.b.a.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      }
      a(false);
      if ((this.n == 1) && (this.r == 2)) {
        UITools.a(this.b.a, getResources().getString(2131890645), this.r);
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.z)
    {
      this.u.b(this.o, this.k, 10);
      this.u.b(this.o, this.k, 2);
      return;
    }
    if (!this.u.b(this.o, this.k, paramInt))
    {
      QQToast.makeText(this, HardCodeUtil.a(2131904894), 1).show(a(this).getDimensionPixelSize(2131299920));
      finish();
    }
  }
  
  void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null)
    {
      paramArrayList = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUserListALLUpdate, simpleData is null, flag[");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramArrayList, 1, ((StringBuilder)localObject).toString());
      if (!this.z)
      {
        c();
        finish();
      }
      return;
    }
    if ((paramInt1 != 2) && (paramInt1 != 10) && (paramInt1 != 12)) {
      this.q = paramInt2;
    } else {
      this.q = paramArrayList.size();
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserListALLUpdate, flag[");
    localStringBuilder.append(this.z);
    localStringBuilder.append("], groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], userCount[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], simpleData[");
    localStringBuilder.append(paramArrayList.size());
    localStringBuilder.append("], mMemberCount[");
    localStringBuilder.append(this.q);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.q == 0)
    {
      if (this.z)
      {
        paramArrayList = this.c;
        if ((paramArrayList != null) && (paramArrayList.length == 2))
        {
          if (paramInt1 == 2)
          {
            paramArrayList[0].y.setVisibility(0);
            this.c[0].y.setText(2131893442);
            this.c[0].z.setVisibility(8);
          }
          else if (paramInt1 == 10)
          {
            paramArrayList[1].y.setVisibility(0);
            this.c[1].y.setText(2131893443);
            this.c[1].z.setVisibility(8);
          }
          this.b.a.setText(2131893302);
        }
        return;
      }
      c();
      finish();
      return;
    }
    if (paramInt1 == 10)
    {
      localObject = this.c;
      if ((localObject != null) && (localObject.length > 1))
      {
        localObject[1].z.setVisibility(0);
        this.c[1].setVisibility(0);
        this.c[1].a(paramArrayList);
        if (this.z)
        {
          this.c[1].y.setVisibility(8);
          this.c[1].z.setVisibility(8);
          localObject = this.c;
          if (localObject[0] != null) {
            localObject[0].A.setVisibility(0);
          }
        }
        a(true);
        break label606;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject[0].z.setVisibility(0);
      this.c[0].setVisibility(0);
      this.c[0].a(paramArrayList);
      if (this.z)
      {
        this.c[0].y.setVisibility(8);
        this.c[0].z.setVisibility(8);
      }
    }
    label606:
    this.g.setVisibility(0);
    this.f.setVisibility(0);
    paramArrayList = this.u.a(paramArrayList.size(), paramArrayList);
    this.f.a(paramArrayList);
    paramArrayList = String.format(super.getResources().getString(2131893440), new Object[] { Integer.valueOf(this.q) });
    this.b.d.setText(paramArrayList);
    d();
    this.t.a().removeCallbacks(this.v);
  }
  
  void a(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, 2131892074, 1).show(super.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(this.k));
    localBundle = this.t.a(6, 0, 0, localBundle, null);
    if (localBundle == null)
    {
      QLog.w(this.a, 1, "closeGAudio, rsp is null");
      paramView.setVisibility(8);
      return;
    }
    boolean bool2 = localBundle.getBoolean("isAdmin");
    boolean bool1 = localBundle.getBoolean("isOwner");
    if (1 == QQAudioHelper.b(7))
    {
      QQAudioHelper.a(HardCodeUtil.a(2131904892));
      bool1 = true;
    }
    if ((!bool2) && (!bool1))
    {
      QLog.w(this.a, 1, "closeGAudio, 没有权限");
      paramView.setVisibility(8);
      QQToast.makeText(super.getApplicationContext(), 2131890644, 1).show();
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009E29", "0X8009E29", 0, 0, "", "", "", "");
    MultiVideoEnterPageActivity.AutoHideQQCustomDialog.a(this, 230, getResources().getString(2131893261), getResources().getString(2131890641), 2131893167, 2131917882, new MultiVideoEnterPageActivity.7(this, paramView), new MultiVideoEnterPageActivity.8(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.n != 1) {
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", String.valueOf(this.k));
      localObject = this.t.a(6, 0, 0, (Bundle)localObject, null);
    }
    else
    {
      localObject = getIntent().getBundleExtra("groupInfo");
    }
    if (localObject == null)
    {
      QLog.w(this.a, 1, "setCloseBtn, rsp is null");
      return;
    }
    boolean bool = ((Bundle)localObject).getBoolean("isAdmin");
    paramBoolean = ((Bundle)localObject).getBoolean("isOwner");
    if (1 == QQAudioHelper.b(7))
    {
      QQAudioHelper.a(HardCodeUtil.a(2131904897));
      paramBoolean = true;
    }
    if ((!bool) && (!paramBoolean))
    {
      localObject = this.b.b.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = (ImmersiveUtils.getScreenWidth() - AIOUtils.b(16.0F, getResources()) * 2);
      this.b.b.setVisibility(8);
      this.b.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.z)
    {
      localObject = this.c;
      if ((localObject != null) && (localObject.length > 1) && (localObject[1] != null)) {
        localObject[1].x.setVisibility(0);
      }
    }
    else
    {
      int i1 = (ImmersiveUtils.getScreenWidth() - AIOUtils.b(16.0F, getResources()) * 2 - AIOUtils.b(8.0F, getResources())) / 2;
      localObject = this.b.b.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.b.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.b.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.b.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.b.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      this.b.b.setVisibility(0);
    }
  }
  
  void b(int paramInt)
  {
    if (this.z)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.c;
      if ((arrayOfMultiVideoEnterPageMembersControlUI != null) && (arrayOfMultiVideoEnterPageMembersControlUI.length == 2) && (paramInt == 10))
      {
        arrayOfMultiVideoEnterPageMembersControlUI[1].setVisibility(4);
        arrayOfMultiVideoEnterPageMembersControlUI = this.c;
        if (arrayOfMultiVideoEnterPageMembersControlUI[0] != null) {
          arrayOfMultiVideoEnterPageMembersControlUI[0].A.setVisibility(8);
        }
        c();
      }
    }
    else
    {
      c();
      finish();
    }
  }
  
  boolean b()
  {
    Object localObject1 = super.getIntent();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "processExtraData-->can not get intent");
      }
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(".processExtraData");
    QQAudioHelper.a(((StringBuilder)localObject2).toString(), ((Intent)localObject1).getExtras(), true);
    this.E = ((Intent)localObject1).getBooleanExtra("openClass", false);
    this.l = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    this.s = ((Intent)localObject1).getStringExtra("creator_nick");
    this.m = ((Intent)localObject1).getIntExtra("sessionType", 0);
    int i1 = this.m;
    if ((i1 != 3) && (i1 != 4))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processExtraData-->get the wrong sessionType,Type=");
        ((StringBuilder)localObject2).append(this.m);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    this.p = ((Intent)localObject1).getIntExtra("Type", -1);
    if (this.p != 3)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processExtraData-->get the wrong GAudioStatus,Type=");
        ((StringBuilder)localObject2).append(this.p);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    this.j = ((Intent)localObject1).getStringExtra("uin");
    this.i = ((Intent)localObject1).getStringExtra("GroupId");
    localObject2 = this.i;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "processExtraData-->can not get the groupuin");
      }
      return false;
    }
    this.k = Long.valueOf((String)localObject2).longValue();
    if (this.k == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "processExtraData-->can not get the groupuin");
      }
      return false;
    }
    i1 = ((Intent)localObject1).getIntExtra("MultiAVType", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get Intent AVType : ");
      localStringBuilder.append(i1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.r = i1;
    this.n = ((Intent)localObject1).getIntExtra("uinType", -1);
    i1 = this.n;
    if (i1 == 3000)
    {
      this.o = 2;
    }
    else
    {
      if (i1 != 1) {
        break label445;
      }
      this.o = 1;
    }
    this.z = ((Intent)localObject1).getBooleanExtra("flag", false);
    return true;
    label445:
    if (QLog.isColorLevel()) {
      QLog.e(this.a, 2, "processExtraData-->can not get uin Type.");
    }
    return false;
  }
  
  void c()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.k);
    localIntent.putExtra("openClass", this.E);
    localIntent.putExtra("relationType", this.o);
    localIntent.putExtra("MultiAVType", this.r);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.t.getApp().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  void c(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNetTips-->type=");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.w == null) {
      this.w = new MultiVideoEnterPageActivity.RemoveTipsRunnale(this);
    }
    Object localObject = this.t;
    if (localObject != null)
    {
      if (((VideoAppInterface)localObject).a() == null) {
        return;
      }
      this.t.a().post(this.w);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2)
          {
            paramInt = 2131893709;
            break label157;
          }
        }
        else
        {
          paramInt = 2131893711;
          break label157;
        }
      }
      else {
        this.t.a().postDelayed(new MultiVideoEnterPageActivity.6(this), 1000L);
      }
      paramInt = -1;
      label157:
      localObject = this.c;
      if (localObject != null)
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localStringBuilder = localObject[i1];
          if (paramInt != -1)
          {
            localStringBuilder.y.setText(paramInt);
            localStringBuilder.z.setVisibility(0);
          }
          i1 += 1;
        }
      }
      if (paramInt != -1)
      {
        this.h.setText(paramInt);
        this.g.setVisibility(0);
      }
    }
  }
  
  void d()
  {
    int i1 = NetworkUtil.getSystemNetwork(this);
    if (NetworkUtil.isBluetoothSharedNetwork(this)) {
      i1 = 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNetTips,netinfo=");
      localStringBuilder.append(i1);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
    }
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3)) {}
    Object localObject = this.c;
    if (localObject != null)
    {
      int i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject[i1].z.setVisibility(8);
        i1 += 1;
      }
    }
    this.g.setVisibility(8);
  }
  
  void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterButtonClick --> AVType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    e(paramInt);
    int i1 = this.n;
    if (i1 == 1)
    {
      if (paramInt == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      return;
    }
    if (i1 == 3000)
    {
      if (this.q <= 0)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, 2131892074, 1).show(super.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if ((this.u.k().i > 0) && (this.u.k().i < 7))
    {
      QQToast.makeText(this, 2131893650, 1).show(super.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClickEnterMultiVideoChat, mRelationId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.u.j);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.u.k);
    localStringBuilder.append("], mHaveMoreRoom[");
    localStringBuilder.append(this.z);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], currentAvtype[");
    localStringBuilder.append(this.r);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (((this.u.j) && (this.k != this.u.k)) || (this.t.o()))
    {
      f();
      return;
    }
    f(paramInt);
  }
  
  public boolean e()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {
      return true;
    }
    return isFinishing();
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "quitGAudioChatDialog");
    }
    MultiVideoEnterPageActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new MultiVideoEnterPageActivity.DialogInterfaceOnClickListener(this, 0);
    MultiVideoEnterPageActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new MultiVideoEnterPageActivity.DialogInterfaceOnClickListener(this, 1);
    MultiVideoEnterPageActivity.AutoHideQQCustomDialog.a(this, 230, null, super.getResources().getString(2131893276), 2131917829, 2131893180, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  @TargetApi(9)
  void f(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = this.u.k().o;
    }
    paramInt = i1;
    if (this.n == 3000)
    {
      paramInt = i1;
      if (!this.z) {
        paramInt = 1;
      }
    }
    if (paramInt == 2)
    {
      localObject = new Intent(this, JumpActivity.class);
      ((Intent)localObject).setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    else
    {
      localObject = new Intent(this, AVActivity.class);
    }
    ((Intent)localObject).addFlags(262144);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("sessionType", 3);
    ((Intent)localObject).putExtra("GroupId", String.valueOf(this.k));
    ((Intent)localObject).putExtra("Type", 1);
    ((Intent)localObject).putExtra("DiscussUinList", this.l);
    ((Intent)localObject).putExtra("MultiAVType", paramInt);
    ((Intent)localObject).putExtra("uin", String.valueOf(this.k));
    ((Intent)localObject).putExtra("uinType", this.n);
    ((Intent)localObject).putExtra("ConfAppID", this.B);
    ((Intent)localObject).putExtra("MeetingConfID", this.C);
    super.startActivity((Intent)localObject);
    finish();
    Object localObject = this.u;
    if (localObject != null) {
      ((VideoController)localObject).a(SessionMgr.a(this.o, String.valueOf(this.k), new int[0]), this.m, false, false, false);
    }
    if (paramInt == 2)
    {
      localObject = this.u;
      if (localObject != null) {
        ((VideoController)localObject).d(1010);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    j();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131625767);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(false, getWindow());
    AVActivity.a(super.getWindow());
    this.t = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = this.t;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "onCreate-->can not get the VideoAppInterface");
      }
      finish();
      return;
    }
    this.u = paramBundle.b();
    if (this.u == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "onCreate-->can not get the VideoController");
      }
      finish();
      return;
    }
    this.t.a(this.H);
    this.t.a(this.I);
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "can not processExtraData");
      }
      finish();
      return;
    }
    this.v = new MultiVideoEnterPageActivity.TimeoutRunnable(this);
    this.t.a().postDelayed(this.v, 15000L);
    a();
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.i, "", "", "");
    if (this.y == null) {
      this.y = new MultiVideoEnterPageActivity.RefreshDisplayNameRunnable(this);
    }
    this.t.a().post(this.y);
    QAVGroupConfig.Report.b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.t.b(this.H);
    this.t.b(this.I);
    this.t.a().removeCallbacks(this.v);
    this.t.a().removeCallbacks(this.w);
    this.t.a().removeCallbacks(this.x);
    this.t.a().removeCallbacks(this.y);
    VideoController localVideoController = this.u;
    if (localVideoController != null) {
      localVideoController.X = false;
    }
    this.y = null;
    this.x = null;
    this.w = null;
    this.v = null;
    this.b.a();
    AVUtil.a(this);
    this.h = null;
    this.g = null;
    this.f = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.u != null)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, mRelationType[");
      localStringBuilder.append(this.o);
      localStringBuilder.append("], mRelationId[");
      localStringBuilder.append(this.k);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(this.u.k().o);
      localStringBuilder.append("], currentAvtype[");
      localStringBuilder.append(this.r);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      a(this.r);
    }
    if (this.x == null) {
      this.x = new MultiVideoEnterPageActivity.RefreshFaceRunnable(this);
    } else {
      this.t.a().removeCallbacks(this.x);
    }
    this.t.a().postDelayed(this.x, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity
 * JD-Core Version:    0.7.0.1
 */