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
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class anpk
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
  private List<annl> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public anpk(QQAppInterface paramQQAppInterface, Context paramContext)
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
          break label1174;
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
    anoa localanoa;
    int m;
    Object localObject2;
    label361:
    int j;
    label471:
    float f1;
    label522:
    int n;
    if (i < this.jdField_b_of_type_Int)
    {
      localObject1 = paramApolloLinearLayout.getChildAt(i);
      localanoa = (anoa)((View)localObject1).getTag();
      m = paramInt * k + i;
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1580;
      }
      ((View)localObject1).setVisibility(0);
      ApolloActionData localApolloActionData = ((annl)this.jdField_a_of_type_JavaUtilList.get(m)).a;
      localanoa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localanoa.jdField_a_of_type_Annl = ((annl)this.jdField_a_of_type_JavaUtilList.get(m));
      if (this.c == 4) {
        localanoa.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838641);
      }
      if (localanoa.jdField_a_of_type_Annl.jdField_b_of_type_Int != 1) {
        break label1183;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject2 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localanoa.jdField_a_of_type_AndroidWidgetImageView).b(5).a();
        ((RedTouch)localObject2).a(((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103200"));
        localanoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838643);
        localanoa.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = ((RedTouch)localObject2);
      }
      localanoa.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      if (this.c != 4) {
        localanoa.jdField_a_of_type_Annl.c = 0;
      }
      if ((this.c != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
      {
        localanoa.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(anev.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
        localanoa.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if (TextUtils.isEmpty(localanoa.jdField_a_of_type_Annl.jdField_b_of_type_JavaLangString)) {
        break label1511;
      }
      if (XPanelContainer.d != 0) {
        break label1288;
      }
      j = 1;
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localanoa.e.setVisibility(0);
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setText(localanoa.jdField_a_of_type_Annl.jdField_b_of_type_JavaLangString);
      if (j == 0) {
        break label1294;
      }
      f1 = 3.0F;
      n = AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = (RelativeLayout.LayoutParams)localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = n;
      ((RelativeLayout.LayoutParams)localObject2).width = (ApolloLinearLayout.e - n * 2);
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - n * 3);
      localObject2 = (RelativeLayout.LayoutParams)localanoa.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (j == 0) {
        break label1301;
      }
      f1 = 2.0F;
      label604:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localanoa.e.setBackgroundResource(2130838480);
      if (localanoa.jdField_a_of_type_Annl.d != 1) {
        break label1366;
      }
      if (j == 0) {
        break label1308;
      }
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      if (f == 0) {
        f = amqw.a(localanoa.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = f;
      label685:
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      localObject2 = localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (j == 0) {
        break label1504;
      }
      f1 = 3.0F;
      label720:
      ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.dp2px(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
      label748:
      ApolloLinearLayout.setApolloActionIcon(localanoa.jdField_a_of_type_Annl.g, localanoa.jdField_a_of_type_Annl.a, localanoa);
      if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000))) {
        localanoa.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject2 = (RelativeLayout)localObject1;
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int != m)) {
        break label1553;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelListAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.jdField_a_of_type_Int), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
      }
      if (localanoa.jdField_a_of_type_AndroidViewView != null)
      {
        ((RelativeLayout)localObject2).removeView(localanoa.jdField_a_of_type_AndroidViewView);
        localanoa.jdField_a_of_type_AndroidViewView = null;
      }
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131363166);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131363166);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363166);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131363166);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setId(2131362763);
      localRelativeLayout.setBackgroundDrawable(null);
      ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
      localanoa.jdField_a_of_type_AndroidViewView = localRelativeLayout;
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setImageResource(2130838638);
      ((ImageView)localObject3).setVisibility(8);
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
      ((ImageView)localObject3).postDelayed(new ApolloPanelListAdapter.1(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localanoa), 200L);
      this.jdField_a_of_type_Int = -1;
      label1091:
      ((View)localObject1).setContentDescription(localApolloActionData.actionName);
      if ((((annl)this.jdField_a_of_type_JavaUtilList.get(m)).a != null) && (((annl)this.jdField_a_of_type_JavaUtilList.get(m)).a.isForPlayerAction == 1)) {
        a(localanoa, (annl)this.jdField_a_of_type_JavaUtilList.get(m));
      }
    }
    for (;;)
    {
      i += 1;
      break label156;
      break;
      label1174:
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      break label77;
      label1183:
      if (localanoa.jdField_a_of_type_Annl.jdField_b_of_type_Int == 2)
      {
        localanoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838610);
        break label361;
      }
      if (((annl)this.jdField_a_of_type_JavaUtilList.get(m)).a.isForPlayerAction == 1) {
        QLog.i("ApolloPanelListAdapter", 4, "setBackgroundDrawable getview");
      }
      localanoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((annl)this.jdField_a_of_type_JavaUtilList.get(m)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      break label361;
      label1288:
      j = 0;
      break label471;
      label1294:
      f1 = 5.0F;
      break label522;
      label1301:
      f1 = 5.0F;
      break label604;
      label1308:
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - n * 2);
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      if (d == 0) {
        d = amqw.a(localanoa.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = d;
      break label685;
      label1366:
      if (j != 0)
      {
        localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
        if (g == 0) {
          g = amqw.a(localanoa.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = g;
        localObject2 = localanoa.jdField_c_of_type_AndroidWidgetTextView;
        if (j == 0) {
          break label1498;
        }
      }
      label1410:
      label1498:
      for (f1 = 7.0F;; f1 = 10.0F)
      {
        ((TextView)localObject2).setTextSize(f1);
        localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838481);
        break;
        localanoa.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        if (e == 0) {
          e = amqw.a(localanoa.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = e;
        break label1410;
      }
      label1504:
      f1 = 9.0F;
      break label720;
      label1511:
      localanoa.e.setBackgroundDrawable(null);
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localanoa.e.setVisibility(8);
      break label748;
      label1553:
      if (localanoa.jdField_a_of_type_AndroidViewView == null) {
        break label1091;
      }
      ((RelativeLayout)localObject2).removeView(localanoa.jdField_a_of_type_AndroidViewView);
      localanoa.jdField_a_of_type_AndroidViewView = null;
      break label1091;
      label1580:
      ((View)localObject1).setContentDescription(null);
      ((View)localObject1).setOnClickListener(null);
      ((View)localObject1).setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(anoa paramanoa, annl paramannl)
  {
    QLog.d("ApolloPanelListAdapter", 4, "ApolloPanelListAdapter handleCMSPlayerGetFrame : " + paramannl.toString());
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (localamme != null) {
      localamme.a("ApolloPanelListAdapter", paramannl.a, new anpn(this, paramanoa, paramannl));
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(List<annl> paramList)
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
 * Qualified Name:     anpk
 * JD-Core Version:    0.7.0.1
 */