import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class aoja
  implements Runnable
{
  public aoja(ShortVideoPlayActivity paramShortVideoPlayActivity, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPlayActivity, 232, null, this.jdField_a_of_type_JavaLangString, new aojb(this), null);
    ShortVideoPlayActivity.a(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPlayActivity, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoja
 * JD-Core Version:    0.7.0.1
 */