import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class bflh
  implements bfli
{
  bflh(bfle parambfle, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.jdField_a_of_type_JavaUtilArrayList);
    if ((bfle.a(this.jdField_a_of_type_Bfle).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)bfle.a(this.jdField_a_of_type_Bfle).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImportantMsgManager", 2, "handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:" + paramImportantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + bfle.a(this.jdField_a_of_type_Bfle).get(Long.valueOf(paramLong)));
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.jdField_a_of_type_Bfle.a(paramImportantMsgItem.clone());
    bfle.a(this.jdField_a_of_type_Bfle, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflh
 * JD-Core Version:    0.7.0.1
 */