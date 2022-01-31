import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import java.util.List;

public class atvk
  implements atvw
{
  public atvk(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(boolean paramBoolean1, List<atwv> paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.a, false);
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.a, paramBoolean2);
      if (paramBoolean2) {
        NearbyMomentFragment.a(this.a).setText(ajyc.a(2131707213));
      }
      NearbyMomentFragment.a(this.a, paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = NearbyMomentFragment.a(this.a, paramList);
        NearbyMomentFragment.a(this.a).addAll(paramList);
        NearbyMomentFragment.a(this.a).b(paramList);
        NearbyMomentFragment.a(this.a, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvk
 * JD-Core Version:    0.7.0.1
 */