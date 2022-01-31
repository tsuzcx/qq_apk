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

public class aqqt
  extends RecyclerView.ViewHolder
{
  public Context a;
  public FrameLayout a;
  public TextView a;
  public aqqc a;
  public NoScrollGridView a;
  public FrameGifView a;
  public FeedsItemData.TopCardInfo a;
  public ShadowView a;
  
  public aqqt(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378125));
    this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView = ((NoScrollGridView)paramView.findViewById(2131367290));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)paramView.findViewById(2131375345));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131375347));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView = ((ShadowView)paramView.findViewById(2131375348));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131710317));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewShadowView.setShadowProperties(actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0.0F, actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#1A0066FF"));
  }
  
  public void a(FeedsItemData.TopCardInfo paramTopCardInfo, aqqc paramaqqc)
  {
    this.jdField_a_of_type_Aqqc = paramaqqc;
    Iterator localIterator;
    int i;
    if ((paramTopCardInfo != null) && (aqqc.a(paramTopCardInfo)))
    {
      paramaqqc = new RecyclerView.LayoutParams(-1, -2);
      this.itemView.setLayoutParams(paramaqqc);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
      paramaqqc = new HashMap();
      yoa.a(paramaqqc, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.msgId);
      paramaqqc.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.msgId);
      paramaqqc.put(Integer.valueOf(4), "8");
      paramaqqc.put(Integer.valueOf(6), this.jdField_a_of_type_Aqqc.a().gameAppId);
      localIterator = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.iterator();
      i = 32;
    }
    while (localIterator.hasNext())
    {
      paramaqqc.put(Integer.valueOf(i), ((FeedsItemData.LabelInfo)localIterator.next()).reportId);
      i += 1;
      continue;
      paramTopCardInfo = new RecyclerView.LayoutParams(-1, 0);
      this.itemView.setLayoutParams(paramTopCardInfo);
      return;
    }
    yoa.a(ajac.a(), "769", "205609", this.jdField_a_of_type_Aqqc.a().gameAppId, "76903", "1", "160", paramaqqc);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo = paramTopCardInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.size() <= 4)) {
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setAdapter(new aqqq(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setOnItemClickListener(new aqqu(this));
      long l = NetConnInfoCenter.getServerTime();
      if ((TextUtils.isEmpty(paramTopCardInfo.bannerIconZip)) || (paramTopCardInfo.bannerBeginTime > l) || (l > paramTopCardInfo.bannerEndTime)) {
        break label496;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if ((this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.getLayoutParams()).topMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(paramTopCardInfo.bannerGap, null, paramTopCardInfo.bannerIconZip, ajrs.a(paramTopCardInfo.bannerIconZip), true);
      yoa.a(ajac.a(), "769", "205646", this.jdField_a_of_type_Aqqc.a().gameAppId, "76903", "1", "160", new String[] { "", "", "8" });
      paramTopCardInfo = paramTopCardInfo.bannerUrl;
      if (TextUtils.isEmpty(paramTopCardInfo)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new aqqv(this, paramTopCardInfo));
      return;
      this.jdField_a_of_type_ComDatalineUtilWidgetNoScrollGridView.setNumColumns(5);
    }
    label496:
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqt
 * JD-Core Version:    0.7.0.1
 */