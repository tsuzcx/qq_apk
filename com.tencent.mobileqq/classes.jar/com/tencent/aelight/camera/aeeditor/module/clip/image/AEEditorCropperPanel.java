package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.List;

public class AEEditorCropperPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AEEditorCropperPanel.CropChangeCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback;
  private AEEditorCropperRatioButton jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton;
  private AEImageCropperContainer jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer;
  private List<AEEditorImageInfo> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AEEditorCropperRatioButton jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton;
  private int jdField_c_of_type_Int = 0;
  private AEEditorCropperRatioButton jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton;
  private AEEditorCropperRatioButton d;
  private AEEditorCropperRatioButton e;
  
  public AEEditorCropperPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorCropperPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorCropperPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(int paramInt1, int paramInt2, Rect paramRect)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    if (f1 * 1.0F / f2 <= (paramRect.right - paramRect.left) * 1.0F / (paramRect.bottom - paramRect.top)) {
      return (paramRect.right - paramRect.left) * 1.0F / f1;
    }
    return (paramRect.bottom - paramRect.top) * 1.0F / f2;
  }
  
  public static CropConfig a(int paramInt1, int paramInt2)
  {
    float f4 = paramInt1;
    float f1 = 1.0F;
    float f5 = paramInt2;
    double d1 = f4 * 1.0F / f5;
    float f3 = 0.0F;
    float f2 = 0.0F;
    if (d1 <= 0.333333343267441D)
    {
      f4 /= 0.3333333F;
      f2 = (f5 - f4) * 1.0F / 2.0F / f5;
      f4 = f4 * 1.0F / f5;
    }
    else
    {
      if (d1 >= 1.777777791023254D)
      {
        f1 = f5 * 1.777778F;
        f2 = (f4 - f1) * 1.0F / 2.0F / f4;
        f1 = f1 * 1.0F / f4;
      }
      f4 = 1.0F;
      f5 = 0.0F;
      f3 = f2;
      f2 = f5;
    }
    return new CropConfig(f3, f2, f1, f4);
  }
  
  private void a(int paramInt)
  {
    c();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.e.setChecked(true);
            return;
          }
          this.d.setChecked(true);
          return;
        }
        this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
        return;
      }
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = ((IQCircleImagePreviewUtil)QRoute.api(IQCircleImagePreviewUtil.class)).getTargetWidthAndHeight(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_Int, ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_b_of_type_Int);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString, i, j), (AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), paramInt1, paramInt2);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2064318566, this);
    paramContext.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer = ((AEImageCropperContainer)paramContext.findViewById(2064121930));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2064122076));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2064122077));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2064122156));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setText(getResources().getString(2064515160));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2064122157));
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setText("1 : 1");
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setBackImg(2064056536);
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton = ((AEEditorCropperRatioButton)paramContext.findViewById(2064122158));
    this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setText("3 : 4");
    this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setBackImg(2064056537);
    this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setOnClickListener(this);
    this.d = ((AEEditorCropperRatioButton)paramContext.findViewById(2064122159));
    this.d.setText("4 : 3");
    this.d.setBackImg(2064056538);
    this.d.setOnClickListener(this);
    this.e = ((AEEditorCropperRatioButton)paramContext.findViewById(2064122160));
    this.e.setText("16 : 9");
    this.e.setBackImg(2064056535);
    this.e.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(false);
    this.d.setChecked(false);
    this.e.setChecked(false);
  }
  
  public CropConfig a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt3 == 0) {
        return a(paramInt1, paramInt2);
      }
      Rect localRect = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a.a();
      if (localRect == null) {
        return a(paramInt1, paramInt2);
      }
      float f3 = a(paramInt1, paramInt2, localRect);
      float f1 = paramInt1 * f3;
      float f2 = (f1 - (localRect.right - localRect.left)) * 1.0F / 2.0F;
      f3 = paramInt2 * f3;
      float f4 = (f3 - (localRect.bottom - localRect.top)) * 1.0F / 2.0F;
      return new CropConfig(f2 / f1, f4 / f3, (localRect.right - localRect.left) * 1.0F / f1, (localRect.bottom - localRect.top) * 1.0F / f3);
    }
    return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a();
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(null);
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(this.jdField_c_of_type_Int);
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a());
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback;
    if (localObject != null) {
      ((AEEditorCropperPanel.CropChangeCallback)localObject).a();
    }
    if (this.jdField_c_of_type_Int != this.jdField_b_of_type_Int)
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (i == this.jdField_a_of_type_Int) {
          ((List)localObject).add(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentTavcutBeanCropConfig);
        } else {
          ((List)localObject).add(a(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int, ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int, this.jdField_c_of_type_Int));
        }
        i += 1;
      }
      if (((List)localObject).size() > 1)
      {
        AEEditorCropperPanel.CropChangeCallback localCropChangeCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback;
        if (localCropChangeCallback != null) {
          localCropChangeCallback.a(this.jdField_c_of_type_Int, (List)localObject);
        }
      }
    }
  }
  
  public void a(List<AEEditorImageInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer != null)
    {
      setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Int = paramInt1;
      paramInt1 = ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).a();
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt1;
      a(this.jdField_b_of_type_Int);
      a(paramInt2, paramInt3);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        return;
      case 2064122160: 
        this.jdField_c_of_type_Int = 4;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
        c();
        this.e.setChecked(true);
        AEReportUtils.a(1, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
        return;
      case 2064122159: 
        this.jdField_c_of_type_Int = 3;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
        c();
        this.d.setChecked(true);
        AEReportUtils.a(1, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
        return;
      case 2064122158: 
        this.jdField_c_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
        c();
        this.jdField_c_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
        AEReportUtils.a(1, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
        return;
      case 2064122157: 
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
        c();
        this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
        AEReportUtils.a(1, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
        return;
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.setRatioType(this.jdField_c_of_type_Int);
      c();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperRatioButton.setChecked(true);
      AEReportUtils.a(1, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
      return;
    case 2064122077: 
      a();
      AEReportUtils.a(3, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback;
    if (paramView != null) {
      paramView.b();
    }
    AEReportUtils.a(2, AEImageCropperContainer.a(this.jdField_c_of_type_Int));
  }
  
  public void setCropChangeCallBack(AEEditorCropperPanel.CropChangeCallback paramCropChangeCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel$CropChangeCallback = paramCropChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorCropperPanel
 * JD-Core Version:    0.7.0.1
 */