package com.tencent.biz.pubaccount.weishi_new.drama.gallery;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSDramaGalleryHolder
  extends WSAbsCheckableHolder<WSDramaItemData>
{
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(7.5F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  private TextView c;
  
  public WSDramaGalleryHolder(ViewGroup paramViewGroup, String paramString, OnCheckedListener<WSDramaItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 2131559999, paramOnCheckedListener);
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
    c();
  }
  
  private void a(stDramaInfo paramstDramaInfo)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(WSDramaUtils.a(getContext(), paramstDramaInfo));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)this.itemView.findViewById(2131365900));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.itemView.findViewById(2131365901));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.itemView.findViewById(2131365903));
    this.b = ((TextView)this.itemView.findViewById(2131365904));
    this.c = ((TextView)this.itemView.findViewById(2131365902));
  }
  
  private void c()
  {
    this.itemView.setOnClickListener(new WSDramaGalleryHolder.1(this));
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    super.a(paramWSDramaItemData);
    a(paramWSDramaItemData.a());
    paramWSDramaItemData = paramWSDramaItemData.a().dramaInfo;
    a(paramWSDramaItemData);
    this.b.setText(paramWSDramaItemData.name);
    this.c.setText(paramWSDramaItemData.recmdDesc);
    WSPicLoader.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, WeishiUtils.a(paramWSDramaItemData.coverImg), WSFeedUtils.a(2131167331), "", 0);
  }
  
  public void a(WSDramaGalleryHolder paramWSDramaGalleryHolder)
  {
    WSDramaBeaconReport.a((WSDramaItemData)paramWSDramaGalleryHolder.a(), getAdapterPosition(), this.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841877);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841876);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryHolder
 * JD-Core Version:    0.7.0.1
 */