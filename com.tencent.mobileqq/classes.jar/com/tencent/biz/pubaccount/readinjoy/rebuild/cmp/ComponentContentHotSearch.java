package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import aoqy;
import aoqz;
import bayu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pgd;
import pxj;
import pxt;
import qck;
import qcl;
import qky;
import rqj;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements pxj
{
  public static final String a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MeasureGridView jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView;
  private pgd jdField_a_of_type_Pgd;
  private qcl jdField_a_of_type_Qcl;
  private rqj jdField_a_of_type_Rqj;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentContentHotSearch.class.getSimpleName();
  }
  
  public ComponentContentHotSearch(Context paramContext, rqj paramrqj)
  {
    super(paramContext);
    this.jdField_a_of_type_Rqj = paramrqj;
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559949, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367777));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377979));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371241));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView = ((MeasureGridView)paramView.findViewById(2131367776));
    this.jdField_a_of_type_Qcl = new qcl(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView.setAdapter(this.jdField_a_of_type_Qcl);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new qck(this));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      this.jdField_a_of_type_Pgd = ((pgd)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Pgd.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hotWordInfo;
    if ((paramObject != null) && (paramObject.a != null) && (paramObject.a.size() > 0))
    {
      this.jdField_a_of_type_Qcl.a(paramObject.a);
      paramObject = aoqz.a();
      if ((paramObject == null) || (TextUtils.isEmpty(paramObject.b))) {
        break label191;
      }
    }
    label191:
    for (paramObject = paramObject.b;; paramObject = "http://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png")
    {
      Drawable localDrawable = bayu.a;
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
  
  public void a(pxt parampxt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parampxt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */