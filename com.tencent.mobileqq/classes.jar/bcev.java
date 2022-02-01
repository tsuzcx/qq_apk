import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bcev
  implements Comparable<bcev>
{
  public int a;
  public long a;
  public bcef a;
  public bceh a;
  public bceu a;
  public bcfn a;
  public bcfq a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bceh> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public bcev()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = ayxx.a();
  }
  
  public int a(bcev parambcev)
  {
    if (this.e < parambcev.e) {
      return -1;
    }
    if (this.e > parambcev.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(bcef parambcef)
  {
    int j = 6;
    if (parambcef == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    parambcef.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcef = parambcef;
    int i;
    if (parambcef.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayxi.a(this.jdField_a_of_type_Bcef.jdField_b_of_type_Int, 0, i);
      return;
      if (parambcef.e == 1006)
      {
        i = 18;
      }
      else if (parambcef.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (parambcef.e != 1001) {
          if (parambcef.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (parambcef.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(bceh parambceh)
  {
    if (parambceh == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    parambceh.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bceh = parambceh;
    this.jdField_b_of_type_JavaLangString = ayxi.a(this.jdField_a_of_type_Bceh.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(bcfn parambcfn)
  {
    int i = 6;
    if (parambcfn == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    parambcfn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bcfn = parambcfn;
    if (parambcfn.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayxi.a(this.jdField_a_of_type_Bcfn.jdField_b_of_type_Int, 1, i);
      return;
      if (parambcfn.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (parambcfn.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(bcfq parambcfq)
  {
    this.jdField_a_of_type_Bcfq = parambcfq;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<bceh> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcev
 * JD-Core Version:    0.7.0.1
 */