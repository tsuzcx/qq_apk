import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class baxt
  extends bawo
  implements baxh
{
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  baxu jdField_a_of_type_Baxu;
  FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo;
  boolean b;
  boolean c;
  
  protected baxt(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, baxu parambaxu, boolean paramBoolean2)
  {
    super(paramDrawable1, paramDrawable2);
    this.jdField_c_of_type_Boolean = true;
    long l1 = System.currentTimeMillis();
    a(paramAppInterface);
    this.jdField_a_of_type_Baxu = parambaxu;
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramInt3 = 3;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = new FaceInfo(paramInt1, paramString, false, paramByte, bayd.a((byte)paramInt3), paramBoolean1, paramInt2, paramBoolean2, paramInt4);
    if ((paramInt1 == 4) && (!bamn.a(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int = 113;
    }
    if ((this instanceof bazg))
    {
      paramAppInterface = b();
      if (paramAppInterface == null) {
        break label271;
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramAppInterface);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Baxu != null) {
        this.jdField_a_of_type_Baxu.onLoadingStateChanged(-1, this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "time cost FaceDrawable:" + (l2 - l1));
      }
      return;
      paramAppInterface = a(true);
      break;
      label271:
      this.jdField_a_of_type_Int = 0;
      a();
    }
  }
  
  private static byte a(int paramInt)
  {
    byte b1 = 3;
    if (paramInt == 115) {
      b1 = 4;
    }
    return b1;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      return bbdr.c();
    }
    if ((paramInt1 == 113) || (paramInt1 == 101) || (paramInt1 == 1001)) {
      return bbdr.e();
    }
    if (paramInt1 == 115) {
      return bbdr.a(true);
    }
    if (paramInt2 == 1) {
      return new ColorDrawable(Color.parseColor("#ebe9e9"));
    }
    return bbdr.b();
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    Drawable localDrawable = a(paramInt1, paramInt2);
    return a(paramAppInterface, paramInt1, paramString, paramInt2, localDrawable, localDrawable);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i = a(paramInt);
    Drawable localDrawable = a(paramInt, i);
    return a(paramAppInterface, paramInt, paramString, i, localDrawable, localDrawable);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    int i = a(paramInt1);
    Drawable localDrawable = a(paramInt1, i);
    return a(paramAppInterface, paramInt1, paramString, i, localDrawable, localDrawable, paramInt2);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt3)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, null);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, baxu parambaxu)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, paramDrawable1, paramDrawable2, parambaxu, false);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, baxu parambaxu, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1 + ",appIntf=" + paramAppInterface);
      }
    }
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new baxv(paramAppInterface, paramInt1, 200, paramString, (byte)0, paramInt2, 100, false, paramDrawable1, paramDrawable2, parambaxu, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new bazg(paramAppInterface, paramInt1, 200, paramString, (byte)1, paramInt2, false, paramDrawable1, paramDrawable2, parambaxu, paramBoolean);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, baxu parambaxu)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, parambaxu, false);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, baxu parambaxu, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new baxv(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, parambaxu, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new bazg(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, parambaxu, paramBoolean);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt1 + ",appIntf=" + paramAppInterface + ",shape=" + paramInt2);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, paramInt2);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new baxv(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, 100, true, localDrawable, localDrawable, null, paramBoolean);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new bazg(paramAppInterface, 32, paramInt1, paramString, (byte)1, paramInt2, true, localDrawable, localDrawable, null, paramBoolean);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramAppInterface, paramInt, paramString, paramBoolean, false);
  }
  
  public static baxt a(AppInterface paramAppInterface, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", idType=" + paramInt + ",appIntf=" + paramAppInterface);
      }
    }
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(32, 3);
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new baxv(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, 100, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new bazg(paramAppInterface, 32, paramInt, paramString, (byte)1, 3, paramBoolean1, localDrawable, localDrawable, null, paramBoolean2);
  }
  
  public static baxt a(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = a(1, paramByte);
    return a(paramAppInterface, 1, paramString, paramByte, localDrawable, localDrawable);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "http://q.qlogo.cn/qqapp/" + paramString2 + "/" + paramString1 + "/100";
  }
  
  public static baxt b(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    return a(paramAppInterface, paramInt1, paramString, paramInt2, false);
  }
  
  public static baxt b(AppInterface paramAppInterface, String paramString, byte paramByte)
  {
    Drawable localDrawable = a(11, paramByte);
    return a(paramAppInterface, 11, paramString, paramByte, localDrawable, localDrawable);
  }
  
  protected abstract Bitmap a(boolean paramBoolean);
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      setCallback(null);
      this.jdField_a_of_type_Baxu = null;
      a(null);
    }
    super.a();
  }
  
  protected abstract void a(AppInterface paramAppInterface);
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((this.jdField_b_of_type_Boolean) || (paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (!paramFaceInfo.equals(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo))) {
      return;
    }
    b();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDrawable", 2, "onDecodeTaskCompleted.faceInfo=" + paramFaceInfo + ", avatrar=" + paramBitmap);
    }
    if ((this.jdField_b_of_type_Boolean) || (paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (!paramFaceInfo.equals(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo))) {
      return;
    }
    paramFaceInfo = null;
    int j = 0;
    if (paramBitmap != null) {
      paramFaceInfo = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    }
    int i;
    if (paramFaceInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFaceInfo;
      i = 1;
      label107:
      if (i == 0) {
        break label247;
      }
      i = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label249;
      }
      this.jdField_a_of_type_Int = 1;
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
    }
    for (;;)
    {
      invalidateSelf();
      if ((i == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Baxu == null)) {
        break;
      }
      this.jdField_a_of_type_Baxu.onLoadingStateChanged(i, this.jdField_a_of_type_Int);
      return;
      i = j;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break label107;
      }
      i = j;
      if (this.jdField_a_of_type_Int == 2) {
        break label107;
      }
      i = 1;
      break label107;
      label247:
      break;
      label249:
      this.jdField_a_of_type_Int = 2;
      if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (this.jdField_b_of_type_Int != -1) {
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
        }
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected abstract boolean a();
  
  protected abstract Bitmap b();
  
  protected abstract void b();
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.jdField_c_of_type_Boolean) && (bfwa.a()))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getBounds());
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c == 1))
      {
        super.draw(paramCanvas);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 10.0F, 10.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      super.draw(paramCanvas);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxt
 * JD-Core Version:    0.7.0.1
 */