import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class bddh
  implements bded
{
  ausa jdField_a_of_type_Ausa;
  private bddc jdField_a_of_type_Bddc = new bddi(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bddh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bddc);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if (paramInt1 == 8) {}
    for (String str = "exp_openframe";; str = "exp_joinbar")
    {
      a(paramString, str);
      bfur.a(paramContext, 230, null, paramContext.getResources().getString(2131698658), paramContext.getResources().getString(2131690620), paramContext.getResources().getString(2131691215), new bddj(this, paramString, paramInt1, paramBundle, paramInt2, paramContext), new bddk(this, paramString, paramInt1)).show();
      return;
    }
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    aqde localaqde = (aqde)apub.a().a(535);
    if (localaqde == null) {}
    TroopInfo localTroopInfo;
    for (int i = 0;; i = localaqde.a.a())
    {
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
      if ((i != 0) && (localTroopInfo != null)) {
        break;
      }
      QQToast.a(paramContext, 0, 2131692889, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherManager", 2, new Object[] { "reopenCategoryPage version=", Integer.valueOf(i), " troopInfo=", localTroopInfo });
      }
      return;
    }
    paramString = bddg.a(false, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramString, paramInt2);
    bddg.a(paramContext, localaqde.a.b(), localaqde.a.a(), localaqde.a.b(), paramString, paramInt1);
  }
  
  private void a(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()))
    {
      QLog.e("WatchTogetherManager", 1, "topActivity is null or finishing");
      return;
    }
    a(paramString2, "exp_unableframe");
    bfur.a(localBaseActivity, 230, null, paramString3, paramContext.getResources().getString(2131693864), paramContext.getResources().getString(2131694201), new bddl(this, paramString2), new bddm(this, paramString2, paramString1, paramInt1, paramInt2)).show();
  }
  
  private void a(Bundle paramBundle, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramBundle.getInt("category_id", 0);
    String str1 = paramBundle.getString("video_id", "");
    String str2 = paramBundle.getString("title_name", "");
    paramBundle = paramBundle.getString("room_cover", "");
    ((bddd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(165)).a(i, str1, str2, paramBundle, 1, paramString, paramInt1, paramInt2);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString2);
    if (localTroopInfo == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 0, 2131692889, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherManager", 2, new Object[] { "reopenVideoRoom troopInfo=", localTroopInfo });
      }
      return;
    }
    paramString2 = bddg.a(false, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramString2, paramInt2);
    bddg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString1, null, paramString2, paramInt1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ((bdct)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339)).a("video_tab", paramString2, 0, paramString1);
  }
  
  public int a()
  {
    return 7;
  }
  
  public ausa a()
  {
    if (this.jdField_a_of_type_Ausa == null) {
      this.jdField_a_of_type_Ausa = ((ausa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338));
    }
    return this.jdField_a_of_type_Ausa;
  }
  
  public QQCustomDialog a()
  {
    return null;
  }
  
  public String a()
  {
    return bdcs.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bddc);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, bddf> paramMap, @Nullable Bundle paramBundle)
  {
    QLog.i("WatchTogetherManager", 1, "notifySessionChange  serviceType = " + paramInt1 + " from = " + paramInt3);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramInt == 5) {
      a().a();
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramContext, paramInt2, paramInt1, paramString, paramBundle);
  }
  
  public void a(bddf parambddf, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherManager", 1, "onPushMessageReceive");
    a().a((WatchTogetherSession)parambddf, paramInt);
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, bddf> paramMap, @Nullable Bundle paramBundle)
  {
    if (paramInt2 == 0) {}
    for (paramContext = "2";; paramContext = "")
    {
      QLog.i("WatchTogetherManager", 1, "start  groupuin = " + paramString + " miniapp_from = " + paramContext);
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
      paramMap = localWatchTogetherSession;
      if (localWatchTogetherSession == null) {}
      try
      {
        paramMap = (WatchTogetherSession)bddg.a(2, 1, paramString);
        a().a(paramContext, paramMap, paramBundle);
        return false;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramMap = localWatchTogetherSession;
        }
      }
    }
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, bddf> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, bddf> paramMap, @Nullable Bundle paramBundle)
  {
    paramContext = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
    QLog.i("WatchTogetherManager", 1, "join  groupuin = " + paramString + " from = " + paramInt2);
    if (paramInt2 == 2) {
      a().a("4", paramContext, paramBundle);
    }
    while (((paramInt2 != 1) && (paramInt2 != 8)) || (paramContext == null)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramContext.a)) && (!paramContext.a.contains("fromid"))) {
      paramContext.a = (paramContext.a + "&fromid=" + "10011");
    }
    a().a(paramContext, paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddh
 * JD-Core Version:    0.7.0.1
 */