import com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory;
import com.tencent.ttpic.video.AEEncoder;

final class bmwd
  implements AECoderFactory.AEEncoderFactory
{
  public AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    return new bbkt(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwd
 * JD-Core Version:    0.7.0.1
 */