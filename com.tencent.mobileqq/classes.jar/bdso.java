import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bdso
  implements alkr
{
  private WeakReference<bdsn> a;
  
  public bdso(bdsn parambdsn)
  {
    this.a = new WeakReference(parambdsn);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bdsn localbdsn = (bdsn)this.a.get();
    if (localbdsn == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbdsn.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdso
 * JD-Core Version:    0.7.0.1
 */