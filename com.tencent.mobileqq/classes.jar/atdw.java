import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment;

class atdw
  implements CustomizedLoading
{
  atdw(atdh paramatdh) {}
  
  public void onShowLoading(Context paramContext, Bundle paramBundle, View paramView)
  {
    LoadingFragment.a(paramContext, paramBundle, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdw
 * JD-Core Version:    0.7.0.1
 */