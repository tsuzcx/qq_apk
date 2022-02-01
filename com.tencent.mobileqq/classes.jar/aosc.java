import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;

public class aosc
  extends aosi
{
  protected aosc(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = a() + ": ";
    this.jdField_a_of_type_Aosm.b((String)localObject);
    this.jdField_a_of_type_Aosm.d(c());
    a();
    a(paramMessage, this.jdField_a_of_type_Aosm);
    if (!pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) {
      return null;
    }
    localObject = this.jdField_a_of_type_Aosm.a();
    pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), paramMessage, (Intent)localObject);
    paramMessage = bheg.e();
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842738);
    if ((localDrawable instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localDrawable).getBitmap();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aosm.a((Intent)localObject);
      this.jdField_a_of_type_Aosm.a(paramMessage);
      return this.jdField_a_of_type_Aosm;
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        paramMessage = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosc
 * JD-Core Version:    0.7.0.1
 */