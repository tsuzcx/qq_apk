package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopRecommendFriendFragment$5
  extends TroopRecommendObserver
{
  TroopRecommendFriendFragment$5(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  protected void a(boolean paramBoolean1, String paramString1, Object paramObject, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2)
  {
    ArrayList localArrayList = (ArrayList)paramObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopRecommendGrayTipsPerson ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      if (localArrayList == null) {
        paramObject = "";
      } else {
        paramObject = Integer.valueOf(localArrayList.size());
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      QLog.i("TroopRecommendFriendFragment", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (TroopRecommendFriendFragment.f(this.a).equals(paramString1)))
    {
      TroopRecommendFriendFragment.g(this.a).setVisibility(8);
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        TroopRecommendFriendFragment.a(this.a, paramArrayOfByte);
        TroopRecommendFriendFragment.a(this.a).a(localArrayList);
        TroopRecommendFriendFragment.a(this.a).notifyDataSetChanged();
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopRecommendFriendFragment", 2, "onGetTroopRecommendGrayTipsPerson no data");
        }
        TroopRecommendFriendFragment.g(this.a).setVisibility(0);
        paramString1 = TroopRecommendFriendFragment.g(this.a).findViewById(2131440726);
        if (paramString1 != null) {
          paramString1.setVisibility(8);
        }
        paramString1 = (TextView)TroopRecommendFriendFragment.g(this.a).findViewById(2131448897);
        if (paramString1 != null) {
          paramString1.setText(paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment.5
 * JD-Core Version:    0.7.0.1
 */