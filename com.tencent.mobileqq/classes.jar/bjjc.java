import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bjjc
  implements Comparable<bjjc>
{
  public int a;
  public bjix a;
  public bjiy a;
  public bjjg a;
  public bjjk a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bjiy> a;
  public int b;
  public String b;
  public int c = 201;
  
  public bjjc()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = atpv.a();
  }
  
  public int a(bjjc parambjjc)
  {
    if (this.c < parambjjc.c) {
      return -1;
    }
    if (this.c > parambjjc.c) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjjc
 * JD-Core Version:    0.7.0.1
 */