import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class anpc
  extends anpp
{
  protected anpc(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = bfsm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130844622));
    this.jdField_a_of_type_Anpt.a((Bitmap)localObject);
    localObject = a() + ": ";
    this.jdField_a_of_type_Anpt.b((String)localObject);
    localObject = c();
    this.jdField_a_of_type_Anpt.d((String)localObject);
    b(paramMessage);
    return this.jdField_a_of_type_Anpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */