import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bbtr
  implements ajte
{
  private WeakReference<bbtq> a;
  
  public bbtr(bbtq parambbtq)
  {
    this.a = new WeakReference(parambbtq);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bbtq localbbtq = (bbtq)this.a.get();
    if (localbbtq == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbbtq.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbtr
 * JD-Core Version:    0.7.0.1
 */