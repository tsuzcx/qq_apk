import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aulc
  implements awfy
{
  private int jdField_a_of_type_Int;
  private aukx jdField_a_of_type_Aukx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private int b;
  
  private aulc(MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, aukx paramaukx)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aukx = paramaukx;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    if (paramRichText != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack attachRichText2Msg with " + paramRichText.toString());
      }
      if (((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForRichText)) && (((MessageForRichText)this.jdField_a_of_type_JavaUtilArrayList.get(0)).richText == null)) {
        if (QLog.isColorLevel()) {
          break label185;
        }
      }
      for (;;)
      {
        ((MessageForRichText)this.jdField_a_of_type_JavaUtilArrayList.get(0)).richText = paramRichText;
        if (!(this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForPtt)) {
          break label272;
        }
        if (((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize >= 0L) {
          break label211;
        }
        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg with fileSize < 0");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
        paramRichText = Thread.currentThread().getStackTrace();
        int j = paramRichText.length;
        int i = 0;
        while (i < j)
        {
          QLog.d("MultiMsg_TAG", 2, new Object[] { paramRichText[i] });
          i += 1;
        }
        label185:
        QLog.d("MultiMsg_TAG", 2, "PttUploadCallback.attachRichText2Msg return but mr.richtext is null");
      }
      ((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize = 1L;
      for (;;)
      {
        label211:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
        aukx.a(this.jdField_a_of_type_Aukx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new HashMap(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, true, this.b);
        return null;
        label272:
        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg but not message for ptt");
      }
    }
    QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack attachRichText2Msg with null");
    return null;
  }
  
  public void a(awfz paramawfz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack updateMsg with " + paramawfz.toString());
    }
  }
  
  public void b(awfz paramawfz)
  {
    if (paramawfz.jdField_a_of_type_Int != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack onSend fail with " + paramawfz.toString());
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof MessageForPtt))
      {
        if (((MessageForPtt)this.jdField_a_of_type_JavaUtilArrayList.get(0)).fileSize < 0L)
        {
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend with fileSize < 0");
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
            paramawfz = Thread.currentThread().getStackTrace();
            int j = paramawfz.length;
            int i = 0;
            while (i < j)
            {
              QLog.d("MultiMsg_TAG", 2, new Object[] { paramawfz[i] });
              i += 1;
            }
          }
        }
      }
      else {
        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend but no message for ptt");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
      aukx.a(this.jdField_a_of_type_Aukx, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack onSend result ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */