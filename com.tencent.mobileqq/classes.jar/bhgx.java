import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bhgx
  implements bhgz
{
  bhgx(bhgw parambhgw) {}
  
  public void a(int paramInt, List<bhha> paramList)
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
        bhha localbhha = (bhha)paramList.next();
        if ((localbhha != null) && (localbhha.jdField_a_of_type_Int == 1) && (localbhha.a()))
        {
          if ((localbhha.jdField_a_of_type_JavaLangString != null) && (localbhha.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbhha.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbhha.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bhgw.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bhha parambhha)
  {
    if ((parambhha == null) || (!parambhha.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bhsr.a(new Object[] { "fetchInfo()", parambhha.toString() }));
              }
              if (parambhha.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (aoip)bhgw.a(this.a).a(20);
            } while (localObject == null);
            ((aoip)localObject).m(parambhha.jdField_a_of_type_JavaLangString);
            return;
            if (parambhha.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bhgw.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambhha.jdField_a_of_type_JavaLangString);
          return;
          if (parambhha.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (aoip)bhgw.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambhha.jdField_a_of_type_JavaLangString);
        if ((parambhha.jdField_a_of_type_AndroidOsBundle != null) && (parambhha.jdField_a_of_type_AndroidOsBundle.getInt(bhlg.jdField_a_of_type_JavaLangString) == bhlg.b))
        {
          ((aoip)localObject).a(parambhha.b, localArrayList, false, parambhha.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((aoip)localObject).a(parambhha.b, (String)parambhha.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambhha.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bhgw.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambhha.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgx
 * JD-Core Version:    0.7.0.1
 */