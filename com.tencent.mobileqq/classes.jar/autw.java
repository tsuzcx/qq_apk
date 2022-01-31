import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class autw
{
  public int a;
  private long jdField_a_of_type_Long;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[256];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c = 125;
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeChecker", 2, "refreshTimer ");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, autx paramautx)
  {
    if ((paramautx == null) || (paramArrayOfByte == null)) {}
    int[] arrayOfInt;
    do
    {
      do
      {
        return;
        arrayOfInt = ShortVideoUtils.a();
      } while (arrayOfInt[0] != 1);
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int % 8 != 0);
    this.jdField_b_of_type_Int = (paramInt1 * paramInt2 * (100 - arrayOfInt[1]) / 100);
    this.c = arrayOfInt[2];
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    int i = 1;
    while (i < paramInt2)
    {
      int j = 1;
      while (j < paramInt1)
      {
        if (i * paramInt1 + j < paramArrayOfByte.length)
        {
          arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          int k = paramArrayOfByte[(i * paramInt1 + j)] & 0xFF;
          arrayOfInt[k] += 64;
        }
        j += 8;
      }
      i += 8;
    }
    i = 0;
    paramInt2 = 255;
    paramInt1 = 255;
    label172:
    if (paramInt1 >= 51)
    {
      i += this.jdField_a_of_type_ArrayOfInt[paramInt1];
      if (i < this.jdField_b_of_type_Int) {}
    }
    for (;;)
    {
      if (paramInt1 <= this.c)
      {
        QLog.w("DarkModeChecker", 1, "darkmode = true!");
        this.jdField_b_of_type_Long = 0L;
        if (this.jdField_a_of_type_Long == 0L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          return;
          paramInt2 = paramInt1;
          paramInt1 -= 1;
          break label172;
        }
        if ((this.jdField_a_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L)) {
          break;
        }
        this.jdField_a_of_type_Long = -1L;
        QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE on!");
        this.jdField_b_of_type_Long = 0L;
        paramautx.a(true);
        return;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_a_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_Long == 0L)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return;
      }
      if ((this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long < 2000L)) {
        break;
      }
      this.jdField_b_of_type_Long = -1L;
      QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE off!");
      this.jdField_a_of_type_Long = 0L;
      paramautx.a(false);
      return;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     autw
 * JD-Core Version:    0.7.0.1
 */