import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import java.util.List;

class bdjb
  extends bdji<UserState>
{
  bdjb(bdiu parambdiu, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a((UserState)bdiu.a(this.a).b());
  }
  
  public void a(UserState paramUserState)
  {
    bdiu.a(this.a).b();
    if (bdiu.a(this.a).a()) {
      bdiu.a(this.a).d();
    }
    bdiu.a(this.a).a(bdgn.c(bdiu.a(this.a).getString(2131719439), bdiu.a(this.a).a()), 0);
    bdiu.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */