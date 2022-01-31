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
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class bhft
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public bhft(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(bhfu parambhfu)
  {
    int j = 2130843665;
    MusicItemInfo localMusicItemInfo2 = parambhfu.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((bhiu)bhfm.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)bhfm.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_Int == 5) && (this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (localMusicItemInfo2.mType == 2) && (localObject != null) && (((MusicItemInfo)localObject).equals(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))) {
      bool = true;
    }
    for (;;)
    {
      if ((k == 1) || (k == 5))
      {
        parambhfu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parambhfu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        parambhfu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        parambhfu.d.setVisibility(8);
        parambhfu.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
        parambhfu.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
        if ((bool) && (!localMusicItemInfo2.isDownloading()))
        {
          i = 2130843641;
          if (localMusicItemInfo2.isMyMusicInfo())
          {
            i = 2130843661;
            parambhfu.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641245));
            parambhfu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            parambhfu.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
            parambhfu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            label251:
            parambhfu.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
            localObject = bhpu.a(localMusicItemInfo2);
            parambhfu.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((bhpu)localObject);
            if ((!localMusicItemInfo2.isDownloading()) || (((bhpu)localObject).a != 2)) {
              break label342;
            }
            parambhfu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        for (;;)
        {
          a(parambhfu, localMusicItemInfo2);
          return;
          parambhfu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          parambhfu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          parambhfu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label251;
          label342:
          if (!localMusicItemInfo2.isFileExist()) {
            parambhfu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            parambhfu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      parambhfu.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
      parambhfu.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      parambhfu.d.setVisibility(8);
      parambhfu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambhfu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambhfu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      parambhfu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = ajjy.a(2131641251);
      int i = 2130843662;
      if (k == 3)
      {
        localObject = ajjy.a(2131641248);
        j = 2130843663;
        i = 2130843664;
        if (!bool) {
          break label582;
        }
        parambhfu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        parambhfu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        parambhfu.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 6)
        {
          localObject = ajjy.a(2131641247);
          break;
        }
        if (k == 8)
        {
          localObject = ajjy.a(2131641253);
          break;
        }
        if (k == 4)
        {
          localObject = ajjy.a(2131641246);
          j = 2130843658;
          i = 2130843659;
          break;
        }
        if (k != 10) {
          break;
        }
        localObject = ajjy.a(2131641252);
        j = 2130843666;
        i = 2130843666;
        parambhfu.d.setVisibility(0);
        break;
        label582:
        parambhfu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = bajq.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131304899);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131304900);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), bajq.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = bajq.b(5.0F);
    localLayoutParams.topMargin = bajq.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131304898);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = bajq.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = bajq.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131304901);
    ((ImageView)localObject2).setImageResource(2130843641);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131307129);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = bajq.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131304918);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131304891);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845012);
    i = bajq.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131313680);
    ((ImageView)localObject1).setImageResource(2130845019);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (bhfu)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(bhfu parambhfu, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      parambhfu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843660);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = aciy.a(80.0F, parambhfu.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843660);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843660);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(azue.v);
    parambhfu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
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
    if (paramView == null)
    {
      paramViewGroup = new bhfu(this);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304900));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304898));
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131304918));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304899));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131307129));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304901));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304891));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131313680));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.jdField_b_of_type_Int;
      a(paramViewGroup);
      if (localMusicItemInfo.isWsBanner()) {
        vnd.a(localMusicItemInfo);
      }
      return paramView;
      paramViewGroup = (bhfu)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhft
 * JD-Core Version:    0.7.0.1
 */