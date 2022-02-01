package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

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
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new FriendProfileMoreInfoActivity.1(this);
  private ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new FriendProfileMoreInfoActivity.5(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FriendProfileMoreInfoActivity.4(this);
  private BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new FriendProfileMoreInfoActivity.3(this);
  BusinessCard jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ProfileConfig jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig;
  AllInOne jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne;
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new FriendProfileMoreInfoActivity.2(this);
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
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
      String str = HardCodeUtil.a(2131705006);
      DialogUtil.a(this, HardCodeUtil.a(2131704985), str, null, 2131695016, 2131695017, new FriendProfileMoreInfoActivity.7(this), new FriendProfileMoreInfoActivity.8(this)).show();
      ProfileCardUtil.a(paramCard, this.app);
      ReportController.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return;
    }
    long l1 = paramCard.lCurrentStyleId;
    l1 = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(RichStatusUtils.Companion.getRichStatus(paramCard));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
      a(paramCard.strNick);
    }
    else if (!TextUtils.isEmpty(paramCard.strNick))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
    }
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
    paramBoolean = this.jdField_f_of_type_Boolean;
    Object localObject2 = null;
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramCard.strLocationCodes)) {
        localObject1 = paramCard.strLocationCodes.split("-");
      } else {
        localObject1 = null;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      d(paramCard.strLocationDesc);
    }
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
    if (!this.jdField_h_of_type_Boolean) {
      g(paramCard.strPersonalNote);
    }
  }
  
  private void a(ArrayList<SchoolInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (this.n.getVisibility() == 0))
    {
      Object localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (localObject1 != null)
      {
        ((LinearLayout)localObject1).removeAllViews();
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            localObject1 = (SchoolInfo)paramArrayList.next();
            if (!TextUtils.isEmpty(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString))
            {
              View localView = View.inflate(this, 2131561337, null);
              TextView localTextView = (TextView)localView.findViewById(2131376950);
              if (((SchoolInfo)localObject1).jdField_b_of_type_Boolean)
              {
                localTextView.setText(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString);
                localObject2 = getResources().getDrawable(2130845173);
                ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
                localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
                localTextView.setCompoundDrawablePadding(AIOUtils.b(4.5F, localTextView.getResources()));
              }
              else
              {
                localTextView.setText(((SchoolInfo)localObject1).jdField_b_of_type_JavaLangString);
              }
              localTextView = (TextView)localView.findViewById(2131366099);
              Object localObject2 = ((SchoolInfo)localObject1).a();
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localTextView.setVisibility(8);
              } else {
                localTextView.setText((CharSequence)localObject2);
              }
              localTextView = (TextView)localView.findViewById(2131366100);
              if (((SchoolInfo)localObject1).jdField_a_of_type_Boolean) {
                localTextView.setVisibility(0);
              } else {
                localTextView.setVisibility(8);
              }
              localView.setOnClickListener(this);
              localView.setTag(localObject1);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
            }
          }
        }
        paramArrayList = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentAccountUin());
        if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
        {
          localObject1 = View.inflate(this, 2131561337, null);
          ((TextView)((View)localObject1).findViewById(2131376950)).setText(paramArrayList.strSchool);
          ((TextView)((View)localObject1).findViewById(2131366099)).setVisibility(8);
          ((View)localObject1).setOnClickListener(this);
          ((View)localObject1).setTag(paramArrayList);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        }
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
        {
          this.n.findViewById(2131376941).setVisibility(0);
          this.n.findViewById(2131376945).setVisibility(0);
          this.n.findViewById(2131376943).setVisibility(0);
          this.n.findViewById(2131376939).setVisibility(8);
          return;
        }
        this.n.findViewById(2131376941).setVisibility(8);
        this.n.findViewById(2131376945).setVisibility(8);
        this.n.findViewById(2131376943).setVisibility(8);
        this.n.findViewById(2131376939).setVisibility(0);
      }
    }
  }
  
  private void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("onDeleteOldSchoolResult:");
      paramCard.append(paramBoolean);
      QLog.e("FriendProfileMoreInfoActivity", 2, paramCard.toString());
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
    if (!NetworkUtil.isNetSupport(this))
    {
      a(paramInt1, paramInt2);
    }
    else if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(paramBundle);
      return true;
    }
    return false;
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1 == paramArrayOfString2) {
      return true;
    }
    for (;;)
    {
      int i1;
      try
      {
        if (paramArrayOfString1.length == paramArrayOfString2.length)
        {
          i1 = 0;
          if (i1 < paramArrayOfString1.length) {
            if (paramArrayOfString1[i1].equals(paramArrayOfString2[i1])) {
              break label55;
            }
          }
          int i2 = paramArrayOfString1.length;
          if (i1 == i2) {
            break;
          }
        }
        return false;
      }
      catch (Exception paramArrayOfString1)
      {
        return false;
      }
      label55:
      i1 += 1;
    }
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("college", "");
    if (a(localBundle, 2131694424, 0)) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, localStringBuilder.toString(), "", "", "");
  }
  
  private boolean b()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(((String)localObject1).trim())))
      {
        localBundle.putString("nick", ((String)localObject1).trim());
        QZoneHelper.restartQzone();
      }
    }
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
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label248:
      break label248;
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
        localBundle.putString("email", (String)localObject1);
      }
    }
    if (this.jdField_h_of_type_Boolean) {
      localBundle.putString("personalNote", this.jdField_e_of_type_JavaLangString);
    }
    return a(localBundle, 2131694424, 0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.app.getLongAccountUin());
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.12(this));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.11(this));
        d(1);
        return;
      }
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult(localIntent, 1003);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.10(this));
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131695013, 0);
    localActionSheet.addButton(2131695015, 0);
    localActionSheet.addButton(2131695014, 0);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new FriendProfileMoreInfoActivity.9(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1, true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startLocationSelectActivity | update result = ");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("FriendProfileMoreInfoActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131691060));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131691060));
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (paramInt == 1) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    if (paramInt == 1) {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
    } else {
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
    }
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
    Object localObject1 = new Intent(this, LocationSelectActivity.class);
    ((Intent)localObject1).putExtra("param_is_popup", false);
    ((Intent)localObject1).putExtra("param_req_type", i1);
    ((Intent)localObject1).putExtra("param_location", (String[])localObject2);
    ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String[])localObject2));
    if (paramInt == 1) {
      paramInt = 1005;
    } else {
      paramInt = 1006;
    }
    startActivityForResult((Intent)localObject1, paramInt);
  }
  
  private void e()
  {
    if (a())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131704983));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_Boolean = true;
        if (!isFinishing()) {
          finish();
        }
      }
      else
      {
        if (b())
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        if (!isFinishing()) {
          finish();
        }
      }
    }
    else if (!isFinishing())
    {
      finish();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376826));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693301);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693301));
    Object localObject = (TextView)findViewById(2131369202);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131705028));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365187));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363158);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131692138));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363154));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377594);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377596));
    a(null);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379291);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131379294));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379292));
      localObject = findViewById(2131379290);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
        {
          this.jdField_c_of_type_AndroidViewView.setClickable(true);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          ((View)localObject).setVisibility(0);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setClickable(false);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
        ((View)localObject).setVisibility(8);
      }
      a();
    }
    this.jdField_d_of_type_AndroidViewView = findViewById(2131371869);
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).setMargins(0, 0, 0, 0);
    }
    this.jdField_d_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371868));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
    a(null);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131377347);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377348));
    a(-1, false);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131363625);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363626));
    a(0, 0, 0);
    if (ProfileCardUtil.a())
    {
      int i1 = this.jdField_e_of_type_AndroidViewView.getPaddingLeft();
      int i2 = this.jdField_e_of_type_AndroidViewView.getPaddingTop();
      int i3 = this.jdField_e_of_type_AndroidViewView.getPaddingRight();
      int i4 = this.jdField_e_of_type_AndroidViewView.getPaddingBottom();
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839440);
      this.jdField_e_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isDevelopLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
      }
    }
    this.jdField_g_of_type_AndroidViewView = findViewById(2131373092);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373091));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373093));
    a(-1);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131365042);
    this.jdField_h_of_type_AndroidViewView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365041));
    this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
    this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
    b(null);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131376949);
    this.jdField_i_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376946));
    this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
    this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
    this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
    c(null);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131370426);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370440));
    d(null);
    this.k = findViewById(2131368224);
    this.k.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368225));
    e(null);
    this.l = findViewById(2131366112);
    this.l.setClickable(false);
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366111));
    this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
    this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
    this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher);
    this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_a_of_type_Boolean = true;
    f(null);
    this.m = findViewById(2131372484);
    this.m.setOnClickListener(this);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372485));
    g(null);
    this.n = findViewById(2131366102);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362251));
    findViewById(2131376940).setOnClickListener(this);
    findViewById(2131376944).setOnClickListener(this);
    findViewById(2131376942).setOnClickListener(this);
    findViewById(2131376938).setOnClickListener(this);
    localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((this.jdField_i_of_type_Boolean) && (((TroopManager)localObject).m(this.jdField_a_of_type_JavaLangString)))
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
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne == null) {
      return;
    }
    SignatureEditManager.b(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    int i1 = 1;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561132, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new FriendProfileMoreInfoActivity.13(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
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
    int i2 = this.jdField_a_of_type_Byte;
    if ((i2 != 0) && (i2 != 1))
    {
      this.jdField_a_of_type_Byte = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    a(this.jdField_a_of_type_Byte, true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (this.jdField_a_of_type_Byte != 1) {
      i1 = 0;
    }
    ((IphonePickerView)localObject).setSelection(0, i1);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new FriendProfileMoreInfoActivity.15(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoSchoolWeb ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FriendProfileMoreInfoActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("hide_more_button", true);
    startActivityForResult((Intent)localObject, 1012);
  }
  
  private void i()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void a()
  {
    String str = ContactUtils.c(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      str = "";
    }
    SpannableString localSpannableString = new ColorNickText(str, 16).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
    ColorNickManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
    a(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131697573), str);
  }
  
  void a(int paramInt)
  {
    if (NearbyProfileUtil.a(paramInt)) {
      this.jdField_e_of_type_Int = paramInt;
    } else {
      this.jdField_e_of_type_Int = -1;
    }
    Object localObject2 = NearbyProfileUtil.e(paramInt);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.jdField_e_of_type_Int = -1;
      localObject1 = getString(2131695113);
    }
    int i1 = NearbyProfileUtil.e.length;
    boolean bool = true;
    if ((paramInt < i1 - 1) && (paramInt > 0))
    {
      localObject2 = getResources().getDrawable(NearbyProfileUtil.b[paramInt]);
      ProfileCardUtils.setNightModeFilterForDrawable(this.app, (Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[paramInt]);
    }
    else
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localObject2 = this.jdField_g_of_type_AndroidWidgetTextView;
    if (this.jdField_e_of_type_Int != -1) {
      bool = false;
    }
    a((TextView)localObject2, (CharSequence)localObject1, bool);
    localObject2 = this.jdField_g_of_type_AndroidViewView;
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    String str = getString(2131695114);
    if (paramInt == -1) {
      localObject1 = "";
    }
    a((View)localObject2, localTextView, str, (String)localObject1);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    String str1 = a();
    boolean bool = true;
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
    if (paramInt1 != 0) {
      bool = false;
    }
    a((TextView)localObject, str1, bool);
    localObject = this.jdField_f_of_type_AndroidViewView;
    TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    String str2 = getString(2131695009);
    if (paramInt1 == 0) {
      str1 = "";
    }
    a((View)localObject, localTextView, str2, str1);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131695117);
    if (paramInt == 0) {
      str = getString(2131693879);
    } else if (paramInt == 1) {
      str = getString(2131692259);
    }
    if (paramBoolean)
    {
      a(this.jdField_d_of_type_AndroidWidgetTextView, str, 2131167064);
    }
    else
    {
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if ((paramInt != 0) && (paramInt != 1)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      a((TextView)localObject, str, paramBoolean);
    }
    Object localObject = str;
    if (paramInt != 0) {
      if (paramInt == 1) {
        localObject = str;
      } else {
        localObject = "";
      }
    }
    a(this.jdField_e_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131695118), (String)localObject);
  }
  
  void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",");
    localObject = ((StringBuilder)localObject).toString();
    paramView1.setContentDescription((CharSequence)localObject);
    paramView1 = (View)localObject;
    if ((paramView2 instanceof EditText))
    {
      paramView1 = new StringBuilder();
      paramView1.append(paramString1);
      paramView1.append(HardCodeUtil.a(2131705010));
      paramView1.append(paramString2);
      paramView1.append(",");
      paramView1 = paramView1.toString();
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
    int i1;
    if (paramBoolean) {
      i1 = 2131167144;
    } else {
      i1 = 2131167056;
    }
    a(paramTextView, paramCharSequence, i1);
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool;
    if (paramRichStatus != null)
    {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
      this.jdField_d_of_type_JavaLangString = paramRichStatus;
      bool = false;
    }
    else
    {
      paramRichStatus = HardCodeUtil.a(2131705017);
      this.jdField_d_of_type_JavaLangString = "";
      bool = true;
    }
    a(this.jdField_c_of_type_AndroidWidgetTextView, paramRichStatus, bool);
    a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetTextView, getString(2131693386), paramRichStatus);
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = getString(2131695066);
      paramString = "";
    }
    else
    {
      str = paramString;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(str);
    a(this.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131695067), paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramString1))
    {
      HWTroopUtils.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("edit_mode", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    if (paramInt == 1011)
    {
      paramString1 = getString(2131697577);
      localIntent.putExtra("edit_type", 5);
      localIntent.putExtra("default_nick_id", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.a());
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString());
      paramString2.append("");
      localIntent.putExtra("default_text", paramString2.toString());
      localIntent.putExtra("max_num", 60);
    }
    else
    {
      paramString1 = "";
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", HardCodeUtil.a(2131704991));
    } else {
      localIntent.putExtra("default_text", "");
    }
    RouteUtils.a(this, localIntent, "/base/activity/editInfoActivity", paramInt);
  }
  
  void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131695019);
    a(this.jdField_h_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131695020), str);
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131695115);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131695116), str);
  }
  
  void d(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("不限")))
    {
      bool = false;
    }
    else
    {
      paramString = getString(2131695062);
      bool = true;
    }
    a(this.jdField_h_of_type_AndroidWidgetTextView, paramString, bool);
    View localView = this.jdField_j_of_type_AndroidViewView;
    TextView localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    String str = getString(2131695063);
    if (bool) {
      paramString = "";
    }
    a(localView, localTextView, str, paramString);
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
    if (paramInt1 == 1002)
    {
      if (paramInt2 != 1001) {
        ((IProfileProtocolService)this.app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
      }
    }
    else if (paramInt1 == 1003)
    {
      if (paramIntent != null)
      {
        int i1 = paramIntent.getShortExtra("param_year", (short)1990);
        int i2 = paramIntent.getByteExtra("param_month", (byte)1);
        int i3 = paramIntent.getByteExtra("param_day", (byte)1);
        paramInt1 = paramIntent.getIntExtra("param_age", 0);
        paramInt2 = paramIntent.getIntExtra("param_constellation_id", 0);
        i1 = i1 << 16 | i2 << 8 | i3;
        if (i1 != this.jdField_b_of_type_Int)
        {
          this.jdField_d_of_type_Boolean = true;
          a(i1, paramInt1, paramInt2);
        }
      }
    }
    else if (paramInt1 == 1004)
    {
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("param_id", -1);
        if (paramInt1 != this.jdField_e_of_type_Int)
        {
          this.jdField_e_of_type_Boolean = true;
          a(paramInt1);
        }
      }
    }
    else if (paramInt1 == 1005)
    {
      if (paramIntent == null) {
        break label464;
      }
      paramIntent = paramIntent.getStringArrayExtra("param_location");
      if (a(this.jdField_a_of_type_ArrayOfJavaLangString, paramIntent)) {
        break label464;
      }
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramIntent;
    }
    try
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
    }
    catch (Exception paramIntent)
    {
      label228:
      Object localObject;
      break label228;
    }
    paramIntent = null;
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
    if (paramInt1 == 1006)
    {
      if (paramIntent == null) {
        break label464;
      }
      paramIntent = paramIntent.getStringArrayExtra("param_location");
      if (a(this.jdField_b_of_type_ArrayOfJavaLangString, paramIntent)) {
        break label464;
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_ArrayOfJavaLangString = paramIntent;
    }
    try
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
    }
    catch (Exception paramIntent)
    {
      label314:
      break label314;
    }
    paramIntent = null;
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
    if (paramInt1 == 1007)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("result");
        if (!paramIntent.equals(this.jdField_e_of_type_JavaLangString))
        {
          this.jdField_h_of_type_Boolean = true;
          g(paramIntent);
        }
      }
    }
    else
    {
      if (paramInt1 == 1011)
      {
        a();
        return;
      }
      if (paramInt1 == 1012)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler != null)
        {
          paramIntent = this.app.getCurrentAccountUin();
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          c();
        }
      }
    }
    label464:
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      super.setContentView(2131561336);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
      paramBundle = getIntent();
      this.jdField_i_of_type_Boolean = paramBundle.getBooleanExtra("isTroopMemberCard", false);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("memberUin");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("options");
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = localJSONObject.optString("troopUin");
          this.jdField_b_of_type_JavaLangString = localJSONObject.optString("memberUin");
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
            this.jdField_i_of_type_Boolean = true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          QLog.d("FriendProfileMoreInfoActivity", 1, localJSONException.getMessage());
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileMoreInfoActivity", 2, String.format("openView options: %s", new Object[] { this.jdField_c_of_type_JavaLangString }));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig = new ProfileConfig(this.app, null);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = (LinearLayout)super.findViewById(2131376816);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        ((LinearLayout)localObject).setFitsSystemWindows(true);
        ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      f();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne = ((AllInOne)getIntent().getParcelableExtra("AllInOne"));
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne = new AllInOne(this.app.getCurrentUin(), 0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = BusinessCardUtils.a(this.app);
      }
      ThreadManager.post(new FriendProfileMoreInfoActivity.6(this), 5, null, true);
      if (!this.jdField_i_of_type_Boolean)
      {
        a(((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a());
        c();
      }
      int i1 = paramBundle.getIntExtra("profile_jump_to_edit", 0);
      if (i1 > 0)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("jump to edit type ");
          paramBundle.append(i1);
          QLog.d("FriendProfileMoreInfoActivity", 2, paramBundle.toString());
        }
        c(i1);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800A0D4", "0X800A0D4", 0, 0, "", "", "", "");
      return true;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig;
    if (localObject != null)
    {
      ((ProfileConfig)localObject).destroy();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigProfileConfig = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localObject != null)
    {
      ((ConditionSearchManager)localObject).b(this);
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
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("FriendProfileMoreInfoActivity", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
        localStringBuilder.append(localIllegalArgumentException.getMessage());
        QLog.e("FriendProfileMoreInfoActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  void e(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("不限")))
    {
      bool = false;
    }
    else
    {
      paramString = getString(2131695056);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, paramString, bool);
    View localView = this.k;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str = getString(2131695057);
    if (bool) {
      paramString = "";
    }
    a(localView, localTextView, str, paramString);
  }
  
  void f(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_d_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131695049);
    a(this.l, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131695050), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      localIntent.putExtra("result", localBundle);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void g(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    int i1;
    String str1;
    if (TextUtils.isEmpty(paramString))
    {
      i1 = 1;
      str1 = getString(2131695080);
    }
    else
    {
      i1 = 0;
      str1 = paramString;
    }
    a(this.jdField_j_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
    paramString = this.m;
    TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
    String str2 = getString(2131695081);
    if (i1 != 0) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1000) {
      return true;
    }
    int i1 = this.jdField_a_of_type_Int;
    if ((i1 == 1) || (i1 == 2))
    {
      i();
      QQToast.a(this, 2131691057, 0).b(getTitleBarHeight());
    }
    return true;
  }
  
  protected boolean onBackEvent()
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
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      try
      {
        localLinearLayout.requestFocus();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", localThrowable);
      }
    }
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379291: 
      localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        if ((!((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, this.app.getCurrentAccountUin())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
          }
        }
        else {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne.uin, 1011);
        }
      }
      break;
    case 2131377594: 
      g();
      ReportController.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
      break;
    case 2131377347: 
      h();
      break;
    case 2131376944: 
      b(2);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      break;
    case 2131376942: 
      b(3);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
      break;
    case 2131376940: 
      b(1);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      break;
    case 2131376938: 
      b(4);
      d();
      break;
    case 2131373092: 
      localObject = new Intent(this, JobSelectionActivity.class);
      ((Intent)localObject).putExtra("param_id", this.jdField_e_of_type_Int);
      startActivityForResult((Intent)localObject, 1004);
      break;
    case 2131372484: 
      localObject = new Intent(this, EditActivity.class);
      ((Intent)localObject).putExtra("title", 2131695081).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131695080).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult((Intent)localObject, 1007);
      break;
    case 2131370426: 
      d(1);
      break;
    case 2131369202: 
      e();
      break;
    case 2131368224: 
      d(2);
      break;
    case 2131366101: 
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
      break;
    case 2131363625: 
      localObject = new Intent(this, AgeSelectionActivity.class);
      ((Intent)localObject).putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult((Intent)localObject, 1003);
      break;
    case 2131363158: 
      localObject = new Intent(this, AvatarPendantActivity.class);
      ((Intent)localObject).putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataAllInOne);
      ((Intent)localObject).putExtra("showActionSheet", true);
      startActivity((Intent)localObject);
      ReportController.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty(paramView.trim()))) {
            QQToast.a(this, HardCodeUtil.a(2131704984), 0).b(getTitleBarHeight());
          }
        }
      }
      else if ((paramView == this.jdField_d_of_type_AndroidWidgetEditText) && (this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean))
      {
        paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
        Matcher localMatcher = SearchBaseActivity.a.matcher(paramView);
        if ((!TextUtils.isEmpty(paramView)) && (!localMatcher.matches())) {
          QQToast.a(this, HardCodeUtil.a(2131705008), 0).b(getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */