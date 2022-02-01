import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avkv
  extends PagerAdapter
{
  private avkv(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  private void a(RelativeLayout paramRelativeLayout, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      TextView localTextView = new TextView(this.a.getActivity());
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 10.0F);
      localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
      localTextView.setText(bhsw.a(this.a.getActivity(), 3, paramMessageRecord.time * 1000L));
      localTextView.setPadding(12, 0, 12, 0);
      localTextView.setId(2131378854);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramMessageRecord = localLayoutParams;
      if (localLayoutParams == null) {
        paramMessageRecord = new RelativeLayout.LayoutParams(-2, agej.a(15.0F, this.a.getResources()));
      }
      localTextView.setGravity(17);
      paramMessageRecord.addRule(14);
      paramMessageRecord.addRule(10);
      localTextView.bringToFront();
      paramRelativeLayout.addView(localTextView, paramMessageRecord);
    }
  }
  
  public avmq a(int paramInt)
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
            avmq localavmq = avnc.a((MessageRecord)localIterator.next(), this.a.getActivity());
            QQGamePubAccountFragment.a(this.a).add(localavmq);
          }
        }
      }
      if ((this.a.isAdded()) && (this.a.getActivity() != null) && (!this.a.getActivity().isFinishing())) {
        QQGamePubAccountFragment.a(this.a).add(new MoreMsgHeaderView(this.a.getActivity()));
      }
    }
    if (paramInt < QQGamePubAccountFragment.a(this.a).size()) {
      return (avmq)QQGamePubAccountFragment.a(this.a).get(paramInt);
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
      avmq localavmq = a(paramInt);
      if (localavmq == null)
      {
        QLog.d("QQGamePubAccountFragment", 4, "headView is null");
        return null;
      }
      localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localavmq).getParent() != null) {
        ((ViewGroup)((View)localavmq).getParent()).removeView((View)localavmq);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13, ((View)localavmq).getId());
      localRelativeLayout.addView((View)localavmq, localLayoutParams);
      a(localRelativeLayout, localMessageRecord);
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
      int i = QQGamePubAccountFragment.a(this.a).getCurrentItem();
      localavmq.a(localMessageRecord, this.a.getActivity());
      if (paramInt != i) {
        break;
      }
      try
      {
        QQGamePubAccountFragment.a(this.a, localavmq);
        if (this.a.a(QQGamePubAccountFragment.a(this.a)))
        {
          ((GameArkView)QQGamePubAccountFragment.a(this.a)).setPrePause(false);
          avlb.a().a((GameArkView)QQGamePubAccountFragment.a(this.a));
        }
        else
        {
          avlb.a().a(null);
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
 * Qualified Name:     avkv
 * JD-Core Version:    0.7.0.1
 */