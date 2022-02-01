import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aosd
  extends aosi
{
  protected aosd(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 266;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
    this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
    localObject = a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698473);
    this.jdField_a_of_type_Aosm.c(str);
    str = (String)localObject + "(" + a() + "): " + c();
    this.jdField_a_of_type_Aosm.b(str);
    localObject = (String)localObject + ": " + c();
    this.jdField_a_of_type_Aosm.d((String)localObject);
    this.jdField_a_of_type_Aosm.b(this.jdField_a_of_type_Aosm.b() + this.jdField_a_of_type_Aosm.a());
    a(paramMessage, this.jdField_a_of_type_Aosm);
    return this.jdField_a_of_type_Aosm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosd
 * JD-Core Version:    0.7.0.1
 */