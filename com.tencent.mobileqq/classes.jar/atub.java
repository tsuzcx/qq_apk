import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;

class atub
  implements TbsReaderView.ReaderCallback
{
  atub(atua paramatua, atuf paramatuf) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "recv actionType[" + paramInteger + "]");
    }
    if (paramInteger.intValue() == 5012)
    {
      int i = ((Integer)paramObject1).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "err Code[" + i + "]");
      }
      if (i != 0) {
        break label129;
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return ok 1-------");
      }
      if (this.jdField_a_of_type_Atuf != null) {
        this.jdField_a_of_type_Atuf.b(true);
      }
    }
    label129:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return ok 2-------");
      }
    } while (this.jdField_a_of_type_Atuf == null);
    this.jdField_a_of_type_Atuf.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atub
 * JD-Core Version:    0.7.0.1
 */