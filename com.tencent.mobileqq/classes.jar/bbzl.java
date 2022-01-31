import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment;
import java.util.ArrayList;

public class bbzl
  implements View.OnClickListener
{
  public bbzl(HomeWorkTroopSelectorFragment paramHomeWorkTroopSelectorFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (HomeWorkTroopSelectorFragment.a(this.a) != null)
    {
      int j = HomeWorkTroopSelectorFragment.a(this.a).getCount();
      int i = 0;
      while (i < j)
      {
        localObject = (bbzq)HomeWorkTroopSelectorFragment.a(this.a).getItem(i);
        if ((((Boolean)((bbzq)localObject).b).booleanValue()) && (!HomeWorkTroopSelectorFragment.a(this.a).equals(((TroopInfo)((bbzq)localObject).a).troopuin)))
        {
          paramView.add(((TroopInfo)((bbzq)localObject).a).troopname);
          localArrayList.add(((TroopInfo)((bbzq)localObject).a).troopuin);
        }
        i += 1;
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key", localArrayList);
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key", paramView);
    this.a.getActivity().setResult(262, (Intent)localObject);
    this.a.getActivity().doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzl
 * JD-Core Version:    0.7.0.1
 */