import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class barb
  implements ajfe
{
  private WeakReference<bara> a;
  
  public barb(bara parambara)
  {
    this.a = new WeakReference(parambara);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bara localbara = (bara)this.a.get();
    if (localbara == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbara.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     barb
 * JD-Core Version:    0.7.0.1
 */