import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.3;
import mqq.os.MqqHandler;

public class blpo
  implements blvj
{
  blpo(blpm paramblpm) {}
  
  public void onDownloadFinish(blvb paramblvb, boolean paramBoolean)
  {
    if ((!paramBoolean) || (blpm.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, paramblvb));
      if (!paramBoolean) {
        break label146;
      }
    }
    label146:
    for (int i = 0;; i = 1)
    {
      zxp.a("record_decoration_download", zxp.a(i, System.currentTimeMillis() - paramblvb.jdField_a_of_type_Long, paramblvb.d, paramblvb.b, paramblvb.jdField_a_of_type_JavaLangString));
      return;
      if ((paramblvb.jdField_a_of_type_JavaLangString.equals(blpm.a(this.a).a())) && (paramblvb.jdField_a_of_type_JavaLangString.equals(blpm.a(this.a).jdField_a_of_type_JavaLangString)))
      {
        blpm.a(this.a);
        blpm.a(this.a, blpm.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, paramblvb));
      break;
    }
  }
  
  public void onProgressUpdate(blvb paramblvb, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, paramblvb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpo
 * JD-Core Version:    0.7.0.1
 */