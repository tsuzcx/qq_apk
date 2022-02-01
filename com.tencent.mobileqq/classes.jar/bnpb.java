import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class bnpb
  extends bnph<bnot, bnot>
{
  private final int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = null;
  private final WeakReference<bnel> jdField_a_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bnpb()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(bnot parambnot, boolean paramBoolean, String paramString)
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
          localObject1 = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.jdField_b_of_type_JavaLangString, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            parambnot.jdField_a_of_type_JavaLangString = ((String)localObject1);
            parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        xvv.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(parambnot);
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          parambnot.jdField_a_of_type_JavaLangString = paramString;
          parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
        }
        else
        {
          xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          parambnot.jdField_a_of_type_JavaLangString = paramString;
          parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      xvv.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, bnot parambnot)
  {
    xvv.a("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    bnpa localbnpa = parambnot.jdField_a_of_type_Bnpa;
    int i = localbnpa.c;
    if (this.jdField_b_of_type_Boolean)
    {
      paramJobContext = new bnpc(localbnpa.jdField_a_of_type_Int, localbnpa.jdField_b_of_type_Int, localbnpa.jdField_a_of_type_JavaLangString, localbnpa.jdField_a_of_type_Float, localbnpa.jdField_a_of_type_Boolean, i, localbnpa.jdField_a_of_type_Double, localbnpa.jdField_b_of_type_Double, localbnpa.jdField_b_of_type_JavaLangString, parambnot.jdField_a_of_type_Int, localbnpa.jdField_b_of_type_Boolean);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(parambnot, bool, paramJobContext.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (bnel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
            str1 = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.jdField_b_of_type_JavaLangString, ".jpg");
          }
          i = new bnpc(localBitmap, str1, localbnpa.jdField_a_of_type_Int, localbnpa.jdField_b_of_type_Int, i, localbnpa.jdField_a_of_type_Float, localbnpa.jdField_a_of_type_Double, localbnpa.jdField_b_of_type_Double, parambnot.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label317;
          }
          parambnot.jdField_a_of_type_JavaLangString = str1;
          parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(parambnot);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label317:
        xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, amtj.a(2131704375) + this.jdField_a_of_type_Int));
      }
      else
      {
        xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, amtj.a(2131704377) + this.jdField_a_of_type_Int));
        return;
      }
    }
    xvv.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, amtj.a(2131704374) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpb
 * JD-Core Version:    0.7.0.1
 */