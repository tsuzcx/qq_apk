import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bacg
  extends aofu
{
  bacg(bacf parambacf) {}
  
  protected void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (bacf.o(this.a) == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(bacf.c(this.a), ((azrb)bacf.p(this.a)).jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(((azrb)bacf.q(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      ((azrb)bacf.r(this.a)).jdField_a_of_type_Int = paramInt;
    } while ((bacf.s(this.a) == null) || (((azrb)bacf.t(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    bacf.a(this.a);
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (bacf.a(this.a).isFinishing())
      {
        QLog.d("ProfileTroopMemInfoComponent", 1, "onGetTroopMemberCard return because is finished!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(((azrb)bacf.a(this.a)).jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + ((azrb)bacf.b(this.a)).jdField_a_of_type_JavaLangString);
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo==null");
          }
        }
        else if ((bacf.c(this.a) == null) || (((azrb)bacf.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(((azrb)bacf.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + ((azrb)bacf.f(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            ((azrb)bacf.g(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            ((azrb)bacf.h(this.a)).c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(bacf.b(this.a), 1, anvx.a(2131704381), 0).a();
              ((azrb)bacf.i(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(bacf.a(this.a), ((azrb)bacf.j(this.a)).jdField_a_of_type_JavaLangString))
              {
                ((azrb)bacf.k(this.a)).b = false;
                bacf.a(this.a);
                return;
              }
              ((azrb)bacf.l(this.a)).c = false;
              return;
            }
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)bacf.b(this.a).getManager(QQManagerFactory.TROOP_MANAGER);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(((azrb)bacf.m(this.a)).jdField_a_of_type_JavaLangString, ((azrb)bacf.n(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
                if (localObject != null)
                {
                  paramObject.titleId = ((TroopMemberInfo)localObject).level;
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                  }
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: updateCardInfo");
            }
            bacf.a(this.a);
          }
        }
      }
    }
  }
  
  protected void onTroopRankSwitchUpdate(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((bacf.B(this.a) == null) || (!((azrb)bacf.C(this.a)).b) || (((azrb)bacf.D(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azrb)bacf.E(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.equals(((azrb)bacf.F(this.a)).jdField_a_of_type_JavaLangString)) {
      return;
    }
    bacf.b(this.a);
  }
  
  protected void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((bacf.u(this.a) == null) || (!((azrb)bacf.v(this.a)).b) || (((azrb)bacf.w(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azrb)bacf.x(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!paramString1.equals(((azrb)bacf.y(this.a)).jdField_a_of_type_JavaLangString)) || (!paramString2.equals(((azrb)bacf.z(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((azrb)bacf.A(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId = paramInt;
    bacf.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacg
 * JD-Core Version:    0.7.0.1
 */