import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloPanelListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class amnd
  extends BaseAdapter
{
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<amlu> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public amnd(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {
      return;
    }
    paramApolloLinearLayout.a();
    paramApolloLinearLayout.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramApolloLinearLayout.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    paramApolloLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
    Object localObject1 = (LinearLayout.LayoutParams)paramApolloLinearLayout.getLayoutParams();
    if (localObject1 != null)
    {
      if (paramInt == 0)
      {
        if (this.c == 4) {
          break label1109;
        }
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        label77:
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
    }
    int k = this.jdField_b_of_type_Int;
    int i = 0;
    label156:
    amlw localamlw;
    int m;
    Object localObject2;
    label360:
    int j;
    label470:
    float f1;
    label521:
    int n;
    if (i < this.jdField_b_of_type_Int)
    {
      localObject1 = paramApolloLinearLayout.getChildAt(i);
      localamlw = (amlw)((View)localObject1).getTag();
      m = paramInt * k + i;
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1481;
      }
      ((View)localObject1).setVisibility(0);
      ApolloActionData localApolloActionData = ((amlu)this.jdField_a_of_type_JavaUtilList.get(m)).a;
      localamlw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localamlw.jdField_a_of_type_Amlu = ((amlu)this.jdField_a_of_type_JavaUtilList.get(m));
      if (this.c == 4) {
        localamlw.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838625);
      }
      if (localamlw.jdField_a_of_type_Amlu.jdField_b_of_type_Int != 1) {
        break label1118;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject2 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localamlw.jdField_a_of_type_AndroidWidgetImageView).a(5).a();
        ((RedTouch)localObject2).a(((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103200"));
        localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838627);
        localamlw.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = ((RedTouch)localObject2);
      }
      localamlw.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      if (this.c != 4) {
        localamlw.jdField_a_of_type_Amlu.c = 0;
      }
      if ((this.c != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
      {
        localamlw.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(amdn.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
        localamlw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if (TextUtils.isEmpty(localamlw.jdField_a_of_type_Amlu.jdField_b_of_type_JavaLangString)) {
        break label1412;
      }
      if (XPanelContainer.d != 0) {
        break label1189;
      }
      j = 1;
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localamlw.e.setVisibility(0);
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setText(localamlw.jdField_a_of_type_Amlu.jdField_b_of_type_JavaLangString);
      if (j == 0) {
        break label1195;
      }
      f1 = 3.0F;
      n = AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = (RelativeLayout.LayoutParams)localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = n;
      ((RelativeLayout.LayoutParams)localObject2).width = (ApolloLinearLayout.e - n * 2);
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - n * 3);
      localObject2 = (RelativeLayout.LayoutParams)localamlw.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (j == 0) {
        break label1202;
      }
      f1 = 2.0F;
      label603:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localamlw.e.setBackgroundResource(2130838464);
      if (localamlw.jdField_a_of_type_Amlu.d != 1) {
        break label1267;
      }
      if (j == 0) {
        break label1209;
      }
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      if (f == 0) {
        f = alrv.a(localamlw.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = f;
      label684:
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      localObject2 = localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (j == 0) {
        break label1405;
      }
      f1 = 3.0F;
      label719:
      ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
      label747:
      ApolloLinearLayout.setApolloActionIcon(localamlw.jdField_a_of_type_Amlu.g, localamlw.jdField_a_of_type_Amlu.a, localamlw);
      if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000))) {
        localamlw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject2 = (RelativeLayout)localObject1;
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int != m)) {
        break label1454;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelListAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.jdField_a_of_type_Int), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
      }
      if (localamlw.jdField_a_of_type_AndroidViewView != null)
      {
        ((RelativeLayout)localObject2).removeView(localamlw.jdField_a_of_type_AndroidViewView);
        localamlw.jdField_a_of_type_AndroidViewView = null;
      }
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131363147);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131363147);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363147);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131363147);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setId(2131362747);
      localRelativeLayout.setBackgroundDrawable(null);
      ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
      localamlw.jdField_a_of_type_AndroidViewView = localRelativeLayout;
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setImageResource(2130838622);
      ((ImageView)localObject3).setVisibility(8);
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
      ((ImageView)localObject3).postDelayed(new ApolloPanelListAdapter.1(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localamlw), 200L);
      this.jdField_a_of_type_Int = -1;
      label1090:
      ((View)localObject1).setContentDescription(localApolloActionData.actionName);
    }
    for (;;)
    {
      i += 1;
      break label156;
      break;
      label1109:
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      break label77;
      label1118:
      if (localamlw.jdField_a_of_type_Amlu.jdField_b_of_type_Int == 2)
      {
        localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838594);
        break label360;
      }
      localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((amlu)this.jdField_a_of_type_JavaUtilList.get(m)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      break label360;
      label1189:
      j = 0;
      break label470;
      label1195:
      f1 = 5.0F;
      break label521;
      label1202:
      f1 = 5.0F;
      break label603;
      label1209:
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - n * 2);
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      if (d == 0) {
        d = alrv.a(localamlw.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = d;
      break label684;
      label1267:
      if (j != 0)
      {
        localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
        if (g == 0) {
          g = alrv.a(localamlw.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = g;
        localObject2 = localamlw.jdField_c_of_type_AndroidWidgetTextView;
        if (j == 0) {
          break label1399;
        }
      }
      label1311:
      label1399:
      for (f1 = 7.0F;; f1 = 10.0F)
      {
        ((TextView)localObject2).setTextSize(f1);
        localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838465);
        break;
        localamlw.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        if (e == 0) {
          e = alrv.a(localamlw.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = e;
        break label1311;
      }
      label1405:
      f1 = 9.0F;
      break label719;
      label1412:
      localamlw.e.setBackgroundDrawable(null);
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localamlw.e.setVisibility(8);
      break label747;
      label1454:
      if (localamlw.jdField_a_of_type_AndroidViewView == null) {
        break label1090;
      }
      ((RelativeLayout)localObject2).removeView(localamlw.jdField_a_of_type_AndroidViewView);
      localamlw.jdField_a_of_type_AndroidViewView = null;
      break label1090;
      label1481:
      ((View)localObject1).setContentDescription(null);
      ((View)localObject1).setOnClickListener(null);
      ((View)localObject1).setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  protected void a(List<amlu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() / this.jdField_b_of_type_Int;
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() % this.jdField_b_of_type_Int != 0) {
        i = j + 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.jdField_b_of_type_Int, 1);
    }
    for (;;)
    {
      a((ApolloLinearLayout)paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnd
 * JD-Core Version:    0.7.0.1
 */