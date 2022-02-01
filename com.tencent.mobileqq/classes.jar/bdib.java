import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import java.util.List;

class bdib
  extends bdji<CreatingState>
{
  bdib(bdhz parambdhz, CreatingState paramCreatingState, List paramList)
  {
    super(paramCreatingState, paramList);
  }
  
  public void a(CreatingState paramCreatingState)
  {
    super.a(paramCreatingState);
    if (bdhz.a(this.a).b() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      bdhz.a(this.a).c(true);
      return;
    }
    bdhz.a(this.a).c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdib
 * JD-Core Version:    0.7.0.1
 */