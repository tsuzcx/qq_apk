package com.tencent.mobileqq.activity.contact.newfriend;

import ahlc;
import ahln;
import ahlq;
import ahls;
import ahmf;
import ahmg;
import ahmh;
import ahmj;
import ahmr;
import ahnc;
import ahnd;
import ahne;
import ahnf;
import ahng;
import ahnh;
import ahni;
import ahnj;
import ahnk;
import ahnq;
import ahob;
import akln;
import alpq;
import alrl;
import altm;
import alud;
import alwd;
import alwx;
import alxr;
import amgf;
import amgi;
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
import aufv;
import aufw;
import azqs;
import bafi;
import bdgm;
import bdjz;
import bety;
import bhtv;
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
  implements View.OnClickListener, aufw, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private ahob jdField_a_of_type_Ahob;
  private akln jdField_a_of_type_Akln;
  private alpq jdField_a_of_type_Alpq = new ahnk(this);
  alrl jdField_a_of_type_Alrl = new ahnh(this);
  altm jdField_a_of_type_Altm = new ahng(this);
  private alwd jdField_a_of_type_Alwd;
  alwx jdField_a_of_type_Alwx = new ahni(this);
  private alxr jdField_a_of_type_Alxr;
  private amgi jdField_a_of_type_Amgi = new ahnj(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<ahob> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bdjz jdField_a_of_type_Bdjz;
  private bety jdField_a_of_type_Bety;
  private bhtv jdField_a_of_type_Bhtv = new ahnd(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private skj jdField_a_of_type_Skj = new ahne(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new ahnc(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Akln = new akln(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Akln);
    i();
    this.jdField_a_of_type_Ahob = new ahob(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Akln == null)) {}
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
                if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Akln.getCount()))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                localObject1 = this.jdField_a_of_type_Akln.getItem(paramInt);
                if ((paramInt == 0) && (((localObject1 instanceof ahlq)) || ((localObject1 instanceof ahls))))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahmr))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahmj))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof ahmh))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if (paramInt + 1 < this.jdField_a_of_type_Akln.getCount())
                {
                  if (!((ahln)this.jdField_a_of_type_Akln.getItem(paramInt) instanceof ahmf)) {
                    break;
                  }
                  this.jdField_a_of_type_Int = paramInt;
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
                  if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
                  {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                    Object localObject2 = ((View)localObject1).getTag();
                    if ((localObject2 instanceof ahmg))
                    {
                      localObject2 = (ahmg)localObject2;
                      if ((((ahmg)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null))
                      {
                        float f = ((ahmg)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
                        }
                        this.jdField_a_of_type_Float = f;
                        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(f);
                      }
                    }
                    this.jdField_a_of_type_Ahob.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                    this.jdField_a_of_type_Ahob.jdField_c_of_type_Int = ((View)localObject1).getTop();
                    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                    paramInt = i;
                    while (paramInt < j)
                    {
                      localObject2 = (ahob)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
                      if (localObject2 != null)
                      {
                        ((ahob)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                        ((ahob)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
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
          } while (!((ahln)this.jdField_a_of_type_Akln.getItem(paramInt + 1) instanceof ahmf));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof ahmg));
      localObject1 = (ahmg)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
      }
    } while ((((ahmg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null));
    ((ahmg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alrl, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amgi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alrl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amgi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561332);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369547));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376447));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377938));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365801));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131377345));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371179);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297298);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376446));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131377381));
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
    this.jdField_a_of_type_Akln.c();
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
      this.jdField_a_of_type_Akln.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Akln.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Akln.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Akln.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof ahls)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, ahlc paramahlc)
  {
    super.a(paramIntent, paramahlc);
    this.jdField_a_of_type_Alxr = ((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
    this.jdField_a_of_type_Alwd = ((alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839217);
      return;
    }
    paramView.setBackgroundResource(2130849643);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h())
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
  
  public void a(ArrayList<ahnq> paramArrayList, int paramInt)
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
      this.jdField_a_of_type_Bdjz = bdgm.a(getContext(), 230);
      this.jdField_a_of_type_Bdjz.setMessage(alud.a(2131715103) + i + alud.a(2131715099));
      this.jdField_a_of_type_Bdjz.setTitle(alud.a(2131715104));
      ahnf localahnf = new ahnf(this);
      this.jdField_a_of_type_Bdjz.setNegativeButton(alud.a(2131715100), localahnf);
      this.jdField_a_of_type_Bdjz.setPositiveButton(alud.a(2131715101), localahnf);
      this.jdField_a_of_type_Bdjz.show();
      this.jdField_a_of_type_Boolean = false;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Akln.g();
    if (this.jdField_a_of_type_Akln.b() == 23) {
      this.jdField_a_of_type_Akln.j();
    }
    this.jdField_a_of_type_Akln.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Akln.b() == 23) {
      this.jdField_a_of_type_Akln.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Akln.f();
    amgf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Alxr.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Akln != null) {
      this.jdField_a_of_type_Akln.h();
    }
    bafi.a().b();
    ((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Alxr.j();
    if (this.jdField_a_of_type_Alxr.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130849536));
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Akln.getCount() > 0)
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
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bety.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719785));
    this.jdField_a_of_type_Bety.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    this.jdField_a_of_type_Bety = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    amgf.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azqs.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Akln.getCount())) {
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