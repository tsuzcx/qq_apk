import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.3;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.IdolInfo;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.RspBody;

public class bacm
  extends azwo
  implements back, AbsListView.OnScrollListener
{
  protected anrc a;
  protected baci a;
  protected boolean a;
  private boolean b;
  
  public bacm(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_a_of_type_Anrc = new bacn(this);
  }
  
  private ArrayList<bact> a(oidb_0xef6.RspBody paramRspBody)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramRspBody == null) {
      return localArrayList;
    }
    if (paramRspBody.idol_list.has())
    {
      paramRspBody = paramRspBody.idol_list.get();
      int i = 0;
      while (i < paramRspBody.size())
      {
        oidb_0xef6.IdolInfo localIdolInfo = (oidb_0xef6.IdolInfo)paramRspBody.get(i);
        bact localbact = new bact();
        if (localIdolInfo.idol_id.has()) {
          localbact.jdField_a_of_type_Int = localIdolInfo.idol_id.get();
        }
        if (localIdolInfo.avatar.has()) {
          localbact.jdField_b_of_type_JavaLangString = localIdolInfo.avatar.get();
        }
        if (localIdolInfo.pic.has()) {
          localbact.c = localIdolInfo.pic.get();
        }
        if (localIdolInfo.name.has()) {
          localbact.jdField_a_of_type_JavaLangString = localIdolInfo.name.get();
        }
        if (localIdolInfo.rank.has()) {
          localbact.jdField_a_of_type_Long = localIdolInfo.rank.get();
        }
        if (localIdolInfo.score.has()) {
          localbact.jdField_b_of_type_Long = localIdolInfo.score.get();
        }
        localArrayList.add(localbact);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "convSvrRsp idolItems:" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      return;
    }
    paramRecyclerView.addOnItemTouchListener(new baco(this));
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "handleGetIdolInfoOfCard isSuccess:" + paramBoolean + " memberUin:" + paramLong + " errCode:" + paramInt);
    }
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!String.valueOf(paramLong).equals(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof oidb_0xef6.RspBody)));
      paramObject = a((oidb_0xef6.RspBody)paramObject);
    } while (this.jdField_b_of_type_JavaLangObject == null);
    ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bacs = new bacs();
    ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bacs.a = paramObject;
    k();
  }
  
  private boolean b(azrb paramazrb)
  {
    boolean bool2 = true;
    if ((!bghc.a()) || (paramazrb == null) || (paramazrb.jdField_a_of_type_Bacs == null) || (paramazrb.jdField_a_of_type_Bacs.a.size() == 0))
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label352;
      }
      this.jdField_a_of_type_JavaLangObject = null;
    }
    label352:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList remove panel!");
      }
      bool2 = bool1;
      return bool2;
      Object localObject1;
      label106:
      Object localObject2;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        localObject1 = this.jdField_a_of_type_Baea.a(a_());
        if (localObject1 == null)
        {
          this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559624, null);
          localObject1 = (RecyclerView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131368362);
          if (localObject1 != null)
          {
            localObject2 = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, false);
            ((LinearLayoutManager)localObject2).setAutoMeasureEnabled(true);
            ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
            ((RecyclerView)localObject1).addItemDecoration(new bacp(ViewUtils.dpToPx(8.0F)));
            if (this.jdField_a_of_type_Baci == null) {
              this.jdField_a_of_type_Baci = new baci(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazrb.jdField_a_of_type_JavaLangString, this);
            }
            ((RecyclerView)localObject1).setAdapter(this.jdField_a_of_type_Baci);
            a((RecyclerView)localObject1);
            i();
          }
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList show panel!");
          }
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        if (this.jdField_a_of_type_Baci != null) {
          this.jdField_a_of_type_Baci.a(paramazrb.jdField_a_of_type_Bacs.a);
        }
        bool2 = bool1;
        if (this.jdField_a_of_type_JavaLangObject == null) {
          break;
        }
        localObject1 = ((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131365012);
        localObject2 = (TextView)((View)localObject1).findViewById(2131378815);
        ((View)localObject1).findViewById(2131368381);
        ((TextView)localObject2).setText(b(paramazrb));
        ((View)localObject1).setContentDescription(b(paramazrb));
        a(null, (TextView)localObject2, null, null);
        return bool1;
        this.jdField_a_of_type_JavaLangObject = localObject1;
        break label106;
      }
    }
  }
  
  private void j()
  {
    if (!bghc.a()) {}
    while ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) || (this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    try
    {
      ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).b(Long.parseLong(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "notifyUpdateUI");
    }
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.b();
    }
  }
  
  public int a()
  {
    return 1027;
  }
  
  public String a()
  {
    return "ProfileTroopFansInfoComponent";
  }
  
  protected String a(azrb paramazrb)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699028);
    String str1 = str2;
    if (paramazrb != null)
    {
      str1 = str2;
      if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1) {
          break label50;
        }
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699027);
      }
    }
    return str1;
    label50:
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699028);
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1012)) {
      j();
    }
  }
  
  public void a(TextView paramTextView)
  {
    a(paramTextView, null);
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Anrc);
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.a(this);
    }
    j();
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return b((azrb)this.jdField_b_of_type_JavaLangObject) | bool;
  }
  
  public String a_()
  {
    return "map_key_fans_info";
  }
  
  protected String b(azrb paramazrb)
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699031);
    }
    return String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699032), new Object[] { a(paramazrb) });
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      j();
    }
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Anrc);
    }
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.b(this);
    }
    super.f();
  }
  
  protected void i()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null)) {
      ((View)this.jdField_a_of_type_JavaLangObject).post(new ProfileTroopFansInfoComponent.3(this));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacm
 * JD-Core Version:    0.7.0.1
 */