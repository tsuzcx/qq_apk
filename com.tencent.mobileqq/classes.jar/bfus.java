import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bfus
  implements bfuu
{
  bfus(bfuo parambfuo, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bful, bfum> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bful localbful = new bful(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bfum localbfum1 = new bfum(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush msgInfo:" + this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.toString());
    bfum localbfum2 = (bfum)paramHashMap.get(localbful);
    if ((localbfum2 != null) && (localbfum1.a <= localbfum2.a))
    {
      QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush oldValue.opTime:" + localbfum2.a);
      return;
    }
    paramHashMap.put(localbful, localbfum1);
    bfuo.a(this.jdField_a_of_type_Bfuo, paramLong);
    this.jdField_a_of_type_Bfuo.a(new TroopEssenceMsgItem(localbful, localbfum1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfus
 * JD-Core Version:    0.7.0.1
 */