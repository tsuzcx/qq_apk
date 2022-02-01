import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;

public class arun
  implements DialogInterface.OnClickListener
{
  public arun(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, ahzq paramahzq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((aqva)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, -1);
    this.jdField_a_of_type_Ahzq.a(0, aquz.h, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arun
 * JD-Core Version:    0.7.0.1
 */