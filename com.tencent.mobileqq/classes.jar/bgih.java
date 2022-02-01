import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;

public class bgih
  extends bght
{
  public bgih(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 100;
  }
  
  public int a(int paramInt)
  {
    return 2130847481;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setText(2131698510);
    paramTextView2.setVisibility(0);
    paramTextView1.setVisibility(0);
  }
  
  public void a(int paramInt1, bfpe parambfpe, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, parambfpe, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    paramString = null;
    if (paramLong != bgia.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    if (paramString != null) {
      paramTextView1.setText(bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString.senderuin));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType == 7) || (paramString.messageType == 8))
      {
        paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717894));
        parambfpe.b = true;
      }
    }
    while (paramInt2 <= 0)
    {
      return;
      paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717880));
      parambfpe.a = true;
      return;
    }
    parambfpe.a = false;
    paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramInt2 > 99) {}
    for (parambfpe = "99+";; parambfpe = Integer.valueOf(paramInt2))
    {
      paramTextView1.setText(paramString.getString(2131698513, new Object[] { parambfpe }));
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgih
 * JD-Core Version:    0.7.0.1
 */