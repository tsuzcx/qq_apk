import com.tencent.mobileqq.pic.CompressInfo;

public class auow
  extends auoy
{
  auow(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a()
  {
    return 80;
  }
  
  protected final int[] a()
  {
    if (this.a.g == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2560;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    aung.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + arrayOfInt[0]);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auow
 * JD-Core Version:    0.7.0.1
 */