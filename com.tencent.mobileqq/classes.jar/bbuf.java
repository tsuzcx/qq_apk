import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class bbuf
  implements uni<bbuh, unf>
{
  bbuf(bbue parambbue) {}
  
  public void a(@NonNull bbuh parambbuh, @Nullable unf paramunf, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      wsv.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      bbue.a(this.a, paramErrorMessage);
      return;
    }
    if (paramunf.a == 0)
    {
      parambbuh = new bbui();
      parambbuh.a = bbue.a(this.a);
      parambbuh.b = bbue.a(this.a).b;
      bbue.a(this.a, parambbuh);
      return;
    }
    wsv.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramunf.b);
    bbue.b(this.a, new ErrorMessage(paramunf.a, paramunf.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuf
 * JD-Core Version:    0.7.0.1
 */