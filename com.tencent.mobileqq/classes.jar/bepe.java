import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import java.util.List;

class bepe
  extends beql<CreatingState>
{
  bepe(bepc parambepc, CreatingState paramCreatingState, List paramList)
  {
    super(paramCreatingState, paramList);
  }
  
  public void a(CreatingState paramCreatingState)
  {
    super.a(paramCreatingState);
    if (bepc.a(this.a).b() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      bepc.a(this.a).c(true);
      return;
    }
    bepc.a(this.a).c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepe
 * JD-Core Version:    0.7.0.1
 */