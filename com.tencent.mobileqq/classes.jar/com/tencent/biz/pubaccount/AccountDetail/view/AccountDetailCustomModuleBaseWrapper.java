package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountDetailCustomModuleBaseWrapper
{
  protected ArrayList<IPublicAccountConfigAttr.PaConfigInfo> a = new ArrayList();
  protected Context b;
  String c;
  String d;
  protected AccountDetailBaseItemClickHandler e;
  protected View.OnClickListener f = new AccountDetailCustomModuleBaseWrapper.1(this);
  protected AdapterView.OnItemClickListener g = new AccountDetailCustomModuleBaseWrapper.2(this);
  
  public AccountDetailCustomModuleBaseWrapper(Context paramContext, ArrayList<IPublicAccountConfigAttr.PaConfigInfo> paramArrayList, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.a = paramArrayList;
    this.e = paramAccountDetailBaseItemClickHandler;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  protected static ArrayList<IPublicAccountConfigAttr.PaConfigInfo> a(PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramPublicAccountConfigAttrImpl != null) && (paramPublicAccountConfigAttrImpl.configs != null))
    {
      Iterator localIterator = paramPublicAccountConfigAttrImpl.configs.iterator();
      while (localIterator.hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)localIterator.next();
        int k = localPaConfigInfo.d;
        int j = 1;
        int i = j;
        if (k != 0) {
          if ((localPaConfigInfo.d == 1) && (paramInt == 1)) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0)
        {
          i = paramPublicAccountConfigAttrImpl.type;
          if (i != 2)
          {
            if ((i == 3) || (i == 4)) {
              if (localPaConfigInfo.e == 23)
              {
                if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.b)) && (!TextUtils.isEmpty(localPaConfigInfo.c))) {
                  localArrayList.add(localPaConfigInfo);
                }
              }
              else if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.b))) {
                localArrayList.add(localPaConfigInfo);
              }
            }
          }
          else if (localPaConfigInfo.e == 23)
          {
            if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.c))) {
              localArrayList.add(localPaConfigInfo);
            }
          }
          else if (!TextUtils.isEmpty(localPaConfigInfo.k)) {
            localArrayList.add(localPaConfigInfo);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    IPublicAccountReportUtils localIPublicAccountReportUtils = null;
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
      localObject1 = (QQAppInterface)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject2 = (IPublicAccountDataManager)((QQAppInterface)localObject1).getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject2 != null)
      {
        localObject2 = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject2).findAccountDetailInfo(this.c);
        if ((localObject2 != null) && (((PublicAccountDetailImpl)localObject2).followType == 1))
        {
          i = 1;
          break label98;
        }
      }
    }
    int i = 0;
    label98:
    Object localObject2 = this.b;
    int j;
    if ((localObject2 != null) && ((localObject2 instanceof PublicAccountDetailActivityImpl))) {
      j = PublicAccountDetailImpl.getReportAccountType((AppInterface)localObject1, this.c, null);
    } else {
      j = 1;
    }
    if ((paramPaConfigInfo.a == 3) && (paramPaConfigInfo.e == 23))
    {
      paramPaConfigInfo = paramPaConfigInfo.c;
      localObject1 = new DynamicInfo();
      ((DynamicInfo)localObject1).a(paramPaConfigInfo);
      localObject1 = ((DynamicInfo)localObject1).f.g;
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = this.c;
      if (i != 0) {
        paramPaConfigInfo = "02";
      } else {
        paramPaConfigInfo = "01";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramPaConfigInfo, String.valueOf(j), false);
      return;
    }
    if (paramPaConfigInfo.a == 1)
    {
      paramPaConfigInfo = Uri.parse(paramPaConfigInfo.h);
      try
      {
        paramPaConfigInfo = paramPaConfigInfo.getQueryParameter("article_id");
      }
      catch (Exception paramPaConfigInfo)
      {
        paramPaConfigInfo.printStackTrace();
        paramPaConfigInfo = localIPublicAccountReportUtils;
      }
      localObject1 = paramPaConfigInfo;
      if (TextUtils.isEmpty(paramPaConfigInfo)) {
        localObject1 = "";
      }
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = this.c;
      if (i != 0) {
        paramPaConfigInfo = "02";
      } else {
        paramPaConfigInfo = "01";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", (String)localObject1, paramPaConfigInfo, String.valueOf(j), false);
    }
  }
  
  protected boolean a(ArrayList<IPublicAccountConfigAttr.PaConfigInfo> paramArrayList)
  {
    if (paramArrayList.size() != this.a.size()) {
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (paramArrayList.get(i) != this.a.get(i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailCustomModuleBaseWrapper
 * JD-Core Version:    0.7.0.1
 */