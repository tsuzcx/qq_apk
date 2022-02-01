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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.DataLineUnreadTask;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
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
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
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
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new DatalineChatPie.7(this);
  private DatalineForwardHandler jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler;
  private DatalineOldForwardHandler jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler;
  private View.OnClickListener b = new DatalineChatPie.9(this);
  private String g;
  
  public DatalineChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_g_of_type_JavaLangString = "3636666661";
  }
  
  private View.OnClickListener a()
  {
    return new DatalineChatPie.6(this);
  }
  
  private void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext = paramRefreshMessageContext.a;
    if ((paramRefreshMessageContext == null) || (paramRefreshMessageContext.isEmpty())) {}
    for (;;)
    {
      return;
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
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent2.putExtra("peakconstant.request_code", 2);
    localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, NewPhotoListActivity.class);
    localIntent1.putExtra("enter_from", 51);
    int i = PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, localIntent2, localIntent1);
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localIntent1.putExtra(AlbumConstants.h, 2);
    localIntent1.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent1.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent1.putExtra("PhotoConst.original_button", false);
    localIntent1.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    if (i == -1) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent1);
    }
    for (;;)
    {
      AlbumUtil.anim(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, false, true);
      if (PeakUtils.a != null) {
        PeakUtils.a.b();
      }
      return;
      if (paramPhotoListPanel != null)
      {
        paramPhotoListPanel = paramPhotoListPanel.a();
        if (paramPhotoListPanel != null) {
          localIntent1.putExtra("PhotoConst.editPathMap", paramPhotoListPanel);
        }
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent1, i);
    }
  }
  
  private boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (paramPhotoListPanel.a.isEmpty())
    {
      paramPhotoListPanel.g();
      return true;
    }
    Iterator localIterator = new ArrayList(paramPhotoListPanel.a).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
    }
    paramPhotoListPanel.g();
    return true;
  }
  
  private void bj()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("dataline_guide_check_show", false)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new DatalineChatPie.4(this, localSharedPreferences));
  }
  
  private void bk()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559118, null);
      ((View)localObject1).getBackground().setAlpha(100);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject1, -1, -2, true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView((View)localObject1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setSoftInputMode(16);
      localObject2 = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(localDisplayMetrics.heightPixels);
      if (Build.VERSION.SDK_INT < 21) {}
    }
    try
    {
      localObject2 = PopupWindow.class.getDeclaredField("mLayoutInScreen");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(this.jdField_a_of_type_AndroidWidgetPopupWindow, Boolean.valueOf(true));
      localObject2 = (AsyncImageView)((View)localObject1).findViewById(2131365800);
      int i = AIOUtils.a(14.0F, a().getResources());
      ((AsyncImageView)localObject2).setCornerRadius(i, i, 0, 0);
      ((AsyncImageView)localObject2).setDefaultImage(2130844372);
      localObject2 = (TextView)((View)localObject1).findViewById(2131365773);
      localObject1 = (AsyncImageView)((View)localObject1).findViewById(2131364824);
      ((TextView)localObject2).setOnClickListener(a());
      ((AsyncImageView)localObject1).setOnClickListener(a());
      ((AsyncImageView)localObject1).setOnTouchListener(new DatalineChatPie.5(this, (AsyncImageView)localObject1));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.c.getRootView(), 17, 0, 0);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  private void bl()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", false);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(a(), localBundle, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new FriendListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new DataLineUnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i = ((Integer)paramObject).intValue();
    if (i == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin()))
      {
        paramObject = (PhotoListPanel)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        paramObject.findViewById(2131375209).setVisibility(4);
        paramObject.findViewById(2131375215).setVisibility(4);
        paramObject.findViewById(2131375210).setVisibility(4);
        paramObject.setCustomOnClickListener(new DatalineChatPie.1(this));
      }
    }
    while (i != 16) {
      return;
    }
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new DatalineChatPie.2(this), 200L);
    new Handler(ThreadManagerV2.getFileThreadLooper()).postDelayed(new DatalineChatPie.3(this), 100L);
    return paramBoolean;
  }
  
  public void aP()
  {
    super.aP();
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167030));
    }
  }
  
  public void al()
  {
    super.al();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  public void am()
  {
    super.am();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(null);
    this.e.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconRight("", 0);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnTouchListener(null);
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void f(Intent paramIntent)
  {
    super.f(paramIntent);
  }
  
  public void g()
  {
    super.g();
    ImageView localImageView = new ImageView(a());
    localImageView.setId(2131366940);
    localImageView.setContentDescription(a().getString(2131698477));
    localImageView.setImageResource(2130844365);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setOnClickListener(this.b);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131377172);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = AIOUtils.a(6.0F, a().getResources());
    localRelativeLayout.addView(localImageView, localLayoutParams);
    if (com.tencent.mobileqq.theme.ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      View localView = new View(a());
      localView.setBackgroundColor(Color.parseColor("#77000000"));
      localRelativeLayout.addView(localView, localLayoutParams);
    }
    if (com.tencent.mobileqq.vas.theme.api.ThemeUtil.b(false)) {
      localImageView.setImageResource(2130844366);
    }
  }
  
  protected void h(Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramIntent.getAction()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler = new DatalineForwardHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      }
      if ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler.a(paramIntent);
      }
      while ((!paramIntent.getAction().equals("android.intent.action.MAIN")) || (!paramIntent.getBooleanExtra("system_share_multi_send", false))) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineForwardHandler.a(paramIntent);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler = new DatalineOldForwardHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.a(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof QQMessageFacade.RefreshMessageContext)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new DatalineChatPie.8(this, paramObject));
    }
    super.update(paramObservable, paramObject);
  }
  
  public void v()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void z()
  {
    PublicFragmentActivity.a(a(), DatalineAIOSettingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie
 * JD-Core Version:    0.7.0.1
 */