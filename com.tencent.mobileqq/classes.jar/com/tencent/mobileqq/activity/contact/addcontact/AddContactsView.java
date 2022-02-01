package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactUtils;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsCanceledListener;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.IFirstLocationReqCancelListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String R = HardCodeUtil.a(2131898096);
  ConditionSearchManager.IFirstLocationReqCancelListener A = new AddContactsView.9(this);
  String[] B = null;
  LBSObserver C = new AddContactsView.11(this);
  PopupWindow D;
  private String[] H;
  private TextView I;
  private EditText J;
  private Button K;
  private View L;
  private IFaceDecoder M;
  private MayKnowAdapter N;
  private long O;
  private long P;
  private TopGestureLayout Q;
  private boolean S;
  private final Runnable T = new AddContactsView.13(this);
  FormMutiItem a;
  FormMutiItem b;
  FormMutiItem c;
  FormMutiItem d;
  FormMutiItem e;
  FormMutiItem f;
  FormMutiItem g;
  FormMutiItem h;
  FormMutiItem i;
  RelativeLayout j;
  RelativeLayout k;
  HorizontalListView l;
  BounceScrollView m;
  boolean n;
  boolean o;
  SwipListView p;
  RecommendFriendAdapter q;
  ConditionSearchManager r;
  boolean s = false;
  View.OnTouchListener t = new AddContactsView.1(this);
  int u = 0;
  MayKnowAdapter.OnRecommendsCanceledListener v = new AddContactsView.3(this);
  MayKnowAdapter.OnRecommendsCanceledListener w = new AddContactsView.4(this);
  SwipListView.RightIconMenuListener x = new AddContactsView.6(this);
  boolean y = false;
  ConditionSearchManager.IConfigListener z = new AddContactsView.8(this);
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = new FormMutiWithAvatarItem(this.F);
    } else {
      localObject = new FormMutiItem(this.F);
    }
    ((FormMutiItem)localObject).setId(paramInt1);
    ((FormMutiItem)localObject).setClickable(true);
    ((FormMutiItem)localObject).setFocusable(true);
    ((FormMutiItem)localObject).setBgType(3);
    ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131168001));
    ((FormMutiItem)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.b(56.0F, getResources())));
    ((FormMutiItem)localObject).setBackgroundResource(2130839572);
    return localObject;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.Q == null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.F.getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.Q = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.Q;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideFace2FaceAddFriendGuideTips, save=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" isShowing:");
      PopupWindow localPopupWindow = this.D;
      boolean bool;
      if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.D;
    if (localObject != null)
    {
      if ((((PopupWindow)localObject).isShowing()) && (paramBoolean))
      {
        this.S = false;
        Face2FaceAddContactUtils.b(this.G);
      }
      this.D.dismiss();
      this.D = null;
    }
    localObject = this.i;
    if (localObject != null) {
      ((FormMutiItem)localObject).removeCallbacks(this.T);
    }
  }
  
  private void j()
  {
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.G.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.n = localMayknowRecommendManager.d("sp_mayknow_addpage_s_a_vl");
    boolean bool;
    if ((localMayknowRecommendManager.d("sp_mayknow_entry_list_add")) && (!StudyModeManager.h())) {
      bool = true;
    } else {
      bool = false;
    }
    this.o = bool;
  }
  
  private void k()
  {
    this.s = this.r.b();
    String[] arrayOfString = this.r.k();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSearchConditions|autoReqLocation = ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(", locCode[0] = ");
      localStringBuilder.append(arrayOfString[0]);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
    if ((this.s) || ("0".equals(arrayOfString[0])))
    {
      if ((!DatingUtil.a()) && (NetworkUtil.isNetSupport(this.F)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
        }
        this.E.a().addObserver(this.C);
        ((LBSHandler)this.G.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
      }
      else
      {
        this.B = new String[] { "-1", "-1", "-1", "-1" };
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
        }
      }
      if (this.s)
      {
        this.r.c(this.z);
        this.r.a(this.A);
      }
    }
  }
  
  private void l()
  {
    this.m = ((BounceScrollView)findViewById(2131427785));
    this.m.setOnScrollChangedListener(new AddContactsView.2(this));
    this.L = findViewById(2131445653);
    this.K = ((Button)findViewById(2131429816));
    this.K.setVisibility(8);
    this.J = ((EditText)findViewById(2131432634));
    this.I = ((TextView)findViewById(2131448724));
    this.J.setFocusableInTouchMode(false);
    this.J.setCursorVisible(false);
    this.J.setOnClickListener(this);
    if (AppSetting.e) {
      this.I.setContentDescription(HardCodeUtil.a(2131898098));
    }
    this.I.setText(2131886280);
    Object localObject = this.a;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130846401));
      this.a.setFirstLineText(this.F.getString(2131886287));
      this.a.setSecondLineVisible(false);
      this.a.a(true);
      this.a.setOnClickListener(this);
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130846141));
      this.b.setFirstLineText(getResources().getString(2131886285));
      this.b.setSecondLineVisible(false);
      this.b.setSecondLineVisible(false);
      this.b.a(true);
      this.b.setOnClickListener(this);
      if (AppSetting.e) {
        this.b.setContentDescription(HardCodeUtil.a(2131898094));
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130846140));
      this.c.setFirstLineText(HardCodeUtil.a(2131898099));
      this.c.setSecondLineVisible(false);
      this.c.a(true);
      this.c.setOnClickListener(this);
      if (AppSetting.e) {
        this.c.setContentDescription(HardCodeUtil.a(2131898095));
      }
    }
    this.k = ((RelativeLayout)findViewById(2131444468));
    this.j = ((RelativeLayout)findViewById(2131427811));
    this.j.setOnClickListener(this);
    this.j.setOnTouchListener(this.t);
    this.l = ((HorizontalListView)findViewById(2131438026));
    this.l.setDividerWidth(AIOUtils.b(9.0F, getResources()));
    this.l.setAdapter(this.N);
    this.p = ((SwipListView)findViewById(2131444460));
    this.p.setFocusable(false);
    this.p.setDragEnable(true);
    localObject = this.d;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837711));
      this.d.setFirstLineText(getResources().getString(2131886291));
      this.d.setSecondLineVisible(false);
      this.d.a(true);
      this.d.setOnClickListener(this);
      if (AppSetting.e) {
        this.d.setContentDescription(getResources().getString(2131886291));
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837708));
      this.e.setFirstLineText(getResources().getString(2131886309));
      this.e.setSecondLineVisible(false);
      this.e.a(true);
      this.e.setOnClickListener(this);
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130846591));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((IExpandManager)this.G.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).t();
      if (localObject != null)
      {
        this.f.setFirstLineText(((ExpandConfig)localObject).addEntranceTitle);
        QLog.d("AddContactsViewqqexpand", 1, ((ExpandConfig)localObject).addEntranceTitle);
        this.f.setSecondLineVisible(false);
      }
      else
      {
        this.f.setFirstLineText(2131896784);
        this.f.setSecondLineVisible(false);
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130846935));
      this.g.a(true);
      this.g.setOnClickListener(this);
      String str = getResources().getString(2131914035);
      localObject = getResources().getString(2131914034);
      str = SharedPreUtils.c(this.G.getApp(), this.G.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
      SharedPreUtils.c(this.G.getApp(), this.G.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
      this.g.setFirstLineText(str);
      this.g.setSecondLineVisible(false);
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837709));
      this.h.a(true);
      this.h.setOnClickListener(this);
      this.M = ((IQQAvatarService)this.G.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.G);
      this.h.setFirstLineText(2131886289);
      this.h.setSecondLineVisible(false);
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130840304));
      this.i.a(true);
      this.i.setOnClickListener(this);
      this.i.setFirstLineText(2131889139);
      this.i.setSecondLineVisible(false);
    }
  }
  
  private void m()
  {
    k();
    Intent localIntent = this.E.b().getIntent();
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.G.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localMayknowRecommendManager != null) {
      localMayknowRecommendManager.e(5);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData  addPageDisplayAsVerticalListItem = ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append("shouldShowMayknowEnty=");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    if (localMayknowRecommendManager != null) {
      localObject = localMayknowRecommendManager.f();
    }
    if (((ArrayList)localObject).size() > 0)
    {
      e();
    }
    else
    {
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.p.setVisibility(8);
    }
    if (this.n)
    {
      this.q = new RecommendFriendAdapter(this.F, this.G, this.p, localIntent.getIntExtra("EntranceId", 0), this.w);
      this.q.b(21);
      int i1 = this.F.getResources().getDimensionPixelSize(2131298134);
      this.q.a(i1);
      this.q.a((List)localObject);
      this.p.setRightIconMenuListener(this.x);
      this.p.getViewTreeObserver().addOnGlobalLayoutListener(new AddContactsView.5(this));
    }
    else
    {
      this.N = new MayKnowAdapter(this.F, this.G, this.l, this.v, 21, localIntent.getIntExtra("EntranceId", 0));
    }
    if (StudyModeManager.k()) {
      this.L.setVisibility(8);
    }
  }
  
  private void n()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.O), Long.valueOf(this.P) }));
    }
    long l2 = this.O;
    if ((l2 <= 0L) || ((l2 > 0L) && (l1 - l2 > this.P)))
    {
      boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
      this.O = l1;
      if (bool) {
        l1 = 1000L;
      } else {
        l1 = 2000L;
      }
      this.P = l1;
      Object localObject1 = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
      Object localObject2 = SharedPreUtils.c(this.G.getApp(), this.G.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      localObject2 = new Intent(this.F, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.F.startActivity((Intent)localObject2);
      ReportController.b(this.G, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
    }
  }
  
  private void o()
  {
    Intent localIntent;
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).isNeedNearbyShowGuide(this.G.getAccount()))
    {
      localIntent = new Intent();
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.F.getResources().getText(2131886199));
      NearbyFakeActivityUtils.a(this.F, localIntent);
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.F.getResources().getText(2131886199));
      RouteUtils.a(getContext(), localIntent, "/nearby/guide");
    }
    ReportController.a(this.G, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
  }
  
  private void p()
  {
    FormMutiItem localFormMutiItem = this.a;
    if (localFormMutiItem != null) {
      localFormMutiItem.setRightIcon(null);
    }
    this.F.startActivity(new Intent(this.F, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.s));
    ReportController.b(this.G, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
  }
  
  private void q()
  {
    Object localObject1 = (IPhoneContactService)this.G.getRuntimeService(IPhoneContactService.class);
    int i1 = ((IPhoneContactService)localObject1).getSelfBindState();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick ADD_PHONE_CONTACTS_ID selfBindState=");
      ((StringBuilder)localObject2).append(i1);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i1 != 2) && (i1 != 4) && (i1 != 9) && (i1 != 8))
    {
      if ((i1 == 3) || (i1 == 6) || (i1 == 7) || (i1 == 1) || (i1 == 5) || (i1 == 0))
      {
        localObject1 = new Intent(this.F, PhoneMatchActivity.class);
        ((Intent)localObject1).putExtra("kSrouce", 14);
        this.F.startActivity((Intent)localObject1);
      }
    }
    else
    {
      localObject1 = new AddContactsView.7(this, (IPhoneContactService)localObject1);
      localObject2 = new DenyRunnable(this.F, 2);
      PermissionChecker.a(this.F, (Runnable)localObject1, (Runnable)localObject2);
    }
    ReportController.b(this.G, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
    ReportController.b(this.G, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
    if ((i1 == 1) || (i1 == 5)) {
      ReportController.b(this.G, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
    }
  }
  
  private void r()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131432580);
    Object localObject = this.H;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i1 = 0;
      while (i1 < this.H.length)
      {
        int i2 = 0;
        while (i2 < this.H[i1].length())
        {
          switch (this.H[i1].charAt(i2))
          {
          default: 
            break;
          case '9': 
            if ((this.h == null) && (!StudyModeManager.h()))
            {
              this.h = a(1009, i1, i2, true);
              localLinearLayout.addView(this.h);
              ReportController.b(this.G, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
            }
            break;
          case '8': 
            if (this.g == null)
            {
              this.g = a(1008, i1, i2);
              localLinearLayout.addView(this.g);
            }
            break;
          case '7': 
            boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).needShowLimitChatOnPlus(this.G);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("createConfigView kuolie showEntry = ");
              ((StringBuilder)localObject).append(bool);
              QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
            }
            if ((this.f == null) && (!StudyModeManager.h()) && (bool))
            {
              this.f = a(1007, i1, i2);
              localLinearLayout.addView(this.f);
              ReportController.b(this.G, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
            }
            break;
          case '6': 
            if (this.i == null)
            {
              this.i = a(1010, i1, i2);
              localLinearLayout.addView(this.i);
              Face2FaceAddContactUtils.a("0X800AB5C", "", "", "");
            }
            break;
          case '5': 
            if (this.d == null)
            {
              this.d = a(1004, i1, i2);
              localLinearLayout.addView(this.d);
            }
            break;
          case '4': 
            if ((this.c == null) && (!StudyModeManager.h()))
            {
              this.c = a(1003, i1, i2);
              localLinearLayout.addView(this.c);
            }
            break;
          case '3': 
            if (this.e == null)
            {
              this.e = a(1006, i1, i2);
              localLinearLayout.addView(this.e);
            }
            break;
          case '2': 
            if ((this.a == null) && (!StudyModeManager.h()))
            {
              this.a = a(1002, i1, i2);
              localLinearLayout.addView(this.a);
            }
            break;
          case '1': 
            if ((this.b == null) && (!StudyModeManager.k()))
            {
              this.b = a(1001, i1, i2);
              localLinearLayout.addView(this.b);
            }
            break;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
  }
  
  private void s()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.G.getCurrentAccountUin(), "extend_friend_config_785");
    Object localObject1 = SharedPreUtils.ac(this.F, this.G.getCurrentAccountUin());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).isEmpty()) {}
    }
    else
    {
      localObject2 = "13275";
    }
    int i1 = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
    localObject1 = (IExpandManager)this.G.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (i1 == 1)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).contains("7"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("7");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = ((String)localObject2).replace("7", "");
    }
    this.u = BaseApplicationImpl.getContext().getSharedPreferences(this.G.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0);
    if (this.u == 1)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("8"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("8");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    else
    {
      localObject2 = ((String)localObject1).replace("8", "");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AddContactsViewConfig fetches successfully，content=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (((String)localObject2).contains("9")) {
      if (this.o)
      {
        localObject1 = localObject2;
        if (((MayknowRecommendManager)this.G.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).d() <= 0) {
          localObject1 = ((String)localObject2).replace("9", "");
        }
      }
      else
      {
        localObject1 = ((String)localObject2).replace("9", "");
      }
    }
    this.H = ((String)localObject1).split("\\|");
  }
  
  private void t()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.12(this));
  }
  
  private void u()
  {
    if (this.S)
    {
      FormMutiItem localFormMutiItem = this.i;
      if ((localFormMutiItem != null) && (this.D == null))
      {
        localFormMutiItem.removeCallbacks(this.T);
        this.i.postDelayed(this.T, 100L);
      }
    }
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131624050);
    this.r = ((ConditionSearchManager)this.G.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    j();
    s();
    r();
    l();
    m();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000000) && (QLog.isColorLevel()))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("REQ_CODE_BIND_NUMBER resultCode: ");
      paramIntent.append(paramInt1);
      paramIntent.append(", src: ");
      paramIntent.append(14);
      QLog.i("BindMsgConstant", 2, paramIntent.toString());
    }
  }
  
  public void b()
  {
    super.b();
    f();
    this.r.a(this);
    Object localObject = this.q;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).b();
    }
    localObject = this.N;
    if (localObject != null) {
      ((MayKnowAdapter)localObject).a();
    }
    if (this.h != null) {
      t();
    }
    int i1 = this.F.getIntent().getIntExtra("entrence_data_report", 0);
    ReportController.b(this.G, "CliOper", "", "", "0X800760D", "0X800760D", i1, 0, "", "", "", "");
    if (i1 != 0) {
      ReportController.b(this.G, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.u == 1) {
      ReportController.b(this.G, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    SearchUtils.a("add_page", "search_people", "exp", 0, 0, new String[] { "" });
    if (this.i != null)
    {
      this.S = Face2FaceAddContactUtils.a(this.G);
      u();
    }
  }
  
  public void c()
  {
    Object localObject = this.N;
    if (localObject != null)
    {
      ((MayKnowAdapter)localObject).c();
      this.N.b();
    }
    localObject = this.q;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).a();
    }
    localObject = this.p;
    if ((localObject != null) && (((SwipListView)localObject).getVisibility() == 0)) {
      this.p.hideCurShowingRightView();
    }
    b(false);
  }
  
  public void d()
  {
    super.d();
    b(false);
    this.r.b(this);
    this.r.d(this.z);
    this.r.a(null);
    this.E.a().removeObserver(this.C);
    Object localObject = this.N;
    if (localObject != null) {
      ((MayKnowAdapter)localObject).d();
    }
    localObject = this.q;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).c();
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.M = null;
    }
  }
  
  void e()
  {
    if (this.o)
    {
      if (this.n)
      {
        this.p.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
      }
      else
      {
        this.p.setVisibility(8);
        this.l.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
      }
    }
    else
    {
      this.p.setVisibility(8);
      this.l.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMayknowRecommendListStyle,addPageDisplayAsVerticalListItem = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" shouldShowMayknowEnty=");
      localStringBuilder.append(this.o);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
  }
  
  void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fillSearchConditions | autoReqLocation = ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(" | code one = ");
      Object localObject = this.B;
      if ((localObject != null) && (localObject.length == 4)) {
        localObject = localObject[0];
      } else {
        localObject = Integer.valueOf(-1000);
      }
      localStringBuilder.append(localObject);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new AddContactsView.10(this, new StringBuilder(R)), null, true);
  }
  
  public int getHeightToTabBar()
  {
    return getResources().getDimensionPixelSize(2131298867);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick id=");
      ((StringBuilder)localObject).append(paramView.getId());
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramView.getId();
    if (i1 != 2131427811)
    {
      if (i1 != 2131432634)
      {
        switch (i1)
        {
        default: 
          switch (i1)
          {
          default: 
            break;
          case 1010: 
            b(true);
            Face2FaceAddContactFragment.a(this.F, new Intent());
            Face2FaceAddContactUtils.a("0X800AB5E", "", "", "");
            break;
          case 1009: 
            localObject = new Intent();
            PublicFragmentActivity.a(this.F, (Intent)localObject, ConnectionsExplorationFragment.class);
            ReportController.b(this.G, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
            break;
          case 1008: 
            n();
            break;
          case 1007: 
            ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.E.b(), this.G, 1);
            ReportController.b(this.G, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
            ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("1");
            break;
          case 1006: 
            localObject = new Intent();
            ((Intent)localObject).putExtra("from", "AddContactsActivity");
            ((Intent)localObject).setFlags(67108864);
            ((Intent)localObject).putExtra("fromPicQRDecode", true);
            RouteUtils.a(this.F, (Intent)localObject, "/qrscan/scanner");
            ReportController.b(this.G, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
          }
          break;
        case 1004: 
          localObject = new Intent(this.F, CreateFaceToFaceDiscussionActivity.class);
          ((Intent)localObject).putExtra("create_source", 7);
          this.F.startActivity((Intent)localObject);
          ReportController.b(this.G, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
          break;
        case 1003: 
          o();
          break;
        case 1002: 
          p();
          break;
        case 1001: 
          q();
          break;
        }
      }
      else
      {
        this.E.c();
        SearchUtils.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
        ReportController.b(this.G, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      }
    }
    else
    {
      i1 = this.E.b().getIntent().getIntExtra("EntranceId", 0);
      if (i1 != 3)
      {
        if (i1 == 4) {
          ReportController.b(this.G, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
        }
      }
      else {
        ReportController.b(this.G, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
      }
      localObject = new Intent(this.F, RecommendFriendActivity.class);
      ((Intent)localObject).putExtra("EntranceId", i1);
      this.F.startActivity((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "setListViewHeightBasedOnChildren");
    }
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int i1 = 0;
    int i2 = 0;
    while (i1 < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(i1, null, paramListView);
      ((View)localObject).measure(0, 0);
      i2 += ((View)localObject).getMeasuredHeight();
      i1 += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i2 + paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + paramListView.getPaddingTop() + paramListView.getPaddingBottom());
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */