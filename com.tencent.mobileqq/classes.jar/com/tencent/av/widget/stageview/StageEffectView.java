package com.tencent.av.widget.stageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import mki;
import mkj;
import mkl;
import mkn;
import mko;
import mkr;
import mks;
import mkt;
import mku;

public class StageEffectView
  extends ViewGroup
{
  private static final float jdField_a_of_type_Float;
  static final double[] jdField_a_of_type_ArrayOfDouble;
  static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[][] jdField_a_of_type_Array2dOfInt;
  private static final float jdField_b_of_type_Float;
  private static final boolean jdField_b_of_type_Boolean;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new StageEffectView.2(this);
  private final ArrayList<mku> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final Comparator<Integer> jdField_a_of_type_JavaUtilComparator = new mkn(this);
  private mkl jdField_a_of_type_Mkl;
  private mks jdField_a_of_type_Mks;
  public boolean a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private final StageMemberView[] jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView = new StageMemberView[8];
  private final Integer[] jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[8];
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Comparator<StageMemberView> jdField_b_of_type_JavaUtilComparator = new mko(this);
  private final int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float = 1.0F;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int = -1;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int;
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  private float j;
  private float k;
  private float l;
  
  static
  {
    boolean bool = true;
    jdField_a_of_type_Float = (float)Math.sin(-0.3141592653589793D);
    jdField_b_of_type_Float = (float)Math.cos(-0.3141592653589793D);
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 17500, 2500, 15000, 5000, 12500, 7500, 10000 };
    jdField_a_of_type_ArrayOfDouble = new double[] { 0.0D, 0.6981317007977318D, 2.094395102393195D, 2.879793265790644D, 3.141592653589793D, 3.403392041388943D, 4.188790204786391D, 5.585053606381854D };
    jdField_a_of_type_Array2dOfInt = new int[][] { new int[0], { 0 }, { 1, 0 }, { 1, 0, 2 }, { 3, 1, 0, 2 }, { 3, 1, 0, 2, 4 }, { 5, 3, 1, 0, 2, 4 }, { 5, 3, 1, 0, 2, 4, 6 }, { 5, 3, 1, 0, 2, 4, 6, 7 } };
    if (Build.VERSION.SDK_INT >= 11) {}
    for (;;)
    {
      jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public StageEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StageEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = a(paramContext);
  }
  
  private double a(float paramFloat, boolean paramBoolean)
  {
    float f1 = 1.0F;
    paramFloat = (paramFloat - this.jdField_c_of_type_Float) / this.jdField_e_of_type_Float / 300.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f1;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        return Math.asin(paramFloat) * 0.6499999761581421D;
        if (paramFloat < -1.0F) {
          paramFloat = -1.0F;
        }
      }
      else
      {
        return 3.141592653589793D - Math.asin(paramFloat) * 1.350000023841858D;
      }
    }
  }
  
  private int a(String[] paramArrayOfString, int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      return paramInt;
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    label17:
    Object localObject;
    int i2;
    mku localmku;
    if (i1 < paramInt)
    {
      localObject = paramArrayOfString[i1];
      if (localObject == null) {
        break label656;
      }
      i2 = 0;
      if (i2 < this.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i2] == null) {}
        do
        {
          i2 += 1;
          break;
          localmku = (mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i2].getTag();
          localmku.jdField_a_of_type_Mku = null;
        } while (!((String)localObject).equals(localmku.jdField_a_of_type_Mkt.jdField_a_of_type_JavaLangString));
        removeViewInLayout(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i2]);
        this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i2] = null;
        i2 = n + 1;
        n = m + 1;
        m = i2;
      }
    }
    for (;;)
    {
      label137:
      i1 += 1;
      i2 = n;
      n = m;
      m = i2;
      break label17;
      i2 = 0;
      for (;;)
      {
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (((String)localObject).equals(((mku)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).jdField_a_of_type_Mkt.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(i2);
            i2 = m + 1;
            m = n;
            n = i2;
            break label137;
          }
          i2 += 1;
          continue;
          paramInt = m;
          if (n <= 0) {
            break;
          }
          Arrays.sort(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilComparator);
          int i5 = this.jdField_a_of_type_Int - n;
          paramArrayOfString = jdField_a_of_type_Array2dOfInt[i5];
          int i3 = 0;
          i1 = 0;
          paramInt = 0;
          while (i3 < this.jdField_a_of_type_Int)
          {
            localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i3];
            if (localObject == null)
            {
              i3 += 1;
            }
            else
            {
              localmku = (mku)((StageMemberView)localObject).getTag();
              if ((localmku.jdField_a_of_type_Int == 0) && ((localmku.jdField_a_of_type_Int < 0) || (localmku.jdField_a_of_type_Int >= 10000))) {
                break label425;
              }
            }
          }
          int i4;
          if (i1 < i5)
          {
            i4 = 0;
            i2 = 0;
            i3 = paramInt;
            if (i4 < this.jdField_a_of_type_Int) {
              if (i1 < i5) {
                break label488;
              }
            }
          }
          for (i3 = paramInt;; i3 = paramInt)
          {
            this.jdField_a_of_type_Int -= n;
            paramInt = 0;
            for (;;)
            {
              if (paramInt < this.jdField_a_of_type_Int)
              {
                this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt] = Integer.valueOf(paramInt);
                paramInt += 1;
                continue;
                label425:
                i2 = paramInt;
                if (localmku.jdField_a_of_type_Int != jdField_a_of_type_ArrayOfInt[paramArrayOfString[i1]])
                {
                  a((StageMemberView)localObject, localmku, jdField_a_of_type_ArrayOfInt[paramArrayOfString[i1]], -1, 0);
                  i2 = Math.max(paramInt, localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Int);
                }
                i1 += 1;
                paramInt = i2;
                break;
                label488:
                localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[(this.jdField_a_of_type_Int - 1 - i4)];
                if (localObject == null)
                {
                  i3 = i2;
                  i2 = paramInt;
                  paramInt = i3;
                }
                for (;;)
                {
                  i4 += 1;
                  i3 = i2;
                  i2 = paramInt;
                  paramInt = i3;
                  break;
                  localmku = (mku)((StageMemberView)localObject).getTag();
                  i3 = paramInt;
                  if (localmku.jdField_a_of_type_Int != jdField_a_of_type_ArrayOfInt[paramArrayOfString[(i5 - 1 - i2)]])
                  {
                    a((StageMemberView)localObject, localmku, jdField_a_of_type_ArrayOfInt[paramArrayOfString[(i5 - 1 - i2)]], -1, 0);
                    i3 = Math.max(paramInt, localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Int);
                  }
                  paramInt = i2 + 1;
                  i1 += 1;
                  i2 = i3;
                }
              }
            }
            b();
            invalidate();
            paramInt = m;
            if (paramArrayOfInt == null) {
              break;
            }
            paramArrayOfInt[0] = i3;
            return m;
          }
        }
      }
      label656:
      i2 = m;
      m = n;
      n = i2;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {}
    label555:
    for (;;)
    {
      return;
      int i1 = this.jdField_c_of_type_Int;
      int m = this.jdField_a_of_type_Int;
      int n = this.jdField_a_of_type_JavaUtilArrayList.size() + m;
      int i2 = this.jdField_c_of_type_Int;
      if (n < 8) {}
      Object localObject1;
      Object localObject2;
      for (m = 8;; m = n)
      {
        this.jdField_c_of_type_Int = mkj.a(i2 + paramInt, m * 2500);
        i1 /= 2500;
        i2 = this.jdField_c_of_type_Int / 2500;
        m = 0;
        while (m < this.jdField_a_of_type_Int)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m];
          localObject2 = (mku)((StageMemberView)localObject1).getTag();
          float f1 = ((mku)localObject2).jdField_d_of_type_Float;
          f1 = ((mku)localObject2).jdField_e_of_type_Float;
          a((mku)localObject2, (StageMemberView)localObject1, ((mku)localObject2).jdField_a_of_type_Int + paramInt);
          m += 1;
        }
      }
      if ((n > 8) && (i1 != i2))
      {
        mku localmku;
        if (paramInt > 0)
        {
          n = (i2 + n - i1) % n;
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.jdField_a_of_type_Int) {
              break label349;
            }
            localObject1 = (mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
            if ((((mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt - 1 + 8) % 8)].getTag()).jdField_a_of_type_Int < 10000) && (((mku)localObject1).jdField_a_of_type_Int >= 10000))
            {
              m = 0;
              while (m < n)
              {
                localObject1 = (mku)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
                localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((n - 1 - m + paramInt) % 8)];
                localmku = (mku)((StageMemberView)localObject2).getTag();
                ((mku)localObject1).a(localmku);
                ((StageMemberView)localObject2).setTag(localObject1);
                ((StageMemberView)localObject2).setBackgroundDrawable(((mku)localObject1).jdField_a_of_type_Mkt.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                ((StageMemberView)localObject2).a(((mku)localObject1).jdField_a_of_type_Mkt.b, false);
                a(-1, localmku);
                m += 1;
              }
              break;
            }
            paramInt += 1;
          }
        }
        else
        {
          label349:
          if (paramInt < 0)
          {
            n = mkj.a(i1 - i2, n);
            paramInt = this.jdField_a_of_type_Int - 1;
            for (;;)
            {
              if (paramInt < 0) {
                break label555;
              }
              localObject1 = (mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
              if ((((mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt + 1 + 8) % 8)].getTag()).jdField_a_of_type_Int > 10000) && (((mku)localObject1).jdField_a_of_type_Int < 10000))
              {
                m = 0;
                while (m < n)
                {
                  localObject1 = (mku)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
                  i1 = mkj.a(paramInt - (n - 1 - m), 8);
                  localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1];
                  localmku = (mku)((StageMemberView)localObject2).getTag();
                  ((mku)localObject1).a(localmku);
                  ((StageMemberView)localObject2).setTag(localObject1);
                  ((StageMemberView)localObject2).setBackgroundDrawable(((mku)localObject1).jdField_a_of_type_Mkt.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                  ((StageMemberView)localObject2).a(((mku)localObject1).jdField_a_of_type_Mkt.b, false);
                  a(0, localmku);
                  m += 1;
                }
                break;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, View paramView)
  {
    int m = paramView.getWidth() / 2;
    int n = paramView.getLeft();
    int i1 = paramView.getHeight() / 2;
    int i2 = paramView.getTop();
    paramView.offsetLeftAndRight(paramInt1 - (m + n));
    paramView.offsetTopAndBottom(paramInt2 - (i1 + i2));
  }
  
  private void a(int paramInt, mku parammku)
  {
    parammku.jdField_a_of_type_Mku = null;
    parammku.jdField_a_of_type_Mkr = null;
    if (paramInt < 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(parammku);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parammku);
  }
  
  private void a(StageMemberView paramStageMemberView, mku parammku, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0) {
      paramStageMemberView.setVisibility(4);
    }
    parammku.jdField_a_of_type_Mkr = new mkr(parammku.jdField_a_of_type_Int, mkj.a(paramInt1, 20000), paramInt2, paramInt3, null);
  }
  
  private void a(mku parammku, StageMemberView paramStageMemberView)
  {
    mku localmku = parammku.jdField_a_of_type_Mku;
    localmku.a(parammku);
    paramStageMemberView.setTag(localmku);
    paramStageMemberView.setBackgroundDrawable(localmku.jdField_a_of_type_Mkt.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramStageMemberView.a(localmku.jdField_a_of_type_Mkt.b, false);
    if (this.jdField_a_of_type_JavaUtilArrayList.remove(localmku)) {
      a(-1, parammku);
    }
  }
  
  @TargetApi(11)
  private void a(mku parammku, StageMemberView paramStageMemberView, int paramInt)
  {
    paramInt = mkj.a(paramInt, 20000);
    int m = paramInt / 2500;
    if (m < jdField_a_of_type_ArrayOfDouble.length - 1) {}
    for (double d1 = jdField_a_of_type_ArrayOfDouble[(m + 1)] - jdField_a_of_type_ArrayOfDouble[m];; d1 = 6.283185307179586D - jdField_a_of_type_ArrayOfDouble[m])
    {
      double d2 = (paramInt - m * 2500) / 2500.0D;
      parammku.jdField_a_of_type_Int = paramInt;
      d1 = d1 * d2 + jdField_a_of_type_ArrayOfDouble[m];
      this.jdField_g_of_type_Float = ((float)(Math.sin(d1) * 300.0D));
      this.jdField_h_of_type_Float = 0.0F;
      this.jdField_i_of_type_Float = (-(float)(Math.cos(d1) * 300.0D));
      this.j = this.jdField_g_of_type_Float;
      this.k = (this.jdField_h_of_type_Float * jdField_b_of_type_Float - this.jdField_i_of_type_Float * jdField_a_of_type_Float);
      this.l = (this.jdField_h_of_type_Float * jdField_a_of_type_Float + this.jdField_i_of_type_Float * jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsCamera.save();
      this.jdField_a_of_type_AndroidGraphicsCamera.translate(this.j, this.k, this.l);
      this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsCamera.restore();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_e_of_type_Float, this.jdField_e_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      parammku.jdField_a_of_type_Float = this.j;
      parammku.jdField_b_of_type_Float = this.k;
      parammku.jdField_c_of_type_Float = this.l;
      parammku.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      parammku.jdField_f_of_type_Float = this.jdField_a_of_type_ArrayOfFloat[0];
      if (this.jdField_i_of_type_Float > 150.0F) {
        parammku.jdField_f_of_type_Float *= (1.0F - (this.jdField_i_of_type_Float - 150.0F) / 150.0F * 0.4F);
      }
      parammku.jdField_d_of_type_Float = this.jdField_a_of_type_ArrayOfFloat[2];
      parammku.jdField_e_of_type_Float = this.jdField_a_of_type_ArrayOfFloat[5];
      a((int)parammku.jdField_d_of_type_Float, (int)parammku.jdField_e_of_type_Float, paramStageMemberView);
      if (jdField_b_of_type_Boolean)
      {
        paramStageMemberView.setScaleX(parammku.jdField_f_of_type_Float);
        paramStageMemberView.setScaleY(parammku.jdField_f_of_type_Float);
      }
      if ((parammku.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
      {
        parammku = new int[2];
        paramStageMemberView.getLocationInWindow(parammku);
        this.jdField_b_of_type_Int = parammku[1];
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    while (m < this.jdField_a_of_type_Int)
    {
      StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[this.jdField_a_of_type_ArrayOfJavaLangInteger[(this.jdField_a_of_type_Int - 1 - m)].intValue()];
      localStageMemberView.a(((mku)localStageMemberView.getTag()).jdField_a_of_type_Mkt.b, true);
      m += 1;
    }
  }
  
  private boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = mki.a();
    setChildrenDrawingOrderEnabled(true);
    setWillNotDraw(true);
    setClipChildren(false);
    this.jdField_i_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_Mkl = new mkl(paramContext);
    this.jdField_a_of_type_Mkl.a(0.05F);
    int m = (int)(70.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    float f1 = Math.max(1.0F, 0.75F * paramContext.getResources().getDisplayMetrics().density);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      paramContext.setDither(true);
      float f2 = m * 0.0625F + 2.0F;
      RectF localRectF1 = new RectF(f2, f2, m - f2, m - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(1.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setColor(-1593835521);
      localCanvas.drawOval(localRectF1, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-1);
      paramContext.setStrokeWidth(f1 * 2.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF1, paramContext);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      RectF localRectF2 = new RectF(f2, f2, m - f2, m - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(f2 + 4.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setColor(-1608790934);
      localCanvas.drawOval(localRectF2, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-15554453);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF2, paramContext);
      this.jdField_c_of_type_Boolean = true;
      if (!jdField_b_of_type_Boolean) {
        setStaticTransformationsEnabled(true);
      }
      return true;
    }
    catch (OutOfMemoryError paramContext) {}
    return false;
  }
  
  private boolean a(mku parammku, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    int m = this.jdField_a_of_type_Int;
    StageMemberView localStageMemberView = new StageMemberView(getContext(), this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap);
    localStageMemberView.jdField_a_of_type_Mkk = parammku.jdField_a_of_type_Mkt.jdField_a_of_type_Mkk;
    localStageMemberView.setBackgroundDrawable(parammku.jdField_a_of_type_Mkt.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStageMemberView.layout(-54, -54, 54, 66);
    localStageMemberView.setTag(parammku);
    if (this.jdField_c_of_type_Boolean) {
      localStageMemberView.a(parammku.jdField_a_of_type_Mkt.b, false);
    }
    a(true);
    super.addViewInLayout(localStageMemberView, getChildCount(), generateDefaultLayoutParams());
    this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m] = localStageMemberView;
    this.jdField_a_of_type_Int += 1;
    if ((paramBoolean2) || (paramInt2 > 0) || (paramBoolean1))
    {
      a(parammku, localStageMemberView, jdField_a_of_type_ArrayOfInt[7]);
      paramInt1 = jdField_a_of_type_ArrayOfInt[m] + paramInt1;
      paramBoolean1 = bool;
      if (parammku.jdField_a_of_type_Int != paramInt1) {
        a(localStageMemberView, parammku, paramInt1, -1, paramInt2);
      }
    }
    for (paramBoolean1 = true;; paramBoolean1 = bool)
    {
      this.jdField_a_of_type_ArrayOfJavaLangInteger[m] = Integer.valueOf(m);
      b();
      return paramBoolean1;
      a(parammku, localStageMemberView, jdField_a_of_type_ArrayOfInt[m]);
      invalidate();
    }
  }
  
  private void b()
  {
    Arrays.sort(this.jdField_a_of_type_ArrayOfJavaLangInteger, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilComparator);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void e()
  {
    int n;
    int m;
    if (this.jdField_d_of_type_Int != 0)
    {
      n = 1;
      if (this.jdField_a_of_type_Int < 8) {
        break label81;
      }
      m = Math.round(this.jdField_c_of_type_Int / 2500.0F) * 2500 - this.jdField_c_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_d_of_type_Int |= 0x2;
      this.jdField_e_of_type_Int = m;
      this.jdField_f_of_type_Int = 0;
      if (n == 0) {
        f();
      }
      return;
      n = 0;
      break;
      label81:
      int i1 = mkj.a(this.jdField_c_of_type_Int, 0, 20000, false);
      m = i1;
      if (i1 > 10000) {
        m = -(20000 - i1);
      }
    }
  }
  
  @TargetApi(16)
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 16L);
  }
  
  @TargetApi(11)
  private void g()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_d_of_type_Int = 0;
  }
  
  private void h()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("must call in ui thread");
    }
  }
  
  @TargetApi(16)
  void a()
  {
    long l1 = SystemClock.uptimeMillis();
    int n;
    StageMemberView localStageMemberView;
    mku localmku;
    int i1;
    label86:
    label219:
    label232:
    float f1;
    int i2;
    if ((this.jdField_d_of_type_Int & 0x10) == 16)
    {
      n = 0;
      m = 0;
      if (m < this.jdField_a_of_type_Int)
      {
        localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m];
        localmku = (mku)localStageMemberView.getTag();
        i1 = localmku.jdField_a_of_type_Int;
        if (localmku.jdField_a_of_type_Mkr != null)
        {
          if (localmku.jdField_a_of_type_Mkr.jdField_a_of_type_ArrayOfInt == null) {
            break label219;
          }
          n = localmku.jdField_a_of_type_Mkr.jdField_a_of_type_ArrayOfInt[0];
          if (l1 >= localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Long) {
            break label232;
          }
        }
        for (;;)
        {
          if ((localmku.jdField_a_of_type_Mku != null) && (((localmku.jdField_a_of_type_Mkr != null) && (!localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Boolean) && (i1 < 10000) && (localmku.jdField_a_of_type_Int >= 10000)) || ((localmku.jdField_a_of_type_Mkr != null) && (localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Boolean) && (i1 > 10000) && (localmku.jdField_a_of_type_Int <= 10000)) || ((this.jdField_d_of_type_Int == 16) && (localmku.jdField_a_of_type_Mkr == null)))) {
            a(localmku, localStageMemberView);
          }
          n = 1;
          m += 1;
          break;
          n = localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Int;
          break label86;
          if (l1 < localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Long + n)
          {
            localStageMemberView.setVisibility(0);
            f1 = (float)(l1 - localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Long) / n;
            if (localmku.jdField_a_of_type_Mkr.jdField_a_of_type_Boolean) {}
            float f2;
            for (n = (int)(localmku.jdField_a_of_type_Mkr.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * localmku.jdField_a_of_type_Mkr.jdField_d_of_type_Int);; n = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * localmku.jdField_a_of_type_Mkr.jdField_d_of_type_Int + f2))
            {
              i2 = localmku.jdField_a_of_type_Mkr.jdField_e_of_type_Int;
              localmku.jdField_a_of_type_Mkr.jdField_e_of_type_Int = n;
              a(localmku, localStageMemberView, localmku.jdField_a_of_type_Int + (n - i2));
              break;
              f2 = localmku.jdField_a_of_type_Mkr.jdField_b_of_type_Int;
            }
          }
          localStageMemberView.setVisibility(0);
          n = localmku.jdField_a_of_type_Mkr.jdField_c_of_type_Int;
          i2 = localmku.jdField_a_of_type_Mkr.jdField_e_of_type_Int;
          localmku.jdField_a_of_type_Mkr.jdField_e_of_type_Int = localmku.jdField_a_of_type_Mkr.jdField_c_of_type_Int;
          a(localmku, localStageMemberView, n - i2 + localmku.jdField_a_of_type_Int);
          localmku.jdField_a_of_type_Mkr = null;
        }
      }
      m = n;
      if (n == 0) {
        this.jdField_d_of_type_Int &= 0xFFFFFFEF;
      }
    }
    for (int m = n;; m = 0)
    {
      switch (this.jdField_d_of_type_Int & 0xF)
      {
      default: 
        b();
        if (m == 0) {
          break label946;
        }
        if (Build.VERSION.SDK_INT >= 16) {
          postOnAnimation(this.jdField_a_of_type_JavaLangRunnable);
        }
        break;
      }
      for (;;)
      {
        invalidate();
        return;
        f1 = (float)(l1 - this.jdField_a_of_type_Long) / (Math.abs(this.jdField_e_of_type_Int) * 0.2F);
        if (f1 >= 1.0F)
        {
          n = this.jdField_e_of_type_Int;
          i1 = this.jdField_f_of_type_Int;
          this.jdField_f_of_type_Int = this.jdField_e_of_type_Int;
          i1 = n - i1;
          n = m;
        }
        for (;;)
        {
          m = this.jdField_a_of_type_Int;
          i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
          this.jdField_c_of_type_Int = mkj.a(this.jdField_c_of_type_Int + i1, (m + i2) * 2500);
          i2 = 0;
          for (;;)
          {
            m = n;
            if (i2 >= this.jdField_a_of_type_Int) {
              break;
            }
            localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i2];
            localmku = (mku)localStageMemberView.getTag();
            m = localmku.jdField_a_of_type_Int;
            a(localmku, localStageMemberView, localmku.jdField_a_of_type_Int + i1);
            if ((localmku.jdField_a_of_type_Mku != null) && ((n == 0) || ((this.jdField_f_of_type_Int > 0) && (m < 10000) && (localmku.jdField_a_of_type_Int >= 10000)) || ((this.jdField_f_of_type_Int < 0) && (m > 10000) && (localmku.jdField_a_of_type_Int <= 10000)))) {
              a(localmku, localStageMemberView);
            }
            i2 += 1;
          }
          n = 1;
          m = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * this.jdField_e_of_type_Int);
          i1 = this.jdField_f_of_type_Int;
          this.jdField_f_of_type_Int = m;
          i1 = m - i1;
        }
        f1 = (float)(l1 - this.jdField_a_of_type_Long) / 500.0F;
        n = this.jdField_e_of_type_Int;
        if (f1 < 1.0F)
        {
          n = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * this.jdField_e_of_type_Int);
          m = 1;
        }
        a(n - this.jdField_f_of_type_Int);
        this.jdField_f_of_type_Int = n;
        break;
        if (this.jdField_a_of_type_Mkl.b()) {
          m = 1;
        }
        n = this.jdField_a_of_type_Mkl.a();
        a(n - this.jdField_f_of_type_Int);
        this.jdField_f_of_type_Int = n;
        break;
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 16L);
      }
      label946:
      invalidate();
      g();
      return;
    }
  }
  
  void a(double paramDouble)
  {
    if (this.jdField_d_of_type_Int != 0) {}
    for (int m = 1;; m = 0)
    {
      this.jdField_d_of_type_Int |= 0x3;
      this.jdField_a_of_type_Mkl.a(this.jdField_c_of_type_Int, 0, (int)(20000.0D * paramDouble), 0, -2147483648, 2147483647, 0, 0, 0, 0, 2500, 0);
      this.jdField_f_of_type_Int = this.jdField_c_of_type_Int;
      if (m == 0) {
        f();
      }
      return;
    }
  }
  
  public boolean a(String... paramVarArgs)
  {
    h();
    if (this.jdField_d_of_type_Int != 0) {}
    int i1;
    for (int m = 1;; m = 0)
    {
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != 0)) {
        postDelayed(new StageEffectView.4(this, paramVarArgs), 500L);
      }
      int n = this.jdField_a_of_type_Int;
      i1 = a(paramVarArgs, paramVarArgs.length, this.jdField_b_of_type_ArrayOfInt);
      a(true);
      if (this.jdField_a_of_type_Int >= n) {
        break label163;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break;
      }
      int i2 = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), 8 - this.jdField_a_of_type_Int);
      n = 0;
      while (n < i2)
      {
        a((mku)this.jdField_a_of_type_JavaUtilArrayList.remove(0), 0, true, true, 0);
        n += 1;
      }
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 16;
    if (m == 0) {
      f();
    }
    label163:
    return i1 > 0;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt2].intValue();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    mku localmku = (mku)paramView.getTag();
    paramTransformation = paramTransformation.getMatrix();
    paramTransformation.postScale(localmku.jdField_f_of_type_Float, localmku.jdField_f_of_type_Float);
    paramTransformation.preTranslate(-paramView.getWidth() / 2.0F, -paramView.getHeight() / 2.0F);
    paramTransformation.postTranslate(paramView.getWidth() / 2.0F, paramView.getHeight() / 2.0F);
    return true;
  }
  
  public boolean isLayoutRequested()
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      float f1 = paramInt1 / 832.0F;
      float f2 = (paramInt2 - paramInt3 - paramInt4) / 444.0F;
      if (f2 >= f1)
      {
        this.jdField_e_of_type_Float = f1;
        f2 = this.jdField_e_of_type_Float;
        float f3 = getPaddingLeft();
        this.jdField_c_of_type_Float = (paramInt1 / 2.0F + f3);
      }
      for (this.jdField_d_of_type_Float = ((paramInt2 - f2 * 444.0F) / 2.0F + 96.770576F * f1);; this.jdField_d_of_type_Float = (getPaddingTop() + 96.770576F * f2))
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_Int)
        {
          StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt1];
          Object localObject = (mku)localStageMemberView.getTag();
          a((mku)localObject, localStageMemberView, ((mku)localObject).jdField_a_of_type_Int);
          if ((((mku)localObject).jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
          {
            localObject = new int[2];
            localStageMemberView.getLocationInWindow((int[])localObject);
            this.jdField_b_of_type_Int = localObject[1];
          }
          paramInt1 += 1;
        }
        this.jdField_e_of_type_Float = f2;
        f1 = getPaddingLeft();
        this.jdField_c_of_type_Float = (paramInt1 / 2.0F + f1);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    setMeasuredDimension(getDefaultSize(m + 832 + n, paramInt1), getDefaultSize(i1 + 444 + i2, paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    c();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      do
      {
        do
        {
          int m;
          do
          {
            return true;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if (((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != 0)) && (this.jdField_a_of_type_Int > 0))
            {
              localObject1 = getParent();
              if (localObject1 != null) {
                ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
              }
              if (this.jdField_a_of_type_AndroidViewView != null)
              {
                this.jdField_a_of_type_AndroidViewView.setPressed(false);
                this.jdField_a_of_type_AndroidViewView = null;
              }
              m = 0;
              while (m < this.jdField_a_of_type_Int)
              {
                ((mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m].getTag()).jdField_a_of_type_Mku = null;
                m += 1;
              }
              this.jdField_e_of_type_Boolean = true;
              this.jdField_d_of_type_Int &= 0xFFFFFFF0;
            }
            for (;;)
            {
              a(true);
              this.jdField_f_of_type_Float = f1;
              this.jdField_h_of_type_Int = ((int)this.jdField_f_of_type_Float);
              this.jdField_d_of_type_Boolean = true;
              this.jdField_a_of_type_Double = a(f1, this.jdField_d_of_type_Boolean);
              this.jdField_g_of_type_Int = paramMotionEvent.getPointerId(0);
              return true;
              m = getChildCount() - 1;
              for (;;)
              {
                if (m < 0) {
                  break label398;
                }
                localObject1 = getChildAt(this.jdField_a_of_type_ArrayOfJavaLangInteger[m].intValue());
                localObject2 = (mku)((View)localObject1).getTag();
                f3 = ((mku)localObject2).jdField_f_of_type_Float * 54.0F;
                f4 = ((mku)localObject2).jdField_e_of_type_Float;
                f5 = ((mku)localObject2).jdField_e_of_type_Float;
                f6 = ((mku)localObject2).jdField_d_of_type_Float;
                f7 = ((mku)localObject2).jdField_d_of_type_Float;
                if ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3))
                {
                  ((View)localObject1).setPressed(true);
                  if (this.jdField_a_of_type_AndroidViewView == localObject1) {
                    break;
                  }
                  if (this.jdField_a_of_type_AndroidViewView != null) {
                    this.jdField_a_of_type_AndroidViewView.setPressed(false);
                  }
                  this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
                  break;
                }
                m -= 1;
              }
            }
            m = paramMotionEvent.findPointerIndex(this.jdField_g_of_type_Int);
          } while ((m == -1) || (m >= paramMotionEvent.getPointerCount()));
          f1 = paramMotionEvent.getX(m);
          f2 = this.jdField_f_of_type_Float;
          if ((!this.jdField_e_of_type_Boolean) && (Math.abs(f1 - f2) > this.jdField_i_of_type_Int) && (this.jdField_a_of_type_Int > 0))
          {
            this.jdField_e_of_type_Boolean = true;
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              this.jdField_a_of_type_AndroidViewView.setPressed(false);
              this.jdField_a_of_type_AndroidViewView = null;
            }
            m = 0;
            while (m < this.jdField_a_of_type_Int)
            {
              ((mku)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m].getTag()).jdField_a_of_type_Mku = null;
              m += 1;
            }
            this.jdField_d_of_type_Int &= 0xFFFFFFF0;
          }
          if (this.jdField_e_of_type_Boolean)
          {
            double d1 = a(f1, this.jdField_d_of_type_Boolean);
            a((int)((d1 - this.jdField_a_of_type_Double) * 45.0D / 40.0D / 6.283185307179586D * 20000.0D));
            b();
            this.jdField_a_of_type_Double = d1;
            this.jdField_h_of_type_Int = ((int)f1);
            invalidate();
            return true;
          }
        } while (this.jdField_a_of_type_AndroidViewView == null);
        f2 = paramMotionEvent.getY();
        paramMotionEvent = (mku)this.jdField_a_of_type_AndroidViewView.getTag();
        f3 = paramMotionEvent.jdField_f_of_type_Float * 54.0F;
        f4 = paramMotionEvent.jdField_e_of_type_Float;
        f5 = paramMotionEvent.jdField_e_of_type_Float;
        f6 = paramMotionEvent.jdField_d_of_type_Float;
        f7 = paramMotionEvent.jdField_d_of_type_Float;
      } while ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3));
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
      return true;
    case 1: 
      label398:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Mks != null))
      {
        playSoundEffect(0);
        paramMotionEvent = (mku)this.jdField_a_of_type_AndroidViewView.getTag();
        localObject1 = this.jdField_a_of_type_Mks;
        localObject2 = this.jdField_a_of_type_AndroidViewView;
        if (paramMotionEvent.jdField_a_of_type_Mku != null)
        {
          paramMotionEvent = paramMotionEvent.jdField_a_of_type_Mku.jdField_a_of_type_Mkt;
          ((mks)localObject1).a(this, (View)localObject2, paramMotionEvent);
        }
      }
      for (;;)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_g_of_type_Int = -1;
        d();
        invalidate();
        return true;
        paramMotionEvent = paramMotionEvent.jdField_a_of_type_Mkt;
        break;
        if (this.jdField_e_of_type_Boolean)
        {
          paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
          paramMotionEvent.computeCurrentVelocity(1000, 2000.0F);
          f1 = paramMotionEvent.getXVelocity();
          if (Math.abs(f1) > 400.0F) {
            a(f1 * 0.0005D);
          } else {
            e();
          }
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_e_of_type_Boolean) {
      e();
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Int = -1;
    d();
    invalidate();
    return true;
  }
  
  public void setOnIconClickListener(mks parammks)
  {
    this.jdField_a_of_type_Mks = parammks;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView
 * JD-Core Version:    0.7.0.1
 */