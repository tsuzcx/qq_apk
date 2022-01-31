package com.tencent.mobileqq.activity.chathistory;

import aepi;
import aghu;
import aghw;
import ahdy;
import ahdz;
import ahea;
import aihj;
import aihk;
import alud;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.WrapperListAdapter;
import aryv;
import avvi;
import azqs;
import bayu;
import bdft;
import bdgg;
import bdpi;
import bety;
import bhsl;
import bhtu;
import bhuw;
import bhux;
import biqe;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;
import xsm;

public class ChatHistoryForTroopFragment
  extends PublicBaseFragment
  implements aghw, Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, View.OnTouchListener, TextView.OnEditorActionListener, bhtu, bhuw, bhux
{
  int jdField_a_of_type_Int = 0;
  ahea jdField_a_of_type_Ahea;
  aihj jdField_a_of_type_Aihj;
  aihk jdField_a_of_type_Aihk;
  View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bety jdField_a_of_type_Bety;
  public AIORichMediaData a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString;
  View c;
  View d;
  
  private String a(String paramString)
  {
    return "https://qun.qq.com/qqweb/m/qunurl/index.html?_bid=2010&groupUin=$GCODE$&_wv=3".replace("$GCODE$", paramString);
  }
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (paramFragmentActivity != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", this.jdField_b_of_type_JavaLangString);
      Object localObject = ((ActivityManager)paramFragmentActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", localRunningAppProcessInfo.pid);
        }
      }
      localBundle.putInt("forward_source_uin_type", 1);
      localBundle.putBoolean("extra.NO_FIRST_ENTER_ANIMATION", true);
      localBundle.putBoolean("extra.RIGHT_EXIT_TRANSITION", true);
      localBundle.putBoolean("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", true);
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_CODE", this.jdField_b_of_type_JavaLangString);
      localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      localBundle.putString("uin", this.jdField_b_of_type_JavaLangString);
      localObject = paramFragmentActivity.getCurrentAccountUin();
      if (localObject != null)
      {
        localBundle.putBoolean("extra.OCR", avvi.a((String)localObject, 7));
        biqe.b(paramFragmentActivity, localBundle, new AIOImageProviderService((String)localObject, this.jdField_b_of_type_JavaLangString, 1, null), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, -1, 3);
      }
    }
    do
    {
      return;
      paramFragmentActivity = getActivity();
    } while (paramFragmentActivity == null);
    TroopAIOImageEmptyFragment.a(paramFragmentActivity, alud.a(2131702054), "http://hb.url.cn/myapp/qq_desk/chatfileEmptyImage.png", alud.a(2131701994));
  }
  
  private void d()
  {
    TroopAIOImageGeter localTroopAIOImageGeter = new TroopAIOImageGeter(getActivity().getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString, 1, null);
    localTroopAIOImageGeter.a(new ahdz(this));
    localTroopAIOImageGeter.a(0);
  }
  
  protected void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376640);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131365735);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376283));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this);
    int i = xsm.a(localFragmentActivity, 10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166983));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131367817);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363522).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367921).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131365704).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366297).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369500).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364994).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370134).setOnClickListener(this);
  }
  
  protected void a(int paramInt)
  {
    int i = 8;
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (paramInt != 1) {
        break label97;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(null);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollToButtomListener(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      label97:
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aihk);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.c);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollToButtomListener(this);
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (this.jdField_a_of_type_Aihk.a()) {}
        for (;;)
        {
          ((TextView)localObject).setVisibility(i);
          this.jdField_a_of_type_Aihk.notifyDataSetChanged();
          ((TextView)this.c.findViewById(2131377620)).setText(alud.a(2131702002));
          localObject = this.jdField_a_of_type_AndroidViewView.getContext().getResources();
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = aepi.a(320.0F, (Resources)localObject);
          localURLDrawableOptions.mRequestHeight = aepi.a(177.5F, (Resources)localObject);
          localURLDrawableOptions.mLoadingDrawable = bayu.a;
          localURLDrawableOptions.mFailedDrawable = bayu.a;
          localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/54e96094adaf456f9b8f622f191f8fde.png", localURLDrawableOptions);
          ((ImageView)this.c.findViewById(2131377824)).setImageDrawable((Drawable)localObject);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          break;
          i = 0;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f == paramLong)) {
      d();
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_b_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      QLog.e("chatHistory.troop.portal", 1, "troop uin id required");
      b();
      return;
    }
    paramBundle = getActivity();
    if (paramBundle == null) {}
    for (paramBundle = null; (paramBundle instanceof QQAppInterface); paramBundle = paramBundle.getAppInterface())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      d();
      aghu.a().a(this);
      return;
    }
    QLog.e("chatHistory.troop.portal", 1, "app is null");
    b();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "searchMessage, currentKeyword = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_Aihk == null)
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localSessionInfo.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Aihk = new aihk(this.jdField_a_of_type_AndroidViewView.getContext(), new bhsl(Looper.getMainLooper(), this), localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Aihk.a())) {
      this.jdField_a_of_type_Aihk.a(System.currentTimeMillis(), paramString, 1);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "search_result", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      a(2);
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "onLongClick, position = " + paramInt);
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      return false;
    }
    this.jdField_a_of_type_Aihj = ((aihj)paramAdapterView.getAdapter().getItem(paramInt));
    paramView.setSelected(true);
    paramAdapterView = new bdpi();
    paramAdapterView.a(2131364912, alud.a(2131701980), 2130838669);
    paramAdapterView.a(2131366760, this.jdField_a_of_type_AndroidViewView.getContext().getString(2131692837), 2130838678);
    bdft.a(paramView, paramAdapterView, this, new ahdy(this, paramView));
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      a(0);
      this.d.setVisibility(8);
      return;
    }
    a(1);
    this.d.setVisibility(0);
    a(paramEditable.toString());
  }
  
  protected void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = aepi.a(new Intent((Context)localObject, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramBundle));
    startActivity((Intent)localObject);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    c();
    TextView localTextView;
    if ((paramMessage.obj instanceof List))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131702032));
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Aihk.a()) {
        break label109;
      }
    }
    label109:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      this.jdField_a_of_type_Aihk.a((List)paramMessage.obj, paramMessage.arg1);
      this.jdField_a_of_type_Aihk.notifyDataSetChanged();
      a(2);
      break;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(20);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (-1 != paramInt2);
    b(paramIntent.getExtras());
  }
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {}
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131363522: 
          b();
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_cancel", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131367817: 
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          ((InputMethodManager)this.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
          return;
        case 2131367921: 
          a(localFragmentActivity);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_pic", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131365704: 
          paramView = new Intent();
          paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_b_of_type_Int);
          paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
          PublicFragmentActivity.a(localFragmentActivity, paramView, TroopAIOEmotionFragment.class);
          return;
        case 2131366297: 
          paramView = localFragmentActivity.getCurrentAccountUin();
          bdgg.a(paramView, "troop_file_new", this.jdField_b_of_type_JavaLangString, 0);
          localObject = new Intent();
          ((Intent)localObject).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          ((Intent)localObject).putExtra("param_from", 5000);
          TroopFileProxyActivity.a(localFragmentActivity, (Intent)localObject, -1, paramView);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_file", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131369500: 
          paramView = new Intent(localFragmentActivity, QQBrowserActivity.class);
          paramView.putExtra("url", a(this.jdField_b_of_type_JavaLangString));
          paramView.putExtra("webStyle", "noBottomBar");
          paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
          startActivity(paramView);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_link", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131364994: 
          paramView = new Intent();
          paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
          PublicFragmentActivity.a(localFragmentActivity, paramView, ChatHistoryByDateFragment.class);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_date", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131370134: 
          paramView = TroopMemberListActivity.a(localFragmentActivity, this.jdField_b_of_type_JavaLangString, 18);
          paramView.putExtra("uin", this.jdField_b_of_type_JavaLangString);
          paramView.putExtra("uintype", 1);
          startActivity(paramView);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_mber", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          return;
        case 2131364912: 
          paramView = this.jdField_a_of_type_Aihj;
        }
      } while (paramView == null);
      ((ClipboardManager)localFragmentActivity.getSystemService("clipboard")).setText(paramView.a.msg);
      return;
      localObject = this.jdField_a_of_type_Aihj;
    } while (localObject == null);
    paramView = new Bundle();
    paramView.putInt("forward_type", -1);
    paramView.putString("forward_text", ((aihj)localObject).a.msg);
    Object localObject = new Intent();
    ((Intent)localObject).putExtras(paramView);
    aryv.a(localFragmentActivity, (Intent)localObject, 21);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560419, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    a(getArguments());
    a();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    c();
    aghu.a().b(this);
    super.onDestroyView();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      paramTextView = paramTextView.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {}
    }
    else
    {
      return false;
    }
    a(paramTextView);
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)localFragmentActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
        localInputMethodManager.hideSoftInputFromWindow(localFragmentActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "onItemClick, position = " + paramInt);
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      paramAdapterView = this.jdField_a_of_type_Aihk.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131702056));
      this.jdField_a_of_type_Aihk.a(System.currentTimeMillis(), paramAdapterView, 2);
    }
    do
    {
      do
      {
        return;
        for (paramAdapterView = this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter(); (paramAdapterView instanceof WrapperListAdapter); paramAdapterView = ((WrapperListAdapter)paramAdapterView).getWrappedAdapter()) {}
        if (paramAdapterView != this.jdField_a_of_type_Aihk) {
          break;
        }
        paramView = getActivity();
      } while (paramView == null);
      paramAdapterView = ((aihj)paramAdapterView.getItem(paramInt)).a;
      ChatHistoryBubbleListForTroopFragment.a(paramView, this.jdField_b_of_type_JavaLangString, paramAdapterView, 100, 2);
      if (QLog.isColorLevel()) {
        QLog.i("chatHistory.troop.portal", 2, "onItemClick, message = " + paramAdapterView);
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_clk", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      if (paramAdapterView == this.jdField_a_of_type_Ahea)
      {
        paramAdapterView = (String)paramAdapterView.getItem(paramInt);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramAdapterView);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramAdapterView.length());
        a(paramAdapterView);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("chatHistory.troop.portal", 2, "onItemClick, unknown data type");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84)))
    {
      paramView = ((TextView)paramView).getText().toString().trim();
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return false;
    }
    a(paramView);
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      if (paramView != this.jdField_a_of_type_ComTencentWidgetXListView) {
        break label49;
      }
      ((InputMethodManager)this.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    label49:
    while (paramView != this.jdField_a_of_type_AndroidWidgetEditText) {
      return false;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "home", "Clk_search", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    return false;
  }
  
  public void y(int paramInt)
  {
    if (paramInt < 0)
    {
      String str = this.jdField_a_of_type_Aihk.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131702000));
      this.jdField_a_of_type_Aihk.a(System.currentTimeMillis(), str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment
 * JD-Core Version:    0.7.0.1
 */