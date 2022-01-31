import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public final class babg
{
  public String a;
  public ArrayList<Integer> a;
  
  public babg()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static babg a(aoko[] paramArrayOfaoko)
  {
    babg localbabg = new babg();
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfaoko.length) {
          break label187;
        }
        String str = paramArrayOfaoko[i].jdField_a_of_type_JavaLangString;
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
            localbabg.jdField_a_of_type_JavaLangString = str;
            localbabg.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
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
    return localbabg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babg
 * JD-Core Version:    0.7.0.1
 */