import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bqgq
  implements Comparable<bqgq>
{
  public int a;
  public bqgl a;
  public bqgm a;
  public bqgs a;
  public bqgw a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bqgm> a;
  public int b;
  public String b;
  public int c = 201;
  
  public bqgq()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = ayxx.a();
  }
  
  public int a(bqgq parambqgq)
  {
    if (this.c < parambqgq.c) {
      return -1;
    }
    if (this.c > parambqgq.c) {
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
 * Qualified Name:     bqgq
 * JD-Core Version:    0.7.0.1
 */