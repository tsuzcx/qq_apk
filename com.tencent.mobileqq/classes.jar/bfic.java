import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bfic
  extends bfhp
{
  public bfic(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 11;
  }
  
  @Nullable
  public bfhr a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = bepx.a(paramInt1, paramLong1, paramInt2);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697837);
    paramList = "";
    boolean bool2 = false;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if (localMessageRecord != null) {
      paramList = localMessageRecord.senderuin;
    }
    boolean bool1 = bool2;
    if (paramLong2 != bfhz.a)
    {
      bool1 = bool2;
      if (paramLong1 < paramLong2) {
        bool1 = true;
      }
    }
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = this.jdField_a_of_type_JavaLangString + ".troop.special_msg.confess_to_me";
      localStringBuilder = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
      if (localMessageRecord == null) {
        break label188;
      }
    }
    label188:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d(str2, 2, bool2 + ", isShow = " + bool1);
      if (!bool1) {
        break;
      }
      return new bfhr(true, str1, paramObject, paramList);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(anni.a(2131713836));
    paramTextView2.setText(anni.a(2131713847));
    paramTextView1.setTextSize(1, 13.0F);
    paramTextView2.setTextSize(1, 13.0F);
  }
  
  public void a(int paramInt1, bepx parambepx, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, parambepx, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    paramString = null;
    if (paramLong != bfhz.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    if (paramString != null) {
      paramTextView1.setText(anni.a(2131713841));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType == 7) || (paramString.messageType == 8))
      {
        paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717763));
        parambepx.b = true;
      }
    }
    while (paramInt2 <= 0)
    {
      return;
      paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717749));
      parambepx.a = true;
      return;
    }
    parambepx.a = false;
    paramTextView2.setText(anni.a(2131713839));
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfic
 * JD-Core Version:    0.7.0.1
 */