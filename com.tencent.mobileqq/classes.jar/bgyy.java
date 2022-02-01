import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bgyy
  implements bgza
{
  bgyy(bgyx parambgyx) {}
  
  public void a(int paramInt, List<bgzb> paramList)
  {
    if ((paramInt != 1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("fetchInfoBatch size:").append(paramList.size()).append("  [");
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bgzb localbgzb = (bgzb)paramList.next();
        if ((localbgzb != null) && (localbgzb.jdField_a_of_type_Int == 1) && (localbgzb.a()))
        {
          if ((localbgzb.jdField_a_of_type_JavaLangString != null) && (localbgzb.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbgzb.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbgzb.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bgyx.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramList == null) {
        break;
      }
      paramList.getFriendInfoBatch(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bgzb parambgzb)
  {
    if ((parambgzb == null) || (!parambgzb.a())) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("FetchBuddyAndTroopNameHelper", 2, StringUtil.makeLogMsg(new Object[] { "fetchInfo()", parambgzb.toString() }));
              }
              if (parambgzb.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (aoep)bgyx.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            } while (localObject == null);
            ((aoep)localObject).m(parambgzb.jdField_a_of_type_JavaLangString);
            return;
            if (parambgzb.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bgyx.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          } while (localObject == null);
          ((FriendListHandler)localObject).getFriendInfo(parambgzb.jdField_a_of_type_JavaLangString);
          return;
          if (parambgzb.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (aoep)bgyx.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambgzb.jdField_a_of_type_JavaLangString);
        if ((parambgzb.jdField_a_of_type_AndroidOsBundle != null) && (parambgzb.jdField_a_of_type_AndroidOsBundle.getInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET) == ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG))
        {
          ((aoep)localObject).a(parambgzb.b, localArrayList, false, parambgzb.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((aoep)localObject).a(parambgzb.b, (String)parambgzb.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambgzb.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bgyx.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    } while (localObject == null);
    ((FriendListHandler)localObject).getFriendInfo(parambgzb.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyy
 * JD-Core Version:    0.7.0.1
 */