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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class bogk
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public bogk(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(bogl parambogl)
  {
    int j = 2130844521;
    MusicItemInfo localMusicItemInfo2 = parambogl.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((boje)bogd.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)bogd.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((k == 1) || (k == 5))
    {
      parambogl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      parambogl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambogl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      parambogl.d.setVisibility(8);
      parambogl.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
      parambogl.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
      if ((bool) && (!localMusicItemInfo2.isDownloading()))
      {
        i = 2130844500;
        if (localMusicItemInfo2.isMyMusicInfo())
        {
          i = 2130844516;
          parambogl.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131706505));
          parambogl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          parambogl.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
          parambogl.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          label198:
          parambogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
          localObject = boov.a(localMusicItemInfo2);
          parambogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((boov)localObject);
          if ((!localMusicItemInfo2.isDownloading()) || (((boov)localObject).a != 2)) {
            break label289;
          }
          parambogl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(parambogl, localMusicItemInfo2);
        return;
        parambogl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambogl.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        parambogl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label198;
        label289:
        if (!localMusicItemInfo2.isFileExist()) {
          parambogl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          parambogl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    parambogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
    parambogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
    parambogl.d.setVisibility(8);
    parambogl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    parambogl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    parambogl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    parambogl.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = anvx.a(2131706511);
    int i = 2130844517;
    if (k == 3)
    {
      localObject = anvx.a(2131706508);
      j = 2130844518;
      i = 2130844519;
    }
    for (;;)
    {
      if (bool) {
        parambogl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        parambogl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        parambogl.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 4)
        {
          localObject = anvx.a(2131706506);
          j = 2130844513;
          i = 2130844514;
          break;
        }
        if (k != 10) {
          break label503;
        }
        localObject = anvx.a(2131706512);
        parambogl.d.setVisibility(0);
        i = 2130844521;
        break;
        parambogl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
      label503:
      j = 2130844520;
    }
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371714);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371715);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), ViewUtils.dpToPx(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = ViewUtils.dpToPx(5.0F);
    localLayoutParams.topMargin = ViewUtils.dpToPx(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371713);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = ViewUtils.dpToPx(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371716);
    ((ImageView)localObject2).setImageResource(2130844500);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131374144);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131371733);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131371707);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845935);
    i = ViewUtils.dpToPx(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381546);
    ((ImageView)localObject1).setImageResource(2130845942);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (bogl)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(bogl parambogl, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      parambogl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844515);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.dp2px(80.0F, parambogl.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844515);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844515);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(bgxc.w);
    parambogl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
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
      this.b = ((int)((this.jdField_a_of_type_Int - MusicProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    bogl localbogl;
    if (paramView == null)
    {
      localbogl = new bogl(this);
      paramView = a();
      localbogl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371715));
      localbogl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371713));
      localbogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131371733));
      localbogl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371714));
      localbogl.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374144));
      localbogl.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371716));
      localbogl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371707));
      localbogl.d = ((ImageView)paramView.findViewById(2131381546));
      paramView.setTag(localbogl);
    }
    for (;;)
    {
      localbogl.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      localbogl.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      localbogl.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.b;
      a(localbogl);
      if (localMusicItemInfo.isWsBanner()) {
        zfn.a(localMusicItemInfo);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbogl = (bogl)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogk
 * JD-Core Version:    0.7.0.1
 */