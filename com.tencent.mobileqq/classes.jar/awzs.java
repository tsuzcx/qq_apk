import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideConfigData.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class awzs
{
  public long a;
  public final String a;
  public final ArrayList<Integer> a;
  public boolean a;
  public awzt[] a;
  public String b;
  public boolean b;
  
  public awzs(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAwzt = new awzt[6];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAwzt.length)
    {
      this.jdField_a_of_type_ArrayOfAwzt[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = bhlo.a();
    ThreadManager.post(new CUOpenCardGuideMng.GuideConfigData.1(this), 5, null, false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      a(BaseApplicationImpl.getApplication().getSharedPreferences("ChinaUnicomPhoneCard" + this.jdField_a_of_type_JavaLangString, 4).getString("config_content", ""));
    } while (!QLog.isColorLevel());
    QLog.i("CUOpenCardGuideMng", 2, "init");
  }
  
  public void a(String paramString)
  {
    int j = 0;
    int i = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.i("CUOpenCardGuideMng", 2, "parseConfig config not change");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      this.jdField_b_of_type_Boolean = false;
      while (i < this.jdField_a_of_type_ArrayOfAwzt.length)
      {
        this.jdField_a_of_type_ArrayOfAwzt[i] = null;
        i += 1;
      }
      this.jdField_b_of_type_JavaLangString = "";
    } while (!QLog.isColorLevel());
    QLog.i("CUOpenCardGuideMng", 2, "parseConfig config is empty");
    return;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("isNeedShowGuide")) {
          break label359;
        }
        this.jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("isNeedShowGuide");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      finally {}
      if ((i < this.jdField_a_of_type_ArrayOfAwzt.length) && (i < awzq.a.length))
      {
        if (((JSONObject)localObject).has(awzq.a[i])) {
          this.jdField_a_of_type_ArrayOfAwzt[i] = awzt.a(((JSONObject)localObject).getJSONObject(awzq.a[i]));
        } else {
          this.jdField_a_of_type_ArrayOfAwzt[i] = null;
        }
      }
      else
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder(300);
        ((StringBuilder)localObject).append("parseConfig:").append("\n");
        ((StringBuilder)localObject).append("config: ").append(paramString).append("\n");
        ((StringBuilder)localObject).append("mIsShowGuide: ").append(this.jdField_b_of_type_Boolean).append("\n");
        i = j;
        while ((i < this.jdField_a_of_type_ArrayOfAwzt.length) && (i < awzq.a.length))
        {
          ((StringBuilder)localObject).append(awzq.a[i]).append(": ").append(this.jdField_a_of_type_ArrayOfAwzt[i]).append("\n");
          i += 1;
        }
        QLog.i("CUOpenCardGuideMng", 2, ((StringBuilder)localObject).toString());
        continue;
        label359:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzs
 * JD-Core Version:    0.7.0.1
 */