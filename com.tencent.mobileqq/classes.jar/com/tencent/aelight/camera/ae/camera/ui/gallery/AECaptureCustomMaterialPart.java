package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.CACHE;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AECaptureCustomMaterialPart
  extends VideoStoryBasePart
{
  private static final String k;
  @NonNull
  private View a;
  @Nullable
  private View b;
  @Nullable
  private View c;
  @NonNull
  private final AEPituCameraUnit d;
  private AEVideoStoryCaptureModeViewModel e;
  private AEVideoStoryStateViewModel f;
  private AEBottomPanelViewModel g;
  private AECaptureMode h = AECaptureMode.NORMAL;
  private AEMaterialMetaData i;
  private final HashMap<String, AECaptureCustomMaterialPart.MaterialConfigWrapper> j = new HashMap();
  private final int[] l = new int[2];
  private int m;
  private int n;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.CACHE.a);
    localStringBuilder.append("/temp_store_file.png");
    k = localStringBuilder.toString();
  }
  
  public AECaptureCustomMaterialPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.d = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    b();
    c();
  }
  
  private Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new BitmapFactory.Options();
    int i7 = 1;
    int i4 = 1;
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int i5 = ((BitmapFactory.Options)localObject1).outWidth;
    int i6 = ((BitmapFactory.Options)localObject1).outHeight;
    if ((i5 > 0) && (i6 > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start decode image of path: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", width = ");
      ((StringBuilder)localObject2).append(i5);
      ((StringBuilder)localObject2).append(", height = ");
      ((StringBuilder)localObject2).append(i6);
      ((StringBuilder)localObject2).append(", targetWidth = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", targetHeight = ");
      ((StringBuilder)localObject2).append(paramInt2);
      AEQLog.a("AECaptureCustomMaterialPart", ((StringBuilder)localObject2).toString());
      float f1 = i5 / i6;
      int i1;
      int i2;
      int i3;
      if (f1 > 2.0F)
      {
        i1 = i6 * 2;
        i2 = i6;
        i3 = 1;
      }
      else if (f1 < 0.5F)
      {
        i2 = i5 * 2;
        i3 = 1;
        i1 = i5;
      }
      else
      {
        i1 = i5;
        i2 = i6;
        i3 = 0;
      }
      if ((i1 > paramInt1) || (i2 > paramInt2))
      {
        int i8 = i1 / 2;
        int i9 = i2 / 2;
        for (;;)
        {
          f1 = i8;
          float f2 = i4;
          i7 = i4;
          if (f1 / f2 <= paramInt1 * 0.65F) {
            break;
          }
          i7 = i4;
          if (i9 / f2 <= paramInt2 * 0.65F) {
            break;
          }
          i4 *= 2;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode image: inSampleSize = ");
      ((StringBuilder)localObject2).append(i7);
      AEQLog.a("AECaptureCustomMaterialPart", ((StringBuilder)localObject2).toString());
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject1).inSampleSize = i7;
      if (i3 != 0) {
        try
        {
          localObject2 = new Rect((i5 - i1) / 2, (i6 - i2) / 2, (i5 + i1) / 2, (i6 + i2) / 2);
          localObject2 = BitmapRegionDecoder.newInstance(new FileInputStream(new File(paramString)), false).decodeRegion((Rect)localObject2, (BitmapFactory.Options)localObject1);
          return localObject2;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      return BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("decode image of path: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", failed");
    AEQLog.d("AECaptureCustomMaterialPart", ((StringBuilder)localObject1).toString());
    return null;
  }
  
  private void a(float paramFloat)
  {
    if (this.a.getVisibility() == 0) {
      b(paramFloat);
    }
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.d.am().a(null);
    this.i = paramAEMaterialMetaData;
    Object localObject = this.i;
    boolean bool = false;
    if ((localObject != null) && (localObject != AEMaterialMetaData.l))
    {
      localObject = (AECaptureCustomMaterialPart.MaterialConfigWrapper)this.j.get(this.i.m);
      if (localObject != null)
      {
        if (((AECaptureCustomMaterialPart.MaterialConfigWrapper)localObject).a != null) {
          bool = true;
        }
        a(bool);
        return;
      }
      ThreadManager.getFileThreadHandler().post(new AECaptureCustomMaterialPart.7(this, paramAEMaterialMetaData));
      return;
    }
    a(false);
  }
  
  private void a(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AECaptureCustomMaterialPart.6(this, paramString));
  }
  
  @MainThread
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      return;
    }
    f();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt3;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    float f4 = paramInt4;
    f2 = paramInt2;
    f3 = Math.min(f3, f4 / f2);
    paramInt1 = (int)(f1 * f3);
    paramInt2 = (int)(f2 * f3);
    return (paramInt1 < paramInt3) || (paramInt2 < paramInt4);
  }
  
  private void b()
  {
    int i1 = ParamsUtil.b();
    if (i1 < 3)
    {
      arrayOfInt = this.l;
      arrayOfInt[0] = 1024;
      arrayOfInt[1] = 576;
      return;
    }
    if (i1 < 5)
    {
      arrayOfInt = this.l;
      arrayOfInt[0] = 1280;
      arrayOfInt[1] = 720;
      return;
    }
    int[] arrayOfInt = this.l;
    arrayOfInt[0] = 1920;
    arrayOfInt[1] = 1080;
  }
  
  private void b(float paramFloat)
  {
    e();
    this.a.setTranslationY(Math.min(paramFloat, i()));
  }
  
  private void c()
  {
    File localFile = new File(AEPath.CAMERA.CACHE.a);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void d()
  {
    this.e = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryCaptureModeViewModel.class));
    this.f = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.d).get(AEVideoStoryStateViewModel.class));
    this.g = ((AEBottomPanelViewModel)AEViewModelProviders.a(this.d).get(AEBottomPanelViewModel.class));
    this.e.a.observe(this.d, new AECaptureCustomMaterialPart.2(this));
    this.f.a().observe(this.d, new AECaptureCustomMaterialPart.3(this));
    this.f.c().observe(this.d, new AECaptureCustomMaterialPart.4(this));
    this.g.a().observe(this.d, new AECaptureCustomMaterialPart.5(this));
  }
  
  private void e()
  {
    if (this.b == null) {
      this.b = this.mRootView.findViewById(2063991110);
    }
    if (this.c == null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = (AbsAECaptureButton)((View)localObject).findViewById(2063990959);
        if ((localObject instanceof AEPituCameraCaptureButtonLayout))
        {
          this.c = ((AEPituCameraCaptureButtonLayout)localObject).y;
          return;
        }
        if ((localObject instanceof QIMCameraCaptureButtonLayoutNew)) {
          this.c = ((QIMCameraCaptureButtonLayoutNew)localObject).e;
        }
      }
    }
  }
  
  private void f()
  {
    View localView = this.a;
    if (localView == null) {
      return;
    }
    if (localView.getVisibility() != 0) {
      return;
    }
    l();
  }
  
  private void g()
  {
    if (!h()) {
      return;
    }
    View localView = this.a;
    if (localView == null) {
      return;
    }
    if (localView.getVisibility() == 0) {
      return;
    }
    k();
  }
  
  private boolean h()
  {
    boolean bool1 = this.d.M();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (this.h != AECaptureMode.NORMAL) {
      return false;
    }
    Object localObject = this.i;
    bool1 = bool2;
    if (localObject != null)
    {
      if (localObject == AEMaterialMetaData.l) {
        return false;
      }
      localObject = (AECaptureCustomMaterialPart.MaterialConfigWrapper)this.j.get(this.i.m);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((AECaptureCustomMaterialPart.MaterialConfigWrapper)localObject).a != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private int i()
  {
    e();
    int i1 = this.a.getBottom();
    View localView = this.b;
    if (localView != null) {
      i1 = localView.getTop() + j();
    }
    return i1 - this.a.getBottom();
  }
  
  private int j()
  {
    View localView = this.c;
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  private void k()
  {
    this.a.setAlpha(0.0F);
    this.a.setVisibility(0);
    this.a.animate().alpha(1.0F).setDuration(200L).setListener(null);
  }
  
  private void l()
  {
    this.a.animate().alpha(0.0F).setDuration(200L).setListener(new AECaptureCustomMaterialPart.8(this));
  }
  
  protected void initView()
  {
    if (this.d.M()) {
      return;
    }
    d();
    this.a = ((ViewStub)this.mRootView.findViewById(2063991452)).inflate();
    this.a.findViewById(2063990923).setOnClickListener(new AECaptureCustomMaterialPart.1(this));
    this.a.setVisibility(8);
    d();
    e();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1027) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        a((String)paramIntent.get(0));
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 851973: 
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramVarArgs = (List)paramVarArgs[0];
        this.m = ((Integer)paramVarArgs.get(0)).intValue();
        this.n = ((Integer)paramVarArgs.get(1)).intValue();
        if (ParamsUtil.b() < 3)
        {
          paramInt = this.m;
          if (paramInt < this.n)
          {
            this.m = Math.min(paramInt, this.l[1]);
            this.n = Math.min(this.n, this.l[0]);
            return;
          }
          this.m = Math.min(paramInt, this.l[0]);
          this.n = Math.min(this.n, this.l[1]);
          return;
        }
      }
      break;
    case 851972: 
      f();
      return;
    case 851971: 
      g();
      return;
    case 851970: 
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        a((AEMaterialMetaData)paramVarArgs[0]);
        return;
      }
      break;
    case 851969: 
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof Float))) {
        a(((Float)paramVarArgs[0]).floatValue());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart
 * JD-Core Version:    0.7.0.1
 */