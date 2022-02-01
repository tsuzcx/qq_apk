import QC.UniLoginCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;

class bgjz
  implements BusinessObserver
{
  private WeakReference<bgjy> a;
  
  public bgjz(bgjy parambgjy)
  {
    this.a = new WeakReference(parambgjy);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bgjy localbgjy = (bgjy)this.a.get();
    if (localbgjy == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbgjy.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjz
 * JD-Core Version:    0.7.0.1
 */