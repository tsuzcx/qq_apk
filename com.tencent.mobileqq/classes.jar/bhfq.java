import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bhfq
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = 14;
  private long jdField_a_of_type_Long;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[320];
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte = new byte[320];
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = new byte[10240];
  
  public bhfq(Context paramContext, int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      bool = SoLoadUtilNew.loadSoByName(paramContext, "amrnb");
      if (bool)
      {
        jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_Int = bhcd.a(paramInt);
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
        this.jdField_a_of_type_Long = AmrInputStreamWrapper.CreateEncoder();
        this.jdField_b_of_type_Long = AmrInputStreamWrapper.GsmAmrEncoderNew(this.jdField_a_of_type_Long);
        AmrInputStreamWrapper.GsmAmrEncoderInitialize(this.jdField_b_of_type_Long);
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
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L)) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrEncoderEncode(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +14 -> 20
    //   9: aload_0
    //   10: getfield 56	bhfq:jdField_a_of_type_Long	J
    //   13: aload_0
    //   14: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   17: invokestatic 121	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(JJ)V
    //   20: aload_0
    //   21: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq +14 -> 40
    //   29: aload_0
    //   30: getfield 56	bhfq:jdField_a_of_type_Long	J
    //   33: aload_0
    //   34: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   37: invokestatic 124	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 62	bhfq:jdField_b_of_type_Long	J
    //   45: aload_0
    //   46: invokevirtual 117	bhfq:b	()V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: lconst_0
    //   53: putfield 62	bhfq:jdField_b_of_type_Long	J
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifeq +14 -> 79
    //   68: aload_0
    //   69: getfield 56	bhfq:jdField_a_of_type_Long	J
    //   72: aload_0
    //   73: getfield 62	bhfq:jdField_b_of_type_Long	J
    //   76: invokestatic 124	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   79: aload_0
    //   80: lconst_0
    //   81: putfield 62	bhfq:jdField_b_of_type_Long	J
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 62	bhfq:jdField_b_of_type_Long	J
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	bhfq
    //   50	7	1	localObject1	Object
    //   58	27	1	localObject2	Object
    //   86	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	40	50	finally
    //   0	20	58	finally
    //   59	79	86	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_c_of_type_Int + paramInt > 10240) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int + paramInt];
    }
    if (this.jdField_c_of_type_Int + paramInt < 320)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, this.jdField_c_of_type_Int, paramInt);
      return null;
    }
    System.arraycopy(this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.jdField_c_of_type_Int);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.jdField_c_of_type_Int, paramInt);
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int + paramInt);
    paramInt = this.jdField_d_of_type_Int % 320;
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.jdField_d_of_type_Int - paramInt, this.jdField_c_of_type_ArrayOfByte, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.jdField_d_of_type_Int / 320 * this.jdField_a_of_type_Int];
    int i = 0;
    paramInt = 0;
    while (this.jdField_d_of_type_Int >= 320)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, 320);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
        System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
        i += this.jdField_b_of_type_ArrayOfByte.length;
        paramInt += 320;
        this.jdField_d_of_type_Int -= 320;
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
    this.jdField_c_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfq
 * JD-Core Version:    0.7.0.1
 */