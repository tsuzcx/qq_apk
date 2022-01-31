import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anwp
  extends QQSysAndEmojiBaseInfo
{
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {}
    for (int i = Integer.parseInt(((QQSysAndEmojiBaseInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QSid);; i = -1)
    {
      int j = i;
      if (i == -1) {
        j = axas.a[paramInt];
      }
      return j;
    }
  }
  
  public ArrayList<Integer> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    int[] arrayOfInt = aocr.a();
    ArrayList localArrayList = new ArrayList(arrayOfInt.length);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localArrayList.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("sysface");
      if (localJSONArray != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        for (;;)
        {
          if (i < localJSONArray.length())
          {
            localObject = null;
            try
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(i);
              localObject = localJSONObject;
              localObject = (QQSysAndEmojiBaseInfo.QQEmoConfigItem)arly.a((JSONObject)localObject, QQSysAndEmojiBaseInfo.QQEmoConfigItem.class);
            }
            catch (JSONException localJSONException)
            {
              try
              {
                int j = Integer.parseInt(((QQSysAndEmojiBaseInfo.QQEmoConfigItem)localObject).AQLid);
                this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
                if (!a((QQSysAndEmojiBaseInfo.QQEmoConfigItem)localObject)) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
                }
                i += 1;
                continue;
                localJSONException = localJSONException;
                localJSONException.printStackTrace();
              }
              catch (NumberFormatException localNumberFormatException)
              {
                for (;;)
                {
                  QLog.d("QQSysAndEmojiBaseInfo", 1, new Object[] { "error occur in sysface AQLid:", ((QQSysAndEmojiBaseInfo.QQEmoConfigItem)localObject).AQLid });
                }
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), " ,orderlist:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1000;
    }
    axqw.b(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwp
 * JD-Core Version:    0.7.0.1
 */