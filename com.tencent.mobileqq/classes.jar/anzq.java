import android.os.AsyncTask;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwThumbGen;

class anzq
  extends AsyncTask
{
  anzq(anzp paramanzp) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramVarArgs = anzp.a(this.a) + "shortvideo_thumb.jpg";
    int j = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwThumbGen.a(anzp.b(this.a), SVHwEncoder.f(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.g(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.b(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder), paramVarArgs);
    int i = j;
    String str;
    if (j == 0)
    {
      str = ShortVideoUtils.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString, "jpg");
      if (!FileUtils.c(paramVarArgs, str)) {
        break label177;
      }
      this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwThumbGen.b = str;
      i = j;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int = i;
      anzp.a(this.a, true);
      return Integer.valueOf(i);
      label177:
      i = j;
      if (!FileUtils.b(str))
      {
        this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("doInBackground()", "rename failure, mThumbFilePath = " + paramVarArgs + ",thumbPath=" + str);
        i = -3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzq
 * JD-Core Version:    0.7.0.1
 */