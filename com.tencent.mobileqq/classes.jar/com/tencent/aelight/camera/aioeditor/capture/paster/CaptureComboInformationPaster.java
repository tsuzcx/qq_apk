package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.InformationPasterChangeListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

public class CaptureComboInformationPaster
  extends CaptureComboBase
  implements InformationFacePackage.InformationPasterChangeListener, IEventReceiver
{
  public static HashMap<String, Drawable> h = new HashMap();
  InformationFacePackage f;
  int g = 2;
  private final String i;
  private float j;
  private String k;
  private QIMInformationPasterManager l;
  private InformationFacePackage.Item m;
  private CaptureComboInformationPaster.DownloadProgressCallback n;
  private float o;
  private float p;
  private String q;
  private String r;
  
  public CaptureComboInformationPaster(InformationFacePackage paramInformationFacePackage, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.i = paramString2;
    this.f = paramInformationFacePackage;
    this.j = paramFloat3;
    this.k = paramString3;
    this.o = paramFloat1;
    this.p = paramFloat2;
    this.l = ((QIMInformationPasterManager)QIMManager.a().d(12));
    this.m = this.f.b(paramString3);
    this.q = paramString1;
    paramInformationFacePackage = this.m;
    if (paramInformationFacePackage != null)
    {
      paramInformationFacePackage.a(this);
      paramInformationFacePackage = new StringBuilder();
      paramInformationFacePackage.append("CaptureComboInformationPaster_");
      paramInformationFacePackage.append(this.m.b);
      paramInformationFacePackage.append("_");
      paramInformationFacePackage.append(this.m.a);
      this.r = paramInformationFacePackage.toString();
    }
    if (QLog.isColorLevel())
    {
      paramInformationFacePackage = new StringBuilder();
      paramInformationFacePackage.append("package id=");
      paramInformationFacePackage.append(paramString2);
      paramInformationFacePackage.append(" posterId=");
      paramInformationFacePackage.append(paramString3);
      QLog.d("CaptureComboInformationPaster", 2, paramInformationFacePackage.toString());
    }
  }
  
  private void a(Drawable paramDrawable, String paramString, int paramInt, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyApngInfoPaster w=");
      localStringBuilder.append(paramDrawable.getIntrinsicWidth());
      localStringBuilder.append(" px=");
      localStringBuilder.append(this.o);
      localStringBuilder.append(" py=");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" scale=");
      localStringBuilder.append(this.j);
      QLog.d("CaptureComboInformationPaster", 2, localStringBuilder.toString());
    }
    paramDrawable = new SelectedItem(this.f.b, this.r, paramDrawable, paramInt);
    paramInt = ScreenUtil.SCREEN_WIDTH;
    int i1 = ScreenUtil.SCREEN_HIGHT;
    paramIFaceSelectedListener.b(paramDrawable, paramInt * this.o, i1 * this.p, this.j, paramString, this.d);
  }
  
  private void a(InformationFacePackage.Item paramItem, IFaceSelectedListener paramIFaceSelectedListener)
  {
    Object localObject1 = InfoStickerSaveUtils.b(paramItem);
    int i1;
    if (paramItem.c == 8)
    {
      int i2 = Calendar.getInstance().get(7) - 1;
      i1 = i2;
      if (i2 == 0) {
        i1 = 7;
      }
      paramItem = new StringBuilder();
      paramItem.append((String)localObject1);
      paramItem.append(File.separator);
      paramItem.append(i1);
      paramItem.append(".apng");
      paramItem = paramItem.toString();
    }
    else
    {
      paramItem = new StringBuilder();
      paramItem.append((String)localObject1);
      paramItem.append(File.separator);
      paramItem.append("city");
      paramItem.append(".apng");
      paramItem = paramItem.toString();
    }
    Object localObject3 = null;
    localObject1 = new File(paramItem);
    try
    {
      if (!ApngDrawable.isApngFile((File)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("applyNormalPaster isApngFile not valid path=");
          ((StringBuilder)localObject1).append(paramItem);
          QLog.d("CaptureComboInformationPaster", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramItem, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      Object localObject2 = localObject3;
      if (localURLDrawable != null)
      {
        i1 = localURLDrawable.getStatus();
        if (i1 != 1)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("urlDrawable is not  SUCCESSED :");
            ((StringBuilder)localObject2).append(i1);
            QLog.e("CaptureComboInformationPaster", 2, ((StringBuilder)localObject2).toString());
          }
          localURLDrawable.setURLDrawableListener(new CaptureComboInformationPaster.2(this, paramItem, localURLDrawable, paramIFaceSelectedListener));
          h.put(paramItem, localURLDrawable);
          if (i1 == 2)
          {
            localURLDrawable.restartDownload();
            localObject2 = localObject3;
          }
          else
          {
            localURLDrawable.startDownload();
            localObject2 = localObject3;
          }
        }
        else
        {
          localObject2 = localURLDrawable;
        }
      }
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        a((Drawable)localObject2, paramItem, 1, paramIFaceSelectedListener);
        return;
      }
      paramItem = new StringBuilder();
      paramItem.append("can not create drawable from name:");
      paramItem.append(this.f.b);
      SLog.e("CaptureComboInformationPaster", paramItem.toString());
    }
  }
  
  private void a(DoodleLayout paramDoodleLayout, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (this.m.c == 8)
    {
      if (paramDoodleLayout != null) {
        ThreadManager.excute(new CaptureComboInformationPaster.1(this, paramIFaceSelectedListener), 16, null, true);
      }
    }
    else
    {
      int i1 = ScreenUtil.SCREEN_WIDTH;
      int i2 = ScreenUtil.SCREEN_HIGHT;
      paramIFaceSelectedListener.a(this.m, this.r, i1 * this.o, i2 * this.p, this.j);
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = DoodleLayoutConnector.a().b(paramInt);
    if ((paramActivity != null) && (this.m != null))
    {
      IFaceSelectedListener localIFaceSelectedListener = paramActivity.getFaceSelectedListener();
      if (localIFaceSelectedListener != null)
      {
        a(paramActivity, localIFaceSelectedListener);
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("apply id=");
          paramActivity.append(this.i);
          paramActivity.append(" name=");
          paramActivity.append(this.k);
          paramActivity.append(" state=");
          paramActivity.append(this.g);
          QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
        }
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    this.g = 2;
    super.a(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(0);
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if (this.m != null)
    {
      paramActivity = DoodleLayoutConnector.a().b(paramInt);
      if (paramActivity != null) {
        paramActivity.getFaceSelectedListener().a(this.f.b, this.r);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply no item =");
      paramActivity.append(this.k);
      QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("unApply id=");
      paramActivity.append(this.i);
      paramActivity.append(" name=");
      paramActivity.append(this.k);
      paramActivity.append(" state=");
      paramActivity.append(this.g);
      QLog.d("CaptureComboInformationPaster", 2, paramActivity.toString());
    }
  }
  
  public int c()
  {
    try
    {
      if (this.m != null) {
        if (this.l.a(this.m)) {
          this.g = 3;
        } else if (this.l.b(this.m)) {
          this.g = 1;
        } else {
          this.g = 2;
        }
      }
      int i1 = this.g;
      return i1;
    }
    finally {}
  }
  
  public int d()
  {
    try
    {
      if (this.m != null)
      {
        if (this.n == null) {
          this.n = new CaptureComboInformationPaster.DownloadProgressCallback(this);
        }
        this.l.a(this.m, this.n);
        a();
        this.g = 1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("create mState=");
          localStringBuilder.append(this.g);
          localStringBuilder.append(" id=");
          localStringBuilder.append(this.i);
          QLog.d("CaptureComboInformationPaster", 2, localStringBuilder.toString());
        }
      }
      else
      {
        a(4);
      }
      int i1 = this.g;
      return i1;
    }
    finally {}
  }
  
  public float e()
  {
    try
    {
      if (this.n != null)
      {
        float f1 = this.n.a();
        return f1;
      }
      return 1.0F;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((InformationFacePackage.Item)localObject).c != 7) {
        return;
      }
      localObject = (CaptureComboManager)QIMManager.a(5);
      ComboSet localComboSet = ((CaptureComboManager)localObject).a(this.q);
      if (localComboSet != null)
      {
        localComboSet.c();
        ((CaptureComboManager)localObject).a(localComboSet);
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.g == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NP@");
    localStringBuilder.append(this.i);
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboInformationPaster
 * JD-Core Version:    0.7.0.1
 */