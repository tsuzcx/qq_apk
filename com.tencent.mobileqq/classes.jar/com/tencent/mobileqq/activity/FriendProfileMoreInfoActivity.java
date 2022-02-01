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
  boolean A = false;
  boolean B = false;
  boolean C = false;
  boolean D = false;
  boolean E = false;
  WeakReferenceHandler F;
  ProfileConfig G;
  Bundle H;
  boolean I = false;
  String J = "";
  String K = "";
  String L = "";
  CardObserver M = new FriendProfileMoreInfoActivity.1(this);
  protected BroadcastReceiver N = new FriendProfileMoreInfoActivity.16(this);
  private View O;
  private ImageView P;
  private View Q;
  private TextView R;
  private View S;
  private View T;
  private View U;
  private TextView V;
  private View W;
  private TextView X;
  private View Y;
  private TextView Z;
  BounceScrollView a;
  private TextView aa;
  private View ab;
  private View ac;
  private View ad;
  private TextView ae;
  private View af;
  private TextView ag;
  private View ah;
  private View ai;
  private TextView aj;
  private View ak;
  private LinearLayout al;
  private IphonePickerView am;
  private String an;
  private byte ao;
  private int ap;
  private int aq;
  private int ar;
  private int as;
  private String at;
  private String au;
  private boolean av = false;
  private ProfileCardObserver aw = new FriendProfileMoreInfoActivity.2(this);
  private BusinessCardObserver ax = new FriendProfileMoreInfoActivity.3(this);
  private FriendListObserver ay = new FriendProfileMoreInfoActivity.4(this);
  private ConditionSearchManager.IConfigListener az = new FriendProfileMoreInfoActivity.5(this);
  TextView b;
  LinearLayout c;
  ColorNickTextView d;
  TextView e;
  EditText f;
  EditText g;
  EditText h;
  EditText i;
  AllInOne j;
  BusinessCard k;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher l;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher m;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher n;
  FriendProfileMoreInfoActivity.MaxBytesTextWatcher o;
  CardHandler p;
  ConditionSearchManager q;
  ActionSheet r;
  QQProgressDialog s = null;
  int t = 0;
  QQProgressDialog u = null;
  boolean v = false;
  boolean w = false;
  String[] x;
  String[] y;
  boolean z = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.t = paramInt;
    if (this.s == null) {
      this.s = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.s.a(paramString);
    this.s.show();
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard != null) && (!this.I) && (ProfileCardUtil.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = HardCodeUtil.a(2131902897);
      DialogUtil.a(this, HardCodeUtil.a(2131902876), str, null, 2131892744, 2131892745, new FriendProfileMoreInfoActivity.7(this), new FriendProfileMoreInfoActivity.8(this)).show();
      ProfileCardUtil.b(paramCard, this.app);
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
    this.au = paramCard.strNick;
    a(RichStatusUtils.Companion.getRichStatus(paramCard));
    Object localObject1 = this.f.getText().toString();
    if ((!this.l.b) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.l.a = true;
      a(paramCard.strNick);
    }
    else if (!TextUtils.isEmpty(paramCard.strNick))
    {
      this.f.setHint(paramCard.strNick);
    }
    if (!this.z) {
      a(paramCard.shGender, false);
    }
    if (!this.A) {
      a((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
    }
    if (!this.B) {
      a(paramCard.iProfession);
    }
    localObject1 = this.g.getText().toString();
    if ((!this.m.b) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
    {
      this.m.a = true;
      b(paramCard.strCompany);
    }
    localObject1 = this.h.getText().toString();
    if ((!this.n.b) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
    {
      this.n.a = true;
      c(paramCard.strSchool);
    }
    paramBoolean = this.C;
    Object localObject2 = null;
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramCard.strLocationCodes)) {
        localObject1 = paramCard.strLocationCodes.split("-");
      } else {
        localObject1 = null;
      }
      this.x = ((String[])localObject1);
      d(paramCard.strLocationDesc);
    }
    if (!this.D)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
        localObject1 = paramCard.strHometownCodes.split("-");
      }
      this.y = ((String[])localObject1);
      e(paramCard.strHometownDesc);
    }
    localObject1 = this.i.getText().toString();
    if ((!this.o.b) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
    {
      this.o.a = true;
      f(paramCard.strEmail);
    }
    if (!this.E) {
      g(paramCard.strPersonalNote);
    }
  }
  
  private void a(ArrayList<SchoolInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (this.ak.getVisibility() == 0))
    {
      Object localObject1 = this.al;
      if (localObject1 != null)
      {
        ((LinearLayout)localObject1).removeAllViews();
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            localObject1 = (SchoolInfo)paramArrayList.next();
            if (!TextUtils.isEmpty(((SchoolInfo)localObject1).d))
            {
              View localView = View.inflate(this, 2131627693, null);
              TextView localTextView = (TextView)localView.findViewById(2131445311);
              if (((SchoolInfo)localObject1).l)
              {
                localTextView.setText(((SchoolInfo)localObject1).d);
                localObject2 = getResources().getDrawable(2130846614);
                ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
                localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
                localTextView.setCompoundDrawablePadding(AIOUtils.b(4.5F, localTextView.getResources()));
              }
              else
              {
                localTextView.setText(((SchoolInfo)localObject1).d);
              }
              localTextView = (TextView)localView.findViewById(2131432379);
              Object localObject2 = ((SchoolInfo)localObject1).a();
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localTextView.setVisibility(8);
              } else {
                localTextView.setText((CharSequence)localObject2);
              }
              localTextView = (TextView)localView.findViewById(2131432380);
              if (((SchoolInfo)localObject1).k) {
                localTextView.setVisibility(0);
              } else {
                localTextView.setVisibility(8);
              }
              localView.setOnClickListener(this);
              localView.setTag(localObject1);
              this.al.addView(localView);
            }
          }
        }
        paramArrayList = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.app.getCurrentAccountUin());
        if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
        {
          localObject1 = View.inflate(this, 2131627693, null);
          ((TextView)((View)localObject1).findViewById(2131445311)).setText(paramArrayList.strSchool);
          ((TextView)((View)localObject1).findViewById(2131432379)).setVisibility(8);
          ((View)localObject1).setOnClickListener(this);
          ((View)localObject1).setTag(paramArrayList);
          this.al.addView((View)localObject1);
        }
        if (this.al.getChildCount() < 2)
        {
          this.ak.findViewById(2131445302).setVisibility(0);
          this.ak.findViewById(2131445306).setVisibility(0);
          this.ak.findViewById(2131445304).setVisibility(0);
          this.ak.findViewById(2131445300).setVisibility(8);
          return;
        }
        this.ak.findViewById(2131445302).setVisibility(8);
        this.ak.findViewById(2131445306).setVisibility(8);
        this.ak.findViewById(2131445304).setVisibility(8);
        this.ak.findViewById(2131445300).setVisibility(0);
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
    this.av = false;
    if (paramBoolean) {
      a(((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).b());
    }
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(paramInt1, paramInt2);
    }
    else if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.p.a(paramBundle);
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
    if (a(localBundle, 2131892104, 0)) {
      this.av = true;
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
  
  private void c()
  {
    this.p.a(this.app.getLongAccountUin());
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
          this.a.post(new FriendProfileMoreInfoActivity.12(this));
          return;
        }
        this.a.post(new FriendProfileMoreInfoActivity.11(this));
        d(1);
        return;
      }
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.ap);
      startActivityForResult(localIntent, 1003);
      return;
    }
    this.a.post(new FriendProfileMoreInfoActivity.10(this));
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addButton(2131892741, 0);
    localActionSheet.addButton(2131892743, 0);
    localActionSheet.addButton(2131892742, 0);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new FriendProfileMoreInfoActivity.9(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.q.d();
    if (i1 != 0)
    {
      i1 = this.q.a(i1, true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startLocationSelectActivity | update result = ");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("FriendProfileMoreInfoActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 == 2)
      {
        QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131888006));
        this.q.c(this.az);
        return;
      }
      a(paramInt, getString(2131888006));
      this.F.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (paramInt == 1) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    if (paramInt == 1) {
      localObject1 = this.x;
    } else {
      localObject1 = this.y;
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
    ((Intent)localObject1).putExtra("param_location_param", this.q.e((String[])localObject2));
    if (paramInt == 1) {
      paramInt = 1005;
    } else {
      paramInt = 1006;
    }
    startActivityForResult((Intent)localObject1, paramInt);
  }
  
  private void e()
  {
    if (j())
    {
      if (this.u == null)
      {
        this.u = new QQProgressDialog(this, getTitleBarHeight());
        this.u.a(HardCodeUtil.a(2131902874));
      }
      if (this.v)
      {
        this.u.dismiss();
        this.w = true;
        if (!isFinishing()) {
          finish();
        }
      }
      else
      {
        if (k())
        {
          this.v = true;
          this.u.show();
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
    this.a = ((BounceScrollView)findViewById(2131445157));
    this.b = ((TextView)findViewById(2131436227));
    this.b.setText(2131890849);
    this.b.setContentDescription(getString(2131890849));
    Object localObject = (TextView)findViewById(2131436180);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131902918));
    ((TextView)localObject).setOnClickListener(this);
    this.c = ((LinearLayout)findViewById(2131431349));
    this.O = findViewById(2131429023);
    this.O.setContentDescription(getString(2131889121));
    this.O.setOnClickListener(this);
    this.P = ((ImageView)findViewById(2131429019));
    this.Q = findViewById(2131446002);
    this.Q.setOnClickListener(this);
    this.R = ((TextView)findViewById(2131446004));
    a(null);
    this.S = findViewById(2131448028);
    if (this.I)
    {
      this.S.setVisibility(0);
      this.d = ((ColorNickTextView)findViewById(2131448031));
      this.e = ((TextView)findViewById(2131448029));
      localObject = findViewById(2131448027);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.J);
      if (localTroopInfo != null)
      {
        if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.K, this.app.getCurrentAccountUin())))
        {
          this.S.setClickable(true);
          this.S.setOnClickListener(this);
          ((View)localObject).setVisibility(0);
        }
      }
      else
      {
        this.S.setClickable(false);
        this.S.setOnClickListener(null);
        ((View)localObject).setVisibility(8);
      }
      a();
    }
    this.T = findViewById(2131439310);
    if (this.S.getVisibility() == 0) {
      ((LinearLayout.LayoutParams)this.T.getLayoutParams()).setMargins(0, 0, 0, 0);
    }
    this.T.setClickable(false);
    this.f = ((EditText)findViewById(2131439309));
    this.f.setOnFocusChangeListener(this);
    this.l = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 36, this.f);
    this.f.addTextChangedListener(this.l);
    this.l.a = true;
    a(null);
    this.U = findViewById(2131445737);
    this.U.setOnClickListener(this);
    this.V = ((TextView)findViewById(2131445738));
    a(-1, false);
    this.W = findViewById(2131429531);
    this.W.setOnClickListener(this);
    this.X = ((TextView)findViewById(2131429532));
    a(0, 0, 0);
    if (ProfileCardUtil.c())
    {
      int i1 = this.U.getPaddingLeft();
      int i2 = this.U.getPaddingTop();
      int i3 = this.U.getPaddingRight();
      int i4 = this.U.getPaddingBottom();
      this.U.setBackgroundResource(2130839629);
      this.U.setPadding(i1, i2, i3, i4);
      this.W.setVisibility(8);
      if (QLog.isDevelopLevel()) {
        QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
      }
    }
    this.Y = findViewById(2131440679);
    this.Y.setOnClickListener(this);
    this.Z = ((TextView)findViewById(2131440678));
    this.aa = ((TextView)findViewById(2131440680));
    a(-1);
    this.ab = findViewById(2131431175);
    this.ab.setClickable(false);
    this.g = ((EditText)findViewById(2131431174));
    this.g.setOnFocusChangeListener(this);
    this.m = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 120, this.g);
    this.g.addTextChangedListener(this.m);
    this.m.a = true;
    b(null);
    this.ac = findViewById(2131445310);
    this.ac.setClickable(false);
    this.h = ((EditText)findViewById(2131445307));
    this.h.setOnFocusChangeListener(this);
    this.n = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 40, this.h);
    this.h.addTextChangedListener(this.n);
    this.n.a = true;
    c(null);
    this.ad = findViewById(2131437694);
    this.ad.setOnClickListener(this);
    this.ae = ((TextView)findViewById(2131437708));
    d(null);
    this.af = findViewById(2131435092);
    this.af.setOnClickListener(this);
    this.ag = ((TextView)findViewById(2131435093));
    e(null);
    this.ah = findViewById(2131432398);
    this.ah.setClickable(false);
    this.i = ((EditText)findViewById(2131432397));
    this.i.setOnFocusChangeListener(this);
    this.o = new FriendProfileMoreInfoActivity.MaxBytesTextWatcher(this, 50, this.i);
    this.i.addTextChangedListener(this.o);
    this.o.a = true;
    f(null);
    this.ai = findViewById(2131440008);
    this.ai.setOnClickListener(this);
    this.aj = ((TextView)findViewById(2131440009));
    g(null);
    this.ak = findViewById(2131432382);
    this.al = ((LinearLayout)findViewById(2131427832));
    findViewById(2131445301).setOnClickListener(this);
    findViewById(2131445305).setOnClickListener(this);
    findViewById(2131445303).setOnClickListener(this);
    findViewById(2131445299).setOnClickListener(this);
    localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((this.I) && (((TroopManager)localObject).Z(this.J)))
    {
      this.Q.setVisibility(8);
      this.Y.setVisibility(8);
      this.ab.setVisibility(8);
      this.ac.setVisibility(8);
      this.af.setVisibility(8);
      this.ah.setVisibility(8);
      this.ai.setVisibility(8);
    }
    if (!this.I)
    {
      this.ac.setVisibility(8);
      this.ak.setVisibility(0);
    }
  }
  
  private String g()
  {
    return String.format("%s-1-1", new Object[] { Integer.valueOf(Calendar.getInstance().get(1) - 18) });
  }
  
  private void h()
  {
    if (this.j == null) {
      return;
    }
    SignatureEditManager.b(this, this.app, 0, "signature_ziliaoka", 1002);
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
    Object localObject = this.r;
    int i1 = 1;
    if (localObject == null)
    {
      this.am = ((IphonePickerView)getLayoutInflater().inflate(2131627482, null));
      this.am.a(new FriendProfileMoreInfoActivity.13(this));
      this.r = ActionSheet.createMenuSheet(this);
      this.r.setCloseAutoRead(true);
      this.r.setActionContentView(this.am, null);
      localObject = (DispatchActionMoveScrollView)this.r.findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.r.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.am.setPickListener(new FriendProfileMoreInfoActivity.14(this));
    }
    int i2 = this.ao;
    if ((i2 != 0) && (i2 != 1))
    {
      this.ao = 0;
      this.z = true;
    }
    a(this.ao, true);
    localObject = this.am;
    if (this.ao != 1) {
      i1 = 0;
    }
    ((IphonePickerView)localObject).setSelection(0, i1);
    try
    {
      this.r.setOnDismissListener(new FriendProfileMoreInfoActivity.15(this));
      this.r.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean j()
  {
    return (this.l.b) || (this.m.b) || (this.n.b) || (this.o.b) || (this.z) || (this.A) || (this.B) || (this.C) || (this.D) || (this.E);
  }
  
  private boolean k()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.l.b)
    {
      localObject1 = this.f.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(((String)localObject1).trim())))
      {
        localBundle.putString("nick", ((String)localObject1).trim());
        QZoneHelper.restartQzone();
      }
    }
    if (this.z) {
      localBundle.putByte("sex", this.ao);
    }
    if (this.A)
    {
      localBundle.putInt("birthday", this.ap);
      localBundle.putInt("age", this.aq);
      localBundle.putInt("key_constellation", this.ar);
    }
    if (this.B) {
      localBundle.putInt("profession", this.as);
    }
    if (this.m.b) {
      localBundle.putString("company", this.g.getText().toString());
    }
    if (this.n.b) {
      localBundle.putString("college", this.h.getText().toString());
    }
    if (this.C)
    {
      localObject1 = this.ae.getText().toString();
      localBundle.putStringArray("location", this.x);
      localBundle.putString("location_desc", (String)localObject1);
      localObject1 = null;
    }
    try
    {
      localObject2 = this.q.f(this.x);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label248:
      break label248;
    }
    localBundle.putStringArray("location_name", (String[])localObject1);
    if (this.D)
    {
      localObject1 = this.ag.getText().toString();
      localBundle.putStringArray("hometown", this.y);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.o.b)
    {
      localObject1 = this.i.getText().toString();
      localObject2 = SearchBaseActivity.C.matcher((CharSequence)localObject1);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((Matcher)localObject2).matches())) {
        localBundle.putString("email", (String)localObject1);
      }
    }
    if (this.E) {
      localBundle.putString("personalNote", this.at);
    }
    return a(localBundle, 2131892104, 0);
  }
  
  private void l()
  {
    QQProgressDialog localQQProgressDialog = this.s;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.s.dismiss();
    }
  }
  
  void a()
  {
    String str = ContactUtils.c(this.app, this.J, this.K);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, this.K)))
    {
      this.e.setVisibility(8);
    }
    else
    {
      this.e.setVisibility(0);
      str = "";
    }
    SpannableString localSpannableString = new ColorNickText(str, 16).b();
    this.d.setText(localSpannableString);
    ColorNickManager.a(this.app, this.d, localSpannableString);
    a(this.S, this.d, getString(2131895346), str);
  }
  
  void a(int paramInt)
  {
    if (NearbyProfileUtil.a(paramInt)) {
      this.as = paramInt;
    } else {
      this.as = -1;
    }
    Object localObject2 = NearbyProfileUtil.h(paramInt);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.as = -1;
      localObject1 = getString(2131892841);
    }
    int i1 = NearbyProfileUtil.f.length;
    boolean bool = true;
    if ((paramInt < i1 - 1) && (paramInt > 0))
    {
      localObject2 = getResources().getDrawable(NearbyProfileUtil.g[paramInt]);
      ProfileCardUtils.setNightModeFilterForDrawable(this.app, (Drawable)localObject2);
      this.Z.setVisibility(0);
      this.Z.setBackgroundDrawable((Drawable)localObject2);
      this.Z.setText(NearbyProfileUtil.f[paramInt]);
    }
    else
    {
      this.Z.setVisibility(8);
    }
    localObject2 = this.aa;
    if (this.as != -1) {
      bool = false;
    }
    a((TextView)localObject2, (CharSequence)localObject1, bool);
    localObject2 = this.Y;
    TextView localTextView = this.aa;
    String str = getString(2131892842);
    if (paramInt == -1) {
      localObject1 = "";
    }
    a((View)localObject2, localTextView, str, (String)localObject1);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ap = paramInt1;
    this.aq = paramInt2;
    this.ar = paramInt3;
    String str1 = g();
    boolean bool = true;
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.X;
    if (paramInt1 != 0) {
      bool = false;
    }
    a((TextView)localObject, str1, bool);
    localObject = this.W;
    TextView localTextView = this.X;
    String str2 = getString(2131892737);
    if (paramInt1 == 0) {
      str1 = "";
    }
    a((View)localObject, localTextView, str2, str1);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    this.ao = ((byte)paramInt);
    String str = getString(2131892845);
    if (paramInt == 0) {
      str = getString(2131891484);
    } else if (paramInt == 1) {
      str = getString(2131889246);
    }
    if (paramBoolean)
    {
      a(this.V, str, 2131168002);
    }
    else
    {
      localObject = this.V;
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
    a(this.U, this.V, getString(2131892846), (String)localObject);
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
      paramView1.append(HardCodeUtil.a(2131902901));
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
      i1 = 2131168125;
    } else {
      i1 = 2131167993;
    }
    a(paramTextView, paramCharSequence, i1);
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool;
    if (paramRichStatus != null)
    {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
      this.an = paramRichStatus;
      bool = false;
    }
    else
    {
      paramRichStatus = HardCodeUtil.a(2131902908);
      this.an = "";
      bool = true;
    }
    a(this.R, paramRichStatus, bool);
    a(this.Q, this.R, getString(2131890935), paramRichStatus);
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = getString(2131892794);
      paramString = "";
    }
    else
    {
      str = paramString;
    }
    this.f.setText(paramString);
    this.f.setHint(str);
    a(this.T, this.f, getString(2131892795), paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).aa(paramString1))
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
      paramString1 = getString(2131895350);
      localIntent.putExtra("edit_type", 5);
      localIntent.putExtra("default_nick_id", this.d.getColorNickId());
      paramString2 = new StringBuilder();
      paramString2.append(this.d.getText().toString());
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
      localIntent.putExtra("default_hint", HardCodeUtil.a(2131902882));
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
    this.g.setText(str);
    this.g.setHint(2131892747);
    a(this.ab, this.g, getString(2131892748), str);
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.h.setText(str);
    this.h.setHint(2131892843);
    a(this.ac, this.h, getString(2131892844), str);
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
      paramString = getString(2131892790);
      bool = true;
    }
    a(this.ae, paramString, bool);
    View localView = this.ad;
    TextView localTextView = this.ae;
    String str = getString(2131892791);
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
        if (i1 != this.ap)
        {
          this.A = true;
          a(i1, paramInt1, paramInt2);
        }
      }
    }
    else if (paramInt1 == 1004)
    {
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("param_id", -1);
        if (paramInt1 != this.as)
        {
          this.B = true;
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
      if (a(this.x, paramIntent)) {
        break label464;
      }
      this.C = true;
      this.x = paramIntent;
    }
    try
    {
      paramIntent = this.q.d(paramIntent);
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
      if (a(this.y, paramIntent)) {
        break label464;
      }
      this.D = true;
      this.y = paramIntent;
    }
    try
    {
      paramIntent = this.q.d(paramIntent);
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
        if (!paramIntent.equals(this.at))
        {
          this.E = true;
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
        if (this.p != null)
        {
          paramIntent = this.app.getCurrentAccountUin();
          this.p.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
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
      super.setContentView(2131627692);
      this.F = new WeakReferenceHandler(Looper.getMainLooper(), this);
      paramBundle = getIntent();
      this.I = paramBundle.getBooleanExtra("isTroopMemberCard", false);
      this.J = paramBundle.getStringExtra("troopUin");
      this.K = paramBundle.getStringExtra("memberUin");
      this.L = paramBundle.getStringExtra("options");
      if (!TextUtils.isEmpty(this.L))
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(this.L);
          this.J = localJSONObject.optString("troopUin");
          this.K = localJSONObject.optString("memberUin");
          if ((!TextUtils.isEmpty(this.J)) && (!TextUtils.isEmpty(this.K))) {
            this.I = true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          QLog.d("FriendProfileMoreInfoActivity", 1, localJSONException.getMessage());
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileMoreInfoActivity", 2, String.format("openView options: %s", new Object[] { this.L }));
        }
      }
      this.p = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      this.q = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      this.G = new ProfileConfig(this.app, null);
      addObserver(this.M);
      addObserver(this.aw);
      addObserver(this.ay);
      this.app.registObserver(this.ax);
      this.q.a(this);
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.N, (IntentFilter)localObject);
      localObject = (LinearLayout)super.findViewById(2131445146);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        ((LinearLayout)localObject).setFitsSystemWindows(true);
        ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      f();
      this.j = ((AllInOne)getIntent().getParcelableExtra("AllInOne"));
      this.k = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
      if (this.j == null) {
        this.j = new AllInOne(this.app.getCurrentUin(), 0);
      }
      if (this.k == null) {
        this.k = BusinessCardUtils.a(this.app);
      }
      ThreadManager.post(new FriendProfileMoreInfoActivity.6(this), 5, null, true);
      if (!this.I)
      {
        a(((BusinessCardManager)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).b());
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
    Object localObject = this.G;
    if (localObject != null)
    {
      ((ProfileConfig)localObject).destroy();
      this.G = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((ConditionSearchManager)localObject).b(this);
      this.q.d(this.az);
      this.q = null;
    }
    if (!this.w)
    {
      removeObserver(this.M);
      removeObserver(this.aw);
    }
    removeObserver(this.ay);
    this.app.unRegistObserver(this.ax);
    try
    {
      unregisterReceiver(this.N);
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
      paramString = getString(2131892784);
      bool = true;
    }
    a(this.ag, paramString, bool);
    View localView = this.af;
    TextView localTextView = this.ag;
    String str = getString(2131892785);
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
    this.i.setText(str);
    this.i.setHint(2131892777);
    a(this.ah, this.i, getString(2131892778), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = this.H;
    if (localBundle != null) {
      localIntent.putExtra("result", localBundle);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void g(String paramString)
  {
    this.at = paramString;
    int i1;
    String str1;
    if (TextUtils.isEmpty(paramString))
    {
      i1 = 1;
      str1 = getString(2131892808);
    }
    else
    {
      i1 = 0;
      str1 = paramString;
    }
    a(this.aj, str1, TextUtils.isEmpty(paramString));
    paramString = this.ai;
    TextView localTextView = this.aj;
    String str2 = getString(2131892809);
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
    int i1 = this.t;
    if ((i1 == 1) || (i1 == 2))
    {
      l();
      QQToast.makeText(this, 2131888003, 0).show(getTitleBarHeight());
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.c != null) {
        this.c.requestFocus();
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
    LinearLayout localLinearLayout = this.c;
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
    case 2131448028: 
      localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.J);
      if (localObject != null) {
        if ((!((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.j.uin, this.app.getCurrentAccountUin())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
          }
        }
        else {
          a(this.J, this.j.uin, 1011);
        }
      }
      break;
    case 2131446002: 
      h();
      ReportController.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
      break;
    case 2131445737: 
      i();
      break;
    case 2131445305: 
      b(2);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      break;
    case 2131445303: 
      b(3);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
      break;
    case 2131445301: 
      b(1);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      break;
    case 2131445299: 
      b(4);
      d();
      break;
    case 2131440679: 
      localObject = new Intent(this, JobSelectionActivity.class);
      ((Intent)localObject).putExtra("param_id", this.as);
      startActivityForResult((Intent)localObject, 1004);
      break;
    case 2131440008: 
      localObject = new Intent(this, EditActivity.class);
      ((Intent)localObject).putExtra("title", 2131892809).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131892808).putExtra("multiLine", true).putExtra("current", this.at).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult((Intent)localObject, 1007);
      break;
    case 2131437694: 
      d(1);
      break;
    case 2131436180: 
      e();
      break;
    case 2131435092: 
      d(2);
      break;
    case 2131432381: 
      ReportController.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
      if ((paramView.getTag() instanceof SchoolInfo))
      {
        localObject = (SchoolInfo)paramView.getTag();
        h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((SchoolInfo)localObject).b), Integer.valueOf(((SchoolInfo)localObject).a) }));
      }
      else if ((paramView.getTag() instanceof Card))
      {
        h("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
      }
      break;
    case 2131429531: 
      localObject = new Intent(this, AgeSelectionActivity.class);
      ((Intent)localObject).putExtra("param_birthday", this.ap);
      startActivityForResult((Intent)localObject, 1003);
      break;
    case 2131429023: 
      localObject = new Intent(this, AvatarPendantActivity.class);
      ((Intent)localObject).putExtra("AllInOne", this.j);
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
      if (paramView == this.f)
      {
        if (this.l.b)
        {
          paramView = this.f.getText().toString();
          if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty(paramView.trim()))) {
            QQToast.makeText(this, HardCodeUtil.a(2131902875), 0).show(getTitleBarHeight());
          }
        }
      }
      else if ((paramView == this.i) && (this.o.b))
      {
        paramView = this.i.getText().toString();
        Matcher localMatcher = SearchBaseActivity.C.matcher(paramView);
        if ((!TextUtils.isEmpty(paramView)) && (!localMatcher.matches())) {
          QQToast.makeText(this, HardCodeUtil.a(2131902899), 0).show(getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */