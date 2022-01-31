import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.7.1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class apyg
  implements View.OnClickListener
{
  public apyg(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    if (bakj.a(SendBottomBar.a(this.a)) == 0)
    {
      bajf.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131697853));
      this.a.c();
    }
    do
    {
      return;
      if (!apue.a()) {
        break;
      }
    } while (!bcvm.a((Activity)SendBottomBar.a(this.a), 2, new apyj(this)));
    Object localObject = new apyk(this);
    String str = SendBottomBar.a(this.a).getString(2131697652);
    localObject = bbcv.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131697850), str, 2131690596, 2131698041, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((amyo.c().b.a) && (!bbwx.a().b())) {
      ((bbgg)localObject).setMessageWithoutAutoLink(amyo.c().b.a(SendBottomBar.a(this.a), str));
    }
    ((bbgg)localObject).show();
    return;
    this.a.c();
  }
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a)) {
      return;
    }
    SendBottomBar.a(this.a, true);
    new Handler().postDelayed(new SendBottomBar.7.1(this), 800L);
    int i = 4;
    if (SendBottomBar.a(this.a).a() == 1)
    {
      i = 2;
      label60:
      paramView = SendBottomBar.a(this.a).a();
      if ((TextUtils.isEmpty(paramView)) || (!paramView.equals(ajsf.z))) {
        break label772;
      }
      i = 3;
    }
    label769:
    label772:
    for (;;)
    {
      long l = apeh.b();
      axqw.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      Object localObject;
      switch (SendBottomBar.a(this.a).b())
      {
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        if (!AppNetConnInfo.isNetSupport())
        {
          aptv.a(2131694543);
          return;
          if (SendBottomBar.a(this.a).a() != 0) {
            break label60;
          }
          i = 1;
        }
        break;
      case 7: 
        if (SendBottomBar.a(this.a).c())
        {
          paramView = new ArrayList();
          paramView.addAll(apeh.a());
          localObject = new Intent();
          ((Intent)localObject).putParcelableArrayListExtra("reslut_select_file_info_list", paramView);
          ((Intent)localObject).putExtra("approval_attachment_customid", SendBottomBar.a(this.a).f());
          SendBottomBar.a(this.a).setResult(-1, (Intent)localObject);
        }
        SendBottomBar.a(this.a).finish();
        return;
      case 1: 
        SendBottomBar.b(this.a);
        return;
      case 5: 
        if ((apue.a()) && (apeh.c() > apee.a()))
        {
          aptr.a(SplashActivity.sTopActivity, 2131692672, 2131692677, new apyh(this));
          return;
        }
        paramView = new ArrayList();
        paramView.addAll(apeh.a());
        localObject = new Intent();
        ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramView);
        SendBottomBar.a(this.a).setResult(-1, (Intent)localObject);
        SendBottomBar.a(this.a).finish();
        return;
      case 8: 
        paramView = SendBottomBar.a(this.a).getIntent();
        if (paramView == null) {
          break;
        }
        if (paramView.getStringExtra("posturl") != null)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).addAll(apeh.a());
          paramView.putParcelableArrayListExtra("fileinfo", (ArrayList)localObject);
          SendBottomBar.a(this.a).setResult(-1, paramView);
          SendBottomBar.a(this.a).finish();
          return;
        }
        SendBottomBar.a(this.a).setResult(-1, paramView);
        SendBottomBar.a(this.a).finish();
        return;
      case 9: 
        this.a.b();
        return;
        int k = SendBottomBar.a(this.a).a();
        if (k == 1) {}
        for (i = 1; k == 5; i = 0)
        {
          this.a.c();
          return;
        }
        if (i != 0)
        {
          a();
          return;
        }
        if (SendBottomBar.a(this.a).i())
        {
          localObject = apeh.a();
          paramView = apeh.b();
          int j = 0;
          localObject = ((Set)localObject).iterator();
          FileInfo localFileInfo;
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localFileInfo = (FileInfo)((Iterator)localObject).next();
          } while ((localFileInfo.a() <= 20971520L) || (!apeh.b(localFileInfo)));
          i = 1;
          if (i != 0) {
            break label769;
          }
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            localObject = (FileManagerEntity)paramView.next();
            if ((((FileManagerEntity)localObject).fileSize > 20971520L) && (apeh.b((FileManagerEntity)localObject))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            apuc.a("0X800942E");
            paramView = bbcv.a(SendBottomBar.a(this.a), 2131698195);
            paramView.setPositiveButton(2131720411, new apyi(this, k));
            paramView.show();
            return;
          }
          this.a.a(k);
          return;
          this.a.a(k);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apyg
 * JD-Core Version:    0.7.0.1
 */