import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bnbl
  extends bnbp<bnaz, bnaz>
{
  public WeakReference<bmiu> a;
  
  public bnbl(bmiu parambmiu)
  {
    this.a = new WeakReference(parambmiu);
  }
  
  protected void a(JobContext paramJobContext, bnaz parambnaz)
  {
    paramJobContext = (bmiu)this.a.get();
    if (paramJobContext == null)
    {
      wxe.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambnaz);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      wxe.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambnaz);
      return;
    }
    int i = bnbk.a(parambnaz);
    Object localObject;
    if (i != 0)
    {
      localObject = xsm.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bnbs.a(parambnaz.jdField_a_of_type_Int, parambnaz.b, ".png");
      try
      {
        if (!xqw.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambnaz);
        return;
      }
      catch (Exception paramJobContext)
      {
        wxe.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      wxe.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    wxe.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbl
 * JD-Core Version:    0.7.0.1
 */