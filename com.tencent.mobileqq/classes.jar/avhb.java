import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class avhb
  implements avha
{
  private int jdField_a_of_type_Int;
  private avcf jdField_a_of_type_Avcf;
  private aven jdField_a_of_type_Aven;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public avhb(aven paramaven, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aven = paramaven;
    this.jdField_a_of_type_Avcf = new avcj(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Avcf.a(paramComment, new avhd(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aven != null) {
      this.jdField_a_of_type_Aven.a();
    }
    this.jdField_a_of_type_Avcf.a(this.jdField_a_of_type_Int, new avhc(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Avcf.a(paramComment, new avhe(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aven = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhb
 * JD-Core Version:    0.7.0.1
 */