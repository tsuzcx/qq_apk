import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bjyf
  implements bjjr
{
  bjyf(bjye parambjye) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzonePersonalizeJsPlugin", 4, "FontInterface.TrueTypeResult font:" + paramInt + ", fontPath:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      bjye.a(this.a, paramString2, -2, "font download failed.");
      return;
    }
    bjye.a(this.a, paramString2, 0, "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjyf
 * JD-Core Version:    0.7.0.1
 */