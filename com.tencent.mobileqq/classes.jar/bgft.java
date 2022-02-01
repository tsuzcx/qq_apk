import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgft
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  private String c = "";
  
  public static bgft a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfig", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    bgft localbgft;
    do
    {
      return paramString;
      localbgft = new bgft();
      try
      {
        Object localObject = new JSONObject(paramString);
        localbgft.a(((JSONObject)localObject).optString("resUrl", ""));
        localbgft.b(((JSONObject)localObject).optString("resMd5", ""));
        localbgft.c = ((JSONObject)localObject).optString("troopCardTipsContent", "");
        localbgft.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("numOfMsgToCheck");
        paramString = new ArrayList();
        localObject = ((JSONObject)localObject).getJSONArray("grayTroopUins");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramString.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
            i += 1;
          }
        }
        localbgft.jdField_a_of_type_JavaUtilList = paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      paramString = localbgft;
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameCardConfig", 2, "resUrl : " + "");
    return localbgft;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfig", 2, "isGrayTroop troopUin = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilList == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("mGrayTroopUinList isNull:  ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label96;
        }
      }
      for (;;)
      {
        QLog.d("TroopGameCardConfig", 2, bool1);
        bool2 = false;
        return bool2;
        label96:
        bool1 = false;
      }
    }
    paramString = paramString.substring(paramString.length() - 1);
    int i = 0;
    label114:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramString)) {}
    }
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopGameCardConfig", 2, "isGrayTroop grayTroopUinList size = " + this.jdField_a_of_type_JavaUtilList.size() + ", isGrayTroop = " + bool1);
      return bool1;
      i += 1;
      break label114;
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgft
 * JD-Core Version:    0.7.0.1
 */