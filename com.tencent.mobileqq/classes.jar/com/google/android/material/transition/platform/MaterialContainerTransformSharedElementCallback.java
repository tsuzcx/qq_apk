package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R.id;
import com.google.android.material.internal.ContextUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback
  extends SharedElementCallback
{
  @Nullable
  private static WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  @Nullable
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private MaterialContainerTransformSharedElementCallback.ShapeProvider jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransformSharedElementCallback$ShapeProvider = new MaterialContainerTransformSharedElementCallback.ShapeableViewShapeProvider();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  private boolean c = false;
  
  private void a(Activity paramActivity, Window paramWindow)
  {
    Object localObject = paramWindow.getSharedElementReturnTransition();
    if ((localObject instanceof MaterialContainerTransform))
    {
      localObject = (MaterialContainerTransform)localObject;
      ((MaterialContainerTransform)localObject).a(true);
      ((MaterialContainerTransform)localObject).addListener(new MaterialContainerTransformSharedElementCallback.2(this, paramActivity));
      if (this.b)
      {
        a(paramWindow, (MaterialContainerTransform)localObject);
        ((MaterialContainerTransform)localObject).addListener(new MaterialContainerTransformSharedElementCallback.3(this, paramWindow));
      }
    }
  }
  
  private static void a(Window paramWindow, MaterialContainerTransform paramMaterialContainerTransform)
  {
    paramWindow.setTransitionBackgroundFadeDuration(paramMaterialContainerTransform.getDuration());
  }
  
  private void c(Window paramWindow)
  {
    Object localObject = paramWindow.getSharedElementEnterTransition();
    if ((localObject instanceof MaterialContainerTransform))
    {
      localObject = (MaterialContainerTransform)localObject;
      if (!this.c) {
        paramWindow.setSharedElementReenterTransition(null);
      }
      if (this.b)
      {
        a(paramWindow, (MaterialContainerTransform)localObject);
        ((MaterialContainerTransform)localObject).addListener(new MaterialContainerTransformSharedElementCallback.1(this, paramWindow));
      }
    }
  }
  
  private static void d(Window paramWindow)
  {
    paramWindow.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
  }
  
  private static void e(Window paramWindow)
  {
    paramWindow.getDecorView().getBackground().mutate().clearColorFilter();
  }
  
  @Nullable
  public Parcelable onCaptureSharedElementSnapshot(@NonNull View paramView, @NonNull Matrix paramMatrix, @NonNull RectF paramRectF)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    return super.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  @Nullable
  public View onCreateSnapshotView(@NonNull Context paramContext, @Nullable Parcelable paramParcelable)
  {
    paramContext = super.onCreateSnapshotView(paramContext, paramParcelable);
    if (paramContext != null)
    {
      paramParcelable = jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramParcelable != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransformSharedElementCallback$ShapeProvider != null))
      {
        paramParcelable = (View)paramParcelable.get();
        if (paramParcelable != null)
        {
          paramParcelable = this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransformSharedElementCallback$ShapeProvider.a(paramParcelable);
          if (paramParcelable != null) {
            paramContext.setTag(R.id.R, paramParcelable);
          }
        }
      }
    }
    return paramContext;
  }
  
  public void onMapSharedElements(@NonNull List<String> paramList, @NonNull Map<String, View> paramMap)
  {
    if ((!paramList.isEmpty()) && (!paramMap.isEmpty()))
    {
      paramList = (View)paramMap.get(paramList.get(0));
      if (paramList != null)
      {
        paramList = ContextUtils.a(paramList.getContext());
        if (paramList != null)
        {
          paramMap = paramList.getWindow();
          if (this.jdField_a_of_type_Boolean)
          {
            c(paramMap);
            return;
          }
          a(paramList, paramMap);
        }
      }
    }
  }
  
  public void onSharedElementEnd(@NonNull List<String> paramList, @NonNull List<View> paramList1, @NonNull List<View> paramList2)
  {
    if ((!paramList1.isEmpty()) && ((((View)paramList1.get(0)).getTag(R.id.R) instanceof View))) {
      ((View)paramList1.get(0)).setTag(R.id.R, null);
    }
    if ((!this.jdField_a_of_type_Boolean) && (!paramList1.isEmpty())) {
      this.jdField_a_of_type_AndroidGraphicsRect = TransitionUtils.a((View)paramList1.get(0));
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onSharedElementStart(@NonNull List<String> paramList, @NonNull List<View> paramList1, @NonNull List<View> paramList2)
  {
    if ((!paramList1.isEmpty()) && (!paramList2.isEmpty())) {
      ((View)paramList1.get(0)).setTag(R.id.R, paramList2.get(0));
    }
    if ((!this.jdField_a_of_type_Boolean) && (!paramList1.isEmpty()) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      paramList = (View)paramList1.get(0);
      paramList.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidGraphicsRect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidGraphicsRect.height(), 1073741824));
      paramList.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
 * JD-Core Version:    0.7.0.1
 */