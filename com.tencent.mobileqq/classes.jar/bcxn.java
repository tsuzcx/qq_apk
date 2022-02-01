import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bcxn
  implements Comparable<bcxn>
{
  public int a;
  public long a;
  public bcwx a;
  public bcwz a;
  public bcxm a;
  public bcyf a;
  public bcyi a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bcwz> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public bcxn()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = azqk.a();
  }
  
  public int a(bcxn parambcxn)
  {
    if (this.e < parambcxn.e) {
      return -1;
    }
    if (this.e > parambcxn.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(bcwx parambcwx)
  {
    int j = 6;
    if (parambcwx == null)
    {
      azpw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    parambcwx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcwx = parambcwx;
    int i;
    if (parambcwx.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = azpw.a(this.jdField_a_of_type_Bcwx.jdField_b_of_type_Int, 0, i);
      return;
      if (parambcwx.e == 1006)
      {
        i = 18;
      }
      else if (parambcwx.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (parambcwx.e != 1001) {
          if (parambcwx.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (parambcwx.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(bcwz parambcwz)
  {
    if (parambcwz == null)
    {
      azpw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    parambcwz.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcwz = parambcwz;
    this.jdField_b_of_type_JavaLangString = azpw.a(this.jdField_a_of_type_Bcwz.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(bcyf parambcyf)
  {
    int i = 6;
    if (parambcyf == null)
    {
      azpw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    parambcyf.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcyf = parambcyf;
    if (parambcyf.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = azpw.a(this.jdField_a_of_type_Bcyf.jdField_b_of_type_Int, 1, i);
      return;
      if (parambcyf.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (parambcyf.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(bcyi parambcyi)
  {
    this.jdField_a_of_type_Bcyi = parambcyi;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<bcwz> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxn
 * JD-Core Version:    0.7.0.1
 */