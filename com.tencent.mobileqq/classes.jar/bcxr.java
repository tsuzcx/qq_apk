import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bcxr
  implements Comparable<bcxr>
{
  public int a;
  public long a;
  public bcxb a;
  public bcxd a;
  public bcxq a;
  public bcyj a;
  public bcyl a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bcxd> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public bcxr()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = azke.a();
  }
  
  public int a(bcxr parambcxr)
  {
    if (this.e < parambcxr.e) {
      return -1;
    }
    if (this.e > parambcxr.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(bcxb parambcxb)
  {
    int j = 6;
    if (parambcxb == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    parambcxb.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcxb = parambcxb;
    int i;
    if (parambcxb.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = azjq.a(this.jdField_a_of_type_Bcxb.jdField_b_of_type_Int, 0, i);
      return;
      if (parambcxb.e == 1006)
      {
        i = 18;
      }
      else if (parambcxb.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (parambcxb.e != 1001) {
          if (parambcxb.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (parambcxb.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(bcxd parambcxd)
  {
    if (parambcxd == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    parambcxd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcxd = parambcxd;
    this.jdField_b_of_type_JavaLangString = azjq.a(this.jdField_a_of_type_Bcxd.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(bcyj parambcyj)
  {
    int i = 6;
    if (parambcyj == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    parambcyj.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcyj = parambcyj;
    if (parambcyj.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = azjq.a(this.jdField_a_of_type_Bcyj.jdField_b_of_type_Int, 1, i);
      return;
      if (parambcyj.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (parambcyj.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(bcyl parambcyl)
  {
    this.jdField_a_of_type_Bcyl = parambcyl;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<bcxd> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxr
 * JD-Core Version:    0.7.0.1
 */