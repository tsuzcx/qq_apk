import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class aqiv
  implements bfux
{
  public aqiv(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bfuw parambfuw)
  {
    switch (parambfuw.a)
    {
    default: 
      return;
    case 0: 
      parambfuw = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (arik.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambfuw)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambfuw);
        }
        arik.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambfuw)) {
        localIntent.putExtra("big_brother_source_key", parambfuw);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambfuw = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambfuw);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambfuw = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambfuw);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", ajya.a(2131707681));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqiv
 * JD-Core Version:    0.7.0.1
 */