import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qphone.base.util.QLog;

public class bfdl
  extends ameq
{
  public bfdl(BindGroupFragment paramBindGroupFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onBindTroopForThirdApp, isSuccess: " + paramBoolean + " bindFlag: " + paramInt + "  troopUin: " + paramLong);
    BindGroupFragment.a(this.a);
    if (paramBoolean)
    {
      BindGroupFragment.c(this.a, alud.a(2131701497));
      BindGroupFragment.a(this.a, String.valueOf(paramLong), 1);
      BindGroupFragment.a(this.a).finish();
      return;
    }
    BindGroupFragment.b(this.a, alud.a(2131701503));
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onGetOnePageTroopInfo, isSuccess: " + paramBoolean1 + " isLastPage: " + paramBoolean2);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        BindGroupFragment.a(this.a);
        if (BindGroupFragment.a(this.a) != null) {
          BindGroupFragment.a(this.a).notifyDataSetChanged();
        }
        return;
      }
      BindGroupFragment.b(this.a);
      return;
    }
    BindGroupFragment.a(this.a);
    BindGroupFragment.b(this.a, alud.a(2131701506));
  }
  
  protected void g(boolean paramBoolean, String paramString)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onGetCreateTroopTokenForThirdApp isSuccess: " + paramBoolean + " url: " + paramString);
    BindGroupFragment.a(this.a);
    if (paramBoolean)
    {
      Intent localIntent = new Intent(BindGroupFragment.a(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", bhsz.a(paramString, "gname", BindGroupFragment.c(this.a)));
      this.a.startActivity(localIntent);
      return;
    }
    BindGroupFragment.b(this.a, alud.a(2131701492));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdl
 * JD-Core Version:    0.7.0.1
 */