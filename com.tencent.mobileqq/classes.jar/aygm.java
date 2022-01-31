import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;

public class aygm
  implements ruy
{
  public aygm(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if ((localFragmentActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localFragmentActivity).b(paramString);
        if (this.a.a != null) {
          ayrd.a("sub_result", "clk_hot", new String[] { paramString, ayrd.a(this.a.a) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygm
 * JD-Core Version:    0.7.0.1
 */