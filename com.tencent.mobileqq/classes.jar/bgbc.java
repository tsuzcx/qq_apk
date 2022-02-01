import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgbc
{
  public static boolean a;
  public static boolean b;
  public static int c = 1;
  public int a;
  public ArrayList<Integer> a;
  public int b;
  public ArrayList<Integer> b;
  
  public bgbc()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Boolean = false;
  }
  
  public static bgbc a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool2 = true;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i4 = 0;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    int n = 0;
    if (i4 < paramArrayOfaqxa.length)
    {
      Object localObject = paramArrayOfaqxa[i4].a;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i4 += 1;
        break;
        localArrayList1.clear();
        localArrayList2.clear();
        int i = i2;
        int j = i3;
        int k = i1;
        int m = n;
        try
        {
          localObject = new JSONObject((String)localObject);
          i = i2;
          j = i3;
          k = i1;
          m = n;
          int i5 = ((JSONObject)localObject).optInt("globalOpen", 0);
          i = i2;
          j = i3;
          k = i1;
          m = i5;
          int i6 = ((JSONObject)localObject).optInt("globalOpenStudyMode", 0);
          i = i2;
          j = i3;
          k = i6;
          m = i5;
          int i7 = ((JSONObject)localObject).optInt("groupShortcutBarSwitchWithoutAdmin", 0);
          i = i2;
          j = i7;
          k = i6;
          m = i5;
          int i8 = ((JSONObject)localObject).optInt("groupAppHotRecommendSwitch", 0);
          i = i8;
          j = i7;
          k = i6;
          m = i5;
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("enabledGroupTypes");
          if (localJSONArray != null)
          {
            i = i8;
            j = i7;
            k = i6;
            m = i5;
            if (localJSONArray.length() > 0)
            {
              n = 0;
              for (;;)
              {
                i = i8;
                j = i7;
                k = i6;
                m = i5;
                if (n >= localJSONArray.length()) {
                  break;
                }
                i = i8;
                j = i7;
                k = i6;
                m = i5;
                localArrayList1.add(Integer.valueOf(localJSONArray.getInt(n)));
                n += 1;
              }
            }
          }
          i = i8;
          j = i7;
          k = i6;
          m = i5;
          localObject = ((JSONObject)localObject).optJSONArray("enabledGroupTypesStudyMode");
          i2 = i8;
          i3 = i7;
          i1 = i6;
          n = i5;
          if (localObject != null)
          {
            i2 = i8;
            i3 = i7;
            i1 = i6;
            n = i5;
            i = i8;
            j = i7;
            k = i6;
            m = i5;
            if (((JSONArray)localObject).length() > 0)
            {
              int i9 = 0;
              for (;;)
              {
                i2 = i8;
                i3 = i7;
                i1 = i6;
                n = i5;
                i = i8;
                j = i7;
                k = i6;
                m = i5;
                if (i9 >= ((JSONArray)localObject).length()) {
                  break;
                }
                i = i8;
                j = i7;
                k = i6;
                m = i5;
                localArrayList2.add(Integer.valueOf(((JSONArray)localObject).getInt(i9)));
                i9 += 1;
              }
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i2 = i;
          i3 = j;
          i1 = k;
          n = m;
        }
      }
    }
    paramArrayOfaqxa = new bgbc();
    if (paramArrayOfaqxa != null)
    {
      if (n != 1) {
        break label591;
      }
      bool1 = true;
      jdField_a_of_type_Boolean = bool1;
      if (i1 != 1) {
        break label597;
      }
    }
    label591:
    label597:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      jdField_b_of_type_Boolean = bool1;
      paramArrayOfaqxa.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      paramArrayOfaqxa.jdField_a_of_type_Int = i3;
      paramArrayOfaqxa.jdField_b_of_type_Int = i2;
      paramArrayOfaqxa.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
      if (QLog.isColorLevel()) {
        QLog.d("TroopShortcutBarConfig", 2, "parse:" + paramArrayOfaqxa.toString());
      }
      return paramArrayOfaqxa;
      bool1 = false;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int > 0;
  }
  
  public boolean a(int paramInt)
  {
    return (true == jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean b(int paramInt)
  {
    return (true == jdField_b_of_type_Boolean) || (this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGlobalOpen:").append(jdField_a_of_type_Boolean).append("\r\n");
    localStringBuilder.append("isGlobalStudyModeOpen:").append(jdField_b_of_type_Boolean).append("\r\n");
    localStringBuilder.append("mTroopShortCutBarSwitchList:").append(this.jdField_a_of_type_JavaUtilArrayList).append("\r\n");
    localStringBuilder.append("mStudyModeTroopSwitchList:").append(this.jdField_b_of_type_JavaUtilArrayList).append("\r\n");
    localStringBuilder.append("groupShortcutBarSwitchWithoutAdmin:").append(this.jdField_a_of_type_Int).append("\r\n");
    localStringBuilder.append("groupAppHotRecommendSwitch:").append(this.jdField_b_of_type_Int).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbc
 * JD-Core Version:    0.7.0.1
 */