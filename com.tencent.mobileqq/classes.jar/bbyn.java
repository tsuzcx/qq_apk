import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class bbyn
  extends JobSegment<String, bbyr>
{
  private bbyp jdField_a_of_type_Bbyp;
  private String jdField_a_of_type_JavaLangString;
  
  public bbyn(bbyp parambbyp)
  {
    this.jdField_a_of_type_Bbyp = parambbyp;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wxe.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    urp.a().a(new bbyq(this.jdField_a_of_type_Bbyp, this.jdField_a_of_type_JavaLangString), new bbyo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyn
 * JD-Core Version:    0.7.0.1
 */