import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ayve
  implements slx<ayvg, slu>
{
  ayve(ayvd paramayvd) {}
  
  public void a(@NonNull ayvg paramayvg, @Nullable slu paramslu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      urk.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      ayvd.a(this.a, paramErrorMessage);
      return;
    }
    if (paramslu.a == 0)
    {
      paramayvg = new ayvh();
      paramayvg.a = ayvd.a(this.a);
      paramayvg.b = ayvd.a(this.a).b;
      ayvd.a(this.a, paramayvg);
      return;
    }
    urk.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramslu.b);
    ayvd.b(this.a, new ErrorMessage(paramslu.a, paramslu.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayve
 * JD-Core Version:    0.7.0.1
 */