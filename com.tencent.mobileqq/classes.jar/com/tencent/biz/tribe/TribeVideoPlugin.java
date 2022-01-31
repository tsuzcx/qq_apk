package com.tencent.biz.tribe;

import adky;
import alpo;
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
import android.widget.Toast;
import azmj;
import bdee;
import becq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import rdm;
import ylt;
import ylu;
import ylv;
import ylw;
import ylx;
import yly;
import ylz;
import ymb;
import ymc;
import ymd;
import yme;

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
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, yme> jdField_a_of_type_JavaUtilHashMap;
  private Queue<String> jdField_a_of_type_JavaUtilQueue;
  private ymb jdField_a_of_type_Ymb;
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
        a(yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject), null);
        this.jdField_a_of_type_Ymb.removeCallbacksAndMessages(null);
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
    a(yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString), null);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Ymb.removeMessages(2, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(1, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(4, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(5, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(6, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(7, paramString);
    this.jdField_a_of_type_Ymb.removeMessages(8, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    yme localyme = a(paramJSONObject);
    if (localyme == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(yme.a(localyme)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(yme.b(localyme))) && (TextUtils.isEmpty(yme.c(localyme))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(yme.c(localyme))) {
      paramJSONObject = yme.c(localyme);
    }
    for (int i = 1; (yme.c(localyme) == 0.0D) || (yme.d(localyme) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = yme.b(localyme);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(yme.a(localyme)))
    {
      if (!yme.c((yme)this.jdField_a_of_type_JavaUtilHashMap.get(yme.a(localyme))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(yme.a(localyme));
    }
    IVideoViewBase localIVideoViewBase = a();
    if (localIVideoViewBase == null) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TribeVideoPlugin.TechReportRunnable(this, bool), 5, null, true);
      if (localIVideoViewBase != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video videoView = null");
      }
      return -1;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.bringToFront();
      this.jdField_b_of_type_Boolean = false;
    }
    TVK_IMediaPlayer localTVK_IMediaPlayer;
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = yme.a(localyme);
      if (yme.a(localyme) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + yme.a(localyme) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localTVK_IMediaPlayer = a(localIVideoViewBase, paramJSONObject, i, localyme);
      yme.a(localyme, localTVK_IMediaPlayer);
      if (yme.b(localyme) != 2) {
        break label609;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label444:
      a(paramJSONObject, localTVK_IMediaPlayer, localyme);
      a(localIVideoViewBase, paramJSONObject, localyme);
      if (yme.b(localyme) == 2) {
        this.mRuntime.a().setOnTouchListener(new ymd(this, yme.a(localyme)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(yme.a(localyme));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + yme.a(localyme) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label609:
            if (yme.b(localyme) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560218, null);
              break label444;
            }
            if (yme.b(localyme) != 0) {
              break label699;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560219, null);
            break label444;
          }
        }
      }
      yme.a(localyme, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(yme.a(localyme), localyme);
      this.jdField_a_of_type_Boolean = false;
      return 0;
      label699:
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
      paramJSONObject1 = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject1.isPlaying())
        {
          paramJSONObject2.put("playStatus", 0);
          if (!paramJSONObject1.getOutputMute()) {
            break label242;
          }
          paramJSONObject2.put("muteStatus", 0);
          paramJSONObject2.put("playDuration", paramJSONObject1.getCurrentPostion());
          return 0;
        }
        if (paramJSONObject1.isPauseing())
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
  
  private int a(yme paramyme, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (yme.a(paramyme)))
    {
      int j = yme.a(paramyme).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = yme.a(paramyme).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < yme.a(paramyme)) || (m - n > yme.b(paramyme)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + yme.a(paramyme));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = yme.a(paramyme);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (yme.a(paramyme).isPauseing()) {
          a(yme.a(paramyme), 1);
        }
        yme.b(paramyme, false);
        yme.a(paramyme).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(yme.a(paramyme), 3);
    yme.b(paramyme, true);
    yme.a(paramyme).pause();
    return 0;
  }
  
  private VideoLayout a(IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout, yme paramyme)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramIVideoViewBase);
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (yme.f(paramyme) == 1) {
      localVideoLayout.setOnTouchListener(new ylz(this));
    }
    if ((this.f > 0) && (this.e > 0)) {}
    for (float f1 = this.f / this.e;; f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density)
    {
      paramIVideoViewBase = new FrameLayout.LayoutParams((int)(yme.c(paramyme) * f1), (int)(yme.d(paramyme) * f1));
      paramIVideoViewBase.topMargin = ((int)(yme.e(paramyme) * f1));
      paramIVideoViewBase.leftMargin = ((int)(yme.f(paramyme) * f1));
      yme.e(paramyme, yme.a(paramyme) * f1);
      yme.f(paramyme, this.c - yme.b(paramyme) * f1);
      if (yme.g(paramyme) > 0) {
        localVideoLayout.setRoundCorner((int)(yme.g(paramyme) * f1));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramIVideoViewBase);
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "sDensity:" + f1);
      }
      yme.a(paramyme, localVideoLayout);
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
  
  private TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase, String paramString, int paramInt, yme paramyme)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramIVideoViewBase);
    paramIVideoViewBase.setXYaxis(2);
    if (yme.c(paramyme) == 0) {
      paramIVideoViewBase.setLoopback(true);
    }
    a(paramIVideoViewBase, paramyme);
    a(yme.d(paramyme), paramString, paramInt, paramIVideoViewBase, paramyme);
    return paramIVideoViewBase;
  }
  
  private IVideoViewBase a()
  {
    if (TVK_SDKMgr.isInstalled(this.mRuntime.a().getApplication())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
        break;
      }
      localObject = Toast.makeText(this.mRuntime.a().getApplication(), alpo.a(2131715491), 1);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
      return null;
      ThreadManager.post(new TribeVideoPlugin.TVKSDKInstallRunnable(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ((IVideoViewBase)localObject).addViewCallBack(new yly(this));
    return localObject;
  }
  
  private ymc a(FrameLayout paramFrameLayout, TVK_IMediaPlayer paramTVK_IMediaPlayer, yme paramyme)
  {
    if ((yme.b(paramyme) != 2) && (yme.b(paramyme) != 1) && (yme.b(paramyme) != 0)) {
      return null;
    }
    ymc localymc = new ymc(null);
    ymc.a(localymc, yme.b(paramyme));
    if (yme.b(paramyme) == 2)
    {
      if (yme.e(paramyme) != 0) {
        break label162;
      }
      paramTVK_IMediaPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramyme);
      ymc.a(localymc).setVisibility(8);
      yme.a(paramyme, localymc);
      return localymc;
      if (yme.b(paramyme) == 1)
      {
        ymc.a(localymc, (ProgressBar)paramFrameLayout.findViewById(2131376576));
        ymc.b(localymc, (ProgressBar)paramFrameLayout.findViewById(2131376577));
        break;
      }
      if (yme.b(paramyme) != 0) {
        break;
      }
      ymc.a(localymc, (ProgressBar)paramFrameLayout.findViewById(2131371193));
      break;
      label162:
      if (yme.e(paramyme) == 1) {
        paramTVK_IMediaPlayer.setOutputMute(true);
      }
    }
  }
  
  /* Error */
  private yme a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 141	yme
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 650	yme:<init>	(Lylt;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: ldc_w 652
    //   16: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 658	yme:a	(Lyme;Ljava/lang/String;)Ljava/lang/String;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: ldc_w 660
    //   29: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 662	yme:b	(Lyme;Ljava/lang/String;)Ljava/lang/String;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: ldc_w 378
    //   42: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 664	yme:c	(Lyme;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload 4
    //   51: aload_1
    //   52: ldc_w 666
    //   55: dconst_0
    //   56: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   59: invokestatic 672	yme:a	(Lyme;D)D
    //   62: pop2
    //   63: aload 4
    //   65: aload_1
    //   66: ldc_w 674
    //   69: dconst_0
    //   70: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   73: invokestatic 676	yme:b	(Lyme;D)D
    //   76: pop2
    //   77: aload 4
    //   79: aload_1
    //   80: ldc_w 678
    //   83: dconst_0
    //   84: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   87: invokestatic 680	yme:c	(Lyme;D)D
    //   90: pop2
    //   91: aload 4
    //   93: aload_1
    //   94: ldc_w 682
    //   97: dconst_0
    //   98: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   101: invokestatic 684	yme:d	(Lyme;D)D
    //   104: pop2
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 686
    //   111: iconst_0
    //   112: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   115: invokestatic 693	yme:a	(Lyme;I)I
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: ldc_w 695
    //   125: iconst_1
    //   126: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   129: invokestatic 697	yme:b	(Lyme;I)I
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: ldc_w 699
    //   139: iconst_0
    //   140: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   143: invokestatic 701	yme:c	(Lyme;I)I
    //   146: pop
    //   147: aload 4
    //   149: aload_1
    //   150: ldc_w 703
    //   153: iconst_0
    //   154: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   157: invokestatic 705	yme:d	(Lyme;I)I
    //   160: pop
    //   161: aload 4
    //   163: invokestatic 309	yme:b	(Lyme;)I
    //   166: iconst_2
    //   167: if_icmpne +10 -> 177
    //   170: aload 4
    //   172: iconst_0
    //   173: invokestatic 705	yme:d	(Lyme;I)I
    //   176: pop
    //   177: aload 4
    //   179: aload_1
    //   180: ldc_w 707
    //   183: iconst_1
    //   184: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   187: invokestatic 709	yme:e	(Lyme;I)I
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: ldc_w 711
    //   197: iconst_0
    //   198: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: invokestatic 713	yme:f	(Lyme;I)I
    //   204: pop
    //   205: aload 4
    //   207: aload_1
    //   208: ldc_w 715
    //   211: iconst_0
    //   212: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: invokestatic 717	yme:g	(Lyme;I)I
    //   218: pop
    //   219: aload_1
    //   220: ldc_w 719
    //   223: iconst_0
    //   224: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   227: istore_2
    //   228: iload_2
    //   229: iconst_1
    //   230: if_icmpne +77 -> 307
    //   233: aload 4
    //   235: iconst_1
    //   236: invokestatic 721	yme:c	(Lyme;Z)Z
    //   239: pop
    //   240: aload 4
    //   242: aload_1
    //   243: ldc_w 723
    //   246: dconst_0
    //   247: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   250: invokestatic 489	yme:e	(Lyme;D)D
    //   253: pop2
    //   254: aload 4
    //   256: aload_1
    //   257: ldc_w 725
    //   260: dconst_0
    //   261: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   264: invokestatic 493	yme:f	(Lyme;D)D
    //   267: pop2
    //   268: aload 4
    //   270: aload_1
    //   271: ldc_w 727
    //   274: iconst_0
    //   275: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   278: invokestatic 730	yme:h	(Lyme;I)I
    //   281: pop
    //   282: aload 4
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 42	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   289: ifgt +61 -> 350
    //   292: aload_0
    //   293: aload_1
    //   294: ldc_w 732
    //   297: iconst_m1
    //   298: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   301: putfield 42	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   304: aload 4
    //   306: areturn
    //   307: iload_2
    //   308: ifne -68 -> 240
    //   311: aload 4
    //   313: iconst_0
    //   314: invokestatic 721	yme:c	(Lyme;Z)Z
    //   317: pop
    //   318: goto -78 -> 240
    //   321: astore_3
    //   322: ldc 200
    //   324: iconst_1
    //   325: new 202	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 734
    //   335: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	TribeVideoPlugin
    //   0	352	1	paramJSONObject	JSONObject
    //   227	81	2	i	int
    //   284	1	3	localyme1	yme
    //   321	1	3	localException	Exception
    //   349	2	3	localyme2	yme
    //   8	304	4	localyme3	yme
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
      localObject = (yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (yme.a((yme)localObject))
      {
        int i = yme.a((yme)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = yme.a((yme)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < yme.a((yme)localObject)) || (j > yme.b((yme)localObject)))
        {
          if (yme.a((yme)localObject).isPlaying())
          {
            yme.a((yme)localObject).pause();
            yme.a((yme)localObject).setVisibility(8);
            yme.a((yme)localObject, true);
            a(yme.a((yme)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + yme.a((yme)localObject) + " mVideoInnerLayout.getTop = " + yme.a((yme)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + yme.a((yme)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (yme.b((yme)localObject))
        {
          yme.b((yme)localObject, false);
          yme.a((yme)localObject).start();
          yme.a((yme)localObject).setVisibility(0);
          yme.a((yme)localObject, false);
          if ((yme.a((yme)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Ymb.obtainMessage();
            localMessage.obj = yme.a((yme)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Ymb.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + yme.a((yme)localObject));
            }
          }
          else
          {
            a(yme.a((yme)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + yme.a((yme)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, TVK_IMediaPlayer paramTVK_IMediaPlayer, yme paramyme)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setLoginCookie("");
    localTVK_UserInfo.setUin(this.mRuntime.a().getCurrentAccountUin());
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    if (!TextUtils.isEmpty(yme.b(paramyme)))
    {
      localTVK_PlayerVideoInfo.setVid(yme.b(paramyme));
      localTVK_PlayerVideoInfo.setPlayMode("cache_video");
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      paramyme = new HashMap();
      paramyme.put("shouq_bus_type", "bus_type_trib");
      localTVK_PlayerVideoInfo.setReportInfoMap(paramyme);
      if (paramInt2 != 0) {
        break label160;
      }
      paramTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, localTVK_UserInfo, localTVK_PlayerVideoInfo, "hd", paramInt1, 0L);
    }
    label160:
    while (paramInt2 != 1)
    {
      return;
      localTVK_PlayerVideoInfo.setVid(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TribeVideoPlugin", 2, "videoInfo.setVid(videoIDOrUrl)");
      break;
    }
    paramTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString, paramInt1, 0L, null, localTVK_PlayerVideoInfo);
  }
  
  private void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, yme paramyme)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new ylv(this, paramyme));
    paramTVK_IMediaPlayer.setOnCompletionListener(new ylw(this, paramyme));
    paramTVK_IMediaPlayer.setOnErrorListener(new ylx(this, paramyme));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        ymc.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    yme localyme = (yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localyme == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", yme.a(localyme).getCurrentPostion());
        localJSONObject.put("duration", yme.a(localyme).getDuration());
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
      localObject = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131376271);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131373561);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131373560);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131373559);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131373558);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131373557);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131373556);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130848063;
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
      i = 2130848612;
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
  
  private void a(yme paramyme)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new TribeVideoPlugin.TimeCountTask(this, yme.a(paramyme)), 0L, 30L);
    yme.a(paramyme, localTimer);
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
    yme localyme = (yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localyme == null) {
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
        localObject2 = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        localObject1 = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
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
        long l3 = ((TVK_IMediaPlayer)localObject2).getDuration();
        l1 = l4;
        l2 = l3;
        l4 = ((TVK_IMediaPlayer)localObject2).getCurrentPostion();
        l1 = l4;
        l2 = l3;
        boolean bool2 = ((TVK_IMediaPlayer)localObject2).isPlaying();
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
          if (ymc.a((ymc)localObject1) == 1) {
            ymc.b((ymc)localObject1).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
          }
        }
      }
      if (ymc.a((ymc)localObject1) != 2) {
        break;
      }
      Object localObject2 = ymc.a((ymc)localObject1);
      localTextView1 = ymc.a((ymc)localObject1);
      localTextView2 = ymc.b((ymc)localObject1);
      localObject1 = ymc.c((ymc)localObject1);
      rdm.a(localTextView1, l2 - l1);
      rdm.a(localTextView2, l1);
      rdm.a((TextView)localObject1, l2);
      ((SeekBar)localObject2).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
      if ((l1 <= 100L) && (!yme.e(localyme)) && (bool1))
      {
        a(paramString, 1);
        yme.e(localyme, true);
      }
    } while ((yme.b(localyme) - l1 > 100L) || (!yme.e(localyme)) || (!bool1));
    a(paramString, 2);
    yme.e(localyme, false);
  }
  
  private void b(yme paramyme)
  {
    yme.d(paramyme, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + yme.a(paramyme) + " mIsPaused=" + yme.d(paramyme) + " isPlaying=" + yme.a(paramyme).isPlaying());
    }
    if (yme.d(paramyme)) {}
    for (;;)
    {
      return;
      if (yme.a(paramyme).isPlaying()) {
        continue;
      }
      if (yme.a(paramyme))
      {
        int i = yme.a(paramyme).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = yme.a(paramyme).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < yme.a(paramyme)) || (j > yme.b(paramyme)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + yme.a(paramyme) + " mVideoInnerLayout.getTop = " + yme.a(paramyme).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + yme.a(paramyme).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(yme.a(paramyme), 3);
          yme.a(paramyme, true);
          return;
        }
      }
      a(yme.a(paramyme));
      try
      {
        yme.a(paramyme).start();
        yme.b(paramyme, yme.a(paramyme).getDuration());
        yme.e(paramyme, true);
        Message localMessage = this.jdField_a_of_type_Ymb.obtainMessage();
        localMessage.obj = yme.a(paramyme);
        localMessage.what = 4;
        this.jdField_a_of_type_Ymb.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + yme.a(paramyme));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(yme.a(paramyme));
          a(yme.a(paramyme), 5);
          azmj.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(bdee.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + yme.a(paramyme));
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
      localObject = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
      if (!((TVK_IMediaPlayer)localObject).getOutputMute()) {
        break label170;
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
      ((TVK_IMediaPlayer)localObject).setOutputMute(false);
    }
    for (;;)
    {
      return 0;
      label170:
      if ((!((TVK_IMediaPlayer)localObject).getOutputMute()) && (i == 1)) {
        ((TVK_IMediaPlayer)localObject).setOutputMute(true);
      }
    }
  }
  
  private void c(yme paramyme)
  {
    if (yme.c(paramyme) == 1)
    {
      yme.a(paramyme).seekTo(0);
      a(yme.a(paramyme), 2);
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
          a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(yme paramyme)
  {
    a(yme.a(paramyme), 5);
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
      paramJSONObject = yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
      l2 = paramJSONObject.getDuration();
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
      adky.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivityForTool.class, TribeVideoListPlayerFragment.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772321, 2130772322);
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
    this.jdField_a_of_type_Ymb = new ymb(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new ylt(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Ymb.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
      yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      yme.a((yme)this.jdField_a_of_type_JavaUtilHashMap.get(str), null);
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
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131380127));
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListenerForBiz(new ylu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */