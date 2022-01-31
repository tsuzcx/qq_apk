import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class azxe
  implements azxg
{
  azxe(azxd paramazxd) {}
  
  public void a(int paramInt, List<azxh> paramList)
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
        azxh localazxh = (azxh)paramList.next();
        if ((localazxh != null) && (localazxh.jdField_a_of_type_Int == 1) && (localazxh.a()))
        {
          if ((localazxh.jdField_a_of_type_JavaLangString != null) && (localazxh.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localazxh.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localazxh.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)azxd.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(azxh paramazxh)
  {
    if ((paramazxh == null) || (!paramazxh.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, baip.a(new Object[] { "fetchInfo()", paramazxh.toString() }));
              }
              if (paramazxh.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (ajtg)azxd.a(this.a).a(20);
            } while (localObject == null);
            ((ajtg)localObject).m(paramazxh.jdField_a_of_type_JavaLangString);
            return;
            if (paramazxh.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)azxd.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(paramazxh.jdField_a_of_type_JavaLangString);
          return;
          if (paramazxh.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (ajtg)azxd.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramazxh.jdField_a_of_type_JavaLangString);
        if ((paramazxh.jdField_a_of_type_AndroidOsBundle != null) && (paramazxh.jdField_a_of_type_AndroidOsBundle.getInt(babh.jdField_a_of_type_JavaLangString) == babh.b))
        {
          ((ajtg)localObject).a(paramazxh.b, localArrayList, false, paramazxh.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((ajtg)localObject).a(paramazxh.b, (String)paramazxh.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (paramazxh.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)azxd.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramazxh.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azxe
 * JD-Core Version:    0.7.0.1
 */