import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import java.util.List;

public class aszg
  implements aszs
{
  public aszg(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(boolean paramBoolean1, List<atar> paramList, boolean paramBoolean2, int paramInt)
  {
    NearbyMomentFragment.a(this.a, false);
    if (paramBoolean1)
    {
      NearbyMomentFragment.b(this.a, paramBoolean2);
      if (paramBoolean2) {
        NearbyMomentFragment.a(this.a).setText(ajjy.a(2131641428));
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
 * Qualified Name:     aszg
 * JD-Core Version:    0.7.0.1
 */