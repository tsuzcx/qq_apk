import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class azvu
  implements syt<azvw, syq>
{
  azvu(azvt paramazvt) {}
  
  public void a(@NonNull azvw paramazvw, @Nullable syq paramsyq, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      veg.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      azvt.a(this.a, paramErrorMessage);
      return;
    }
    if (paramsyq.a == 0)
    {
      paramazvw = new azvx();
      paramazvw.a = azvt.a(this.a);
      paramazvw.b = azvt.a(this.a).b;
      azvt.a(this.a, paramazvw);
      return;
    }
    veg.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramsyq.b);
    azvt.b(this.a, new ErrorMessage(paramsyq.a, paramsyq.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvu
 * JD-Core Version:    0.7.0.1
 */