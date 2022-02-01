import com.tencent.tavcut.TAVCut.Callback;
import java.util.List;

class blms
  implements TAVCut.Callback
{
  blms(blmr paramblmr) {}
  
  public void onDone(int paramInt)
  {
    if (paramInt != 0) {
      blmr.a(this.a).add(new blmy(this.a, -8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blms
 * JD-Core Version:    0.7.0.1
 */