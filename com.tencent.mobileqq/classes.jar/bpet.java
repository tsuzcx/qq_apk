import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class bpet
  extends bpez<bpel, bpel>
{
  private final int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = null;
  private final WeakReference<boud> jdField_a_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public bpet()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(bpel parambpel, boolean paramBoolean, String paramString)
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
          localObject1 = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.jdField_b_of_type_JavaLangString, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            parambpel.jdField_a_of_type_JavaLangString = ((String)localObject1);
            parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        ykq.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(parambpel);
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          parambpel.jdField_a_of_type_JavaLangString = paramString;
          parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
        }
        else
        {
          ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          parambpel.jdField_a_of_type_JavaLangString = paramString;
          parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      ykq.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    ykq.a("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    bpes localbpes = parambpel.jdField_a_of_type_Bpes;
    int i = localbpes.c;
    if (this.jdField_b_of_type_Boolean)
    {
      paramJobContext = new bpeu(localbpes.jdField_a_of_type_Int, localbpes.jdField_b_of_type_Int, localbpes.jdField_a_of_type_JavaLangString, localbpes.jdField_a_of_type_Float, localbpes.jdField_a_of_type_Boolean, i, localbpes.jdField_a_of_type_Double, localbpes.jdField_b_of_type_Double, localbpes.jdField_b_of_type_JavaLangString, parambpel.jdField_a_of_type_Int, localbpes.jdField_b_of_type_Boolean);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(parambpel, bool, paramJobContext.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (boud)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
            str1 = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.jdField_b_of_type_JavaLangString, ".jpg");
          }
          i = new bpeu(localBitmap, str1, localbpes.jdField_a_of_type_Int, localbpes.jdField_b_of_type_Int, i, localbpes.jdField_a_of_type_Float, localbpes.jdField_a_of_type_Double, localbpes.jdField_b_of_type_Double, parambpel.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label317;
          }
          parambpel.jdField_a_of_type_JavaLangString = str1;
          parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(parambpel);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label317:
        ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anvx.a(2131704726) + this.jdField_a_of_type_Int));
      }
      else
      {
        ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anvx.a(2131704728) + this.jdField_a_of_type_Int));
        return;
      }
    }
    ykq.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, anvx.a(2131704725) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpet
 * JD-Core Version:    0.7.0.1
 */