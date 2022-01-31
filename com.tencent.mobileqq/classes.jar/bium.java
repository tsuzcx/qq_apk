import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bium
  extends biuq<bitz, bitz>
{
  public WeakReference<bibk> a;
  
  public bium(bibk parambibk)
  {
    this.a = new WeakReference(parambibk);
  }
  
  protected void a(JobContext paramJobContext, bitz parambitz)
  {
    paramJobContext = (bibk)this.a.get();
    if (paramJobContext == null)
    {
      urk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambitz);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      urk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambitz);
      return;
    }
    int i = biul.a(parambitz);
    Object localObject;
    if (i != 0)
    {
      localObject = vms.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = biut.a(parambitz.jdField_a_of_type_Int, parambitz.b, ".png");
      try
      {
        if (!vlc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambitz);
        return;
      }
      catch (Exception paramJobContext)
      {
        urk.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      urk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    urk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bium
 * JD-Core Version:    0.7.0.1
 */