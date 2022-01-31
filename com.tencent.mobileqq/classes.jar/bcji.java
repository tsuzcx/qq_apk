import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class bcji
  extends ViewPager.SimpleOnPageChangeListener
{
  public bcji(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    String str1;
    String str3;
    if (this.a.a != null)
    {
      if (!VisitorTroopCardFragment.a(this.a)) {
        break label85;
      }
      str1 = "grpData_admin";
      str3 = this.a.a.troopUin;
      if (!VisitorTroopCardFragment.a(this.a)) {
        break label91;
      }
    }
    label85:
    label91:
    for (String str2 = bdes.a(this.a.a);; str2 = "1")
    {
      bdes.a("Grp_set_new", str1, "slide_head", 0, 0, new String[] { str3, str2 });
      return;
      str1 = "grpData_visitor";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcji
 * JD-Core Version:    0.7.0.1
 */