import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.qphone.base.util.QLog;

public class anao
  extends View
{
  int jdField_a_of_type_Int;
  public Bitmap a;
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public final Rect a;
  public boolean a;
  int jdField_b_of_type_Int;
  final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d;
  int e;
  public int f;
  
  public anao(ScreenShot paramScreenShot, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    setLongClickable(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null)) {
      this.jdField_a_of_type_Boolean = false;
    }
    do
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
        if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
          localCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
        ScreenShot.a("save and hide");
        ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131717767, 1).show();
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShot", 2, this.jdField_a_of_type_AndroidGraphicsRect.width() + ":" + this.jdField_a_of_type_AndroidGraphicsRect.height(), localIllegalArgumentException);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShot", 2, "", localThrowable);
          }
        }
        ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot).obtainMessage(2, 0, 0, this).sendToTarget();
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
      {
        i = getWidth() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
        j = getHeight() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
        k = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + j;
        float f1 = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, k + i, m);
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(20.0F * getResources().getDisplayMetrics().scaledDensity);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(2.0F, 0.0F, 2.0F * f1, -2147483648);
        paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext.getString(2131718540), getWidth() / 2, m + 26.0F * f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    } while ((this.f == 100001) || (this.f == 0));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int k = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    int i = this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    int m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m + k, j);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    k = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + k;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m, j);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    j = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m, j);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    k = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m + k, j);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label247;
      }
      localObject = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    }
    label240:
    label247:
    for (int i = ((Rect)localObject).top;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null)
      {
        if (this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity()) {
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, i, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight());
        }
      }
      else
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
        {
          this.jdField_a_of_type_AndroidGraphicsRect.left = getLeft();
          this.jdField_a_of_type_AndroidGraphicsRect.right = getRight();
          this.jdField_a_of_type_AndroidGraphicsRect.top = getTop();
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = getBottom();
        }
        if ((this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) && (this.jdField_a_of_type_AndroidGraphicsRect.height() > 0))
        {
          this.jdField_a_of_type_Boolean = true;
          if (!paramBoolean) {
            break label240;
          }
        }
      }
      for (localObject = "1";; localObject = "0")
      {
        bcef.b(null, "CliOper", "", "", "0X8005007", "0X8005007", 0, 0, (String)localObject, "", "", "");
        invalidate();
        return;
        this.jdField_a_of_type_AndroidGraphicsRect.set(i, 0, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
        break;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      localObject = getResources().getDisplayMetrics();
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      if ((((DisplayMetrics)localObject).heightPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth()) && (((DisplayMetrics)localObject).widthPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight()))
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if ((this.f == 0) || (this.f == 100001)) {
        break label639;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      i = this.e + 1;
      this.e = i;
      float f1 = i;
      ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f1));
      invalidate();
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
        if (this.jdField_a_of_type_AndroidGraphicsRect.left > this.jdField_a_of_type_AndroidGraphicsRect.right)
        {
          i = this.jdField_a_of_type_AndroidGraphicsRect.left;
          this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidGraphicsRect.right;
          this.jdField_a_of_type_AndroidGraphicsRect.right = i;
        }
        if (this.jdField_a_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.bottom)
        {
          i = this.jdField_a_of_type_AndroidGraphicsRect.top;
          this.jdField_a_of_type_AndroidGraphicsRect.top = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = i;
        }
        a(paramCanvas);
        return;
        i = getWidth();
        int j = getHeight();
        if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap == null) && (i > 0) && (j > 0)) {}
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap != null)
          {
            localObject = new Canvas(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap);
            this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().draw((Canvas)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap;
          }
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() == i)) {
            break;
          }
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "", localThrowable);
            }
          }
        }
      }
      label639:
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
      this.e = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return super.onTouchEvent(paramMotionEvent);
    case 0: 
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
      if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
        if (this.jdField_a_of_type_AndroidGraphicsRect.contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)) {
          this.f = 100004;
        }
      }
      for (;;)
      {
        invalidate();
        break;
        if (new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - 20, this.jdField_a_of_type_AndroidGraphicsRect.top - 20, this.jdField_a_of_type_AndroidGraphicsRect.right + 20, this.jdField_a_of_type_AndroidGraphicsRect.bottom + 20).contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
        {
          this.f = 100005;
          this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
        }
        else
        {
          this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
          this.f = 100001;
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
          this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
          continue;
          this.f = 100001;
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
        }
      }
    case 1: 
      if (Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.width()) < 5) {
        this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.f = 100002;
        ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, true);
      }
      for (;;)
      {
        invalidate();
        break;
        this.f = 0;
        ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
      }
      this.c = ((int)paramMotionEvent.getX());
      this.d = ((int)paramMotionEvent.getY());
      int j;
      Rect localRect;
      if (this.f == 100004)
      {
        i = this.c - this.jdField_a_of_type_Int;
        j = this.d - this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Int = this.c;
        this.jdField_b_of_type_Int = this.d;
        if ((this.jdField_a_of_type_AndroidGraphicsRect.left + i >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.right + i <= getWidth()))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left += i;
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = (i + localRect.right);
        }
        if ((this.jdField_a_of_type_AndroidGraphicsRect.top + j >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.bottom + j <= getHeight()))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top += j;
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = (j + localRect.bottom);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.d.setVisibility(8);
        invalidate();
        break;
        if (this.f == 100001)
        {
          this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_AndroidGraphicsRect.top = this.jdField_b_of_type_Int;
          this.jdField_a_of_type_AndroidGraphicsRect.right = this.c;
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = this.d;
        }
        else if (this.f == 100005)
        {
          i = this.c - this.jdField_a_of_type_Int;
          j = this.d - this.jdField_b_of_type_Int;
          this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect);
          if (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2)
          {
            localRect = this.jdField_a_of_type_AndroidGraphicsRect;
            localRect.left = (i + localRect.left);
            this.jdField_a_of_type_AndroidGraphicsRect.left = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.left, 0);
          }
          for (;;)
          {
            if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 2) {
              break label815;
            }
            localRect = this.jdField_a_of_type_AndroidGraphicsRect;
            localRect.top = (j + localRect.top);
            this.jdField_a_of_type_AndroidGraphicsRect.top = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.top, 0);
            break;
            localRect = this.jdField_a_of_type_AndroidGraphicsRect;
            localRect.right = (i + localRect.right);
            this.jdField_a_of_type_AndroidGraphicsRect.right = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.right, getWidth());
          }
          label815:
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = (j + localRect.bottom);
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.bottom, getHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */