import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class anuk
  extends SimpleJob
{
  public anuk(EditVideoPartManager paramEditVideoPartManager) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    VideoEditReport.a("0X80076BC");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anuk
 * JD-Core Version:    0.7.0.1
 */