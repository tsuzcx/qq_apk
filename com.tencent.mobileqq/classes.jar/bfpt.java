import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1;
import java.util.List;

public class bfpt
  extends aoiz
{
  bfpt(bfpr parambfpr, MessageRecord paramMessageRecord, bfpu parambfpu) {}
  
  protected void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        bfpr.a(this.jdField_a_of_type_Bfpr, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (TroopAioKeywordTipInfo)paramList.get(0), this.jdField_a_of_type_Bfpu);
        synchronized (this.jdField_a_of_type_Bfpr.b)
        {
          this.jdField_a_of_type_Bfpr.b.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      bfpr.a(this.jdField_a_of_type_Bfpr, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bfpu);
      return;
    }
    bfpr.a(this.jdField_a_of_type_Bfpr, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bfpu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpt
 * JD-Core Version:    0.7.0.1
 */