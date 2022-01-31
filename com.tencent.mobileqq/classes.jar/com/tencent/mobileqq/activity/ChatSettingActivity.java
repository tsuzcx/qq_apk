package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ryw;
import ryx;
import ryy;
import ryz;
import rza;
import rzb;
import rzc;
import rzd;
import rze;
import rzf;
import rzg;
import rzh;
import rzi;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_b_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rzg(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rzf(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new rzi(this);
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new rzb(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new rzh(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ryy(this);
  public RichStatus a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private XSimpleListAdapter jdField_a_of_type_ComTencentWidgetXSimpleListAdapter;
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public MqqHandler a;
  public boolean a;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 3;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  public TextView f;
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean;
  private String k = "";
  
  public ChatSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "ChatSettingActivity.nearby";
    this.jdField_a_of_type_MqqOsMqqHandler = new rze(this);
  }
  
  private void A()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_a_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    }
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void B()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void C()
  {
    ryx localryx = new ryx(this);
    if (!this.jdField_j_of_type_Boolean) {
      ThreadManager.post(localryx, 8, null, true);
    }
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.a(paramString.toString(), null);
    } while (paramString == null);
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label151;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label151:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendsManager)this.app.getManager(50)).a(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = (FriendsManager)this.app.getManager(50);
    } while (localObject == null);
    Friends localFriends = ((FriendsManager)localObject).c(paramString);
    if (localFriends != null) {
      if (localFriends.remark != null)
      {
        paramString = localFriends.remark;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (TextUtils.isEmpty(localFriends.name)) {}
        }
      }
    }
    for (Object localObject = localFriends.name;; localObject = null)
    {
      return localObject;
      paramString = null;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramInt <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int m = paramInt;
    if (paramInt > 999) {
      m = 999;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(m + "天");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845800);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845799);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845786);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845785);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_f_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_e_of_type_Int |= 0x1;
          a(paramIntent);
          e(getString(2131435319));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(2131435764, 1);
        return;
      }
      a(2131435763, 0);
      return;
    }
    a(2131434595, 1);
  }
  
  private void a(FriendsManager paramFriendsManager, ExtensionInfo paramExtensionInfo)
  {
    int m;
    int i1;
    int i2;
    int i3;
    int n;
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      boolean bool = paramFriendsManager.d();
      m = paramFriendsManager.a(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, 1, bool);
      i1 = paramFriendsManager.b(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      i2 = paramFriendsManager.c(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      i3 = paramFriendsManager.a(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      n = paramFriendsManager.d(this.jdField_c_of_type_JavaLangString, paramExtensionInfo, bool);
      if (m > 0)
      {
        paramFriendsManager = HotReactiveHelper.a(this, 19);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(String.format(paramFriendsManager, new Object[] { Integer.valueOf(m) }));
      }
      if (i1 != 1) {
        break label196;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 1));
    }
    label146:
    label167:
    label195:
    label196:
    label238:
    label243:
    do
    {
      break label195;
      if (i2 == 1)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 3));
        if (i3 != 1) {
          break label243;
        }
        paramFriendsManager = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!paramExtensionInfo.isQzoneLover) {
          break label238;
        }
        m = 59;
        paramFriendsManager.setContentDescription(HotReactiveHelper.a(this, m));
      }
      for (;;)
      {
        if (n == 1)
        {
          this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 36));
          return;
          if (i1 != 2) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 2));
          break;
          if (i2 != 2) {
            break label146;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 4));
          break label146;
          m = 5;
          break label167;
          if (i3 == 2)
          {
            paramFriendsManager = this.jdField_d_of_type_AndroidWidgetImageView;
            if (paramExtensionInfo.isQzoneLover) {}
            for (m = 60;; m = 6)
            {
              paramFriendsManager.setContentDescription(HotReactiveHelper.a(this, m));
              break;
            }
          }
        }
      }
    } while (n != 2);
    this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HotReactiveHelper.a(this, 37));
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_f_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
      if (localStatusManager != null) {}
      for (paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);; paramRichStatus = BitmapManager.a(getResources(), 2130845328))
      {
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else {
      return;
    }
    paramString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(50)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    paramString = localFriendsManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendsManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845803);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845802);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845789);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845788);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int m = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((FriendsManager)this.app.getManager(50)).a(String.valueOf(m));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramInt == 1)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (paramInt = 2130845794;; paramInt = 2130845801)
      {
        localImageView.setImageResource(paramInt);
        return;
      }
    }
    if (paramInt == 2)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (paramInt = 2130845793;; paramInt = 2130845787)
      {
        localImageView.setImageResource(paramInt);
        return;
      }
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(String paramString)
  {
    Object localObject = this.app.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.a().e(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
          }
          paramString = this.app.getHandler(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.jdField_c_of_type_JavaLangString;
          ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void d()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  private void d(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845796);
        return;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845795);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845798);
        return;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845797);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    if (Utils.b(paramString)) {
      localActionSheet.a(2131434511);
    }
    for (;;)
    {
      localActionSheet.a(2131434501, 3);
      localActionSheet.c(2131432998);
      localActionSheet.a(new rzd(this, paramString, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.a(2131434510);
    }
  }
  
  private void e()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    this.app.removeHandler(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = null;
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130971460);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131434436));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  private void f()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("follow_flag", false);
    if ((this.jdField_a_of_type_Int == 0) && (!a(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 1003;
    }
    if ((1 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      j();
    }
    for (;;)
    {
      setTitle(2131435258);
      setLeftViewName(2131432397);
      setContentBackgroundResource(2130838210);
      return;
      i();
    }
  }
  
  private void h()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.d());
      localWebProcessManager.e();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "start preloadWebProcess");
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130969040, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    try
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130968774, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
      super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363683));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363684));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363686));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363689));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363690));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363691));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363693));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363692));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363687));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363694));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363672));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363673));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363674));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363699));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363700));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363697));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363698));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363696));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363701));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (Build.VERSION.SDK_INT <= 25)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131435696));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131434342));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433632));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433634));
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131435242));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131436844));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131435279));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131437147));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131435246));
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131434501));
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131434691));
        }
        this.jdField_f_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_f_of_type_JavaLangString == null) {
          this.jdField_f_of_type_JavaLangString = "";
        }
        a(this.jdField_f_of_type_JavaLangString);
        if (this.jdField_f_of_type_JavaLangString != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_JavaLangString != null)
        {
          localObject = FaceDrawable.a(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        a(a(this.jdField_c_of_type_JavaLangString), this.jdField_c_of_type_AndroidWidgetTextView);
        this.jdField_g_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_g_of_type_JavaLangString == null) {
          this.jdField_g_of_type_JavaLangString = "";
        }
        b(this.jdField_g_of_type_JavaLangString);
        q();
        if (!Utils.b(this.jdField_c_of_type_JavaLangString)) {
          break label1013;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        Object localObject = (LinearLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this, 20.0F);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localObject = ((FriendsManager)this.app.getManager(50)).b(AppConstants.au);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject).babyQSwitch);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        ((CardHandler)this.app.a(2)).r();
      }
      for (;;)
      {
        if (QidianManager.b(this.app, this.jdField_c_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        if (this.app != null)
        {
          w();
          b();
        }
        return;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break;
        label1013:
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void j()
  {
    Object localObject1 = View.inflate(this, 2130968776, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131363710));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130968775, null);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363704);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363702));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363707));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363703));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363705));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363706));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131363708));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363709));
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
      v();
    }
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131363711));
    int m;
    label399:
    label479:
    label621:
    String str;
    label716:
    boolean bool;
    label788:
    label803:
    label1066:
    QQAppInterface localQQAppInterface;
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131435696));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131435275));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131435279));
      localObject1 = this.jdField_b_of_type_AndroidWidgetButton;
      if ((1001 != this.jdField_a_of_type_Int) && (10002 != this.jdField_a_of_type_Int)) {
        break label1166;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        m = 2131430499;
        ((Button)localObject1).setContentDescription(getString(m));
        this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131434693));
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int != 10004) {
        break label1173;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1006) || (this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false))) {
        break label1184;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject1 != null) {
        ((Switch)localObject1).setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1211;
      }
      localObject1 = FaceDrawable.a(this.app, 200, this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002)) {
        break label1326;
      }
      if (this.jdField_a_of_type_Int == 1006)
      {
        this.k = this.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.k)) {
          break label1281;
        }
        this.jdField_g_of_type_Boolean = false;
      }
      localObject1 = (ShieldMsgManger)this.app.getManager(15);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_f_of_type_Boolean = ((ShieldMsgManger)localObject1).a(this.jdField_i_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, shieldMsgManger=");
        if (localObject1 != null) {
          break label1321;
        }
        bool = true;
        QLog.d(str, 2, bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initStrangerView, curType=" + this.jdField_a_of_type_Int + ", mShieldUin=" + this.jdField_i_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldEnable=" + this.jdField_g_of_type_Boolean);
      }
      if (!a(this.jdField_a_of_type_Int)) {
        break label1429;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      label898:
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_i_of_type_Boolean = true;
      u();
      a(a(this.jdField_c_of_type_JavaLangString), this.jdField_h_of_type_AndroidWidgetTextView);
      localObject1 = new String[1];
      localObject1[0] = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        c();
      }
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1441;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, true);
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int != 1001) {
          break label1453;
        }
        localObject1 = "0";
        label1106:
        if (!this.jdField_a_of_type_Boolean) {
          break label1460;
        }
        str = "0";
        label1118:
        if (!this.jdField_f_of_type_Boolean) {
          break label1468;
        }
      }
    }
    label1166:
    label1173:
    label1184:
    label1211:
    label1468:
    for (Object localObject2 = "0";; localObject2 = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      return;
      m = 2131430497;
      break;
      m = 2131435276;
      break;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label399;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label479;
      if (this.jdField_a_of_type_Int == 1006)
      {
        localObject1 = FaceDrawable.b(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label621;
      }
      localObject1 = FaceDrawable.a(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label621;
      localObject1 = ContactUtils.g(this.app, this.k);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_g_of_type_Boolean = false;
        break label716;
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_i_of_type_JavaLangString = ((String)localObject1);
      break label716;
      bool = false;
      break label788;
      localObject1 = ((FriendsManager)this.app.getManager(50)).c(this.jdField_i_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, f=");
        if (localObject1 != null) {
          break label1416;
        }
      }
      for (bool = true;; bool = false)
      {
        QLog.d(str, 2, bool);
        if ((localObject1 == null) || (((Friends)localObject1).groupid != -1002)) {
          break label1421;
        }
        this.jdField_f_of_type_Boolean = true;
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      break label803;
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      break label898;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, false);
      break label1066;
      localObject1 = "1";
      break label1106;
      str = "1";
      break label1118;
    }
  }
  
  private void k()
  {
    int m = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0);
    Object localObject = null;
    switch (m)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131433852);
      break;
      localObject = getResources().getString(2131433851);
      break;
      localObject = getResources().getString(2131433850);
      break;
      localObject = getResources().getString(2131433849);
      break;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "messge roam flag is error ,is : " + m);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_entrance", 29);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    startActivityForResult(localIntent, 2);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (Intent localIntent = new Intent(this, ChatHistoryForC2C.class);; localIntent = new Intent(this, ChatHistory.class))
    {
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
      localIntent.putExtra("FriendNick", this.jdField_h_of_type_JavaLangString);
      startActivityForResult(localIntent, 1000);
      return;
    }
  }
  
  private void n()
  {
    ReportController.b(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("leftViewText", getString(2131435259));
    startActivity(localIntent);
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void p()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_c_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void q()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!QvipSpecialCareManager.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130845926);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130845923);
    getResources().getDrawable(2130838480);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void r()
  {
    rzc localrzc = new rzc(this, new StringBuilder());
    if (!this.jdField_j_of_type_Boolean)
    {
      ThreadManager.post(localrzc, 8, null, true);
      a(2, getString(2131434467));
    }
  }
  
  private void s()
  {
    boolean bool = true;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131432992, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      c();
      return;
    }
    try
    {
      l = Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (l > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_e_of_type_Boolean)
        {
          localFriendListHandler.a(l, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
        continue;
        bool = false;
      }
      a(1, "无效的号码");
    }
  }
  
  private void t()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131432992, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      return;
      Object localObject1 = (ShieldMsgManger)this.app.getManager(15);
      if (localObject1 != null) {}
      try
      {
        l = Long.parseLong(this.jdField_i_of_type_JavaLangString);
        if (l > 0L)
        {
          Object localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startStangerShield, tuin=" + l + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mIsFollowed=" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_f_of_type_Boolean)
          {
            ((ShieldMsgManger)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
            this.jdField_h_of_type_Boolean = true;
            QQAppInterface localQQAppInterface = this.app;
            if (!this.jdField_f_of_type_Boolean) {
              break label512;
            }
            localObject2 = "cancel_aio";
            if (this.jdField_a_of_type_Int != 1001) {
              break label520;
            }
            str2 = "0";
            if (!this.jdField_f_of_type_Boolean) {
              break label528;
            }
            localObject1 = "";
            ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
            if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 1003))
            {
              if (!this.jdField_f_of_type_Boolean) {
                break label549;
              }
              if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
              {
                this.app.a().b(this.jdField_c_of_type_JavaLangString);
                this.jdField_h_of_type_Boolean = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startStangerShield, mCurUin=" + this.jdField_c_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldByThis=" + this.jdField_h_of_type_Boolean);
              }
            }
            if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int != 1010)) {
              continue;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label588;
            }
            ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            if (ChatActivityUtils.a.size() > 5) {
              ChatActivityUtils.a.poll();
            }
            ChatActivityUtils.a.offer(l + "");
          }
          ((ShieldMsgManger)localObject1).a(this.jdField_a_of_type_Int, localException);
          continue;
          a(1, "无效的号码");
          continue;
          label512:
          String str1 = "block_aio";
          continue;
          label520:
          String str2 = "1";
          continue;
          label528:
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = "0";
          }
          else
          {
            localObject1 = "1";
            continue;
            label549:
            if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
            {
              this.app.a().a(this.jdField_c_of_type_JavaLangString);
              this.jdField_h_of_type_Boolean = true;
            }
          }
        }
        label588:
        ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshShieldButton, mCurType=" + this.jdField_a_of_type_Int + ", mIsShield=" + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131435278));
      }
    }
    if ((this.jdField_a_of_type_Int == 1003) || (!this.jdField_g_of_type_Boolean)) {
      if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void v()
  {
    int m;
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
      if (this.jdField_a_of_type_Boolean) {
        m = 2131430499;
      }
    }
    for (;;)
    {
      String str = getString(m);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(str);
      return;
      m = 2131430497;
      continue;
      m = 2131435276;
    }
  }
  
  private void w()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    if ((localFriendsManager != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_e_of_type_Boolean = localFriendsManager.d(this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131435278));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      while (jdField_b_of_type_Boolean)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
    }
  }
  
  private void x()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void y()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.jdField_a_of_type_Int = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_Int != 1010) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label580;
      }
      localObject = new Intent(this, NearbyPeopleProfileActivity.class);
      if (this.jdField_a_of_type_Int == 1001)
      {
        localAllInOne.jdField_h_of_type_Int = 12;
        ((Intent)localObject).putExtra("frome_where", 21);
        label334:
        ((Intent)localObject).putExtra("AllInOne", localAllInOne);
        if (!Utils.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label568;
        }
        ((Intent)localObject).putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivityForResult((Intent)localObject, 3);
      return;
      localAllInOne.jdField_a_of_type_Int = 42;
      break;
      localAllInOne.jdField_a_of_type_Int = 86;
      break;
      localAllInOne.jdField_a_of_type_Int = 76;
      break;
      localAllInOne.jdField_a_of_type_Int = 22;
      localAllInOne.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      break;
      localAllInOne.jdField_a_of_type_Int = 70;
      break;
      localAllInOne.jdField_a_of_type_Int = 47;
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      break;
      localAllInOne.jdField_a_of_type_Int = 2;
      break;
      localAllInOne.jdField_a_of_type_Int = 34;
      break;
      localAllInOne.jdField_a_of_type_Int = 57;
      break;
      localAllInOne.jdField_a_of_type_Int = 72;
      break;
      localAllInOne.jdField_a_of_type_Int = 74;
      break;
      localAllInOne.jdField_a_of_type_Int = 27;
      break;
      localAllInOne.jdField_a_of_type_Int = 93;
      break;
      localAllInOne.jdField_a_of_type_Int = 58;
      break;
      if (this.jdField_a_of_type_Int == 10002)
      {
        ((Intent)localObject).putExtra("frome_where", 22);
        break label334;
      }
      if (this.jdField_a_of_type_Int == 1010)
      {
        localAllInOne.jdField_h_of_type_Int = 13;
        break label334;
      }
      localAllInOne.jdField_h_of_type_Int = 30;
      break label334;
      label568:
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    label580:
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("param_wzry_data"))
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getSerializableExtra("param_wzry_data");
      if (localObject != null) {
        localAllInOne.jdField_a_of_type_AndroidOsBundle.putSerializable("param_wzry_data", (Serializable)localObject);
      }
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void z()
  {
    int m = 3999;
    int n = 0;
    Object localObject = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    while (m == 3007)
    {
      if (LBSHandler.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        break label322;
      }
      a();
      return;
      m = 3004;
      n = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      m = 3007;
      n = 3;
      continue;
      m = 3043;
      n = 3;
      continue;
      m = 3071;
      n = 1;
      continue;
      m = 3003;
      continue;
      m = 3005;
      n = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      m = 3008;
      continue;
      m = 3006;
      continue;
      m = 3013;
      continue;
      m = 3008;
      continue;
      m = 3003;
      n = 2;
      continue;
      m = 3041;
      continue;
      m = 3082;
      n = 1;
      continue;
      m = 3019;
    }
    if ((m == 3019) && (!DatingUtil.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      a();
      return;
    }
    label322:
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 4000) || (this.jdField_a_of_type_Int == 1006)) {}
    for (localObject = AddFriendLogicActivity.a(this, 2, this.k, null, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);; localObject = AddFriendLogicActivity.a(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null))
    {
      if (localObject != null)
      {
        Serializable localSerializable = StrangerChatPie.a(this, this.jdField_a_of_type_Int, false, false);
        if (localSerializable != null) {
          ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
        }
      }
      startActivity((Intent)localObject);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131437392), new ryz(this), new rza(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_c_of_type_JavaLangString, false);
    if (localExtensionInfo == null) {
      return;
    }
    long l1 = localExtensionInfo.lastpraiseTime;
    long l2 = localExtensionInfo.lastChatTime;
    long l3 = localExtensionInfo.lastQzoneVisitTime;
    boolean bool1 = HotReactiveHelper.a(HotReactiveHelper.b(), l2 * 1000L);
    boolean bool2 = HotReactiveHelper.a(HotReactiveHelper.b(), l1 * 1000L);
    boolean bool3 = HotReactiveHelper.a(HotReactiveHelper.b(), l3 * 1000L);
    boolean bool4 = localFriendsManager.d();
    int m = localFriendsManager.a(this.jdField_c_of_type_JavaLangString, localExtensionInfo, 1, bool4);
    int n = localFriendsManager.b(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool4);
    int i1 = localFriendsManager.c(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool4);
    int i2 = localFriendsManager.a(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool4);
    int i3 = localFriendsManager.d(this.jdField_c_of_type_JavaLangString, localExtensionInfo, bool4);
    a(n, bool1);
    a(m);
    b(i1, bool2);
    c(i2, localExtensionInfo.isQzoneLover);
    d(i3, bool3);
    a(localFriendsManager, localExtensionInfo);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_d_of_type_Boolean = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      return;
      p();
      finish();
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnActivityResult");
        }
        b();
      }
      setResult(-1);
      this.jdField_c_of_type_Boolean = true;
      return;
      a(paramIntent);
      return;
      b(paramIntent);
      return;
      switch (paramIntent.getIntExtra("param_subtype", -1))
      {
      default: 
        return;
      case 0: 
        ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        TroopUtils.a(this, paramIntent.getStringExtra("roomId"));
        return;
      }
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
      localIntent.putExtra("isBack2Root", true);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    c();
    d();
    f();
    g();
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_j_of_type_Boolean = true;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        FaceDrawable localFaceDrawable;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    e();
    this.jdField_i_of_type_Boolean = false;
  }
  
  protected void doOnPause()
  {
    this.jdField_d_of_type_Boolean = true;
    x();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(32);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      str = getString(2131436844);
      SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label214;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131436019));
    }
    for (String str = str + getString(2131436019);; str = str + getString(2131436020))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(34)))
      {
        int m = HotReactiveHelper.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
      return;
      label214:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131436020));
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)) {
      k();
    }
  }
  
  public void finish()
  {
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("follow_flag", this.jdField_a_of_type_Boolean);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    int m = 1;
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (NetworkUtil.d(BaseApplication.getContext()))
      {
        ((CardHandler)this.app.a(2)).j(paramBoolean);
        paramCompoundButton = this.app;
        if (paramBoolean) {
          ReportController.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
        }
      }
    }
    label274:
    do
    {
      do
      {
        return;
        m = 0;
        break;
        a(2131432992, 1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!paramBoolean) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          return;
        }
        if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton)) {
          break label274;
        }
      } while (this.jdField_f_of_type_Boolean == paramBoolean);
      if (paramBoolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, isCheck=" + paramBoolean);
        }
        t();
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
      }
    } while (this.jdField_e_of_type_Boolean == paramBoolean);
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
    }
    for (;;)
    {
      s();
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363694: 
    case 2131363672: 
    case 2131363673: 
    case 2131363674: 
    case 2131363699: 
    case 2131363707: 
    case 2131363711: 
      do
      {
        return;
        l();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
        return;
        m();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
        return;
        n();
        FileManagerReporter.a("0X8004E01");
        return;
        o();
        ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        return;
        C();
        ReportController.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
        return;
        r();
        ReportController.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      } while (!a(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Int == 1001)
      {
        ProfileCardUtil.a(this, 0L, this.jdField_c_of_type_JavaLangString, null, 10030);
        return;
      }
      ProfileCardUtil.a(this, this.jdField_c_of_type_JavaLangString, null, this.app.getAccount(), 10026, null);
      return;
    case 2131363702: 
      y();
      return;
    case 2131363709: 
      if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
      {
        Object localObject1;
        Object localObject2;
        String str;
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = "2";
          localObject1 = this.app;
          localObject2 = this.jdField_c_of_type_JavaLangString;
          if (this.jdField_a_of_type_Int != 1001) {
            break label591;
          }
          str = "2";
          if (this.jdField_a_of_type_Int != 1001) {
            break label598;
          }
          NearbyHandler.a((QQAppInterface)localObject1, (String)localObject2, str, paramView, 3, new ryw(this, paramView));
          ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
          localObject2 = this.app;
          if (!"1".equals(paramView)) {
            break label601;
          }
          str = "follow_aio";
          if (this.jdField_a_of_type_Int != 1001) {
            break label608;
          }
          localObject1 = "0";
          if (!"1".equals(paramView)) {
            break label622;
          }
          if (!localShieldMsgManger.a(this.jdField_c_of_type_JavaLangString)) {
            break label615;
          }
          paramView = "1";
        }
        for (;;)
        {
          ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", str, 0, 0, (String)localObject1, "1", paramView, "");
          return;
          paramView = "1";
          break;
          str = "1";
          break label455;
          break label465;
          str = "unfollow_aio";
          break label517;
          localObject1 = "1";
          break label531;
          paramView = "0";
          continue;
          paramView = "";
        }
      }
      z();
      ReportController.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
      return;
    case 2131363683: 
      A();
      return;
    case 2131363700: 
      d(this.jdField_c_of_type_JavaLangString);
      if (Utils.b(this.jdField_c_of_type_JavaLangString)) {
        ReportController.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      return;
    case 2131363697: 
      label455:
      label465:
      label598:
      label601:
      label608:
      label615:
      label622:
      paramView = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      label517:
      label531:
      label591:
      paramView.edit().putBoolean("special_care_chat_setting", false).commit();
      if (paramView.getBoolean("special_care_red_point_one", false)) {
        paramView.edit().putBoolean("special_care_red_point_one", false).commit();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      paramView = new Intent(this, QQSpecialCareSettingActivity.class);
      paramView.putExtra("key_friend_uin", this.jdField_c_of_type_JavaLangString);
      paramView.putExtra("key_start_from", 2);
      startActivity(paramView);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
      return;
    }
    ProfileCardUtil.a(this, this.jdField_c_of_type_JavaLangString, null, this.app.getAccount(), 10026, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */