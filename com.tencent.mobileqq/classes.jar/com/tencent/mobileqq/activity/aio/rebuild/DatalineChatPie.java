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
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new DatalineChatPie.9(this);
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new DatalineChatPie.7(this);
  private DatalineForwardHandler jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler;
  private DatalineOldForwardHandler jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler;
  private String d;
  
  public DatalineChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_d_of_type_JavaLangString = "3636666661";
  }
  
  private View.OnClickListener a()
  {
    return new DatalineChatPie.6(this);
  }
  
  private void a(RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext = paramRefreshMessageContext.a;
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageForDLFile)localObject).deviceType).a(((MessageForDLFile)localObject).associatedId);
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
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 51);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
    int i = PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, localIntent, localActivityURIRequest);
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
        paramPhotoListPanel = paramPhotoListPanel.a();
        if (paramPhotoListPanel != null) {
          localActivityURIRequest.extra().putSerializable("PhotoConst.editPathMap", paramPhotoListPanel);
        }
      }
      localActivityURIRequest.setRequestCode(i);
    }
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, true);
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  private boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (paramPhotoListPanel.a.isEmpty())
    {
      paramPhotoListPanel.h();
      return true;
    }
    Iterator localIterator = new ArrayList(paramPhotoListPanel.a).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
    }
    paramPhotoListPanel.h();
    return true;
  }
  
  private void aq()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("dataline_guide_check_show", false)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new DatalineChatPie.4(this, localSharedPreferences));
  }
  
  private void ar()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      Object localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559012, null);
      ((View)localObject1).getBackground().setAlpha(100);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject1, -1, -2, true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
      Object localObject2 = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(localDisplayMetrics.heightPixels);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          localObject2 = PopupWindow.class.getDeclaredField("mLayoutInScreen");
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(this.jdField_a_of_type_AndroidWidgetPopupWindow, Boolean.valueOf(true));
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
      Object localObject3 = (AsyncImageView)((View)localObject1).findViewById(2131365637);
      int i = AIOUtils.b(14.0F, a().getResources());
      ((AsyncImageView)localObject3).setCornerRadius(i, i, 0, 0);
      ((AsyncImageView)localObject3).setDefaultImage(2130844278);
      localObject3 = (TextView)((View)localObject1).findViewById(2131365610);
      localObject1 = (AsyncImageView)((View)localObject1).findViewById(2131364711);
      ((TextView)localObject3).setOnClickListener(a());
      ((AsyncImageView)localObject1).setOnClickListener(a());
      ((AsyncImageView)localObject1).setOnTouchListener(new DatalineChatPie.5(this, (AsyncImageView)localObject1));
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update();
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.c.getRootView(), 17, 0, 0);
  }
  
  private void as()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", false);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(a(), localBundle, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  protected void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  protected void P()
  {
    super.P();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
    }
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new FriendListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new DataLineUnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new DatalineHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin()))
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (localObject == null)
        {
          QLog.e("DatalineChatPie", 1, "root.getCurrentPanelView() return null!");
          return;
        }
        localObject = (PhotoListPanel)localObject;
        ((PhotoListPanel)localObject).findViewById(2131374724).setVisibility(4);
        ((PhotoListPanel)localObject).findViewById(2131374730).setVisibility(4);
        ((PhotoListPanel)localObject).findViewById(2131374725).setVisibility(4);
        ((PhotoListPanel)localObject).setCustomOnClickListener(new DatalineChatPie.1(this));
      }
    }
    else if (paramInt == 16) {
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new DatalineChatPie.2(this), 200L);
    new Handler(ThreadManagerV2.getFileThreadLooper()).postDelayed(new DatalineChatPie.3(this), 100L);
    return paramBoolean;
  }
  
  protected void aj()
  {
    super.aj();
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(null);
    this.e.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconRight("", 0);
    this.g.setOnTouchListener(null);
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  protected void e()
  {
    super.e();
    ImageView localImageView = new ImageView(a());
    localImageView.setId(2131366802);
    localImageView.setContentDescription(a().getString(2131698543));
    localImageView.setImageResource(2130844271);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131376643);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = AIOUtils.b(6.0F, a().getResources());
    localRelativeLayout.addView(localImageView, localLayoutParams);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      View localView = new View(a());
      localView.setBackgroundColor(Color.parseColor("#77000000"));
      localRelativeLayout.addView(localView, localLayoutParams);
    }
    if (ThemeUtil.isSimpleDayTheme(false)) {
      localImageView.setImageResource(2130844272);
    }
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
  }
  
  protected void h(Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramIntent.getAction()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler = new DatalineForwardHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      }
      if ((!paramIntent.getAction().equals("android.intent.action.SEND")) && (!paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))
      {
        if ((paramIntent.getAction().equals("android.intent.action.MAIN")) && (paramIntent.getBooleanExtra("system_share_multi_send", false))) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler.a(paramIntent);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler.a(paramIntent);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler = new DatalineOldForwardHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.a(paramIntent);
    }
  }
  
  protected void j()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void k()
  {
    PublicFragmentActivity.a(a(), DatalineAIOSettingFragment.class);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof RefreshMessageContext)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new DatalineChatPie.8(this, paramObject));
    }
    super.update(paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie
 * JD-Core Version:    0.7.0.1
 */