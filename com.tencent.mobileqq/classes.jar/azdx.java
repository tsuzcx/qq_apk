import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class azdx
  implements Comparable<azdx>
{
  public int a;
  public long a;
  public azdg a;
  public azdi a;
  public azdv a;
  public azen a;
  public azeq a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<azdi> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public azdx()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = awjl.a();
  }
  
  public int a(azdx paramazdx)
  {
    if (this.e < paramazdx.e) {
      return -1;
    }
    if (this.e > paramazdx.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(azdg paramazdg)
  {
    int j = 6;
    if (paramazdg == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramazdg.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Azdg = paramazdg;
    int i;
    if (paramazdg.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = awiw.a(this.jdField_a_of_type_Azdg.jdField_b_of_type_Int, 0, i);
      return;
      if (paramazdg.e == 1006)
      {
        i = 18;
      }
      else if (paramazdg.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramazdg.e != 1001) {
          if (paramazdg.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramazdg.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(azdi paramazdi)
  {
    if (paramazdi == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramazdi.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Azdi = paramazdi;
    this.jdField_b_of_type_JavaLangString = awiw.a(this.jdField_a_of_type_Azdi.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(azen paramazen)
  {
    int i = 6;
    if (paramazen == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramazen.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Azen = paramazen;
    if (paramazen.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = awiw.a(this.jdField_a_of_type_Azen.jdField_b_of_type_Int, 1, i);
      return;
      if (paramazen.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramazen.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(azeq paramazeq)
  {
    this.jdField_a_of_type_Azeq = paramazeq;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<azdi> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdx
 * JD-Core Version:    0.7.0.1
 */