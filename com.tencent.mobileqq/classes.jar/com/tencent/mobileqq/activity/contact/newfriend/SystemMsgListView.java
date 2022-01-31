package com.tencent.mobileqq.activity.contact.newfriend;

import afji;
import afjt;
import afjw;
import afjy;
import afkl;
import afkm;
import afkn;
import afkp;
import afkx;
import afli;
import aflj;
import aflk;
import afll;
import aflm;
import afln;
import aflo;
import aflp;
import aflq;
import aflw;
import afmh;
import aipn;
import ajto;
import ajvj;
import ajxj;
import ajya;
import akaa;
import akat;
import akbn;
import akka;
import akkd;
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
import askn;
import asko;
import axqy;
import aydc;
import bbdj;
import bbgu;
import bcqf;
import bfos;
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
import rtw;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, asko, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private afmh jdField_a_of_type_Afmh;
  private aipn jdField_a_of_type_Aipn;
  private ajto jdField_a_of_type_Ajto = new aflq(this);
  ajvj jdField_a_of_type_Ajvj = new afln(this);
  ajxj jdField_a_of_type_Ajxj = new aflm(this);
  private akaa jdField_a_of_type_Akaa;
  akat jdField_a_of_type_Akat = new aflo(this);
  private akbn jdField_a_of_type_Akbn;
  private akkd jdField_a_of_type_Akkd = new aflp(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private SparseArray<afmh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bbgu jdField_a_of_type_Bbgu;
  private bcqf jdField_a_of_type_Bcqf;
  private bfos jdField_a_of_type_Bfos = new aflj(this);
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private rtw jdField_a_of_type_Rtw = new aflk(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new afli(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Aipn = new aipn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Aipn);
    i();
    this.jdField_a_of_type_Afmh = new afmh(23, 0, 0);
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
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_Aipn == null)) {}
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
                if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Aipn.getCount()))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                localObject1 = this.jdField_a_of_type_Aipn.getItem(paramInt);
                if ((paramInt == 0) && (((localObject1 instanceof afjw)) || ((localObject1 instanceof afjy))))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkx))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkp))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if ((localObject1 instanceof afkn))
                {
                  this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
                  return;
                }
                if (paramInt + 1 < this.jdField_a_of_type_Aipn.getCount())
                {
                  if (!((afjt)this.jdField_a_of_type_Aipn.getItem(paramInt) instanceof afkl)) {
                    break;
                  }
                  this.jdField_a_of_type_Int = paramInt;
                  localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
                  if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
                  {
                    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                    Object localObject2 = ((View)localObject1).getTag();
                    if ((localObject2 instanceof afkm))
                    {
                      localObject2 = (afkm)localObject2;
                      if ((((afkm)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null))
                      {
                        float f = ((afkm)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
                        }
                        this.jdField_a_of_type_Float = f;
                        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(f);
                      }
                    }
                    this.jdField_a_of_type_Afmh.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                    this.jdField_a_of_type_Afmh.jdField_c_of_type_Int = ((View)localObject1).getTop();
                    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                    paramInt = i;
                    while (paramInt < j)
                    {
                      localObject2 = (afmh)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
                      if (localObject2 != null)
                      {
                        ((afmh)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
                        ((afmh)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
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
          } while (!((afjt)this.jdField_a_of_type_Aipn.getItem(paramInt + 1) instanceof afkl));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof afkm));
      localObject1 = (afkm)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
      }
    } while ((((afkm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout == null));
    ((afkm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvj, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akkd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akkd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561127);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369294));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375894));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365715));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376779));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370850);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297279);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375893));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131376814));
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
    this.jdField_a_of_type_Aipn.c();
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
      this.jdField_a_of_type_Aipn.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Aipn.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Aipn.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Aipn.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof afjy)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, afji paramafji)
  {
    super.a(paramIntent, paramafji);
    this.jdField_a_of_type_Akbn = ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    ((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_Akaa = ((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
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
    paramView.setBackgroundResource(2130849139);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h())
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
  
  public void a(ArrayList<aflw> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(this.jdField_a_of_type_Rtw);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_Rtw);
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
      this.jdField_a_of_type_Bbgu = bbdj.a(getContext(), 230);
      this.jdField_a_of_type_Bbgu.setMessage(ajya.a(2131714719) + i + ajya.a(2131714715));
      this.jdField_a_of_type_Bbgu.setTitle(ajya.a(2131714720));
      afll localafll = new afll(this);
      this.jdField_a_of_type_Bbgu.setNegativeButton(ajya.a(2131714716), localafll);
      this.jdField_a_of_type_Bbgu.setPositiveButton(ajya.a(2131714717), localafll);
      this.jdField_a_of_type_Bbgu.show();
      this.jdField_a_of_type_Boolean = false;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Aipn.g();
    if (this.jdField_a_of_type_Aipn.b() == 23) {
      this.jdField_a_of_type_Aipn.j();
    }
    this.jdField_a_of_type_Aipn.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aipn.b() == 23) {
      this.jdField_a_of_type_Aipn.i();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_Aipn.f();
    akka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_Akbn.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_Aipn != null) {
      this.jdField_a_of_type_Aipn.h();
    }
    aydc.a().b();
    ((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Akbn.j();
    if (this.jdField_a_of_type_Akbn.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130849032));
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_Aipn.getCount() > 0)
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
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_Bcqf.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719292));
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.jdField_a_of_type_Bcqf = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    akka.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqy.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Aipn.getCount())) {
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