import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auwb
  extends axlr
{
  auwb(auwa paramauwa, QQAppInterface paramQQAppInterface) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "updateNumMsg: appid msgList.size = " + paramList.size());
    }
    if (("nearby_num_red_dot".equals(paramString)) && (paramList != null))
    {
      this.jdField_a_of_type_Auwa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      ambm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((paramString != null) && (paramString.a("businessbase_processor") != null)) {
        paramString.a("businessbase_processor").a(105, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwb
 * JD-Core Version:    0.7.0.1
 */