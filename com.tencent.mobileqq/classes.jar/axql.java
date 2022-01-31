import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import java.util.Comparator;

public class axql
  implements Comparator<axpr>
{
  public axql(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(axpr paramaxpr1, axpr paramaxpr2)
  {
    if (paramaxpr2.a() > paramaxpr1.a()) {
      return -1;
    }
    if (paramaxpr2.a() == paramaxpr1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axql
 * JD-Core Version:    0.7.0.1
 */