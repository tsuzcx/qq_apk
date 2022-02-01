import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aofe
  extends aofu
{
  public aofe(TroopManager paramTroopManager) {}
  
  protected void onActiveExtTroop(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onActiveExtTroop success: " + paramBoolean + " troopUin: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      ((aoep)this.a.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).j(paramString);
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onGetTroopInfoResult success: troopUin: " + paramString);
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramString = (TroopMemberCardInfo)paramArrayList.get(i);
        this.a.b(paramString.troopuin, paramString.memberuin);
        i += 1;
      }
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    TroopManager.a(this.a, paramInt1, paramInt2, paramString);
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    TroopManager.a(this.a, paramString, paramBoolean, paramList, paramInt1, paramLong, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofe
 * JD-Core Version:    0.7.0.1
 */