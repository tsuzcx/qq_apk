import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import java.util.List;
import mqq.os.MqqHandler;

public class antc
  implements ansj
{
  private int jdField_a_of_type_Int;
  
  public antc(FavroamingManager.8 param8, List paramList) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0.f();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Antd != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Antd.a(this.jdField_a_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int) {
      if (!ansx.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0))
      {
        paramString = (String)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        ansx.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0, paramString, ansx.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0));
      }
    }
    do
    {
      return;
      paramString = ansx.s(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0).getHandler(ChatActivity.class);
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Antd == null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Antd.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     antc
 * JD-Core Version:    0.7.0.1
 */