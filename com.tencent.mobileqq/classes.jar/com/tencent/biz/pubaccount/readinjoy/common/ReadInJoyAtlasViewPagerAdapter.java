package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader.Result;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImageList;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelRecommend;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyGallery;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lna;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class ReadInJoyAtlasViewPagerAdapter
  extends PagerAdapter
  implements ReadInJoyAtlasAdapter.OnLoadMoreClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  public static final String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new lna(this);
  private View jdField_a_of_type_AndroidViewView;
  public ReadInJoyAtlasAdapter a;
  private ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener;
  public Gallery a;
  private List jdField_a_of_type_JavaUtilList;
  private List b = new ArrayList();
  private List c = new ArrayList();
  private List d = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ReadInJoyAtlasViewPagerAdapter.class.getSimpleName();
  }
  
  public ReadInJoyAtlasViewPagerAdapter(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a();
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup, AtlasModelRecommend paramAtlasModelRecommend)
  {
    paramViewGroup.removeAllViews();
    int k = paramAtlasModelRecommend.recommendGalleryList.size();
    int m = (int)((ScreenUtil.a - DisplayUtil.a(paramContext, 3.0F)) / 2 * 1.0F / 1.537F);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject3 = (gallery.GalleryInfo)paramAtlasModelRecommend.recommendGalleryList.get(j);
      Object localObject1 = new gallery.PictureInfo();
      ((gallery.PictureInfo)localObject1).set(((gallery.GalleryInfo)localObject3).rpt_msg_summary_pic.get(0));
      ((gallery.PictureInfo)localObject1).bytes_pic_desc.set(((gallery.GalleryInfo)localObject3).bytes_subject.get());
      ReadInJoyAtlasManager.a();
      Object localObject2 = ReadInJoyAtlasManager.a((gallery.GalleryInfo)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ReadInJoyUtils.a((String)localObject2, 750, 415);
        ((gallery.PictureInfo)localObject1).bytes_pic_url.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      }
      localObject1 = new AtlasModelImage(((gallery.GalleryInfo)localObject3).bytes_row_key.get().toStringUtf8(), (gallery.PictureInfo)localObject1);
      localObject2 = LayoutInflater.from(paramContext).inflate(2130969549, paramViewGroup, false);
      if (j != 0) {
        ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), DisplayUtil.a(paramContext, 12.0F), ((View)localObject2).getPaddingRight(), ((View)localObject2).getPaddingBottom());
      }
      Object localObject4 = (LinearLayout)((View)localObject2).findViewById(2131366924);
      a(paramViewGroup, (LinearLayout)localObject4, (AtlasModelImage)localObject1, (gallery.GalleryInfo)localObject3, j);
      ((LinearLayout)localObject4).setTag(2131362472, localObject3);
      ((LinearLayout)localObject4).setTag(2131362473, Integer.valueOf(j));
      ((LinearLayout)localObject4).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject3 = (LinearLayout)((View)localObject2).findViewById(2131366925);
      if (j + 1 < k)
      {
        localObject4 = (gallery.GalleryInfo)paramAtlasModelRecommend.recommendGalleryList.get(j + 1);
        localObject1 = (gallery.PictureInfo)((gallery.GalleryInfo)localObject4).rpt_msg_summary_pic.get(0);
        String str1 = ((gallery.GalleryInfo)localObject4).bytes_row_key.get().toStringUtf8();
        ((gallery.PictureInfo)localObject1).bytes_pic_desc.set(((gallery.GalleryInfo)localObject4).bytes_subject.get());
        ReadInJoyAtlasManager.a();
        String str2 = ReadInJoyAtlasManager.a((gallery.GalleryInfo)localObject4);
        if (!TextUtils.isEmpty(str2))
        {
          str2 = ReadInJoyUtils.a(str2, 750, 415);
          ((gallery.PictureInfo)localObject1).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(str2));
        }
        localObject1 = new AtlasModelImage(str1, (gallery.PictureInfo)localObject1);
        a(paramViewGroup, (LinearLayout)localObject3, (AtlasModelImage)localObject1, (gallery.GalleryInfo)localObject4, j + 1);
        ((LinearLayout)localObject3).setTag(2131362472, localObject4);
        ((LinearLayout)localObject3).setTag(2131362473, Integer.valueOf(j + 1));
        ((LinearLayout)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        ((View)localObject2).setTag(localObject1);
        paramViewGroup.addView((View)localObject2, -1, -2);
        j += 2;
        i += m;
        break;
        ((LinearLayout)localObject3).setVisibility(4);
      }
    }
    paramViewGroup.setTag(paramAtlasModelRecommend);
    j = View.MeasureSpec.makeMeasureSpec(0, 0);
    k = View.MeasureSpec.makeMeasureSpec(0, 0);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      ((LinearLayout)paramViewGroup).setGravity(16);
      return paramViewGroup;
    }
    paramViewGroup.measure(j, k);
    this.jdField_a_of_type_AndroidViewView.measure(j, k);
    j = paramViewGroup.getMeasuredHeight();
    k = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    if (j + i >= ScreenUtil.b - k * 2)
    {
      paramViewGroup.setPadding(0, k, 0, 0);
      return paramViewGroup;
    }
    ((LinearLayout)paramViewGroup).setGravity(16);
    return paramViewGroup;
  }
  
  public AtlasModel a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetGallery == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter == null)) {}
    int i;
    do
    {
      return null;
      i = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition();
    } while (i < 0);
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(i);
  }
  
  public List a()
  {
    return this.b;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener != null) && (a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < a()) && (paramInt >= 0)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup, LinearLayout paramLinearLayout, AtlasModelImage paramAtlasModelImage, gallery.GalleryInfo paramGalleryInfo, int paramInt)
  {
    paramLinearLayout.setVisibility(0);
    URLImageView localURLImageView = (URLImageView)paramLinearLayout.findViewById(2131361846);
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131365664);
    a(paramViewGroup, localURLImageView, paramAtlasModelImage.pictureInfo.bytes_pic_url.get().toStringUtf8());
    paramLinearLayout.setText(paramAtlasModelImage.pictureInfo.bytes_pic_desc.get().toStringUtf8());
    long l = paramGalleryInfo.uint64_article_id.get();
    paramViewGroup = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    paramLinearLayout = paramGalleryInfo.bytes_report_exdata.get().toStringUtf8();
    paramGalleryInfo.int32_reason.get();
    paramViewGroup = GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, ReadInJoyUtils.a(), 2, l, System.currentTimeMillis(), paramInt, paramViewGroup, paramLinearLayout, 4);
    this.b.add(paramViewGroup);
    this.c.add(Integer.valueOf(paramInt));
    this.d.add(paramGalleryInfo);
  }
  
  public void a(ViewGroup paramViewGroup, URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramViewGroup != null)
    {
      localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
      localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
    }
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mPlayGifImage = true;
    paramViewGroup = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramViewGroup.getStatus() != 1) {
      paramViewGroup.startDownload();
    }
    paramURLImageView.setImageDrawable(paramViewGroup);
    paramURLImageView.setTag(paramString);
  }
  
  public void a(ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener paramOnChildGalleryEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener = paramOnChildGalleryEventListener;
  }
  
  public void a(ReadinjoyAtlasPageLoader.Result paramResult)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(paramResult);
    }
  }
  
  public void a(AtlasModel paramAtlasModel)
  {
    a(paramAtlasModel, false);
  }
  
  public void a(AtlasModel paramAtlasModel, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (paramAtlasModel == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateData atlasModel is null.");
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramAtlasModel);
    notifyDataSetChanged();
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(paramView, paramInt, a());
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener != null) && (a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener.a(paramInt, a());
    }
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener != null) && (a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener.b(paramInt, a());
    }
    return true;
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery == null)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.b(paramList, paramBoolean);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AtlasModel localAtlasModel = (AtlasModel)((Iterator)localObject).next();
      if ((localAtlasModel instanceof AtlasModelImageList))
      {
        localObject = (AtlasModelImageList)localAtlasModel;
        ((AtlasModelImageList)localObject).imageList.addAll(paramList);
        ((AtlasModelImageList)localObject).hasMoreData = paramBoolean;
        return true;
      }
    }
    return false;
  }
  
  public AtlasModel b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a();
  }
  
  public List b()
  {
    return this.c;
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(paramInt, a());
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener != null) && (a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener.a(paramInt, a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a());
      paramAdapterView = a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(paramAdapterView);
    }
  }
  
  public List c()
  {
    return this.d;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (AtlasModel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((AtlasModel)localObject).type == 3)
    {
      localObject = (AtlasModelImageList)localObject;
      if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
      {
        this.jdField_a_of_type_ComTencentWidgetGallery = new ReadInJoyGallery(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this);
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(this);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter = new ReadInJoyAtlasAdapter(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(this);
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(((AtlasModelImageList)localObject).imageList, ((AtlasModelImageList)localObject).hasMoreData);
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetGallery.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentWidgetGallery);
      }
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetGallery);
      return this.jdField_a_of_type_ComTencentWidgetGallery;
    }
    if (((AtlasModel)localObject).type == 2)
    {
      localObject = (AtlasModelRecommend)localObject;
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      a(this.jdField_a_of_type_AndroidContentContext, localLinearLayout, (AtlasModelRecommend)localObject);
      paramViewGroup.addView(localLinearLayout);
      return localLinearLayout;
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */