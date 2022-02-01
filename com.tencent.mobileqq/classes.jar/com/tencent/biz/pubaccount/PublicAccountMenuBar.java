package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import bjnw;
import bjon;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nsf;
import nsg;
import ocw;
import odn;
import odo;
import odp;
import zvc;

public class PublicAccountMenuBar
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public PublicAccountMenuBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @RequiresApi(api=21)
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private CharSequence a(zvc paramzvc)
  {
    if (paramzvc == null) {
      return "";
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841654);
    paramzvc = new SpannableStringBuilder("[]" + paramzvc.b());
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
    ((VerticalCenterImageSpan)localObject).setPadding(ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F));
    paramzvc.setSpan(localObject, 0, "[]".length(), 18);
    return paramzvc;
  }
  
  private List<mobileqq_mp.ButtonInfo> a(List<mobileqq_mp.ButtonInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          return localArrayList;
        }
        mobileqq_mp.ButtonInfo localButtonInfo = (mobileqq_mp.ButtonInfo)paramList.next();
        if (localButtonInfo != null) {
          if (a(localButtonInfo))
          {
            localArrayList.add(localButtonInfo);
          }
          else if (localButtonInfo.sub_button.has())
          {
            Iterator localIterator = localButtonInfo.sub_button.get().iterator();
            if (localIterator.hasNext())
            {
              if (!a((mobileqq_mp.ButtonInfo)localIterator.next())) {
                break;
              }
              localArrayList.add(localButtonInfo);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setVisibility(8);
  }
  
  private void a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {}
    label42:
    label60:
    label98:
    Object localObject3;
    label119:
    Object localObject4;
    label170:
    label190:
    label243:
    label250:
    label255:
    do
    {
      return;
      if (paramButtonInfo.key.has())
      {
        localObject1 = paramButtonInfo.key.get();
        if (!paramButtonInfo.name.has()) {
          break label243;
        }
        localObject2 = paramButtonInfo.name.get();
        if (!paramButtonInfo.id.has()) {
          break label250;
        }
        i = paramButtonInfo.id.get();
        localObject2 = new zvc((String)localObject1, (String)localObject2, null, i);
        ((zvc)localObject2).a(paramButtonInfo);
        if (!paramButtonInfo.sub_button.has()) {
          break label255;
        }
        paramButtonInfo = paramButtonInfo.sub_button.get();
        if ((paramButtonInfo == null) || (paramButtonInfo.size() <= 0)) {
          break label277;
        }
        localObject3 = paramButtonInfo.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (mobileqq_mp.ButtonInfo)((Iterator)localObject3).next();
        } while (!a((mobileqq_mp.ButtonInfo)localObject4));
        if (!((mobileqq_mp.ButtonInfo)localObject4).key.has()) {
          break label260;
        }
        paramButtonInfo = ((mobileqq_mp.ButtonInfo)localObject4).key.get();
        if (!((mobileqq_mp.ButtonInfo)localObject4).name.has()) {
          break label266;
        }
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject4).name.get();
        if (!((mobileqq_mp.ButtonInfo)localObject4).id.has()) {
          break label272;
        }
      }
      for (int i = ((mobileqq_mp.ButtonInfo)localObject4).id.get();; i = 0)
      {
        paramButtonInfo = new zvc(paramButtonInfo, (String)localObject1, null, i);
        paramButtonInfo.a((mobileqq_mp.ButtonInfo)localObject4);
        ((zvc)localObject2).a(paramButtonInfo);
        break label119;
        localObject1 = "";
        break;
        localObject2 = "";
        break label42;
        i = 0;
        break label60;
        paramButtonInfo = null;
        break label98;
        paramButtonInfo = "";
        break label170;
        localObject1 = "";
        break label190;
      }
      paramButtonInfo = ((zvc)localObject2).a();
    } while ((paramButtonInfo == null) || (paramButtonInfo.size() <= 0));
    label260:
    label266:
    label272:
    label277:
    Object localObject1 = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
    ((bjnw)localObject1).b(true);
    ((bjnw)localObject1).a(((zvc)localObject2).b(), 11);
    Object localObject2 = paramButtonInfo.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (zvc)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject4 = ((zvc)localObject3).a();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((bjnw)localObject1).a(((zvc)localObject3).b(), (String)localObject4);
        } else {
          ((bjnw)localObject1).c(((zvc)localObject3).b());
        }
      }
    }
    ((bjnw)localObject1).c(2131690620);
    ((bjnw)localObject1).a(new odo(this, paramButtonInfo, (bjnw)localObject1));
    ((bjnw)localObject1).setOnDismissListener(new odp(this));
    ((bjnw)localObject1).show();
  }
  
  private void a(zvc paramzvc)
  {
    if (paramzvc != null) {}
    try
    {
      String str = paramzvc.c();
      int i = paramzvc.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
      {
        ocw.a().a(str, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, i, null, this.jdField_a_of_type_MqqOsMqqHandler, 2, new SessionInfo());
        paramzvc = ocw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, i);
        if (paramzvc != null) {
          nsf.a.d(this.jdField_a_of_type_JavaLangString, paramzvc.id.get(), paramzvc.name.get());
        }
      }
      return;
    }
    catch (Exception paramzvc)
    {
      paramzvc.printStackTrace();
    }
  }
  
  private void a(zvc paramzvc, mobileqq_mp.ButtonInfo paramButtonInfo, boolean paramBoolean)
  {
    if (paramzvc == null) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = paramButtonInfo.sub_button.has();
    if (bool) {
      ((TextView)localObject).setText(a(paramzvc));
    }
    for (;;)
    {
      ((TextView)localObject).setTextSize(17.0F);
      ((TextView)localObject).setTextColor(-16777216);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(13, -1);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      if (!paramBoolean)
      {
        localObject = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject).setBackgroundResource(2130849620);
        localLayoutParams1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(0.5F), ViewUtils.dip2px(25.0F));
        localLayoutParams1.addRule(11, -1);
        localLayoutParams1.addRule(15, -1);
        localRelativeLayout.addView((View)localObject, localLayoutParams1);
      }
      localRelativeLayout.setOnClickListener(new odn(this, bool, paramButtonInfo, paramzvc));
      AccountDetailActivity.a(localRelativeLayout, "gzh_ele_enter_subprofile", this.jdField_a_of_type_JavaLangString);
      addView(localRelativeLayout, localLayoutParams);
      return;
      ((TextView)localObject).setText(paramzvc.b());
    }
  }
  
  private boolean a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramButtonInfo != null) {
      if (!paramButtonInfo.type.has()) {
        break label69;
      }
    }
    label69:
    for (int i = paramButtonInfo.type.get();; i = 0)
    {
      bool1 = bool2;
      if (i == 2)
      {
        bool1 = bool2;
        if (paramButtonInfo.url.has())
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramButtonInfo.url.get())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void setData(List<mobileqq_mp.ButtonInfo> paramList)
  {
    List localList = a(paramList);
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    setVisibility(0);
    int k = localList.size();
    removeAllViews();
    int i = 0;
    label43:
    mobileqq_mp.ButtonInfo localButtonInfo;
    label82:
    String str;
    label103:
    int j;
    if (i < k)
    {
      localButtonInfo = (mobileqq_mp.ButtonInfo)localList.get(i);
      if (!localButtonInfo.key.has()) {
        break label195;
      }
      paramList = localButtonInfo.key.get();
      if (!localButtonInfo.name.has()) {
        break label201;
      }
      str = localButtonInfo.name.get();
      if (!localButtonInfo.id.has()) {
        break label208;
      }
      j = localButtonInfo.id.get();
      label123:
      paramList = new zvc(paramList, str, null, j);
      paramList.a(localButtonInfo);
      if (i != k - 1) {
        break label213;
      }
    }
    label195:
    label201:
    label208:
    label213:
    for (boolean bool = true;; bool = false)
    {
      a(paramList, localButtonInfo, bool);
      nsf.a.c(this.jdField_a_of_type_JavaLangString, localButtonInfo.id.get(), localButtonInfo.name.get());
      i += 1;
      break label43;
      break;
      paramList = "";
      break label82;
      str = "";
      break label103;
      j = 0;
      break label123;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar
 * JD-Core Version:    0.7.0.1
 */