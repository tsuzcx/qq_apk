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
  private static WeakReference<View> a;
  private boolean b = true;
  private boolean c = true;
  private boolean d = false;
  @Nullable
  private Rect e;
  @Nullable
  private MaterialContainerTransformSharedElementCallback.ShapeProvider f = new MaterialContainerTransformSharedElementCallback.ShapeableViewShapeProvider();
  
  private void a(Activity paramActivity, Window paramWindow)
  {
    Object localObject = paramWindow.getSharedElementReturnTransition();
    if ((localObject instanceof MaterialContainerTransform))
    {
      localObject = (MaterialContainerTransform)localObject;
      ((MaterialContainerTransform)localObject).a(true);
      ((MaterialContainerTransform)localObject).addListener(new MaterialContainerTransformSharedElementCallback.2(this, paramActivity));
      if (this.c)
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
      if (!this.d) {
        paramWindow.setSharedElementReenterTransition(null);
      }
      if (this.c)
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
    a = new WeakReference(paramView);
    return super.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  @Nullable
  public View onCreateSnapshotView(@NonNull Context paramContext, @Nullable Parcelable paramParcelable)
  {
    paramContext = super.onCreateSnapshotView(paramContext, paramParcelable);
    if (paramContext != null)
    {
      paramParcelable = a;
      if ((paramParcelable != null) && (this.f != null))
      {
        paramParcelable = (View)paramParcelable.get();
        if (paramParcelable != null)
        {
          paramParcelable = this.f.a(paramParcelable);
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
          if (this.b)
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
    if ((!this.b) && (!paramList1.isEmpty())) {
      this.e = TransitionUtils.b((View)paramList1.get(0));
    }
    this.b = false;
  }
  
  public void onSharedElementStart(@NonNull List<String> paramList, @NonNull List<View> paramList1, @NonNull List<View> paramList2)
  {
    if ((!paramList1.isEmpty()) && (!paramList2.isEmpty())) {
      ((View)paramList1.get(0)).setTag(R.id.R, paramList2.get(0));
    }
    if ((!this.b) && (!paramList1.isEmpty()) && (this.e != null))
    {
      paramList = (View)paramList1.get(0);
      paramList.measure(View.MeasureSpec.makeMeasureSpec(this.e.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.e.height(), 1073741824));
      paramList.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
 * JD-Core Version:    0.7.0.1
 */