import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class avcs
  implements avcr
{
  private int jdField_a_of_type_Int;
  private auxw jdField_a_of_type_Auxw;
  private avae jdField_a_of_type_Avae;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public avcs(avae paramavae, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Avae = paramavae;
    this.jdField_a_of_type_Auxw = new auya(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Auxw.a(paramComment, new avcu(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Avae != null) {
      this.jdField_a_of_type_Avae.a();
    }
    this.jdField_a_of_type_Auxw.a(this.jdField_a_of_type_Int, new avct(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Auxw.a(paramComment, new avcv(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avae = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcs
 * JD-Core Version:    0.7.0.1
 */