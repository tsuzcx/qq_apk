import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraperV2InOtherProcess.1;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

public class biih
  extends biic
{
  String a()
  {
    return "KC.KCWraper.Other";
  }
  
  void a(ViewGroup paramViewGroup)
  {
    a("can not call bindActivationView");
  }
  
  void a(biin parambiin, boolean paramBoolean)
  {
    a("queryKingCard : from cache");
    Pair localPair = a();
    if (parambiin != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraperV2InOtherProcess.1(this, parambiin, localPair));
      }
    }
    else {
      return;
    }
    parambiin.a(true, ((Boolean)localPair.first).booleanValue(), ((Integer)localPair.second).intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biih
 * JD-Core Version:    0.7.0.1
 */