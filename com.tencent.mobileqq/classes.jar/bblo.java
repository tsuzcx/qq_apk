import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import java.util.Comparator;

public class bblo
  implements Comparator<bbku>
{
  public bblo(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(bbku parambbku1, bbku parambbku2)
  {
    if (parambbku2.a() > parambbku1.a()) {
      return -1;
    }
    if (parambbku2.a() == parambbku1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblo
 * JD-Core Version:    0.7.0.1
 */