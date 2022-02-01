import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class bgch
{
  private agkb jdField_a_of_type_Agkb;
  private ajdm jdField_a_of_type_Ajdm;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow.OnDismissListener jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private bgbr jdField_a_of_type_Bgbr;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArrayList<bgba> jdField_a_of_type_JavaUtilArrayList;
  private View b;
  
  public bgch(BaseChatPie paramBaseChatPie, agin paramagin, PopupWindow.OnDismissListener paramOnDismissListener, bgbr parambgbr)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agkb = ((agkb)paramagin);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_Bgbr = parambgbr;
  }
  
  private void a(ajdw paramajdw, bgba parambgba, int paramInt)
  {
    boolean bool1 = true;
    if ((paramajdw == null) || (parambgba == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(parambgba instanceof bgba))) {
      return;
    }
    Object localObject = (bgcq)paramajdw;
    ((bgcq)localObject).jdField_a_of_type_Bgba = parambgba;
    if (this.jdField_a_of_type_Bgbr != null) {
      this.jdField_a_of_type_Bgbr.a(Long.valueOf(parambgba.a()), Long.valueOf(parambgba.b()));
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    label148:
    String str;
    if (paramInt == 0) {
      if (bool2)
      {
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840883));
        if (!bool2) {
          break label399;
        }
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        ((bgcq)localObject).jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(parambgba.a());
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(parambgba);
        ((bgcq)localObject).itemView.setTag(parambgba);
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bgcm(this));
        paramajdw = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext;
        localObject = ((bgcq)localObject).jdField_a_of_type_ComTencentImageURLImageView;
        str = parambgba.b();
        if (parambgba.b() != 1) {
          break label415;
        }
      }
    }
    for (;;)
    {
      bgil.a(paramajdw, (ImageView)localObject, str, 19.0F, bool1);
      return;
      ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840882));
      break;
      if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        if (bool2)
        {
          ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840885));
          break;
        }
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840884));
        break;
      }
      if (bool2)
      {
        ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840887));
        break;
      }
      ((bgcq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130840886));
      break;
      label399:
      ((bgcq)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label148;
      label415:
      bool1 = false;
    }
  }
  
  private void e()
  {
    int j = -1;
    int i;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label215;
          }
          i = j;
        }
      }
    }
    label215:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755331;
      if (this.b == null)
      {
        this.b = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
        this.b.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getResources().getColor(2131165500));
        this.b.setOnClickListener(new bgci(this));
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext).inflate(2131558654, null);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379560);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379563));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379561));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), 1, false));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app)) {
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838680));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView, ViewUtils.dip2px(175.0F), -2, true);
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener != null) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new bgcj(this));
      return;
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838679));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ajdm = new bgck(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), 2131563012);
    this.jdField_a_of_type_Ajdm.a(new bgcl(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajdm);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!(this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof bgba)))
    {
      this.jdField_a_of_type_Ajdm.a(null);
      return;
    }
    this.jdField_a_of_type_Ajdm.a();
    this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ajdm.notifyDataSetChanged();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    f();
    g();
    h();
    e();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramView != null))
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        paramView.getLocationOnScreen(new int[2]);
        if (paramInt1 <= this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2) {
          break label155;
        }
        localLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2 + ViewUtils.dip2px(73.0F) / 2);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app)) {
            break label173;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_Ajdm != null) {
        this.jdField_a_of_type_Ajdm.notifyDataSetChanged();
      }
      return;
      label155:
      localLayoutParams.leftMargin = (ViewUtils.dip2px(73.0F) / 2 + paramInt1);
      break;
      label173:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
    }
  }
  
  public void a(ArrayList<bgba> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.getLayoutParams();
    if (paramArrayList.size() > 5) {}
    for (localLayoutParams.height = ViewUtils.dip2px(247.0F);; localLayoutParams.height = -2)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_Ajdm == null) {
        break;
      }
      this.jdField_a_of_type_Ajdm.a();
      this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ajdm.notifyDataSetChanged();
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      return this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (paramView != null))
    {
      localObject = this.jdField_a_of_type_Bgbr;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label220;
      }
      paramInt1 = 0;
      ((bgbr)localObject).a(paramInt1);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        if (paramInt3 <= 0) {
          break label231;
        }
        ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] - paramInt3 + ViewUtils.dip2px(73.0F) / 2);
        label93:
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app)) {
            break label252;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
      label142:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        if (!ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity())) {
          break label263;
        }
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView()).addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_Ajdm != null) {
        this.jdField_a_of_type_Ajdm.notifyDataSetChanged();
      }
      return;
      label220:
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label231:
      ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] + ViewUtils.dip2px(73.0F) / 2);
      break label93;
      label252:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
      break label142;
      label263:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindowManager().addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
  }
  
  public void c()
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity()))
      {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView()).removeView(this.b);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindowManager().removeView(this.b);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMoreListDialog", 2, localException.toString());
      }
    }
  }
  
  public void d()
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity())) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow().getDecorView()).removeView(this.b);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindowManager().removeView(this.b);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMoreListDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgch
 * JD-Core Version:    0.7.0.1
 */