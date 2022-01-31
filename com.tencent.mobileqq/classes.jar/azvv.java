import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class azvv
  extends JobSegment<String, azvz>
{
  private azvx jdField_a_of_type_Azvx;
  private String jdField_a_of_type_JavaLangString;
  
  public azvv(azvx paramazvx)
  {
    this.jdField_a_of_type_Azvx = paramazvx;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ved.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    syo.a().a(new azvy(this.jdField_a_of_type_Azvx, this.jdField_a_of_type_JavaLangString), new azvw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvv
 * JD-Core Version:    0.7.0.1
 */