import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import java.util.concurrent.ConcurrentHashMap;

public class bjbn
  implements Comparable<bjbn>
{
  public int a;
  public long a;
  public int b;
  
  public bjbn(VideoFramesRetriever paramVideoFramesRetriever, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesRetriever.a(paramVideoFramesRetriever));
    VideoFramesRetriever.a(paramVideoFramesRetriever).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(bjbn parambjbn)
  {
    return -(int)(this.jdField_a_of_type_Long - parambjbn.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjbn
 * JD-Core Version:    0.7.0.1
 */