import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import java.util.concurrent.ConcurrentHashMap;

public class anru
  implements Comparable
{
  public int a;
  public long a;
  public int b;
  
  public anru(VideoFramesRetriever paramVideoFramesRetriever, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesRetriever.a(paramVideoFramesRetriever));
    VideoFramesRetriever.a(paramVideoFramesRetriever).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(anru paramanru)
  {
    return -(int)(this.jdField_a_of_type_Long - paramanru.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anru
 * JD-Core Version:    0.7.0.1
 */