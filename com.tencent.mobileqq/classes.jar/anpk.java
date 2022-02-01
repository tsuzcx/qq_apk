import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class anpk
  extends anpp
{
  protected anpk(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 266;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
    this.jdField_a_of_type_Anpt.a((Bitmap)localObject);
    localObject = a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698187);
    this.jdField_a_of_type_Anpt.c(str);
    str = (String)localObject + "(" + a() + "): " + c();
    this.jdField_a_of_type_Anpt.b(str);
    localObject = (String)localObject + ": " + c();
    this.jdField_a_of_type_Anpt.d((String)localObject);
    this.jdField_a_of_type_Anpt.b(this.jdField_a_of_type_Anpt.b() + this.jdField_a_of_type_Anpt.a());
    a(paramMessage, this.jdField_a_of_type_Anpt);
    return this.jdField_a_of_type_Anpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpk
 * JD-Core Version:    0.7.0.1
 */