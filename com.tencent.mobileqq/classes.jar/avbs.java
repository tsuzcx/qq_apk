import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.dataline.util.widget.NoScrollGridView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class avbs
  extends RecyclerView.ViewHolder
{
  public Context a;
  public FrameLayout a;
  public TextView a;
  public avbb a;
  public NoScrollGridView a;
  public FrameGifView a;
  public FeedsItemData.TopCardInfo a;
  public ShadowView a;
  
  public avbs(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379870));
    this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView = ((NoScrollGridView)paramView.findViewById(2131367977));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)paramView.findViewById(2131376785));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376787));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView = ((ShadowView)paramView.findViewById(2131376788));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131709765));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView.setShadowProperties(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0.0F, AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#1A0066FF"));
  }
  
  public void a(FeedsItemData.TopCardInfo paramTopCardInfo, avbb paramavbb)
  {
    this.jdField_a_of_type_Avbb = paramavbb;
    Iterator localIterator;
    int i;
    if ((paramTopCardInfo != null) && (avbb.a(paramTopCardInfo)))
    {
      paramavbb = new RecyclerView.LayoutParams(-1, -2);
      this.itemView.setLayoutParams(paramavbb);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
      paramavbb = new HashMap();
      abuf.a(paramavbb, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.msgId);
      paramavbb.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.msgId);
      paramavbb.put(Integer.valueOf(4), "8");
      paramavbb.put(Integer.valueOf(6), this.jdField_a_of_type_Avbb.a().gameAppId);
      localIterator = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.iterator();
      i = 32;
    }
    while (localIterator.hasNext())
    {
      paramavbb.put(Integer.valueOf(i), ((FeedsItemData.LabelInfo)localIterator.next()).reportId);
      i += 1;
      continue;
      paramTopCardInfo = new RecyclerView.LayoutParams(-1, 0);
      this.itemView.setLayoutParams(paramTopCardInfo);
      return;
    }
    abuf.a(amwn.a(), "769", "205609", this.jdField_a_of_type_Avbb.a().gameAppId, "76903", "1", "160", paramavbb);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.size() <= 4)) {
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setAdapter(new avbp(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setOnItemClickListener(new avbt(this));
      long l = NetConnInfoCenter.getServerTime();
      if ((TextUtils.isEmpty(paramTopCardInfo.bannerIconZip)) || (paramTopCardInfo.bannerBeginTime > l) || (l > paramTopCardInfo.bannerEndTime)) {
        break label496;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if ((this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams()).topMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(paramTopCardInfo.bannerGap, null, paramTopCardInfo.bannerIconZip, annt.a(paramTopCardInfo.bannerIconZip), true);
      abuf.a(amwn.a(), "769", "205646", this.jdField_a_of_type_Avbb.a().gameAppId, "76903", "1", "160", new String[] { "", "", "8" });
      paramTopCardInfo = paramTopCardInfo.bannerUrl;
      if (TextUtils.isEmpty(paramTopCardInfo)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new avbu(this, paramTopCardInfo));
      return;
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(5);
    }
    label496:
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbs
 * JD-Core Version:    0.7.0.1
 */