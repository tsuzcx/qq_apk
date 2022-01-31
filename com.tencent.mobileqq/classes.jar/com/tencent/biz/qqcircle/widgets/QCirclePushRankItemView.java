package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bdnn;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;
import tql;
import tqr;
import tzv;
import uex;

public class QCirclePushRankItemView
  extends BaseWidgetView<QQCircleDitto.StItemContainer>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQCircleDitto.StItemInfo jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private TextView c;
  
  public QCirclePushRankItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NotNull
  private FeedCloudMeta.StUser a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramStItemInfo.id.get());
    localStUser.followState.set(paramStItemInfo.buttonInfo.buttonValue.get());
    localStUser.nick.set(paramStItemInfo.name.get());
    return localStUser;
  }
  
  public int a()
  {
    return 2131560584;
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCirclePushRankItemView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = paramContext.getInt(0, 1);
      paramContext.recycle();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368939));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373231));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131372571));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378901));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378935));
    this.c = ((TextView)paramView.findViewById(2131378936));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373232));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373289));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
  }
  
  protected void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {}
    while ((paramStItemContainer.items == null) || (paramStItemContainer.items.size() < this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo = ((QQCircleDitto.StItemInfo)paramStItemContainer.items.get(this.jdField_a_of_type_Int - 1));
    Object localObject = a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, (FeedCloudMeta.StUser)localObject);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localObject);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new uex(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((FeedCloudMeta.StUser)localObject).nick.get());
    if (this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.size() > 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.get(0));
    }
    if (this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.size() > 1) {
      this.c.setText((CharSequence)this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.get(1));
    }
    localObject = "";
    String str = "";
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramStItemContainer = str;
    }
    for (;;)
    {
      tql.a((String)localObject, this.jdField_a_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166178)));
      tql.a(paramStItemContainer, this.jdField_b_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166178)));
      return;
      switch (paramStItemContainer.containerType.get())
      {
      default: 
        paramStItemContainer = str;
        break;
      case 1: 
        localObject = "https://sola.gtimg.cn/aoi/sola/20200420161850_TO3juCOD5g.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420161850_aASbryezls.png";
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843699);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843702);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841497);
        break;
      case 2: 
        localObject = "https://sola.gtimg.cn/aoi/sola/20200420162643_ucSiy5BHOR.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162643_jHnc9fLr88.png";
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843709);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843711);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841500);
        break;
      case 3: 
        localObject = "https://sola.gtimg.cn/aoi/sola/20200423195102_1G9RjstwQG.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195419_fsnqeCkzil.png";
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843705);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843708);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841503);
        break;
      case 4: 
        localObject = "https://sola.gtimg.cn/aoi/sola/20200420164706_MAybOSOV4Z.png";
        paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420164706_EHkNzcztIK.png";
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843701);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843704);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841506);
        continue;
        switch (paramStItemContainer.containerType.get())
        {
        default: 
          paramStItemContainer = str;
          break;
        case 1: 
          localObject = "https://sola.gtimg.cn/aoi/sola/20200420162145_qGlonPe51i.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162145_cs8bXfoj7T.png";
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843700);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843703);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841496);
          break;
        case 2: 
          localObject = "https://sola.gtimg.cn/aoi/sola/20200420162843_LL2oCfCZxQ.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162843_g63ANBxN1I.png";
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843709);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843711);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841499);
          break;
        case 3: 
          localObject = "https://sola.gtimg.cn/aoi/sola/20200423195138_ZpWFx9ROhf.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195352_8klmXhkiTV.png";
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843699);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843702);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841502);
          break;
        case 4: 
          localObject = "https://sola.gtimg.cn/aoi/sola/20200420164927_WYcCVHrfQU.png";
          paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420164927_b4UUDZex19.png";
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843604);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843605);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841505);
          continue;
          switch (paramStItemContainer.containerType.get())
          {
          default: 
            paramStItemContainer = str;
            break;
          case 1: 
            localObject = "https://sola.gtimg.cn/aoi/sola/20200420162433_l3SFpIS75O.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420162432_U1cpuRvxFL.png";
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843701);
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843704);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841498);
            break;
          case 2: 
            localObject = "https://sola.gtimg.cn/aoi/sola/20200420163559_FeOrK0i9Ig.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420163559_dMjJxScsSR.png";
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843710);
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843712);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841501);
            break;
          case 3: 
            localObject = "https://sola.gtimg.cn/aoi/sola/20200423195211_Cj6JbErN8S.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200423195440_afxmpzcS18.png";
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843706);
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843707);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841504);
            break;
          case 4: 
            localObject = "https://sola.gtimg.cn/aoi/sola/20200420165139_1uThGkBHzb.png";
            paramStItemContainer = "https://sola.gtimg.cn/aoi/sola/20200420165139_JeRAYOTHqy.png";
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843713);
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843714);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841507);
          }
          break;
        }
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = tqr.a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.urlInfo.get(), "RankItemUrl");
      if (bdnn.a(paramView)) {
        QLog.w("QCirclePushRankItemView", 1, "rank item url is empty");
      }
      Intent localIntent = new Intent(getContext(), JumpActivity.class);
      localIntent.setData(Uri.parse(paramView));
      getContext().startActivity(localIntent);
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 2L, 0L);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void setRank(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView
 * JD-Core Version:    0.7.0.1
 */