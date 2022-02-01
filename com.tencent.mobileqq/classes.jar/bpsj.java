import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bpsj
  extends bpsv<bpsf, bpsf>
{
  public WeakReference<bpaa> a;
  
  public bpsj(bpaa parambpaa)
  {
    this.a = new WeakReference(parambpaa);
  }
  
  protected void a(JobContext paramJobContext, bpsf parambpsf)
  {
    paramJobContext = (bpaa)this.a.get();
    if (paramJobContext == null)
    {
      yqp.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambpsf);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      yqp.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambpsf);
      return;
    }
    String str = bpsy.a(parambpsf.jdField_a_of_type_Int, parambpsf.b, ".png");
    try
    {
      if (zkh.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambpsf);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      yqp.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    yqp.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsj
 * JD-Core Version:    0.7.0.1
 */