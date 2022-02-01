package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.SelectedListener;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.util.ContactBindUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.StringAddition;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ContactBindedActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener, ContactBindedAdapter.SelectedListener, INewFriendListener, ContactSearchResultPresenter.OnActionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  public static final String[] l = { "$", "★", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  public static final String[] m = { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private View A;
  private EditText B;
  private QQCustomDialog C = null;
  private IFaceDecoder D;
  private Bitmap E;
  private ContactSearchFragment F = null;
  private ContactBindedActivity.AddedAdapter G;
  private ArrayList<PhoneContact> H = new ArrayList();
  private boolean I = false;
  private ContactBindedActivity.PinyinCharComparator J = new ContactBindedActivity.PinyinCharComparator(null);
  private int K = 1;
  private boolean L = false;
  private int M = -1;
  IndexView a;
  View b;
  TextView c = null;
  IPhoneContactService d;
  boolean e = false;
  public PhoneContact f = null;
  public int g = -1;
  public Handler h;
  public Handler i;
  public ArrayList<PhoneContact> j = null;
  protected boolean k = true;
  private PinnedDividerListView n;
  private View o;
  private TextView p;
  private ContactBindedAdapter q;
  private INewFriendService r;
  private View s;
  private CustomHorizontalScrollView t;
  private View u;
  private View v;
  private GridView w;
  private EditText x;
  private View y;
  private Button z;
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("check_permission_result");
    } else {
      paramIntent = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, String.format("startFromOther [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    paramIntent = BaseActivity.sTopActivity;
    if (paramIntent != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(paramIntent, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("kSrouce", paramInt1);
      paramQQAppInterface.putExtra("fromKeyForContactBind", paramInt2);
      paramIntent.startActivityForResult(paramQQAppInterface, 222);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startFromOther requestCode: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  starList:");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent((Context)localObject, ContactBindedActivity.class);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList(paramArrayList.size());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(((PhoneContact)paramArrayList.next()).mobileNo);
        }
        paramQQAppInterface.putExtra("isBindAction", localArrayList);
      }
      paramQQAppInterface.putExtra("from_type", 1);
      ((Activity)localObject).startActivityForResult(paramQQAppInterface, paramInt);
    }
  }
  
  private void b(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.H.size() >= 100)
      {
        QQToast.makeText(this, 1, 2131888032, 0).show(getTitleBarHeight());
        paramBoolean = false;
      }
      else
      {
        this.H.add(paramPhoneContact);
      }
      this.x.setText("");
    }
    else
    {
      int i3 = -1;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.H.size()) {
          break;
        }
        if (TextUtils.equals(((PhoneContact)this.H.get(i1)).unifiedCode, paramPhoneContact.unifiedCode))
        {
          i2 = i1;
          break;
        }
        i1 += 1;
      }
      this.H.remove(i2);
    }
    this.q.a(paramPhoneContact, paramBoolean);
    paramPhoneContact = this.F;
    if (paramPhoneContact != null) {
      paramPhoneContact.e(this.H);
    }
    if (this.H.isEmpty()) {
      paramPhoneContact = getString(2131888030);
    } else {
      paramPhoneContact = getString(2131888031, new Object[] { Integer.valueOf(this.H.size()) });
    }
    this.z.setText(paramPhoneContact);
    this.z.setEnabled(this.H.isEmpty() ^ true);
    a(true);
  }
  
  private void b(boolean paramBoolean)
  {
    this.i.removeMessages(2);
    Handler localHandler = this.i;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(2, Boolean.valueOf(paramBoolean)), 100L);
  }
  
  private void c(boolean paramBoolean)
  {
    this.e ^= true;
    if (this.e)
    {
      this.leftView.setVisibility(8);
      this.s.setVisibility(0);
      this.y.setVisibility(0);
      if (this.H.isEmpty()) {
        localObject = getString(2131888030);
      } else {
        localObject = getString(2131888031, new Object[] { Integer.valueOf(this.H.size()) });
      }
      this.z.setText((CharSequence)localObject);
      this.n.removeHeaderView(this.A);
      if (this.F == null)
      {
        this.F = ContactSearchFragment.a(19, 524288, null, null, this);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131445416, this.F);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
    }
    else
    {
      this.leftView.setVisibility(0);
      this.v.setVisibility(8);
      this.s.setVisibility(8);
      this.n.addHeaderView(this.A);
      this.y.setVisibility(8);
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
    }
    if (paramBoolean)
    {
      this.H.clear();
      this.q.a.clear();
    }
    Object localObject = this.F;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).e(this.H);
    }
    this.z.setEnabled(this.H.isEmpty() ^ true);
    localObject = this.rightViewText;
    int i1;
    if (this.e) {
      i1 = 2131887648;
    } else {
      i1 = 2131888034;
    }
    ((TextView)localObject).setText(i1);
    this.G.notifyDataSetChanged();
    this.q.a(this.e);
    this.x.setText("");
    a(true);
  }
  
  private void e()
  {
    if (this.H.isEmpty()) {
      return;
    }
    int i1;
    Object localObject;
    if (this.H.size() == 1)
    {
      int i2;
      if (!((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
      {
        i1 = 3075;
        i2 = 1;
      }
      else
      {
        i1 = 3006;
        i2 = 13;
      }
      localObject = (PhoneContact)this.H.get(0);
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 2, ((PhoneContact)localObject).unifiedCode, null, i1, i2, ((PhoneContact)localObject).name, null, null, HardCodeUtil.a(2131898212), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 102);
      return;
    }
    if (this.H.size() <= 100)
    {
      if (!((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
        i1 = 3079;
      } else {
        i1 = 3078;
      }
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startMultiAddContact(this, this.H, i1, null, HardCodeUtil.a(2131898212), null, this.K);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 101);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramPhoneContact != null) {
      b(paramPhoneContact, paramBoolean);
    }
  }
  
  public void a(ContactBindedData paramContactBindedData)
  {
    if ((paramContactBindedData.d.size() <= 0) && (!this.I)) {
      this.b.setVisibility(0);
    } else {
      this.b.setVisibility(8);
    }
    if ((paramContactBindedData.d.size() > 10) && (!this.L) && (this.K == 1))
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
      this.L = true;
    }
    if ((paramContactBindedData.d.size() <= 10) && (!this.I)) {
      this.a.setVisibility(8);
    } else {
      this.a.setVisibility(0);
    }
    this.q.a(paramContactBindedData);
    this.q.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    this.w.setNumColumns(this.H.size());
    ViewGroup.LayoutParams localLayoutParams = this.w.getLayoutParams();
    localLayoutParams.width = ((int)((this.H.size() * 40 + this.H.size() * 10) * this.mDensity));
    this.w.setLayoutParams(localLayoutParams);
    c();
    if (paramBoolean) {
      this.h.sendEmptyMessageDelayed(3, 200L);
    }
    this.G.notifyDataSetChanged();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    Object localObject = this.v;
    int i1;
    if (TextUtils.isEmpty(paramEditable)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    localObject = this.F;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).a(paramEditable);
    }
  }
  
  public void b()
  {
    b(false);
  }
  
  public void bR_()
  {
    b(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.mDensity * 40.0F));
    int i2 = (int)(this.mDensity * 10.0F);
    int i1;
    if (this.H.size() > 0)
    {
      if (this.H.size() < 5) {
        i1 = (int)((this.H.size() * 40 + this.H.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
      } else {
        i1 = (int)(this.mDensity * 230.0F);
      }
      this.u.setVisibility(8);
    }
    else
    {
      i1 = (int)(this.mDensity * 40.0F);
      this.u.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i1, 0, i2, 0);
    this.x.setLayoutParams(localLayoutParams);
  }
  
  public void d()
  {
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      localTextView.clearAnimation();
      this.c.setVisibility(8);
      this.c = null;
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      if (paramIntent.hasExtra("result"))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("result");
        if (!paramIntent.isEmpty())
        {
          Object localObject2 = new ArrayList();
          Object localObject3 = new ArrayList();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          Object localObject4 = paramIntent.iterator();
          Object localObject5;
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (AddBatchPhoneFriendResult)((Iterator)localObject4).next();
            if (((AddBatchPhoneFriendResult)localObject5).sendResult == 0)
            {
              ((FriendsManager)localObject1).c(((AddBatchPhoneFriendResult)localObject5).mobile, true);
              ((List)localObject2).add(localObject5);
            }
            else if (((AddBatchPhoneFriendResult)localObject5).sendResult == 37)
            {
              localArrayList1.add(localObject5);
            }
            else if ((((AddBatchPhoneFriendResult)localObject5).sendResult != 32) && (((AddBatchPhoneFriendResult)localObject5).sendResult != 33))
            {
              if (((AddBatchPhoneFriendResult)localObject5).allowType == 2) {
                ((List)localObject3).add(localObject5);
              }
            }
            else
            {
              localArrayList2.add(localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            paramInt1 = paramIntent.size();
            paramInt2 = ((List)localObject2).size();
            int i1 = ((List)localObject3).size();
            int i2 = localArrayList1.size();
            int i3 = localArrayList2.size();
            paramIntent = new StringBuilder();
            paramIntent.append("doOnActivityResult, adds=");
            paramIntent.append(((List)localObject2).size());
            paramIntent.append(", needAnswers=");
            paramIntent.append(((List)localObject3).size());
            paramIntent.append(", security anti=");
            paramIntent.append(localArrayList1.size());
            paramIntent.append(", upToLimits=");
            paramIntent.append(localArrayList2.size());
            paramIntent.append(", others=");
            paramIntent.append(paramInt1 - paramInt2 - i1 - i2 - i3);
            QLog.d("IphoneTitleBarActivity", 2, paramIntent.toString());
          }
          localObject4 = new StringBuilder();
          if (!localArrayList1.isEmpty())
          {
            paramIntent = HardCodeUtil.a(2131900626);
            ((StringBuilder)localObject4).append("部分好友添加失败，请稍后再试。");
          }
          else if (!localArrayList2.isEmpty())
          {
            paramIntent = HardCodeUtil.a(2131900628);
            ((StringBuilder)localObject4).append("好友已达上限，部分好友未添加。");
          }
          else if (!((List)localObject3).isEmpty())
          {
            localObject1 = getString(2131888033);
            Object localObject6;
            if (((List)localObject3).size() == 1)
            {
              localObject5 = (AddBatchPhoneFriendResult)((List)localObject3).get(0);
              localObject6 = this.H.iterator();
              do
              {
                paramIntent = (Intent)localObject1;
                if (!((Iterator)localObject6).hasNext()) {
                  break;
                }
                paramIntent = (PhoneContact)((Iterator)localObject6).next();
              } while (!((AddBatchPhoneFriendResult)localObject5).mobile.equals(paramIntent.unifiedCode));
              if (TextUtils.isEmpty(paramIntent.name)) {
                paramIntent = paramIntent.nickName;
              } else {
                paramIntent = paramIntent.name;
              }
              ((StringBuilder)localObject4).append(StringAddition.a(paramIntent, 12, true));
              ((StringBuilder)localObject4).append("的好友验证方式需要回答问题, 请单独添加。");
              paramIntent = (Intent)localObject1;
            }
            else
            {
              localObject5 = new ArrayList(((List)localObject3).size());
              paramIntent = ((List)localObject3).iterator();
              while (paramIntent.hasNext())
              {
                localObject6 = (AddBatchPhoneFriendResult)paramIntent.next();
                Iterator localIterator = this.H.iterator();
                while (localIterator.hasNext())
                {
                  PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
                  if (((AddBatchPhoneFriendResult)localObject6).mobile.equals(localPhoneContact.unifiedCode)) {
                    ((List)localObject5).add(localPhoneContact);
                  }
                }
              }
              Collections.sort((List)localObject5, this.J);
              paramInt1 = 0;
              while (paramInt1 < 2)
              {
                paramIntent = (PhoneContact)((List)localObject5).get(paramInt1);
                if (TextUtils.isEmpty(paramIntent.name)) {
                  paramIntent = paramIntent.nickName;
                } else {
                  paramIntent = paramIntent.name;
                }
                ((StringBuilder)localObject4).append(StringAddition.a(paramIntent, 12, true));
                if (paramInt1 == 0) {
                  ((StringBuilder)localObject4).append("、");
                }
                paramInt1 += 1;
              }
              ((StringBuilder)localObject4).append("等");
              ((StringBuilder)localObject4).append(((List)localObject3).size());
              ((StringBuilder)localObject4).append("位联系人的好友验证方式需要回答问题, 请单独添加。");
              if (this.K == 0)
              {
                ReportController.b(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
                paramIntent = (Intent)localObject1;
              }
              else
              {
                ReportController.b(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
                paramIntent = (Intent)localObject1;
              }
            }
          }
          else
          {
            paramIntent = "";
          }
          if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()) || (!((List)localObject3).isEmpty()))
          {
            this.C = DialogUtil.a(this, 230, paramIntent, ((StringBuilder)localObject4).toString(), new ContactBindedActivity.1(this), null);
            this.h.sendEmptyMessageDelayed(6, 900L);
          }
          ((List)localObject3).addAll((Collection)localObject2);
          if (this.j == null) {
            this.j = new ArrayList();
          }
          this.j.clear();
          paramIntent = ((List)localObject3).iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (AddBatchPhoneFriendResult)paramIntent.next();
            localObject2 = this.H.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (PhoneContact)((Iterator)localObject2).next();
              if (((AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject3).unifiedCode)) {
                this.j.add(localObject3);
              }
            }
          }
          this.a.setIndex(l);
          this.I = true;
        }
      }
      b(false);
      c(true);
      a(true);
      this.h.removeMessages(4);
      paramIntent = this.h;
      paramIntent.sendMessageDelayed(paramIntent.obtainMessage(4), 120L);
      return;
    }
    if ((paramInt1 == 102) && (paramInt2 == -1))
    {
      if (!this.H.isEmpty())
      {
        if (this.j == null) {
          this.j = new ArrayList();
        }
        this.j.clear();
        this.j.add(this.H.get(0));
        this.a.setIndex(l);
        this.I = true;
      }
      b(false);
      c(true);
      a(true);
      this.h.removeMessages(4);
      paramIntent = this.h;
      paramIntent.sendMessageDelayed(paramIntent.obtainMessage(4), 120L);
    }
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2131627365);
    paramBundle = getIntent();
    this.d = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, ""));
    Object localObject2;
    if (paramBundle != null)
    {
      localObject1 = (ArrayList)paramBundle.getSerializableExtra("isBindAction");
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        this.j = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.d.queryPhoneContactByMobile((String)localObject2);
        if (localObject2 != null)
        {
          this.j.add(localObject2);
          continue;
          this.j = this.d.generateRandomList();
        }
      }
      this.K = paramBundle.getIntExtra("from_type", 1);
      this.M = paramBundle.getIntExtra("from_page", -1);
      if (paramBundle.getIntExtra("fromKeyForContactBind", 0) == 1) {
        QQToast.makeText(BaseApplication.getContext(), 2, 2131892467, 0);
      }
    }
    this.h = new Handler(Looper.getMainLooper(), this);
    this.i = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mFlingHandler = new ContactBindedActivity.CustomFlingHandler(this, this);
    this.o = findViewById(2131445137);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.o.setFitsSystemWindows(true);
    }
    this.n = ((PinnedDividerListView)findViewById(2131446715));
    this.p = ((TextView)findViewById(2131436227));
    this.p.setVisibility(0);
    this.p.setText(2131892440);
    setTitle(getString(2131892440));
    setLeftViewName(2131887625);
    this.leftView.setOnClickListener(this);
    this.s = findViewById(2131445426);
    this.t = ((CustomHorizontalScrollView)this.s.findViewById(2131445370));
    this.u = this.s.findViewById(2131445381);
    this.x = ((EditText)this.s.findViewById(2131445437));
    this.x.addTextChangedListener(this);
    this.x.setOnKeyListener(this);
    this.w = ((GridView)this.s.findViewById(2131445556));
    AccessibilityUtil.a(this.t, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.t.setOverScrollMode(2);
      this.w.setOverScrollMode(2);
    }
    this.w.setSmoothScrollbarEnabled(false);
    this.G = new ContactBindedActivity.AddedAdapter(this, this);
    this.w.setAdapter(this.G);
    this.w.setOnItemClickListener(this);
    this.D = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.D.setDecodeTaskCompletionListener(this.G);
    this.E = ImageUtil.k();
    this.s.setOnClickListener(this);
    this.v = findViewById(2131445416);
    this.y = findViewById(2131433271);
    this.z = ((Button)findViewById(2131429937));
    this.z.setOnClickListener(this);
    this.A = LayoutInflater.from(this).inflate(2131629215, this.n, false);
    this.A.findViewById(2131429816).setVisibility(8);
    this.B = ((EditText)this.A.findViewById(2131432634));
    this.B.setFocusableInTouchMode(false);
    this.B.setCursorVisible(false);
    this.B.setOnClickListener(this);
    this.n.addHeaderView(this.A);
    this.a = ((IndexView)findViewById(2131435677));
    if (this.j == null) {
      this.a.setIndex(m);
    } else {
      this.a.setIndex(l);
    }
    this.a.setOnIndexChangedListener(this);
    this.b = findViewById(2131432507);
    this.s.setVisibility(8);
    paramBundle = this.d.getSelfBindInfo();
    if ((paramBundle != null) && (TextUtils.isEmpty(paramBundle.mobileNo)) && (paramBundle.noBindUploadContacts == true)) {
      ReportController.b(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
    }
    if (this.d.isBindedIgnoreUpload()) {
      ReportController.b(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
    }
    paramBundle = this.d.getContactBoundDataCache();
    if ((paramBundle == null) || (this.j == null)) {
      paramBundle = new ContactBindedData();
    }
    this.q = new ContactBindedAdapter(this, this.app, this.n, paramBundle.d);
    Object localObject1 = this.q;
    ((ContactBindedAdapter)localObject1).f = this;
    ((ContactBindedAdapter)localObject1).e = this.a;
    this.n.setAdapter((ListAdapter)localObject1);
    this.n.setOnScrollListener(this);
    if (!paramBundle.d.isEmpty())
    {
      localObject2 = this.j;
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject1 = paramBundle;
        if (!((ArrayList)localObject2).isEmpty())
        {
          long l1 = System.currentTimeMillis();
          paramBundle = ContactBindUtils.a(paramBundle.d, this.j, true);
          this.d.setContactBoundDataCache(paramBundle);
          long l2 = System.currentTimeMillis();
          localObject1 = paramBundle;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("constructHashStruct startTime=");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(", endTime=");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append(", cost=");
            ((StringBuilder)localObject1).append(String.valueOf(l2 - l1));
            QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject1).toString());
            localObject1 = paramBundle;
          }
        }
      }
      a((ContactBindedData)localObject1);
    }
    b(true);
    this.r = ((INewFriendService)this.app.getRuntimeService(INewFriendService.class));
    this.r.addListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    Object localObject = this.h;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      this.h.removeMessages(4);
      this.h.removeMessages(6);
    }
    localObject = this.i;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(2);
    }
    this.r.removeListener(this);
    localObject = this.q;
    if (localObject != null) {
      ((ContactBindedAdapter)localObject).d();
    }
    this.d.clearRecommendBadge();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void i_(int paramInt) {}
  
  public void onAction(View paramView)
  {
    paramView = (IContactSearchModel)paramView.getTag(2131449867);
    if (paramView == null) {
      return;
    }
    paramView = ((ContactSearchModelPhoneContact)paramView).a;
    if (paramView != null) {
      b(paramView, true);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.M == 1) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131448810: 
      d();
      break;
    case 2131436211: 
      d();
      if (!this.e) {
        if (this.K == 0) {
          ReportController.b(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
        }
      }
      c(true);
      break;
    case 2131436180: 
      if (this.M == 1) {
        ReportController.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
      }
      finish();
      break;
    case 2131432634: 
      d();
      ContactSearchComponentActivity.a(this, null, 17, 524288, 21001);
      break;
    case 2131429937: 
      if (!this.H.isEmpty())
      {
        int i3 = 0;
        int i1 = 0;
        int i2 = i3;
        if (!this.I)
        {
          Object localObject = this.j;
          i2 = i3;
          if (localObject != null)
          {
            i2 = i3;
            if (!((ArrayList)localObject).isEmpty())
            {
              localObject = this.j.iterator();
              for (;;)
              {
                i2 = i1;
                if (!((Iterator)localObject).hasNext()) {
                  break label350;
                }
                PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
                Iterator localIterator = this.H.iterator();
                if (localIterator.hasNext())
                {
                  if (!TextUtils.equals(((PhoneContact)localIterator.next()).unifiedCode, localPhoneContact.unifiedCode)) {
                    break;
                  }
                  i1 += 1;
                }
              }
            }
          }
        }
        label350:
        if (this.K == 0)
        {
          ReportController.b(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.H.size()), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(i2), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.H.size() - i2), "", "", "");
        }
        else
        {
          ReportController.b(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.H.size()), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(i2), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.H.size() - i2), "", "", "");
        }
      }
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.n.setSelection(0);
      return;
    }
    int i1 = this.q.b(paramString);
    if (i1 != -1)
    {
      paramString = this.n;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.c = ((TextView)paramView);
    this.c.setOnClickListener(this);
    paramViewStub = new ContactBindedActivity.2(this, 0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    paramViewStub.setDuration(500L);
    paramViewStub.setInterpolator(new OvershootInterpolator());
    paramViewStub.setAnimationListener(new ContactBindedActivity.3(this));
    this.c.startAnimation(paramViewStub);
    paramViewStub = PreferenceManager.getDefaultSharedPreferences(this).edit();
    paramView = new StringBuilder();
    paramView.append("has_contact_bind_act_show_new_guide_");
    paramView.append(this.app.getCurrentAccountUin());
    paramViewStub.putBoolean(paramView.toString(), true).commit();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getTag() != null) {
      b((PhoneContact)paramView.getTag(), false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      if (paramKeyEvent.getAction() == 0) {
        this.k = TextUtils.isEmpty(this.x.getText());
      } else if ((paramKeyEvent.getAction() == 1) && (this.k)) {
        this.G.a();
      }
    }
    return false;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity
 * JD-Core Version:    0.7.0.1
 */