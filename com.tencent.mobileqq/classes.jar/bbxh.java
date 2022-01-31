import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraperV2InOtherProcess.1;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

public class bbxh
  extends bbxc
{
  String a()
  {
    return "KC.KCWraper.Other";
  }
  
  void a(ViewGroup paramViewGroup)
  {
    a("can not call bindActivationView");
  }
  
  void a(bbxm parambbxm, boolean paramBoolean)
  {
    a("queryKingCard : from cache");
    Pair localPair = a();
    if (parambbxm != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraperV2InOtherProcess.1(this, parambbxm, localPair));
      }
    }
    else {
      return;
    }
    parambbxm.a(true, ((Boolean)localPair.first).booleanValue(), ((Integer)localPair.second).intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxh
 * JD-Core Version:    0.7.0.1
 */