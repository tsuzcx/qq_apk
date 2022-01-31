import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bklq
  extends bklt<bkld, bkld>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<bjxx> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public bklq()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public bklq(String paramString, bjxx parambjxx, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjxx);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    ved.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    bkll localbkll = parambkld.jdField_a_of_type_Bkll;
    int i = localbkll.c;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (bjxx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
            str1 = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".jpg");
          }
          i = new bkln(localBitmap, str1, localbkll.jdField_a_of_type_Int, localbkll.jdField_b_of_type_Int, i, localbkll.jdField_a_of_type_Float, localbkll.jdField_a_of_type_Double, localbkll.jdField_b_of_type_Double, parambkld.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label217;
          }
          parambkld.jdField_a_of_type_JavaLangString = str1;
          parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(parambkld);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705693) + this.jdField_a_of_type_Int));
      }
      else
      {
        ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705694) + this.jdField_a_of_type_Int));
        return;
      }
    }
    ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, ajya.a(2131705685) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklq
 * JD-Core Version:    0.7.0.1
 */