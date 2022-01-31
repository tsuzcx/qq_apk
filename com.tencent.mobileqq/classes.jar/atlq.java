import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class atlq
  implements atlp
{
  private int jdField_a_of_type_Int;
  private atgv jdField_a_of_type_Atgv;
  private atjc jdField_a_of_type_Atjc;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public atlq(atjc paramatjc, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atjc = paramatjc;
    this.jdField_a_of_type_Atgv = new atgz(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Atgv.a(paramComment, new atls(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Atjc != null) {
      this.jdField_a_of_type_Atjc.a();
    }
    this.jdField_a_of_type_Atgv.a(this.jdField_a_of_type_Int, new atlr(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Atgv.a(paramComment, new atlt(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Atjc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atlq
 * JD-Core Version:    0.7.0.1
 */