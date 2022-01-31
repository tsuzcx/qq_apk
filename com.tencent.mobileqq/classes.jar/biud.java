import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class biud
  extends biuq<bitz, bitz>
{
  public WeakReference<bibk> a;
  
  public biud(bibk parambibk)
  {
    this.a = new WeakReference(parambibk);
  }
  
  protected void a(JobContext paramJobContext, bitz parambitz)
  {
    paramJobContext = (bibk)this.a.get();
    if (paramJobContext == null)
    {
      urk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambitz);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      urk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambitz);
      return;
    }
    String str = biut.a(parambitz.jdField_a_of_type_Int, parambitz.b, ".png");
    try
    {
      if (vlc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambitz);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      urk.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    urk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biud
 * JD-Core Version:    0.7.0.1
 */