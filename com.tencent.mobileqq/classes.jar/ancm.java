import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import java.util.List;
import mqq.os.MqqHandler;

public class ancm
  implements anbt
{
  private int jdField_a_of_type_Int;
  
  public ancm(FavroamingManager.8 param8, List paramList) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0.f();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Ancn != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Ancn.a(this.jdField_a_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int) {
      if (!anch.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0))
      {
        paramString = (String)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        anch.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0, paramString, anch.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0));
      }
    }
    do
    {
      return;
      paramString = anch.s(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0).getHandler(ChatActivity.class);
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Ancn == null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Ancn.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ancm
 * JD-Core Version:    0.7.0.1
 */