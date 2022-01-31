import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class bbyo
  implements urr<bbyq, uro>
{
  bbyo(bbyn parambbyn) {}
  
  public void a(@NonNull bbyq parambbyq, @Nullable uro paramuro, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      wxe.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      bbyn.a(this.a, paramErrorMessage);
      return;
    }
    if (paramuro.a == 0)
    {
      parambbyq = new bbyr();
      parambbyq.a = bbyn.a(this.a);
      parambbyq.b = bbyn.a(this.a).b;
      bbyn.a(this.a, parambbyq);
      return;
    }
    wxe.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramuro.b);
    bbyn.b(this.a, new ErrorMessage(paramuro.a, paramuro.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyo
 * JD-Core Version:    0.7.0.1
 */