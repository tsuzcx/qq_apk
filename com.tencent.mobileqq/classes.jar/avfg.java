import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class avfg
  implements blop
{
  public avfg(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bloo parambloo)
  {
    switch (parambloo.a)
    {
    default: 
      return;
    case 0: 
      parambloo = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (awcc.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambloo)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambloo);
        }
        awcc.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambloo)) {
        localIntent.putExtra("big_brother_source_key", parambloo);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambloo = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambloo);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambloo = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambloo);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", anzj.a(2131706549));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfg
 * JD-Core Version:    0.7.0.1
 */