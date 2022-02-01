package com.tencent.biz.tribe;

import adxr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import azjl;
import bcef;
import bgve;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import rwv;
import znu;
import znv;
import znw;
import znx;
import zny;
import znz;
import zoa;
import zob;
import zoc;
import zod;

public class TribeVideoPlugin
  extends WebViewPlugin
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, zod> jdField_a_of_type_JavaUtilHashMap;
  private Queue<String> jdField_a_of_type_JavaUtilQueue;
  private zoa jdField_a_of_type_Zoa;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  private int e = -1;
  private int f = -1;
  
  public TribeVideoPlugin()
  {
    this.mPluginNameSpace = "tribeVideoPlayer";
  }
  
  private int a()
  {
    if ((this.mRuntime.a() instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.mRuntime.a()).getSupportFragmentManager();
      if (localObject != null)
      {
        FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
        localObject = ((FragmentManager)localObject).getFragments();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Fragment localFragment = (Fragment)((Iterator)localObject).next();
            if (((localFragment instanceof WebViewFragment)) && (localFragment.isVisible())) {
              localFragmentTransaction.hide(localFragment).commit();
            }
          }
        }
      }
    }
    return 0;
  }
  
  private int a(String paramString)
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (!"".equals(paramString)) {
        break label188;
      }
      paramString = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        a(zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject), null);
        this.jdField_a_of_type_Zoa.removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      i = 0;
    }
    label188:
    do
    {
      return i;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        break;
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "realPluckVideo no such playID playerID = " + paramString);
    return -1;
    a(zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString), null);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Zoa.removeMessages(2, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(1, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(4, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(5, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(6, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(7, paramString);
    this.jdField_a_of_type_Zoa.removeMessages(8, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    zod localzod = a(paramJSONObject);
    if (localzod == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(zod.a(localzod)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(zod.b(localzod))) && (TextUtils.isEmpty(zod.c(localzod))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(zod.c(localzod))) {
      paramJSONObject = zod.c(localzod);
    }
    for (int i = 1; (zod.c(localzod) == 0.0D) || (zod.d(localzod) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = zod.b(localzod);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(zod.a(localzod)))
    {
      if (!zod.c((zod)this.jdField_a_of_type_JavaUtilHashMap.get(zod.a(localzod))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(zod.a(localzod));
    }
    ISPlayerVideoView localISPlayerVideoView = a();
    ThreadManager.post(new TribeVideoPlugin.TechReportRunnable(this, false), 5, null, true);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.bringToFront();
      this.jdField_b_of_type_Boolean = false;
    }
    ISuperPlayer localISuperPlayer;
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = zod.a(localzod);
      if (zod.a(localzod) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + zod.a(localzod) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localISuperPlayer = a(localISPlayerVideoView, paramJSONObject, i, localzod);
      zod.a(localzod, localISuperPlayer);
      if (zod.b(localzod) != 2) {
        break label549;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label390:
      a(paramJSONObject, localISuperPlayer, localzod);
      a(localISPlayerVideoView, paramJSONObject, localzod);
      if (zod.b(localzod) == 2) {
        this.mRuntime.a().setOnTouchListener(new zoc(this, zod.a(localzod)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(zod.a(localzod));
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilQueue.size() > 1)
        {
          paramJSONObject = (String)this.jdField_a_of_type_JavaUtilQueue.poll();
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramJSONObject))
          {
            a(paramJSONObject);
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + zod.a(localzod) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label549:
            if (zod.b(localzod) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560390, null);
              break label390;
            }
            if (zod.b(localzod) != 0) {
              break label634;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560391, null);
            break label390;
          }
        }
      }
      zod.a(localzod, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(zod.a(localzod), localzod);
      this.jdField_a_of_type_Boolean = false;
      return 0;
      label634:
      paramJSONObject = null;
    }
  }
  
  private int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject1 = paramJSONObject1.getString("playerID");
      if (paramJSONObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "getPlayerInfo playerID = null");
        }
        return -1;
      }
    }
    catch (Exception paramJSONObject1)
    {
      for (;;)
      {
        QLog.e("TribeVideoPlugin", 1, "getPlayerInfo Err:" + paramJSONObject1.toString());
        paramJSONObject1 = null;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramJSONObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TribeVideoPlugin", 2, "getPlayerInfo no such playID playerID = " + paramJSONObject1);
        }
        return -1;
      }
      paramJSONObject1 = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject1.isPlaying())
        {
          paramJSONObject2.put("playStatus", 0);
          if (!paramJSONObject1.isOutputMute()) {
            break label242;
          }
          paramJSONObject2.put("muteStatus", 0);
          paramJSONObject2.put("playDuration", paramJSONObject1.getCurrentPositionMs());
          return 0;
        }
        if (paramJSONObject1.isPausing())
        {
          paramJSONObject2.put("playStatus", -1);
          continue;
        }
        paramJSONObject2.put("playStatus", -2);
      }
      catch (JSONException paramJSONObject1)
      {
        QLog.e("TribeVideoPlugin", 1, "getPlayerInfo Err:" + paramJSONObject1.toString());
        return -1;
      }
      continue;
      label242:
      paramJSONObject2.put("muteStatus", -1);
    }
  }
  
  private int a(zod paramzod, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (zod.a(paramzod)))
    {
      int j = zod.a(paramzod).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = zod.a(paramzod).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < zod.a(paramzod)) || (m - n > zod.b(paramzod)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + zod.a(paramzod));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = zod.a(paramzod);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (zod.a(paramzod).isPausing()) {
          a(zod.a(paramzod), 1);
        }
        zod.b(paramzod, false);
        zod.a(paramzod).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(zod.a(paramzod), 3);
    zod.b(paramzod, true);
    zod.a(paramzod).pause();
    return 0;
  }
  
  private VideoLayout a(ISPlayerVideoView paramISPlayerVideoView, FrameLayout paramFrameLayout, zod paramzod)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramISPlayerVideoView);
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (zod.f(paramzod) == 1) {
      localVideoLayout.setOnTouchListener(new znz(this));
    }
    if ((this.f > 0) && (this.e > 0)) {}
    for (float f1 = this.f / this.e;; f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density)
    {
      paramISPlayerVideoView = new FrameLayout.LayoutParams((int)(zod.c(paramzod) * f1), (int)(zod.d(paramzod) * f1));
      paramISPlayerVideoView.topMargin = ((int)(zod.e(paramzod) * f1));
      paramISPlayerVideoView.leftMargin = ((int)(zod.f(paramzod) * f1));
      zod.e(paramzod, zod.a(paramzod) * f1);
      zod.f(paramzod, this.c - zod.b(paramzod) * f1);
      if (zod.g(paramzod) > 0) {
        localVideoLayout.setRoundCorner((int)(zod.g(paramzod) * f1));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramISPlayerVideoView);
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "sDensity:" + f1);
      }
      zod.a(paramzod, localVideoLayout);
      return localVideoLayout;
    }
  }
  
  private TribeVideoListPlayerFragment a()
  {
    if ((this.mRuntime.a() instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.mRuntime.a()).getSupportFragmentManager();
      if (localObject != null)
      {
        localObject = ((FragmentManager)localObject).getFragments();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Fragment localFragment = (Fragment)((Iterator)localObject).next();
            if ((localFragment instanceof TribeVideoListPlayerFragment)) {
              return (TribeVideoListPlayerFragment)localFragment;
            }
          }
        }
      }
    }
    return null;
  }
  
  private ISuperPlayer a(ISPlayerVideoView paramISPlayerVideoView, String paramString, int paramInt, zod paramzod)
  {
    paramISPlayerVideoView = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 111, paramISPlayerVideoView);
    paramISPlayerVideoView.setXYaxis(2);
    if (zod.c(paramzod) == 0) {
      paramISPlayerVideoView.setLoopback(true);
    }
    a(paramISPlayerVideoView, paramzod);
    a(zod.d(paramzod), paramString, paramInt, paramISPlayerVideoView, paramzod);
    return paramISPlayerVideoView;
  }
  
  private ISPlayerVideoView a()
  {
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.jdField_a_of_type_AndroidContentContext);
    localISPlayerVideoView.addViewCallBack(new zny(this));
    return localISPlayerVideoView;
  }
  
  private zob a(FrameLayout paramFrameLayout, ISuperPlayer paramISuperPlayer, zod paramzod)
  {
    if ((zod.b(paramzod) != 2) && (zod.b(paramzod) != 1) && (zod.b(paramzod) != 0)) {
      return null;
    }
    zob localzob = new zob(null);
    zob.a(localzob, zod.b(paramzod));
    if (zod.b(paramzod) == 2)
    {
      if (zod.e(paramzod) != 0) {
        break label161;
      }
      paramISuperPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramzod);
      zob.a(localzob).setVisibility(8);
      zod.a(paramzod, localzob);
      return localzob;
      if (zod.b(paramzod) == 1)
      {
        zob.a(localzob, (ProgressBar)paramFrameLayout.findViewById(2131377343));
        zob.b(localzob, (ProgressBar)paramFrameLayout.findViewById(2131377344));
        break;
      }
      if (zod.b(paramzod) != 0) {
        break;
      }
      zob.a(localzob, (ProgressBar)paramFrameLayout.findViewById(2131371849));
      break;
      label161:
      if (zod.e(paramzod) == 1) {
        paramISuperPlayer.setOutputMute(true);
      }
    }
  }
  
  /* Error */
  private zod a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 140	zod
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 609	zod:<init>	(Lznu;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: ldc_w 611
    //   16: invokevirtual 614	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 617	zod:a	(Lzod;Ljava/lang/String;)Ljava/lang/String;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: ldc_w 619
    //   29: invokevirtual 614	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 621	zod:b	(Lzod;Ljava/lang/String;)Ljava/lang/String;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: ldc_w 375
    //   42: invokevirtual 614	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 623	zod:c	(Lzod;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload 4
    //   51: aload_1
    //   52: ldc_w 625
    //   55: dconst_0
    //   56: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   59: invokestatic 631	zod:a	(Lzod;D)D
    //   62: pop2
    //   63: aload 4
    //   65: aload_1
    //   66: ldc_w 633
    //   69: dconst_0
    //   70: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   73: invokestatic 635	zod:b	(Lzod;D)D
    //   76: pop2
    //   77: aload 4
    //   79: aload_1
    //   80: ldc_w 637
    //   83: dconst_0
    //   84: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   87: invokestatic 639	zod:c	(Lzod;D)D
    //   90: pop2
    //   91: aload 4
    //   93: aload_1
    //   94: ldc_w 641
    //   97: dconst_0
    //   98: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   101: invokestatic 643	zod:d	(Lzod;D)D
    //   104: pop2
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 645
    //   111: iconst_0
    //   112: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   115: invokestatic 652	zod:a	(Lzod;I)I
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: ldc_w 654
    //   125: iconst_1
    //   126: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   129: invokestatic 656	zod:b	(Lzod;I)I
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: ldc_w 658
    //   139: iconst_0
    //   140: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   143: invokestatic 660	zod:c	(Lzod;I)I
    //   146: pop
    //   147: aload 4
    //   149: aload_1
    //   150: ldc_w 662
    //   153: iconst_0
    //   154: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   157: invokestatic 664	zod:d	(Lzod;I)I
    //   160: pop
    //   161: aload 4
    //   163: invokestatic 306	zod:b	(Lzod;)I
    //   166: iconst_2
    //   167: if_icmpne +10 -> 177
    //   170: aload 4
    //   172: iconst_0
    //   173: invokestatic 664	zod:d	(Lzod;I)I
    //   176: pop
    //   177: aload 4
    //   179: aload_1
    //   180: ldc_w 666
    //   183: iconst_1
    //   184: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   187: invokestatic 668	zod:e	(Lzod;I)I
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: ldc_w 670
    //   197: iconst_0
    //   198: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: invokestatic 672	zod:f	(Lzod;I)I
    //   204: pop
    //   205: aload 4
    //   207: aload_1
    //   208: ldc_w 674
    //   211: iconst_0
    //   212: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: invokestatic 676	zod:g	(Lzod;I)I
    //   218: pop
    //   219: aload_1
    //   220: ldc_w 678
    //   223: iconst_0
    //   224: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   227: istore_2
    //   228: iload_2
    //   229: iconst_1
    //   230: if_icmpne +77 -> 307
    //   233: aload 4
    //   235: iconst_1
    //   236: invokestatic 680	zod:c	(Lzod;Z)Z
    //   239: pop
    //   240: aload 4
    //   242: aload_1
    //   243: ldc_w 682
    //   246: dconst_0
    //   247: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   250: invokestatic 486	zod:e	(Lzod;D)D
    //   253: pop2
    //   254: aload 4
    //   256: aload_1
    //   257: ldc_w 684
    //   260: dconst_0
    //   261: invokevirtual 629	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   264: invokestatic 490	zod:f	(Lzod;D)D
    //   267: pop2
    //   268: aload 4
    //   270: aload_1
    //   271: ldc_w 686
    //   274: iconst_0
    //   275: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   278: invokestatic 689	zod:h	(Lzod;I)I
    //   281: pop
    //   282: aload 4
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 41	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   289: ifgt +61 -> 350
    //   292: aload_0
    //   293: aload_1
    //   294: ldc_w 691
    //   297: iconst_m1
    //   298: invokevirtual 649	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   301: putfield 41	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   304: aload 4
    //   306: areturn
    //   307: iload_2
    //   308: ifne -68 -> 240
    //   311: aload 4
    //   313: iconst_0
    //   314: invokestatic 680	zod:c	(Lzod;Z)Z
    //   317: pop
    //   318: goto -78 -> 240
    //   321: astore_3
    //   322: ldc 199
    //   324: iconst_1
    //   325: new 201	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 693
    //   335: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	TribeVideoPlugin
    //   0	352	1	paramJSONObject	JSONObject
    //   227	81	2	i	int
    //   284	1	3	localzod1	zod
    //   321	1	3	localException	Exception
    //   349	2	3	localzod2	zod
    //   8	304	4	localzod3	zod
    // Exception table:
    //   from	to	target	type
    //   10	177	321	java/lang/Exception
    //   177	228	321	java/lang/Exception
    //   233	240	321	java/lang/Exception
    //   240	282	321	java/lang/Exception
    //   285	304	321	java/lang/Exception
    //   311	318	321	java/lang/Exception
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (zod.a((zod)localObject))
      {
        int i = zod.a((zod)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = zod.a((zod)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < zod.a((zod)localObject)) || (j > zod.b((zod)localObject)))
        {
          if (zod.a((zod)localObject).isPlaying())
          {
            zod.a((zod)localObject).pause();
            zod.a((zod)localObject).setVisibility(8);
            zod.a((zod)localObject, true);
            a(zod.a((zod)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + zod.a((zod)localObject) + " mVideoInnerLayout.getTop = " + zod.a((zod)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + zod.a((zod)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (zod.b((zod)localObject))
        {
          zod.b((zod)localObject, false);
          zod.a((zod)localObject).start();
          zod.a((zod)localObject).setVisibility(0);
          zod.a((zod)localObject, false);
          if ((zod.a((zod)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Zoa.obtainMessage();
            localMessage.obj = zod.a((zod)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Zoa.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + zod.a((zod)localObject));
            }
          }
          else
          {
            a(zod.a((zod)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + zod.a((zod)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, ISuperPlayer paramISuperPlayer, zod paramzod)
  {
    Object localObject = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt2 == 1)) {
      paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, "");
    }
    for (;;)
    {
      paramISuperPlayer.seekTo(paramInt1);
      paramISuperPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramString, 0L);
      return;
      paramString = localObject;
      if (paramInt2 == 0) {
        paramString = SuperPlayerFactory.createVideoInfoForTVideo(4080303, zod.b(paramzod));
      }
    }
  }
  
  private void a(ISuperPlayer paramISuperPlayer, zod paramzod)
  {
    paramISuperPlayer.setOnVideoPreparedListener(new znv(this, paramzod));
    paramISuperPlayer.setOnCompletionListener(new znw(this, paramzod));
    paramISuperPlayer.setOnErrorListener(new znx(this, paramzod));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        zob.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    zod localzod = (zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localzod == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", zod.a(localzod).getCurrentPositionMs());
        localJSONObject.put("duration", zod.a(localzod).getDurationMs());
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus: " + paramString.toString());
      }
    }
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int j = 4;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus playerID = " + paramString);
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString));
      localObject = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131376995);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131374223);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131374222);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131374221);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131374220);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131374219);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131374218);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130848542;
        localImageView1.setImageResource(i);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label350;
      }
      i = 0;
      label258:
      localImageView1.setVisibility(i);
      if (!paramBoolean) {
        break label355;
      }
      i = 0;
      label270:
      localSeekBar.setVisibility(i);
      if (!paramBoolean) {
        break label360;
      }
      i = 0;
      label282:
      localTextView1.setVisibility(i);
      if (!paramBoolean) {
        break label365;
      }
      i = 0;
      label294:
      localTextView2.setVisibility(i);
      if (!paramBoolean) {
        break label370;
      }
      i = 0;
      label306:
      ((ImageView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break label375;
      }
      i = 4;
      label318:
      localImageView2.setVisibility(i);
      if (!paramBoolean) {
        break label380;
      }
    }
    label350:
    label355:
    label360:
    label365:
    label370:
    label375:
    label380:
    for (int i = j;; i = 0)
    {
      localTextView3.setVisibility(i);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      i = 2130849091;
      break;
      i = 4;
      break label258;
      i = 4;
      break label270;
      i = 4;
      break label282;
      i = 4;
      break label294;
      i = 4;
      break label306;
      i = 0;
      break label318;
    }
  }
  
  private void a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
  }
  
  private void a(zod paramzod)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new TribeVideoPlugin.TimeCountTask(this, zod.a(paramzod)), 0L, 30L);
    zod.a(paramzod, localTimer);
  }
  
  private int b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = 0;
    try
    {
      paramJSONObject = paramJSONObject.optString("playerID");
      if (paramJSONObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "pluckVideo playerID = null");
        }
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("TribeVideoPlugin", 1, "pluckVideo Err:" + paramJSONObject.toString());
        paramJSONObject = null;
      }
    }
    return a(paramJSONObject);
  }
  
  private void b(String paramString)
  {
    zod localzod = (zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localzod == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "videoWrapper == null");
      }
    }
    boolean bool1;
    label142:
    do
    {
      do
      {
        return;
        localObject2 = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        localObject1 = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        if ((localObject2 != null) && (localObject1 != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramString = new StringBuilder().append("player == null ");
      if (localObject2 == null)
      {
        bool1 = true;
        paramString = paramString.append(bool1).append(" layoutHolder == null ");
        if (localObject1 != null) {
          break label142;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("TribeVideoPlugin", 2, bool1);
        return;
        bool1 = false;
        break;
      }
      l2 = 0L;
      long l4 = 0L;
      bool1 = false;
      l1 = l4;
      try
      {
        long l3 = ((ISuperPlayer)localObject2).getDurationMs();
        l1 = l4;
        l2 = l3;
        l4 = ((ISuperPlayer)localObject2).getCurrentPositionMs();
        l1 = l4;
        l2 = l3;
        boolean bool2 = ((ISuperPlayer)localObject2).isPlaying();
        bool1 = bool2;
        l2 = l3;
        l1 = l4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TextView localTextView1;
          TextView localTextView2;
          QLog.e("TribeVideoPlugin", 1, "setProgressBar error");
          continue;
          if (zob.a((zob)localObject1) == 1) {
            zob.b((zob)localObject1).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
          }
        }
      }
      if (zob.a((zob)localObject1) != 2) {
        break;
      }
      Object localObject2 = zob.a((zob)localObject1);
      localTextView1 = zob.a((zob)localObject1);
      localTextView2 = zob.b((zob)localObject1);
      localObject1 = zob.c((zob)localObject1);
      rwv.a(localTextView1, l2 - l1);
      rwv.a(localTextView2, l1);
      rwv.a((TextView)localObject1, l2);
      ((SeekBar)localObject2).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
      if ((l1 <= 100L) && (!zod.e(localzod)) && (bool1))
      {
        a(paramString, 1);
        zod.e(localzod, true);
      }
    } while ((zod.b(localzod) - l1 > 100L) || (!zod.e(localzod)) || (!bool1));
    a(paramString, 2);
    zod.e(localzod, false);
  }
  
  private void b(zod paramzod)
  {
    zod.d(paramzod, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + zod.a(paramzod) + " mIsPaused=" + zod.d(paramzod) + " isPlaying=" + zod.a(paramzod).isPlaying());
    }
    if (zod.d(paramzod)) {}
    for (;;)
    {
      return;
      if (zod.a(paramzod).isPlaying()) {
        continue;
      }
      if (zod.a(paramzod))
      {
        int i = zod.a(paramzod).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = zod.a(paramzod).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < zod.a(paramzod)) || (j > zod.b(paramzod)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + zod.a(paramzod) + " mVideoInnerLayout.getTop = " + zod.a(paramzod).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + zod.a(paramzod).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(zod.a(paramzod), 3);
          zod.a(paramzod, true);
          return;
        }
      }
      a(zod.a(paramzod));
      try
      {
        zod.a(paramzod).start();
        zod.b(paramzod, zod.a(paramzod).getDurationMs());
        zod.e(paramzod, true);
        Message localMessage = this.jdField_a_of_type_Zoa.obtainMessage();
        localMessage.obj = zod.a(paramzod);
        localMessage.what = 4;
        this.jdField_a_of_type_Zoa.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + zod.a(paramzod));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(zod.a(paramzod));
          a(zod.a(paramzod), 5);
          bcef.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(NetworkUtil.getNetworkType(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + zod.a(paramzod));
        }
      }
    }
  }
  
  private int c(JSONObject paramJSONObject)
  {
    Object localObject = null;
    int i;
    try
    {
      String str = paramJSONObject.getString("playerID");
      localObject = str;
      i = paramJSONObject.optInt("switch");
      paramJSONObject = str;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("TribeVideoPlugin", 1, "muteSound Err:" + paramJSONObject.toString());
        paramJSONObject = (JSONObject)localObject;
        i = 0;
      }
      localObject = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) && (localObject != null)) {
        break label147;
      }
      if (!QLog.isColorLevel()) {
        break label145;
      }
      QLog.e("TribeVideoPlugin", 2, "muteOrUnmuteSound no such playID playerID = " + paramJSONObject);
      label145:
      return -1;
      label147:
      if (!((ISuperPlayer)localObject).isOutputMute()) {
        break label169;
      }
    }
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 2, "muteOrUnmuteSound playerID = null");
      }
      return -1;
    }
    if (i == 0) {
      ((ISuperPlayer)localObject).setOutputMute(false);
    }
    for (;;)
    {
      return 0;
      label169:
      if ((!((ISuperPlayer)localObject).isOutputMute()) && (i == 1)) {
        ((ISuperPlayer)localObject).setOutputMute(true);
      }
    }
  }
  
  private void c(zod paramzod)
  {
    if (zod.c(paramzod) == 1)
    {
      zod.a(paramzod).seekTo(0);
      a(zod.a(paramzod), 2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "Completion video");
    }
  }
  
  private int d(JSONObject paramJSONObject)
  {
    label53:
    do
    {
      for (;;)
      {
        try
        {
          str = paramJSONObject.getString("playerID");
          QLog.e("TribeVideoPlugin", 1, "handlePlayControl Err:" + paramJSONObject.toString());
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            i = paramJSONObject.optInt("playSwitch");
          }
          catch (Exception paramJSONObject)
          {
            for (;;)
            {
              String str;
              int j;
              int i = 1;
            }
          }
          try
          {
            j = paramJSONObject.optInt("visibilitySwitch");
            if (str != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handlePlayControl playerID = null");
            }
            return -1;
          }
          catch (Exception paramJSONObject)
          {
            break label53;
          }
          paramJSONObject = paramJSONObject;
          str = null;
          i = 1;
        }
        j = 0;
      }
      if ("all".equals(str))
      {
        paramJSONObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (paramJSONObject.hasNext())
        {
          str = (String)paramJSONObject.next();
          a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(zod paramzod)
  {
    a(zod.a(paramzod), 5);
  }
  
  private int e(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    long l1;
    long l2;
    try
    {
      localObject2 = paramJSONObject.getString("playerID");
      localObject1 = localObject2;
      int i = paramJSONObject.optInt("time");
      l1 = i;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject2;
      do
      {
        for (;;)
        {
          QLog.e("TribeVideoPlugin", 1, "handlePlayControl Err:" + paramJSONObject.toString());
          l1 = -1L;
          localObject2 = localObject1;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TribeVideoPlugin", 2, "seekToPlay no such playID playerID = " + (String)localObject2);
      return -1;
      paramJSONObject = zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
      l2 = paramJSONObject.getDurationMs();
      if (l1 >= 0L) {
        break label182;
      }
    }
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 2, "seekToPlay playerID = null");
      }
      return -1;
    }
    paramJSONObject.seekTo(0);
    for (;;)
    {
      paramJSONObject.start();
      return 0;
      label182:
      if (l1 > l2) {
        paramJSONObject.seekTo((int)l2);
      } else {
        paramJSONObject.seekTo((int)l1);
      }
    }
  }
  
  private int f(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("error_code");
    int j = paramJSONObject.optInt("like_count");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("error_code", i);
    paramJSONObject.putExtra("like_count", j);
    paramJSONObject = a();
    if (paramJSONObject != null) {
      paramJSONObject.a(1, j);
    }
    return 0;
  }
  
  private int g(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("error_code");
    int j = paramJSONObject.optInt("comment_count");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("error_code", i);
    paramJSONObject.putExtra("comment_count", j);
    paramJSONObject = a();
    if (paramJSONObject != null) {
      paramJSONObject.a(0, j);
    }
    return 0;
  }
  
  private int h(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      String str1 = paramJSONObject.getString("request_cookie");
      int i = paramJSONObject.optInt("type");
      String str2 = paramJSONObject.optString("feeds");
      Intent localIntent = new Intent();
      localIntent.putExtra("feeds", str2);
      localIntent.putExtra("type", i);
      localIntent.putExtra("request_cookie", str1);
      localIntent.putExtra("start", paramJSONObject.optInt("start"));
      localIntent.putExtra("num", paramJSONObject.optInt("num"));
      localIntent.putExtra("type", paramJSONObject.optInt("type"));
      localIntent.putExtra("source_type", paramJSONObject.optInt("source_type"));
      localIntent.putExtra("recommend_by_bid", paramJSONObject.optInt("recommend_by_bid"));
      TribeVideoListPlayerFragment.a(this);
      adxr.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivityForTool.class, TribeVideoListPlayerFragment.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772329, 2130772330);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "openTribeVideo: time = " + (l2 - l1) + " jsonObject = " + paramJSONObject + " source_type" + paramJSONObject.optInt("source_type"));
      }
      return 0;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("TribeVideoPlugin", 1, "openTribeVideo Err:" + paramJSONObject.toString());
    }
    return -1;
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramLong);
      localJSONObject.put("relation", 1);
      callJs("javascript:mqq.dispatchEvent(\"follow_people\"," + localJSONObject.toString() + ")");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if (paramVarArgs.length > 0)
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback");
          paramString2 = new JSONObject();
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 1, "handleJsRequest method = " + paramString3 + " jsonObject = " + paramJsBridgeListener);
          }
          if ("pinVideo".equals(paramString3))
          {
            paramString3 = paramJsBridgeListener.optString("onStateChange");
            if ((this.jdField_a_of_type_JavaLangString == null) && (paramString3 != null)) {
              this.jdField_a_of_type_JavaLangString = paramString3;
            }
            i = a(paramJsBridgeListener);
            paramString2.put("retCode", i);
            callJs(paramString1, new String[] { paramString2.toString() });
            return true;
          }
        }
        else
        {
          paramJsBridgeListener = new JSONObject();
          continue;
        }
        if (!"pluckVideo".equals(paramString3)) {
          break label195;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("TribeVideoPlugin", 1, "[handleJsRequest] error=", paramJsBridgeListener);
        return true;
      }
      int i = b(paramJsBridgeListener);
      continue;
      label195:
      if ("muteSound".equals(paramString3))
      {
        i = c(paramJsBridgeListener);
      }
      else if ("playControl".equals(paramString3))
      {
        i = d(paramJsBridgeListener);
      }
      else if ("getVideoPlayerInfo".equals(paramString3))
      {
        i = a(paramJsBridgeListener, paramString2);
      }
      else if ("seekTo".equals(paramString3))
      {
        i = e(paramJsBridgeListener);
      }
      else if ("openTribeVideo".equals(paramString3))
      {
        i = h(paramJsBridgeListener);
      }
      else if ("moveWebToBack".equals(paramString3))
      {
        i = a();
      }
      else if ("giveGiftResult".equals(paramString3))
      {
        i = f(paramJsBridgeListener);
      }
      else if ("commentResult".equals(paramString3))
      {
        i = g(paramJsBridgeListener);
      }
      else
      {
        i = -1;
        QLog.e("TribeVideoPlugin", 1, "no such method = " + paramString3);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Zoa = new zoa(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    if (!azjl.a()) {
      azjl.a(BaseApplicationImpl.getApplication(), null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Zoa.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
      zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      zod.a((zod)this.jdField_a_of_type_JavaUtilHashMap.get(str), null);
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    QLog.d("TribeVideoPlugin", 1, "onDestroy");
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131381053));
    if (this.jdField_a_of_type_ComTencentBizUiRefreshView.findViewWithTag("tribeVideoTag") == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mRuntime.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTag("tribeVideoTag");
      this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramCustomWebView);
      this.c = this.jdField_a_of_type_ComTencentBizUiRefreshView.getHeight();
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        this.d = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
        if (this.f <= 0)
        {
          paramCustomWebView = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getWindowManager();
          DisplayMetrics localDisplayMetrics = new DisplayMetrics();
          paramCustomWebView.getDefaultDisplay().getMetrics(localDisplayMetrics);
          this.f = localDisplayMetrics.widthPixels;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "onWebViewCreated mVideoLayoutHeight = " + this.c + " titleHeight = " + this.d + " mScreenWidthFromLocal = " + this.f);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.mRuntime.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollBy(0, this.jdField_a_of_type_ComTencentBizUiTouchWebView.mTotalYoffset);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListenerForBiz(new znu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */