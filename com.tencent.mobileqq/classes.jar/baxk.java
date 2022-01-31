import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecoder.1;
import com.tencent.mobileqq.util.FaceInfo;

public class baxk
{
  baxm a;
  
  public baxk(Context paramContext, AppInterface paramAppInterface)
  {
    this(paramAppInterface);
  }
  
  public baxk(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.a = new baxo((QQAppInterface)paramAppInterface);
    }
    while (this.a == null)
    {
      throw new NullPointerException("can not Instantiation FaceDecoder");
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.a = new bazi((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  private byte a(int paramInt)
  {
    byte b = 3;
    if (paramInt == 115) {
      b = 4;
    }
    return b;
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramQQAppInterface == null) || (paramFaceInfo == null)) {
      return;
    }
    ThreadManager.post(new FaceDecoder.1(paramFaceInfo, paramQQAppInterface), 10, null, true);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    if (paramInt == 32) {
      return null;
    }
    byte b = a(paramInt);
    if ((paramInt == 101) || (paramInt == 1001)) {
      b = 3;
    }
    return this.a.a(paramInt, paramString, 0, b);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2)
  {
    return a(paramInt1, paramString, paramInt2, (byte)3);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    return this.a.a(paramInt1, paramString, paramInt2, paramByte);
  }
  
  public void a()
  {
    this.a.c();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    this.a.a(paramInt1, paramString, paramInt2, paramLong);
  }
  
  public void a(baxl parambaxl)
  {
    this.a.a(parambaxl);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a.a(paramAppInterface);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, (byte)0, a(paramInt));
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, paramByte, a(paramInt));
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return this.a.a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 3);
  }
  
  public Bitmap b(int paramInt1, String paramString, int paramInt2)
  {
    return a(paramInt1, paramString);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public boolean b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 1);
  }
  
  public void c()
  {
    this.a.a();
  }
  
  public boolean c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 3);
  }
  
  public void d()
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     baxk
 * JD-Core Version:    0.7.0.1
 */