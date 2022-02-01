import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2.1;

public class avzx
  implements awal
{
  public avzx(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
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
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704294), anzj.a(2131704309));
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704305) + avzr.a(l) + ")", new avzz(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704307), anzj.a(2131704308));
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).b();
    return;
    GroupVideoLoadingFragment.a(this.a).a();
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704306), anzj.a(2131704300));
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704303), anzj.a(2131704299));
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704304), new avzz(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).b();
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704295), "");
    GroupVideoLoadingFragment.a(this.a).a(anzj.a(2131704296), new avzz(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).a(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzx
 * JD-Core Version:    0.7.0.1
 */