import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1;
import java.util.List;

public class azng
  extends akht
{
  azng(azne paramazne, MessageRecord paramMessageRecord, aznh paramaznh) {}
  
  protected void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        azne.a(this.jdField_a_of_type_Azne, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (TroopAioKeywordTipInfo)paramList.get(0), this.jdField_a_of_type_Aznh);
        synchronized (this.jdField_a_of_type_Azne.b)
        {
          this.jdField_a_of_type_Azne.b.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      azne.a(this.jdField_a_of_type_Azne, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Aznh);
      return;
    }
    azne.a(this.jdField_a_of_type_Azne, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Aznh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azng
 * JD-Core Version:    0.7.0.1
 */