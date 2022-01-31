package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import zes;
import zeu;
import zev;
import zew;
import zex;

public class ApolloLottieAnim
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(paramContext.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private zex jdField_a_of_type_Zex = new zex();
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  
  public ApolloLottieAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = ApolloConstant.g;
    return str + paramString + ".zip";
  }
  
  private void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      ZipUtils.a(paramFile, paramString);
    }
  }
  
  private void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.n = false;
    localDownloadTask.l = true;
    localDownloadTask.f = "apollo_lottie";
    localDownloadTask.b = 1;
    localDownloadTask.o = true;
    localDownloadTask.p = true;
    localDownloadTask.a(new zeu(this, paramString1, paramString2, paramString3));
    paramString1 = BaseApplicationImpl.getApplication();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getRuntime();
      if (!(paramString1 instanceof QQAppInterface)) {}
    }
    for (paramString1 = (QQAppInterface)paramString1;; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = (DownloaderFactory)paramString1.getManager(46);
        if (paramString1 != null)
        {
          paramString1 = paramString1.a(1);
          if (paramString1 != null) {
            paramString1.a(localDownloadTask, localDownloadTask.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new zev(this, localDownloadTask));
        }
        return;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!paramString2.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_Int = 0;
      }
      paramString2 = b(this.jdField_a_of_type_JavaLangString);
      new File(paramString2).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "setZipData mState:", Integer.valueOf(this.jdField_a_of_type_Int), ",zipUrl:", paramString1, ",localZipPath:", this.jdField_a_of_type_JavaLangString });
      }
      paramBoolean = a(paramString2);
      if (!paramBoolean)
      {
        QLog.w("ApolloLottieAnim", 1, "setZipData Lottie Anim data.json not exit");
        this.jdField_a_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_Boolean = false;
        File localFile = new File(this.jdField_a_of_type_JavaLangString);
        if (paramBoolean)
        {
          a(false, localFile, paramString2);
          return;
        }
        if (localFile.exists())
        {
          a(true, localFile, paramString2);
          return;
        }
        a(paramString1, this.jdField_a_of_type_JavaLangString, paramString2);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    a(false, null, paramString2);
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      if (!a(paramString))
      {
        QLog.e("ApolloLottieAnim", 1, "Lottie Anim data.json not exit");
        return;
      }
      this.jdField_a_of_type_Int = 3;
      if (this.jdField_b_of_type_Boolean)
      {
        a();
        a(paramString);
        return;
      }
    }
    catch (Exception paramFile)
    {
      QLog.e("ApolloLottieAnim", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  private boolean a(String paramString)
  {
    return new File(paramString + "data.json").exists();
  }
  
  private String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      return str + File.separator;
    }
    return "";
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new zew(this));
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
    } while (paramDiniFlyAnimationView.isAnimating());
    if (this.jdField_a_of_type_Boolean)
    {
      paramDiniFlyAnimationView.playAnimation();
      return;
    }
    for (;;)
    {
      try
      {
        zes localzes = new zes(this, paramDiniFlyAnimationView);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder().append("apollo://lottie_");
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          paramDiniFlyAnimationView = paramString;
          localBundle.putString("key", Utils.Crc64String(paramDiniFlyAnimationView));
          localBundle.putString("path", paramString + "images/");
          LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, new FileInputStream(paramString + "data.json"), localzes, localBundle, BaseApplicationImpl.sImageCache);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ApolloLottieAnim", 1, "playApolloGameBoxLottieAnim:" + paramContext);
        return;
      }
      paramDiniFlyAnimationView = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  public void a(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramDiniFlyAnimationView);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Zex.a(this, 0, paramString, a(paramString), true);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_Zex, 16);
    ThreadManager.excute(this.jdField_a_of_type_Zex, 16, null, true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramMessage = paramMessage.getData().getString("folder");
        a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (DiniFlyAnimationView)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim
 * JD-Core Version:    0.7.0.1
 */