import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class awun
  implements awum
{
  private int jdField_a_of_type_Int;
  private awpq jdField_a_of_type_Awpq;
  private awrz jdField_a_of_type_Awrz;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public awun(awrz paramawrz, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awrz = paramawrz;
    this.jdField_a_of_type_Awpq = new awpu(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Awpq.a(paramComment, new awup(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Awrz != null) {
      this.jdField_a_of_type_Awrz.a();
    }
    this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Int, new awuo(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Awpq.a(paramComment, new awuq(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Awrz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awun
 * JD-Core Version:    0.7.0.1
 */