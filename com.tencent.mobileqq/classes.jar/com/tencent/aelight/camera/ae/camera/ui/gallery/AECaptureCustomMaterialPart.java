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
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
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
  private static final String jdField_a_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  @NonNull
  private View jdField_a_of_type_AndroidViewView;
  @NonNull
  private final AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = AECaptureMode.NORMAL;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private final HashMap<String, AECaptureCustomMaterialPart.MaterialConfigWrapper> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  @Nullable
  private View c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.CACHE.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/temp_store_file.png");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public AECaptureCustomMaterialPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    a();
    b();
  }
  
  private int a()
  {
    View localView = this.c;
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  private Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new BitmapFactory.Options();
    int i2 = 1;
    int m = 1;
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int n = ((BitmapFactory.Options)localObject1).outWidth;
    int i1 = ((BitmapFactory.Options)localObject1).outHeight;
    if ((n > 0) && (i1 > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start decode image of path: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", width = ");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(", height = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", targetWidth = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", targetHeight = ");
      ((StringBuilder)localObject2).append(paramInt2);
      AEQLog.a("AECaptureCustomMaterialPart", ((StringBuilder)localObject2).toString());
      float f1 = n / i1;
      int i;
      int j;
      int k;
      if (f1 > 2.0F)
      {
        i = i1 * 2;
        j = i1;
        k = 1;
      }
      else if (f1 < 0.5F)
      {
        j = n * 2;
        k = 1;
        i = n;
      }
      else
      {
        i = n;
        j = i1;
        k = 0;
      }
      if ((i > paramInt1) || (j > paramInt2))
      {
        int i3 = i / 2;
        int i4 = j / 2;
        for (;;)
        {
          f1 = i3;
          float f2 = m;
          i2 = m;
          if (f1 / f2 <= paramInt1 * 0.65F) {
            break;
          }
          i2 = m;
          if (i4 / f2 <= paramInt2 * 0.65F) {
            break;
          }
          m *= 2;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode image: inSampleSize = ");
      ((StringBuilder)localObject2).append(i2);
      AEQLog.a("AECaptureCustomMaterialPart", ((StringBuilder)localObject2).toString());
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject1).inSampleSize = i2;
      if (k != 0) {
        try
        {
          localObject2 = new Rect((n - i) / 2, (i1 - j) / 2, (n + i) / 2, (i1 + j) / 2);
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
  
  private void a()
  {
    int i = ParamsUtil.a();
    if (i < 3)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[0] = 1024;
      arrayOfInt[1] = 576;
      return;
    }
    if (i < 5)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[0] = 1280;
      arrayOfInt[1] = 720;
      return;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[0] = 1920;
    arrayOfInt[1] = 1080;
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      b(paramFloat);
    }
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().a(null);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    boolean bool = false;
    if ((localObject != null) && (localObject != AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))
    {
      localObject = (AECaptureCustomMaterialPart.MaterialConfigWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
      if (localObject != null)
      {
        if (((AECaptureCustomMaterialPart.MaterialConfigWrapper)localObject).a != null) {
          bool = true;
        }
        a(bool);
        return;
      }
      ThreadManager.getFileThreadHandler().post(new AECaptureCustomMaterialPart.4(this, paramAEMaterialMetaData));
      return;
    }
    a(false);
  }
  
  private void a(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AECaptureCustomMaterialPart.3(this, paramString));
  }
  
  @MainThread
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f();
      return;
    }
    e();
  }
  
  private boolean a()
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.l();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    bool1 = bool2;
    if (localObject != null)
    {
      if (localObject == AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData) {
        return false;
      }
      localObject = (AECaptureCustomMaterialPart.MaterialConfigWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
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
    File localFile = new File(AEPath.CAMERA.CACHE.jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void b(float paramFloat)
  {
    d();
    View localView = this.jdField_b_of_type_AndroidViewView;
    float f;
    if (localView != null) {
      f = Math.max(0.0F, localView.getTop() + a() - this.jdField_a_of_type_AndroidViewView.getBottom());
    } else {
      f = paramFloat;
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationY(Math.min(paramFloat, f));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AECaptureCustomMaterialPart.2(this));
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2064122228);
    }
    if (this.c == null)
    {
      Object localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        localObject = (AbsAECaptureButton)((View)localObject).findViewById(2064122025);
        if ((localObject instanceof AEPituCameraCaptureButtonLayout))
        {
          this.c = ((AEPituCameraCaptureButtonLayout)localObject).jdField_b_of_type_AndroidViewView;
          return;
        }
        if ((localObject instanceof QIMCameraCaptureButtonLayoutNew)) {
          this.c = ((QIMCameraCaptureButtonLayoutNew)localObject).jdField_b_of_type_AndroidViewView;
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    h();
  }
  
  private void f()
  {
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    g();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.animate().alpha(1.0F).setDuration(200L).setListener(null);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(200L).setListener(new AECaptureCustomMaterialPart.5(this));
  }
  
  protected void initView()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.l()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = ((ViewStub)this.mRootView.findViewById(2064122662)).inflate();
    this.jdField_a_of_type_AndroidViewView.findViewById(2064121995).setOnClickListener(new AECaptureCustomMaterialPart.1(this));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    c();
    d();
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
        this.jdField_a_of_type_Int = ((Integer)paramVarArgs.get(0)).intValue();
        this.jdField_b_of_type_Int = ((Integer)paramVarArgs.get(1)).intValue();
        if (ParamsUtil.a() < 3)
        {
          paramInt = this.jdField_a_of_type_Int;
          if (paramInt < this.jdField_b_of_type_Int)
          {
            this.jdField_a_of_type_Int = Math.min(paramInt, this.jdField_a_of_type_ArrayOfInt[1]);
            this.jdField_b_of_type_Int = Math.min(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0]);
            return;
          }
          this.jdField_a_of_type_Int = Math.min(paramInt, this.jdField_a_of_type_ArrayOfInt[0]);
          this.jdField_b_of_type_Int = Math.min(this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[1]);
          return;
        }
      }
      break;
    case 851972: 
      e();
      return;
    case 851971: 
      f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart
 * JD-Core Version:    0.7.0.1
 */