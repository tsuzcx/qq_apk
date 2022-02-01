import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class beed
  implements beef
{
  beed(bedz parambedz, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bedw, bedx> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bedw localbedw = new bedw(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bedx localbedx1 = new bedx(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush msgInfo:" + this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.toString());
    bedx localbedx2 = (bedx)paramHashMap.get(localbedw);
    if ((localbedx2 != null) && (localbedx1.a <= localbedx2.a))
    {
      QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush oldValue.opTime:" + localbedx2.a);
      return;
    }
    paramHashMap.put(localbedw, localbedx1);
    bedz.a(this.jdField_a_of_type_Bedz, paramLong);
    this.jdField_a_of_type_Bedz.a(new TroopEssenceMsgItem(localbedw, localbedx1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beed
 * JD-Core Version:    0.7.0.1
 */