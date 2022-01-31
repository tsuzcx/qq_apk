import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class axeg
  implements Comparable<axeg>
{
  public int a;
  public long a;
  public axdr a;
  public axdt a;
  public axee a;
  public axew a;
  public axez a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<axdt> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public axeg()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = aunt.a();
  }
  
  public int a(axeg paramaxeg)
  {
    if (this.e < paramaxeg.e) {
      return -1;
    }
    if (this.e > paramaxeg.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(axdr paramaxdr)
  {
    int j = 6;
    if (paramaxdr == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramaxdr.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axdr = paramaxdr;
    int i;
    if (paramaxdr.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aune.a(this.jdField_a_of_type_Axdr.jdField_b_of_type_Int, 0, i);
      return;
      if (paramaxdr.e == 1006)
      {
        i = 18;
      }
      else if (paramaxdr.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramaxdr.e != 1001) {
          if (paramaxdr.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramaxdr.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(axdt paramaxdt)
  {
    if (paramaxdt == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramaxdt.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axdt = paramaxdt;
    this.jdField_b_of_type_JavaLangString = aune.a(this.jdField_a_of_type_Axdt.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(axew paramaxew)
  {
    int i = 6;
    if (paramaxew == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramaxew.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axew = paramaxew;
    if (paramaxew.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aune.a(this.jdField_a_of_type_Axew.jdField_b_of_type_Int, 1, i);
      return;
      if (paramaxew.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramaxew.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(axez paramaxez)
  {
    this.jdField_a_of_type_Axez = paramaxez;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<axdt> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axeg
 * JD-Core Version:    0.7.0.1
 */