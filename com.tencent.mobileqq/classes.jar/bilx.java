import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import mqq.os.MqqHandler;

public class bilx
  implements birp
{
  bilx(bilv parambilv) {}
  
  public void a(bire parambire, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, parambire, paramInt));
  }
  
  public void a(bire parambire, boolean paramBoolean)
  {
    if ((!paramBoolean) || (bilv.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, parambire));
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      xhb.a("record_decoration_download", xhb.a(i, System.currentTimeMillis() - parambire.jdField_a_of_type_Long, parambire.d, parambire.b, parambire.jdField_a_of_type_JavaLangString));
      return;
      if (this.a.a(bilv.a(this.a).a()) == bilv.a(this.a)) {
        bilv.a(this.a, bilv.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, parambire));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilx
 * JD-Core Version:    0.7.0.1
 */