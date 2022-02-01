import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class ayhf
  implements ayhe
{
  private int jdField_a_of_type_Int;
  private ayci jdField_a_of_type_Ayci;
  private ayer jdField_a_of_type_Ayer;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public ayhf(ayer paramayer, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ayer = paramayer;
    this.jdField_a_of_type_Ayci = new aycm(paramVideoData, paramQQAppInterface);
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
    this.jdField_a_of_type_Ayci.a(paramComment, new ayhh(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ayer != null) {
      this.jdField_a_of_type_Ayer.a();
    }
    this.jdField_a_of_type_Ayci.a(this.jdField_a_of_type_Int, new ayhg(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Ayci.a(paramComment, new ayhi(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ayer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhf
 * JD-Core Version:    0.7.0.1
 */