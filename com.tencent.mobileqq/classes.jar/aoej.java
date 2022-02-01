import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class aoej
  implements Comparator<RecentBaseData>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public aoej(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(String paramString1, String paramString2)
  {
    long l1 = Long.parseLong(paramString1);
    long l2 = Long.parseLong(paramString2);
    if (l1 - l2 == 0L) {
      return 0;
    }
    if (l1 - l2 > 0L) {
      return 1;
    }
    return -1;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString, paramInt) > 0);
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      boolean bool1;
      if ((paramRecentBaseData1.mUser.getType() == 1) && (!axbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentBaseData1.mUser)))
      {
        bool1 = localTroopManager.b(paramRecentBaseData1.getRecentUserUin());
        if ((paramRecentBaseData2.mUser.getType() != 1) || (axbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentBaseData2.mUser))) {
          break label147;
        }
      }
      label147:
      for (boolean bool2 = localTroopManager.b(paramRecentBaseData2.getRecentUserUin());; bool2 = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentBaseData2.mUser))
      {
        if ((!bool1) || (bool2)) {
          break label166;
        }
        return -1;
        bool1 = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentBaseData1.mUser);
        break;
      }
      label166:
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if ((!bool1) && (!bool2)) {
        if ((paramRecentBaseData1.mUnreadNum > 0) && (paramRecentBaseData1.mUser.getType() == 0) && (alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramRecentBaseData1.mUser.uin)) && (!a(paramRecentBaseData1.mUser.uin, 0)))
        {
          i = 1;
          if (i == 0) {
            break label606;
          }
        }
      }
    }
    label337:
    label477:
    label606:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.mUnreadNum > 0) && (paramRecentBaseData2.mUser.getType() == 0) && (alxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramRecentBaseData2.mUser.uin)) && (!a(paramRecentBaseData2.mUser.uin, 0)))
      {
        j = 1;
        if (j == 0) {
          break label600;
        }
      }
      for (int j = 4096;; j = 0)
      {
        long l2 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        long l3 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        long l1 = l2;
        if (paramRecentBaseData1.mUser.lastmsgtime <= 0L)
        {
          l1 = l2;
          if (paramRecentBaseData1.mUser.lastmsgdrafttime <= 0L) {
            l1 = Math.max(l2, paramRecentBaseData1.mUser.opTime);
          }
        }
        l2 = l3;
        if (paramRecentBaseData2.mUser.lastmsgtime <= 0L)
        {
          l2 = l3;
          if (paramRecentBaseData2.mUser.lastmsgdrafttime <= 0L) {
            l2 = Math.max(l3, paramRecentBaseData2.mUser.opTime);
          }
        }
        if (l1 > l2) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(0x2 | j);
          if (l1 != 0L) {
            break label587;
          }
          return a(paramRecentBaseData1.mUser.uin, paramRecentBaseData2.mUser.uin);
          i = 0;
          break;
          j = 0;
          break label337;
          l1 = paramRecentBaseData1.mDisplayTime;
          l2 = paramRecentBaseData2.mDisplayTime;
          j = 0;
          i = 0;
          break label477;
          if (l1 < l2) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        if (l1 < 0L) {
          return 1;
        }
        return -1;
        return 0;
      }
    }
  }
  
  public void a(List<RecentUser> paramList)
  {
    RecentUser localRecentUser;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localRecentUser = (RecentUser)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentUser.uin + "|" + localRecentUser.getType() + ",");
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject = null;
    int i;
    if (paramList == null)
    {
      i = 0;
      i -= 1;
      label141:
      if (i < 0) {
        break label560;
      }
      localRecentUser = (RecentUser)paramList.get(i);
      if (localRecentUser != null) {
        break label187;
      }
      paramList.remove(i);
    }
    label187:
    label597:
    label600:
    for (;;)
    {
      i -= 1;
      break label141;
      i = paramList.size();
      break;
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i);
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(i).append(",").append(localRecentUser.getType()).append(";");
        }
      }
      else if ((localRecentUser.getType() == 1) && ((localRecentUser.lFlag & 1L) != 0L))
      {
        if ((localObject != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label597;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      }
      for (;;)
      {
        if ((localObject == null) || (((HotChatManager)localObject).b(localRecentUser.uin))) {
          break label600;
        }
        paramList.remove(i);
        if ((this.jdField_a_of_type_JavaLangStringBuilder == null) || (!QLog.isDevelopLevel())) {
          break label600;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i).append(",").append(localRecentUser.uin).append(";");
        break;
        if (localRecentUser.getType() == 3000)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label557;
          }
          DiscussionInfo localDiscussionInfo = ((ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(localRecentUser.uin);
          if ((localDiscussionInfo == null) || (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()) || (localDiscussionInfo.isHidden()))
          {
            paramList.remove(i);
            if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
              this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i).append(",").append(localRecentUser.uin).append(";");
            }
          }
          break;
        }
        if (localRecentUser.lFlag == 16L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label557;
          }
          nuu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          break;
        }
        if ((localRecentUser.getType() == 10005) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          avfu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
        }
        break;
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("]");
          QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoej
 * JD-Core Version:    0.7.0.1
 */