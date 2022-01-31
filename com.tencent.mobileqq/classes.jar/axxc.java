import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;

public class axxc
  implements axxg
{
  public axxc(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      axwp localaxwp = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localaxwp != null)
      {
        EditActivity.a(this.a).actionText = localaxwp.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxc
 * JD-Core Version:    0.7.0.1
 */