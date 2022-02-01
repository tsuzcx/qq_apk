import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class areu
  extends QQSysAndEmojiResInfo
  implements arez
{
  private int a;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        i = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QCid);
      }
    }
    return i;
  }
  
  public Drawable a(int paramInt)
  {
    for (;;)
    {
      try
      {
        localURL1 = new URL("qqsys_emoji", "host_emoji", String.format("emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
        localURL2 = localURL1;
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QQEmojiResInfo", 2, "getDrawable url:" + localURL1.toString());
            localURL2 = localURL1;
          }
          return a(localURL2, null, false, String.valueOf(paramInt));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          URL localURL1;
          URL localURL2;
          break label82;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localURL1 = null;
      }
      label82:
      if (QLog.isColorLevel())
      {
        QLog.d("QQEmojiResInfo", 2, "getDrawable ,", localMalformedURLException1);
        localURL2 = localURL1;
      }
    }
  }
  
  public String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        str1 = ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QDes;
      }
    }
    return str1;
  }
  
  public void a()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("emoji");
      if (localJSONArray != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.b == null) {
          this.b = new HashMap();
        }
        if (this.c == null) {
          this.c = new HashMap();
        }
        if (this.d == null) {
          this.d = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label394;
          }
          localObject1 = null;
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              localJSONException.printStackTrace();
            }
          }
          localObject1 = (QQSysAndEmojiResInfo.QQEmoConfigItem)ausy.a((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid);
            int k = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QCid);
            if (!TextUtils.isEmpty(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode))
            {
              localObject2 = "[em]e" + ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode + "[/em]";
              String str = ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QDes;
              this.c.put(str, localObject2);
              this.d.put(localObject2, Integer.valueOf(j));
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject1);
            this.b.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!a((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
            }
            if (j > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = j;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.d("QQEmojiResInfo", 1, new Object[] { "error occur in emoji AQLid:", ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid });
            }
          }
          i += 1;
        }
        label394:
        if (QLog.isColorLevel()) {
          QLog.d("QQEmojiResInfo", 2, new Object[] { "emoji configItem:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), " ,orderlist:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), ", maxLid:", Integer.valueOf(this.jdField_a_of_type_Int), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]" });
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    a(a(paramInt), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bcef.b(null, "dc00898", "", "", "0X800A7A3", "0X800A7A3", a(paramInt1), 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    String str = arev.a(3, String.format("/emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Arey = new arey(this);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */