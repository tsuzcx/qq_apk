import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import java.util.concurrent.ConcurrentHashMap;

public class brbj
  implements Comparable<brbj>
{
  public int a;
  public long a;
  public int b;
  
  public brbj(VideoFramesFetcher paramVideoFramesFetcher, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesFetcher.a(paramVideoFramesFetcher));
    VideoFramesFetcher.a(paramVideoFramesFetcher).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(brbj parambrbj)
  {
    return -(int)(this.jdField_a_of_type_Long - parambrbj.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     brbj
 * JD-Core Version:    0.7.0.1
 */