import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

class ancs
  implements View.OnClickListener
{
  ancs(ancr paramancr) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getTag() == null) {}
    Object localObject;
    EmoticonPackage localEmoticonPackage;
    int i;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)((BaseActivity)this.a.a).getAppRuntime();
        localEmoticonPackage = (EmoticonPackage)paramView.getTag();
      } while (!localEmoticonPackage.valid);
      i = ancr.a(this.a, (QQAppInterface)localObject, localEmoticonPackage);
      if (i == 0)
      {
        ancr.a(this.a, localEmoticonPackage, paramView);
        awqx.b((QQAppInterface)localObject, "CliOper", "", ((QQAppInterface)localObject).getCurrentAccountUin(), "ep_mall", "Clk_updatepkg_mine", 0, 0, localEmoticonPackage.epId, "" + localEmoticonPackage.localVersion, "" + localEmoticonPackage.latestVersion, "");
        return;
      }
      if ((i == 1) || (i == 2))
      {
        localObject = this.a;
        if (i == 1) {
          bool = true;
        }
        ancr.a((ancr)localObject, localEmoticonPackage, paramView, bool);
        return;
      }
    } while (i != 3);
    if (!badq.a(this.a.a)) {
      babr.a(this.a.a, 230).setTitle(this.a.a.getString(2131654372)).setMessage(this.a.a.getString(2131626455)).setPositiveButton(this.a.a.getString(2131653044), new ancu(this, localEmoticonPackage, paramView)).setNegativeButton(this.a.a.getString(2131653043), new anct(this)).show();
    }
    for (;;)
    {
      awqx.b((QQAppInterface)localObject, "CliOper", "", "", "ep_mall", "0X8005C14", 0, 0, "", "", "", "");
      return;
      if (badq.a(this.a.a)) {
        ancr.a(this.a, localEmoticonPackage, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ancs
 * JD-Core Version:    0.7.0.1
 */