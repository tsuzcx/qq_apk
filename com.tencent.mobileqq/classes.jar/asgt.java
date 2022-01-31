import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class asgt
  implements biab
{
  public asgt(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(biaa parambiaa)
  {
    switch (parambiaa.a)
    {
    default: 
      return;
    case 0: 
      parambiaa = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (atdh.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambiaa)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambiaa);
        }
        atdh.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambiaa)) {
        localIntent.putExtra("big_brother_source_key", parambiaa);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambiaa = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambiaa);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambiaa = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambiaa);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", alud.a(2131708065));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgt
 * JD-Core Version:    0.7.0.1
 */