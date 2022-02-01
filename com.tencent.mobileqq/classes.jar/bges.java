import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bges
  extends JobSegment<bgel, bgel>
{
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public bges(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
  }
  
  protected void a(JobContext paramJobContext, bgel parambgel)
  {
    bger localbger = (bger)parambgel;
    if (QLog.isColorLevel()) {
      QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localbger.jdField_g_of_type_Int) });
    }
    String str = bgel.b();
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
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localbger.f });
        }
        str = bigv.a(str + localbger.f.substring(localbger.f.lastIndexOf("/") + 1, localbger.f.lastIndexOf(".")) + System.currentTimeMillis() + auog.a(localbger.f));
        i = bnsn.a(localXMediaEditor.getContext(), localbger.f, str);
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
        }
        if (i != 1) {
          break label414;
        }
        str = localbger.f;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label217:
        QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
        URLDrawable.clearMemoryCache();
        System.gc();
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        a(paramJobContext, parambgel);
        return;
        notifyError(new Error("-200"));
        return;
        notifyError(new Error("0"));
        return;
        notifyError(new Error("-1"));
        return;
      }
      if (auog.b(str))
      {
        if (auog.a(str) > 104857600L)
        {
          notifyError(new Error("200"));
          return;
        }
        localbger.jdField_g_of_type_JavaLangString = str;
        ThreadManager.getUIHandler().post(new VideoInfo.CompressVideoSegment.1(this, localbger, localXMediaEditor));
        if (isCanceled()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localbger.jdField_g_of_type_JavaLangString, ", info status=", Integer.valueOf(localbger.jdField_g_of_type_Int) });
        }
        notifyResult(localbger);
        return;
      }
      label414:
      if (i != 0) {
        if (i != 1) {
          break label217;
        }
      }
    }
  }
  
  public void onCancel()
  {
    notifyError(new Error("c_2001"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bges
 * JD-Core Version:    0.7.0.1
 */