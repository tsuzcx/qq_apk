package com.tencent.biz.troop.feeds;

import android.graphics.Rect;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

class TroopNewGuidePopWindow$2
  implements BounceScrollView.OnScrollChangedListener
{
  TroopNewGuidePopWindow$2(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a.C != null) && (this.a.D))
    {
      Object localObject = new Rect();
      this.a.p.getHitRect((Rect)localObject);
      if (this.a.s.getLocalVisibleRect((Rect)localObject))
      {
        localObject = this.a;
        ((TroopNewGuidePopWindow)localObject).D = false;
        TroopBarUtils.a(((TroopNewGuidePopWindow)localObject).a, null, this.a.C.a, 0, null, null);
        ReportController.b(this.a.w, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "exp_ad", 0, 0, this.a.z, String.valueOf(this.a.B.a), "8020205751015455", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "onScrollChanged 广告图片可见-------------------------");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.2
 * JD-Core Version:    0.7.0.1
 */