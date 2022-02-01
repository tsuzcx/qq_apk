package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

class TroopRequestActivity$5
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  TroopRequestActivity$5(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if ((paramBoolean) && (paramAccountDetail != null))
    {
      this.a.j.setText(paramAccountDetail.name);
      this.a.b.setVisibility(0);
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.5
 * JD-Core Version:    0.7.0.1
 */