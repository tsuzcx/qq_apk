import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class beib
  implements vqp<beid, vqm>
{
  beib(beia parambeia) {}
  
  public void a(@NonNull beid parambeid, @Nullable vqm paramvqm, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      xvv.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      beia.a(this.a, paramErrorMessage);
      return;
    }
    if (paramvqm.a == 0)
    {
      parambeid = new beie();
      parambeid.a = beia.a(this.a);
      parambeid.b = beia.a(this.a).b;
      beia.a(this.a, parambeid);
      return;
    }
    xvv.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramvqm.b);
    beia.b(this.a, new ErrorMessage(paramvqm.a, paramvqm.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beib
 * JD-Core Version:    0.7.0.1
 */