import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bklh
  extends bklt<bkld, bkld>
{
  public WeakReference<bjsy> a;
  
  public bklh(bjsy parambjsy)
  {
    this.a = new WeakReference(parambjsy);
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    paramJobContext = (bjsy)this.a.get();
    if (paramJobContext == null)
    {
      ved.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambkld);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      ved.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambkld);
      return;
    }
    String str = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".png");
    try
    {
      if (vxv.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambkld);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      ved.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    ved.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklh
 * JD-Core Version:    0.7.0.1
 */