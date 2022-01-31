import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class azam
  extends JobSegment<azaf, azaf>
{
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public azam(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
  }
  
  protected void a(JobContext paramJobContext, azaf paramazaf)
  {
    azal localazal = (azal)paramazaf;
    if (QLog.isColorLevel()) {
      QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localazal.jdField_g_of_type_Int) });
    }
    String str = azaf.b();
    XMediaEditor localXMediaEditor;
    int i;
    for (;;)
    {
      try
      {
        localXMediaEditor = (XMediaEditor)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localXMediaEditor == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localazal.f });
        }
        str = str + localazal.f.substring(localazal.f.lastIndexOf("/") + 1, localazal.f.lastIndexOf(".")) + System.currentTimeMillis() + apdh.a(localazal.f);
        i = bgnv.a(localXMediaEditor.getContext(), localazal.f, str);
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
        }
        if (i != 1) {
          break label411;
        }
        str = localazal.f;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label214:
        QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
        URLDrawable.clearMemoryCache();
        System.gc();
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        a(paramJobContext, paramazaf);
        return;
        notifyError(new Error("-200"));
        return;
        notifyError(new Error("0"));
        return;
        notifyError(new Error("-1"));
        return;
      }
      if (apdh.b(str))
      {
        if (apdh.a(str) > 52428800L)
        {
          notifyError(new Error("200"));
          return;
        }
        localazal.jdField_g_of_type_JavaLangString = str;
        ThreadManager.getUIHandler().post(new VideoInfo.CompressVideoSegment.1(this, localazal, localXMediaEditor));
        if (isCanceled()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localazal.jdField_g_of_type_JavaLangString, ", info status=", Integer.valueOf(localazal.jdField_g_of_type_Int) });
        }
        notifyResult(localazal);
        return;
      }
      label411:
      if (i != 0) {
        if (i != 1) {
          break label214;
        }
      }
    }
  }
  
  public void onCancel()
  {
    notifyError(new Error("c_2001"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azam
 * JD-Core Version:    0.7.0.1
 */