import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bahs
  extends aojs
{
  bahs(bahr parambahr) {}
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((bahr.u(this.a) == null) || (!((azxr)bahr.v(this.a)).b) || (((azxr)bahr.w(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azxr)bahr.x(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!paramString1.equals(((azxr)bahr.y(this.a)).jdField_a_of_type_JavaLangString)) || (!paramString2.equals(((azxr)bahr.z(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((azxr)bahr.A(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId = paramInt;
    bahr.b(this.a);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((bahr.B(this.a) == null) || (!((azxr)bahr.C(this.a)).b) || (((azxr)bahr.D(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azxr)bahr.E(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.equals(((azxr)bahr.F(this.a)).jdField_a_of_type_JavaLangString)) {
      return;
    }
    bahr.b(this.a);
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (bahr.o(this.a) == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(bahr.c(this.a), ((azxr)bahr.p(this.a)).jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(((azxr)bahr.q(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      ((azxr)bahr.r(this.a)).jdField_a_of_type_Int = paramInt;
    } while ((bahr.s(this.a) == null) || (((azxr)bahr.t(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    bahr.a(this.a);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (bahr.a(this.a).isFinishing())
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
        if (l != Long.parseLong(((azxr)bahr.a(this.a)).jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + ((azxr)bahr.b(this.a)).jdField_a_of_type_JavaLangString);
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
        else if ((bahr.c(this.a) == null) || (((azxr)bahr.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(((azxr)bahr.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + ((azxr)bahr.f(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            ((azxr)bahr.g(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            ((azxr)bahr.h(this.a)).c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(bahr.b(this.a), 1, anzj.a(2131703800), 0).a();
              ((azxr)bahr.i(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(bahr.a(this.a), ((azxr)bahr.j(this.a)).jdField_a_of_type_JavaLangString))
              {
                ((azxr)bahr.k(this.a)).b = false;
                bahr.a(this.a);
                return;
              }
              ((azxr)bahr.l(this.a)).c = false;
              return;
            }
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)bahr.b(this.a).getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(((azxr)bahr.m(this.a)).jdField_a_of_type_JavaLangString, ((azxr)bahr.n(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
            bahr.a(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahs
 * JD-Core Version:    0.7.0.1
 */