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

class azpc
  extends anxg
{
  azpc(azpb paramazpb) {}
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((azpb.u(this.a) == null) || (!((azfe)azpb.v(this.a)).b) || (((azfe)azpb.w(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azfe)azpb.x(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while ((!paramString1.equals(((azfe)azpb.y(this.a)).jdField_a_of_type_JavaLangString)) || (!paramString2.equals(((azfe)azpb.z(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ((azfe)azpb.A(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId = paramInt;
    azpb.b(this.a);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("onTroopRankTitleUpdate, troopUin: %s,switchOpen: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((azpb.B(this.a) == null) || (!((azfe)azpb.C(this.a)).b) || (((azfe)azpb.D(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (((azfe)azpb.E(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.equals(((azfe)azpb.F(this.a)).jdField_a_of_type_JavaLangString)) {
      return;
    }
    azpb.b(this.a);
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (azpb.o(this.a) == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(azpb.c(this.a), ((azfe)azpb.p(this.a)).jdField_a_of_type_JavaLangString)) || (!paramBoolean) || (paramLong != Long.parseLong(((azfe)azpb.q(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)));
      ((azfe)azpb.r(this.a)).jdField_a_of_type_Int = paramInt;
    } while ((azpb.s(this.a) == null) || (((azfe)azpb.t(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
    azpb.a(this.a);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (azpb.a(this.a).isFinishing())
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
        if (l != Long.parseLong(((azfe)azpb.a(this.a)).jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + ((azfe)azpb.b(this.a)).jdField_a_of_type_JavaLangString);
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
        else if ((azpb.c(this.a) == null) || (((azfe)azpb.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.allinone == null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(((azfe)azpb.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + ((azfe)azpb.f(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileTroopMemInfoComponent", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            ((azfe)azpb.g(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
            ((azfe)azpb.h(this.a)).c = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(azpb.b(this.a), 1, anni.a(2131703693), 0).a();
              ((azfe)azpb.i(this.a)).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(azpb.a(this.a), ((azfe)azpb.j(this.a)).jdField_a_of_type_JavaLangString))
              {
                ((azfe)azpb.k(this.a)).b = false;
                azpb.a(this.a);
                return;
              }
              ((azfe)azpb.l(this.a)).c = false;
              return;
            }
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)azpb.b(this.a).getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(((azfe)azpb.m(this.a)).jdField_a_of_type_JavaLangString, ((azfe)azpb.n(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
            azpb.a(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpc
 * JD-Core Version:    0.7.0.1
 */