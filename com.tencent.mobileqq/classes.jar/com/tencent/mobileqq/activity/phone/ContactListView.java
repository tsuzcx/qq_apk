package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener, DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  private static final String[] K = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private static final String u = HardCodeUtil.a(2131900648);
  private View A;
  private View B;
  private EditText C;
  private IFaceDecoder D;
  private Bitmap E;
  private HashMap<String, Integer> F;
  private IndexView G;
  private TextView H;
  private ImageView I;
  private int J = 0;
  private boolean L = false;
  private FriendObserver M = new ContactListView.1(this);
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack N = new ContactListView.5(this);
  List<List<PhoneContact>> l;
  ArrayList<PhoneContact> m;
  int n;
  ContactListView.ContactGroupAdapter o;
  List<PhoneContact> p;
  ContactBindedAdapter q;
  ContactListView.UiHandler r;
  ActionSheet s;
  public ForwardBaseOption t;
  private ContactListView.ContactListObserver v;
  private List<String> w;
  private Handler x;
  private XListView y;
  private View z;
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setContentView(2131625564);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "ContactListView()");
    }
    this.r = new ContactListView.UiHandler(this);
    this.x = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.y = ((XListView)findViewById(2131431261));
    this.y.setOnScrollListener(this);
    this.G = ((IndexView)findViewById(2131435677));
  }
  
  private void a(View paramView)
  {
    paramView = (ContactListView.Holder)paramView.getTag();
    Object localObject1 = paramView.i;
    int i = paramView.h;
    Object localObject2 = this.a;
    if (i == 2) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
    if (i == 2)
    {
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).m(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ((Friends)localObject1).getFriendNickWithAlias());
          if ((CrmUtils.a(((Friends)localObject1).cSpecialFlag)) || (QidianManager.b(((Friends)localObject1).cSpecialFlag))) {
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
      return;
    }
    if (i == 3)
    {
      paramView = ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramView.nationCode);
      ((StringBuilder)localObject2).append(paramView.mobileNo);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("entrance", 3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((PhoneContact)localObject1).nationCode);
      localStringBuilder.append(((PhoneContact)localObject1).mobileCode);
      paramView.putExtra("uin", localStringBuilder.toString());
      paramView.putExtra("phonenum", (String)localObject2);
      paramView.putExtra("uintype", 1006);
      paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((PhoneContact)localObject1).nationCode);
      ((StringBuilder)localObject2).append(((PhoneContact)localObject1).mobileCode);
      localObject2 = new AllInOne(((StringBuilder)localObject2).toString(), 31);
      ((AllInOne)localObject2).contactArray = new ArrayList();
      ((AllInOne)localObject2).nickname = ((PhoneContact)localObject1).nickName;
      ((AllInOne)localObject2).contactName = ((PhoneContact)localObject1).name;
      ((AllInOne)localObject2).contactArray.add(new ProfileContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
      ((AllInOne)localObject2).chatAbility = ((PhoneContact)localObject1).ability;
      ((AllInOne)localObject2).lastActivity = 3;
      ((AllInOne)localObject2).profileEntryType = 59;
      paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
      a(paramView);
    }
  }
  
  private void a(ContactListView.Holder paramHolder, String paramString, int paramInt)
  {
    Bitmap localBitmap2 = this.D.getBitmapFromCache(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.D.isPausing()) {
        this.D.requestDecodeFace(paramString, paramInt, false);
      }
      if (this.E == null) {
        this.E = ImageUtil.k();
      }
      localBitmap1 = this.E;
    }
    paramHolder.b.setImageBitmap(localBitmap1);
    paramHolder.a = paramString;
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    if (this.J == 0)
    {
      int j = paramListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        ContactListView.Holder localHolder = (ContactListView.Holder)paramListView.getChildAt(i).getTag();
        if ((localHolder != null) && (paramString.equals(localHolder.a)))
        {
          localHolder.b.setImageBitmap(paramBitmap);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() tipsType ");
      localStringBuilder.append(paramQQPimTipsInfo.a);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() tipsString ");
      localStringBuilder.append(paramQQPimTipsInfo.b);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() repeatContactNum ");
      localStringBuilder.append(paramQQPimTipsInfo.d);
      QLog.i("ContactListView", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshBlueBarTipsUi() mTextViewQQPimTips ");
      localStringBuilder.append(this.H.getClass().hashCode());
      QLog.i("ContactListView", 2, localStringBuilder.toString());
    }
    if (paramQQPimTipsInfo.a == 0)
    {
      this.I.setVisibility(4);
      this.H.setText("");
    }
    else if ((paramQQPimTipsInfo.a == 1) || (paramQQPimTipsInfo.a == 2) || (paramQQPimTipsInfo.a == 4))
    {
      if (TextUtils.isEmpty(paramQQPimTipsInfo.b)) {
        this.H.setText("");
      } else {
        this.H.setText(paramQQPimTipsInfo.b);
      }
      if (paramQQPimTipsInfo.c > 0) {
        this.I.setVisibility(0);
      } else {
        this.I.setVisibility(4);
      }
    }
    if (paramQQPimTipsInfo.a == 3)
    {
      a(true, paramQQPimTipsInfo.b);
      return;
    }
    a(false, null);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "initBlueTipsBar()");
    }
    View localView = null;
    if (paramBoolean) {
      localView = b(paramString);
    }
    if (localView != null)
    {
      this.y.addHeaderView(localView);
      paramString = this.A;
      if (paramString != null)
      {
        this.y.removeHeaderView(paramString);
        this.y.addHeaderView(this.A);
      }
    }
  }
  
  private View b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateMergeContactsView()");
    }
    ReportController.b(this.a, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
    if (this.B == null) {
      this.B = LayoutInflater.from(getContext()).inflate(2131629358, this.y, false);
    }
    this.B.findViewById(2131447406).setOnClickListener(new ContactListView.3(this));
    this.B.findViewById(2131447412).setOnClickListener(new ContactListView.4(this));
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)this.B.findViewById(2131447415)).setText(paramString);
    }
    return this.B;
  }
  
  private void b(View paramView)
  {
    Object localObject = (ContactListView.Holder)paramView.getTag();
    QQAppInterface localQQAppInterface = this.a;
    if (((ContactListView.Holder)localObject).h == 2) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
    paramView = ((ContactListView.Holder)localObject).i;
    int i = ((ContactListView.Holder)localObject).h;
    if ((i != 2) && (i == 3)) {
      i = 1006;
    } else {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramView.nationCode);
    ((StringBuilder)localObject).append(paramView.mobileCode);
    localObject = ((StringBuilder)localObject).toString();
    ChatActivityUtils.a(this.a, getContext(), i, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "from_internal");
    ReportController.b(this.a, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
  }
  
  private void c(View paramView)
  {
    ReportController.b(this.a, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    Object localObject = ((ContactListView.Holder)paramView.getTag()).i;
    IAddFriendApi localIAddFriendApi = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((PhoneContact)localObject).nationCode);
    localStringBuilder.append(((PhoneContact)localObject).mobileCode);
    localObject = localIAddFriendApi.startAddFriend(localContext, 2, localStringBuilder.toString(), null, 3006, 3, ((PhoneContact)localObject).name, null, null, HardCodeUtil.a(2131900667), null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.b, (Intent)localObject);
    if (this.c != 3) {
      return;
    }
    paramView = paramView.getTag(2131442296);
    if (paramView != null)
    {
      int i = ((Integer)paramView).intValue();
      if (i < 5)
      {
        paramView = null;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                if (i != 4) {
                  break label237;
                }
              }
            }
          }
        }
        for (;;)
        {
          paramView = "0X80068BB";
          continue;
          paramView = "0X80068BA";
          continue;
          paramView = "0X80068B9";
          continue;
          paramView = "0X80068B8";
          continue;
          paramView = "0X80068B7";
        }
        label237:
        if (paramView != null) {
          ReportController.b(this.a, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    Object localObject1 = (ContactListView.Holder)paramView.getTag();
    if (localObject1 != null)
    {
      if (((ContactListView.Holder)localObject1).i == null) {
        return;
      }
      PhoneContact localPhoneContact = ((ContactListView.Holder)localObject1).i;
      int i = ((ContactListView.Holder)localObject1).h;
      Object localObject2;
      if (this.c == 2)
      {
        boolean bool = this.t instanceof ForwardShareCardOption;
        if ((i == 2) && (!bool))
        {
          paramView = new Bundle();
          paramView.putString("uin", localPhoneContact.uin);
          paramView.putInt("uintype", 0);
          paramView.putString("uinname", localPhoneContact.name);
          this.b.getIntent().putExtras(paramView);
          this.t.a(ForwardAbility.ForwardAbilityType.c.intValue(), paramView);
        }
        else if (i == 3)
        {
          bool = true;
        }
        if (bool)
        {
          localObject2 = new Bundle();
          localObject1 = localPhoneContact.mobileCode;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramView = localPhoneContact.mobileNo;
          }
          else
          {
            i = ((String)localObject1).indexOf("|");
            paramView = (View)localObject1;
            if (i > -1) {
              paramView = ((String)localObject1).substring(0, i);
            }
          }
          ((Bundle)localObject2).putBoolean("bindContact", TextUtils.isEmpty(localPhoneContact.uin) ^ true);
          ((Bundle)localObject2).putString("uin", paramView);
          ((Bundle)localObject2).putInt("uintype", 1006);
          ((Bundle)localObject2).putString("uinname", localPhoneContact.name);
          this.b.getIntent().putExtras((Bundle)localObject2);
          this.t.a(ForwardAbility.ForwardAbilityType.i.intValue(), (Bundle)localObject2);
        }
        return;
      }
      if (this.c == 0)
      {
        localObject1 = this.a;
        if (i == 2) {
          paramView = "0";
        } else {
          paramView = "1";
        }
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
      }
      else if (this.c == 3)
      {
        ReportController.b(this.a, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
        paramView = paramView.getTag(2131442296);
        if (paramView != null)
        {
          int j = ((Integer)paramView).intValue();
          if (j < 5)
          {
            paramView = null;
            if (j != 0) {
              if (j != 1) {
                if (j != 2) {
                  if (j != 3) {
                    if (j != 4) {
                      break label464;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              paramView = "0X80068B6";
              continue;
              paramView = "0X80068B5";
              continue;
              paramView = "0X80068B4";
              continue;
              paramView = "0X80068B3";
              continue;
              paramView = "0X80068B2";
            }
            label464:
            if (paramView != null) {
              ReportController.b(this.a, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
        }
      }
      paramView = getContext();
      localObject1 = new Intent(paramView, QCallDetailActivity.class);
      ((Intent)localObject1).putExtra("contactID", localPhoneContact.contactID);
      if (i != 2)
      {
        if (i != 3)
        {
          ((Intent)localObject1).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject1).putExtra("uintype", 56938);
          ((Intent)localObject1).putExtra("uinname", localPhoneContact.name);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localPhoneContact.nationCode);
          ((StringBuilder)localObject2).append(localPhoneContact.mobileCode);
          ((Intent)localObject1).putExtra("uin", ((StringBuilder)localObject2).toString());
          ((Intent)localObject1).putExtra("uintype", 1006);
          ((Intent)localObject1).putExtra("uinname", localPhoneContact.name);
        }
      }
      else
      {
        ((Intent)localObject1).putExtra("uin", localPhoneContact.uin);
        ((Intent)localObject1).putExtra("uintype", 0);
        ((Intent)localObject1).putExtra("uinname", localPhoneContact.nickName);
      }
      paramView.startActivity((Intent)localObject1);
    }
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void n()
  {
    if (this.c == 3) {
      ReportController.b(this.a, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    this.a.getApplication();
    int i = 0;
    int j = 21001;
    if ((this.c != 0) && (this.c != 5))
    {
      if (this.c == 2)
      {
        if ((this.t instanceof ForwardShareCardOption)) {
          i = 32768;
        } else {
          i = 256;
        }
        j = 21006;
      }
      else if (this.c == 3)
      {
        j = 21005;
        i = 256;
      }
    }
    else
    {
      i = 768;
      j = 21004;
    }
    ContactSearchComponentActivity.a(this.b, null, 3, i, j);
  }
  
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStart()");
    }
    this.a.setHandler(ContactListView.class, this.r);
    if (this.c == 2) {
      this.h.setText(HardCodeUtil.a(2131900664));
    } else if ((this.c != 0) && (this.c != 5))
    {
      if (this.c == 3) {
        this.h.setText(HardCodeUtil.a(2131900650));
      }
    }
    else {
      this.h.setText(HardCodeUtil.a(2131900666));
    }
    if (this.v == null)
    {
      this.v = new ContactListView.ContactListObserver(this, null);
      this.a.registObserver(this.v);
    }
    this.a.addObserver(this.M);
    k();
    int i = this.e.getSelfBindState();
    if ((this.c == 2) && ((this.t instanceof ForwardShareCardOption)))
    {
      this.g.setVisibility(8);
    }
    else
    {
      this.g.setOnClickListener(this);
      TextView localTextView = this.g;
      boolean bool;
      if (i != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localTextView.setEnabled(bool);
    }
    this.D.resume();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onActivityResult() ");
    }
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 2)
      {
        localObject = new Intent(getContext(), BindNumberActivity.class);
        ((Intent)localObject).putExtra("kNeedUnbind", true);
        a((Intent)localObject);
      }
      else if (paramInt2 == 0)
      {
        int i = this.e.getSelfBindState();
        if ((i == 1) || (i == 5)) {
          a(new Intent(getContext(), PhoneLaunchActivity.class));
        }
      }
      else if (paramInt2 == 4002)
      {
        g();
      }
      else
      {
        a(new Intent(getContext(), PhoneLaunchActivity.class));
      }
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21005)
      {
        if (paramInt1 != 21006) {
          return;
        }
        SearchUtil.a(paramIntent, this.t);
        return;
      }
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("contactSearchResultUin");
        paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
        String str1 = paramIntent.getStringExtra("contactSearchResultName");
        long l1 = paramIntent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
        String str2 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
        String str3 = paramIntent.getStringExtra("contactSearchResultPhoneContactNationCode");
        paramInt2 = paramIntent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
        paramIntent = null;
        if (paramInt1 == 1006)
        {
          if (l1 == 3L) {
            paramInt1 = 32;
          } else {
            paramInt1 = 31;
          }
          paramIntent = new AllInOne((String)localObject, paramInt1);
          paramIntent.contactArray = new ArrayList();
          paramIntent.contactName = str1;
          paramIntent.contactArray.add(new ProfileContactInfo(str1, str2, str3));
          paramIntent.chatAbility = paramInt2;
          paramIntent.lastActivity = 3;
        }
        else if (paramInt1 == 0)
        {
          paramIntent = new AllInOne((String)localObject, 1);
        }
        ProfileUtils.openProfileCard(this.b, paramIntent);
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onCreate()");
    }
    int i = this.e.getSelfBindState();
    boolean bool;
    if ((this.c == 2) && ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)))
    {
      bool = false;
    }
    else
    {
      this.z = LayoutInflater.from(getContext()).inflate(2131629215, this.y, false);
      this.z.findViewById(2131429816).setVisibility(8);
      this.C = ((EditText)this.z.findViewById(2131432634));
      this.C.setFocusableInTouchMode(false);
      this.C.setCursorVisible(false);
      this.C.setOnClickListener(this);
      this.y.addHeaderView(this.z);
      bool = true;
    }
    if ((this.c == 2) && (this.b != null)) {
      this.t = ForwardOptionBuilder.a(this.b.getIntent(), this.a, this.b);
    }
    if ((this.c != 0) && (this.c != 2) && (this.c != 5))
    {
      this.q = new ContactBindedAdapter(getContext(), this.a, this.y, this.p);
      this.y.setAdapter(this.q);
      this.G.setVisibility(8);
    }
    else
    {
      paramIntent = this.z;
      if (paramIntent != null) {
        paramIntent.setPadding(0, 0, 40, 0);
      }
    }
    if (this.b != null)
    {
      paramIntent = this.b.getIntent().getStringArrayExtra("key_reserved_mobile");
      if ((paramIntent != null) && (paramIntent.length > 0)) {
        this.w = Arrays.asList(paramIntent);
      }
    }
    this.D = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
    this.D.setDecodeTaskCompletionListener(this);
    this.G.setIndex(K, bool, false, false);
    this.G.setOnIndexChangedListener(this);
    this.e.checkUpdateBindStateAndListIgnoreBindState(true, false, 19);
  }
  
  void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    ContactListView.Holder localHolder = (ContactListView.Holder)paramView.getTag();
    if (paramBoolean) {
      localHolder.d.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
    } else {
      localHolder.d.setText(paramPhoneContact.name);
    }
    localHolder.a = null;
    localHolder.i = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      localHolder.b.setVisibility(0);
      localHolder.c.setVisibility(0);
      localHolder.f.setVisibility(8);
      localHolder.g.setVisibility(8);
      localHolder.h = 1;
      localHolder.b.setImageResource(2130843087);
      paramPhoneContact = ContactUtils.b(paramPhoneContact.name);
      localHolder.c.setText(paramPhoneContact);
      if (ContactUtils.a(paramPhoneContact)) {
        localHolder.c.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299846));
      } else {
        localHolder.c.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299847));
      }
      localHolder.e.setVisibility(8);
      return;
    }
    localHolder.b.setVisibility(0);
    localHolder.c.setVisibility(8);
    if ((this.c == 0) || (this.c == 5))
    {
      localHolder.f.setVisibility(8);
      localHolder.g.setVisibility(0);
    }
    localHolder.f.setTag(localHolder);
    localHolder.g.setTag(localHolder);
    Object localObject = localHolder.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131900647));
    localStringBuilder.append(paramPhoneContact.name);
    localStringBuilder.append(HardCodeUtil.a(2131900656));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    localObject = localHolder.g;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131900652));
    localStringBuilder.append(paramPhoneContact.name);
    localStringBuilder.append(HardCodeUtil.a(2131900654));
    ((Button)localObject).setContentDescription(localStringBuilder.toString());
    if (!paramPhoneContact.uin.equals("0"))
    {
      localHolder.h = 2;
      a(localHolder, paramPhoneContact.uin, 1);
      localHolder.e.setVisibility(8);
    }
    else
    {
      localHolder.h = 3;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramPhoneContact.nationCode);
      ((StringBuilder)localObject).append(paramPhoneContact.mobileCode);
      a(localHolder, ((StringBuilder)localObject).toString(), 11);
      if (this.c == 5)
      {
        if (paramPhoneContact.isHiden)
        {
          localHolder.e.setVisibility(0);
          if (AppSetting.e)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramPhoneContact.name);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131900669));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localHolder.e.setVisibility(8);
          if (AppSetting.e)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramPhoneContact.name);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131900655));
            paramView.setContentDescription(((StringBuilder)localObject).toString());
          }
        }
      }
      else {
        localHolder.e.setVisibility(8);
      }
    }
    if (localHolder.h != 2) {
      localHolder.g.setVisibility(8);
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onResume()");
    }
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.e.getSelfBindState() != 9)
    {
      if (NetworkUtil.isNetSupport(getContext()))
      {
        if (this.e.isAutoUploadContacts())
        {
          a(2131916272, 0L, false);
          return;
        }
        this.e.checkUpdateBindStateAndListIgnoreBindState(true, true, 20);
        i();
        return;
      }
      a(2131892157, 3000L);
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStop()");
    }
    this.D.pause();
    this.D.destory();
    this.a.removeHandler(ContactListView.class);
    j();
    h();
    ActionSheet localActionSheet = this.s;
    if (localActionSheet != null)
    {
      localActionSheet.cancel();
      this.s = null;
    }
    if (this.v != null)
    {
      this.a.unRegistObserver(this.v);
      this.v = null;
    }
    this.a.removeObserver(this.M);
    super.d();
  }
  
  protected void e()
  {
    QQPimGetTipsInfoIPC.a().b();
    Object localObject = this.t;
    if (localObject != null) {
      ((ForwardBaseOption)localObject).ad();
    }
    localObject = this.x;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(7);
    }
    super.e();
  }
  
  void getContactGroupData()
  {
    boolean bool;
    if ((this.c == 2) && ((this.t instanceof ForwardShareCardOption))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((this.c != 5) && (!bool))
    {
      this.l = this.e.getContactListForDisplay();
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.e.getContactListForContactListView(bool));
      localArrayList.add(new ArrayList());
      this.l = localArrayList;
    }
    l();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 7)
    {
      this.x.removeMessages(7);
      paramMessage = new ArrayList();
      paramMessage.add(this.e.getContactListForContactListView(this.e.loadContactFromPhoneWithoutCaches(), true));
      paramMessage.add(new ArrayList());
      this.l = paramMessage;
      this.r.sendEmptyMessage(8);
    }
    return false;
  }
  
  void k()
  {
    int i;
    StringBuilder localStringBuilder;
    if ((this.c != 0) && (this.c != 2) && (this.c != 5))
    {
      if (this.c == 3)
      {
        i = this.e.loadContactFriendList(this.w);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load contact friend result: ");
          localStringBuilder.append(i);
          QLog.d("ContactListView", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      i = this.e.getSelfBindState();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("the load contact mode is retype=");
        localStringBuilder.append(this.c);
        localStringBuilder.append(", state=");
        localStringBuilder.append(i);
        QLog.d("ContactListView", 2, localStringBuilder.toString());
      }
      if ((i != 1) && (i != 2) && (i != 6) && (i != 7) && (i != 3))
      {
        getContactGroupData();
        return;
      }
      this.x.sendEmptyMessage(7);
    }
  }
  
  void l()
  {
    if (this.o == null)
    {
      this.o = new ContactListView.ContactGroupAdapter(this, null);
      this.y.setAdapter(this.o);
    }
    if (this.l == null)
    {
      this.r.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.F = new LinkedHashMap();
    Object localObject1 = K;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      this.F.put(localObject2, Integer.valueOf(0));
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)this.l.get(0)).iterator();
    Object localObject3;
    for (Object localObject2 = "*"; localIterator.hasNext(); localObject2 = localObject3)
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.F.get(localObject3) == null)
      {
        localPhoneContact.pinyinFirst = "#";
        localObject1 = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      localObject2 = this.F;
      ((HashMap)localObject2).put(localObject1, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject1)).intValue() + 1));
    }
    localObject1 = this.F.keySet().iterator();
    for (i = 0; ((Iterator)localObject1).hasNext(); i = j)
    {
      localObject2 = (String)((Iterator)localObject1).next();
      j = ((Integer)this.F.get(localObject2)).intValue();
      if (j != 0) {
        j = j + i + 1;
      } else {
        j = i;
      }
      this.F.put(localObject2, Integer.valueOf(i));
    }
    if (this.c == 0)
    {
      localObject1 = (List)this.l.get(1);
      if (((List)localObject1).size() > 0)
      {
        this.F.put(u, Integer.valueOf(localArrayList.size()));
        localArrayList.add(null);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)localObject1).next();
          ((PhoneContact)localObject2).pinyinFirst = u;
          localArrayList.add(localObject2);
        }
      }
    }
    this.m = localArrayList;
    this.n = this.m.size();
    if (this.n > 10) {
      this.G.setVisibility(0);
    } else {
      this.G.setVisibility(8);
    }
    this.o.notifyDataSetChanged();
  }
  
  View m()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131625565, null);
    ContactListView.Holder localHolder = new ContactListView.Holder(null);
    localHolder.b = ((ImageView)localView.findViewById(2131440526));
    localHolder.c = ((TextView)localView.findViewById(2131440527));
    localHolder.e = ((ImageView)localView.findViewById(2131440525));
    localHolder.d = ((TextView)localView.findViewById(2131439134));
    localHolder.f = ((Button)localView.findViewById(2131447866));
    localHolder.f.setOnClickListener(this);
    localHolder.g = ((Button)localView.findViewById(2131447865));
    localHolder.g.setOnClickListener(this);
    localHolder.j = ((Button)localView.findViewById(2131427784));
    localHolder.j.setOnClickListener(this);
    localHolder.k = ((TextView)localView.findViewById(2131427776));
    localHolder.l = localView.findViewById(2131444792);
    if (this.c == 3)
    {
      localHolder.f.setVisibility(8);
      localHolder.g.setVisibility(8);
      localHolder.l.setVisibility(8);
    }
    else
    {
      localHolder.j.setVisibility(8);
      localHolder.k.setVisibility(8);
    }
    localView.setTag(localHolder);
    return localView;
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      break;
    case 2131447866: 
      a(paramView);
      break;
    case 2131447865: 
      b(paramView);
      break;
    case 2131436211: 
      if (this.c == 2)
      {
        g();
      }
      else
      {
        Intent localIntent1 = this.b.getIntent();
        Intent localIntent2 = new Intent(getContext(), SettingActivity2.class);
        if (localIntent1.hasExtra("kSrouce")) {
          localIntent2.putExtra("kSrouce", localIntent1.getIntExtra("kSrouce", 6));
        }
        a(localIntent2, 1);
        ReportController.b(this.a, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      }
      break;
    case 2131432634: 
      n();
      break;
    case 2131427784: 
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      a(this.y, paramString, paramBitmap);
    }
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.y.setSelection(0);
      return;
    }
    XListView localXListView = this.y;
    localXListView.setSelection(localXListView.getHeaderViewsCount() + ((Integer)this.F.get(paramString)).intValue());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.J = paramInt;
    if (paramInt != 0)
    {
      this.D.cancelPendingRequests();
      this.D.pause();
      return;
    }
    if (this.D.isPausing()) {
      this.D.resume();
    }
    int j = this.y.getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      paramAbsListView = (ContactListView.Holder)this.y.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.a)))
      {
        int i;
        if (paramAbsListView.h == 3) {
          i = 11;
        } else {
          i = 1;
        }
        Bitmap localBitmap = this.D.getBitmapFromCache(i, paramAbsListView.a);
        if (localBitmap == null) {
          this.D.requestDecodeFace(paramAbsListView.a, i, false);
        } else {
          paramAbsListView.b.setImageBitmap(localBitmap);
        }
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */