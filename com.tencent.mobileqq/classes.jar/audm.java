import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.ITbsReaderCallback;

class audm
  implements ITbsReaderCallback
{
  audm(audj paramaudj) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "initTbsReaderEntry: eventType[" + paramInteger + "] code[" + paramObject1.toString() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audm
 * JD-Core Version:    0.7.0.1
 */