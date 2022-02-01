import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bpsr
  extends bpsv<bpsf, bpsf>
{
  public WeakReference<bpaa> a;
  
  public bpsr(bpaa parambpaa)
  {
    this.a = new WeakReference(parambpaa);
  }
  
  protected void a(JobContext paramJobContext, bpsf parambpsf)
  {
    paramJobContext = (bpaa)this.a.get();
    if (paramJobContext == null)
    {
      yqp.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambpsf);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      yqp.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambpsf);
      return;
    }
    int i = bpsq.a(parambpsf);
    Object localObject;
    if (i != 0)
    {
      localObject = zlx.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bpsy.a(parambpsf.jdField_a_of_type_Int, parambpsf.b, ".png");
      try
      {
        if (!zkh.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambpsf);
        return;
      }
      catch (Exception paramJobContext)
      {
        yqp.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      yqp.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    yqp.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsr
 * JD-Core Version:    0.7.0.1
 */