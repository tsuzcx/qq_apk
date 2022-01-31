import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bmwr
  extends bmxd<bmwn, bmwn>
{
  public WeakReference<bmei> a;
  
  public bmwr(bmei parambmei)
  {
    this.a = new WeakReference(parambmei);
  }
  
  protected void a(JobContext paramJobContext, bmwn parambmwn)
  {
    paramJobContext = (bmei)this.a.get();
    if (paramJobContext == null)
    {
      wsv.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "EditInteractExport is null, return directly.");
      notifyResult(parambmwn);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      wsv.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambmwn);
      return;
    }
    String str = bmxg.a(parambmwn.jdField_a_of_type_Int, parambmwn.b, ".png");
    try
    {
      if (xmn.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str))
      {
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", str);
        notifyResult(parambmwn);
        return;
      }
    }
    catch (Exception paramJobContext)
    {
      wsv.c("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    wsv.e("Q.qqstory.publish.editGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwr
 * JD-Core Version:    0.7.0.1
 */