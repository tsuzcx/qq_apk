package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;

public class CaptureComboLocationPaster
  extends CaptureComboBase
  implements URLDrawable.URLDrawableListener
{
  LocationFacePackage f;
  int g = 0;
  String h;
  int i = 2;
  URLDrawable j;
  private final String k;
  private final float l;
  private final float m;
  private final float n;
  
  public CaptureComboLocationPaster(LocationFacePackage paramLocationFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.k = paramString1;
    this.h = paramString2;
    this.f = paramLocationFacePackage;
    this.l = paramFloat1;
    this.m = paramFloat2;
    this.n = paramFloat3;
    if (QLog.isColorLevel())
    {
      paramLocationFacePackage = new StringBuilder();
      paramLocationFacePackage.append("create id=");
      paramLocationFacePackage.append(paramString1);
      paramLocationFacePackage.append(" name=");
      paramLocationFacePackage.append(paramString2);
      QLog.d("QCombo.LPaster", 2, paramLocationFacePackage.toString());
    }
  }
  
  private URLDrawable g()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
    LocationFacePackage.Item localItem = this.f.b(this.h);
    if (localItem != null) {
      return URLDrawable.getDrawable(localItem.d, (URLDrawable.URLDrawableOptions)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createUrlDrawable no item =");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("QCombo.LPaster", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = DoodleLayoutConnector.a().b(paramInt);
    if (paramActivity != null)
    {
      a(this.f, this.h, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, this.l, this.m, this.n, paramActivity.getFaceSelectedListener());
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("apply id=");
        paramActivity.append(this.k);
        paramActivity.append(" name=");
        paramActivity.append(this.h);
        paramActivity.append(" state=");
        paramActivity.append(this.i);
        QLog.d("QCombo.LPaster", 2, paramActivity.toString());
      }
    }
    return 0;
  }
  
  public void a(LocationFacePackage paramLocationFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (paramIFaceSelectedListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "try apply but no listener");
      }
      return;
    }
    paramLocationFacePackage = this.j;
    if (paramLocationFacePackage != null)
    {
      paramLocationFacePackage.setBounds(0, 0, paramLocationFacePackage.getIntrinsicWidth(), paramLocationFacePackage.getIntrinsicHeight());
      paramString = this.f.b(this.h);
      if (paramString != null)
      {
        paramString.e = paramLocationFacePackage;
        paramIFaceSelectedListener.a(paramString, paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, this.d);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramLocationFacePackage = new StringBuilder();
        paramLocationFacePackage.append("applyLocationPaster no item =");
        paramLocationFacePackage.append(this.h);
        QLog.d("QCombo.LPaster", 2, paramLocationFacePackage.toString());
      }
    }
    else
    {
      paramLocationFacePackage = new StringBuilder();
      paramLocationFacePackage.append("can create drawable from urldrawable:");
      paramLocationFacePackage.append(this.j);
      SLog.e("QCombo.LPaster", paramLocationFacePackage.toString());
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    paramActivity = this.f.b(this.h);
    if (paramActivity != null)
    {
      DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().b(paramInt);
      if (localDoodleLayout != null) {
        localDoodleLayout.getFaceSelectedListener().a(this.f.b, paramActivity.c);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply no item =");
      paramActivity.append(this.h);
      QLog.d("QCombo.LPaster", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("apply id=");
      paramActivity.append(this.k);
      paramActivity.append(" name=");
      paramActivity.append(this.h);
      paramActivity.append(" state=");
      paramActivity.append(this.i);
      QLog.d("QCombo.LPaster", 2, paramActivity.toString());
    }
  }
  
  public int c()
  {
    try
    {
      if (this.j == null) {
        this.j = g();
      }
      if (this.j != null)
      {
        if (this.i != 3)
        {
          Object localObject1 = this.f.b(this.h);
          if (localObject1 != null)
          {
            if (AbsDownloader.getFile(((LocationFacePackage.Item)localObject1).d) == null)
            {
              this.i = 2;
            }
            else
            {
              this.i = 3;
              this.j.startDownload();
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getState no item =");
            ((StringBuilder)localObject1).append(this.h);
            QLog.d("QCombo.LPaster", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      else {
        this.i = 2;
      }
      int i1 = this.i;
      return i1;
    }
    finally {}
  }
  
  public int d()
  {
    try
    {
      if (this.j == null) {
        this.j = g();
      }
      if (this.j != null)
      {
        if (this.j.getStatus() == 1)
        {
          this.i = 3;
          this.g = 100;
        }
        else
        {
          this.j.startDownload();
          this.j.setURLDrawableListener(this);
          this.i = 1;
          this.g = 0;
          a();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download id=");
          localStringBuilder.append(this.k);
          localStringBuilder.append(" name=");
          localStringBuilder.append(this.h);
          localStringBuilder.append(" dstate=");
          localStringBuilder.append(this.j.getStatus());
          QLog.d("QCombo.LPaster", 2, localStringBuilder.toString());
        }
      }
      int i1 = this.i;
      return i1;
    }
    finally {}
  }
  
  public float e()
  {
    return 1.0F;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.g = 0;
    this.i = 2;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.g = 0;
    this.i = 2;
    a(4);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.g = paramInt;
    this.i = 1;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.g = 100;
    this.i = 3;
    b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LP@");
    localStringBuilder.append(this.k);
    localStringBuilder.append("@");
    localStringBuilder.append(this.h);
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboLocationPaster
 * JD-Core Version:    0.7.0.1
 */