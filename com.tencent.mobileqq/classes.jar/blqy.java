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

public class blqy
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public blqy(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(blqz paramblqz)
  {
    int j = 2130844172;
    MusicItemInfo localMusicItemInfo2 = paramblqz.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((blua)blqr.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)blqr.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_Int == 5) && (this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (localMusicItemInfo2.mType == 2) && (localObject != null) && (((MusicItemInfo)localObject).equals(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))) {
      bool = true;
    }
    for (;;)
    {
      if ((k == 1) || (k == 5))
      {
        paramblqz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramblqz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramblqz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramblqz.d.setVisibility(8);
        paramblqz.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
        paramblqz.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
        if ((bool) && (!localMusicItemInfo2.isDownloading()))
        {
          i = 2130844152;
          if (localMusicItemInfo2.isMyMusicInfo())
          {
            i = 2130844168;
            paramblqz.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131707425));
            paramblqz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            paramblqz.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
            paramblqz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            label251:
            paramblqz.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
            localObject = bmaz.a(localMusicItemInfo2);
            paramblqz.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((bmaz)localObject);
            if ((!localMusicItemInfo2.isDownloading()) || (((bmaz)localObject).a != 2)) {
              break label342;
            }
            paramblqz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        for (;;)
        {
          a(paramblqz, localMusicItemInfo2);
          return;
          paramblqz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          paramblqz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramblqz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label251;
          label342:
          if (!localMusicItemInfo2.isFileExist()) {
            paramblqz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            paramblqz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      paramblqz.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
      paramblqz.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      paramblqz.d.setVisibility(8);
      paramblqz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramblqz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramblqz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramblqz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = alud.a(2131707431);
      int i = 2130844169;
      if (k == 3)
      {
        localObject = alud.a(2131707428);
        j = 2130844170;
        i = 2130844171;
        if (!bool) {
          break label582;
        }
        paramblqz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        paramblqz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramblqz.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 6)
        {
          localObject = alud.a(2131707427);
          break;
        }
        if (k == 8)
        {
          localObject = alud.a(2131707433);
          break;
        }
        if (k == 4)
        {
          localObject = alud.a(2131707426);
          j = 2130844165;
          i = 2130844166;
          break;
        }
        if (k != 10) {
          break;
        }
        localObject = alud.a(2131707432);
        j = 2130844173;
        i = 2130844173;
        paramblqz.d.setVisibility(0);
        break;
        label582:
        paramblqz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = bdoo.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131370888);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131370889);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), bdoo.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = bdoo.b(5.0F);
    localLayoutParams.topMargin = bdoo.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131370887);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = bdoo.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = bdoo.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131370890);
    ((ImageView)localObject2).setImageResource(2130844152);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131373333);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = bdoo.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131370906);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131370880);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845534);
    i = bdoo.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131380299);
    ((ImageView)localObject1).setImageResource(2130845541);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (blqz)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(blqz paramblqz, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      paramblqz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844167);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = aepi.a(80.0F, paramblqz.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844167);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844167);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(bcyz.v);
    paramblqz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
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
      paramViewGroup = new blqz(this);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370889));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370887));
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131370906));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370888));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373333));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370890));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370880));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131380299));
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
        xsx.a(localMusicItemInfo);
      }
      return paramView;
      paramViewGroup = (blqz)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqy
 * JD-Core Version:    0.7.0.1
 */