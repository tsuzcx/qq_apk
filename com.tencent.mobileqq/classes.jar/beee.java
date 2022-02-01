import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class beee
  implements beef
{
  beee(bedz parambedz, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bedw, bedx> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bedw localbedw = new bedw(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bedx localbedx = (bedx)paramHashMap.get(localbedw);
    if (localbedx != null)
    {
      if (localbedx.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType)
      {
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet 本地已经存在且状态一致 直接丢弃");
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbedw.toString() + " oldValue:" + localbedx.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime = localbedx.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq = localbedx.b;
    }
    localbedx = new bedx(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    paramHashMap.put(localbedw, localbedx);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbedw.toString() + " value:" + localbedx.toString());
    bedz.a(this.jdField_a_of_type_Bedz, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin);
    this.jdField_a_of_type_Bedz.a(new TroopEssenceMsgItem(localbedw, localbedx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beee
 * JD-Core Version:    0.7.0.1
 */