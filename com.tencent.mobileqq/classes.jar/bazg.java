import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class bazg
{
  aweq jdField_a_of_type_Aweq;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bazg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("key");
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramBundle);
    if ((paramBundle == null) || (paramBundle.size() == 0)) {
      return localBundle;
    }
    if (this.jdField_a_of_type_Aweq == null) {
      this.jdField_a_of_type_Aweq = ((aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    }
    if (this.jdField_a_of_type_Aweq == null) {
      return localBundle;
    }
    ArrayList localArrayList = new ArrayList(paramBundle.size());
    Iterator localIterator = paramBundle.iterator();
    String str1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = "";
      Object localObject;
      if (str2 == null)
      {
        localObject = null;
        label124:
        paramBundle = str1;
        if (localObject != null)
        {
          paramBundle = str1;
          if (localObject.length != 3) {}
        }
      }
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localObject[0]);
          String str3 = localObject[1];
          int i = Integer.parseInt(localObject[2]);
          paramBundle = str1;
          if (j == 1)
          {
            j = Integer.parseInt(str3);
            localObject = this.jdField_a_of_type_Aweq.a(j);
            paramBundle = str1;
            if (localObject != null)
            {
              if (i != 201) {
                continue;
              }
              paramBundle = ((awbm)localObject).a;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          paramBundle = str1;
          continue;
        }
        atbr.a("getIconUrl", "getIconUrl", new Object[] { str2, paramBundle });
        localArrayList.add(paramBundle);
        break;
        localObject = str2.split("_s_");
        break label124;
        paramBundle = ((awbm)localObject).b;
      }
    }
    localBundle.putStringArrayList("path", localArrayList);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bazg
 * JD-Core Version:    0.7.0.1
 */