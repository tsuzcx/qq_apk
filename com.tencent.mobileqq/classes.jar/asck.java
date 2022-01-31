import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class asck
  implements bhvu
{
  public asck(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(bhvt parambhvt)
  {
    switch (parambhvt.a)
    {
    default: 
      return;
    case 0: 
      parambhvt = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (asyy.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambhvt)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambhvt);
        }
        asyy.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambhvt)) {
        localIntent.putExtra("big_brother_source_key", parambhvt);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambhvt = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambhvt);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambhvt = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambhvt);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", alpo.a(2131708053));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asck
 * JD-Core Version:    0.7.0.1
 */