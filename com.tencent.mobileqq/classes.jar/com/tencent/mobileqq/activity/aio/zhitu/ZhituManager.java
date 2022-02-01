package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate.ReqBody;

public class ZhituManager
  implements Handler.Callback, ZhituTextManager.ImgGenerateCallback, Manager
{
  private static volatile boolean K = false;
  private static volatile boolean L = false;
  private static int f;
  private boolean A;
  private boolean B = true;
  private boolean C = false;
  private boolean D = false;
  private AppInterface E;
  private final int F = 180;
  private boolean G = false;
  private boolean H = false;
  private long I = 0L;
  private int J = 180;
  private ZhituManager.ZhituSendListener M;
  private Handler N = new ZhituManager.5(this, Looper.getMainLooper());
  public LinearLayout a;
  public ZhituEmotionHorizonListView b;
  public ZhituPanelView c;
  public ZhituPicAdapter d;
  public ZhituPanelView.ZhituPanelAdapter e;
  private ZhituObserver g;
  private Map<String, String> h = new HashMap();
  private Map<String, String> i = new HashMap();
  private BlockingDeque<ZhituReportData> j = new LinkedBlockingDeque();
  private String k = "";
  private int l;
  private volatile String m = "";
  private boolean n = false;
  private Typeface o;
  private volatile int p = 0;
  private Map<String, ZhituResponse> q = new HashMap();
  private HandlerThread r;
  private Handler s;
  private Executor t;
  private List<HttpNetReq> u = new LinkedList();
  private ZhituManager.DownloadListener v;
  private Map<File, Boolean> w;
  private int x = 0;
  private int y = 0;
  private List<String> z = new LinkedList();
  
  public ZhituManager(AppInterface paramAppInterface)
  {
    this.E = paramAppInterface;
    A();
  }
  
  private void A()
  {
    this.B = SharedPreUtils.bA(this.E.getApp(), this.E.getCurrentAccountUin());
    this.A = SharedPreUtils.bo(this.E.getApp(), this.E.getCurrentAccountUin());
    this.l = SharedPreUtils.bB(this.E.getApp(), this.E.getCurrentAccountUin());
    this.G = SharedPreUtils.bC(this.E.getApp(), this.E.getCurrentAccountUin());
    this.H = SharedPreUtils.bD(this.E.getApp(), this.E.getCurrentAccountUin());
    this.I = SharedPreUtils.bE(this.E.getApp(), this.E.getCurrentAccountUin());
    this.J = SharedPreUtils.bF(this.E.getApp(), this.E.getCurrentAccountUin());
    this.C = true;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (paramInt != 7220) {
            return 4;
          }
          return 5;
        }
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  @Nullable
  static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a(localOutOfMemoryError);
    }
    return null;
  }
  
  @Nullable
  private Rect a(String paramString, ZhituImgResponse paramZhituImgResponse)
  {
    Object localObject = new Rect();
    String[] arrayOfString = paramZhituImgResponse.coord.split("\\|");
    try
    {
      ((Rect)localObject).left = Integer.parseInt(arrayOfString[0]);
      ((Rect)localObject).top = Integer.parseInt(arrayOfString[1]);
      ((Rect)localObject).right = (((Rect)localObject).left + Integer.parseInt(arrayOfString[2]));
      ((Rect)localObject).bottom = (((Rect)localObject).top + Integer.parseInt(arrayOfString[3]));
      return localObject;
    }
    catch (Exception localException)
    {
      label75:
      break label75;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown rect format: ");
    ((StringBuilder)localObject).append(paramZhituImgResponse.coord);
    QLog.d("ZhituManager", 1, a(paramString, "startImgGenerate", ((StringBuilder)localObject).toString()));
    return null;
  }
  
  static AbstractGifImage a(String paramString)
  {
    paramString = GlobalImageCache.a.get(paramString);
    if ((paramString instanceof Pair)) {
      return (AbstractGifImage)((Pair)paramString).first;
    }
    return null;
  }
  
  public static ZhituManager a(AppInterface paramAppInterface)
  {
    return (ZhituManager)paramAppInterface.getManager(QQManagerFactory.ZHITU_MANAGER);
  }
  
  private File a(File paramFile, ZhituImgResponse paramZhituImgResponse)
  {
    return new File(paramFile, a(paramZhituImgResponse));
  }
  
  @NonNull
  private String a(ZhituImgResponse paramZhituImgResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.securitysdk.utils.MD5.b(paramZhituImgResponse.url));
    localStringBuilder.append("_");
    localStringBuilder.append(paramZhituImgResponse.md5);
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString3);
    return a(paramString1, paramString2, localStringBuilder.toString());
  }
  
  static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("[%s][%s]: %s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private void a(int paramInt1, ZhituResponse paramZhituResponse, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error code: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramZhituResponse);
      localStringBuilder.append(" startIdx: ");
      localStringBuilder.append(paramInt2);
      QLog.d("ZhituManager", 2, a(paramString1, "onResponse", localStringBuilder.toString()));
    }
    if (paramInt1 != 0) {
      return;
    }
    a(paramString1, paramZhituResponse);
    a(paramZhituResponse, paramString1, paramInt2, paramString2);
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (!paramString1.equals(d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ZhituPicData localZhituPicData = new ZhituPicData();
    localZhituPicData.i = new BitmapDrawable(this.E.getApp().getResources(), paramBitmap2);
    if (paramBitmap1 != null) {
      paramBitmap1 = new BitmapDrawable(this.E.getApp().getResources(), paramBitmap1);
    } else {
      paramBitmap1 = null;
    }
    localZhituPicData.j = paramBitmap1;
    boolean bool = false;
    localZhituPicData.k = false;
    if (paramInt == 0) {
      bool = true;
    }
    localZhituPicData.p = bool;
    localZhituPicData.q = paramBoolean;
    a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, localZhituPicData);
    j(localZhituPicData);
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ReqUniqueKey");
    if (!d().equals(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "reqKey is outdated, skip."));
      }
      return;
    }
    int i1 = paramBundle.getInt("RetryCount", 0);
    int i2 = paramBundle.getInt("IdxInRes");
    str1 = paramBundle.getString("ReqUniqueKey");
    if (i1 >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "max retry limitation is reached."));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current retry count is ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", ((StringBuilder)localObject).toString()));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "retry img download"));
    }
    paramBundle.putInt("RetryCount", i1 + 1);
    Object localObject = (ZhituResponse)paramBundle.getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)paramBundle.getParcelable("ImgResponse");
    String str2 = paramBundle.getString("QueryText");
    paramBundle.remove("ErrorCode");
    a((ZhituResponse)localObject, str1, this.E, i2, localZhituImgResponse, str2, paramBundle);
  }
  
  private void a(Message paramMessage)
  {
    Object localObject = (Bundle)paramMessage.obj;
    paramMessage = ((Bundle)localObject).getString("ReqUniqueKey");
    if (!d().equals(paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "reqKey is outdated, skip."));
      }
      return;
    }
    ZhituResponse localZhituResponse = (ZhituResponse)((Bundle)localObject).getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)((Bundle)localObject).getParcelable("ImgResponse");
    int i2 = ((Bundle)localObject).getInt("IdxInRes");
    localObject = ((Bundle)localObject).getString("QueryText");
    if ((localZhituResponse != null) && (localZhituImgResponse != null))
    {
      int i3 = e(localZhituImgResponse.style);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("style is ");
        localStringBuilder.append(i3);
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", i2, localStringBuilder.toString()));
      }
      int i4 = f();
      int i1 = 1;
      if (i4 != 1) {
        i1 = 0;
      }
      if (i3 != 2)
      {
        this.t.execute(new ZhituManager.6(this, paramMessage, i2, localZhituResponse, localZhituImgResponse, i3, (String)localObject));
        return;
      }
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("zhitutest handleImgDownloadSucc key = ");
          localStringBuilder.append(paramMessage);
          localStringBuilder.append(" |idxinRes = ");
          localStringBuilder.append(i2);
          localStringBuilder.append(" | originQueryText = ");
          localStringBuilder.append((String)localObject);
          QLog.d("ZhituManager", 2, localStringBuilder.toString());
        }
        if (a(paramMessage, localZhituImgResponse) != null)
        {
          this.t.execute(new ZhituManager.7(this, paramMessage, i2, localZhituResponse, localZhituImgResponse, i3, (String)localObject));
          return;
        }
        a(paramMessage, i2, localZhituImgResponse);
        return;
      }
      a(paramMessage, i2, localZhituImgResponse);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "originResponse or originImgResponse is null, skip."));
    }
  }
  
  private void a(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ZhituManager.3(this));
    b(paramMessageQueue);
  }
  
  private void a(AbstractGifImage paramAbstractGifImage, ZhituTextManager.DrawTextParam paramDrawTextParam, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!paramString3.equals(d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString3, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ZhituPicData localZhituPicData = new ZhituPicData();
    localZhituPicData.d = paramDrawTextParam;
    boolean bool = true;
    localZhituPicData.k = true;
    localZhituPicData.c = paramString1;
    localZhituPicData.b = paramString2;
    localZhituPicData.e = true;
    if (paramInt != 0) {
      bool = false;
    }
    localZhituPicData.p = bool;
    a(paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, localZhituPicData);
    paramDrawTextParam = f(localZhituPicData);
    a(paramDrawTextParam, paramAbstractGifImage);
    paramAbstractGifImage = this.s;
    if (paramAbstractGifImage != null) {
      paramAbstractGifImage.post(new ZhituManager.8(this, paramDrawTextParam));
    }
    j(localZhituPicData);
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramZhituResponse.list;
    if (localObject == null)
    {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "the list is null"));
      if (paramInt == 0) {
        f(this.E.getApp().getResources().getString(2131918212));
      }
      return;
    }
    this.q.put(paramString1, paramZhituResponse);
    if ((paramInt == 0) && (((List)localObject).isEmpty()))
    {
      f(this.E.getApp().getResources().getString(2131918212));
      return;
    }
    int i1 = Math.min(((List)localObject).size(), paramInt + y());
    if (!a(paramZhituResponse, (List)localObject, paramInt, i1, paramString1, paramString2))
    {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "fail to start download"));
      return;
    }
    localObject = this.N.obtainMessage(6);
    ((Message)localObject).arg1 = (i1 - paramInt);
    if (paramInt == 0) {
      ((Message)localObject).arg1 += 1;
    }
    ((Message)localObject).arg2 = paramZhituResponse.hasMore;
    ((Message)localObject).obj = paramString1;
    this.N.sendMessage((Message)localObject);
    if (paramInt == 0) {
      this.t.execute(new ZhituManager.9(this, paramZhituResponse, paramString1, i1, paramString2));
    }
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, AppInterface paramAppInterface, int paramInt, ZhituImgResponse paramZhituImgResponse, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("ZhituRespose", paramZhituResponse);
    localBundle.putParcelable("ImgResponse", paramZhituImgResponse);
    localBundle.putString("ReqUniqueKey", paramString1);
    localBundle.putInt("IdxInRes", paramInt);
    localBundle.putString("QueryText", paramString2);
    localBundle.putLong("StartTs", System.currentTimeMillis());
    paramZhituResponse = b(paramZhituImgResponse);
    boolean bool = paramZhituResponse.exists();
    int i1 = 1;
    if (bool)
    {
      g(paramZhituResponse.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "md5 matched, the origin img is downloaded and just skip download."));
      }
      if (this.y != 2)
      {
        bool = paramZhituResponse.setLastModified(System.currentTimeMillis());
        if ((this.y == 0) && (QLog.isColorLevel()))
        {
          paramZhituResponse = new StringBuilder();
          paramZhituResponse.append("set last modified time is supported? ");
          paramZhituResponse.append(bool);
          QLog.d("ZhituManager", 2, paramZhituResponse.toString());
        }
        if (bool) {
          paramInt = i1;
        } else {
          paramInt = 2;
        }
        this.y = paramInt;
      }
      paramZhituResponse = this.s.obtainMessage(3);
      paramZhituResponse.obj = localBundle;
      this.s.sendMessage(paramZhituResponse);
      return;
    }
    if (this.v == null) {
      this.v = new ZhituManager.DownloadListener(this.s);
    }
    paramZhituImgResponse = paramZhituImgResponse.url;
    paramAppInterface = (IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    paramString2 = new HttpNetReq();
    paramString2.mNeedIpConnect = true;
    paramString2.mNeedNotReferer = true;
    paramString2.mCallback = this.v;
    paramString2.mHttpMethod = 0;
    paramString2.mReqUrl = paramZhituImgResponse;
    paramString2.mOutPath = paramZhituResponse.getAbsolutePath();
    paramString2.mPrioty = 0;
    paramString2.setUserData(localBundle);
    if (QLog.isColorLevel())
    {
      paramZhituResponse = new StringBuilder();
      paramZhituResponse.append("start send img download request, ");
      paramZhituResponse.append(paramZhituImgResponse);
      QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, paramZhituResponse.toString()));
    }
    this.u.add(paramString2);
    paramAppInterface.sendReq(paramString2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, ZhituRequest paramZhituRequest, int paramInt, Handler paramHandler)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), ZhituServlet.class);
    String str = JSONUtils.a(paramZhituRequest).toString();
    localNewIntent.putExtra("ZhituCMD", "AIMessage.Text2Image");
    localNewIntent.putExtra("ZhituRequestBytes", str.getBytes());
    a(localNewIntent, paramHandler);
    localNewIntent.putExtra("ZhituReqKey", paramString);
    localNewIntent.putExtra("StartIdx", paramInt);
    localNewIntent.putExtra("QueryText", paramZhituRequest.text);
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      paramHandler = new StringBuilder();
      paramHandler.append("send request: ");
      paramHandler.append(paramZhituRequest);
      QLog.d("ZhituManager", 2, a(paramString, "realSendZhituRequest", paramHandler.toString()));
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800ADCB", "0X800ADCB", 0, 0, "", "", paramZhituRequest.text, "");
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (this.w == null) {
        this.w = new HashMap();
      }
      if (!this.w.containsKey(paramFile))
      {
        File localFile = new File(paramFile, ".nomedia");
        if ((!localFile.exists()) && (localFile.createNewFile())) {
          this.w.put(paramFile, Boolean.valueOf(true));
        }
      }
      return;
    }
    finally {}
  }
  
  static void a(OutOfMemoryError paramOutOfMemoryError)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituCreateBitmapCatchedExceptionOOM when create bitmap with count: ");
    localStringBuilder.append(f);
    CaughtExceptionReport.a(paramOutOfMemoryError, localStringBuilder.toString());
    paramOutOfMemoryError = new StringBuilder();
    paramOutOfMemoryError.append("create bitmap but oom, ");
    paramOutOfMemoryError.append(f);
    QLog.d("ZhituManager", 1, paramOutOfMemoryError.toString());
  }
  
  private void a(String paramString, int paramInt, ZhituImgResponse paramZhituImgResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "passThroughOriginImg", paramInt, "start"));
    }
    String str = paramZhituImgResponse.url;
    if (".gif".equalsIgnoreCase(str.substring(str.lastIndexOf(".")))) {}
    try
    {
      str = b(paramZhituImgResponse).getAbsolutePath();
      a(new NativeGifImage(new File(str), false), null, str, str, paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
      return;
    }
    catch (IOException paramZhituImgResponse)
    {
      label110:
      break label110;
    }
    QLog.e("ZhituManager", 1, a(paramString, "passThroughOriginImg", "convert to gif drawable fail"));
    return;
    a(null, BitmapFactory.decodeFile(b(paramZhituImgResponse).getAbsolutePath()), paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
  }
  
  /* Error */
  private void a(String paramString1, int paramInt1, ZhituResponse paramZhituResponse, ZhituImgResponse paramZhituImgResponse, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 11
    //   3: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +22 -> 28
    //   9: ldc_w 260
    //   12: iconst_2
    //   13: aload 11
    //   15: ldc_w 262
    //   18: iload_2
    //   19: ldc_w 830
    //   22: invokestatic 475	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: getstatic 817	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:f	I
    //   31: iconst_1
    //   32: iadd
    //   33: putstatic 817	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:f	I
    //   36: aload 4
    //   38: getfield 316	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   41: astore 12
    //   43: aload 12
    //   45: aload 12
    //   47: ldc_w 834
    //   50: invokevirtual 837	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   53: invokevirtual 840	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: astore 14
    //   58: aload_0
    //   59: aload 11
    //   61: aload 4
    //   63: invokespecial 499	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse;)Landroid/graphics/Rect;
    //   66: astore 13
    //   68: aload 13
    //   70: ifnonnull +4 -> 74
    //   73: return
    //   74: aload_0
    //   75: aload 4
    //   77: invokespecial 654	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:b	(Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse;)Ljava/io/File;
    //   80: invokevirtual 660	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: astore 12
    //   85: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   88: lstore 9
    //   90: ldc_w 832
    //   93: aload 14
    //   95: invokevirtual 844	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   98: ifeq +525 -> 623
    //   101: aload_0
    //   102: invokevirtual 478	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:f	()I
    //   105: istore 7
    //   107: iload 7
    //   109: iconst_1
    //   110: if_icmpne +9 -> 119
    //   113: iconst_1
    //   114: istore 7
    //   116: goto +6 -> 122
    //   119: iconst_0
    //   120: istore 7
    //   122: iload_2
    //   123: ifeq +121 -> 244
    //   126: iload 7
    //   128: ifeq +6 -> 134
    //   131: goto +113 -> 244
    //   134: new 846	com/tencent/image/NativeGifImage
    //   137: dup
    //   138: new 306	java/io/File
    //   141: dup
    //   142: aload 12
    //   144: invokespecial 848	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: iconst_0
    //   148: invokespecial 851	com/tencent/image/NativeGifImage:<init>	(Ljava/io/File;Z)V
    //   151: astore 11
    //   153: invokestatic 873	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   156: astore 14
    //   158: aload 11
    //   160: invokevirtual 876	com/tencent/image/NativeGifImage:getWidth	()I
    //   163: istore 7
    //   165: aload 11
    //   167: invokevirtual 879	com/tencent/image/NativeGifImage:getHeight	()I
    //   170: istore 8
    //   172: aload_3
    //   173: getfield 882	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   176: astore_3
    //   177: aload 4
    //   179: getfield 885	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   182: astore 15
    //   184: aload_0
    //   185: getfield 887	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:o	Landroid/graphics/Typeface;
    //   188: astore 16
    //   190: aload_0
    //   191: aload 11
    //   193: aload 14
    //   195: iload 7
    //   197: iload 8
    //   199: aload 6
    //   201: aload_3
    //   202: aload 15
    //   204: aload 13
    //   206: iload 5
    //   208: aload_1
    //   209: iload_2
    //   210: aload 16
    //   212: invokevirtual 890	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;
    //   215: aload 12
    //   217: aconst_null
    //   218: aload_1
    //   219: iload_2
    //   220: aload 4
    //   222: getfield 316	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   225: aload 4
    //   227: getfield 326	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   230: aload 4
    //   232: getfield 469	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   235: aload 4
    //   237: getfield 854	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   240: invokespecial 856	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Lcom/tencent/image/AbstractGifImage;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   243: return
    //   244: ldc_w 260
    //   247: astore 11
    //   249: new 892	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText
    //   252: dup
    //   253: new 306	java/io/File
    //   256: dup
    //   257: aload 12
    //   259: invokespecial 848	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: iconst_0
    //   263: fconst_0
    //   264: invokespecial 895	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:<init>	(Ljava/io/File;ZF)V
    //   267: astore 14
    //   269: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +79 -> 351
    //   275: new 251	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   282: astore 15
    //   284: aload 15
    //   286: ldc_w 897
    //   289: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 15
    //   295: iload_2
    //   296: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 15
    //   302: ldc_w 350
    //   305: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 15
    //   311: aload 14
    //   313: invokevirtual 898	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   316: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 15
    //   322: ldc_w 350
    //   325: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 15
    //   331: aload 14
    //   333: invokevirtual 899	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:f	()I
    //   336: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 11
    //   342: iconst_2
    //   343: aload 15
    //   345: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: invokestatic 873	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   354: astore 15
    //   356: aload 14
    //   358: invokevirtual 898	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   361: istore 7
    //   363: aload 14
    //   365: invokevirtual 900	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getHeight	()I
    //   368: istore 8
    //   370: aload_3
    //   371: getfield 882	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   374: astore_3
    //   375: aload 4
    //   377: getfield 885	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   380: astore 16
    //   382: aload_0
    //   383: getfield 887	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:o	Landroid/graphics/Typeface;
    //   386: astore 17
    //   388: aload 15
    //   390: iload 7
    //   392: iload 8
    //   394: aload 6
    //   396: aload_3
    //   397: aload 16
    //   399: aload 13
    //   401: iload 5
    //   403: aload_1
    //   404: iload_2
    //   405: aload 17
    //   407: invokevirtual 890	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;
    //   410: astore_3
    //   411: aload 14
    //   413: aload_3
    //   414: invokevirtual 903	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:a	(Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;)V
    //   417: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +385 -> 805
    //   423: new 251	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   430: astore 6
    //   432: aload 6
    //   434: ldc_w 905
    //   437: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 6
    //   443: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   446: lload 9
    //   448: lsub
    //   449: invokestatic 910	java/lang/Long:toString	(J)Ljava/lang/String;
    //   452: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 6
    //   458: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: astore 6
    //   463: aload 11
    //   465: iconst_2
    //   466: aload_1
    //   467: ldc_w 912
    //   470: iload_2
    //   471: aload 6
    //   473: invokestatic 475	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   476: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: goto +3 -> 482
    //   482: aload 4
    //   484: getfield 316	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   487: astore 6
    //   489: aload 4
    //   491: getfield 326	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   494: astore 11
    //   496: aload 4
    //   498: getfield 469	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   501: astore 13
    //   503: aload 4
    //   505: getfield 854	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   508: astore 15
    //   510: ldc_w 260
    //   513: astore 4
    //   515: aload_0
    //   516: aload 14
    //   518: aload_3
    //   519: aload 12
    //   521: aconst_null
    //   522: aload_1
    //   523: iload_2
    //   524: aload 6
    //   526: aload 11
    //   528: aload 13
    //   530: aload 15
    //   532: invokespecial 856	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Lcom/tencent/image/AbstractGifImage;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   535: return
    //   536: astore_3
    //   537: goto +41 -> 578
    //   540: astore_3
    //   541: ldc_w 260
    //   544: astore 4
    //   546: goto +32 -> 578
    //   549: astore_3
    //   550: aload 11
    //   552: astore 4
    //   554: goto +24 -> 578
    //   557: astore_3
    //   558: ldc_w 260
    //   561: astore 4
    //   563: goto +15 -> 578
    //   566: astore_1
    //   567: aload_1
    //   568: invokestatic 211	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/OutOfMemoryError;)V
    //   571: return
    //   572: astore_3
    //   573: ldc_w 260
    //   576: astore 4
    //   578: new 251	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   585: astore 6
    //   587: aload 6
    //   589: ldc_w 914
    //   592: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 6
    //   598: aload_3
    //   599: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 4
    //   605: iconst_1
    //   606: aload_1
    //   607: ldc_w 262
    //   610: iload_2
    //   611: aload 6
    //   613: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 475	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   619: invokestatic 860	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: return
    //   623: aload 12
    //   625: invokestatic 866	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   628: astore 14
    //   630: aload 14
    //   632: ifnonnull +23 -> 655
    //   635: ldc_w 260
    //   638: iconst_1
    //   639: aload 11
    //   641: ldc_w 916
    //   644: iload_2
    //   645: ldc_w 918
    //   648: invokestatic 475	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   651: invokestatic 860	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: return
    //   655: invokestatic 873	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   658: aload 12
    //   660: aload 6
    //   662: aload_3
    //   663: getfield 882	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   666: aload 4
    //   668: getfield 885	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   671: aload 13
    //   673: iload 5
    //   675: aload_1
    //   676: iload_2
    //   677: aload_0
    //   678: getfield 887	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:o	Landroid/graphics/Typeface;
    //   681: invokevirtual 921	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Landroid/graphics/Bitmap;
    //   684: astore_3
    //   685: invokestatic 346	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +57 -> 745
    //   691: new 251	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   698: astore 6
    //   700: aload 6
    //   702: ldc_w 905
    //   705: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 6
    //   711: invokestatic 647	java/lang/System:currentTimeMillis	()J
    //   714: lload 9
    //   716: lsub
    //   717: invokestatic 910	java/lang/Long:toString	(J)Ljava/lang/String;
    //   720: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: ldc_w 260
    //   727: iconst_2
    //   728: aload 11
    //   730: ldc_w 923
    //   733: iload_2
    //   734: aload 6
    //   736: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 475	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   742: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: aload_3
    //   746: ifnonnull +4 -> 750
    //   749: return
    //   750: aload_0
    //   751: aload 14
    //   753: aload_3
    //   754: aload_1
    //   755: iload_2
    //   756: aload 4
    //   758: getfield 316	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   761: aload 4
    //   763: getfield 326	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   766: aload 4
    //   768: getfield 469	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   771: aload 4
    //   773: getfield 854	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   776: iconst_0
    //   777: invokespecial 868	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   780: return
    //   781: ldc_w 260
    //   784: iconst_1
    //   785: ldc_w 925
    //   788: invokestatic 860	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: return
    //   792: astore_1
    //   793: goto -12 -> 781
    //   796: astore_3
    //   797: ldc_w 260
    //   800: astore 4
    //   802: goto -224 -> 578
    //   805: goto -323 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	ZhituManager
    //   0	808	1	paramString1	String
    //   0	808	2	paramInt1	int
    //   0	808	3	paramZhituResponse	ZhituResponse
    //   0	808	4	paramZhituImgResponse	ZhituImgResponse
    //   0	808	5	paramInt2	int
    //   0	808	6	paramString2	String
    //   105	286	7	i1	int
    //   170	223	8	i2	int
    //   88	627	9	l1	long
    //   1	728	11	localObject1	Object
    //   41	618	12	str	String
    //   66	606	13	localObject2	Object
    //   56	696	14	localObject3	Object
    //   182	349	15	localObject4	Object
    //   188	210	16	localObject5	Object
    //   386	20	17	localTypeface	Typeface
    // Exception table:
    //   from	to	target	type
    //   515	535	536	java/io/IOException
    //   463	479	540	java/io/IOException
    //   482	510	540	java/io/IOException
    //   388	463	549	java/io/IOException
    //   190	243	557	java/io/IOException
    //   249	351	557	java/io/IOException
    //   351	388	557	java/io/IOException
    //   101	107	566	java/lang/OutOfMemoryError
    //   134	190	566	java/lang/OutOfMemoryError
    //   190	243	566	java/lang/OutOfMemoryError
    //   249	351	566	java/lang/OutOfMemoryError
    //   351	388	566	java/lang/OutOfMemoryError
    //   388	463	566	java/lang/OutOfMemoryError
    //   463	479	566	java/lang/OutOfMemoryError
    //   482	510	566	java/lang/OutOfMemoryError
    //   515	535	566	java/lang/OutOfMemoryError
    //   101	107	572	java/io/IOException
    //   623	630	792	java/lang/OutOfMemoryError
    //   134	190	796	java/io/IOException
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, ZhituPicData paramZhituPicData)
  {
    paramZhituPicData.f = paramString1;
    paramZhituPicData.g = paramInt;
    paramZhituPicData.a = paramString2;
    paramZhituPicData.h = paramString3;
    paramString1 = new ZhituReportData();
    paramString1.b = paramString3;
    paramString1.c = paramString4;
    paramString1.a = paramString5;
    paramString1.e = g(this.p);
    paramString1.f = e();
    paramZhituPicData.l = paramString1;
  }
  
  private void a(String paramString, AbstractGifImage paramAbstractGifImage)
  {
    paramAbstractGifImage = new Pair(paramAbstractGifImage, Integer.valueOf(paramAbstractGifImage.getByteSize()));
    GlobalImageCache.a.put(paramString, paramAbstractGifImage);
  }
  
  private void a(String paramString, ZhituResponse paramZhituResponse)
  {
    List localList = paramZhituResponse.list;
    if (localList == null)
    {
      QLog.d("ZhituManager", 1, a(paramString, "removeDuplicateImg", "the list is null"));
      return;
    }
    HashSet localHashSet = new HashSet(localList.size());
    ArrayList localArrayList = new ArrayList(localList.size());
    int i1 = 0;
    while (i1 < localList.size())
    {
      if (!localHashSet.add(localList.get(i1)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find duplication res: ");
          localStringBuilder.append(localList.get(i1));
          QLog.e("ZhituManager", 2, a(paramString, "removeDuplicateImg", localStringBuilder.toString()));
        }
      }
      else {
        localArrayList.add(localList.get(i1));
      }
      i1 += 1;
    }
    paramZhituResponse.list = localArrayList;
  }
  
  private void a(List<HttpNetReq> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancel all pending net req: ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (IHttpEngineService)this.E.getRuntimeService(IHttpEngineService.class, "all");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((IHttpEngineService)localObject).cancelReq((HttpNetReq)paramList.next());
    }
  }
  
  private void a(NewIntent paramNewIntent, Handler paramHandler)
  {
    if (this.g == null) {
      this.g = new ZhituObserver(paramHandler);
    }
    paramNewIntent.setObserver(this.g);
  }
  
  private boolean a(ZhituResponse paramZhituResponse, List<ZhituImgResponse> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start / end idx: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ZhituManager", 2, a(paramString1, "startImgDownload", ((StringBuilder)localObject).toString()));
    }
    Object localObject = v();
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QLog.d("ZhituManager", 1, a(paramString1, "startImgDownload", "can not create dir."));
      return false;
    }
    try
    {
      a((File)localObject);
      label116:
      int i1;
      if (paramInt1 == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
      while (paramInt1 < paramInt2)
      {
        localObject = (ZhituImgResponse)paramList.get(paramInt1 + i1);
        a(paramZhituResponse, paramString1, this.E, paramInt1, (ZhituImgResponse)localObject, paramString2, null);
        paramInt1 += 1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      break label116;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = localAppRuntime instanceof QQAppInterface;
    boolean bool3 = false;
    if (bool1) {
      bool1 = a((QQAppInterface)localAppRuntime).i();
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (b(paramMessageForPic))
    {
      bool2 = bool3;
      if (!bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private File b(ZhituImgResponse paramZhituImgResponse)
  {
    return a(v(), paramZhituImgResponse);
  }
  
  private void b(Message paramMessage)
  {
    int i1 = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    if (android.text.TextUtils.isEmpty(paramMessage)) {
      return;
    }
    if (!paramMessage.equals(d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
      }
      return;
    }
    ZhituResponse localZhituResponse = (ZhituResponse)this.q.get(paramMessage);
    if (localZhituResponse != null) {
      a(localZhituResponse, paramMessage, i1, e());
    }
  }
  
  private void b(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ZhituManager.4(this));
  }
  
  private void b(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "generateFullTextZhitu", paramInt, ""));
    }
    Bitmap localBitmap = a(200, 200);
    if (localBitmap == null) {
      return;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    Rect localRect = new Rect(0, 0, 200, 200);
    localCanvas.drawRect(localRect, localPaint);
    paramZhituResponse = ZhituTextManager.a().a(localBitmap, paramString2, paramZhituResponse.tokens, "#000000", localRect, 3, paramString1, paramInt, this.o);
    if (paramZhituResponse == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "generate full text zhitu fail");
      }
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("mario");
    paramString2.append(System.currentTimeMillis());
    a(null, paramZhituResponse, paramString1, paramInt, "http://img.qq.com/zhitu/fulltext.jpg", paramString2.toString(), "WhiteBack", null, true);
  }
  
  public static boolean b(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isZhitu());
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "realSendZhituSafeGateRequest start");
    }
    if (StringUtil.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZhituManager", 1, "realSendZhituSafeGateRequest iCurrentUin is Empty");
      }
      return;
    }
    ZhituSafeGate.ReqBody localReqBody = new ZhituSafeGate.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(paramString));
    localReqBody.uint32_src_term.set(3);
    paramString = new NewIntent(this.E.getApp(), ZhituServlet.class);
    paramString.putExtra("ZhituCMD", "ZhituGate.Check");
    paramString.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
    this.E.startServlet(paramString);
  }
  
  public static void d(boolean paramBoolean)
  {
    if (K == paramBoolean) {
      return;
    }
    try
    {
      K = paramBoolean;
      return;
    }
    finally {}
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 3000) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private int e(String paramString)
  {
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 != 0)
      {
        if (i1 != 1) {
          return 2;
        }
        return 1;
      }
      return 0;
    }
    catch (NumberFormatException paramString)
    {
      label20:
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "img response has invalid style");
    }
    return 2;
  }
  
  private String e(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (paramInt != 7220) {
            return Integer.toString(paramInt);
          }
          return "kandian";
        }
        return "discussion";
      }
      return "troop";
    }
    return "c2c";
  }
  
  public static void e(boolean paramBoolean)
  {
    if (L == paramBoolean) {
      return;
    }
    try
    {
      L = paramBoolean;
      return;
    }
    finally {}
  }
  
  private int f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (paramInt != 7220) {
            return paramInt;
          }
          return 4;
        }
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  private void f(String paramString)
  {
    paramString = this.N.obtainMessage(11, paramString);
    this.N.sendMessage(paramString);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.j.size() == 0) {
      return;
    }
    long l1 = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    while ((!this.j.isEmpty()) && ((localLinkedList.size() <= 100) || (!paramBoolean))) {
      localLinkedList.add(this.j.poll());
    }
    Object localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ZhituReportMsg.ReqBody localReqBody = ((ZhituReportData)((Iterator)localObject).next()).a();
      if (localReqBody != null)
      {
        NewIntent localNewIntent = new NewIntent(this.E.getApp(), ZhituServlet.class);
        localNewIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
        localNewIntent.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
        this.E.startServlet(localNewIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send ");
      ((StringBuilder)localObject).append(localLinkedList.size());
      ((StringBuilder)localObject).append(" reports, take ");
      ((StringBuilder)localObject).append(Long.toString(System.currentTimeMillis() - l1));
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private String g(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (paramInt != 7220) {
            return "tempchat";
          }
          return "kandian";
        }
        return "discuss";
      }
      return "group";
    }
    return "c2c";
  }
  
  private static String g(String paramString)
  {
    localObject1 = "";
    long l1 = System.currentTimeMillis();
    try
    {
      try
      {
        localObject2 = HexUtil.bytes2HexStr(com.tencent.qphone.base.util.MD5.getFileMd5(paramString));
        paramString = (String)localObject2;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject2;
      label32:
      break label32;
    }
    localObject2 = new File(paramString);
    paramString = (String)localObject1;
    if (((File)localObject2).exists()) {}
    try
    {
      paramString = MD5FileUtil.a((File)localObject2);
      if (paramString == null) {
        paramString = "";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("md5:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("ZhituManager", 2, new Object[] { "calcMD5", ((StringBuilder)localObject1).toString() });
    }
    return paramString;
  }
  
  private void i(ZhituPicData paramZhituPicData)
  {
    if (paramZhituPicData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "handleRequestDecodeGif font fail, picData is null.");
      }
      return;
    }
    int i2 = f();
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    String str = f(paramZhituPicData);
    if (a(str) != null)
    {
      j(paramZhituPicData);
      return;
    }
    try
    {
      if ((paramZhituPicData.d != null) && ((paramZhituPicData.p) || (i1 != 0)))
      {
        localObject = new GifImageWithText(new File(paramZhituPicData.c), false, 0.0F);
        ((GifImageWithText)localObject).a(paramZhituPicData.d);
      }
      else
      {
        if (paramZhituPicData.c == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode gif picData.originPath is null: ");
          ((StringBuilder)localObject).append(paramZhituPicData.toString());
          QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new NativeGifImage(new File(paramZhituPicData.c), false);
      }
      a(str, (AbstractGifImage)localObject);
      this.z.add(str);
      j(paramZhituPicData);
      return;
    }
    catch (OutOfMemoryError paramZhituPicData)
    {
      a(paramZhituPicData);
      return;
    }
    catch (IOException paramZhituPicData)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decode gif fail: ");
        ((StringBuilder)localObject).append(paramZhituPicData);
        QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  private void j(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.N.obtainMessage(5, paramZhituPicData);
    this.N.sendMessage(paramZhituPicData);
  }
  
  public static boolean p()
  {
    try
    {
      boolean bool = L;
      return bool;
    }
    finally {}
  }
  
  public static boolean q()
  {
    try
    {
      boolean bool = K;
      return bool;
    }
    finally {}
  }
  
  private File r()
  {
    return new File(s(), "font");
  }
  
  private File s()
  {
    return w();
  }
  
  private void t()
  {
    if (this.s != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
      }
      int i1 = 1;
      while (i1 < 10)
      {
        this.s.removeMessages(i1);
        i1 += 1;
      }
    }
  }
  
  private void u()
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GlobalImageCache.a.remove(str);
    }
    this.z.clear();
  }
  
  private File v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("origin/");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private File w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private File x()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sent/");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private int y()
  {
    return this.l;
  }
  
  private boolean z()
  {
    return this.D;
  }
  
  public int a()
  {
    return this.p;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "requestDownloadMoreImg", paramInt, ""));
    }
    Message localMessage = this.s.obtainMessage(7);
    localMessage.obj = paramString;
    localMessage.arg1 = paramInt;
    this.s.sendMessage(localMessage);
    paramString = this.E;
    if ((paramString instanceof QQAppInterface)) {
      paramString = (QQAppInterface)paramString;
    } else {
      paramString = null;
    }
    ReportController.b(paramString, "dc00898", "", "", "0X8008C73", "0X8008C73", a(this.p), 0, "", "", "", "");
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituSafeGateRequestTime: ");
      localStringBuilder.append(paramLong);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.I = paramLong;
    SharedPreUtils.f(this.E.getApp(), this.E.getCurrentAccountUin(), paramLong);
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, boolean paramBoolean, MqqHandler paramMqqHandler)
  {
    if (paramViewGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : parentView is null.");
      }
      return;
    }
    this.D = paramBoolean;
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131450396);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout != null.");
      }
      this.a = ((LinearLayout)localObject);
      this.b = ((ZhituEmotionHorizonListView)this.a.findViewById(2131450400));
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout == null.");
      }
      this.a = ((LinearLayout)View.inflate(paramContext, 2131624160, null));
      this.b = ((ZhituEmotionHorizonListView)this.a.findViewById(2131450400));
      this.b.setOnScrollStateChangedListener(new ZhituManager.10(this));
      this.b.setTouchListener(new ZhituManager.11(this, paramMqqHandler));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131435809);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramViewGroup.addView(this.a, (ViewGroup.LayoutParams)localObject);
    }
    this.d = ((ZhituPicAdapter)this.b.getAdapter());
    if (this.d == null)
    {
      paramViewGroup = this.E;
      if ((paramViewGroup instanceof QQAppInterface))
      {
        this.d = new ZhituPicAdapter(paramContext, (QQAppInterface)paramViewGroup, paramBaseActivity, paramSessionInfo, paramMqqHandler);
        this.b.setAdapter(this.d);
        this.b.setRecycleListener(this.d);
      }
    }
    this.a.setVisibility(0);
    if (paramMqqHandler != null)
    {
      paramMqqHandler.removeMessages(84);
      paramMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void a(ZhituManager.ZhituSendListener paramZhituSendListener)
  {
    this.M = paramZhituSendListener;
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSend:");
      ((StringBuilder)localObject).append(paramZhituPicData);
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    this.i.put(this.E.getCurrentAccountUin(), e());
    this.h.put(this.E.getCurrentAccountUin(), paramZhituPicData.h);
    Object localObject = paramZhituPicData.l;
    ((ZhituReportData)localObject).d = 1;
    this.j.add(localObject);
    localObject = null;
    AppInterface localAppInterface = this.E;
    if ((localAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localAppInterface;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800ADCD", "0X800ADCD", 0, 0, "", "", paramZhituPicData.h, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest start");
    }
    if (!RichTextChatManager.a(paramQQAppInterface).c(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest isZhituLegalOpen is fales return");
      }
      return;
    }
    long l1 = System.currentTimeMillis() - k();
    if (l1 < l() * 60000L)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("sendZhituSafeGateRequest time is short return time = ");
        paramQQAppInterface.append(l1);
        QLog.d("ZhituManager", 2, paramQQAppInterface.toString());
      }
      return;
    }
    d(paramQQAppInterface.getCurrentUin());
  }
  
  public void a(QQAppInterface paramQQAppInterface, Editable paramEditable, List<ChatMessage> paramList, int paramInt, boolean paramBoolean)
  {
    e(true);
    paramList = paramEditable.toString();
    if (android.text.TextUtils.isEmpty(paramList)) {
      return;
    }
    if (paramList.length() <= 24)
    {
      if (!a(paramEditable)) {
        return;
      }
      paramEditable = this.c;
      if ((paramEditable != null) && (paramEditable.getSendView() != null)) {
        this.c.getSendView().setEnabled(false);
      }
      b();
      t();
      if (this.r == null)
      {
        this.r = ThreadManager.newFreeHandlerThread("ZhituThread", 8);
        this.r.start();
        this.s = new Handler(this.r.getLooper(), this);
        if (Build.VERSION.SDK_INT >= 23) {
          a(this.s.getLooper().getQueue());
        } else {
          this.s.postAtFrontOfQueue(new ZhituManager.1(this));
        }
        paramEditable = new ThreadPoolParams();
        paramEditable.corePoolsize = 1;
        paramEditable.maxPooolSize = 1;
        paramEditable.priority = 8;
        paramEditable.poolThreadName = "ZhituImgGenerateThreadPool";
        this.t = ThreadManager.newFreeThreadPool(paramEditable);
      }
      paramEditable = new StringBuilder();
      paramEditable.append(com.tencent.securitysdk.utils.MD5.b(paramList));
      paramEditable.append("_");
      paramEditable.append(System.currentTimeMillis());
      paramEditable = paramEditable.toString();
      a(paramEditable, paramList);
      paramQQAppInterface = new ZhituManager.2(this, paramInt, paramQQAppInterface, paramEditable, paramList);
      paramQQAppInterface = this.s.obtainMessage(1, paramQQAppInterface);
      paramList = this.s;
      long l1;
      if (paramBoolean) {
        l1 = 500L;
      } else {
        l1 = 0L;
      }
      paramList.sendMessageDelayed(paramQQAppInterface, l1);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramEditable, "pending request", ""));
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, List<String> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "sendZhituRequest", "start sending request"));
    }
    ZhituRequest localZhituRequest = new ZhituRequest();
    localZhituRequest.uin = paramQQAppInterface.getCurrentUin();
    localZhituRequest.os = "android";
    localZhituRequest.text = paramString2;
    localZhituRequest.styles = 3;
    localZhituRequest.chat = e(paramInt1);
    localZhituRequest.version = "8.8.17";
    if (this.h.containsKey(paramQQAppInterface.getCurrentUin()))
    {
      paramString2 = new ZhituReportRequest();
      paramString2.a = paramList;
      paramString2.d = ((String)this.i.get(paramQQAppInterface.getCurrentUin()));
      paramString2.c = ((String)this.h.get(paramQQAppInterface.getCurrentUin()));
      paramString2.b = f(paramInt1);
      localZhituRequest.report = paramString2;
    }
    a(paramQQAppInterface, paramString1, localZhituRequest, 0, this.s);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.k = paramString1;
      this.m = paramString2;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituConfigOpen: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.A = paramBoolean;
    SharedPreUtils.i(this.E.getApp(), this.E.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a(Editable paramEditable)
  {
    String str = paramEditable.toString();
    boolean bool3 = android.text.TextUtils.isEmpty(str);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (com.tencent.mobileqq.text.TextUtils.hasEmoji(str) <= -1) {
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str))
        {
          bool1 = bool2;
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          AtTroopMemberSpan.a(paramEditable, localArrayList);
          bool1 = bool2;
          if (localArrayList.size() <= 0) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramEditable = new StringBuilder();
      paramEditable.append("isLegal: ");
      paramEditable.append(bool1);
      paramEditable.append(" / ");
      paramEditable.append(com.tencent.securitysdk.utils.MD5.b(str));
      QLog.d("ZhituManager", 2, paramEditable.toString());
    }
    return bool1;
  }
  
  public File b(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(paramString).getName());
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    paramString = localStringBuilder.toString();
    return new File(x(), paramString);
  }
  
  public File b(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString2)) {
      return b(paramString2);
    }
    int i1 = paramString1.lastIndexOf("/") + 1;
    int i2 = paramString1.lastIndexOf(".");
    if (i1 < i2) {
      paramString1 = paramString1.substring(i1, i2);
    } else {
      paramString1 = "fakeFileName";
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(System.currentTimeMillis());
    paramString1 = paramString2.toString();
    return new File(x(), paramString1);
  }
  
  public void b()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((ZhituPanelView)localObject).getVisibility() == 0))
    {
      localObject = this.e;
      if (localObject != null) {
        ((ZhituPanelView.ZhituPanelAdapter)localObject).b();
      }
    }
    localObject = this.a;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0))
    {
      this.d = ((ZhituPicAdapter)this.b.getAdapter());
      localObject = this.d;
      if (localObject == null) {
        return;
      }
      ((ZhituPicAdapter)localObject).a();
      this.b.resetCurrentX(0);
      this.d.notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituSafeGateRequestInterval: ");
      localStringBuilder.append(paramInt);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.J = paramInt;
    SharedPreUtils.T(this.E.getApp(), this.E.getCurrentAccountUin(), paramInt);
  }
  
  public void b(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShow:");
      ((StringBuilder)localObject).append(paramZhituPicData);
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramZhituPicData.l;
    ((ZhituReportData)localObject).d = 0;
    this.j.add(localObject);
    localObject = null;
    AppInterface localAppInterface = this.E;
    if ((localAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localAppInterface;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800ADCC", "0X800ADCC", 0, 0, "", "", paramZhituPicData.h, "");
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituSaveAndShareSwitch: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.G = paramBoolean;
    SharedPreUtils.j(this.E.getApp(), this.E.getCurrentAccountUin(), paramBoolean);
  }
  
  @Nullable
  public String c(ZhituPicData paramZhituPicData)
  {
    if ((paramZhituPicData.e) && (paramZhituPicData.d != null)) {
      return ZhituTextManager.a().a(paramZhituPicData.c, paramZhituPicData.d, paramZhituPicData.f, paramZhituPicData.g, this);
    }
    return null;
  }
  
  public void c()
  {
    if (this.n) {
      return;
    }
    File localFile = s();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return;
    }
    localFile = new File(localFile, "font");
    if ((localFile.exists()) && ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(g(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
      }
      this.o = Typeface.createFromFile(localFile);
      this.n = true;
      return;
    }
    IHttpEngineService localIHttpEngineService = (IHttpEngineService)this.E.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mNeedIpConnect = true;
    localHttpNetReq.mNeedNotReferer = true;
    localHttpNetReq.mCallback = new ZhituManager.FontDownloadListener(this.s);
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
    localHttpNetReq.mOutPath = localFile.getAbsolutePath();
    localHttpNetReq.mPrioty = 0;
    localIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageLen: ");
      localStringBuilder.append(paramInt);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.l = paramInt;
    SharedPreUtils.S(this.E.getApp(), this.E.getCurrentAccountUin(), paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituSafeGateSwitch: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.H = paramBoolean;
    SharedPreUtils.k(this.E.getApp(), this.E.getCurrentAccountUin(), paramBoolean);
  }
  
  public String d()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.s.obtainMessage(10, paramZhituPicData);
    this.s.sendMessage(paramZhituPicData);
  }
  
  public String e()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(ZhituPicData paramZhituPicData)
  {
    d(paramZhituPicData);
  }
  
  public int f()
  {
    AppInterface localAppInterface = this.E;
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      return RichTextChatManager.a((QQAppInterface)localAppInterface).e();
    }
    return 0;
  }
  
  @NonNull
  String f(ZhituPicData paramZhituPicData)
  {
    int i2 = f();
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    Object localObject = "origin";
    if (i1 != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Zhitu_");
      localStringBuilder.append(paramZhituPicData.c);
      localStringBuilder.append("_");
      if (paramZhituPicData.d != null) {
        localObject = Integer.valueOf(paramZhituPicData.d.hashCode());
      }
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Zhitu_");
    localStringBuilder.append(paramZhituPicData.c);
    localStringBuilder.append("_");
    if ((paramZhituPicData.d != null) && (paramZhituPicData.p)) {
      localObject = Integer.valueOf(paramZhituPicData.d.hashCode());
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    File localFile = x();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return null;
    }
    try
    {
      a(localFile);
      label26:
      return localFile.getAbsolutePath();
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public void g(ZhituPicData paramZhituPicData)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0)) {
      this.d.a(paramZhituPicData);
    }
    localObject = this.c;
    if ((localObject != null) && (((ZhituPanelView)localObject).getVisibility() == 0)) {
      this.e.a(paramZhituPicData);
    }
  }
  
  public void h(ZhituPicData paramZhituPicData)
  {
    ZhituManager.ZhituSendListener localZhituSendListener = this.M;
    if (localZhituSendListener != null) {
      localZhituSendListener.a(paramZhituPicData);
    }
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isZhituConfigOpen.zhituSwitch = ");
      localStringBuilder.append(this.A);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.A;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1) {
      if (i1 != 2) {
        if (i1 != 3) {
          if (i1 != 4) {
            if (i1 != 100) {
              if (i1 == 101) {}
            }
          }
        }
      }
    }
    switch (i1)
    {
    default: 
      return true;
    case 10: 
      i((ZhituPicData)paramMessage.obj);
      return true;
    case 8: 
      if ((paramMessage.obj instanceof HttpNetReq))
      {
        this.u.remove(paramMessage.obj);
        return true;
      }
      break;
    case 7: 
      b(paramMessage);
      return true;
      this.x += 1;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("download font fail, retry count: ");
        paramMessage.append(this.x);
        QLog.d("ZhituManager", 2, paramMessage.toString());
      }
      if (this.x <= 3)
      {
        b(Looper.myQueue());
        return true;
        paramMessage = r();
        if (paramMessage.exists()) {
          paramMessage = Typeface.createFromFile(paramMessage);
        } else {
          paramMessage = null;
        }
        this.o = paramMessage;
        this.n = true;
        return true;
        a((Bundle)paramMessage.obj);
        return true;
        a(paramMessage);
        return true;
        paramMessage = (Bundle)paramMessage.obj;
        ZhituResponse localZhituResponse = (ZhituResponse)paramMessage.getParcelable("Response");
        a(paramMessage.getInt("ErrorCode"), localZhituResponse, paramMessage.getString("UniqueKey"), paramMessage.getInt("StartIdx", 0), paramMessage.getString("QueryText"));
        return true;
        ((Runnable)paramMessage.obj).run();
      }
      break;
    }
    return true;
  }
  
  public boolean i()
  {
    return this.G;
  }
  
  public boolean j()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isZhituSafeGateSwitch = ");
      localStringBuilder.append(this.H);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.H;
  }
  
  public long k()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getZhituSafeGateRequestTime = ");
      localStringBuilder.append(this.I);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.I;
  }
  
  public int l()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getZhituSafeGateRequestInterval = ");
      localStringBuilder.append(this.J);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.J;
  }
  
  public boolean m()
  {
    return this.B;
  }
  
  public boolean n()
  {
    boolean bool1 = q();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (h())
    {
      bool1 = bool2;
      if (m()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "hideZhituEmotionLayout.");
    }
    if ((z()) && ((this.E instanceof QQAppInterface))) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite((QQAppInterface)this.E, "zhitu", false);
    }
    if (this.a != null)
    {
      b();
      ((ViewGroup)this.a.getParent()).removeView(this.a);
      this.a = null;
      this.b = null;
      this.d = null;
    }
    t();
    Handler localHandler = this.s;
    if (localHandler != null)
    {
      localHandler.post(new ZhituManager.12(this));
      this.s.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.a = null;
      this.b = null;
      this.d = null;
    }
    if (this.c != null)
    {
      this.c = null;
      this.e = null;
    }
    if ((this.r != null) && (this.s != null))
    {
      t();
      this.s.post(new ZhituManager.13(this));
    }
    Executor localExecutor = this.t;
    if ((localExecutor instanceof ExecutorService)) {
      ((ExecutorService)localExecutor).shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager
 * JD-Core Version:    0.7.0.1
 */