import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment;
import java.util.ArrayList;
import java.util.List;

public class bhse
  extends PagerAdapter
{
  private bhse(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return QQVipFeedWedFragment.a(this.a).size() + 1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if ((QQVipFeedWedFragment.a(this.a) == null) || (QQVipFeedWedFragment.a(this.a).size() == 0))
    {
      localObject = this.a.a();
      paramViewGroup.addView((View)localObject);
      return localObject;
    }
    if (paramInt < QQVipFeedWedFragment.a(this.a).size()) {}
    for (QQVipMsgInfo localQQVipMsgInfo = (QQVipMsgInfo)QQVipFeedWedFragment.a(this.a).get(paramInt);; localQQVipMsgInfo = null)
    {
      bhsh localbhsh = bhsn.a(localQQVipMsgInfo, this.a.getActivity());
      if (localbhsh == null) {
        return null;
      }
      this.a.a.add(localbhsh);
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localbhsh).getParent() != null) {
        ((ViewGroup)((View)localbhsh).getParent()).removeView((View)localbhsh);
      }
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(13, ((View)localbhsh).getId());
      TextView localTextView;
      if (localQQVipMsgInfo != null)
      {
        localTextView = new TextView(this.a.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(Color.parseColor("#FFD69D5A"));
        localTextView.setText(bhid.a(this.a.getActivity(), 3, localQQVipMsgInfo.msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131378912);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localObject = localLayoutParams1;
        if (localLayoutParams1 == null) {
          localObject = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(14.0F, this.a.getResources()));
        }
        localTextView.setGravity(17);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 25;
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        localTextView.bringToFront();
      }
      for (;;)
      {
        localRelativeLayout.addView((View)localbhsh, localLayoutParams2);
        if ((localTextView != null) && (localObject != null)) {
          localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams2);
        if ((localbhsh != null) && (localQQVipMsgInfo != null)) {
          localbhsh.a(localQQVipMsgInfo, this.a.getActivity(), paramInt);
        }
        return localRelativeLayout;
        localTextView = null;
        localObject = null;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhse
 * JD-Core Version:    0.7.0.1
 */