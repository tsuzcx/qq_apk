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

public class arvt
  implements View.OnClickListener
{
  public arvt(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    if (bcnt.a(SendBottomBar.a(this.a)) == 0)
    {
      bcmp.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131698042));
      this.a.c();
    }
    do
    {
      return;
      if (!arrr.a()) {
        break;
      }
    } while (!bezm.a((Activity)SendBottomBar.a(this.a), 2, new arvw(this)));
    Object localObject = new arvx(this);
    String str = SendBottomBar.a(this.a).getString(2131697830);
    localObject = bdgm.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131698039), str, 2131690648, 2131698230, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aoul.c().b.a) && (!beav.a().b())) {
      ((bdjz)localObject).setMessageWithoutAutoLink(aoul.c().b.a(SendBottomBar.a(this.a), str));
    }
    ((bdjz)localObject).show();
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
      if ((TextUtils.isEmpty(paramView)) || (!paramView.equals(alof.z))) {
        break label772;
      }
      i = 3;
    }
    label769:
    label772:
    for (;;)
    {
      long l = arbs.b();
      azqs.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
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
          arri.a(2131694702);
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
          paramView.addAll(arbs.a());
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
        if ((arrr.a()) && (arbs.c() > arbp.a()))
        {
          arre.a(SplashActivity.sTopActivity, 2131692754, 2131692759, new arvu(this));
          return;
        }
        paramView = new ArrayList();
        paramView.addAll(arbs.a());
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
          ((ArrayList)localObject).addAll(arbs.a());
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
          localObject = arbs.a();
          paramView = arbs.b();
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
          } while ((localFileInfo.a() <= 20971520L) || (!arbs.b(localFileInfo)));
          i = 1;
          if (i != 0) {
            break label769;
          }
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            localObject = (FileManagerEntity)paramView.next();
            if ((((FileManagerEntity)localObject).fileSize > 20971520L) && (arbs.b((FileManagerEntity)localObject))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            arrp.a("0X800942E");
            paramView = bdgm.a(SendBottomBar.a(this.a), 2131698507);
            paramView.setPositiveButton(2131720972, new arvv(this, k));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvt
 * JD-Core Version:    0.7.0.1
 */