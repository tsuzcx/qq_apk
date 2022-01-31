import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bbtd
  implements ajtg
{
  private WeakReference<bbtc> a;
  
  public bbtd(bbtc parambbtc)
  {
    this.a = new WeakReference(parambbtc);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bbtc localbbtc = (bbtc)this.a.get();
    if (localbbtc == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbbtc.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbtd
 * JD-Core Version:    0.7.0.1
 */