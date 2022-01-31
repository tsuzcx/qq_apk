import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public final class azwx
{
  public String a;
  public ArrayList<Integer> a;
  
  public azwx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static azwx a(aogf[] paramArrayOfaogf)
  {
    azwx localazwx = new azwx();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfaogf.length) {
          break label187;
        }
        String str = paramArrayOfaogf[i].jdField_a_of_type_JavaLangString;
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
            localazwx.jdField_a_of_type_JavaLangString = str;
            localazwx.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
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
    return localazwx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwx
 * JD-Core Version:    0.7.0.1
 */