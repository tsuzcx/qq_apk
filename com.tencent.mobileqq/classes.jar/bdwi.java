import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraperV2InOtherProcess.1;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

public class bdwi
  extends bdwd
{
  String a()
  {
    return "KC.KCWraper.Other";
  }
  
  void a(ViewGroup paramViewGroup)
  {
    a("can not call bindActivationView");
  }
  
  void a(bdwn parambdwn, boolean paramBoolean)
  {
    a("queryKingCard : from cache");
    Pair localPair = a();
    if (parambdwn != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraperV2InOtherProcess.1(this, parambdwn, localPair));
      }
    }
    else {
      return;
    }
    parambdwn.a(true, ((Boolean)localPair.first).booleanValue(), ((Integer)localPair.second).intValue());
  }
  
  void a(Runnable paramRunnable)
  {
    a("tryLoad : do nothing");
  }
  
  boolean a()
  {
    a("isReady : do nothing");
    return true;
  }
  
  boolean a(Activity paramActivity)
  {
    if (c())
    {
      PublicFragmentActivity.a(paramActivity, KingCardActivationFragment.class);
      return true;
    }
    return false;
  }
  
  boolean b()
  {
    boolean bool = c();
    a("supportActivationView = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwi
 * JD-Core Version:    0.7.0.1
 */