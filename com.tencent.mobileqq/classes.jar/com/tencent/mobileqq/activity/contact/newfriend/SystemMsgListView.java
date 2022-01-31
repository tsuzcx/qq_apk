package com.tencent.mobileqq.activity.contact.newfriend;

import afjk;
import afjv;
import afjy;
import afka;
import afkn;
import afko;
import afkp;
import afkr;
import afkz;
import aflk;
import afll;
import aflm;
import afln;
import aflo;
import aflp;
import aflq;
import aflr;
import afls;
import afly;
import afmj;
import aipp;
import ajtq;
import ajvl;
import ajxl;
import ajyc;
import akac;
import akav;
import akbo;
import akkb;
import akke;
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
import askl;
import askm;
import axqw;
import ayda;
import bbcv;
import bbgg;
import bcpq;
import bfob;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import rtz;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, askm, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private afmj jdField_a_of_type_Afmj;
  private aipp jdField_a_of_type_Aipp;
  private ajtq jdField_a_of_type_Ajtq = new afls(this);
  ajvl jdField_a_of_type_Ajvl = new aflp(this);
  ajxl jdField_a_of_type_Ajxl = new aflo(this);
  private akac jdField_a_of_type_Akac;
  akav jdField_a_of_type_Akav = new aflq(this);
  private akbo jdField_a_of_type_Akbo;
  private akke jdField_a_of_type_Akke = new aflr(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<afmj> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bbgg jdField_a_of_type_Bbgg;
  private bcpq jdField_a_of_type_Bcpq;
  private bfob jdField_a_of_type_Bfob = new afll(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private rtz jdField_a_of_type_Rtz = new aflm(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new aflk(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Aipp = new aipp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aipp);
    i();
    this.jdField_a_of_type_Afmj = new afmj(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Aipp == null)) {}
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
                if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Aipp.getCount()))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                localObject1 = this.jdField_a_of_type_Aipp.getItem(paramInt);
                if ((paramInt == 0) && (((localObject1 instanceof afjy)) || ((localObject1 instanceof afka))))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkz))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkr))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkp))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if (paramInt + 1 < this.jdField_a_of_type_Aipp.getCount())
                {
                  if (!((afjv)this.jdField_a_of_type_Aipp.getItem(paramInt) instanceof afkn)) {
                    break;
                  }
                  this.jdField_a_of_type_Int = paramInt;
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
                  if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
                  {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                    Object localObject2 = ((View)localObject1).getTag();
                    if ((localObject2 instanceof afko))
                    {
                      localObject2 = (afko)localObject2;
                      if ((((afko)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null))
                      {
                        float f = ((afko)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
                        }
                        this.jdField_a_of_type_Float = f;
                        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(f);
                      }
                    }
                    this.jdField_a_of_type_Afmj.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                    this.jdField_a_of_type_Afmj.jdField_c_of_type_Int = ((View)localObject1).getTop();
                    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                    paramInt = i;
                    while (paramInt < j)
                    {
                      localObject2 = (afmj)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
                      if (localObject2 != null)
                      {
                        ((afmj)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                        ((afmj)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
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
          } while (!((afjv)this.jdField_a_of_type_Aipp.getItem(paramInt + 1) instanceof afkn));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof afko));
      localObject1 = (afko)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
      }
    } while ((((afko)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null));
    ((afko)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvl, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akav);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akke);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajtq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akav);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akke);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajtq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561128);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369294));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365716));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376777));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370850);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297279);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375891));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131376812));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298865);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_Aipp.c();
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
      this.jdField_a_of_type_Aipp.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Aipp.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Aipp.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Aipp.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof afka)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, afjk paramafjk)
  {
    super.a(paramIntent, paramafjk);
    this.jdField_a_of_type_Akbo = ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Bfob);
    this.jdField_a_of_type_Akac = ((akac)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839132);
      return;
    }
    paramView.setBackgroundResource(2130849130);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h())
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
  
  public void a(ArrayList<afly> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(this.jdField_a_of_type_Rtz);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Rtz);
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
      this.jdField_a_of_type_Bbgg = bbcv.a(getContext(), 230);
      this.jdField_a_of_type_Bbgg.setMessage(ajyc.a(2131714708) + i + ajyc.a(2131714704));
      this.jdField_a_of_type_Bbgg.setTitle(ajyc.a(2131714709));
      afln localafln = new afln(this);
      this.jdField_a_of_type_Bbgg.setNegativeButton(ajyc.a(2131714705), localafln);
      this.jdField_a_of_type_Bbgg.setPositiveButton(ajyc.a(2131714706), localafln);
      this.jdField_a_of_type_Bbgg.show();
      this.jdField_a_of_type_Boolean = false;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Aipp.g();
    if (this.jdField_a_of_type_Aipp.b() == 23) {
      this.jdField_a_of_type_Aipp.j();
    }
    this.jdField_a_of_type_Aipp.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aipp.b() == 23) {
      this.jdField_a_of_type_Aipp.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Aipp.f();
    akkb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Akbo.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Aipp != null) {
      this.jdField_a_of_type_Aipp.h();
    }
    ayda.a().b();
    ((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Akbo.j();
    if (this.jdField_a_of_type_Akbo.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130849026));
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Aipp.getCount() > 0)
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
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bcpq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719281));
    this.jdField_a_of_type_Bcpq.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.jdField_a_of_type_Bcpq = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    akkb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqw.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Aipp.getCount())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */