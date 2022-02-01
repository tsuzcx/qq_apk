import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.1;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.3;
import mqq.os.MqqHandler;

public class bncx
  implements bnkq
{
  bncx(bncv parambncv) {}
  
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    if ((!paramBoolean) || (bncv.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, parambnke));
      if (!paramBoolean) {
        break label146;
      }
    }
    label146:
    for (int i = 0;; i = 1)
    {
      aanb.a("record_decoration_download", aanb.a(i, System.currentTimeMillis() - parambnke.jdField_a_of_type_Long, parambnke.d, parambnke.b, parambnke.jdField_a_of_type_JavaLangString));
      return;
      if ((parambnke.jdField_a_of_type_JavaLangString.equals(bncv.a(this.a).a())) && (parambnke.jdField_a_of_type_JavaLangString.equals(bncv.a(this.a).jdField_a_of_type_JavaLangString)))
      {
        bncv.a(this.a);
        bncv.a(this.a, bncv.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, parambnke));
      break;
    }
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, parambnke, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncx
 * JD-Core Version:    0.7.0.1
 */