import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class bfpe
  implements wfk<bfpg, wfh>
{
  bfpe(bfpd parambfpd) {}
  
  public void a(@NonNull bfpg parambfpg, @Nullable wfh paramwfh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      ykq.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      bfpd.a(this.a, paramErrorMessage);
      return;
    }
    if (paramwfh.a == 0)
    {
      parambfpg = new bfph();
      parambfpg.a = bfpd.a(this.a);
      parambfpg.b = bfpd.a(this.a).b;
      bfpd.a(this.a, parambfpg);
      return;
    }
    ykq.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramwfh.b);
    bfpd.b(this.a, new ErrorMessage(paramwfh.a, paramwfh.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpe
 * JD-Core Version:    0.7.0.1
 */