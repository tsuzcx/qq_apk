import android.text.TextUtils;
import com.tencent.mobileqq.pic.ReportInfo;
import java.net.URL;

public class aunn
  extends aunj
{
  public ReportInfo a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public int f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.f);
    localStringBuilder.append("\n |-").append("uuid:").append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("groupFileID:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n |-").append("uinType:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-").append("subMsgId:").append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n |-").append("subVersion:").append(this.d);
    localStringBuilder.append("\n |-").append("protocol:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("fileSizeFlag:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbMsgUrl:").append(this.h);
    localStringBuilder.append("\n |-").append("bigthumbMsgUrl:").append(this.k);
    localStringBuilder.append("\n |-").append("bigMsgUrl:").append(this.i);
    localStringBuilder.append("\n |-").append("rawMsgUrl:").append(this.j);
    localStringBuilder.append("\n |-").append("isMixed:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-").append("shareAppID:").append(this.jdField_e_of_type_Long);
    localStringBuilder.append("\n |-").append("action:").append(this.l);
    localStringBuilder.append("\n |-").append("actMsgContentValue:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-").append("picExtraFlag:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("picExtraObject:").append(this.jdField_a_of_type_JavaLangObject);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      a("PicDownloadInfo.check", "uuid invaid:" + this.jdField_g_of_type_JavaLangString);
      return false;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      a("checkPicInfo", "selfUin invalid,selfUin:" + this.jdField_b_of_type_JavaLangString);
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_e_of_type_Long == 0L))
    {
      a("PicDownloadInfo.check", "groupFileID invaid:" + this.jdField_e_of_type_Long);
      return false;
    }
    return super.a();
  }
  
  String b()
  {
    int n = 65537;
    if ("chatthumb".equals(this.jdField_e_of_type_JavaLangString)) {}
    while (this.jdField_a_of_type_Boolean)
    {
      localObject = new auod();
      ((auod)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      ((auod)localObject).d = this.d;
      ((auod)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((auod)localObject).f = this.f;
      localObject = aywm.a((auod)localObject, n, null);
      if (localObject == null) {
        break label129;
      }
      return ((URL)localObject).toString();
      if ("chatimg".equals(this.jdField_e_of_type_JavaLangString)) {
        n = 1;
      } else if ("chatraw".equals(this.jdField_e_of_type_JavaLangString)) {
        n = 131075;
      }
    }
    Object localObject = aywm.a(this, n, null);
    if (localObject != null) {
      return ((URL)localObject).toString();
    }
    label129:
    return null;
  }
  
  public String d()
  {
    return c() + "_dp";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunn
 * JD-Core Version:    0.7.0.1
 */