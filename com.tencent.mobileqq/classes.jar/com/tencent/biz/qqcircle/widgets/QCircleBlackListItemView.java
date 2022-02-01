package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleBlackListItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StUser>
{
  private QCircleAvatarView a;
  private TextView b;
  private QCircleAddBlackListView c;
  private FeedCloudMeta.StUser d;
  
  public QCircleBlackListItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, int paramInt)
  {
    if (paramStUser == null) {
      return;
    }
    this.d = paramStUser;
    this.d.blackState.set(1);
    this.a.setUser(paramStUser);
    this.b.setText(paramStUser.nick.get());
    this.c.setUserData(paramStUser);
  }
  
  public int getLayoutId()
  {
    return 2131626767;
  }
  
  protected String getLogTag()
  {
    return "QCircleBlackListItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QCircleAvatarView)paramView.findViewById(2131441579));
    this.b = ((TextView)paramView.findViewById(2131441580));
    this.c = ((QCircleAddBlackListView)paramView.findViewById(2131441578));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBlackListItemView
 * JD-Core Version:    0.7.0.1
 */