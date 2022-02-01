import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atxw
  extends PagerAdapter
{
  private atxw(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  private void a(RelativeLayout paramRelativeLayout, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      TextView localTextView = new TextView(this.a.getActivity());
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 10.0F);
      localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
      localTextView.setText(bfzl.a(this.a.getActivity(), 3, paramMessageRecord.time * 1000L));
      localTextView.setPadding(12, 0, 12, 0);
      localTextView.setId(2131378618);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramMessageRecord = localLayoutParams;
      if (localLayoutParams == null) {
        paramMessageRecord = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(15.0F, this.a.getResources()));
      }
      localTextView.setGravity(17);
      paramMessageRecord.addRule(14);
      paramMessageRecord.addRule(10);
      localTextView.bringToFront();
      paramRelativeLayout.addView(localTextView, paramMessageRecord);
    }
  }
  
  public atzp a(int paramInt)
  {
    if (QQGamePubAccountFragment.a(this.a).isEmpty())
    {
      synchronized (QQGamePubAccountFragment.b)
      {
        if ((QQGamePubAccountFragment.a(this.a) != null) && (QQGamePubAccountFragment.a(this.a).size() > 0))
        {
          Iterator localIterator = QQGamePubAccountFragment.a(this.a).iterator();
          if (localIterator.hasNext())
          {
            atzp localatzp = auab.a((MessageRecord)localIterator.next(), this.a.getActivity());
            QQGamePubAccountFragment.a(this.a).add(localatzp);
          }
        }
      }
      if ((this.a.isAdded()) && (this.a.getActivity() != null) && (!this.a.getActivity().isFinishing())) {
        QQGamePubAccountFragment.a(this.a).add(new MoreMsgHeaderView(this.a.getActivity()));
      }
    }
    if (paramInt < QQGamePubAccountFragment.a(this.a).size()) {
      return (atzp)QQGamePubAccountFragment.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return QQGamePubAccountFragment.a(this.a).size() + 1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.d("QQGamePubAccountFragment", 4, "---->instantiateItem");
    if (paramInt < QQGamePubAccountFragment.a(this.a).size()) {}
    RelativeLayout localRelativeLayout;
    for (MessageRecord localMessageRecord = (MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt);; localMessageRecord = null)
    {
      atzp localatzp = a(paramInt);
      if (localatzp == null)
      {
        QLog.d("QQGamePubAccountFragment", 4, "headView is null");
        return null;
      }
      localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localatzp).getParent() != null) {
        ((ViewGroup)((View)localatzp).getParent()).removeView((View)localatzp);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13, ((View)localatzp).getId());
      localRelativeLayout.addView((View)localatzp, localLayoutParams);
      a(localRelativeLayout, localMessageRecord);
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
      int i = QQGamePubAccountFragment.a(this.a).getCurrentItem();
      if (localMessageRecord != null) {
        localatzp.a(localMessageRecord, this.a.getActivity());
      }
      if (paramInt != i) {
        break;
      }
      try
      {
        QQGamePubAccountFragment.a(this.a, localatzp);
        if (this.a.a(QQGamePubAccountFragment.a(this.a)))
        {
          ((GameArkView)QQGamePubAccountFragment.a(this.a)).setPrePause(false);
          atyb.a().a((GameArkView)QQGamePubAccountFragment.a(this.a));
        }
        else
        {
          atyb.a().a(null);
        }
      }
      catch (Throwable paramViewGroup)
      {
        QLog.d("QQGamePubAccountFragment", 4, "--->instantiateItem init video ark fail:" + paramViewGroup.getMessage());
      }
    }
    return localRelativeLayout;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxw
 * JD-Core Version:    0.7.0.1
 */