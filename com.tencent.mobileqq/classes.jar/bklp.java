import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bklp
  extends bklt<bkld, bkld>
{
  public WeakReference<bjsy> a;
  
  public bklp(bjsy parambjsy)
  {
    this.a = new WeakReference(parambjsy);
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    paramJobContext = (bjsy)this.a.get();
    if (paramJobContext == null)
    {
      ved.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambkld);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      ved.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambkld);
      return;
    }
    int i = bklo.a(parambkld);
    Object localObject;
    if (i != 0)
    {
      localObject = vzl.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".png");
      try
      {
        if (!vxv.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambkld);
        return;
      }
      catch (Exception paramJobContext)
      {
        ved.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      ved.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    ved.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklp
 * JD-Core Version:    0.7.0.1
 */