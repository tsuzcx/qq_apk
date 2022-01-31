import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;

public class azah
  extends JobSegment<azaf, azaf>
{
  private int jdField_a_of_type_Int;
  private azaf jdField_a_of_type_Azaf;
  private bgny jdField_a_of_type_Bgny;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  
  public azah(int paramInt, XMediaEditor paramXMediaEditor, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, azaf paramazaf)
  {
    if (isCanceled()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int), ", info status=", Integer.valueOf(paramazaf.g) });
    }
    this.jdField_a_of_type_Azaf = paramazaf;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (paramJobContext = paramazaf.c;; paramJobContext = ((azal)paramazaf).g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start - getFilePath: ", paramJobContext });
      }
      if (TextUtils.isEmpty(paramJobContext)) {
        break;
      }
      this.jdField_a_of_type_Bgny = paramazaf.a(paramJobContext, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bgny.a(new azai(this));
      this.jdField_a_of_type_Bgny.b();
      return;
    }
    notifyError(new Error("-2"));
  }
  
  public void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, new Object[] { "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    if (this.jdField_a_of_type_Bgny != null) {
      this.jdField_a_of_type_Bgny.c();
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
 * Qualified Name:     azah
 * JD-Core Version:    0.7.0.1
 */