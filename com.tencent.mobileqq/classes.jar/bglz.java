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

public class bglz
  extends bgkj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public ahzx a;
  private aocj jdField_a_of_type_Aocj;
  private aojs jdField_a_of_type_Aojs;
  private bgkh jdField_a_of_type_Bgkh;
  private bgku jdField_a_of_type_Bgku;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  
  public bglz(BaseChatPie paramBaseChatPie, bgkh parambgkh)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bgkh = parambgkh;
    this.jdField_a_of_type_Long = a();
    g();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_Bgku);
    a(this.jdField_a_of_type_Aocj);
    a(this.jdField_a_of_type_Aojs);
    if (bduy.a()) {}
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
  
  private ArrayList<bgkm> a(ArrayList<bgkn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bgkn localbgkn = (bgkn)paramArrayList.next();
      if ((localbgkn != null) && ((localbgkn instanceof bgkm))) {
        localArrayList.add(localbgkn);
      }
    }
    return localArrayList;
  }
  
  private void a(anui paramanui)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramanui != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramanui);
    }
  }
  
  private void b(anui paramanui)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramanui != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramanui);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bgku = new bgma(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aojs = new bgmb(this);
    this.jdField_a_of_type_Aocj = new bgmc(this);
  }
  
  private void h()
  {
    Object localObject = (bgks)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
    if ((!"".equals(this.jdField_a_of_type_JavaLangString)) && (localObject != null))
    {
      long l = ((bgks)localObject).c(this.jdField_a_of_type_Long);
      if (l > ((bgks)localObject).b(this.jdField_a_of_type_Long)) {
        ((bgks)localObject).a(this.jdField_a_of_type_Long, l);
      }
      localObject = ((bgks)localObject).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = ((bgkr)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bgkn)((Iterator)localObject).next()).a(false);
        }
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    bgko localbgko;
    bgkq localbgkq;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      localbgko = (bgko)aran.a().a(590);
      localbgkq = (bgkq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
    } while ((localbgko == null) || (localTroopInfo == null) || ((!localbgko.a((int)localTroopInfo.dwGroupClassExt)) && (!localbgko.b((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      boolean bool;
      try
      {
        localbgkr = ((bgks)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localbgkr == null) {
          break label356;
        }
        if (!bduy.a()) {
          break label325;
        }
        i = 1;
        if ((localbgkr.a() < System.currentTimeMillis()) || ((bduy.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          localbgkq.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt);
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
        bgkr localbgkr;
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      if (i == 0)
      {
        if (localbgko.jdField_a_of_type_Int == bgko.c)
        {
          bool = true;
          if (((i == 0) && (localbgkr.a() == 0)) || ((i != 0) && (localbgkr.b() == 0)))
          {
            this.jdField_a_of_type_Bgkh.a(0, a(localbgkr.a()), bool);
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
      this.jdField_a_of_type_Bgkh.a(0, null, bool);
      return;
      label356:
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
      }
      localbgkq.a(this.jdField_a_of_type_Long, (int)localException.dwGroupClassExt);
      return;
      label386:
      int i = 1;
    }
  }
  
  public void a()
  {
    h();
    b(this.jdField_a_of_type_Aojs);
    b(this.jdField_a_of_type_Aocj);
    b(this.jdField_a_of_type_Bgku);
    f();
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Bgkh = null;
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
      } while (!(paramObject instanceof bgkn));
      h();
      paramObject = (bgkn)paramObject;
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
      bdll.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if ((l == 1101236949L) && (armu.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
      bdll.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    int i = paramObject.b();
    if (str.startsWith("local"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt == null) {
        break label375;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt instanceof agrz)) {
        ((agrz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Agrt).c(3);
      }
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.c()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      bgqr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, l, str, 0, i);
      return;
      label375:
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
      localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localIntent.putExtra("fling_action_key", 2);
      localIntent.putExtra("fling_code_key", hashCode());
      localIntent.putExtra("reportfrom", 3);
      afez.a(xiz.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
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
    if ((this.jdField_a_of_type_Ahzx == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364389);
      this.jdField_a_of_type_Ahzx = new ahzx(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
      this.jdField_a_of_type_Ahzx.a(4);
      this.jdField_a_of_type_Ahzx.c(75);
      this.jdField_a_of_type_Ahzx.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ahzx != null)
    {
      this.jdField_a_of_type_Ahzx.b();
      this.jdField_a_of_type_Ahzx = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ahzx == null) {
      return;
    }
    this.jdField_a_of_type_Ahzx.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglz
 * JD-Core Version:    0.7.0.1
 */