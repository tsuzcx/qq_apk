import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bayi
  implements bayk
{
  bayi(bayh parambayh) {}
  
  public void a(int paramInt, List<bayl> paramList)
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
        bayl localbayl = (bayl)paramList.next();
        if ((localbayl != null) && (localbayl.jdField_a_of_type_Int == 1) && (localbayl.a()))
        {
          if ((localbayl.jdField_a_of_type_JavaLangString != null) && (localbayl.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbayl.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbayl.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bayh.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bayl parambayl)
  {
    if ((parambayl == null) || (!parambayl.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bbjw.a(new Object[] { "fetchInfo()", parambayl.toString() }));
              }
              if (parambayl.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (akhq)bayh.a(this.a).a(20);
            } while (localObject == null);
            ((akhq)localObject).m(parambayl.jdField_a_of_type_JavaLangString);
            return;
            if (parambayl.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bayh.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambayl.jdField_a_of_type_JavaLangString);
          return;
          if (parambayl.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (akhq)bayh.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambayl.jdField_a_of_type_JavaLangString);
        if ((parambayl.jdField_a_of_type_AndroidOsBundle != null) && (parambayl.jdField_a_of_type_AndroidOsBundle.getInt(bbcl.jdField_a_of_type_JavaLangString) == bbcl.b))
        {
          ((akhq)localObject).a(parambayl.b, localArrayList, false, parambayl.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((akhq)localObject).a(parambayl.b, (String)parambayl.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambayl.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bayh.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambayl.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayi
 * JD-Core Version:    0.7.0.1
 */