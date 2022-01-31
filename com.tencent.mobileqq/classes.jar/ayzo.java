import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class ayzo
  implements Comparable<ayzo>
{
  public int a;
  public long a;
  public ayyx a;
  public ayyz a;
  public ayzm a;
  public azae a;
  public azah a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<ayyz> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public ayzo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = awfc.a();
  }
  
  public int a(ayzo paramayzo)
  {
    if (this.e < paramayzo.e) {
      return -1;
    }
    if (this.e > paramayzo.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(ayyx paramayyx)
  {
    int j = 6;
    if (paramayyx == null)
    {
      awen.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramayyx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayyx = paramayyx;
    int i;
    if (paramayyx.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = awen.a(this.jdField_a_of_type_Ayyx.jdField_b_of_type_Int, 0, i);
      return;
      if (paramayyx.e == 1006)
      {
        i = 18;
      }
      else if (paramayyx.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramayyx.e != 1001) {
          if (paramayyx.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramayyx.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(ayyz paramayyz)
  {
    if (paramayyz == null)
    {
      awen.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramayyz.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayyz = paramayyz;
    this.jdField_b_of_type_JavaLangString = awen.a(this.jdField_a_of_type_Ayyz.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(azae paramazae)
  {
    int i = 6;
    if (paramazae == null)
    {
      awen.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramazae.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Azae = paramazae;
    if (paramazae.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = awen.a(this.jdField_a_of_type_Azae.jdField_b_of_type_Int, 1, i);
      return;
      if (paramazae.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramazae.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(azah paramazah)
  {
    this.jdField_a_of_type_Azah = paramazah;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<ayyz> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzo
 * JD-Core Version:    0.7.0.1
 */