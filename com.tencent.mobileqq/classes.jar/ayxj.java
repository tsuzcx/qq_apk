import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ayxj
  extends andd
{
  ayxj(ayxi paramayxi) {}
  
  protected void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (ayxi.o(this.a) == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(ayxi.c(this.a), ((aymg)ayxi.p(this.a)).jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(((aymg)ayxi.q(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      ((aymg)ayxi.r(this.a)).jdField_a_of_type_Int = paramInt;
    } while ((ayxi.s(this.a) == null) || (((aymg)ayxi.t(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    ayxi.a(this.a);
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (ayxi.a(this.a).isFinishing())
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
        if (l != Long.parseLong(((aymg)ayxi.a(this.a)).jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + ((aymg)ayxi.b(this.a)).jdField_a_of_type_JavaLangString);
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
        else if ((ayxi.c(this.a) == null) || (((aymg)ayxi.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(((aymg)ayxi.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + ((aymg)ayxi.f(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            ((aymg)ayxi.g(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            ((aymg)ayxi.h(this.a)).c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(ayxi.b(this.a), 1, amtj.a(2131704030), 0).a();
              ((aymg)ayxi.i(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(ayxi.a(this.a), ((aymg)ayxi.j(this.a)).jdField_a_of_type_JavaLangString))
              {
                ((aymg)ayxi.k(this.a)).b = false;
                ayxi.a(this.a);
                return;
              }
              ((aymg)ayxi.l(this.a)).c = false;
              return;
            }
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)ayxi.b(this.a).getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(((aymg)ayxi.m(this.a)).jdField_a_of_type_JavaLangString, ((aymg)ayxi.n(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
            ayxi.a(this.a);
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
    if ((ayxi.B(this.a) == null) || (!((aymg)ayxi.C(this.a)).b) || (((aymg)ayxi.D(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((aymg)ayxi.E(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.equals(((aymg)ayxi.F(this.a)).jdField_a_of_type_JavaLangString)) {
      return;
    }
    ayxi.b(this.a);
  }
  
  protected void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((ayxi.u(this.a) == null) || (!((aymg)ayxi.v(this.a)).b) || (((aymg)ayxi.w(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((aymg)ayxi.x(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!paramString1.equals(((aymg)ayxi.y(this.a)).jdField_a_of_type_JavaLangString)) || (!paramString2.equals(((aymg)ayxi.z(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((aymg)ayxi.A(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId = paramInt;
    ayxi.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxj
 * JD-Core Version:    0.7.0.1
 */