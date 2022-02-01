import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class awxq
  extends biht
{
  public awxq(PngFrameManager.3 param3) {}
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null)
      {
        if (parambihu.a() != 3) {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_Awxu).sendToTarget();
        }
      }
      else {
        return;
      }
      parambihu = awxw.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Awxu.a = parambihu;
      this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_Awxu).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, parambihu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxq
 * JD-Core Version:    0.7.0.1
 */