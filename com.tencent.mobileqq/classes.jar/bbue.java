import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class bbue
  extends JobSegment<String, bbui>
{
  private bbug jdField_a_of_type_Bbug;
  private String jdField_a_of_type_JavaLangString;
  
  public bbue(bbug parambbug)
  {
    this.jdField_a_of_type_Bbug = parambbug;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wsv.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    ung.a().a(new bbuh(this.jdField_a_of_type_Bbug, this.jdField_a_of_type_JavaLangString), new bbuf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbue
 * JD-Core Version:    0.7.0.1
 */