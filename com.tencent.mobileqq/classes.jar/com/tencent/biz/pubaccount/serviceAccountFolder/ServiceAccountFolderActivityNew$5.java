package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.view.View;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.videostory.support.VSReporter;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;

class ServiceAccountFolderActivityNew$5
  implements ViewPager.OnPageChangeListener
{
  ServiceAccountFolderActivityNew$5(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(int paramInt)
  {
    int i = FolderBaseTabFragment.d;
    String str = "1";
    if (paramInt == i)
    {
      if (!ServiceAccountFolderActivityNew.l(this.a)) {
        str = "2";
      }
      VSReporter.b("auth_discover", "tofollow", 0, 0, new String[] { str });
      MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
      return;
    }
    if (!ServiceAccountFolderActivityNew.l(this.a)) {
      str = "2";
    }
    VSReporter.b("auth_follow", "todiscover", 0, 0, new String[] { str });
    MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    a(paramInt);
    if ((ServiceAccountFolderActivityNew.i(this.a) != null) && (ServiceAccountFolderActivityNew.i(this.a).getChildCount() > paramInt))
    {
      ServiceAccountFolderActivityNew.i(this.a).getChildAt(paramInt).performClick();
      ServiceAccountFolderActivityNew.a(this.a, false);
    }
    if (ServiceAccountFolderActivityNew.j(this.a).size() > paramInt) {
      ((FolderBaseTabFragment)ServiceAccountFolderActivityNew.j(this.a).get(paramInt)).a(this.a, paramInt);
    }
    if (ServiceAccountFolderActivityNew.k(this.a) > 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = ServiceAccountFolderActivityNew.k(this.a);
      String str;
      if (ServiceAccountFolderActivityNew.c(this.a) == FolderBaseTabFragment.d) {
        str = "auth_follow";
      } else {
        str = "auth_discover";
      }
      VSReporter.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      ServiceAccountFolderActivityNew.a(this.a, 0L);
    }
    ServiceAccountFolderActivityNew.a(this.a, System.currentTimeMillis());
    ServiceAccountFolderActivityNew.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.5
 * JD-Core Version:    0.7.0.1
 */