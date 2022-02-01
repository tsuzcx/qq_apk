package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public abstract class AdBaseHandler
  implements IBaseHandler
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private IReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a();
  }
  
  public final Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a();
  }
  
  @Nullable
  public View a(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public AnimationSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a();
  }
  
  public final IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a();
  }
  
  public final IReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
  }
  
  @Nullable
  public Boolean a()
  {
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.getItemViewType(paramInt));
  }
  
  public final Object a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.getItem(paramInt);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {}
  
  public void a(int paramInt, @Nullable List<Long> paramList) {}
  
  public void a(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable String paramString, int paramInt) {}
  
  public void a(@Nullable View paramView1, @Nullable View paramView2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(@Nullable View paramView, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView) {}
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView, long paramLong) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public final void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter;
  }
  
  public void a(@Nullable AbsListView paramAbsListView) {}
  
  public void a(@Nullable AbsListView paramAbsListView, int paramInt) {}
  
  public void a(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(@Nullable AdapterView<?> paramAdapterView, @Nullable View paramView, int paramInt, long paramLong) {}
  
  public void a(@Nullable List<? extends AbsBaseArticleInfo> paramList) {}
  
  public void a(@Nullable Map<Integer, ? extends BaseReportData> paramMap) {}
  
  public void a(@Nullable Map<Long, ? extends BaseReportData> paramMap, boolean paramBoolean) {}
  
  public void a(@Nullable Set<Long> paramSet, @Nullable Map<Long, ? extends BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.a();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.b();
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2) {}
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.getCount();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdBaseHandler
 * JD-Core Version:    0.7.0.1
 */