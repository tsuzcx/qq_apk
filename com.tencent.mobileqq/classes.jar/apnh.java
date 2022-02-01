import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.1;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.2;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apnh
  implements apng, RecogCallback
{
  public static boolean c;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Handler jdField_a_of_type_AndroidOsHandler;
  apnc jdField_a_of_type_Apnc;
  public apni a;
  public volatile boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public apnh(Handler paramHandler, Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, paramRect.height(), paramRect.width());
      this.jdField_a_of_type_AndroidGraphicsRect.offset(paramRect.top, paramRect.left);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect, this.jdField_a_of_type_AndroidGraphicsRect }));
      }
    }
    System.currentTimeMillis();
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
          }
          paramArrayOfByte = null;
        }
        try
        {
          paramRect = Bitmap.createBitmap(paramArrayOfByte, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
          if (paramRect != paramArrayOfByte) {
            paramArrayOfByte.recycle();
          }
          return paramRect;
        }
        catch (Throwable paramArrayOfByte) {}
      } while (!QLog.isColorLevel());
      QLog.i("QRSession.MiniRecog", 2, "recognizeDetect exception", paramArrayOfByte);
    }
    return null;
  }
  
  private String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!apnc.a()) {
      paramArrayOfByte = null;
    }
    String str;
    do
    {
      return paramArrayOfByte;
      str = this.jdField_a_of_type_Apnc.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, "recognizeNoAI resultStr:" + str);
      }
      paramArrayOfByte = str;
    } while (apnc.a(str));
    return null;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Apnc = apnc.a();
    this.jdField_a_of_type_Apnc.a(this);
    this.jdField_a_of_type_Apnc.a(this);
    this.jdField_a_of_type_Apnc.a(this.jdField_a_of_type_AndroidContentContext, hashCode(), "MiniRecog");
    this.jdField_c_of_type_Int = RecogUtil.getSupportDetectType();
    if (this.jdField_c_of_type_Int >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return 0;
    }
  }
  
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    try
    {
      if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length != paramInt1 * paramInt2)) {
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt1 * paramInt2];
      }
      if (apnc.a(this.jdField_a_of_type_ArrayOfInt, paramArrayOfByte, paramInt1, paramInt2) == 0) {
        localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      return localBitmap;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.i("QRSession.MiniRecog", 2, "getBitmapFromYuv error ", paramArrayOfByte);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(apnb paramapnb)
  {
    this.jdField_a_of_type_Apni = ((apni)paramapnb);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, Rect paramRect, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, ScannerResult paramScannerResult, ArrayList<apmz> paramArrayList)
  {
    if (!apnc.a()) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    int i;
    if ((apnc.b()) && (this.jdField_a_of_type_Apnc.c())) {
      i = 1;
    }
    Object localObject1;
    while ((this.jdField_b_of_type_Boolean) && (i != 0))
    {
      paramScannerResult.jdField_a_of_type_Boolean = true;
      long l2 = System.currentTimeMillis();
      paramArrayOfByte1 = a(paramArrayOfByte1, paramInt1, paramInt2, paramRect);
      if (paramArrayOfByte1 == null)
      {
        return false;
        i = 0;
      }
      else
      {
        localObject1 = new ArrayList();
        boolean bool = apnc.a().a(paramArrayOfByte1, l2, (ArrayList)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("QRSession.MiniRecog", 2, String.format("recognize exec=%b, detectRects=%s", new Object[] { Boolean.valueOf(bool), localObject1 }));
        }
        paramArrayOfByte1.recycle();
        if ((!bool) || (((ArrayList)localObject1).isEmpty())) {
          break label472;
        }
        paramArrayOfByte1 = ((ArrayList)localObject1).iterator();
      }
    }
    while (paramArrayOfByte1.hasNext())
    {
      localObject1 = (apmz)paramArrayOfByte1.next();
      if (!((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.isEmpty())
      {
        Rect localRect = new Rect(((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect);
        localRect.offset(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
        Object localObject2 = new apmz();
        ((apmz)localObject2).jdField_a_of_type_AndroidGraphicsRect.set(localRect);
        ((apmz)localObject2).jdField_a_of_type_Int = ((apmz)localObject1).jdField_a_of_type_Int;
        ((apmz)localObject2).jdField_a_of_type_Float = ((apmz)localObject1).jdField_a_of_type_Float;
        paramArrayList.add(localObject2);
        if (((apmz)localObject1).jdField_a_of_type_Int == 2)
        {
          localObject2 = new Rect();
          localRect = new Rect();
          localRect.set(0, 0, ((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.height(), ((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.width());
          localRect.offset(paramInt3 - ((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.top - ((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.height(), ((apmz)localObject1).jdField_a_of_type_AndroidGraphicsRect.left);
          RecogUtil.scaleRect(localRect, (Rect)localObject2, paramInt3, paramInt4, 1.2F);
          localObject2 = a(paramArrayOfByte2, paramInt3, paramInt4, ((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).width(), ((Rect)localObject2).height());
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localRect.offset(paramRect.left, paramRect.top);
            paramScannerResult.a((String)localObject2, localRect, ((apmz)localObject1).jdField_a_of_type_Float, paramInt2, paramInt1);
            continue;
            paramArrayOfByte1 = a(paramArrayOfByte2, paramInt3, paramInt4, 0, 0, 0, 0);
            paramScannerResult.jdField_a_of_type_Boolean = false;
            if (!TextUtils.isEmpty(paramArrayOfByte1)) {
              paramScannerResult.a(paramArrayOfByte1);
            }
          }
        }
      }
    }
    label472:
    if (QLog.isColorLevel()) {
      QLog.i("QRSession.MiniRecog", 2, String.format("------>recognize Mini suc=%b minicode_timecost=%d result=%s \nrects=%s", new Object[] { Boolean.valueOf(paramScannerResult.c()), Long.valueOf(System.currentTimeMillis() - l1), paramScannerResult, paramArrayList }));
    }
    return paramScannerResult.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apnc != null)
    {
      this.jdField_a_of_type_Apnc.c(this);
      this.jdField_a_of_type_Apnc.b(this);
      this.jdField_a_of_type_Apnc.a(hashCode(), "MiniRecog");
    }
  }
  
  public void b(int paramInt) {}
  
  public void onDetectReady(int paramInt)
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if ((QLog.isColorLevel()) || (apno.a())) {
      QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", new Object[] { Long.valueOf(l) }));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.2(this));
    apno.d(this.jdField_c_of_type_Int, (int)l);
  }
  
  public void onDetectResult(List<apmz> paramList, long paramLong) {}
  
  public void onSaveImg(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnh
 * JD-Core Version:    0.7.0.1
 */