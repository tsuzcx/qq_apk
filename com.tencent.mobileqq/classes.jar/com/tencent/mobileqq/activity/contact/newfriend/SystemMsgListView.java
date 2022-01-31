package com.tencent.mobileqq.activity.contact.newfriend;

import aexu;
import aeyf;
import aeyi;
import aeyk;
import aeyx;
import aeyy;
import aeyz;
import aezb;
import aezj;
import aezu;
import aezv;
import aezw;
import aezx;
import aezy;
import aezz;
import afaa;
import afab;
import afac;
import afai;
import afat;
import aicw;
import ajfo;
import ajhi;
import ajjh;
import ajjy;
import ajls;
import ajmm;
import ajnf;
import ajvr;
import ajvu;
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
import aroh;
import aroi;
import awqx;
import axcy;
import babr;
import bafb;
import bbms;
import begh;
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
import rhj;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, aroi, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private afat jdField_a_of_type_Afat;
  private aicw jdField_a_of_type_Aicw;
  private ajfo jdField_a_of_type_Ajfo = new afac(this);
  ajhi jdField_a_of_type_Ajhi = new aezz(this);
  ajjh jdField_a_of_type_Ajjh = new aezy(this);
  private ajls jdField_a_of_type_Ajls;
  ajmm jdField_a_of_type_Ajmm = new afaa(this);
  private ajnf jdField_a_of_type_Ajnf;
  private ajvu jdField_a_of_type_Ajvu = new afab(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<afat> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bafb jdField_a_of_type_Bafb;
  private bbms jdField_a_of_type_Bbms;
  private begh jdField_a_of_type_Begh = new aezv(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private rhj jdField_a_of_type_Rhj = new aezw(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new aezu(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Aicw = new aicw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aicw);
    i();
    this.jdField_a_of_type_Afat = new afat(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Aicw == null)) {}
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
                if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Aicw.getCount()))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                localObject1 = this.jdField_a_of_type_Aicw.getItem(paramInt);
                if ((paramInt == 0) && (((localObject1 instanceof aeyi)) || ((localObject1 instanceof aeyk))))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof aezj))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof aezb))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof aeyz))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if (paramInt + 1 < this.jdField_a_of_type_Aicw.getCount())
                {
                  if (!((aeyf)this.jdField_a_of_type_Aicw.getItem(paramInt) instanceof aeyx)) {
                    break;
                  }
                  this.jdField_a_of_type_Int = paramInt;
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
                  if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
                  {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                    Object localObject2 = ((View)localObject1).getTag();
                    if ((localObject2 instanceof aeyy))
                    {
                      localObject2 = (aeyy)localObject2;
                      if ((((aeyy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null))
                      {
                        float f = ((aeyy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
                        }
                        this.jdField_a_of_type_Float = f;
                        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(f);
                      }
                    }
                    this.jdField_a_of_type_Afat.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                    this.jdField_a_of_type_Afat.jdField_c_of_type_Int = ((View)localObject1).getTop();
                    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                    paramInt = i;
                    while (paramInt < j)
                    {
                      localObject2 = (afat)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
                      if (localObject2 != null)
                      {
                        ((afat)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                        ((afat)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
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
          } while (!((aeyf)this.jdField_a_of_type_Aicw.getItem(paramInt + 1) instanceof aeyx));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof aeyy));
      localObject1 = (aeyy)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
      }
    } while ((((aeyy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null));
    ((aeyy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajhi, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajhi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131495540);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303624));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131310128));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311534));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131300119));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131310968));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305177);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131166198);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131310127));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131311003));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_Aicw.c();
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
      this.jdField_a_of_type_Aicw.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Aicw.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Aicw.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Aicw.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof aeyk)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, aexu paramaexu)
  {
    super.a(paramIntent, paramaexu);
    this.jdField_a_of_type_Ajnf = ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Begh);
    this.jdField_a_of_type_Ajls = ((ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130848902);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h())
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
  
  public void a(ArrayList<afai> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(this.jdField_a_of_type_Rhj);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Rhj);
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
      this.jdField_a_of_type_Bafb = babr.a(getContext(), 230);
      this.jdField_a_of_type_Bafb.setMessage(ajjy.a(2131648919) + i + ajjy.a(2131648915));
      this.jdField_a_of_type_Bafb.setTitle(ajjy.a(2131648920));
      aezx localaezx = new aezx(this);
      this.jdField_a_of_type_Bafb.setNegativeButton(ajjy.a(2131648916), localaezx);
      this.jdField_a_of_type_Bafb.setPositiveButton(ajjy.a(2131648917), localaezx);
      this.jdField_a_of_type_Bafb.show();
      this.jdField_a_of_type_Boolean = false;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Aicw.g();
    if (this.jdField_a_of_type_Aicw.b() == 23) {
      this.jdField_a_of_type_Aicw.j();
    }
    this.jdField_a_of_type_Aicw.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aicw.b() == 23) {
      this.jdField_a_of_type_Aicw.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Aicw.f();
    ajvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Ajnf.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Aicw != null) {
      this.jdField_a_of_type_Aicw.h();
    }
    axcy.a().b();
    ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Ajnf.j();
    if (this.jdField_a_of_type_Ajnf.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130848801));
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Aicw.getCount() > 0)
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
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bbms.a(this.jdField_a_of_type_AndroidContentContext.getString(2131653452));
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    this.jdField_a_of_type_Bbms = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ajvr.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    awqx.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Aicw.getCount())) {
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