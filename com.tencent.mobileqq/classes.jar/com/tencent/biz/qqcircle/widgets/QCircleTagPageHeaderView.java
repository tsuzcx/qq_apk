package com.tencent.biz.qqcircle.widgets;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tqb;
import ucw;
import ydw;

public class QCircleTagPageHeaderView
  extends BaseWidgetView<ydw>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCircleFollowTagView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public QCircleTagPageHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null) {}
    int i;
    do
    {
      return 0;
      i = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagType.get();
      if (i == 2) {
        return 2130843671;
      }
    } while (i != 3);
    return 2130843670;
  }
  
  private void b()
  {
    try
    {
      String str = tqb.g + "/qcircle_tagpage_background.png";
      if (new File(str).exists())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = ImmersiveUtils.a();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(((ViewGroup.LayoutParams)localObject).width * 0.4D));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131166178));
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getFileDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 2131560576;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131363000));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378861));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368705));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368916));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView = ((QCircleFollowTagView)paramView.findViewById(2131373197));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setItemReportListener(new ucw(this));
    b();
  }
  
  protected void a(ydw paramydw)
  {
    if ((paramydw != null) && ((paramydw.a instanceof FeedCloudMeta.StTagInfo)))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramydw.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagTotalUser.get() + alpo.a(2131698378));
      paramydw = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.userList.get().iterator();
      while (localIterator.hasNext()) {
        paramydw.add(((FeedCloudMeta.StUser)localIterator.next()).id.get());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramydw);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(b());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setTagInfo(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */