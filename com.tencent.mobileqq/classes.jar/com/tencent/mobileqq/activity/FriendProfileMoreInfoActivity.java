package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements Handler.Callback, View.OnClickListener, View.OnFocusChangeListener
{
  private byte jdField_a_of_type_Byte;
  int jdField_a_of_type_Int = 0;
  protected BroadcastReceiver a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new FriendProfileMoreInfoActivity.1(this);
  private ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new FriendProfileMoreInfoActivity.5(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FriendProfileMoreInfoActivity.4(this);
  private BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new FriendProfileMoreInfoActivity.3(this);
  BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new FriendProfileMoreInfoActivity.2(this);
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  ProfileConfigHelper jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher;
  QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  boolean jdField_g_of_type_Boolean = false;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  boolean jdField_h_of_type_Boolean = false;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  boolean jdField_i_of_type_Boolean = false;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean = false;
  private View k;
  private View l;
  private View m;
  private View n;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new FriendProfileMoreInfoActivity.16(this);
  }
  
  private String a()
  {
    return String.format("%s-1-1", new Object[] { Integer.valueOf(Calendar.getInstance().get(1) - 18) });
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard != null) && (!this.jdField_i_of_type_Boolean) && (ProfileCardUtil.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = HardCodeUtil.a(2131704930);
      DialogUtil.a(this, HardCodeUtil.a(2131704909), str, null, 2131695026, 2131695027, new FriendProfileMoreInfoActivity.7(this), new FriendProfileMoreInfoActivity.8(this)).show();
      ProfileCardUtil.a(paramCard, this.app);
      ReportController.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {
      return;
    }
    if (paramCard.lCurrentStyleId != ProfileCardTemplate.a) {}
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(RichStatusUtils.Companion.getRichStatus(paramCard));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      a(paramCard.strNick);
      label93:
      if (!this.jdField_c_of_type_Boolean) {
        a(paramCard.shGender, false);
      }
      if (!this.jdField_d_of_type_Boolean) {
        a((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
      }
      if (!this.jdField_e_of_type_Boolean) {
        a(paramCard.iProfession);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
        c(paramCard.strSchool);
      }
      if (!this.jdField_f_of_type_Boolean) {
        if (TextUtils.isEmpty(paramCard.strLocationCodes)) {
          break label438;
        }
      }
    }
    label438:
    for (localObject1 = paramCard.strLocationCodes.split("-");; localObject1 = null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      d(paramCard.strLocationDesc);
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        e(paramCard.strHometownDesc);
      }
      localObject1 = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
        f(paramCard.strEmail);
      }
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
      g(paramCard.strPersonalNote);
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break label93;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break label93;
    }
  }
  
  private void a(ArrayList<SchoolInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (this.n.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject1 = (SchoolInfo)paramArrayList.next();
        } while (TextUtils.isEmpty(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString));
        View localView = View.inflate(this, 2131561493, null);
        TextView localTextView = (TextView)localView.findViewById(2131377507);
        Object localObject2;
        if (((SchoolInfo)localObject1).jdField_b_of_type_Boolean)
        {
          localTextView.setText(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString);
          localObject2 = getResources().getDrawable(2130845281);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          localTextView.setCompoundDrawablePadding(AIOUtils.a(4.5F, localTextView.getResources()));
          label161:
          localTextView = (TextView)localView.findViewById(2131366207);
          localObject2 = ((SchoolInfo)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label252;
          }
          localTextView.setVisibility(8);
          label194:
          localTextView = (TextView)localView.findViewById(2131366208);
          if (!((SchoolInfo)localObject1).jdField_a_of_type_Boolean) {
            break label262;
          }
          localTextView.setVisibility(0);
        }
        for (;;)
        {
          localView.setOnClickListener(this);
          localView.setTag(localObject1);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          localTextView.setText(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString);
          break label161;
          label252:
          localTextView.setText((CharSequence)localObject2);
          break label194;
          label262:
          localTextView.setVisibility(8);
        }
      }
      paramArrayList = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject1 = View.inflate(this, 2131561493, null);
        ((TextView)((View)localObject1).findViewById(2131377507)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject1).findViewById(2131366207)).setVisibility(8);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(paramArrayList);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
      {
        this.n.findViewById(2131377498).setVisibility(0);
        this.n.findViewById(2131377502).setVisibility(0);
        this.n.findViewById(2131377500).setVisibility(0);
        this.n.findViewById(2131377496).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.n.findViewById(2131377498).setVisibility(8);
    this.n.findViewById(2131377502).setVisibility(8);
    this.n.findViewById(2131377500).setVisibility(8);
    this.n.findViewById(2131377496).setVisibility(0);
  }
  
  private void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + paramBoolean);
    }
    this.jdField_j_of_type_Boolean = false;
    if (paramBoolean) {
      a(((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(paramBundle);
    return true;
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i1;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i1 = 0;
        }
        for (;;)
        {
          if ((i1 >= paramArrayOfString1.length) || (!paramArrayOfString1[i1].equals(paramArrayOfString2[i1])))
          {
            int i2 = paramArrayOfString1.length;
            if (i1 == i2) {
              break;
            }
            bool = false;
            break;
          }
          i1 += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1) {}
    }
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("college", "");
    if (a(localBundle, 2131694459, 0)) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    ReportController.b(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private boolean b()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(((String)localObject1).trim()))) {}
    }
    else
    {
      if (this.jdField_c_of_type_Boolean) {
        localBundle.putByte("sex", this.jdField_a_of_type_Byte);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localBundle.putInt("birthday", this.jdField_b_of_type_Int);
        localBundle.putInt("age", this.jdField_c_of_type_Int);
        localBundle.putInt("key_constellation", this.jdField_d_of_type_Int);
      }
      if (this.jdField_e_of_type_Boolean) {
        localBundle.putInt("profession", this.jdField_e_of_type_Int);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) {
        localBundle.putString("college", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_f_of_type_Boolean)
      {
        localObject1 = this.jdField_h_of_type_AndroidWidgetTextView.getText().toString();
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("location_desc", (String)localObject1);
        localObject1 = null;
      }
    }
    label390:
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label231:
      break label231;
    }
    localBundle.putStringArray("location_name", (String[])localObject1);
    if (this.jdField_g_of_type_Boolean)
    {
      localObject1 = this.jdField_i_of_type_AndroidWidgetTextView.getText().toString();
      localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localObject2 = SearchBaseActivity.a.matcher((CharSequence)localObject1);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((Matcher)localObject2).matches())) {
        break label390;
      }
    }
    for (;;)
    {
      if (this.jdField_h_of_type_Boolean) {
        localBundle.putString("personalNote", this.jdField_e_of_type_JavaLangString);
      }
      return a(localBundle, 2131694459, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new QZoneDistributedAppCtrl.Control();
      ((QZoneDistributedAppCtrl.Control)localObject1).cmd = 5;
      QZoneDistributedAppCtrl.getInstance(getAppRuntime().getAccount()).submitCtrl((QZoneDistributedAppCtrl.Control)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.app.getLongAccountUin());
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.10(this));
      return;
    case 2: 
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult(localIntent, 1003);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.11(this));
      d(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.12(this));
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131695023, 0);
    localActionSheet.addButton(2131695025, 0);
    localActionSheet.addButton(2131695024, 0);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new FriendProfileMoreInfoActivity.9(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131694459, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131691140));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131691140));
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Object localObject1;
    if (paramInt == 1)
    {
      i1 = 2;
      if (paramInt != 1) {
        break label273;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label148:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length == 4) {}
      }
      else
      {
        localObject2 = new String[4];
        localObject2[0] = "0";
        localObject2[1] = "0";
        localObject2[2] = "0";
        localObject2[3] = "0";
      }
      localObject1 = new Intent(this, LocationSelectActivity.class);
      ((Intent)localObject1).putExtra("param_is_popup", false);
      ((Intent)localObject1).putExtra("param_req_type", i1);
      ((Intent)localObject1).putExtra("param_location", (String[])localObject2);
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String[])localObject2));
      if (paramInt != 1) {
        break label281;
      }
    }
    label273:
    label281:
    for (paramInt = 1005;; paramInt = 1006)
    {
      startActivityForResult((Intent)localObject1, paramInt);
      return;
      i1 = 3;
      break;
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label148;
    }
  }
  
  private void e()
  {
    if (a())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131704907));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_Boolean = true;
        if (!isFinishing()) {
          finish();
        }
      }
    }
    while (isFinishing())
    {
      do
      {
        return;
        if (b())
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
      } while (isFinishing());
      finish();
      return;
    }
    finish();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693346);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693346));
    Object localObject = (TextView)findViewById(2131369487);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131704952));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365312));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363219);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131692212));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363215));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131378173);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378175));
    a(null);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379962);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131379965));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379963));
      localObject = findViewById(2131379961);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null) {
        break label1269;
      }
      if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        this.jdField_c_of_type_AndroidViewView.setClickable(true);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        ((View)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      a();
      this.jdField_d_of_type_AndroidViewView = findViewById(2131372281);
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_d_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372280));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131377924);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377925));
      a(-1, false);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131363695);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363696));
      a(0, 0, 0);
      if (ProfileCardUtil.a())
      {
        int i1 = this.jdField_e_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_e_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_e_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_e_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839582);
        this.jdField_e_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_g_of_type_AndroidViewView = findViewById(2131373513);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373512));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373514));
      a(-1);
      this.jdField_h_of_type_AndroidViewView = findViewById(2131365161);
      this.jdField_h_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365160));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
      this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131377506);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131377503));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
      this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      c(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131370794);
      this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370809));
      d(null);
      this.k = findViewById(2131368476);
      this.k.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368477));
      e(null);
      this.l = findViewById(2131366223);
      this.l.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366222));
      this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
      this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      f(null);
      this.m = findViewById(2131372897);
      this.m.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372898));
      g(null);
      this.n = findViewById(2131366210);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362228));
      findViewById(2131377497).setOnClickListener(this);
      findViewById(2131377501).setOnClickListener(this);
      findViewById(2131377499).setOnClickListener(this);
      findViewById(2131377495).setOnClickListener(this);
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((this.jdField_i_of_type_Boolean) && (((TroopManager)localObject).n(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.n.setVisibility(0);
      }
      return;
      label1269:
      this.jdField_c_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    SignatureEditManager.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561289, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new FriendProfileMoreInfoActivity.13(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361983);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new FriendProfileMoreInfoActivity.14(this));
    }
    if ((this.jdField_a_of_type_Byte != 0) && (this.jdField_a_of_type_Byte != 1))
    {
      this.jdField_a_of_type_Byte = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    a(this.jdField_a_of_type_Byte, true);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (this.jdField_a_of_type_Byte != 1) {}
    for (int i1 = 0;; i1 = 1)
    {
      ((IphonePickerView)localObject).setSelection(0, i1);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new FriendProfileMoreInfoActivity.15(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "gotoSchoolWeb " + paramString);
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    startActivityForResult(localIntent, 1012);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void a()
  {
    String str = ContactUtils.h(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new ColorNickText(str, 16).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      ColorNickManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131697567), str);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void a(int paramInt)
  {
    boolean bool = false;
    Object localObject2;
    Object localObject1;
    label67:
    TextView localTextView;
    String str;
    if (NearbyProfileUtil.a(paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      localObject2 = NearbyProfileUtil.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_e_of_type_Int = -1;
        localObject1 = getString(2131695123);
      }
      if ((paramInt < NearbyProfileUtil.e.length - 1) && (paramInt > 0)) {
        break label137;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_g_of_type_AndroidWidgetTextView;
      if (this.jdField_e_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (CharSequence)localObject1, bool);
      localObject2 = this.jdField_g_of_type_AndroidViewView;
      localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
      str = getString(2131695124);
      if (paramInt == -1) {
        break label192;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.jdField_e_of_type_Int = -1;
      break;
      label137:
      localObject2 = getResources().getDrawable(NearbyProfileUtil.b[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[paramInt]);
      break label67;
      label192:
      localObject1 = "";
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    String str1 = a();
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
    TextView localTextView;
    String str2;
    if (paramInt1 == 0)
    {
      a((TextView)localObject, str1, bool);
      localObject = this.jdField_f_of_type_AndroidViewView;
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      str2 = getString(2131695019);
      if (paramInt1 == 0) {
        break label146;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      bool = false;
      break;
      label146:
      str1 = "";
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131695127);
    if (paramInt == 0)
    {
      str = getString(2131693923);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_d_of_type_AndroidWidgetTextView, str, 2131167041);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131695128), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131692330);
      break;
      label88:
      TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if ((paramInt != 0) && (paramInt != 1)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(localTextView, str, paramBoolean);
        break;
      }
      label121:
      str = "";
    }
  }
  
  void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    paramView1 = str;
    if ((paramView2 instanceof EditText)) {
      paramView1 = paramString1 + HardCodeUtil.a(2131704934) + paramString2 + ",";
    }
    paramView2.setContentDescription(paramView1);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    paramTextView.setTextColor(getResources().getColor(paramInt));
    paramTextView.setText(paramCharSequence);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2131167119;; i1 = 2131167033)
    {
      a(paramTextView, paramCharSequence, i1);
      return;
    }
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool = false;
    if (paramRichStatus != null) {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
    }
    for (this.jdField_d_of_type_JavaLangString = paramRichStatus;; this.jdField_d_of_type_JavaLangString = "")
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView, paramRichStatus, bool);
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetTextView, getString(2131693431), paramRichStatus);
      return;
      paramRichStatus = HardCodeUtil.a(2131704941);
      bool = true;
    }
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131695076);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131695077), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).o(paramString1))
    {
      HWTroopUtils.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131697571);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_nick_id", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.a());
      localIntent.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", HardCodeUtil.a(2131704915));
    }
    for (;;)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      localIntent.putExtra("default_text", "");
    }
  }
  
  void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131695029);
    a(this.jdField_h_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131695030), str);
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131695125);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131695126), str);
  }
  
  void d(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131695072);
      bool = true;
    }
    a(this.jdField_h_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_j_of_type_AndroidViewView;
    TextView localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    String str2 = getString(2131695073);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
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
    if (paramInt1 == 1002) {
      if (paramInt2 != 1001) {
        ((IProfileProtocolService)this.app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
      }
    }
    label235:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        int i1;
                        do
                        {
                          do
                          {
                            return;
                            if (paramInt1 != 1003) {
                              break;
                            }
                          } while (paramIntent == null);
                          i1 = paramIntent.getShortExtra("param_year", (short)1990);
                          int i2 = paramIntent.getByteExtra("param_month", (byte)1);
                          int i3 = paramIntent.getByteExtra("param_day", (byte)1);
                          paramInt1 = paramIntent.getIntExtra("param_age", 0);
                          paramInt2 = paramIntent.getIntExtra("param_constellation_id", 0);
                          i1 = i1 << 16 | i2 << 8 | i3;
                        } while (i1 == this.jdField_b_of_type_Int);
                        this.jdField_d_of_type_Boolean = true;
                        a(i1, paramInt1, paramInt2);
                        return;
                        if (paramInt1 != 1004) {
                          break;
                        }
                      } while (paramIntent == null);
                      paramInt1 = paramIntent.getIntExtra("param_id", -1);
                    } while (paramInt1 == this.jdField_e_of_type_Int);
                    this.jdField_e_of_type_Boolean = true;
                    a(paramInt1);
                    return;
                    if (paramInt1 != 1005) {
                      break;
                    }
                  } while (paramIntent == null);
                  localObject = paramIntent.getStringArrayExtra("param_location");
                } while (a(this.jdField_a_of_type_ArrayOfJavaLangString, (String[])localObject));
                this.jdField_f_of_type_Boolean = true;
                this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
                paramIntent = null;
                try
                {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject);
                  paramIntent = (Intent)localObject;
                }
                catch (Exception localException2)
                {
                  break label235;
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  localObject = paramIntent;
                  if (!paramIntent.equals("不限")) {}
                }
                else
                {
                  localObject = "";
                }
                d((String)localObject);
                return;
                if (paramInt1 != 1006) {
                  break;
                }
              } while (paramIntent == null);
              localObject = paramIntent.getStringArrayExtra("param_location");
            } while (a(this.jdField_b_of_type_ArrayOfJavaLangString, (String[])localObject));
            this.jdField_g_of_type_Boolean = true;
            this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject);
            paramIntent = null;
            try
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject);
              paramIntent = (Intent)localObject;
            }
            catch (Exception localException1)
            {
              break label326;
            }
            if (!TextUtils.isEmpty(paramIntent))
            {
              localObject = paramIntent;
              if (!paramIntent.equals("不限")) {}
            }
            else
            {
              localObject = "";
            }
            e((String)localObject);
            return;
            if (paramInt1 != 1007) {
              break;
            }
          } while (paramIntent == null);
          paramIntent = paramIntent.getStringExtra("result");
        } while (paramIntent.equals(this.jdField_e_of_type_JavaLangString));
        this.jdField_h_of_type_Boolean = true;
        g(paramIntent);
        return;
        if (paramInt1 == 1011)
        {
          a();
          return;
        }
      } while (paramInt1 != 1012);
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null);
    label326:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1348	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1349
    //   10: invokespecial 1352	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 823	com/tencent/util/WeakReferenceHandler
    //   17: dup
    //   18: invokestatic 1358	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   21: aload_0
    //   22: invokespecial 1361	com/tencent/util/WeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   25: putfield 819	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   28: aload_0
    //   29: invokevirtual 1365	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: ldc_w 1367
    //   38: iconst_0
    //   39: invokevirtual 1371	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   42: putfield 81	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   45: aload_0
    //   46: aload_1
    //   47: ldc_w 1242
    //   50: invokevirtual 1335	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 85	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc_w 1373
    //   61: invokevirtual 1335	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 87	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 1375
    //   72: invokevirtual 1335	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   75: putfield 89	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 89	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +91 -> 176
    //   88: new 1377	org/json/JSONObject
    //   91: dup
    //   92: aload_0
    //   93: getfield 89	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_0
    //   101: aload_3
    //   102: ldc_w 1242
    //   105: invokevirtual 1382	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 85	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_3
    //   113: ldc_w 1373
    //   116: invokevirtual 1382	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 87	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 85	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   126: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +18 -> 147
    //   132: aload_0
    //   133: getfield 87	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   136: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +8 -> 147
    //   142: aload_0
    //   143: iconst_1
    //   144: putfield 81	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   147: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +26 -> 176
    //   153: ldc 228
    //   155: iconst_2
    //   156: ldc_w 1384
    //   159: iconst_1
    //   160: anewarray 136	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 89	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   181: getstatic 1389	com/tencent/mobileqq/app/BusinessHandlerFactory:CARD_HANLDER	Ljava/lang/String;
    //   184: invokevirtual 1393	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   187: checkcast 583	com/tencent/mobileqq/app/CardHandler
    //   190: putfield 581	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppCardHandler	Lcom/tencent/mobileqq/app/CardHandler;
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: getstatic 1396	com/tencent/mobileqq/app/QQManagerFactory:CONDITION_SEARCH_MANAGER	I
    //   201: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   204: checkcast 661	com/tencent/mobileqq/app/ConditionSearchManager
    //   207: putfield 659	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   210: aload_0
    //   211: new 1398	com/tencent/mobileqq/widget/ProfileConfigHelper
    //   214: dup
    //   215: aload_0
    //   216: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   219: aconst_null
    //   220: invokespecial 1401	com/tencent/mobileqq/widget/ProfileConfigHelper:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/widget/ProfileConfigHelper$OnConfigUpdateListener;)V
    //   223: putfield 1403	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper	Lcom/tencent/mobileqq/widget/ProfileConfigHelper;
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 98	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppCardObserver	Lcom/tencent/mobileqq/app/CardObserver;
    //   231: invokevirtual 1407	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 103	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver	Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;
    //   239: invokevirtual 1407	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   242: aload_0
    //   243: aload_0
    //   244: getfield 113	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   247: invokevirtual 1407	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   250: aload_0
    //   251: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: aload_0
    //   255: getfield 108	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver	Lcom/tencent/mobileqq/businessCard/BusinessCardObserver;
    //   258: invokevirtual 1411	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   261: aload_0
    //   262: getfield 659	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   265: aload_0
    //   266: invokevirtual 1413	com/tencent/mobileqq/app/ConditionSearchManager:a	(Ljava/lang/Object;)V
    //   269: new 1415	android/content/IntentFilter
    //   272: dup
    //   273: invokespecial 1416	android/content/IntentFilter:<init>	()V
    //   276: astore_3
    //   277: aload_3
    //   278: ldc_w 1418
    //   281: invokevirtual 1421	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   284: aload_0
    //   285: aload_0
    //   286: getfield 123	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   289: aload_3
    //   290: invokevirtual 1425	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   293: pop
    //   294: aload_0
    //   295: ldc_w 1426
    //   298: invokespecial 1427	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   301: checkcast 423	android/widget/LinearLayout
    //   304: astore_3
    //   305: invokestatic 1432	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   308: iconst_1
    //   309: if_icmpne +19 -> 328
    //   312: aload_3
    //   313: iconst_1
    //   314: invokevirtual 1435	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   317: aload_3
    //   318: iconst_0
    //   319: aload_0
    //   320: invokestatic 1439	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   323: iconst_0
    //   324: iconst_0
    //   325: invokevirtual 1440	android/widget/LinearLayout:setPadding	(IIII)V
    //   328: aload_0
    //   329: invokespecial 1442	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:f	()V
    //   332: aload_0
    //   333: aload_0
    //   334: invokevirtual 1365	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   337: ldc_w 1444
    //   340: invokevirtual 1448	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   343: checkcast 1450	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   346: putfield 1047	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   349: aload_0
    //   350: aload_0
    //   351: invokevirtual 1365	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   354: ldc_w 1452
    //   357: invokevirtual 1448	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   360: checkcast 1454	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   363: putfield 1456	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   366: aload_0
    //   367: getfield 1047	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   370: ifnonnull +22 -> 392
    //   373: aload_0
    //   374: new 1450	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   377: dup
    //   378: aload_0
    //   379: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   382: invokevirtual 1459	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   385: iconst_0
    //   386: invokespecial 1461	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   389: putfield 1047	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   392: aload_0
    //   393: getfield 1456	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   396: ifnonnull +14 -> 410
    //   399: aload_0
    //   400: aload_0
    //   401: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   404: invokestatic 1466	com/tencent/mobileqq/businessCard/utilities/BusinessCardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   407: putfield 1456	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   410: new 1468	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6
    //   413: dup
    //   414: aload_0
    //   415: invokespecial 1469	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   418: iconst_5
    //   419: aconst_null
    //   420: iconst_1
    //   421: invokestatic 1474	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   424: aload_0
    //   425: getfield 81	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   428: ifne +27 -> 455
    //   431: aload_0
    //   432: aload_0
    //   433: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   436: getstatic 564	com/tencent/mobileqq/app/QQManagerFactory:BUSINESS_CARD_MANAGER	I
    //   439: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   442: checkcast 566	com/tencent/mobileqq/businessCard/BusinessCardManager
    //   445: invokevirtual 569	com/tencent/mobileqq/businessCard/BusinessCardManager:a	()Ljava/util/ArrayList;
    //   448: invokespecial 207	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:a	(Ljava/util/ArrayList;)V
    //   451: aload_0
    //   452: invokespecial 1342	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	()V
    //   455: aload_1
    //   456: ldc_w 1476
    //   459: iconst_0
    //   460: invokevirtual 1318	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   463: istore_2
    //   464: iload_2
    //   465: ifle +40 -> 505
    //   468: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +29 -> 500
    //   474: ldc 228
    //   476: iconst_2
    //   477: new 550	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 551	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 1478
    //   487: invokevirtual 557	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: iload_2
    //   491: invokevirtual 607	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload_0
    //   501: iload_2
    //   502: invokespecial 1480	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	(I)V
    //   505: aload_0
    //   506: getfield 215	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   509: ldc_w 261
    //   512: ldc 83
    //   514: ldc 83
    //   516: ldc_w 1482
    //   519: ldc_w 1482
    //   522: iconst_0
    //   523: iconst_0
    //   524: ldc 83
    //   526: ldc 83
    //   528: ldc 83
    //   530: ldc 83
    //   532: invokestatic 268	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   535: iconst_1
    //   536: ireturn
    //   537: astore_1
    //   538: aload_1
    //   539: invokevirtual 1485	java/lang/Exception:printStackTrace	()V
    //   542: aload_0
    //   543: invokevirtual 865	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   546: iconst_0
    //   547: ireturn
    //   548: astore_3
    //   549: aload_3
    //   550: invokevirtual 1486	org/json/JSONException:printStackTrace	()V
    //   553: ldc 228
    //   555: iconst_1
    //   556: aload_3
    //   557: invokevirtual 1489	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   560: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: goto -416 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	FriendProfileMoreInfoActivity
    //   0	566	1	paramBundle	Bundle
    //   463	39	2	i1	int
    //   99	219	3	localObject	Object
    //   548	9	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   6	13	537	java/lang/Exception
    //   88	147	548	org/json/JSONException
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = null;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localIllegalArgumentException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
    }
  }
  
  void e(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131695066);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.k;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str2 = getString(2131695067);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  void f(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_d_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131695059);
    a(this.l, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131695060), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void g(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    int i1;
    if (TextUtils.isEmpty(paramString)) {
      i1 = 1;
    }
    for (String str1 = getString(2131695090);; str1 = paramString)
    {
      a(this.jdField_j_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.m;
      TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      String str2 = getString(2131695091);
      if (i1 == 0) {}
      for (;;)
      {
        a(paramString, localTextView, str2, str1);
        return;
        str1 = "";
      }
      i1 = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
    } while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2));
    i();
    QQToast.a(this, 2131691137, 0).b(getTitleBarHeight());
    return true;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
      }
      label15:
      e();
      return true;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
      switch (paramView.getId())
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", localThrowable);
        continue;
        e();
        continue;
        Object localObject = new Intent(this, AvatarPendantActivity.class);
        ((Intent)localObject).putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ((Intent)localObject).putExtra("showActionSheet", true);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
        continue;
        g();
        ReportController.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
        continue;
        h();
        continue;
        localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          if ((((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) || (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
          {
            a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1011);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
            continue;
            localObject = new Intent(this, AgeSelectionActivity.class);
            ((Intent)localObject).putExtra("param_birthday", this.jdField_b_of_type_Int);
            startActivityForResult((Intent)localObject, 1003);
            continue;
            localObject = new Intent(this, JobSelectionActivity.class);
            ((Intent)localObject).putExtra("param_id", this.jdField_e_of_type_Int);
            startActivityForResult((Intent)localObject, 1004);
            continue;
            d(1);
            continue;
            d(2);
            continue;
            localObject = new Intent(this, EditActivity.class);
            ((Intent)localObject).putExtra("title", 2131695091).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131695090).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
            startActivityForResult((Intent)localObject, 1007);
            continue;
            b(1);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
            continue;
            b(2);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
            continue;
            b(3);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
            continue;
            b(4);
            d();
            continue;
            ReportController.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
            if ((paramView.getTag() instanceof SchoolInfo))
            {
              localObject = (SchoolInfo)paramView.getTag();
              h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((SchoolInfo)localObject).jdField_b_of_type_Int), Integer.valueOf(((SchoolInfo)localObject).jdField_a_of_type_Int) }));
            }
            else if ((paramView.getTag() instanceof Card))
            {
              h("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != this.jdField_a_of_type_AndroidWidgetEditText) {
        break label70;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, HardCodeUtil.a(2131704908), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_d_of_type_AndroidWidgetEditText) || (!this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean));
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, HardCodeUtil.a(2131704932), 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */