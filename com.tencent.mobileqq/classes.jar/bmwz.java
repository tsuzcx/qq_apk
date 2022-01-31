import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bmwz
  extends bmxd<bmwn, bmwn>
{
  public WeakReference<bmei> a;
  
  public bmwz(bmei parambmei)
  {
    this.a = new WeakReference(parambmei);
  }
  
  protected void a(JobContext paramJobContext, bmwn parambmwn)
  {
    paramJobContext = (bmei)this.a.get();
    if (paramJobContext == null)
    {
      wsv.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambmwn);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      wsv.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambmwn);
      return;
    }
    int i = bmwy.a(parambmwn);
    Object localObject;
    if (i != 0)
    {
      localObject = xod.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bmxg.a(parambmwn.jdField_a_of_type_Int, parambmwn.b, ".png");
      try
      {
        if (!xmn.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambmwn);
        return;
      }
      catch (Exception paramJobContext)
      {
        wsv.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      wsv.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    wsv.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwz
 * JD-Core Version:    0.7.0.1
 */