import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class beyy
  extends JobSegment<String, bezc>
{
  private beza jdField_a_of_type_Beza;
  private String jdField_a_of_type_JavaLangString;
  
  public beyy(beza parambeza)
  {
    this.jdField_a_of_type_Beza = parambeza;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    yqp.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    wlb.a().a(new bezb(this.jdField_a_of_type_Beza, this.jdField_a_of_type_JavaLangString), new beyz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */