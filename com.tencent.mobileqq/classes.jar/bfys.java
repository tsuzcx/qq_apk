import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class bfys
  extends JobSegment<String, bfyw>
{
  private bfyu jdField_a_of_type_Bfyu;
  private String jdField_a_of_type_JavaLangString;
  
  public bfys(bfyu parambfyu)
  {
    this.jdField_a_of_type_Bfyu = parambfyu;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    yuk.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    wow.a().a(new bfyv(this.jdField_a_of_type_Bfyu, this.jdField_a_of_type_JavaLangString), new bfyt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfys
 * JD-Core Version:    0.7.0.1
 */