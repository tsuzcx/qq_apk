package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amvl;
import amvm;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import aywk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pax;
import pqr;
import prb;
import pvt;
import pvu;
import qbf;
import rap;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements pqr
{
  public static final String a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MeasureGridView jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView;
  private pax jdField_a_of_type_Pax;
  private pvu jdField_a_of_type_Pvu;
  private rap jdField_a_of_type_Rap;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentContentHotSearch.class.getSimpleName();
  }
  
  public ComponentContentHotSearch(Context paramContext, rap paramrap)
  {
    super(paramContext);
    this.jdField_a_of_type_Rap = paramrap;
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559855, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367638));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377390));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131370911));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView = ((MeasureGridView)paramView.findViewById(2131367637));
    this.jdField_a_of_type_Pvu = new pvu(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView.setAdapter(this.jdField_a_of_type_Pvu);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new pvt(this));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      this.jdField_a_of_type_Pax = ((pax)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Pax.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hotWordInfo;
    if ((paramObject != null) && (paramObject.a != null) && (paramObject.a.size() > 0))
    {
      this.jdField_a_of_type_Pvu.a(paramObject.a);
      paramObject = amvm.a();
      if ((paramObject == null) || (TextUtils.isEmpty(paramObject.b))) {
        break label191;
      }
    }
    label191:
    for (paramObject = paramObject.b;; paramObject = "http://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png")
    {
      Drawable localDrawable = aywk.a;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramObject);
      if ((paramObject.getStatus() == 1) || (paramObject.getStatus() == 0)) {
        break;
      }
      paramObject.restartDownload();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "bindData hotWordInfo is null or hotWordItems is null ");
      return;
    }
  }
  
  public void a(prb paramprb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramprb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */