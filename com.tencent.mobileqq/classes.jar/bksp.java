import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import java.util.concurrent.ConcurrentHashMap;

public class bksp
  implements Comparable<bksp>
{
  public int a;
  public long a;
  public int b;
  
  public bksp(VideoFramesFetcher paramVideoFramesFetcher, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesFetcher.a(paramVideoFramesFetcher));
    VideoFramesFetcher.a(paramVideoFramesFetcher).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(bksp parambksp)
  {
    return -(int)(this.jdField_a_of_type_Long - parambksp.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bksp
 * JD-Core Version:    0.7.0.1
 */