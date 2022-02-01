import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.qphone.base.util.QLog;

public class avkx
  extends bgod
{
  public avkx(PngFrameManager.3 param3) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null)
      {
        if (parambgoe.a() != 3) {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_Avlb).sendToTarget();
        }
      }
      else {
        return;
      }
      parambgoe = avld.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Avlb.a = parambgoe;
      this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_Avlb).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, parambgoe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkx
 * JD-Core Version:    0.7.0.1
 */