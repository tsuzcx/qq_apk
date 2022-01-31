import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class asoy
  extends PagerAdapter
{
  private asoy(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((QQGameFeedWebFragment.a(this.a) == null) || (QQGameFeedWebFragment.a(this.a).size() == 0)) {
      return 1;
    }
    return QQGameFeedWebFragment.a(this.a).size() + 1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((QQGameFeedWebFragment.a(this.a) == null) || (QQGameFeedWebFragment.a(this.a).size() == 0))
    {
      localObject1 = this.a.a();
      paramViewGroup.addView((View)localObject1);
      return localObject1;
    }
    for (;;)
    {
      synchronized (QQGameFeedWebFragment.a(this.a))
      {
        if (paramInt >= QQGameFeedWebFragment.a(this.a).size()) {
          break label536;
        }
        localQQGameMsgInfo = (QQGameMsgInfo)QQGameFeedWebFragment.a(this.a).get(paramInt);
        asnu localasnu = asof.a(localQQGameMsgInfo, this.a.getActivity());
        if (((localasnu instanceof MoreMsgHeaderView)) && (paramInt != QQGameFeedWebFragment.a(this.a).size())) {
          return null;
        }
        if (localasnu == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 2, "headerView = null");
          }
          return null;
        }
        this.a.a.add(localasnu);
        if (QLog.isColorLevel()) {
          QLog.d("GameWebPage", 2, "headerView = " + localasnu.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localasnu).getParent() != null) {
          ((ViewGroup)((View)localasnu).getParent()).removeView((View)localasnu);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13, ((View)localasnu).getId());
        if (localQQGameMsgInfo == null) {
          break label531;
        }
        TextView localTextView = new TextView(this.a.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
        localTextView.setText(bdns.a(this.a.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131377854);
        localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new RelativeLayout.LayoutParams(-2, aepi.a(15.0F, this.a.getResources()));
          localTextView.setGravity(17);
          ((RelativeLayout.LayoutParams)localObject1).addRule(14);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10);
          localTextView.bringToFront();
          localObject2 = localObject1;
          localObject1 = localTextView;
          localRelativeLayout.addView((View)localasnu, localLayoutParams);
          if ((localObject1 != null) && (localObject2 != null)) {
            localRelativeLayout.addView((View)localObject1, localObject2);
          }
          paramViewGroup.addView(localRelativeLayout, localLayoutParams);
          if (localQQGameMsgInfo != null)
          {
            localasnu.a(localQQGameMsgInfo, this.a.getActivity(), paramInt);
            return localRelativeLayout;
          }
          localasnu.a(new QQGameMsgInfo(), this.a.getActivity(), paramInt);
        }
      }
      continue;
      label531:
      localObject1 = null;
      continue;
      label536:
      QQGameMsgInfo localQQGameMsgInfo = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoy
 * JD-Core Version:    0.7.0.1
 */