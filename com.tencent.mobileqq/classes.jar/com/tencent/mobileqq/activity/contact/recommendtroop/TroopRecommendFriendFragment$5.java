package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopRecommendFriendFragment$5
  extends TroopBusinessObserver
{
  TroopRecommendFriendFragment$5(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  public void onGetTroopRecommendGrayTipsPerson(boolean paramBoolean1, String paramString1, ArrayList<RecommendMember> paramArrayList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopRecommendGrayTipsPerson ").append(paramBoolean1).append(" ").append(paramString1).append(" ");
      if (paramArrayList == null)
      {
        localObject = "";
        QLog.i("TroopRecommendFriendFragment", 2, localObject + " " + paramBoolean2 + " " + paramString2);
      }
    }
    else if ((paramBoolean1) && (TroopRecommendFriendFragment.a(this.a).equals(paramString1)))
    {
      TroopRecommendFriendFragment.a(this.a).setVisibility(8);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label167;
      }
      TroopRecommendFriendFragment.a(this.a, paramArrayOfByte);
      TroopRecommendFriendFragment.a(this.a).a(paramArrayList);
      TroopRecommendFriendFragment.a(this.a).notifyDataSetChanged();
    }
    label167:
    do
    {
      do
      {
        return;
        localObject = Integer.valueOf(paramArrayList.size());
        break;
      } while (TextUtils.isEmpty(paramString2));
      if (QLog.isColorLevel()) {
        QLog.i("TroopRecommendFriendFragment", 2, "onGetTroopRecommendGrayTipsPerson no data");
      }
      TroopRecommendFriendFragment.a(this.a).setVisibility(0);
      paramString1 = TroopRecommendFriendFragment.a(this.a).findViewById(2131373545);
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      paramString1 = (TextView)TroopRecommendFriendFragment.a(this.a).findViewById(2131380726);
    } while (paramString1 == null);
    paramString1.setText(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment.5
 * JD-Core Version:    0.7.0.1
 */