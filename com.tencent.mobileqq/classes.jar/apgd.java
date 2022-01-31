import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
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

public class apgd
  implements View.OnClickListener
{
  public apgd(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    if (azjg.a(SendBottomBar.a(this.a)) == 0)
    {
      azic.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131632133));
      this.a.c();
    }
    do
    {
      return;
      if (!apck.a()) {
        break;
      }
    } while (!bbrm.a((Activity)SendBottomBar.a(this.a), 2, new apgg(this)));
    Object localObject = new apgh(this);
    String str = SendBottomBar.a(this.a).getString(2131631938);
    localObject = babr.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131632130), str, 2131625035, 2131632315, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((amik.c().b.a) && (!baud.a().b())) {
      ((bafb)localObject).setMessageWithoutAutoLink(amik.c().b.a(SendBottomBar.a(this.a), str));
    }
    ((bafb)localObject).show();
    return;
    this.a.c();
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    if (SendBottomBar.a(this.a)) {}
    Object localObject;
    do
    {
      return;
      SendBottomBar.a(this.a, true);
      new Handler().postDelayed(new SendBottomBar.7.1(this), 800L);
      switch (SendBottomBar.a(this.a).b())
      {
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        if (AppNetConnInfo.isNetSupport()) {
          break;
        }
        apcb.a(2131628882);
        return;
      case 7: 
        if (SendBottomBar.a(this.a).c())
        {
          paramView = new ArrayList();
          paramView.addAll(aonm.a());
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
        if ((apck.a()) && (aonm.c() > aonj.a()))
        {
          apbx.a(SplashActivity.sTopActivity, 2131627035, 2131627040, new apge(this));
          return;
        }
        paramView = new ArrayList();
        paramView.addAll(aonm.a());
        localObject = new Intent();
        ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramView);
        SendBottomBar.a(this.a).setResult(-1, (Intent)localObject);
        SendBottomBar.a(this.a).finish();
        return;
      case 8: 
        paramView = SendBottomBar.a(this.a).getIntent();
      }
    } while (paramView == null);
    if (paramView.getStringExtra("posturl") != null)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).addAll(aonm.a());
      paramView.putParcelableArrayListExtra("fileinfo", (ArrayList)localObject);
      SendBottomBar.a(this.a).setResult(-1, paramView);
      SendBottomBar.a(this.a).finish();
      return;
    }
    SendBottomBar.a(this.a).setResult(-1, paramView);
    SendBottomBar.a(this.a).finish();
    return;
    this.a.b();
    return;
    int k = SendBottomBar.a(this.a).a();
    if (k == 1) {}
    for (int i = 1; k == 5; i = 0)
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
      localObject = aonm.a();
      paramView = aonm.b();
      localObject = ((Set)localObject).iterator();
      FileInfo localFileInfo;
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFileInfo = (FileInfo)((Iterator)localObject).next();
      } while ((localFileInfo.a() <= 20971520L) || (!aonm.b(localFileInfo)));
      i = 1;
      if (i != 0) {
        break label654;
      }
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        localObject = (FileManagerEntity)paramView.next();
        if ((((FileManagerEntity)localObject).fileSize > 20971520L) && (aonm.b((FileManagerEntity)localObject))) {
          i = 1;
        }
      }
    }
    label654:
    for (;;)
    {
      if (i != 0)
      {
        apci.a("0X800942E");
        paramView = babr.a(SendBottomBar.a(this.a), 2131632463);
        paramView.setPositiveButton(2131654515, new apgf(this, k));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */