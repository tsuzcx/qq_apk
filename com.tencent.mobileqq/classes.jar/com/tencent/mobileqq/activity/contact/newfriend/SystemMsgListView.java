package com.tencent.mobileqq.activity.contact.newfriend;

import ajic;
import ajif;
import ajiq;
import ajjb;
import ajjg;
import ajjr;
import ajju;
import ajjw;
import ajka;
import ajkq;
import ajkr;
import ajks;
import ajku;
import ajlc;
import ajln;
import ajlo;
import ajlp;
import ajlq;
import ajlr;
import ajls;
import ajlt;
import ajlu;
import ajlv;
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
import anuw;
import anwt;
import anyu;
import aobl;
import aocj;
import axfr;
import axfs;
import bdll;
import bdzh;
import bjbs;
import blih;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import szu;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, axfs, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private ajif jdField_a_of_type_Ajif = new ajls(this);
  private ajjb jdField_a_of_type_Ajjb;
  private ajka jdField_a_of_type_Ajka;
  private ajln jdField_a_of_type_Ajln;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<ajjb> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new ajlt(this);
  anwt jdField_a_of_type_Anwt = new ajlr(this);
  anyu jdField_a_of_type_Anyu = new ajlq(this);
  private aobl jdField_a_of_type_Aobl;
  aocj jdField_a_of_type_Aocj = new ajlv(this);
  private bjbs jdField_a_of_type_Bjbs;
  private blih jdField_a_of_type_Blih = new ajlu(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private szu jdField_a_of_type_Szu = new ajlp(this);
  private int jdField_b_of_type_Int;
  private SparseArray<Boolean> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private int d;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new ajlo(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Ajln = new ajln(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ajln);
    i();
    this.jdField_a_of_type_Ajjb = new ajjb(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Ajln == null)) {}
    do
    {
      return;
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Ajln.getCount()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      Object localObject = this.jdField_a_of_type_Ajln.getItem(paramInt);
      if ((paramInt == 0) && (((localObject instanceof ajju)) || ((localObject instanceof ajjw))))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof ajlc))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof ajku))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof ajks))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
    } while (paramInt + 1 >= this.jdField_a_of_type_Ajln.getCount());
    f(paramInt);
  }
  
  private void f(int paramInt)
  {
    int i = 0;
    Object localObject1;
    if (((ajjr)this.jdField_a_of_type_Ajln.getItem(paramInt) instanceof ajkq))
    {
      this.jdField_a_of_type_Int = paramInt;
      localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
      if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        Object localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof ajkr))
        {
          localObject2 = (ajkr)localObject2;
          if ((((ajkr)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null))
          {
            float f = ((ajkr)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
            }
            this.jdField_a_of_type_Float = f;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(f);
          }
        }
        this.jdField_a_of_type_Ajjb.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
        this.jdField_a_of_type_Ajjb.jdField_c_of_type_Int = ((View)localObject1).getTop();
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = i;
        while (paramInt < j)
        {
          localObject2 = (ajjb)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((ajjb)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
            ((ajjb)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int > -1) {
        break label255;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    label255:
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
              return;
              if (paramInt > this.jdField_a_of_type_Int)
              {
                this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                return;
              }
            } while (!this.jdField_c_of_type_AndroidViewViewGroup.isShown());
            this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          } while (!((ajjr)this.jdField_a_of_type_Ajln.getItem(paramInt + 1) instanceof ajkq));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof ajkr));
      localObject1 = (ajkr)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
      }
    } while ((((ajkr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null));
    ((ajkr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anwt, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajif);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajif);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561606);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370040));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377376));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378936));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366094));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378328));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371847);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297373);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377375));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131378363));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_Ajln.c();
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
      this.jdField_a_of_type_Ajln.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Ajln.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Ajln.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Ajln.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof ajjw)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, ajjg paramajjg)
  {
    super.a(paramIntent, paramajjg);
    this.jdField_a_of_type_Ajka = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_Aobl = ((aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839402);
      return;
    }
    paramView.setBackgroundResource(2130850231);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i())
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
      str = paramString;
      break;
      paramString = str + ":" + paramString;
    }
  }
  
  public void a(ArrayList<ajiq> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(this.jdField_a_of_type_Szu);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Szu);
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Ajln.g();
    if (this.jdField_a_of_type_Ajln.b() == 23) {
      this.jdField_a_of_type_Ajln.j();
    }
    this.jdField_a_of_type_Ajln.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Ajln.b() == 23) {
      this.jdField_a_of_type_Ajln.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Ajln.e();
    ajic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Ajka.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Ajln != null) {
      this.jdField_a_of_type_Ajln.h();
    }
    bdzh.a().b();
    ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Ajka.j();
    if (this.jdField_a_of_type_Ajka.a)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130850099));
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Ajln.getCount() > 0)
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
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bjbs.a(this.jdField_a_of_type_AndroidContentContext.getString(2131717902));
    this.jdField_a_of_type_Bjbs.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    this.jdField_a_of_type_Bjbs = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ajic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bdll.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Ajln.getCount())) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHeadSelection position : " + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new SystemMsgListView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */