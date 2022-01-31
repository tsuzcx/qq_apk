import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class awey
  implements Comparable<awey>
{
  public int a;
  public long a;
  public awej a;
  public awel a;
  public awew a;
  public awfo a;
  public awfr a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<awel> a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 201;
  public int f;
  
  public awey()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = atpv.a();
  }
  
  public int a(awey paramawey)
  {
    if (this.e < paramawey.e) {
      return -1;
    }
    if (this.e > paramawey.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(awej paramawej)
  {
    int j = 6;
    if (paramawej == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return;
    }
    paramawej.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Awej = paramawej;
    int i;
    if (paramawej.e == 1002) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = atpg.a(this.jdField_a_of_type_Awej.jdField_b_of_type_Int, 0, i);
      return;
      if (paramawej.e == 1006)
      {
        i = 18;
      }
      else if (paramawej.e == 1004)
      {
        i = 16;
      }
      else
      {
        i = j;
        if (paramawej.e != 1001) {
          if (paramawej.e == 1005)
          {
            i = 17;
          }
          else
          {
            i = j;
            if (paramawej.e == 1003) {
              i = 9;
            }
          }
        }
      }
    }
  }
  
  public void a(awel paramawel)
  {
    if (paramawel == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return;
    }
    paramawel.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Awel = paramawel;
    this.jdField_b_of_type_JavaLangString = atpg.a(this.jdField_a_of_type_Awel.jdField_b_of_type_Int, 2, 20);
  }
  
  public void a(awfo paramawfo)
  {
    int i = 6;
    if (paramawfo == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return;
    }
    paramawfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Awfo = paramawfo;
    if (paramawfo.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = atpg.a(this.jdField_a_of_type_Awfo.jdField_b_of_type_Int, 1, i);
      return;
      if (paramawfo.jdField_b_of_type_Int == 3000) {
        i = 17;
      } else if (paramawfo.jdField_b_of_type_Int == 1) {
        i = 9;
      }
    }
  }
  
  public void a(awfr paramawfr)
  {
    this.jdField_a_of_type_Awfr = paramawfr;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  public void a(ArrayList<awel> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awey
 * JD-Core Version:    0.7.0.1
 */