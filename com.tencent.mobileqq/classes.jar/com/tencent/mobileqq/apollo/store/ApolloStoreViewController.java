package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.bubble.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStrategy;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResHelperImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloStoreViewController
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener, TouchWebView.OnScrollChangedListener, OnApolloViewListener
{
  public static String a;
  private BarrageView A;
  private WeakReferenceHandler B = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private RelativeLayout C;
  private int D;
  private int E;
  private ImageView F;
  private RelativeLayout.LayoutParams G;
  private IRenderCallback H;
  private IRenderCallback I;
  private float J = 2.0F;
  private float K = 1.0F;
  private int L;
  private String M;
  private int N;
  private boolean O;
  private MediaPlayer P;
  private AudioManager Q;
  private TelephonyManager R;
  private int S;
  private boolean T;
  private ApolloVoiceDIYHelper U;
  private boolean V;
  private boolean W;
  private float X;
  private int Y;
  private TextView Z;
  private ImageView aa;
  private ApolloStoreViewController.PlayActionData ab;
  private ApolloImageShareLayout ac;
  private ApolloWebAvatarParam ad;
  private HashMap<String, ApolloWebAvatarParam> ae = new HashMap();
  private String af;
  private boolean ag;
  @NonNull
  private IApolloResManager ah;
  public int b;
  public boolean c;
  TextView d;
  String e;
  String f;
  private IApolloViewControllerCallBack g;
  private WeakReference<OnApolloViewListener> h;
  private boolean i;
  private Button j;
  private LinearLayout k;
  private float l;
  private float m;
  private String n;
  private int o = 1;
  private boolean p;
  private boolean q;
  private RelativeLayout r;
  private RelativeLayout s;
  private float t;
  private boolean u;
  private int v;
  private TextView w;
  private FrameLayout x;
  private ApolloTextureView y;
  private ApolloTextureView z;
  
  public ApolloStoreViewController(RelativeLayout paramRelativeLayout, IApolloViewControllerCallBack paramIApolloViewControllerCallBack)
  {
    this.g = paramIApolloViewControllerCallBack;
    this.C = paramRelativeLayout;
    if (this.C != null)
    {
      this.ah = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
      paramRelativeLayout = this.C.getContext();
      this.y = new ApolloTextureView(paramRelativeLayout, null);
      this.y.init(this);
      if (BaseApplicationImpl.sProcessId == 7) {
        this.y.setDumplicateCreateRenderThread(true);
      }
      this.y.setClickable(false);
      paramIApolloViewControllerCallBack = new RelativeLayout.LayoutParams(100, 100);
      this.H = new ApolloStoreViewController.1(this);
      this.y.getRender().setRenderCallback(this.H);
      this.C.addView(this.y, paramIApolloViewControllerCallBack);
      this.K = (FontSettingManager.getFontLevel() / 16.0F);
      if (this.K != 0.0F) {
        this.J = (DeviceInfoUtil.A() / this.K);
      }
      if (this.J == 0.0F) {
        this.J = DeviceInfoUtil.A();
      }
      this.F = new ImageView(paramRelativeLayout);
      this.F.setImageResource(2130839585);
      this.D = ViewUtils.dip2px(25.0F);
      this.E = ViewUtils.dip2px(25.0F);
      this.G = new RelativeLayout.LayoutParams(this.D, this.E);
      this.G.addRule(9, -1);
      this.G.addRule(10, -1);
      this.F.setVisibility(8);
      this.C.addView(this.F, this.G);
      this.U = new ApolloVoiceDIYHelper();
      this.s = new RelativeLayout(paramRelativeLayout);
      paramIApolloViewControllerCallBack = new ImageView(paramRelativeLayout);
      paramIApolloViewControllerCallBack.setImageResource(2130839585);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      this.s.addView(paramIApolloViewControllerCallBack, localLayoutParams);
      this.C.addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
      this.x = new FrameLayout(paramRelativeLayout);
      this.w = new TextView(paramRelativeLayout);
      this.w.setTextColor(-8366104);
      this.w.setTextSize(12.0F);
      this.w.setGravity(17);
      this.w.setSingleLine(false);
      paramRelativeLayout = new FrameLayout.LayoutParams(-1, -1);
      paramRelativeLayout.leftMargin = ViewUtils.dip2px(15.0F);
      paramRelativeLayout.rightMargin = ViewUtils.dip2px(15.0F);
      this.x.addView(this.w, paramRelativeLayout);
      this.x.setBackgroundResource(2130838635);
      paramRelativeLayout = new RelativeLayout.LayoutParams(ViewUtils.dip2px(81.0F), ViewUtils.dip2px(58.0F));
      this.C.addView(this.x, paramRelativeLayout);
      this.x.setVisibility(8);
      float f1 = this.K;
      if (f1 != 0.0F) {
        this.w.setTextSize(12.0F / f1);
      }
      a();
      return;
    }
    throw new RuntimeException("rootView must not null");
  }
  
  private void a(Message paramMessage)
  {
    if ((this.y != null) && (this.z != null) && (this.k != null))
    {
      if (this.ad == null) {
        return;
      }
      int i2 = paramMessage.arg2;
      this.y.setVisibility(4);
      this.z.setVisibility(0);
      float f1;
      if (this.k.getVisibility() == 0) {
        f1 = 77.0F;
      } else {
        f1 = 42.0F;
      }
      float f4 = (float)(Math.max(DeviceInfoUtil.C(), DeviceInfoUtil.B()) / 7L) / 368.0F;
      Object localObject = paramMessage.obj;
      float f3 = 0.0F;
      float f2;
      int i1;
      if ((localObject != null) && ((localObject instanceof Float)))
      {
        f2 = ((Float)localObject).floatValue();
        i1 = 1;
      }
      else
      {
        f2 = 0.0F;
        i1 = 0;
      }
      int i3 = paramMessage.arg1;
      if ((i3 == 1) && (this.ah.b(this.L)))
      {
        f3 = 330.0F * f4 / DeviceInfoUtil.a / 2.0F;
        this.z.getRenderImpl().a(2, null, this.L, f4, this.t - f3, f1);
        this.z.getRenderImpl().a(2, null, ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(this.L), null);
        paramMessage = ApolloActionHelperImpl.getActionRscPath(13, i2, this.L, false);
        if (i1 != 0)
        {
          this.U.a(this.z, i2, this.ad.roleId, i3);
          this.U.a(f2);
        }
        else
        {
          this.z.getRenderImpl().a(2, null, i2, 0, paramMessage[0], paramMessage[1]);
        }
      }
      this.z.getRenderImpl().a(1, this.ad.apolloId, this.ad.roleId, f4, this.t + f3, f1);
      this.z.getRenderImpl().a(1, this.ad.apolloId, this.ad.dressIds, null);
      paramMessage = ApolloActionHelperImpl.getActionRscPath(13, i2, this.ad.roleId, true);
      this.z.stopLoopDelayed(1000L);
      if (i1 != 0)
      {
        this.U.a(this.z, i2, this.ad.roleId, i3);
        this.U.a(f2);
      }
      else
      {
        this.z.getRenderImpl().a(1, this.ad.apolloId, i2, 0, paramMessage[0], paramMessage[1]);
      }
      if (!TextUtils.isEmpty(this.M))
      {
        if (this.N == 1)
        {
          this.z.getRenderImpl().a(1, this.ad.apolloId, "Bubble");
          if (this.A != null)
          {
            i1 = (int)((float)(DeviceInfoUtil.E() / 7L) * 1.14F);
            paramMessage = this.A.getParent();
            if (this.r != paramMessage)
            {
              if (paramMessage != null) {
                ((ViewGroup)paramMessage).removeView(this.A);
              }
              paramMessage = new RelativeLayout.LayoutParams(-1, i1);
              paramMessage.addRule(12, -1);
              paramMessage.leftMargin = ViewUtils.dip2px(25.0F);
              paramMessage.rightMargin = ViewUtils.dip2px(25.0F);
              paramMessage.bottomMargin = (ViewUtils.dip2px(f1) + (this.r.getHeight() - this.z.getHeight()) / 2);
              this.r.addView(this.A, 1, paramMessage);
            }
            ApolloBarrageUtil.a(this.r.getWidth(), i1, this.A, BaseApplicationImpl.getContext(), "", this.M, true);
          }
        }
        else
        {
          ApolloBubbleLogic.a.set(0);
          this.z.getRenderImpl().b(0, this.ad.apolloId, 1, this.ad.roleId, this.M, null);
        }
      }
      else {
        this.z.getRenderImpl().a(1, this.ad.apolloId, "Bubble");
      }
    }
  }
  
  private void a(ApolloStoreViewController.PlayActionData paramPlayActionData, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    this.y.setVisibility(0);
    Object localObject = this.z;
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).onExecDispose();
      this.z.stopLoopDelayed(50L);
    }
    if (this.o != paramPlayActionData.actionType)
    {
      this.y.onExecDispose();
      float f1 = 0.0F;
      if (this.ad != null) {
        f1 = this.y.getHeight() / this.J - paramApolloWebAvatarParam.y;
      }
      if (paramPlayActionData.actionType == 1)
      {
        if (this.ah.b(this.L))
        {
          float f2 = this.m / 2.0F;
          this.y.getRenderImpl().a(2, null, this.L, this.l, paramApolloWebAvatarParam.x - f2, f1);
          this.y.getRenderImpl().a(2, null, ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(this.L), null);
          this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, paramApolloWebAvatarParam.roleId, this.l, paramApolloWebAvatarParam.x + f2, f1);
          this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, paramApolloWebAvatarParam.dressIds, null);
        }
      }
      else
      {
        this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, paramApolloWebAvatarParam.roleId, this.l, paramApolloWebAvatarParam.x, f1);
        this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, paramApolloWebAvatarParam.dressIds, null);
      }
      this.y.stopLoopDelayed(15000L);
    }
    if (paramPlayActionData.previewOnFrame)
    {
      this.U.a(this.y, paramPlayActionData.activeId, paramApolloWebAvatarParam.roleId, paramPlayActionData.actionType);
      this.U.a(paramPlayActionData.frameTime);
    }
    else
    {
      ApolloUtilImpl.endTrace("ready resource");
      localObject = ApolloActionHelperImpl.getActionRscPath(13, paramPlayActionData.activeId, paramApolloWebAvatarParam.roleId, true);
      this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, paramPlayActionData.activeId, 0, localObject[0], localObject[1]);
      if (paramPlayActionData.actionType == 1)
      {
        localObject = ApolloActionHelperImpl.getActionRscPath(13, paramPlayActionData.activeId, paramApolloWebAvatarParam.roleId, false);
        this.y.getRenderImpl().a(2, null, paramPlayActionData.activeId, 0, localObject[0], localObject[1]);
      }
    }
    this.o = paramPlayActionData.actionType;
    this.r.setVisibility(8);
    if (TextUtils.isEmpty(paramPlayActionData.text))
    {
      this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, "Bubble");
      return;
    }
    if (paramPlayActionData.textType == 1)
    {
      this.y.getRenderImpl().a(1, paramApolloWebAvatarParam.apolloId, "Bubble");
      localObject = this.A;
      if (localObject != null)
      {
        localObject = ((BarrageView)localObject).getParent();
        int i3 = (int)((float)DeviceInfoUtil.E() * paramApolloWebAvatarParam.rate * 1.14F);
        if (this.C != localObject)
        {
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.A);
          }
          localObject = new RelativeLayout.LayoutParams(-1, i3);
          ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramApolloWebAvatarParam.y * this.J - i3));
          int i2 = this.C.indexOfChild(this.y) - 1;
          int i1 = i2;
          if (i2 < 0) {
            i1 = 0;
          }
          this.C.addView(this.A, i1, (ViewGroup.LayoutParams)localObject);
        }
        else if (this.A.getHeight() != i3)
        {
          localObject = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramApolloWebAvatarParam.y * this.J - i3));
          this.A.getLayoutParams().height = i3;
          this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (!paramPlayActionData.previewOnFrame) {
          ApolloBarrageUtil.a(this.y.getWidth(), i3, this.A, BaseApplicationImpl.getContext(), "", paramPlayActionData.text, true);
        }
      }
    }
    else
    {
      ApolloBubbleLogic.a.set(8);
      this.y.getRenderImpl().b(8, paramApolloWebAvatarParam.apolloId, 1, paramApolloWebAvatarParam.roleId, this.M, null);
    }
  }
  
  private String b(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return b("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return b("no apolloId");
    }
    if (!this.ah.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898821), 0).show();
      return b("dresses is not download!");
    }
    this.ad = paramApolloWebAvatarParam;
    this.af = this.ad.tab;
    synchronized (this.ae)
    {
      this.ae.put(this.ad.apolloId, this.ad);
      this.ag = false;
      this.y.setVisibility(0);
      if ((paramApolloWebAvatarParam.tapRectWidth > 0) && (paramApolloWebAvatarParam.tapRectHeight > 0))
      {
        float f1 = paramApolloWebAvatarParam.tapRectX * this.J;
        float f2 = paramApolloWebAvatarParam.tapRectY * this.J;
        ??? = new RectF(f1, f2, paramApolloWebAvatarParam.tapRectWidth * this.J + f1, paramApolloWebAvatarParam.tapRectHeight * this.J + f2);
        this.y.setTouchableRect((RectF)???);
        ??? = new RelativeLayout.LayoutParams(-1, -1);
        this.y.setLayoutParams((ViewGroup.LayoutParams)???);
      }
      else
      {
        ??? = new RelativeLayout.LayoutParams(-1, (int)(this.ad.y * this.J));
        this.y.setTouchableRect(null);
        this.y.setLayoutParams((ViewGroup.LayoutParams)???);
      }
      this.y.bringToFront();
      this.S = this.ad.type;
      this.T = paramBoolean;
      this.B.sendEmptyMessageDelayed(23, 500L);
      if (Float.compare(0.0F, this.ad.rate) == 0) {
        this.ad.rate = 0.2F;
      }
      this.l = ApolloUtilImpl.getSurfaceScale(this.ad.rate);
      this.m = (this.l * 330.0F / this.J);
      ??? = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
      ((RelativeLayout.LayoutParams)???).addRule(10);
      ((RelativeLayout.LayoutParams)???).addRule(11);
      ((RelativeLayout.LayoutParams)???).width = ViewUtils.dip2px(this.ad.rate * 81.0F / 0.289F);
      ((RelativeLayout.LayoutParams)???).height = ViewUtils.dip2px(this.ad.rate * 58.0F / 0.289F);
      ((RelativeLayout.LayoutParams)???).topMargin = ((int)(paramApolloWebAvatarParam.y * this.J - (float)DeviceInfoUtil.E() * this.ad.rate));
      ((RelativeLayout.LayoutParams)???).rightMargin = ((int)((float)DeviceInfoUtil.D() - this.J * paramApolloWebAvatarParam.x - ((RelativeLayout.LayoutParams)???).width - ViewUtils.dip2px(68.0F) * this.ad.rate / 0.289F));
      this.w.setTextSize(this.ad.rate * 12.0F / 0.289F);
      k();
      this.o = 1;
      paramApolloWebAvatarParam = Message.obtain();
      paramApolloWebAvatarParam.getData().putInt("key_operation", 1);
      paramApolloWebAvatarParam.what = 18;
      this.B.sendMessage(paramApolloWebAvatarParam);
      a(false, this.ad.x, this.ad.y);
      a(false);
      this.M = null;
      this.O = false;
      paramApolloWebAvatarParam = this.A;
      if (paramApolloWebAvatarParam != null) {
        paramApolloWebAvatarParam.setVisibility(8);
      }
      return c("initAvatar成功");
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"result\":1,\"msg\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  private void b(Message arg1)
  {
    String str = (String)???.obj;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[handleMessage] MSG_RESET_APOLLO, apolloId=", str });
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[handleMessage] MSG_RESET_APOLLO, apolloId null");
      return;
    }
    if ((this.i) && (this.y != null) && (this.ad != null)) {
      synchronized (this.ae)
      {
        if (!this.ae.containsKey(str)) {
          return;
        }
        ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)this.ae.get(str);
        if (localApolloWebAvatarParam == null) {
          return;
        }
        ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl = this.y.getRenderImpl();
        if (localApolloRenderInterfaceImpl == null) {
          return;
        }
        this.y.onExecDispose(str);
        localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtilImpl.getSurfaceScale(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.y.getHeight() / this.J - localApolloWebAvatarParam.y);
        if (localApolloWebAvatarParam.roleId == 0) {
          localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, ApolloResHelperImpl.DEFAULT_DRESSIDS_ROLE0, null);
        } else if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
          localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
        }
        this.y.stopLoopDelayed(15000L);
        return;
      }
    }
    QLog.e("[cmshow]ApolloViewController", 1, new Object[] { "[handleMessage] MSG_RESET_APOLLO, surface not ready, mSurfaceReady=", Boolean.valueOf(this.i), ", mSurfaceView=", this.y });
  }
  
  private void b(ApolloStoreViewController.PlayActionData paramPlayActionData)
  {
    a();
    if (this.q)
    {
      localObject = this.z;
      if (localObject != null)
      {
        ((ApolloTextureView)localObject).onExecDispose();
        this.y.onExecDispose();
        this.r.setVisibility(0);
        localObject = this.B.obtainMessage(19, paramPlayActionData.actionType, paramPlayActionData.activeId);
        if (paramPlayActionData.previewOnFrame) {
          ((Message)localObject).obj = Float.valueOf(paramPlayActionData.frameTime);
        }
        this.B.sendMessageDelayed((Message)localObject, 100L);
        break label253;
      }
    }
    this.r.setVisibility(0);
    this.z = new ApolloTextureView(this.C.getContext(), null);
    Object localObject = new RelativeLayout.LayoutParams(-2, (int)(this.C.getContext().getResources().getDisplayMetrics().heightPixels * 0.6F));
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(25.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(25.0F);
    this.r.addView(this.z, (ViewGroup.LayoutParams)localObject);
    localObject = this.C.getContext().getResources().getDisplayMetrics();
    this.z.init(new ApolloStoreViewController.4(this, (DisplayMetrics)localObject, paramPlayActionData));
    if (this.I == null) {
      this.I = new ApolloStoreViewController.OtherSurfaceViewRenderCallBack(this);
    }
    this.z.getRender().setRenderCallback(this.I);
    label253:
    this.o = 1;
    this.y.onExecDispose();
    this.y.stopLoopDelayed(50L);
    this.B.removeMessages(15);
    TextView localTextView = this.d;
    if (TextUtils.isEmpty(this.e)) {
      localObject = HardCodeUtil.a(2131898823);
    } else {
      localObject = this.e;
    }
    localTextView.setText((CharSequence)localObject);
    if (!TextUtils.isEmpty(this.f))
    {
      this.Z.setVisibility(0);
      this.Z.setText(this.f);
    }
    else
    {
      this.Z.setVisibility(8);
    }
    if ((paramPlayActionData.feeType != 1) && (paramPlayActionData.vipLevel > 0))
    {
      boolean bool = QZoneVipInfoManager.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "isSuperYellow:", Boolean.valueOf(bool) });
      }
      if (TextUtils.isEmpty(this.f)) {
        this.Z.setText(this.C.getContext().getResources().getString(2131886692));
      }
      this.Z.setVisibility(0);
      this.aa.setVisibility(0);
      ApolloUtilImpl.setApolloLv(this.aa, paramPlayActionData.vipLevel);
      if (!bool) {
        this.k.setVisibility(0);
      } else {
        this.k.setVisibility(8);
      }
    }
    else
    {
      this.k.setVisibility(8);
      if (TextUtils.isEmpty(this.f)) {
        this.Z.setVisibility(8);
      }
      this.aa.setVisibility(8);
    }
    this.j.setTag(Integer.valueOf(paramPlayActionData.activeId));
    this.k.setTag(Integer.valueOf(paramPlayActionData.activeId));
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"result\":0,\"msg\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  private void c(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "handleMessage MSG_ADD_APOLLO");
    }
    if ((this.i) && (this.y != null))
    {
      if (this.ad == null) {
        return;
      }
      Object localObject = (ArrayList)paramMessage.getData().getSerializable("key_add_avatar_list");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        paramMessage = this.y.getRenderImpl();
        if (paramMessage == null)
        {
          QLog.e("[cmshow]ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, renderInterface null");
          return;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)localObject).next();
          if (localApolloWebAvatarParam != null) {
            synchronized (this.ae)
            {
              if (this.ae.containsKey(localApolloWebAvatarParam.apolloId))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "handleMessage MSG_ADD_APOLLO, ", localApolloWebAvatarParam.apolloId, " is showing, destroy" });
                }
                if (this.y != null) {
                  this.y.onExecDispose(localApolloWebAvatarParam.apolloId);
                }
                this.ae.remove(localApolloWebAvatarParam.apolloId);
              }
              paramMessage.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtilImpl.getSurfaceScale(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.y.getHeight() / this.J - localApolloWebAvatarParam.y);
              if (localApolloWebAvatarParam.roleId == 0) {
                paramMessage.a(1, localApolloWebAvatarParam.apolloId, ApolloResHelperImpl.DEFAULT_DRESSIDS_ROLE0, null);
              } else if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
                paramMessage.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
              }
              synchronized (this.ae)
              {
                this.ae.put(localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam);
              }
            }
          }
        }
        this.y.stopLoopDelayed(15000L);
        return;
      }
      QLog.e("[cmshow]ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, avatar list null");
    }
  }
  
  private void d(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "handleMessage MSG_CODE_REFRESH_APOLLO");
    }
    if ((this.i) && (this.y != null) && (this.o != 0))
    {
      int i1 = paramMessage.getData().getInt("key_operation");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "handleMessage MSG_CODE_REFRESH_APOLLO, opFlag=", Integer.valueOf(i1) });
      }
      if (i1 == 1)
      {
        s();
        this.y.onExecDispose("friend");
      }
      else
      {
        ??? = this.ad;
        if (??? != null) {
          if (!TextUtils.isEmpty(((ApolloWebAvatarParam)???).apolloId)) {
            this.y.onExecDispose(this.ad.apolloId);
          } else {
            this.y.onExecDispose();
          }
        }
        this.y.onExecDispose("friend");
      }
      ??? = this.ad;
      if ((??? != null) && (!TextUtils.isEmpty(((ApolloWebAvatarParam)???).apolloId)))
      {
        this.y.getRenderImpl().a(1, this.ad.apolloId, this.ad.roleId, this.l, this.ad.x, this.y.getHeight() / this.J - this.ad.y);
        if (this.ad.roleId == 0) {
          this.y.getRenderImpl().a(1, this.ad.apolloId, ApolloResHelperImpl.DEFAULT_DRESSIDS_ROLE0, null);
        } else if ((this.ad.roleId > 0) && (this.ad.dressIds != null)) {
          this.y.getRenderImpl().a(1, this.ad.apolloId, this.ad.dressIds, null);
        }
        synchronized (this.ae)
        {
          this.ae.put(this.ad.apolloId, this.ad);
          if ((paramMessage.arg1 > 0) && (!TextUtils.isEmpty(this.M)) && (this.O) && (this.N == 0))
          {
            this.c = false;
            ApolloBubbleLogic.a.set(8);
            this.y.getRenderImpl().b(8, this.ad.apolloId, 1, this.ad.roleId, this.M, null);
          }
          else if ((this.T) && (!TextUtils.isEmpty(this.ad.greeting)))
          {
            ApolloBubbleLogic.a.set(8);
            this.c = true;
            this.y.getRenderImpl().b(8, this.ad.apolloId, 1, this.ad.roleId, this.ad.greeting, null);
          }
          else
          {
            this.c = false;
          }
        }
      }
      this.y.stopLoopDelayed(15000L);
      this.o = 0;
      this.u = true;
      this.p = false;
      paramMessage = this.g;
      if (paramMessage != null) {
        paramMessage.a(this.y);
      }
    }
    a(false);
    if (this.i)
    {
      paramMessage = this.y;
      if ((paramMessage != null) && (paramMessage.getVisibility() != 0)) {
        this.B.sendEmptyMessageDelayed(21, 100L);
      }
    }
  }
  
  private MediaPlayer i()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setOnPreparedListener(this);
    localMediaPlayer.setOnErrorListener(this);
    return localMediaPlayer;
  }
  
  private void j()
  {
    if (this.V) {
      return;
    }
    if (this.ad == null) {
      return;
    }
    int i1 = this.Y;
    int i4 = 0;
    if (i1 == 0) {}
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        String str = ApolloUtilImpl.getAudioPathForAction(this.b, this.ah);
        if (FileUtils.fileExists(str))
        {
          if (this.Q == null) {
            this.Q = ((AudioManager)this.C.getContext().getSystemService("audio"));
          }
          if (this.R == null) {
            this.R = ((TelephonyManager)this.C.getContext().getSystemService("phone"));
          }
          if ((this.Q == null) || (this.Q.getRingerMode() != 1)) {
            break label801;
          }
          i1 = 1;
          if ((this.Q == null) || (this.Q.getStreamVolume(2) != 0)) {
            break label806;
          }
          i2 = 1;
          if ((this.R == null) || (this.R.getCallState() != 0)) {
            break label811;
          }
          i3 = 1;
          if ((i1 != 0) || (i2 != 0) || (i3 == 0) || (!CardDrawerStrategy.c())) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[playActionSound] ");
            localStringBuilder.append(this.b);
            localStringBuilder.append(" ");
            localStringBuilder.append(str);
            QLog.d("[cmshow]ApolloViewController", 2, localStringBuilder.toString());
          }
          try
          {
            QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
            if (this.P == null) {
              this.P = i();
            }
            this.P.reset();
            this.P.setDataSource(str);
            this.P.prepareAsync();
            return;
          }
          catch (Throwable localThrowable1)
          {
            QLog.e("[cmshow]ApolloViewController", 1, localThrowable1.getMessage());
            return;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[playActionSound] not found file for ");
        localStringBuilder.append(localThrowable1);
        QLog.e("[cmshow]ApolloViewController", 1, localStringBuilder.toString());
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("[cmshow]ApolloViewController", 1, localThrowable2, new Object[] { "[playActionSound] exception" });
      }
      i1 = this.Y;
      Object localObject;
      if (i1 > 0)
      {
        localObject = this.ah.i(i1);
        if (new File((String)localObject).exists())
        {
          this.B.sendEmptyMessageDelayed(24, (int)(this.X * 1000.0F));
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[playActionSound] error, audio is not exists! audioPath = ");
        localStringBuilder.append((String)localObject);
        QLog.e("[cmshow]ApolloViewController", 1, localStringBuilder.toString());
        return;
      }
      if ((!TextUtils.isEmpty(a)) && ("interactive".equals(this.ad.tab)))
      {
        this.B.sendEmptyMessageDelayed(24, 0L);
        return;
      }
      if (this.W)
      {
        if (this.P == null) {
          this.P = i();
        }
        if (this.Q == null) {
          this.Q = ((AudioManager)this.C.getContext().getSystemService("audio"));
        }
        if (this.R == null) {
          this.R = ((TelephonyManager)this.C.getContext().getSystemService("phone"));
        }
        localObject = this.Q;
        if ((localObject != null) && (((AudioManager)localObject).getRingerMode() == 1)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        localObject = this.Q;
        if ((localObject != null) && (((AudioManager)localObject).getStreamVolume(2) == 0)) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        localObject = this.R;
        i3 = i4;
        if (localObject != null)
        {
          i3 = i4;
          if (((TelephonyManager)localObject).getCallState() == 0) {
            i3 = 1;
          }
        }
        if ((this.ah.g(this.b)) && (i2 == 0) && (i1 == 0) && (i3 != 0)) {
          try
          {
            QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
            this.P.reset();
            localObject = this.P;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
            localStringBuilder.append(this.b);
            localStringBuilder.append("/");
            localStringBuilder.append("music.amr");
            ((MediaPlayer)localObject).setDataSource(localStringBuilder.toString());
            this.P.prepare();
            this.P.start();
            return;
          }
          catch (Throwable localThrowable3)
          {
            QLog.e("[cmshow]ApolloViewController", 1, localThrowable3.getMessage());
          }
        }
      }
      return;
      label801:
      i1 = 0;
      continue;
      label806:
      int i2 = 0;
      continue;
      label811:
      int i3 = 0;
    }
  }
  
  private void k()
  {
    try
    {
      if ((this.P != null) && (this.P.isPlaying()))
      {
        QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
        this.P.stop();
      }
      if (this.B != null)
      {
        this.B.removeMessages(24);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloViewController", 1, localThrowable.getMessage());
    }
  }
  
  private void l()
  {
    ApolloStoreViewController.PlayActionData localPlayActionData = this.ab;
    if ((localPlayActionData != null) && (localPlayActionData.playCount > 0))
    {
      localPlayActionData = this.ab;
      localPlayActionData.playCount -= 1;
      a(this.ab);
    }
  }
  
  private void m()
  {
    ApolloTextureView localApolloTextureView = this.y;
    if ((localApolloTextureView != null) && (localApolloTextureView.getVisibility() != 0)) {
      this.y.setVisibility(0);
    }
  }
  
  private void n()
  {
    String str = this.n;
    if (str != null)
    {
      this.w.setText(str);
      this.x.setVisibility(0);
      return;
    }
    this.x.setVisibility(8);
  }
  
  private void o()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    if (this.c)
    {
      if (this.i)
      {
        localObject = this.y;
        if ((localObject != null) && (this.ad != null))
        {
          ((ApolloTextureView)localObject).getRenderImpl().a(1, this.ad.apolloId, "Bubble");
          this.y.stopLoopDelayed(15000L);
        }
      }
      this.c = false;
    }
  }
  
  private void p()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(8);
    }
    localObject = this.z;
    if (localObject != null) {
      ((ApolloTextureView)localObject).setVisibility(8);
    }
    localObject = this.y;
    if (localObject != null) {
      ((ApolloTextureView)localObject).setVisibility(0);
    }
    localObject = this.A;
    if (localObject != null) {
      ((BarrageView)localObject).a(false);
    }
    this.B.sendEmptyMessage(18);
  }
  
  private void q()
  {
    if ((this.i) && (this.y != null))
    {
      Object localObject = this.ad;
      if (localObject != null)
      {
        localObject = ApolloActionHelperImpl.getActionRscPath(4, -1, ((ApolloWebAvatarParam)localObject).roleId, true);
        this.y.getRenderImpl().a(1, this.ad.apolloId, 5, 0, localObject[0], localObject[1]);
      }
    }
  }
  
  private void r()
  {
    if (this.P == null) {
      this.P = i();
    }
    if (this.Q == null) {
      this.Q = ((AudioManager)this.C.getContext().getSystemService("audio"));
    }
    if (this.R == null) {
      this.R = ((TelephonyManager)this.C.getContext().getSystemService("phone"));
    }
    Object localObject1 = this.Q;
    int i4 = 0;
    int i1;
    if ((localObject1 != null) && (((AudioManager)localObject1).getRingerMode() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject1 = this.Q;
    int i2;
    if ((localObject1 != null) && (((AudioManager)localObject1).getStreamVolume(2) == 0)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    localObject1 = this.R;
    int i3 = i4;
    if (localObject1 != null)
    {
      i3 = i4;
      if (((TelephonyManager)localObject1).getCallState() == 0) {
        i3 = 1;
      }
    }
    if ((new File(this.ah.i(this.Y)).exists()) && (i2 == 0) && (i1 == 0) && (i3 != 0)) {
      try
      {
        QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
        this.P.reset();
        this.P.setDataSource(this.ah.i(this.Y));
        this.P.prepare();
        this.P.start();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloViewController", 1, localThrowable.getMessage());
      }
    }
    if (TextUtils.isEmpty(a)) {
      return;
    }
    Object localObject2 = a;
    StringBuilder localStringBuilder;
    if (((String)localObject2).startsWith("def"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.a);
      localStringBuilder.append("/");
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/");
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
    }
    a = "";
    localObject2 = ApolloUtilImpl.getFile((String)localObject2, "amr");
    if (localObject2 == null) {
      return;
    }
    try
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
      this.P.reset();
      this.P.setDataSource(((File)localObject2).getPath());
      this.P.prepare();
      this.P.start();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "[destoryAllAvatars]");
    }
    if (this.y == null)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[destoryAllAvatars] surfaceView null");
      return;
    }
    synchronized (this.ae)
    {
      Iterator localIterator = this.ae.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (this.y != null)) {
          this.y.onExecDispose(str);
        }
      }
      this.ae.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public String a(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return b("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return b("no apolloId");
    }
    if (!ApolloEngine.isEngineReady())
    {
      QLog.e("[cmshow]ApolloViewController", 1, "ApolloEngine is not ready");
      return b("ApolloEngine is not ready");
    }
    if (!this.ah.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898808), 0).show();
      return b("dresses is not download!");
    }
    if ((!TextUtils.isEmpty(this.af)) && (!this.af.equals(paramApolloWebAvatarParam.tab)) && (this.y.getRenderImpl() != null)) {
      this.y.getRenderImpl().a(paramApolloWebAvatarParam.apolloId);
    }
    this.B.postDelayed(new ApolloStoreViewController.2(this, paramInt, paramBoolean, paramApolloWebAvatarParam), 100L);
    return c("initAvatar成功");
  }
  
  public String a(ApolloStoreViewController.PlayActionData paramPlayActionData)
  {
    if (this.ag)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "previewAction 小人已隐藏");
      return b(HardCodeUtil.a(2131898814));
    }
    if (paramPlayActionData == null) {
      return b("actionData is null");
    }
    if (paramPlayActionData.playCount > 1) {
      this.ab = paramPlayActionData;
    } else {
      this.ab = null;
    }
    if ((paramPlayActionData.actionType == 1) && (!TextUtils.isEmpty(paramPlayActionData.apolloId)) && (this.ad != null) && (!paramPlayActionData.apolloId.equals(this.ad.apolloId))) {
      return b(HardCodeUtil.a(2131898819));
    }
    if (TextUtils.isEmpty(paramPlayActionData.apolloId))
    {
      localApolloWebAvatarParam = this.ad;
      if (localApolloWebAvatarParam != null) {
        paramPlayActionData.apolloId = localApolloWebAvatarParam.apolloId;
      }
    }
    if (TextUtils.isEmpty(paramPlayActionData.apolloId)) {
      return b("未传apolloId");
    }
    if (!this.ae.containsKey(paramPlayActionData.apolloId)) {
      return b(HardCodeUtil.a(2131898817));
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)this.ae.get(paramPlayActionData.apolloId);
    if (localApolloWebAvatarParam == null) {
      return b(HardCodeUtil.a(2131898803));
    }
    int i1;
    if ((this.ad != null) && (paramPlayActionData.apolloId.equals(this.ad.apolloId))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (!this.ah.a(localApolloWebAvatarParam.uin, localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, null)))
    {
      QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898804), 0).show();
      return b(HardCodeUtil.a(2131898815));
    }
    if (!this.ah.c(paramPlayActionData.activeId, paramPlayActionData.actionType))
    {
      if (i1 != 0) {
        QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898822), 0).show();
      }
      return b(HardCodeUtil.a(2131898805));
    }
    if ((this.u) && (this.y != null) && (this.r != null) && (this.C != null))
    {
      if (i1 != 0) {
        k();
      }
      this.Y = paramPlayActionData.audioId;
      this.X = paramPlayActionData.audioStartTime;
      boolean bool;
      if (paramPlayActionData.playOriginalAudio == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.W = bool;
      this.V = paramPlayActionData.previewOnFrame;
      if ((this.ad != null) && (paramPlayActionData.apolloId.equals(this.ad.apolloId))) {
        this.b = paramPlayActionData.activeId;
      }
      this.p = true;
      this.x.setVisibility(8);
      this.B.removeMessages(16);
      this.L = paramPlayActionData.partnerRoleId;
      this.M = paramPlayActionData.text;
      this.N = paramPlayActionData.textType;
      if (paramPlayActionData.isDiyAction == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.O = bool;
      Object localObject;
      if (!paramPlayActionData.previewOnFrame)
      {
        localObject = this.U;
        if (localObject != null) {
          ((ApolloVoiceDIYHelper)localObject).a();
        }
      }
      if ((!TextUtils.isEmpty(paramPlayActionData.text)) && (!paramPlayActionData.previewOnFrame))
      {
        if (paramPlayActionData.textType == 1)
        {
          if (this.A == null)
          {
            this.A = new BarrageView(this.C.getContext(), null);
            this.A.setClickable(false);
          }
          this.A.setVisibility(0);
        }
        else
        {
          localObject = this.A;
          if (localObject != null) {
            ((BarrageView)localObject).setVisibility(8);
          }
        }
      }
      else
      {
        localObject = this.A;
        if (localObject != null) {
          ((BarrageView)localObject).setVisibility(8);
        }
      }
      if (paramPlayActionData.floatPreview == 0)
      {
        a(paramPlayActionData, localApolloWebAvatarParam);
      }
      else
      {
        if ((this.ad != null) && (!paramPlayActionData.apolloId.equals(this.ad.apolloId))) {
          return b(HardCodeUtil.a(2131898827));
        }
        b(paramPlayActionData);
      }
      a(false);
      return c(HardCodeUtil.a(2131898818));
    }
    if (i1 != 0) {
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131898820), 0).show();
    }
    return b(HardCodeUtil.a(2131898810));
  }
  
  public String a(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[addAvatar] avatarParams=", paramArrayList });
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)localObject).next();
        if (!this.ah.a(localApolloWebAvatarParam.uin, localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, null))
        {
          QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898806), 0).show();
          return b("dresses is not download!");
        }
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 27;
      ((Message)localObject).getData().putSerializable("key_add_avatar_list", paramArrayList);
      this.B.sendMessage((Message)localObject);
      return c("updateAvatar成功");
    }
    return b("no params");
  }
  
  public String a(int[] paramArrayOfInt)
  {
    if (this.ag)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "preview 小人已隐藏");
      return b(HardCodeUtil.a(2131898816));
    }
    Object localObject = this.ad;
    if (localObject == null) {
      return b(HardCodeUtil.a(2131898807));
    }
    if (!this.ah.a(((ApolloWebAvatarParam)localObject).uin, this.ad.roleId, paramArrayOfInt, null))
    {
      QQToast.makeText(this.C.getContext(), HardCodeUtil.a(2131898824), 0).show();
      return b(HardCodeUtil.a(2131898813));
    }
    if (this.u)
    {
      localObject = this.y;
      if ((localObject != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        this.ad.dressIds = paramArrayOfInt;
        if (this.p)
        {
          ((ApolloTextureView)localObject).onExecDispose();
          this.y.getRenderImpl().a(1, this.ad.apolloId, this.ad.roleId, this.l, this.ad.x, this.y.getHeight() / this.J - this.ad.y);
        }
        if ((!TextUtils.isEmpty(this.M)) && (this.O)) {
          this.y.getRenderImpl().a(1, this.ad.apolloId, "Bubble");
        }
        this.y.getRenderImpl().a(1, this.ad.apolloId, paramArrayOfInt, null);
        this.y.stopLoopDelayed(15000L);
      }
    }
    a(false);
    this.p = false;
    this.o = 0;
    this.O = false;
    this.M = null;
    paramArrayOfInt = this.A;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.setVisibility(8);
    }
    k();
    return c(HardCodeUtil.a(2131898812));
  }
  
  public void a()
  {
    if (this.r != null) {
      return;
    }
    this.r = new RelativeLayout(this.C.getContext());
    this.r.setClickable(true);
    this.r.setBackgroundColor(this.C.getContext().getResources().getColor(2131167894));
    this.r.setVisibility(4);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, (int)((float)DeviceInfoUtil.E() * 0.6F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = ViewUtils.dip2px(25.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = ViewUtils.dip2px(25.0F);
    Object localObject2 = LayoutInflater.from(this.C.getContext()).inflate(2131624194, null);
    this.j = ((Button)((View)localObject2).findViewById(2131430201));
    this.k = ((LinearLayout)((View)localObject2).findViewById(2131428489));
    this.k.setOnClickListener(this);
    this.d = ((TextView)((View)localObject2).findViewById(2131428416));
    this.j.setOnClickListener(this);
    this.Z = ((TextView)((View)localObject2).findViewById(2131428415));
    this.aa = ((ImageView)((View)localObject2).findViewById(2131428413));
    this.r.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.C.addView(this.r, new RelativeLayout.LayoutParams(-1, -1));
    long l1 = Math.max(DeviceInfoUtil.C(), DeviceInfoUtil.B());
    localObject1 = new ImageView(this.C.getContext());
    ((ImageView)localObject1).setId(2131428446);
    double d1 = l1;
    Double.isNaN(d1);
    int i1 = (int)(d1 / 16.68D + 0.5D);
    localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(d1 / 19.899999999999999D + 0.5D));
    ((ImageView)localObject1).setBackgroundResource(2130838470);
    ((ImageView)localObject1).setOnClickListener(this);
    this.r.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }
  
  public void a(int paramInt)
  {
    this.B.removeMessages(23);
    this.v = paramInt;
    if (this.T)
    {
      this.B.removeMessages(16);
      this.B.sendEmptyMessageDelayed(16, 3000L);
      return;
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = this.ad;
    if (localApolloWebAvatarParam == null) {
      return;
    }
    if ("mall".equals(localApolloWebAvatarParam.tab))
    {
      paramInt = this.v;
      if (paramInt == 0) {
        this.n = HardCodeUtil.a(2131898826);
      } else if (paramInt == 2) {
        this.n = HardCodeUtil.a(2131898811);
      } else {
        this.n = null;
      }
    }
    else
    {
      this.n = null;
    }
    if (this.S == 1) {
      this.n = this.ah.h(this.ad.roleId);
    }
    if (!TextUtils.isEmpty(this.ad.greeting)) {
      this.n = this.ad.greeting;
    }
    if (!TextUtils.isEmpty(this.n)) {
      this.B.sendEmptyMessage(17);
    } else if (Looper.myLooper() == Looper.getMainLooper()) {
      this.x.setVisibility(8);
    } else {
      this.B.sendEmptyMessage(16);
    }
    if (this.v == 1)
    {
      this.B.removeMessages(16);
      this.B.sendEmptyMessageDelayed(16, 3000L);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = true;
    QLog.d("[cmshow]ApolloViewController", 2, "Avatar view is Ready.");
    this.B.sendEmptyMessage(18);
    WeakReference localWeakReference = this.h;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((OnApolloViewListener)this.h.get()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.i) && (this.y != null))
    {
      WeakReference localWeakReference = this.h;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((OnApolloViewListener)this.h.get()).a(paramInt, paramString);
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.v = 1;
    this.n = null;
    this.x.setVisibility(8);
  }
  
  public void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    c(false);
    this.B.postDelayed(new ApolloStoreViewController.3(this, paramActivity, paramAppInterface, paramString1, paramString2), 500L);
  }
  
  public void a(OnApolloViewListener paramOnApolloViewListener)
  {
    this.h = new WeakReference(paramOnApolloViewListener);
  }
  
  public void a(String paramString)
  {
    WeakReference localWeakReference = this.h;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((OnApolloViewListener)this.h.get()).a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.s;
    if (localRelativeLayout != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localRelativeLayout.setVisibility(i1);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.F.setVisibility(0);
      Object localObject = this.G;
      float f1 = this.J;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(paramFloat1 * f1) - (this.D >> 1));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramFloat2 * f1 * 0.75F));
      this.F.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.y;
      if (localObject != null)
      {
        ((ApolloTextureView)localObject).onExecDispose();
        this.y.setVisibility(4);
      }
    }
    else
    {
      this.F.setVisibility(8);
    }
  }
  
  public void b()
  {
    ApolloTextureView localApolloTextureView = this.y;
    if (localApolloTextureView != null)
    {
      localApolloTextureView.setVisibility(8);
      this.y.onExecDispose();
      this.ag = true;
      QLog.d("[cmshow]ApolloViewController", 2, "hideAndDispose");
    }
  }
  
  public void b(int paramInt)
  {
    ApolloTextureView localApolloTextureView = this.y;
    if (localApolloTextureView != null) {
      if (paramInt > 0)
      {
        localApolloTextureView.setVisibility(0);
        localApolloTextureView = this.y;
        if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null))
        {
          this.y.getRenderImpl().b();
          this.y.getRenderImpl().a(1000L);
        }
        this.ag = false;
      }
      else
      {
        this.ag = true;
        localApolloTextureView.setVisibility(8);
        k();
        if ((this.A != null) && (!TextUtils.isEmpty(this.M))) {
          this.A.a(false);
        }
        localApolloTextureView = this.y;
        if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null)) {
          this.y.getRenderImpl().a(0L);
        }
      }
    }
    QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "setApolloViewVisibility visibility:", Integer.valueOf(paramInt) });
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[destoryAvatar] apolloIdList=", paramArrayList });
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      synchronized (this.ae)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          if ((!TextUtils.isEmpty(str)) && (this.y != null) && (this.ae.containsKey(str)))
          {
            this.y.onExecDispose(str);
            this.ae.remove(str);
          }
        }
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ApolloTextureView localApolloTextureView = this.y;
    if (localApolloTextureView != null) {
      localApolloTextureView.disableTouchEvent(paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    k();
    if ((this.A != null) && (!TextUtils.isEmpty(this.M))) {
      if (paramBoolean) {
        this.A.a(false);
      } else {
        this.A.b();
      }
    }
    ApolloTextureView localApolloTextureView = this.y;
    if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null)) {
      this.y.getRenderImpl().a(0L);
    }
    this.o = 1;
    this.B.obtainMessage(18).sendToTarget();
  }
  
  public boolean c()
  {
    return (this.i) && (this.y != null);
  }
  
  public String d()
  {
    this.Y = 0;
    if (c())
    {
      Object localObject = this.ad;
      if (localObject != null)
      {
        this.b = 5;
        localObject = ApolloActionHelperImpl.getActionRscPath(10, -1, ((ApolloWebAvatarParam)localObject).roleId, true);
        if ((localObject.length > 0) && (!TextUtils.isEmpty(localObject[0])) && (localObject[0].length() - 6 > 0)) {
          a = localObject[0].substring(0, localObject[0].length() - 6);
        }
        this.y.getRenderImpl().a(1, this.ad.apolloId, 5, 0, localObject[0], localObject[1]);
        return c("sayHi Ok");
      }
    }
    this.B.sendEmptyMessageDelayed(22, 100L);
    return b(HardCodeUtil.a(2131898809));
  }
  
  public void e()
  {
    if (this.P != null)
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
      this.P.stop();
    }
  }
  
  public void f()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.y);
      }
      this.y.getRenderImpl().c();
    }
    localObject = this.z;
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.z);
      }
      this.z.getRenderImpl().c();
    }
    this.B.removeCallbacksAndMessages(null);
    localObject = this.A;
    if (localObject != null) {
      ((BarrageView)localObject).a();
    }
    s();
    k();
    localObject = this.ac;
    if (localObject != null) {
      ((ApolloImageShareLayout)localObject).a(true);
    }
    localObject = this.P;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).release();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, "[onDestroy] release player");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "onDestroy");
    }
  }
  
  public ApolloTextureView g()
  {
    return this.y;
  }
  
  public int h()
  {
    return this.b;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 20: 
    case 26: 
    default: 
      break;
    case 28: 
      b(paramMessage);
      break;
    case 27: 
      c(paramMessage);
      break;
    case 25: 
      l();
      break;
    case 24: 
      r();
      break;
    case 23: 
      a(this.v);
      return true;
    case 22: 
      q();
      break;
    case 21: 
      m();
      break;
    case 19: 
      a(paramMessage);
      return true;
    case 18: 
      d(paramMessage);
      break;
    case 17: 
      n();
      return true;
    case 16: 
      o();
      return true;
    case 15: 
      p();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428446)
    {
      this.B.sendEmptyMessage(15);
      k();
      return;
    }
    if ((paramView == this.k) || (paramView == this.j))
    {
      k();
      if ((this.g != null) && ((paramView.getTag() instanceof Integer))) {
        this.g.a(((Integer)paramView.getTag()).intValue());
      }
      this.B.sendEmptyMessage(15);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("[onError] ");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(paramInt2);
    QLog.e("[cmshow]ApolloViewController", 1, paramMediaPlayer.toString());
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.P != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, "[onPrepared] start play");
      }
      this.P.start();
    }
  }
  
  @TargetApi(14)
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView = this.x;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.x.setTranslationX(-paramInt1);
        this.x.setTranslationY(-paramInt2);
      }
      paramView = this.A;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.A.setTranslationX(-paramInt1);
        this.A.setTranslationY(-paramInt2);
      }
      paramView = this.y;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.y.setTranslationX(-paramInt1);
        this.y.setTranslationY(-paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreViewController
 * JD-Core Version:    0.7.0.1
 */