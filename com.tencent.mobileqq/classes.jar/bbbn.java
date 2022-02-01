import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbbn
  implements View.OnClickListener
{
  public int a;
  public afwe a;
  private anyu jdField_a_of_type_Anyu = new bbbo(this);
  private bbbp jdField_a_of_type_Bbbp;
  public bbbq a;
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public bbbn(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Bbbq = ((anyw)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afwe != null)
    {
      a(this.jdField_a_of_type_Afwe);
      a(1, this.jdField_a_of_type_Afwe.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afwe = null;
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
  
  public void a(afwe paramafwe)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    bbbq localbbbq = this.jdField_a_of_type_Bbbq;
    if ((paramafwe == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramafwe.n = 0;
      return;
    }
    if (localbbbq != null)
    {
      if (((bgty)localTroopMemberListActivity.app.getManager(203)).b(paramafwe.jdField_a_of_type_JavaLangString))
      {
        paramafwe.n = 0;
        return;
      }
      paramafwe.n = localbbbq.a(paramafwe.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramafwe.n = 0;
  }
  
  public void a(afwl paramafwl, afwe paramafwe)
  {
    if (paramafwl == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramafwl.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramafwe == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramafwl.f.setVisibility(0);
        localButton = (Button)paramafwl.f.findViewById(2131362162);
        paramafwl = (TextView)paramafwl.f.findViewById(2131362164);
        if (paramafwe.n != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramafwl.setVisibility(0);
        return;
        if ((paramafwe.n == 3) || (paramafwe.n == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramafwe.n != 3) {
        break;
      }
      localButton.setTag(paramafwe);
      localButton.setOnClickListener(this);
      localButton.setText(anzj.a(2131698750));
      localButton.setVisibility(0);
      paramafwl.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramafwe = "";
    paramafwl = "";
    if (localTroopInfo != null)
    {
      paramafwl = localTroopInfo.troopuin;
      paramafwe = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new bdlq((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramafwl, paramafwe }).a();
    return;
    localButton.setVisibility(8);
    paramafwl.setVisibility(8);
    return;
    label266:
    paramafwl.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Bbbp == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Bbbp.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Bbbp.jdField_a_of_type_Int));
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
    afwe localafwe;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localafwe = (afwe)localIterator1.next();
          if ((localafwe != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localafwe.jdField_a_of_type_JavaLangString))) {
            a(localafwe);
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
          localafwe = (afwe)localIterator2.next();
          if (localafwe != null) {
            a(localafwe);
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
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anyu);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Bbbq = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bbbp == null)
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
      this.jdField_a_of_type_Bbbp = new bbbp((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof afwe)))
    {
      afwe localafwe = (afwe)localObject;
      this.jdField_a_of_type_Afwe = localafwe;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          localObject = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localafwe.jdField_a_of_type_JavaLangString, (String)localObject, 3004, 13, localafwe.m, null, null, null, null));
      localObject = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        localObject = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
      }
      new bdlq(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbn
 * JD-Core Version:    0.7.0.1
 */