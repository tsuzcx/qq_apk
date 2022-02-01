import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class beuu
  implements beuv
{
  beuu(beur parambeur, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.jdField_a_of_type_JavaUtilArrayList);
    if ((beur.a(this.jdField_a_of_type_Beur).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)beur.a(this.jdField_a_of_type_Beur).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImportantMsgManager", 2, "handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:" + paramImportantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + beur.a(this.jdField_a_of_type_Beur).get(Long.valueOf(paramLong)));
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.jdField_a_of_type_Beur.a(paramImportantMsgItem.clone());
    beur.a(this.jdField_a_of_type_Beur, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beuu
 * JD-Core Version:    0.7.0.1
 */