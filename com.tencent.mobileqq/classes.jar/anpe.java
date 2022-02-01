import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class anpe
  extends anpp
{
  protected anpe(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = bfsm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130844883));
    this.jdField_a_of_type_Anpt.a((Bitmap)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698074);
    this.jdField_a_of_type_Anpt.c((String)localObject);
    localObject = new ConfessInfo();
    ((ConfessInfo)localObject).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
    localObject = apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ConfessInfo)localObject, paramMessage.senderuin);
    String str = (String)localObject + "(" + a() + "):" + c();
    this.jdField_a_of_type_Anpt.b(str);
    localObject = (String)localObject + ":" + c();
    this.jdField_a_of_type_Anpt.d((String)localObject);
    b(paramMessage);
    return this.jdField_a_of_type_Anpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */