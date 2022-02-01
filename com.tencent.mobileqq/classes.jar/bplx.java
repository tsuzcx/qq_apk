import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class bplx
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public bplx(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(bply parambply)
  {
    int j = 2130844583;
    MusicItemInfo localMusicItemInfo2 = parambply.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((bpoz)bplq.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)bplq.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_Int == 5) && (this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (localMusicItemInfo2.mType == 2) && (localObject != null) && (((MusicItemInfo)localObject).equals(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))) {
      bool = true;
    }
    for (;;)
    {
      if ((k == 1) || (k == 5))
      {
        parambply.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambply.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        parambply.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        parambply.d.setVisibility(8);
        parambply.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
        parambply.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
        if ((bool) && (!localMusicItemInfo2.isDownloading()))
        {
          i = 2130844563;
          if (localMusicItemInfo2.isMyMusicInfo())
          {
            i = 2130844579;
            parambply.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131705923));
            parambply.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            parambply.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
            parambply.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            label251:
            parambply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
            localObject = bpvy.a(localMusicItemInfo2);
            parambply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((bpvy)localObject);
            if ((!localMusicItemInfo2.isDownloading()) || (((bpvy)localObject).a != 2)) {
              break label342;
            }
            parambply.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        for (;;)
        {
          a(parambply, localMusicItemInfo2);
          return;
          parambply.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          parambply.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          parambply.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label251;
          label342:
          if (!localMusicItemInfo2.isFileExist()) {
            parambply.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            parambply.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      parambply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
      parambply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambply.d.setVisibility(8);
      parambply.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambply.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambply.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      parambply.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = anzj.a(2131705929);
      int i = 2130844580;
      if (k == 3)
      {
        localObject = anzj.a(2131705926);
        j = 2130844581;
        i = 2130844582;
        if (!bool) {
          break label582;
        }
        parambply.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        parambply.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        parambply.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 6)
        {
          localObject = anzj.a(2131705925);
          break;
        }
        if (k == 8)
        {
          localObject = anzj.a(2131705931);
          break;
        }
        if (k == 4)
        {
          localObject = anzj.a(2131705924);
          j = 2130844576;
          i = 2130844577;
          break;
        }
        if (k != 10) {
          break;
        }
        localObject = anzj.a(2131705930);
        j = 2130844584;
        i = 2130844584;
        parambply.d.setVisibility(0);
        break;
        label582:
        parambply.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = bhtq.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371560);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371561);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), bhtq.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = bhtq.b(5.0F);
    localLayoutParams.topMargin = bhtq.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371559);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = bhtq.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = bhtq.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371562);
    ((ImageView)localObject2).setImageResource(2130844563);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131374172);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = bhtq.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131371579);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131371553);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845947);
    i = bhtq.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381467);
    ((ImageView)localObject1).setImageResource(2130845954);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (bply)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(bply parambply, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      parambply.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844578);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = agej.a(80.0F, parambply.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844578);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844578);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(bhez.w);
    parambply.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
  }
  
  public void a(List<MusicItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Int <= 0) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Int = paramViewGroup.getMeasuredWidth();
      this.jdField_b_of_type_Int = ((int)((this.jdField_a_of_type_Int - MusicProviderPagerAdapter.jdField_b_of_type_Int * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    bply localbply;
    if (paramView == null)
    {
      localbply = new bply(this);
      paramView = a();
      localbply.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371561));
      localbply.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371559));
      localbply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131371579));
      localbply.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371560));
      localbply.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374172));
      localbply.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371562));
      localbply.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371553));
      localbply.d = ((ImageView)paramView.findViewById(2131381467));
      paramView.setTag(localbply);
    }
    for (;;)
    {
      localbply.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      localbply.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      localbply.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.jdField_b_of_type_Int;
      a(localbply);
      if (localMusicItemInfo.isWsBanner()) {
        zqd.a(localMusicItemInfo);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbply = (bply)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplx
 * JD-Core Version:    0.7.0.1
 */