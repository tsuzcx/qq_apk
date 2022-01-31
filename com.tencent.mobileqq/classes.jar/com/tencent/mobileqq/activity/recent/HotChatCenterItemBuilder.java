package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import xgx;

public class HotChatCenterItemBuilder
  extends RecentDefaultItemBuilder
  implements View.OnClickListener, Runnable
{
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
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
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a != null) && (this.jdField_a_of_type_JavaLangRefWeakReference == null))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a);
      a();
    }
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        paramViewGroup = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramOnDragModeChangedListener = new RecentDefaultItemBuilder.RecentItemDefaultHolder();
      localObject = a(paramContext, 2130968688, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131362701));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131363189));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131363183));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131363187));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131363185));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131363186));
      paramOnDragModeChangedListener.d = ((TextView)((View)localObject).findViewById(2131363188));
      paramOnDragModeChangedListener.e = ((TextView)((View)localObject).findViewById(16908309));
      paramOnDragModeChangedListener.e.setGravity(16);
      a((View)localObject, paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramOnDragModeChangedListener);
      paramView = (View)localObject;
      paramViewGroup = paramOnDragModeChangedListener;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = paramOnDragModeChangedListener;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.b) {
        paramView.setContentDescription(null);
      }
      label627:
      int i;
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null) {
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramOnDragModeChangedListener);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.b) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format("点击进入%s资料卡页面", new Object[] { ((RecentItemEcShop)paramObject).b() }));
          }
        }
        localObject = paramView.findViewById(2131363182);
        paramRecentFaceDecoder = paramView.findViewById(2131363190);
        View localView = paramView.findViewById(2131363181);
        paramOnDragModeChangedListener = paramView.findViewById(2131363193);
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        ((View)localObject).setOnClickListener(paramOnClickListener);
        paramRecentFaceDecoder.setOnClickListener(this);
        ((View)localObject).setTag(-1, Integer.valueOf(paramInt));
        paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
        paramRecentFaceDecoder.setTag(-100, paramOnClickListener);
        localView.setLongClickable(true);
        localView.setOnLongClickListener(paramOnLongClickListener);
        localView.setTag(-1, Integer.valueOf(paramInt));
        if (((paramObject instanceof RecentHotchatItem)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a != null))
        {
          paramViewGroup = (RecentHotchatItem)paramObject;
          paramObject = (TextView)paramView.findViewById(2131363192);
          paramOnClickListener = ApolloGameUtil.a(paramViewGroup.c(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a);
          if (paramOnClickListener == null) {
            break label901;
          }
          paramObject.setText(paramOnClickListener.mTipsWording);
          paramObject = paramRecentFaceDecoder.getTag();
          if ((paramObject != null) && ((paramObject instanceof RedTouch))) {
            break label959;
          }
          paramObject = new RedTouch(paramContext, paramOnDragModeChangedListener).a(19).a();
          paramRecentFaceDecoder.setTag(paramObject);
          label668:
          if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, paramViewGroup.c())) {
            break label983;
          }
          paramRecentFaceDecoder.setTag(-200, Integer.valueOf(paramViewGroup.c()));
          paramRecentFaceDecoder.setTag(-300, paramObject);
          paramRecentFaceDecoder = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramRecentFaceDecoder.red_type.set(0);
          paramObject.a(paramRecentFaceDecoder);
          paramObject = ApolloGameUtil.a(paramViewGroup.c(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a);
          if (paramObject != null) {
            break label967;
          }
          paramInt = 0;
          label753:
          i = paramViewGroup.c();
          if (paramObject != null) {
            break label975;
          }
        }
      }
      label901:
      label959:
      label967:
      label975:
      for (paramObject = "";; paramObject = paramObject.mActId)
      {
        VipUtils.a(null, "cmshow", "Apollo", "reddot_show", paramInt, 0, new String[] { String.valueOf(i), String.valueOf(0), paramObject });
        return paramView;
        if (paramViewGroup == null) {
          break;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.d.setText("");
        paramViewGroup.e.setText("");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        paramInt = paramViewGroup.c();
        paramOnClickListener = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(154)).a(paramInt);
        if (paramOnClickListener == null) {
          break label627;
        }
        paramObject.setText(String.format("马上来玩%s", new Object[] { paramOnClickListener.name }));
        break label627;
        paramObject = (RedTouch)paramObject;
        break label668;
        paramInt = paramObject.mDotId;
        break label753;
      }
      label983:
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterItemBuilder", 2, "[getView] no red dot");
      }
      paramObject.b();
      paramOnDragModeChangedListener.setVisibility(0);
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
        ((RedTouch)paramView.getTag(-300)).b();
        ViewParent localViewParent = paramView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof View))) {
          ((View)localViewParent).setVisibility(0);
        }
      }
      paramView.setTag(-300, null);
      paramView.setTag(-200, null);
      ThreadManager.post(new xgx(this, i), 5, null, false);
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      EntityManager localEntityManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getEntityManagerFactory().createEntityManager();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder
 * JD-Core Version:    0.7.0.1
 */