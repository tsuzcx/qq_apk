import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;

public class bbva
{
  public static bbva a;
  public static String a;
  private bbsy a;
  
  static
  {
    jdField_a_of_type_Bbva = new bbva();
  }
  
  private bbva()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static bbva a()
  {
    return jdField_a_of_type_Bbva;
  }
  
  public bbsy a()
  {
    if (this.jdField_a_of_type_Bbsy == null) {
      this.jdField_a_of_type_Bbsy = new bbsy(40, CodecParam.RECORD_MAX_TIME);
    }
    return this.jdField_a_of_type_Bbsy;
  }
  
  public bbtb a()
  {
    return bbtb.a();
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbsy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbva
 * JD-Core Version:    0.7.0.1
 */