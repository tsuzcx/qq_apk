import QC.UniLoginCheckRsp;
import java.lang.ref.WeakReference;

class bhde
  implements anil
{
  private WeakReference<bhdd> a;
  
  public bhde(bhdd parambhdd)
  {
    this.a = new WeakReference(parambhdd);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bhdd localbhdd = (bhdd)this.a.get();
    if (localbhdd == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbhdd.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhde
 * JD-Core Version:    0.7.0.1
 */