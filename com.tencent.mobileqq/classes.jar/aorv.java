import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aorv
  extends aosi
{
  protected aorv(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = bhbd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130844688));
    this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
    localObject = a() + ": ";
    this.jdField_a_of_type_Aosm.b((String)localObject);
    localObject = c();
    this.jdField_a_of_type_Aosm.d((String)localObject);
    b(paramMessage);
    return this.jdField_a_of_type_Aosm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorv
 * JD-Core Version:    0.7.0.1
 */