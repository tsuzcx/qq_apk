import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class angc
  extends QQSysAndEmojiBaseInfo
{
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {}
    for (int i = Integer.parseInt(((QQSysAndEmojiBaseInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QCid);; i = -1)
    {
      int j = i;
      if (i == -1)
      {
        j = i;
        if (paramInt >= 0)
        {
          j = i;
          if (paramInt < axjs.d.length) {
            j = axjs.d[paramInt];
          }
        }
      }
      return j;
    }
  }
  
  public ArrayList<Integer> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    ArrayList localArrayList = new ArrayList(anhr.b);
    int i = 0;
    while (i < anhr.b)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("emoji");
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
              localObject = (QQSysAndEmojiBaseInfo.QQEmoConfigItem)aqrg.a((JSONObject)localObject, QQSysAndEmojiBaseInfo.QQEmoConfigItem.class);
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
                  QLog.d("QQSysAndEmojiBaseInfo", 1, new Object[] { "error occur in emoji AQLid:", ((QQSysAndEmojiBaseInfo.QQEmoConfigItem)localObject).AQLid });
                }
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "emoji configItem:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), " ,orderlist:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    awqx.b(null, "dc00898", "", "", "0X800A7A3", "0X800A7A3", a(paramInt1), 0, String.valueOf(paramInt2), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angc
 * JD-Core Version:    0.7.0.1
 */