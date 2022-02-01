import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem.MsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class bgbx
  implements bgbz
{
  bgbx(bgbv parambgbv, ArrayList paramArrayList, int paramInt) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    ArrayList localArrayList = paramImportantMsgItem.getMsgInfoList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    label23:
    Long localLong;
    int j;
    if (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      j = localArrayList.indexOf(bgca.a(localLong.longValue()));
      if (-1 == j) {
        break label224;
      }
      ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNeedShow = false;
      ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgSummary = "";
      if (this.jdField_a_of_type_Int == 1) {
        ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNotShowType = 1;
      }
    }
    label224:
    label225:
    for (;;)
    {
      label117:
      QLog.i("ImportantMsgManager", 2, "delImportantMsg msgSeq:" + localLong + " from:" + this.jdField_a_of_type_Int);
      i = 1;
      for (;;)
      {
        break label23;
        if (this.jdField_a_of_type_Int != 2) {
          break label225;
        }
        ((ImportantMsgItem.MsgInfo)localArrayList.get(j)).msgNotShowType = 2;
        break label117;
        if (i != 0) {
          this.jdField_a_of_type_Bgbv.a(paramImportantMsgItem.clone());
        }
        if ((this.jdField_a_of_type_Int != 1) && (i == 0)) {
          break;
        }
        bgbv.a(this.jdField_a_of_type_Bgbv, paramLong);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbx
 * JD-Core Version:    0.7.0.1
 */