import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class auxg
  implements blel
{
  public auxg(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(blek paramblek)
  {
    switch (paramblek.a)
    {
    default: 
      return;
    case 0: 
      paramblek = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (avux.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(paramblek)) {
          ((Bundle)localObject).putString("big_brother_source_key", paramblek);
        }
        avux.c((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(paramblek)) {
        localIntent.putExtra("big_brother_source_key", paramblek);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      paramblek = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramblek);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    paramblek = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramblek);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", anvx.a(2131707125));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxg
 * JD-Core Version:    0.7.0.1
 */