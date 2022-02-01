import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;

public class bccs
  implements sjy
{
  public bccs(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if ((localFragmentActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localFragmentActivity).b(paramString);
        if (this.a.a != null) {
          bcni.a("sub_result", "clk_hot", new String[] { paramString, bcni.a(this.a.a) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccs
 * JD-Core Version:    0.7.0.1
 */