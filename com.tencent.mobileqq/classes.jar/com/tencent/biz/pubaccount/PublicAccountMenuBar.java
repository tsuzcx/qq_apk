package com.tencent.biz.pubaccount;

import aaum;
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
import bgtn;
import bkho;
import bkif;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nzz;
import oaq;
import oar;
import oas;

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
  
  private CharSequence a(aaum paramaaum)
  {
    if (paramaaum == null) {
      return "";
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841608);
    paramaaum = new SpannableStringBuilder("[]" + paramaaum.b());
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
    ((VerticalCenterImageSpan)localObject).setPadding(bgtn.a(4.0F), bgtn.a(4.0F));
    paramaaum.setSpan(localObject, 0, "[]".length(), 18);
    return paramaaum;
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
  
  private void a(aaum paramaaum)
  {
    if (paramaaum != null) {}
    try
    {
      String str = paramaaum.c();
      int i = paramaaum.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
        nzz.a().a(str, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, i, null, this.jdField_a_of_type_MqqOsMqqHandler, 2, new SessionInfo());
      }
      return;
    }
    catch (Exception paramaaum)
    {
      paramaaum.printStackTrace();
    }
  }
  
  private void a(aaum paramaaum, mobileqq_mp.ButtonInfo paramButtonInfo, boolean paramBoolean)
  {
    if (paramaaum == null) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    boolean bool = paramButtonInfo.sub_button.has();
    if (bool) {
      ((TextView)localObject).setText(a(paramaaum));
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
        ((View)localObject).setBackgroundResource(2130849692);
        localLayoutParams1 = new RelativeLayout.LayoutParams(bgtn.a(0.5F), bgtn.a(25.0F));
        localLayoutParams1.addRule(11, -1);
        localLayoutParams1.addRule(15, -1);
        localRelativeLayout.addView((View)localObject, localLayoutParams1);
      }
      localRelativeLayout.setOnClickListener(new oaq(this, bool, paramButtonInfo, paramaaum));
      addView(localRelativeLayout, localLayoutParams);
      return;
      ((TextView)localObject).setText(paramaaum.b());
    }
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
        localObject2 = new aaum((String)localObject1, (String)localObject2, null, i);
        ((aaum)localObject2).a(paramButtonInfo);
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
        paramButtonInfo = new aaum(paramButtonInfo, (String)localObject1, null, i);
        paramButtonInfo.a((mobileqq_mp.ButtonInfo)localObject4);
        ((aaum)localObject2).a(paramButtonInfo);
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
      paramButtonInfo = ((aaum)localObject2).a();
    } while ((paramButtonInfo == null) || (paramButtonInfo.size() <= 0));
    label260:
    label266:
    label272:
    label277:
    Object localObject1 = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
    ((bkho)localObject1).b(true);
    ((bkho)localObject1).a(((aaum)localObject2).b(), 11);
    Object localObject2 = paramButtonInfo.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (aaum)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject4 = ((aaum)localObject3).a();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((bkho)localObject1).a(((aaum)localObject3).b(), (String)localObject4);
        } else {
          ((bkho)localObject1).c(((aaum)localObject3).b());
        }
      }
    }
    ((bkho)localObject1).c(2131690582);
    ((bkho)localObject1).a(new oar(this, paramButtonInfo, (bkho)localObject1));
    ((bkho)localObject1).setOnDismissListener(new oas(this));
    ((bkho)localObject1).show();
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
        break label169;
      }
      paramList = localButtonInfo.key.get();
      if (!localButtonInfo.name.has()) {
        break label175;
      }
      str = localButtonInfo.name.get();
      if (!localButtonInfo.id.has()) {
        break label182;
      }
      j = localButtonInfo.id.get();
      label123:
      paramList = new aaum(paramList, str, null, j);
      paramList.a(localButtonInfo);
      if (i != k - 1) {
        break label187;
      }
    }
    label169:
    label175:
    label182:
    label187:
    for (boolean bool = true;; bool = false)
    {
      a(paramList, localButtonInfo, bool);
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