import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bbqx
  implements Comparable<bbqx>
{
  public int a;
  public long a;
  public bbqh a;
  public bbqj a;
  public bbqw a;
  public bbrp a;
  public bbrr a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bbqj> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public bbqx()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = ayds.a();
  }
  
  public int a(bbqx parambbqx)
  {
    if (this.e < parambbqx.e) {
      return -1;
    }
    if (this.e > parambbqx.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(bbqh parambbqh)
  {
    int j = 6;
    if (parambbqh == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    parambbqh.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bbqh = parambbqh;
    int i;
    if (parambbqh.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayde.a(this.jdField_a_of_type_Bbqh.jdField_b_of_type_Int, 0, i);
      return;
      if (parambbqh.e == 1006)
      {
        i = 18;
      }
      else if (parambbqh.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (parambbqh.e != 1001) {
          if (parambbqh.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (parambbqh.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(bbqj parambbqj)
  {
    if (parambbqj == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    parambbqj.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bbqj = parambbqj;
    this.jdField_b_of_type_JavaLangString = ayde.a(this.jdField_a_of_type_Bbqj.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(bbrp parambbrp)
  {
    int i = 6;
    if (parambbrp == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    parambbrp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bbrp = parambbrp;
    if (parambbrp.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayde.a(this.jdField_a_of_type_Bbrp.jdField_b_of_type_Int, 1, i);
      return;
      if (parambbrp.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (parambbrp.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(bbrr parambbrr)
  {
    this.jdField_a_of_type_Bbrr = parambbrr;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<bbqj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqx
 * JD-Core Version:    0.7.0.1
 */