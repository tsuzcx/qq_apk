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
import otg;
import oth;
import oti;
import otj;
import otk;
import otl;
import otm;
import otn;
import otp;
import otq;
import otr;
import ots;
import ott;
import otu;

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
  private otr jdField_a_of_type_Otr;
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
        break label171;
      }
      paramString = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        a(otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        this.jdField_a_of_type_Otr.removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      i = 0;
    }
    label171:
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
    a(otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Otr.removeMessages(2, paramString);
    this.jdField_a_of_type_Otr.removeMessages(1, paramString);
    this.jdField_a_of_type_Otr.removeMessages(3, paramString);
    this.jdField_a_of_type_Otr.removeMessages(4, paramString);
    this.jdField_a_of_type_Otr.removeMessages(5, paramString);
    this.jdField_a_of_type_Otr.removeMessages(6, paramString);
    this.jdField_a_of_type_Otr.removeMessages(7, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    otu localotu = a(paramJSONObject);
    if (localotu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(otu.a(localotu)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(otu.b(localotu))) && (TextUtils.isEmpty(otu.c(localotu))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(otu.c(localotu))) {
      paramJSONObject = otu.c(localotu);
    }
    for (int i = 1; (otu.c(localotu) == 0.0D) || (otu.d(localotu) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = otu.b(localotu);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(otu.a(localotu)))
    {
      if (!otu.c((otu)this.jdField_a_of_type_JavaUtilHashMap.get(otu.a(localotu))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(otu.a(localotu));
    }
    IVideoViewBase localIVideoViewBase = a();
    if (localIVideoViewBase == null) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new otp(this, bool), 5, null, true);
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
      this.jdField_b_of_type_Int = otu.a(localotu);
      if (otu.a(localotu) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + otu.a(localotu) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localTVK_IMediaPlayer = a(localIVideoViewBase, paramJSONObject, i, localotu);
      otu.a(localotu, localTVK_IMediaPlayer);
      if (otu.b(localotu) != 2) {
        break label602;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label438:
      a(paramJSONObject, localTVK_IMediaPlayer, localotu);
      a(localIVideoViewBase, paramJSONObject, localotu);
      if (otu.b(localotu) == 2) {
        this.mRuntime.a().setOnTouchListener(new ott(this, otu.a(localotu)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(otu.a(localotu));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + otu.a(localotu) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label602:
            if (otu.b(localotu) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969688, null);
              break label438;
            }
            if (otu.b(localotu) != 0) {
              break label726;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969689, null);
            break label438;
          }
        }
      }
      otu.a(localotu, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(otu.a(localotu), localotu);
      this.jdField_a_of_type_Boolean = false;
      paramJSONObject = this.jdField_a_of_type_Otr.obtainMessage();
      paramJSONObject.obj = otu.a(localotu);
      paramJSONObject.what = 3;
      this.jdField_a_of_type_Otr.sendMessageDelayed(paramJSONObject, 10000L);
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
      paramJSONObject1 = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
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
  
  private int a(otu paramotu, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (otu.a(paramotu)))
    {
      int j = otu.a(paramotu).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = otu.a(paramotu).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < otu.a(paramotu)) || (m - n > otu.b(paramotu)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + otu.a(paramotu));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = otu.a(paramotu);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (otu.a(paramotu).isPauseing()) {
          a(otu.a(paramotu), 1);
        }
        otu.b(paramotu, false);
        otu.a(paramotu).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(otu.a(paramotu), 3);
    otu.b(paramotu, true);
    otu.a(paramotu).pause();
    return 0;
  }
  
  private VideoLayout a(IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout, otu paramotu)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramIVideoViewBase);
    ((View)paramIVideoViewBase).setTag("VideoViewTAG");
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (otu.f(paramotu) == 1) {
      localVideoLayout.setOnTouchListener(new otm(this));
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramIVideoViewBase = new FrameLayout.LayoutParams((int)(otu.c(paramotu) * f), (int)(otu.d(paramotu) * f));
    paramIVideoViewBase.topMargin = ((int)(otu.e(paramotu) * f));
    paramIVideoViewBase.leftMargin = ((int)(otu.f(paramotu) * f));
    otu.e(paramotu, otu.a(paramotu) * f);
    otu.f(paramotu, this.c - otu.b(paramotu) * f);
    if (otu.g(paramotu) > 0) {
      localVideoLayout.setRoundCorner((int)(otu.g(paramotu) * f));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramIVideoViewBase);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "sDensity:" + f);
    }
    otu.a(paramotu, localVideoLayout);
    return localVideoLayout;
  }
  
  private TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase, String paramString, int paramInt, otu paramotu)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramIVideoViewBase);
    paramIVideoViewBase.setXYaxis(2);
    if (otu.c(paramotu) == 0) {
      paramIVideoViewBase.setLoopback(true);
    }
    a(paramIVideoViewBase, paramotu);
    a(otu.d(paramotu), paramString, paramInt, paramIVideoViewBase, paramotu);
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
      ThreadManager.post(new otn(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ((IVideoViewBase)localObject).addViewCallBack(new otl(this));
    return localObject;
  }
  
  private ots a(FrameLayout paramFrameLayout, TVK_IMediaPlayer paramTVK_IMediaPlayer, otu paramotu)
  {
    if ((otu.b(paramotu) != 2) && (otu.b(paramotu) != 1) && (otu.b(paramotu) != 0)) {
      return null;
    }
    ots localots = new ots(null);
    ots.a(localots, otu.b(paramotu));
    if (otu.b(paramotu) == 2)
    {
      if (otu.e(paramotu) != 0) {
        break label162;
      }
      paramTVK_IMediaPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramotu);
      ots.a(localots).setVisibility(8);
      otu.a(paramotu, localots);
      return localots;
      if (otu.b(paramotu) == 1)
      {
        ots.a(localots, (ProgressBar)paramFrameLayout.findViewById(2131367467));
        ots.b(localots, (ProgressBar)paramFrameLayout.findViewById(2131367468));
        break;
      }
      if (otu.b(paramotu) != 0) {
        break;
      }
      ots.a(localots, (ProgressBar)paramFrameLayout.findViewById(2131367469));
      break;
      label162:
      if (otu.e(paramotu) == 1) {
        paramTVK_IMediaPlayer.setOutputMute(true);
      }
    }
  }
  
  private otu a(JSONObject paramJSONObject)
  {
    otu localotu = new otu(null);
    try
    {
      otu.a(localotu, paramJSONObject.optString("vid"));
      otu.b(localotu, paramJSONObject.optString("videoPath"));
      otu.c(localotu, paramJSONObject.optString("playerID"));
      otu.a(localotu, paramJSONObject.optDouble("top", 0.0D));
      otu.b(localotu, paramJSONObject.optDouble("left", 0.0D));
      otu.c(localotu, paramJSONObject.optDouble("width", 0.0D));
      otu.d(localotu, paramJSONObject.optDouble("height", 0.0D));
      otu.a(localotu, paramJSONObject.optInt("time", 0));
      otu.b(localotu, paramJSONObject.optInt("needMute", 1));
      otu.c(localotu, paramJSONObject.optInt("playMode", 0));
      otu.d(localotu, paramJSONObject.optInt("showUIController", 0));
      if (otu.b(localotu) == 2) {
        otu.d(localotu, 0);
      }
      otu.e(localotu, paramJSONObject.optInt("needCountdown", 1));
      otu.f(localotu, paramJSONObject.optInt("videoTouchIntercept", 0));
      otu.g(localotu, paramJSONObject.optInt("repeatType", 0));
      int i = paramJSONObject.optInt("needCheckShowArea", 0);
      if (i == 1) {
        otu.c(localotu, true);
      }
      for (;;)
      {
        otu.e(localotu, paramJSONObject.optDouble("showAreaTop", 0.0D));
        otu.f(localotu, paramJSONObject.optDouble("showAreaBottom", 0.0D));
        otu.h(localotu, paramJSONObject.optInt("roundCorner", 0));
        return localotu;
        if (i == 0) {
          otu.c(localotu, false);
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
      localObject = (otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (otu.a((otu)localObject))
      {
        int i = otu.a((otu)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = otu.a((otu)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < otu.a((otu)localObject)) || (j > otu.b((otu)localObject)))
        {
          if (otu.a((otu)localObject).isPlaying())
          {
            otu.a((otu)localObject).pause();
            otu.a((otu)localObject).setVisibility(8);
            otu.a((otu)localObject, true);
            a(otu.a((otu)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + otu.a((otu)localObject) + " mVideoInnerLayout.getTop = " + otu.a((otu)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + otu.a((otu)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (otu.b((otu)localObject))
        {
          otu.b((otu)localObject, false);
          otu.a((otu)localObject).start();
          otu.a((otu)localObject).setVisibility(0);
          otu.a((otu)localObject, false);
          if ((otu.a((otu)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Otr.obtainMessage();
            localMessage.obj = otu.a((otu)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Otr.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + otu.a((otu)localObject));
            }
          }
          else
          {
            a(otu.a((otu)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + otu.a((otu)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, TVK_IMediaPlayer paramTVK_IMediaPlayer, otu paramotu)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setLoginCookie("");
    localTVK_UserInfo.setUin(this.mRuntime.a().getCurrentAccountUin());
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    if (!TextUtils.isEmpty(otu.b(paramotu)))
    {
      localTVK_PlayerVideoInfo.setVid(otu.b(paramotu));
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
  
  private void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, otu paramotu)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new oti(this, paramotu));
    paramTVK_IMediaPlayer.setOnCompletionListener(new otj(this, paramotu));
    paramTVK_IMediaPlayer.setOnErrorListener(new otk(this, paramotu));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        ots.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    otu localotu = (otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localotu == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", otu.a(localotu).getCurrentPostion());
        localJSONObject.put("duration", otu.a(localotu).getDuration());
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
      localObject = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131364655);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131362354);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131362353);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131362355);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131362351);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131362352);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131367435);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130844885;
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
      i = 2130845166;
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
  
  private void a(otu paramotu)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new otq(this, otu.a(paramotu)), 0L, 30L);
    otu.a(paramotu, localTimer);
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
  
  private void b(otu paramotu)
  {
    otu.d(paramotu, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + otu.a(paramotu) + " mIsPaused=" + otu.d(paramotu) + " isPlaying=" + otu.a(paramotu).isPlaying());
    }
    if (otu.d(paramotu)) {}
    for (;;)
    {
      return;
      if (otu.a(paramotu).isPlaying()) {
        continue;
      }
      if (otu.a(paramotu))
      {
        int i = otu.a(paramotu).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = otu.a(paramotu).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < otu.a(paramotu)) || (j > otu.b(paramotu)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + otu.a(paramotu) + " mVideoInnerLayout.getTop = " + otu.a(paramotu).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + otu.a(paramotu).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(otu.a(paramotu), 3);
          otu.a(paramotu, true);
          return;
        }
      }
      a(otu.a(paramotu));
      try
      {
        otu.a(paramotu).start();
        otu.b(paramotu, otu.a(paramotu).getDuration());
        otu.e(paramotu, true);
        Message localMessage = this.jdField_a_of_type_Otr.obtainMessage();
        localMessage.obj = otu.a(paramotu);
        localMessage.what = 4;
        this.jdField_a_of_type_Otr.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + otu.a(paramotu));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(otu.a(paramotu));
          a(otu.a(paramotu), 5);
          ReportController.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + otu.a(paramotu));
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
      localObject = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
  
  private void c(otu paramotu)
  {
    if (otu.c(paramotu) == 1)
    {
      otu.a(paramotu).seekTo(0);
      a(otu.a(paramotu), 2);
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
          a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(otu paramotu)
  {
    a(otu.a(paramotu), 5);
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
      paramJSONObject = otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
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
    this.jdField_a_of_type_Otr = new otr(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new otg(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Otr.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      a(otu.a((otu)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
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
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131366726));
    if (((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131368147) == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mRuntime.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131368147);
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(new oth(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */