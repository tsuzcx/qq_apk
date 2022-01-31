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

public class apyi
  implements View.OnClickListener
{
  public apyi(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    if (bakx.a(SendBottomBar.a(this.a)) == 0)
    {
      bajt.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131697863));
      this.a.c();
    }
    do
    {
      return;
      if (!apug.a()) {
        break;
      }
    } while (!bcwb.a((Activity)SendBottomBar.a(this.a), 2, new apyl(this)));
    Object localObject = new apym(this);
    String str = SendBottomBar.a(this.a).getString(2131697653);
    localObject = bbdj.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131697860), str, 2131690596, 2131698051, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((amyv.c().b.a) && (!bbxl.a().b())) {
      ((bbgu)localObject).setMessageWithoutAutoLink(amyv.c().b.a(SendBottomBar.a(this.a), str));
    }
    ((bbgu)localObject).show();
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
      if ((TextUtils.isEmpty(paramView)) || (!paramView.equals(ajsd.z))) {
        break label772;
      }
      i = 3;
    }
    label769:
    label772:
    for (;;)
    {
      long l = apel.b();
      axqy.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
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
          aptx.a(2131694544);
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
          paramView.addAll(apel.a());
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
        if ((apug.a()) && (apel.c() > apei.a()))
        {
          aptt.a(SplashActivity.sTopActivity, 2131692673, 2131692678, new apyj(this));
          return;
        }
        paramView = new ArrayList();
        paramView.addAll(apel.a());
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
          ((ArrayList)localObject).addAll(apel.a());
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
          localObject = apel.a();
          paramView = apel.b();
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
          } while ((localFileInfo.a() <= 20971520L) || (!apel.b(localFileInfo)));
          i = 1;
          if (i != 0) {
            break label769;
          }
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            localObject = (FileManagerEntity)paramView.next();
            if ((((FileManagerEntity)localObject).fileSize > 20971520L) && (apel.b((FileManagerEntity)localObject))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            apue.a("0X800942E");
            paramView = bbdj.a(SendBottomBar.a(this.a), 2131698205);
            paramView.setPositiveButton(2131720422, new apyk(this, k));
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
 * Qualified Name:     apyi
 * JD-Core Version:    0.7.0.1
 */