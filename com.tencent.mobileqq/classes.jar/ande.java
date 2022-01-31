import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import java.util.Comparator;

public final class ande
  implements Comparator
{
  public int a(FaceLayer.FaceItem paramFaceItem1, FaceLayer.FaceItem paramFaceItem2)
  {
    long l = paramFaceItem1.a - paramFaceItem2.a;
    if (l < 0L) {
      return -1;
    }
    if (l == 0L) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof ande));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ande
 * JD-Core Version:    0.7.0.1
 */