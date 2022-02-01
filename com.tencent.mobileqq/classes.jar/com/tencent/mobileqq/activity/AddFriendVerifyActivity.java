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
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
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
import mqq.app.AppRuntime;
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
  Handler jdField_a_of_type_AndroidOsHandler = new AddFriendVerifyActivity.22(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new AddFriendVerifyActivity.15(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AddFriendVerifyActivity.23(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AddFriendVerifyActivity.34(this);
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
  KplRoleInfo.WZRYUIinfo jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AddFriendVerifyActivity.17(this);
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new AddFriendVerifyActivity.16(this);
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new AddFriendVerifyActivity.20(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new AddFriendVerifyActivity.19(this);
  private TroopShowExternalObserver jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver = new AddFriendVerifyActivity.21(this);
  protected QQCustomDialog a;
  private PobingDecoder.DecodeCallBack jdField_a_of_type_ComTencentMobileqqVasTrooppobingPobingDecoder$DecodeCallBack = new AddFriendVerifyActivity.29(this);
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
    Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentUin());
    String str = "";
    int i1;
    Object localObject1;
    int i2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      i1 = ((Card)localObject2).shGender;
      if (((Card)localObject2).shGender == 0) {
        localObject1 = getString(2131693879);
      } else if (((Card)localObject2).shGender == 1) {
        localObject1 = getString(2131692259);
      } else {
        localObject1 = "";
      }
      i2 = ((Card)localObject2).age;
      localObject3 = ((Card)localObject2).strProvince;
      localObject5 = ((Card)localObject2).strCity;
      i2 = ((Card)localObject2).constellation;
      localObject2 = NearbyProfileUtil.c(((Card)localObject2).constellation);
      localObject4 = localObject1;
      localObject1 = localObject5;
    }
    else
    {
      i2 = 0;
      localObject5 = "";
      localObject2 = localObject5;
      localObject3 = localObject2;
      localObject1 = localObject3;
      i1 = -1;
      localObject4 = localObject2;
      localObject2 = localObject5;
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = str;
    }
    if ((bool) && (i2 == 0) && (i1 == -1))
    {
      localObject1 = HardCodeUtil.a(2131700061);
    }
    else if ((bool) && (i2 == 0))
    {
      localObject1 = HardCodeUtil.a(2131700079);
    }
    else if ((bool) && (i1 == -1))
    {
      localObject1 = HardCodeUtil.a(2131700076);
    }
    else if ((i2 == 0) && (i1 == -1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700067));
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (i2 == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700088));
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (i1 == -1)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131700069));
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131700075));
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131700064));
      localObject1 = ((StringBuilder)localObject4).toString();
    }
    else if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append((String)localObject4);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131700065));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131700081));
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131700060));
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append((String)localObject4);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131700084));
      localObject1 = ((StringBuilder)localObject5).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("~");
    return ((StringBuilder)localObject2).toString();
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.app.getAccount());
      return localSharedPreferences.getString(localStringBuilder.toString(), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.app.getAccount());
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Int == 3090) {
      try
      {
        ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("feedBackToGameSDK error = ");
        localStringBuilder.append(paramString);
        QLog.e("AddFriendVerifyActivity", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.app != null))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
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
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 465	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 470	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 473	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 470	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 479	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: astore_3
    //   39: ldc_w 481
    //   42: invokestatic 487	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   45: checkcast 481	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   48: aload_0
    //   49: invokeinterface 491 2 0
    //   54: istore_1
    //   55: aload 4
    //   57: astore_2
    //   58: iload_1
    //   59: ifeq +35 -> 94
    //   62: aload 4
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload 4
    //   70: iload_1
    //   71: i2f
    //   72: invokestatic 494	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   75: astore_0
    //   76: aload_0
    //   77: astore_2
    //   78: aload_0
    //   79: ifnull +15 -> 94
    //   82: aload_0
    //   83: astore_2
    //   84: aload_0
    //   85: astore_3
    //   86: aload_0
    //   87: aload 5
    //   89: invokestatic 497	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   92: aload_0
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 502	android/graphics/Bitmap:recycle	()V
    //   102: return
    //   103: astore_0
    //   104: goto +19 -> 123
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: aload_0
    //   111: invokevirtual 505	java/io/IOException:printStackTrace	()V
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 502	android/graphics/Bitmap:recycle	()V
    //   122: return
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 502	android/graphics/Bitmap:recycle	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 506	java/lang/OutOfMemoryError:printStackTrace	()V
    //   138: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   54	17	1	i1	int
    //   21	107	2	localObject1	Object
    //   38	81	3	localObject2	Object
    //   31	38	4	localBitmap	Bitmap
    //   8	80	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	55	103	finally
    //   68	76	103	finally
    //   86	92	103	finally
    //   110	114	103	finally
    //   39	55	107	java/io/IOException
    //   68	76	107	java/io/IOException
    //   86	92	107	java/io/IOException
    //   22	33	133	java/lang/OutOfMemoryError
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localITroopMngHandler.a(paramString1, paramString2, paramInt1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, a(this.jdField_j_of_type_Int, this.jdField_i_of_type_JavaLangString, paramString2, l1, l2, paramInt2), this.jdField_j_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        paramString2 = "2";
      } else {
        paramString2 = "0";
      }
    }
    else if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      paramString2 = "1";
    } else {
      paramString2 = "3";
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
    TroopReportor.a(this.jdField_a_of_type_JavaLangString, 1, 0, paramInt1);
    if (this.jdField_c_of_type_Boolean) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
    } else {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
    if ((this.jdField_b_of_type_Boolean == true) && (!this.jdField_c_of_type_Boolean)) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean == true)) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
    }
    this.jdField_i_of_type_Int = 1001;
    ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e(this.jdField_f_of_type_JavaLangString);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131696195, 0).b(getTitleBarHeight());
      e();
      return;
    }
    if ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      ((ITroopShowExternalHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER)).a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramBoolean, true);
    }
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
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#send_request_all", true, -1L, -1L, localHashMap, true, true);
    }
  }
  
  private void b(int paramInt)
  {
    String str2 = HardCodeUtil.a(2131700094);
    String str1;
    if (paramInt != 4002)
    {
      if (paramInt != 5002)
      {
        if (paramInt != 12002)
        {
          if (paramInt != 16002)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("showPayDialog, UNKOWN errorCode: ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
            return;
          }
          QQToast.a(this, 1, HardCodeUtil.a(2131700080), 1).a();
          return;
        }
        localObject = HardCodeUtil.a(2131700062);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
      else
      {
        localObject = HardCodeUtil.a(2131700063);
        str1 = "CJCLUBT";
        paramInt = 2;
      }
    }
    else
    {
      localObject = HardCodeUtil.a(2131700056);
      str1 = "LTMCLUB";
      paramInt = 1;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
    String str3 = String.format(HardCodeUtil.a(2131700078), new Object[] { localObject, localObject });
    Object localObject = String.format(HardCodeUtil.a(2131700082), new Object[] { localObject });
    DialogUtil.a(this, 230, str2, str3, HardCodeUtil.a(2131700093), (String)localObject, new AddFriendVerifyActivity.26(this, str1, paramInt), new AddFriendVerifyActivity.27(this)).show();
  }
  
  private void b(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    URLDrawable localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), paramBitmapsCache.a(2131380431));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(localURLDrawable);
    localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), paramBitmapsCache.a(2131380426));
    this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundDrawable(localURLDrawable);
    this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(paramBitmapsCache.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(paramBitmapsCache.jdField_b_of_type_Int);
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.app.getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("last_verify_msg", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.app.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), true);
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = l1;
    boolean bool;
    if ((l2 > 1000L) && (this.jdField_i_of_type_Int != 1001) && (!this.jdField_f_of_type_Boolean)) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.jdField_i_of_type_Int), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(bool) }));
    return bool;
  }
  
  private void d()
  {
    INewFriendVerificationService localINewFriendVerificationService = (INewFriendVerificationService)this.app.getRuntimeService(INewFriendVerificationService.class);
    if (localINewFriendVerificationService != null)
    {
      int i1 = getIntent().getIntExtra("friend_setting", 0);
      int i2 = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int i3 = getIntent().getIntExtra("sub_source_id", 0);
      localINewFriendVerificationService.reportAddFriendBlocked(this.jdField_f_of_type_JavaLangString, i1, i2, i3, str);
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localObject != null)
    {
      if (((FormSwitchItem)localObject).getVisibility() == 8) {
        return;
      }
      Switch localSwitch = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      localSwitch.setTag(Integer.valueOf(1));
      this.jdField_c_of_type_Boolean = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
      localSwitch.setChecked(this.jdField_c_of_type_Boolean);
      if (this.jdField_c_of_type_Boolean == true) {
        localObject = getString(2131696189);
      } else {
        localObject = getString(2131696193);
      }
      localSwitch.setContentDescription((CharSequence)localObject);
    }
  }
  
  private void e(String paramString)
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label33:
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131694331, null, new AddFriendVerifyActivity.31(this, paramString));
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label33;
    }
  }
  
  private void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131718753, 5);
    localActionSheet.addButton(2131718743, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new AddFriendVerifyActivity.24(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void f(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSecurityTipsDialog errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label102:
      String str;
      break label102;
    }
    str = getString(2131718651);
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = getString(2131718648);
    }
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, str, (String)localObject, 2131718649, 2131718650, new AddFriendVerifyActivity.32(this), new AddFriendVerifyActivity.33(this));
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog, tips dialog show failed", paramString);
      }
      return;
    }
  }
  
  private void g(String paramString)
  {
    runOnUiThread(new AddFriendVerifyActivity.35(this));
  }
  
  void a()
  {
    Object localObject1;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject1 = new Intent(this, SplashActivity.class);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject1).setFlags(67108864);
      startActivity((Intent)localObject1);
      finish();
      return;
    }
    Object localObject2 = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("goBack | retAddr = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (localObject2 != null) {
      try
      {
        localObject1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
        localObject2 = Class.forName((String)localObject2);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
        if ((!localObject2.equals(localObject1)) && (!localObject2.equals(QidianProfileCardActivity.class)))
        {
          if (localObject2.equals(QQNearbyManager.b()))
          {
            localIntent2.putExtra("AllInOne", new AllInOne(this.jdField_f_of_type_JavaLangString, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        else {
          ProfileActivity.a(this, this.jdField_f_of_type_JavaLangString, localIntent2);
        }
        localIntent2.setFlags(67108864);
        localIntent2.putExtra("key_back_from_add_friend", true);
        startActivity(localIntent2);
        return;
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
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.jdField_f_of_type_JavaLangString);
      setResult(-1, localIntent1);
    }
    else
    {
      a(0, "");
      setResult(-1);
    }
    finish();
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 2000)
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167138));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundResource(2130850703);
      int i1 = AIOUtils.b(10.0F, getResources());
      this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
      this.jdField_c_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167056));
    }
    else
    {
      localObject = PobingDecoder.a(PobingManager.b(paramInt));
      if (localObject == null) {
        new PobingDecoder(paramInt, TroopPobingItemView.b, this.jdField_a_of_type_ComTencentMobileqqVasTrooppobingPobingDecoder$DecodeCallBack);
      } else {
        a((PobingDecoder.BitmapsCache)localObject);
      }
      if (SimpleUIUtil.a()) {
        DialogUtil.a(this, 0, HardCodeUtil.a(2131700089), HardCodeUtil.a(2131700083), null, HardCodeUtil.a(2131700058), new AddFriendVerifyActivity.28(this), null).show();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" server: ");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_g_of_type_Int != paramInt)
    {
      localObject = (VipInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
      if (localObject != null)
      {
        UniSetReq localUniSetReq = new UniSetReq();
        localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt, "");
        ((VipInfoHandler)localObject).a(localUniSetReq, new AddFriendVerifyActivity.PobingTemplateObserver(this, paramInt), false);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "set fail, VipInfoHandler is null");
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyActivity.36(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3) {
        return;
      }
      if ((paramBoolean) && ((paramObject instanceof UniGetRsp)))
      {
        paramObject = ((UniGetRsp)paramObject).uniBusinessItemList.iterator();
        while (paramObject.hasNext())
        {
          localObject = (UniBusinessItem)paramObject.next();
          if (((UniBusinessItem)localObject).appid == 40)
          {
            this.jdField_g_of_type_Int = ((UniBusinessItem)localObject).itemid;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter.a(((UniBusinessItem)localObject).itemid);
            paramObject = new StringBuilder();
            paramObject.append("TYPE_UNI_GET_RSP: ");
            paramObject.append(this.jdField_g_of_type_Int);
            QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
            return;
          }
        }
        paramObject = new StringBuilder();
        paramObject.append("TYPE_UNI_GET_RSP nothing: ");
        paramObject.append(this.jdField_g_of_type_Int);
        QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TYPE_UNI_GET_RSP: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)))
    {
      paramObject = (UniSetRsp)paramObject;
      if (paramObject.ret == 0)
      {
        this.jdField_g_of_type_Int = paramInt2;
        paramObject = new StringBuilder();
        paramObject.append("TYPE_UNI_SET_RSP success: ");
        paramObject.append(this.jdField_g_of_type_Int);
        QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TYPE_UNI_SET_RSP: ");
      ((StringBuilder)localObject).append(paramObject.ret);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(paramObject.errmsg);
      QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
      b(paramObject.ret);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter.a(this.jdField_g_of_type_Int);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TYPE_UNI_SET_RSP: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" data=");
    ((StringBuilder)localObject).append(paramObject);
    QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    if (paramBitmapsCache == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AddFriendVerifyActivity.30(this, paramBitmapsCache));
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
    Object localObject = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.app.getAccount());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.app.getAccount());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
  }
  
  void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131694475), 0).b(getTitleBarHeight());
      return;
    }
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyActivity.13(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, localException.toString());
      }
    }
    Intent localIntent = getIntent();
    int i2 = localIntent.getIntExtra("sub_source_id", 0);
    int i1 = localIntent.getIntExtra("friend_setting", 0);
    if (i1 == 3) {
      i1 = 100;
    }
    boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
    String str = localIntent.getStringExtra("src_name");
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriendWithMyCard(this.jdField_f_of_type_JavaLangString, localIntent.getStringExtra("extra"), i1, (byte)this.jdField_c_of_type_Int, paramString1, this.jdField_d_of_type_Int, i2, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"), false);
    if (!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(i1, this.jdField_d_of_type_Int, bool)) {
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
      if (this.jdField_b_of_type_ComTencentWidgetSwitch != null)
      {
        bool = this.jdField_e_of_type_Boolean;
        if (bool)
        {
          QCircleFollowView.a(this.jdField_f_of_type_JavaLangString, bool);
          paramString1 = new HashMap();
          paramString1.put("ext3", "1");
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
          break label555;
        }
      }
      paramString1 = new HashMap();
      paramString1.put("ext3", "2");
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
      label555:
      if ((localIntent.getBooleanExtra("key_qcircle_stick", false)) && (TextUtils.isEmpty(paramString2))) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 93, 2, 2);
      }
    }
    if (this.jdField_d_of_type_Int == 3094)
    {
      if (i2 == 1)
      {
        ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.a(), ExtendFriendReport.a(this.app), ExtendFriendReport.c());
        return;
      }
      if (i2 == 2)
      {
        ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.a(this.app), "");
        return;
      }
      if (i2 == 8)
      {
        ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_h_of_type_Int, 0, "", "", "", "");
        return;
      }
      if (i2 == 9) {
        ReportController.a(this.app, "dc00898", "", this.jdField_f_of_type_JavaLangString, "0X800A69D", "0X800A69D", this.jdField_h_of_type_Int, 0, "", "", "", "");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 1003) {
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      Object localObject5;
      Object localObject3;
      Object localObject4;
      int i1;
      Object localObject2;
      Object localObject6;
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        localObject5 = (JSONObject)paramJSONObject.get("result");
        if ((paramInt == 0) && (localObject5 != null))
        {
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("checkApiState onResult. retCode = ");
            paramJSONObject.append(paramInt);
            paramJSONObject.append("\n");
            QLog.i("AddFriendVerifyActivity", 2, paramJSONObject.toString());
          }
          localObject1 = (JSONObject)((JSONObject)localObject5).get("basics");
          paramJSONObject = "msg";
          localObject3 = "api";
          paramBundle = paramJSONObject;
          if (localObject1 != null)
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
            paramBundle = paramJSONObject;
            if (localObject1 != null)
            {
              paramInt = 0;
              paramBundle = paramJSONObject;
              if (paramInt < ((JSONArray)localObject1).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
                paramBundle = (String)((JSONObject)localObject4).get("name");
                i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get("api");
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (!QLog.isColorLevel()) {
                  break label953;
                }
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("checkApiState onResult, basics name = ");
                ((StringBuilder)localObject6).append(paramBundle);
                ((StringBuilder)localObject6).append(" state = ");
                ((StringBuilder)localObject6).append(i1);
                ((StringBuilder)localObject6).append(" api = ");
                ((StringBuilder)localObject6).append((String)localObject2);
                ((StringBuilder)localObject6).append(" msg = ");
                ((StringBuilder)localObject6).append((String)localObject4);
                ((StringBuilder)localObject6).append("\n");
                QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject6).toString());
                break label953;
              }
            }
          }
          localObject1 = paramBundle;
          paramJSONObject = (JSONObject)((JSONObject)localObject5).get("friendlink");
          localObject2 = localObject3;
          paramBundle = (Bundle)localObject1;
          if (paramJSONObject != null)
          {
            localObject4 = (JSONArray)paramJSONObject.get("datas");
            localObject2 = localObject3;
            paramBundle = (Bundle)localObject1;
            if (localObject4 != null)
            {
              paramInt = 0;
              paramJSONObject = (JSONObject)localObject3;
              localObject3 = localObject4;
              localObject2 = paramJSONObject;
              paramBundle = (Bundle)localObject1;
              if (paramInt < ((JSONArray)localObject3).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject3).get(paramInt);
                paramBundle = (String)((JSONObject)localObject4).get("name");
                i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get(paramJSONObject);
                localObject4 = (String)((JSONObject)localObject4).get((String)localObject1);
                bool = "add_friend".equals(localObject2);
                if ((!bool) || (i1 == 1)) {
                  break label964;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject) {}
      try
      {
        localObject6 = getActivity().getResources().getString(2131719913);
        g((String)localObject6);
        if (!QLog.isColorLevel()) {
          break label967;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("checkApiState onResult, friendlink name = ");
        ((StringBuilder)localObject6).append(paramBundle);
        ((StringBuilder)localObject6).append(" state = ");
        ((StringBuilder)localObject6).append(i1);
        ((StringBuilder)localObject6).append(" api = ");
        ((StringBuilder)localObject6).append((String)localObject2);
        ((StringBuilder)localObject6).append(" msg= ");
        ((StringBuilder)localObject6).append((String)localObject4);
        ((StringBuilder)localObject6).append("\n");
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject6).toString());
      }
      catch (Exception paramJSONObject)
      {
        break label910;
      }
      paramJSONObject = (JSONObject)localObject2;
      paramInt = ((Integer)((JSONObject)localObject5).get("appid")).intValue();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkApiState onResult, appid =");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("\n");
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (JSONObject)((JSONObject)localObject5).get("qqpay");
      if (localObject1 != null)
      {
        localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
        if (localObject1 != null)
        {
          paramInt = 0;
          if (paramInt < ((JSONArray)localObject1).length())
          {
            localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
            localObject2 = (String)((JSONObject)localObject4).get("name");
            i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
            localObject3 = (String)((JSONObject)localObject4).get(paramJSONObject);
            localObject4 = (String)((JSONObject)localObject4).get(paramBundle);
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("checkApiState onResult, qqpay name = ");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((StringBuilder)localObject5).append(" state = ");
              ((StringBuilder)localObject5).append(i1);
              ((StringBuilder)localObject5).append(" api = ");
              ((StringBuilder)localObject5).append((String)localObject3);
              ((StringBuilder)localObject5).append(" msg= ");
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("\n");
              QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject5).toString());
            }
            paramInt += 1;
            continue;
            label910:
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("checkApiState onResult ");
              paramBundle.append(paramJSONObject.toString());
              QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
            }
          }
        }
      }
      return;
      label953:
      paramInt += 1;
      continue;
      label964:
      continue;
      label967:
      paramInt += 1;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1420	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1421	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1423	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1424	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1426	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1427	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1431	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1437	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1443	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1447	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1450	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1454	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1459	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1423	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1424	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1463	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1468	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1471	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1454	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1459	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1423	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1424	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1473	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1474	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1476	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1477	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1481	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1488	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1492	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1496	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1443	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1500	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1501	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1454	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1459	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1503	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1504	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1508	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1509	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1511	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1512	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 10
    //   206: aload 10
    //   208: getfield 1516	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1517	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1519	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1520	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1522	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1523	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 11
    //   232: aload 11
    //   234: getfield 1526	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1531	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 11
    //   244: getfield 1534	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 11
    //   255: getfield 1537	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 11
    //   264: getfield 1541	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1545	com/dataline/util/DatalineMathUtil:a	()J
    //   270: l2i
    //   271: invokevirtual 1548	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 11
    //   276: getfield 1551	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 11
    //   286: getfield 1554	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1556	com/tencent/common/config/AppSetting:a	()I
    //   292: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1560	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 11
    //   301: invokevirtual 1561	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1560	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1526	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1531	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1563	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1564	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1568	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1569	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1568	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1572	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1531	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1568	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1576	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1579	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1581	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1582	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1586	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1587	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1589	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1590	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1593	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 12
    //   385: getstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   395: aload 12
    //   397: iload_1
    //   398: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1595	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1596	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 12
    //   410: aload 12
    //   412: getfield 1600	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1601	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 12
    //   421: getfield 1605	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1606	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 10
    //   430: getfield 1610	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 12
    //   435: invokevirtual 1611	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1613	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1614	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 12
    //   447: aload 12
    //   449: getfield 1617	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 12
    //   458: getfield 1620	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: ldc 111
    //   469: astore_2
    //   470: aload_0
    //   471: getfield 246	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokestatic 1625	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   477: astore_3
    //   478: aload_3
    //   479: astore_2
    //   480: aload_3
    //   481: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: istore 9
    //   486: iload 9
    //   488: ifeq +54 -> 542
    //   491: aconst_null
    //   492: areturn
    //   493: astore 13
    //   495: aload_2
    //   496: astore_3
    //   497: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +42 -> 542
    //   503: new 322	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   510: astore_3
    //   511: aload_3
    //   512: ldc_w 1627
    //   515: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: aload 13
    //   522: invokevirtual 1630	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: ldc_w 273
    //   532: iconst_2
    //   533: aload_3
    //   534: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 1633	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: aload_2
    //   541: astore_3
    //   542: aload 12
    //   544: getfield 1636	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   547: aload_3
    //   548: invokestatic 1437	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   551: invokevirtual 1443	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   554: new 1638	tencent/im/msg/im_imagent$ImAgentHead
    //   557: dup
    //   558: invokespecial 1639	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   561: astore_2
    //   562: aload_2
    //   563: getfield 1642	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   566: iconst_3
    //   567: invokevirtual 1579	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   570: aload_2
    //   571: getfield 1646	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   574: aload 12
    //   576: invokevirtual 1647	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   579: aload_2
    //   580: getfield 1650	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   583: aload 11
    //   585: invokevirtual 1561	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   588: aload_2
    //   589: getfield 1651	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   592: astore_3
    //   593: getstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   596: istore_1
    //   597: iload_1
    //   598: iconst_1
    //   599: iadd
    //   600: putstatic 90	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_l_of_type_Int	I
    //   603: aload_3
    //   604: iload_1
    //   605: invokevirtual 1485	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   608: new 1653	tencent/im/msg/im_msg$MsgSendReq
    //   611: dup
    //   612: invokespecial 1654	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   615: astore_3
    //   616: aload_3
    //   617: getfield 1657	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   620: aload 10
    //   622: invokevirtual 1658	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   625: new 1660	tencent/im/msg/im_imagent$ImAgentPackage
    //   628: dup
    //   629: invokespecial 1661	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   632: astore 10
    //   634: aload 10
    //   636: getfield 1664	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   639: aload_2
    //   640: invokevirtual 1665	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   643: aload 10
    //   645: getfield 1669	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   648: aload_3
    //   649: invokevirtual 1670	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   652: aload 10
    //   654: invokevirtual 1671	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   657: astore_2
    //   658: new 1673	java/io/ByteArrayOutputStream
    //   661: dup
    //   662: aload_2
    //   663: arraylength
    //   664: bipush 8
    //   666: iadd
    //   667: invokespecial 1675	java/io/ByteArrayOutputStream:<init>	(I)V
    //   670: astore_3
    //   671: new 1677	java/io/DataOutputStream
    //   674: dup
    //   675: aload_3
    //   676: invokespecial 1680	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   679: astore 10
    //   681: aload 10
    //   683: aload_2
    //   684: arraylength
    //   685: bipush 8
    //   687: iadd
    //   688: invokevirtual 1683	java/io/DataOutputStream:writeInt	(I)V
    //   691: aload 10
    //   693: bipush 123
    //   695: invokevirtual 1686	java/io/DataOutputStream:write	(I)V
    //   698: aload 10
    //   700: bipush 123
    //   702: invokevirtual 1686	java/io/DataOutputStream:write	(I)V
    //   705: aload 10
    //   707: aload_2
    //   708: invokevirtual 1689	java/io/DataOutputStream:write	([B)V
    //   711: aload 10
    //   713: bipush 125
    //   715: invokevirtual 1686	java/io/DataOutputStream:write	(I)V
    //   718: aload 10
    //   720: bipush 125
    //   722: invokevirtual 1686	java/io/DataOutputStream:write	(I)V
    //   725: aload_3
    //   726: invokevirtual 1690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   729: astore 11
    //   731: new 322	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   738: astore 12
    //   740: aload 12
    //   742: ldc_w 1692
    //   745: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: ifnonnull +10 -> 761
    //   754: ldc_w 1694
    //   757: astore_2
    //   758: goto +10 -> 768
    //   761: aload 11
    //   763: arraylength
    //   764: invokestatic 802	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: astore_2
    //   768: aload 12
    //   770: aload_2
    //   771: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: ldc_w 273
    //   778: iconst_1
    //   779: aload 12
    //   781: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_3
    //   788: invokevirtual 1696	java/io/ByteArrayOutputStream:close	()V
    //   791: aload 10
    //   793: invokevirtual 1697	java/io/DataOutputStream:close	()V
    //   796: aload 11
    //   798: areturn
    //   799: astore_2
    //   800: goto +19 -> 819
    //   803: astore_2
    //   804: aload_2
    //   805: invokevirtual 1698	java/lang/Exception:printStackTrace	()V
    //   808: aload_3
    //   809: invokevirtual 1696	java/io/ByteArrayOutputStream:close	()V
    //   812: aload 10
    //   814: invokevirtual 1697	java/io/DataOutputStream:close	()V
    //   817: aconst_null
    //   818: areturn
    //   819: aload_3
    //   820: invokevirtual 1696	java/io/ByteArrayOutputStream:close	()V
    //   823: aload 10
    //   825: invokevirtual 1697	java/io/DataOutputStream:close	()V
    //   828: aload_2
    //   829: athrow
    //   830: astore_2
    //   831: aload 11
    //   833: areturn
    //   834: astore_2
    //   835: aconst_null
    //   836: areturn
    //   837: astore_3
    //   838: goto -10 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	AddFriendVerifyActivity
    //   0	841	1	paramInt1	int
    //   0	841	2	paramString1	String
    //   0	841	3	paramString2	String
    //   0	841	4	paramLong1	long
    //   0	841	6	paramLong2	long
    //   0	841	8	paramInt2	int
    //   484	3	9	bool	boolean
    //   38	786	10	localObject1	Object
    //   47	785	11	localObject2	Object
    //   383	397	12	localObject3	Object
    //   493	28	13	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   470	478	493	java/lang/InterruptedException
    //   480	486	493	java/lang/InterruptedException
    //   681	749	799	finally
    //   761	768	799	finally
    //   768	787	799	finally
    //   804	808	799	finally
    //   681	749	803	java/lang/Exception
    //   761	768	803	java/lang/Exception
    //   768	787	803	java/lang/Exception
    //   787	796	830	java/lang/Exception
    //   808	817	834	java/lang/Exception
    //   819	828	837	java/lang/Exception
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).countByByte(paramEditable) > 32)
    {
      int i1 = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getRemark(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (i1 >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramEditable = this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131693375));
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
    }
  }
  
  void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131718220), 0).b(getTitleBarHeight());
      return;
    }
    if (getIntent().hasExtra("contacts"))
    {
      ArrayList localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyActivity.14(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
        ((IFriendHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_d_of_type_Int, new ArrayList());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      if (!localFile.isFile()) {
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
      {
        QQToast.a(getApplicationContext(), 1, 2131696066, 0).b(getTitleBarHeight());
        return;
      }
      ThreadManager.post(new AddFriendVerifyActivity.25(this, paramString), 5, null, false);
    }
  }
  
  protected void d(String paramString)
  {
    if (this.jdField_f_of_type_Int != 4)
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setText("30");
    }
    else
    {
      int i2 = 0;
      int i1;
      try
      {
        i1 = paramString.getBytes("utf-8").length;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
          i1 = i2;
        }
      }
      TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(90 - i1);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(paramString);
    paramString = this.jdField_c_of_type_AndroidWidgetEditText;
    paramString.setSelection(paramString.getText().length());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",data=");
      if (paramIntent == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002)
      {
        if (paramInt1 != 1004) {
          return;
        }
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("ticket");
          localObject = this.jdField_a_of_type_AndroidOsBundle;
          if (localObject != null)
          {
            a(((Bundle)localObject).getString("msg", ""), this.jdField_a_of_type_AndroidOsBundle.getByteArray("sig"), paramIntent);
            bool1 = true;
          }
          else
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
            if (paramIntent != null)
            {
              paramIntent.cancel();
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
            }
            e(getString(2131718220));
            d();
            bool1 = bool2;
          }
        }
        else
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          if (paramIntent != null)
          {
            paramIntent.cancel();
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
          }
          e(getString(2131718220));
          d();
          bool1 = bool2;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=");
          paramIntent.append(bool1);
          QLog.d("AddFriendVerifyActivity", 2, paramIntent.toString());
        }
      }
      else if (paramIntent != null)
      {
        paramInt1 = paramIntent.getByteExtra("result", (byte)0);
        this.jdField_c_of_type_Int = paramInt1;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
        paramIntent = this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131700092));
        ((StringBuilder)localObject).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
        paramIntent.setContentDescription(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramIntent = this.jdField_a_of_type_AndroidNetUri.getPath();
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.jdField_k_of_type_JavaLangString = paramIntent;
        a(this.jdField_k_of_type_JavaLangString);
        c(this.jdField_k_of_type_JavaLangString);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = getIntent();
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
    this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("k_uin_type", 1);
    if (this.jdField_f_of_type_Int != 4) {
      setTheme(2131755317);
    }
    this.jdField_h_of_type_Int = ((Intent)localObject1).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    int i1;
    Object localObject2;
    if (this.jdField_f_of_type_Int == 4)
    {
      setContentViewB(2131558507);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131380425));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380432));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380429));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380430));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131380426));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380428));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379247));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362182));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368486));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368560));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.m = ((TextView)findViewById(2131373316));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373870));
      this.n = ((TextView)findViewById(2131373872));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131373869));
      this.o = ((TextView)findViewById(2131373871));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131372886));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380431));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373314));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373315));
    }
    else
    {
      setContentViewB(2131558506);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      this.jdField_e_of_type_Int = getIntent().getIntExtra("sub_source_id", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("source_id", 3999);
      if (((Intent)localObject1).hasExtra("param_wzry_data")) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject1).getSerializableExtra("param_wzry_data"));
      }
      if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.jdField_d_of_type_Int))
      {
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("nick_name");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
      {
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("nick_name");
      }
      else if (this.jdField_d_of_type_Int == 3004)
      {
        i1 = this.jdField_e_of_type_Int;
        if ((i1 == 5) || (i1 == 6) || (i1 == 7) || (i1 == 8)) {
          this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("nick_name");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AddFriendVerifyActivity remark = ");
        ((StringBuilder)localObject2).append(this.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", source id=");
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject2).append(", mTargetGroupId = ");
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramBundle == null) && (NetworkUtil.isNetSupport(this)) && (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.jdField_d_of_type_Int, this.jdField_f_of_type_JavaLangString))) {
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.jdField_f_of_type_JavaLangString, this.jdField_d_of_type_Int, ((Intent)localObject1).getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363786));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new AddFriendVerifyActivity.1(this));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376446));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376447));
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(100, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362295));
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371747));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362709));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372959));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371877));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378853));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367825));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376728));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131376688));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366329));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379709));
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_e_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_e_of_type_JavaLangString.length());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.jdField_c_of_type_Int));
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700086));
      ((StringBuilder)localObject2).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.jdField_c_of_type_Int));
      paramBundle.setContentDescription(((StringBuilder)localObject2).toString());
      if (Utils.b(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689614));
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131689613));
      }
      if ((!EAddFriendSourceID.a(this.jdField_d_of_type_Int)) && (this.jdField_d_of_type_Int != 3016)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
      {
        this.jdField_a_of_type_AndroidViewView = findViewById(2131375610);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131375611));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if ((this.jdField_d_of_type_Int == 3050) && (this.jdField_e_of_type_Int == 3))
      {
        if (!((Intent)localObject1).getBooleanExtra("qcircle_isfollow", false))
        {
          this.jdField_b_of_type_AndroidViewView = findViewById(2131373902);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131373903));
          this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
          paramBundle = new HashMap();
          paramBundle.put("ext3", "1");
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 1, 0, paramBundle, null, null);
        }
        else
        {
          paramBundle = new HashMap();
          paramBundle.put("ext3", "2");
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 79, 1, 0, paramBundle, null, null);
        }
        if (((Intent)localObject1).getBooleanExtra("key_qcircle_stick", false)) {
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_f_of_type_JavaLangString, 93, 1, 1);
        }
      }
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131692138));
        if (!Utils.b(this.jdField_f_of_type_JavaLangString)) {
          this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718187));
        } else {
          this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718186));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getResources().getString(2131693375));
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        paramBundle.setContentDescription(((StringBuilder)localObject2).toString());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
        if (i1 == 0)
        {
          this.jdField_a_of_type_AndroidViewView.setFocusable(true);
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690785);
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("authKey");
    this.jdField_h_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("authSig");
    paramBundle = this.jdField_g_of_type_JavaLangString;
    paramBundle = getIntent().getExtras().getString("nick_name");
    Object localObject3;
    int i2;
    Object localObject4;
    if (this.jdField_f_of_type_Int == 4)
    {
      setTitle(2131689702);
      localObject3 = (TextView)findViewById(2131369202);
      localObject2 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = getString(2131690706);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      localObject2 = (ITroopMngHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      paramBundle = (ITroopInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      this.jdField_d_of_type_JavaLangString = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        paramBundle.c(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = getIntent().getExtras().getShort("group_option", (short)2);
      i1 = this.jdField_a_of_type_Int;
      paramBundle = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      i2 = getIntent().getIntExtra("stat_option", 0);
      TroopReportor.a(this.jdField_a_of_type_JavaLangString, 1, 1, i2);
      ((ITroopMngHandler)localObject2).a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), Long.valueOf(this.app.getCurrentUin()).longValue(), null);
      if ((i1 != 1) && (i1 != 2))
      {
        if (i1 != 3) {
          if (i1 != 4)
          {
            if (i1 == 5)
            {
              this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(getString(2131716737));
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(paramBundle);
              paramBundle = new QQText(((StringBuilder)localObject2).toString(), 13);
              this.n.setText(paramBundle);
              this.n.setTag(this.jdField_a_of_type_JavaLangString);
              this.n.setMovementMethod(LinkMovementMethod.getInstance());
              this.n.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
              this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
              if (jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691956));
              }
              setRightHighlightButton(2131690820, new AddFriendVerifyActivity.4(this));
              ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
              if (paramBundle.mSpanCount > 0)
              {
                i2 = 0;
                while (i2 < paramBundle.mSpans.length)
                {
                  if ((paramBundle.mSpans[i2] instanceof LinkSpan))
                  {
                    localObject2 = ((LinkSpan)paramBundle.mSpans[i2]).jdField_a_of_type_JavaLangString;
                    i1 = -1;
                    if (Patterns.d.matcher((CharSequence)localObject2).find()) {
                      i1 = 0;
                    }
                    if (QQTextParseLinkUtil.b.matcher((CharSequence)localObject2).find()) {
                      i1 = 1;
                    }
                    if (QQTextParseLinkUtil.e.matcher((CharSequence)localObject2).find()) {
                      i1 = 2;
                    }
                    localObject2 = this.app;
                    localObject3 = this.jdField_a_of_type_JavaLangString;
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("");
                    ((StringBuilder)localObject4).append(i1);
                    ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
                  }
                  i2 += 1;
                }
              }
            }
          }
          else
          {
            this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getString(2131716737));
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramBundle);
            paramBundle = new QQText(((StringBuilder)localObject2).toString(), 13);
            this.n.setText(paramBundle);
            this.n.setTag(this.jdField_a_of_type_JavaLangString);
            this.n.setMovementMethod(LinkMovementMethod.getInstance());
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
            if (jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131691956));
            }
            setRightHighlightButton(2131690820, new AddFriendVerifyActivity.3(this));
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
            if (paramBundle.mSpanCount > 0) {
              i2 = 0;
            }
          }
        }
      }
      else {
        while (i2 < paramBundle.mSpans.length)
        {
          if ((paramBundle.mSpans[i2] instanceof LinkSpan))
          {
            localObject2 = ((LinkSpan)paramBundle.mSpans[i2]).jdField_a_of_type_JavaLangString;
            i1 = -1;
            if (Patterns.d.matcher((CharSequence)localObject2).find()) {
              i1 = 0;
            }
            if (QQTextParseLinkUtil.b.matcher((CharSequence)localObject2).find()) {
              i1 = 1;
            }
            if (QQTextParseLinkUtil.e.matcher((CharSequence)localObject2).find()) {
              i1 = 2;
            }
            localObject2 = this.app;
            localObject3 = this.jdField_a_of_type_JavaLangString;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(i1);
            ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
          }
          i2 += 1;
          continue;
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
          this.jdField_c_of_type_AndroidWidgetEditText.setHeight(AIOUtils.b(160.0F, getResources()));
          this.jdField_c_of_type_AndroidWidgetEditText.setSingleLine(false);
          this.jdField_c_of_type_AndroidWidgetEditText.setGravity(48);
          this.jdField_c_of_type_AndroidWidgetEditText.setHint("");
          i1 = AIOUtils.b(10.0F, getResources());
          this.jdField_c_of_type_AndroidWidgetEditText.setPadding(i1, i1, i1, i1);
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            paramBundle = getString(2131697545, new Object[] { this.app.getCurrentNickname() });
          } else {
            paramBundle = this.jdField_d_of_type_JavaLangString;
          }
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
            if (paramBundle != null)
            {
              localObject2 = new UniGetReq();
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(Integer.valueOf(40));
              ((UniGetReq)localObject2).appidList = ((ArrayList)localObject3);
              paramBundle.a((UniGetReq)localObject2, new AddFriendVerifyActivity.PobingTemplateObserver(this, 0), false);
            }
            else
            {
              QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
            }
          }
          setRightHighlightButton(2131690820, new AddFriendVerifyActivity.2(this));
        }
      }
      getWindow().setSoftInputMode(5);
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      break label5519;
      setTitle(2131689609);
      setLeftButton(HardCodeUtil.a(2131700057), null);
      localObject2 = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      int i3 = getIntent().getExtras().getInt("source_id", 3999);
      int i4 = getIntent().getIntExtra("sub_source_id", 0);
      if (EAddFriendSourceID.a(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.jdField_f_of_type_JavaLangString;
        ((CardHandler)localObject2).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
      }
      else
      {
        ((CardHandler)localObject2).a(this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
      addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      i1 = this.jdField_f_of_type_Int;
      if (i1 == 2)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 11, this.jdField_f_of_type_JavaLangString));
        localObject3 = this.jdField_l_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject2 = this.jdField_f_of_type_JavaLangString;
        } else {
          localObject2 = paramBundle;
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject3 = this.jdField_l_of_type_AndroidWidgetTextView;
          localObject2 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject2 = this.jdField_f_of_type_JavaLangString;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
        }
      }
      else if (i1 == 3)
      {
        localObject2 = ((Intent)localObject1).getStringExtra("extra");
        localObject2 = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.jdField_f_of_type_JavaLangString, (String)localObject2), URLDrawable.URLDrawableOptions.obtain());
        if (QQTheme.f()) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        } else {
          a((URLDrawable)localObject2);
        }
        this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
        }
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestInfoWithOpenId(this.jdField_f_of_type_JavaLangString, getIntent().getStringExtra("extra"));
      }
      else
      {
        if ((i3 != 3007) && (i3 != 2007) && (i3 != 4007) && (i3 != 3019) && (i3 != 2019)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_f_of_type_JavaLangString));
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_f_of_type_JavaLangString, true));
        }
        if (a())
        {
          if (paramBundle != null)
          {
            this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
            if (AppSetting.jdField_d_of_type_Boolean) {
              this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
            }
          }
        }
        else {
          ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
        }
      }
      int i5 = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      localObject3 = getIntent().getExtras().getStringArrayList("user_question");
      localObject2 = "reportClickEvent action: 0X80077AF  sourceId = ";
      if (i5 != 0)
      {
        if (i5 == 1) {
          break label4912;
        }
        if (i5 != 2)
        {
          if (i5 != 3)
          {
            if (i5 != 4) {
              break;
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            localObject4 = new StringBuffer();
            if ((localObject3 != null) && (((ArrayList)localObject3).size() == 1)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            i2 = 0;
            while (i2 < ((ArrayList)localObject3).size())
            {
              if (i2 != 0)
              {
                if (i2 != 1)
                {
                  if (i2 != 2)
                  {
                    if (i2 != 3)
                    {
                      if (i2 != 4) {
                        paramBundle = getResources().getString(2131716737);
                      } else {
                        paramBundle = getResources().getString(2131716743);
                      }
                    }
                    else {
                      paramBundle = getResources().getString(2131716742);
                    }
                  }
                  else {
                    paramBundle = getResources().getString(2131716741);
                  }
                }
                else {
                  paramBundle = getResources().getString(2131716740);
                }
              }
              else if (i1 != 0) {
                paramBundle = getResources().getString(2131716738);
              } else {
                paramBundle = getResources().getString(2131716739);
              }
              Object localObject7 = getLayoutInflater().inflate(2131560897, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
              Object localObject6 = getLayoutInflater().inflate(2131560896, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
              if (i2 > 0)
              {
                localObject5 = (LinearLayout.LayoutParams)((View)localObject7).getLayoutParams();
                if (localObject5 != null)
                {
                  ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)DisplayUtils.a(getApplication(), 19.0F));
                  ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                }
              }
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject7);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject6);
              Object localObject5 = (String)((ArrayList)localObject3).get(i2);
              localObject7 = (TextView)((View)localObject7).findViewById(2131378476);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBundle);
              localStringBuilder.append((String)localObject5);
              ((TextView)localObject7).setText(localStringBuilder.toString());
              localObject6 = (EditText)((View)localObject6).findViewById(2131368891);
              ((EditText)localObject6).addTextChangedListener(new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject6));
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject6);
              if (jdField_a_of_type_Boolean)
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(paramBundle);
                ((StringBuilder)localObject6).append((String)localObject5);
                ((TextView)localObject7).setContentDescription(((StringBuilder)localObject6).toString());
                ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).setContentDescription(getString(2131689612));
              }
              i2 += 1;
              paramBundle = new StringBuilder();
              paramBundle.append(getString(2131716737));
              paramBundle.append(i2);
              paramBundle.append(":");
              paramBundle.append((String)localObject5);
              ((StringBuffer)localObject4).append(paramBundle.toString());
              ((StringBuffer)localObject4).append("\n");
              paramBundle = new StringBuilder();
              paramBundle.append(getString(2131690014));
              paramBundle.append(":${answer}");
              ((StringBuffer)localObject4).append(paramBundle.toString());
              if (i2 != ((ArrayList)localObject3).size()) {
                ((StringBuffer)localObject4).append("\n");
              }
            }
            setRightHighlightButton(2131690820, new AddFriendVerifyActivity.10(this, (StringBuffer)localObject4, i3, i4, i5));
            findViewById(2131376732).setOnTouchListener(new AddFriendVerifyActivity.11(this));
            getWindow().setSoftInputMode(4);
            paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramBundle.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
            ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i3), String.valueOf(i4), "", "");
            paramBundle = (Bundle)localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramBundle = new StringBuilder();
            paramBundle.append((String)localObject2);
            paramBundle.append(i3);
            paramBundle.append(" subSourceId = ");
            paramBundle.append(i4);
            QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
            paramBundle = (Bundle)localObject1;
            continue;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          paramBundle = (String)((ArrayList)localObject3).get(0);
          localObject2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378476);
          localObject3 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368891);
          this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject3);
          ((EditText)localObject3).addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(getString(2131716737));
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(paramBundle);
          ((TextView)localObject2).setText(((StringBuilder)localObject4).toString());
          ((EditText)localObject3).setSingleLine(true);
          if (jdField_a_of_type_Boolean)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(getString(2131716737));
            ((StringBuilder)localObject4).append(":");
            ((StringBuilder)localObject4).append(paramBundle);
            ((TextView)localObject2).setContentDescription(((StringBuilder)localObject4).toString());
            ((EditText)localObject3).setContentDescription(getString(2131689612));
          }
          setRightHighlightButton(2131690820, new AddFriendVerifyActivity.9(this, (EditText)localObject3, i5, i3, i4));
          getWindow().setSoftInputMode(5);
          paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
          paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i3), String.valueOf(i4), "", "");
          paramBundle = (Bundle)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("reportClickEvent action: 0X80077AF  sourceId = ");
          paramBundle.append(i3);
          paramBundle.append(" subSourceId = ");
          paramBundle.append(i4);
          QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
          paramBundle = (Bundle)localObject1;
          continue;
        }
      }
      paramBundle = (Bundle)localObject1;
      break label5130;
      label4912:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
        paramBundle.setContentDescription(paramBundle.getText().toString());
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689615));
      }
      setRightHighlightButton(2131690820, new AddFriendVerifyActivity.8(this, i3, i4, i5));
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
      paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
      ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i3), String.valueOf(i4), "", "");
      paramBundle = (Bundle)localObject1;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("reportClickEvent action: 0X80077AF  sourceId = ");
        paramBundle.append(i3);
        paramBundle.append(" subSourceId = ");
        paramBundle.append(i4);
        QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
        paramBundle = (Bundle)localObject1;
        continue;
        label5130:
        if ((i3 != 3078) && (i3 != 3079))
        {
          setRightHighlightButton(2131690820, new AddFriendVerifyActivity.7(this, i3, i4));
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i3), String.valueOf(i4), "", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("reportClickEvent action: 0X80077AF  sourceId = ");
            ((StringBuilder)localObject1).append(i3);
            ((StringBuilder)localObject1).append(" subSourceId = ");
            ((StringBuilder)localObject1).append(i4);
            QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
          }
          a(i3, i5);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131689597));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
            ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689615));
          }
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (getIntent() != null) {
            i1 = getIntent().getIntExtra("contact_from_type", 1);
          } else {
            i1 = 1;
          }
          setRightHighlightButton(2131690820, new AddFriendVerifyActivity.6(this, i1));
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    label5519:
    if (this.jdField_f_of_type_Int == 3)
    {
      localObject1 = paramBundle.getStringExtra("is_from_game");
      paramBundle = paramBundle.getStringExtra("extra");
      try
      {
        localObject2 = QConfigLocalLoader.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(localObject1)) || (((QConfLogBean)localObject2).b())) && (!TextUtils.isEmpty(paramBundle)))
        {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), paramBundle, this, 1003, null);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("AddFriend enableCheckPermission = ");
            ((StringBuilder)localObject3).append(((QConfLogBean)localObject2).b());
            QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      catch (Exception localException)
      {
        if (("true".equals(localObject1)) && (!TextUtils.isEmpty(paramBundle))) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), paramBundle, this, 1003, null);
        }
        paramBundle = new StringBuilder();
        paramBundle.append("AddFriend loadConfig exception = ");
        paramBundle.append(localException);
        QLog.d("AddFriendVerifyActivity", 1, paramBundle.toString());
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    enableRightHighlight(true);
    if (QidianManager.a(this.app, this.jdField_f_of_type_JavaLangString)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("webImVisitId");
    return true;
  }
  
  protected void doOnDestroy()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    } else {
      getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_k_of_type_JavaLangString = ((String)paramIntent.get(0));
      c(this.jdField_k_of_type_JavaLangString);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject1;
    int i2;
    String str;
    Object localObject2;
    Object localObject3;
    if (this.jdField_f_of_type_Int != 4)
    {
      localObject1 = getIntent();
      i2 = 0;
      int i3 = 0;
      i1 = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        str = getString(2131691954);
        if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(getString(2131698401));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
          localObject2 = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject2);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          localObject2 = str;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
          ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689615));
        }
        localObject1 = null;
        if (this.jdField_f_of_type_Int == 3)
        {
          localObject1 = getIntent().getStringExtra("msg");
        }
        else
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
          if (localObject3 != null)
          {
            localObject3 = ((KplRoleInfo.WZRYUIinfo)localObject3).verifyMsg;
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              i1 = 0;
              localObject1 = localObject3;
              break label278;
            }
          }
        }
        i1 = 1;
        label278:
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = a(false);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = localObject3;
        }
        i2 = i3;
        localObject1 = localObject2;
        if (i1 != 0)
        {
          i2 = i3;
          localObject1 = localObject2;
          if (str.equals(localObject2))
          {
            i2 = i3;
            localObject1 = localObject2;
            if (!b())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
              localObject1 = ((StringBuilder)localObject1).toString();
              i2 = 1;
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
        if (i2 == 0) {}
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable1)
    {
      break label442;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    label442:
    getWindow().setSoftInputMode(5);
    return;
    int i1 = this.jdField_d_of_type_Int;
    if ((i1 == 3078) || (i1 == 3079))
    {
      localObject3 = a(false);
      localObject2 = getString(2131691954);
      localObject1 = localObject3;
      i1 = i2;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if (!b())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
          localObject1 = ((StringBuilder)localObject1).toString();
          i1 = 1;
        }
        else
        {
          localObject1 = localObject2;
          i1 = i2;
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      if (i1 == 0) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject2).length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable2)
    {
      break label624;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    }
    label624:
    getWindow().setSoftInputMode(5);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
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
      overridePendingTransition(0, 2130772015);
    }
  }
  
  protected boolean onBackEvent()
  {
    d();
    Object localObject = getIntent();
    boolean bool = false;
    if (((Intent)localObject).getBooleanExtra("need_jumpto_splash", false))
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
      if (4 == this.jdField_f_of_type_Int) {
        bool = true;
      }
      a((String)localObject, bool);
      if ((getString(2131691954).equals(localObject)) && (!b())) {
        c();
      }
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      ReportController.b(this.app, "dc00899", "Qidian", this.jdField_f_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, 1, 2131694424, 0).b(getTitleBarHeight());
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (localObject != null)
      {
        ((Switch)localObject).setChecked(paramBoolean ^ true);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
      }
      localObject = this.jdField_b_of_type_ComTencentWidgetSwitch;
      if (localObject != null)
      {
        ((Switch)localObject).setChecked(paramBoolean ^ true);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (localObject != null) {
        ((Switch)localObject).setOnClickListener(this);
      }
      localObject = this.jdField_b_of_type_ComTencentWidgetSwitch;
      if (localObject != null) {
        ((Switch)localObject).setOnClickListener(this);
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
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
      else if (paramCompoundButton == this.jdField_b_of_type_ComTencentWidgetSwitch)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
      }
      localObject = paramCompoundButton.getTag();
      if (((localObject instanceof Integer)) && ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) != null) && (this.jdField_a_of_type_JavaLangString != null) && (((Integer)localObject).intValue() == 1)) {
        a(paramBoolean);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376688)
    {
      Object localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult((Intent)localObject, 1002);
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localObject != null) {
        a(((EditText)localObject).getText().toString(), false);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if (paramView.getId() == 2131368891)
    {
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if ((i1 != 1) && (i1 != 3)) {
          return false;
        }
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */