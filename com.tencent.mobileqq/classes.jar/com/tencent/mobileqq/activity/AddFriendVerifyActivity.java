package com.tencent.mobileqq.activity;

import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter.Callback;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, PobingTemplateAdapter.Callback, HttpWebCgiAsyncTask.Callback
{
  public static final boolean a;
  private static int jdField_l_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new AddFriendVerifyActivity.21(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new AddFriendVerifyActivity.15(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AddFriendVerifyActivity.22(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AddFriendVerifyActivity.33(this);
  protected InputMethodManager a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  private PobingTemplateAdapter jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddFriendVerifyActivity.17(this);
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new AddFriendVerifyActivity.20(this);
  KplRoleInfo.WZRYUIinfo jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new AddFriendVerifyActivity.16(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new AddFriendVerifyActivity.19(this);
  protected QQCustomDialog a;
  private PobingDecoder.DecodeCallBack jdField_a_of_type_ComTencentMobileqqVasTrooppobingPobingDecoder$DecodeCallBack = new AddFriendVerifyActivity.28(this);
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = null;
  protected FormSwitchItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new AddFriendVerifyActivity.18(this);
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  protected String a;
  private ArrayList<EditText> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  private FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = null;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  protected String b;
  private ArrayList<PhoneContact> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  private int jdField_c_of_type_Int;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  protected boolean c;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  String jdField_d_of_type_JavaLangString;
  protected boolean d;
  private int jdField_e_of_type_Int;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 2000;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int = 1000;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = null;
  private int jdField_j_of_type_Int = 0;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString = null;
  private int jdField_k_of_type_Int = 0;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString = null;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private TextView m;
  private TextView n;
  private TextView o;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  }
  
  public AddFriendVerifyActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private String a()
  {
    Object localObject3 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentUin());
    Object localObject2 = "";
    String str = "";
    Object localObject1 = "";
    int i2 = 0;
    int i1;
    Object localObject4;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      i1 = ((Card)localObject3).shGender;
      if (((Card)localObject3).shGender == 0)
      {
        localObject1 = getString(2131693923);
        i2 = ((Card)localObject3).age;
        str = ((Card)localObject3).strProvince;
        localObject2 = ((Card)localObject3).strCity;
        i2 = ((Card)localObject3).constellation;
        localObject4 = NearbyProfileUtil.c(((Card)localObject3).constellation);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(str);
      localObject4 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject4 = "";
      }
      if ((bool) && (i2 == 0) && (i1 == -1)) {
        localObject1 = HardCodeUtil.a(2131699920);
      }
      for (;;)
      {
        return (String)localObject1 + "~";
        localObject1 = localObject2;
        if (((Card)localObject3).shGender != 1) {
          break;
        }
        localObject1 = getString(2131692330);
        break;
        if ((bool) && (i2 == 0)) {
          localObject1 = HardCodeUtil.a(2131699938);
        } else if ((bool) && (i1 == -1)) {
          localObject1 = HardCodeUtil.a(2131699935);
        } else if ((i2 == 0) && (i1 == -1)) {
          localObject1 = HardCodeUtil.a(2131699926) + str + (String)localObject4;
        } else if (i2 == 0) {
          localObject1 = HardCodeUtil.a(2131699947) + str + (String)localObject4;
        } else if (i1 == -1) {
          localObject1 = HardCodeUtil.a(2131699928) + str + (String)localObject4 + HardCodeUtil.a(2131699934) + (String)localObject2 + HardCodeUtil.a(2131699923);
        } else if (bool) {
          localObject1 = (String)localObject2 + (String)localObject3 + HardCodeUtil.a(2131699924);
        } else {
          localObject1 = HardCodeUtil.a(2131699940) + str + (String)localObject4 + HardCodeUtil.a(2131699919) + (String)localObject2 + (String)localObject3 + HardCodeUtil.a(2131699943);
        }
      }
      localObject3 = "";
      localObject2 = "";
      i1 = -1;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Int == 3090) {}
    try
    {
      ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AddFriendVerifyActivity", 1, "feedBackToGameSDK error = " + paramString);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable == null) || (this.app == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Bitmap localBitmap = ImageUtil.a(paramURLDrawable);
    if (paramURLDrawable.getStatus() == 1)
    {
      paramURLDrawable = this.app;
      paramURLDrawable = QQAppInterface.getCircleFaceBitmap(localBitmap, 50, 50);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramURLDrawable));
      return;
    }
    paramURLDrawable.setURLDrawableListener(new AddFriendVerifyActivity.12(this));
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 459	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 461	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 464	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 467	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 464	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 473	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload_2
    //   36: astore_3
    //   37: aload_0
    //   38: invokestatic 478	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)I
    //   41: istore_1
    //   42: aload_2
    //   43: astore_3
    //   44: iload_1
    //   45: ifeq +34 -> 79
    //   48: aload_2
    //   49: astore 4
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: iload_1
    //   55: i2f
    //   56: invokestatic 481	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   59: astore_0
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: ifnull +16 -> 79
    //   66: aload_0
    //   67: astore 4
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: aload 5
    //   74: invokestatic 484	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 489	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 492	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 493	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: ifnull -17 -> 87
    //   107: aload 4
    //   109: invokevirtual 489	android/graphics/Bitmap:recycle	()V
    //   112: return
    //   113: astore_0
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 489	android/graphics/Bitmap:recycle	()V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   41	14	1	i1	int
    //   21	33	2	localObject1	Object
    //   36	83	3	localObject2	Object
    //   33	75	4	localObject3	Object
    //   8	65	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   22	32	88	java/lang/OutOfMemoryError
    //   37	42	94	java/io/IOException
    //   53	60	94	java/io/IOException
    //   71	77	94	java/io/IOException
    //   37	42	113	finally
    //   53	60	113	finally
    //   71	77	113	finally
    //   98	102	113	finally
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    TroopHandler localTroopHandler = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localTroopHandler.a(paramString1, paramString2, paramInt1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, a(this.jdField_j_of_type_Int, this.jdField_i_of_type_JavaLangString, paramString2, l1, l2, paramInt2), this.jdField_j_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        paramString2 = "2";
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        TroopReportor.a(this.jdField_a_of_type_JavaLangString, 1, 0, paramInt1);
        if (!this.jdField_c_of_type_Boolean) {
          break label335;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean == true) && (!this.jdField_c_of_type_Boolean)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean == true)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      this.jdField_i_of_type_Int = 1001;
      ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e(this.jdField_f_of_type_JavaLangString);
      return;
      paramString2 = "0";
      break;
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "3";
      break;
      label335:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131696176, 0).b(getTitleBarHeight());
      e();
    }
    while (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramBoolean, true);
  }
  
  private boolean a()
  {
    int i1 = getIntent().getExtras().getInt("source_id", 3999);
    return (i1 == 3003) || (i1 == 3006) || (i1 == 3007) || (i1 == 3009) || (i1 == 3013);
  }
  
  private void b()
  {
    if (this.jdField_d_of_type_Int == 3094)
    {
      int i1 = getIntent().getIntExtra("sub_source_id", 8);
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(i1));
      localHashMap.put("to_uid", this.jdField_f_of_type_JavaLangString);
      ExpandReportUtils.a("click#data_page#send_request_all", true, -1L, -1L, localHashMap, true, true);
    }
  }
  
  private void b(int paramInt)
  {
    String str3 = HardCodeUtil.a(2131699953);
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      QLog.e("AddFriendVerifyActivity", 1, "showPayDialog, UNKOWN errorCode: " + paramInt);
      return;
    case 4002: 
      str2 = HardCodeUtil.a(2131699915);
      paramInt = 1;
      str1 = "LTMCLUB";
    case 5002: 
    case 12002: 
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
        String str4 = String.format(HardCodeUtil.a(2131699937), new Object[] { str2, str2 });
        str2 = String.format(HardCodeUtil.a(2131699941), new Object[] { str2 });
        DialogUtil.a(this, 230, str3, str4, HardCodeUtil.a(2131699952), str2, new AddFriendVerifyActivity.25(this, str1, paramInt), new AddFriendVerifyActivity.26(this)).show();
        return;
        str2 = HardCodeUtil.a(2131699922);
        paramInt = 2;
        str1 = "CJCLUBT";
        continue;
        str2 = HardCodeUtil.a(2131699921);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
    }
    QQToast.a(this, 1, HardCodeUtil.a(2131699939), 1).a();
  }
  
  private void b(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    URLDrawable localURLDrawable = VasApngFactory.a("", new VasApngFactory.Options(), paramBitmapsCache.a(2131381174));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(localURLDrawable);
    localURLDrawable = VasApngFactory.a("", new VasApngFactory.Options(), paramBitmapsCache.a(2131381169));
    this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundDrawable(localURLDrawable);
    this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(paramBitmapsCache.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(paramBitmapsCache.jdField_b_of_type_Int);
  }
  
  private boolean b()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private void c()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = l1;
    if ((l2 > 1000L) && (this.jdField_i_of_type_Int != 1001) && (!this.jdField_f_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.jdField_i_of_type_Int), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  private void d()
  {
    if (NewFriendVerificationManager.a(this.app) != null)
    {
      int i1 = getIntent().getIntExtra("friend_setting", 0);
      int i2 = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int i3 = getIntent().getIntExtra("sub_source_id", 0);
      NewFriendVerificationManager.a(this.app).a(this.jdField_f_of_type_JavaLangString, i1, i2, i3, str);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.jdField_c_of_type_Boolean = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(this.jdField_a_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean == true) {}
    for (String str = getString(2131696170);; str = getString(2131696174))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131694366, null, new AddFriendVerifyActivity.30(this, paramString));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  private void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131719037, 5);
    localActionSheet.addButton(2131719027, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new AddFriendVerifyActivity.23(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void f(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog errorStr = " + paramString);
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label94:
      String str = getString(2131718935);
      if (TextUtils.isEmpty(paramString)) {
        paramString = getString(2131718932);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, str, paramString, 2131718933, 2131718934, new AddFriendVerifyActivity.31(this), new AddFriendVerifyActivity.32(this));
        try
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
        }
        catch (Throwable paramString)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog, tips dialog show failed", paramString);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  private void g(String paramString)
  {
    runOnUiThread(new AddFriendVerifyActivity.34(this));
  }
  
  void a()
  {
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      finish();
      return;
    }
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null) {
      for (;;)
      {
        Intent localIntent2;
        try
        {
          localObject = Class.forName((String)localObject);
          localIntent2 = new Intent();
          localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject).getName()));
          if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class)))
          {
            ProfileActivity.a(this, this.jdField_f_of_type_JavaLangString, localIntent2);
            localIntent2.setFlags(67108864);
            localIntent2.putExtra("key_back_from_add_friend", true);
            startActivity(localIntent2);
            return;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "goBack | exception = ", localClassNotFoundException);
          }
          localClassNotFoundException.printStackTrace();
          setResult(-1);
          finish();
          return;
        }
        if (localClassNotFoundException.equals(NearbyPeopleProfileActivity.class))
        {
          localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_f_of_type_JavaLangString, 41));
          localIntent2.putExtra("param_mode", 3);
        }
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.jdField_f_of_type_JavaLangString);
      setResult(-1, localIntent1);
    }
    for (;;)
    {
      finish();
      return;
      a(0, "");
      setResult(-1);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2000)
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167113));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundResource(2130850777);
      int i1 = AIOUtils.a(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
      this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167033));
    }
    label276:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "select: " + paramInt + " server: " + this.jdField_g_of_type_Int);
      }
      Object localObject;
      if (this.jdField_g_of_type_Int != paramInt)
      {
        localObject = (VipInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
        if (localObject != null)
        {
          UniSetReq localUniSetReq = new UniSetReq();
          localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt, "");
          ((VipInfoHandler)localObject).a(localUniSetReq, new AddFriendVerifyActivity.PobingTemplateObserver(this, paramInt), false);
        }
      }
      else
      {
        return;
        localObject = PobingDecoder.a(PobingManager.b(paramInt));
        if (localObject == null) {
          new PobingDecoder(paramInt, TroopPobingItemView.b, this.jdField_a_of_type_ComTencentMobileqqVasTrooppobingPobingDecoder$DecodeCallBack);
        }
        for (;;)
        {
          if (!SimpleUIUtil.a()) {
            break label276;
          }
          DialogUtil.a(this, 0, HardCodeUtil.a(2131699948), HardCodeUtil.a(2131699942), null, HardCodeUtil.a(2131699917), new AddFriendVerifyActivity.27(this), null).show();
          break;
          a((PobingDecoder.BitmapsCache)localObject);
        }
      }
    }
    QLog.e("AddFriendVerifyActivity", 1, "set fail, VipInfoHandler is null");
  }
  
  void a(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyActivity.35(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      if ((paramBoolean) && ((paramObject instanceof UniGetRsp)))
      {
        paramObject = ((UniGetRsp)paramObject).uniBusinessItemList.iterator();
        while (paramObject.hasNext())
        {
          UniBusinessItem localUniBusinessItem = (UniBusinessItem)paramObject.next();
          if (localUniBusinessItem.appid == 40)
          {
            this.jdField_g_of_type_Int = localUniBusinessItem.itemid;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter.a(localUniBusinessItem.itemid);
            QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + this.jdField_g_of_type_Int);
            return;
          }
        }
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP nothing: " + this.jdField_g_of_type_Int);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + paramBoolean + " data=" + paramObject);
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)))
    {
      paramObject = (UniSetRsp)paramObject;
      if (paramObject.ret == 0)
      {
        this.jdField_g_of_type_Int = paramInt2;
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP success: " + this.jdField_g_of_type_Int);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramObject.ret + " msg:" + paramObject.errmsg);
      b(paramObject.ret);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter.a(this.jdField_g_of_type_Int);
      return;
    }
    QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramBoolean + " data=" + paramObject);
  }
  
  public void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    if (paramBitmapsCache == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AddFriendVerifyActivity.29(this, paramBitmapsCache));
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "saveVerifyMsg return from wzry");
      }
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!NetworkUtil.d(this)) {}
    int i3;
    label581:
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694510), 0).b(getTitleBarHeight());
      for (;;)
      {
        return;
        if (!isFinishing())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyActivity.13(this));
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            Intent localIntent = getIntent();
            i3 = localIntent.getIntExtra("sub_source_id", 0);
            int i2 = localIntent.getIntExtra("friend_setting", 0);
            int i1 = i2;
            if (i2 == 3) {
              i1 = 100;
            }
            boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
            String str = localIntent.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addFriendWithMyCard(this.jdField_f_of_type_JavaLangString, localIntent.getStringExtra("extra"), i1, (byte)this.jdField_c_of_type_Int, paramString1, this.jdField_d_of_type_Int, i3, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"), true);
            if (!AutoRemarkActivity.a(i1, this.jdField_d_of_type_Int, bool)) {
              ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_f_of_type_JavaLangString, true);
            }
            if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_e_of_type_JavaLangString)) {
              ReportController.b(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
            if (localIntent.getIntExtra("sort_id", 0) == 3090) {
              ReportController.b(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
            }
            if ((this.jdField_d_of_type_Int == 3050) && (this.jdField_e_of_type_Int == 3))
            {
              if ((this.jdField_b_of_type_ComTencentWidgetSwitch == null) || (!this.jdField_e_of_type_Boolean)) {
                break label581;
              }
              QCircleFollowView.a(this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_Boolean);
              paramString1 = new HashMap();
              paramString1.put("ext3", "1");
              ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
              if ((localIntent.getBooleanExtra("key_qcircle_stick", false)) && (TextUtils.isEmpty(paramString2))) {
                ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 93, 2, 0);
              }
            }
            if (this.jdField_d_of_type_Int == 3094) {
              if (i3 == 1)
              {
                ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.a(), ExtendFriendReport.a(this.app), ExtendFriendReport.c());
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("AddFriendVerifyActivity", 2, localException.toString());
                continue;
                paramString1 = new HashMap();
                paramString1.put("ext3", "2");
                ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
              }
            }
            if (i3 == 2)
            {
              ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.a(this.app), "");
              return;
            }
            if (i3 == 8)
            {
              ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_h_of_type_Int, 0, "", "", "", "");
              return;
            }
          }
        }
      }
    } while (i3 != 9);
    ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_h_of_type_Int, 0, "", "", "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramJSONObject == null);
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        paramJSONObject = (JSONObject)paramJSONObject.get("result");
        if ((paramInt != 0) || (paramJSONObject == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
        }
        paramBundle = (JSONObject)paramJSONObject.get("basics");
        Object localObject2;
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (!QLog.isColorLevel()) {
                break label767;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
              break label767;
            }
          }
        }
        paramBundle = (JSONObject)paramJSONObject.get("friendlink");
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (("add_friend".equals(localObject1)) && (i1 != 1)) {
                g(getActivity().getResources().getString(2131720180));
              }
              if (!QLog.isColorLevel()) {
                break label774;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
              break label774;
            }
          }
        }
        paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, appid =" + paramInt + "\n");
        }
        paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
        if (paramJSONObject == null) {
          break;
        }
        paramJSONObject = (JSONArray)paramJSONObject.get("datas");
        if (paramJSONObject == null) {
          break;
        }
        paramInt = 0;
        if (paramInt >= paramJSONObject.length()) {
          break;
        }
        Object localObject1 = (JSONObject)paramJSONObject.get(paramInt);
        paramBundle = (String)((JSONObject)localObject1).get("name");
        int i1 = ((Integer)((JSONObject)localObject1).get("state")).intValue();
        String str = (String)((JSONObject)localObject1).get("api");
        localObject1 = (String)((JSONObject)localObject1).get("msg");
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i1 + " api = " + str + " msg= " + (String)localObject1 + "\n");
        }
        paramInt += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramJSONObject) {}
      QLog.d("AddFriendVerifyActivity", 2, "checkApiState onResult " + paramJSONObject.toString());
      return;
      label767:
      paramInt += 1;
      continue;
      label774:
      paramInt += 1;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1397	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1398	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1400	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1401	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1403	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1404	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1408	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1414	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1420	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1424	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1427	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1431	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1436	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1400	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1401	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1440	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1443	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1446	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1431	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1436	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1400	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1401	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1448	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1449	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1451	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1452	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1456	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1463	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1467	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1471	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1420	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1475	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1476	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1431	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1436	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1478	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1479	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1483	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1484	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1486	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1487	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 11
    //   206: aload 11
    //   208: getfield 1491	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1492	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1494	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1495	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1497	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1498	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 12
    //   232: aload 12
    //   234: getfield 1501	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1506	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 12
    //   244: getfield 1509	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 12
    //   255: getfield 1512	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 12
    //   264: getfield 1516	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1520	com/dataline/util/DatalineMathUtil:a	()J
    //   270: l2i
    //   271: invokevirtual 1523	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 12
    //   276: getfield 1526	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 12
    //   286: getfield 1529	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1531	com/tencent/common/config/AppSetting:a	()I
    //   292: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1535	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 12
    //   301: invokevirtual 1536	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1535	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1501	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1506	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1538	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1539	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1543	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1544	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1543	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1547	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1506	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1543	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1551	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1554	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1556	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1557	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1561	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1562	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1564	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1565	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1568	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 10
    //   385: getstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   395: aload 10
    //   397: iload_1
    //   398: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1570	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1571	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 10
    //   410: aload 10
    //   412: getfield 1575	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1576	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 10
    //   421: getfield 1580	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1581	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 11
    //   430: getfield 1585	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 10
    //   435: invokevirtual 1586	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1588	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1589	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 13
    //   447: aload 13
    //   449: getfield 1592	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 13
    //   458: getfield 1595	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: aload_0
    //   468: getfield 240	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: invokestatic 1600	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   474: astore_2
    //   475: aload_2
    //   476: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: istore 9
    //   481: aload_2
    //   482: astore 10
    //   484: iload 9
    //   486: ifeq +51 -> 537
    //   489: aconst_null
    //   490: areturn
    //   491: astore_3
    //   492: ldc 110
    //   494: astore_2
    //   495: aload_2
    //   496: astore 10
    //   498: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +36 -> 537
    //   504: ldc_w 267
    //   507: iconst_2
    //   508: new 313	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 1602
    //   518: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_3
    //   522: invokevirtual 1605	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 1608	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_2
    //   535: astore 10
    //   537: aload 13
    //   539: getfield 1611	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   542: aload 10
    //   544: invokestatic 1414	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   547: invokevirtual 1420	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   550: new 1613	tencent/im/msg/im_imagent$ImAgentHead
    //   553: dup
    //   554: invokespecial 1614	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   557: astore_2
    //   558: aload_2
    //   559: getfield 1617	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   562: iconst_3
    //   563: invokevirtual 1554	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   566: aload_2
    //   567: getfield 1621	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   570: aload 13
    //   572: invokevirtual 1622	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   575: aload_2
    //   576: getfield 1625	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   579: aload 12
    //   581: invokevirtual 1536	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   584: aload_2
    //   585: getfield 1626	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   588: astore_3
    //   589: getstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   592: istore_1
    //   593: iload_1
    //   594: iconst_1
    //   595: iadd
    //   596: putstatic 89	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   599: aload_3
    //   600: iload_1
    //   601: invokevirtual 1460	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   604: new 1628	tencent/im/msg/im_msg$MsgSendReq
    //   607: dup
    //   608: invokespecial 1629	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   611: astore_3
    //   612: aload_3
    //   613: getfield 1632	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   616: aload 11
    //   618: invokevirtual 1633	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   621: new 1635	tencent/im/msg/im_imagent$ImAgentPackage
    //   624: dup
    //   625: invokespecial 1636	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   628: astore 10
    //   630: aload 10
    //   632: getfield 1639	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   635: aload_2
    //   636: invokevirtual 1640	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   639: aload 10
    //   641: getfield 1644	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   644: aload_3
    //   645: invokevirtual 1645	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   648: aload 10
    //   650: invokevirtual 1646	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   653: astore_2
    //   654: new 1648	java/io/ByteArrayOutputStream
    //   657: dup
    //   658: aload_2
    //   659: arraylength
    //   660: bipush 8
    //   662: iadd
    //   663: invokespecial 1650	java/io/ByteArrayOutputStream:<init>	(I)V
    //   666: astore_3
    //   667: new 1652	java/io/DataOutputStream
    //   670: dup
    //   671: aload_3
    //   672: invokespecial 1655	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   675: astore 10
    //   677: aload 10
    //   679: aload_2
    //   680: arraylength
    //   681: bipush 8
    //   683: iadd
    //   684: invokevirtual 1658	java/io/DataOutputStream:writeInt	(I)V
    //   687: aload 10
    //   689: bipush 123
    //   691: invokevirtual 1661	java/io/DataOutputStream:write	(I)V
    //   694: aload 10
    //   696: bipush 123
    //   698: invokevirtual 1661	java/io/DataOutputStream:write	(I)V
    //   701: aload 10
    //   703: aload_2
    //   704: invokevirtual 1664	java/io/DataOutputStream:write	([B)V
    //   707: aload 10
    //   709: bipush 125
    //   711: invokevirtual 1661	java/io/DataOutputStream:write	(I)V
    //   714: aload 10
    //   716: bipush 125
    //   718: invokevirtual 1661	java/io/DataOutputStream:write	(I)V
    //   721: aload_3
    //   722: invokevirtual 1665	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   725: astore 11
    //   727: new 313	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 1667
    //   737: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: astore 12
    //   742: aload 11
    //   744: ifnonnull +39 -> 783
    //   747: ldc_w 1669
    //   750: astore_2
    //   751: ldc_w 267
    //   754: iconst_1
    //   755: aload 12
    //   757: aload_2
    //   758: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 402	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: aload_3
    //   768: invokevirtual 1671	java/io/ByteArrayOutputStream:close	()V
    //   771: aload 10
    //   773: invokevirtual 1672	java/io/DataOutputStream:close	()V
    //   776: aload 11
    //   778: areturn
    //   779: astore_2
    //   780: aload 11
    //   782: areturn
    //   783: aload 11
    //   785: arraylength
    //   786: istore_1
    //   787: iload_1
    //   788: invokestatic 781	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: astore_2
    //   792: goto -41 -> 751
    //   795: astore_2
    //   796: aload_2
    //   797: invokevirtual 1673	java/lang/Exception:printStackTrace	()V
    //   800: aload_3
    //   801: invokevirtual 1671	java/io/ByteArrayOutputStream:close	()V
    //   804: aload 10
    //   806: invokevirtual 1672	java/io/DataOutputStream:close	()V
    //   809: aconst_null
    //   810: areturn
    //   811: astore_2
    //   812: aload_3
    //   813: invokevirtual 1671	java/io/ByteArrayOutputStream:close	()V
    //   816: aload 10
    //   818: invokevirtual 1672	java/io/DataOutputStream:close	()V
    //   821: aload_2
    //   822: athrow
    //   823: astore_3
    //   824: goto -3 -> 821
    //   827: astore_2
    //   828: goto -19 -> 809
    //   831: astore_3
    //   832: goto -337 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	this	AddFriendVerifyActivity
    //   0	835	1	paramInt1	int
    //   0	835	2	paramString1	String
    //   0	835	3	paramString2	String
    //   0	835	4	paramLong1	long
    //   0	835	6	paramLong2	long
    //   0	835	8	paramInt2	int
    //   479	6	9	bool	boolean
    //   38	779	10	localObject1	Object
    //   47	737	11	localObject2	Object
    //   230	526	12	localObject3	Object
    //   445	126	13	localSignature	tencent.im.msg.im_imagent.Signature
    // Exception table:
    //   from	to	target	type
    //   467	475	491	java/lang/InterruptedException
    //   767	776	779	java/lang/Exception
    //   677	742	795	java/lang/Exception
    //   751	767	795	java/lang/Exception
    //   783	787	795	java/lang/Exception
    //   677	742	811	finally
    //   751	767	811	finally
    //   783	787	811	finally
    //   796	800	811	finally
    //   812	821	823	java/lang/Exception
    //   800	809	827	java/lang/Exception
    //   475	481	831	java/lang/InterruptedException
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if (AutoRemarkActivity.a(paramEditable) > 32)
    {
      int i1 = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = AutoRemarkActivity.a(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (i1 >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693420) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  void b(String paramString)
  {
    if (!NetworkUtil.d(this)) {}
    ArrayList localArrayList;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131718552), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while (!getIntent().hasExtra("contacts"));
      localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyActivity.14(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addBatchPhoneFriend(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_d_of_type_Int, new ArrayList());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    if (!NetworkUtil.g(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 1, 2131696051, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new AddFriendVerifyActivity.24(this, paramString), 5, null, false);
  }
  
  protected void d(String paramString)
  {
    if (this.jdField_f_of_type_Int != 4) {
      this.jdField_j_of_type_AndroidWidgetTextView.setText("30");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
      return;
      int i2 = 0;
      try
      {
        i1 = paramString.getBytes("utf-8").length;
        this.jdField_j_of_type_AndroidWidgetTextView.setText(90 - i1 + "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
            i1 = i2;
          }
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doOnActivityResult, requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null)
      {
        bool1 = true;
        QLog.d("AddFriendVerifyActivity", 2, bool1);
      }
    }
    else if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    switch (paramInt1)
    {
    case 1003: 
    default: 
    case 1001: 
    case 1002: 
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          paramIntent = this.jdField_a_of_type_AndroidNetUri.getPath();
        } while (TextUtils.isEmpty(paramIntent));
        this.jdField_k_of_type_JavaLangString = paramIntent;
        a(this.jdField_k_of_type_JavaLangString);
        c(this.jdField_k_of_type_JavaLangString);
        return;
      } while (paramIntent == null);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, paramInt1));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(HardCodeUtil.a(2131699951) + AutoRemarkActivity.a(this.app, paramInt1));
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("ticket");
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        a(this.jdField_a_of_type_AndroidOsBundle.getString("msg", ""), this.jdField_a_of_type_AndroidOsBundle.getByteArray("sig"), paramIntent);
        bool1 = bool2;
        label284:
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=" + bool1);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        e(getString(2131718552));
        d();
      }
    }
    for (;;)
    {
      bool1 = false;
      break label284;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      e(getString(2131718552));
      d();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = getIntent();
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("uin");
    this.jdField_f_of_type_Int = ((Intent)localObject2).getIntExtra("k_uin_type", 1);
    if (this.jdField_f_of_type_Int != 4) {
      setTheme(2131755155);
    }
    this.jdField_h_of_type_Int = ((Intent)localObject2).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    Object localObject3;
    int i2;
    if (this.jdField_f_of_type_Int == 4)
    {
      setContentViewB(2131558478);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131381168));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381175));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381172));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381173));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131381169));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381171));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379918));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362156));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368754));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368832));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.m = ((TextView)findViewById(2131373744));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374314));
      this.n = ((TextView)findViewById(2131374316));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131374313));
      this.o = ((TextView)findViewById(2131374315));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131373306));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381174));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373742));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373743));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690857);
      this.jdField_g_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authKey");
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("authSig");
      if (this.jdField_g_of_type_JavaLangString != null) {}
      paramBundle = getIntent().getExtras().getString("nick_name");
      if (this.jdField_f_of_type_Int != 4) {
        break label3215;
      }
      setTitle(2131689670);
      localObject3 = (TextView)findViewById(2131369487);
      localObject1 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getString(2131690778);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      paramBundle = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      localObject1 = (TroopInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      this.jdField_d_of_type_JavaLangString = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        ((TroopInfoHandler)localObject1).c(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = getIntent().getExtras().getShort("group_option", (short)2);
      i1 = this.jdField_a_of_type_Int;
      localObject1 = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      i2 = getIntent().getIntExtra("stat_option", 0);
      TroopReportor.a(this.jdField_a_of_type_JavaLangString, 1, 1, i2);
      paramBundle.b(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), Long.valueOf(this.app.getCurrentUin()).longValue(), null);
      switch (i1)
      {
      case 3: 
      default: 
        label768:
        getWindow().setSoftInputMode(5);
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Int == 3)
      {
        paramBundle = ((Intent)localObject2).getStringExtra("is_from_game");
        localObject1 = ((Intent)localObject2).getStringExtra("extra");
      }
      try
      {
        localObject2 = QConfigLocalLoader.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(paramBundle)) || (((QConfLogBean)localObject2).b())) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          TroopUtils.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "AddFriend enableCheckPermission = " + ((QConfLogBean)localObject2).b());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i3;
          int i4;
          int i5;
          if (("true".equals(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            TroopUtils.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          }
          QLog.d("AddFriendVerifyActivity", 1, "AddFriend loadConfig exception = " + localException);
          continue;
          i1 = 0;
          continue;
        }
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      enableRightHighlight(true);
      if (QidianManager.b(this.app, this.jdField_f_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("webImVisitId");
      return true;
      setContentViewB(2131558477);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      this.jdField_e_of_type_Int = getIntent().getIntExtra("sub_source_id", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject2).getIntExtra("source_id", 3999);
      if (((Intent)localObject2).hasExtra("param_wzry_data")) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject2).getSerializableExtra("param_wzry_data"));
      }
      if (AutoRemarkActivity.a(this.jdField_d_of_type_Int))
      {
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        label1048:
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.jdField_e_of_type_JavaLangString + ", source id=" + this.jdField_d_of_type_Int + ", mTargetGroupId = " + this.jdField_c_of_type_Int);
        }
        if ((paramBundle == null) && (NetworkUtil.d(this)) && (AutoRemarkActivity.a(this.jdField_d_of_type_Int, this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getAutoInfo(this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Int, ((Intent)localObject2).getIntExtra("sub_source_id", 0));
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363858));
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new AddFriendVerifyActivity.1(this));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376956));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376957));
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(100, this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362334));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramBundle = getIntent().getStringExtra("key_param_age_area");
        if (!TextUtils.isEmpty(paramBundle))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372165));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362754));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373379));
        this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372288));
        this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379504));
        this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368073));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131377269));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131377228));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
        this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366449));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380395));
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_e_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_e_of_type_JavaLangString.length());
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, this.jdField_c_of_type_Int));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(HardCodeUtil.a(2131699945) + AutoRemarkActivity.a(this.app, this.jdField_c_of_type_Int));
        if (!Utils.b(this.jdField_f_of_type_JavaLangString)) {
          break label2062;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689582));
        label1629:
        if ((!EAddFriendSourceID.a(this.jdField_d_of_type_Int)) && (this.jdField_d_of_type_Int != 3016)) {
          break label2087;
        }
        i1 = 1;
        label1651:
        if (i1 == 0)
        {
          this.jdField_a_of_type_AndroidViewView = findViewById(2131376097);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376098));
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        }
        if ((this.jdField_d_of_type_Int == 3050) && (this.jdField_e_of_type_Int == 3))
        {
          if (((Intent)localObject2).getBooleanExtra("qcircle_isfollow", false)) {
            break label2092;
          }
          this.jdField_b_of_type_AndroidViewView = findViewById(2131374349);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131374350));
          this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
          paramBundle = new HashMap();
          paramBundle.put("ext3", "1");
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 1, 0, paramBundle, null, null);
          label1811:
          if (((Intent)localObject2).getBooleanExtra("key_qcircle_stick", false)) {
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 93, 1, 0);
          }
        }
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131692212));
        if (Utils.b(this.jdField_f_of_type_JavaLangString)) {
          break label2139;
        }
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718522));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131693420) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (i1 != 0) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.setFocusable(true);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717762));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
        {
          this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
          break label1048;
        }
        if ((this.jdField_d_of_type_Int != 3004) || ((this.jdField_e_of_type_Int != 5) && (this.jdField_e_of_type_Int != 6) && (this.jdField_e_of_type_Int != 7) && (this.jdField_e_of_type_Int != 8))) {
          break label1048;
        }
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("nick_name");
        break label1048;
        label2062:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689581));
        break label1629;
        label2087:
        i1 = 0;
        break label1651;
        label2092:
        paramBundle = new HashMap();
        paramBundle.put("ext3", "2");
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 1, 0, paramBundle, null, null);
        break label1811;
        label2139:
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718521));
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.m.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = 0;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)1));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(160.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_c_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_c_of_type_AndroidWidgetEditText.setHint("");
      i1 = AIOUtils.a(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        paramBundle = getString(2131697539, new Object[] { this.app.getCurrentNickname() });
        label2361:
        d(paramBundle);
        if (VasUpdateUtil.a())
        {
          ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F8", 0, 0, "", "", "", "");
          paramBundle = new GridLayoutManager(this, 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter = new PobingTemplateAdapter(this);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
          paramBundle = (VipInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
          if (paramBundle == null) {
            break label2544;
          }
          localObject1 = new UniGetReq();
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(Integer.valueOf(40));
          ((UniGetReq)localObject1).appidList = ((ArrayList)localObject3);
          paramBundle.a((UniGetReq)localObject1, new AddFriendVerifyActivity.PobingTemplateObserver(this, 0), false);
        }
      }
      for (;;)
      {
        setRightHighlightButton(2131690891, new AddFriendVerifyActivity.2(this));
        break;
        paramBundle = this.jdField_d_of_type_JavaLangString;
        break label2361;
        label2544:
        QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131717078) + ":" + (String)localObject1, 13);
      this.n.setText(paramBundle);
      this.n.setTag(this.jdField_a_of_type_JavaLangString);
      this.n.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131692037));
      }
      setRightHighlightButton(2131690891, new AddFriendVerifyActivity.3(this));
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label768;
      }
      i2 = 0;
      if (i2 >= paramBundle.mSpans.length) {
        break label768;
      }
      if (!(paramBundle.mSpans[i2] instanceof LinkSpan)) {}
      for (;;)
      {
        i2 += 1;
        break;
        localObject1 = ((LinkSpan)paramBundle.mSpans[i2]).jdField_a_of_type_JavaLangString;
        i1 = -1;
        if (Patterns.d.matcher((CharSequence)localObject1).find()) {
          i1 = 0;
        }
        if (QQTextParseLinkUtil.b.matcher((CharSequence)localObject1).find()) {
          i1 = 1;
        }
        if (!QQTextParseLinkUtil.e.matcher((CharSequence)localObject1).find()) {
          break label5476;
        }
        i1 = 2;
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + i1, "", "");
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131717078) + ":" + (String)localObject1, 13);
      this.n.setText(paramBundle);
      this.n.setTag(this.jdField_a_of_type_JavaLangString);
      this.n.setMovementMethod(LinkMovementMethod.getInstance());
      this.n.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131692037));
      }
      setRightHighlightButton(2131690891, new AddFriendVerifyActivity.4(this));
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label768;
      }
      i2 = 0;
      label3070:
      if (i2 < paramBundle.mSpans.length) {
        if ((paramBundle.mSpans[i2] instanceof LinkSpan)) {
          break label3098;
        }
      }
      for (;;)
      {
        i2 += 1;
        break label3070;
        break;
        label3098:
        localObject1 = ((LinkSpan)paramBundle.mSpans[i2]).jdField_a_of_type_JavaLangString;
        i1 = -1;
        if (Patterns.d.matcher((CharSequence)localObject1).find()) {
          i1 = 0;
        }
        if (QQTextParseLinkUtil.b.matcher((CharSequence)localObject1).find()) {
          i1 = 1;
        }
        if (!QQTextParseLinkUtil.e.matcher((CharSequence)localObject1).find()) {
          break label5473;
        }
        i1 = 2;
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_a_of_type_JavaLangString, "" + i1, "", "");
      }
      label3215:
      setTitle(2131689577);
      setLeftButton(HardCodeUtil.a(2131699916), null);
      localObject1 = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      i3 = getIntent().getExtras().getInt("source_id", 3999);
      i4 = getIntent().getIntExtra("sub_source_id", 0);
      if (EAddFriendSourceID.a(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.jdField_f_of_type_JavaLangString;
        ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
        label3332:
        addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
        if (this.jdField_f_of_type_Int != 2) {
          break label3753;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 11, this.jdField_f_of_type_JavaLangString));
        localObject3 = this.jdField_l_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(paramBundle)) {
          break label3747;
        }
        localObject1 = this.jdField_f_of_type_JavaLangString;
        label3403:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject3 = this.jdField_l_of_type_AndroidWidgetTextView;
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = this.jdField_f_of_type_JavaLangString;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
        }
        label3445:
        i5 = ((Intent)localObject2).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
      }
      switch (i5)
      {
      default: 
        break;
      case 0: 
      case 2: 
        if ((i3 == 3078) || (i3 == 3079))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689565));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689583));
          }
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (getIntent() != null) {}
          for (i1 = getIntent().getIntExtra("contact_from_type", 1);; i1 = 1)
          {
            setRightHighlightButton(2131690891, new AddFriendVerifyActivity.6(this, i1));
            paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
            paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
            break;
            ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            break label3332;
            localObject1 = paramBundle;
            break label3403;
            if (this.jdField_f_of_type_Int == 3)
            {
              localObject1 = ((Intent)localObject2).getStringExtra("extra");
              localObject1 = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.jdField_f_of_type_JavaLangString, (String)localObject1), URLDrawable.URLDrawableOptions.obtain());
              if (QQTheme.e()) {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              }
              for (;;)
              {
                this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
                if (AppSetting.jdField_d_of_type_Boolean) {
                  this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
                }
                ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).infoOpenId(this.jdField_f_of_type_JavaLangString, getIntent().getStringExtra("extra"));
                break;
                a((URLDrawable)localObject1);
              }
            }
            if ((i3 == 3007) || (i3 == 2007) || (i3 == 4007) || (i3 == 3019) || (i3 == 2019)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_f_of_type_JavaLangString, true));
            }
            for (;;)
            {
              if (!a()) {
                break label3987;
              }
              if (paramBundle == null) {
                break;
              }
              this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
              if (!AppSetting.jdField_d_of_type_Boolean) {
                break;
              }
              this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
              break;
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_f_of_type_JavaLangString));
            }
            ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
            break label3445;
          }
        }
        setRightHighlightButton(2131690891, new AddFriendVerifyActivity.7(this, i3, i4));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
        paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        a(i3, i5);
        break;
      case 1: 
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689583));
        }
        setRightHighlightButton(2131690891, new AddFriendVerifyActivity.8(this, i3, i4, i5));
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
        paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        break;
      case 3: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379106);
        localObject3 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369160);
        this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject3);
        ((EditText)localObject3).addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
        ((TextView)localObject1).setText(getString(2131717078) + ":" + paramBundle);
        ((EditText)localObject3).setSingleLine(true);
        if (jdField_a_of_type_Boolean)
        {
          ((TextView)localObject1).setContentDescription(getString(2131717078) + ":" + paramBundle);
          ((EditText)localObject3).setContentDescription(getString(2131689580));
        }
        setRightHighlightButton(2131690891, new AddFriendVerifyActivity.9(this, (EditText)localObject3, i5, i3, i4));
        getWindow().setSoftInputMode(5);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        break;
      case 4: 
        label3747:
        label3753:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        label3987:
        localObject3 = new StringBuffer();
        if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
          break label5468;
        }
        i1 = 1;
        i2 = 0;
        if (i2 < ((ArrayList)localObject1).size())
        {
          switch (i2)
          {
          default: 
            paramBundle = getResources().getString(2131717078);
          }
          for (;;)
          {
            Object localObject6 = getLayoutInflater().inflate(2131561033, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            Object localObject4 = getLayoutInflater().inflate(2131561032, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (i2 > 0)
            {
              localObject5 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
              if (localObject5 != null)
              {
                ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)DisplayUtils.a(getApplication(), 19.0F));
                ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject6);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
            Object localObject5 = (String)((ArrayList)localObject1).get(i2);
            localObject6 = (TextView)((View)localObject6).findViewById(2131379106);
            ((TextView)localObject6).setText(paramBundle + (String)localObject5);
            localObject4 = (EditText)((View)localObject4).findViewById(2131369160);
            ((EditText)localObject4).addTextChangedListener(new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject4));
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            if (jdField_a_of_type_Boolean)
            {
              ((TextView)localObject6).setContentDescription(paramBundle + (String)localObject5);
              ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).setContentDescription(getString(2131689580));
            }
            int i6 = i2 + 1;
            ((StringBuffer)localObject3).append(getString(2131717078) + i6 + ":" + (String)localObject5);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131690098) + ":${answer}");
            if (i6 != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            i2 += 1;
            break;
            if (i1 != 0)
            {
              paramBundle = getResources().getString(2131717079);
            }
            else
            {
              paramBundle = getResources().getString(2131717080);
              continue;
              paramBundle = getResources().getString(2131717081);
              continue;
              paramBundle = getResources().getString(2131717082);
              continue;
              paramBundle = getResources().getString(2131717083);
              continue;
              paramBundle = getResources().getString(2131717084);
            }
          }
        }
        setRightHighlightButton(2131690891, new AddFriendVerifyActivity.10(this, (StringBuffer)localObject3, i3, i4, i5));
        findViewById(2131377273).setOnTouchListener(new AddFriendVerifyActivity.11(this));
        getWindow().setSoftInputMode(4);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
        paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i3), String.valueOf(i4), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + i3 + " subSourceId = " + i4);
        }
        break;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      for (;;)
      {
        super.doOnDestroy();
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_k_of_type_JavaLangString = ((String)paramIntent.get(0));
      c(this.jdField_k_of_type_JavaLangString);
    }
  }
  
  public void doOnResume()
  {
    int i1 = 1;
    int i2 = 0;
    super.doOnResume();
    if (this.jdField_f_of_type_Int != 4) {}
    String str1;
    Object localObject2;
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_d_of_type_Int != 3078) && (this.jdField_d_of_type_Int != 3079));
      str1 = a(false);
      localObject2 = getString(2131692035);
      if (TextUtils.isEmpty(str1)) {
        if (!b()) {
          str1 = (String)localObject2 + ContactUtils.a(this.app, this.app.getAccount());
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
      if (i1 != 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject2).length(), str1.length());
        for (;;)
        {
          label168:
          getWindow().setSoftInputMode(5);
          return;
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str1.length());
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label168;
      }
      String str4 = getString(2131692035);
      String str2;
      if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
      {
        localObject2 = str4 + getString(2131698336) + " " + ContactUtils.a(this.app, this.app.getAccount());
        this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689583));
        }
        if (this.jdField_f_of_type_Int != 3) {
          break label492;
        }
        str2 = getIntent().getStringExtra("msg");
        i1 = 1;
      }
      for (;;)
      {
        label358:
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
          str3 = a(false);
        }
        if (TextUtils.isEmpty(str3)) {}
        for (;;)
        {
          if ((i1 != 0) && (str4.equals(localObject2)) && (!b())) {
            str2 = (String)localObject2 + ContactUtils.a(this.app, this.app.getAccount());
          }
          for (i1 = 1;; i1 = i2)
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setText(str2);
              if (i1 != 0) {}
              try
              {
                this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str4.length(), str2.length());
                for (;;)
                {
                  label467:
                  getWindow().setSoftInputMode(5);
                  return;
                  this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
                  localObject2 = str4;
                  break;
                  label492:
                  if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) {
                    break label557;
                  }
                  str2 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg;
                  if (TextUtils.isEmpty(str2)) {
                    break label552;
                  }
                  i1 = 0;
                  break label358;
                  this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str2.length());
                }
              }
              catch (Throwable localThrowable2)
              {
                break label467;
              }
            }
            localObject1 = localObject2;
          }
          localObject2 = str3;
        }
        label552:
        i1 = 1;
        continue;
        label557:
        localObject1 = null;
        i1 = 1;
      }
      i1 = 0;
      Object localObject1 = localObject2;
      continue;
      i1 = 0;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
    localIntent.setPackage(getPackageName());
    localIntent.putExtra("ret_action", this.jdField_i_of_type_Int);
    sendBroadcast(localIntent);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.jdField_f_of_type_Int != 4) {
      overridePendingTransition(0, 2130772003);
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = true;
    d();
    Object localObject;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      return super.onBackEvent();
    }
    if (this.jdField_f_of_type_Int != 4)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 != this.jdField_f_of_type_Int) {
        break label177;
      }
    }
    for (;;)
    {
      a((String)localObject, bool);
      if ((getString(2131692035).equals(localObject)) && (!b())) {
        c();
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        ReportController.b(this.app, "dc00899", "Qidian", this.jdField_f_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
      }
      return super.onBackEvent();
      label177:
      bool = false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, 1, 2131694459, 0).b(getTitleBarHeight());
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean)
        {
          bool1 = true;
          ((Switch)localObject).setChecked(bool1);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
        }
      }
      else if (this.jdField_b_of_type_ComTencentWidgetSwitch != null)
      {
        localObject = this.jdField_b_of_type_ComTencentWidgetSwitch;
        if (paramBoolean) {
          break label108;
        }
        bool1 = bool2;
        label80:
        ((Switch)localObject).setChecked(bool1);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
      label108:
      bool1 = false;
      break label80;
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this);
      }
      if (this.jdField_b_of_type_ComTencentWidgetSwitch != null) {
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnClickListener(this);
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717762));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.jdField_e_of_type_JavaLangString = "QQ空间";
        localPluginParams.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.getQZonePluginName();
        localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localPluginParams.jdField_f_of_type_JavaLangString = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        IPluginManager.b(this.app.getApp(), localPluginParams);
        ReportController.b(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramCompoundButton.getTag();
        if ((localObject instanceof Integer)) {
          break label359;
        }
        break;
        if (paramCompoundButton == this.jdField_b_of_type_ComTencentWidgetSwitch) {
          this.jdField_e_of_type_Boolean = paramBoolean;
        }
      }
      label359:
      if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) == null) || (this.jdField_a_of_type_JavaLangString != null)) {
        switch (((Integer)localObject).intValue())
        {
        default: 
          break;
        case 1: 
          a(paramBoolean);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
      localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult(localIntent, 1002);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131369160) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */