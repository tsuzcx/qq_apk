import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class aung
  implements bknm
{
  public aung(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bknl parambknl)
  {
    switch (parambknl.a)
    {
    default: 
      return;
    case 0: 
      parambknl = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (avju.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambknl)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambknl);
        }
        avju.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambknl)) {
        localIntent.putExtra("big_brother_source_key", parambknl);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambknl = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambknl);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambknl = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambknl);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", anni.a(2131706442));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aung
 * JD-Core Version:    0.7.0.1
 */