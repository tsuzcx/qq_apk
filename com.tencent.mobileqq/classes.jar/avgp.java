import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avgp
  extends PagerAdapter
{
  private avgp(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    synchronized (QQGameFeedWebFragment.jdField_a_of_type_ArrayOfByte)
    {
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 1))
      {
        int i = this.a.jdField_a_of_type_JavaUtilList.size();
        return i;
      }
      return 1;
    }
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
      synchronized (QQGameFeedWebFragment.jdField_a_of_type_ArrayOfByte)
      {
        if (paramInt >= QQGameFeedWebFragment.a(this.a).size()) {
          break label601;
        }
        localQQGameMsgInfo = (QQGameMsgInfo)QQGameFeedWebFragment.a(this.a).get(paramInt);
        if (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label595;
        }
        localavfh = (avfh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localavfh == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 2, "headerView = null");
          }
          return null;
        }
        if (((localavfh instanceof MoreMsgHeaderView)) && (paramInt != QQGameFeedWebFragment.a(this.a).size())) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameWebPage", 2, "headerView = " + localavfh.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localavfh).getParent() != null) {
          ((ViewGroup)((View)localavfh).getParent()).removeView((View)localavfh);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13, ((View)localavfh).getId());
        if (localQQGameMsgInfo == null) {
          break label590;
        }
        TextView localTextView = new TextView(this.a.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(0);
        localTextView.setText(bhid.a(this.a.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131378912);
        localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject1 != null) {
          break label587;
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(15.0F, this.a.getResources()));
        localTextView.setGravity(17);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        localTextView.bringToFront();
        localObject2 = localObject1;
        localObject1 = localTextView;
        localRelativeLayout.addView((View)localavfh, localLayoutParams);
        if ((localObject1 != null) && (localObject2 != null)) {
          localRelativeLayout.addView((View)localObject1, localObject2);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams);
        if (localQQGameMsgInfo != null)
        {
          localavfh.a(localQQGameMsgInfo, this.a.getActivity(), paramInt);
          if (paramInt == QQGameFeedWebFragment.a(this.a).getCurrentItem())
          {
            QQGameFeedWebFragment.a(this.a, localavfh);
            if ((localavfh instanceof GameArkView))
            {
              ((GameArkView)localavfh).setPrePause(false);
              avdq.a().a((GameArkView)localavfh);
            }
          }
          else
          {
            return localRelativeLayout;
          }
          avdq.a().a(null);
        }
      }
      localavfh.a(new QQGameMsgInfo(), this.a.getActivity(), paramInt);
      continue;
      label587:
      continue;
      label590:
      localObject1 = null;
      continue;
      label595:
      avfh localavfh = null;
      continue;
      label601:
      QQGameMsgInfo localQQGameMsgInfo = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgp
 * JD-Core Version:    0.7.0.1
 */