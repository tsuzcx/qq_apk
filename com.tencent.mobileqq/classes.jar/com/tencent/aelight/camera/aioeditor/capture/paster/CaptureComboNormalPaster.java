package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CaptureComboNormalPaster
  extends CaptureComboBase
  implements IEventReceiver
{
  public static HashMap<String, Drawable> h = new HashMap();
  NormalFacePackage f;
  int g = 2;
  private final String i;
  private float j;
  private float k;
  private float l;
  private String m;
  private CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver n;
  
  public CaptureComboNormalPaster(NormalFacePackage paramNormalFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.i = paramString1;
    this.m = paramString2;
    this.f = paramNormalFacePackage;
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = paramFloat3;
    if (QLog.isColorLevel())
    {
      paramNormalFacePackage = new StringBuilder();
      paramNormalFacePackage.append("create id=");
      paramNormalFacePackage.append(paramString1);
      paramNormalFacePackage.append(" name=");
      paramNormalFacePackage.append(paramString2);
      QLog.d("QComboNPaster", 2, paramNormalFacePackage.toString());
    }
  }
  
  private static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    new File(paramString).getName();
    URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
    if (localURLDrawable != null)
    {
      int i1 = localURLDrawable.getStatus();
      if (i1 != 1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("urlDrawable is not  SUCCESSED :");
          localStringBuilder.append(i1);
          QLog.e("QComboNPaster", 2, localStringBuilder.toString());
        }
        localURLDrawable.setURLDrawableListener(paramURLDrawableListener);
        if (i1 == 2) {
          localURLDrawable.restartDownload();
        } else {
          localURLDrawable.startDownload();
        }
        h.put(paramString, localURLDrawable);
      }
      else
      {
        return localURLDrawable;
      }
    }
    return null;
  }
  
  public static void a(NormalFacePackage paramNormalFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener)
  {
    int i1;
    if (paramIFaceSelectedListener != null)
    {
      i1 = paramNormalFacePackage.c(paramString);
      paramString = paramNormalFacePackage.b(paramString);
      if (!TextUtils.isEmpty(paramString)) {}
    }
    try
    {
      FileUtils.e(paramNormalFacePackage.l);
      label33:
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
      }
      return;
      paramString = Uri.parse(paramString).getPath();
      String str = new File(paramString).getName();
      CaptureComboNormalPaster.2 local2 = new CaptureComboNormalPaster.2(str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i1);
      if (i1 != 1) {
        try
        {
          b(Drawable.createFromPath(paramString), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i1);
          return;
        }
        catch (OutOfMemoryError paramNormalFacePackage)
        {
          SLog.c("QComboNPaster", "createFromPath error", paramNormalFacePackage);
          return;
        }
      }
      Object localObject = new File(paramString);
      try
      {
        if (!ApngDrawable.isApngFile((File)localObject))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("applyNormalPaster isApngFile not valid path=");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("QComboNPaster", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        b(a(paramString, local2), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i1);
        return;
      }
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    catch (Exception paramNormalFacePackage)
    {
      break label33;
    }
  }
  
  private static void b(Drawable paramDrawable, String paramString1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener, int paramInt3)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      int i1 = paramDrawable.getIntrinsicWidth();
      float f1 = paramInt1;
      paramFloat3 = f1 * paramFloat3 / i1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("applyNormalPaster w=");
        localStringBuilder.append(i1);
        localStringBuilder.append(" scale=");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append(" px=");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(" py=");
        localStringBuilder.append(paramFloat2);
        QLog.d("QComboNPaster", 2, localStringBuilder.toString());
      }
      paramIFaceSelectedListener.a(new SelectedItem(paramNormalFacePackage.b, paramString1, paramDrawable, paramInt3), f1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, paramString2, paramSegmentKeeper);
      return;
    }
    paramDrawable = new StringBuilder();
    paramDrawable.append("can not create drawable from name:");
    paramDrawable.append(paramString1);
    SLog.e("QComboNPaster", paramDrawable.toString());
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this.f.m == null) || (this.f.m.size() == 0))
    {
      paramActivity = this.f;
      paramActivity.a(paramActivity.e());
    }
    ThreadManager.excute(new CaptureComboNormalPaster.1(this, paramInt), 64, null, true);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("apply id=");
      paramActivity.append(this.i);
      paramActivity.append(" name=");
      paramActivity.append(this.m);
      QLog.d("QComboNPaster", 2, paramActivity.toString());
    }
    return 0;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if ((this.f.m == null) || (this.f.m.size() == 0))
    {
      paramActivity = this.f;
      paramActivity.a(paramActivity.e());
    }
    paramActivity = this.f.b(this.m);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unApply id=");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(" name=");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("url=");
      ((StringBuilder)localObject).append(paramActivity);
      QLog.d("QComboNPaster", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramActivity)) {
      return;
    }
    try
    {
      paramActivity = new File(Uri.parse(paramActivity).getPath()).getName();
      localObject = DoodleLayoutConnector.a().b(paramInt);
      if (localObject != null)
      {
        ((DoodleLayout)localObject).getFaceSelectedListener().a(this.f.b, paramActivity);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public int c()
  {
    try
    {
      if (!StringUtil.isEmpty(this.f.l)) {
        this.g = 3;
      } else if (this.f.n) {
        this.g = 1;
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
      ((DoodleEmojiManager)QIMManager.a(14)).a(this.i, false);
      a();
      Object localObject1 = StoryDispatcher.a();
      CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver localDoodleEmojiDownloadEventReceiver = new CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver(this);
      this.n = localDoodleEmojiDownloadEventReceiver;
      ((Dispatcher)localObject1).registerSubscriber(localDoodleEmojiDownloadEventReceiver);
      this.g = 1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create mState=");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append(" id=");
        ((StringBuilder)localObject1).append(this.i);
        QLog.d("QComboNPaster", 2, ((StringBuilder)localObject1).toString());
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
      if (!StringUtil.isEmpty(this.f.l))
      {
        c();
        return 1.0F;
      }
      if ((this.f.o != 100.0F) && (this.f.o > 0.0F))
      {
        float f1 = this.f.p;
        int i1 = this.f.o;
        f1 = f1 * 1.0F / i1;
        return f1;
      }
      return 0.0F;
    }
    finally {}
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster
 * JD-Core Version:    0.7.0.1
 */