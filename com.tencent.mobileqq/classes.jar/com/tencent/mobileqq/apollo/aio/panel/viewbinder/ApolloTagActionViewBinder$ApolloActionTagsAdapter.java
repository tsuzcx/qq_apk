package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.HashMap;
import java.util.List;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private ApolloTagButtonData jdField_a_of_type_ComTencentMobileqqApolloModelApolloTagButtonData = new ApolloTagButtonData(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder.a, false);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<ApolloTagButtonData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public ApolloTagActionViewBinder$ApolloActionTagsAdapter(Context paramContext, List<ApolloTagButtonData> paramList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramList;
    this.jdField_a_of_type_JavaUtilList = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloTagButtonData);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  private HashMap<String, String> a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ApolloDtReportUtil.a("aio", "tagpage", "tagexpose", this.jdField_a_of_type_JavaUtilHashMap);
      ApolloDtReportUtil.a("aio", "tagpage", "tagclick", this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    ApolloDtReportUtil.a("aio", "tagpage", "qxtagclick", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      return ViewUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165890), ViewUtils.a(paramInt2));
    }
    return ViewUtils.a(paramInt1, ViewUtils.a(paramInt2));
  }
  
  public ApolloTagButtonData a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return (ApolloTagButtonData)localList.get(paramInt);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558615, paramViewGroup, false);
    }
    paramView = (Button)localView.findViewById(2131364082);
    paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838402);
    paramViewGroup.setBounds(0, 0, paramViewGroup.getMinimumWidth(), paramViewGroup.getMinimumHeight());
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167366);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167002);
    paramView.setCompoundDrawables(null, null, null, null);
    paramView.setText(((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).tag);
    paramView.setContentDescription(((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).tag);
    paramView.setBackgroundDrawable(a(i, 14));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165891));
    }
    else if (((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).isSelected)
    {
      paramView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167003));
      paramView.setBackgroundDrawable(a(j, 14));
      paramView.setCompoundDrawables(paramViewGroup, null, null, null);
    }
    else
    {
      paramView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167367));
      paramView.setBackgroundDrawable(a(i, 14));
      paramView.setCompoundDrawables(null, null, null, null);
    }
    paramView.setOnClickListener(new ApolloTagActionViewBinder.ApolloActionTagsAdapter.1(this, paramView, paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter
 * JD-Core Version:    0.7.0.1
 */