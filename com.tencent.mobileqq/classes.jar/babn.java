import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;

public class babn
  extends JobSegment<babl, babl>
{
  private int jdField_a_of_type_Int;
  private babl jdField_a_of_type_Babl;
  private bhxj jdField_a_of_type_Bhxj;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  
  public babn(int paramInt, XMediaEditor paramXMediaEditor, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, babl parambabl)
  {
    if (isCanceled()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int), ", info status=", Integer.valueOf(parambabl.g) });
    }
    this.jdField_a_of_type_Babl = parambabl;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (paramJobContext = parambabl.c;; paramJobContext = ((babr)parambabl).g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start - getFilePath: ", paramJobContext });
      }
      if (TextUtils.isEmpty(paramJobContext)) {
        break;
      }
      this.jdField_a_of_type_Bhxj = parambabl.a(paramJobContext, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bhxj.a(new babo(this));
      this.jdField_a_of_type_Bhxj.b();
      return;
    }
    notifyError(new Error("-2"));
  }
  
  public void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, new Object[] { "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    if (this.jdField_a_of_type_Bhxj != null) {
      this.jdField_a_of_type_Bhxj.c();
    }
    Error localError;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localError = new Error("c_1001");
    }
    for (;;)
    {
      notifyError(localError);
      return;
      localError = new Error("c_2002");
      continue;
      localError = new Error("c_2003");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babn
 * JD-Core Version:    0.7.0.1
 */