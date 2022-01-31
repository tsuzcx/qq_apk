import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class bklm
  extends bklt<bkld, bkld>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<bjxx> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bklm()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public bklm(String paramString, bjxx parambjxx, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjxx);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(bkld parambkld, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    for (File localFile = new File(paramString);; localFile = null)
    {
      Object localObject2;
      int i;
      if ((paramBoolean) && (localFile != null) && (localFile.exists()) && (localFile.isFile()) && (localFile.length() > 0L))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.jdField_b_of_type_JavaLangString, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            parambkld.jdField_a_of_type_JavaLangString = ((String)localObject1);
            parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        ved.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(parambkld);
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          parambkld.jdField_a_of_type_JavaLangString = paramString;
          parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
        }
        else
        {
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          parambkld.jdField_a_of_type_JavaLangString = paramString;
          parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      ved.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    ved.a("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    bkll localbkll = parambkld.jdField_a_of_type_Bkll;
    int i = localbkll.c;
    if (parambkld.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramJobContext = new bkln(localbkll.jdField_a_of_type_Int, localbkll.jdField_b_of_type_Int, localbkll.jdField_a_of_type_JavaLangString, localbkll.jdField_a_of_type_Float, localbkll.jdField_a_of_type_Boolean, i, localbkll.jdField_a_of_type_Double, localbkll.jdField_b_of_type_Double, localbkll.jdField_b_of_type_JavaLangString, parambkld.jdField_a_of_type_Int, localbkll.jdField_b_of_type_Boolean);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(parambkld, bool, paramJobContext.jdField_a_of_type_JavaLangString);
        return;
      }
    }
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
            str1 = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.jdField_b_of_type_JavaLangString, ".jpg");
          }
          i = new bkln(localBitmap, str1, localbkll.jdField_a_of_type_Int, localbkll.jdField_b_of_type_Int, i, localbkll.jdField_a_of_type_Float, localbkll.jdField_a_of_type_Double, localbkll.jdField_b_of_type_Double, parambkld.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label327;
          }
          parambkld.jdField_a_of_type_JavaLangString = str1;
          parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(parambkld);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label327:
        ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705259) + this.jdField_a_of_type_Int));
      }
      else
      {
        ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705261) + this.jdField_a_of_type_Int));
        return;
      }
    }
    ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, ajya.a(2131705258) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklm
 * JD-Core Version:    0.7.0.1
 */