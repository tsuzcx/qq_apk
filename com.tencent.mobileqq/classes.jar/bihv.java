import com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory;
import com.tencent.ttpic.video.AEEncoder;

final class bihv
  implements AECoderFactory.AEEncoderFactory
{
  public AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    return new avxf(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihv
 * JD-Core Version:    0.7.0.1
 */