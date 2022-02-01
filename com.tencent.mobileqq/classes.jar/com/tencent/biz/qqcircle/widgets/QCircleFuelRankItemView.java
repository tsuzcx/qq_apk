package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedAbstract;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StRankingItem;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleFeedBase.StRankingItemBusiData;

public class QCircleFuelRankItemView
  extends QCircleBaseWidgetView<List<FeedCloudMeta.StRankingItem>>
{
  private View a;
  private QCircleAvatarView b;
  private TextView c;
  private QCirclePlusFollowView d;
  private TextView e;
  private TextView f;
  private SquareImageView g;
  private int h = 1;
  private Part i;
  
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
  
  private void a(String paramString, int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQCircleExtraTypeInfo.mFeed.poster.id.get();
      }
      QCircleLpReportDc05507.report(localDataBuilder.setToUin(str).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("extraTypeInfo is null or lost feed,actionType:");
    paramString.append(paramInt1);
    paramString.append(",subActionType:");
    paramString.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleFuelRankItemView", 1, paramString.toString());
  }
  
  protected void a(List<FeedCloudMeta.StRankingItem> paramList, int paramInt)
  {
    if (paramList != null)
    {
      paramInt = paramList.size();
      int j = this.h;
      if (paramInt < j) {
        return;
      }
      paramList = (FeedCloudMeta.StRankingItem)paramList.get(j - 1);
      setOnClickListener(new QCircleFuelRankItemView.1(this, paramList));
      paramInt = this.h;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            this.a.setBackgroundResource(2130845234);
          }
        }
        else {
          this.a.setBackgroundResource(2130845233);
        }
      }
      else {
        this.a.setBackgroundResource(2130845232);
      }
      this.b.setUser(paramList.user);
      this.c.setText(paramList.user.nick.get());
      this.d.setItemReportListener(new QCircleFuelRankItemView.2(this, paramList));
      if (paramList.user.followState.get() == 1) {
        this.d.setVisibility(8);
      } else {
        this.d.setVisibility(0);
      }
      this.d.setUserData(paramList.user);
      this.e.setText(getContext().getString(2131895745, new Object[] { Long.valueOf(paramList.score.get()) }));
      QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
      try
      {
        localStUserBusiData.mergeFrom(paramList.user.busiData.get().toByteArray());
        this.f.setText(getContext().getString(2131895816, new Object[] { Integer.valueOf(localStUserBusiData.feedNum.get()) }));
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      QQCircleFeedBase.StRankingItemBusiData localStRankingItemBusiData = new QQCircleFeedBase.StRankingItemBusiData();
      try
      {
        localStRankingItemBusiData.mergeFrom(paramList.busiData.get().toByteArray());
        paramList = localStRankingItemBusiData.feedList;
        if ((paramList != null) && (paramList.size() != 0))
        {
          QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(this.g).setUrl(((FeedCloudMeta.StFeedAbstract)paramList.get(0)).pic.picUrl.get()), null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626947;
  }
  
  protected String getLogTag()
  {
    return "QCircleFuelRankItemView";
  }
  
  protected void handleAttr(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.handleAttr(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cE);
    if (paramContext != null)
    {
      this.h = paramContext.getInt(R.styleable.cF, 1);
      paramContext.recycle();
    }
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = paramView.findViewById(2131449815);
    this.b = ((QCircleAvatarView)paramView.findViewById(2131436271));
    this.c = ((TextView)paramView.findViewById(2131448606));
    this.d = ((QCirclePlusFollowView)paramView.findViewById(2131436382));
    this.e = ((TextView)paramView.findViewById(2131448480));
    this.f = ((TextView)paramView.findViewById(2131448630));
    this.g = ((SquareImageView)paramView.findViewById(2131436486));
  }
  
  public void setParentPart(Part paramPart)
  {
    this.i = paramPart;
  }
  
  public void setRank(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelRankItemView
 * JD-Core Version:    0.7.0.1
 */