import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class azvw
  implements syq<azvy, syn>
{
  azvw(azvv paramazvv) {}
  
  public void a(@NonNull azvy paramazvy, @Nullable syn paramsyn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      ved.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      azvv.a(this.a, paramErrorMessage);
      return;
    }
    if (paramsyn.a == 0)
    {
      paramazvy = new azvz();
      paramazvy.a = azvv.a(this.a);
      paramazvy.b = azvv.a(this.a).b;
      azvv.a(this.a, paramazvy);
      return;
    }
    ved.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramsyn.b);
    azvv.b(this.a, new ErrorMessage(paramsyn.a, paramsyn.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvw
 * JD-Core Version:    0.7.0.1
 */