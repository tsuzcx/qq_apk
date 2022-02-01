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
  private static int jdField_a_of_type_Int = 0;
  private static volatile boolean h = false;
  private static volatile boolean i = false;
  private long jdField_a_of_type_Long = 0L;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public LinearLayout a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ZhituEmotionHorizonListView a;
  private ZhituManager.DownloadListener jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$DownloadListener;
  private ZhituManager.ZhituSendListener jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener;
  private ZhituObserver jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituObserver;
  public ZhituPanelView.ZhituPanelAdapter a;
  public ZhituPanelView a;
  public ZhituPicAdapter a;
  private String jdField_a_of_type_JavaLangString = "";
  private List<HttpNetReq> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque<ZhituReportData> jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new ZhituManager.5(this, Looper.getMainLooper());
  private volatile String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int = 0;
  private Map<String, ZhituResponse> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private Map<File, Boolean> jdField_d_of_type_JavaUtilMap;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private final int jdField_f_of_type_Int = 180;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 180;
  private boolean jdField_g_of_type_Boolean = false;
  
  public ZhituManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    f();
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
  
  private int a(String paramString)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      if (j != 0)
      {
        if (j != 1) {
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
  
  private File a()
  {
    return new File(b(), "font");
  }
  
  private File a(ZhituImgResponse paramZhituImgResponse)
  {
    return a(c(), paramZhituImgResponse);
  }
  
  private File a(File paramFile, ZhituImgResponse paramZhituImgResponse)
  {
    return new File(paramFile, a(paramZhituImgResponse));
  }
  
  private String a(int paramInt)
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
  
  @NonNull
  private String a(ZhituImgResponse paramZhituImgResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.securitysdk.utils.MD5.a(paramZhituImgResponse.url));
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
    if (!paramString1.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ZhituPicData localZhituPicData = new ZhituPicData();
    localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), paramBitmap2);
    if (paramBitmap1 != null) {
      paramBitmap1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), paramBitmap1);
    } else {
      paramBitmap1 = null;
    }
    localZhituPicData.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramBitmap1;
    boolean bool = false;
    localZhituPicData.jdField_b_of_type_Boolean = false;
    if (paramInt == 0) {
      bool = true;
    }
    localZhituPicData.jdField_d_of_type_Boolean = bool;
    localZhituPicData.jdField_e_of_type_Boolean = paramBoolean;
    a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, localZhituPicData);
    h(localZhituPicData);
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ReqUniqueKey");
    if (!a().equals(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "reqKey is outdated, skip."));
      }
      return;
    }
    int j = paramBundle.getInt("RetryCount", 0);
    int k = paramBundle.getInt("IdxInRes");
    str1 = paramBundle.getString("ReqUniqueKey");
    if (j >= 3)
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
      ((StringBuilder)localObject).append(j);
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", ((StringBuilder)localObject).toString()));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "retry img download"));
    }
    paramBundle.putInt("RetryCount", j + 1);
    Object localObject = (ZhituResponse)paramBundle.getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)paramBundle.getParcelable("ImgResponse");
    String str2 = paramBundle.getString("QueryText");
    paramBundle.remove("ErrorCode");
    a((ZhituResponse)localObject, str1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, k, localZhituImgResponse, str2, paramBundle);
  }
  
  private void a(Message paramMessage)
  {
    Object localObject = (Bundle)paramMessage.obj;
    paramMessage = ((Bundle)localObject).getString("ReqUniqueKey");
    if (!a().equals(paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "reqKey is outdated, skip."));
      }
      return;
    }
    ZhituResponse localZhituResponse = (ZhituResponse)((Bundle)localObject).getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)((Bundle)localObject).getParcelable("ImgResponse");
    int k = ((Bundle)localObject).getInt("IdxInRes");
    localObject = ((Bundle)localObject).getString("QueryText");
    if ((localZhituResponse != null) && (localZhituImgResponse != null))
    {
      int m = a(localZhituImgResponse.style);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("style is ");
        localStringBuilder.append(m);
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", k, localStringBuilder.toString()));
      }
      int n = b();
      int j = 1;
      if (n != 1) {
        j = 0;
      }
      if (m != 2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.6(this, paramMessage, k, localZhituResponse, localZhituImgResponse, m, (String)localObject));
        return;
      }
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("zhitutest handleImgDownloadSucc key = ");
          localStringBuilder.append(paramMessage);
          localStringBuilder.append(" |idxinRes = ");
          localStringBuilder.append(k);
          localStringBuilder.append(" | originQueryText = ");
          localStringBuilder.append((String)localObject);
          QLog.d("ZhituManager", 2, localStringBuilder.toString());
        }
        if (a(paramMessage, localZhituImgResponse) != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.7(this, paramMessage, k, localZhituResponse, localZhituImgResponse, m, (String)localObject));
          return;
        }
        a(paramMessage, k, localZhituImgResponse);
        return;
      }
      a(paramMessage, k, localZhituImgResponse);
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
    if (!paramString3.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString3, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ZhituPicData localZhituPicData = new ZhituPicData();
    localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = paramDrawTextParam;
    boolean bool = true;
    localZhituPicData.jdField_b_of_type_Boolean = true;
    localZhituPicData.c = paramString1;
    localZhituPicData.jdField_b_of_type_JavaLangString = paramString2;
    localZhituPicData.jdField_a_of_type_Boolean = true;
    if (paramInt != 0) {
      bool = false;
    }
    localZhituPicData.jdField_d_of_type_Boolean = bool;
    a(paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, localZhituPicData);
    paramDrawTextParam = b(localZhituPicData);
    a(paramDrawTextParam, paramAbstractGifImage);
    paramAbstractGifImage = this.jdField_a_of_type_AndroidOsHandler;
    if (paramAbstractGifImage != null) {
      paramAbstractGifImage.post(new ZhituManager.8(this, paramDrawTextParam));
    }
    h(localZhituPicData);
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramZhituResponse.list;
    if (localObject == null)
    {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "the list is null"));
      if (paramInt == 0) {
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources().getString(2131720495));
      }
      return;
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramString1, paramZhituResponse);
    if ((paramInt == 0) && (((List)localObject).isEmpty()))
    {
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources().getString(2131720495));
      return;
    }
    int j = Math.min(((List)localObject).size(), paramInt + d());
    if (!a(paramZhituResponse, (List)localObject, paramInt, j, paramString1, paramString2))
    {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "fail to start download"));
      return;
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(6);
    ((Message)localObject).arg1 = (j - paramInt);
    if (paramInt == 0) {
      ((Message)localObject).arg1 += 1;
    }
    ((Message)localObject).arg2 = paramZhituResponse.hasMore;
    ((Message)localObject).obj = paramString1;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ZhituManager.9(this, paramZhituResponse, paramString1, j, paramString2));
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
    paramZhituResponse = a(paramZhituImgResponse);
    boolean bool = paramZhituResponse.exists();
    int j = 1;
    if (bool)
    {
      b(paramZhituResponse.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "md5 matched, the origin img is downloaded and just skip download."));
      }
      if (this.jdField_e_of_type_Int != 2)
      {
        bool = paramZhituResponse.setLastModified(System.currentTimeMillis());
        if ((this.jdField_e_of_type_Int == 0) && (QLog.isColorLevel()))
        {
          paramZhituResponse = new StringBuilder();
          paramZhituResponse.append("set last modified time is supported? ");
          paramZhituResponse.append(bool);
          QLog.d("ZhituManager", 2, paramZhituResponse.toString());
        }
        if (bool) {
          paramInt = j;
        } else {
          paramInt = 2;
        }
        this.jdField_e_of_type_Int = paramInt;
      }
      paramZhituResponse = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      paramZhituResponse.obj = localBundle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramZhituResponse);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$DownloadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$DownloadListener = new ZhituManager.DownloadListener(this.jdField_a_of_type_AndroidOsHandler);
    }
    paramZhituImgResponse = paramZhituImgResponse.url;
    paramAppInterface = (IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    paramString2 = new HttpNetReq();
    paramString2.mNeedIpConnect = true;
    paramString2.mNeedNotReferer = true;
    paramString2.mCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$DownloadListener;
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
    this.jdField_a_of_type_JavaUtilList.add(paramString2);
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
      if (this.jdField_d_of_type_JavaUtilMap == null) {
        this.jdField_d_of_type_JavaUtilMap = new HashMap();
      }
      if (!this.jdField_d_of_type_JavaUtilMap.containsKey(paramFile))
      {
        File localFile = new File(paramFile, ".nomedia");
        if ((!localFile.exists()) && (localFile.createNewFile())) {
          this.jdField_d_of_type_JavaUtilMap.put(paramFile, Boolean.valueOf(true));
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
    localStringBuilder.append(jdField_a_of_type_Int);
    CaughtExceptionReport.a(paramOutOfMemoryError, localStringBuilder.toString());
    paramOutOfMemoryError = new StringBuilder();
    paramOutOfMemoryError.append("create bitmap but oom, ");
    paramOutOfMemoryError.append(jdField_a_of_type_Int);
    QLog.d("ZhituManager", 1, paramOutOfMemoryError.toString());
  }
  
  private void a(String paramString)
  {
    paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11, paramString);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
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
      str = a(paramZhituImgResponse).getAbsolutePath();
      a(new NativeGifImage(new File(str), false), null, str, str, paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
      return;
    }
    catch (IOException paramZhituImgResponse)
    {
      label109:
      break label109;
    }
    QLog.e("ZhituManager", 1, a(paramString, "passThroughOriginImg", "convert to gif drawable fail"));
    return;
    a(null, BitmapFactory.decodeFile(a(paramZhituImgResponse).getAbsolutePath()), paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
  }
  
  /* Error */
  private void a(String paramString1, int paramInt1, ZhituResponse paramZhituResponse, ZhituImgResponse paramZhituImgResponse, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 11
    //   3: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +20 -> 26
    //   9: ldc 139
    //   11: iconst_2
    //   12: aload 11
    //   14: ldc 206
    //   16: iload_2
    //   17: ldc_w 793
    //   20: invokestatic 439	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: getstatic 777	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:jdField_a_of_type_Int	I
    //   29: iconst_1
    //   30: iadd
    //   31: putstatic 777	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:jdField_a_of_type_Int	I
    //   34: aload 4
    //   36: getfield 279	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   39: astore 12
    //   41: aload 12
    //   43: aload 12
    //   45: ldc_w 797
    //   48: invokevirtual 800	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   51: invokevirtual 803	java/lang/String:substring	(I)Ljava/lang/String;
    //   54: astore 14
    //   56: aload_0
    //   57: aload 11
    //   59: aload 4
    //   61: invokespecial 463	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse;)Landroid/graphics/Rect;
    //   64: astore 13
    //   66: aload 13
    //   68: ifnonnull +4 -> 72
    //   71: return
    //   72: aload_0
    //   73: aload 4
    //   75: invokespecial 616	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse;)Ljava/io/File;
    //   78: invokevirtual 622	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: astore 12
    //   83: invokestatic 610	java/lang/System:currentTimeMillis	()J
    //   86: lstore 9
    //   88: ldc_w 795
    //   91: aload 14
    //   93: invokevirtual 807	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   96: ifeq +519 -> 615
    //   99: aload_0
    //   100: invokevirtual 442	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:b	()I
    //   103: istore 7
    //   105: iload 7
    //   107: iconst_1
    //   108: if_icmpne +9 -> 117
    //   111: iconst_1
    //   112: istore 7
    //   114: goto +6 -> 120
    //   117: iconst_0
    //   118: istore 7
    //   120: iload_2
    //   121: ifeq +121 -> 242
    //   124: iload 7
    //   126: ifeq +6 -> 132
    //   129: goto +113 -> 242
    //   132: new 809	com/tencent/image/NativeGifImage
    //   135: dup
    //   136: new 248	java/io/File
    //   139: dup
    //   140: aload 12
    //   142: invokespecial 811	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: iconst_0
    //   146: invokespecial 814	com/tencent/image/NativeGifImage:<init>	(Ljava/io/File;Z)V
    //   149: astore 11
    //   151: invokestatic 836	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   154: astore 14
    //   156: aload 11
    //   158: invokevirtual 839	com/tencent/image/NativeGifImage:getWidth	()I
    //   161: istore 7
    //   163: aload 11
    //   165: invokevirtual 842	com/tencent/image/NativeGifImage:getHeight	()I
    //   168: istore 8
    //   170: aload_3
    //   171: getfield 845	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   174: astore_3
    //   175: aload 4
    //   177: getfield 848	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   180: astore 15
    //   182: aload_0
    //   183: getfield 850	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:jdField_a_of_type_AndroidGraphicsTypeface	Landroid/graphics/Typeface;
    //   186: astore 16
    //   188: aload_0
    //   189: aload 11
    //   191: aload 14
    //   193: iload 7
    //   195: iload 8
    //   197: aload 6
    //   199: aload_3
    //   200: aload 15
    //   202: aload 13
    //   204: iload 5
    //   206: aload_1
    //   207: iload_2
    //   208: aload 16
    //   210: invokevirtual 853	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;
    //   213: aload 12
    //   215: aconst_null
    //   216: aload_1
    //   217: iload_2
    //   218: aload 4
    //   220: getfield 279	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   223: aload 4
    //   225: getfield 289	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   228: aload 4
    //   230: getfield 433	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   233: aload 4
    //   235: getfield 817	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   238: invokespecial 819	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Lcom/tencent/image/AbstractGifImage;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   241: return
    //   242: ldc 139
    //   244: astore 11
    //   246: new 855	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText
    //   249: dup
    //   250: new 248	java/io/File
    //   253: dup
    //   254: aload 12
    //   256: invokespecial 811	java/io/File:<init>	(Ljava/lang/String;)V
    //   259: iconst_0
    //   260: fconst_0
    //   261: invokespecial 858	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:<init>	(Ljava/io/File;ZF)V
    //   264: astore 14
    //   266: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +79 -> 348
    //   272: new 197	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   279: astore 15
    //   281: aload 15
    //   283: ldc_w 860
    //   286: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 15
    //   292: iload_2
    //   293: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 15
    //   299: ldc_w 312
    //   302: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 15
    //   308: aload 14
    //   310: invokevirtual 861	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   313: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 15
    //   319: ldc_w 312
    //   322: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 15
    //   328: aload 14
    //   330: invokevirtual 862	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:d	()I
    //   333: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 11
    //   339: iconst_2
    //   340: aload 15
    //   342: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: invokestatic 836	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   351: astore 15
    //   353: aload 14
    //   355: invokevirtual 861	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   358: istore 7
    //   360: aload 14
    //   362: invokevirtual 863	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getHeight	()I
    //   365: istore 8
    //   367: aload_3
    //   368: getfield 845	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   371: astore_3
    //   372: aload 4
    //   374: getfield 848	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   377: astore 16
    //   379: aload_0
    //   380: getfield 850	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:jdField_a_of_type_AndroidGraphicsTypeface	Landroid/graphics/Typeface;
    //   383: astore 17
    //   385: aload 15
    //   387: iload 7
    //   389: iload 8
    //   391: aload 6
    //   393: aload_3
    //   394: aload 16
    //   396: aload 13
    //   398: iload 5
    //   400: aload_1
    //   401: iload_2
    //   402: aload 17
    //   404: invokevirtual 853	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;
    //   407: astore_3
    //   408: aload 14
    //   410: aload_3
    //   411: invokevirtual 866	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:a	(Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;)V
    //   414: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +376 -> 793
    //   420: new 197	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   427: astore 6
    //   429: aload 6
    //   431: ldc_w 868
    //   434: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 6
    //   440: invokestatic 610	java/lang/System:currentTimeMillis	()J
    //   443: lload 9
    //   445: lsub
    //   446: invokestatic 873	java/lang/Long:toString	(J)Ljava/lang/String;
    //   449: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 6
    //   455: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: astore 6
    //   460: aload 11
    //   462: iconst_2
    //   463: aload_1
    //   464: ldc_w 875
    //   467: iload_2
    //   468: aload 6
    //   470: invokestatic 439	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   473: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto +3 -> 479
    //   479: aload 4
    //   481: getfield 279	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   484: astore 6
    //   486: aload 4
    //   488: getfield 289	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   491: astore 11
    //   493: aload 4
    //   495: getfield 433	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   498: astore 13
    //   500: aload 4
    //   502: getfield 817	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   505: astore 15
    //   507: ldc 139
    //   509: astore 4
    //   511: aload_0
    //   512: aload 14
    //   514: aload_3
    //   515: aload 12
    //   517: aconst_null
    //   518: aload_1
    //   519: iload_2
    //   520: aload 6
    //   522: aload 11
    //   524: aload 13
    //   526: aload 15
    //   528: invokespecial 819	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Lcom/tencent/image/AbstractGifImage;Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   531: return
    //   532: astore_3
    //   533: goto +38 -> 571
    //   536: astore_3
    //   537: ldc 139
    //   539: astore 4
    //   541: goto +30 -> 571
    //   544: astore_3
    //   545: aload 11
    //   547: astore 4
    //   549: goto +22 -> 571
    //   552: astore_3
    //   553: ldc 139
    //   555: astore 4
    //   557: goto +14 -> 571
    //   560: astore_1
    //   561: aload_1
    //   562: invokestatic 163	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/OutOfMemoryError;)V
    //   565: return
    //   566: astore_3
    //   567: ldc 139
    //   569: astore 4
    //   571: new 197	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   578: astore 6
    //   580: aload 6
    //   582: ldc_w 877
    //   585: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 6
    //   591: aload_3
    //   592: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 4
    //   598: iconst_1
    //   599: aload_1
    //   600: ldc 206
    //   602: iload_2
    //   603: aload 6
    //   605: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 439	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   611: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: return
    //   615: aload 12
    //   617: invokestatic 829	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   620: astore 14
    //   622: aload 14
    //   624: ifnonnull +22 -> 646
    //   627: ldc 139
    //   629: iconst_1
    //   630: aload 11
    //   632: ldc_w 879
    //   635: iload_2
    //   636: ldc_w 881
    //   639: invokestatic 439	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   642: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: return
    //   646: invokestatic 836	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	()Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager;
    //   649: aload 12
    //   651: aload 6
    //   653: aload_3
    //   654: getfield 845	com/tencent/mobileqq/activity/aio/zhitu/ZhituResponse:tokens	Ljava/util/List;
    //   657: aload 4
    //   659: getfield 848	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:textColor	Ljava/lang/String;
    //   662: aload 13
    //   664: iload 5
    //   666: aload_1
    //   667: iload_2
    //   668: aload_0
    //   669: getfield 850	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:jdField_a_of_type_AndroidGraphicsTypeface	Landroid/graphics/Typeface;
    //   672: invokevirtual 884	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Landroid/graphics/Rect;ILjava/lang/String;ILandroid/graphics/Typeface;)Landroid/graphics/Bitmap;
    //   675: astore_3
    //   676: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   679: ifeq +56 -> 735
    //   682: new 197	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   689: astore 6
    //   691: aload 6
    //   693: ldc_w 868
    //   696: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 6
    //   702: invokestatic 610	java/lang/System:currentTimeMillis	()J
    //   705: lload 9
    //   707: lsub
    //   708: invokestatic 873	java/lang/Long:toString	(J)Ljava/lang/String;
    //   711: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: ldc 139
    //   717: iconst_2
    //   718: aload 11
    //   720: ldc_w 886
    //   723: iload_2
    //   724: aload 6
    //   726: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 439	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   732: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: aload_3
    //   736: ifnonnull +4 -> 740
    //   739: return
    //   740: aload_0
    //   741: aload 14
    //   743: aload_3
    //   744: aload_1
    //   745: iload_2
    //   746: aload 4
    //   748: getfield 279	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:url	Ljava/lang/String;
    //   751: aload 4
    //   753: getfield 289	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:md5	Ljava/lang/String;
    //   756: aload 4
    //   758: getfield 433	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:style	Ljava/lang/String;
    //   761: aload 4
    //   763: getfield 817	com/tencent/mobileqq/activity/aio/zhitu/ZhituImgResponse:pass	Ljava/lang/String;
    //   766: iconst_0
    //   767: invokespecial 831	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   770: return
    //   771: ldc 139
    //   773: iconst_1
    //   774: ldc_w 888
    //   777: invokestatic 823	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: return
    //   781: astore_1
    //   782: goto -11 -> 771
    //   785: astore_3
    //   786: ldc 139
    //   788: astore 4
    //   790: goto -219 -> 571
    //   793: goto -314 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	this	ZhituManager
    //   0	796	1	paramString1	String
    //   0	796	2	paramInt1	int
    //   0	796	3	paramZhituResponse	ZhituResponse
    //   0	796	4	paramZhituImgResponse	ZhituImgResponse
    //   0	796	5	paramInt2	int
    //   0	796	6	paramString2	String
    //   103	285	7	j	int
    //   168	222	8	k	int
    //   86	620	9	l	long
    //   1	718	11	localObject1	Object
    //   39	611	12	str	String
    //   64	599	13	localObject2	Object
    //   54	688	14	localObject3	Object
    //   180	347	15	localObject4	Object
    //   186	209	16	localObject5	Object
    //   383	20	17	localTypeface	Typeface
    // Exception table:
    //   from	to	target	type
    //   511	531	532	java/io/IOException
    //   460	476	536	java/io/IOException
    //   479	507	536	java/io/IOException
    //   385	460	544	java/io/IOException
    //   188	241	552	java/io/IOException
    //   246	348	552	java/io/IOException
    //   348	385	552	java/io/IOException
    //   99	105	560	java/lang/OutOfMemoryError
    //   132	188	560	java/lang/OutOfMemoryError
    //   188	241	560	java/lang/OutOfMemoryError
    //   246	348	560	java/lang/OutOfMemoryError
    //   348	385	560	java/lang/OutOfMemoryError
    //   385	460	560	java/lang/OutOfMemoryError
    //   460	476	560	java/lang/OutOfMemoryError
    //   479	507	560	java/lang/OutOfMemoryError
    //   511	531	560	java/lang/OutOfMemoryError
    //   99	105	566	java/io/IOException
    //   615	622	781	java/lang/OutOfMemoryError
    //   132	188	785	java/io/IOException
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, ZhituPicData paramZhituPicData)
  {
    paramZhituPicData.jdField_d_of_type_JavaLangString = paramString1;
    paramZhituPicData.jdField_a_of_type_Int = paramInt;
    paramZhituPicData.jdField_a_of_type_JavaLangString = paramString2;
    paramZhituPicData.jdField_e_of_type_JavaLangString = paramString3;
    paramString1 = new ZhituReportData();
    paramString1.jdField_b_of_type_JavaLangString = paramString3;
    paramString1.c = paramString4;
    paramString1.jdField_a_of_type_JavaLangString = paramString5;
    paramString1.jdField_d_of_type_JavaLangString = b(this.jdField_c_of_type_Int);
    paramString1.jdField_e_of_type_JavaLangString = b();
    paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData = paramString1;
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
    int j = 0;
    while (j < localList.size())
    {
      if (!localHashSet.add(localList.get(j)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("find duplication res: ");
          localStringBuilder.append(localList.get(j));
          QLog.e("ZhituManager", 2, a(paramString, "removeDuplicateImg", localStringBuilder.toString()));
        }
      }
      else {
        localArrayList.add(localList.get(j));
      }
      j += 1;
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
    Object localObject = (IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((IHttpEngineService)localObject).cancelReq((HttpNetReq)paramList.next());
    }
  }
  
  private void a(NewIntent paramNewIntent, Handler paramHandler)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituObserver = new ZhituObserver(paramHandler);
    }
    paramNewIntent.setObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituObserver);
  }
  
  public static boolean a(int paramInt)
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
    Object localObject = c();
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QLog.d("ZhituManager", 1, a(paramString1, "startImgDownload", "can not create dir."));
      return false;
    }
    try
    {
      a((File)localObject);
      label114:
      int j;
      if (paramInt1 == 0) {
        j = 0;
      } else {
        j = -1;
      }
      while (paramInt1 < paramInt2)
      {
        localObject = (ZhituImgResponse)paramList.get(paramInt1 + j);
        a(paramZhituResponse, paramString1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1, (ZhituImgResponse)localObject, paramString2, null);
        paramInt1 += 1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      break label114;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = localAppRuntime instanceof QQAppInterface;
    boolean bool3 = false;
    if (bool1) {
      bool1 = a((QQAppInterface)localAppRuntime).b();
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
  
  private int b(int paramInt)
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
  
  private File b()
  {
    return d();
  }
  
  private String b(int paramInt)
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
  
  private static String b(String paramString)
  {
    localObject1 = "";
    long l = System.currentTimeMillis();
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
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("ZhituManager", 2, new Object[] { "calcMD5", ((StringBuilder)localObject1).toString() });
    }
    return paramString;
  }
  
  private void b(Message paramMessage)
  {
    int j = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    if (android.text.TextUtils.isEmpty(paramMessage)) {
      return;
    }
    if (!paramMessage.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
      }
      return;
    }
    ZhituResponse localZhituResponse = (ZhituResponse)this.jdField_c_of_type_JavaUtilMap.get(paramMessage);
    if (localZhituResponse != null) {
      a(localZhituResponse, paramMessage, j, b());
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
    paramZhituResponse = ZhituTextManager.a().a(localBitmap, paramString2, paramZhituResponse.tokens, "#000000", localRect, 3, paramString1, paramInt, this.jdField_a_of_type_AndroidGraphicsTypeface);
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
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "realSendZhituSafeGateRequest start");
    }
    ZhituSafeGate.ReqBody localReqBody = new ZhituSafeGate.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(paramQQAppInterface.getCurrentUin()));
    localReqBody.uint32_src_term.set(3);
    paramQQAppInterface = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ZhituServlet.class);
    paramQQAppInterface.putExtra("ZhituCMD", "ZhituGate.Check");
    paramQQAppInterface.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramQQAppInterface);
  }
  
  public static boolean b(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isZhitu());
  }
  
  private File c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("origin/");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private File d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
      }
      int j = 1;
      while (j < 10)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
        j += 1;
      }
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    if (h == paramBoolean) {
      return;
    }
    try
    {
      h = paramBoolean;
      return;
    }
    finally {}
  }
  
  private File e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("zhitu");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sent/");
    return new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GlobalImageCache.a.remove(str);
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public static void e(boolean paramBoolean)
  {
    if (i == paramBoolean) {
      return;
    }
    try
    {
      i = paramBoolean;
      return;
    }
    finally {}
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = SharedPreUtils.q(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Boolean = SharedPreUtils.n(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Int = SharedPreUtils.aw(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_f_of_type_Boolean = SharedPreUtils.r(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_g_of_type_Boolean = SharedPreUtils.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Long = SharedPreUtils.g(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_g_of_type_Int = SharedPreUtils.ax(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.size() == 0) {
      return;
    }
    long l = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    while ((!this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.isEmpty()) && ((localLinkedList.size() <= 100) || (!paramBoolean))) {
      localLinkedList.add(this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.poll());
    }
    Object localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ZhituReportMsg.ReqBody localReqBody = ((ZhituReportData)((Iterator)localObject).next()).a();
      if (localReqBody != null)
      {
        NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ZhituServlet.class);
        localNewIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
        localNewIntent.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send ");
      ((StringBuilder)localObject).append(localLinkedList.size());
      ((StringBuilder)localObject).append(" reports, take ");
      ((StringBuilder)localObject).append(Long.toString(System.currentTimeMillis() - l));
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean f()
  {
    try
    {
      boolean bool = i;
      return bool;
    }
    finally {}
  }
  
  private void g(ZhituPicData paramZhituPicData)
  {
    if (paramZhituPicData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "handleRequestDecodeGif font fail, picData is null.");
      }
      return;
    }
    int k = b();
    int j = 1;
    if (k != 1) {
      j = 0;
    }
    String str = b(paramZhituPicData);
    if (a(str) != null)
    {
      h(paramZhituPicData);
      return;
    }
    try
    {
      if ((paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam != null) && ((paramZhituPicData.jdField_d_of_type_Boolean) || (j != 0)))
      {
        localObject = new GifImageWithText(new File(paramZhituPicData.c), false, 0.0F);
        ((GifImageWithText)localObject).a(paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam);
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
      this.jdField_b_of_type_JavaUtilList.add(str);
      h(paramZhituPicData);
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
  
  public static boolean g()
  {
    try
    {
      boolean bool = h;
      return bool;
    }
    finally {}
  }
  
  private void h(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, paramZhituPicData);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramZhituPicData);
  }
  
  private boolean h()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getZhituSafeGateRequestTime = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Long;
  }
  
  public File a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(paramString).getName());
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    paramString = localStringBuilder.toString();
    return new File(e(), paramString);
  }
  
  public File a(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString2)) {
      return a(paramString2);
    }
    int j = paramString1.lastIndexOf("/") + 1;
    int k = paramString1.lastIndexOf(".");
    if (j < k) {
      paramString1 = paramString1.substring(j, k);
    } else {
      paramString1 = "fakeFileName";
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(System.currentTimeMillis());
    paramString1 = paramString2.toString();
    return new File(e(), paramString1);
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public String a(ZhituPicData paramZhituPicData)
  {
    if ((paramZhituPicData.jdField_a_of_type_Boolean) && (paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam != null)) {
      return ZhituTextManager.a().a(paramZhituPicData.c, paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam, paramZhituPicData.jdField_d_of_type_JavaLangString, paramZhituPicData.jdField_a_of_type_Int, this);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView;
    if ((localObject != null) && (((ZhituPanelView)localObject).getVisibility() == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter;
      if (localObject != null) {
        ((ZhituPanelView.ZhituPanelAdapter)localObject).b();
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = ((ZhituPicAdapter)this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.getAdapter());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter;
      if (localObject == null) {
        return;
      }
      ((ZhituPicAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.resetCurrentX(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setZhituSafeGateRequestInterval: ");
      localStringBuilder.append(paramInt);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.jdField_g_of_type_Int = paramInt;
    SharedPreUtils.P(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "requestDownloadMoreImg", paramInt, ""));
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    localMessage.obj = paramString;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((paramString instanceof QQAppInterface)) {
      paramString = (QQAppInterface)paramString;
    } else {
      paramString = null;
    }
    ReportController.b(paramString, "dc00898", "", "", "0X8008C73", "0X8008C73", a(this.jdField_c_of_type_Int), 0, "", "", "", "");
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
    this.jdField_a_of_type_Long = paramLong;
    SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramLong);
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
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131381343);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout != null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView = ((ZhituEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131381347));
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout == null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramContext, 2131558600, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView = ((ZhituEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131381347));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.setOnScrollStateChangedListener(new ZhituManager.10(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.setTouchListener(new ZhituManager.11(this, paramMqqHandler));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368875);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = ((ZhituPicAdapter)this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.getAdapter());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if ((paramViewGroup instanceof QQAppInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = new ZhituPicAdapter(paramContext, (QQAppInterface)paramViewGroup, paramBaseActivity, paramSessionInfo, paramMqqHandler);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView.setRecycleListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramMqqHandler != null)
    {
      paramMqqHandler.removeMessages(84);
      paramMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void a(ZhituManager.ZhituSendListener paramZhituSendListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener = paramZhituSendListener;
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
    this.jdField_b_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), b());
    this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramZhituPicData.jdField_e_of_type_JavaLangString);
    Object localObject = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    ((ZhituReportData)localObject).jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localAppInterface;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800ADCD", "0X800ADCD", 0, 0, "", "", paramZhituPicData.jdField_e_of_type_JavaLangString, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest start");
    }
    if (!RichTextChatManager.a(paramQQAppInterface).a(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest isZhituLegalOpen is fales return");
      }
      return;
    }
    long l = System.currentTimeMillis() - a();
    if (l < c() * 60000L)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("sendZhituSafeGateRequest time is short return time = ");
        paramQQAppInterface.append(l);
        QLog.d("ZhituManager", 2, paramQQAppInterface.toString());
      }
      return;
    }
    b(paramQQAppInterface);
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
      paramEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView;
      if ((paramEditable != null) && (paramEditable.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a().setEnabled(false);
      }
      a();
      d();
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ZhituThread", 8);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
        if (Build.VERSION.SDK_INT >= 23) {
          a(this.jdField_a_of_type_AndroidOsHandler.getLooper().getQueue());
        } else {
          this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new ZhituManager.1(this));
        }
        paramEditable = new ThreadPoolParams();
        paramEditable.corePoolsize = 1;
        paramEditable.maxPooolSize = 1;
        paramEditable.priority = 8;
        paramEditable.poolThreadName = "ZhituImgGenerateThreadPool";
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramEditable);
      }
      paramEditable = new StringBuilder();
      paramEditable.append(com.tencent.securitysdk.utils.MD5.a(paramList));
      paramEditable.append("_");
      paramEditable.append(System.currentTimeMillis());
      paramEditable = paramEditable.toString();
      a(paramEditable, paramList);
      paramQQAppInterface = new ZhituManager.2(this, paramInt, paramQQAppInterface, paramEditable, paramList);
      paramQQAppInterface = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramQQAppInterface);
      paramList = this.jdField_a_of_type_AndroidOsHandler;
      long l;
      if (paramBoolean) {
        l = 500L;
      } else {
        l = 0L;
      }
      paramList.sendMessageDelayed(paramQQAppInterface, l);
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
    localZhituRequest.chat = a(paramInt1);
    localZhituRequest.version = "8.7.0";
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramQQAppInterface.getCurrentUin()))
    {
      paramString2 = new ZhituReportRequest();
      paramString2.jdField_a_of_type_JavaUtilList = paramList;
      paramString2.jdField_b_of_type_JavaLangString = ((String)this.jdField_b_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentUin()));
      paramString2.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentUin()));
      paramString2.jdField_a_of_type_Int = b(paramInt1);
      localZhituRequest.report = paramString2;
    }
    a(paramQQAppInterface, paramString1, localZhituRequest, 0, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
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
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreUtils.j(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isZhituConfigOpen.zhituSwitch = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.jdField_b_of_type_Boolean;
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
      paramEditable.append(com.tencent.securitysdk.utils.MD5.a(str));
      QLog.d("ZhituManager", 2, paramEditable.toString());
    }
    return bool1;
  }
  
  public int b()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface))) {
      return RichTextChatManager.a((QQAppInterface)localAppInterface).a();
    }
    return 0;
  }
  
  public String b()
  {
    try
    {
      String str = this.jdField_b_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  String b(ZhituPicData paramZhituPicData)
  {
    int k = b();
    int j = 1;
    if (k != 1) {
      j = 0;
    }
    Object localObject = "origin";
    if (j != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Zhitu_");
      localStringBuilder.append(paramZhituPicData.c);
      localStringBuilder.append("_");
      if (paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam != null) {
        localObject = Integer.valueOf(paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.hashCode());
      }
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Zhitu_");
    localStringBuilder.append(paramZhituPicData.c);
    localStringBuilder.append("_");
    if ((paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam != null) && (paramZhituPicData.jdField_d_of_type_Boolean)) {
      localObject = Integer.valueOf(paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.hashCode());
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    File localFile = b();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return;
    }
    localFile = new File(localFile, "font");
    if ((localFile.exists()) && ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(b(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    IHttpEngineService localIHttpEngineService = (IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mNeedIpConnect = true;
    localHttpNetReq.mNeedNotReferer = true;
    localHttpNetReq.mCallback = new ZhituManager.FontDownloadListener(this.jdField_a_of_type_AndroidOsHandler);
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
    localHttpNetReq.mOutPath = localFile.getAbsolutePath();
    localHttpNetReq.mPrioty = 0;
    localIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageLen: ");
      localStringBuilder.append(paramInt);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramInt;
    SharedPreUtils.O(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
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
    Object localObject = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    ((ZhituReportData)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localAppInterface;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800ADCC", "0X800ADCC", 0, 0, "", "", paramZhituPicData.jdField_e_of_type_JavaLangString, "");
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
    this.jdField_f_of_type_Boolean = paramBoolean;
    SharedPreUtils.k(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getZhituSafeGateRequestInterval = ");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.jdField_g_of_type_Int;
  }
  
  public String c()
  {
    File localFile = e();
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "hideZhituEmotionLayout.");
    }
    if ((h()) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "zhitu", false);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = null;
    }
    d();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.post(new ZhituManager.12(this));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  public void c(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10, paramZhituPicData);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramZhituPicData);
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
    this.jdField_g_of_type_Boolean = paramBoolean;
    SharedPreUtils.l(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isZhituSafeGateSwitch = ");
      localStringBuilder.append(this.jdField_g_of_type_Boolean);
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    return this.jdField_g_of_type_Boolean;
  }
  
  public void d(ZhituPicData paramZhituPicData)
  {
    c(paramZhituPicData);
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void e(ZhituPicData paramZhituPicData)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.a(paramZhituPicData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView;
    if ((localObject != null) && (((ZhituPanelView)localObject).getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter.a(paramZhituPicData);
    }
  }
  
  public boolean e()
  {
    boolean bool1 = g();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void f(ZhituPicData paramZhituPicData)
  {
    ZhituManager.ZhituSendListener localZhituSendListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener;
    if (localZhituSendListener != null) {
      localZhituSendListener.a(paramZhituPicData);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 1) {
      if (j != 2) {
        if (j != 3) {
          if (j != 4) {
            if (j != 100) {
              if (j == 101) {}
            }
          }
        }
      }
    }
    switch (j)
    {
    default: 
      return true;
    case 10: 
      g((ZhituPicData)paramMessage.obj);
      return true;
    case 8: 
      if ((paramMessage.obj instanceof HttpNetReq))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramMessage.obj);
        return true;
      }
      break;
    case 7: 
      b(paramMessage);
      return true;
      this.jdField_d_of_type_Int += 1;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("download font fail, retry count: ");
        paramMessage.append(this.jdField_d_of_type_Int);
        QLog.d("ZhituManager", 2, paramMessage.toString());
      }
      if (this.jdField_d_of_type_Int <= 3)
      {
        b(Looper.myQueue());
        return true;
        paramMessage = a();
        if (paramMessage.exists()) {
          paramMessage = Typeface.createFromFile(paramMessage);
        } else {
          paramMessage = null;
        }
        this.jdField_a_of_type_AndroidGraphicsTypeface = paramMessage;
        this.jdField_a_of_type_Boolean = true;
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
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituEmotionHorizonListView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter = null;
    }
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.post(new ZhituManager.13(this));
    }
    Executor localExecutor = this.jdField_a_of_type_JavaUtilConcurrentExecutor;
    if ((localExecutor instanceof ExecutorService)) {
      ((ExecutorService)localExecutor).shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager
 * JD-Core Version:    0.7.0.1
 */