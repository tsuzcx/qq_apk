import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class auzj
{
  public int a;
  public long a;
  public Bitmap a;
  public String a;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public Bitmap b;
  public String b;
  public boolean b;
  public int c;
  
  public auzj()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public int a()
  {
    int i = 1;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if (!this.jdField_b_of_type_JavaLangString.startsWith("act")) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.Item", 2, "getTagType id = " + this.jdField_a_of_type_Int + " type = " + i);
      }
      return i;
      if (this.jdField_b_of_type_JavaLangString.startsWith("free"))
      {
        String[] arrayOfString = this.jdField_b_of_type_JavaLangString.split("-");
        if ((arrayOfString.length >= 3) && (!TextUtils.isEmpty(arrayOfString[1])) && (TextUtils.isDigitsOnly(arrayOfString[1])) && (!TextUtils.isEmpty(arrayOfString[2])) && (TextUtils.isDigitsOnly(arrayOfString[2])))
        {
          long l1 = Long.parseLong(arrayOfString[1]);
          long l2 = Long.parseLong(arrayOfString[2]);
          long l3 = NetConnInfoCenter.getServerTime();
          if ((l3 > l1) && (l3 < l2))
          {
            i = 2;
            continue;
          }
        }
      }
      i = 0;
    }
  }
  
  public String toString()
  {
    return "HiBoomItem: id = " + this.jdField_a_of_type_Int + " name = " + this.jdField_a_of_type_JavaLangString + " engine = " + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzj
 * JD-Core Version:    0.7.0.1
 */