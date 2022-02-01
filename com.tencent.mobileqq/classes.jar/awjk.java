import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class awjk
  extends azvc
{
  awjk(awji paramawji, QQAppInterface paramQQAppInterface) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "updateNumMsg: appid msgList.size = " + paramList.size());
    }
    if (("nearby_num_red_dot".equals(paramString)) && (paramList != null))
    {
      this.jdField_a_of_type_Awji.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      awji.a(this.jdField_a_of_type_Awji, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
      if ((paramString != null) && (paramString.a("businessbase_processor") != null)) {
        paramString.a("businessbase_processor").a(105, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjk
 * JD-Core Version:    0.7.0.1
 */