import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import com.tencent.mobileqq.together.writetogether.statemachine.UserStateMachineController.1.1;
import java.util.List;

public class bepy
  extends beql<UserState>
{
  bepy(bepx parambepx, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    paramUserState = this.a;
    if (!benq.a(bepx.a(this.a))) {}
    for (boolean bool = true;; bool = false)
    {
      bepx.a(paramUserState, bool);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new UserStateMachineController.1.1(this), 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepy
 * JD-Core Version:    0.7.0.1
 */