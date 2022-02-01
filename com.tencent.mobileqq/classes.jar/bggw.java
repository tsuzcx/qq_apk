import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bggw
  implements bggy
{
  bggw(bggv parambggv) {}
  
  public void a(int paramInt, List<bggz> paramList)
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
        bggz localbggz = (bggz)paramList.next();
        if ((localbggz != null) && (localbggz.jdField_a_of_type_Int == 1) && (localbggz.a()))
        {
          if ((localbggz.jdField_a_of_type_JavaLangString != null) && (localbggz.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbggz.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbggz.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bggv.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bggz parambggz)
  {
    if ((parambggz == null) || (!parambggz.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bgsp.a(new Object[] { "fetchInfo()", parambggz.toString() }));
              }
              if (parambggz.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (anwd)bggv.a(this.a).a(20);
            } while (localObject == null);
            ((anwd)localObject).m(parambggz.jdField_a_of_type_JavaLangString);
            return;
            if (parambggz.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bggv.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambggz.jdField_a_of_type_JavaLangString);
          return;
          if (parambggz.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (anwd)bggv.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambggz.jdField_a_of_type_JavaLangString);
        if ((parambggz.jdField_a_of_type_AndroidOsBundle != null) && (parambggz.jdField_a_of_type_AndroidOsBundle.getInt(bglf.jdField_a_of_type_JavaLangString) == bglf.b))
        {
          ((anwd)localObject).a(parambggz.b, localArrayList, false, parambggz.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((anwd)localObject).a(parambggz.b, (String)parambggz.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambggz.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bggv.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambggz.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggw
 * JD-Core Version:    0.7.0.1
 */