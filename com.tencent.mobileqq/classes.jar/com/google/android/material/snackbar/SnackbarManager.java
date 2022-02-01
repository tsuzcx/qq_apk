package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager
{
  private static SnackbarManager jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager;
  @NonNull
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new SnackbarManager.1(this));
  @Nullable
  private SnackbarManager.SnackbarRecord jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord;
  @NonNull
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  @Nullable
  private SnackbarManager.SnackbarRecord b;
  
  static SnackbarManager a()
  {
    if (jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager == null) {
      jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager = new SnackbarManager();
    }
    return jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager;
  }
  
  private void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord = ((SnackbarManager.SnackbarRecord)localObject);
      this.b = null;
      localObject = (SnackbarManager.Callback)this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        ((SnackbarManager.Callback)localObject).a();
        return;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord = null;
    }
  }
  
  private boolean a(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    SnackbarManager.Callback localCallback = (SnackbarManager.Callback)paramSnackbarRecord.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallback != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.a(paramInt);
      return true;
    }
    return false;
  }
  
  private void b(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord)
  {
    if (paramSnackbarRecord.jdField_a_of_type_Int == -2) {
      return;
    }
    int i = 2750;
    if (paramSnackbarRecord.jdField_a_of_type_Int > 0) {
      i = paramSnackbarRecord.jdField_a_of_type_Int;
    } else if (paramSnackbarRecord.jdField_a_of_type_Int == -1) {
      i = 1500;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(paramSnackbarRecord);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramSnackbarRecord), i);
  }
  
  private boolean b(SnackbarManager.Callback paramCallback)
  {
    SnackbarManager.SnackbarRecord localSnackbarRecord = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord;
    return (localSnackbarRecord != null) && (localSnackbarRecord.a(paramCallback));
  }
  
  private boolean c(SnackbarManager.Callback paramCallback)
  {
    SnackbarManager.SnackbarRecord localSnackbarRecord = this.b;
    return (localSnackbarRecord != null) && (localSnackbarRecord.a(paramCallback));
  }
  
  public void a(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (b(paramCallback))
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord = null;
        if (this.b != null) {
          a();
        }
      }
      return;
    }
  }
  
  public void a(SnackbarManager.Callback paramCallback, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (b(paramCallback)) {
        a(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord, paramInt);
      } else if (c(paramCallback)) {
        a(this.b, paramInt);
      }
      return;
    }
  }
  
  void a(@NonNull SnackbarManager.SnackbarRecord paramSnackbarRecord)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord == paramSnackbarRecord) || (this.b == paramSnackbarRecord)) {
        a(paramSnackbarRecord, 2);
      }
      return;
    }
  }
  
  public boolean a(SnackbarManager.Callback paramCallback)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (b(paramCallback)) {
          break label40;
        }
        if (c(paramCallback))
        {
          break label40;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
  
  public void b(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (b(paramCallback)) {
        b(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord);
      }
      return;
    }
  }
  
  public void c(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((b(paramCallback)) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord);
      }
      return;
    }
  }
  
  public void d(SnackbarManager.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((b(paramCallback)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord.jdField_a_of_type_Boolean = false;
        b(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarSnackbarManager$SnackbarRecord);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarManager
 * JD-Core Version:    0.7.0.1
 */