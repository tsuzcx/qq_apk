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

public class bmqs
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public bmqs(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(bmqt parambmqt)
  {
    int j = 2130844454;
    MusicItemInfo localMusicItemInfo2 = parambmqt.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((bmtm)bmql.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)bmql.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    if ((k == 1) || (k == 5))
    {
      parambmqt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      parambmqt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambmqt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      parambmqt.d.setVisibility(8);
      parambmqt.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
      parambmqt.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
      if ((bool) && (!localMusicItemInfo2.isDownloading()))
      {
        i = 2130844433;
        if (localMusicItemInfo2.isMyMusicInfo())
        {
          i = 2130844449;
          parambmqt.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131706153));
          parambmqt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          parambmqt.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
          parambmqt.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          label198:
          parambmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
          localObject = bmzd.a(localMusicItemInfo2);
          parambmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a((bmzd)localObject);
          if ((!localMusicItemInfo2.isDownloading()) || (((bmzd)localObject).a != 2)) {
            break label289;
          }
          parambmqt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(parambmqt, localMusicItemInfo2);
        return;
        parambmqt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambmqt.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        parambmqt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label198;
        label289:
        if (!localMusicItemInfo2.isFileExist()) {
          parambmqt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          parambmqt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    parambmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(null);
    parambmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
    parambmqt.d.setVisibility(8);
    parambmqt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    parambmqt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    parambmqt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    parambmqt.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = amtj.a(2131706159);
    int i = 2130844450;
    if (k == 3)
    {
      localObject = amtj.a(2131706156);
      j = 2130844451;
      i = 2130844452;
    }
    for (;;)
    {
      if (bool) {
        parambmqt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      for (;;)
      {
        parambmqt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        parambmqt.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (k == 4)
        {
          localObject = amtj.a(2131706154);
          j = 2130844446;
          i = 2130844447;
          break;
        }
        if (k != 10) {
          break label503;
        }
        localObject = amtj.a(2131706160);
        parambmqt.d.setVisibility(0);
        i = 2130844454;
        break;
        parambmqt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      }
      label503:
      j = 2130844453;
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
    ((ImageView)localObject2).setId(2131371528);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371529);
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
    ((TextView)localObject2).setId(2131371527);
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
    ((ImageView)localObject2).setId(2131371530);
    ((ImageView)localObject2).setImageResource(2130844433);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131373915);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131371547);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131371521);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130845847);
    i = ViewUtils.dpToPx(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381184);
    ((ImageView)localObject1).setImageResource(2130845854);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (bmqt)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(bmqt parambmqt, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      parambmqt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844448);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.dp2px(80.0F, parambmqt.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844448);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844448);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(bfol.w);
    parambmqt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
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
    bmqt localbmqt;
    if (paramView == null)
    {
      localbmqt = new bmqt(this);
      paramView = a();
      localbmqt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371529));
      localbmqt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371527));
      localbmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131371547));
      localbmqt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371528));
      localbmqt.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373915));
      localbmqt.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371530));
      localbmqt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371521));
      localbmqt.d = ((ImageView)paramView.findViewById(2131381184));
      paramView.setTag(localbmqt);
    }
    for (;;)
    {
      localbmqt.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      localbmqt.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
      localbmqt.jdField_a_of_type_Int = paramInt;
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
        paramView.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams1.height = this.b;
      a(localbmqt);
      if (localMusicItemInfo.isWsBanner()) {
        yqu.a(localMusicItemInfo);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbmqt = (bmqt)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqs
 * JD-Core Version:    0.7.0.1
 */