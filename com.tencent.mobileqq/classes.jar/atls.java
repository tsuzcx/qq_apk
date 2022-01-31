import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class atls
  implements atlr
{
  private int jdField_a_of_type_Int;
  private atgx jdField_a_of_type_Atgx;
  private atje jdField_a_of_type_Atje;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public atls(atje paramatje, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atje = paramatje;
    this.jdField_a_of_type_Atgx = new athb(paramVideoData, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    b();
  }
  
  public void a(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Atgx.a(paramComment, new atlu(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Atje != null) {
      this.jdField_a_of_type_Atje.a();
    }
    this.jdField_a_of_type_Atgx.a(this.jdField_a_of_type_Int, new atlt(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Atgx.a(paramComment, new atlv(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Atje = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atls
 * JD-Core Version:    0.7.0.1
 */