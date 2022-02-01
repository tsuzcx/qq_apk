package com.tencent.mobileqq.activity.contact.newfriend;

import aicl;
import aico;
import aicz;
import aidk;
import aidp;
import aiea;
import aied;
import aief;
import aiej;
import aiez;
import aifa;
import aifb;
import aifd;
import aifl;
import aifw;
import aifx;
import aify;
import aifz;
import aiga;
import aigb;
import aigc;
import aigd;
import aige;
import amrc;
import amsu;
import amvo;
import amwl;
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
import avsy;
import avsz;
import bcef;
import bcsy;
import bhht;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import tdu;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, avsz, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private aico jdField_a_of_type_Aico = new aigb(this);
  private aidk jdField_a_of_type_Aidk;
  private aiej jdField_a_of_type_Aiej;
  private aifw jdField_a_of_type_Aifw;
  amrc jdField_a_of_type_Amrc = new aiga(this);
  amsu jdField_a_of_type_Amsu = new aifz(this);
  private amvo jdField_a_of_type_Amvo;
  amwl jdField_a_of_type_Amwl = new aige(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<aidk> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhht jdField_a_of_type_Bhht;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aigc(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new aigd(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private tdu jdField_a_of_type_Tdu = new aify(this);
  private int jdField_b_of_type_Int;
  private SparseArray<Boolean> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private int d;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new aifx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Aifw = new aifw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aifw);
    i();
    this.jdField_a_of_type_Aidk = new aidk(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Aifw == null)) {}
    do
    {
      return;
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Aifw.getCount()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      Object localObject = this.jdField_a_of_type_Aifw.getItem(paramInt);
      if ((paramInt == 0) && (((localObject instanceof aied)) || ((localObject instanceof aief))))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof aifl))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof aifd))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof aifb))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
    } while (paramInt + 1 >= this.jdField_a_of_type_Aifw.getCount());
    f(paramInt);
  }
  
  private void f(int paramInt)
  {
    int i = 0;
    Object localObject1;
    if (((aiea)this.jdField_a_of_type_Aifw.getItem(paramInt) instanceof aiez))
    {
      this.jdField_a_of_type_Int = paramInt;
      localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
      if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        Object localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof aifa))
        {
          localObject2 = (aifa)localObject2;
          if ((((aifa)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null))
          {
            float f = ((aifa)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
            }
            this.jdField_a_of_type_Float = f;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(f);
          }
        }
        this.jdField_a_of_type_Aidk.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
        this.jdField_a_of_type_Aidk.jdField_c_of_type_Int = ((View)localObject1).getTop();
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = i;
        while (paramInt < j)
        {
          localObject2 = (aidk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((aidk)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
            ((aidk)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
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
          } while (!((aiea)this.jdField_a_of_type_Aifw.getItem(paramInt + 1) instanceof aiez));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof aifa));
      localObject1 = (aifa)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
      }
    } while ((((aifa)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null));
    ((aifa)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrc, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amwl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aico);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amwl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aico);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561484);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370037));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377139));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378707));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366123));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378095));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371813);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297428);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377138));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131378130));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299076);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_Aifw.c();
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
      this.jdField_a_of_type_Aifw.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Aifw.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Aifw.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Aifw.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof aief)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, aidp paramaidp)
  {
    super.a(paramIntent, paramaidp);
    this.jdField_a_of_type_Aiej = ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Amvo = ((amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839437);
      return;
    }
    paramView.setBackgroundResource(2130850152);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i())
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
  
  public void a(ArrayList<aicz> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(this.jdField_a_of_type_Tdu);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Tdu);
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
    this.jdField_a_of_type_Aifw.g();
    if (this.jdField_a_of_type_Aifw.b() == 23) {
      this.jdField_a_of_type_Aifw.j();
    }
    this.jdField_a_of_type_Aifw.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aifw.b() == 23) {
      this.jdField_a_of_type_Aifw.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Aifw.e();
    aicl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Aiej.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Aifw != null) {
      this.jdField_a_of_type_Aifw.h();
    }
    bcsy.a().b();
    ((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Aiej.j();
    if (this.jdField_a_of_type_Aiej.a)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130850016));
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Aifw.getCount() > 0)
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
    if (this.jdField_a_of_type_Bhht == null) {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bhht.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718142));
    this.jdField_a_of_type_Bhht.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
    this.jdField_a_of_type_Bhht = null;
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
      aicl.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bcef.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Aifw.getCount())) {
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