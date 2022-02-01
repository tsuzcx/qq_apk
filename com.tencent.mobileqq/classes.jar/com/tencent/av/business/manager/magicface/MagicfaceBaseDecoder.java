package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class MagicfaceBaseDecoder
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected MagicfaceData a;
  String jdField_a_of_type_JavaLangString;
  WeakReference<MagicfaceBaseDecoder.MagicPlayListener> jdField_a_of_type_JavaLangRefWeakReference;
  volatile boolean jdField_a_of_type_Boolean = false;
  WeakReference<MagicfaceBaseDecoder.MagicfaceRenderListener> b;
  
  public MagicfaceBaseDecoder()
  {
    c();
  }
  
  public abstract int a();
  
  public void a()
  {
    d();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a();
      try
      {
        new Thread(new MagicfaceBaseDecoder.1(this)).start();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDecoder err:");
          localStringBuilder.append(localOutOfMemoryError.getMessage());
          QLog.e("MagicfaceBaseDecoder", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMagicPlayListener);
  }
  
  public void a(MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    if (paramMagicfaceRenderListener != null)
    {
      this.b = new WeakReference(paramMagicfaceRenderListener);
      return;
    }
    this.b = null;
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData = paramMagicfaceData;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.3(this, paramString, paramInt));
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.4(this, paramString, paramBoolean));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.b();
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.2(this, paramString));
    }
  }
  
  protected void c() {}
  
  protected void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.5(this, paramString));
    }
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder
 * JD-Core Version:    0.7.0.1
 */