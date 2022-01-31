import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class appf
  implements bemm
{
  public appf(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(beml parambeml)
  {
    switch (parambeml.a)
    {
    default: 
      return;
    case 0: 
      parambeml = this.a.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (aqod.a())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parambeml)) {
          ((Bundle)localObject).putString("big_brother_source_key", parambeml);
        }
        aqod.b((Bundle)localObject);
        return;
      }
      localObject = "" + this.a.c;
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parambeml)) {
        localIntent.putExtra("big_brother_source_key", parambeml);
      }
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      parambeml = "" + this.a.d;
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parambeml);
      ((Intent)localObject).putExtra("reqType", 1);
      this.a.startActivity((Intent)localObject);
      return;
    }
    parambeml = "" + this.a.e;
    Object localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parambeml);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", ajjy.a(2131641885));
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appf
 * JD-Core Version:    0.7.0.1
 */