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
import ova;
import ovb;
import ovc;
import ovd;
import ove;
import ovf;
import ovg;
import ovh;
import ovj;
import ovk;
import ovl;
import ovm;
import ovn;
import ovo;

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
  private ovl jdField_a_of_type_Ovl;
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
        a(ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)));
        FrameLayout localFrameLayout = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
        ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
        a((String)localObject, 2);
        ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).stop();
        ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).release();
        this.jdField_a_of_type_Ovl.removeCallbacksAndMessages(null);
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
    a(ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)));
    Object localObject = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
    ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
    a(paramString, 2);
    ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).stop();
    ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).release();
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_Ovl.removeMessages(2, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(1, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(3, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(4, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(5, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(6, paramString);
    this.jdField_a_of_type_Ovl.removeMessages(7, paramString);
    return 0;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    ovo localovo = a(paramJSONObject);
    if (localovo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video json 参数错误 jsonObject = " + paramJSONObject);
      }
      return -1;
    }
    if (TextUtils.isEmpty(ovo.a(localovo)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mPlayerID = null");
      }
      return -1;
    }
    if ((TextUtils.isEmpty(ovo.b(localovo))) && (TextUtils.isEmpty(ovo.c(localovo))))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "pin Video mVid = null && mVideoPath = null");
      }
      return -1;
    }
    if (!TextUtils.isEmpty(ovo.c(localovo))) {
      paramJSONObject = ovo.c(localovo);
    }
    for (int i = 1; (ovo.c(localovo) == 0.0D) || (ovo.d(localovo) == 0.0D); i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeVideoPlugin", 1, "width or height error");
      }
      return -1;
      paramJSONObject = ovo.b(localovo);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(ovo.a(localovo)))
    {
      if (!ovo.c((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(ovo.a(localovo))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is preparing");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 1, "mVideoPlayerManager already contain playerID, the same player is prepared, so pluck it");
      }
      a(ovo.a(localovo));
    }
    IVideoViewBase localIVideoViewBase = a();
    if (localIVideoViewBase == null) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new ovj(this, bool), 5, null, true);
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
      this.jdField_b_of_type_Int = ovo.a(localovo);
      if (ovo.a(localovo) == 1) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoPlugin", 2, "efficient pinview playmode playMode = " + ovo.a(localovo) + " mPlayMode = " + this.jdField_b_of_type_Int);
      }
      localTVK_IMediaPlayer = a(localIVideoViewBase, paramJSONObject, i, localovo);
      ovo.a(localovo, localTVK_IMediaPlayer);
      if (ovo.b(localovo) != 2) {
        break label602;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      label438:
      a(paramJSONObject, localTVK_IMediaPlayer, localovo);
      a(localIVideoViewBase, paramJSONObject, localovo);
      if (ovo.b(localovo) == 2) {
        this.mRuntime.a().setOnTouchListener(new ovn(this, ovo.a(localovo)));
      }
      this.jdField_a_of_type_JavaUtilQueue.add(ovo.a(localovo));
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
            QLog.d("TribeVideoPlugin", 2, "inefficient pinview playmode playMode = " + ovo.a(localovo) + " mPlayMode = " + this.jdField_b_of_type_Int);
            break;
            label602:
            if (ovo.b(localovo) == 1)
            {
              paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969702, null);
              break label438;
            }
            if (ovo.b(localovo) != 0) {
              break label726;
            }
            paramJSONObject = (FrameLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969703, null);
            break label438;
          }
        }
      }
      ovo.a(localovo, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(ovo.a(localovo), localovo);
      this.jdField_a_of_type_Boolean = false;
      paramJSONObject = this.jdField_a_of_type_Ovl.obtainMessage();
      paramJSONObject.obj = ovo.a(localovo);
      paramJSONObject.what = 3;
      this.jdField_a_of_type_Ovl.sendMessageDelayed(paramJSONObject, 10000L);
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
      paramJSONObject1 = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject1));
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
  
  private int a(ovo paramovo, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 1) && (ovo.a(paramovo)))
    {
      int j = ovo.a(paramovo).getTop();
      int k = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      int m = ovo.a(paramovo).getBottom();
      int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
      if ((j - k < ovo.a(paramovo)) || (m - n > ovo.b(paramovo)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoPlugin", 2, "realHandlePlayControl returned due to started not in show area videoWrapper.mPlayerID = " + ovo.a(paramovo));
        }
        paramInt2 = -1;
      }
    }
    do
    {
      return paramInt2;
      FrameLayout localFrameLayout = ovo.a(paramovo);
      if (paramInt2 == 1) {
        localFrameLayout.setVisibility(0);
      }
      while (paramInt1 == 1)
      {
        if (ovo.a(paramovo).isPauseing()) {
          a(ovo.a(paramovo), 1);
        }
        ovo.b(paramovo, false);
        ovo.a(paramovo).start();
        return 0;
        if (paramInt2 == 0) {
          localFrameLayout.setVisibility(4);
        }
      }
      paramInt2 = i;
    } while (paramInt1 != 0);
    a(ovo.a(paramovo), 3);
    ovo.b(paramovo, true);
    ovo.a(paramovo).pause();
    this.jdField_a_of_type_Ovl.removeMessages(3, ovo.a(paramovo));
    return 0;
  }
  
  private VideoLayout a(IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout, ovo paramovo)
  {
    VideoLayout localVideoLayout = new VideoLayout(this.jdField_a_of_type_AndroidContentContext);
    localVideoLayout.addView((View)paramIVideoViewBase);
    ((View)paramIVideoViewBase).setTag("VideoViewTAG");
    if (paramFrameLayout != null) {
      localVideoLayout.addView(paramFrameLayout);
    }
    localVideoLayout.setBackgroundColor(-16777216);
    if (ovo.f(paramovo) == 1) {
      localVideoLayout.setOnTouchListener(new ovg(this));
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramIVideoViewBase = new FrameLayout.LayoutParams((int)(ovo.c(paramovo) * f), (int)(ovo.d(paramovo) * f));
    paramIVideoViewBase.topMargin = ((int)(ovo.e(paramovo) * f));
    paramIVideoViewBase.leftMargin = ((int)(ovo.f(paramovo) * f));
    ovo.e(paramovo, ovo.a(paramovo) * f);
    ovo.f(paramovo, this.c - ovo.b(paramovo) * f);
    if (ovo.g(paramovo) > 0) {
      localVideoLayout.setRoundCorner((int)(ovo.g(paramovo) * f));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localVideoLayout, paramIVideoViewBase);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "sDensity:" + f);
    }
    ovo.a(paramovo, localVideoLayout);
    return localVideoLayout;
  }
  
  private TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase, String paramString, int paramInt, ovo paramovo)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramIVideoViewBase);
    paramIVideoViewBase.setXYaxis(2);
    if (ovo.c(paramovo) == 0) {
      paramIVideoViewBase.setLoopback(true);
    }
    a(paramIVideoViewBase, paramovo);
    a(ovo.d(paramovo), paramString, paramInt, paramIVideoViewBase, paramovo);
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
      ThreadManager.post(new ovh(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ((IVideoViewBase)localObject).addViewCallBack(new ovf(this));
    return localObject;
  }
  
  private ovm a(FrameLayout paramFrameLayout, TVK_IMediaPlayer paramTVK_IMediaPlayer, ovo paramovo)
  {
    if ((ovo.b(paramovo) != 2) && (ovo.b(paramovo) != 1) && (ovo.b(paramovo) != 0)) {
      return null;
    }
    ovm localovm = new ovm(null);
    ovm.a(localovm, ovo.b(paramovo));
    if (ovo.b(paramovo) == 2)
    {
      if (ovo.e(paramovo) != 0) {
        break label162;
      }
      paramTVK_IMediaPlayer.setOutputMute(false);
    }
    for (;;)
    {
      a(paramovo);
      ovm.a(localovm).setVisibility(8);
      ovo.a(paramovo, localovm);
      return localovm;
      if (ovo.b(paramovo) == 1)
      {
        ovm.a(localovm, (ProgressBar)paramFrameLayout.findViewById(2131367535));
        ovm.b(localovm, (ProgressBar)paramFrameLayout.findViewById(2131367536));
        break;
      }
      if (ovo.b(paramovo) != 0) {
        break;
      }
      ovm.a(localovm, (ProgressBar)paramFrameLayout.findViewById(2131367537));
      break;
      label162:
      if (ovo.e(paramovo) == 1) {
        paramTVK_IMediaPlayer.setOutputMute(true);
      }
    }
  }
  
  private ovo a(JSONObject paramJSONObject)
  {
    ovo localovo = new ovo(null);
    try
    {
      ovo.a(localovo, paramJSONObject.optString("vid"));
      ovo.b(localovo, paramJSONObject.optString("videoPath"));
      ovo.c(localovo, paramJSONObject.optString("playerID"));
      ovo.a(localovo, paramJSONObject.optDouble("top", 0.0D));
      ovo.b(localovo, paramJSONObject.optDouble("left", 0.0D));
      ovo.c(localovo, paramJSONObject.optDouble("width", 0.0D));
      ovo.d(localovo, paramJSONObject.optDouble("height", 0.0D));
      ovo.a(localovo, paramJSONObject.optInt("time", 0));
      ovo.b(localovo, paramJSONObject.optInt("needMute", 1));
      ovo.c(localovo, paramJSONObject.optInt("playMode", 0));
      ovo.d(localovo, paramJSONObject.optInt("showUIController", 0));
      if (ovo.b(localovo) == 2) {
        ovo.d(localovo, 0);
      }
      ovo.e(localovo, paramJSONObject.optInt("needCountdown", 1));
      ovo.f(localovo, paramJSONObject.optInt("videoTouchIntercept", 0));
      ovo.g(localovo, paramJSONObject.optInt("repeatType", 0));
      int i = paramJSONObject.optInt("needCheckShowArea", 0);
      if (i == 1) {
        ovo.c(localovo, true);
      }
      for (;;)
      {
        ovo.e(localovo, paramJSONObject.optDouble("showAreaTop", 0.0D));
        ovo.f(localovo, paramJSONObject.optDouble("showAreaBottom", 0.0D));
        ovo.h(localovo, paramJSONObject.optInt("roundCorner", 0));
        return localovo;
        if (i == 0) {
          ovo.c(localovo, false);
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
      localObject = (ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (ovo.a((ovo)localObject))
      {
        int i = ovo.a((ovo)localObject).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = ovo.a((ovo)localObject).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < ovo.a((ovo)localObject)) || (j > ovo.b((ovo)localObject)))
        {
          if (ovo.a((ovo)localObject).isPlaying())
          {
            ovo.a((ovo)localObject).pause();
            ovo.a((ovo)localObject).setVisibility(8);
            ovo.a((ovo)localObject, true);
            a(ovo.a((ovo)localObject), 3);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "handleCheckPlayerShowArea not in show area videoWrapper.mPlayerID = " + ovo.a((ovo)localObject) + " mVideoInnerLayout.getTop = " + ovo.a((ovo)localObject).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + ovo.a((ovo)localObject).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
            }
          }
        }
        else if (ovo.b((ovo)localObject))
        {
          ovo.b((ovo)localObject, false);
          ovo.a((ovo)localObject).start();
          ovo.a((ovo)localObject).setVisibility(0);
          ovo.a((ovo)localObject, false);
          if ((ovo.a((ovo)localObject) == 0) && (!this.jdField_b_of_type_Boolean))
          {
            Message localMessage = this.jdField_a_of_type_Ovl.obtainMessage();
            localMessage.obj = ovo.a((ovo)localObject);
            localMessage.what = 4;
            this.jdField_a_of_type_Ovl.sendMessageDelayed(localMessage, 200L);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea delay start playerID = " + ovo.a((ovo)localObject));
            }
          }
          else
          {
            a(ovo.a((ovo)localObject), 1);
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 1, "handleCheckPlayerShowArea start playerID = " + ovo.a((ovo)localObject));
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, TVK_IMediaPlayer paramTVK_IMediaPlayer, ovo paramovo)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setLoginCookie("");
    localTVK_UserInfo.setUin(this.mRuntime.a().getCurrentAccountUin());
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    if (!TextUtils.isEmpty(ovo.b(paramovo)))
    {
      localTVK_PlayerVideoInfo.setVid(ovo.b(paramovo));
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
  
  private void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, ovo paramovo)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new ovc(this, paramovo));
    paramTVK_IMediaPlayer.setOnCompletionListener(new ovd(this, paramovo));
    paramTVK_IMediaPlayer.setOnErrorListener(new ove(this, paramovo));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      paramString = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if (paramString != null) {
        ovm.a(paramString).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "reportPlayerStatus playerID = " + paramString + " type = " + paramInt);
    }
    ovo localovo = (ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localovo == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("playerID", paramString);
      localJSONObject.put("state", paramInt);
      if (paramInt != 5)
      {
        localJSONObject.put("currentPosition", ovo.a(localovo).getCurrentPostion());
        localJSONObject.put("duration", ovo.a(localovo).getDuration());
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
      localObject = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      paramString = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
      if ((paramString != null) && (localObject != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoPlugin", 2, "setPlayerControllerStatus player = " + paramString + " videoInnerLayoutTemp = " + localObject);
    return;
    SeekBar localSeekBar = (SeekBar)((FrameLayout)localObject).findViewById(2131364679);
    TextView localTextView1 = (TextView)((FrameLayout)localObject).findViewById(2131362354);
    TextView localTextView2 = (TextView)((FrameLayout)localObject).findViewById(2131362353);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject).findViewById(2131362355);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject).findViewById(2131362351);
    TextView localTextView3 = (TextView)((FrameLayout)localObject).findViewById(2131362352);
    Object localObject = (ImageView)((FrameLayout)localObject).findViewById(2131367503);
    if (paramBoolean)
    {
      if (paramString.isPlaying())
      {
        i = 2130845010;
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
      i = 2130845291;
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
  
  private void a(ovo paramovo)
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new ovk(this, ovo.a(paramovo)), 0L, 30L);
    ovo.a(paramovo, localTimer);
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
  
  private void b(ovo paramovo)
  {
    ovo.d(paramovo, true);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "first onVideoPrepared mPlayerID=" + ovo.a(paramovo) + " mIsPaused=" + ovo.d(paramovo) + " isPlaying=" + ovo.a(paramovo).isPlaying());
    }
    if (ovo.d(paramovo)) {}
    for (;;)
    {
      return;
      if (ovo.a(paramovo).isPlaying()) {
        continue;
      }
      if (ovo.a(paramovo))
      {
        int i = ovo.a(paramovo).getTop() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        int j = ovo.a(paramovo).getBottom() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY();
        if ((i < ovo.a(paramovo)) || (j > ovo.b(paramovo)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TribeVideoPlugin", 2, "onVideoPrepared returned due to prepared not in show area videoWrapper.mPlayerID = " + ovo.a(paramovo) + " mVideoInnerLayout.getTop = " + ovo.a(paramovo).getTop() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " top = " + i + " mVideoInnerLayout.getBottom = " + ovo.a(paramovo).getBottom() + " getScrollY() = " + this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() + " bottom = " + j);
          }
          a(ovo.a(paramovo), 3);
          ovo.a(paramovo, true);
          return;
        }
      }
      a(ovo.a(paramovo));
      try
      {
        ovo.a(paramovo).start();
        ovo.b(paramovo, ovo.a(paramovo).getDuration());
        ovo.e(paramovo, true);
        Message localMessage = this.jdField_a_of_type_Ovl.obtainMessage();
        localMessage.obj = ovo.a(paramovo);
        localMessage.what = 4;
        this.jdField_a_of_type_Ovl.sendMessageDelayed(localMessage, 200L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TribeVideoPlugin", 2, "onVideoPrepared really start videoWrapper.mPlayerID = " + ovo.a(paramovo));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(ovo.a(paramovo));
          a(ovo.a(paramovo), 5);
          ReportController.b(null, "dc00899", "BizTechReport", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getCurrentAccountUin(), "tribe_video", "play", 0, 0, Integer.toString(2), Integer.toString(NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)), "", "");
          QLog.e("TribeVideoPlugin", 2, "onVideoPrepared start exception videoWrapper.mPlayerID = " + ovo.a(paramovo));
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
      localObject = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(paramJSONObject));
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
  
  private void c(ovo paramovo)
  {
    if (ovo.c(paramovo) == 1)
    {
      ovo.a(paramovo).seekTo(0);
      a(ovo.a(paramovo), 2);
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
          a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
        }
        return 0;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TribeVideoPlugin", 2, "handlePlayControl no such playID playerID = " + str);
    return -1;
    return a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(str), i, j);
  }
  
  private void d(ovo paramovo)
  {
    a(ovo.a(paramovo), 5);
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
      paramJSONObject = ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
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
    this.jdField_a_of_type_Ovl = new ovl(this);
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new ova(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Ovl.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(str)).stop();
      ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(str)).release();
      a(ovo.a((ovo)this.jdField_a_of_type_JavaUtilHashMap.get(str)));
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
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131366769));
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(new ovb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin
 * JD-Core Version:    0.7.0.1
 */