import android.util.SparseArray;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2;
import java.util.Iterator;
import java.util.List;

public class bfps
  extends aoiz
{
  public bfps(TroopAioKeywordTipManager.2 param2) {}
  
  protected void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    SparseArray localSparseArray;
    if (paramBoolean)
    {
      localSparseArray = this.a.this$0.b;
      if (paramList != null) {
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramList.next();
            this.a.this$0.b.put(localTroopAioKeywordTipInfo.ruleId, localTroopAioKeywordTipInfo);
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfps
 * JD-Core Version:    0.7.0.1
 */