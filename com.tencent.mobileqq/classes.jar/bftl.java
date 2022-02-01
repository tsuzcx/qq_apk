import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bftl
{
  private static boolean jdField_a_of_type_Boolean;
  static final int[] jdField_a_of_type_ArrayOfInt = { 12, 13, 15, 17, 19, 20, 26, 31, 5, 0 };
  private int jdField_a_of_type_Int = 14;
  private long jdField_a_of_type_Long;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[320];
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private byte[] d = new byte[1024];
  
  public bftl(Context paramContext, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_Long = AmrInputStreamWrapper.CreateDecoder();
    this.jdField_b_of_type_Long = AmrInputStreamWrapper.GsmAmrDecoderNew(this.jdField_a_of_type_Long);
    AmrInputStreamWrapper.GsmAmrDecoderInitialize(this.jdField_b_of_type_Long);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 8)) {
      return jdField_a_of_type_ArrayOfInt[paramInt] + 1;
    }
    return 14;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L)) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrDecoderDecode(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	bftl:jdField_b_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +14 -> 20
    //   9: aload_0
    //   10: getfield 53	bftl:jdField_a_of_type_Long	J
    //   13: aload_0
    //   14: getfield 59	bftl:jdField_b_of_type_Long	J
    //   17: invokestatic 81	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderCleanup	(JJ)V
    //   20: aload_0
    //   21: getfield 59	bftl:jdField_b_of_type_Long	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq +14 -> 40
    //   29: aload_0
    //   30: getfield 53	bftl:jdField_a_of_type_Long	J
    //   33: aload_0
    //   34: getfield 59	bftl:jdField_b_of_type_Long	J
    //   37: invokestatic 84	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(JJ)V
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 59	bftl:jdField_b_of_type_Long	J
    //   45: aload_0
    //   46: invokevirtual 77	bftl:b	()V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: lconst_0
    //   53: putfield 59	bftl:jdField_b_of_type_Long	J
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 59	bftl:jdField_b_of_type_Long	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifeq +14 -> 79
    //   68: aload_0
    //   69: getfield 53	bftl:jdField_a_of_type_Long	J
    //   72: aload_0
    //   73: getfield 59	bftl:jdField_b_of_type_Long	J
    //   76: invokestatic 84	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(JJ)V
    //   79: aload_0
    //   80: lconst_0
    //   81: putfield 59	bftl:jdField_b_of_type_Long	J
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 59	bftl:jdField_b_of_type_Long	J
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	bftl
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
    if (this.jdField_b_of_type_Int + paramInt > 1024) {
      this.d = new byte[this.jdField_b_of_type_Int + paramInt];
    }
    if (this.jdField_b_of_type_Int + paramInt < this.jdField_a_of_type_Int)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, this.jdField_b_of_type_Int, paramInt);
      return null;
    }
    System.arraycopy(this.jdField_c_of_type_ArrayOfByte, 0, this.d, 0, this.jdField_b_of_type_Int);
    System.arraycopy(paramArrayOfByte, 0, this.d, this.jdField_b_of_type_Int, paramInt);
    this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int + paramInt);
    paramInt = this.jdField_c_of_type_Int % this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.d, this.jdField_c_of_type_Int - paramInt, this.jdField_c_of_type_ArrayOfByte, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.jdField_c_of_type_Int / this.jdField_a_of_type_Int * 320];
    int i = 0;
    paramInt = 0;
    while (this.jdField_c_of_type_Int >= this.jdField_a_of_type_Int)
    {
      System.arraycopy(this.d, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
        System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
        i += this.jdField_b_of_type_ArrayOfByte.length;
        paramInt += this.jdField_a_of_type_Int;
        this.jdField_c_of_type_Int -= this.jdField_a_of_type_Int;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Amr2PcmWrapper", 2, "========mAmr2Pcm.amr2pcmParser==IOException=====", paramArrayOfByte);
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
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftl
 * JD-Core Version:    0.7.0.1
 */