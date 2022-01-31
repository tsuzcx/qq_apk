import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class baeb
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = 14;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[320];
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte = new byte[320];
  private int jdField_d_of_type_Int = 1;
  private byte[] jdField_d_of_type_ArrayOfByte = new byte[10240];
  private int e;
  private int f;
  
  public baeb(Context paramContext, int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      bool = SoLoadUtilNew.loadSoByName(paramContext, "amrnb");
      if (bool)
      {
        jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_Int = paramInt;
        this.jdField_a_of_type_Int = baag.a(paramInt);
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.jdField_b_of_type_Int = AmrInputStreamWrapper.CreateEncoder();
        this.jdField_c_of_type_Int = AmrInputStreamWrapper.GsmAmrEncoderNew(this.jdField_b_of_type_Int);
        AmrInputStreamWrapper.GsmAmrEncoderInitialize(this.jdField_c_of_type_Int);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "libamrnb.so load failed, exception info : " + QLog.getStackTraceString(paramContext));
        }
        boolean bool = false;
        continue;
        try
        {
          System.loadLibrary("amrnb");
          jdField_a_of_type_Boolean = true;
        }
        catch (UnsatisfiedLinkError paramContext) {}
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "libamrnb.so load system way failed, exception info : " + QLog.getStackTraceString(paramContext));
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0)) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrEncoderEncode(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	baeb:jdField_c_of_type_Int	I
    //   4: ifeq +14 -> 18
    //   7: aload_0
    //   8: getfield 57	baeb:jdField_b_of_type_Int	I
    //   11: aload_0
    //   12: getfield 62	baeb:jdField_c_of_type_Int	I
    //   15: invokestatic 120	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   18: aload_0
    //   19: getfield 62	baeb:jdField_c_of_type_Int	I
    //   22: ifeq +14 -> 36
    //   25: aload_0
    //   26: getfield 57	baeb:jdField_b_of_type_Int	I
    //   29: aload_0
    //   30: getfield 62	baeb:jdField_c_of_type_Int	I
    //   33: invokestatic 123	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 62	baeb:jdField_c_of_type_Int	I
    //   41: aload_0
    //   42: invokevirtual 116	baeb:b	()V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 62	baeb:jdField_c_of_type_Int	I
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 62	baeb:jdField_c_of_type_Int	I
    //   59: ifeq +14 -> 73
    //   62: aload_0
    //   63: getfield 57	baeb:jdField_b_of_type_Int	I
    //   66: aload_0
    //   67: getfield 62	baeb:jdField_c_of_type_Int	I
    //   70: invokestatic 123	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 62	baeb:jdField_c_of_type_Int	I
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 62	baeb:jdField_c_of_type_Int	I
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	baeb
    //   46	7	1	localObject1	Object
    //   54	25	1	localObject2	Object
    //   80	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	36	46	finally
    //   0	18	54	finally
    //   55	73	80	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.e + paramInt > 10240) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.e + paramInt];
    }
    if (this.e + paramInt < 320)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, this.e, paramInt);
      return null;
    }
    System.arraycopy(this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.e);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.e, paramInt);
    this.f = (this.e + paramInt);
    paramInt = this.f % 320;
    this.e = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.f - paramInt, this.jdField_c_of_type_ArrayOfByte, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.f / 320 * this.jdField_a_of_type_Int];
    int i = 0;
    paramInt = 0;
    while (this.f >= 320)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, 320);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
        System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
        i += this.jdField_b_of_type_ArrayOfByte.length;
        paramInt += 320;
        this.f -= 320;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "========mPcm2Amr.pcm2amrParser==IOException=====", paramArrayOfByte);
        }
        b();
        return null;
      }
    }
    if (i == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeb
 * JD-Core Version:    0.7.0.1
 */