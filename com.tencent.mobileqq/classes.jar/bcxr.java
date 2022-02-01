import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class bcxr
  implements bcxw
{
  bcxo jdField_a_of_type_Bcxo;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  
  public bcxr(String paramString, bcxo parambcxo)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bcxo = parambcxo;
  }
  
  public void B_()
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onNetWorkNone...", null);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (this.d)) {
      bcxo.a(this.jdField_a_of_type_Bcxo);
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
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        this.b = true;
      } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        this.c = true;
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        this.d = true;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxr
 * JD-Core Version:    0.7.0.1
 */