import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class aorx
  extends aosi
{
  protected aorx(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = bhbd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130844957));
    this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698360);
    this.jdField_a_of_type_Aosm.c((String)localObject);
    localObject = new ConfessInfo();
    ((ConfessInfo)localObject).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
    localObject = aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ConfessInfo)localObject, paramMessage.senderuin);
    String str = (String)localObject + "(" + a() + "):" + c();
    this.jdField_a_of_type_Aosm.b(str);
    localObject = (String)localObject + ":" + c();
    this.jdField_a_of_type_Aosm.d((String)localObject);
    b(paramMessage);
    return this.jdField_a_of_type_Aosm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorx
 * JD-Core Version:    0.7.0.1
 */