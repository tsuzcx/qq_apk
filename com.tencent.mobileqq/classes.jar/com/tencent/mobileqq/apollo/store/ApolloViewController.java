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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
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
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
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

public class ApolloViewController
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener, TouchWebView.OnScrollChangedListener, OnApolloViewListener
{
  private float jdField_a_of_type_Float;
  public int a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private BarrageView jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
  private ApolloImageShareLayout jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout;
  private ApolloViewController.PlayActionData jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData;
  private ApolloVoiceDIYHelper jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper;
  private ApolloWebAvatarParam jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
  private IApolloViewControllerCallBack jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloViewControllerCallBack;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
  private IRenderCallback jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  String jdField_a_of_type_JavaLangString;
  private WeakReference<OnApolloViewListener> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, ApolloWebAvatarParam> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
  private IRenderCallback jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 2.0F;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float = 1.0F;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  
  public ApolloViewController(RelativeLayout paramRelativeLayout, IApolloViewControllerCallBack paramIApolloViewControllerCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloViewControllerCallBack = paramIApolloViewControllerCallBack;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    paramRelativeLayout = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout = paramRelativeLayout.getContext();
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView = new ApolloTextureView(paramRelativeLayout, null);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.init(this);
      if (BaseApplicationImpl.sProcessId == 7) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setDumplicateCreateRenderThread(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setClickable(false);
      paramIApolloViewControllerCallBack = new RelativeLayout.LayoutParams(100, 100);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback = new ApolloViewController.1(this);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRender().setRenderCallback(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, paramIApolloViewControllerCallBack);
      this.jdField_e_of_type_Float = (FontSettingManager.getFontLevel() / 16.0F);
      if (this.jdField_e_of_type_Float != 0.0F) {
        this.jdField_d_of_type_Float = (DeviceInfoUtil.a() / this.jdField_e_of_type_Float);
      }
      if (this.jdField_d_of_type_Float == 0.0F) {
        this.jdField_d_of_type_Float = DeviceInfoUtil.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839401);
      this.jdField_d_of_type_Int = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
      this.jdField_e_of_type_Int = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(10, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper = new ApolloVoiceDIYHelper();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramRelativeLayout);
      paramIApolloViewControllerCallBack = new ImageView(paramRelativeLayout);
      paramIApolloViewControllerCallBack.setImageResource(2130839401);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramIApolloViewControllerCallBack, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8366104);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramRelativeLayout = new FrameLayout.LayoutParams(-1, -1);
      paramRelativeLayout.leftMargin = ApolloUtilImpl.dp2px(15.0F, this.jdField_d_of_type_Float);
      paramRelativeLayout.rightMargin = ApolloUtilImpl.dp2px(15.0F, this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130838576);
      paramRelativeLayout = new RelativeLayout.LayoutParams(ApolloUtilImpl.dp2px(81.0F, this.jdField_d_of_type_Float), ApolloUtilImpl.dp2px(58.0F, this.jdField_d_of_type_Float));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      float f1 = this.jdField_e_of_type_Float;
      if (f1 != 0.0F) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F / f1);
      }
      a();
      return;
    }
    throw new RuntimeException("rootView must not null");
  }
  
  private MediaPlayer a()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setOnPreparedListener(this);
    localMediaPlayer.setOnErrorListener(this);
    return localMediaPlayer;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"result\":1,\"msg\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  private void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null) {
        return;
      }
      int m = paramMessage.arg2;
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(4);
      this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(0);
      float f1;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        f1 = 77.0F;
      } else {
        f1 = 42.0F;
      }
      float f4 = (float)(Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g()) / 7L) / 368.0F;
      Object localObject = paramMessage.obj;
      float f3 = 0.0F;
      float f2;
      int k;
      if ((localObject != null) && ((localObject instanceof Float)))
      {
        f2 = ((Float)localObject).floatValue();
        k = 1;
      }
      else
      {
        f2 = 0.0F;
        k = 0;
      }
      int n = paramMessage.arg1;
      if ((n == 1) && (CMResUtil.b(this.jdField_f_of_type_Int)))
      {
        f3 = 330.0F * f4 / DeviceInfoUtil.jdField_a_of_type_Float / 2.0F;
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, this.jdField_f_of_type_Int, f4, this.jdField_c_of_type_Float - f3, f1);
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.jdField_f_of_type_Int), null);
        paramMessage = ApolloActionHelperImpl.getActionRscPath(13, m, this.jdField_f_of_type_Int, false);
        if (k != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, m, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, n);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(f2);
        }
        else
        {
          this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, m, 0, paramMessage[0], paramMessage[1]);
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, f4, this.jdField_c_of_type_Float + f3, f1);
      this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
      paramMessage = ApolloActionHelperImpl.getActionRscPath(13, m, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
      this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(1000L);
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, m, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, n);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(f2);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, m, 0, paramMessage[0], paramMessage[1]);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (this.jdField_g_of_type_Int == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
          if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
          {
            k = (int)((float)(DeviceInfoUtil.j() / 7L) * 1.14F);
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != paramMessage)
            {
              if (paramMessage != null) {
                ((ViewGroup)paramMessage).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
              }
              paramMessage = new RelativeLayout.LayoutParams(-1, k);
              paramMessage.addRule(12, -1);
              paramMessage.leftMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
              paramMessage.rightMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
              paramMessage.bottomMargin = (AIOUtils.b(f1, this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources()) + (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight()) / 2);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, 1, paramMessage);
            }
            ApolloBarrageUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), k, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", this.jdField_d_of_type_JavaLangString, true);
          }
        }
        else
        {
          ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().b(0, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_d_of_type_JavaLangString, null);
        }
      }
      else {
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
      }
    }
  }
  
  private String b(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return a("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return a("no apolloId");
    }
    if (!ApolloActionHelperImpl.isRscValid(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700795), 0).a();
      return a("dresses is not download!");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam = paramApolloWebAvatarParam;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
      this.j = false;
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(0);
      if ((paramApolloWebAvatarParam.tapRectWidth > 0) && (paramApolloWebAvatarParam.tapRectHeight > 0))
      {
        float f1 = paramApolloWebAvatarParam.tapRectX * this.jdField_d_of_type_Float;
        float f2 = paramApolloWebAvatarParam.tapRectY * this.jdField_d_of_type_Float;
        ??? = new RectF(f1, f2, paramApolloWebAvatarParam.tapRectWidth * this.jdField_d_of_type_Float + f1, paramApolloWebAvatarParam.tapRectHeight * this.jdField_d_of_type_Float + f2);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setTouchableRect((RectF)???);
        ??? = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
      }
      else
      {
        ??? = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y * this.jdField_d_of_type_Float));
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setTouchableRect(null);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.bringToFront();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.type;
      this.jdField_g_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(23, 500L);
      if (Float.compare(0.0F, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate) == 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate = 0.2F;
      }
      this.jdField_a_of_type_Float = ApolloUtilImpl.getSurfaceScale(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * 330.0F / this.jdField_d_of_type_Float);
      ??? = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)???).addRule(10);
      ((RelativeLayout.LayoutParams)???).addRule(11);
      ((RelativeLayout.LayoutParams)???).width = ApolloUtilImpl.dp2px(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate * 81.0F / 0.289F, this.jdField_d_of_type_Float);
      ((RelativeLayout.LayoutParams)???).height = ApolloUtilImpl.dp2px(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate * 58.0F / 0.289F, this.jdField_d_of_type_Float);
      ((RelativeLayout.LayoutParams)???).topMargin = ((int)(paramApolloWebAvatarParam.y * this.jdField_d_of_type_Float - (float)DeviceInfoUtil.j() * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate));
      ((RelativeLayout.LayoutParams)???).rightMargin = ((int)((float)DeviceInfoUtil.i() - this.jdField_d_of_type_Float * paramApolloWebAvatarParam.x - ((RelativeLayout.LayoutParams)???).width - ApolloUtilImpl.dp2px(68.0F, this.jdField_d_of_type_Float) * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate * 12.0F / 0.289F);
      f();
      this.jdField_b_of_type_Int = 1;
      paramApolloWebAvatarParam = Message.obtain();
      paramApolloWebAvatarParam.getData().putInt("key_operation", 1);
      paramApolloWebAvatarParam.what = 18;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramApolloWebAvatarParam);
      a(false, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
      a(false);
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_f_of_type_Boolean = false;
      paramApolloWebAvatarParam = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
      if (paramApolloWebAvatarParam != null) {
        paramApolloWebAvatarParam.setVisibility(8);
      }
      return b("initAvatar成功");
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"result\":0,\"msg\":\"");
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
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          return;
        }
        ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localApolloWebAvatarParam == null) {
          return;
        }
        ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl();
        if (localApolloRenderInterfaceImpl == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose(str);
        localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtilImpl.getSurfaceScale(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - localApolloWebAvatarParam.y);
        if (localApolloWebAvatarParam.roleId == 0) {
          localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, ApolloResDownloaderImpl.DEFAULT_DRESSIDS_ROLE0, null);
        } else if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
          localApolloRenderInterfaceImpl.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
        return;
      }
    }
    QLog.e("[cmshow]ApolloViewController", 1, new Object[] { "[handleMessage] MSG_RESET_APOLLO, surface not ready, mSurfaceReady=", Boolean.valueOf(this.jdField_b_of_type_Boolean), ", mSurfaceView=", this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView });
  }
  
  private void c(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "handleMessage MSG_ADD_APOLLO");
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null) {
        return;
      }
      Object localObject = (ArrayList)paramMessage.getData().getSerializable("key_add_avatar_list");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl();
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
            synchronized (this.jdField_a_of_type_JavaUtilHashMap)
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localApolloWebAvatarParam.apolloId))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "handleMessage MSG_ADD_APOLLO, ", localApolloWebAvatarParam.apolloId, " is showing, destroy" });
                }
                if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) {
                  this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose(localApolloWebAvatarParam.apolloId);
                }
                this.jdField_a_of_type_JavaUtilHashMap.remove(localApolloWebAvatarParam.apolloId);
              }
              paramMessage.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtilImpl.getSurfaceScale(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - localApolloWebAvatarParam.y);
              if (localApolloWebAvatarParam.roleId == 0) {
                paramMessage.a(1, localApolloWebAvatarParam.apolloId, ApolloResDownloaderImpl.DEFAULT_DRESSIDS_ROLE0, null);
              } else if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
                paramMessage.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashMap)
              {
                this.jdField_a_of_type_JavaUtilHashMap.put(localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam);
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
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
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_b_of_type_Int != 0))
    {
      int k = paramMessage.getData().getInt("key_operation");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "handleMessage MSG_CODE_REFRESH_APOLLO, opFlag=", Integer.valueOf(k) });
      }
      if (k == 1)
      {
        n();
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose("friend");
      }
      else
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
        if (??? != null) {
          if (!TextUtils.isEmpty(((ApolloWebAvatarParam)???).apolloId)) {
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose("friend");
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
      if ((??? != null) && (!TextUtils.isEmpty(((ApolloWebAvatarParam)???).apolloId)))
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId == 0) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, ApolloResDownloaderImpl.DEFAULT_DRESSIDS_ROLE0, null);
        } else if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId > 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds != null)) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
          if ((paramMessage.arg1 > 0) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_f_of_type_Boolean) && (this.jdField_g_of_type_Int == 0))
          {
            this.jdField_a_of_type_Boolean = false;
            ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_d_of_type_JavaLangString, null);
          }
          else if ((this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)))
          {
            ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting, null);
          }
          else
          {
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
      this.jdField_b_of_type_Int = 0;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = false;
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloViewControllerCallBack;
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView);
      }
    }
    a(false);
    if (this.jdField_b_of_type_Boolean)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
      if ((paramMessage != null) && (paramMessage.getVisibility() != 0)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(21, 100L);
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null) {
      return;
    }
    int k = this.jdField_i_of_type_Int;
    int i1 = 0;
    if (k == 0) {}
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        String str = ApolloUtilImpl.getAudioPathForAction(this.jdField_a_of_type_Int);
        if (FileUtils.fileExists(str))
        {
          if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
            this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
          }
          if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
            this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
          }
          if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() != 1)) {
            break label757;
          }
          k = 1;
          if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2) != 0)) {
            break label762;
          }
          m = 1;
          if ((this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() != 0)) {
            break label767;
          }
          n = 1;
          if ((k != 0) || (m != 0) || (n == 0) || (!CardDrawerStatus.b())) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[playActionSound] ");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append(" ");
            localStringBuilder.append(str);
            QLog.d("[cmshow]ApolloViewController", 2, localStringBuilder.toString());
          }
          try
          {
            QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
            if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
              this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
            }
            this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(str);
            this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
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
      if (this.jdField_i_of_type_Int > 0)
      {
        if (new File(((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(this.jdField_i_of_type_Int)).exists()) {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(24, (int)(this.jdField_f_of_type_Float * 1000.0F));
        }
      }
      else
      {
        if ((!TextUtils.isEmpty(ApolloActionManager.a().jdField_a_of_type_JavaLangString)) && ("interactive".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab)))
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(24, 0L);
          return;
        }
        if (this.jdField_i_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
            this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
          }
          if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
            this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
          }
          if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
            this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
          }
          Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
          if ((localObject != null) && (((AudioManager)localObject).getRingerMode() == 1)) {
            k = 1;
          } else {
            k = 0;
          }
          localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
          if ((localObject != null) && (((AudioManager)localObject).getStreamVolume(2) == 0)) {
            m = 1;
          } else {
            m = 0;
          }
          localObject = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
          n = i1;
          if (localObject != null)
          {
            n = i1;
            if (((TelephonyManager)localObject).getCallState() == 0) {
              n = 1;
            }
          }
          if ((ApolloResDownloaderImpl.hasSound(this.jdField_a_of_type_Int)) && (m == 0) && (k == 0) && (n != 0)) {
            try
            {
              QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
              this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
              localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
              localStringBuilder.append(this.jdField_a_of_type_Int);
              localStringBuilder.append("/");
              localStringBuilder.append("music.amr");
              ((MediaPlayer)localObject).setDataSource(localStringBuilder.toString());
              this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
              this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
              return;
            }
            catch (Throwable localThrowable3)
            {
              QLog.e("[cmshow]ApolloViewController", 1, localThrowable3.getMessage());
            }
          }
        }
      }
      return;
      label757:
      k = 0;
      continue;
      label762:
      int m = 0;
      continue;
      label767:
      int n = 0;
    }
  }
  
  private void f()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(24);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloViewController", 1, localThrowable.getMessage());
    }
  }
  
  private void g()
  {
    ApolloViewController.PlayActionData localPlayActionData = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData;
    if ((localPlayActionData != null) && (localPlayActionData.jdField_a_of_type_Int > 0))
    {
      localPlayActionData = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData;
      localPlayActionData.jdField_a_of_type_Int -= 1;
      a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData);
    }
  }
  
  private void h()
  {
    ApolloTextureView localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if ((localApolloTextureView != null) && (localApolloTextureView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(0);
    }
  }
  
  private void i()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if (str != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null))
        {
          ((ApolloTextureView)localObject).getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(8);
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localObject != null) {
      ((ApolloTextureView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localObject != null) {
      ((ApolloTextureView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
    if (localObject != null) {
      ((BarrageView)localObject).a(false);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(18);
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
      if (localObject != null)
      {
        localObject = ApolloActionHelperImpl.getActionRscPath(4, -1, ((ApolloWebAvatarParam)localObject).roleId, true);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, localObject[0], localObject[1]);
      }
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
    }
    Object localObject1 = this.jdField_a_of_type_AndroidMediaAudioManager;
    int i1 = 0;
    int k;
    if ((localObject1 != null) && (((AudioManager)localObject1).getRingerMode() == 1)) {
      k = 1;
    } else {
      k = 0;
    }
    localObject1 = this.jdField_a_of_type_AndroidMediaAudioManager;
    int m;
    if ((localObject1 != null) && (((AudioManager)localObject1).getStreamVolume(2) == 0)) {
      m = 1;
    } else {
      m = 0;
    }
    localObject1 = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
    int n = i1;
    if (localObject1 != null)
    {
      n = i1;
      if (((TelephonyManager)localObject1).getCallState() == 0) {
        n = 1;
      }
    }
    if ((new File(((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(this.jdField_i_of_type_Int)).exists()) && (m == 0) && (k == 0) && (n != 0)) {
      try
      {
        QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(this.jdField_i_of_type_Int));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloViewController", 1, localThrowable.getMessage());
      }
    }
    if (TextUtils.isEmpty(ApolloActionManager.a().jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject2 = ApolloActionManager.a().jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder;
    if (((String)localObject2).startsWith("def"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.jdField_a_of_type_JavaLangString);
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
    ApolloActionManager.a().jdField_a_of_type_JavaLangString = "";
    localObject2 = ApolloUtilImpl.getFile((String)localObject2, "amr");
    if (localObject2 == null) {
      return;
    }
    try
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((File)localObject2).getPath());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, "[destoryAllAvatars]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView == null)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[destoryAllAvatars] surfaceView null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose(str);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
  }
  
  public String a()
  {
    this.jdField_i_of_type_Int = 0;
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = 5;
        localObject = ApolloActionHelperImpl.getActionRscPath(10, -1, ((ApolloWebAvatarParam)localObject).roleId, true);
        if ((localObject.length > 0) && (!TextUtils.isEmpty(localObject[0])) && (localObject[0].length() - 6 > 0)) {
          ApolloActionManager.a().jdField_a_of_type_JavaLangString = localObject[0].substring(0, localObject[0].length() - 6);
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, localObject[0], localObject[1]);
        return b("sayHi Ok");
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(22, 100L);
    return a(HardCodeUtil.a(2131700783));
  }
  
  public String a(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return a("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return a("no apolloId");
    }
    if (!ApolloEngine.isEngineReady())
    {
      QLog.e("[cmshow]ApolloViewController", 1, "ApolloEngine is not ready");
      return a("ApolloEngine is not ready");
    }
    if (!ApolloActionHelperImpl.isRscValid(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700782), 0).a();
      return a("dresses is not download!");
    }
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_e_of_type_JavaLangString.equals(paramApolloWebAvatarParam.tab)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(paramApolloWebAvatarParam.apolloId);
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ApolloViewController.2(this, paramInt, paramBoolean, paramApolloWebAvatarParam), 100L);
    }
    else
    {
      b(paramInt, paramBoolean, paramApolloWebAvatarParam);
    }
    return b("initAvatar成功");
  }
  
  public String a(ApolloViewController.PlayActionData paramPlayActionData)
  {
    if (this.j)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "previewAction 小人已隐藏");
      return a(HardCodeUtil.a(2131700788));
    }
    if (paramPlayActionData == null) {
      return a("actionData is null");
    }
    if (paramPlayActionData.jdField_a_of_type_Int > 1) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData = paramPlayActionData;
    } else {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData = null;
    }
    if ((paramPlayActionData.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(paramPlayActionData.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramPlayActionData.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
      return a(HardCodeUtil.a(2131700793));
    }
    if (TextUtils.isEmpty(paramPlayActionData.jdField_b_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
      if (localObject1 != null) {
        paramPlayActionData.jdField_b_of_type_JavaLangString = ((ApolloWebAvatarParam)localObject1).apolloId;
      }
    }
    if (TextUtils.isEmpty(paramPlayActionData.jdField_b_of_type_JavaLangString)) {
      return a("未传apolloId");
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramPlayActionData.jdField_b_of_type_JavaLangString)) {
      return a(HardCodeUtil.a(2131700791));
    }
    Object localObject1 = (ApolloWebAvatarParam)this.jdField_a_of_type_JavaUtilHashMap.get(paramPlayActionData.jdField_b_of_type_JavaLangString);
    if (localObject1 == null) {
      return a(HardCodeUtil.a(2131700777));
    }
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (paramPlayActionData.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (!ApolloActionHelperImpl.isRscValid(((ApolloWebAvatarParam)localObject1).uin, ((ApolloWebAvatarParam)localObject1).roleId, ((ApolloWebAvatarParam)localObject1).dressIds, null)))
    {
      QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700778), 0).a();
      return a(HardCodeUtil.a(2131700789));
    }
    if (!CMResUtil.a(paramPlayActionData.jdField_b_of_type_Int, paramPlayActionData.jdField_c_of_type_Int))
    {
      if (k != 0) {
        QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700796), 0).a();
      }
      return a(HardCodeUtil.a(2131700779));
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null))
    {
      if (k != 0) {
        f();
      }
      this.jdField_i_of_type_Int = paramPlayActionData.m;
      this.jdField_f_of_type_Float = paramPlayActionData.jdField_a_of_type_Float;
      boolean bool;
      if (paramPlayActionData.l == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_i_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = paramPlayActionData.jdField_a_of_type_Boolean;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (paramPlayActionData.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
        this.jdField_a_of_type_Int = paramPlayActionData.jdField_b_of_type_Int;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
      this.jdField_f_of_type_Int = paramPlayActionData.jdField_i_of_type_Int;
      this.jdField_d_of_type_JavaLangString = paramPlayActionData.jdField_a_of_type_JavaLangString;
      this.jdField_g_of_type_Int = paramPlayActionData.k;
      if (paramPlayActionData.j == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_f_of_type_Boolean = bool;
      Object localObject2;
      if (!paramPlayActionData.jdField_a_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper;
        if (localObject2 != null) {
          ((ApolloVoiceDIYHelper)localObject2).a();
        }
      }
      if ((!TextUtils.isEmpty(paramPlayActionData.jdField_a_of_type_JavaLangString)) && (!paramPlayActionData.jdField_a_of_type_Boolean))
      {
        if (paramPlayActionData.k == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), null);
            this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setClickable(false);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(0);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
          if (localObject2 != null) {
            ((BarrageView)localObject2).setVisibility(8);
          }
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
        if (localObject2 != null) {
          ((BarrageView)localObject2).setVisibility(8);
        }
      }
      if (paramPlayActionData.jdField_d_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(0);
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
        if (localObject2 != null)
        {
          ((ApolloTextureView)localObject2).onExecDispose();
          this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(50L);
        }
        if (this.jdField_b_of_type_Int != paramPlayActionData.jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose();
          float f1 = 0.0F;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) {
            f1 = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - ((ApolloWebAvatarParam)localObject1).y;
          }
          if (paramPlayActionData.jdField_c_of_type_Int == 1)
          {
            if (CMResUtil.b(this.jdField_f_of_type_Int))
            {
              float f2 = this.jdField_b_of_type_Float / 2.0F;
              this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, this.jdField_f_of_type_Int, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x - f2, f1);
              this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.jdField_f_of_type_Int), null);
              this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x + f2, f1);
              this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x, f1);
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
          }
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
        }
        if (paramPlayActionData.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, paramPlayActionData.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, paramPlayActionData.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloVoiceDIYHelper.a(paramPlayActionData.jdField_b_of_type_Float);
        }
        else
        {
          ApolloUtilImpl.endTrace("ready resource");
          localObject2 = ApolloActionHelperImpl.getActionRscPath(13, paramPlayActionData.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, true);
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, paramPlayActionData.jdField_b_of_type_Int, 0, localObject2[0], localObject2[1]);
          if (paramPlayActionData.jdField_c_of_type_Int == 1)
          {
            localObject2 = ApolloActionHelperImpl.getActionRscPath(13, paramPlayActionData.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, false);
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(2, null, paramPlayActionData.jdField_b_of_type_Int, 0, localObject2[0], localObject2[1]);
          }
        }
        this.jdField_b_of_type_Int = paramPlayActionData.jdField_c_of_type_Int;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (!TextUtils.isEmpty(paramPlayActionData.jdField_a_of_type_JavaLangString))
        {
          if (paramPlayActionData.k == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
            if (localObject2 != null)
            {
              localObject2 = ((BarrageView)localObject2).getParent();
              int n = (int)((float)DeviceInfoUtil.j() * ((ApolloWebAvatarParam)localObject1).rate * 1.14F);
              if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != localObject2)
              {
                if (localObject2 != null) {
                  ((ViewGroup)localObject2).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
                }
                localObject2 = new RelativeLayout.LayoutParams(-1, n);
                ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
                ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.jdField_d_of_type_Float - n));
                int m = this.jdField_c_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView) - 1;
                k = m;
                if (m < 0) {
                  k = 0;
                }
                this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, k, (ViewGroup.LayoutParams)localObject2);
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getHeight() != n)
              {
                localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.jdField_d_of_type_Float - n));
                this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams().height = n;
                this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
              if (!paramPlayActionData.jdField_a_of_type_Boolean) {
                ApolloBarrageUtil.a(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getWidth(), n, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", paramPlayActionData.jdField_a_of_type_JavaLangString, true);
              }
            }
          }
          else
          {
            ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().b(8, ((ApolloWebAvatarParam)localObject1).apolloId, 1, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_d_of_type_JavaLangString, null);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramPlayActionData.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
          return a(HardCodeUtil.a(2131700801));
        }
        a();
        if (this.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
          if (localObject1 != null)
          {
            ((ApolloTextureView)localObject1).onExecDispose();
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose();
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            localObject1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(19, paramPlayActionData.jdField_c_of_type_Int, paramPlayActionData.jdField_b_of_type_Int);
            if (paramPlayActionData.jdField_a_of_type_Boolean) {
              ((Message)localObject1).obj = Float.valueOf(paramPlayActionData.jdField_b_of_type_Float);
            }
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 100L);
            break label1807;
          }
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView = new ApolloTextureView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), null);
        localObject1 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDisplayMetrics().heightPixels * 0.6F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDisplayMetrics();
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.init(new ApolloViewController.4(this, (DisplayMetrics)localObject1, paramPlayActionData));
        if (this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback == null) {
          this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback = new ApolloViewController.OtherSurfaceViewRenderCallBack(this);
        }
        this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRender().setRenderCallback(this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloIRenderCallback);
        label1807:
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(50L);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          localObject1 = HardCodeUtil.a(2131700797);
        } else {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramPlayActionData.jdField_h_of_type_Int != 1) && (paramPlayActionData.jdField_e_of_type_Int > 0))
        {
          bool = QZoneVipInfoManager.a().a();
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "isSuperYellow:", Boolean.valueOf(bool) });
          }
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getString(2131690042));
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ApolloUtilImpl.setApolloLv(this.jdField_b_of_type_AndroidWidgetImageView, paramPlayActionData.jdField_e_of_type_Int);
          if (!bool) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          } else {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramPlayActionData.jdField_b_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramPlayActionData.jdField_b_of_type_Int));
      }
      a(false);
      return b(HardCodeUtil.a(2131700792));
    }
    if (k != 0) {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131700794), 0).a();
    }
    return a(HardCodeUtil.a(2131700784));
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
        if (!ApolloActionHelperImpl.isRscValid(localApolloWebAvatarParam.uin, localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, null))
        {
          QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700780), 0).a();
          return a("dresses is not download!");
        }
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 27;
      ((Message)localObject).getData().putSerializable("key_add_avatar_list", paramArrayList);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      return b("updateAvatar成功");
    }
    return a("no params");
  }
  
  public String a(int[] paramArrayOfInt)
  {
    if (this.j)
    {
      QLog.e("[cmshow]ApolloViewController", 1, "preview 小人已隐藏");
      return a(HardCodeUtil.a(2131700790));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
    if (localObject == null) {
      return a(HardCodeUtil.a(2131700781));
    }
    if (!ApolloActionHelperImpl.isRscValid(((ApolloWebAvatarParam)localObject).uin, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, paramArrayOfInt, null))
    {
      QQToast.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), HardCodeUtil.a(2131700798), 0).a();
      return a(HardCodeUtil.a(2131700787));
    }
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
      if ((localObject != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = paramArrayOfInt;
        if (this.jdField_c_of_type_Boolean)
        {
          ((ApolloTextureView)localObject).onExecDispose();
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
        }
        if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_f_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, paramArrayOfInt, null);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.stopLoopDelayed(15000L);
      }
    }
    a(false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.setVisibility(8);
    }
    f();
    return b(HardCodeUtil.a(2131700786));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getColor(2131166961));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, (int)((float)DeviceInfoUtil.j() * 0.6F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtilImpl.dp2px(25.0F, this.jdField_d_of_type_Float);
    Object localObject2 = LayoutInflater.from(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext()).inflate(2131558629, null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131364198));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131362803));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131362730));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131362729));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131362727));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    long l = Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g());
    localObject1 = new ImageView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
    ((ImageView)localObject1).setId(2131362760);
    double d1 = l;
    Double.isNaN(d1);
    int k = (int)(d1 / 16.68D + 0.5D);
    localObject2 = new RelativeLayout.LayoutParams(k, k);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(d1 / 19.899999999999999D + 0.5D));
    ((ImageView)localObject1).setBackgroundResource(2130838412);
    ((ImageView)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(23);
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(16, 3000L);
      return;
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
    if (localApolloWebAvatarParam == null) {
      return;
    }
    if ("mall".equals(localApolloWebAvatarParam.tab))
    {
      paramInt = this.jdField_c_of_type_Int;
      if (paramInt == 0) {
        this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131700800);
      } else if (paramInt == 2) {
        this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131700785);
      } else {
        this.jdField_c_of_type_JavaLangString = null;
      }
    }
    else
    {
      this.jdField_c_of_type_JavaLangString = null;
    }
    if (this.jdField_h_of_type_Int == 1) {
      this.jdField_c_of_type_JavaLangString = ApolloResDownloaderImpl.readRoleBubbleTips(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)) {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(17);
    } else if (Looper.myLooper() == Looper.getMainLooper()) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    } else {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(16);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(16, 3000L);
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    c(false);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ApolloViewController.3(this, paramActivity, paramAppInterface, paramString1, paramString2), 500L);
  }
  
  public void a(OnApolloViewListener paramOnApolloViewListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnApolloViewListener);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[destoryAvatar] apolloIdList=", paramArrayList });
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)))
          {
            this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose(str);
            this.jdField_a_of_type_JavaUtilHashMap.remove(str);
          }
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      int k;
      if (paramBoolean) {
        k = 0;
      } else {
        k = 8;
      }
      localRelativeLayout.setVisibility(k);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      float f1 = this.jdField_d_of_type_Float;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(paramFloat1 * f1) - (this.jdField_d_of_type_Int >> 1));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramFloat2 * f1 * 0.75F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
      if (localObject != null)
      {
        ((ApolloTextureView)localObject).onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setVisibility(4);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null);
  }
  
  public void b()
  {
    ApolloTextureView localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localApolloTextureView != null)
    {
      localApolloTextureView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.onExecDispose();
      this.j = true;
      QLog.d("[cmshow]ApolloViewController", 2, "hideAndDispose");
    }
  }
  
  public void b(int paramInt)
  {
    ApolloTextureView localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localApolloTextureView != null) {
      if (paramInt > 0)
      {
        localApolloTextureView.setVisibility(0);
        localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
        if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().b();
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(1000L);
        }
        this.j = false;
      }
      else
      {
        this.j = true;
        localApolloTextureView.setVisibility(8);
        f();
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
        }
        localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
        if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(0L);
        }
      }
    }
    QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "setApolloViewVisibility visibility:", Integer.valueOf(paramInt) });
  }
  
  public void b(boolean paramBoolean)
  {
    ApolloTextureView localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localApolloTextureView != null) {
      localApolloTextureView.disableTouchEvent(paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
      }
    }
    ApolloTextureView localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if ((localApolloTextureView != null) && (localApolloTextureView.getRenderImpl() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().a(0L);
    }
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(18).sendToTarget();
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().c();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView);
      }
      this.jdField_b_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.getRenderImpl().c();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
    if (localObject != null) {
      ((BarrageView)localObject).a();
    }
    n();
    f();
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout;
    if (localObject != null) {
      ((ApolloImageShareLayout)localObject).a(true);
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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
      g();
      break;
    case 24: 
      m();
      break;
    case 23: 
      a(this.jdField_c_of_type_Int);
      return true;
    case 22: 
      l();
      break;
    case 21: 
      h();
      break;
    case 19: 
      a(paramMessage);
      return true;
    case 18: 
      d(paramMessage);
      break;
    case 17: 
      i();
      return true;
    case 16: 
      j();
      return true;
    case 15: 
      k();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362760)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(15);
      f();
      return;
    }
    if ((paramView == this.jdField_a_of_type_AndroidWidgetLinearLayout) || (paramView == this.jdField_a_of_type_AndroidWidgetButton))
    {
      f();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloViewControllerCallBack != null) && ((paramView.getTag() instanceof Integer))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreIApolloViewControllerCallBack.a(((Integer)paramView.getTag()).intValue());
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(15);
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
  
  public void onNotifyLongTouch(String paramString)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((OnApolloViewListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onNotifyLongTouch(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView != null))
    {
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((OnApolloViewListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onNotifyStatusChanged(paramInt, paramString);
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloViewController", 2, "[onPrepared] start play");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  @TargetApi(14)
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationX(-paramInt1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(-paramInt2);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationX(-paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationY(-paramInt2);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView;
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setTranslationX(-paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloTextureView.setTranslationY(-paramInt2);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    QLog.d("[cmshow]ApolloViewController", 2, "Avatar view is Ready.");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(18);
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((OnApolloViewListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onSurfaceReady(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController
 * JD-Core Version:    0.7.0.1
 */