package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

public class TeleScreenListenerWrapper
  implements DownloadListener, JumpListener
{
  @Nullable
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  TeleScreenListenerWrapper(Context paramContext, @Nullable DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramDownloadListener;
  }
  
  TeleScreenListenerWrapper(Context paramContext, @Nullable JumpListener paramJumpListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramJumpListener;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof JumpListener)) {
      ((JumpListener)localObject).a(paramBoolean, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof DownloadListener)) {
      ((DownloadListener)localObject).a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof DownloadListener)) {
      return ((DownloadListener)localObject).a();
    }
    return false;
  }
  
  void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jump | jump: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errCode: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errMsg: ");
    localStringBuilder.append(paramString);
    QLog.d("TeleScreenListenerWrapper", 1, localStringBuilder.toString());
    a(paramBoolean, paramInt1, paramInt2, paramString);
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download | pass: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(", errCode: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errMsg: ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("TeleScreenListenerWrapper", 1, ((StringBuilder)localObject).toString());
    a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    paramString1 = this.jdField_a_of_type_JavaLangObject;
    if (((paramString1 instanceof DownloadListener)) && (!((DownloadListener)paramString1).a())) {
      return;
    }
    localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && (paramBoolean1) && (!paramBoolean2) && (!TextUtils.isEmpty(paramString2)))
    {
      Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString2);
      if ((localObject instanceof Activity)) {
        paramString1 = (Activity)localObject;
      } else {
        paramString1 = Foreground.getTopActivity();
      }
      if (paramString1 == null)
      {
        localIntent.addFlags(268435456);
        ((Context)localObject).startActivity(localIntent);
        return;
      }
      paramString1.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreenListenerWrapper
 * JD-Core Version:    0.7.0.1
 */