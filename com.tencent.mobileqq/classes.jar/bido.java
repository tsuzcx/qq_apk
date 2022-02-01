import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bido
  implements anui
{
  private WeakReference<bidn> a;
  
  public bido(bidn parambidn)
  {
    this.a = new WeakReference(parambidn);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bidn localbidn = (bidn)this.a.get();
    if (localbidn == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbidn.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bido
 * JD-Core Version:    0.7.0.1
 */