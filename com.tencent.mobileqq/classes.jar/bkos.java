import com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory;
import com.tencent.ttpic.video.AEEncoder;

final class bkos
  implements AECoderFactory.AEEncoderFactory
{
  public AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    return new axtp(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkos
 * JD-Core Version:    0.7.0.1
 */