import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import java.util.Arrays;
import java.util.Collections;

public class bdhz
{
  private bdjh<CreatingState> jdField_a_of_type_Bdjh;
  private bdjx jdField_a_of_type_Bdjx;
  
  public bdhz(bdjx parambdjx)
  {
    this.jdField_a_of_type_Bdjx = parambdjx;
  }
  
  public CreatingState a()
  {
    return (CreatingState)this.jdField_a_of_type_Bdjh.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdjh = new bdjh(CreatingState.TEMPLATE_NO, "CreatingStateMachineController");
    this.jdField_a_of_type_Bdjh.a(new bdia(this, CreatingState.TEMPLATE_FIRST_USE, Collections.singletonList(CreatingState.TEMPLATE_NO)));
    this.jdField_a_of_type_Bdjh.a(new bdib(this, CreatingState.TEMPLATE_SHOW_ENTRANCE, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_LAYER })));
    this.jdField_a_of_type_Bdjh.a(new bdic(this, CreatingState.TEMPLATE_SHOW_LAYER, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_ENTRANCE })));
  }
  
  public void a(CreatingState paramCreatingState)
  {
    this.jdField_a_of_type_Bdjh.a(paramCreatingState);
  }
  
  public CreatingState b()
  {
    return (CreatingState)this.jdField_a_of_type_Bdjh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhz
 * JD-Core Version:    0.7.0.1
 */