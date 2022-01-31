import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1;
import java.util.List;

public class bblp
  extends alzj
{
  bblp(bbln parambbln, MessageRecord paramMessageRecord, bblq parambblq) {}
  
  protected void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        bbln.a(this.jdField_a_of_type_Bbln, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (TroopAioKeywordTipInfo)paramList.get(0), this.jdField_a_of_type_Bblq);
        synchronized (this.jdField_a_of_type_Bbln.b)
        {
          this.jdField_a_of_type_Bbln.b.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      bbln.a(this.jdField_a_of_type_Bbln, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bblq);
      return;
    }
    bbln.a(this.jdField_a_of_type_Bbln, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Bblq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblp
 * JD-Core Version:    0.7.0.1
 */