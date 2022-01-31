import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bdbz
  implements bdcb
{
  bdbz(bdby parambdby) {}
  
  public void a(int paramInt, List<bdcc> paramList)
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
        bdcc localbdcc = (bdcc)paramList.next();
        if ((localbdcc != null) && (localbdcc.jdField_a_of_type_Int == 1) && (localbdcc.a()))
        {
          if ((localbdcc.jdField_a_of_type_JavaLangString != null) && (localbdcc.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbdcc.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbdcc.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bdby.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bdcc parambdcc)
  {
    if ((parambdcc == null) || (!parambdcc.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bdnn.a(new Object[] { "fetchInfo()", parambdcc.toString() }));
              }
              if (parambdcc.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (amdu)bdby.a(this.a).a(20);
            } while (localObject == null);
            ((amdu)localObject).m(parambdcc.jdField_a_of_type_JavaLangString);
            return;
            if (parambdcc.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bdby.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambdcc.jdField_a_of_type_JavaLangString);
          return;
          if (parambdcc.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (amdu)bdby.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambdcc.jdField_a_of_type_JavaLangString);
        if ((parambdcc.jdField_a_of_type_AndroidOsBundle != null) && (parambdcc.jdField_a_of_type_AndroidOsBundle.getInt(bdgc.jdField_a_of_type_JavaLangString) == bdgc.b))
        {
          ((amdu)localObject).a(parambdcc.b, localArrayList, false, parambdcc.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((amdu)localObject).a(parambdcc.b, (String)parambdcc.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambdcc.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bdby.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambdcc.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbz
 * JD-Core Version:    0.7.0.1
 */