package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.richframework.part.block.BlockMerger.ShareData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleTagPageHeaderView
  extends QCircleBaseWidgetView<BlockMerger.ShareData>
{
  private QCircleAvatarListView a;
  private FeedCloudMeta.StTagInfo b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private QCircleFollowTagView f;
  
  public QCircleTagPageHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
  }
  
  protected void a(BlockMerger.ShareData paramShareData, int paramInt)
  {
    if ((paramShareData != null) && ((paramShareData.a instanceof FeedCloudMeta.StTagInfo)))
    {
      this.b = ((FeedCloudMeta.StTagInfo)paramShareData.a);
      this.c.setText(this.b.tagName.get());
      paramShareData = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.tagTotalUser.get());
      localStringBuilder.append(HardCodeUtil.a(2131895924));
      paramShareData.setText(localStringBuilder.toString());
      this.a.setData(QCircleAvatarListUtils.a(this.b.userList.get(), 2147483647));
      this.f.setTagInfo(this.b);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626969;
  }
  
  protected String getLogTag()
  {
    return "QCircleTagPageHeaderView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QCircleAvatarListView)paramView.findViewById(2131429025));
    this.c = ((TextView)paramView.findViewById(2131448814));
    this.d = ((TextView)paramView.findViewById(2131448637));
    this.e = ((ImageView)paramView.findViewById(2131436287));
    this.f = ((QCircleFollowTagView)paramView.findViewById(2131441894));
    this.f.setItemReportListener(new QCircleTagPageHeaderView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */