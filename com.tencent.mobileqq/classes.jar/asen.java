import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import java.util.Iterator;
import java.util.List;

class asen
  extends auqd
{
  asen(asem paramasem, QQAppInterface paramQQAppInterface) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (("nearby_num_red_dot".equals(paramString)) && (paramList != null))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (NumRedMsg.NumMsgBusi)paramString.next();
        this.jdField_a_of_type_Asem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.ui_appid.get(), paramList.str_path.get(), paramList.str_ext.get());
      }
      ajqy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((paramString != null) && (paramString.a("businessbase_processor") != null)) {
        paramString.a("businessbase_processor").a(105, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asen
 * JD-Core Version:    0.7.0.1
 */