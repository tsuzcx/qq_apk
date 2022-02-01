import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apep
  extends apec
  implements aozc, apcs, apde
{
  private long jdField_a_of_type_Long = 500L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private apcs jdField_a_of_type_Apcs;
  private apdd jdField_a_of_type_Apdd;
  private apde jdField_a_of_type_Apde;
  private apdm jdField_a_of_type_Apdm;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  private boolean jdField_c_of_type_Boolean;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private Rect jdField_d_of_type_AndroidGraphicsRect;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = SystemClock.uptimeMillis();
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  public apep()
  {
    this.jdField_b_of_type_Int = 0;
    apek.a().b(this);
    apek.a().a(this);
  }
  
  private static float a(Rect paramRect1, Rect paramRect2, Point paramPoint)
  {
    int i2 = paramPoint.x;
    int i3 = paramRect2.left;
    int i4 = paramRect2.right;
    int i5 = paramPoint.x;
    int k = paramPoint.y;
    int m = paramRect2.top;
    int n = paramRect2.bottom;
    int i1 = paramPoint.y;
    int i;
    int j;
    label92:
    float f1;
    label108:
    float f2;
    label125:
    float f5;
    label155:
    label177:
    float f3;
    if (paramRect1.left < paramPoint.x)
    {
      i = paramPoint.x - paramRect1.left;
      if (paramRect1.right <= paramPoint.x) {
        break label395;
      }
      j = paramRect1.right - paramPoint.x;
      if (i <= 0) {
        break label401;
      }
      f1 = (i2 - i3) / i;
      if (j <= 0) {
        break label407;
      }
      f2 = (i4 - i5) / j;
      f5 = Math.min(f1, f2);
      if (paramRect1.top >= paramPoint.y) {
        break label414;
      }
      i = paramPoint.y - paramRect1.top;
      if (paramRect1.bottom <= paramPoint.y) {
        break label420;
      }
      j = paramRect1.bottom - paramPoint.y;
      if (i <= 0) {
        break label426;
      }
      f3 = (k - m) / i;
      label194:
      if (j <= 0) {
        break label433;
      }
    }
    float f8;
    label395:
    label401:
    label407:
    label414:
    label420:
    label426:
    label433:
    for (float f4 = (n - i1) / j;; f4 = 2.147484E+009F)
    {
      f5 = Math.min(f5, Math.min(f3, f4));
      float f6 = paramRect2.width() / paramRect1.width();
      float f7 = paramRect2.height() / paramRect1.height();
      f8 = Math.min(f6, f7);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_ori [codeRect,scanRect,prevCenter]=[%s|%s|%s]", new Object[] { paramRect1.toShortString(), paramRect2.toShortString(), paramPoint.toString() }));
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_calc [ratioLeft,ratioRight]=[%.2f,%.2f], [ratioTop,ratioBot]=[%.2f,%.2f] [wFactor,hFactor]=[%.2f,%.2f]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7) }));
      }
      if ((f5 < 0.0F) || (f8 <= f5)) {
        break label440;
      }
      return f5;
      i = 0;
      break;
      j = 0;
      break label92;
      f1 = 2.147484E+009F;
      break label108;
      f2 = 2.147484E+009F;
      break label125;
      i = 0;
      break label155;
      j = 0;
      break label177;
      f3 = 2.147484E+009F;
      break label194;
    }
    label440:
    return f8;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = -1;
    int k = n;
    if (paramArrayOfByte.length > paramInt1 * paramInt2)
    {
      k = 0;
      int i = 0;
      int j = 0;
      while (k < paramInt2)
      {
        int m = i;
        int i1 = 0;
        i = j;
        j = m;
        m = i1;
        while (m < paramInt1)
        {
          i += (paramArrayOfByte[(k * paramInt1 + m)] & 0xFF);
          j += 1;
          m += 3;
        }
        m = k + 3;
        k = i;
        i = j;
        j = k;
        k = m;
      }
      k = n;
      if (i > 0) {
        k = j / i;
      }
    }
    return k;
  }
  
  private void a()
  {
    if ((this.jdField_d_of_type_Int <= 0) || (this.jdField_e_of_type_Int <= 0)) {
      return;
    }
    float f1 = this.jdField_e_of_type_Int / apfe.jdField_a_of_type_Int;
    float f2 = this.jdField_d_of_type_Int / apfe.jdField_b_of_type_Int;
    Rect localRect1 = new Rect((int)(this.jdField_a_of_type_AndroidGraphicsRect.left * f1), (int)(this.jdField_a_of_type_AndroidGraphicsRect.top * f2), (int)(f1 * this.jdField_a_of_type_AndroidGraphicsRect.right), (int)(f2 * this.jdField_a_of_type_AndroidGraphicsRect.bottom));
    Rect localRect2 = new Rect(0, 0, (int)(localRect1.width() * 1.5F), (int)(localRect1.height() * 1.5F));
    localRect2.offset(localRect1.centerX() - localRect2.centerX(), localRect1.centerY() - localRect2.centerY());
    localRect2.intersect(0, 0, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
    Rect localRect3 = new Rect(0, 0, localRect1.height(), localRect1.width());
    localRect3.offset(localRect1.top, localRect1.left);
    Rect localRect4 = new Rect(0, 0, (int)(1.3F * localRect3.width()), (int)(1.2F * localRect3.height()));
    localRect4.offset(localRect3.centerX() - localRect4.centerX(), localRect3.centerY() - localRect4.centerY());
    localRect4.intersect(0, 0, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("QRSession", 2, String.format("initScanRect [mScanRect,qRRecogRect,qRRecogRectExt,rotateQRRecogRectExt]=[%s, %s, %s, %s] [w,h]=[%d,%d]", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect.toShortString(), localRect1.toShortString(), localRect2.toShortString(), localRect4.toShortString(), Integer.valueOf(apfe.jdField_a_of_type_Int), Integer.valueOf(apfe.jdField_b_of_type_Int) }));
    }
    this.jdField_b_of_type_AndroidGraphicsRect = localRect1;
    this.jdField_d_of_type_AndroidGraphicsRect = localRect2;
    this.jdField_c_of_type_AndroidGraphicsRect = localRect4;
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    if ((paramRect1 != null) && (paramRect1.width() > 0) && (paramRect1.height() > 0))
    {
      localRect.set(0, 0, paramRect1.height(), paramRect1.width());
      localRect.offset(this.jdField_e_of_type_Int - paramRect1.top - paramRect1.height(), paramRect1.left);
    }
    if ((localRect.width() > 0) && (localRect.height() > 0))
    {
      paramRect2.set(localRect);
      float f1 = apfe.jdField_a_of_type_Int / this.jdField_e_of_type_Int;
      float f2 = apfe.jdField_b_of_type_Int / this.jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("getScreenRect [%.2f,%.2f, %d,%d,%d,%d]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(apfe.jdField_a_of_type_Int), Integer.valueOf(apfe.jdField_b_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) }));
      }
      paramRect2.left = ((int)(paramRect2.left * f1));
      paramRect2.top = ((int)(paramRect2.top * f2));
      paramRect2.right = ((int)(f1 * paramRect2.right));
      paramRect2.bottom = ((int)(paramRect2.bottom * f2));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("[------ detect_point 2 rect=%s previewRect=%s screenRect=%s isQr=%b ------]", new Object[] { paramRect1, localRect, paramRect2, Boolean.valueOf(paramBoolean) }));
    }
  }
  
  private void a(List<apcu> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    if (this.jdField_e_of_type_Long > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_e_of_type_Long;
      this.jdField_e_of_type_Long = 0L;
      apdk.f(this.jdField_a_of_type_Apdd.b(), (int)(l1 - l2));
    }
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("onGetDetectRect:");
      i = 0;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append(((apcu)paramList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.i("QRSession", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = System.currentTimeMillis();
    boolean bool2;
    boolean bool7;
    boolean bool5;
    boolean bool6;
    label166:
    boolean bool9;
    boolean bool8;
    boolean bool11;
    boolean bool10;
    Rect localRect;
    boolean bool4;
    boolean bool3;
    boolean bool1;
    label324:
    float f3;
    label390:
    float f4;
    float f2;
    float f1;
    if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int))
    {
      bool2 = false;
      bool7 = false;
      bool5 = false;
      bool6 = false;
      i = 0;
      bool9 = bool6;
      bool8 = bool5;
      bool11 = bool7;
      bool10 = bool2;
      if (i < paramList.size())
      {
        localObject = (apcu)paramList.get(i);
        bool8 = bool6;
        bool9 = bool5;
        bool10 = bool7;
        bool11 = bool2;
        if (((apcu)localObject).jdField_a_of_type_AndroidGraphicsRect.width() > 0)
        {
          bool8 = bool6;
          bool9 = bool5;
          bool10 = bool7;
          bool11 = bool2;
          if (((apcu)localObject).jdField_a_of_type_AndroidGraphicsRect.height() > 0)
          {
            localRect = ((apcu)localObject).jdField_a_of_type_AndroidGraphicsRect;
            if (((apcu)localObject).jdField_a_of_type_Int == 2)
            {
              bool6 = true;
              bool7 = a(localRect);
              bool4 = bool6;
              bool3 = bool5;
              bool1 = bool7;
              if (!bool7)
              {
                bool2 = b(localRect);
                bool1 = bool7;
                bool3 = bool5;
                bool4 = bool6;
              }
              bool9 = bool4;
              bool8 = bool3;
              bool11 = bool1;
              bool10 = bool2;
              if (bool2) {
                break label1052;
              }
              bool8 = bool4;
              bool9 = bool3;
              bool10 = bool1;
              bool11 = bool2;
              if (!bool1) {
                break label1004;
              }
              bool5 = bool4;
              bool6 = bool3;
              bool4 = bool2;
              bool3 = bool1;
              bool2 = bool6;
              bool1 = bool5;
              f3 = 0.0F;
              f4 = 0.0F;
              f2 = f4;
              f1 = f3;
              if (bool4) {
                break label1041;
              }
              f2 = f4;
              f1 = f3;
              if (bool3) {
                break label1041;
              }
              f2 = f4;
              f1 = f3;
            }
          }
        }
      }
    }
    for (;;)
    {
      float f5;
      try
      {
        if (((apcu)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.width() <= 0) {
          break label1041;
        }
        f2 = f4;
        f1 = f3;
        if (((apcu)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.height() <= 0) {
          break label1041;
        }
        if (this.jdField_f_of_type_Long != 0L)
        {
          f2 = f4;
          f1 = f3;
          if (SystemClock.uptimeMillis() - this.jdField_f_of_type_Long <= 500L) {
            break label1041;
          }
        }
        f4 = ((apcu)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_c_of_type_AndroidGraphicsRect.width();
        f3 = ((apcu)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.height() / this.jdField_c_of_type_AndroidGraphicsRect.height();
        if ((f4 >= 0.7F) || (f3 >= 0.7F)) {
          break label1029;
        }
        bool5 = true;
        if (QLog.isColorLevel()) {
          QLog.i("QRSession", 2, String.format("[wRatio,hRatio,need]=[%.2f %.2f %b]", new Object[] { Float.valueOf(f4), Float.valueOf(f3), Boolean.valueOf(bool5) }));
        }
        f2 = f3;
        f1 = f4;
        if (!bool5) {
          break label1041;
        }
        paramList = new Rect(((apcu)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect);
        localObject = new Point(this.jdField_d_of_type_Int / 2, this.jdField_e_of_type_Int / 2);
        f5 = a(paramList, this.jdField_c_of_type_AndroidGraphicsRect, (Point)localObject);
        f2 = f3;
        f1 = f4;
        if (f5 < 1.2F) {
          break label1041;
        }
        if (f5 <= 25.0F) {
          break label1035;
        }
        f1 = 25.0F;
        bool5 = apek.a().a(f1, false);
        this.g |= bool5;
        if (!bool5) {
          break label1086;
        }
        this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
        apek.a().c();
      }
      catch (Throwable paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, String.format("doRecognizeInternal ...async onGetDetectRect has=[%b,%b] suc=[%b,%b] zoom=%b [%.2f,%.2f] minicode_timecost=%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Float.valueOf(f3), Float.valueOf(f1), Long.valueOf(System.currentTimeMillis() - l1) }));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, paramList.getMessage(), paramList);
      return;
      if (((apcu)localObject).jdField_a_of_type_Int == 1)
      {
        bool5 = true;
        bool8 = b(localRect);
        bool4 = bool6;
        bool3 = bool5;
        bool1 = bool7;
        bool2 = bool8;
        if (bool8) {
          break label324;
        }
        bool1 = a(localRect);
        bool4 = bool6;
        bool3 = bool5;
        bool2 = bool8;
        break label324;
      }
      bool4 = bool6;
      bool3 = bool5;
      bool1 = bool7;
      if (((apcu)localObject).jdField_a_of_type_Int != 3) {
        break label324;
      }
      bool8 = b(localRect);
      bool4 = bool6;
      bool3 = bool5;
      bool1 = bool7;
      bool2 = bool8;
      if (bool8) {
        break label324;
      }
      bool1 = a(localRect);
      bool4 = bool6;
      bool3 = bool5;
      bool2 = bool8;
      break label324;
      label1004:
      i += 1;
      bool6 = bool8;
      bool5 = bool9;
      bool7 = bool10;
      bool2 = bool11;
      break label166;
      label1029:
      bool5 = false;
      continue;
      label1035:
      f1 = f5;
      continue;
      label1041:
      f3 = f1;
      bool5 = false;
      f1 = f2;
      continue;
      label1052:
      bool3 = bool11;
      bool4 = bool10;
      bool1 = bool9;
      bool2 = bool8;
      break label390;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      bool1 = false;
      break label390;
      label1086:
      bool5 = true;
      f1 = f3;
      f3 = f4;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int j = -1;
    long l1 = System.currentTimeMillis();
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i = j;
    long l2;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      i = j;
      if (l1 - this.jdField_c_of_type_Long > 1000L)
      {
        l2 = System.currentTimeMillis();
        i = a(this.jdField_b_of_type_ArrayOfByte, paramInt1, paramInt2);
        if (i >= this.jdField_c_of_type_Int) {
          break label152;
        }
      }
    }
    label152:
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      this.jdField_c_of_type_Long = l1;
      if ((this.jdField_a_of_type_Apcs != null) && (this.jdField_a_of_type_Int == 2) && (i >= 0)) {
        this.jdField_a_of_type_Apcs.a(i);
      }
      return bool1;
    }
  }
  
  private boolean a(Rect paramRect)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Apdd.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), true);
      return bool;
    }
    catch (Throwable paramRect)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, paramRect.getMessage(), paramRect);
      }
    }
    return false;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Apdm.a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Apdd.a();
    this.jdField_b_of_type_Boolean = true;
  }
  
  private boolean b(Rect paramRect)
  {
    boolean bool = false;
    if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length != paramRect.width() * paramRect.height() * 3 / 2)) {
      this.jdField_c_of_type_ArrayOfByte = new byte[paramRect.width() * paramRect.height() * 3 / 2];
    }
    int[] arrayOfInt = new int[2];
    if (ImgProcessScan.gray_rotate_crop_sub(this.jdField_c_of_type_ArrayOfByte, arrayOfInt, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), 90, 0) == 0) {
      bool = this.jdField_a_of_type_Apdm.a(this.jdField_c_of_type_ArrayOfByte, arrayOfInt[0], arrayOfInt[1], true);
    }
    return bool;
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Apdm.a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Apdd.a();
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession", 2, "unInitQbar fail!", localException);
    }
  }
  
  private void d()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("doRecognizeInternal ");; localStringBuilder = null)
    {
      boolean bool1 = false;
      boolean bool2;
      boolean bool3;
      if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int))
      {
        if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_d_of_type_AndroidGraphicsRect == null)) {
          a();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
        bool1 = this.jdField_a_of_type_Apdd.a();
        if ((this.jdField_f_of_type_Int >= 2) && (bool1)) {
          break label480;
        }
        int i = this.jdField_d_of_type_AndroidGraphicsRect.top;
        int j = this.jdField_d_of_type_AndroidGraphicsRect.left;
        int k = this.jdField_d_of_type_AndroidGraphicsRect.height();
        int m = this.jdField_d_of_type_AndroidGraphicsRect.width();
        if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != k * m * 3 / 2)) {
          this.jdField_b_of_type_ArrayOfByte = new byte[k * m * 3 / 2];
        }
        int[] arrayOfInt = new int[2];
        if (ImgProcessScan.gray_rotate_crop_sub(this.jdField_b_of_type_ArrayOfByte, arrayOfInt, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, i, j, k, m, 90, 0) == 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          long l2 = System.currentTimeMillis();
          boolean bool4 = this.jdField_a_of_type_Apdm.a(this.jdField_b_of_type_ArrayOfByte, i, j, false);
          long l3 = System.currentTimeMillis();
          if ((bool4) || (!this.jdField_a_of_type_Apdd.a(this.jdField_b_of_type_ArrayOfByte, i, j, false))) {
            break label468;
          }
          bool2 = true;
          long l4 = System.currentTimeMillis();
          if ((bool4) || (bool2) || (!a(i, j))) {
            break label474;
          }
          bool3 = true;
          label289:
          if ((!bool3) && (!bool4) && (!bool2)) {
            this.jdField_f_of_type_Int += 1;
          }
          if ((bool4) || (bool2))
          {
            this.jdField_f_of_type_Int = 0;
            this.jdField_d_of_type_Long = 0L;
          }
          apdk.a((int)(l3 - l2), 0);
          apdk.a((int)(l4 - l3), 1);
          if (localStringBuilder != null) {
            localStringBuilder.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.jdField_f_of_type_Int) }));
          }
        }
      }
      for (;;)
      {
        if ((QLog.isColorLevel()) && (localStringBuilder != null))
        {
          QLog.i("QRSession", 2, localStringBuilder.toString());
          QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end isReady2Detect=%b minicode_timecost=%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(System.currentTimeMillis() - l1) }));
        }
        return;
        label468:
        bool2 = false;
        break;
        label474:
        bool3 = false;
        break label289;
        label480:
        this.jdField_d_of_type_Long = this.jdField_a_of_type_Apdd.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_AndroidGraphicsRect);
        this.jdField_f_of_type_Int = 0;
        if (this.jdField_d_of_type_Long > 0L) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 350L);
        }
        if (localStringBuilder != null) {
          localStringBuilder.append(String.format("...2 detect ts=%d", new Object[] { Long.valueOf(this.jdField_d_of_type_Long) }));
        }
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Apde != null) {
      this.jdField_a_of_type_Apde.a(paramLong);
    }
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    super.a(paramContext, paramAppInterface);
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QRRecognizerController", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new apeq(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Apdm = new apdm(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Apdm.a(this);
    this.jdField_a_of_type_Apdd = new apdd(this.jdField_a_of_type_AndroidOsHandler, paramContext);
    this.jdField_a_of_type_Apdd.a(this);
    this.jdField_a_of_type_Long = 250L;
    if (aoxi.a().jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = 120L;
    }
    this.jdField_c_of_type_Int = aoxi.a().jdField_c_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
    QLog.i("QRSession", 1, String.format("init mQRRecognizeInterval=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  public void a(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
      a();
    }
  }
  
  public void a(apcs paramapcs, apde paramapde)
  {
    this.jdField_a_of_type_Apcs = paramapcs;
    this.jdField_a_of_type_Apde = paramapde;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 2;
    this.jdField_e_of_type_Long = 0L;
    if ((this.jdField_a_of_type_Apcs != null) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_Apcs.a(paramString1.toString(), paramString2.toString(), paramBoolean);
    }
    if (paramBoolean) {}
    for (;;)
    {
      apdk.a(i);
      return;
      if (this.g) {
        i = 6;
      } else {
        i = 1;
      }
    }
  }
  
  public void a(List<apcu> paramList, long paramLong)
  {
    if ((this.jdField_a_of_type_Apde != null) && (!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (paramLong == this.jdField_d_of_type_Long))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        apcu localapcu1 = new apcu();
        apcu localapcu2 = new apcu();
        localapcu1.jdField_a_of_type_Int = ((apcu)paramList.get(i)).jdField_a_of_type_Int;
        localapcu2.jdField_a_of_type_Int = ((apcu)paramList.get(i)).jdField_a_of_type_Int;
        localapcu1.jdField_a_of_type_Float = ((apcu)paramList.get(i)).jdField_a_of_type_Float;
        localapcu2.jdField_a_of_type_Float = ((apcu)paramList.get(i)).jdField_a_of_type_Float;
        localapcu1.jdField_a_of_type_AndroidGraphicsRect = ((apcu)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect;
        Rect localRect = ((apcu)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect;
        if ((localRect.width() > 0) && (localRect.height() > 0)) {
          a(localRect, localapcu2.jdField_a_of_type_AndroidGraphicsRect, true);
        }
        localArrayList1.add(localapcu1);
        localArrayList2.add(localapcu2);
        i += 1;
      }
      if (this.jdField_a_of_type_Apde != null) {
        this.jdField_a_of_type_Apde.a(localArrayList2, paramLong);
      }
      a(localArrayList1);
    }
    if (paramLong == this.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      apdk.a((int)(System.currentTimeMillis() - paramLong), 2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    int i;
    if ((this.jdField_a_of_type_Apdd != null) && (this.jdField_a_of_type_Apdd.b()))
    {
      i = 1;
      if (QLog.isColorLevel()) {
        if (i == 0) {
          break label203;
        }
      }
    }
    label203:
    for (int j = 1;; j = 0)
    {
      QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Integer.valueOf(j) }));
      if ((this.jdField_a_of_type_Apcs != null) && (this.jdField_a_of_type_Int == 2))
      {
        if ((paramBoolean) && (paramFloat > 0.003F) && (i == 0))
        {
          float f2 = (float)(Math.sqrt(paramFloat) * 100.0D) * 0.75F;
          float f1 = f2;
          if (f2 >= 1.2F)
          {
            f1 = f2;
            if (f2 > 25.0F) {
              f1 = 25.0F;
            }
            apek.a().a(f1, false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("QRSession", 2, String.format("onRecognizeFail onGetDetectRect ratio=%.2f", new Object[] { Float.valueOf(f1) }));
          }
        }
        this.jdField_a_of_type_Apcs.a(paramBoolean, paramFloat);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_e_of_type_Long = 0L;
    }
    if ((this.jdField_a_of_type_Apde != null) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_Apde.a(paramBoolean1, paramString, paramBoolean2);
    }
    int i;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label60;
      }
      i = 4;
    }
    for (;;)
    {
      apdk.a(i);
      return;
      label60:
      if (this.g) {
        i = 5;
      } else {
        i = 3;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l;
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) && (this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_f_of_type_Boolean) && ((paramBoolean) || ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(101)) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(102)))))
    {
      l = System.currentTimeMillis();
      if ((paramBoolean) || (l - this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)) {}
    }
    else
    {
      return;
    }
    if (a(paramArrayOfByte, paramInt1, paramInt2))
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramArrayOfByte.length)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
    }
    for (this.jdField_b_of_type_Long = l;; this.jdField_b_of_type_Long = 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      return;
      this.jdField_d_of_type_Int = 0;
      this.jdField_e_of_type_Int = 0;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a(paramArrayOfByte, apek.a().a(), apek.a().b(), this.jdField_d_of_type_Boolean);
      if (apdk.a()) {
        apdk.b();
      }
    }
    this.jdField_d_of_type_Boolean = false;
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (this.g) {
      this.g = false;
    }
  }
  
  public void h()
  {
    super.h();
    if (this.g) {
      apek.a().d();
    }
    if (apdk.a()) {
      apdk.c();
    }
  }
  
  public void j()
  {
    super.j();
    c();
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    apek.a().c(this);
    apek.a().b(this);
    apdk.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apep
 * JD-Core Version:    0.7.0.1
 */