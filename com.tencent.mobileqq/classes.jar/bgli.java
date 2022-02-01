import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class bgli
  implements bglj
{
  bgli(bglf parambglf, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.jdField_a_of_type_JavaUtilArrayList);
    if ((bglf.a(this.jdField_a_of_type_Bglf).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)bglf.a(this.jdField_a_of_type_Bglf).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImportantMsgManager", 2, "handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:" + paramImportantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + bglf.a(this.jdField_a_of_type_Bglf).get(Long.valueOf(paramLong)));
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.jdField_a_of_type_Bglf.a(paramImportantMsgItem.clone());
    bglf.a(this.jdField_a_of_type_Bglf, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgli
 * JD-Core Version:    0.7.0.1
 */