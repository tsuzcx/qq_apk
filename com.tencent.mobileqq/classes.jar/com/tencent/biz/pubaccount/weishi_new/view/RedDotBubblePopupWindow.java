package com.tencent.biz.pubaccount.weishi_new.view;

import UserGrowth.stNotificationRedDot;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class RedDotBubblePopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(8.0F);
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RedDotBubblePopupWindow.DisPopupRunnable jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable;
  private RedDotBubblePopupWindow.RedDotBubblePopupListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$RedDotBubblePopupListener;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private TextView b;
  private TextView c;
  
  public RedDotBubblePopupWindow(Activity paramActivity, RedDotBubblePopupWindow.RedDotBubblePopupListener paramRedDotBubblePopupListener)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$RedDotBubblePopupListener = paramRedDotBubblePopupListener;
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = ((View)localObject).getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          int j;
          if (i == 0) {
            j = 0;
          } else {
            j = jdField_a_of_type_Int;
          }
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
        }
        i += 1;
      }
    }
  }
  
  private void b(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    paramView.findViewById(2131370288).setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131370027));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131366469));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131372214));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370033));
    this.b = ((TextView)paramView.findViewById(2131366471));
    this.c = ((TextView)paramView.findViewById(2131372215));
    String str1 = "";
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = "";
      paramView = paramArrayList;
      for (;;)
      {
        str2 = str1;
        localObject2 = paramArrayList;
        localObject1 = paramView;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (stNotificationRedDot)localIterator.next();
        if (((stNotificationRedDot)localObject1).type == 2) {
          str1 = ((stNotificationRedDot)localObject1).text;
        } else if (((stNotificationRedDot)localObject1).type == 3) {
          paramArrayList = ((stNotificationRedDot)localObject1).text;
        } else if (((stNotificationRedDot)localObject1).type == 1) {
          paramView = ((stNotificationRedDot)localObject1).text;
        }
      }
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    String str2 = str1;
    if (TextUtils.isEmpty(str2))
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(8);
    }
    else
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(8);
    }
    else
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(0);
      this.b.setText((CharSequence)localObject2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(8);
      return;
    }
    ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(0);
    this.c.setText((CharSequence)localObject1);
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      RedDotBubblePopupWindow.DisPopupRunnable localDisPopupRunnable = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable;
      if (localDisPopupRunnable != null)
      {
        localHandler.removeCallbacksAndMessages(localDisPopupRunnable);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable = null;
      }
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    if (isShowing()) {
      dismiss();
    }
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559988, null);
      b(this.jdField_a_of_type_AndroidViewView, paramArrayList);
      setContentView(this.jdField_a_of_type_AndroidViewView);
      setWidth(-2);
      setHeight(-2);
      b();
    }
    paramView.post(new RedDotBubblePopupWindow.1(this, paramView));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370288)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$RedDotBubblePopupListener;
      if (paramView != null) {
        paramView.a();
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */