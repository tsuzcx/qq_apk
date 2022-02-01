package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountDetailCustomModuleBaseWrapper
{
  protected Context a;
  protected View.OnClickListener a;
  protected AccountDetailBaseItemClickHandler a;
  protected AdapterView.OnItemClickListener a;
  String a;
  protected ArrayList<PaConfigAttr.PaConfigInfo> a;
  String b;
  
  public AccountDetailCustomModuleBaseWrapper(Context paramContext, ArrayList<PaConfigAttr.PaConfigInfo> paramArrayList, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new AccountDetailCustomModuleBaseWrapper.1(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new AccountDetailCustomModuleBaseWrapper.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailHandlerAccountDetailBaseItemClickHandler = paramAccountDetailBaseItemClickHandler;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  protected static ArrayList<PaConfigAttr.PaConfigInfo> a(PaConfigAttr paramPaConfigAttr, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramPaConfigAttr != null) && (paramPaConfigAttr.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramPaConfigAttr.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)localIterator.next();
        if ((localPaConfigInfo.jdField_b_of_type_Int == 0) || ((localPaConfigInfo.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramPaConfigAttr.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localPaConfigInfo.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localPaConfigInfo.e)) || (TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localPaConfigInfo);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localPaConfigInfo.e))
        {
          localArrayList.add(localPaConfigInfo);
          continue;
          if (localPaConfigInfo.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localPaConfigInfo);
            }
          }
          else if ((!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localPaConfigInfo);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (PublicAccountDataManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((PublicAccountDataManager)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof PublicAccountDetailActivityImpl))) {}
        for (int j = PublicAccountReportUtilsImpl.getReportAccountType((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          String str;
          if ((paramPaConfigInfo.jdField_a_of_type_Int == 3) && (paramPaConfigInfo.jdField_c_of_type_Int == 23))
          {
            paramPaConfigInfo = paramPaConfigInfo.jdField_b_of_type_JavaLangString;
            localObject1 = new DynamicInfo();
            ((DynamicInfo)localObject1).a(paramPaConfigInfo);
            localObject1 = ((DynamicInfo)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            str = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramPaConfigInfo = "02";
              ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramPaConfigInfo, String.valueOf(j), false);
            }
          }
          while (paramPaConfigInfo.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramPaConfigInfo = "01";
            }
          }
          paramPaConfigInfo = Uri.parse(paramPaConfigInfo.jdField_c_of_type_JavaLangString);
          try
          {
            paramPaConfigInfo = paramPaConfigInfo.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramPaConfigInfo))
            {
              paramPaConfigInfo = "";
              localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
              str = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X80077F9", "0X80077F9", 0, 0, "1", paramPaConfigInfo, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramPaConfigInfo)
          {
            for (;;)
            {
              paramPaConfigInfo.printStackTrace();
              paramPaConfigInfo = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  protected boolean a(ArrayList<PaConfigAttr.PaConfigInfo> paramArrayList)
  {
    if (paramArrayList.size() != this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label49;
      }
      if (paramArrayList.get(i) != this.jdField_a_of_type_JavaUtilArrayList.get(i)) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailCustomModuleBaseWrapper
 * JD-Core Version:    0.7.0.1
 */