package com.tencent.mobileqq.activity.recent.cur;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragFrameLayout
  extends FrameLayout
  implements IDragView.OnChangeModeListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130842480, 2130842481, 2130842482, 2130842483, 2130842484 };
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private DragFrameLayout.AllBornRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner;
  private DragFrameLayout.BornRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner;
  private DragFrameLayout.IDragViewProvider jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider;
  private DragFrameLayout.OnDragListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener;
  private DragFrameLayout.ShakeRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner;
  private final List<DragFrameLayout.OnDragModeChangedListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final int c;
  private int d = -1;
  private int e;
  private int f;
  private int g;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 3.0F));
    this.c = ((int)(getResources().getDisplayMetrics().density * 12.0F));
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 48.0F));
  }
  
  private static Bitmap a(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = paramView.getDrawingCache();
    if (localBitmap != null) {}
    try
    {
      localBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    localBitmap = null;
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if ((localView != null) && ((localView instanceof DragFrameLayout))) {
      return (DragFrameLayout)localView;
    }
    paramActivity = new DragFrameLayout(paramActivity.getApplication());
    localViewGroup.addView(paramActivity, 0);
    localViewGroup.removeView(localView);
    paramActivity.addView(localView);
    return paramActivity;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    DragFrameLayout.OnDragListener localOnDragListener = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener;
    if (localOnDragListener != null) {
      localOnDragListener.a(paramFloat1, paramFloat2, paramInt, this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void a(int paramInt)
  {
    this.d = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMode:");
      localStringBuilder.append(this.d);
      QLog.d("Drag", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.d == -1) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    int i = this.e;
    if (i != 0) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
    } else if (this.f == 1) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-4797728);
    } else {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
    }
    i = this.d;
    if (i == 0)
    {
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    float f3;
    float f2;
    float f1;
    Object localObject;
    if (i == 1)
    {
      paramCanvas.save();
      i = this.g;
      f3 = i / 1.5F;
      f2 = i * (0.8F - this.jdField_a_of_type_Float * 0.45F / this.jdField_a_of_type_Int);
      i = this.c;
      f1 = f2;
      if (f2 > i) {
        f1 = i;
      }
      i = this.jdField_b_of_type_Int;
      f2 = f1;
      if (f1 < i) {
        f2 = i;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MODE_DRAG:");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
      }
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
      paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
      paramCanvas.translate(-f3, -f2);
      a(paramCanvas, f2, f3);
      paramCanvas.restore();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    if ((i != 3) && (i != 6))
    {
      if (i == 2)
      {
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      if (i == 4)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.BornRunner)localObject).a();
          if (localObject != null) {
            paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new RectF(this.jdField_a_of_type_AndroidGraphicsPointF.x - ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - ((Bitmap)localObject).getHeight() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.x + ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y + ((Bitmap)localObject).getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner, 50L);
        }
      }
      else if (i == 5)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner;
        if (localObject != null)
        {
          localObject = ((DragFrameLayout.AllBornRunner)localObject).a();
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner.a();
          if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
            paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          if (DragFrameLayout.AllBornRunner.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner) == -1)
          {
            post(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner);
            return;
          }
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner, 25L);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner;
      if ((localObject != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
      {
        localObject = ((DragFrameLayout.ShakeRunner)localObject).a();
        this.jdField_a_of_type_AndroidGraphicsPointF.set((PointF)localObject);
        this.jdField_a_of_type_Float = ((float)Math.sqrt((this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY())));
        paramCanvas.save();
        f3 = this.g / 1.5F;
        f2 = (1.0F - this.jdField_a_of_type_Float / this.jdField_a_of_type_Int) * f3;
        i = this.c;
        f1 = f2;
        if (f2 > i / 2) {
          f1 = i / 2;
        }
        i = this.jdField_b_of_type_Int;
        f2 = f1;
        if (f1 < i) {
          f2 = i;
        }
        paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner, 60L);
      }
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("drawAtOrigion:");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramFloat2);
      QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
    }
    float f1 = this.jdField_a_of_type_Float;
    float f3 = paramFloat1 / 2.0F;
    float f2 = paramFloat2 - f3;
    f3 = paramFloat2 + f3;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.jdField_a_of_type_AndroidGraphicsPaint);
    Object localObject = new Path();
    ((Path)localObject).moveTo(paramFloat2 + paramFloat1, paramFloat1);
    float f4 = 0.5F + (paramFloat1 + f1);
    ((Path)localObject).cubicTo(f3, paramFloat1 + 0.3F * f1, f3, paramFloat1 + f1 * 0.7F, paramFloat2 + paramFloat2, f4);
    ((Path)localObject).lineTo(paramFloat2 - paramFloat2, f4);
    ((Path)localObject).cubicTo(f2, f1 * 0.7F + paramFloat1, f2, f1 * 0.3F + paramFloat1, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath((Path)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == -1) {
      this.e = 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).onChange(paramBoolean, this.f, this);
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.d != -1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner = null;
      }
      boolean bool;
      if (this.d == 5) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause call, mMode=");
      localStringBuilder.append(this.d);
      QLog.d("DragFrameLayout", 2, new Object[] { localStringBuilder.toString(), " isDone=", Boolean.valueOf(bool) });
      a(-1);
      a(bool);
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModeChanged:");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
    }
    this.e = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramView);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      this.e = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, 1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getOrginalCachePixel:");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("Drag", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Matrix();
      ((Matrix)localObject).postScale(1.1F, 1.1F);
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, true);
      getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
      paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left -= i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top -= j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).right -= i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).bottom -= j;
      i = this.jdField_a_of_type_AndroidGraphicsRect.width();
      j = this.jdField_a_of_type_AndroidGraphicsRect.height();
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      float f1 = ((Rect)localObject).left;
      float f2 = i;
      f2 = (f2 * 1.1F - f2) / 2.0F;
      ((Rect)localObject).left = ((int)(f1 - f2));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).right = ((int)(((Rect)localObject).right + f2));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      f1 = ((Rect)localObject).bottom;
      f2 = j;
      f2 = (1.1F * f2 - f2) / 2.0F;
      ((Rect)localObject).bottom = ((int)(f1 + f2));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - f2));
      double d1 = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      Double.isNaN(d1);
      this.g = ((int)(d1 * 0.8D));
      i = this.g;
      j = this.c;
      if (i > j) {
        this.g = j;
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      a(0);
      this.f = paramInt;
      paramView.setVisibility(4);
      invalidate();
      a(false);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("init:");
        paramView.append(this.jdField_a_of_type_AndroidGraphicsRect);
        QLog.d("Drag", 2, paramView.toString());
      }
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramOnDragModeChangedListener != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnDragModeChangedListener);
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((paramOnDragModeChangedListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener)))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramOnDragModeChangedListener);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(0, paramOnDragModeChangedListener);
    }
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    super.addChildrenForAccessibility(paramArrayList);
    int i = 0;
    while (i < paramArrayList.size())
    {
      localView = (View)paramArrayList.get(i);
      if (localView.getId() == 2131369800) {
        break label46;
      }
      i += 1;
    }
    View localView = null;
    label46:
    if (localView != null)
    {
      paramArrayList.remove(localView);
      paramArrayList.add(0, localView);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      label5:
      a(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    StringBuilder localStringBuilder;
    if (this.d == -1)
    {
      if ((i == 0) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Host.dispatchTouchEvent: Down At<");
        localStringBuilder.append(paramMotionEvent.getX());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramMotionEvent.getY());
        localStringBuilder.append(">");
        QLog.d("Drag", 2, localStringBuilder.toString());
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Host.dispatchTouchEvent: ");
      localStringBuilder.append(paramMotionEvent.getAction());
      localStringBuilder.append(" At<");
      localStringBuilder.append(paramMotionEvent.getX());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMotionEvent.getY());
      localStringBuilder.append(">");
      QLog.d("Drag", 2, localStringBuilder.toString());
    }
    if ((this.d != 6) && (this.f == 4))
    {
      a(6);
      paramMotionEvent = new RectF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.centerX() - 6, this.jdField_a_of_type_AndroidGraphicsRect.centerY());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = new DragFrameLayout.ShakeRunner(this, new PointF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY()), paramMotionEvent);
      invalidate();
    }
    if ((i != 3) && (i != 1))
    {
      if (i == 2)
      {
        i = this.d;
        if ((i != 0) && (i != 1))
        {
          if (i == 3) {
            return true;
          }
          if (i == 2)
          {
            this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
            a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 2);
            invalidate();
            return true;
          }
        }
        else
        {
          float f3 = (float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()));
          if (f3 >= this.g + this.jdField_a_of_type_Int)
          {
            this.jdField_a_of_type_Float = f3;
            this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
            a(2);
            a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 2);
          }
          else if (f3 >= 0.0F)
          {
            this.jdField_a_of_type_Float = f3;
            this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
            a(1);
            a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 1);
          }
          else
          {
            a(0);
            a(0.0F, 0.0F, 0);
          }
          invalidate();
          return true;
        }
      }
    }
    else
    {
      a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, -1);
      i = this.d;
      if (i == 0)
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView = null;
        a(-1);
        invalidate();
        a(false);
        return true;
      }
      if (i == 1)
      {
        a(3);
        this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
        paramMotionEvent = new RectF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = new DragFrameLayout.ShakeRunner(this, new PointF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY()), paramMotionEvent);
        invalidate();
        return true;
      }
      if (i == 3) {
        return true;
      }
      if (i == 2)
      {
        if ((float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY())) < (this.g + this.jdField_a_of_type_Int) / 2)
        {
          this.jdField_b_of_type_AndroidGraphicsBitmap = null;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView = null;
          a(-1);
          a(false);
        }
        else
        {
          a(4);
          this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner = new DragFrameLayout.BornRunner(this, this.jdField_a_of_type_AndroidGraphicsPointF);
        }
        invalidate();
      }
    }
    return true;
  }
  
  public void setDragViewProvider(DragFrameLayout.IDragViewProvider paramIDragViewProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider = paramIDragViewProvider;
  }
  
  public void setOnDragListener(DragFrameLayout.OnDragListener paramOnDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */