package com.tencent.biz.pubaccount.weishi_new.comment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  ListView jdField_a_of_type_AndroidWidgetListView;
  private WSDragLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
  
  private WSCommentPopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static WSCommentPopupWindow a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    WSCommentPopupWindow localWSCommentPopupWindow = new WSCommentPopupWindow(LayoutInflater.from(paramActivity).inflate(2131559993, null), paramInt1, paramInt2);
    localWSCommentPopupWindow.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localWSCommentPopupWindow.setAnimationStyle(2131755835);
    localWSCommentPopupWindow.c();
    localWSCommentPopupWindow.setFocusable(true);
    localWSCommentPopupWindow.setInputMethodMode(1);
    localWSCommentPopupWindow.setSoftInputMode(16);
    localWSCommentPopupWindow.setClippingEnabled(false);
    localWSCommentPopupWindow.getContentView().setOnKeyListener(new WSCommentPopupWindow.1(localWSCommentPopupWindow));
    localWSCommentPopupWindow.setOutsideTouchable(true);
    return localWSCommentPopupWindow;
  }
  
  private void b(float paramFloat)
  {
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = paramFloat;
    localWindow.addFlags(2);
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void c()
  {
    View localView = getContentView();
    localView.findViewById(2131376818).setOnClickListener(new WSCommentPopupWindow.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)localView.findViewById(2131365169));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(false);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364941);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366563));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setContentView(this.jdField_a_of_type_AndroidWidgetListView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setTouchListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setMode(1);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress = ");
    localStringBuilder.append(paramFloat);
    WSLog.a("DraggablePopup", localStringBuilder.toString());
    double d = paramFloat;
    Double.isNaN(d);
    b((float)(d * 0.3D + 0.7D));
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    WSDragLayout localWSDragLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
    if (localWSDragLayout != null) {
      localWSDragLayout.a(0);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    b(1.0F);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379076) {
      dismiss();
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    if (SystemBarTintManager.hasNavBar(this.jdField_a_of_type_AndroidAppActivity))
    {
      i = paramInt3;
      if (ScreenUtil.isNavigationBarExist(this.jdField_a_of_type_AndroidAppActivity)) {
        i = paramInt3 + SystemBarTintManager.getNavigationBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentPopupWindow
 * JD-Core Version:    0.7.0.1
 */