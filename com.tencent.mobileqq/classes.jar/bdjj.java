import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bdjj
{
  int jdField_a_of_type_Int = 0;
  HashMap<String, bdjm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  int b = 40;
  int c = 9;
  int d = 9;
  int e = 20;
  
  static bdjj a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        bdjj localbdjj = new bdjj();
        localbdjj.jdField_a_of_type_Int = paramString.optInt("task_id");
        if (paramString.has("max_gaudio_member")) {
          localbdjj.b = paramString.optInt("max_gaudio_member");
        }
        if (paramString.has("max_select_num")) {
          localbdjj.c = paramString.optInt("max_select_num");
        }
        if (paramString.has("show_invite_box")) {
          localbdjj.e = paramString.optInt("show_invite_box");
        }
        if (paramString.has("auto_select_num")) {
          localbdjj.d = paramString.optInt("auto_select_num");
        }
        return localbdjj;
      }
      catch (Exception paramString)
      {
        QLog.d("QAVGroupConfig", 1, "parseJson, Exception", paramString);
      }
    }
    return new bdjj();
  }
  
  public bdjm a(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (bdjm)((Map.Entry)localObject2).getValue();
      if (l > ((bdjm)localObject2).jdField_a_of_type_Long) {
        localIterator.remove();
      }
      for (localObject2 = localObject1;; localObject2 = localObject1) {
        do
        {
          localObject1 = localObject2;
          break;
        } while ((localObject1 == null) && (TextUtils.equals(paramString, str)));
      }
    }
    return localObject1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    long l = 600000L;
    if (AudioHelper.d()) {
      l = 60000L;
    }
    bdjm localbdjm = new bdjm();
    localbdjm.jdField_a_of_type_Long = (l + System.currentTimeMillis());
    localbdjm.jdField_a_of_type_JavaLangString = paramString2;
    localbdjm.b = paramString3;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localbdjm);
  }
  
  public String toString()
  {
    return "task_id[" + this.jdField_a_of_type_Int + "], max_gaudio_member[" + this.b + "], max_select_num[" + this.c + "], show_invite_box[" + this.e + "], auto_select_num[" + this.d + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjj
 * JD-Core Version:    0.7.0.1
 */