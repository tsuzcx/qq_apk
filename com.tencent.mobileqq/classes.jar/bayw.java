import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bayw
  implements bayy
{
  bayw(bayv parambayv) {}
  
  public void a(int paramInt, List<bayz> paramList)
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
        bayz localbayz = (bayz)paramList.next();
        if ((localbayz != null) && (localbayz.jdField_a_of_type_Int == 1) && (localbayz.a()))
        {
          if ((localbayz.jdField_a_of_type_JavaLangString != null) && (localbayz.jdField_a_of_type_JavaLangString.length() > 0)) {
            localArrayList.add(localbayz.jdField_a_of_type_JavaLangString);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localbayz.jdField_a_of_type_JavaLangString).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)bayv.a(this.a).a(1);
      if (paramList == null) {
        break;
      }
      paramList.a(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(bayz parambayz)
  {
    if ((parambayz == null) || (!parambayz.a())) {}
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
                QLog.d("FetchBuddyAndTroopNameHelper", 2, bbkk.a(new Object[] { "fetchInfo()", parambayz.toString() }));
              }
              if (parambayz.jdField_a_of_type_Int != 2) {
                break;
              }
              localObject = (akhp)bayv.a(this.a).a(20);
            } while (localObject == null);
            ((akhp)localObject).m(parambayz.jdField_a_of_type_JavaLangString);
            return;
            if (parambayz.jdField_a_of_type_Int != 1) {
              break;
            }
            localObject = (FriendListHandler)bayv.a(this.a).a(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).b(parambayz.jdField_a_of_type_JavaLangString);
          return;
          if (parambayz.jdField_a_of_type_Int != 3) {
            break;
          }
          localObject = (akhp)bayv.a(this.a).a(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(parambayz.jdField_a_of_type_JavaLangString);
        if ((parambayz.jdField_a_of_type_AndroidOsBundle != null) && (parambayz.jdField_a_of_type_AndroidOsBundle.getInt(bbcz.jdField_a_of_type_JavaLangString) == bbcz.b))
        {
          ((akhp)localObject).a(parambayz.b, localArrayList, false, parambayz.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        ((akhp)localObject).a(parambayz.b, (String)parambayz.jdField_a_of_type_JavaLangObject, localArrayList);
        return;
      } while (parambayz.jdField_a_of_type_Int != 4);
      localObject = (FriendListHandler)bayv.a(this.a).a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(parambayz.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayw
 * JD-Core Version:    0.7.0.1
 */