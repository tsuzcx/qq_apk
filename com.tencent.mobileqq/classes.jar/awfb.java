import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;

class awfb
  implements awfg
{
  awez jdField_a_of_type_Awez;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  boolean e = true;
  
  public awfb(String paramString, awez paramawez)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Awez = paramawez;
  }
  
  public void I_()
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onNetWorkNone...", null);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (this.c) && (this.e)) {
      awez.a(this.jdField_a_of_type_Awez);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      a();
      return;
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        this.b = true;
        paramString1 = new Intent();
        paramString1.setAction("key_notify_filter_so_ready");
        paramString1.setPackage(BaseApplicationImpl.getContext().getPackageName());
        BaseApplicationImpl.getContext().sendBroadcast(paramString1);
      }
      else if (paramString1.startsWith("new_qq_android_native_art_filter_"))
      {
        this.c = true;
      }
      else if (paramString1.startsWith("new_qq_android_native_portrait_filter_"))
      {
        this.d = true;
      }
      else if (paramString1.startsWith("new_qq_android_native_object_tracking_"))
      {
        this.e = true;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfb
 * JD-Core Version:    0.7.0.1
 */