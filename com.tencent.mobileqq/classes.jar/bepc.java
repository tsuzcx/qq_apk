import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import java.util.Arrays;
import java.util.Collections;

public class bepc
{
  private beqk<CreatingState> jdField_a_of_type_Beqk;
  private bera jdField_a_of_type_Bera;
  
  public bepc(bera parambera)
  {
    this.jdField_a_of_type_Bera = parambera;
  }
  
  public CreatingState a()
  {
    return (CreatingState)this.jdField_a_of_type_Beqk.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beqk = new beqk(CreatingState.TEMPLATE_NO, "CreatingStateMachineController");
    this.jdField_a_of_type_Beqk.a(new bepd(this, CreatingState.TEMPLATE_FIRST_USE, Collections.singletonList(CreatingState.TEMPLATE_NO)));
    this.jdField_a_of_type_Beqk.a(new bepe(this, CreatingState.TEMPLATE_SHOW_ENTRANCE, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_LAYER })));
    this.jdField_a_of_type_Beqk.a(new bepf(this, CreatingState.TEMPLATE_SHOW_LAYER, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_ENTRANCE })));
  }
  
  public void a(CreatingState paramCreatingState)
  {
    this.jdField_a_of_type_Beqk.a(paramCreatingState);
  }
  
  public CreatingState b()
  {
    return (CreatingState)this.jdField_a_of_type_Beqk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepc
 * JD-Core Version:    0.7.0.1
 */