import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import mqq.util.WeakReference;
import org.xmlpull.v1.XmlPullParser;

public class awzv
  extends Drawable
  implements Handler.Callback, URLDrawable.URLDrawableListener
{
  int jdField_a_of_type_Int = 42;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<awzw> jdField_a_of_type_MqqUtilWeakReference;
  int jdField_b_of_type_Int = 255;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  int c = 0;
  int d = 0;
  int e = 102;
  
  public awzv(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(paramInt);
  }
  
  public awzv(Context paramContext, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, this.jdField_a_of_type_Int);
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = paramContext.getResources().getDisplayMetrics().densityDpi / 2;
    this.jdField_a_of_type_ComTencentImageURLDrawable.setTargetDensity(i);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "MutualMarkIconProxyDrawable density : " + i);
    }
  }
  
  private Drawable a()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    setAlpha(this.e);
  }
  
  public void a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      }
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString))) {
        b();
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    } while ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().applyTheme(paramTheme);
    }
    super.applyTheme(paramTheme);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = 255;
    this.c = 0;
    this.d = 0;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    setAlpha(this.jdField_b_of_type_Int);
  }
  
  public boolean canApplyTheme()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      return a().canApplyTheme();
    }
    return super.canApplyTheme();
  }
  
  public void clearColorFilter()
  {
    if (a() != null) {
      a().clearColorFilter();
    }
    super.clearColorFilter();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (a() != null) {
      a().draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (a() != null)) {
      return a().getAlpha();
    }
    return super.getAlpha();
  }
  
  @Nullable
  public Drawable.Callback getCallback()
  {
    if (a() != null)
    {
      Drawable.Callback localCallback = a().getCallback();
      if (localCallback != null) {
        return localCallback;
      }
    }
    return super.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    if (a() != null) {
      return a().getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  @Nullable
  public ColorFilter getColorFilter()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      return a().getColorFilter();
    }
    return super.getColorFilter();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    if (a() != null) {
      return a().getConstantState();
    }
    return super.getConstantState();
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    if (a() != null) {
      return a().getCurrent();
    }
    return super.getCurrent();
  }
  
  @NonNull
  public Rect getDirtyBounds()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      return a().getDirtyBounds();
    }
    return super.getDirtyBounds();
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (a() != null))
    {
      a().getHotspotBounds(paramRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (a() != null)
    {
      int i = a().getIntrinsicHeight();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getIntrinsicHeight height : " + i + " limitHeight=" + this.jdField_a_of_type_Int);
      }
      return this.jdField_a_of_type_Int;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (a() != null)
    {
      int j = a().getIntrinsicWidth();
      int k = a().getIntrinsicHeight();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (j > 0) {
          i = j * this.jdField_a_of_type_Int / k;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getIntrinsicWidth width : " + i);
      }
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getLayoutDirection()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (a() != null)) {
      return a().getLayoutDirection();
    }
    return super.getLayoutDirection();
  }
  
  public int getMinimumHeight()
  {
    if (a() != null)
    {
      int i = a().getMinimumHeight();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumHeight height : " + i);
      }
      return i;
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (a() != null)
    {
      int i = a().getMinimumWidth();
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumWidth width : " + i);
      }
      return i;
    }
    return super.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(@NonNull Outline paramOutline)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null))
    {
      a().getOutline(paramOutline);
      return;
    }
    super.getOutline(paramOutline);
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (a() != null) {
      return a().getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState()
  {
    if (a() != null) {
      return a().getState();
    }
    return super.getState();
  }
  
  @Nullable
  public Region getTransparentRegion()
  {
    if (a() != null) {
      return a().getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Int <= 0)
      {
        this.c = 0;
        label50:
        if (this.c != 0) {
          break label170;
        }
        this.jdField_b_of_type_Int += 5;
        if (this.jdField_b_of_type_Int >= 255) {
          this.jdField_b_of_type_Int = 255;
        }
      }
      for (;;)
      {
        setAlpha(this.jdField_b_of_type_Int);
        invalidateSelf();
        if (this.jdField_b_of_type_Int != 0) {
          break label195;
        }
        this.d += 1;
        if ((this.d < 3) || (this.jdField_b_of_type_Int < this.e)) {
          break label195;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        break;
        if (this.jdField_b_of_type_Int < 255) {
          break label50;
        }
        this.c = 1;
        break label50;
        label170:
        this.jdField_b_of_type_Int -= 5;
        if (this.jdField_b_of_type_Int <= 0) {
          this.jdField_b_of_type_Int = 0;
        }
      }
      label195:
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 20);
      continue;
      setAlpha(102);
      invalidateSelf();
    }
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet)
  {
    if (a() != null) {
      a().inflate(paramResources, paramXmlPullParser, paramAttributeSet);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public void invalidateSelf()
  {
    if (a() != null) {
      a().invalidateSelf();
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (a() != null)) {
      return a().isAutoMirrored();
    }
    return super.isAutoMirrored();
  }
  
  public boolean isFilterBitmap()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (a() != null)) {
      return a().isFilterBitmap();
    }
    return super.isFilterBitmap();
  }
  
  public boolean isStateful()
  {
    if (a() != null) {
      return a().isStateful();
    }
    return super.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    if (a() != null) {
      a().jumpToCurrentState();
    }
    super.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate()
  {
    Drawable localDrawable = a();
    if (localDrawable != null)
    {
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((SkinnableBitmapDrawable)a()).mutate2();
      }
      while (!(localDrawable instanceof URLDrawable)) {
        return this;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localDrawable.mutate();
      return this;
    }
    return super.mutate();
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (a() != null)) {
      return a().onLayoutDirectionChanged(paramInt);
    }
    return super.onLayoutDirectionChanged(paramInt);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    int k = paramURLDrawable.getIntrinsicWidth();
    int m = paramURLDrawable.getIntrinsicHeight();
    int j = m;
    int i = k;
    if (m > 0)
    {
      j = m;
      i = k;
      if (k > 0)
      {
        i = k * this.jdField_a_of_type_Int / m;
        j = this.jdField_a_of_type_Int;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "onLoadSuccessed width : " + i + " height:" + j);
    }
    if ((i > 0) && (j > 0))
    {
      setBounds(0, 0, i, j);
      invalidateSelf();
      if ((getCallback() != null) && ((getCallback() instanceof View)))
      {
        ((View)getCallback()).invalidate();
        ((View)getCallback()).requestLayout();
      }
      if (this.jdField_a_of_type_MqqUtilWeakReference != null)
      {
        paramURLDrawable = (awzw)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.a();
        }
      }
    }
  }
  
  public void scheduleSelf(@NonNull Runnable paramRunnable, long paramLong)
  {
    if (a() != null) {
      a().scheduleSelf(paramRunnable, paramLong);
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    if (a() != null) {
      a().setAlpha(paramInt);
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (a() != null)) {
      a().setAutoMirrored(paramBoolean);
    }
    super.setAutoMirrored(paramBoolean);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "setBounds [left, top right, bottom] : " + new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (a() != null) {
      a().setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(@NonNull Rect paramRect)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkIconProxyDrawable", 2, "setBounds bounds : " + paramRect);
    }
    if (a() != null) {
      a().setBounds(paramRect);
    }
    super.setBounds(paramRect);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (a() != null) {
      a().setChangingConfigurations(paramInt);
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    if (a() != null) {
      a().setColorFilter(paramInt, paramMode);
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (a() != null) {
      a().setColorFilter(paramColorFilter);
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (a() != null) {
      a().setDither(paramBoolean);
    }
    super.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (a() != null) {
      a().setFilterBitmap(paramBoolean);
    }
    super.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().setHotspot(paramFloat1, paramFloat2);
    }
    super.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfInt)
  {
    if (a() != null) {
      return a().setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().setTint(paramInt);
    }
    super.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().setTintList(paramColorStateList);
    }
    super.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (a() != null)) {
      a().setTintMode(paramMode);
    }
    super.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a() != null) {
      return a().setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(@NonNull Runnable paramRunnable)
  {
    if (a() != null) {
      a().unscheduleSelf(paramRunnable);
    }
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzv
 * JD-Core Version:    0.7.0.1
 */