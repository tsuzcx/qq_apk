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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    WSCommentPopupWindow localWSCommentPopupWindow = new WSCommentPopupWindow(LayoutInflater.from(paramActivity).inflate(2131560121, null), paramInt1, paramInt2);
    localWSCommentPopupWindow.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localWSCommentPopupWindow.setAnimationStyle(2131755487);
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
    localView.findViewById(2131377366).setOnClickListener(new WSCommentPopupWindow.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)localView.findViewById(2131365294));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(false);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365058);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366694));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setListView(this.jdField_a_of_type_AndroidWidgetListView);
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
    WSLog.a("DraggablePopup", "progress = " + paramFloat);
    b((float)(0.7D + paramFloat * 0.3D));
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.a(0);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    b(1.0F);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379738) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentPopupWindow
 * JD-Core Version:    0.7.0.1
 */