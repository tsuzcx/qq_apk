package com.tencent.mobileqq.apollo.screenshot;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.player.CMSHelper.TF;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;)V", "TAG", "", "mRecordHandler", "Landroid/os/Handler;", "mRecordListener", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "mResource", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "initThreadPool", "", "onRecordFrame", "", "pixels", "", "width", "", "height", "onRecordFrameEnd", "actionCompleted", "onRecordFrameStart", "frameTimeInSec", "", "setRecordListener", "listener", "stopRecord", "taskId", "normally", "INSTANCE", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloScreenshotController
{
  private static DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  public static final ApolloScreenshotController.INSTANCE a;
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private ApolloCoderResource jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource;
  private volatile IApolloActionRecordListener jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
  private final IScriptService jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController$INSTANCE = new ApolloScreenshotController.INSTANCE(null);
  }
  
  public ApolloScreenshotController(@NotNull IScriptService paramIScriptService)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = paramIScriptService;
    paramIScriptService = new StringBuilder();
    paramIScriptService.append("[ApolloScrshot] ");
    paramIScriptService.append(this);
    paramIScriptService.append(' ');
    this.jdField_a_of_type_JavaLangString = paramIScriptService.toString();
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "new ApolloScreenshotController");
    paramIScriptService = new HandlerThread(this.jdField_a_of_type_JavaLangString);
    paramIScriptService.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramIScriptService.getLooper());
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController$INSTANCE.a();
    ApolloScreenshotController.INSTANCE.a(jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController$INSTANCE);
    a();
  }
  
  private final void a()
  {
    int i = CmShowWnsUtils.a();
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initThreadPool size:");
    ((StringBuilder)localObject2).append(i);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = TimeUnit.MINUTES;
    localObject2 = (BlockingQueue)new LinkedBlockingQueue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_AsyncThread");
    localObject1 = new ThreadPoolExecutor(i, i, 1L, (TimeUnit)localObject1, (BlockingQueue)localObject2, (ThreadFactory)new CMSHelper.TF(localStringBuilder.toString(), 9));
    ((ThreadPoolExecutor)localObject1).allowCoreThreadTimeOut(true);
    jdField_a_of_type_JavaUtilConcurrentExecutor = (Executor)localObject1;
  }
  
  private final void a(@NotNull IScriptService paramIScriptService, int paramInt, boolean paramBoolean)
  {
    String str = ScriptUtil.a(paramInt, paramBoolean);
    Intrinsics.checkExpressionValueIsNotNull(str, "content");
    paramIScriptService.a(new Script(str));
  }
  
  public final void a(@NotNull IApolloActionRecordListener paramIApolloActionRecordListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIApolloActionRecordListener, "listener");
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRecordListener to: ");
    localStringBuilder.append(paramIApolloActionRecordListener);
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener = paramIApolloActionRecordListener;
  }
  
  public final boolean a(float paramFloat)
  {
    if (!ApolloApngEncoder.a.b())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onRecordFrameStart so not preloaded");
      return false;
    }
    IApolloActionRecordListener localIApolloActionRecordListener = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
    if ((paramFloat > 0) && (localIApolloActionRecordListener != null))
    {
      String str1 = localIApolloActionRecordListener.a();
      Object localObject = localIApolloActionRecordListener.a();
      int i = localIApolloActionRecordListener.a();
      BusinessConfig localBusinessConfig = localIApolloActionRecordListener.a();
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordFrameStart");
      localStringBuilder.append(", frameTimeInSec:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", taskId:");
      localStringBuilder.append(i);
      localStringBuilder.append(", uniKey:");
      localStringBuilder.append(str1);
      localStringBuilder.append(", getRecordMode:");
      localStringBuilder.append(localObject);
      QLog.i(str2, 1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)str1)) {
        return false;
      }
      int j = (int)(paramFloat * 1000);
      int k = ApolloScreenshotController.WhenMappings.a[localObject.ordinal()];
      if (k != 1) {
        if (k != 2) {
          localObject = EncodeType.APNG;
        }
      }
      for (;;)
      {
        break;
        localObject = EncodeType.GIF;
        continue;
        localObject = EncodeType.FRAME;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource = new ApolloCoderResource(i, str1, j, (EncodeType)localObject, localBusinessConfig, this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService, 0, 64, null);
      localIApolloActionRecordListener.a();
      return true;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onRecordFrameStart return false");
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    ApolloCoderResource localApolloCoderResource = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource;
    if (localApolloCoderResource != null)
    {
      IApolloActionRecordListener localIApolloActionRecordListener = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
      Object localObject2 = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource = ((ApolloCoderResource)null);
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordFrameEnd, key:");
      if (localApolloCoderResource != null) {
        localObject1 = localApolloCoderResource.c();
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", taskId:");
      Object localObject1 = localObject2;
      if (localApolloCoderResource != null) {
        localObject1 = Integer.valueOf(localApolloCoderResource.c());
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", complete:");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 1, localStringBuilder.toString());
      if ((localApolloCoderResource != null) && (localIApolloActionRecordListener != null)) {
        localIApolloActionRecordListener.a(localApolloCoderResource.a());
      }
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrameEnd.2(this, localApolloCoderResource, paramBoolean, localIApolloActionRecordListener));
      return true;
    }
    return false;
  }
  
  public final boolean a(@Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      int i;
      if (paramArrayOfByte.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (paramInt1 > 0) && (paramInt2 > 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource;
        if (localObject1 == null)
        {
          paramArrayOfByte = this.jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRecordFrame fail, width:");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(", height:");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(", resource null");
          QLog.e(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        if (((ApolloCoderResource)localObject1).a())
        {
          ((ApolloCoderResource)localObject1).a(-13408);
          paramArrayOfByte = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onRecordFrame forceStopRecord, key:");
          ((StringBuilder)localObject2).append(((ApolloCoderResource)localObject1).c());
          ((StringBuilder)localObject2).append(" taskId:");
          ((StringBuilder)localObject2).append(((ApolloCoderResource)localObject1).c());
          ((StringBuilder)localObject2).append(" currentFrameCount:");
          ((StringBuilder)localObject2).append(((ApolloCoderResource)localObject1).b());
          QLog.e(paramArrayOfByte, 1, ((StringBuilder)localObject2).toString());
          a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService, ((ApolloCoderResource)localObject1).c(), false);
          return false;
        }
        ((ApolloCoderResource)localObject1).a();
        try
        {
          paramArrayOfByte = (byte[])paramArrayOfByte.clone();
          localObject2 = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onRecordFrame key:");
          localStringBuilder.append(((ApolloCoderResource)localObject1).c());
          localStringBuilder.append(" taskId:");
          localStringBuilder.append(((ApolloCoderResource)localObject1).c());
          localStringBuilder.append(", pixelSize:");
          localStringBuilder.append(paramArrayOfByte.length);
          localStringBuilder.append(", width:");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", height:");
          localStringBuilder.append(paramInt2);
          QLog.i((String)localObject2, 1, localStringBuilder.toString());
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new ApolloScreenshotController.onRecordFrame.1(this, paramInt1, paramInt2, paramArrayOfByte, (ApolloCoderResource)localObject1, (IApolloActionRecordListener)localObject2));
          return true;
        }
        catch (OutOfMemoryError paramArrayOfByte)
        {
          ((ApolloCoderResource)localObject1).a(-13409);
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "onRecordFrame OOM", (Throwable)paramArrayOfByte);
          System.gc();
          a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService, ((ApolloCoderResource)localObject1).c(), false);
          return false;
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onRecordFrame fail, width:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", height:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", pixels.size:");
    if (paramArrayOfByte != null) {
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
    } else {
      paramArrayOfByte = null;
    }
    ((StringBuilder)localObject2).append(paramArrayOfByte);
    QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController
 * JD-Core Version:    0.7.0.1
 */