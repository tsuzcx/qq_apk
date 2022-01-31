package com.tencent.mobileqq.activity;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.NowOnliveGallayCallback;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.campuscircle.CampusCircleConstant;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.campuscircle.CampusConfig;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.PhotoWallView.QZonePhotoCache;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import spn;
import spq;
import spr;
import sps;
import spt;
import spu;
import spv;
import spw;
import spx;
import spy;
import spz;
import sqa;
import sqb;
import sqc;
import sqf;
import sqg;
import sqh;
import sqi;
import sqj;
import sqk;
import sql;
import sqn;
import sqo;
import sqp;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements Handler.Callback, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener
{
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private byte jdField_a_of_type_Byte;
  public int a;
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Bundle a;
  View jdField_a_of_type_AndroidViewView;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne a;
  private CardHandler.NowOnliveGallayCallback jdField_a_of_type_ComTencentMobileqqAppCardHandler$NowOnliveGallayCallback = new sqi(this);
  public CardHandler a;
  public CardObserver a;
  private ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new sqh(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new sqg(this);
  private BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new sqf(this);
  public BusinessCard a;
  public CampusCircleObserver a;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  public Card a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private PhotoWallView.QZonePhotoCache jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache = new PhotoWallView.QZonePhotoCache();
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  public WeakReferenceHandler a;
  public ActionSheet a;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  public String a;
  public ArrayList a;
  public sqo a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public sqo b;
  public boolean b;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  public EditText c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  public sqo c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public boolean f;
  private int jdField_g_of_type_Int = -1;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private int jdField_h_of_type_Int = -1;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private int jdField_i_of_type_Int = -1;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private int jdField_j_of_type_Int = -1;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = -1;
  private View jdField_k_of_type_AndroidViewView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public boolean k;
  private int jdField_l_of_type_Int = -1;
  private View jdField_l_of_type_AndroidViewView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public boolean l;
  private int jdField_m_of_type_Int = -1;
  private View jdField_m_of_type_AndroidViewView;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public boolean m;
  private int jdField_n_of_type_Int = -1;
  private View jdField_n_of_type_AndroidViewView;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int = -1;
  private View jdField_o_of_type_AndroidViewView;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  public boolean o;
  private int jdField_p_of_type_Int = -1;
  private View jdField_p_of_type_AndroidViewView;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int = -1;
  private View jdField_q_of_type_AndroidViewView;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  private int jdField_r_of_type_Int = -1;
  private View jdField_r_of_type_AndroidViewView;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int = -1;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int = -1;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int = -1;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean;
  private boolean z;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataCard = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver = new spn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new sqa(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sqc(this);
  }
  
  public static List a(List paramList1, List paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int i2 = 0;
    int i1 = 0;
    label34:
    if (i2 < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(i2);
      label56:
      if (i1 >= paramList1.size()) {
        break label123;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i1);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label116;
      }
      int i3 = i1 + 1;
      paramList1.add(i1, localProfilePhotoWall1);
      i1 = i3;
    }
    label116:
    label123:
    for (;;)
    {
      i2 += 1;
      break label34;
      break;
      i1 += 1;
      break label56;
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent.hasExtra("param_interest_switch")) {
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("param_interest_switch", 0);
    }
    if (!this.jdField_r_of_type_Boolean) {
      this.jdField_r_of_type_Boolean = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_music_switch")) {
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("param_music_switch", 0);
    }
    if (!this.jdField_s_of_type_Boolean) {
      this.jdField_s_of_type_Boolean = paramIntent.getBooleanExtra("param_music_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_recent_activity_switch")) {
      this.jdField_j_of_type_Int = paramIntent.getIntExtra("param_recent_activity_switch", 0);
    }
    if (!this.jdField_t_of_type_Boolean) {
      this.jdField_t_of_type_Boolean = paramIntent.getBooleanExtra("param_recent_activity_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_star_switch")) {
      this.jdField_k_of_type_Int = paramIntent.getIntExtra("param_star_switch", 0);
    }
    if (!this.jdField_u_of_type_Boolean) {
      this.jdField_u_of_type_Boolean = paramIntent.getBooleanExtra("param_star_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_joined_group_switch")) {
      this.jdField_l_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", 0);
    }
    if (!this.jdField_v_of_type_Boolean) {
      this.jdField_v_of_type_Boolean = paramIntent.getBooleanExtra("param_joined_group_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_now_switch")) {
      this.jdField_m_of_type_Int = paramIntent.getIntExtra("param_now_switch", 0);
    }
    if (!this.jdField_w_of_type_Boolean) {
      this.jdField_w_of_type_Boolean = paramIntent.getBooleanExtra("param_now_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_ktv_switch")) {
      this.jdField_n_of_type_Int = paramIntent.getIntExtra("param_ktv_switch", 0);
    }
    if (!this.jdField_x_of_type_Boolean) {
      this.jdField_x_of_type_Boolean = paramIntent.getBooleanExtra("param_ktv_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_eat_switch")) {
      this.jdField_o_of_type_Int = paramIntent.getIntExtra("param_eat_switch", 0);
    }
    if (!this.jdField_y_of_type_Boolean) {
      this.jdField_y_of_type_Boolean = paramIntent.getBooleanExtra("param_eat_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_reader_switch")) {
      this.jdField_p_of_type_Int = paramIntent.getIntExtra("param_reader_switch", 0);
    }
    if (!this.z) {
      this.z = paramIntent.getBooleanExtra("param_reader_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_radio_switch")) {
      this.jdField_q_of_type_Int = paramIntent.getIntExtra("param_radio_switch", 0);
    }
    if (!this.A) {
      this.A = paramIntent.getBooleanExtra("param_radio_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_comic_switch")) {
      this.jdField_r_of_type_Int = paramIntent.getIntExtra("param_comic_switch", 0);
    }
    if (!this.B) {
      this.B = paramIntent.getBooleanExtra("param_comic_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_education_switch")) {
      this.jdField_s_of_type_Int = paramIntent.getIntExtra("param_education_switch", 0);
    }
    if (!this.C) {
      this.C = paramIntent.getBooleanExtra("param_education_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_using_tim_switch")) {
      this.jdField_t_of_type_Int = paramIntent.getIntExtra("param_using_tim_switch", 0);
    }
    if (!this.D) {
      this.D = paramIntent.getBooleanExtra("param_using_tim_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_weishi_switch")) {
      this.jdField_u_of_type_Int = paramIntent.getIntExtra("param_weishi_switch", 0);
    }
    if (!this.E) {
      this.E = paramIntent.getBooleanExtra("param_weishi_switch_changed", false);
    }
    if (a()) {
      j();
    }
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
  
  private void a(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramMessage);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) {
        a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList);
      }
    }
  }
  
  private void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("updatePhotoWall curSize=%s totalSize=%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramInt) }));
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%s张", new Object[] { Integer.valueOf(paramInt) }));
    int i2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getWidth();
    int i3 = paramList.size();
    int i1 = 0;
    paramInt = 0;
    label117:
    Object localObject1;
    if (i1 < i3)
    {
      localObject1 = (ProfilePhotoWall)paramList.get(i1);
      if (localObject1 == null) {
        break label393;
      }
    }
    label393:
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            localObject2 = getResources();
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(((Resources)localObject2).getColor(2131493014));
            this.jdField_x_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131558552);
            this.jdField_y_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131558553);
          }
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_x_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_x_of_type_Int;
          localObject2 = URLDrawable.getDrawable(((ProfilePhotoWall)localObject1).getThumbUrl(this.jdField_w_of_type_Int), (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = new ImageView(getBaseContext());
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_x_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_x_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.jdField_y_of_type_Int;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          i4 = this.jdField_x_of_type_Int;
          i5 = this.jdField_y_of_type_Int;
          paramInt = i4 + i5 + paramInt;
        }
        catch (Exception localException1)
        {
          int i4;
          int i5;
          continue;
        }
        try
        {
          i4 = this.jdField_x_of_type_Int;
          i5 = this.jdField_y_of_type_Int;
          if (i4 + paramInt + i5 > i2) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      i1 += 1;
      break label117;
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = ((CampusCircleHandler)this.app.a(108)).a();
    if (paramBoolean) {
      localObject1 = ((CampusConfig)localObject1).jdField_b_of_type_JavaLangString;
    }
    for (int i1 = 1010;; i1 = 1009)
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains("adtag=edit")) {
          localObject2 = (String)localObject1 + "&adtag=edit";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        startActivityForResult((Intent)localObject1, i1);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "changeOrCertificateSchool isCertificateSchool: %b url: %s requestCode: %d", new Object[] { Boolean.valueOf(paramBoolean), localObject2, Integer.valueOf(i1) }));
      }
      return;
      localObject1 = ((CampusConfig)localObject1).jdField_a_of_type_JavaLangString;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_r_of_type_Boolean) || (this.jdField_s_of_type_Boolean) || (this.jdField_t_of_type_Boolean) || (this.jdField_u_of_type_Boolean) || (this.jdField_v_of_type_Boolean) || (this.jdField_x_of_type_Boolean) || (this.jdField_y_of_type_Boolean) || (this.z) || (this.A) || (this.jdField_w_of_type_Boolean) || (this.B) || (this.C) || (this.D) || (this.E);
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
    if (b())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在更新资料");
      }
      if (this.jdField_b_of_type_Int != 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        if ((this.jdField_b_of_type_Int & 0x1) == 1) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((this.jdField_b_of_type_Int & 0x2) == 2) {
          this.jdField_b_of_type_Boolean = true;
        }
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
        if (d()) {
          this.jdField_b_of_type_Int |= 0x1;
        }
        if (c()) {
          this.jdField_b_of_type_Int |= 0x2;
        }
        if (this.jdField_b_of_type_Int != 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
      } while (isFinishing());
      finish();
      return;
    }
    finish();
  }
  
  private void b(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {}
    Object localObject1;
    label220:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard.getRichStatus());
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((this.jdField_a_of_type_Sqo.jdField_b_of_type_Boolean) || (paramCard.strNick == null) || (paramCard.strNick.equals(localObject1))) {
        break;
      }
      this.jdField_a_of_type_Sqo.jdField_a_of_type_Boolean = true;
      a(paramCard.strNick);
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
      if ((!this.jdField_b_of_type_Sqo.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_Sqo.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      a(paramCard, paramBoolean);
      if (!this.jdField_f_of_type_Boolean)
      {
        if (TextUtils.isEmpty(paramCard.strLocationCodes)) {
          break label423;
        }
        localObject1 = paramCard.strLocationCodes.split("-");
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        f(paramCard.strLocationDesc);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        g(paramCard.strHometownDesc);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_Sqo.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_c_of_type_Sqo.jdField_a_of_type_Boolean = true;
        h(paramCard.strEmail);
      }
      if (!this.jdField_h_of_type_Boolean) {
        i(paramCard.strPersonalNote);
      }
      if (paramCard.switch_disable_personality_label != -1) {
        this.jdField_g_of_type_Int = paramCard.switch_disable_personality_label;
      }
    } while (this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
    paramCard = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_g_of_type_Int != 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCard.setChecked(paramBoolean);
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break;
      label423:
      localObject1 = null;
      break label220;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Sqo.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Sqo.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Sqo.jdField_b_of_type_Boolean) || (this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.jdField_j_of_type_Boolean);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131435746);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435746));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433681);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("返回按钮");
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363533));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370911);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131437152));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370912));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370537));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370913);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131434560));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370914));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370915);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370916));
    a(null);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131370917);
    View localView;
    if (this.jdField_p_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370919));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370920));
      localView = findViewById(2131370921);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null) {
        break label1430;
      }
      if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        this.jdField_d_of_type_AndroidViewView.setClickable(true);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      a();
      this.jdField_e_of_type_AndroidViewView = findViewById(2131370922);
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_e_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370924));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_Sqo = new sqo(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Sqo);
      this.jdField_a_of_type_Sqo.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131370925);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370926));
      a(-1, false);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131370927);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370928));
      a(0, 0, 0);
      if (ProfileCardUtil.b())
      {
        int i1 = this.jdField_f_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_f_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_f_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_f_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838626);
        this.jdField_f_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_h_of_type_AndroidViewView = findViewById(2131370929);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370930));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370931));
      a(-1);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131370932);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370933));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_Sqo = new sqo(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Sqo);
      this.jdField_b_of_type_Sqo.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131370934);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131370935));
      this.jdField_k_of_type_AndroidViewView = findViewById(2131370936);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131370937));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131370938));
      this.jdField_l_of_type_AndroidViewView = findViewById(2131370939);
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131370940));
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131370941));
      this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_l_of_type_AndroidViewView.setVisibility(8);
      c(null);
      this.jdField_m_of_type_AndroidViewView = findViewById(2131364300);
      this.jdField_m_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370942));
      f(null);
      this.jdField_n_of_type_AndroidViewView = findViewById(2131370943);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370944));
      g(null);
      this.jdField_o_of_type_AndroidViewView = findViewById(2131370945);
      this.jdField_o_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370946));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_Sqo = new sqo(this, 50, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Sqo);
      this.jdField_c_of_type_Sqo.jdField_a_of_type_Boolean = true;
      h(null);
      this.jdField_p_of_type_AndroidViewView = findViewById(2131370947);
      this.jdField_p_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370948));
      i(null);
      this.jdField_q_of_type_AndroidViewView = findViewById(2131370949);
      this.jdField_q_of_type_AndroidViewView.setContentDescription(getString(2131437505));
      this.jdField_q_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_r_of_type_AndroidViewView = findViewById(2131370951);
      this.jdField_r_of_type_AndroidViewView.setContentDescription(getString(2131437503));
      this.jdField_r_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370950));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      if ((this.jdField_p_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_n_of_type_AndroidViewView.setVisibility(8);
        this.jdField_q_of_type_AndroidViewView.setVisibility(8);
        this.jdField_o_of_type_AndroidViewView.setVisibility(8);
        this.jdField_p_of_type_AndroidViewView.setVisibility(8);
        this.jdField_r_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      return;
      label1430:
      this.jdField_d_of_type_AndroidViewView.setClickable(false);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(null);
      localView.setVisibility(8);
    }
  }
  
  private void c(int paramInt)
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
        QQToast.a(this, 2131434794, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131437280));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131437280));
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Object localObject1;
    if (paramInt == 1)
    {
      i1 = 2;
      if (paramInt != 1) {
        break label274;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label149:
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
        break label282;
      }
    }
    label274:
    label282:
    for (paramInt = 1005;; paramInt = 1006)
    {
      startActivityForResult((Intent)localObject1, paramInt);
      return;
      i1 = 3;
      break;
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label149;
    }
  }
  
  private boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      return bool2;
    }
    Bundle localBundle = new Bundle();
    int i1 = CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID);
    CampusCircleHandler localCampusCircleHandler = (CampusCircleHandler)this.app.a(108);
    String str;
    if (this.jdField_k_of_type_Boolean)
    {
      str = this.jdField_l_of_type_AndroidWidgetTextView.getText().toString();
      if (i1 == 4)
      {
        localBundle.putString("campus_college", str);
        label83:
        bool1 = true;
      }
    }
    else if (this.jdField_l_of_type_Boolean)
    {
      str = this.jdField_n_of_type_AndroidWidgetTextView.getText().toString();
      if (i1 != 4) {
        break label164;
      }
      localBundle.putInt("campus_enroll_year", Integer.parseInt(str));
    }
    for (;;)
    {
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localCampusCircleHandler.a(localBundle);
      return bool1;
      localBundle.putInt("campus_enroll_year", CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID, str));
      break label83;
      label164:
      localBundle.putString("campus_class", str);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    Object localObject = IndividuationUrlHelper.a("signatureH5Url");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("http")))
    {
      VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject, -1L, null, false, -1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = new Intent(this, QQIndividualityBridgeActivity.class);
      ((Intent)localObject).putExtra("k_source", 4);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra(QQIndividualityUtils.l, 1);
      ((Intent)localObject).putExtra(QQIndividualityUtils.e, "path");
      ((Intent)localObject).putExtra(QQIndividualityUtils.f, "name");
      ((Intent)localObject).putExtra(QQIndividualityUtils.i, 1002);
      startActivityForResult((Intent)localObject, 1002);
      return;
    }
    Intent localIntent = new Intent(this, QQIndividualityBridgeActivity.class);
    localIntent.putExtra("key__entry_type", 1);
    localIntent.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;; localObject = "")
    {
      localIntent.putExtra("key_uin_name", (String)localObject);
      localIntent.putExtra(QQIndividualityUtils.l, 2);
      localIntent.putExtra(QQIndividualityUtils.e, "path");
      localIntent.putExtra(QQIndividualityUtils.f, "name");
      localIntent.putExtra(QQIndividualityUtils.i, 1002);
      startActivityForResult(localIntent, 1002);
      return;
    }
  }
  
  private boolean d()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_Sqo.jdField_b_of_type_Boolean)
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
        localBundle.putInt("birthday", this.jdField_c_of_type_Int);
        localBundle.putInt("age", this.jdField_d_of_type_Int);
        localBundle.putInt("key_constellation", this.jdField_e_of_type_Int);
      }
      if (this.jdField_e_of_type_Boolean) {
        localBundle.putInt("profession", this.jdField_f_of_type_Int);
      }
      if (this.jdField_b_of_type_Sqo.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_f_of_type_Boolean)
      {
        localObject1 = this.jdField_o_of_type_AndroidWidgetTextView.getText().toString();
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("locationo_desc", (String)localObject1);
        localObject1 = null;
      }
    }
    label419:
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label213:
      int i1;
      label306:
      break label213;
    }
    localBundle.putStringArray("location_name", (String[])localObject1);
    if (this.jdField_g_of_type_Boolean)
    {
      localObject1 = this.jdField_p_of_type_AndroidWidgetTextView.getText().toString();
      localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.jdField_c_of_type_Sqo.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      localObject2 = SearchBaseActivity.a.matcher((CharSequence)localObject1);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((Matcher)localObject2).matches())) {}
    }
    else
    {
      if (this.jdField_h_of_type_Boolean) {
        localBundle.putString("personalNote", this.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_j_of_type_Boolean) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label419;
        }
      }
    }
    for (i1 = 0;; i1 = 1)
    {
      localBundle.putShort("key_personality_label_switch", (short)i1);
      return a(localBundle, 2131434794, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new QZoneDistributedAppCtrl.Control();
      ((QZoneDistributedAppCtrl.Control)localObject1).jdField_a_of_type_Int = 5;
      QZoneDistributedAppCtrl.a(getAppRuntime().getAccount()).a((QZoneDistributedAppCtrl.Control)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
      break label306;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130970344, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new spq(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131362787);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new spr(this));
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
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new sps(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 2, "handleSchoolLayoutClick card is null");
      }
      return;
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus == 4)
    {
      Object localObject2 = ((CampusCircleHandler)this.app.a(108)).a();
      if (Math.abs(NetConnInfoCenter.getServerTimeMillis() / 1000L - this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusLastModifySchoolTime) < ((CampusConfig)localObject2).jdField_a_of_type_Long)
      {
        localObject1 = String.format(Locale.getDefault(), "已认证学校每%d个月仅限修改一次，暂不能修改。", new Object[] { Integer.valueOf(((CampusConfig)localObject2).jdField_a_of_type_Int) });
        QQToast.a(BaseApplicationImpl.getContext(), 0, (CharSequence)localObject1, 0).a();
        if (this.jdField_m_of_type_Boolean)
        {
          a("0X80081E7", 1);
          return;
        }
        a("0X80081E4", 1);
        return;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusSchool)) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.strSchool;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusSchool)
      {
        localObject1 = String.format(Locale.getDefault(), "你已通过%s的认证审核，若修改为其他学校，须重新认证，且%d个月内仅限修改一次。是否继续修改？", new Object[] { localObject1, Integer.valueOf(((CampusConfig)localObject2).jdField_a_of_type_Int) });
        localObject2 = new spt(this);
        DialogUtil.a(this, (String)localObject1, 2131432998, 2131438923, new spu(this), (DialogInterface.OnClickListener)localObject2).show();
        return;
      }
    }
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_o_of_type_Boolean = true;
      a(true);
      a("0X80081E7", 2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusSchoolFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus == 1) && ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusSchool)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strSchool))))
    {
      localObject1 = ActionSheet.a(this);
      ((ActionSheet)localObject1).a("当前学校学生身份尚未认证，去认证或修改学校信息。");
      ((ActionSheet)localObject1).c("去校园圈认证");
      ((ActionSheet)localObject1).c("修改学校");
      ((ActionSheet)localObject1).c(2131432998);
      ((ActionSheet)localObject1).a(new spv(this));
      ((ActionSheet)localObject1).a(new spw(this, (ActionSheet)localObject1));
      ((ActionSheet)localObject1).show();
      return;
    }
    a(false);
    a("0X80081E5", 1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 2, "handleCampusExtraOneLayoutClick card is null");
      }
      return;
    }
    ArrayList localArrayList = null;
    switch (CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID))
    {
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break label230;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FriendProfileMoreInfoActivity", 2, "handleCampusExtraOneLayoutClick list data illegal");
      return;
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      continue;
      localArrayList = new ArrayList(CampusCircleConstant.c.length);
      int i1 = 0;
      while (i1 < CampusCircleConstant.c.length)
      {
        localArrayList.add(CampusCircleConstant.c[i1]);
        i1 += 1;
      }
      continue;
      localArrayList = new ArrayList(CampusCircleConstant.jdField_b_of_type_ArrayOfJavaLangString.length);
      i1 = 0;
      while (i1 < CampusCircleConstant.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        localArrayList.add(CampusCircleConstant.jdField_b_of_type_ArrayOfJavaLangString[i1]);
        i1 += 1;
      }
      continue;
      localArrayList = new ArrayList(CampusCircleConstant.jdField_a_of_type_ArrayOfJavaLangString.length);
      i1 = 0;
      while (i1 < CampusCircleConstant.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localArrayList.add(CampusCircleConstant.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        i1 += 1;
      }
    }
    label230:
    String str = this.jdField_l_of_type_AndroidWidgetTextView.getText().toString();
    if (!localArrayList.contains(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 2, String.format(Locale.getDefault(), "handleCampusExtraOneLayoutClick invalid %s", new Object[] { str }));
      }
      localArrayList.add(str);
    }
    a(localArrayList, str, new spx(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 2, "handleCampusExtraTwoLayoutClick card is null");
      }
      return;
    }
    ArrayList localArrayList = null;
    switch (CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID))
    {
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        break label206;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FriendProfileMoreInfoActivity", 2, "handleCampusExtraTwoLayoutClick list data illegal");
      return;
      localObject = ((CampusCircleHandler)this.app.a(108)).a();
      int i2 = Calendar.getInstance().get(1);
      localArrayList = new ArrayList(((CampusConfig)localObject).jdField_b_of_type_Int);
      int i1 = 0;
      while (i1 < ((CampusConfig)localObject).jdField_b_of_type_Int)
      {
        localArrayList.add(String.valueOf(i2 - i1));
        i1 += 1;
      }
      continue;
      localArrayList = new ArrayList(21);
      i1 = 0;
      while (i1 < CampusCircleConstant.d.length)
      {
        localArrayList.add(CampusCircleConstant.d[i1]);
        i1 += 1;
      }
    }
    label206:
    Object localObject = this.jdField_n_of_type_AndroidWidgetTextView.getText().toString();
    if (!localArrayList.contains(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 2, String.format(Locale.getDefault(), "handleCampusExtraTwoLayoutClick invalid %s", new Object[] { localObject }));
      }
      localArrayList.add(localObject);
    }
    a(localArrayList, (String)localObject, new spy(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, InterestSwitchEditActivity.class);
    if (-1 != this.jdField_o_of_type_Int) {
      localIntent.putExtra("param_eat_switch", this.jdField_o_of_type_Int);
    }
    if (-1 != this.jdField_h_of_type_Int) {
      localIntent.putExtra("param_interest_switch", this.jdField_h_of_type_Int);
    }
    if (-1 != this.jdField_l_of_type_Int) {
      localIntent.putExtra("param_joined_group_switch", this.jdField_l_of_type_Int);
    }
    if (-1 != this.jdField_m_of_type_Int) {
      localIntent.putExtra("param_now_switch", this.jdField_m_of_type_Int);
    }
    if (-1 != this.jdField_n_of_type_Int) {
      localIntent.putExtra("param_ktv_switch", this.jdField_n_of_type_Int);
    }
    if (-1 != this.jdField_i_of_type_Int) {
      localIntent.putExtra("param_music_switch", this.jdField_i_of_type_Int);
    }
    if (-1 != this.jdField_j_of_type_Int) {
      localIntent.putExtra("param_recent_activity_switch", this.jdField_j_of_type_Int);
    }
    if (-1 != this.jdField_k_of_type_Int) {
      localIntent.putExtra("param_star_switch", this.jdField_k_of_type_Int);
    }
    if (-1 != this.jdField_p_of_type_Int) {
      localIntent.putExtra("param_reader_switch", this.jdField_p_of_type_Int);
    }
    if (-1 != this.jdField_q_of_type_Int) {
      localIntent.putExtra("param_radio_switch", this.jdField_q_of_type_Int);
    }
    if (-1 != this.jdField_r_of_type_Int) {
      localIntent.putExtra("param_comic_switch", this.jdField_r_of_type_Int);
    }
    if (-1 != this.jdField_s_of_type_Int) {
      localIntent.putExtra("param_education_switch", this.jdField_s_of_type_Int);
    }
    if (-1 != this.jdField_t_of_type_Int) {
      localIntent.putExtra("param_using_tim_switch", this.jdField_t_of_type_Int);
    }
    if (-1 != this.jdField_u_of_type_Int) {
      localIntent.putExtra("param_weishi_switch", this.jdField_u_of_type_Int);
    }
    startActivityForResult(localIntent, 1008);
  }
  
  private void j()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_r_of_type_Boolean) {
      localBundle.putShort("key_interest_switch", (short)this.jdField_h_of_type_Int);
    }
    if (this.jdField_v_of_type_Boolean) {
      localBundle.putShort("key_joined_group_switch", (short)this.jdField_l_of_type_Int);
    }
    if (this.jdField_x_of_type_Boolean) {
      localBundle.putShort("key_ktv_switch", (short)this.jdField_n_of_type_Int);
    }
    if (this.jdField_s_of_type_Boolean) {
      localBundle.putShort("key_music_switch", (short)this.jdField_i_of_type_Int);
    }
    if (this.jdField_t_of_type_Boolean) {
      localBundle.putShort("key_recent_activity_switch", (short)this.jdField_j_of_type_Int);
    }
    if (this.jdField_u_of_type_Boolean) {
      localBundle.putShort("key_star_switch", (short)this.jdField_k_of_type_Int);
    }
    if (this.jdField_y_of_type_Boolean) {
      localBundle.putShort("key_eat_switch", (short)this.jdField_o_of_type_Int);
    }
    if (this.z) {
      localBundle.putShort("key_reader_switch", (short)this.jdField_p_of_type_Int);
    }
    if (this.A) {
      localBundle.putShort("key_radio_switch", (short)this.jdField_q_of_type_Int);
    }
    if (this.jdField_w_of_type_Boolean) {
      localBundle.putShort("key_now_switch", (short)this.jdField_m_of_type_Int);
    }
    if (this.B) {
      localBundle.putShort("key_comic_switch", (short)this.jdField_r_of_type_Int);
    }
    if (this.C) {
      localBundle.putShort("key_education_switch", (short)this.jdField_s_of_type_Int);
    }
    if (this.D) {
      localBundle.putShort("key_using_tim_switch", (short)this.jdField_t_of_type_Int);
    }
    if (this.E) {
      localBundle.putShort("key_weishi_switch", (short)this.jdField_u_of_type_Int);
    }
    a(localBundle, 2131434794, 0);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public ActionSheet a(List paramList, String paramString, sqp paramsqp)
  {
    ActionSheet localActionSheet = ActionSheet.c(this);
    paramList = new sqn(localActionSheet, paramList, paramString, paramsqp);
    paramString = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131362787);
    paramString.jdField_a_of_type_Boolean = true;
    paramString.setBackgroundResource(17170445);
    paramString = (IphonePickerView)LayoutInflater.from(this).inflate(2130970344, null);
    paramString.a(paramList);
    paramString.setPickListener(paramList);
    paramString.setSelection(paramList.a(), paramList.b());
    localActionSheet.a(paramList);
    localActionSheet.a(paramString, null);
    localActionSheet.show();
    return localActionSheet;
  }
  
  public void a()
  {
    String str = ContactUtils.h(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      a(this.jdField_d_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131430579), str);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
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
      this.jdField_f_of_type_Int = paramInt;
      localObject2 = NearbyProfileUtil.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_f_of_type_Int = -1;
        localObject1 = getString(2131437491);
      }
      if ((paramInt < NearbyProfileUtil.e.length - 1) && (paramInt > 0)) {
        break label137;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_j_of_type_AndroidWidgetTextView;
      if (this.jdField_f_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (CharSequence)localObject1, bool);
      localObject2 = this.jdField_h_of_type_AndroidViewView;
      localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      str = getString(2131437490);
      if (paramInt == -1) {
        break label172;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.jdField_f_of_type_Int = -1;
      break;
      label137:
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.b[paramInt]);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[paramInt]);
      break label67;
      label172:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    String str1 = getString(2131437485);
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.jdField_h_of_type_AndroidWidgetTextView;
    TextView localTextView;
    String str2;
    if (paramInt1 == 0)
    {
      a((TextView)localObject, str1, bool);
      localObject = this.jdField_g_of_type_AndroidViewView;
      localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
      str2 = getString(2131437484);
      if (paramInt1 == 0) {
        break label149;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      bool = false;
      break;
      label149:
      str1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_a_of_type_JavaLangString = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_a_of_type_Int = paramList.size();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131437483);
    if (paramInt == 0)
    {
      str = getString(2131433924);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_g_of_type_AndroidWidgetTextView, str, 2131494213);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_f_of_type_AndroidViewView, this.jdField_g_of_type_AndroidWidgetTextView, getString(2131437482), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131433925);
      break;
      label88:
      TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
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
  
  public void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    paramView1 = str;
    if ((paramView2 instanceof EditText)) {
      paramView1 = paramString1 + ",编辑框," + paramString2 + ",";
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
    for (int i1 = 2131494262;; i1 = 2131494207)
    {
      a(paramTextView, paramCharSequence, i1);
      return;
    }
  }
  
  public void a(Card paramCard)
  {
    if (((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) && (paramCard != null) && (paramCard.nCampusStatus == 4))
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post(new spz(this, paramCard), 5, null, true);
      }
    }
    else {
      return;
    }
    b(paramCard);
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if ((paramCard == null) || ((!paramBoolean) && (this.jdField_n_of_type_Boolean))) {
      return;
    }
    this.jdField_n_of_type_Boolean = true;
    String str1;
    String str3;
    String str2;
    if (TextUtils.isEmpty(paramCard.strCampusSchool))
    {
      str1 = paramCard.strSchool;
      if (paramCard.nCampusStatus != 4) {
        break label196;
      }
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
      this.jdField_l_of_type_AndroidViewView.setVisibility(0);
      if (CampusCircleHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.lCampusSchoolID) != 4) {
        break label154;
      }
      this.jdField_k_of_type_AndroidWidgetTextView.setText("院系");
      this.jdField_m_of_type_AndroidWidgetTextView.setText("入学年份");
      str3 = paramCard.strCampusCollege;
      str2 = String.valueOf(paramCard.nCampusEnrolYear);
      label109:
      if (!this.jdField_k_of_type_Boolean) {
        d(str3);
      }
      if (!this.jdField_l_of_type_Boolean) {
        e(str2);
      }
      a(paramCard);
    }
    for (;;)
    {
      c(str1);
      return;
      str1 = paramCard.strCampusSchool;
      break;
      label154:
      this.jdField_k_of_type_AndroidWidgetTextView.setText("年级");
      this.jdField_m_of_type_AndroidWidgetTextView.setText("班级");
      str3 = CampusCircleHelper.a(paramCard.lCampusSchoolID, paramCard.nCampusEnrolYear);
      str2 = paramCard.strCampusClass;
      break label109;
      label196:
      this.jdField_k_of_type_Boolean = false;
      this.jdField_l_of_type_Boolean = false;
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      this.jdField_l_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool = false;
    if (paramRichStatus != null) {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
    }
    for (this.jdField_c_of_type_JavaLangString = paramRichStatus;; this.jdField_c_of_type_JavaLangString = "")
    {
      a(this.jdField_f_of_type_AndroidWidgetTextView, paramRichStatus, bool);
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_f_of_type_AndroidWidgetTextView, getString(2131433469), paramRichStatus);
      return;
      paramRichStatus = "编辑个性签名";
      bool = true;
    }
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131437481);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131437480), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.post(new sqb(this, paramString, paramInt), 5, null, false);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "report [T: %s,  fromType: %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return;
      ReportController.b(this.app, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
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
      paramString1 = getString(2131430578);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_d_of_type_AndroidWidgetTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", "未设置");
    }
    for (;;)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      localIntent.putExtra("default_text", "");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (!isFinishing()) {
        finish();
      }
    }
  }
  
  /* Error */
  @TargetApi(11)
  public void b(Card paramCard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 1393	com/tencent/mobileqq/data/Card:strCampusSchool	Ljava/lang/String;
    //   6: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +148 -> 157
    //   12: aload_1
    //   13: getfield 1396	com/tencent/mobileqq/data/Card:strSchool	Ljava/lang/String;
    //   16: astore_2
    //   17: aload_1
    //   18: getfield 1082	com/tencent/mobileqq/data/Card:lCampusSchoolID	J
    //   21: aload_2
    //   22: invokestatic 1753	com/tencent/mobileqq/campuscircle/CampusCircleHelper:a	(JLjava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 163	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   30: ifnonnull +135 -> 165
    //   33: aload_0
    //   34: new 139	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 140	java/util/ArrayList:<init>	()V
    //   41: putfield 163	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   44: aload_0
    //   45: getfield 544	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   48: invokevirtual 1757	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   51: aload_3
    //   52: aconst_null
    //   53: invokeinterface 1763 3 0
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +21 -> 81
    //   63: aload_3
    //   64: invokeinterface 1766 1 0
    //   69: ifle +12 -> 81
    //   72: aload_0
    //   73: getfield 163	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_3
    //   77: invokevirtual 374	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   80: pop
    //   81: aload_0
    //   82: getfield 544	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: bipush 108
    //   87: invokevirtual 549	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   90: checkcast 551	com/tencent/mobileqq/campuscircle/CampusCircleHandler
    //   93: aload_1
    //   94: getfield 1082	com/tencent/mobileqq/data/Card:lCampusSchoolID	J
    //   97: aload_2
    //   98: invokevirtual 1769	com/tencent/mobileqq/campuscircle/CampusCircleHandler:a	(JLjava/lang/String;)V
    //   101: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +50 -> 154
    //   107: ldc_w 401
    //   110: iconst_2
    //   111: invokestatic 616	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   114: ldc_w 1771
    //   117: iconst_3
    //   118: anewarray 405	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: getfield 163	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   127: invokevirtual 375	java/util/ArrayList:size	()I
    //   130: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_1
    //   137: getfield 1082	com/tencent/mobileqq/data/Card:lCampusSchoolID	J
    //   140: invokestatic 1776	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload_2
    //   147: aastore
    //   148: invokestatic 626	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokestatic 628	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: monitorexit
    //   156: return
    //   157: aload_1
    //   158: getfield 1393	com/tencent/mobileqq/data/Card:strCampusSchool	Ljava/lang/String;
    //   161: astore_2
    //   162: goto -145 -> 17
    //   165: aload_0
    //   166: getfield 163	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   169: invokevirtual 373	java/util/ArrayList:clear	()V
    //   172: goto -128 -> 44
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	FriendProfileMoreInfoActivity
    //   0	180	1	paramCard	Card
    //   16	146	2	str	String
    //   25	52	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	175	finally
    //   17	44	175	finally
    //   44	59	175	finally
    //   63	81	175	finally
    //   81	154	175	finally
    //   157	162	175	finally
    //   165	172	175	finally
  }
  
  void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131437493);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131437492), str);
  }
  
  void c(String paramString)
  {
    int i2;
    int i1;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = getString(2131437495);
      i2 = 1;
      i1 = 0;
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      Object localObject2 = getResources();
      int i3;
      label40:
      String str;
      if (i2 != 0)
      {
        i3 = 2131494262;
        ((SingleLineTextView)localObject1).setTextColor(((Resources)localObject2).getColor(i3));
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131559408));
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i1);
        localObject1 = this.jdField_j_of_type_AndroidViewView;
        localObject2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
        str = getString(2131437494);
        if (i2 == 0) {
          break label225;
        }
      }
      label225:
      for (paramString = "";; paramString = paramString.toString())
      {
        a((View)localObject1, (View)localObject2, str, paramString);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          i1 = 0;
          i2 = 0;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus == 4)
        {
          i1 = CampusCircleConstant.jdField_a_of_type_ArrayOfInt[0];
          i2 = 0;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus == 2)
        {
          i1 = CampusCircleConstant.jdField_a_of_type_ArrayOfInt[1];
          i2 = 0;
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusSchoolFlag != 1)) {
          break label235;
        }
        i1 = CampusCircleConstant.jdField_a_of_type_ArrayOfInt[2];
        i2 = 0;
        break;
        i3 = 2131494207;
        break label40;
      }
      label235:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public void d(String paramString)
  {
    boolean bool = false;
    String str1 = paramString;
    if (paramString == null)
    {
      bool = true;
      str1 = "";
    }
    a(this.jdField_l_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_k_of_type_AndroidViewView;
    TextView localTextView = this.jdField_l_of_type_AndroidWidgetTextView;
    String str2 = this.jdField_k_of_type_AndroidWidgetTextView.getText().toString();
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Bundle localBundle = null;
    Object localObject = null;
    long l1;
    if (paramInt1 == 1009) {
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("campus_school");
        l1 = paramIntent.getLongExtra("campus_school_id", 0L);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataCard.strSchool)))
        {
          paramIntent = (CampusCircleHandler)this.app.a(108);
          if (NetworkUtil.d(this)) {
            break label95;
          }
          a(2131437508, 1);
        }
      }
    }
    for (;;)
    {
      return;
      label95:
      this.jdField_i_of_type_Boolean = true;
      localBundle = new Bundle();
      localBundle.putString("campus_school", (String)localObject);
      localBundle.putLong("campus_school_id", l1);
      paramIntent.a(localBundle);
      return;
      if (paramInt1 == 1001)
      {
        paramIntent = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001);
        paramIntent.obj = null;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramIntent);
        return;
      }
      if (paramInt1 == 1002)
      {
        if (paramInt2 == 1001) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.h();
        return;
      }
      if (paramInt1 == 1003)
      {
        if (paramIntent == null) {
          continue;
        }
        int i1 = paramIntent.getShortExtra("param_year", (short)1990);
        int i2 = paramIntent.getByteExtra("param_month", (byte)1);
        int i3 = paramIntent.getByteExtra("param_day", (byte)1);
        paramInt1 = paramIntent.getIntExtra("param_age", 0);
        paramInt2 = paramIntent.getIntExtra("param_constellation_id", 0);
        i1 = i1 << 16 | i2 << 8 | i3;
        if (i1 == this.jdField_c_of_type_Int) {
          continue;
        }
        this.jdField_d_of_type_Boolean = true;
        a(i1, paramInt1, paramInt2);
        return;
      }
      if (paramInt1 == 1004)
      {
        if (paramIntent == null) {
          continue;
        }
        paramInt1 = paramIntent.getIntExtra("param_id", -1);
        if (paramInt1 == this.jdField_f_of_type_Int) {
          continue;
        }
        this.jdField_e_of_type_Boolean = true;
        a(paramInt1);
        return;
      }
      if (paramInt1 == 1005)
      {
        if (paramIntent == null) {
          continue;
        }
        paramIntent = paramIntent.getStringArrayExtra("param_location");
        if (a(this.jdField_a_of_type_ArrayOfJavaLangString, paramIntent)) {
          continue;
        }
        this.jdField_f_of_type_Boolean = true;
        this.jdField_a_of_type_ArrayOfJavaLangString = paramIntent;
      }
      try
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
        if (!TextUtils.isEmpty(paramIntent))
        {
          localObject = paramIntent;
          if (!paramIntent.equals("不限")) {}
        }
        else
        {
          localObject = "";
        }
        f((String)localObject);
        return;
        if (paramInt1 == 1006)
        {
          if (paramIntent == null) {
            continue;
          }
          paramIntent = paramIntent.getStringArrayExtra("param_location");
          if (a(this.jdField_b_of_type_ArrayOfJavaLangString, paramIntent)) {
            continue;
          }
          this.jdField_g_of_type_Boolean = true;
          this.jdField_b_of_type_ArrayOfJavaLangString = paramIntent;
        }
        try
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            localObject = paramIntent;
            if (!paramIntent.equals("不限")) {}
          }
          else
          {
            localObject = "";
          }
          g((String)localObject);
          return;
          if (paramInt1 == 1007)
          {
            if (paramIntent == null) {
              continue;
            }
            paramIntent = paramIntent.getStringExtra("result");
            if (paramIntent.equals(this.jdField_d_of_type_JavaLangString)) {
              continue;
            }
            this.jdField_h_of_type_Boolean = true;
            i(paramIntent);
            return;
          }
          if (paramInt1 == 1008)
          {
            if (paramIntent == null) {
              continue;
            }
            a(paramInt2, paramIntent);
            return;
          }
          if (paramInt1 == 1010)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(this.app.getCurrentAccountUin(), 5);
            return;
          }
          if (paramInt1 != 1011) {
            continue;
          }
          a();
          return;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent = localBundle;
          }
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent = (Intent)localObject;
        }
      }
    }
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970499);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    paramBundle = getIntent();
    int i1 = paramBundle.getIntExtra("profile_entry_type", 0);
    this.jdField_m_of_type_Boolean = ProfileActivity.AllInOne.a(i1);
    if (QLog.isDevelopLevel()) {
      QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "doOnCreate [%b, %d]", new Object[] { Boolean.valueOf(this.jdField_m_of_type_Boolean), Integer.valueOf(i1) }));
    }
    this.jdField_p_of_type_Boolean = paramBundle.getBooleanExtra("isTroopMemberCard", false);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("memberUin");
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver, true);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = (LinearLayout)super.findViewById(2131370909);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    c();
    paramBundle = getResources().getDisplayMetrics();
    i1 = Math.max(paramBundle.widthPixels, paramBundle.heightPixels);
    if (i1 <= 240) {
      this.jdField_w_of_type_Int = 60;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
      ThreadManager.post(new sql(this), 5, null, true);
      return true;
      if (i1 <= 320) {
        this.jdField_w_of_type_Int = 100;
      } else {
        this.jdField_w_of_type_Int = 160;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_a_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (!this.jdField_b_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
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
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e(String paramString)
  {
    boolean bool = false;
    String str1 = paramString;
    if (paramString == null)
    {
      bool = true;
      str1 = "";
    }
    a(this.jdField_n_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_l_of_type_AndroidViewView;
    TextView localTextView = this.jdField_n_of_type_AndroidWidgetTextView;
    String str2 = this.jdField_m_of_type_AndroidWidgetTextView.getText().toString();
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  void f(String paramString)
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
      str1 = getString(2131437497);
      bool = true;
    }
    a(this.jdField_o_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_m_of_type_AndroidViewView;
    TextView localTextView = this.jdField_o_of_type_AndroidWidgetTextView;
    String str2 = getString(2131437496);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (a())
    {
      localIntent.putExtra("param_joined_group_switch", this.jdField_l_of_type_Int);
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void g(String paramString)
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
      str1 = getString(2131437499);
      bool = true;
    }
    a(this.jdField_p_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_n_of_type_AndroidViewView;
    TextView localTextView = this.jdField_p_of_type_AndroidWidgetTextView;
    String str2 = getString(2131437498);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  void h(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131437501);
    a(this.jdField_o_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131437500), str);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
              return true;
            } while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2));
            k();
            QQToast.a(this, 2131437281, 0).b(getTitleBarHeight());
            return true;
            a(paramMessage);
            a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_b_of_type_Int);
            this.jdField_v_of_type_Int = 0;
            try
            {
              long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
              this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$NowOnliveGallayCallback);
              return true;
            }
            catch (Exception paramMessage) {}
          } while (!QLog.isColorLevel());
          QLog.e("FriendProfileMoreInfoActivity", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FROM_DATABASE fail!", paramMessage);
          return true;
          this.jdField_v_of_type_Int |= 0x1;
          a(paramMessage);
        } while (this.jdField_v_of_type_Int != 17);
        a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_b_of_type_Int);
        return true;
        this.jdField_v_of_type_Int |= 0x10;
        a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList);
      } while (this.jdField_v_of_type_Int != 17);
      a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$QZonePhotoCache.jdField_b_of_type_Int);
      return true;
    } while ((isFinishing()) || (!isResume()) || (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusStatus != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.nCampusSchoolFlag != 1) || ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCampusSchool)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strSchool))));
    paramMessage = new sqj(this);
    sqk localsqk = new sqk(this);
    DialogUtil.a(this, getString(2131438910), 2131438912, 2131438911, localsqk, paramMessage).show();
    return true;
  }
  
  void i(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    int i1;
    if (TextUtils.isEmpty(paramString)) {
      i1 = 1;
    }
    for (String str1 = getString(2131437506);; str1 = paramString)
    {
      a(this.jdField_q_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.jdField_p_of_type_AndroidViewView;
      TextView localTextView = this.jdField_q_of_type_AndroidWidgetTextView;
      String str2 = getString(2131437502);
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
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
    }
    b();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    if (paramBoolean)
    {
      i1 = 0;
      if (this.jdField_g_of_type_Int != i1) {
        this.jdField_j_of_type_Boolean = true;
      }
      paramCompoundButton = this.app;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i1 = i2;; i1 = 2)
    {
      ReportController.b(paramCompoundButton, "dc00898", "", "", "0X8008407", "0X8008407", i1, 0, "", "", "", "");
      return;
      i1 = 1;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
    }
    switch (paramView.getId())
    {
    default: 
    case 2131363227: 
    case 2131370911: 
    case 2131370913: 
    case 2131370915: 
    case 2131370925: 
    case 2131370917: 
      do
      {
        do
        {
          return;
          b();
          return;
          paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
          paramView.putExtra("hide_more_button", true);
          paramView.putExtra("hide_operation_bar", true);
          paramView.putExtra("url", "http://ti.qq.com/photowall/index.html?_wv=1027");
          paramView.putExtra("leftViewText", getString(2131432397));
          startActivityForResult(paramView, 1001);
          ReportController.b(this.app, "dc00898", "", "", "0X8007EC4", "0X8007EC4", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this, AvatarPendantActivity.class);
          paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          paramView.putExtra("showActionSheet", true);
          startActivity(paramView);
          ReportController.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
          return;
          d();
          ReportController.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
          return;
          e();
          return;
          paramView = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
        } while (paramView == null);
        if ((paramView.isTroopAdmin(this.app.getCurrentAccountUin())) || (paramView.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
        {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1011);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
      return;
    case 2131370927: 
      paramView = new Intent(this, AgeSelectionActivity.class);
      paramView.putExtra("param_birthday", this.jdField_c_of_type_Int);
      startActivityForResult(paramView, 1003);
      return;
    case 2131370929: 
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_f_of_type_Int);
      startActivityForResult(paramView, 1004);
      return;
    case 2131364300: 
      c(1);
      return;
    case 2131370943: 
      c(2);
      return;
    case 2131370947: 
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131437502).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131437506).putExtra("multiLine", true).putExtra("current", this.jdField_d_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult(paramView, 1007);
      return;
    case 2131370949: 
      ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      ReportController.b(this.app, "dc00898", "", "", "0X8007ED2", "0X8007ED2", 0, 0, "", "", "", "");
      return;
    case 2131370951: 
      i();
      ReportController.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
      return;
    case 2131370934: 
      f();
      return;
    case 2131370936: 
      g();
      return;
    }
    h();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != this.jdField_a_of_type_AndroidWidgetEditText) {
        break label67;
      }
      if (this.jdField_a_of_type_Sqo.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label67:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, "昵称不可以为空", 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_c_of_type_AndroidWidgetEditText) || (!this.jdField_c_of_type_Sqo.jdField_b_of_type_Boolean));
      paramView = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, "邮箱格式不正确", 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */