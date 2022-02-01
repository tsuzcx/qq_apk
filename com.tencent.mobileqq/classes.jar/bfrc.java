import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class bfrc
  extends anyu
{
  WeakReference<bfqz> a;
  
  private bfrc(bfqz parambfqz)
  {
    this.a = new WeakReference(parambfqz);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    bfqz localbfqz = (bfqz)this.a.get();
    if ((localbfqz != null) && (paramBoolean) && (paramString != null) && (localbfqz.a != null) && (localbfqz.a.size() > 0) && (paramString.equals(((TroopInfo)localbfqz.a.get(0)).troopuin))) {
      localbfqz.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrc
 * JD-Core Version:    0.7.0.1
 */