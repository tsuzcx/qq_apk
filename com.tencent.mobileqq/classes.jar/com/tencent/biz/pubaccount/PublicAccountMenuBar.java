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
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.ui.MenuItem;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAccountMenuBar
  extends LinearLayout
{
  private Context a;
  private QQAppInterface b;
  private String c;
  private MqqHandler d;
  private boolean e;
  
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
  
  private CharSequence a(MenuItem paramMenuItem)
  {
    if (paramMenuItem == null) {
      return "";
    }
    Object localObject = this.a.getResources().getDrawable(2130842608);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[]");
    localStringBuilder.append(paramMenuItem.d());
    paramMenuItem = new SpannableStringBuilder(localStringBuilder.toString());
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
    ((VerticalCenterImageSpan)localObject).setPadding(ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F));
    paramMenuItem.setSpan(localObject, 0, 2, 18);
    return paramMenuItem;
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
    this.a = paramContext;
    setVisibility(8);
  }
  
  private void a(MenuItem paramMenuItem, mobileqq_mp.ButtonInfo paramButtonInfo, boolean paramBoolean)
  {
    if (paramMenuItem == null) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.a);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    Object localObject = new TextView(this.a);
    boolean bool = paramButtonInfo.sub_button.has();
    if (bool) {
      ((TextView)localObject).setText(a(paramMenuItem));
    } else {
      ((TextView)localObject).setText(paramMenuItem.d());
    }
    ((TextView)localObject).setTextSize(17.0F);
    ((TextView)localObject).setTextColor(-16777216);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(13, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (!paramBoolean)
    {
      localObject = new View(this.a);
      ((View)localObject).setBackgroundResource(2130851802);
      localLayoutParams1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(0.5F), ViewUtils.dip2px(25.0F));
      localLayoutParams1.addRule(11, -1);
      localLayoutParams1.addRule(15, -1);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
    }
    localRelativeLayout.setOnClickListener(new PublicAccountMenuBar.1(this, bool, paramButtonInfo, paramMenuItem));
    PublicAccountDetailActivityImpl.setDatatongElement(localRelativeLayout, "gzh_ele_enter_subprofile", this.c);
    addView(localRelativeLayout, localLayoutParams);
  }
  
  private boolean a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo != null)
    {
      int i;
      if (paramButtonInfo.type.has()) {
        i = paramButtonInfo.type.get();
      } else {
        i = 0;
      }
      if ((i == 2) && (paramButtonInfo.url.has()) && (!TextUtils.isEmpty(paramButtonInfo.url.get()))) {
        return true;
      }
    }
    return false;
  }
  
  private void b(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null) {
      try
      {
        String str = paramMenuItem.e();
        int i = paramMenuItem.a();
        if ((this.b != null) && (this.c != null) && (this.d != null))
        {
          ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleButtonEvent(str, this.a, this.b, this.c, i, null, this.d, 2, new SessionInfo());
          paramMenuItem = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getButtonInfoByMenuId(this.b, this.c, i);
          if (paramMenuItem != null)
          {
            OfficialAccountReporter.a.d(this.c, paramMenuItem.id.get(), paramMenuItem.name.get());
            return;
          }
        }
      }
      catch (Exception paramMenuItem)
      {
        paramMenuItem.printStackTrace();
      }
    }
  }
  
  private void b(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {
      return;
    }
    Object localObject1;
    if (paramButtonInfo.key.has()) {
      localObject1 = paramButtonInfo.key.get();
    } else {
      localObject1 = "";
    }
    if (paramButtonInfo.name.has()) {
      localObject2 = paramButtonInfo.name.get();
    } else {
      localObject2 = "";
    }
    int i;
    if (paramButtonInfo.id.has()) {
      i = paramButtonInfo.id.get();
    } else {
      i = 0;
    }
    Object localObject2 = new MenuItem((String)localObject1, (String)localObject2, null, i);
    ((MenuItem)localObject2).a(paramButtonInfo);
    if (paramButtonInfo.sub_button.has()) {
      paramButtonInfo = paramButtonInfo.sub_button.get();
    } else {
      paramButtonInfo = null;
    }
    Object localObject3;
    Object localObject4;
    if ((paramButtonInfo != null) && (paramButtonInfo.size() > 0))
    {
      localObject3 = paramButtonInfo.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (mobileqq_mp.ButtonInfo)((Iterator)localObject3).next();
        if (a((mobileqq_mp.ButtonInfo)localObject4))
        {
          if (((mobileqq_mp.ButtonInfo)localObject4).key.has()) {
            paramButtonInfo = ((mobileqq_mp.ButtonInfo)localObject4).key.get();
          } else {
            paramButtonInfo = "";
          }
          if (((mobileqq_mp.ButtonInfo)localObject4).name.has()) {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject4).name.get();
          } else {
            localObject1 = "";
          }
          if (((mobileqq_mp.ButtonInfo)localObject4).id.has()) {
            i = ((mobileqq_mp.ButtonInfo)localObject4).id.get();
          } else {
            i = 0;
          }
          paramButtonInfo = new MenuItem(paramButtonInfo, (String)localObject1, null, i);
          paramButtonInfo.a((mobileqq_mp.ButtonInfo)localObject4);
          ((MenuItem)localObject2).a(paramButtonInfo);
        }
      }
    }
    paramButtonInfo = ((MenuItem)localObject2).h();
    if (paramButtonInfo != null)
    {
      if (paramButtonInfo.size() <= 0) {
        return;
      }
      localObject1 = (ActionSheet)ActionSheetHelper.b(this.a, null);
      ((ActionSheet)localObject1).setRoundCornerTop(true);
      ((ActionSheet)localObject1).addButton(((MenuItem)localObject2).d(), 11);
      localObject2 = paramButtonInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MenuItem)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          localObject4 = ((MenuItem)localObject3).b();
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((ActionSheet)localObject1).addButtonWithLeftUrlIcon(((MenuItem)localObject3).d(), (String)localObject4);
          } else {
            ((ActionSheet)localObject1).addButton(((MenuItem)localObject3).d());
          }
        }
      }
      ((ActionSheet)localObject1).addCancelButton(2131887648);
      ((ActionSheet)localObject1).setOnButtonClickListener(new PublicAccountMenuBar.2(this, paramButtonInfo, (ActionSheet)localObject1));
      ((ActionSheet)localObject1).setOnDismissListener(new PublicAccountMenuBar.3(this));
      ((ActionSheet)localObject1).show();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MqqHandler paramMqqHandler)
  {
    this.b = paramQQAppInterface;
    this.c = paramString;
    this.d = paramMqqHandler;
  }
  
  public void setData(List<mobileqq_mp.ButtonInfo> paramList)
  {
    List localList = a(paramList);
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      setVisibility(0);
      int k = localList.size();
      removeAllViews();
      int i = 0;
      while (i < k)
      {
        mobileqq_mp.ButtonInfo localButtonInfo = (mobileqq_mp.ButtonInfo)localList.get(i);
        boolean bool = localButtonInfo.key.has();
        String str = "";
        if (bool) {
          paramList = localButtonInfo.key.get();
        } else {
          paramList = "";
        }
        if (localButtonInfo.name.has()) {
          str = localButtonInfo.name.get();
        }
        int j;
        if (localButtonInfo.id.has()) {
          j = localButtonInfo.id.get();
        } else {
          j = 0;
        }
        paramList = new MenuItem(paramList, str, null, j);
        paramList.a(localButtonInfo);
        if (i == k - 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(paramList, localButtonInfo, bool);
        OfficialAccountReporter.a.c(this.c, localButtonInfo.id.get(), localButtonInfo.name.get());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar
 * JD-Core Version:    0.7.0.1
 */