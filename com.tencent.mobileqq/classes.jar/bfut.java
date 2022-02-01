import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bfut
  implements bfuu
{
  bfut(bfuo parambfuo, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bful, bfum> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bful localbful = new bful(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bfum localbfum = (bfum)paramHashMap.get(localbful);
    if (localbfum != null)
    {
      if (localbfum.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType)
      {
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet 本地已经存在且状态一致 直接丢弃");
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbful.toString() + " oldValue:" + localbfum.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime = localbfum.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq = localbfum.b;
    }
    localbfum = new bfum(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    paramHashMap.put(localbful, localbfum);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbful.toString() + " value:" + localbfum.toString());
    bfuo.a(this.jdField_a_of_type_Bfuo, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin);
    this.jdField_a_of_type_Bfuo.a(new TroopEssenceMsgItem(localbful, localbfum));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfut
 * JD-Core Version:    0.7.0.1
 */