import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bnbd
  extends bnbp<bnaz, bnaz>
{
  public WeakReference<bmiu> a;
  
  public bnbd(bmiu parambmiu)
  {
    this.a = new WeakReference(parambmiu);
  }
  
  protected void a(JobContext paramJobContext, bnaz parambnaz)
  {
    paramJobContext = (bmiu)this.a.get();
    if (paramJobContext == null)
    {
      wxe.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambnaz);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      wxe.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambnaz);
      return;
    }
    String str = bnbs.a(parambnaz.jdField_a_of_type_Int, parambnaz.b, ".png");
    try
    {
      if (xqw.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambnaz);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      wxe.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    wxe.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbd
 * JD-Core Version:    0.7.0.1
 */