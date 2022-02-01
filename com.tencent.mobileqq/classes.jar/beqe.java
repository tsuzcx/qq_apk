import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import java.util.List;

class beqe
  extends beql<UserState>
{
  beqe(bepx parambepx, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a((UserState)bepx.a(this.a).b());
  }
  
  public void a(UserState paramUserState)
  {
    bepx.a(this.a).b();
    if (bepx.a(this.a).a()) {
      bepx.a(this.a).d();
    }
    bepx.a(this.a).a(benq.c(bepx.a(this.a).getString(2131719891), bepx.a(this.a).a()), 0);
    bepx.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqe
 * JD-Core Version:    0.7.0.1
 */