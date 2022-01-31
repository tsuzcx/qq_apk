import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class ascg
  extends bbwt
{
  public ascg(PngFrameManager.3 param3) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null)
      {
        if (parambbwu.a() != 3) {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_Asck).sendToTarget();
        }
      }
      else {
        return;
      }
      parambbwu = ascm.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Asck.a = parambbwu;
      this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_Asck).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, parambbwu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascg
 * JD-Core Version:    0.7.0.1
 */