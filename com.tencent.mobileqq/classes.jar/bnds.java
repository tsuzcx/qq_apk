import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bnds
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 68.0F;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Property<bnds, Integer> jdField_a_of_type_AndroidUtilProperty = new bndt(this, Integer.class, "bfIndex");
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bndy> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 68.0F;
  private int jdField_b_of_type_Int = 255;
  private AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  Property<bnds, Integer> jdField_b_of_type_AndroidUtilProperty = new bndu(this, Integer.class, "textAlpha");
  private Map<String, Drawable> jdField_b_of_type_JavaUtilMap = new HashMap();
  private float jdField_c_of_type_Float = 30.0F;
  private int jdField_c_of_type_Int = 1;
  private AnimationDrawable jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable;
  Property<bnds, Float> jdField_c_of_type_AndroidUtilProperty = new bndv(this, Float.class, "textPos");
  private float d = 70.0F;
  private float e = 60.0F;
  private float f = 50.0F;
  private float g = 35.0F;
  private float h = 5.0F;
  private float i = this.h;
  
  private float a()
  {
    return this.i;
  }
  
  private int a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames()) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() - paramInt;
  }
  
  private AnimationDrawable a(Context paramContext, int paramInt)
  {
    paramContext = (AnimationDrawable)paramContext.getResources().getDrawable(paramInt);
    paramContext.setVisible(true, false);
    paramContext.setOneShot(true);
    return paramContext;
  }
  
  private void a(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramFloat4 / 2.0F + paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (paramFloat2 - paramFloat4 / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramFloat3 / 2.0F + paramFloat1);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (paramFloat1 - paramFloat3 / 2.0F);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "startValueAnimator: state:" + this.jdField_c_of_type_Int + " mIndex:" + this.jdField_a_of_type_Int + " mTextAlpha:" + this.jdField_b_of_type_Int);
    }
    if (paramInt1 == 2) {
      if (this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(600L);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bndw(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bndx(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      if (paramInt1 == 4)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
        {
          paramInt1 = a(this.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "calcBackIndex return : " + paramInt1);
          }
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { paramInt1, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() }) });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
        }
      }
      else if (paramInt1 == 5)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 255 }), PropertyValuesHolder.ofFloat(this.jdField_c_of_type_AndroidUtilProperty, new float[] { this.i, 0.0F }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
      else if (paramInt1 == 6)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 0 }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = PickerContainer.a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.jdField_c_of_type_Float = PickerContainer.a(paramContext, this.jdField_c_of_type_Float);
    this.d = PickerContainer.a(paramContext, this.d);
    this.e = PickerContainer.a(paramContext, this.e);
    this.f = PickerContainer.a(paramContext, this.f);
    this.g = PickerContainer.a(paramContext, this.g);
    this.h = PickerContainer.a(paramContext, this.h);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_JavaUtilList.set(j, Integer.valueOf((int)PickerContainer.a(paramContext, ((Integer)this.jdField_a_of_type_JavaUtilList.get(j)).intValue())));
        j += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int j = 0;
    if (this.jdField_c_of_type_Int == 1) {}
    do
    {
      Drawable localDrawable;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_c_of_type_Int != 2) {
                break;
              }
            } while (this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable == null);
            j = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames();
            if (this.jdField_a_of_type_Int >= j) {
              this.jdField_a_of_type_Int = (j - 1);
            }
            localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
          } while (localDrawable == null);
          localDrawable.draw(paramCanvas);
          return;
          if (this.jdField_c_of_type_Int != 3) {
            break;
          }
          localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() - 1);
        } while (localDrawable == null);
        localDrawable.draw(paramCanvas);
        return;
        if (this.jdField_c_of_type_Int != 4) {
          break;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
          j = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames();
        }
        if (this.jdField_a_of_type_Int >= j) {
          this.jdField_a_of_type_Int = (j - 1);
        }
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
        if (localDrawable != null) {
          localDrawable.draw(paramCanvas);
        }
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(this.jdField_a_of_type_Int);
      } while (localDrawable == null);
      localDrawable.draw(paramCanvas);
      return;
    } while (this.jdField_c_of_type_Int != 5);
  }
  
  private int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1000));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(42));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(47));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(54));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(61));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(65));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(67));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(69));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(66));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
  }
  
  private void b(float paramFloat)
  {
    a(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), paramFloat, paramFloat);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("1/2", paramContext.getResources().getDrawable(2130841183));
    this.jdField_a_of_type_JavaUtilMap.put("1/4", paramContext.getResources().getDrawable(2130841184));
    this.jdField_a_of_type_JavaUtilMap.put("1x", paramContext.getResources().getDrawable(2130841185));
    this.jdField_a_of_type_JavaUtilMap.put("2x", paramContext.getResources().getDrawable(2130841186));
    this.jdField_a_of_type_JavaUtilMap.put("4x", paramContext.getResources().getDrawable(2130841187));
    this.jdField_a_of_type_JavaUtilMap.put(PickerContainer.jdField_a_of_type_JavaLangString, paramContext.getResources().getDrawable(2130841210));
    this.jdField_b_of_type_JavaUtilMap.put("1/2", paramContext.getResources().getDrawable(2130841227));
    this.jdField_b_of_type_JavaUtilMap.put("1/4", paramContext.getResources().getDrawable(2130841228));
    this.jdField_b_of_type_JavaUtilMap.put("1x", paramContext.getResources().getDrawable(2130841229));
    this.jdField_b_of_type_JavaUtilMap.put("2x", paramContext.getResources().getDrawable(2130841230));
    this.jdField_b_of_type_JavaUtilMap.put("4x", paramContext.getResources().getDrawable(2130841231));
    this.jdField_b_of_type_JavaUtilMap.put(PickerContainer.jdField_a_of_type_JavaLangString, paramContext.getResources().getDrawable(2130841232));
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    while (this.jdField_c_of_type_Int == 1) {
      return;
    }
    Rect localRect = new Rect((int)this.jdField_a_of_type_AndroidGraphicsRectF.left, (int)this.jdField_a_of_type_AndroidGraphicsRectF.top, (int)this.jdField_a_of_type_AndroidGraphicsRectF.right, (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  private int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void c(float paramFloat)
  {
    a(getBounds().width() - paramFloat, this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height());
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_c_of_type_Int == 2)
    {
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
      {
        paramInt = ((Integer)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).intValue();
        float f1 = this.g;
        c(paramInt + f1);
        b(this.jdField_a_of_type_Float);
      }
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_b_of_type_Int = 51;
      }
    }
    bndy localbndy;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_b_of_type_Int = 127;
          return;
        }
        this.jdField_b_of_type_Int = 255;
        return;
      } while ((this.jdField_c_of_type_Int != 4) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null));
      localbndy = (bndy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbndy == null);
    localbndy.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames());
  }
  
  private void c(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 4) || (this.jdField_c_of_type_Int == 3)) {
      return;
    }
    Rect localRect = getBounds();
    int j = (int)(localRect.right - this.d - this.e);
    int k = (int)(localRect.centerY() - this.f / 2.0F);
    localRect = new Rect(j, k, (int)(j + this.e), (int)(k + this.f));
    if (this.jdField_c_of_type_Int == 5) {
      localRect.offset(0, (int)this.i);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      if (this.jdField_c_of_type_Int != 6) {}
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bndy localbndy;
    do
    {
      return;
      localbndy = (bndy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbndy == null);
    localbndy.e(paramInt);
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bndy localbndy;
    do
    {
      return;
      localbndy = (bndy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbndy == null);
    localbndy.d(paramInt);
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bndy localbndy;
    do
    {
      return;
      localbndy = (bndy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbndy == null);
    localbndy.f(paramInt);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidUtilProperty = null;
    this.jdField_b_of_type_AndroidUtilProperty = null;
    this.jdField_c_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "setAnimState: old state:" + this.jdField_c_of_type_Int + " new state:" + paramInt);
    }
    this.jdField_c_of_type_Int = paramInt;
    switch (this.jdField_c_of_type_Int)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    }
    this.jdField_a_of_type_Int = 0;
    b(this.jdField_a_of_type_Float);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)this.jdField_b_of_type_JavaUtilMap.get(paramString));
    invalidateSelf();
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, bndy parambndy)
  {
    b();
    a(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt1);
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt2);
    this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable = a(paramContext, paramInt3);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambndy);
    b(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 4) && (this.jdField_c_of_type_Int != 3)) {
          break;
        }
        a(paramCanvas);
      } while (this.jdField_c_of_type_Int == 4);
      b(paramCanvas);
      return;
    } while ((this.jdField_c_of_type_Int != 5) && (this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 6));
    c(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int k = 0;
    super.onBoundsChange(paramRect);
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onBoundsChange: mState:" + this.jdField_c_of_type_Int + " bound:" + paramRect);
    }
    int j;
    Drawable localDrawable;
    if (this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(paramRect);
      j = 0;
      while (j < this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        j += 1;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(paramRect);
      j = 0;
      while (j < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        j += 1;
      }
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(paramRect);
      j = k;
      while (j < this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(j);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        j += 1;
      }
    }
    a(paramRect.centerX(), paramRect.centerY(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "start:" + this.jdField_c_of_type_Int + " isRunning:" + this.jdField_a_of_type_Boolean);
    }
    if (isRunning()) {
      stop();
    }
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_c_of_type_Int = 2;
      a(this.jdField_c_of_type_Int, 600);
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_Int == 4) || (this.jdField_c_of_type_Int == 3))
      {
        this.jdField_c_of_type_Int = 4;
        a(this.jdField_c_of_type_Int, 400);
        return;
      }
    } while ((this.jdField_c_of_type_Int != 5) && (this.jdField_c_of_type_Int != 6));
    a(this.jdField_c_of_type_Int, 200);
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "stop:" + this.jdField_c_of_type_Int + " isRunning:" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_AndroidAnimationValueAnimator == null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnds
 * JD-Core Version:    0.7.0.1
 */