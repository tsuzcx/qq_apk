import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.FileUtils;

public class ar
  implements Runnable
{
  public ar(LiteActivity paramLiteActivity, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5 = FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.runOnUiThread(new as(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ar
 * JD-Core Version:    0.7.0.1
 */