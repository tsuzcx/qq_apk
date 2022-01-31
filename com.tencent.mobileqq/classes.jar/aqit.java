import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class aqit
  implements bfug
{
  public aqit(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bfuf parambfuf)
  {
    switch (parambfuf.a)
    {
    default: 
      return;
    case 0: 
      parambfuf = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (arii.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambfuf)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambfuf);
        }
        arii.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambfuf)) {
        localIntent.putExtra("big_brother_source_key", parambfuf);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambfuf = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambfuf);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambfuf = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambfuf);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", ajyc.a(2131707670));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqit
 * JD-Core Version:    0.7.0.1
 */