package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
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
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ril;
import rim;
import rin;
import rio;
import rip;
import riq;
import rir;
import ris;
import rit;
import riu;
import riv;
import riw;
import rix;
import riy;
import riz;
import rja;
import rjb;
import rjc;
import rjd;
import rje;
import rjf;
import rjg;
import rjh;
import rji;
import rjj;
import rjl;
import rjm;
import rjn;
import rjo;
import rjq;
import rjr;
import rjs;
import tencent.im.msg.im_msg_body.RichMsg;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, HttpWebCgiAsyncTask.Callback
{
  public static final boolean b;
  private static int jdField_g_of_type_Int = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Dialog a;
  private Uri jdField_a_of_type_AndroidNetUri;
  public Handler a;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new rir(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rjb(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new rjh(this);
  public InputMethodManager a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new rja(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ris(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rit(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new riv(this);
  public KplRoleInfo.WZRYUIinfo a;
  public QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  protected FormSwitchItem a;
  public QQProgressDialog a;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new riu(this);
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AddFriendVerifyActivity.MaxBytesTextWatcher jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher;
  public FormSwitchItem b;
  public String b;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  public TextView c;
  protected String c;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  String jdField_d_of_type_JavaLangString = null;
  public boolean d;
  private int jdField_e_of_type_Int;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public String f;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public String g;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString = "";
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private String jdField_l_of_type_JavaLangString;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private String jdField_m_of_type_JavaLangString;
  
  static
  {
    jdField_b_of_type_Boolean = AppSetting.jdField_b_of_type_Boolean;
  }
  
  public AddFriendVerifyActivity()
  {
    this.jdField_b_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new rix(this);
  }
  
  private String a()
  {
    Object localObject3 = ((FriendsManager)this.app.getManager(50)).a(this.app.c());
    Object localObject2 = "";
    String str = "";
    Object localObject1 = "";
    int i1 = 0;
    int n;
    Object localObject4;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      n = ((Card)localObject3).shGender;
      if (((Card)localObject3).shGender == 0)
      {
        localObject1 = getString(2131433941);
        i1 = ((Card)localObject3).age;
        str = ((Card)localObject3).strProvince;
        localObject2 = ((Card)localObject3).strCity;
        i1 = ((Card)localObject3).constellation;
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
      if ((bool) && (i1 == 0) && (n == -1)) {
        localObject1 = "欢迎大家随时撩我";
      }
      for (;;)
      {
        return (String)localObject1 + "~";
        localObject1 = localObject2;
        if (((Card)localObject3).shGender != 1) {
          break;
        }
        localObject1 = getString(2131433942);
        break;
        if ((bool) && (i1 == 0)) {
          localObject1 = "欢迎大家随时撩我";
        } else if ((bool) && (n == -1)) {
          localObject1 = "欢迎大家随时撩我";
        } else if ((i1 == 0) && (n == -1)) {
          localObject1 = "来自" + str + (String)localObject4;
        } else if (i1 == 0) {
          localObject1 = "来自" + str + (String)localObject4;
        } else if (n == -1) {
          localObject1 = "来自" + str + (String)localObject4 + "的" + (String)localObject2 + "一枚";
        } else if (bool) {
          localObject1 = (String)localObject2 + (String)localObject3 + "一枚";
        } else {
          localObject1 = "来自" + str + (String)localObject4 + "的" + (String)localObject2 + (String)localObject3 + "一枚";
        }
      }
      localObject3 = "";
      localObject2 = "";
      n = -1;
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
  
  private im_msg_body.RichMsg a(String paramString1, String paramString2, long paramLong)
  {
    paramString2 = new AddFriendVerifyActivity.27(this);
    paramString2.mMsgServiceID = 104;
    paramString2.mMsgBrief = paramString1;
    paramString2.mMsgTemplateID = 1;
    paramString1 = StructMsgElementFactory.a(2);
    paramString1.a(new rje(this, ""));
    paramString1.a(new StructMsgItemTitle("新人入群"));
    paramString2.addItem(paramString1);
    paramString1 = paramString2.getXmlBytes();
    if (paramString1 == null) {
      return null;
    }
    im_msg_body.RichMsg localRichMsg = new im_msg_body.RichMsg();
    localRichMsg.bytes_template_1.set(ByteStringMicro.copyFrom(paramString1));
    localRichMsg.uint32_service_id.set(paramString2.mMsgServiceID);
    return localRichMsg;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Int == 3090) {}
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
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 425	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 426	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 429	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 434	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 429	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 440	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload_2
    //   36: astore_3
    //   37: aload_0
    //   38: invokestatic 445	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;)I
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
    //   56: invokestatic 448	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
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
    //   74: invokestatic 451	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 456	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 459	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 460	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: ifnull -17 -> 87
    //   107: aload 4
    //   109: invokevirtual 456	android/graphics/Bitmap:recycle	()V
    //   112: return
    //   113: astore_0
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 456	android/graphics/Bitmap:recycle	()V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   41	14	1	n	int
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
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434453);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localTroopHandler.a(paramString1, paramString2, paramInt, this.jdField_j_of_type_JavaLangString, a(this.jdField_e_of_type_Int, this.jdField_k_of_type_JavaLangString, paramString2, l1, l2), this.jdField_l_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        paramString2 = "2";
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != null))
        {
          boolean bool = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().isChecked();
          ((BizTroopHandler)this.app.a(22)).a(null, this.jdField_b_of_type_JavaLangString, 3, bool);
          if (!bool) {
            break label462;
          }
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_open", 0, 0, paramString1, "", "", "");
          label219:
          if ((!this.jdField_a_of_type_Boolean) && (bool)) {
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_open", 0, 0, paramString1, "", "", "");
          }
          if ((this.jdField_a_of_type_Boolean) && (!bool)) {
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_close", 0, 0, paramString1, "", "", "");
          }
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label495;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean == true) && (!this.jdField_d_of_type_Boolean)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean == true)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      return;
      paramString2 = "0";
      break;
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "3";
      break;
      label462:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_close", 0, 0, paramString1, "", "", "");
      break label219;
      label495:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private boolean a()
  {
    int n = getIntent().getExtras().getInt("source_id", 3999);
    return (n == 3003) || (n == 3006) || (n == 3007) || (n == 3009) || (n == 3013);
  }
  
  private void b()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131430390, 0).b(getTitleBarHeight());
      c();
    }
    while (((TroopManager)this.app.getManager(51) == null) || (this.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    ((TroopHandler)this.app.a(20)).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramBoolean, true);
  }
  
  private boolean b()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.jdField_d_of_type_Boolean = ((TroopManager)this.app.getManager(51)).d(this.jdField_b_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean == true) {}
    for (String str = getString(2131430388);; str = getString(2131430387))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (((TroopInfoManager)this.app.getManager(36) == null) || (this.jdField_b_of_type_JavaLangString == null)) {}
    do
    {
      return;
      if (NetworkUtil.a(this) == 0)
      {
        QQToast.a(this, 2131429834, 0).b(getTitleBarHeight());
        a(paramBoolean);
        return;
      }
    } while (paramBoolean);
    DialogUtil.a(this, 230).setTitle(getString(2131433265)).setMessage(getString(2131430417)).setNegativeButton(getString(2131430418), new riz(this)).setPositiveButton(getString(2131430419), new riy(this, paramBoolean)).show();
  }
  
  private void d()
  {
    ((BizTroopHandler)this.app.a(22)).a(null, this.jdField_b_of_type_JavaLangString, 1, false);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131436158, 5);
    localActionSheet.a(2131436160, 5);
    localActionSheet.c(2131433015);
    localActionSheet.a(new rjc(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void f(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 0, 2131433016, null, new rjf(this, paramString));
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
  
  private void g(String paramString)
  {
    runOnUiThread(new rjj(this));
  }
  
  public void a()
  {
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject1 = new Intent(this, SplashActivity.class);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      ((Intent)localObject1).setFlags(67108864);
      startActivity((Intent)localObject1);
      finish();
      return;
    }
    Object localObject1 = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "goBack | retAddr = " + (String)localObject1);
    }
    if (localObject1 != null) {
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = Class.forName((String)localObject1);
          localObject1 = new Intent();
          ((Intent)localObject1).setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
          if ((localObject2.equals(FriendProfileCardActivity.class)) || (localObject2.equals(QidianProfileCardActivity.class)))
          {
            localObject2 = new ProfileActivity.AllInOne(this.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_Int == 47))
            {
              ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
              if (QLog.isColorLevel()) {
                QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendVerityActivity goBack  %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
              }
            }
            if (this.jdField_a_of_type_Int == 21) {
              ((Intent)localObject1).putExtra("troopUin", this.jdField_b_of_type_JavaLangString);
            }
            ((Intent)localObject1).putExtra("AllInOne", (Parcelable)localObject2);
            ((Intent)localObject1).setFlags(67108864);
            ((Intent)localObject1).putExtra("key_back_from_add_friend", true);
            startActivity((Intent)localObject1);
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
        if (localObject2.equals(NearbyPeopleProfileActivity.class))
        {
          localClassNotFoundException.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_i_of_type_JavaLangString, 41));
          localClassNotFoundException.putExtra("param_mode", 3);
        }
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", true);
      localIntent.putExtra("uin", this.jdField_i_of_type_JavaLangString);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      a(0, "");
      setResult(-1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new rjl(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
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
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (!NetworkUtil.d(this)) {}
    int i2;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131434613), 0).b(getTitleBarHeight());
      for (;;)
      {
        return;
        if (!isFinishing())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new rip(this));
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434453);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            Intent localIntent = getIntent();
            i2 = localIntent.getIntExtra("sub_source_id", 0);
            int i1 = localIntent.getIntExtra("friend_setting", 0);
            int n = i1;
            if (i1 == 3) {
              n = 100;
            }
            boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
            String str = localIntent.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_i_of_type_JavaLangString, localIntent.getStringExtra("extra"), n, (byte)this.jdField_b_of_type_Int, paramString, this.jdField_c_of_type_Int, i2, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0));
            if (!AutoRemarkActivity.a(n, this.jdField_c_of_type_Int, bool)) {
              ((FriendsManager)this.app.getManager(50)).a(this.jdField_i_of_type_JavaLangString, true);
            }
            if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_h_of_type_JavaLangString)) {
              ReportController.b(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
            if (localIntent.getIntExtra("sort_id", 0) == 3090) {
              ReportController.b(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
            }
            if (this.jdField_c_of_type_Int == 3094) {
              if (i2 == 1)
              {
                ReportController.b(this.app, "dc00898", "", "", "0X80092E3", "0X80092E3", 0, 0, "", "", "", "");
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, localException.toString());
              }
            }
          }
        }
      }
    } while (i2 != 2);
    ReportController.b(this.app, "dc00898", "", "", "0X80092CC", "0X80092CC", 0, 0, "", "", "", "");
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
              n = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (!QLog.isColorLevel()) {
                break label761;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, basics name = " + str + " state = " + n + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
              break label761;
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
              n = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (("add_friend".equals(localObject1)) && (n != 1)) {
                g(getActivity().getResources().getString(2131433685));
              }
              if (!QLog.isColorLevel()) {
                break label768;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str + " state = " + n + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
              break label768;
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
        int n = ((Integer)((JSONObject)localObject1).get("state")).intValue();
        String str = (String)((JSONObject)localObject1).get("api");
        localObject1 = (String)((JSONObject)localObject1).get("msg");
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + n + " api = " + str + " msg= " + (String)localObject1 + "\n");
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
      label761:
      paramInt += 1;
      continue;
      label768:
      paramInt += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(2));
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      localSwitch.setContentDescription(getString(2131430416));
      return;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1098	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1099	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +105 -> 133
    //   31: new 1101	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1102	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 9
    //   40: new 1104	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1105	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 10
    //   49: aload 10
    //   51: getfield 1108	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1112	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 359	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 9
    //   63: getfield 1116	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 10
    //   68: invokevirtual 1119	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1123	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 9
    //   77: invokevirtual 1128	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1101	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1102	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 9
    //   89: aload 9
    //   91: getfield 1132	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_0
    //   95: aload_3
    //   96: new 252	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   103: lload 4
    //   105: invokevirtual 1135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: ldc 92
    //   110: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: lload 6
    //   118: invokespecial 1137	com/tencent/mobileqq/activity/AddFriendVerifyActivity:a	(Ljava/lang/String;Ljava/lang/String;J)Ltencent/im/msg/im_msg_body$RichMsg;
    //   121: invokevirtual 1138	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   124: aload_2
    //   125: getfield 1123	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   128: aload 9
    //   130: invokevirtual 1128	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   133: new 1140	tencent/im/msg/im_msg_body$MsgBody
    //   136: dup
    //   137: invokespecial 1141	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   140: astore_3
    //   141: aload_3
    //   142: getfield 1145	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   145: aload_2
    //   146: invokevirtual 1146	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   149: new 1148	tencent/im/msg/im_msg$Msg
    //   152: dup
    //   153: invokespecial 1149	tencent/im/msg/im_msg$Msg:<init>	()V
    //   156: astore 10
    //   158: aload 10
    //   160: getfield 1153	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   163: aload_3
    //   164: invokevirtual 1154	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   167: new 1156	tencent/im/msg/im_msg$Group
    //   170: dup
    //   171: invokespecial 1157	tencent/im/msg/im_msg$Group:<init>	()V
    //   174: astore_3
    //   175: new 1159	tencent/im/msg/im_common$User
    //   178: dup
    //   179: invokespecial 1160	tencent/im/msg/im_common$User:<init>	()V
    //   182: astore 11
    //   184: aload 11
    //   186: getfield 1163	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   189: lload 4
    //   191: invokevirtual 1168	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   194: aload 11
    //   196: getfield 1171	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: sipush 1001
    //   202: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   205: aload 11
    //   207: getfield 1174	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   210: iconst_1
    //   211: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   214: aload 11
    //   216: getfield 1178	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   219: invokestatic 1182	com/dataline/util/DatalineMathUtil:a	()J
    //   222: l2i
    //   223: invokevirtual 1185	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   226: aload 11
    //   228: getfield 1188	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: bipush 109
    //   233: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   236: aload 11
    //   238: getfield 1191	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: getstatic 1192	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   244: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   247: aload_3
    //   248: getfield 1196	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   251: aload 11
    //   253: invokevirtual 1197	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   256: aload_3
    //   257: getfield 1196	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   260: getfield 1163	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   263: lload 4
    //   265: invokevirtual 1168	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   268: new 1199	tencent/im/msg/im_common$GroupInfo
    //   271: dup
    //   272: invokespecial 1200	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   275: astore_2
    //   276: aload_3
    //   277: getfield 1204	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   280: aload_2
    //   281: invokevirtual 1205	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   284: aload_3
    //   285: getfield 1204	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   288: getfield 1208	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   291: lload 6
    //   293: invokevirtual 1168	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   296: aload_3
    //   297: getfield 1204	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   300: getfield 1212	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   303: iconst_1
    //   304: invokevirtual 1215	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   307: new 1217	tencent/im/msg/im_msg$RoutingHead
    //   310: dup
    //   311: invokespecial 1218	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   314: astore_2
    //   315: aload_2
    //   316: getfield 1222	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   319: aload_3
    //   320: invokevirtual 1223	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   323: new 1225	tencent/im/msg/im_msg$ContentHead
    //   326: dup
    //   327: invokespecial 1226	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   330: astore_3
    //   331: aload_3
    //   332: getfield 1229	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   335: astore 9
    //   337: getstatic 77	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_g_of_type_Int	I
    //   340: istore_1
    //   341: iload_1
    //   342: iconst_1
    //   343: iadd
    //   344: putstatic 77	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_g_of_type_Int	I
    //   347: aload 9
    //   349: iload_1
    //   350: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   353: new 1231	tencent/im/msg/im_msg$MsgHead
    //   356: dup
    //   357: invokespecial 1232	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   360: astore 9
    //   362: aload 9
    //   364: getfield 1236	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   367: aload_3
    //   368: invokevirtual 1237	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: aload 9
    //   373: getfield 1241	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   376: aload_2
    //   377: invokevirtual 1242	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   380: aload 10
    //   382: getfield 1246	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   385: aload 9
    //   387: invokevirtual 1247	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   390: new 1249	tencent/im/msg/im_imagent$Signature
    //   393: dup
    //   394: invokespecial 1250	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   397: astore 12
    //   399: aload 12
    //   401: getfield 1253	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   404: iconst_1
    //   405: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   408: aload 12
    //   410: getfield 1256	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   413: sipush 256
    //   416: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: aload_0
    //   420: getfield 188	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   423: invokestatic 1261	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   426: astore_2
    //   427: aload_2
    //   428: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   431: istore 8
    //   433: aload_2
    //   434: astore 9
    //   436: iload 8
    //   438: ifeq +50 -> 488
    //   441: aconst_null
    //   442: areturn
    //   443: astore_3
    //   444: ldc 92
    //   446: astore_2
    //   447: aload_2
    //   448: astore 9
    //   450: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +35 -> 488
    //   456: ldc 209
    //   458: iconst_2
    //   459: new 252	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 1263
    //   469: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_3
    //   473: invokevirtual 1266	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 1269	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_2
    //   486: astore 9
    //   488: aload 12
    //   490: getfield 1272	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   493: aload 9
    //   495: invokestatic 1112	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   498: invokevirtual 359	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   501: new 1274	tencent/im/msg/im_imagent$ImAgentHead
    //   504: dup
    //   505: invokespecial 1275	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   508: astore_2
    //   509: aload_2
    //   510: getfield 1278	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   513: iconst_3
    //   514: invokevirtual 1215	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   517: aload_2
    //   518: getfield 1282	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   521: aload 12
    //   523: invokevirtual 1283	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   526: aload_2
    //   527: getfield 1286	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   530: aload 11
    //   532: invokevirtual 1197	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   535: aload_2
    //   536: getfield 1287	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   539: astore_3
    //   540: getstatic 77	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_g_of_type_Int	I
    //   543: istore_1
    //   544: iload_1
    //   545: iconst_1
    //   546: iadd
    //   547: putstatic 77	com/tencent/mobileqq/activity/AddFriendVerifyActivity:jdField_g_of_type_Int	I
    //   550: aload_3
    //   551: iload_1
    //   552: invokevirtual 368	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   555: new 1289	tencent/im/msg/im_msg$MsgSendReq
    //   558: dup
    //   559: invokespecial 1290	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   562: astore_3
    //   563: aload_3
    //   564: getfield 1293	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   567: aload 10
    //   569: invokevirtual 1294	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   572: new 1296	tencent/im/msg/im_imagent$ImAgentPackage
    //   575: dup
    //   576: invokespecial 1297	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   579: astore 9
    //   581: aload 9
    //   583: getfield 1300	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   586: aload_2
    //   587: invokevirtual 1301	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   590: aload 9
    //   592: getfield 1305	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   595: aload_3
    //   596: invokevirtual 1306	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   599: aload 9
    //   601: invokevirtual 1309	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   604: astore 9
    //   606: new 1311	java/io/ByteArrayOutputStream
    //   609: dup
    //   610: aload 9
    //   612: arraylength
    //   613: bipush 8
    //   615: iadd
    //   616: invokespecial 1313	java/io/ByteArrayOutputStream:<init>	(I)V
    //   619: astore_2
    //   620: new 1315	java/io/DataOutputStream
    //   623: dup
    //   624: aload_2
    //   625: invokespecial 1318	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   628: astore_3
    //   629: aload_3
    //   630: aload 9
    //   632: arraylength
    //   633: bipush 8
    //   635: iadd
    //   636: invokevirtual 1321	java/io/DataOutputStream:writeInt	(I)V
    //   639: aload_3
    //   640: bipush 123
    //   642: invokevirtual 1324	java/io/DataOutputStream:write	(I)V
    //   645: aload_3
    //   646: bipush 123
    //   648: invokevirtual 1324	java/io/DataOutputStream:write	(I)V
    //   651: aload_3
    //   652: aload 9
    //   654: invokevirtual 1327	java/io/DataOutputStream:write	([B)V
    //   657: aload_3
    //   658: bipush 125
    //   660: invokevirtual 1324	java/io/DataOutputStream:write	(I)V
    //   663: aload_3
    //   664: bipush 125
    //   666: invokevirtual 1324	java/io/DataOutputStream:write	(I)V
    //   669: aload_2
    //   670: invokevirtual 1328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   673: astore 9
    //   675: aload_2
    //   676: invokevirtual 1330	java/io/ByteArrayOutputStream:close	()V
    //   679: aload_3
    //   680: invokevirtual 1331	java/io/DataOutputStream:close	()V
    //   683: aload 9
    //   685: areturn
    //   686: astore_2
    //   687: aload 9
    //   689: areturn
    //   690: astore 9
    //   692: aload 9
    //   694: invokevirtual 1332	java/lang/Exception:printStackTrace	()V
    //   697: aload_2
    //   698: invokevirtual 1330	java/io/ByteArrayOutputStream:close	()V
    //   701: aload_3
    //   702: invokevirtual 1331	java/io/DataOutputStream:close	()V
    //   705: aconst_null
    //   706: areturn
    //   707: astore 9
    //   709: aload_2
    //   710: invokevirtual 1330	java/io/ByteArrayOutputStream:close	()V
    //   713: aload_3
    //   714: invokevirtual 1331	java/io/DataOutputStream:close	()V
    //   717: aload 9
    //   719: athrow
    //   720: astore_2
    //   721: goto -4 -> 717
    //   724: astore_2
    //   725: goto -20 -> 705
    //   728: astore_3
    //   729: goto -282 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	this	AddFriendVerifyActivity
    //   0	732	1	paramInt	int
    //   0	732	2	paramString1	String
    //   0	732	3	paramString2	String
    //   0	732	4	paramLong1	long
    //   0	732	6	paramLong2	long
    //   431	6	8	bool	boolean
    //   38	650	9	localObject1	Object
    //   690	3	9	localException	Exception
    //   707	11	9	localObject2	Object
    //   47	521	10	localObject3	Object
    //   182	349	11	localUser	tencent.im.msg.im_common.User
    //   397	125	12	localSignature	tencent.im.msg.im_imagent.Signature
    // Exception table:
    //   from	to	target	type
    //   419	427	443	java/lang/InterruptedException
    //   675	683	686	java/lang/Exception
    //   629	675	690	java/lang/Exception
    //   629	675	707	finally
    //   692	697	707	finally
    //   709	717	720	java/lang/Exception
    //   697	705	724	java/lang/Exception
    //   427	433	728	java/lang/InterruptedException
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if (AutoRemarkActivity.a(paramEditable) > 32)
    {
      int n = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = AutoRemarkActivity.a(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (n >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131433493) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
    }
  }
  
  public void b(String paramString)
  {
    if (!NetworkUtil.d(this)) {}
    ArrayList localArrayList;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131434460), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while (!getIntent().hasExtra("contacts"));
      localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new riq(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434453);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_c_of_type_Int, new ArrayList());
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
      QQToast.a(getApplicationContext(), 1, 2131430227, 0).b(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new rjd(this, paramString), 5, null, false);
  }
  
  public void d(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (Utils.a(paramString, this.jdField_d_of_type_JavaLangString))) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramString;
    paramString = getString(2131434467);
    String str1 = paramString + ContactUtils.a(this.app, this.app.getCurrentAccountUin());
    String str2 = a(false);
    if ((TextUtils.isEmpty(str2)) || (Utils.a(str2, str1))) {}
    for (this.jdField_e_of_type_JavaLangString = (paramString + this.jdField_d_of_type_JavaLangString);; this.jdField_e_of_type_JavaLangString = str2)
    {
      runOnUiThread(new rji(this, str1));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AddFriendVerifyActivity", 2, String.format(Locale.getDefault(), "updateSelfCampusName [%s, %s]", new Object[] { this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }));
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    switch (paramInt1)
    {
    default: 
    case 1001: 
      do
      {
        return;
        paramIntent = this.jdField_a_of_type_AndroidNetUri.getPath();
      } while (TextUtils.isEmpty(paramIntent));
      this.jdField_m_of_type_JavaLangString = paramIntent;
      a(this.jdField_m_of_type_JavaLangString);
      c(this.jdField_m_of_type_JavaLangString);
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, paramInt1));
    this.jdField_b_of_type_AndroidViewView.setContentDescription("分组：" + AutoRemarkActivity.a(this.app, paramInt1));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_d_of_type_Int = localIntent.getIntExtra("k_uin_type", 1);
    if (this.jdField_d_of_type_Int != 4) {
      setTheme(2131624738);
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    Object localObject2;
    Object localObject1;
    int n;
    label1069:
    label1624:
    label1646:
    label1903:
    int i1;
    if (this.jdField_d_of_type_Int == 4)
    {
      setContentViewB(2130968621);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362914));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362915));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362917));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362918));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362921));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362922));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362920));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366465));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362767));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361845));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362923));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362924));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362925));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131362926));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362927));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434693);
      this.jdField_j_of_type_JavaLangString = localIntent.getStringExtra("authKey");
      if (this.jdField_j_of_type_JavaLangString != null) {}
      paramBundle = getIntent().getExtras().getString("nick_name");
      if (this.jdField_d_of_type_Int == 4)
      {
        setTitle(2131436520);
        localObject2 = (TextView)findViewById(2131363245);
        localObject1 = getIntent().getExtras().getString("leftViewText");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = getString(2131433698);
        }
        ((TextView)localObject2).setText(paramBundle);
        this.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
        this.jdField_c_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
        d();
        findViewById(2131362929).setVisibility(0);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.jdField_g_of_type_JavaLangString = getIntent().getExtras().getString("key_param_homework_intro_str");
        if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          ((TroopHandler)this.app.a(20)).c(this.jdField_b_of_type_JavaLangString);
        }
        n = getIntent().getExtras().getShort("group_option", (short)2);
        paramBundle = getIntent().getExtras().getString("troop_question");
        localObject1 = getIntent().getExtras().getString("troop_answer");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362928));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getResources().getString(2131430416));
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        ((Switch)localObject2).setTag(Integer.valueOf(2));
        ((Switch)localObject2).setChecked(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131430416));
      }
    }
    else
    {
      switch (n)
      {
      case 3: 
      default: 
      case 1: 
      case 2: 
      case 4: 
        label1928:
        label1933:
        do
        {
          getWindow().setSoftInputMode(5);
          if (this.jdField_d_of_type_Int == 3)
          {
            paramBundle = localIntent.getStringExtra("is_from_game");
            localObject1 = localIntent.getStringExtra("extra");
            if (("true".equals(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              TroopUtils.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
            }
          }
          enableRightHighlight(true);
          SearchProtocol.a(this, 10800000L, AddFriendVerifyActivity.class.getSimpleName());
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 0, 0, "", "", "", "");
          if (QidianManager.b(this.app, this.jdField_i_of_type_JavaLangString)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("webImVisitId");
          return true;
          setContentViewB(2130968620);
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
          this.jdField_a_of_type_Int = getIntent().getIntExtra("param_return_profilecard_pa", 19);
          if ((this.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_Int == 46))
          {
            this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("param_return_profilecard_discuss_uin");
            if (QLog.isColorLevel()) {
              QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendVerityActivity  %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
            }
          }
          if (this.jdField_a_of_type_Int == 21) {
            this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_return_profilecard_troop_uin");
          }
          n = getIntent().getIntExtra("sub_source_id", 0);
          this.jdField_c_of_type_Int = localIntent.getIntExtra("source_id", 3999);
          if (localIntent.hasExtra("param_wzry_data")) {
            this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)localIntent.getSerializableExtra("param_wzry_data"));
          }
          if (ProfileActivity.e(this.jdField_c_of_type_Int))
          {
            this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
            ThreadManager.post(new ril(this), 5, null, true);
            if (QLog.isColorLevel()) {
              QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.jdField_h_of_type_JavaLangString + ", source id=" + this.jdField_c_of_type_Int + ", mTargetGroupId = " + this.jdField_b_of_type_Int);
            }
            if ((paramBundle == null) && (NetworkUtil.d(this)) && (AutoRemarkActivity.a(this.jdField_c_of_type_Int, this.jdField_i_of_type_JavaLangString))) {
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_i_of_type_JavaLangString, this.jdField_c_of_type_Int, localIntent.getIntExtra("sub_source_id", 0));
            }
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363451));
            this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new riw(this));
            this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362897));
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362896));
            this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(100, this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362895));
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            paramBundle = getIntent().getStringExtra("key_param_age_area");
            if (!TextUtils.isEmpty(paramBundle))
            {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
              if (AppSetting.jdField_b_of_type_Boolean) {
                this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
              }
            }
            this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362903));
            this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362905));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362893));
            this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362894));
            this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362907));
            this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362906));
            this.jdField_a_of_type_AndroidViewView = findViewById(2131362908);
            this.jdField_b_of_type_AndroidViewView = findViewById(2131362910);
            this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362909));
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362911));
            this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
            this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
            this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_h_of_type_JavaLangString);
            if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
              this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_h_of_type_JavaLangString.length());
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.app, this.jdField_b_of_type_Int));
            this.jdField_b_of_type_AndroidViewView.setContentDescription("分组：" + AutoRemarkActivity.a(this.app, this.jdField_b_of_type_Int));
            if (!Utils.b(this.jdField_i_of_type_JavaLangString)) {
              break label1903;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_i_of_type_AndroidWidgetTextView.setText(getString(2131433097));
            if ((!EAddFriendSourceID.a(this.jdField_c_of_type_Int)) && (this.jdField_c_of_type_Int != 3016)) {
              break label1928;
            }
            n = 1;
            if (n == 0)
            {
              this.jdField_c_of_type_AndroidViewView = findViewById(2131362912);
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131362913));
              this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
            }
            if (!AppSetting.jdField_b_of_type_Boolean) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131434577));
            if (Utils.b(this.jdField_i_of_type_JavaLangString)) {
              break label1933;
            }
            this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433098));
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidViewView.setFocusable(true);
            this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131433493) + this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
            if (n != 0) {
              break;
            }
            this.jdField_c_of_type_AndroidViewView.setFocusable(true);
            this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131435181));
            break;
            if (AutoRemarkActivity.a(this.jdField_c_of_type_Int))
            {
              this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
              break label1069;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
            {
              this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
              break label1069;
            }
            if ((this.jdField_c_of_type_Int != 3004) || (n != 5)) {
              break label1069;
            }
            this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
            break label1069;
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_i_of_type_AndroidWidgetTextView.setText(getString(2131433096));
            break label1624;
            n = 0;
            break label1646;
            this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433099));
          }
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
          ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = 0;
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(FaceDrawable.a(this.app, this.app.getCurrentAccountUin(), (byte)1));
          this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_c_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(100.0F, getResources()));
          this.jdField_c_of_type_AndroidWidgetEditText.setSingleLine(false);
          this.jdField_c_of_type_AndroidWidgetEditText.setGravity(48);
          this.jdField_c_of_type_AndroidWidgetEditText.setBackgroundResource(2130846001);
          this.jdField_c_of_type_AndroidWidgetEditText.setHint("");
          n = AIOUtils.a(10.0F, getResources());
          this.jdField_c_of_type_AndroidWidgetEditText.setPadding(n, n, n, n);
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
          for (paramBundle = getString(2131430301, new Object[] { this.app.getCurrentNickname() });; paramBundle = this.jdField_g_of_type_JavaLangString)
          {
            e(paramBundle);
            setRightHighlightButton(2131433631, new rjg(this));
            break;
          }
          this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.jdField_e_of_type_AndroidWidgetLinearLayout.getId());
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(this, 15.0F));
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          paramBundle = new QQText(getString(2131434470) + ":" + paramBundle, 13);
          this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
          this.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_b_of_type_JavaLangString);
          this.jdField_l_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
          if (jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131432556));
          }
          setRightHighlightButton(2131433631, new rjm(this, (String)localObject1));
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        } while (paramBundle.jdField_b_of_type_Int <= 0);
        i1 = 0;
        while (i1 < paramBundle.a.length)
        {
          if ((paramBundle.a[i1] instanceof QQText.LinkSpan)) {
            break label2443;
          }
          label2436:
          i1 += 1;
        }
        label2443:
        localObject1 = ((QQText.LinkSpan)paramBundle.a[i1]).jdField_a_of_type_JavaLangString;
        n = -1;
        if (Patterns.d.matcher((CharSequence)localObject1).find()) {
          n = 0;
        }
        if (QQText.jdField_b_of_type_JavaUtilRegexPattern.matcher((CharSequence)localObject1).find()) {
          n = 1;
        }
        if (QQText.e.matcher((CharSequence)localObject1).find()) {
          n = 2;
        }
        break;
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_b_of_type_JavaLangString, "" + n, "", "");
      break label2436;
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_e_of_type_AndroidWidgetLinearLayout.getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)DisplayUtils.a(this, 15.0F));
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBundle = new QQText(getString(2131434470) + ":" + paramBundle, 13);
      this.jdField_l_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_b_of_type_JavaLangString);
      this.jdField_l_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131432556));
      }
      setRightHighlightButton(2131433631, new rjn(this));
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      if (paramBundle.jdField_b_of_type_Int <= 0) {
        break;
      }
      i1 = 0;
      while (i1 < paramBundle.a.length)
      {
        if ((paramBundle.a[i1] instanceof QQText.LinkSpan)) {
          break label2823;
        }
        label2816:
        i1 += 1;
      }
      break;
      label2823:
      localObject1 = ((QQText.LinkSpan)paramBundle.a[i1]).jdField_a_of_type_JavaLangString;
      n = -1;
      if (Patterns.d.matcher((CharSequence)localObject1).find()) {
        n = 0;
      }
      if (QQText.jdField_b_of_type_JavaUtilRegexPattern.matcher((CharSequence)localObject1).find()) {
        n = 1;
      }
      if (QQText.e.matcher((CharSequence)localObject1).find()) {
        n = 2;
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.jdField_b_of_type_JavaLangString, "" + n, "", "");
        break label2816;
        setTitle(2131433032);
        setLeftButton("取消", null);
        localObject1 = (CardHandler)this.app.a(2);
        label3021:
        int i2;
        label3110:
        label3152:
        int i3;
        if (EAddFriendSourceID.a(getIntent().getIntExtra("sort_id", 0)))
        {
          localObject2 = this.jdField_i_of_type_JavaLangString;
          ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject2, 0L, 10004, null, (byte)0);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
          i2 = getIntent().getExtras().getInt("source_id", 3999);
          if (this.jdField_d_of_type_Int != 2) {
            break label3461;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 11, this.jdField_i_of_type_JavaLangString));
          localObject2 = this.jdField_j_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(paramBundle)) {
            break label3455;
          }
          localObject1 = this.jdField_i_of_type_JavaLangString;
          ((TextView)localObject2).setText((CharSequence)localObject1);
          if (AppSetting.jdField_b_of_type_Boolean)
          {
            localObject2 = this.jdField_j_of_type_AndroidWidgetTextView;
            localObject1 = paramBundle;
            if (TextUtils.isEmpty(paramBundle)) {
              localObject1 = this.jdField_i_of_type_JavaLangString;
            }
            ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
          }
          i3 = localIntent.getIntExtra("friend_setting", 0);
          localObject1 = getIntent().getExtras().getStringArrayList("user_question");
        }
        switch (i3)
        {
        default: 
          break;
        case 0: 
        case 2: 
          if ((i2 == 3078) || (i2 == 3079))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433093));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433095));
            }
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (getIntent() != null) {}
            for (n = getIntent().getIntExtra("contact_from_type", 1);; n = 1)
            {
              setRightHighlightButton(2131433631, new rjq(this, n));
              paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
              paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
              paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
              this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
              break;
              ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), this.jdField_i_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
              break label3021;
              localObject1 = paramBundle;
              break label3110;
              if (this.jdField_d_of_type_Int == 3)
              {
                localObject1 = localIntent.getStringExtra("extra");
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(FaceDrawable.a(this.jdField_i_of_type_JavaLangString, (String)localObject1)));
                this.jdField_j_of_type_AndroidWidgetTextView.setText(paramBundle);
                if (AppSetting.jdField_b_of_type_Boolean) {
                  this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
                }
                ((FriendListHandler)this.app.a(1)).a(this.jdField_i_of_type_JavaLangString, getIntent().getStringExtra("extra"));
                break label3152;
              }
              if ((i2 == 3007) || (i2 == 2007) || (i2 == 4007) || (i2 == 3019) || (i2 == 2019)) {
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 200, this.jdField_i_of_type_JavaLangString, true));
              }
              for (;;)
              {
                if (!a()) {
                  break label3671;
                }
                if (paramBundle == null) {
                  break;
                }
                this.jdField_j_of_type_AndroidWidgetTextView.setText(paramBundle);
                if (!AppSetting.jdField_b_of_type_Boolean) {
                  break;
                }
                this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(paramBundle);
                break;
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_i_of_type_JavaLangString));
              }
              ThreadManager.getSubThreadHandler().post(new rjo(this, paramBundle));
              break label3152;
            }
          }
          setRightHighlightButton(2131433631, new rjr(this));
          paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, "", "", "", "");
          a(i2, i3);
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (AppSetting.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433095));
          }
          setRightHighlightButton(2131433631, new rjs(this, i2, i3));
          paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
          paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, "", "", "", "");
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          paramBundle = (String)((ArrayList)localObject1).get(0);
          localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362961);
          localObject2 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369399);
          this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher = new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject2);
          ((EditText)localObject2).addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$MaxBytesTextWatcher);
          ((TextView)localObject1).setText(getString(2131434470) + ":" + paramBundle);
          ((EditText)localObject2).setSingleLine(true);
          if (jdField_b_of_type_Boolean)
          {
            ((TextView)localObject1).setContentDescription(getString(2131434470) + ":" + paramBundle);
            ((EditText)localObject2).setContentDescription(getString(2131432557));
          }
          setRightHighlightButton(2131433631, new rim(this, (EditText)localObject2, i3, i2));
          getWindow().setSoftInputMode(5);
          paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramBundle.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
          paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, "", "", "", "");
          break;
        case 4: 
          label3455:
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          label3461:
          label3671:
          localObject2 = new StringBuffer();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1)) {}
          for (n = 1;; n = 0)
          {
            i1 = 0;
            if (i1 < ((ArrayList)localObject1).size())
            {
              switch (i1)
              {
              default: 
                paramBundle = getResources().getString(2131434470);
              }
              for (;;)
              {
                Object localObject5 = getLayoutInflater().inflate(2130970170, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
                Object localObject3 = getLayoutInflater().inflate(2130970169, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
                if (i1 > 0)
                {
                  localObject4 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
                  if (localObject4 != null)
                  {
                    ((LinearLayout.LayoutParams)localObject4).topMargin = ((int)DisplayUtils.a(getApplication(), 19.0F));
                    ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                  }
                }
                this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject5);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
                Object localObject4 = (String)((ArrayList)localObject1).get(i1);
                localObject5 = (TextView)((View)localObject5).findViewById(2131362961);
                ((TextView)localObject5).setText(paramBundle + (String)localObject4);
                localObject3 = (EditText)((View)localObject3).findViewById(2131369399);
                ((EditText)localObject3).addTextChangedListener(new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject3));
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
                if (jdField_b_of_type_Boolean)
                {
                  ((TextView)localObject5).setContentDescription(paramBundle + (String)localObject4);
                  ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).setContentDescription(getString(2131432557));
                }
                int i4 = i1 + 1;
                ((StringBuffer)localObject2).append(getString(2131434470) + i4 + ":" + (String)localObject4);
                ((StringBuffer)localObject2).append("\n");
                ((StringBuffer)localObject2).append(getString(2131434474) + ":${answer}");
                if (i4 != ((ArrayList)localObject1).size()) {
                  ((StringBuffer)localObject2).append("\n");
                }
                i1 += 1;
                break;
                if (n != 0)
                {
                  paramBundle = getResources().getString(2131434695);
                }
                else
                {
                  paramBundle = getResources().getString(2131434696);
                  continue;
                  paramBundle = getResources().getString(2131434697);
                  continue;
                  paramBundle = getResources().getString(2131434698);
                  continue;
                  paramBundle = getResources().getString(2131434699);
                  continue;
                  paramBundle = getResources().getString(2131434700);
                }
              }
            }
            setRightHighlightButton(2131433631, new rin(this, (StringBuffer)localObject2, i2, i3));
            findViewById(2131362892).setOnTouchListener(new rio(this));
            getWindow().setSoftInputMode(4);
            paramBundle = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramBundle.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
            ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, "", "", "", "");
            break;
          }
        }
      }
    }
  }
  
  protected void doOnDestroy()
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_m_of_type_JavaLangString = ((String)paramIntent.get(0));
      c(this.jdField_m_of_type_JavaLangString);
    }
  }
  
  protected void doOnResume()
  {
    Object localObject5 = null;
    int n = 1;
    int i1 = 0;
    super.doOnResume();
    if (this.jdField_d_of_type_Int != 4) {}
    String str1;
    Object localObject3;
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.jdField_c_of_type_Int != 3078) && (this.jdField_c_of_type_Int != 3079));
      str1 = a(false);
      localObject3 = getString(2131434467);
      if (TextUtils.isEmpty(str1)) {
        if (!b()) {
          str1 = (String)localObject3 + ContactUtils.a(this.app, this.app.getAccount());
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
      if (n != 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject3).length(), str1.length());
        for (;;)
        {
          label172:
          getWindow().setSoftInputMode(5);
          return;
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str1.length());
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label172;
      }
      String str2 = getString(2131434467);
      Object localObject1;
      if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
      {
        localObject3 = str2 + getString(2131432051) + " " + ContactUtils.a(this.app, this.app.getAccount());
        this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131433095));
        }
        if (!ProfileActivity.e(this.jdField_c_of_type_Int)) {
          break label524;
        }
        localObject1 = this.jdField_e_of_type_JavaLangString;
        n = 1;
      }
      for (;;)
      {
        label358:
        Object localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = a(false);
        }
        if (TextUtils.isEmpty((CharSequence)localObject4)) {}
        for (;;)
        {
          if ((n != 0) && (str2.equals(localObject3)) && (!b()))
          {
            localObject1 = localObject5;
            if (ProfileActivity.e(this.jdField_c_of_type_Int)) {
              localObject1 = this.jdField_d_of_type_JavaLangString;
            }
            localObject4 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject4 = ContactUtils.a(this.app, this.app.getAccount());
            }
            localObject1 = (String)localObject3 + (String)localObject4;
          }
          for (n = 1;; n = i1)
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
              if (n != 0) {}
              try
              {
                this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str2.length(), ((String)localObject1).length());
                for (;;)
                {
                  label499:
                  getWindow().setSoftInputMode(5);
                  return;
                  this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
                  localObject3 = str2;
                  break;
                  label524:
                  if (this.jdField_d_of_type_Int == 3)
                  {
                    localObject1 = getIntent().getStringExtra("msg");
                    n = 1;
                    break label358;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) {
                    break label613;
                  }
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg;
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label608;
                  }
                  n = 0;
                  break label358;
                  this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
                }
              }
              catch (Throwable localThrowable2)
              {
                break label499;
              }
            }
            localObject2 = localObject3;
          }
          localObject3 = localObject4;
        }
        label608:
        n = 1;
        continue;
        label613:
        n = 1;
        localObject2 = null;
      }
      n = 0;
      Object localObject2 = localObject3;
      continue;
      n = 0;
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_d_of_type_Int != 4) {
      this.jdField_h_of_type_AndroidWidgetTextView.setText("30");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
      return;
      int i1 = 0;
      try
      {
        n = paramString.getBytes("utf-8").length;
        this.jdField_h_of_type_AndroidWidgetTextView.setText(90 - n + "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int n = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
            n = i1;
          }
        }
      }
    }
  }
  
  public void finish()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.jdField_d_of_type_Int != 4) {
      overridePendingTransition(0, 2131034135);
    }
  }
  
  protected boolean onBackEvent()
  {
    boolean bool = true;
    Object localObject;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      return super.onBackEvent();
    }
    if (this.jdField_d_of_type_Int != 4)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 != this.jdField_d_of_type_Int) {
        break label173;
      }
    }
    for (;;)
    {
      a((String)localObject, bool);
      if ((getString(2131434467).equals(localObject)) && (!b())) {
        b();
      }
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        ReportController.b(this.app, "dc00899", "Qidian", this.jdField_i_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
      }
      return super.onBackEvent();
      label173:
      bool = false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, 1, 2131434811, 0).b(getTitleBarHeight());
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null)
      {
        paramCompoundButton = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean) {
          bool = true;
        }
        paramCompoundButton.setChecked(bool);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this);
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
      {
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131435181));
        }
        Intent localIntent = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        localIntent.putExtra("qzone_permission_uin", this.jdField_i_of_type_JavaLangString);
        localIntent.putExtra("qzone_permission_operateType", 1);
        localIntent.putExtra("qzone_permission_value", paramBoolean);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.jdField_d_of_type_JavaLangString = "QQ空间";
        localPluginParams.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
        localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        localPluginParams.jdField_e_of_type_JavaLangString = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        IPluginManager.a(this.app.getApp(), localPluginParams);
        ReportController.b(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      paramCompoundButton = paramCompoundButton.getTag();
    } while ((!(paramCompoundButton instanceof Integer)) || ((TroopManager)this.app.getManager(51) == null) || (this.jdField_b_of_type_JavaLangString == null));
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    case 1: 
      b(paramBoolean);
      return;
    }
    c(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_i_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_b_of_type_Int);
    paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    startActivityForResult(paramView, 1002);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
    }
    ReportController.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131369399) {}
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