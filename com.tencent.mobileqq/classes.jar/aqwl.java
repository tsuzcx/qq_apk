import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.5;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.6;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.7;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwl
  implements aqlb<String>, aqvm
{
  private int jdField_a_of_type_Int = 5;
  private long jdField_a_of_type_Long;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 30;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 10;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int f;
  
  public aqwl()
  {
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  public aqvn a()
  {
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("url")) {
      return new aqwm(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("mqqapi")) {
      return new aqwn(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("system")) {
      return new aqwo(this);
    }
    if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("custom")) {
      return new aqwp(this);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.5(this));
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "receiveAllConfigs|type: 606configContent is empty");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("local_day_times")) {
        this.jdField_d_of_type_Int = paramString.getInt("local_day_times");
      }
      if (paramString.has("local_day_last_time"))
      {
        this.jdField_a_of_type_Long = paramString.getLong("local_day_last_time");
        long l = bbyp.a();
        if (!atvo.a(this.jdField_a_of_type_Long * 1000L, l * 1000L, TimeZone.getDefault()))
        {
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "is not one day, set mLocalDayTims:0");
          this.jdField_d_of_type_Int = 0;
        }
      }
      if (paramString.has("local_max_times")) {
        this.jdField_e_of_type_Int = paramString.getInt("local_max_times");
      }
      this.jdField_b_of_type_Int = paramString.getInt("max_count");
      if (this.jdField_e_of_type_Int >= this.jdField_b_of_type_Int)
      {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.jdField_e_of_type_Int + " >= mMaxTimes:" + this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (paramString.has("local_click_times")) {
      this.f = paramString.getInt("local_click_times");
    }
    if (this.f >= this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.f + " >= mMaxClickTimes:" + this.jdField_c_of_type_Int);
      return;
    }
    if (paramString.getInt("switch") == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = paramString.getString("txt_content");
      this.jdField_c_of_type_JavaLangString = paramString.getString("jump_txt");
      this.jdField_a_of_type_Int = paramString.getInt("one_day_max");
      if (this.jdField_d_of_type_Int >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.jdField_d_of_type_Int + " >= mOneDayMaxTimes:" + this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_c_of_type_Int = paramString.getInt("click_max");
      this.jdField_d_of_type_JavaLangString = paramString.getString("jump_type");
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("url"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("url")).getString("url");
        return;
      }
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("mqqapi"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("mqqapi")).getString("url");
        return;
      }
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("custom"))
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("custom")).toString();
        return;
      }
      if (!this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("system")) {
        break;
      }
      this.jdField_e_of_type_JavaLangString = new JSONObject(paramString.getString("system")).getString("url");
      return;
      bool = false;
    }
  }
  
  public boolean a()
  {
    if (this.f >= this.jdField_c_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.f + " >= mMaxClickTimes:" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Int >= this.jdField_a_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.jdField_d_of_type_Int + " >= mOneDayMaxTimes:" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Int >= this.jdField_b_of_type_Int)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.jdField_e_of_type_Int + " >= mMaxTimes:" + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.6(this));
  }
  
  public void c()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwl
 * JD-Core Version:    0.7.0.1
 */