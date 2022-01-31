import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bcxq
  implements bcxs
{
  bcxq(bcxp parambcxp) {}
  
  public void a(int paramInt, List<bcxt> paramList)
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
        bcxt localbcxt = (bcxt)paramList.next();
        if ((localbcxt != null) && (localbcxt.jdField_a_of_type_Int == 1) && (localbcxt.a()))
        {
          if ((localbcxt.jdField_a_of_type_JavaLangString != null) && (localbcxt.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbcxt.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbcxt.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bcxp.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bcxt parambcxt)
  {
    if ((parambcxt == null) || (!parambcxt.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bdje.a(new Object[] { "fetchInfo()", parambcxt.toString() }));
              }
              if (parambcxt.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (alzf)bcxp.a(this.a).a(20);
            } while (localObject == null);
            ((alzf)localObject).m(parambcxt.jdField_a_of_type_JavaLangString);
            return;
            if (parambcxt.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bcxp.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambcxt.jdField_a_of_type_JavaLangString);
          return;
          if (parambcxt.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (alzf)bcxp.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambcxt.jdField_a_of_type_JavaLangString);
        if ((parambcxt.jdField_a_of_type_AndroidOsBundle != null) && (parambcxt.jdField_a_of_type_AndroidOsBundle.getInt(bdbt.jdField_a_of_type_JavaLangString) == bdbt.b))
        {
          ((alzf)localObject).a(parambcxt.b, localArrayList, false, parambcxt.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((alzf)localObject).a(parambcxt.b, (String)parambcxt.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambcxt.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bcxp.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambcxt.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxq
 * JD-Core Version:    0.7.0.1
 */