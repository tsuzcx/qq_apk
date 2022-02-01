import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.Iterator;
import java.util.List;

public class bbqx
  extends BrowserBaseView
  implements View.OnLongClickListener
{
  private int a;
  public ImageButton a;
  public RelativeLayout a;
  public bbpz a;
  public ShareActionSheet a;
  public ImageButton b;
  public ImageButton c;
  
  public bbqx(Activity paramActivity, bbpz parambbpz)
  {
    super(paramActivity, parambbpz);
    this.jdField_a_of_type_Bbpz = parambbpz;
    if ((this.jdField_a_of_type_Bbpz != null) && (this.jdField_a_of_type_Bbpz.getRecyclerView() != null))
    {
      this.mScreenWidthPx = this.jdField_a_of_type_Bbpz.getRecyclerView().getWidth();
      this.mScreenHeightPx = this.jdField_a_of_type_Bbpz.getRecyclerView().getHeight();
    }
  }
  
  private int a()
  {
    int i = 0;
    switch (bbph.a().c())
    {
    }
    for (;;)
    {
      if (bbph.a().c()) {
        i = 6;
      }
      return i;
      i = 1;
      continue;
      i = 5;
      continue;
      i = 4;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 1036) || (paramInt == 10002) || (paramInt == 10003) || (paramInt == 10004)) {
      return 3;
    }
    return 4;
  }
  
  private int a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null)) {}
    switch (paramRichMediaBrowserInfo.baseData.getType())
    {
    default: 
    case 100: 
    case 102: 
    case 101: 
      do
      {
        return 0;
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        if ((paramRichMediaBrowserInfo.b != 1) || (!paramRichMediaBrowserInfo.k)) {
          break;
        }
        return 2;
        return 2;
        paramRichMediaBrowserInfo = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
        if (paramRichMediaBrowserInfo.d == 0) {
          return 4;
        }
      } while (paramRichMediaBrowserInfo.d != 1);
      return 3;
    }
    return 5;
    return 1;
  }
  
  public void a(int paramInt)
  {
    QLog.d("AIOBrowserBaseView", 2, "TimShareTest Class Name is " + getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = this.mContext;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new bbqy(this));
    Object localObject = this.jdField_a_of_type_Bbpz.getSelectedItem();
    int j = a((RichMediaBrowserInfo)localObject);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {}
    for (int i = ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).b;; i = 0)
    {
      i = a(i);
      int k = a();
      if (paramInt == 2) {
        paramInt = 1;
      }
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", j, 0, String.valueOf(i), String.valueOf(k), String.valueOf(paramInt), "");
        return;
        if (paramInt == 1) {
          paramInt = 2;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return this.jdField_a_of_type_Bbpz.a(paramRichMediaBrowserInfo);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public boolean b()
  {
    return (!bbph.a().c()) && (bbph.a().a() != 1037) && (acnh.a(bbph.a().a()) != 1044) && (acnh.a(bbph.a().a()) != 1032) && (bbph.a().c() != 3) && (bbph.a().c() != 4) && (bbph.a().h());
  }
  
  public boolean back()
  {
    super.back();
    if (bbph.a().f())
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpz.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", bbqq.a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData));
        this.mContext.setResult(-1, localIntent);
      }
    }
    if (bbph.a().d()) {
      this.mContext.setResult(-1, this.mContext.getIntent());
    }
    return false;
  }
  
  protected void c()
  {
    if (bbph.a().c() == 2) {}
    for (int i = 1;; i = 0)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpz.getSelectedItem();
      bbqs.a(this.mContext, bbph.a().c(), bbph.a().a(), localRichMediaBrowserInfo);
      this.mContext.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      this.mContext.overridePendingTransition(2130772294, 2130772235);
      if (i == 0) {
        this.mContext.finish();
      }
      this.jdField_a_of_type_Bbpz.a.e();
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.b != null)
    {
      localImageButton = this.b;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  protected void d()
  {
    bdla.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    a(2);
  }
  
  public void d(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.c != null)
    {
      localImageButton = this.c;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void e()
  {
    ImmersionHelper localImmersionHelper = this.jdField_a_of_type_Bbpz.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBaseView", 2, "doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = " + localImmersionHelper.b + " , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = " + localImmersionHelper.c);
    }
    if (localImmersionHelper.b) {
      a(true);
    }
    if (localImmersionHelper.c) {
      this.jdField_a_of_type_Bbpz.b(true);
    }
    this.jdField_a_of_type_Bbpz.a().d();
    this.jdField_a_of_type_Bbpz.f();
    this.jdField_a_of_type_Bbpz.g();
    showContentView(true);
    b(true);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbpz.a().c();
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_Bbpz.a().b();
    this.jdField_a_of_type_Bbpz.a().a = false;
    this.jdField_a_of_type_Bbpz.a().a();
  }
  
  public void h()
  {
    e();
    g();
  }
  
  public boolean needEnterRectAnimation()
  {
    boolean bool = true;
    if (bbph.a().d() == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean needExitRectAnimation()
  {
    if (((bbph.a().d() == -3321) || (bbph.a().d() == 1)) && (!bbph.a().f())) {
      return false;
    }
    if (bbph.a().e() == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int i = localRunningAppProcessInfo.pid;; i = -2147483648) {
      return i == bbph.a().e();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    bhbz.a().a();
    if (this.jdField_a_of_type_Bbpz != null) {
      this.jdField_a_of_type_Bbpz.a().b();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    this.jdField_a_of_type_Bbpz.a();
    a(true);
    if (bbph.a().c() == 4) {
      a(false);
    }
  }
  
  public void onEnterAnimationStart()
  {
    a(false);
  }
  
  public void onExitAnimationStart()
  {
    a(false);
    showContentView(false);
  }
  
  public void onItemSelected(int paramInt)
  {
    if (!bbph.a().b())
    {
      if (!this.jdField_a_of_type_Bbpz.a()) {
        break label91;
      }
      notifyImageModelDataChanged();
    }
    label91:
    label234:
    label237:
    for (;;)
    {
      this.jdField_a_of_type_Bbpz.a().a = false;
      this.jdField_a_of_type_Bbpz.a().d();
      this.jdField_a_of_type_Bbpz.f();
      this.jdField_a_of_type_Bbpz.g();
      this.jdField_a_of_type_Bbpz.a().b();
      this.jdField_a_of_type_Bbpz.a().a();
      if (!this.isInExitAnim) {
        a(true);
      }
      return;
      int i = this.jdField_a_of_type_Bbpz.getCount();
      if (bbph.a().f())
      {
        if (i - paramInt <= 0) {
          break label234;
        }
        if (paramInt > i - 25) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if ((i == 1) || (paramInt == 0) || (this.jdField_a_of_type_Int == i)) {
          break label237;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 4, "[onItemSelected] loadMedias: mLastLoadCount=" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bbpz.getCount();
        if (RichMediaBrowserManager.getInstance().getProvider() == null) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().loadMedias(0);
        break;
        paramInt = 0;
        continue;
        if (paramInt < 25)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (this.jdField_a_of_type_Bbpz.getSelectedItem() != null)
        {
          a(3);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onKeyDown, showActionSheet");
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onKeyDown showActionSheet exception = " + paramKeyEvent.getMessage());
        return true;
      }
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    bdla.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (bbph.a().c() == 4) {
      return true;
    }
    try
    {
      a(1);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onItemLongClick, showActionSheet");
      return true;
    }
    catch (Throwable paramView)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onItemLongClick showActionSheet exception: " + paramView.getMessage());
    }
    return true;
  }
  
  public void onScrollEnd()
  {
    if (this.jdField_a_of_type_Bbpz.a(this.jdField_a_of_type_Bbpz.getCurrentPosition())) {
      this.jdField_a_of_type_Bbpz.a();
    }
    b(true);
  }
  
  public void onScrollStart()
  {
    if (this.jdField_a_of_type_Bbpz.a(this.jdField_a_of_type_Bbpz.getCurrentPosition())) {
      this.jdField_a_of_type_Bbpz.a(false);
    }
    b(false);
  }
  
  public void showContentView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbpz.showContentView(paramBoolean);
    if (paramBoolean) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqx
 * JD-Core Version:    0.7.0.1
 */