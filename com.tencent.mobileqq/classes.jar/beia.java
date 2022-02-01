import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class beia
  extends JobSegment<String, beie>
{
  private beic jdField_a_of_type_Beic;
  private String jdField_a_of_type_JavaLangString;
  
  public beia(beic parambeic)
  {
    this.jdField_a_of_type_Beic = parambeic;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    xvv.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    vqn.a().a(new beid(this.jdField_a_of_type_Beic, this.jdField_a_of_type_JavaLangString), new beib(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beia
 * JD-Core Version:    0.7.0.1
 */