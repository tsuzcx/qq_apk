import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class atsg
  implements bjsz
{
  public atsg(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bjsy parambjsy)
  {
    switch (parambjsy.a)
    {
    default: 
      return;
    case 0: 
      parambjsy = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (aupc.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambjsy)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambjsy);
        }
        aupc.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambjsy)) {
        localIntent.putExtra("big_brother_source_key", parambjsy);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambjsy = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambjsy);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambjsy = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambjsy);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", amtj.a(2131706779));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsg
 * JD-Core Version:    0.7.0.1
 */