package com.tencent.mobileqq.activity.contact.newfriend;

import ahgn;
import ahgy;
import ahhb;
import ahhd;
import ahhq;
import ahhr;
import ahhs;
import ahhu;
import ahic;
import ahin;
import ahio;
import ahip;
import ahiq;
import ahir;
import ahis;
import ahit;
import ahiu;
import ahiv;
import ahjb;
import ahjm;
import akgy;
import allb;
import almw;
import alox;
import alpo;
import alro;
import alsi;
import altc;
import ambq;
import ambt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aubm;
import aubn;
import azmj;
import baaz;
import bdcd;
import bdfq;
import bepp;
import bhpo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import skj;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, aubn, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private ahjm jdField_a_of_type_Ahjm;
  private akgy jdField_a_of_type_Akgy;
  private allb jdField_a_of_type_Allb = new ahiv(this);
  almw jdField_a_of_type_Almw = new ahis(this);
  alox jdField_a_of_type_Alox = new ahir(this);
  private alro jdField_a_of_type_Alro;
  alsi jdField_a_of_type_Alsi = new ahit(this);
  private altc jdField_a_of_type_Altc;
  private ambt jdField_a_of_type_Ambt = new ahiu(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<ahjm> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bdfq jdField_a_of_type_Bdfq;
  private bepp jdField_a_of_type_Bepp;
  private bhpo jdField_a_of_type_Bhpo = new ahio(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private skj jdField_a_of_type_Skj = new ahip(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  private SparseArray<Boolean> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private int d;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new ahin(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Akgy = new akgy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Akgy);
    i();
    this.jdField_a_of_type_Ahjm = new ahjm(23, 0, 0);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        return ((Boolean)localObject).booleanValue();
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, Boolean.valueOf(true));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    int i = 0;
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Akgy == null)) {}
    Object localObject1;
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
              for (;;)
              {
                return;
                if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Akgy.getCount()))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                localObject1 = this.jdField_a_of_type_Akgy.getItem(paramInt);
                if ((paramInt == 0) && (((localObject1 instanceof ahhb)) || ((localObject1 instanceof ahhd))))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahic))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahhu))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahhs))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if (paramInt + 1 < this.jdField_a_of_type_Akgy.getCount())
                {
                  if (!((ahgy)this.jdField_a_of_type_Akgy.getItem(paramInt) instanceof ahhq)) {
                    break;
                  }
                  this.jdField_a_of_type_Int = paramInt;
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
                  if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
                  {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                    Object localObject2 = ((View)localObject1).getTag();
                    if ((localObject2 instanceof ahhr))
                    {
                      localObject2 = (ahhr)localObject2;
                      if ((((ahhr)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null))
                      {
                        float f = ((ahhr)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
                        }
                        this.jdField_a_of_type_Float = f;
                        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(f);
                      }
                    }
                    this.jdField_a_of_type_Ahjm.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                    this.jdField_a_of_type_Ahjm.jdField_c_of_type_Int = ((View)localObject1).getTop();
                    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                    paramInt = i;
                    while (paramInt < j)
                    {
                      localObject2 = (ahjm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
                      if (localObject2 != null)
                      {
                        ((ahjm)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                        ((ahjm)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
                      }
                      paramInt += 1;
                    }
                  }
                }
              }
              if (this.jdField_a_of_type_Int <= -1)
              {
                this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                return;
              }
              if (paramInt > this.jdField_a_of_type_Int)
              {
                this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                return;
              }
            } while (!this.jdField_c_of_type_AndroidViewViewGroup.isShown());
            this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          } while (!((ahgy)this.jdField_a_of_type_Akgy.getItem(paramInt + 1) instanceof ahhq));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof ahhr));
      localObject1 = (ahhr)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
      }
    } while ((((ahhr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null));
    ((ahhr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almw, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ambt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ambt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561314);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369529));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376393));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377884));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365799));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131377291));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371160);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297298);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376392));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131377327));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_Akgy.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label265:
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_Akgy.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Akgy.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Akgy.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Akgy.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof ahhd)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, ahgn paramahgn)
  {
    super.a(paramIntent, paramahgn);
    this.jdField_a_of_type_Altc = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Bhpo);
    this.jdField_a_of_type_Alro = ((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839216);
      return;
    }
    paramView.setBackgroundResource(2130849570);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h())
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("systemmsg_addFriendCount", "");
      if (!TextUtils.isEmpty(str)) {
        break label65;
      }
    }
    label65:
    for (String[] arrayOfString = new String[0]; arrayOfString.length >= 3; arrayOfString = str.split(":")) {
      return;
    }
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("systemmsg_addFriendCount", str).commit();
        return;
      }
      i += 1;
    }
    if (arrayOfString.length == 0) {}
    for (;;)
    {
      str = paramString;
      if (arrayOfString.length + 1 != 3) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      str = paramString;
      break;
      paramString = str + ":" + paramString;
    }
  }
  
  public void a(ArrayList<ahjb> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(this.jdField_a_of_type_Skj);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Skj);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void b(int paramInt) {}
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boolean)
    {
      int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b().size();
      this.jdField_a_of_type_Bdfq = bdcd.a(getContext(), 230);
      this.jdField_a_of_type_Bdfq.setMessage(alpo.a(2131715091) + i + alpo.a(2131715087));
      this.jdField_a_of_type_Bdfq.setTitle(alpo.a(2131715092));
      ahiq localahiq = new ahiq(this);
      this.jdField_a_of_type_Bdfq.setNegativeButton(alpo.a(2131715088), localahiq);
      this.jdField_a_of_type_Bdfq.setPositiveButton(alpo.a(2131715089), localahiq);
      this.jdField_a_of_type_Bdfq.show();
      this.jdField_a_of_type_Boolean = false;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Akgy.g();
    if (this.jdField_a_of_type_Akgy.b() == 23) {
      this.jdField_a_of_type_Akgy.j();
    }
    this.jdField_a_of_type_Akgy.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Akgy.b() == 23) {
      this.jdField_a_of_type_Akgy.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Akgy.f();
    ambq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Altc.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Akgy != null) {
      this.jdField_a_of_type_Akgy.h();
    }
    baaz.a().b();
    ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Altc.j();
    if (this.jdField_a_of_type_Altc.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130849463));
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Akgy.getCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719773));
    this.jdField_a_of_type_Bepp.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    this.jdField_a_of_type_Bepp = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ambq.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azmj.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Akgy.getCount())) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHeadSelection position : " + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new SystemMsgListView.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */