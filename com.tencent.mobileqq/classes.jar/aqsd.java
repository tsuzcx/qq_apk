import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aqsd
  extends PagerAdapter
{
  public aqsd(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
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
    if (paramInt < QQGamePubAccountFragment.a(this.a).size()) {}
    for (MessageRecord localMessageRecord = (MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt);; localMessageRecord = null)
    {
      aqsx localaqsx = aqti.a(localMessageRecord, this.a.getActivity());
      if (localaqsx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePubAccountFragment", 2, "headerView = null");
        }
        return null;
      }
      this.a.a.add(localaqsx);
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 2, "headerView = " + localaqsx.getClass().getSimpleName());
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localaqsx).getParent() != null) {
        ((ViewGroup)((View)localaqsx).getParent()).removeView((View)localaqsx);
      }
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams3.addRule(13, ((View)localaqsx).getId());
      TextView localTextView;
      RelativeLayout.LayoutParams localLayoutParams1;
      if (localMessageRecord != null)
      {
        localTextView = new TextView(this.a.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
        localTextView.setText(bbkb.a(this.a.getActivity(), 3, localMessageRecord.time * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131377270);
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, actn.a(15.0F, this.a.getResources()));
        }
        localTextView.setGravity(17);
        localLayoutParams1.addRule(14);
        localLayoutParams1.addRule(10);
        localTextView.bringToFront();
      }
      for (;;)
      {
        localRelativeLayout.addView((View)localaqsx, localLayoutParams3);
        if ((localTextView != null) && (localLayoutParams1 != null)) {
          localRelativeLayout.addView(localTextView, localLayoutParams1);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams3);
        localaqsx.a(localMessageRecord, this.a.getActivity());
        if (localMessageRecord == null) {
          return localRelativeLayout;
        }
        if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForArkApp)))
        {
          paramViewGroup = (ArkTextureView)localaqsx;
          ((View)localaqsx).setOnTouchListener(new aqse(this, paramViewGroup));
        }
        return localRelativeLayout;
        localTextView = null;
        localLayoutParams1 = null;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsd
 * JD-Core Version:    0.7.0.1
 */