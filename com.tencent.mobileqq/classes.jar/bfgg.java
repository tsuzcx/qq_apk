import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1;
import java.util.List;

public class bfgg
  extends aofa
{
  bfgg(bfge parambfge, MessageRecord paramMessageRecord, bfgh parambfgh) {}
  
  protected void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        bfge.a(this.jdField_a_of_type_Bfge, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (TroopAioKeywordTipInfo)paramList.get(0), this.jdField_a_of_type_Bfgh);
        synchronized (this.jdField_a_of_type_Bfge.b)
        {
          this.jdField_a_of_type_Bfge.b.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      bfge.a(this.jdField_a_of_type_Bfge, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bfgh);
      return;
    }
    bfge.a(this.jdField_a_of_type_Bfge, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bfgh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgg
 * JD-Core Version:    0.7.0.1
 */