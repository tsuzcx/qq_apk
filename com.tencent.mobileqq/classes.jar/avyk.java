import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import java.util.Comparator;

public class avyk
  implements Comparator<avxq>
{
  public avyk(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(avxq paramavxq1, avxq paramavxq2)
  {
    if (paramavxq2.a() > paramavxq1.a()) {
      return -1;
    }
    if (paramavxq2.a() == paramavxq1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyk
 * JD-Core Version:    0.7.0.1
 */