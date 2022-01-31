import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import mqq.os.MqqHandler;

public class bkqo
  implements bkwg
{
  bkqo(bkqk parambkqk) {}
  
  public void a(bkvu parambkvu, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.3(this, parambkvu, paramInt));
  }
  
  public void a(bkvu parambkvu, boolean paramBoolean)
  {
    if ((!paramBoolean) || (bkqk.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.1(this, parambkvu));
      if (!paramBoolean) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      yvu.a("record_decoration_download", yvu.a(i, System.currentTimeMillis() - parambkvu.jdField_a_of_type_Long, parambkvu.d, parambkvu.b, parambkvu.jdField_a_of_type_JavaLangString));
      return;
      if (this.a.a(bkqk.a(this.a).a()) == bkqk.a(this.a)) {
        bkqk.a(this.a, bkqk.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.6.2(this, parambkvu));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqo
 * JD-Core Version:    0.7.0.1
 */