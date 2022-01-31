import android.text.TextUtils;

public class bjix
  extends bjiu
{
  public boolean a;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public String i;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uuid:").append(this.a);
    localStringBuilder.append("\n |-").append("fileType:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("format:").append(this.d);
    localStringBuilder.append("\n |-").append("mRequestType:").append(this.f);
    localStringBuilder.append("\n |-").append("mSceneType:").append(this.g);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.a))
    {
      a("ShortVideoDownloadInfo.check", "uuid invaid:" + this.a);
      return false;
    }
    if (this.b == null)
    {
      a("ShortVideoDownloadInfo", "selfUin invalid,selfUin:" + this.b);
      return false;
    }
    return super.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjix
 * JD-Core Version:    0.7.0.1
 */