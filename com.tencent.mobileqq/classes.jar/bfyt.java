import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class bfyt
  implements woy<bfyv, wov>
{
  bfyt(bfys parambfys) {}
  
  public void a(@NonNull bfyv parambfyv, @Nullable wov paramwov, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      yuk.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      bfys.a(this.a, paramErrorMessage);
      return;
    }
    if (paramwov.a == 0)
    {
      parambfyv = new bfyw();
      parambfyv.a = bfys.a(this.a);
      parambfyv.b = bfys.a(this.a).b;
      bfys.a(this.a, parambfyv);
      return;
    }
    yuk.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramwov.b);
    bfys.b(this.a, new ErrorMessage(paramwov.a, paramwov.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyt
 * JD-Core Version:    0.7.0.1
 */