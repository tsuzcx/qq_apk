import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;

public class avce
  implements avci
{
  public avce(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      avbr localavbr = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localavbr != null)
      {
        EditActivity.a(this.a).actionText = localavbr.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avce
 * JD-Core Version:    0.7.0.1
 */