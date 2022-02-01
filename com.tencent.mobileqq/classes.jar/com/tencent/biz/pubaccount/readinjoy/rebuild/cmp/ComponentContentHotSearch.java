package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfBean;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements ComponentInheritView
{
  public static final String a;
  public static String b = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ComponentContentHotSearch.HotWordsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$HotWordsAdapter;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private MeasureGridView jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentContentHotSearch.class.getSimpleName();
  }
  
  public ComponentContentHotSearch(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560240, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368554));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131379477));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372372));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView = ((MeasureGridView)paramView.findViewById(2131368553));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$HotWordsAdapter = new ComponentContentHotSearch.HotWordsAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$HotWordsAdapter);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ComponentContentHotSearch.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = ((IReadInJoyModel)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hotWordInfo;
    if ((paramObject != null) && (paramObject.a != null) && (paramObject.a.size() > 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch$HotWordsAdapter.a(paramObject.a);
      paramObject = ReadInjoySearchJumpurlConfProcessor.a();
      if ((paramObject == null) || (TextUtils.isEmpty(paramObject.b))) {
        break label191;
      }
    }
    label191:
    for (paramObject = paramObject.b;; paramObject = "https://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png")
    {
      Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */