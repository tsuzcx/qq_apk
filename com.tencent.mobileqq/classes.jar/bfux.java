import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;

public class bfux
  extends JobSegment<bfuw, bfuw>
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public bfux(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bfuw parambfuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment start. info status=", Integer.valueOf(parambfuw.g) });
    }
    bfuw.b();
    try
    {
      String str = TroopHWJsPlugin.a(-1, parambfuw.a, this.jdField_a_of_type_Int, null);
      if (FileUtil.fileExistsAndNotEmpty(str)) {}
      for (parambfuw.c = str;; parambfuw.c = parambfuw.a)
      {
        QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment. in path=", parambfuw.a, ", out path=", parambfuw.c });
        if (isCanceled()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment notifyResult. info status=", Integer.valueOf(parambfuw.g) });
        }
        notifyResult(parambfuw);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("CompressImageSegment", 2, "CompressImageSegment failed.");
        }
      }
      return;
    }
    catch (Exception paramJobContext)
    {
      QLog.e("CompressImageSegment", 1, "CompressImageSegment Exception: ", paramJobContext);
      notifyError(new Error("101"));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("CompressImageSegment", 1, "CompressImageSegment error. OutOfMemoryError");
      URLDrawable.clearMemoryCache();
      System.gc();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(paramJobContext, parambfuw);
        return;
      }
      notifyError(new Error("-1"));
    }
  }
  
  public void onCancel()
  {
    notifyError(new Error("c_1000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfux
 * JD-Core Version:    0.7.0.1
 */