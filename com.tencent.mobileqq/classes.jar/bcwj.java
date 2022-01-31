import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class bcwj
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, wwq
{
  public static final int a;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new bcwk(this);
  protected ValueAnimator a;
  public Context a;
  public Animatable a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  protected RelativeLayout a;
  public TextView a;
  protected bbqg a;
  protected bcwm a;
  protected bcws a;
  protected StoryHomeHorizontalListView a;
  protected QQAppInterface a;
  protected String a;
  protected boolean a;
  public int b;
  private ValueAnimator.AnimatorUpdateListener b;
  protected ValueAnimator b;
  protected RelativeLayout b;
  private int c = 1;
  
  static
  {
    jdField_a_of_type_Int = xsm.a(BaseApplicationImpl.getContext(), 111.0F);
  }
  
  public bcwj(QQAppInterface paramQQAppInterface, Context paramContext, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, bbqg parambbqg)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new bcwl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout1;
    this.jdField_a_of_type_Bbqg = parambbqg;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout2;
    this.jdField_a_of_type_Bcws = ((bcws)paramQQAppInterface.getManager(234));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void U_()
  {
    int j;
    if (this.jdField_b_of_type_Int == 2) {
      j = 22;
    }
    for (int i = 8;; i = 1)
    {
      if (this.jdField_b_of_type_Int == 3) {
        i = 5;
      }
      Intent localIntent = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
      localIntent.putExtra("selfSet_leftViewText", alud.a(2131716085));
      localIntent.putExtra("sort_type", i);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (this.jdField_b_of_type_Int == 2)
      {
        bdes.a("Grp_idol", "Grp_renshu", "right", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
        return;
      }
      new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("enter_mberList").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
      return;
      j = 17;
    }
  }
  
  public void V_() {}
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView == null) {
      return this.c;
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914), -jdField_a_of_type_Int + this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914) });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bcwm.b.clear();
    return this.c;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
    while (i >= 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i) == this.jdField_a_of_type_AndroidViewViewGroup) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      }
      i -= 1;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560398, null));
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378474));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnItemLongClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setBackgroundColor(-16445151);
        this.jdField_a_of_type_Bcwm = new bcwm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_Bcwm);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(2147483647);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      e();
      localObject = ((bcws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(this.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label384;
      }
      this.jdField_a_of_type_Bcwm.a((List)localObject);
      this.jdField_a_of_type_Bcwm.notifyDataSetChanged();
      this.c = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -jdField_a_of_type_Int + this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914), this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(0);
      if (this.jdField_a_of_type_Bbqg != null) {
        this.jdField_a_of_type_Bbqg.a(true);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Int != 2) {
        break label459;
      }
      bdes.a("Grp_idol", "Grp_renshu", "exp", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setBackgroundColor(-436207617);
      break;
      label384:
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362344));
      }
      this.jdField_a_of_type_Bcwm.a();
      this.jdField_a_of_type_Bcwm.notifyDataSetChanged();
      ThreadManager.getUIHandler().postDelayed(new TroopOnlineMemberBar.1(this), 500L);
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberBar", 2, "show(), itemList == null || itemList.empty");
      }
    }
    label459:
    new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    int i = this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_JavaLangString);
    if (i == 3)
    {
      this.jdField_b_of_type_Int = 2;
      return;
    }
    if (i == 5)
    {
      this.jdField_b_of_type_Int = 3;
      return;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) || ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()));
  }
  
  public void d()
  {
    if (a())
    {
      List localList = ((bcws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(this.jdField_a_of_type_JavaLangString);
      if (localList != null)
      {
        this.c = 0;
        e();
        this.jdField_a_of_type_Bcwm.a(localList);
        this.jdField_a_of_type_Bcwm.notifyDataSetChanged();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((bcwp)paramView.getTag()).jdField_a_of_type_Bcwr;
    if (paramAdapterView == null) {}
    for (;;)
    {
      return;
      if (paramAdapterView.jdField_a_of_type_Int == 2) {
        bdes.a("Grp_idol", "Grp_renshu", "clk", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      }
      while (!((bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, Long.valueOf(paramAdapterView.jdField_a_of_type_JavaLangString).longValue()))
      {
        awrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramAdapterView.jdField_a_of_type_JavaLangString, 0, -1);
        return;
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("clk_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, paramAdapterView.b }).a();
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bcwp)paramView.getTag();
    paramView = paramAdapterView.jdField_a_of_type_Bcwr;
    TroopChatPie localTroopChatPie = (TroopChatPie)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
    if (localTroopChatPie != null) {
      localTroopChatPie.a(paramView.jdField_a_of_type_JavaLangString, paramAdapterView.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), false, 1);
    }
    new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("press_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, paramView.b }).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwj
 * JD-Core Version:    0.7.0.1
 */