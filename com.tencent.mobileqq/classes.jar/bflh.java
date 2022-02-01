import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bflh
  implements bfli
{
  bflh(bflc parambflc, TroopEssenceMsgItem paramTroopEssenceMsgItem) {}
  
  public void a(long paramLong, HashMap<bfkz, bfla> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    bfkz localbfkz = new bfkz(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSeq, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgRandom);
    bfla localbfla = (bfla)paramHashMap.get(localbfkz);
    if (localbfla != null)
    {
      if (localbfla.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType)
      {
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet 本地已经存在且状态一致 直接丢弃");
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbfkz.toString() + " oldValue:" + localbfla.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime = localbfla.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq = localbfla.b;
    }
    localbfla = new bfla(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opType, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.msgSenderUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opUin, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.opTime, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.graytipuniseq);
    paramHashMap.put(localbfkz, localbfla);
    QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + localbfkz.toString() + " value:" + localbfla.toString());
    bflc.a(this.jdField_a_of_type_Bflc, this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgItem.troopUin);
    this.jdField_a_of_type_Bflc.a(new TroopEssenceMsgItem(localbfkz, localbfla));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflh
 * JD-Core Version:    0.7.0.1
 */