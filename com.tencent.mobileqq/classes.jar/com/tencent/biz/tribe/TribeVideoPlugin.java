package com.tencent.biz.tribe;

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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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

public class TribeVideoPlugin
  extends WebViewPlugin
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TribeVideoPlugin.UIHandler jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler;
  private RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private String jdField_a_of_type_JavaLangString = null;
  private HashMap<String, TribeVideoPlugin.VideoWrapper> jdField_a_of_type_JavaUtilHashMap;
  private Queue<String> jdField_a_of_type_JavaUtilQueue;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  private int d = 0;
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
  
  private int a(TribeVideoPlugin.VideoWrapper paramVideoWrapper, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper)))
    {
      int j = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper)) || (m - n > TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).isPausing()) {
          a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 1);
        }
        TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper, false);
        TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 3);
    TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper, true);
    TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).pause();
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
        a(TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject), null);
        this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeCallbacksAndMessages(null);
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
    a(TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString), null);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(2, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(1, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(4, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(5, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(6, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(7, paramString);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeMessages(8, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    TribeVideoPlugin.VideoWrapper localVideoWrapper = a(paramJSONObject);
    if (localVideoWrapper == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(TribeVideoPlugin.VideoWrapper.b(localVideoWrapper))) && (TextUtils.isEmpty(TribeVideoPlugin.VideoWrapper.c(localVideoWrapper))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(TribeVideoPlugin.VideoWrapper.c(localVideoWrapper))) {
      paramJSONObject = TribeVideoPlugin.VideoWrapper.c(localVideoWrapper);
    }
    for (int i = 1; (TribeVideoPlugin.VideoWrapper.c(localVideoWrapper) == 0.0D) || (TribeVideoPlugin.VideoWrapper.d(localVideoWrapper) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = TribeVideoPlugin.VideoWrapper.b(localVideoWrapper);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper)))
    {
      if (!TribeVideoPlugin.VideoWrapper.c((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper));
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
      this.jdField_b_of_type_Int = TribeVideoPlugin.VideoWrapper.a(localVideoWrapper);
      if (TribeVideoPlugin.VideoWrapper.a(localVideoWrapper) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + TribeVideoPlugin.VideoWrapper.a(localVideoWrapper) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localISuperPlayer = a(localISPlayerVideoView, paramJSONObject, i, localVideoWrapper);
      TribeVideoPlugin.VideoWrapper.a(localVideoWrapper, localISuperPlayer);
      if (TribeVideoPlugin.VideoWrapper.b(localVideoWrapper) != 2) {
        break label553;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label394:
      a(paramJSONObject, localISuperPlayer, localVideoWrapper);
      a(localISPlayerVideoView, paramJSONObject, localVideoWrapper);
      if (TribeVideoPlugin.VideoWrapper.b(localVideoWrapper) == 2) {
        this.mRuntime.a().setOnTouchListener(new TribeVideoPlugin.VideoTouchListener(this, TribeVideoPlugin.VideoWrapper.a(localVideoWrapper)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + TribeVideoPlugin.VideoWrapper.a(localVideoWrapper) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label553:
            if (TribeVideoPlugin.VideoWrapper.b(localVideoWrapper) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560518, null);
              break label394;
            }
            if (TribeVideoPlugin.VideoWrapper.b(localVideoWrapper) != 0) {
              break label638;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560519, null);
            break label394;
          }
        }
      }
      TribeVideoPlugin.VideoWrapper.a(localVideoWrapper, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(TribeVideoPlugin.VideoWrapper.a(localVideoWrapper), localVideoWrapper);
      this.jdField_a_of_type_Boolean = false;
      return 0;
      label638:
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
      paramJSONObject1 = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
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
  
  private TribeVideoPlugin.VideoLayoutHolder a(FrameLayout paramFrameLayout, ISuperPlayer paramISuperPlayer, TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    if ((TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) != 2) && (TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) != 1) && (TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) != 0)) {
      return null;
    }
    TribeVideoPlugin.VideoLayoutHolder localVideoLayoutHolder = new TribeVideoPlugin.VideoLayoutHolder(null);
    TribeVideoPlugin.VideoLayoutHolder.a(localVideoLayoutHolder, TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper));
    if (TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) == 2)
    {
      if (TribeVideoPlugin.VideoWrapper.e(paramVideoWrapper) != 0) {
        break label161;
      }
      paramISuperPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramVideoWrapper);
      TribeVideoPlugin.VideoLayoutHolder.a(localVideoLayoutHolder).setVisibility(8);
      TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper, localVideoLayoutHolder);
      return localVideoLayoutHolder;
      if (TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) == 1)
      {
        TribeVideoPlugin.VideoLayoutHolder.a(localVideoLayoutHolder, (ProgressBar)paramFrameLayout.findViewById(2131378027));
        TribeVideoPlugin.VideoLayoutHolder.b(localVideoLayoutHolder, (ProgressBar)paramFrameLayout.findViewById(2131378028));
        break;
      }
      if (TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) != 0) {
        break;
      }
      TribeVideoPlugin.VideoLayoutHolder.a(localVideoLayoutHolder, (ProgressBar)paramFrameLayout.findViewById(2131372343));
      break;
      label161:
      if (TribeVideoPlugin.VideoWrapper.e(paramVideoWrapper) == 1) {
        paramISuperPlayer.setOutputMute(true);
      }
    }
  }
  
  /* Error */
  private TribeVideoPlugin.VideoWrapper a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 124	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 494	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:<init>	(Lcom/tencent/biz/tribe/TribeVideoPlugin$1;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: ldc_w 496
    //   16: invokevirtual 499	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 502	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:a	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;Ljava/lang/String;)Ljava/lang/String;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: ldc_w 504
    //   29: invokevirtual 499	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 506	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:b	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;Ljava/lang/String;)Ljava/lang/String;
    //   35: pop
    //   36: aload 4
    //   38: aload_1
    //   39: ldc_w 416
    //   42: invokevirtual 499	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 508	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:c	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload 4
    //   51: aload_1
    //   52: ldc_w 510
    //   55: dconst_0
    //   56: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   59: invokestatic 517	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:a	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   62: pop2
    //   63: aload 4
    //   65: aload_1
    //   66: ldc_w 519
    //   69: dconst_0
    //   70: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   73: invokestatic 521	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:b	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   76: pop2
    //   77: aload 4
    //   79: aload_1
    //   80: ldc_w 523
    //   83: dconst_0
    //   84: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   87: invokestatic 525	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:c	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   90: pop2
    //   91: aload 4
    //   93: aload_1
    //   94: ldc_w 527
    //   97: dconst_0
    //   98: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   101: invokestatic 529	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:d	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   104: pop2
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 531
    //   111: iconst_0
    //   112: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   115: invokestatic 538	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:a	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: ldc_w 540
    //   125: iconst_1
    //   126: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   129: invokestatic 542	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:b	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: ldc_w 544
    //   139: iconst_0
    //   140: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   143: invokestatic 546	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:c	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   146: pop
    //   147: aload 4
    //   149: aload_1
    //   150: ldc_w 548
    //   153: iconst_0
    //   154: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   157: invokestatic 550	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:d	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   160: pop
    //   161: aload 4
    //   163: invokestatic 349	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:b	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;)I
    //   166: iconst_2
    //   167: if_icmpne +10 -> 177
    //   170: aload 4
    //   172: iconst_0
    //   173: invokestatic 550	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:d	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   176: pop
    //   177: aload 4
    //   179: aload_1
    //   180: ldc_w 552
    //   183: iconst_1
    //   184: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   187: invokestatic 554	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:e	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: ldc_w 556
    //   197: iconst_0
    //   198: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: invokestatic 558	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:f	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   204: pop
    //   205: aload 4
    //   207: aload_1
    //   208: ldc_w 560
    //   211: iconst_0
    //   212: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: invokestatic 563	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:g	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   218: pop
    //   219: aload_1
    //   220: ldc_w 565
    //   223: iconst_0
    //   224: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   227: istore_2
    //   228: iload_2
    //   229: iconst_1
    //   230: if_icmpne +77 -> 307
    //   233: aload 4
    //   235: iconst_1
    //   236: invokestatic 567	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:c	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;Z)Z
    //   239: pop
    //   240: aload 4
    //   242: aload_1
    //   243: ldc_w 569
    //   246: dconst_0
    //   247: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   250: invokestatic 571	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:e	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   253: pop2
    //   254: aload 4
    //   256: aload_1
    //   257: ldc_w 573
    //   260: dconst_0
    //   261: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   264: invokestatic 575	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:f	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;D)D
    //   267: pop2
    //   268: aload 4
    //   270: aload_1
    //   271: ldc_w 577
    //   274: iconst_0
    //   275: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   278: invokestatic 580	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:h	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;I)I
    //   281: pop
    //   282: aload 4
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 49	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   289: ifgt +61 -> 350
    //   292: aload_0
    //   293: aload_1
    //   294: ldc_w 582
    //   297: iconst_m1
    //   298: invokevirtual 535	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   301: putfield 49	com/tencent/biz/tribe/TribeVideoPlugin:e	I
    //   304: aload 4
    //   306: areturn
    //   307: iload_2
    //   308: ifne -68 -> 240
    //   311: aload 4
    //   313: iconst_0
    //   314: invokestatic 567	com/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper:c	(Lcom/tencent/biz/tribe/TribeVideoPlugin$VideoWrapper;Z)Z
    //   317: pop
    //   318: goto -78 -> 240
    //   321: astore_3
    //   322: ldc 155
    //   324: iconst_1
    //   325: new 157	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 584
    //   335: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	TribeVideoPlugin
    //   0	352	1	paramJSONObject	JSONObject
    //   227	81	2	i	int
    //   284	1	3	localVideoWrapper1	TribeVideoPlugin.VideoWrapper
    //   321	1	3	localException	Exception
    //   349	2	3	localVideoWrapper2	TribeVideoPlugin.VideoWrapper
    //   8	304	4	localVideoWrapper3	TribeVideoPlugin.VideoWrapper
    // Exception table:
    //   from	to	target	type
    //   10	177	321	java/lang/Exception
    //   177	228	321	java/lang/Exception
    //   233	240	321	java/lang/Exception
    //   240	282	321	java/lang/Exception
    //   285	304	321	java/lang/Exception
    //   311	318	321	java/lang/Exception
  }
  
  private VideoLayout a(ISPlayerVideoView paramISPlayerVideoView, FrameLayout paramFrameLayout, TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramISPlayerVideoView);
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (TribeVideoPlugin.VideoWrapper.f(paramVideoWrapper) == 1) {
      localVideoLayout.setOnTouchListener(new TribeVideoPlugin.6(this));
    }
    if ((this.f > 0) && (this.e > 0)) {}
    for (float f1 = this.f / this.e;; f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density)
    {
      paramISPlayerVideoView = new FrameLayout.LayoutParams((int)(TribeVideoPlugin.VideoWrapper.c(paramVideoWrapper) * f1), (int)(TribeVideoPlugin.VideoWrapper.d(paramVideoWrapper) * f1));
      paramISPlayerVideoView.topMargin = ((int)(TribeVideoPlugin.VideoWrapper.e(paramVideoWrapper) * f1));
      paramISPlayerVideoView.leftMargin = ((int)(TribeVideoPlugin.VideoWrapper.f(paramVideoWrapper) * f1));
      TribeVideoPlugin.VideoWrapper.e(paramVideoWrapper, TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper) * f1);
      TribeVideoPlugin.VideoWrapper.f(paramVideoWrapper, this.c - TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper) * f1);
      if (TribeVideoPlugin.VideoWrapper.g(paramVideoWrapper) > 0) {
        localVideoLayout.setRoundCorner((int)(TribeVideoPlugin.VideoWrapper.g(paramVideoWrapper) * f1));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramISPlayerVideoView);
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "sDensity:" + f1);
      }
      TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper, localVideoLayout);
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
  
  private ISuperPlayer a(ISPlayerVideoView paramISPlayerVideoView, String paramString, int paramInt, TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    paramISPlayerVideoView = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 111, paramISPlayerVideoView);
    paramISPlayerVideoView.setXYaxis(2);
    if (TribeVideoPlugin.VideoWrapper.c(paramVideoWrapper) == 0) {
      paramISPlayerVideoView.setLoopback(true);
    }
    a(paramISPlayerVideoView, paramVideoWrapper);
    a(TribeVideoPlugin.VideoWrapper.d(paramVideoWrapper), paramString, paramInt, paramISPlayerVideoView, paramVideoWrapper);
    return paramISPlayerVideoView;
  }
  
  private ISPlayerVideoView a()
  {
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.jdField_a_of_type_AndroidContentContext);
    localISPlayerVideoView.addViewCallBack(new TribeVideoPlugin.5(this));
    return localISPlayerVideoView;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject))
      {
        int i = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject)) || (j > TribeVideoPlugin.VideoWrapper.b((TribeVideoPlugin.VideoWrapper)localObject)))
        {
          if (TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).isPlaying())
          {
            TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).pause();
            TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).setVisibility(8);
            TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject, true);
            a(TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject) + " mVideoInnerLayout.getTop = " + TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (TribeVideoPlugin.VideoWrapper.b((TribeVideoPlugin.VideoWrapper)localObject))
        {
          TribeVideoPlugin.VideoWrapper.b((TribeVideoPlugin.VideoWrapper)localObject, false);
          TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).start();
          TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject).setVisibility(0);
          TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject, false);
          if ((TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.obtainMessage();
            localMessage.obj = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject));
            }
          }
          else
          {
            a(TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, ISuperPlayer paramISuperPlayer, TribeVideoPlugin.VideoWrapper paramVideoWrapper)
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
        paramString = SuperPlayerFactory.createVideoInfoForTVideo(4080303, TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper));
      }
    }
  }
  
  private void a(TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new TribeVideoPlugin.TimeCountTask(this, TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper)), 0L, 30L);
    TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper, localTimer);
  }
  
  private void a(ISuperPlayer paramISuperPlayer, TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    paramISuperPlayer.setOnVideoPreparedListener(new TribeVideoPlugin.2(this, paramVideoWrapper));
    paramISuperPlayer.setOnCompletionListener(new TribeVideoPlugin.3(this, paramVideoWrapper));
    paramISuperPlayer.setOnErrorListener(new TribeVideoPlugin.4(this, paramVideoWrapper));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        TribeVideoPlugin.VideoLayoutHolder.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    TribeVideoPlugin.VideoWrapper localVideoWrapper = (TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localVideoWrapper == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", TribeVideoPlugin.VideoWrapper.a(localVideoWrapper).getCurrentPositionMs());
        localJSONObject.put("duration", TribeVideoPlugin.VideoWrapper.a(localVideoWrapper).getDurationMs());
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
      localObject = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131377688);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131374814);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131374813);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131374812);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131374811);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131374810);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131374809);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130849014;
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
      i = 2130849563;
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
  
  private void b(TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    TribeVideoPlugin.VideoWrapper.d(paramVideoWrapper, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper) + " mIsPaused=" + TribeVideoPlugin.VideoWrapper.d(paramVideoWrapper) + " isPlaying=" + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).isPlaying());
    }
    if (TribeVideoPlugin.VideoWrapper.d(paramVideoWrapper)) {}
    for (;;)
    {
      return;
      if (TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).isPlaying()) {
        continue;
      }
      if (TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper))
      {
        int i = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper)) || (j > TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper) + " mVideoInnerLayout.getTop = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 3);
          TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper, true);
          return;
        }
      }
      a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper));
      try
      {
        TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).start();
        TribeVideoPlugin.VideoWrapper.b(paramVideoWrapper, TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).getDurationMs());
        TribeVideoPlugin.VideoWrapper.e(paramVideoWrapper, true);
        Message localMessage = this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.obtainMessage();
        localMessage.obj = TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper);
        localMessage.what = 4;
        this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper));
          a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 5);
          ReportController.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper));
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    TribeVideoPlugin.VideoWrapper localVideoWrapper = (TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localVideoWrapper == null) {
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
        localObject2 = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        localObject1 = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
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
          if (TribeVideoPlugin.VideoLayoutHolder.a((TribeVideoPlugin.VideoLayoutHolder)localObject1) == 1) {
            TribeVideoPlugin.VideoLayoutHolder.b((TribeVideoPlugin.VideoLayoutHolder)localObject1).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
          }
        }
      }
      if (TribeVideoPlugin.VideoLayoutHolder.a((TribeVideoPlugin.VideoLayoutHolder)localObject1) != 2) {
        break;
      }
      Object localObject2 = TribeVideoPlugin.VideoLayoutHolder.a((TribeVideoPlugin.VideoLayoutHolder)localObject1);
      localTextView1 = TribeVideoPlugin.VideoLayoutHolder.a((TribeVideoPlugin.VideoLayoutHolder)localObject1);
      localTextView2 = TribeVideoPlugin.VideoLayoutHolder.b((TribeVideoPlugin.VideoLayoutHolder)localObject1);
      localObject1 = TribeVideoPlugin.VideoLayoutHolder.c((TribeVideoPlugin.VideoLayoutHolder)localObject1);
      VideoFeedsHelper.a(localTextView1, l2 - l1);
      VideoFeedsHelper.a(localTextView2, l1);
      VideoFeedsHelper.a((TextView)localObject1, l2);
      ((SeekBar)localObject2).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
      if ((l1 <= 100L) && (!TribeVideoPlugin.VideoWrapper.e(localVideoWrapper)) && (bool1))
      {
        a(paramString, 1);
        TribeVideoPlugin.VideoWrapper.e(localVideoWrapper, true);
      }
    } while ((TribeVideoPlugin.VideoWrapper.b(localVideoWrapper) - l1 > 100L) || (!TribeVideoPlugin.VideoWrapper.e(localVideoWrapper)) || (!bool1));
    a(paramString, 2);
    TribeVideoPlugin.VideoWrapper.e(localVideoWrapper, false);
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
      localObject = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
  
  private void c(TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    if (TribeVideoPlugin.VideoWrapper.c(paramVideoWrapper) == 1)
    {
      TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper).seekTo(0);
      a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 2);
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
          a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(TribeVideoPlugin.VideoWrapper paramVideoWrapper)
  {
    a(TribeVideoPlugin.VideoWrapper.a(paramVideoWrapper), 5);
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
      paramJSONObject = TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
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
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivityForTool.class, TribeVideoListPlayerFragment.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772343, 2130772344);
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
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler = new TribeVideoPlugin.UIHandler(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$UIHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
      TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      TribeVideoPlugin.VideoWrapper.a((TribeVideoPlugin.VideoWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(str), null);
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
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131381873));
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListenerForBiz(new TribeVideoPlugin.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */