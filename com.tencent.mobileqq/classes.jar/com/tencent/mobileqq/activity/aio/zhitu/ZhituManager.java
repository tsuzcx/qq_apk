package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.ark.ArkAtBabyQSpan;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wan;
import wao;
import wap;
import waq;
import war;
import was;
import wat;
import wau;
import wav;
import waw;
import wax;
import way;
import waz;
import wba;
import wbg;

public class ZhituManager
  implements Handler.Callback, Manager, wbg
{
  private static int jdField_a_of_type_Int;
  private static volatile boolean f;
  private static volatile boolean g;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public LinearLayout a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ZhituManager.ZhituSendListener jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener;
  private ZhituObserver jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituObserver;
  public ZhituPicAdapter a;
  public DoutuEmotionHorizonListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private waz jdField_a_of_type_Waz;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new wau(this, Looper.getMainLooper());
  private volatile String jdField_b_of_type_JavaLangString = "";
  private List jdField_b_of_type_JavaUtilList = new LinkedList();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private Map jdField_d_of_type_JavaUtilMap;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  
  public ZhituManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    f();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 5;
  }
  
  private int a(ZhituImgResponse paramZhituImgResponse)
  {
    try
    {
      int i = Integer.parseInt(paramZhituImgResponse.style);
      switch (i)
      {
      }
    }
    catch (NumberFormatException paramZhituImgResponse)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ZhituManager", 2, "img response has invalid style");
    }
    return 2;
    return 0;
    return 1;
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
    Rect localRect = new Rect();
    String[] arrayOfString = paramZhituImgResponse.coord.split("\\|");
    try
    {
      localRect.left = Integer.parseInt(arrayOfString[0]);
      localRect.top = Integer.parseInt(arrayOfString[1]);
      localRect.right = (localRect.left + Integer.parseInt(arrayOfString[2]));
      int i = localRect.top;
      localRect.bottom = (Integer.parseInt(arrayOfString[3]) + i);
      return localRect;
    }
    catch (Exception localException)
    {
      QLog.d("ZhituManager", 1, a(paramString, "startImgGenerate", "unknown rect format: " + paramZhituImgResponse.coord));
    }
    return null;
  }
  
  static AbstractGifImage a(String paramString)
  {
    paramString = BaseApplicationImpl.sImageCache.get(paramString);
    if ((paramString instanceof Pair)) {
      return (AbstractGifImage)((Pair)paramString).first;
    }
    return null;
  }
  
  public static ZhituManager a(AppInterface paramAppInterface)
  {
    return (ZhituManager)paramAppInterface.getManager(257);
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
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "c2c";
    case 3000: 
      return "discussion";
    case 1: 
      return "troop";
    }
    return "kandian";
  }
  
  @NonNull
  private String a(ZhituImgResponse paramZhituImgResponse)
  {
    return com.tencent.securitysdk.utils.MD5.a(paramZhituImgResponse.url) + "_" + paramZhituImgResponse.md5;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return a(paramString1, paramString2, "[" + paramInt + "]" + paramString3);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("[%s][%s]: %s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private void a(int paramInt1, ZhituResponse paramZhituResponse, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "onResponse", "error code: " + paramInt1 + " / " + paramZhituResponse + " startIdx: " + paramInt2));
    }
    if (paramInt1 != 0) {
      return;
    }
    a(paramString1, paramZhituResponse);
    a(paramZhituResponse, paramString1, paramInt2, paramString2);
  }
  
  private void a(Bitmap paramBitmap, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!paramString1.equals(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ZhituPicData localZhituPicData = new ZhituPicData();
    localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), paramBitmap);
    localZhituPicData.jdField_b_of_type_Boolean = false;
    a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, localZhituPicData);
    g(localZhituPicData);
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ReqUniqueKey");
    if (!a().equals(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "reqKey is outdated, skip."));
      }
    }
    int i;
    int j;
    do
    {
      return;
      i = paramBundle.getInt("RetryCount", 0);
      j = paramBundle.getInt("IdxInRes");
      str1 = paramBundle.getString("ReqUniqueKey");
      if (i < 3) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "max retry limitation is reached."));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "current retry count is " + i));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(str1, "retryFailDownload", "retry img download"));
    }
    paramBundle.putInt("RetryCount", i + 1);
    ZhituResponse localZhituResponse = (ZhituResponse)paramBundle.getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)paramBundle.getParcelable("ImgResponse");
    String str2 = paramBundle.getString("QueryText");
    paramBundle.remove("ErrorCode");
    a(localZhituResponse, str1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, j, localZhituImgResponse, str2, paramBundle);
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
    int i = ((Bundle)localObject).getInt("IdxInRes");
    localObject = ((Bundle)localObject).getString("QueryText");
    int j = a(localZhituImgResponse);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", i, "style is " + j));
    }
    if (j != 2)
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new wav(this, paramMessage, i, localZhituResponse, localZhituImgResponse, j, (String)localObject));
      return;
    }
    a(paramMessage, i, localZhituImgResponse);
  }
  
  private void a(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new was(this));
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
    localZhituPicData.jdField_b_of_type_Boolean = true;
    localZhituPicData.c = paramString1;
    localZhituPicData.jdField_b_of_type_JavaLangString = paramString2;
    localZhituPicData.jdField_a_of_type_Boolean = true;
    a(paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, localZhituPicData);
    paramDrawTextParam = b(localZhituPicData);
    a(paramDrawTextParam, paramAbstractGifImage);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new waw(this, paramDrawTextParam));
    }
    g(localZhituPicData);
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramZhituResponse.list;
    if (localObject == null) {
      QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "the list is null"));
    }
    int i;
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_JavaUtilMap.put(paramString1, paramZhituResponse);
      } while ((paramInt == 0) && (((List)localObject).isEmpty()));
      i = Math.min(((List)localObject).size(), b() + paramInt);
      if (!a(paramZhituResponse, (List)localObject, paramInt, i, paramString1, paramString2))
      {
        QLog.d("ZhituManager", 1, a(paramString1, "handleZhituResponse", "fail to start download"));
        return;
      }
      localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(6);
      ((Message)localObject).arg1 = (i - paramInt);
      if (paramInt == 0) {
        ((Message)localObject).arg1 += 1;
      }
      ((Message)localObject).arg2 = paramZhituResponse.hasMore;
      ((Message)localObject).obj = paramString1;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    } while (paramInt != 0);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new wax(this, paramZhituResponse, paramString1, i, paramString2));
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, AppInterface paramAppInterface, int paramInt, ZhituImgResponse paramZhituImgResponse, String paramString2, Bundle paramBundle)
  {
    int i = 1;
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
    if (paramZhituResponse.exists())
    {
      b(paramZhituResponse.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "md5 matched, the origin img is downloaded and just skip download."));
      }
      if (this.jdField_e_of_type_Int != 2)
      {
        boolean bool = paramZhituResponse.setLastModified(System.currentTimeMillis());
        if ((this.jdField_e_of_type_Int == 0) && (QLog.isColorLevel())) {
          QLog.d("ZhituManager", 2, "set last modified time is supported? " + bool);
        }
        if (!bool) {
          break label223;
        }
      }
      label223:
      for (paramInt = i;; paramInt = 2)
      {
        this.jdField_e_of_type_Int = paramInt;
        paramZhituResponse = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        paramZhituResponse.obj = localBundle;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramZhituResponse);
        return;
      }
    }
    if (this.jdField_a_of_type_Waz == null) {
      this.jdField_a_of_type_Waz = new waz(this.jdField_a_of_type_AndroidOsHandler);
    }
    paramZhituImgResponse = paramZhituImgResponse.url;
    paramAppInterface = paramAppInterface.getNetEngine(0);
    paramString2 = new HttpNetReq();
    paramString2.jdField_a_of_type_Boolean = true;
    paramString2.jdField_e_of_type_Boolean = true;
    paramString2.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this.jdField_a_of_type_Waz;
    paramString2.jdField_a_of_type_Int = 0;
    paramString2.jdField_a_of_type_JavaLangString = paramZhituImgResponse;
    paramString2.c = paramZhituResponse.getAbsolutePath();
    paramString2.jdField_e_of_type_Int = 0;
    paramString2.a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "start send img download request, " + paramZhituImgResponse));
    }
    this.jdField_a_of_type_JavaUtilList.add(paramString2);
    paramAppInterface.a(paramString2);
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
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "realSendZhituRequest", "send request: " + paramZhituRequest));
    }
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
  
  public static void a(OutOfMemoryError paramOutOfMemoryError)
  {
    QQCatchedExceptionReporter.reportQQCatchedException(paramOutOfMemoryError, "ZhituCreateBitmapCatchedException", "OOM when create bitmap with count: " + jdField_a_of_type_Int);
    QLog.d("ZhituManager", 1, "create bitmap but oom, " + jdField_a_of_type_Int);
  }
  
  private void a(String paramString, int paramInt, ZhituImgResponse paramZhituImgResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "passThroughOriginImg", paramInt, "start"));
    }
    String str = paramZhituImgResponse.url;
    if (".gif".equalsIgnoreCase(str.substring(str.lastIndexOf(".")))) {
      try
      {
        str = a(paramZhituImgResponse).getAbsolutePath();
        a(new NativeGifImage(new File(str), false), null, str, str, paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
        return;
      }
      catch (IOException paramZhituImgResponse)
      {
        QLog.e("ZhituManager", 1, a(paramString, "passThroughOriginImg", "convert to gif drawable fail"));
        return;
      }
    }
    a(BitmapFactory.decodeFile(a(paramZhituImgResponse).getAbsolutePath()), paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
  }
  
  private void a(String paramString1, int paramInt1, ZhituResponse paramZhituResponse, ZhituImgResponse paramZhituImgResponse, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startImgGenerate", paramInt1, "start"));
    }
    jdField_a_of_type_Int += 1;
    String str = paramZhituImgResponse.url;
    Object localObject = str.substring(str.lastIndexOf("."));
    Rect localRect = a(paramString1, paramZhituImgResponse);
    if (localRect == null) {}
    do
    {
      return;
      str = a(paramZhituImgResponse).getAbsolutePath();
      long l = System.currentTimeMillis();
      if (".gif".equalsIgnoreCase((String)localObject)) {
        try
        {
          localObject = new GifImageWithText(new File(str), false, 0.0F);
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "get width: " + paramInt1 + " / " + ((GifImageWithText)localObject).getWidth() + " / " + ((GifImageWithText)localObject).d());
          }
          paramZhituResponse = ZhituTextManager.a().a(((GifImageWithText)localObject).getWidth(), ((GifImageWithText)localObject).getHeight(), paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.jdField_a_of_type_AndroidGraphicsTypeface);
          ((GifImageWithText)localObject).a(paramZhituResponse);
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, a(paramString1, "generateGifImage", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
          }
          a((AbstractGifImage)localObject, paramZhituResponse, str, null, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
          return;
        }
        catch (IOException paramZhituResponse)
        {
          QLog.e("ZhituManager", 1, a(paramString1, "startImgGenerate", paramInt1, "open gif file fail, " + paramZhituResponse));
          return;
        }
        catch (OutOfMemoryError paramString1)
        {
          a(paramString1);
          return;
        }
      }
      paramZhituResponse = ZhituTextManager.a().a(str, paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.jdField_a_of_type_AndroidGraphicsTypeface);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "generateBitmap", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
      }
    } while (paramZhituResponse == null);
    a(paramZhituResponse, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, ZhituPicData paramZhituPicData)
  {
    paramZhituPicData.d = paramString1;
    paramZhituPicData.jdField_a_of_type_Int = paramInt;
    paramZhituPicData.jdField_a_of_type_JavaLangString = paramString2;
    paramZhituPicData.e = paramString3;
    paramString1 = new ZhituReportData();
    paramString1.jdField_b_of_type_JavaLangString = paramString3;
    paramString1.c = paramString4;
    paramString1.jdField_a_of_type_JavaLangString = paramString5;
    paramString1.d = b(this.jdField_c_of_type_Int);
    paramString1.e = b();
    paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData = paramString1;
  }
  
  private void a(String paramString, AbstractGifImage paramAbstractGifImage)
  {
    paramAbstractGifImage = new Pair(paramAbstractGifImage, Integer.valueOf(paramAbstractGifImage.getByteSize()));
    BaseApplicationImpl.sImageCache.put(paramString, paramAbstractGifImage);
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
    int i = 0;
    if (i < localList.size())
    {
      if (!localHashSet.add(localList.get(i))) {
        if (QLog.isColorLevel()) {
          QLog.e("ZhituManager", 2, a(paramString, "removeDuplicateImg", "find duplication res: " + localList.get(i)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localList.get(i));
      }
    }
    paramZhituResponse.list = localArrayList;
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cancel all pending net req: " + paramList.size());
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localINetEngine.b((HttpNetReq)paramList.next());
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
    boolean bool = false;
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(ZhituResponse paramZhituResponse, List paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startImgDownload", "start / end idx: " + paramInt1 + " / " + paramInt2));
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
      label98:
      int i;
      if (paramInt1 == 0) {
        i = 0;
      }
      while (paramInt1 < paramInt2)
      {
        localObject = (ZhituImgResponse)paramList.get(paramInt1 + i);
        a(paramZhituResponse, paramString1, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1, (ZhituImgResponse)localObject, paramString2, null);
        paramInt1 += 1;
        continue;
        i = -1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      break label98;
    }
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  private File b()
  {
    return d();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "tempchat";
    case 0: 
      return "c2c";
    case 3000: 
      return "discuss";
    case 1: 
      return "group";
    }
    return "kandian";
  }
  
  private static String b(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(com.tencent.qphone.base.util.MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = MD5FileUtil.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, new Object[] { "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private void b(Message paramMessage)
  {
    int i = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    if (android.text.TextUtils.isEmpty(paramMessage)) {}
    ZhituResponse localZhituResponse;
    do
    {
      do
      {
        return;
        if (paramMessage.equals(a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
      return;
      localZhituResponse = (ZhituResponse)this.jdField_c_of_type_JavaUtilMap.get(paramMessage);
    } while (localZhituResponse == null);
    a(localZhituResponse, paramMessage, i, b());
  }
  
  private void b(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new wat(this));
  }
  
  private void b(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "generateFullTextZhitu", paramInt, ""));
    }
    Bitmap localBitmap = a(200, 200);
    if (localBitmap == null) {}
    do
    {
      return;
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setColor(-1);
      Rect localRect = new Rect(0, 0, 200, 200);
      localCanvas.drawRect(localRect, localPaint);
      paramZhituResponse = ZhituTextManager.a().a(localBitmap, paramString2, paramZhituResponse.tokens, "#000000", localRect, 3, paramString1, paramInt, this.jdField_a_of_type_AndroidGraphicsTypeface);
      if (paramZhituResponse != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "generate full text zhitu fail");
    return;
    a(paramZhituResponse, paramString1, paramInt, "http://img.qq.com/zhitu/fulltext.jpg", "mario" + System.currentTimeMillis(), "WhiteBack", null);
  }
  
  private File c()
  {
    return new File(AppConstants.aJ + "zhitu", "origin/");
  }
  
  public static void c(boolean paramBoolean)
  {
    if (f == paramBoolean) {
      return;
    }
    try
    {
      f = paramBoolean;
      return;
    }
    finally {}
  }
  
  private File d()
  {
    return new File(AppConstants.aJ + "zhitu");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
      }
      int i = 1;
      while (i < 10)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(i);
        i += 1;
      }
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    if (g == paramBoolean) {
      return;
    }
    try
    {
      g = paramBoolean;
      return;
    }
    finally {}
  }
  
  public static boolean d()
  {
    try
    {
      boolean bool = g;
      return bool;
    }
    finally {}
  }
  
  private File e()
  {
    return new File(AppConstants.aJ + "zhitu", "sent/");
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      BaseApplicationImpl.sImageCache.remove(str);
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.size() == 0) {}
    long l;
    LinkedList localLinkedList;
    do
    {
      return;
      l = System.currentTimeMillis();
      localLinkedList = new LinkedList();
      while ((!this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.isEmpty()) && ((localLinkedList.size() <= 100) || (!paramBoolean))) {
        localLinkedList.add(this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.poll());
      }
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ZhituReportMsg.ReqBody localReqBody = ((ZhituReportData)localIterator.next()).a();
        if (localReqBody != null)
        {
          NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ZhituServlet.class);
          localNewIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
          localNewIntent.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "send " + localLinkedList.size() + " reports, take " + Long.toString(System.currentTimeMillis() - l));
  }
  
  public static boolean e()
  {
    try
    {
      boolean bool = f;
      return bool;
    }
    finally {}
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = SharedPreUtils.w(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Boolean = SharedPreUtils.u(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Int = SharedPreUtils.aT(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void f(ZhituPicData paramZhituPicData)
  {
    for (;;)
    {
      try
      {
        if (paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam != null)
        {
          localObject = new GifImageWithText(new File(paramZhituPicData.c), false, 0.0F);
          ((GifImageWithText)localObject).a(paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam);
          String str = b(paramZhituPicData);
          a(str, (AbstractGifImage)localObject);
          this.jdField_b_of_type_JavaUtilList.add(str);
          g(paramZhituPicData);
          return;
        }
      }
      catch (IOException paramZhituPicData)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ZhituManager", 2, "decode gif fail: " + paramZhituPicData);
        return;
      }
      catch (OutOfMemoryError paramZhituPicData)
      {
        a(paramZhituPicData);
      }
      localObject = new NativeGifImage(new File(paramZhituPicData.c), false);
    }
  }
  
  private boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  private void g(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, paramZhituPicData);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramZhituPicData);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public File a(@NonNull String paramString)
  {
    paramString = new File(paramString).getName() + "_" + System.currentTimeMillis();
    return new File(e(), paramString);
  }
  
  public File a(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString2)) {
      return a(paramString2);
    }
    int i = paramString1.lastIndexOf("/") + 1;
    int j = paramString1.lastIndexOf(".");
    if (i < j) {}
    for (paramString1 = paramString1.substring(i, j);; paramString1 = "fakeFileName")
    {
      paramString1 = paramString1 + "_" + System.currentTimeMillis();
      return new File(e(), paramString1);
    }
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
    if ((!paramZhituPicData.jdField_a_of_type_Boolean) || (paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam == null)) {
      return null;
    }
    return ZhituTextManager.a().a(paramZhituPicData.c, paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam, paramZhituPicData.d, paramZhituPicData.jdField_a_of_type_Int, this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = ((ZhituPicAdapter)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setPageLen: " + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    SharedPreUtils.ah(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
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
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; paramString = null)
    {
      ReportController.b(paramString, "dc00898", "", "", "0X8008C73", "0X8008C73", a(this.jdField_c_of_type_Int), 0, "", "", "", "");
      return;
    }
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
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131363100);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout != null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363101));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = ((ZhituPicAdapter)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.a());
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter == null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = new ZhituPicAdapter(paramContext, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBaseActivity, paramSessionInfo, paramMqqHandler);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setRecycleListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramMqqHandler == null) {
        break;
      }
      paramMqqHandler.removeMessages(85);
      paramMqqHandler.sendEmptyMessageDelayed(85, 10000L);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout == null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramContext, 2130968673, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363101));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setOnScrollStateChangedListener(new way(this));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setTouchListener(new wao(this, paramMqqHandler));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363476);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(ZhituManager.ZhituSendListener paramZhituSendListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener = paramZhituSendListener;
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onSend:" + paramZhituPicData);
    }
    this.jdField_b_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), b());
    this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramZhituPicData.e);
    paramZhituPicData = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    paramZhituPicData.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(paramZhituPicData);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Editable paramEditable, List paramList, int paramInt, boolean paramBoolean)
  {
    d(true);
    paramList = paramEditable.toString();
    if (android.text.TextUtils.isEmpty(paramList)) {
      break label16;
    }
    label16:
    while ((paramList.length() > 24) || (!a(paramEditable))) {
      return;
    }
    a();
    d();
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ZhituThread", 8);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      if (Build.VERSION.SDK_INT >= 23)
      {
        a(this.jdField_a_of_type_AndroidOsHandler.getLooper().getQueue());
        label109:
        paramEditable = new ThreadPoolParams();
        paramEditable.jdField_b_of_type_Int = 1;
        paramEditable.jdField_c_of_type_Int = 1;
        paramEditable.jdField_a_of_type_Int = 8;
        paramEditable.jdField_a_of_type_JavaLangString = "ZhituImgGenerateThreadPool";
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramEditable);
      }
    }
    else
    {
      paramEditable = com.tencent.securitysdk.utils.MD5.a(paramList) + "_" + System.currentTimeMillis();
      a(paramEditable, paramList);
      paramQQAppInterface = new war(this, paramInt, paramQQAppInterface, paramEditable, paramList);
      paramQQAppInterface = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramQQAppInterface);
      paramList = this.jdField_a_of_type_AndroidOsHandler;
      if (!paramBoolean) {
        break label271;
      }
    }
    label271:
    for (long l = 500L;; l = 0L)
    {
      paramList.sendMessageDelayed(paramQQAppInterface, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ZhituManager", 2, a(paramEditable, "pending request", ""));
      return;
      this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new wan(this));
      break label109;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, List paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "sendZhituRequest", "start sending request"));
    }
    ZhituRequest localZhituRequest = new ZhituRequest();
    localZhituRequest.uin = paramQQAppInterface.c();
    localZhituRequest.os = "android";
    localZhituRequest.text = paramString2;
    localZhituRequest.styles = 3;
    localZhituRequest.chat = a(paramInt1);
    localZhituRequest.version = "7.6.0";
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramQQAppInterface.c()))
    {
      paramString2 = new ZhituReportRequest();
      paramString2.jdField_a_of_type_JavaUtilList = paramList;
      paramString2.jdField_b_of_type_JavaLangString = ((String)this.jdField_b_of_type_JavaUtilMap.get(paramQQAppInterface.c()));
      paramString2.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.c()));
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
    this.jdField_c_of_type_Boolean = paramBoolean;
    SharedPreUtils.t(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
    String str;
    if (paramBoolean)
    {
      str = "0X8008C75";
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label86;
      }
    }
    label86:
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localQQAppInterface = null)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", str, str, a(this.jdField_c_of_type_Int), 0, "", "", "", "");
      return;
      str = "0X8008C74";
      break;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "isZhituConfigOpen.zhituSwitch = " + this.jdField_b_of_type_Boolean);
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Editable paramEditable)
  {
    boolean bool1;
    if ((com.tencent.mobileqq.text.TextUtils.a(paramEditable.toString()) > -1) || (com.tencent.mobileqq.text.TextUtils.a(paramEditable.toString())))
    {
      bool1 = false;
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "isLegal: " + bool1 + " / " + com.tencent.securitysdk.utils.MD5.a(paramEditable.toString()));
      }
      return bool1;
    }
    Object localObject = new ArrayList();
    AtTroopMemberSpan.a(paramEditable, (ArrayList)localObject);
    if (((ArrayList)localObject).size() <= 0)
    {
      bool1 = true;
      label99:
      if (!bool1) {
        break label166;
      }
      localObject = (ArkAtBabyQSpan[])paramEditable.getSpans(0, paramEditable.toString().length(), ArkAtBabyQSpan.class);
      if ((localObject == null) || (localObject.length <= 0)) {
        break label166;
      }
    }
    label166:
    for (boolean bool2 = false;; bool2 = bool1)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      bool1 = bool2;
      if (!LoveLanguageManager.b(paramEditable.toString())) {
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label99;
    }
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
    StringBuilder localStringBuilder = new StringBuilder().append("Zhitu_").append(paramZhituPicData.c).append("_");
    if (paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam == null) {}
    for (paramZhituPicData = "origin";; paramZhituPicData = Integer.valueOf(paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.hashCode())) {
      return paramZhituPicData;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localFile = b();
    } while ((!localFile.exists()) && (!localFile.mkdirs()));
    File localFile = new File(localFile, "font");
    if ((localFile.exists()) && ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(b(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.jdField_e_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new wba(this.jdField_a_of_type_AndroidOsHandler);
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaLangString = "http://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
    localHttpNetReq.c = localFile.getAbsolutePath();
    localHttpNetReq.jdField_e_of_type_Int = 0;
    localINetEngine.a(localHttpNetReq);
  }
  
  public void b(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onShow:" + paramZhituPicData);
    }
    paramZhituPicData = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    paramZhituPicData.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(paramZhituPicData);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituConfigOpen: " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreUtils.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
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
    if ((f()) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      SpriteCommFunc.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "zhitu", false);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = null;
    }
    d();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new wap(this));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  public void c(ZhituPicData paramZhituPicData)
  {
    paramZhituPicData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10, paramZhituPicData);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramZhituPicData);
  }
  
  public boolean c()
  {
    if (e()) {}
    while ((!a()) || (!b())) {
      return false;
    }
    return true;
  }
  
  public void d(ZhituPicData paramZhituPicData)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.a(paramZhituPicData);
    }
  }
  
  public void e(ZhituPicData paramZhituPicData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituManager$ZhituSendListener.a(paramZhituPicData);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 9: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    case 100: 
    case 8: 
    case 101: 
      do
      {
        do
        {
          return true;
          ((Runnable)paramMessage.obj).run();
          return true;
          paramMessage = (Bundle)paramMessage.obj;
          ZhituResponse localZhituResponse = (ZhituResponse)paramMessage.getParcelable("Response");
          a(paramMessage.getInt("ErrorCode"), localZhituResponse, paramMessage.getString("UniqueKey"), paramMessage.getInt("StartIdx", 0), paramMessage.getString("QueryText"));
          return true;
          a(paramMessage);
          return true;
          a((Bundle)paramMessage.obj);
          return true;
          b(paramMessage);
          return true;
          paramMessage = a();
          if (paramMessage.exists()) {}
          for (paramMessage = Typeface.createFromFile(paramMessage);; paramMessage = null)
          {
            this.jdField_a_of_type_AndroidGraphicsTypeface = paramMessage;
            this.jdField_a_of_type_Boolean = true;
            return true;
          }
        } while (!(paramMessage.obj instanceof HttpNetReq));
        this.jdField_a_of_type_JavaUtilList.remove(paramMessage.obj);
        return true;
        this.jdField_d_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "download font fail, retry count: " + this.jdField_d_of_type_Int);
        }
      } while (this.jdField_d_of_type_Int > 3);
      b(Looper.myQueue());
      return true;
    }
    f((ZhituPicData)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter = null;
    }
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.post(new waq(this));
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutor instanceof ExecutorService)) {
      ((ExecutorService)this.jdField_a_of_type_JavaUtilConcurrentExecutor).shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager
 * JD-Core Version:    0.7.0.1
 */