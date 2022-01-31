import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bdwx
  implements alpg
{
  private WeakReference<bdww> a;
  
  public bdwx(bdww parambdww)
  {
    this.a = new WeakReference(parambdww);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bdww localbdww = (bdww)this.a.get();
    if (localbdww == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbdww.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwx
 * JD-Core Version:    0.7.0.1
 */