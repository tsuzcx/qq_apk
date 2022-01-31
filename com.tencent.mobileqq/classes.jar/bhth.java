import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.giftext.fragment.AEGIFChunkPreviewFragment.1.1;
import java.util.List;

public class bhth
  implements biao
{
  bhth(bhtg parambhtg) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e("AEGIFChunkPreviewFragment", 4, "pngsCreateWorkingQueueFirstFrameOnly index: " + paramInt);
    if (paramInt == 0) {
      bhtg.a(this.a, paramString);
    }
    bhtg.a(this.a).add(Integer.valueOf(paramInt));
    ((bhsf)bhtg.b(this.a).get(paramInt)).c = paramString;
    ((bhsf)bhtg.b(this.a).get(paramInt)).a = 14;
    bhtg.a(this.a).runOnUiThread(new AEGIFChunkPreviewFragment.1.1(this, paramInt));
    if (this.a.a()) {
      bhtg.a(this.a);
    }
    while (bhtg.a(this.a).size() != bhtg.a(this.a)) {
      return;
    }
    paramInt = bhtg.b(this.a);
    while (paramInt < bhtg.a(this.a))
    {
      bhtg.a(this.a).a((biaj)bhtg.c(this.a).get(paramInt));
      paramInt += 1;
    }
    bhtg.a(this.a, bhtg.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhth
 * JD-Core Version:    0.7.0.1
 */