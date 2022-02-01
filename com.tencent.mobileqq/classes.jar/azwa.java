import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azwa
  implements View.OnClickListener
{
  public int a;
  public aeox a;
  private amsu jdField_a_of_type_Amsu = new azwb(this);
  private azwc jdField_a_of_type_Azwc;
  public azwd a;
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public azwa(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Azwd = ((amsw)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Amsu);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aeox != null)
    {
      a(this.jdField_a_of_type_Aeox);
      a(1, this.jdField_a_of_type_Aeox.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aeox = null;
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
  
  public void a(aeox paramaeox)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    azwd localazwd = this.jdField_a_of_type_Azwd;
    if ((paramaeox == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramaeox.n = 0;
      return;
    }
    if (localazwd != null)
    {
      if (((bfdm)localTroopMemberListActivity.app.getManager(203)).b(paramaeox.jdField_a_of_type_JavaLangString))
      {
        paramaeox.n = 0;
        return;
      }
      paramaeox.n = localazwd.a(paramaeox.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramaeox.n = 0;
  }
  
  public void a(aepe paramaepe, aeox paramaeox)
  {
    if (paramaepe == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramaepe.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramaeox == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramaepe.f.setVisibility(0);
        localButton = (Button)paramaepe.f.findViewById(2131362162);
        paramaepe = (TextView)paramaepe.f.findViewById(2131362164);
        if (paramaeox.n != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramaepe.setVisibility(0);
        return;
        if ((paramaeox.n == 3) || (paramaeox.n == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramaeox.n != 3) {
        break;
      }
      localButton.setTag(paramaeox);
      localButton.setOnClickListener(this);
      localButton.setText(amtj.a(2131698985));
      localButton.setVisibility(0);
      paramaepe.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramaeox = "";
    paramaepe = "";
    if (localTroopInfo != null)
    {
      paramaepe = localTroopInfo.troopuin;
      paramaeox = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new bcek((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramaepe, paramaeox }).a();
    return;
    localButton.setVisibility(8);
    paramaepe.setVisibility(8);
    return;
    label266:
    paramaepe.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Azwc == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Azwc.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Azwc.jdField_a_of_type_Int));
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
    aeox localaeox;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localaeox = (aeox)localIterator1.next();
          if ((localaeox != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localaeox.jdField_a_of_type_JavaLangString))) {
            a(localaeox);
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
          localaeox = (aeox)localIterator2.next();
          if (localaeox != null) {
            a(localaeox);
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
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Amsu);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Azwd = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Azwc == null)
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
      this.jdField_a_of_type_Azwc = new azwc((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof aeox)))
    {
      aeox localaeox = (aeox)localObject;
      this.jdField_a_of_type_Aeox = localaeox;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          localObject = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localaeox.jdField_a_of_type_JavaLangString, (String)localObject, 3004, 13, localaeox.m, null, null, null, null));
      localObject = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        localObject = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt);
      }
      new bcek(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwa
 * JD-Core Version:    0.7.0.1
 */