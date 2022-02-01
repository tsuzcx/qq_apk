package com.tencent.mobileqq.activity.chathistory;

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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakUtils;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryForTroopFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, View.OnTouchListener, TextView.OnEditorActionListener, MsgRevokeListener, AbsListView.OnScrollButtomListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  int a = 0;
  SearchHistoryAdapter b;
  MessageResultAdapter c;
  MessageItem d;
  View e;
  View f;
  View g;
  XListView h;
  EditText i;
  View j;
  TextView k;
  int l;
  String m;
  String n;
  QQAppInterface o;
  AIORichMediaData p;
  QQProgressDialog q;
  
  private void a(BaseActivity paramBaseActivity)
  {
    if ((this.p != null) && (paramBaseActivity != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", this.n);
      Object localObject = ((ActivityManager)paramBaseActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
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
      localBundle.putString("extra.GROUP_CODE", this.n);
      localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      localBundle.putString("uin", this.n);
      localObject = paramBaseActivity.getCurrentAccountUin();
      if (localObject != null)
      {
        localBundle.putBoolean("extra.OCR", ((IOCRService)this.o.getRuntimeService(IOCRService.class, "")).isSupportOcr((String)localObject, 7));
        PeakUtils.b(paramBaseActivity, localBundle, new AIOImageProviderService((String)localObject, this.n, 1, null), this.p, -1, 3);
      }
    }
    else
    {
      paramBaseActivity = getBaseActivity();
      if (paramBaseActivity == null) {
        return;
      }
      TroopAIOImageEmptyFragment.a(paramBaseActivity, HardCodeUtil.a(2131899898), "https://hb.url.cn/myapp/qq_desk/chatfileEmptyImage.png", HardCodeUtil.a(2131899840));
    }
  }
  
  private String b(String paramString)
  {
    return "https://qun.qq.com/qqweb/m/qunurl/index.html?_bid=2010&groupUin=$GCODE$&_wv=3".replace("$GCODE$", paramString);
  }
  
  private void d()
  {
    TroopAIOImageGeter localTroopAIOImageGeter = new TroopAIOImageGeter(getBaseActivity().getCurrentAccountUin(), this.n, 1, null);
    localTroopAIOImageGeter.a(new ChatHistoryForTroopFragment.2(this));
    localTroopAIOImageGeter.a(0);
  }
  
  protected void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    this.f = this.e.findViewById(2131445863);
    this.g = this.e.findViewById(2131432501);
    this.h = ((XListView)this.e.findViewById(2131445451));
    this.h.setOnTouchListener(this);
    int i1 = UIUtils.a(localBaseActivity, 10.0F);
    this.k = new TextView(localBaseActivity);
    this.k.setTextSize(16.0F);
    this.k.setTextColor(getResources().getColorStateList(2131168125));
    this.k.setGravity(1);
    this.k.setPadding(0, i1, 0, i1);
    this.k.setVisibility(8);
    this.h.addFooterView(this.k);
    this.j = this.e.findViewById(2131435215);
    this.j.setOnClickListener(this);
    this.i = ((EditText)this.e.findViewById(2131432634));
    this.i.addTextChangedListener(this);
    this.i.setOnEditorActionListener(this);
    this.i.setOnKeyListener(this);
    this.i.setOnTouchListener(this);
    this.e.findViewById(2131429816).setOnClickListener(this);
    this.e.findViewById(2131435357).setOnClickListener(this);
    this.e.findViewById(2131432464).setOnClickListener(this);
    this.e.findViewById(2131433099).setOnClickListener(this);
    this.e.findViewById(2131437250).setOnClickListener(this);
    this.e.findViewById(2131431602).setOnClickListener(this);
    this.e.findViewById(2131438036).setOnClickListener(this);
  }
  
  protected void a(int paramInt)
  {
    if (this.a != paramInt)
    {
      int i1 = 0;
      if (paramInt == 1)
      {
        this.h.setAdapter(null);
        this.h.setOnItemClickListener(null);
        this.h.setOnItemLongClickListener(null);
        this.h.setVisibility(0);
        this.h.setEmptyView(null);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.h.setOnScrollToButtomListener(null);
        this.k.setVisibility(8);
      }
      else if (paramInt == 2)
      {
        this.h.setAdapter(this.c);
        this.h.setOnItemClickListener(this);
        this.h.setOnItemLongClickListener(this);
        this.h.setVisibility(0);
        this.h.setEmptyView(this.g);
        this.f.setVisibility(8);
        this.h.setOnScrollToButtomListener(this);
        Object localObject = this.k;
        if (this.c.c()) {
          i1 = 8;
        }
        ((TextView)localObject).setVisibility(i1);
        this.c.notifyDataSetChanged();
        ((TextView)this.g.findViewById(2131447089)).setText(HardCodeUtil.a(2131899847));
        localObject = this.e.getContext().getResources();
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = AIOUtils.b(320.0F, (Resources)localObject);
        localURLDrawableOptions.mRequestHeight = AIOUtils.b(177.5F, (Resources)localObject);
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
        localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/54e96094adaf456f9b8f622f191f8fde.png", localURLDrawableOptions);
        ((ImageView)this.g.findViewById(2131447324)).setImageDrawable((Drawable)localObject);
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_exp", 0, 0, this.n, "", "", "");
      }
      else
      {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(0);
      }
      this.a = paramInt;
    }
  }
  
  public void a(long paramLong)
  {
    AIORichMediaData localAIORichMediaData = this.p;
    if ((localAIORichMediaData != null) && (localAIORichMediaData.L == paramLong)) {
      d();
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    this.m = paramBundle.getString("uin");
    this.l = paramBundle.getInt("uintype");
    this.n = paramBundle.getString("troop_uin");
    if (this.n == null)
    {
      QLog.e("chatHistory.troop.portal", 1, "troop uin id required");
      b();
      return;
    }
    paramBundle = getBaseActivity();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = paramBundle.getAppInterface();
    }
    if ((paramBundle instanceof QQAppInterface))
    {
      this.o = ((QQAppInterface)paramBundle);
      d();
      AIOGalleryMsgRevokeMgr.a().a(this);
      return;
    }
    QLog.e("chatHistory.troop.portal", 1, "app is null");
    b();
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, currentKeyword = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("chatHistory.troop.portal", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.c == null)
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).b = this.n;
      ((SessionInfo)localObject).a = 1;
      this.c = new MessageResultAdapter(this.e.getContext(), new MqqWeakReferenceHandler(Looper.getMainLooper(), this), (SessionInfo)localObject, this.o);
    }
    if (!paramString.equalsIgnoreCase(this.c.b())) {
      this.c.a(System.currentTimeMillis(), paramString, 1);
    } else {
      a(2);
    }
    ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "search_result", 0, 0, this.n, "", "", "");
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() != 0))
    {
      a(1);
      this.j.setVisibility(0);
      a(paramEditable.toString());
      return;
    }
    a(0);
    this.j.setVisibility(8);
  }
  
  protected void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    Object localObject = getBaseActivity();
    if (localObject == null) {
      return;
    }
    localObject = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramBundle));
    startActivity((Intent)localObject);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.q;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.q.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      c();
      if ((paramMessage.obj instanceof List))
      {
        this.k.setText(HardCodeUtil.a(2131899877));
        TextView localTextView = this.k;
        int i1;
        if (this.c.c()) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        localTextView.setVisibility(i1);
        this.c.a((List)paramMessage.obj, paramMessage.arg1);
        this.c.notifyDataSetChanged();
      }
      a(2);
    }
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(20);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 21) {
      return;
    }
    if (-1 == paramInt2) {
      b(paramIntent.getExtras());
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = getBaseActivity();
    if (localObject1 != null)
    {
      Object localObject3;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131438036: 
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("troop_uin", this.n);
        ((Intent)localObject1).putExtra("param_from", 18);
        ((Intent)localObject1).putExtra("uin", this.n);
        ((Intent)localObject1).putExtra("uintype", 1);
        RouteUtils.a(getActivity(), (Intent)localObject1, "/troop/memberlist/TroopMemberList");
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_mber", 0, 0, this.n, "", "", "");
        break;
      case 2131437250: 
        localObject1 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", b(this.n));
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject1);
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_link", 0, 0, this.n, "", "", "");
        break;
      case 2131435357: 
        a((BaseActivity)localObject1);
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_pic", 0, 0, this.n, "", "", "");
        break;
      case 2131435215: 
        this.i.setText("");
        ((InputMethodManager)this.i.getContext().getSystemService("input_method")).showSoftInput(this.i, 0);
        break;
      case 2131433636: 
        localObject3 = this.d;
        if (localObject3 != null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("forward_type", -1);
          ((Bundle)localObject2).putString("forward_text", ((MessageItem)localObject3).b.msg);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtras((Bundle)localObject2);
          ForwardBaseOption.a((Activity)localObject1, (Intent)localObject3, 21);
        }
        break;
      case 2131433099: 
        localObject2 = ((BaseActivity)localObject1).getCurrentAccountUin();
        ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo((String)localObject2, "troop_file_new", this.n, 0);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra(TroopFileProxyActivity.b, this.n);
        ((Intent)localObject3).putExtra("param_from", 5000);
        TroopFileProxyActivity.a((Activity)localObject1, (Intent)localObject3, -1, (String)localObject2);
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_file", 0, 0, this.n, "", "", "");
        break;
      case 2131432464: 
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin", this.m);
        ((Intent)localObject2).putExtra("uintype", this.l);
        ((Intent)localObject2).putExtra("troop_uin", this.n);
        PublicFragmentActivity.a((Context)localObject1, (Intent)localObject2, TroopAIOEmotionFragment.class);
        break;
      case 2131431602: 
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("troop_uin", this.n);
        PublicFragmentActivity.a((Context)localObject1, (Intent)localObject2, ChatHistoryByDateFragment.class);
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_date", 0, 0, this.n, "", "", "");
        break;
      case 2131431492: 
        localObject2 = this.d;
        if (localObject2 != null) {
          ((ClipboardManager)((BaseActivity)localObject1).getSystemService("clipboard")).setText(((MessageItem)localObject2).b.msg);
        }
        break;
      case 2131429816: 
        b();
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_cancel", 0, 0, this.n, "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = paramLayoutInflater.inflate(2131626674, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.e.setFitsSystemWindows(true);
      this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    a(getArguments());
    a();
    ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "exp", 0, 0, this.n, "", "", "");
    paramLayoutInflater = this.e;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    c();
    AIOGalleryMsgRevokeMgr.a().b(this);
    super.onDestroyView();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 3)
    {
      String str = paramTextView.getText().toString().trim();
      if (TextUtils.isEmpty(str))
      {
        bool1 = bool2;
      }
      else
      {
        a(str);
        bool1 = true;
      }
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)localBaseActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
        localInputMethodManager.hideSoftInputFromWindow(localBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("chatHistory.troop.portal", 2, paramAdapterView.toString());
    }
    if (paramView == this.k)
    {
      paramAdapterView = this.c.b();
      this.k.setText(HardCodeUtil.a(2131899900));
      this.c.a(System.currentTimeMillis(), paramAdapterView, 2);
      return;
    }
    for (paramAdapterView = this.h.getAdapter(); (paramAdapterView instanceof WrapperListAdapter); paramAdapterView = ((WrapperListAdapter)paramAdapterView).getWrappedAdapter()) {}
    if (paramAdapterView == this.c)
    {
      paramView = getBaseActivity();
      if (paramView == null) {
        return;
      }
      paramAdapterView = ((MessageItem)paramAdapterView.getItem(paramInt)).b;
      ChatHistoryBubbleListForTroopFragment.a(paramView, this.n, paramAdapterView, 100, 2);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onItemClick, message = ");
        paramView.append(paramAdapterView);
        QLog.i("chatHistory.troop.portal", 2, paramView.toString());
      }
      ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_clk", 0, 0, this.n, "", "", "");
      return;
    }
    if (paramAdapterView == this.b)
    {
      paramAdapterView = (String)paramAdapterView.getItem(paramInt);
      this.i.setText(paramAdapterView);
      this.i.setSelection(paramAdapterView.length());
      a(paramAdapterView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "onItemClick, unknown data type");
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLongClick, position = ");
      localStringBuilder.append(paramInt);
      QLog.i("chatHistory.troop.portal", 2, localStringBuilder.toString());
    }
    if (paramView == this.k) {
      return false;
    }
    this.d = ((MessageItem)paramAdapterView.getAdapter().getItem(paramInt));
    paramView.setSelected(true);
    paramAdapterView = new QQCustomMenu();
    paramAdapterView.a(2131431492, HardCodeUtil.a(2131899826), 2130839057);
    paramAdapterView.a(2131433636, this.e.getContext().getString(2131889668), 2130839066);
    BubbleContextMenu.a(paramView, paramAdapterView, this, new ChatHistoryForTroopFragment.1(this, paramView));
    return true;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84)))
    {
      paramView = ((TextView)paramView).getText().toString().trim();
      if (TextUtils.isEmpty(paramView)) {
        return false;
      }
      a(paramView);
      return true;
    }
    return false;
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0)
    {
      String str = this.c.b();
      this.k.setText(HardCodeUtil.a(2131899845));
      this.c.a(System.currentTimeMillis(), str, 2);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      if (paramView == this.h)
      {
        ((InputMethodManager)this.i.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.i.getWindowToken(), 0);
        return false;
      }
      if (paramView == this.i) {
        ReportController.b(this.o, "dc00899", "Grp_chatRecord", "", "home", "Clk_search", 0, 0, this.n, "", "", "");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment
 * JD-Core Version:    0.7.0.1
 */