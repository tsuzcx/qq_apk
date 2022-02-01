package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class IntimateContentItemLoverAchievementView
  extends IntimateContentItemBaseView
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private IntimateContentItemLoverAchievementView.CoupleAchievementItemListener jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementItemListener = new IntimateContentItemLoverAchievementView.1(this);
  private IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter;
  
  public IntimateContentItemLoverAchievementView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = new SpannableString(paramString);
      localObject = new StyleSpan(0);
      paramInt2 += paramInt1;
      paramString.setSpan(localObject, paramInt1, paramInt2, 33);
      paramString.setSpan(new AbsoluteSizeSpan(ViewUtils.a(14.0F)), paramInt1, paramInt2, 33);
      paramString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.jdField_a_of_type_AndroidContentContext, 2131166849)), paramInt1, paramInt2, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getUnBoldContent fail:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("IntimateContentItemLoverAchievementView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void m()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B567", "0X800B567", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559256, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365279));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365281));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)((View)localObject).findViewById(2131365280));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter = new IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter(this, null);
    localObject = new IntimateContentItemLoverAchievementView.2(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 3);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131365279) {
      return;
    }
    paramView = FriendIntimateRelationshipConfProcessor.a().T;
    if (!TextUtils.isEmpty(paramView))
    {
      m();
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramView, 2064, null);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo != null) && (paramIntimateInfo.loveAchievementInfo != null) && (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      setVisibility(0);
      SpannableString localSpannableString = a(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693418), new Object[] { Integer.valueOf(paramIntimateInfo.loveAchievementInfo.b), Integer.valueOf(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_Int) }), 0, 3);
      if (localSpannableString != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter != null) {
        if (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 3) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter.a(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.subList(0, 3));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter.a(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B566", "0X800B566", 0, 0, "", "", "", "");
      return;
    }
    setVisibility(8);
  }
  
  protected boolean a()
  {
    boolean bool3 = FriendIntimateRelationshipConfProcessor.a().b;
    IntimateInfo localIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    boolean bool2 = false;
    int i;
    if ((localIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == 1)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void f()
  {
    RecyclerView localRecyclerView = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(null);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.removeAllViews();
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(null);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
      removeAllViews();
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView
 * JD-Core Version:    0.7.0.1
 */