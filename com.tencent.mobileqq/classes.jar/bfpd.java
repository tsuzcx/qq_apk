import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class bfpd
  extends JobSegment<String, bfph>
{
  private bfpf jdField_a_of_type_Bfpf;
  private String jdField_a_of_type_JavaLangString;
  
  public bfpd(bfpf parambfpf)
  {
    this.jdField_a_of_type_Bfpf = parambfpf;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ykq.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    wfi.a().a(new bfpg(this.jdField_a_of_type_Bfpf, this.jdField_a_of_type_JavaLangString), new bfpe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpd
 * JD-Core Version:    0.7.0.1
 */