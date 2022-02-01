import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bqun
  extends bquq<bqua, bqua>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<bqgu> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public bqun()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public bqun(String paramString, bqgu parambqgu, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqgu);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    yuk.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    bqui localbqui = parambqua.jdField_a_of_type_Bqui;
    int i = localbqui.c;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (bqgu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.a(this.jdField_a_of_type_Int);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (str2 == null) {
            str1 = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".jpg");
          }
          i = new bquk(localBitmap, str1, localbqui.jdField_a_of_type_Int, localbqui.jdField_b_of_type_Int, i, localbqui.jdField_a_of_type_Float, localbqui.jdField_a_of_type_Double, localbqui.jdField_b_of_type_Double, parambqua.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label217;
          }
          parambqua.jdField_a_of_type_JavaLangString = str1;
          parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(parambqua);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704585) + this.jdField_a_of_type_Int));
      }
      else
      {
        yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704586) + this.jdField_a_of_type_Int));
        return;
      }
    }
    yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, anzj.a(2131704577) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqun
 * JD-Core Version:    0.7.0.1
 */