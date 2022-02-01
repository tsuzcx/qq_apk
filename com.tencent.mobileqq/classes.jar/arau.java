import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class arau
  implements URLDrawable.URLDrawableListener
{
  public arau(EmoticonFromGroupManager.5 param5, URLDrawable paramURLDrawable, CustomEmotionData paramCustomEmotionData, arbb paramarbb, arba paramarba) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    araq.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    araq.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    araq.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.a(paramURLDrawable)) {}
    String str;
    do
    {
      do
      {
        return;
        str = araq.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0, paramURLDrawable);
      } while ("".equals(str));
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath = str;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = paramURLDrawable;
    } while ("".equals(str));
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 4, "onLoadSuccessed upload emo " + paramURLDrawable);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
      this.jdField_a_of_type_Arbb.d(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_Arba.c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arau
 * JD-Core Version:    0.7.0.1
 */