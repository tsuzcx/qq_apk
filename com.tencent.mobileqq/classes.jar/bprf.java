import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

public class bprf
  implements Comparable<bprf>
{
  public int a;
  public bpqz a;
  public bpra a;
  public bprh a;
  public bprl a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<bpra> a;
  public int b;
  public String b;
  public int c = 201;
  
  public bprf()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = azke.a();
  }
  
  public int a(bprf parambprf)
  {
    if (this.c < parambprf.c) {
      return -1;
    }
    if (this.c > parambprf.c) {
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
 * Qualified Name:     bprf
 * JD-Core Version:    0.7.0.1
 */