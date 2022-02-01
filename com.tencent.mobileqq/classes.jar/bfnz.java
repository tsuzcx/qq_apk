import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bfnz
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "RelationFriendsSearchHelper";
  
  public bfnz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ArrayList<Entity> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "uin empty");
      return null;
    }
    Object localObject2 = (apbd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2);
    Object localObject1 = ((apbd)localObject2).a(paramString);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "Search ftsEntities empty");
      return null;
    }
    Object localObject3 = new HashMap();
    long l2 = NetConnInfoCenter.getServerTime();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = 0;
    long l1 = 0L;
    int i = 0;
    long l3;
    if (j < ((List)localObject1).size())
    {
      localObject5 = (TroopIndex)((List)localObject1).get(j);
      if (!((HashMap)localObject3).containsKey(((TroopIndex)localObject5).mTroopUin))
      {
        localObject6 = (RecentUser)((apaw)localObject4).findRecentUserByUin(((TroopIndex)localObject5).mTroopUin, 1);
        if ((localObject6 != null) && (((RecentUser)localObject6).lastmsgtime > 0L))
        {
          l3 = 100L + l2 - ((RecentUser)localObject6).lastmsgtime;
          if (l3 < 0L) {}
          ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(l3));
          i += 1;
          l1 += l3;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(0L));
      }
    }
    long l4 = System.currentTimeMillis();
    localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject5 = new HashMap();
    float f3 = 1.0F / ((HashMap)localObject3).size();
    Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Iterator localIterator = ((HashMap)localObject3).keySet().iterator();
    l2 = 0L;
    Object localObject7;
    float f1;
    if (localIterator.hasNext())
    {
      localObject7 = (String)localIterator.next();
      float f2 = 0.0F;
      l3 = ((Long)((HashMap)localObject3).get(localObject7)).longValue();
      f1 = f2;
      if (l3 > 0L)
      {
        f1 = f2;
        if (l1 > 0L)
        {
          f1 = (0.0F + (float)l3) / (float)l1;
          if ((f1 > 1.0F) || (i <= 0)) {
            break label1121;
          }
          if (i != 1) {
            break label502;
          }
          f1 = 1.0F;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsSearchHelper", 2, "troopUin:" + (String)localObject7 + ",delta:" + l3 + "troopActiveFator_delta:" + f1);
      }
      l3 = System.currentTimeMillis();
      localObject7 = ((apbd)localObject2).b((String)localObject7);
      l3 = l2 + (System.currentTimeMillis() - l3);
      if ((localObject7 == null) || (((List)localObject7).size() == 0))
      {
        QLog.e("RelationFriendsSearchHelper", 1, "Search ftsMembers empty");
        l2 = l3;
        break;
        label502:
        f1 = (1.0F - f1) / (i - 1);
        continue;
      }
      j = 0;
      l2 = l3;
      if (j >= ((List)localObject7).size()) {
        break;
      }
      Object localObject8 = (TroopIndex)((List)localObject7).get(j);
      if ((((anyw)localObject1).b(((TroopIndex)localObject8).mMemberUin)) && (!((String)localObject6).equals(((TroopIndex)localObject8).mMemberUin)) && (!paramString.equals(((TroopIndex)localObject8).mMemberUin)))
      {
        if (((HashMap)localObject5).containsKey(((TroopIndex)localObject8).mMemberUin)) {
          break label676;
        }
        bfoc localbfoc = new bfoc(this, f3);
        localbfoc.b = f1;
        localbfoc.jdField_a_of_type_Int = 1;
        RecentUser localRecentUser = (RecentUser)((apaw)localObject4).findRecentUserByUin(((TroopIndex)localObject8).mMemberUin, 0);
        if (localRecentUser != null) {
          localbfoc.jdField_a_of_type_Long = localRecentUser.lastmsgtime;
        }
        ((HashMap)localObject5).put(((TroopIndex)localObject8).mMemberUin, localbfoc);
      }
      for (;;)
      {
        j += 1;
        break;
        label676:
        localObject8 = (bfoc)((HashMap)localObject5).get(((TroopIndex)localObject8).mMemberUin);
        ((bfoc)localObject8).jdField_a_of_type_Int += 1;
        ((bfoc)localObject8).b += f1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsSearchHelper", 2, "timecost:" + (System.currentTimeMillis() - l4) + "querycostmember:" + l2 + ",troopsSize:" + ((HashMap)localObject3).size() + "Members:" + ((HashMap)localObject5).size());
      }
      paramString = new ArrayList(((HashMap)localObject5).entrySet());
      Collections.sort(paramString, new bfoa(this));
      i = paramString.size();
      if ((i > 1) && (((bfoc)((Map.Entry)paramString.get(i - 1)).getValue()).a() == ((bfoc)((Map.Entry)paramString.get(0)).getValue()).a())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RelationFriendsSearchHelper", 2, "isAllMemberScoreEqual");
          }
          Collections.sort(paramString, new bfob(this));
        }
        localObject2 = new ArrayList();
        i = 0;
        if (i < paramString.size())
        {
          localObject3 = (bfoc)((Map.Entry)paramString.get(i)).getValue();
          localObject4 = ((anyw)localObject1).b((String)((Map.Entry)paramString.get(i)).getKey());
          if (localObject4 != null)
          {
            ((ArrayList)localObject2).add(localObject4);
            if ((i < 20) && (QLog.isColorLevel())) {
              QLog.i("RelationFriendsSearchHelper", 2, "top20:uin" + bhsr.e(((Friends)localObject4).uin) + ",scores:" + ((bfoc)localObject3).a() + ",frequency:" + ((bfoc)localObject3).jdField_a_of_type_Int + ",activefactor:" + ((bfoc)localObject3).b + ",c2clastmsgtime:" + ((bfoc)localObject3).jdField_a_of_type_Long);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.i("RelationFriendsSearchHelper", 2, "friends null");
            }
          }
        }
        return localObject2;
      }
      label1121:
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnz
 * JD-Core Version:    0.7.0.1
 */