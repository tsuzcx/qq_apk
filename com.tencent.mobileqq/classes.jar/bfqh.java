import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bfqh
  implements bfqj
{
  bfqh(bfqg parambfqg) {}
  
  public void a(int paramInt, List<bfqk> paramList)
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
        bfqk localbfqk = (bfqk)paramList.next();
        if ((localbfqk != null) && (localbfqk.jdField_a_of_type_Int == 1) && (localbfqk.a()))
        {
          if ((localbfqk.jdField_a_of_type_JavaLangString != null) && (localbfqk.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbfqk.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbfqk.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bfqg.a(this.a).getBusinessHandler(1);
      if (paramList == null) {
        break;
      }
      paramList.getFriendInfoBatch(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bfqk parambfqk)
  {
    if ((parambfqk == null) || (!parambfqk.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, StringUtil.makeLogMsg(new Object[] { "fetchInfo()", parambfqk.toString() }));
              }
              if (parambfqk.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (anca)bfqg.a(this.a).getBusinessHandler(20);
            } while (localObject == null);
            ((anca)localObject).m(parambfqk.jdField_a_of_type_JavaLangString);
            return;
            if (parambfqk.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bfqg.a(this.a).getBusinessHandler(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).getFriendInfo(parambfqk.jdField_a_of_type_JavaLangString);
          return;
          if (parambfqk.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (anca)bfqg.a(this.a).getBusinessHandler(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambfqk.jdField_a_of_type_JavaLangString);
        if ((parambfqk.jdField_a_of_type_AndroidOsBundle != null) && (parambfqk.jdField_a_of_type_AndroidOsBundle.getInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET) == ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG))
        {
          ((anca)localObject).a(parambfqk.b, localArrayList, false, parambfqk.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((anca)localObject).a(parambfqk.b, (String)parambfqk.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambfqk.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bfqg.a(this.a).getBusinessHandler(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).getFriendInfo(parambfqk.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqh
 * JD-Core Version:    0.7.0.1
 */