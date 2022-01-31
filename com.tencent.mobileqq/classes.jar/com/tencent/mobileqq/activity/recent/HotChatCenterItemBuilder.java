package com.tencent.mobileqq.activity.recent;

import ahai;
import ahaz;
import ahba;
import ahbe;
import ahdb;
import aiyu;
import ajjy;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import atmp;
import atmq;
import bajr;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;

public class HotChatCenterItemBuilder
  extends ahaz
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
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    if ((this.jdField_a_of_type_Ahai != null) && (this.jdField_a_of_type_Ahai.a != null) && (this.jdField_a_of_type_JavaLangRefWeakReference == null))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_Ahai.a);
      a();
    }
    paramahdb = null;
    paramViewGroup = paramahdb;
    if (paramView != null)
    {
      paramViewGroup = paramahdb;
      if ((paramView.getTag() instanceof ahba)) {
        paramViewGroup = (ahba)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramahdb = new ahba();
      localObject = a(paramContext, 2131493062, paramahdb);
      paramahdb.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject).findViewById(2131302061));
      paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131312826));
      paramahdb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131303219));
      paramahdb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131299195));
      paramahdb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramahdb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131310659));
      paramahdb.c = ((TextView)((View)localObject).findViewById(2131301546));
      paramahdb.d = ((TextView)((View)localObject).findViewById(2131300220));
      paramahdb.e = ((TextView)((View)localObject).findViewById(16908309));
      paramahdb.e.setGravity(16);
      a((View)localObject, paramahdb.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramahdb);
      paramView = (View)localObject;
      paramViewGroup = paramahdb;
      if (this.jdField_a_of_type_Ahai != null)
      {
        paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahai.a());
        paramViewGroup = paramahdb;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      label630:
      int i;
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramahdb = null;
        if (paramahbe != null) {
          paramahdb = paramahbe.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramahdb);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.c) {
            paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setContentDescription(String.format(ajjy.a(2131639751), new Object[] { ((RecentItemEcShop)paramObject).b() }));
          }
        }
        localObject = paramView.findViewById(2131309349);
        paramahbe = paramView.findViewById(2131297078);
        View localView = paramView.findViewById(2131297079);
        paramahdb = paramView.findViewById(2131297081);
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        ((View)localObject).setOnClickListener(paramOnClickListener);
        paramahbe.setOnClickListener(this);
        ((View)localObject).setTag(-1, Integer.valueOf(paramInt));
        paramahbe.setTag(-1, Integer.valueOf(paramInt));
        paramahbe.setTag(-100, paramOnClickListener);
        localView.setLongClickable(true);
        localView.setOnLongClickListener(paramOnLongClickListener);
        localView.setTag(-1, Integer.valueOf(paramInt));
        if (((paramObject instanceof RecentHotchatItem)) && (this.jdField_a_of_type_Ahai != null) && (this.jdField_a_of_type_Ahai.a != null))
        {
          paramViewGroup = (RecentHotchatItem)paramObject;
          paramObject = (TextView)paramView.findViewById(2131297082);
          paramOnClickListener = ApolloGameUtil.a(paramViewGroup.c(), this.jdField_a_of_type_Ahai.a);
          if (paramOnClickListener == null) {
            break label904;
          }
          paramObject.setText(paramOnClickListener.mTipsWording);
          paramObject = paramahbe.getTag();
          if ((paramObject != null) && ((paramObject instanceof RedTouch))) {
            break label965;
          }
          paramObject = new RedTouch(paramContext, paramahdb).a(19).a();
          paramahbe.setTag(paramObject);
          label671:
          if (!a(this.jdField_a_of_type_Ahai.a, paramViewGroup.c())) {
            break label989;
          }
          paramahbe.setTag(-200, Integer.valueOf(paramViewGroup.c()));
          paramahbe.setTag(-300, paramObject);
          paramahbe = new BusinessInfoCheckUpdate.RedTypeInfo();
          paramahbe.red_type.set(0);
          paramObject.a(paramahbe);
          paramObject = ApolloGameUtil.a(paramViewGroup.c(), this.jdField_a_of_type_Ahai.a);
          if (paramObject != null) {
            break label973;
          }
          paramInt = 0;
          label756:
          i = paramViewGroup.c();
          if (paramObject != null) {
            break label981;
          }
        }
      }
      label904:
      label965:
      label973:
      label981:
      for (paramObject = "";; paramObject = paramObject.mActId)
      {
        bajr.a(null, "cmshow", "Apollo", "reddot_show", paramInt, 0, new String[] { String.valueOf(i), String.valueOf(0), paramObject });
        return paramView;
        if (paramViewGroup == null) {
          break;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.c.setText("");
        paramViewGroup.d.setText("");
        paramViewGroup.e.setText("");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        paramInt = paramViewGroup.c();
        paramOnClickListener = ((aiyu)this.jdField_a_of_type_Ahai.a.getManager(155)).a(paramInt);
        if (paramOnClickListener == null) {
          break label630;
        }
        paramObject.setText(String.format(ajjy.a(2131639750), new Object[] { paramOnClickListener.name }));
        break label630;
        paramObject = (RedTouch)paramObject;
        break label671;
        paramInt = paramObject.mDotId;
        break label756;
      }
      label989:
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterItemBuilder", 2, "[getView] no red dot");
      }
      paramObject.b();
      paramahdb.setVisibility(0);
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
      ThreadManager.post(new HotChatCenterItemBuilder.1(this, i), 5, null, false);
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      atmp localatmp = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getEntityManagerFactory().createEntityManager();
      if (localatmp != null) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_AndroidUtilSparseArray = ApolloGameUtil.a(localatmp);
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