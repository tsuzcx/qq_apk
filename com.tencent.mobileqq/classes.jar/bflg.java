import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bflg
  implements bfli
{
  bflg(bflc parambflc, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bfkz, bfla> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bfkz localbfkz = new bfkz(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bfla localbfla1 = new bfla(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush msgInfo:" + this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.toString());
    bfla localbfla2 = (bfla)paramHashMap.get(localbfkz);
    if ((localbfla2 != null) && (localbfla1.a <= localbfla2.a))
    {
      QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush oldValue.opTime:" + localbfla2.a);
      return;
    }
    paramHashMap.put(localbfkz, localbfla1);
    bflc.a(this.jdField_a_of_type_Bflc, paramLong);
    this.jdField_a_of_type_Bflc.a(new TroopEssenceMsgItem(localbfkz, localbfla1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflg
 * JD-Core Version:    0.7.0.1
 */