import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class baad
{
  private static final String a;
  protected int a;
  protected long a;
  protected azyh a;
  protected List<ParagraphInfo> a;
  protected JSONArray a;
  protected JSONObject a;
  
  static
  {
    jdField_a_of_type_JavaLangString = baad.class.getSimpleName();
  }
  
  public baad(List<ParagraphInfo> paramList, azyh paramazyh, String paramString)
  {
    this.jdField_a_of_type_Azyh = paramazyh;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramList.toString());
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_OrgJsonJSONArray == null)) {
      return null;
    }
    return this.jdField_a_of_type_OrgJsonJSONArray.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    for (;;)
    {
      if (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        int j;
        try
        {
          JSONObject localJSONObject = (JSONObject)this.jdField_a_of_type_OrgJsonJSONArray.get(i);
          j = localJSONObject.optInt("p");
          int k = localJSONObject.optInt("w");
          if ((j < 0) || (j >= this.jdField_a_of_type_JavaUtilList.size())) {
            break label224;
          }
          Object localObject = ((ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(j)).generateOrGetWordInfoList(j);
          if ((k >= 0) && (k < ((List)localObject).size()))
          {
            localObject = (WordInfo)((List)localObject).get(k);
            ((WordInfo)localObject).setColor(localJSONObject.optInt("s"));
            if (this.jdField_a_of_type_Azyh != null) {
              this.jdField_a_of_type_Azyh.a((WordInfo)localObject);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "w error:" + k);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label270;
          }
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "JSONException:" + localJSONException.toString());
        break label270;
        label224:
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "p error:" + j);
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_OrgJsonJSONObject = null;
        return;
      }
      label270:
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_OrgJsonJSONArray == null)) {}
    for (;;)
    {
      return;
      float f;
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        f = paramInt / 1000.0F;
      }
      try
      {
        if (this.jdField_a_of_type_OrgJsonJSONObject != null)
        {
          long l = this.jdField_a_of_type_OrgJsonJSONObject.getLong("t");
          if (f <= (float)l) {
            continue;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, localJSONException1.toString());
            continue;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "w error:" + j);
            }
          }
        }
      }
      paramInt = this.jdField_a_of_type_Int;
      while (paramInt < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        for (;;)
        {
          try
          {
            localJSONObject = (JSONObject)this.jdField_a_of_type_OrgJsonJSONArray.get(paramInt);
            localObject = localJSONObject.optString("t");
          }
          catch (JSONException localJSONException2)
          {
            JSONObject localJSONObject;
            Object localObject;
            int i;
            int j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "JSONException:" + localJSONException2.toString());
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "p error:" + i);
            continue;
            this.jdField_a_of_type_OrgJsonJSONObject = localJSONException2;
          }
          try
          {
            if (f <= Float.valueOf((String)localObject).floatValue()) {
              continue;
            }
            i = localJSONObject.optInt("p");
            j = localJSONObject.optInt("w");
            if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
              continue;
            }
            localObject = ((ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(i)).generateOrGetWordInfoList(i);
            if ((j < 0) || (j >= ((List)localObject).size())) {
              continue;
            }
            localObject = (WordInfo)((List)localObject).get(j);
            ((WordInfo)localObject).setColor(localJSONObject.optInt("s"));
            if (this.jdField_a_of_type_Azyh != null) {
              this.jdField_a_of_type_Azyh.a((WordInfo)localObject);
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "NumberFormatException:" + localNumberFormatException.toString());
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("p", paramInt1);
      localJSONObject.put("s", paramInt3);
      localJSONObject.put("t", f);
      localJSONObject.put("w", paramInt2);
      this.jdField_a_of_type_OrgJsonJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addWordResult:" + localJSONException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baad
 * JD-Core Version:    0.7.0.1
 */