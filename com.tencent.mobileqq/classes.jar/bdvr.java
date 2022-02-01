import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public final class bdvr
{
  public String a;
  public ArrayList<Integer> a;
  
  public bdvr()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bdvr a(aqxa[] paramArrayOfaqxa)
  {
    bdvr localbdvr = new bdvr();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfaqxa.length) {
          break label187;
        }
        String str = paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString;
        try
        {
          str = new JSONObject(str).optString("black_ids");
          ArrayList localArrayList = new ArrayList();
          if (!TextUtils.isEmpty(str))
          {
            String[] arrayOfString = str.split(",");
            int k = arrayOfString.length;
            int j = 0;
            while (j < k)
            {
              localArrayList.add(Integer.valueOf(Integer.parseInt(arrayOfString[j].trim())));
              j += 1;
            }
            localbdvr.jdField_a_of_type_JavaLangString = str;
            localbdvr.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.i("StudyModePushConfigProcessor", 2, "[study mode push config], :" + str);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("StudyModePushConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    label187:
    return localbdvr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvr
 * JD-Core Version:    0.7.0.1
 */