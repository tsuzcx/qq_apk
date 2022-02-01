package com.tencent.gdtad.views.image;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class GdtDrawableLoader
{
  private int jdField_a_of_type_Int = 0;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private WeakReference<GdtDrawableLoader.Listener> jdField_a_of_type_JavaLangRefWeakReference;
  private URL jdField_a_of_type_JavaNetURL;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GdtDrawableLoader(String paramString, WeakReference<GdtDrawableLoader.Listener> paramWeakReference)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaNetURL = new URL(paramString);
        this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        return;
      }
    }
    catch (MalformedURLException paramWeakReference)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GdtDrawableLoader error ");
      localStringBuilder.append(paramString);
      GdtLog.d("GdtDrawableLoader", localStringBuilder.toString(), paramWeakReference);
    }
  }
  
  private URLDrawable.URLDrawableListener a()
  {
    return new GdtDrawableLoader.1(this);
  }
  
  private String a()
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localURLDrawable != null) && (localURLDrawable.getURL() != null)) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    }
    if (b()) {
      return this.jdField_a_of_type_JavaNetURL.toString();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notify ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(a());
        GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_Boolean = true;
        if (paramBoolean)
        {
          ((GdtDrawableLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentImageURLDrawable);
          return;
        }
        ((GdtDrawableLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
  
  private boolean a()
  {
    if ((b()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_Int < 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry ");
      localStringBuilder.append(a());
      GdtLog.b("GdtDrawableLoader", localStringBuilder.toString());
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (b())
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null)
      {
        int j = ((URLDrawable)localObject).getStatus();
        int i = 0;
        if (j == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is loading ");
          ((StringBuilder)localObject).append(a());
          GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          if (!this.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
            this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
          }
        }
        do
        {
          for (;;)
          {
            i = 1;
            break label351;
            if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 4) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("drawable status is file downloaded ");
            ((StringBuilder)localObject).append(a());
            GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          }
          if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("drawable status is successed ");
            ((StringBuilder)localObject).append(a());
            GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
            a(true);
            break label351;
          }
          if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is failed ");
          ((StringBuilder)localObject).append(a());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        } while (a());
        a(false);
        break label351;
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is cancled ");
          ((StringBuilder)localObject).append(a());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
          a(false);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable status is ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(a());
          GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
        }
        label351:
        if ((i != 0) && (!this.jdField_a_of_type_Boolean)) {
          new Handler(Looper.getMainLooper()).postDelayed(new GdtDrawableLoader.2(this), 100L);
        }
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update error ");
    ((StringBuilder)localObject).append(a());
    GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load ");
    ((StringBuilder)localObject).append(a());
    GdtLog.b("GdtDrawableLoader", ((StringBuilder)localObject).toString());
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaNetURL, (URLDrawable.URLDrawableOptions)localObject);
    localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load error ");
      ((StringBuilder)localObject).append(a());
      GdtLog.d("GdtDrawableLoader", ((StringBuilder)localObject).toString());
      return;
    }
    ((URLDrawable)localObject).setURLDrawableListener(a());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtDrawableLoader
 * JD-Core Version:    0.7.0.1
 */