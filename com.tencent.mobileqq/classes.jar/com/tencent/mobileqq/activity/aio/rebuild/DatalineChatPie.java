package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.helper.DatalineHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.DataLineUnreadTask;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineForwardHandler;
import com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler;
import com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import cooperation.peak.PeakUtils;
import cooperation.qqdataline.QQProxyForDataline;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class DatalineChatPie
  extends FriendChatPie
{
  private String bC = "3636666661";
  private DatalineOldForwardHandler bD;
  private DatalineForwardHandler bE;
  private PopupWindow bF;
  private DataLineObserver bG = new DatalineChatPie.7(this);
  private View.OnClickListener bH = new DatalineChatPie.9(this);
  
  public DatalineChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a(RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext = paramRefreshMessageContext.b;
    if (paramRefreshMessageContext != null)
    {
      if (paramRefreshMessageContext.isEmpty()) {
        return;
      }
      paramRefreshMessageContext = paramRefreshMessageContext.iterator();
      while (paramRefreshMessageContext.hasNext())
      {
        Object localObject = (MessageRecord)paramRefreshMessageContext.next();
        if (((MessageRecord)localObject).msgtype == -3017)
        {
          localObject = (MessageForDLFile)localObject;
          this.d.getMessageFacade().d(((MessageForDLFile)localObject).deviceType).c(((MessageForDLFile)localObject).associatedId);
        }
      }
    }
  }
  
  private void a(PhotoListPanel paramPhotoListPanel, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("peakconstant.request_code", 2);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.f, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 51);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.a);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.a);
    int i = PlusPanelUtils.a(this.d, this.f, this.ah, paramArrayList, localIntent, localActivityURIRequest);
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localActivityURIRequest.extra().putInt(AlbumConstants.h, 2);
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    if (i != -1)
    {
      if (paramPhotoListPanel != null)
      {
        paramPhotoListPanel = paramPhotoListPanel.s();
        if (paramPhotoListPanel != null) {
          localActivityURIRequest.extra().putSerializable("PhotoConst.editPathMap", paramPhotoListPanel);
        }
      }
      localActivityURIRequest.setRequestCode(i);
    }
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.f, false, true);
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  private boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (paramPhotoListPanel.d.isEmpty())
    {
      paramPhotoListPanel.l();
      return true;
    }
    Iterator localIterator = new ArrayList(paramPhotoListPanel.d).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.d.getFileManagerEngine().a(str, this.ah.c, this.ah.b, this.ah.a, true);
    }
    paramPhotoListPanel.l();
    return true;
  }
  
  private void bC()
  {
    SharedPreferences localSharedPreferences = this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("dataline_guide_check_show", false)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new DatalineChatPie.4(this, localSharedPreferences));
  }
  
  private void bD()
  {
    if (this.bF == null)
    {
      Object localObject1 = LayoutInflater.from(this.e).inflate(2131624646, null);
      ((View)localObject1).getBackground().setAlpha(100);
      this.bF = new PopupWindow((View)localObject1, -1, -2, true);
      this.bF.setContentView((View)localObject1);
      this.bF.setSoftInputMode(16);
      Object localObject2 = (WindowManager)this.e.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.bF.setHeight(localDisplayMetrics.heightPixels);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          localObject2 = PopupWindow.class.getDeclaredField("mLayoutInScreen");
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(this.bF, Boolean.valueOf(true));
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
      }
      Object localObject3 = (AsyncImageView)((View)localObject1).findViewById(2131431868);
      int i = AIOUtils.b(14.0F, aX().getResources());
      ((AsyncImageView)localObject3).setCornerRadius(i, i, 0, 0);
      ((AsyncImageView)localObject3).setDefaultImage(2130845595);
      localObject3 = (TextView)((View)localObject1).findViewById(2131431841);
      localObject1 = (AsyncImageView)((View)localObject1).findViewById(2131430817);
      ((TextView)localObject3).setOnClickListener(bE());
      ((AsyncImageView)localObject1).setOnClickListener(bE());
      ((AsyncImageView)localObject1).setOnTouchListener(new DatalineChatPie.5(this, (AsyncImageView)localObject1));
    }
    this.bF.setFocusable(true);
    this.bF.setOutsideTouchable(true);
    this.bF.update();
    this.bF.showAtLocation(this.aZ.getRootView(), 17, 0, 0);
  }
  
  private View.OnClickListener bE()
  {
    return new DatalineChatPie.6(this);
  }
  
  private void bF()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", false);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(aX(), localBundle, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  public void B()
  {
    PublicFragmentActivity.a(aX(), DatalineAIOSettingFragment.class);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 4)
    {
      if (this.ah.b.equalsIgnoreCase(((IQFileConfigManager)this.d.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin()))
      {
        Object localObject = this.n.getCurrentPanelView();
        if (!(localObject instanceof PhotoListPanel))
        {
          QLog.e("DatalineChatPie", 1, "root.getCurrentPanelView() return null!");
          return;
        }
        localObject = (PhotoListPanel)localObject;
        ((PhotoListPanel)localObject).findViewById(2131442912).setVisibility(4);
        ((PhotoListPanel)localObject).findViewById(2131442918).setVisibility(4);
        ((PhotoListPanel)localObject).findViewById(2131442913).setVisibility(4);
        ((PhotoListPanel)localObject).setCustomOnClickListener(new DatalineChatPie.1(this));
      }
    }
    else if (paramInt == 16) {
      PlusPanelUtils.a(this.d, aX(), this.ah);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    this.d.getFileManagerEngine();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new DatalineChatPie.2(this), 200L);
    new Handler(ThreadManagerV2.getFileThreadLooper()).postDelayed(new DatalineChatPie.3(this), 100L);
    return paramBoolean;
  }
  
  protected void au()
  {
    super.au();
    if (this.bG != null) {
      this.d.addObserver(this.bG);
    }
  }
  
  protected void av()
  {
    super.av();
    if (this.bG != null)
    {
      this.d.removeObserver(this.bG);
      this.bG = null;
    }
  }
  
  protected HelperProvider b()
  {
    return new DatalineHelperProvider(this.f);
  }
  
  protected void bg()
  {
    super.bg();
    if (this.e != null) {
      this.C.setTextColor(this.e.getResources().getColor(2131167990));
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.C.setOnClickListener(null);
    this.C.setClickable(false);
    this.p.setTitleIconRight("", 0);
    this.H.setOnTouchListener(null);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new FriendScroller()).a(new FriendListUI(this.i)).a(new DataLineUnreadTask(this.i)).a();
  }
  
  protected void g(Intent paramIntent)
  {
    super.g(paramIntent);
  }
  
  protected void i(Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramIntent.getAction()))
    {
      if (this.bE == null) {
        this.bE = new DatalineForwardHandler(this.d, aX());
      }
      if ((!paramIntent.getAction().equals("android.intent.action.SEND")) && (!paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))
      {
        if ((paramIntent.getAction().equals("android.intent.action.MAIN")) && (paramIntent.getBooleanExtra("system_share_multi_send", false))) {
          this.bE.a(paramIntent);
        }
      }
      else {
        this.bE.a(paramIntent);
      }
    }
    else
    {
      if (this.bD == null) {
        this.bD = new DatalineOldForwardHandler(this.d, aX());
      }
      this.bD.a(paramIntent);
    }
  }
  
  protected void l()
  {
    super.l();
    ImageView localImageView = new ImageView(aX());
    localImageView.setId(2131433124);
    localImageView.setContentDescription(aX().getString(2131896489));
    localImageView.setImageResource(2130845588);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setOnClickListener(this.bH);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.z.findViewById(2131444904);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = AIOUtils.b(6.0F, aX().getResources());
    localRelativeLayout.addView(localImageView, localLayoutParams);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      View localView = new View(aX());
      localView.setBackgroundColor(Color.parseColor("#77000000"));
      localRelativeLayout.addView(localView, localLayoutParams);
    }
    if (ThemeUtil.isSimpleDayTheme(false)) {
      localImageView.setImageResource(2130845589);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof RefreshMessageContext)) {
      this.f.runOnUiThread(new DatalineChatPie.8(this, paramObject));
    }
    super.update(paramObservable, paramObject);
  }
  
  protected void z()
  {
    if (this.A != null) {
      this.A.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie
 * JD-Core Version:    0.7.0.1
 */