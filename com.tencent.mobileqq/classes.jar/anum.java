import android.os.Bundle;
import com.tencent.mobileqq.utils.LogTag;
import dov.com.tencent.mobileqq.richmedia.CompoundProcessor;
import dov.com.tencent.mobileqq.richmedia.RichmediaClient;

public class anum
  implements Runnable
{
  public anum(CompoundProcessor paramCompoundProcessor) {}
  
  public void run()
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    String str = this.a.a(this.a.jdField_b_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.a.a);
    localBundle.putString("full_video_path", str);
    localBundle.putInt("video_slices_total_time_length", this.a.jdField_b_of_type_Int);
    localRichmediaClient.a(103, -1, localBundle);
    LogTag.a(this.a.a, "clicompCompoundProcessor.compressSourceYUV", "path = " + str + ",totalTime = " + this.a.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anum
 * JD-Core Version:    0.7.0.1
 */