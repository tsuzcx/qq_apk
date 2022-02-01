import com.tencent.mobileqq.troop.associations.AllianceItem;
import com.tencent.qphone.base.util.QLog;

class bfcn
  extends aofu
{
  bfcn(bfcm parambfcm) {}
  
  protected void onGetRelatedTroopList(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    if (paramAllianceItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssociationsListWrapper", 1, "TroopAssociationsListWrapper onGetRelatedTroopList: allianceItem is null");
      }
      this.a.a(paramBoolean, paramString, paramInt, null, 0, null, paramLong);
      return;
    }
    this.a.a(paramBoolean, paramString, paramInt, paramAllianceItem.nextTroopUin, paramAllianceItem.associatedTroopCount, paramAllianceItem.associatedTroopList, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcn
 * JD-Core Version:    0.7.0.1
 */