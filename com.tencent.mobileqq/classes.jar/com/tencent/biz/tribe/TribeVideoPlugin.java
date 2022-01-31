package com.tencent.biz.tribe;

import abtq;
import ajya;
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
import axqy;
import bbfj;
import bcdp;
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
import qoi;
import wxa;
import wxb;
import wxc;
import wxd;
import wxe;
import wxf;
import wxg;
import wxi;
import wxj;
import wxk;
import wxl;

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
  private HashMap<String, wxl> jdField_a_of_type_JavaUtilHashMap;
  private Queue<String> jdField_a_of_type_JavaUtilQueue;
  private wxi jdField_a_of_type_Wxi;
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
        a(wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject), null);
        this.jdField_a_of_type_Wxi.removeCallbacksAndMessages(null);
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
    a(wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString), null);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Wxi.removeMessages(2, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(1, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(4, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(5, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(6, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(7, paramString);
    this.jdField_a_of_type_Wxi.removeMessages(8, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    wxl localwxl = a(paramJSONObject);
    if (localwxl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(wxl.a(localwxl)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(wxl.b(localwxl))) && (TextUtils.isEmpty(wxl.c(localwxl))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(wxl.c(localwxl))) {
      paramJSONObject = wxl.c(localwxl);
    }
    for (int i = 1; (wxl.c(localwxl) == 0.0D) || (wxl.d(localwxl) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = wxl.b(localwxl);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(wxl.a(localwxl)))
    {
      if (!wxl.c((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(wxl.a(localwxl))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(wxl.a(localwxl));
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
      this.jdField_b_of_type_Int = wxl.a(localwxl);
      if (wxl.a(localwxl) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + wxl.a(localwxl) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localTVK_IMediaPlayer = a(localIVideoViewBase, paramJSONObject, i, localwxl);
      wxl.a(localwxl, localTVK_IMediaPlayer);
      if (wxl.b(localwxl) != 2) {
        break label609;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label444:
      a(paramJSONObject, localTVK_IMediaPlayer, localwxl);
      a(localIVideoViewBase, paramJSONObject, localwxl);
      if (wxl.b(localwxl) == 2) {
        this.mRuntime.a().setOnTouchListener(new wxk(this, wxl.a(localwxl)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(wxl.a(localwxl));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + wxl.a(localwxl) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label609:
            if (wxl.b(localwxl) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560115, null);
              break label444;
            }
            if (wxl.b(localwxl) != 0) {
              break label699;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560116, null);
            break label444;
          }
        }
      }
      wxl.a(localwxl, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(wxl.a(localwxl), localwxl);
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
      paramJSONObject1 = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
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
  
  private int a(wxl paramwxl, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (wxl.a(paramwxl)))
    {
      int j = wxl.a(paramwxl).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = wxl.a(paramwxl).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < wxl.a(paramwxl)) || (m - n > wxl.b(paramwxl)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + wxl.a(paramwxl));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = wxl.a(paramwxl);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (wxl.a(paramwxl).isPauseing()) {
          a(wxl.a(paramwxl), 1);
        }
        wxl.b(paramwxl, false);
        wxl.a(paramwxl).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(wxl.a(paramwxl), 3);
    wxl.b(paramwxl, true);
    wxl.a(paramwxl).pause();
    return 0;
  }
  
  private VideoLayout a(IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout, wxl paramwxl)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramIVideoViewBase);
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (wxl.f(paramwxl) == 1) {
      localVideoLayout.setOnTouchListener(new wxg(this));
    }
    if ((this.f > 0) && (this.e > 0)) {}
    for (float f1 = this.f / this.e;; f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density)
    {
      paramIVideoViewBase = new FrameLayout.LayoutParams((int)(wxl.c(paramwxl) * f1), (int)(wxl.d(paramwxl) * f1));
      paramIVideoViewBase.topMargin = ((int)(wxl.e(paramwxl) * f1));
      paramIVideoViewBase.leftMargin = ((int)(wxl.f(paramwxl) * f1));
      wxl.e(paramwxl, wxl.a(paramwxl) * f1);
      wxl.f(paramwxl, this.c - wxl.b(paramwxl) * f1);
      if (wxl.g(paramwxl) > 0) {
        localVideoLayout.setRoundCorner((int)(wxl.g(paramwxl) * f1));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramIVideoViewBase);
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "sDensity:" + f1);
      }
      wxl.a(paramwxl, localVideoLayout);
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
  
  private TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase, String paramString, int paramInt, wxl paramwxl)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramIVideoViewBase);
    paramIVideoViewBase.setXYaxis(2);
    if (wxl.c(paramwxl) == 0) {
      paramIVideoViewBase.setLoopback(true);
    }
    a(paramIVideoViewBase, paramwxl);
    a(wxl.d(paramwxl), paramString, paramInt, paramIVideoViewBase, paramwxl);
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
      localObject = Toast.makeText(this.mRuntime.a().getApplication(), ajya.a(2131715119), 1);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
      return null;
      ThreadManager.post(new TribeVideoPlugin.TVKSDKInstallRunnable(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ((IVideoViewBase)localObject).addViewCallBack(new wxf(this));
    return localObject;
  }
  
  private wxj a(FrameLayout paramFrameLayout, TVK_IMediaPlayer paramTVK_IMediaPlayer, wxl paramwxl)
  {
    if ((wxl.b(paramwxl) != 2) && (wxl.b(paramwxl) != 1) && (wxl.b(paramwxl) != 0)) {
      return null;
    }
    wxj localwxj = new wxj(null);
    wxj.a(localwxj, wxl.b(paramwxl));
    if (wxl.b(paramwxl) == 2)
    {
      if (wxl.e(paramwxl) != 0) {
        break label162;
      }
      paramTVK_IMediaPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramwxl);
      wxj.a(localwxj).setVisibility(8);
      wxl.a(paramwxl, localwxj);
      return localwxj;
      if (wxl.b(paramwxl) == 1)
      {
        wxj.a(localwxj, (ProgressBar)paramFrameLayout.findViewById(2131376077));
        wxj.b(localwxj, (ProgressBar)paramFrameLayout.findViewById(2131376078));
        break;
      }
      if (wxl.b(paramwxl) != 0) {
        break;
      }
      wxj.a(localwxj, (ProgressBar)paramFrameLayout.findViewById(2131370883));
      break;
      label162:
      if (wxl.e(paramwxl) == 1) {
        paramTVK_IMediaPlayer.setOutputMute(true);
      }
    }
  }
  
  /* Error */
  private wxl a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 141	wxl
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 650	wxl:<init>	(Lwxa;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: ldc_w 652
    //   16: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 658	wxl:a	(Lwxl;Ljava/lang/String;)Ljava/lang/String;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: ldc_w 660
    //   29: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 662	wxl:b	(Lwxl;Ljava/lang/String;)Ljava/lang/String;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: ldc_w 378
    //   42: invokevirtual 655	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 664	wxl:c	(Lwxl;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload 4
    //   51: aload_1
    //   52: ldc_w 666
    //   55: dconst_0
    //   56: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   59: invokestatic 672	wxl:a	(Lwxl;D)D
    //   62: pop2
    //   63: aload 4
    //   65: aload_1
    //   66: ldc_w 674
    //   69: dconst_0
    //   70: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   73: invokestatic 676	wxl:b	(Lwxl;D)D
    //   76: pop2
    //   77: aload 4
    //   79: aload_1
    //   80: ldc_w 678
    //   83: dconst_0
    //   84: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   87: invokestatic 680	wxl:c	(Lwxl;D)D
    //   90: pop2
    //   91: aload 4
    //   93: aload_1
    //   94: ldc_w 682
    //   97: dconst_0
    //   98: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   101: invokestatic 684	wxl:d	(Lwxl;D)D
    //   104: pop2
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 686
    //   111: iconst_0
    //   112: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   115: invokestatic 693	wxl:a	(Lwxl;I)I
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: ldc_w 695
    //   125: iconst_1
    //   126: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   129: invokestatic 697	wxl:b	(Lwxl;I)I
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: ldc_w 699
    //   139: iconst_0
    //   140: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   143: invokestatic 701	wxl:c	(Lwxl;I)I
    //   146: pop
    //   147: aload 4
    //   149: aload_1
    //   150: ldc_w 703
    //   153: iconst_0
    //   154: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   157: invokestatic 705	wxl:d	(Lwxl;I)I
    //   160: pop
    //   161: aload 4
    //   163: invokestatic 309	wxl:b	(Lwxl;)I
    //   166: iconst_2
    //   167: if_icmpne +10 -> 177
    //   170: aload 4
    //   172: iconst_0
    //   173: invokestatic 705	wxl:d	(Lwxl;I)I
    //   176: pop
    //   177: aload 4
    //   179: aload_1
    //   180: ldc_w 707
    //   183: iconst_1
    //   184: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   187: invokestatic 709	wxl:e	(Lwxl;I)I
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: ldc_w 711
    //   197: iconst_0
    //   198: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: invokestatic 713	wxl:f	(Lwxl;I)I
    //   204: pop
    //   205: aload 4
    //   207: aload_1
    //   208: ldc_w 715
    //   211: iconst_0
    //   212: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: invokestatic 717	wxl:g	(Lwxl;I)I
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
    //   236: invokestatic 721	wxl:c	(Lwxl;Z)Z
    //   239: pop
    //   240: aload 4
    //   242: aload_1
    //   243: ldc_w 723
    //   246: dconst_0
    //   247: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   250: invokestatic 489	wxl:e	(Lwxl;D)D
    //   253: pop2
    //   254: aload 4
    //   256: aload_1
    //   257: ldc_w 725
    //   260: dconst_0
    //   261: invokevirtual 670	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   264: invokestatic 493	wxl:f	(Lwxl;D)D
    //   267: pop2
    //   268: aload 4
    //   270: aload_1
    //   271: ldc_w 727
    //   274: iconst_0
    //   275: invokevirtual 690	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   278: invokestatic 730	wxl:h	(Lwxl;I)I
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
    //   314: invokestatic 721	wxl:c	(Lwxl;Z)Z
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
    //   284	1	3	localwxl1	wxl
    //   321	1	3	localException	Exception
    //   349	2	3	localwxl2	wxl
    //   8	304	4	localwxl3	wxl
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
      localObject = (wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (wxl.a((wxl)localObject))
      {
        int i = wxl.a((wxl)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = wxl.a((wxl)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < wxl.a((wxl)localObject)) || (j > wxl.b((wxl)localObject)))
        {
          if (wxl.a((wxl)localObject).isPlaying())
          {
            wxl.a((wxl)localObject).pause();
            wxl.a((wxl)localObject).setVisibility(8);
            wxl.a((wxl)localObject, true);
            a(wxl.a((wxl)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + wxl.a((wxl)localObject) + " mVideoInnerLayout.getTop = " + wxl.a((wxl)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + wxl.a((wxl)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (wxl.b((wxl)localObject))
        {
          wxl.b((wxl)localObject, false);
          wxl.a((wxl)localObject).start();
          wxl.a((wxl)localObject).setVisibility(0);
          wxl.a((wxl)localObject, false);
          if ((wxl.a((wxl)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Wxi.obtainMessage();
            localMessage.obj = wxl.a((wxl)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Wxi.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + wxl.a((wxl)localObject));
            }
          }
          else
          {
            a(wxl.a((wxl)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + wxl.a((wxl)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, TVK_IMediaPlayer paramTVK_IMediaPlayer, wxl paramwxl)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setLoginCookie("");
    localTVK_UserInfo.setUin(this.mRuntime.a().getCurrentAccountUin());
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    if (!TextUtils.isEmpty(wxl.b(paramwxl)))
    {
      localTVK_PlayerVideoInfo.setVid(wxl.b(paramwxl));
      localTVK_PlayerVideoInfo.setPlayMode("cache_video");
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      paramwxl = new HashMap();
      paramwxl.put("shouq_bus_type", "bus_type_trib");
      localTVK_PlayerVideoInfo.setReportInfoMap(paramwxl);
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
  
  private void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, wxl paramwxl)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new wxc(this, paramwxl));
    paramTVK_IMediaPlayer.setOnCompletionListener(new wxd(this, paramwxl));
    paramTVK_IMediaPlayer.setOnErrorListener(new wxe(this, paramwxl));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        wxj.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    wxl localwxl = (wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localwxl == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", wxl.a(localwxl).getCurrentPostion());
        localJSONObject.put("duration", wxl.a(localwxl).getDuration());
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
      localObject = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131375776);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131373124);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131373123);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131373122);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131373121);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131373120);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131373119);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130847681;
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
      i = 2130848227;
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
  
  private void a(wxl paramwxl)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new TribeVideoPlugin.TimeCountTask(this, wxl.a(paramwxl)), 0L, 30L);
    wxl.a(paramwxl, localTimer);
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
    wxl localwxl = (wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localwxl == null) {
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
        localObject2 = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        localObject1 = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
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
          if (wxj.a((wxj)localObject1) == 1) {
            wxj.b((wxj)localObject1).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
          }
        }
      }
      if (wxj.a((wxj)localObject1) != 2) {
        break;
      }
      Object localObject2 = wxj.a((wxj)localObject1);
      localTextView1 = wxj.a((wxj)localObject1);
      localTextView2 = wxj.b((wxj)localObject1);
      localObject1 = wxj.c((wxj)localObject1);
      qoi.a(localTextView1, l2 - l1);
      qoi.a(localTextView2, l1);
      qoi.a((TextView)localObject1, l2);
      ((SeekBar)localObject2).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
      if ((l1 <= 100L) && (!wxl.e(localwxl)) && (bool1))
      {
        a(paramString, 1);
        wxl.e(localwxl, true);
      }
    } while ((wxl.b(localwxl) - l1 > 100L) || (!wxl.e(localwxl)) || (!bool1));
    a(paramString, 2);
    wxl.e(localwxl, false);
  }
  
  private void b(wxl paramwxl)
  {
    wxl.d(paramwxl, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + wxl.a(paramwxl) + " mIsPaused=" + wxl.d(paramwxl) + " isPlaying=" + wxl.a(paramwxl).isPlaying());
    }
    if (wxl.d(paramwxl)) {}
    for (;;)
    {
      return;
      if (wxl.a(paramwxl).isPlaying()) {
        continue;
      }
      if (wxl.a(paramwxl))
      {
        int i = wxl.a(paramwxl).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = wxl.a(paramwxl).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < wxl.a(paramwxl)) || (j > wxl.b(paramwxl)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + wxl.a(paramwxl) + " mVideoInnerLayout.getTop = " + wxl.a(paramwxl).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + wxl.a(paramwxl).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(wxl.a(paramwxl), 3);
          wxl.a(paramwxl, true);
          return;
        }
      }
      a(wxl.a(paramwxl));
      try
      {
        wxl.a(paramwxl).start();
        wxl.b(paramwxl, wxl.a(paramwxl).getDuration());
        wxl.e(paramwxl, true);
        Message localMessage = this.jdField_a_of_type_Wxi.obtainMessage();
        localMessage.obj = wxl.a(paramwxl);
        localMessage.what = 4;
        this.jdField_a_of_type_Wxi.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + wxl.a(paramwxl));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(wxl.a(paramwxl));
          a(wxl.a(paramwxl), 5);
          axqy.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(bbfj.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + wxl.a(paramwxl));
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
      localObject = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
  
  private void c(wxl paramwxl)
  {
    if (wxl.c(paramwxl) == 1)
    {
      wxl.a(paramwxl).seekTo(0);
      a(wxl.a(paramwxl), 2);
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
          a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(wxl paramwxl)
  {
    a(wxl.a(paramwxl), 5);
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
      paramJSONObject = wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
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
      abtq.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivityForTool.class, TribeVideoListPlayerFragment.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772305, 2130772306);
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
    this.jdField_a_of_type_Wxi = new wxi(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new wxa(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Wxi.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
      wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      wxl.a((wxl)this.jdField_a_of_type_JavaUtilHashMap.get(str), null);
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
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131379412));
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListenerForBiz(new wxb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */