import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bkky
  extends bklc<bkkm, bkkm>
{
  public WeakReference<bjsh> a;
  
  public bkky(bjsh parambjsh)
  {
    this.a = new WeakReference(parambjsh);
  }
  
  protected void a(JobContext paramJobContext, bkkm parambkkm)
  {
    paramJobContext = (bjsh)this.a.get();
    if (paramJobContext == null)
    {
      veg.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambkkm);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      veg.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambkkm);
      return;
    }
    int i = bkkx.a(parambkkm);
    Object localObject;
    if (i != 0)
    {
      localObject = vzo.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bklf.a(parambkkm.jdField_a_of_type_Int, parambkkm.b, ".png");
      try
      {
        if (!vxy.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambkkm);
        return;
      }
      catch (Exception paramJobContext)
      {
        veg.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      veg.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    veg.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkky
 * JD-Core Version:    0.7.0.1
 */