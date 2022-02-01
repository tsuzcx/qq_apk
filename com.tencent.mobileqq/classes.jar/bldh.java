import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class bldh
{
  private int jdField_a_of_type_Int;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int d;
  private int e;
  
  public static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt2 > 4) {
      paramInt2 = paramInt1 + 4;
    }
    while (paramInt1 < paramInt2)
    {
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
      continue;
      paramInt2 = paramInt1 + paramInt2;
    }
    return 0xFFFFFFFF & l;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (this.jdField_c_of_type_Int = 0; this.jdField_c_of_type_Int < 8; this.jdField_c_of_type_Int += 1)
    {
      if (this.e + this.jdField_c_of_type_Int >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      int i = this.jdField_c_of_type_Int;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.jdField_a_of_type_Int + paramInt1 + this.jdField_c_of_type_Int)]));
    }
    this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return false;
    }
    this.e += 8;
    this.jdField_a_of_type_Int += 8;
    this.jdField_c_of_type_Int = 0;
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = a(paramArrayOfByte, paramInt, 4);
        l2 = a(paramArrayOfByte, paramInt + 4, 4);
        l4 = a(this.jdField_c_of_type_ArrayOfByte, 0, 4);
        l5 = a(this.jdField_c_of_type_ArrayOfByte, 4, 4);
        l6 = a(this.jdField_c_of_type_ArrayOfByte, 8, 4);
        l7 = a(this.jdField_c_of_type_ArrayOfByte, 12, 4);
        l1 = 0xE3779B90 & 0xFFFFFFFF;
        paramInt = i;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      while (paramInt > 0)
      {
        l2 = l2 - ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        l3 = l3 - ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16)) {
      return null;
    }
    this.jdField_a_of_type_ArrayOfByte = a(paramArrayOfByte1, paramInt1);
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return null;
    }
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_ArrayOfByte[0] & 0x7);
    int j = paramInt2 - this.jdField_c_of_type_Int - 10;
    if (j < 0) {
      return null;
    }
    int i = paramInt1;
    while (i < paramArrayOfByte2.length)
    {
      paramArrayOfByte2[i] = 0;
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfByte = new byte[j];
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 8;
    this.e = 8;
    this.jdField_c_of_type_Int += 1;
    this.d = 1;
    for (;;)
    {
      if (this.d <= 2)
      {
        if (this.jdField_c_of_type_Int < 8)
        {
          this.jdField_c_of_type_Int += 1;
          this.d += 1;
        }
        if (this.jdField_c_of_type_Int != 8) {
          continue;
        }
        if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
          return null;
        }
      }
      else
      {
        i = j;
        int k = 0;
        for (;;)
        {
          int m;
          if (i != 0)
          {
            m = k;
            j = i;
            if (this.jdField_c_of_type_Int < 8)
            {
              this.jdField_b_of_type_ArrayOfByte[k] = ((byte)(paramArrayOfByte2[(this.jdField_b_of_type_Int + paramInt1 + this.jdField_c_of_type_Int)] ^ this.jdField_a_of_type_ArrayOfByte[this.jdField_c_of_type_Int]));
              m = k + 1;
              j = i - 1;
              this.jdField_c_of_type_Int += 1;
            }
            k = m;
            i = j;
            if (this.jdField_c_of_type_Int != 8) {
              continue;
            }
            this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int - 8);
            if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
              return null;
            }
          }
          else
          {
            for (this.d = 1; this.d < 8; this.d += 1)
            {
              if (this.jdField_c_of_type_Int < 8)
              {
                if ((paramArrayOfByte2[(this.jdField_b_of_type_Int + paramInt1 + this.jdField_c_of_type_Int)] ^ this.jdField_a_of_type_ArrayOfByte[this.jdField_c_of_type_Int]) != 0) {
                  return null;
                }
                this.jdField_c_of_type_Int += 1;
              }
              if (this.jdField_c_of_type_Int == 8)
              {
                this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
                if (!a(paramArrayOfByte1, paramInt1, paramInt2)) {
                  return null;
                }
                paramArrayOfByte2 = paramArrayOfByte1;
              }
            }
            return this.jdField_b_of_type_ArrayOfByte;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          k = m;
          i = j;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bldh
 * JD-Core Version:    0.7.0.1
 */