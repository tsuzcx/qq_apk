package com.tencent.comic.ui;

import android.util.SparseArray;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.jsp.QQComicDownloadCountObserver;
import com.tencent.comic.utils.SimpleBiMap;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import java.util.List;

class QQComicTabBarView$3
  implements QQComicDownloadCountObserver
{
  QQComicTabBarView$3(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.getSelectedTabIndex();
    if ((this.a.g != null) && (paramInt1 >= 0))
    {
      if (paramInt1 >= this.a.g.size()) {
        return;
      }
      paramInt2 = VipComicJumpActivity.getIndexByTag("fav", this.a.g);
      if ((paramBoolean) && (paramInt1 != paramInt2))
      {
        this.a.a(paramInt2);
        return;
      }
      RedTouchUI localRedTouchUI = (RedTouchUI)this.a.e.get("1113.100801");
      RedAppInfo localRedAppInfo = (RedAppInfo)this.a.d.get(paramInt2);
      if ((localRedTouchUI != null) && (localRedTouchUI.h()) && (localRedAppInfo != null) && (localRedTouchUI.a == localRedAppInfo)) {
        this.a.a(paramInt2, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.3
 * JD-Core Version:    0.7.0.1
 */