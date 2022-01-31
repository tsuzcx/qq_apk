import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import java.util.Comparator;

public class axuu
  implements Comparator<axua>
{
  public axuu(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(axua paramaxua1, axua paramaxua2)
  {
    if (paramaxua2.a() > paramaxua1.a()) {
      return -1;
    }
    if (paramaxua2.a() == paramaxua1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axuu
 * JD-Core Version:    0.7.0.1
 */