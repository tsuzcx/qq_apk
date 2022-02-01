import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aory
{
  public int a;
  public long a;
  public String a;
  public ArrayList<aorz> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public aory()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = "https://www.qq.com";
  }
  
  public static aory a(JSONObject paramJSONObject)
  {
    localaory = new aory();
    try
    {
      if (paramJSONObject.has("preDownload")) {
        localaory.jdField_a_of_type_Int = paramJSONObject.optInt("preDownload");
      }
      if (paramJSONObject.has("Video360Restart")) {
        localaory.jdField_b_of_type_Int = paramJSONObject.optInt("Video360Restart");
      }
      int i;
      if (paramJSONObject.has("Video360Repeat"))
      {
        localaory.jdField_c_of_type_Int = paramJSONObject.optInt("Video360Repeat");
        if (localaory.jdField_c_of_type_Int > 0) {
          break label440;
        }
        i = 2147483647;
      }
      for (;;)
      {
        localaory.jdField_c_of_type_Int = i;
        if (paramJSONObject.has("Video360ConnectType")) {
          localaory.jdField_d_of_type_Int = paramJSONObject.optInt("Video360ConnectType");
        }
        Object localObject1;
        if (paramJSONObject.has("TraversingResource"))
        {
          localObject1 = paramJSONObject.optJSONObject("TraversingResource");
          if (((JSONObject)localObject1).has("TraversingResourceSize")) {
            localaory.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("TraversingResourceSize");
          }
          if (((JSONObject)localObject1).has("TraversingResourceUrl")) {
            localaory.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("TraversingResourceUrl");
          }
          if (((JSONObject)localObject1).has("TraversingResourceMD5")) {
            localaory.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("TraversingResourceMD5");
          }
        }
        label440:
        if (paramJSONObject.has("FragmentInfos"))
        {
          paramJSONObject = paramJSONObject.optJSONArray("FragmentInfos");
          int k = paramJSONObject.length();
          i = 0;
          label212:
          if (i < k)
          {
            Object localObject2 = paramJSONObject.getJSONObject(i);
            localObject1 = new aorz();
            if (((JSONObject)localObject2).has("name")) {
              ((aorz)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("name");
            }
            if (((JSONObject)localObject2).has("md5")) {
              ((aorz)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("md5");
            }
            if (((JSONObject)localObject2).has("url")) {
              ((aorz)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("url");
            }
            int j;
            if (((JSONObject)localObject2).has("repeat"))
            {
              ((aorz)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("repeat");
              if (((aorz)localObject1).jdField_a_of_type_Int <= 0)
              {
                j = 2147483647;
                ((aorz)localObject1).jdField_a_of_type_Int = j;
              }
            }
            else
            {
              if (((JSONObject)localObject2).has("triggerType")) {
                ((aorz)localObject1).jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("triggerType");
              }
              if (((JSONObject)localObject2).has("trigger"))
              {
                localObject2 = ((JSONObject)localObject2).getString("trigger").split("\\|");
                if (localObject2 != null)
                {
                  j = localObject2.length;
                  if (j != 2) {}
                }
              }
            }
            try
            {
              ((aorz)localObject1).jdField_c_of_type_Int = Integer.parseInt(localObject2[0]);
              ((aorz)localObject1).jdField_d_of_type_Int = Integer.parseInt(localObject2[1]);
              localaory.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
              i += 1;
              break label212;
              i = localaory.jdField_c_of_type_Int;
              continue;
              j = ((aorz)localObject1).jdField_a_of_type_Int;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                ((aorz)localObject1).jdField_c_of_type_Int = 0;
                ((aorz)localObject1).jdField_d_of_type_Int = 0;
                QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, numberException\n%s", new Object[] { localNumberFormatException }));
              }
            }
          }
        }
      }
      return localaory;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aory
 * JD-Core Version:    0.7.0.1
 */