package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static SearchResult jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult;
  private static boolean e = false;
  private static int h;
  int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ClassificationSearchFragment.HistoryGridAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter;
  private ClassificationSearchFragment.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter;
  private List<AccountSearchPb.record> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private boolean d;
  private int g;
  private int i;
  
  public static ClassificationSearchFragment a(int paramInt)
  {
    h = paramInt;
    return new ClassificationSearchFragment();
  }
  
  public static ClassificationSearchFragment a(SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult = paramSearchResult;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    ClassificationSearchFragment.SearchResultAdapter localSearchResultAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList<SearchResult> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject, 2);
        return true;
      }
    }
    return false;
  }
  
  private String c(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramrecord.uin.get());
    ((StringBuilder)localObject1).append("");
    paramItemViewHolder.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    paramItemViewHolder.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    if (paramrecord.uin.get() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramItemViewHolder.jdField_a_of_type_Boolean = bool;
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramItemViewHolder.jdField_b_of_type_Int, paramrecord.name.get()));
    localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
    Object localObject2;
    if (paramItemViewHolder.jdField_b_of_type_Int == 80000000)
    {
      localObject2 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject2).append("(");
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {
        localObject1 = paramItemViewHolder.jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = paramItemViewHolder.jdField_b_of_type_JavaLangString;
      }
      ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
      ((SpannableStringBuilder)localObject2).append(")");
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      if ((!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_JavaLangString)) && (Utils.b(paramItemViewHolder.jdField_a_of_type_JavaLangString)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        Drawable localDrawable = ((Resources)localObject1).getDrawable(2130841838);
        localDrawable.setBounds(0, 0, AIOUtils.b(15.0F, (Resources)localObject1), AIOUtils.b(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
      }
      else
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      j = paramrecord.uint32_richflag1_59.get();
      k = paramrecord.uint32_richflag4_409.get();
      PrettyAccountUtil.a("0X800B238", j, k);
      localObject1 = PrettyAccountUtil.a(j, k, (CharSequence)localObject2, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      PrettyAccountUtil.a(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView, j, k, 2131167139, 17);
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
    }
    int j = this.jdField_d_of_type_Int;
    if (j != 0)
    {
      if (j == 2) {
        localStringBuilder.append(b(paramItemViewHolder, paramrecord));
      }
    }
    else {
      localStringBuilder.append(a(paramItemViewHolder, paramrecord));
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    boolean bool = paramItemViewHolder.jdField_a_of_type_Boolean;
    int k = 11;
    if (bool) {
      j = 1;
    } else {
      j = 11;
    }
    if (paramItemViewHolder.jdField_a_of_type_Boolean) {
      paramrecord = paramItemViewHolder.jdField_a_of_type_JavaLangString;
    } else {
      paramrecord = paramItemViewHolder.jdField_b_of_type_JavaLangString;
    }
    localObject1 = ((IFaceDecoder)localObject1).getBitmapFromCache(j, paramrecord);
    paramrecord = (AccountSearchPb.record)localObject1;
    if (localObject1 == null)
    {
      localObject1 = ImageUtil.f();
      paramrecord = (AccountSearchPb.record)localObject1;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
        if (paramItemViewHolder.jdField_a_of_type_Boolean) {
          paramrecord = paramItemViewHolder.jdField_a_of_type_JavaLangString;
        } else {
          paramrecord = paramItemViewHolder.jdField_b_of_type_JavaLangString;
        }
        j = k;
        if (paramItemViewHolder.jdField_a_of_type_Boolean) {
          j = 1;
        }
        ((IFaceDecoder)localObject2).requestDecodeFace(paramrecord, j, true, (byte)1);
        paramrecord = (AccountSearchPb.record)localObject1;
      }
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isGetMore = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append(" mListData is null = ");
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ClassificationSearchFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList == null))
    {
      g();
      return;
    }
    Object localObject2;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter = new ClassificationSearchFragment.SearchResultAdapter(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      localObject2 = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0) {
        j = 2131702129;
      } else {
        j = 2131702135;
      }
      ((StringBuilder)localObject2).append(HardCodeUtil.a(j));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702131));
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter);
      this.a = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter.a().addAll(this.jdField_a_of_type_JavaUtilList);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$SearchResultAdapter.notifyDataSetChanged();
    if (this.c)
    {
      this.c = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      localObject1 = new StringBuilder();
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(String.valueOf(((AccountSearchPb.record)((Iterator)localObject2).next()).uin.get()));
        ((StringBuilder)localObject1).append("#");
        j += 1;
      }
      localObject2 = ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage((String)localObject2, this.jdField_a_of_type_JavaLangString, 3, true, j, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    b(3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
      } else if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
      }
    }
    else if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      i();
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
      } else if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
      }
      this.c = true;
    }
    else
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131694424, 0).b(b());
      b(4);
    }
    if (this.jdField_d_of_type_Int == 2)
    {
      paramString = getBaseActivity();
      if ((paramString != null) && ((paramString instanceof SearchBaseActivity)))
      {
        int j = ((SearchBaseActivity)paramString).a();
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a();
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(k + 1);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, localStringBuilder.toString(), SearchBaseActivity.JumpSrcConstants.a(j), this.jdField_a_of_type_JavaLangString, "", false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    SearchResult localSearchResult = (SearchResult)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ClassificationSearchFragment.1(this, localSearchResult));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is no more page  = ");
      localStringBuilder.append(localSearchResult.jdField_a_of_type_Boolean);
      QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList = localSearchResult.jdField_b_of_type_JavaUtilList;
    if (!this.jdField_b_of_type_Boolean) {
      e();
    }
    a(paramArrayList);
    return true;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      b(2);
      a(this.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(0);
    }
  }
  
  @TargetApi(9)
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_Int == 2))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getBaseActivity()).inflate(2131559625, null);
        localObject = (GridView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377058);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(AIOUtils.b(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter;
      if ((localObject != null) && (((ClassificationSearchFragment.HistoryGridAdapter)localObject).getCount() > 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter.a();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377061)).setText(getString(2131695247));
        } else {
          ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377061)).setText((CharSequence)localObject);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter;
      if ((localObject != null) && (((ClassificationSearchFragment.HistoryGridAdapter)localObject).a() != null) && (!ClassificationSearchFragment.HistoryGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter.a(false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      boolean bool = localObject1 instanceof SearchBaseFragment.ItemViewHolder;
      Object localObject2 = "";
      Object localObject3;
      int j;
      Object localObject5;
      Object localObject4;
      Object localObject6;
      if (bool)
      {
        localObject3 = (SearchBaseFragment.ItemViewHolder)localObject1;
        a(((SearchBaseFragment.ItemViewHolder)localObject3).jdField_b_of_type_Int, ((SearchBaseFragment.ItemViewHolder)localObject3).jdField_a_of_type_AddcontactsAccountSearchPb$record, 2);
        j = ((SearchBaseFragment.ItemViewHolder)localObject3).c;
        int k = ((SearchBaseFragment.ItemViewHolder)localObject3).jdField_b_of_type_Int;
        int m = ((SearchBaseFragment.ItemViewHolder)localObject3).c;
        if (((SearchBaseFragment.ItemViewHolder)localObject3).jdField_a_of_type_AddcontactsAccountSearchPb$record.uin != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((SearchBaseFragment.ItemViewHolder)localObject3).jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = null;
        }
        SearchUtils.a(k, 0, m, false, (String)localObject1, this.jdField_a_of_type_JavaLangString, UniteSearchActivity.jdField_d_of_type_Int);
        if (((SearchBaseFragment.ItemViewHolder)localObject3).jdField_b_of_type_Int == 80000002)
        {
          localObject5 = ((SearchBaseFragment.ItemViewHolder)localObject3).jdField_a_of_type_AddcontactsAccountSearchPb$record;
          localObject1 = getBaseActivity();
          if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
          {
            localObject4 = SearchBaseActivity.JumpSrcConstants.a(((SearchBaseActivity)localObject1).a());
            localObject1 = paramView.getTag(2131370666);
            if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
              ((SearchBaseFragment.ItemViewHolder)localObject3).c = (((Integer)localObject1).intValue() + 1);
            }
            localObject6 = (IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class);
            if (((AccountSearchPb.record)localObject5).uin != null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
              ((StringBuilder)localObject1).append("");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            else
            {
              localObject1 = "";
            }
            ((IPublicAccountDetailReportUtil)localObject6).setAttrSearchClick(3, (String)localObject1, j, UniteSearchActivity.jdField_d_of_type_Int);
            if (UniteSearchActivity.jdField_d_of_type_Int == 12)
            {
              localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((SearchBaseFragment.ItemViewHolder)localObject3).c);
              ((StringBuilder)localObject1).append("");
              localObject3 = ((StringBuilder)localObject1).toString();
              localObject1 = localObject2;
              if (((AccountSearchPb.record)localObject5).uin != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
                ((StringBuilder)localObject1).append("");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              ReportController.b((AppRuntime)localObject6, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject3, (String)localObject4, (String)localObject1, this.jdField_a_of_type_JavaLangString);
            }
            else
            {
              localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
              localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (((AccountSearchPb.record)localObject5).uin != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
                ((StringBuilder)localObject1).append("");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = "";
              }
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(((SearchBaseFragment.ItemViewHolder)localObject3).c);
              ((StringBuilder)localObject5).append("");
              ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject6, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D22", "0X8005D22", 0, 0, ((StringBuilder)localObject5).toString(), (String)localObject4, this.jdField_a_of_type_JavaLangString, "", false);
            }
          }
        }
      }
      else if ((localObject1 instanceof ClassificationSearchFragment.MoreViewHolder))
      {
        j = this.jdField_a_of_type_Int;
        if ((j == 3) || (j == 4)) {
          if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
          {
            b(1);
          }
          else
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2131694424, 0).b(b());
            b(4);
          }
        }
      }
      else if ((localObject1 instanceof SearchBaseFragment.ArticleItemViewHolder))
      {
        localObject1 = (SearchBaseFragment.ArticleItemViewHolder)localObject1;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_JavaLangString);
        if (UniteSearchActivity.jdField_d_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
        }
        else if (UniteSearchActivity.jdField_d_of_type_Int == 2)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 11);
        }
        else
        {
          j = this.i;
          if (j == 14) {
            ((Intent)localObject2).putExtra("articalChannelId", 14);
          } else if (j == 13) {
            ((Intent)localObject2).putExtra("articalChannelId", 12);
          } else if (j == 15) {
            ((Intent)localObject2).putExtra("articalChannelId", 13);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        if (UniteSearchActivity.jdField_d_of_type_Int == 12)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int);
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = this.jdField_a_of_type_JavaLangString;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long);
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, (String)localObject3, "", (String)localObject4, ((StringBuilder)localObject5).toString());
        }
        else
        {
          localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = this.jdField_a_of_type_JavaLangString;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("");
          ((StringBuilder)localObject6).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long);
          ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, (String)localObject4, "", (String)localObject5, ((StringBuilder)localObject6).toString(), false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2131559212, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ClassificationSearchFragment.HistoryGridAdapter localHistoryGridAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter;
    if (localHistoryGridAdapter != null) {
      localHistoryGridAdapter.a();
    }
    ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).backPage();
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(36);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(36);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult;
    if (paramView != null)
    {
      b(paramView.jdField_a_of_type_Boolean ^ true);
      this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult.jdField_b_of_type_Int);
      if (ViewFactory.a(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult.jdField_a_of_type_Int) == 2131689696) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784)).setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      } else {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784)).setText(ViewFactory.a(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult.jdField_a_of_type_Int));
      }
      if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        paramView = new ArrayList();
        paramView.add(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult);
        a(paramView);
      }
      jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult = null;
      a();
    }
    else
    {
      if ((h != ClassificationSearchActivity.jdField_a_of_type_Int) && (h != ClassificationSearchActivity.jdField_b_of_type_Int))
      {
        if ((h == ClassificationSearchActivity.c) || (h == ClassificationSearchActivity.e)) {
          ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784)).setText(ViewFactory.a(80000002));
        }
      }
      else {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784)).setText(ViewFactory.a(80000003));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      g();
    }
    this.g = c();
    if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$HistoryGridAdapter = new ClassificationSearchFragment.HistoryGridAdapter(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */