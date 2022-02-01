package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRelation.RelationBiz;

public class QCircleSpecialFollowUserItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StRelationInfo>
  implements View.OnClickListener
{
  private QCircleAvatarView a;
  private TextView b;
  private TextView c;
  private URLImageView d;
  private View e;
  private String f;
  
  public QCircleSpecialFollowUserItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  private QQCircleRelation.RelationBiz a(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    if (paramStRelationInfo.busiData.get() != null)
    {
      Object localObject = new QQCircleRelation.RelationBiz();
      try
      {
        ((QQCircleRelation.RelationBiz)localObject).mergeFrom(paramStRelationInfo.busiData.get().toByteArray());
        return localObject;
      }
      catch (InvalidProtocolBufferMicroException paramStRelationInfo)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindData: merge data failed");
        ((StringBuilder)localObject).append(paramStRelationInfo.toString());
        QLog.w("QCircleSpecialFollowUse", 4, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  protected void a(FeedCloudMeta.StRelationInfo paramStRelationInfo, int paramInt)
  {
    this.f = paramStRelationInfo.id.get();
    Object localObject = a(paramStRelationInfo);
    paramStRelationInfo = new FeedCloudMeta.StUser();
    paramStRelationInfo.id.set(this.f);
    int i = 0;
    boolean bool;
    if (localObject != null)
    {
      this.b.setText(((QQCircleRelation.RelationBiz)localObject).nick.get());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindData: ");
      localStringBuilder.append(((QQCircleRelation.RelationBiz)localObject).nick.get());
      localStringBuilder.append(" ");
      localStringBuilder.append(((QQCircleRelation.RelationBiz)localObject).qqRelation.get());
      localStringBuilder.append(" ");
      localStringBuilder.append(((QQCircleRelation.RelationBiz)localObject).sign.get());
      localStringBuilder.append(" ");
      localStringBuilder.append(((QQCircleRelation.RelationBiz)localObject).certification.get());
      QLog.i("QCircleSpecialFollowUse", 4, localStringBuilder.toString());
      this.c.setText(((QQCircleRelation.RelationBiz)localObject).sign.get());
      paramInt = ((QQCircleRelation.RelationBiz)localObject).qqRelation.get();
      bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      paramInt = ((QQCircleRelation.RelationBiz)localObject).certification.get();
      paramStRelationInfo.icon.iconUrl.set(((QQCircleRelation.RelationBiz)localObject).logo.get());
    }
    else
    {
      this.b.setText(this.f);
      this.c.setText("");
      bool = QCirclePluginUtil.e(this.f);
      paramInt = 0;
    }
    localObject = this.d;
    if (!bool) {
      i = 8;
    }
    ((URLImageView)localObject).setVisibility(i);
    this.a.setIsAuth(paramInt);
    this.a.setUser(paramStRelationInfo);
  }
  
  public int getLayoutId()
  {
    return 2131626963;
  }
  
  protected String getLogTag()
  {
    return "QCircleSpecialFollowUse";
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.f)) && (!FastClickUtils.a("QCircleSpecialFollowUse")))
    {
      int i = paramView.getId();
      if ((i != 2131441879) && (i != 2131441882))
      {
        if (i == 2131441880) {
          QCircleCustomDialog.a(getContext(), "提示", "取消后需要重新去他人的主页进行设置，确定取消吗？", 2131887648, 2131887629, new QCircleSpecialFollowUserItemView.1(this), new QCircleSpecialFollowUserItemView.2(this)).show();
        }
      }
      else
      {
        QCircleInitBean localQCircleInitBean = new QCircleInitBean();
        localQCircleInitBean.setUin(this.f);
        QCircleLauncher.b(paramView.getContext(), localQCircleInitBean);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QCircleAvatarView)paramView.findViewById(2131441879));
    this.b = ((TextView)paramView.findViewById(2131441882));
    this.c = ((TextView)paramView.findViewById(2131441881));
    this.d = ((URLImageView)paramView.findViewById(2131441883));
    this.d.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
    this.e = paramView.findViewById(2131441880);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView
 * JD-Core Version:    0.7.0.1
 */