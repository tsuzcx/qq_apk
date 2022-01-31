import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class asjx
  extends bbwm
{
  public asjx(ChatBackgroundManager paramChatBackgroundManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    super.a(paramLong, paramInt, paramBundle);
    paramBundle = ChatBackgroundManager.a(true, paramLong + "");
    if (new File(paramBundle).exists()) {
      acuv.a(this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a.c(), this.jdField_a_of_type_JavaLangString, paramBundle, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjx
 * JD-Core Version:    0.7.0.1
 */