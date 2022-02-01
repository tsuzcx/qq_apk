import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class awey
  extends bhhe
{
  public awey(PngFrameManager.3 param3) {}
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null)
      {
        if (parambhhf.a() != 3) {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_Awfc).sendToTarget();
        }
      }
      else {
        return;
      }
      parambhhf = awfe.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Awfc.a = parambhhf;
      this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_Awfc).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, parambhhf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awey
 * JD-Core Version:    0.7.0.1
 */