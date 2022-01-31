package com.tencent.mobileqq.apollo.view;

import aiys;
import ajca;
import ajcc;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import batm;
import bato;
import batr;
import befq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import mpx;
import mqq.os.MqqHandler;

public class ApolloLottieAnim
  implements Handler.Callback
{
  public int a;
  private befq jdField_a_of_type_Befq = new befq(paramContext.getMainLooper(), this);
  private ApolloLottieAnim.DecoderRunnable jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim$DecoderRunnable = new ApolloLottieAnim.DecoderRunnable();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<DiniFlyAnimationView> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ApolloLottieAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = aiys.k;
    return str + paramString + ".zip";
  }
  
  private void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      mpx.a(paramFile, paramString);
    }
  }
  
  private void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_Befq.sendMessage(localMessage);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.c = paramBoolean;
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
      b();
      a(paramString);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("ApolloLottieAnim", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
    }
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
  
  public MQLruCache<String, Object> a()
  {
    return BaseApplicationImpl.sImageCache;
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
    } while (paramDiniFlyAnimationView.isAnimating());
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      paramDiniFlyAnimationView.playAnimation();
      return;
    }
    for (;;)
    {
      try
      {
        ajca localajca = new ajca(this, paramDiniFlyAnimationView, paramBoolean);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder().append("apollo://lottie_");
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          str = paramString;
          localBundle.putString("key", Utils.Crc64String(str));
          localBundle.putString("path", paramString + "images/");
          LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, paramInputStream, paramDiniFlyAnimationView.getLottieDrawable(), localajca, localBundle, a());
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ApolloLottieAnim", 1, "playApolloGameBoxLottieAnim:" + paramContext);
        return;
      }
      String str = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
        this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramDiniFlyAnimationView);
      }
      a(paramContext, paramDiniFlyAnimationView, paramString, new FileInputStream(paramString + "data.json"), paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloLottieAnim", 1, "fromFileWithCacheBitmap:" + paramContext);
    }
  }
  
  public void a(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramDiniFlyAnimationView);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim$DecoderRunnable.a(this, paramString1, paramString2, paramBoolean);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim$DecoderRunnable, 16);
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim$DecoderRunnable, 16, null, true);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    batm localbatm = new batm(paramString1, new File(paramString2));
    localbatm.p = true;
    localbatm.n = true;
    localbatm.f = "apollo_lottie";
    localbatm.b = 1;
    localbatm.q = true;
    localbatm.r = true;
    localbatm.a(new ajcc(this, paramString1, paramString2, paramString3));
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
        paramString1 = (bato)paramString1.getManager(47);
        if (paramString1 != null)
        {
          paramString1 = paramString1.a(3);
          if (paramString1 != null) {
            paramString1.a(localbatm, localbatm.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new ApolloLottieAnim.3(this, localbatm));
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
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
  
  public boolean a(String paramString)
  {
    return new File(paramString + "data.json").exists();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ApolloLottieAnim.4(this));
    if (this.jdField_a_of_type_Befq != null) {
      this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
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
        a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (DiniFlyAnimationView)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramMessage, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim
 * JD-Core Version:    0.7.0.1
 */