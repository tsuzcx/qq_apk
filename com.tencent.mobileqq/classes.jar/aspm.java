import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class aspm
  implements aspl
{
  private int jdField_a_of_type_Int;
  private askr jdField_a_of_type_Askr;
  private asmy jdField_a_of_type_Asmy;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public aspm(asmy paramasmy, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Asmy = paramasmy;
    this.jdField_a_of_type_Askr = new askv(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Askr.a(paramComment, new aspo(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Asmy != null) {
      this.jdField_a_of_type_Asmy.a();
    }
    this.jdField_a_of_type_Askr.a(this.jdField_a_of_type_Int, new aspn(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Askr.a(paramComment, new aspp(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Asmy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aspm
 * JD-Core Version:    0.7.0.1
 */