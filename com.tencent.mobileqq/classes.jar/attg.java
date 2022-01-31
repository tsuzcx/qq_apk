import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class attg
  extends bdvu
{
  public attg(PngFrameManager.3 param3) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null)
      {
        if (parambdvv.a() != 3) {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_Attk).sendToTarget();
        }
      }
      else {
        return;
      }
      parambdvv = attm.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Attk.a = parambdvv;
      this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_Attk).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, parambdvv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attg
 * JD-Core Version:    0.7.0.1
 */