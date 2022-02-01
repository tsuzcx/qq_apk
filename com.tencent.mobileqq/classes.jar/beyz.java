import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class beyz
  implements wld<bezb, wla>
{
  beyz(beyy parambeyy) {}
  
  public void a(@NonNull bezb parambezb, @Nullable wla paramwla, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      yqp.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      beyy.a(this.a, paramErrorMessage);
      return;
    }
    if (paramwla.a == 0)
    {
      parambezb = new bezc();
      parambezb.a = beyy.a(this.a);
      parambezb.b = beyy.a(this.a).b;
      beyy.a(this.a, parambezb);
      return;
    }
    yqp.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramwla.b);
    beyy.b(this.a, new ErrorMessage(paramwla.a, paramwla.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyz
 * JD-Core Version:    0.7.0.1
 */