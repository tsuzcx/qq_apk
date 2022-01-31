import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bnqa
  implements Comparable<bnqa>
{
  public int a;
  public bnpv a;
  public bnpw a;
  public bnqe a;
  public bnqi a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bnpw> a;
  public int b;
  public String b;
  public int c = 201;
  
  public bnqa()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = awjl.a();
  }
  
  public int a(bnqa parambnqa)
  {
    if (this.c < parambnqa.c) {
      return -1;
    }
    if (this.c > parambnqa.c) {
      return 1;
    }
    return 0;
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqa
 * JD-Core Version:    0.7.0.1
 */