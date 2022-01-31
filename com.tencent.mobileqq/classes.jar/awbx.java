import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;

public class awbx
  implements awcb
{
  public awbx(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      awbk localawbk = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localawbk != null)
      {
        EditActivity.a(this.a).actionText = localawbk.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbx
 * JD-Core Version:    0.7.0.1
 */