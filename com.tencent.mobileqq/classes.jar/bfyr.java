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

public class bfyr
  extends bfye
{
  public bfyr(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 11;
  }
  
  @Nullable
  public bfyg a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = bffr.a(paramInt1, paramLong1, paramInt2);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698364);
    paramList = "";
    boolean bool2 = false;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    if (localMessageRecord != null) {
      paramList = localMessageRecord.senderuin;
    }
    boolean bool1 = bool2;
    if (paramLong2 != bfyo.a)
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
      return new bfyg(true, str1, paramObject, paramList);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(anvx.a(2131714524));
    paramTextView2.setText(anvx.a(2131714535));
    paramTextView1.setTextSize(1, 13.0F);
    paramTextView2.setTextSize(1, 13.0F);
  }
  
  public void a(int paramInt1, bffr parambffr, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, parambffr, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    paramString = null;
    if (paramLong != bfyo.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong);
    }
    if (paramString != null) {
      paramTextView1.setText(anvx.a(2131714529));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType == 7) || (paramString.messageType == 8))
      {
        paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718519));
        parambffr.b = true;
      }
    }
    while (paramInt2 <= 0)
    {
      return;
      paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718503));
      parambffr.a = true;
      return;
    }
    parambffr.a = false;
    paramTextView2.setText(anvx.a(2131714527));
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyr
 * JD-Core Version:    0.7.0.1
 */