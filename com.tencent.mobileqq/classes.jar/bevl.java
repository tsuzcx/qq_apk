import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bevl
  extends betr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public agwl a;
  private amwl jdField_a_of_type_Amwl;
  private andd jdField_a_of_type_Andd;
  private betp jdField_a_of_type_Betp;
  private beud jdField_a_of_type_Beud;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  
  public bevl(BaseChatPie paramBaseChatPie, betp parambetp)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Betp = parambetp;
    this.jdField_a_of_type_Long = a();
    g();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_Beud);
    a(this.jdField_a_of_type_Amwl);
    a(this.jdField_a_of_type_Andd);
    if (bcoo.a()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    do
    {
      do
      {
        return 0L;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin == null));
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  private ArrayList<betu> a(ArrayList<betv> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      betv localbetv = (betv)paramArrayList.next();
      if ((localbetv != null) && ((localbetv instanceof betu))) {
        localArrayList.add(localbetv);
      }
    }
    return localArrayList;
  }
  
  private void a(BusinessObserver paramBusinessObserver)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (paramBusinessObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(paramBusinessObserver);
    }
  }
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (paramBusinessObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(paramBusinessObserver);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Beud = new bevm(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    this.jdField_a_of_type_Andd = new bevn(this);
    this.jdField_a_of_type_Amwl = new bevo(this);
  }
  
  private void h()
  {
    Object localObject = (beua)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(355);
    if ((!"".equals(this.jdField_a_of_type_JavaLangString)) && (localObject != null))
    {
      long l = ((beua)localObject).c(this.jdField_a_of_type_Long);
      if (l > ((beua)localObject).b(this.jdField_a_of_type_Long)) {
        ((beua)localObject).a(this.jdField_a_of_type_Long, l);
      }
      localObject = ((beua)localObject).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = ((betz)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((betv)((Iterator)localObject).next()).a(false);
        }
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    betw localbetw;
    bety localbety;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      localbetw = (betw)apub.a().a(590);
      localbety = (bety)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(171);
    } while ((localbetw == null) || (localTroopInfo == null) || ((!localbetw.a((int)localTroopInfo.dwGroupClassExt)) && (!localbetw.b((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      boolean bool;
      try
      {
        localbetz = ((beua)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(355)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localbetz == null) {
          break label357;
        }
        if (!bcoo.a()) {
          break label326;
        }
        i = 1;
        if ((localbetz.a() < System.currentTimeMillis()) || ((bcoo.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          localbety.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShow. updateAppShortcutPanel. ");
        }
        if (localTroopInfo.isAdmin()) {
          break label388;
        }
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin())) {
          break label331;
        }
      }
      catch (Exception localException)
      {
        betz localbetz;
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      if (i == 0)
      {
        if (localbetw.jdField_a_of_type_Int == betw.c)
        {
          bool = true;
          if (((i == 0) && (localbetz.a() == 0)) || ((i != 0) && (localbetz.b() == 0)))
          {
            this.jdField_a_of_type_Betp.a(0, a(localbetz.a()), bool);
            return;
            label326:
            i = 0;
            continue;
            label331:
            i = 0;
            continue;
          }
        }
        else
        {
          bool = false;
          continue;
        }
      }
      else
      {
        bool = true;
        continue;
      }
      this.jdField_a_of_type_Betp.a(0, null, bool);
      return;
      label357:
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
      }
      localbety.a(this.jdField_a_of_type_Long, (int)localException.dwGroupClassExt, null);
      return;
      label388:
      int i = 1;
    }
  }
  
  public void a()
  {
    h();
    b(this.jdField_a_of_type_Andd);
    b(this.jdField_a_of_type_Amwl);
    b(this.jdField_a_of_type_Beud);
    f();
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Betp = null;
  }
  
  public void a(Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (paramObject == null)) {}
    String str;
    long l;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof betv));
      h();
      paramObject = (betv)paramObject;
      str = paramObject.c();
      l = paramObject.c();
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
    return;
    if (l == 101847770L) {
      bcef.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if ((l == 1101236949L) && (aqgr.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin())))) {
      bcef.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    int i = paramObject.b();
    if (str.startsWith("local"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer == null) {
        break label375;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer instanceof afnt)) {
        ((afnt)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer).c(3);
      }
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      bfaf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, l, str, 0, i);
      return;
      label375:
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
      localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
      localIntent.putExtra("fling_action_key", 2);
      localIntent.putExtra("fling_code_key", hashCode());
      localIntent.putExtra("reportfrom", 3);
      adxr.a(wkp.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
  }
  
  public void b(Object paramObject) {}
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Agwl == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364407);
      this.jdField_a_of_type_Agwl = new agwl(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, localRelativeLayout);
      this.jdField_a_of_type_Agwl.a(4);
      this.jdField_a_of_type_Agwl.c(75);
      this.jdField_a_of_type_Agwl.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Agwl != null)
    {
      this.jdField_a_of_type_Agwl.b();
      this.jdField_a_of_type_Agwl = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Agwl == null) {
      return;
    }
    this.jdField_a_of_type_Agwl.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bevl
 * JD-Core Version:    0.7.0.1
 */