import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class ayvd
  extends JobSegment<String, ayvh>
{
  private ayvf jdField_a_of_type_Ayvf;
  private String jdField_a_of_type_JavaLangString;
  
  public ayvd(ayvf paramayvf)
  {
    this.jdField_a_of_type_Ayvf = paramayvf;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    urk.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    slv.a().a(new ayvg(this.jdField_a_of_type_Ayvf, this.jdField_a_of_type_JavaLangString), new ayve(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayvd
 * JD-Core Version:    0.7.0.1
 */