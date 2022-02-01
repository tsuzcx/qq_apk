import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bque
  extends bquq<bqua, bqua>
{
  public WeakReference<bqbv> a;
  
  public bque(bqbv parambqbv)
  {
    this.a = new WeakReference(parambqbv);
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    paramJobContext = (bqbv)this.a.get();
    if (paramJobContext == null)
    {
      yuk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambqua);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      yuk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambqua);
      return;
    }
    String str = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".png");
    try
    {
      if (zoc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambqua);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      yuk.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    yuk.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bque
 * JD-Core Version:    0.7.0.1
 */