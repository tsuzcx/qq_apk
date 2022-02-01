package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import feedcloud.FeedCloudMeta.StFeedAbstract;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StRankingItem;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleFeedBase.StRankingItemBusiData;
import uxh;
import vxf;
import vxg;
import zxj;

public class QCircleFuelRankItemView
  extends QCircleBaseWidgetView<List<FeedCloudMeta.StRankingItem>>
{
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCirclePlusFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private zxj jdField_a_of_type_Zxj;
  private TextView b;
  private TextView c;
  
  public QCircleFuelRankItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFuelRankItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCircleFuelRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleFuelRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return 2131560773;
  }
  
  protected String a()
  {
    return "QCircleFuelRankItemView";
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFuelRankItemView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = paramContext.getInt(0, 1);
      paramContext.recycle();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380880);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369037));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379786));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView = ((QCirclePlusFollowView)paramView.findViewById(2131369131));
    this.b = ((TextView)paramView.findViewById(2131379681));
    this.c = ((TextView)paramView.findViewById(2131379804));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369213));
  }
  
  protected void a(List<FeedCloudMeta.StRankingItem> paramList)
  {
    if ((paramList == null) || (paramList.size() < this.jdField_a_of_type_Int)) {}
    for (;;)
    {
      return;
      paramList = (FeedCloudMeta.StRankingItem)paramList.get(this.jdField_a_of_type_Int - 1);
      setOnClickListener(new vxf(this, paramList));
      label76:
      Object localObject;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if ((getContext() instanceof BaseActivity)) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramList.user);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList.user.nick.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView.setItemReportListener(new vxg(this, paramList));
        if (paramList.user.followState.get() == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView.setUserData(paramList.user);
          this.b.setText(getContext().getString(2131697174, new Object[] { Long.valueOf(paramList.score.get()) }));
          localObject = new QQCircleBase.StUserBusiData();
        }
        break;
      }
      try
      {
        ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramList.user.busiData.get().toByteArray());
        this.c.setText(getContext().getString(2131697213, new Object[] { Integer.valueOf(((QQCircleBase.StUserBusiData)localObject).feedNum.get()) }));
        localObject = new QQCircleFeedBase.StRankingItemBusiData();
        try
        {
          ((QQCircleFeedBase.StRankingItemBusiData)localObject).mergeFrom(paramList.busiData.get().toByteArray());
          paramList = ((QQCircleFeedBase.StRankingItemBusiData)localObject).feedList;
          if ((paramList == null) || (paramList.size() == 0)) {
            continue;
          }
          uxh.a(((FeedCloudMeta.StFeedAbstract)paramList.get(0)).pic.picUrl.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844099);
        break label76;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844100);
        break label76;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844101);
        break label76;
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePlusFollowView.setVisibility(0);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void setParentPart(zxj paramzxj)
  {
    this.jdField_a_of_type_Zxj = paramzxj;
  }
  
  public void setRank(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelRankItemView
 * JD-Core Version:    0.7.0.1
 */