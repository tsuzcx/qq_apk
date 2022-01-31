package com.tencent.biz.tribe;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import ozr;
import ozs;
import ozt;
import ozu;
import ozv;
import ozw;
import ozx;
import ozy;
import paa;
import pab;
import pac;
import pad;
import pae;
import paf;

public class TribeVideoPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private pac jdField_a_of_type_Pac;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  
  public TribeVideoPlugin()
  {
    this.mPluginNameSpace = "tribeVideoPlayer";
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
        a(paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject), null);
        this.jdField_a_of_type_Pac.removeCallbacksAndMessages(null);
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
    a(paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString), null);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Pac.removeMessages(2, paramString);
    this.jdField_a_of_type_Pac.removeMessages(1, paramString);
    this.jdField_a_of_type_Pac.removeMessages(3, paramString);
    this.jdField_a_of_type_Pac.removeMessages(4, paramString);
    this.jdField_a_of_type_Pac.removeMessages(5, paramString);
    this.jdField_a_of_type_Pac.removeMessages(6, paramString);
    this.jdField_a_of_type_Pac.removeMessages(7, paramString);
    this.jdField_a_of_type_Pac.removeMessages(8, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    paf localpaf = a(paramJSONObject);
    if (localpaf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(paf.a(localpaf)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(paf.b(localpaf))) && (TextUtils.isEmpty(paf.c(localpaf))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(paf.c(localpaf))) {
      paramJSONObject = paf.c(localpaf);
    }
    for (int i = 1; (paf.c(localpaf) == 0.0D) || (paf.d(localpaf) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = paf.b(localpaf);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paf.a(localpaf)))
    {
      if (!paf.c((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paf.a(localpaf))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(paf.a(localpaf));
    }
    IVideoViewBase localIVideoViewBase = a();
    if (localIVideoViewBase == null) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new paa(this, bool), 5, null, true);
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
      this.jdField_b_of_type_Int = paf.a(localpaf);
      if (paf.a(localpaf) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + paf.a(localpaf) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localTVK_IMediaPlayer = a(localIVideoViewBase, paramJSONObject, i, localpaf);
      paf.a(localpaf, localTVK_IMediaPlayer);
      if (paf.b(localpaf) != 2) {
        break label602;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label438:
      a(paramJSONObject, localTVK_IMediaPlayer, localpaf);
      a(localIVideoViewBase, paramJSONObject, localpaf);
      if (paf.b(localpaf) == 2) {
        this.mRuntime.a().setOnTouchListener(new pae(this, paf.a(localpaf)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(paf.a(localpaf));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + paf.a(localpaf) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label602:
            if (paf.b(localpaf) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969699, null);
              break label438;
            }
            if (paf.b(localpaf) != 0) {
              break label726;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969700, null);
            break label438;
          }
        }
      }
      paf.a(localpaf, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(paf.a(localpaf), localpaf);
      this.jdField_a_of_type_Boolean = false;
      paramJSONObject = this.jdField_a_of_type_Pac.obtainMessage();
      paramJSONObject.obj = paf.a(localpaf);
      paramJSONObject.what = 3;
      this.jdField_a_of_type_Pac.sendMessageDelayed(paramJSONObject, 10000L);
      return 0;
      label726:
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
      paramJSONObject1 = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
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
  
  private int a(paf parampaf, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (paf.a(parampaf)))
    {
      int j = paf.a(parampaf).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = paf.a(parampaf).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < paf.a(parampaf)) || (m - n > paf.b(parampaf)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + paf.a(parampaf));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = paf.a(parampaf);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (paf.a(parampaf).isPauseing()) {
          a(paf.a(parampaf), 1);
        }
        paf.b(parampaf, false);
        paf.a(parampaf).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(paf.a(parampaf), 3);
    paf.b(parampaf, true);
    paf.a(parampaf).pause();
    this.jdField_a_of_type_Pac.removeMessages(3, paf.a(parampaf));
    return 0;
  }
  
  private VideoLayout a(IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout, paf parampaf)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramIVideoViewBase);
    ((View)paramIVideoViewBase).setTag("VideoViewTAG");
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (paf.f(parampaf) == 1) {
      localVideoLayout.setOnTouchListener(new ozx(this));
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramIVideoViewBase = new FrameLayout.LayoutParams((int)(paf.c(parampaf) * f), (int)(paf.d(parampaf) * f));
    paramIVideoViewBase.topMargin = ((int)(paf.e(parampaf) * f));
    paramIVideoViewBase.leftMargin = ((int)(paf.f(parampaf) * f));
    paf.e(parampaf, paf.a(parampaf) * f);
    paf.f(parampaf, this.c - paf.b(parampaf) * f);
    if (paf.g(parampaf) > 0) {
      localVideoLayout.setRoundCorner((int)(paf.g(parampaf) * f));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramIVideoViewBase);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "sDensity:" + f);
    }
    paf.a(parampaf, localVideoLayout);
    return localVideoLayout;
  }
  
  private TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase, String paramString, int paramInt, paf parampaf)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramIVideoViewBase);
    paramIVideoViewBase.setXYaxis(2);
    if (paf.c(parampaf) == 0) {
      paramIVideoViewBase.setLoopback(true);
    }
    a(paramIVideoViewBase, parampaf);
    a(paf.d(parampaf), paramString, paramInt, paramIVideoViewBase, parampaf);
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
      localObject = Toast.makeText(this.mRuntime.a().getApplication(), "腾讯视频插件安装中,请稍等..", 1);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
      return null;
      ThreadManager.post(new ozy(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ((IVideoViewBase)localObject).addViewCallBack(new ozw(this));
    return localObject;
  }
  
  private pad a(FrameLayout paramFrameLayout, TVK_IMediaPlayer paramTVK_IMediaPlayer, paf parampaf)
  {
    if ((paf.b(parampaf) != 2) && (paf.b(parampaf) != 1) && (paf.b(parampaf) != 0)) {
      return null;
    }
    pad localpad = new pad(null);
    pad.a(localpad, paf.b(parampaf));
    if (paf.b(parampaf) == 2)
    {
      if (paf.e(parampaf) != 0) {
        break label162;
      }
      paramTVK_IMediaPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(parampaf);
      pad.a(localpad).setVisibility(8);
      paf.a(parampaf, localpad);
      return localpad;
      if (paf.b(parampaf) == 1)
      {
        pad.a(localpad, (ProgressBar)paramFrameLayout.findViewById(2131367542));
        pad.b(localpad, (ProgressBar)paramFrameLayout.findViewById(2131367543));
        break;
      }
      if (paf.b(parampaf) != 0) {
        break;
      }
      pad.a(localpad, (ProgressBar)paramFrameLayout.findViewById(2131367544));
      break;
      label162:
      if (paf.e(parampaf) == 1) {
        paramTVK_IMediaPlayer.setOutputMute(true);
      }
    }
  }
  
  private paf a(JSONObject paramJSONObject)
  {
    paf localpaf = new paf(null);
    try
    {
      paf.a(localpaf, paramJSONObject.optString("vid"));
      paf.b(localpaf, paramJSONObject.optString("videoPath"));
      paf.c(localpaf, paramJSONObject.optString("playerID"));
      paf.a(localpaf, paramJSONObject.optDouble("top", 0.0D));
      paf.b(localpaf, paramJSONObject.optDouble("left", 0.0D));
      paf.c(localpaf, paramJSONObject.optDouble("width", 0.0D));
      paf.d(localpaf, paramJSONObject.optDouble("height", 0.0D));
      paf.a(localpaf, paramJSONObject.optInt("time", 0));
      paf.b(localpaf, paramJSONObject.optInt("needMute", 1));
      paf.c(localpaf, paramJSONObject.optInt("playMode", 0));
      paf.d(localpaf, paramJSONObject.optInt("showUIController", 0));
      if (paf.b(localpaf) == 2) {
        paf.d(localpaf, 0);
      }
      paf.e(localpaf, paramJSONObject.optInt("needCountdown", 1));
      paf.f(localpaf, paramJSONObject.optInt("videoTouchIntercept", 0));
      paf.g(localpaf, paramJSONObject.optInt("repeatType", 0));
      int i = paramJSONObject.optInt("needCheckShowArea", 0);
      if (i == 1) {
        paf.c(localpaf, true);
      }
      for (;;)
      {
        paf.e(localpaf, paramJSONObject.optDouble("showAreaTop", 0.0D));
        paf.f(localpaf, paramJSONObject.optDouble("showAreaBottom", 0.0D));
        paf.h(localpaf, paramJSONObject.optInt("roundCorner", 0));
        return localpaf;
        if (i == 0) {
          paf.c(localpaf, false);
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("TribeVideoPlugin", 1, "AddView Err: json = " + paramJSONObject);
    }
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (paf.a((paf)localObject))
      {
        int i = paf.a((paf)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = paf.a((paf)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < paf.a((paf)localObject)) || (j > paf.b((paf)localObject)))
        {
          if (paf.a((paf)localObject).isPlaying())
          {
            paf.a((paf)localObject).pause();
            paf.a((paf)localObject).setVisibility(8);
            paf.a((paf)localObject, true);
            a(paf.a((paf)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + paf.a((paf)localObject) + " mVideoInnerLayout.getTop = " + paf.a((paf)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + paf.a((paf)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (paf.b((paf)localObject))
        {
          paf.b((paf)localObject, false);
          paf.a((paf)localObject).start();
          paf.a((paf)localObject).setVisibility(0);
          paf.a((paf)localObject, false);
          if ((paf.a((paf)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Pac.obtainMessage();
            localMessage.obj = paf.a((paf)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Pac.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + paf.a((paf)localObject));
            }
          }
          else
          {
            a(paf.a((paf)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + paf.a((paf)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, TVK_IMediaPlayer paramTVK_IMediaPlayer, paf parampaf)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setLoginCookie("");
    localTVK_UserInfo.setUin(this.mRuntime.a().getCurrentAccountUin());
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    if (!TextUtils.isEmpty(paf.b(parampaf)))
    {
      localTVK_PlayerVideoInfo.setVid(paf.b(parampaf));
      localTVK_PlayerVideoInfo.setPlayMode("cache_video");
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      if (paramInt2 != 0) {
        break label130;
      }
      paramTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, localTVK_UserInfo, localTVK_PlayerVideoInfo, "hd", paramInt1, 0L);
    }
    label130:
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
  
  private void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, paf parampaf)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new ozt(this, parampaf));
    paramTVK_IMediaPlayer.setOnCompletionListener(new ozu(this, parampaf));
    paramTVK_IMediaPlayer.setOnErrorListener(new ozv(this, parampaf));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        pad.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    paf localpaf = (paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localpaf == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", paf.a(localpaf).getCurrentPostion());
        localJSONObject.put("duration", paf.a(localpaf).getDuration());
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
      localObject = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131364703);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131362357);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131362356);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131362358);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131362354);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131362355);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131367510);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130845085;
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
      i = 2130845367;
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
  
  private void a(paf parampaf)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new pab(this, paf.a(parampaf)), 0L, 30L);
    paf.a(parampaf, localTimer);
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
    paf localpaf = (paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localpaf == null) {
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
        localObject2 = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
        localObject1 = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
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
          if (pad.a((pad)localObject1) == 1) {
            pad.b((pad)localObject1).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
          }
        }
      }
      if (pad.a((pad)localObject1) != 2) {
        break;
      }
      Object localObject2 = pad.a((pad)localObject1);
      localTextView1 = pad.a((pad)localObject1);
      localTextView2 = pad.b((pad)localObject1);
      localObject1 = pad.c((pad)localObject1);
      VideoFeedsHelper.a(localTextView1, l2 - l1);
      VideoFeedsHelper.a(localTextView2, l1);
      VideoFeedsHelper.a((TextView)localObject1, l2);
      ((SeekBar)localObject2).setProgress((int)((float)l1 * 100.0F / (float)l2 + 0.5D));
      if ((l1 <= 100L) && (!paf.e(localpaf)) && (bool1))
      {
        a(paramString, 1);
        paf.e(localpaf, true);
      }
    } while ((paf.b(localpaf) - l1 > 100L) || (!paf.e(localpaf)) || (!bool1));
    a(paramString, 2);
    paf.e(localpaf, false);
  }
  
  private void b(paf parampaf)
  {
    paf.d(parampaf, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + paf.a(parampaf) + " mIsPaused=" + paf.d(parampaf) + " isPlaying=" + paf.a(parampaf).isPlaying());
    }
    if (paf.d(parampaf)) {}
    for (;;)
    {
      return;
      if (paf.a(parampaf).isPlaying()) {
        continue;
      }
      if (paf.a(parampaf))
      {
        int i = paf.a(parampaf).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = paf.a(parampaf).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < paf.a(parampaf)) || (j > paf.b(parampaf)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + paf.a(parampaf) + " mVideoInnerLayout.getTop = " + paf.a(parampaf).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + paf.a(parampaf).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(paf.a(parampaf), 3);
          paf.a(parampaf, true);
          return;
        }
      }
      a(paf.a(parampaf));
      try
      {
        paf.a(parampaf).start();
        paf.b(parampaf, paf.a(parampaf).getDuration());
        paf.e(parampaf, true);
        Message localMessage = this.jdField_a_of_type_Pac.obtainMessage();
        localMessage.obj = paf.a(parampaf);
        localMessage.what = 4;
        this.jdField_a_of_type_Pac.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + paf.a(parampaf));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(paf.a(parampaf));
          a(paf.a(parampaf), 5);
          ReportController.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + paf.a(parampaf));
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
      localObject = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
  
  private void c(paf parampaf)
  {
    if (paf.c(parampaf) == 1)
    {
      paf.a(parampaf).seekTo(0);
      a(paf.a(parampaf), 2);
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
          a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(paf parampaf)
  {
    a(paf.a(parampaf), 5);
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
      paramJSONObject = paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      paramString1 = paramJsBridgeListener.optString("callback");
      paramString2 = new JSONObject();
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "handleJsRequest method = " + paramString3 + " jsonObject = " + paramJsBridgeListener);
      }
      int i;
      if ("pinVideo".equals(paramString3))
      {
        paramString3 = paramJsBridgeListener.optString("onStateChange");
        if ((this.jdField_a_of_type_JavaLangString == null) && (paramString3 != null)) {
          this.jdField_a_of_type_JavaLangString = paramString3;
        }
        i = a(paramJsBridgeListener);
      }
      for (;;)
      {
        paramString2.put("retCode", i);
        callJs(paramString1, new String[] { paramString2.toString() });
        return true;
        if ("pluckVideo".equals(paramString3))
        {
          i = b(paramJsBridgeListener);
        }
        else if ("muteSound".equals(paramString3))
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
        else
        {
          i = -1;
          QLog.e("TribeVideoPlugin", 1, "no such method = " + paramString3);
        }
      }
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.e("TribeVideoPlugin", 1, "[handleJsRequest] error=", paramJsBridgeListener);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Pac = new pac(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new ozr(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Pac.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
      paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      paf.a((paf)this.jdField_a_of_type_JavaUtilHashMap.get(str), null);
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    QLog.d("TribeVideoPlugin", 1, "onDestroy");
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131366767));
    if (((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131368214) == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mRuntime.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131368214);
      this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramCustomWebView);
      this.c = this.jdField_a_of_type_ComTencentBizUiRefreshView.getHeight();
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
        this.d = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "onWebViewCreated mVideoLayoutHeight = " + this.c + " titleHeight = " + this.d);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.mRuntime.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollBy(0, this.jdField_a_of_type_ComTencentBizUiTouchWebView.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(new ozs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */