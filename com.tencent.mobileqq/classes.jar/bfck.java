import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bfck
  extends bfqu
{
  public bfck(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlAppDetailsActivity", 2, "onDelApp: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = alud.a(2131701188) + AuthorityControlAppDetailsFragment.a(this.a).b() + alud.a(2131701186);
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 2, (CharSequence)localObject, 0).a();
      localObject = new Intent();
      if ((paramList != null) && (paramList.size() == 1))
      {
        ((Intent)localObject).putExtra("KEY_DELETED_INFO", (Parcelable)paramList.get(0));
        AuthorityControlAppDetailsFragment.a(this.a).setResult(-1, (Intent)localObject);
      }
      AuthorityControlAppDetailsFragment.a(this.a).finish();
      localObject = AuthorityControlAppDetailsFragment.a(this.a);
      if (!paramBoolean) {
        break label236;
      }
    }
    label236:
    for (paramList = "0";; paramList = "1")
    {
      azqs.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009E1C", "0X8009E1C", 0, 0, paramList, "", String.valueOf(AuthorityControlAppDetailsFragment.a(this.a).a()), "");
      return;
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 1, alud.a(2131701187), 0).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfck
 * JD-Core Version:    0.7.0.1
 */