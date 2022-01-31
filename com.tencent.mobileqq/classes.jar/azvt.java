import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class azvt
  extends JobSegment<String, azvx>
{
  private azvv jdField_a_of_type_Azvv;
  private String jdField_a_of_type_JavaLangString;
  
  public azvt(azvv paramazvv)
  {
    this.jdField_a_of_type_Azvv = paramazvv;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    veg.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    syr.a().a(new azvw(this.jdField_a_of_type_Azvv, this.jdField_a_of_type_JavaLangString), new azvu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvt
 * JD-Core Version:    0.7.0.1
 */