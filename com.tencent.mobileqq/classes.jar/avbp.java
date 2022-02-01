import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class avbp
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  public List<FeedsItemData.LabelInfo> a;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap;
  
  public avbp(List<FeedsItemData.LabelInfo> paramList, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePubFeedsAdapter", 0, "[LabelsAdapter] set next image");
    }
    if (paramList == null) {}
    for (this.jdField_a_of_type_JavaUtilList = new ArrayList();; this.jdField_a_of_type_JavaUtilList = paramList)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePubFeedsAdapter", 0, "[getView] set next image");
    }
    FeedsItemData.LabelInfo localLabelInfo = (FeedsItemData.LabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    avbo localavbo;
    Object localObject1;
    if (paramView == null)
    {
      localavbo = new avbo();
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131368759);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject1).setPadding(AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Object localObject3 = new ImageSwitcher(this.jdField_a_of_type_AndroidContentContext);
      ((ImageSwitcher)localObject3).setId(2131368634);
      ((ImageSwitcher)localObject3).setFactory(new avbq(this));
      Object localObject4 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageSwitcher(this.jdField_a_of_type_AndroidContentContext);
      ((ImageSwitcher)localObject4).setFactory(new avbr(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(5, ((ImageSwitcher)localObject3).getId());
      localLayoutParams.leftMargin = AIOUtils.dp2px(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject1).addView((View)localObject4, localLayoutParams);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)localObject3);
      localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)localObject4);
      localavbo.jdField_a_of_type_Avfq = new avfq(localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher, localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject2).setId(2131368633);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(34.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localavbo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setSingleLine(true);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((TextView)localObject3).setTextSize(12.0F);
      ((TextView)localObject3).setTextColor(-14540254);
      ((TextView)localObject3).setId(2131371803);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localavbo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RelativeLayout.LayoutParams)localObject4).addRule(3, ((TextView)localObject3).getId());
      ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((TextView)localObject2).setTextColor(-2145246686);
      ((TextView)localObject2).setTextSize(10.0F);
      paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850427));
      localObject4 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, ((RelativeLayout)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, ((RelativeLayout)localObject1).getId());
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localavbo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      localavbo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      paramView.setPadding(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setTag(localavbo);
    }
    for (;;)
    {
      localavbo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (aver.a(localLabelInfo.redInfo))
      {
        localavbo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localLabelInfo.name))
        {
          this.jdField_a_of_type_JavaUtilMap.put(localLabelInfo.name, Boolean.valueOf(true));
          localObject1 = new HashMap();
          abuf.a((Map)localObject1, localLabelInfo.msgId);
          ((Map)localObject1).put(Integer.valueOf(2), localLabelInfo.msgId);
          ((Map)localObject1).put(Integer.valueOf(3), localLabelInfo.reportId);
          abuf.a(amwn.a(), "769", "205648", localLabelInfo.appId, "76903", "1", "160", (Map)localObject1);
        }
      }
      if (!localLabelInfo.isFriend) {
        break label1386;
      }
      localavbo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      if ((localLabelInfo.friendList != null) && (localLabelInfo.friendList.size() > 0)) {}
      try
      {
        if (localLabelInfo.friendList.size() < 2) {
          break label1300;
        }
        localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(0)).icon);
        localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(1)).icon);
        localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject1);
        if (localLabelInfo.friendList.size() >= 4)
        {
          localObject1 = new ArrayList();
          int i = 0;
          for (;;)
          {
            if (i < localLabelInfo.friendList.size())
            {
              ((List)localObject1).add(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(i)).icon);
              i += 1;
              continue;
              localavbo = (avbo)paramView.getTag();
              break;
            }
          }
          localavbo.jdField_a_of_type_Avfq.a((List)localObject1);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.e("QQGamePubFeedsAdapter", 1, "[TopCardVH] initView error." + localException1);
        }
      }
    }
    localavbo.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131709775));
    localavbo.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131709770) + localLabelInfo.friendNum + anvx.a(2131709762));
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      label1300:
      localObject1 = URLDrawable.getDrawable(((FeedsItemData.FriendInfo)localLabelInfo.friendList.get(0)).icon);
      localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
      localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable((Drawable)localObject1);
      localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
      break;
      try
      {
        label1386:
        URLDrawable localURLDrawable;
        if ((localLabelInfo.icons != null) && (localLabelInfo.icons.size() > 0))
        {
          if (localLabelInfo.icons.size() < 2) {
            break label1562;
          }
          localavbo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
          localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(0);
          localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(0));
          localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setImageDrawable(localURLDrawable);
          localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(1));
          localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setImageDrawable(localURLDrawable);
          if (localLabelInfo.icons.size() >= 4) {
            localavbo.jdField_a_of_type_Avfq.a(localLabelInfo.icons);
          }
        }
        for (;;)
        {
          localavbo.jdField_a_of_type_AndroidWidgetTextView.setText(localLabelInfo.name);
          localavbo.jdField_b_of_type_AndroidWidgetTextView.setText(localLabelInfo.desc);
          break;
          label1562:
          localavbo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localavbo.jdField_a_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
          localavbo.jdField_b_of_type_AndroidWidgetImageSwitcher.setVisibility(8);
          localURLDrawable = URLDrawable.getDrawable((String)localLabelInfo.icons.get(0));
          localavbo.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("QQGamePubFeedsAdapter", 1, "[TopCardVH] initView error." + localException2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbp
 * JD-Core Version:    0.7.0.1
 */