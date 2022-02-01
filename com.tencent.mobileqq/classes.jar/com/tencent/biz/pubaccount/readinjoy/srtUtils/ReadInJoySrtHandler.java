package com.tencent.biz.pubaccount.readinjoy.srtUtils;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class ReadInJoySrtHandler
{
  public static int a;
  private static ReadInJoySrtHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoySrtUtilsReadInJoySrtHandler;
  private SparseArray<ReadInJoySrtHandler.IRuleManager> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  private ReadInJoySrtHandler.IRuleManager a(int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager2 = (ReadInJoySrtHandler.IRuleManager)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    ReadInJoySrtHandler.IRuleManager localIRuleManager1 = localIRuleManager2;
    if (localIRuleManager2 == null)
    {
      localIRuleManager1 = SRTFactory.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localIRuleManager1);
    }
    return localIRuleManager1;
  }
  
  public static ReadInJoySrtHandler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoySrtUtilsReadInJoySrtHandler == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoySrtUtilsReadInJoySrtHandler = new ReadInJoySrtHandler();
      }
      ReadInJoySrtHandler localReadInJoySrtHandler = jdField_a_of_type_ComTencentBizPubaccountReadinjoySrtUtilsReadInJoySrtHandler;
      return localReadInJoySrtHandler;
    }
    finally {}
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (localCalendar == null) {
      return "";
    }
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return String.valueOf(i) + j + k;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return "";
    }
    return localIRuleManager.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return;
    }
    localIRuleManager.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return;
    }
    localIRuleManager.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    ReadInJoySrtHandler.IRuleManager localIRuleManager = a(paramInt);
    if (localIRuleManager == null) {
      return false;
    }
    return localIRuleManager.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler
 * JD-Core Version:    0.7.0.1
 */