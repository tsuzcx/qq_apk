import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;

public class bpsl
{
  public static bpsl a;
  public static String a;
  private bprn a;
  
  static
  {
    jdField_a_of_type_Bpsl = new bpsl();
  }
  
  private bpsl()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bpsl a()
  {
    return jdField_a_of_type_Bpsl;
  }
  
  public bprn a()
  {
    if (this.jdField_a_of_type_Bprn == null) {
      this.jdField_a_of_type_Bprn = new bprn(40, CodecParam.RECORD_MAX_TIME);
    }
    return this.jdField_a_of_type_Bprn;
  }
  
  public bprp a()
  {
    return bprp.a();
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsl
 * JD-Core Version:    0.7.0.1
 */