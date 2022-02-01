import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bfly
  extends bfki
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public ahqj a;
  private anqd jdField_a_of_type_Anqd;
  private anxg jdField_a_of_type_Anxg;
  private bfkg jdField_a_of_type_Bfkg;
  private bfkt jdField_a_of_type_Bfkt;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  
  public bfly(BaseChatPie paramBaseChatPie, bfkg parambfkg)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bfkg = parambfkg;
    this.jdField_a_of_type_Long = a();
    g();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_Bfkt);
    a(this.jdField_a_of_type_Anqd);
    a(this.jdField_a_of_type_Anxg);
    if (bdch.a()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    do
    {
      do
      {
        return 0L;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null));
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  private ArrayList<bfkl> a(ArrayList<bfkm> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bfkm localbfkm = (bfkm)paramArrayList.next();
      if ((localbfkm != null) && ((localbfkm instanceof bfkl))) {
        localArrayList.add(localbfkm);
      }
    }
    return localArrayList;
  }
  
  private void a(anil paramanil)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramanil != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramanil);
    }
  }
  
  private void b(anil paramanil)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramanil != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramanil);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bfkt = new bflz(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Anxg = new bfma(this);
    this.jdField_a_of_type_Anqd = new bfmb(this);
  }
  
  private void h()
  {
    Object localObject = (bfkr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
    if ((!"".equals(this.jdField_a_of_type_JavaLangString)) && (localObject != null))
    {
      long l = ((bfkr)localObject).c(this.jdField_a_of_type_Long);
      if (l > ((bfkr)localObject).b(this.jdField_a_of_type_Long)) {
        ((bfkr)localObject).a(this.jdField_a_of_type_Long, l);
      }
      localObject = ((bfkr)localObject).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = ((bfkq)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bfkm)((Iterator)localObject).next()).a(false);
        }
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    bfkn localbfkn;
    bfkp localbfkp;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      localbfkn = (bfkn)aqlk.a().a(590);
      localbfkp = (bfkp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
    } while ((localbfkn == null) || (localTroopInfo == null) || ((!localbfkn.a((int)localTroopInfo.dwGroupClassExt)) && (!localbfkn.b((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      boolean bool;
      try
      {
        localbfkq = ((bfkr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localbfkq == null) {
          break label356;
        }
        if (!bdch.a()) {
          break label325;
        }
        i = 1;
        if ((localbfkq.a() < System.currentTimeMillis()) || ((bdch.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          localbfkp.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShow. updateAppShortcutPanel. ");
        }
        if (localTroopInfo.isAdmin()) {
          break label386;
        }
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label330;
        }
      }
      catch (Exception localException)
      {
        bfkq localbfkq;
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      if (i == 0)
      {
        if (localbfkn.jdField_a_of_type_Int == bfkn.c)
        {
          bool = true;
          if (((i == 0) && (localbfkq.a() == 0)) || ((i != 0) && (localbfkq.b() == 0)))
          {
            this.jdField_a_of_type_Bfkg.a(0, a(localbfkq.a()), bool);
            return;
            label325:
            i = 0;
            continue;
            label330:
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
      this.jdField_a_of_type_Bfkg.a(0, null, bool);
      return;
      label356:
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
      }
      localbfkp.a(this.jdField_a_of_type_Long, (int)localException.dwGroupClassExt);
      return;
      label386:
      int i = 1;
    }
  }
  
  public void a()
  {
    h();
    b(this.jdField_a_of_type_Anxg);
    b(this.jdField_a_of_type_Anqd);
    b(this.jdField_a_of_type_Bfkt);
    f();
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Bfkg = null;
  }
  
  public void a(Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (paramObject == null)) {}
    String str;
    long l;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bfkm));
      h();
      paramObject = (bfkm)paramObject;
      str = paramObject.c();
      l = paramObject.c();
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
    return;
    if (l == 101847770L) {
      bcst.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if ((l == 1101236949L) && (aqxg.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
      bcst.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    int i = paramObject.b();
    if (i != 0) {
      bftr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo.troopuin, (int)l);
    }
    if (str.startsWith("local"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agis == null) {
        break label396;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agis.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agis.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agis instanceof agiy)) {
        ((agiy)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agis).c(3);
      }
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      bfqq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, l, str, 0, i);
      return;
      label396:
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
      localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localIntent.putExtra("fling_action_key", 2);
      localIntent.putExtra("fling_code_key", hashCode());
      localIntent.putExtra("reportfrom", 3);
      aevv.a(xfe.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
  }
  
  public void b(Object paramObject) {}
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Ahqj == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364345);
      this.jdField_a_of_type_Ahqj = new ahqj(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
      this.jdField_a_of_type_Ahqj.a(4);
      this.jdField_a_of_type_Ahqj.c(75);
      this.jdField_a_of_type_Ahqj.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ahqj != null)
    {
      this.jdField_a_of_type_Ahqj.b();
      this.jdField_a_of_type_Ahqj = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ahqj == null) {
      return;
    }
    this.jdField_a_of_type_Ahqj.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfly
 * JD-Core Version:    0.7.0.1
 */