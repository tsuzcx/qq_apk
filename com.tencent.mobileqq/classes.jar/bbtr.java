import android.os.AsyncTask;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode;
import com.tencent.mobileqq.utils.FileUtils;

public class bbtr
  extends AsyncTask<Void, Void, Integer>
{
  public bbtr(SVHwEncoder.HwEncode paramHwEncode) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramVarArgs = SVHwEncoder.HwEncode.a(this.a) + "shortvideo_thumb.jpg";
    int j = this.a.a.a(SVHwEncoder.HwEncode.b(this.a), SVHwEncoder.f(this.a.this$0), SVHwEncoder.g(this.a.this$0), SVHwEncoder.a(this.a.this$0), SVHwEncoder.b(this.a.this$0), paramVarArgs);
    int i = j;
    String str;
    if (j == 0)
    {
      str = ShortVideoUtils.getShortVideoThumbPicPath(this.a.a.jdField_a_of_type_JavaLangString, "jpg");
      if (!FileUtils.rename(paramVarArgs, str)) {
        break label177;
      }
      this.a.a.b = str;
      i = j;
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      this.a.a.jdField_a_of_type_Int = i;
      SVHwEncoder.HwEncode.a(this.a, true);
      return Integer.valueOf(i);
      label177:
      i = j;
      if (!FileUtils.fileExistsAndNotEmpty(str))
      {
        this.a.this$0.a("doInBackground()", "rename failure, mThumbFilePath = " + paramVarArgs + ",thumbPath=" + str);
        i = -3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtr
 * JD-Core Version:    0.7.0.1
 */