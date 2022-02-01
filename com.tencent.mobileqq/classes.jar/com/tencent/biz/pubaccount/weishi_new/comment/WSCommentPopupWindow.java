package com.tencent.biz.pubaccount.weishi_new.comment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout.TouchListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.immersive.SystemBarTintManager;

public class WSCommentPopupWindow
  extends PopupWindow
  implements View.OnClickListener, WSDragLayout.TouchListener
{
  ListView a;
  private WSDragLayout b;
  private View c;
  private Activity d;
  
  private WSCommentPopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static WSCommentPopupWindow a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    WSCommentPopupWindow localWSCommentPopupWindow = new WSCommentPopupWindow(LayoutInflater.from(paramActivity).inflate(2131626036, null), paramInt1, paramInt2);
    localWSCommentPopupWindow.d = paramActivity;
    localWSCommentPopupWindow.setAnimationStyle(2131952946);
    localWSCommentPopupWindow.e();
    localWSCommentPopupWindow.setFocusable(true);
    localWSCommentPopupWindow.setInputMethodMode(1);
    localWSCommentPopupWindow.setSoftInputMode(16);
    localWSCommentPopupWindow.setClippingEnabled(false);
    localWSCommentPopupWindow.getContentView().setOnKeyListener(new WSCommentPopupWindow.1(localWSCommentPopupWindow));
    localWSCommentPopupWindow.setOutsideTouchable(true);
    return localWSCommentPopupWindow;
  }
  
  private void e()
  {
    View localView = getContentView();
    localView.findViewById(2131445148).setOnClickListener(new WSCommentPopupWindow.2(this));
    this.b = ((WSDragLayout)localView.findViewById(2131431322));
    this.b.setDisableMinScrollY(true);
    this.b.setControlLitTongue(false);
    this.c = localView.findViewById(2131431066);
    this.a = ((ListView)this.c.findViewById(2131432885));
    this.b.setContentView(this.a);
    this.b.setTouchListener(this);
    this.b.setMode(1);
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress = ");
    localStringBuilder.append(paramFloat);
    WSLog.a("DraggablePopup", localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean b()
  {
    return false;
  }
  
  public View c()
  {
    return this.c;
  }
  
  public void d()
  {
    WSDragLayout localWSDragLayout = this.b;
    if (localWSDragLayout != null) {
      localWSDragLayout.a(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131447803) {
      dismiss();
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Activity localActivity = this.d;
    if ((localActivity != null) && (localActivity.isFinishing())) {
      return;
    }
    int i = paramInt3;
    if (SystemBarTintManager.hasNavBar(this.d))
    {
      i = paramInt3;
      if (ScreenUtil.isNavigationBarExist(this.d)) {
        i = paramInt3 + SystemBarTintManager.getNavigationBarHeight(this.d);
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentPopupWindow
 * JD-Core Version:    0.7.0.1
 */