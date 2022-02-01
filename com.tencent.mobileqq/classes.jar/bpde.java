import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bpde
  extends QQUIEventReceiver<bpcv, bpjh>
{
  public bpde(@NonNull bpcv parambpcv)
  {
    super(parambpcv);
  }
  
  public void a(@NonNull bpcv parambpcv, @NonNull bpjh parambpjh) {}
  
  public Class acceptEventClass()
  {
    return bpjh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpde
 * JD-Core Version:    0.7.0.1
 */