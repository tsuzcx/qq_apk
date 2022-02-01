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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.ArrayList<LUserGrowth.stNotificationRedDot;>;
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
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (((View)localObject).getVisibility() != 0) {
        break label87;
      }
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (i == 0)
        {
          j = 0;
          label66:
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
        }
      }
      else
      {
        i += 1;
      }
    }
    label87:
    for (;;)
    {
      break;
      j = jdField_a_of_type_Int;
      break label66;
      return;
    }
  }
  
  private void b(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    paramView.findViewById(2131370645).setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131370361));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131366600));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131372633));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370368));
    this.b = ((TextView)paramView.findViewById(2131366602));
    this.c = ((TextView)paramView.findViewById(2131372634));
    String str = "";
    Object localObject1 = "";
    paramView = "";
    Object localObject2 = paramView;
    Object localObject3 = localObject1;
    Object localObject4 = str;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = str;
      localObject2 = paramView;
      localObject3 = localObject1;
      localObject4 = paramArrayList;
      if (localIterator.hasNext())
      {
        localObject2 = (stNotificationRedDot)localIterator.next();
        if (((stNotificationRedDot)localObject2).type == 2)
        {
          localObject2 = ((stNotificationRedDot)localObject2).text;
          paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<stNotificationRedDot>)localObject2;
      break;
      if (((stNotificationRedDot)localObject2).type == 3)
      {
        localObject2 = ((stNotificationRedDot)localObject2).text;
        localObject1 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject2;
      }
      else if (((stNotificationRedDot)localObject2).type == 1)
      {
        paramView = ((stNotificationRedDot)localObject2).text;
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
        localObject1 = localObject2;
        continue;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(8);
          if (!TextUtils.isEmpty(localObject3)) {
            break label344;
          }
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label371;
          }
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(8);
          return;
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
          break;
          label344:
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(0);
          this.b.setText(localObject3);
        }
        label371:
        ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(0);
        this.c.setText((CharSequence)localObject2);
      }
      else
      {
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$DisPopupRunnable = null;
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560116, null);
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
    if (paramView.getId() == 2131370645)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$RedDotBubblePopupListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow$RedDotBubblePopupListener.a();
      }
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */