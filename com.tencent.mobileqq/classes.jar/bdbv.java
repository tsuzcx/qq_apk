import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;

public class bdbv
{
  public static bdbv a;
  public static String a;
  private bczt a;
  
  static
  {
    jdField_a_of_type_Bdbv = new bdbv();
  }
  
  private bdbv()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bdbv a()
  {
    return jdField_a_of_type_Bdbv;
  }
  
  public bczt a()
  {
    if (this.jdField_a_of_type_Bczt == null) {
      this.jdField_a_of_type_Bczt = new bczt(40, CodecParam.RECORD_MAX_TIME);
    }
    return this.jdField_a_of_type_Bczt;
  }
  
  public bczw a()
  {
    return bczw.a();
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bczt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbv
 * JD-Core Version:    0.7.0.1
 */