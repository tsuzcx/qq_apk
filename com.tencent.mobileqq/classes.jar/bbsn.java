import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;

public class bbsn
  implements bbsr
{
  public bbsn(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      bbsa localbbsa = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localbbsa != null)
      {
        EditActivity.a(this.a).actionText = localbbsa.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsn
 * JD-Core Version:    0.7.0.1
 */