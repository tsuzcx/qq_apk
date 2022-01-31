package com.tencent.gdtad.views.image;

import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import qrj;
import qrk;

public class GdtDrawableLoader
{
  private int jdField_a_of_type_Int;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private URL jdField_a_of_type_JavaNetURL;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtDrawableLoader(String paramString, WeakReference paramWeakReference)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      return;
    }
    catch (MalformedURLException paramWeakReference)
    {
      GdtLog.d("GdtDrawableLoader", "GdtDrawableLoader error " + paramString, paramWeakReference);
    }
  }
  
  private URLDrawable.URLDrawableListener a()
  {
    return new qrj(this);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getURL() != null)) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    }
    if (b()) {
      return this.jdField_a_of_type_JavaNetURL.toString();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    GdtLog.b("GdtDrawableLoader", "notify " + paramBoolean + " " + a());
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean)
    {
      ((GdtDrawableLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    ((GdtDrawableLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  private boolean a()
  {
    if ((!b()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (this.jdField_a_of_type_Int >= 3)) {
      return false;
    }
    GdtLog.b("GdtDrawableLoader", "retry " + a());
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    return true;
  }
  
  private void b()
  {
    int j = 1;
    if ((!b()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
      GdtLog.b("GdtDrawableLoader", "update error " + a());
    }
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)
      {
        GdtLog.b("GdtDrawableLoader", "drawable status is loading " + a());
        i = j;
        if (!this.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted())
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
          i = j;
        }
      }
      while ((i != 0) && (!this.jdField_a_of_type_Boolean))
      {
        new Handler(Looper.getMainLooper()).postDelayed(new qrk(this), 100L);
        return;
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4)
        {
          GdtLog.b("GdtDrawableLoader", "drawable status is file downloaded " + a());
          i = j;
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
        {
          GdtLog.b("GdtDrawableLoader", "drawable status is successed " + a());
          a(true);
          i = 0;
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
        {
          GdtLog.d("GdtDrawableLoader", "drawable status is failed " + a());
          i = j;
          if (!a())
          {
            a(false);
            i = 0;
          }
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3)
        {
          GdtLog.d("GdtDrawableLoader", "drawable status is cancled " + a());
          a(false);
          i = 0;
        }
        else
        {
          GdtLog.d("GdtDrawableLoader", "drawable status is " + this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() + " " + a());
          i = 0;
        }
      }
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaNetURL != null;
  }
  
  public URLDrawable a()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public void a()
  {
    if (!b())
    {
      GdtLog.d("GdtDrawableLoader", "load error");
      return;
    }
    GdtLog.b("GdtDrawableLoader", "load " + a());
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaNetURL, URLDrawable.URLDrawableOptions.obtain());
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      GdtLog.d("GdtDrawableLoader", "load error " + a());
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(a());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtDrawableLoader
 * JD-Core Version:    0.7.0.1
 */