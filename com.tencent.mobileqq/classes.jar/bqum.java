import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bqum
  extends bquq<bqua, bqua>
{
  public WeakReference<bqbv> a;
  
  public bqum(bqbv parambqbv)
  {
    this.a = new WeakReference(parambqbv);
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    paramJobContext = (bqbv)this.a.get();
    if (paramJobContext == null)
    {
      yuk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "EditVideoInteract is null, return directly.");
      notifyResult(parambqua);
      return;
    }
    paramJobContext = paramJobContext.a();
    if (paramJobContext == null)
    {
      yuk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "interact bitmap is null, return directly.");
      notifyResult(parambqua);
      return;
    }
    int i = bqul.a(parambqua);
    Object localObject;
    if (i != 0)
    {
      localObject = zps.a(paramJobContext, i);
      if (localObject != null)
      {
        paramJobContext.recycle();
        paramJobContext = (JobContext)localObject;
      }
    }
    for (;;)
    {
      localObject = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".png");
      try
      {
        if (!zoc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, (String)localObject)) {
          break;
        }
        parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("il_pic", localObject);
        notifyResult(parambqua);
        return;
      }
      catch (Exception paramJobContext)
      {
        yuk.c("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile Exception :", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      yuk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "rotate vote bitmap failed. rotation=%s", new Object[] { Integer.valueOf(i) });
    }
    yuk.e("Q.qqstory.publish.editHWEncodeGenerateInteractPasterImageSegment", "compressToFile failed.");
    super.notifyError(new ErrorMessage(-1, "compress interact bitmap failed !"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqum
 * JD-Core Version:    0.7.0.1
 */