import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class ayap
  implements ayao
{
  private int jdField_a_of_type_Int;
  private axvs jdField_a_of_type_Axvs;
  private axyb jdField_a_of_type_Axyb;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public ayap(axyb paramaxyb, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Axyb = paramaxyb;
    this.jdField_a_of_type_Axvs = new axvw(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Axvs.a(paramComment, new ayar(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axyb != null) {
      this.jdField_a_of_type_Axyb.a();
    }
    this.jdField_a_of_type_Axvs.a(this.jdField_a_of_type_Int, new ayaq(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Axvs.a(paramComment, new ayas(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Axyb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayap
 * JD-Core Version:    0.7.0.1
 */