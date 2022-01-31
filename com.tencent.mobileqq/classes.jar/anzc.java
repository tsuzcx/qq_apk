import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.ColorNoteListLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class anzc
  implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener, anzn
{
  private static int jdField_a_of_type_Int = 2131167206;
  private static int jdField_b_of_type_Int = 2131167192;
  private static int c = 2130839080;
  private Context jdField_a_of_type_AndroidContentContext;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private anyx jdField_a_of_type_Anyx;
  private anzn jdField_a_of_type_Anzn;
  private ColorNoteListLayout jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  
  public anzc(Context paramContext, anzn paramanzn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Anzn = paramanzn;
  }
  
  private void c()
  {
    e();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558845, null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout = ((ColorNoteListLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364460));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364464));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363438));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364463));
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new anzd(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new anze(this));
    localObject = new anzf(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363438).setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.requestFocus();
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.hasFocus())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(200L).start();
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();; f = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth())
    {
      localViewPropertyAnimator.translationX(f).setDuration(180L).setListener(new anzk(this)).start();
      return;
    }
  }
  
  private void e()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      jdField_a_of_type_Int = 2131165326;
      jdField_b_of_type_Int = 2131165307;
      c = 2130839081;
      return;
    }
    jdField_a_of_type_Int = 2131167206;
    jdField_b_of_type_Int = 2131167192;
    c = 2130839080;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_Anyx = new anyx();
    this.jdField_a_of_type_Anyx.a(this);
    this.jdField_a_of_type_Anyx.a(paramBoolean);
    List localList = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a();
    this.jdField_a_of_type_Anyx.a(localList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Anyx);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_Anyx.a(new anzg(this));
    Object localObject;
    if (localList.size() > 0)
    {
      localObject = (ColorNote)localList.get(0);
      if (anyi.b((ColorNote)localObject)) {
        azmj.b(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", anxm.b(anyi.a(((ColorNote)localObject).getServiceType())), 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setAnchor(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setHideListener(this);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.9F).setDuration(200L).setListener(new anzj(this, paramBoolean)).start();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = new ArrayMap();
      localIterator = localList.iterator();
      label266:
      if (!localIterator.hasNext()) {
        break label350;
      }
      paramInt2 = ((ColorNote)localIterator.next()).getServiceType();
      if (!((ArrayMap)localObject).containsValue(Integer.valueOf(paramInt2))) {
        break label345;
      }
    }
    label345:
    for (paramInt1 = ((Integer)((ArrayMap)localObject).valueAt(paramInt2)).intValue() + 1;; paramInt1 = 1)
    {
      ((ArrayMap)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      break label266;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
    }
    label350:
    Iterator localIterator = ((ArrayMap)localObject).keySet().iterator();
    paramInt1 = 0;
    paramInt2 = 0;
    int i;
    if (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      if (((Integer)((ArrayMap)localObject).get(Integer.valueOf(i))).intValue() <= paramInt2) {
        break label519;
      }
      paramInt1 = ((Integer)((ArrayMap)localObject).get(Integer.valueOf(i))).intValue();
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      azmj.b(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, localList.size() + "", anxm.a(paramInt1) + "", "", "");
      return;
      label519:
      i = paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(c);
  }
  
  public void onAnimationsFinished()
  {
    if (this.jdField_a_of_type_Anyx.getItemCount() == 0) {
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d();
    azmj.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzc
 * JD-Core Version:    0.7.0.1
 */