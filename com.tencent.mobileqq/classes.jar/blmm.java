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

public class blmm
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public blmm(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(blmn paramblmn)
  {
    int j = 2130844100;
    MusicItemInfo localMusicItemInfo2 = paramblmn.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((blpo)blmf.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)blmf.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_Int == 5) && (this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (localMusicItemInfo2.mType == 2) && (localObject != null) && (((MusicItemInfo)localObject).equals(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))) {
      bool = true;
    }
    for (;;)
    {
      if ((k == 1) || (k == 5))
      {
        paramblmn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramblmn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramblmn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramblmn.d.setVisibility(8);
        paramblmn.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
        paramblmn.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
        if ((bool) && (!localMusicItemInfo2.isDownloading()))
        {
          i = 2130844080;
          if (localMusicItemInfo2.isMyMusicInfo())
          {
            i = 2130844096;
            paramblmn.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131707413));
            paramblmn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            paramblmn.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
            paramblmn.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            label251:
            paramblmn.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
            localObject = blwn.a(localMusicItemInfo2);
            paramblmn.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((blwn)localObject);
            if ((!localMusicItemInfo2.isDownloading()) || (((blwn)localObject).a != 2)) {
              break label342;
            }
            paramblmn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        for (;;)
        {
          a(paramblmn, localMusicItemInfo2);
          return;
          paramblmn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          paramblmn.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramblmn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label251;
          label342:
          if (!localMusicItemInfo2.isFileExist()) {
            paramblmn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            paramblmn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      paramblmn.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
      paramblmn.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      paramblmn.d.setVisibility(8);
      paramblmn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramblmn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramblmn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramblmn.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = alpo.a(2131707419);
      int i = 2130844097;
      if (k == 3)
      {
        localObject = alpo.a(2131707416);
        j = 2130844098;
        i = 2130844099;
        if (!bool) {
          break label582;
        }
        paramblmn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        paramblmn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramblmn.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 6)
        {
          localObject = alpo.a(2131707415);
          break;
        }
        if (k == 8)
        {
          localObject = alpo.a(2131707421);
          break;
        }
        if (k == 4)
        {
          localObject = alpo.a(2131707414);
          j = 2130844093;
          i = 2130844094;
          break;
        }
        if (k != 10) {
          break;
        }
        localObject = alpo.a(2131707420);
        j = 2130844101;
        i = 2130844101;
        paramblmn.d.setVisibility(0);
        break;
        label582:
        paramblmn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = bdkf.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131370869);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131370870);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), bdkf.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = bdkf.b(5.0F);
    localLayoutParams.topMargin = bdkf.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131370868);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = bdkf.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = bdkf.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131370871);
    ((ImageView)localObject2).setImageResource(2130844080);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131373281);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = bdkf.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131370887);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131370861);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845462);
    i = bdkf.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131380241);
    ((ImageView)localObject1).setImageResource(2130845469);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (blmn)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(blmn paramblmn, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      paramblmn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844095);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = aekt.a(80.0F, paramblmn.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844095);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844095);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(bcuq.v);
    paramblmn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
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
      paramViewGroup = new blmn(this);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370870));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370868));
      paramViewGroup.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131370887));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370869));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373281));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370871));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370861));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131380241));
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
        xoo.a(localMusicItemInfo);
      }
      return paramView;
      paramViewGroup = (blmn)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmm
 * JD-Core Version:    0.7.0.1
 */