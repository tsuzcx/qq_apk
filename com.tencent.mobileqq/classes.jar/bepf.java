import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import java.util.List;

class bepf
  extends bepm<UserState>
{
  bepf(beoy parambeoy, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a((UserState)beoy.a(this.a).b());
  }
  
  public void a(UserState paramUserState)
  {
    beoy.a(this.a).b();
    if (beoy.a(this.a).a()) {
      beoy.a(this.a).d();
    }
    beoy.a(this.a).a(bemv.c(beoy.a(this.a).getString(2131719153), beoy.a(this.a).a()), 0);
    beoy.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepf
 * JD-Core Version:    0.7.0.1
 */