import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class assw
  extends akil
{
  public assw(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "onUpdateTroopGetMemberList（） troopUin =  " + paramString);
    }
    if ((paramInt1 == 9) && (paramString.equals(MultiCardRecommendFragment.a(this.a))) && (this.a.a != null)) {
      this.a.a.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assw
 * JD-Core Version:    0.7.0.1
 */