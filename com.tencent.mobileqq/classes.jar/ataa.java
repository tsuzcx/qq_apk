import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2.1;

public class ataa
  implements atao
{
  public ataa(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
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
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705786), alud.a(2131705801));
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705797) + aszu.a(l) + ")", new atac(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705799), alud.a(2131705800));
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).b();
    return;
    GroupVideoLoadingFragment.a(this.a).a();
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705798), alud.a(2131705792));
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705795), alud.a(2131705791));
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705796), new atac(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).b();
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705787), "");
    GroupVideoLoadingFragment.a(this.a).a(alud.a(2131705788), new atac(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).a(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ataa
 * JD-Core Version:    0.7.0.1
 */