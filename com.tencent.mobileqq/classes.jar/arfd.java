import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2.1;

public class arfd
  implements arfr
{
  public arfd(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    do
    {
      return;
      GroupVideoLoadingFragment.a(this.a, paramInt);
      switch (paramInt)
      {
      case 4: 
      case 8: 
      default: 
        return;
      }
    } while (!GroupVideoLoadingFragment.a(this.a));
    long l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705402), ajya.a(2131705417));
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705413) + arex.a(l) + ")", new arff(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705415), ajya.a(2131705416));
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).b();
    return;
    GroupVideoLoadingFragment.a(this.a).a();
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705414), ajya.a(2131705408));
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705411), ajya.a(2131705407));
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705412), new arff(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).b();
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705403), "");
    GroupVideoLoadingFragment.a(this.a).a(ajya.a(2131705404), new arff(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).a(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfd
 * JD-Core Version:    0.7.0.1
 */