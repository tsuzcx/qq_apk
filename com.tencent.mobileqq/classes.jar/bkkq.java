import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bkkq
  extends bklc<bkkm, bkkm>
{
  public WeakReference<bjsh> a;
  
  public bkkq(bjsh parambjsh)
  {
    this.a = new WeakReference(parambjsh);
  }
  
  protected void a(JobContext paramJobContext, bkkm parambkkm)
  {
    paramJobContext = (bjsh)this.a.get();
    if (paramJobContext == null)
    {
      veg.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambkkm);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      veg.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambkkm);
      return;
    }
    String str = bklf.a(parambkkm.jdField_a_of_type_Int, parambkkm.b, ".png");
    try
    {
      if (vxy.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambkkm);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      veg.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    veg.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkq
 * JD-Core Version:    0.7.0.1
 */