import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class axol
  implements axok
{
  private int jdField_a_of_type_Int;
  private axjo jdField_a_of_type_Axjo;
  private axlx jdField_a_of_type_Axlx;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public axol(axlx paramaxlx, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Axlx = paramaxlx;
    this.jdField_a_of_type_Axjo = new axjs(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Axjo.a(paramComment, new axon(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axlx != null) {
      this.jdField_a_of_type_Axlx.a();
    }
    this.jdField_a_of_type_Axjo.a(this.jdField_a_of_type_Int, new axom(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Axjo.a(paramComment, new axoo(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Axlx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axol
 * JD-Core Version:    0.7.0.1
 */