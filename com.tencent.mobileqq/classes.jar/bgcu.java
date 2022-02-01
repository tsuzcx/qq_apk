import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bgcu
  extends bgax
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public ahpl a;
  private anyz jdField_a_of_type_Anyz;
  private aofu jdField_a_of_type_Aofu;
  private bgav jdField_a_of_type_Bgav;
  private bgbj jdField_a_of_type_Bgbj;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  
  public bgcu(BaseChatPie paramBaseChatPie, bgav parambgav)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bgav = parambgav;
    this.jdField_a_of_type_Long = a();
    h();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_Bgbj);
    a(this.jdField_a_of_type_Anyz);
    a(this.jdField_a_of_type_Aofu);
    if (bdvn.a()) {}
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
  
  private ArrayList<bgba> a(ArrayList<bgbb> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bgbb localbgbb = (bgbb)paramArrayList.next();
      if ((localbgbb != null) && ((localbgbb instanceof bgba))) {
        localArrayList.add(localbgbb);
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
  
  private void h()
  {
    this.jdField_a_of_type_Bgbj = new bgcv(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    this.jdField_a_of_type_Aofu = new bgcw(this);
    this.jdField_a_of_type_Anyz = new bgcx(this);
  }
  
  private void i()
  {
    Object localObject = (bgbg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    if ((!"".equals(this.jdField_a_of_type_JavaLangString)) && (localObject != null))
    {
      long l = ((bgbg)localObject).c(this.jdField_a_of_type_Long);
      if (l > ((bgbg)localObject).b(this.jdField_a_of_type_Long)) {
        ((bgbg)localObject).a(this.jdField_a_of_type_Long, l);
      }
      localObject = ((bgbg)localObject).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = ((bgbf)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bgbb)((Iterator)localObject).next()).b(false);
        }
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    bgbc localbgbc;
    bgbe localbgbe;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      localbgbc = (bgbc)aqxe.a().a(590);
      localbgbe = (bgbe)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    } while ((localbgbc == null) || (localTroopInfo == null) || ((!localbgbc.a((int)localTroopInfo.dwGroupClassExt)) && (!localbgbc.b((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      boolean bool;
      try
      {
        localbgbf = ((bgbg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localbgbf == null) {
          break label358;
        }
        if (!bdvn.a()) {
          break label327;
        }
        i = 1;
        if ((localbgbf.a() < System.currentTimeMillis()) || ((bdvn.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          localbgbe.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShow. updateAppShortcutPanel. ");
        }
        if (localTroopInfo.isAdmin()) {
          break label389;
        }
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin())) {
          break label332;
        }
      }
      catch (Exception localException)
      {
        bgbf localbgbf;
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      if (i == 0)
      {
        if (localbgbc.jdField_a_of_type_Int == bgbc.c)
        {
          bool = true;
          if (((i == 0) && (localbgbf.a() == 0)) || ((i != 0) && (localbgbf.b() == 0)))
          {
            this.jdField_a_of_type_Bgav.a(0, a(localbgbf.a()), bool);
            return;
            label327:
            i = 0;
            continue;
            label332:
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
      this.jdField_a_of_type_Bgav.a(0, null, bool);
      return;
      label358:
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
      }
      localbgbe.a(this.jdField_a_of_type_Long, (int)localException.dwGroupClassExt, null);
      return;
      label389:
      int i = 1;
    }
  }
  
  public void a()
  {
    i();
    b(this.jdField_a_of_type_Aofu);
    b(this.jdField_a_of_type_Anyz);
    b(this.jdField_a_of_type_Bgbj);
    g();
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Bgav = null;
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
      } while (!(paramObject instanceof bgbb));
      i();
      paramObject = (bgbb)paramObject;
      str = paramObject.c();
      l = paramObject.b();
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
    return;
    if (l == 101847770L) {
      bdla.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if ((l == 1101236949L) && (arjy.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin())))) {
      bdla.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    int i = paramObject.c();
    if (str.startsWith("local"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer == null) {
        break label376;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer instanceof agex)) {
        ((agex)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mChatDrawer).c(3);
      }
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      bgil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, l, str, 0, i);
      return;
      label376:
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
      localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
      localIntent.putExtra("fling_action_key", 2);
      localIntent.putExtra("fling_code_key", hashCode());
      localIntent.putExtra("reportfrom", 3);
      aeow.a(wzk.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Ahpl == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131364488);
      this.jdField_a_of_type_Ahpl = new ahpl(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo, localRelativeLayout);
      this.jdField_a_of_type_Ahpl.a(4);
      this.jdField_a_of_type_Ahpl.c(75);
      this.jdField_a_of_type_Ahpl.a();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ahpl != null)
    {
      this.jdField_a_of_type_Ahpl.b();
      this.jdField_a_of_type_Ahpl = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Ahpl == null) {
      return;
    }
    this.jdField_a_of_type_Ahpl.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcu
 * JD-Core Version:    0.7.0.1
 */