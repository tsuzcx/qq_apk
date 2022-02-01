import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbcg
  implements View.OnClickListener
{
  public int a;
  public afgi a;
  private anvi jdField_a_of_type_Anvi = new bbch(this);
  private bbci jdField_a_of_type_Bbci;
  public bbcj a;
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public bbcg(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Bbcj = ((anvk)paramTroopMemberListActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afgi != null)
    {
      a(this.jdField_a_of_type_Afgi);
      a(1, this.jdField_a_of_type_Afgi.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afgi = null;
      return;
      b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b();
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramString == null) || (!paramString.isResume()));
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void a(afgi paramafgi)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    bbcj localbbcj = this.jdField_a_of_type_Bbcj;
    if ((paramafgi == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramafgi.n = 0;
      return;
    }
    if (localbbcj != null)
    {
      if (((bgls)localTroopMemberListActivity.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramafgi.jdField_a_of_type_JavaLangString))
      {
        paramafgi.n = 0;
        return;
      }
      paramafgi.n = localbbcj.a(paramafgi.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramafgi.n = 0;
  }
  
  public void a(afgp paramafgp, afgi paramafgi)
  {
    if (paramafgp == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramafgp.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramafgi == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramafgp.f.setVisibility(0);
        localButton = (Button)paramafgp.f.findViewById(2131362166);
        paramafgp = (TextView)paramafgp.f.findViewById(2131362168);
        if (paramafgi.n != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramafgp.setVisibility(0);
        return;
        if ((paramafgi.n == 3) || (paramafgi.n == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramafgi.n != 3) {
        break;
      }
      localButton.setTag(paramafgi);
      localButton.setOnClickListener(this);
      localButton.setText(anvx.a(2131699336));
      localButton.setVisibility(0);
      paramafgp.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramafgi = "";
    paramafgp = "";
    if (localTroopInfo != null)
    {
      paramafgp = localTroopInfo.troopuin;
      paramafgi = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new bdlf((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramafgp, paramafgi }).a();
    return;
    localButton.setVisibility(8);
    paramafgp.setVisibility(8);
    return;
    label266:
    paramafgp.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Bbci == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Bbci.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Bbci.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((localTroopMemberListActivity == null) || (localTroopMemberListActivity.isFinishing()) || (!localTroopMemberListActivity.isResume())) {
      if (QLog.isColorLevel()) {
        QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
      }
    }
    do
    {
      return;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
    return;
    afgi localafgi;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localafgi = (afgi)localIterator1.next();
          if ((localafgi != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localafgi.jdField_a_of_type_JavaLangString))) {
            a(localafgi);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localTroopMemberListActivity.o();
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_Int != 2) {
        continue;
      }
      try
      {
        Iterator localIterator2 = localThrowable1.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localafgi = (afgi)localIterator2.next();
          if (localafgi != null) {
            a(localafgi);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        localThrowable1.o();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anvi);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Bbcj = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bbci == null)
    {
      TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localTroopMemberListActivity != null)
      {
        localObject1 = localObject2;
        if (localTroopMemberListActivity.app != null) {
          localObject1 = localTroopMemberListActivity.app.getCurrentAccountUin();
        }
      }
      this.jdField_a_of_type_Bbci = new bbci((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof afgi)))
    {
      afgi localafgi = (afgi)localObject;
      this.jdField_a_of_type_Afgi = localafgi;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          localObject = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localafgi.jdField_a_of_type_JavaLangString, (String)localObject, 3004, 13, localafgi.m, null, null, null, null));
      localObject = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        localObject = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt);
      }
      new bdlf(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcg
 * JD-Core Version:    0.7.0.1
 */