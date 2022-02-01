package com.tencent.mobileqq.activity.recent;

import alms;
import alnj;
import alnk;
import alno;
import alpv;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import annx;
import anzj;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;

public class HotChatCenterItemBuilder
  extends alnj
  implements View.OnClickListener, Runnable
{
  private SparseArray<SparseArray<ApolloGameRedDot>> jdField_a_of_type_AndroidUtilSparseArray;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  private void a()
  {
    try
    {
      ThreadManager.remove(this);
      ThreadManager.post(this, 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HotChatCenterItemBuilder", 1, "[loadRedDot]", localThrowable);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a();
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      paramQQAppInterface = ApolloGameUtil.a((SparseArray)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
      return (paramQQAppInterface != null) && (!paramQQAppInterface.mIsShow);
    }
    return false;
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    if ((this.jdField_a_of_type_Alms != null) && (this.jdField_a_of_type_Alms.a != null) && (this.jdField_a_of_type_JavaLangRefWeakReference == null))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_Alms.a);
      a();
    }
    paramalpv = null;
    paramViewGroup = paramalpv;
    if (paramView != null)
    {
      paramViewGroup = paramalpv;
      if ((paramView.getTag() instanceof alnk)) {
        paramViewGroup = (alnk)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramalpv = new alnk();
      localObject = a(paramContext, 2131558678, paramalpv);
      paramalpv.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject).findViewById(2131368212));
      paramalpv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131380442));
      paramalpv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131369615));
      paramalpv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131365116));
      paramalpv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramalpv.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131377965));
      paramalpv.c = ((TextView)((View)localObject).findViewById(2131367674));
      paramalpv.d = ((TextView)((View)localObject).findViewById(2131366206));
      paramalpv.e = ((TextView)((View)localObject).findViewById(16908309));
      paramalpv.e.setGravity(16);
      a((View)localObject, paramalpv.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramalpv);
      paramView = (View)localObject;
      paramViewGroup = paramalpv;
      if (this.jdField_a_of_type_Alms != null)
      {
        paramalpv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Alms.a());
        paramViewGroup = paramalpv;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramalpv = null;
        if (paramalno != null) {
          paramalpv = paramalno.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramalpv);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.c) {
            paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setContentDescription(String.format(anzj.a(2131704439), new Object[] { ((RecentItemEcShop)paramObject).getTitleName() }));
          }
        }
      }
      for (;;)
      {
        localObject = paramView.findViewById(2131376485);
        paramalno = paramView.findViewById(2131362770);
        View localView = paramView.findViewById(2131362771);
        paramalpv = paramView.findViewById(2131362773);
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        ((View)localObject).setOnClickListener(paramOnClickListener);
        paramalno.setOnClickListener(this);
        ((View)localObject).setTag(-1, Integer.valueOf(paramInt));
        paramalno.setTag(-1, Integer.valueOf(paramInt));
        paramalno.setTag(-100, paramOnClickListener);
        localView.setLongClickable(true);
        localView.setOnLongClickListener(paramOnLongClickListener);
        localView.setTag(-1, Integer.valueOf(paramInt));
        if (((paramObject instanceof RecentHotchatItem)) && (this.jdField_a_of_type_Alms != null) && (this.jdField_a_of_type_Alms.a != null)) {
          break;
        }
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.c.setText("");
          paramViewGroup.d.setText("");
          paramViewGroup.e.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
      paramViewGroup = (RecentHotchatItem)paramObject;
      paramObject = (TextView)paramView.findViewById(2131362774);
      paramOnClickListener = ApolloGameUtil.a(paramViewGroup.a(), this.jdField_a_of_type_Alms.a);
      label761:
      int i;
      if (paramOnClickListener != null)
      {
        paramObject.setText(paramOnClickListener.mTipsWording);
        paramObject = paramalno.getTag();
        if ((paramObject != null) && ((paramObject instanceof RedTouch))) {
          break label962;
        }
        paramObject = new RedTouch(paramContext, paramalpv).a(19).a();
        paramalno.setTag(paramObject);
        if (!a(this.jdField_a_of_type_Alms.a, paramViewGroup.a())) {
          break label986;
        }
        paramalno.setTag(-200, Integer.valueOf(paramViewGroup.a()));
        paramalno.setTag(-300, paramObject);
        paramalno = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramalno.red_type.set(0);
        paramObject.a(paramalno);
        paramObject = ApolloGameUtil.a(paramViewGroup.a(), this.jdField_a_of_type_Alms.a);
        if (paramObject != null) {
          break label970;
        }
        paramInt = 0;
        label846:
        i = paramViewGroup.a();
        if (paramObject != null) {
          break label978;
        }
      }
      label962:
      label970:
      label978:
      for (paramObject = "";; paramObject = paramObject.mActId)
      {
        VipUtils.a(null, "cmshow", "Apollo", "reddot_show", paramInt, 0, new String[] { String.valueOf(i), String.valueOf(0), paramObject });
        return paramView;
        paramInt = paramViewGroup.a();
        paramOnClickListener = ((annx)this.jdField_a_of_type_Alms.a.getManager(155)).a(paramInt);
        if (paramOnClickListener == null) {
          break;
        }
        paramObject.setText(String.format(anzj.a(2131704438), new Object[] { paramOnClickListener.name }));
        break;
        paramObject = (RedTouch)paramObject;
        break label761;
        paramInt = paramObject.mDotId;
        break label846;
      }
      label986:
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterItemBuilder", 2, "[getView] no red dot");
      }
      paramObject.d();
      paramalpv.setVisibility(0);
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag(-100) != null) && ((paramView.getTag(-100) instanceof View.OnClickListener))) {
      ((View.OnClickListener)paramView.getTag(-100)).onClick(paramView);
    }
    if ((paramView.getTag(-200) != null) && ((paramView.getTag(-200) instanceof Integer)))
    {
      int i = ((Integer)paramView.getTag(-200)).intValue();
      if ((paramView.getTag(-300) != null) && ((paramView.getTag(-300) instanceof RedTouch)))
      {
        ((RedTouch)paramView.getTag(-300)).d();
        ViewParent localViewParent = paramView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof View))) {
          ((View)localViewParent).setVisibility(0);
        }
      }
      paramView.setTag(-300, null);
      paramView.setTag(-200, null);
      ThreadManager.post(new HotChatCenterItemBuilder.1(this, i), 5, null, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      EntityManager localEntityManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().createEntityManager();
      if (localEntityManager != null) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_AndroidUtilSparseArray = ApolloGameUtil.a(localEntityManager);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder
 * JD-Core Version:    0.7.0.1
 */