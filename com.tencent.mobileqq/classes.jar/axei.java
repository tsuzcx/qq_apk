import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class axei
  implements Comparable<axei>
{
  public int a;
  public long a;
  public axdt a;
  public axdv a;
  public axeg a;
  public axey a;
  public axfb a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<axdv> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public axei()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = aunv.a();
  }
  
  public int a(axei paramaxei)
  {
    if (this.e < paramaxei.e) {
      return -1;
    }
    if (this.e > paramaxei.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(axdt paramaxdt)
  {
    int j = 6;
    if (paramaxdt == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramaxdt.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axdt = paramaxdt;
    int i;
    if (paramaxdt.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aung.a(this.jdField_a_of_type_Axdt.jdField_b_of_type_Int, 0, i);
      return;
      if (paramaxdt.e == 1006)
      {
        i = 18;
      }
      else if (paramaxdt.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramaxdt.e != 1001) {
          if (paramaxdt.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramaxdt.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(axdv paramaxdv)
  {
    if (paramaxdv == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramaxdv.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axdv = paramaxdv;
    this.jdField_b_of_type_JavaLangString = aung.a(this.jdField_a_of_type_Axdv.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(axey paramaxey)
  {
    int i = 6;
    if (paramaxey == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramaxey.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axey = paramaxey;
    if (paramaxey.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aung.a(this.jdField_a_of_type_Axey.jdField_b_of_type_Int, 1, i);
      return;
      if (paramaxey.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramaxey.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(axfb paramaxfb)
  {
    this.jdField_a_of_type_Axfb = paramaxfb;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<axdv> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axei
 * JD-Core Version:    0.7.0.1
 */