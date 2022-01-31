import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class apsx
{
  protected int a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public apsx(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    a(paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("extra.IS_APOLLO");
    this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
    this.f = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.jdField_a_of_type_Long = localBundle.getLong("key_multi_forward_seq", 0L);
    this.jdField_b_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_d_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool;
    if (TextUtils.isEmpty(localBundle.getString("babyq_video_type")))
    {
      bool = false;
      this.g = bool;
      this.jdField_a_of_type_Int = localBundle.getInt("extra.EXTRA_ENTRANCE");
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int != 4) && (!localBundle.getBoolean("is_one_item"))) {
        break label272;
      }
      bool = true;
      label168:
      this.h = bool;
      if (!paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) {
        break label277;
      }
    }
    label272:
    label277:
    for (int j = 1;; j = 0)
    {
      this.jdField_c_of_type_Int = j;
      this.jdField_d_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
      this.jdField_e_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
      this.i = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
      this.jdField_c_of_type_Boolean = localBundle.getBoolean(bfcq.jdField_b_of_type_JavaLangString, true);
      this.jdField_b_of_type_Boolean = localBundle.getBoolean(bfcq.jdField_a_of_type_JavaLangString);
      return;
      bool = true;
      break;
      bool = false;
      break label168;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != -1);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsx
 * JD-Core Version:    0.7.0.1
 */