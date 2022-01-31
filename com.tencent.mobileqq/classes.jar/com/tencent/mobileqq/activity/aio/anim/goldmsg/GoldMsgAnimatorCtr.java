package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class GoldMsgAnimatorCtr
  implements Handler.Callback, TextWatcher, View.OnClickListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AIOFooterViewDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  int c;
  int d = 0;
  private int e = 0;
  
  public GoldMsgAnimatorCtr(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = paramAIOFooterViewDetector;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_b_of_type_Int = ((int)(paramQQAppInterface.density * 10.0F + 0.5F));
    this.c = ((int)(paramQQAppInterface.density * 50.0F + 0.5F));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramRelativeLayout.findViewById(2131363489));
    this.jdField_a_of_type_AndroidWidgetListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {}
    do
    {
      return;
      if (this.e == 0) {}
      for (int i = 1;; i = this.e)
      {
        this.e = i;
        if (this.e != 1) {
          break;
        }
        Bundle localBundle = new Bundle();
        localBundle.putInt("animType", 1);
        a(this.e, localBundle);
        return;
      }
    } while (this.e != 2);
    a(this.e, null);
  }
  
  public BaseBubbleBuilder.ViewHolder a(long paramLong)
  {
    int i = AIOUtils.a(paramLong, this.jdField_a_of_type_AndroidWidgetListAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgAnimatorCtr", 2, "getViewHolderByMsgUniseq adapterCount=" + this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() + ",msgUniseq=" + paramLong + ",findMessagePosition=" + i);
    }
    if (i < 0) {
      return null;
    }
    Object localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i));
    if ((localObject instanceof BaseBubbleBuilder.ViewHolder)) {}
    for (localObject = (BaseBubbleBuilder.ViewHolder)localObject;; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgAnimatorCtr", 2, "getViewHolderByMsgUniseq msgUniseq=" + paramLong + ",viewHolder=" + localObject);
      }
      return localObject;
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("GoldMsgAnimatorCtr", 4, "finish...");
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      if (localIterator.hasNext()) {
        ((BaseGoldMsgAnimator)((Map.Entry)localIterator.next()).getValue()).b();
      }
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width = 0;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestLayout();
    }
    this.e = 0;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    if (this.d != 0)
    {
      a();
      return;
    }
    d();
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    this.e = paramInt;
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    if (paramBundle != null) {
      localMessage.setData(paramBundle);
    }
    localMessage.sendToTarget();
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs.length < 3) || (!(paramVarArgs[0] instanceof Long)) || (!(paramVarArgs[1] instanceof Long)) || (!(paramVarArgs[2] instanceof String)) || (!(paramVarArgs[3] instanceof Integer)) || (!(paramVarArgs[4] instanceof Long))) {}
    do
    {
      do
      {
        return;
      } while (((Long)paramVarArgs[1]).longValue() <= this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Long = ((Long)paramVarArgs[0]).longValue();
      this.jdField_b_of_type_Long = ((Long)paramVarArgs[1]).longValue();
      this.jdField_a_of_type_JavaLangString = ((String)paramVarArgs[2]);
      this.jdField_a_of_type_Int = ((Integer)paramVarArgs[3]).intValue();
      long l = ((Long)paramVarArgs[4]).longValue();
      if (QLog.isDevelopLevel()) {
        QLog.i("GoldMsgAnimatorCtr", 4, "start... msgId=" + l + "，currStep=" + this.e + ",currMoney=" + this.jdField_a_of_type_Long + ",totalMoney=" + this.jdField_b_of_type_Long + ",friendUin=" + this.jdField_a_of_type_JavaLangString + ",currSessionType=" + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilVector.add(Long.valueOf(l));
      c();
    } while (this.d != 0);
    d();
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("GoldMsgAnimatorCtr", 4, "uninit...");
    }
    a();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_JavaUtilVector != null) {
        this.jdField_a_of_type_JavaUtilVector.clear();
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Boolean = false;
      this.d = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = null;
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
    {
      paramCharSequence = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramCharSequence.what = 2;
      paramCharSequence.sendToTarget();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("GoldMsgAnimatorCtr", 4, "init...");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970948, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(6, 2131363489);
      localLayoutParams.addRule(8, 2131363489);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, -1, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131362398).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372339));
      this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(2, this.c).a(this.c, false, "goldMsg");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("GoldMsgAnimatorCtr", 4, "handleMessage...currStep=" + this.e);
    }
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      localObject1 = (BaseGoldMsgAnimator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.e));
      if (localObject1 == null) {
        switch (this.e)
        {
        default: 
          label112:
          if (localObject1 == null) {}
          break;
        }
      }
      break;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.e)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.e), localObject1);
          if (!(localObject1 instanceof GoldMsgLayAnim)) {
            break label252;
          }
          ((BaseGoldMsgAnimator)localObject1).a(paramMessage.getData());
          return false;
          localObject1 = new GoldMsgLayAnim(this.e, this, this.jdField_b_of_type_AndroidWidgetRelativeLayout);
          break label112;
          localObject1 = new GoldMsgNumAnim(this.e, this, this.jdField_b_of_type_AndroidWidgetRelativeLayout);
          break label112;
        }
        localObject1 = (BaseGoldMsgAnimator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.e));
      }
      label252:
      if (!(localObject1 instanceof GoldMsgNumAnim)) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilVector.isEmpty())
      {
        ((BaseGoldMsgAnimator)localObject1).a(null);
        return false;
      }
      paramMessage = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (paramMessage.hasNext())
      {
        long l = ((Long)paramMessage.next()).longValue();
        ??? = new Bundle();
        ((Bundle)???).putLong("messageId", l);
        ((BaseGoldMsgAnimator)localObject1).a((Bundle)???);
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
      return false;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)) {
        break;
      }
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.measure(i, i);
      this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width = (this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestLayout();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.e == 0)
      {
        paramView = new Bundle();
        paramView.putInt("animType", 1);
        paramView.putBoolean("fromClick", true);
        a(1, paramView);
        return;
      }
      paramView = GoldMsgChatHelper.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(paramView));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr
 * JD-Core Version:    0.7.0.1
 */