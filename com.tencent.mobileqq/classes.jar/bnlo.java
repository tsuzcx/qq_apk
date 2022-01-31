import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bnlo
  implements Comparable<bnlo>
{
  public int a;
  public bnlj a;
  public bnlk a;
  public bnls a;
  public bnlw a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bnlk> a;
  public int b;
  public String b;
  public int c = 201;
  
  public bnlo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = awfc.a();
  }
  
  public int a(bnlo parambnlo)
  {
    if (this.c < parambnlo.c) {
      return -1;
    }
    if (this.c > parambnlo.c) {
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
 * Qualified Name:     bnlo
 * JD-Core Version:    0.7.0.1
 */