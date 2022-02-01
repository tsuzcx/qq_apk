import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class bgby
  implements bgbz
{
  bgby(bgbv parambgbv, ArrayList paramArrayList) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    paramImportantMsgItem.addMsgInfos(this.jdField_a_of_type_JavaUtilArrayList);
    if ((bgbv.a(this.jdField_a_of_type_Bgbv).containsKey(Long.valueOf(paramLong))) && (paramImportantMsgItem.maxImportantMsgSeq >= ((Integer)bgbv.a(this.jdField_a_of_type_Bgbv).get(Long.valueOf(paramLong))).intValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImportantMsgManager", 2, "handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:" + paramImportantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + bgbv.a(this.jdField_a_of_type_Bgbv).get(Long.valueOf(paramLong)));
      }
      paramImportantMsgItem.updateMaxMsgSeq();
    }
    this.jdField_a_of_type_Bgbv.a(paramImportantMsgItem.clone());
    bgbv.a(this.jdField_a_of_type_Bgbv, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgby
 * JD-Core Version:    0.7.0.1
 */