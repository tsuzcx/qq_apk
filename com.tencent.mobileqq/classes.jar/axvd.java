import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
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
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.util.Iterator;
import java.util.List;

public class axvd
  extends BrowserBaseView
{
  private int a;
  public ImageButton a;
  public axug a;
  public ShareActionSheet a;
  public ImageButton b;
  public ImageButton c;
  
  public axvd(Activity paramActivity, axug paramaxug)
  {
    super(paramActivity, paramaxug);
    this.jdField_a_of_type_Axug = paramaxug;
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
    return this.jdField_a_of_type_Axug.a(paramRichMediaBrowserInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
  }
  
  public void b(boolean paramBoolean)
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
  
  public boolean b()
  {
    return (!axtu.a().c()) && (axtu.a().a() != 1037) && (abot.a(axtu.a().a()) != 1044) && (abot.a(axtu.a().a()) != 1032) && (axtu.a().c() != 3) && (axtu.a().c() != 4) && (axtu.a().h());
  }
  
  public boolean back()
  {
    super.back();
    if (axtu.a().f())
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axug.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", axuw.a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData));
        this.mContext.setResult(-1, localIntent);
      }
    }
    if (axtu.a().d()) {
      this.mContext.setResult(-1, this.mContext.getIntent());
    }
    return false;
  }
  
  protected void c()
  {
    if (axtu.a().c() == 2) {}
    for (int i = 1;; i = 0)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axug.getSelectedItem();
      axuy.a(this.mContext, axtu.a().c(), axtu.a().a(), localRichMediaBrowserInfo);
      this.mContext.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      this.mContext.overridePendingTransition(2130772287, 2130772228);
      if (i == 0) {
        this.mContext.finish();
      }
      this.jdField_a_of_type_Axug.a.e();
      return;
    }
  }
  
  public void c(boolean paramBoolean)
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
  
  protected void d()
  {
    azmj.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    showActionSheet(2);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axug.a().c();
  }
  
  public void e()
  {
    ImmersionHelper localImmersionHelper = this.jdField_a_of_type_Axug.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBaseView", 2, "doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = " + localImmersionHelper.b + " , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = " + localImmersionHelper.c);
    }
    if (localImmersionHelper.b) {
      a(true);
    }
    if (localImmersionHelper.c) {
      this.jdField_a_of_type_Axug.b(true);
    }
    this.jdField_a_of_type_Axug.a().d();
    this.jdField_a_of_type_Axug.e();
    showContentView(true);
  }
  
  public void f() {}
  
  public boolean needEnterRectAnimation()
  {
    boolean bool = true;
    if (axtu.a().d() == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean needExitRectAnimation()
  {
    if (((axtu.a().d() == -3321) || (axtu.a().d() == 1)) && (!axtu.a().f())) {
      return false;
    }
    if (axtu.a().e() == -2147483648) {
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
      return i == axtu.a().e();
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
    bdan.a().a();
    if (this.jdField_a_of_type_Axug != null) {
      this.jdField_a_of_type_Axug.a().b();
    }
    if (this.contentView != null) {
      this.contentView.removeAllViews();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    this.jdField_a_of_type_Axug.a();
    a(true);
    if (axtu.a().c() == 4) {
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
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    azmj.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (axtu.a().c() == 4) {
      return true;
    }
    try
    {
      showActionSheet(1);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onItemLongClick, showActionSheet");
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onItemLongClick showActionSheet exception: " + paramAdapterView.getMessage());
      }
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!axtu.a().b())
    {
      if (!this.jdField_a_of_type_Axug.a()) {
        break label116;
      }
      notifyImageModelDataChanged();
    }
    label264:
    label267:
    for (;;)
    {
      if (this.jdField_a_of_type_Axug.getGallery() != null)
      {
        this.jdField_a_of_type_Axug.getGallery().enableDoubleTap(true);
        this.jdField_a_of_type_Axug.getGallery().enableScaleGesture(true);
      }
      this.jdField_a_of_type_Axug.a().a = false;
      this.jdField_a_of_type_Axug.a().d();
      this.jdField_a_of_type_Axug.e();
      this.jdField_a_of_type_Axug.a().b();
      this.jdField_a_of_type_Axug.a().a();
      if (!this.isInExitAnim) {
        a(true);
      }
      return;
      label116:
      int i = this.jdField_a_of_type_Axug.getCount();
      if (axtu.a().f())
      {
        if (i - paramInt <= 0) {
          break label264;
        }
        if (paramInt > i - 25) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        if ((i == 1) || (paramInt == 0) || (this.jdField_a_of_type_Int == i)) {
          break label267;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 4, "[onItemSelected] loadMedias: mLastLoadCount=" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Axug.getCount();
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
        if (this.jdField_a_of_type_Axug.getSelectedItem() != null)
        {
          showActionSheet(3);
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
  
  public void onScrollEnd(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_Axug.getCurrentPosition()) && (this.jdField_a_of_type_Axug.a(paramInt))) {
      this.jdField_a_of_type_Axug.a();
    }
  }
  
  public void onScrollStart(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_Axug.getCurrentPosition()) && (this.jdField_a_of_type_Axug.a(paramInt))) {
      this.jdField_a_of_type_Axug.a(false);
    }
  }
  
  public void showActionSheet(int paramInt)
  {
    int m = 4;
    QLog.d("AIOBrowserBaseView", 2, "TimShareTest Class Name is " + getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject1 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject1).context = this.mContext;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(this.mContext.getString(2131693003));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new axve(this));
    Object localObject1 = this.jdField_a_of_type_Axug.getSelectedItem();
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null)) {}
    int i;
    switch (((RichMediaBrowserInfo)localObject1).baseData.getType())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      label178:
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null)) {}
      for (int j = ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject1).baseData).b;; j = 0)
      {
        int k;
        if (j == 0)
        {
          k = 1;
          label210:
          j = m;
          switch (axtu.a().c())
          {
          default: 
            j = 0;
          case 3: 
            label246:
            if (axtu.a().c()) {
              j = 6;
            }
            break;
          }
        }
        for (;;)
        {
          if (paramInt == 2) {
            paramInt = 1;
          }
          for (;;)
          {
            azmj.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i, 0, String.valueOf(k), String.valueOf(j), String.valueOf(paramInt), "");
            return;
            Object localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
            if ((((AIOPictureData)localObject2).b != 1) || (!((AIOPictureData)localObject2).k)) {
              break label540;
            }
            i = 2;
            break label178;
            i = 2;
            break label178;
            localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
            if (((AIOVideoData)localObject2).d == 0)
            {
              i = 4;
              break label178;
            }
            if (((AIOVideoData)localObject2).d != 1) {
              break;
            }
            i = 3;
            break label178;
            i = 5;
            break label178;
            if (j == 1)
            {
              k = 2;
              break label210;
            }
            if ((j == 1004) || (j == 1008) || (j == 1009) || (j == 1010) || (j == 1011) || (j == 1020) || (j == 1021) || (j == 1022) || (j == 1023) || (j == 1024) || (j == 1025) || (j == 1036) || (j == 10002) || (j == 10003) || (j == 10004))
            {
              k = 3;
              break label210;
            }
            k = 4;
            break label210;
            j = 1;
            break label246;
            j = 5;
            break label246;
            if (paramInt == 1) {
              paramInt = 2;
            } else {
              paramInt = 0;
            }
          }
        }
      }
      label540:
      i = 1;
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axug.showContentView(paramBoolean);
    if (paramBoolean) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvd
 * JD-Core Version:    0.7.0.1
 */