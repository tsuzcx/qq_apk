import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.giftext.fragment.AEGIFChunkPreviewFragment.2.1;
import java.util.List;

public class bhti
  implements biao
{
  bhti(bhtg parambhtg) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("AEGIFChunkPreviewFragment", 4, "pngsCreateWorkingQueueCompleteGIF index: " + paramInt);
    if (paramInt == 0) {
      bhtg.a(this.a, paramString);
    }
    ((bhsf)bhtg.b(this.a).get(paramInt)).c = paramString;
    ((bhsf)bhtg.b(this.a).get(paramInt)).a = 13;
    bhtg.a(this.a).runOnUiThread(new AEGIFChunkPreviewFragment.2.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhti
 * JD-Core Version:    0.7.0.1
 */