import QC.UniLoginCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;

class bhsw
  implements BusinessObserver
{
  private WeakReference<bhsv> a;
  
  public bhsw(bhsv parambhsv)
  {
    this.a = new WeakReference(parambhsv);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    bhsv localbhsv = (bhsv)this.a.get();
    if (localbhsv == null) {}
    while (!(paramObject instanceof UniLoginCheckRsp)) {
      return;
    }
    localbhsv.a(((UniLoginCheckRsp)paramObject).stKeyWord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsw
 * JD-Core Version:    0.7.0.1
 */