import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class aukz
  extends azaj
{
  aukz(aukx paramaukx, ArrayList paramArrayList, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, int paramInt2) {}
  
  public void a(int paramInt, ArrayList<azaa> paramArrayList)
  {
    int i;
    int k;
    int j;
    MessageRecord localMessageRecord;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult success[" + paramArrayList.size() + "]");
      }
      i = 0;
      k = 0;
      paramInt = 0;
      j = paramInt;
      if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label278;
      }
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (!(localMessageRecord instanceof MessageForShortVideo)) {
        break label363;
      }
      if (i >= paramArrayList.size())
      {
        QLog.e("MultiMsg_TAG", 1, "MultiForwardVideo: error index!");
        j = i;
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      k += 1;
      j = i;
      i = paramInt;
      paramInt = j;
      break;
      azaa localazaa = (azaa)paramArrayList.get(i);
      j = paramInt;
      if (localazaa != null)
      {
        if ((localazaa.jdField_a_of_type_Int != 0) || (localazaa.jdField_a_of_type_JavaLangObject == null) || (!(localazaa.jdField_a_of_type_JavaLangObject instanceof im_msg_body.RichText))) {
          break label213;
        }
        ((MessageForShortVideo)localMessageRecord).richText = ((im_msg_body.RichText)localazaa.jdField_a_of_type_JavaLangObject);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = i + 1;
        i = j;
        break;
        label213:
        j = paramInt;
        if (localazaa.jdField_a_of_type_Int == -1)
        {
          j = paramInt;
          if (localazaa.jdField_a_of_type_Awey != null)
          {
            j = paramInt;
            if ("cancel".equals(localazaa.jdField_a_of_type_Awey.b)) {
              j = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult failed!");
      }
      j = 0;
      label278:
      if (j != 0) {
        aukx.a(this.jdField_a_of_type_Aukx, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
      do
      {
        return;
        aukx.a(this.jdField_a_of_type_Aukx, 2);
      } while (aukx.c(this.jdField_a_of_type_Aukx) != 0);
      aukx.a(this.jdField_a_of_type_Aukx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, false, this.b);
      return;
      label363:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aukz
 * JD-Core Version:    0.7.0.1
 */