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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class bglm
{
  private agwg jdField_a_of_type_Agwg;
  private ajoe jdField_a_of_type_Ajoe;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow.OnDismissListener jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private bgkw jdField_a_of_type_Bgkw;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArrayList<bgkm> jdField_a_of_type_JavaUtilArrayList;
  private View b;
  
  public bglm(BaseChatPie paramBaseChatPie, agvc paramagvc, PopupWindow.OnDismissListener paramOnDismissListener, bgkw parambgkw)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agwg = ((agwg)paramagvc);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_Bgkw = parambgkw;
  }
  
  private void a(ajoo paramajoo, bgkm parambgkm, int paramInt)
  {
    boolean bool1 = true;
    if ((paramajoo == null) || (parambgkm == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(parambgkm instanceof bgkm))) {
      return;
    }
    Object localObject = (bglv)paramajoo;
    ((bglv)localObject).jdField_a_of_type_Bgkm = parambgkm;
    if (this.jdField_a_of_type_Bgkw != null) {
      this.jdField_a_of_type_Bgkw.a(Long.valueOf(parambgkm.a()), Long.valueOf(parambgkm.c()));
    }
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    label148:
    String str;
    if (paramInt == 0) {
      if (bool2)
      {
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840809));
        if (!bool2) {
          break label399;
        }
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        ((bglv)localObject).jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(parambgkm.a());
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(parambgkm);
        ((bglv)localObject).itemView.setTag(parambgkm);
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bglr(this));
        paramajoo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
        localObject = ((bglv)localObject).jdField_a_of_type_ComTencentImageURLImageView;
        str = parambgkm.b();
        if (parambgkm.a() != 1) {
          break label415;
        }
      }
    }
    for (;;)
    {
      bgqr.a(paramajoo, (ImageView)localObject, str, 19.0F, bool1);
      return;
      ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840808));
      break;
      if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        if (bool2)
        {
          ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840811));
          break;
        }
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840810));
        break;
      }
      if (bool2)
      {
        ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840813));
        break;
      }
      ((bglv)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840812));
      break;
      label399:
      ((bglv)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView().getHeight();
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
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755330;
      if (this.b == null)
      {
        this.b = new View(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        this.b.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getColor(2131165486));
        this.b.setOnClickListener(new bgln(this));
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131558638, null);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379486);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379489));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379487));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, false));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838639));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView, bhtq.a(175.0F), -2, true);
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener != null) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new bglo(this));
      return;
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838638));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ajoe = new bglp(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131563057);
    this.jdField_a_of_type_Ajoe.a(new bglq(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajoe);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!(this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof bgkm)))
    {
      this.jdField_a_of_type_Ajoe.a(null);
      return;
    }
    this.jdField_a_of_type_Ajoe.a();
    this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
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
        localLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidWidgetPopupWindow.getWidth() / 2 + bhtq.a(73.0F) / 2);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label173;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_Ajoe != null) {
        this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
      }
      return;
      label155:
      localLayoutParams.leftMargin = (bhtq.a(73.0F) / 2 + paramInt1);
      break;
      label173:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
    }
  }
  
  public void a(ArrayList<bgkm> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.getLayoutParams();
    if (paramArrayList.size() > 5) {}
    for (localLayoutParams.height = bhtq.a(247.0F);; localLayoutParams.height = -2)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_Ajoe == null) {
        break;
      }
      this.jdField_a_of_type_Ajoe.a();
      this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
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
      localObject = this.jdField_a_of_type_Bgkw;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label213;
      }
      paramInt1 = 0;
      ((bgkw)localObject).a(paramInt1);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        if (paramInt3 <= 0) {
          break label224;
        }
        ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] - paramInt3 + bhtq.a(73.0F) / 2);
        label93:
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label245;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-14934754);
        }
      }
      label142:
      if (!ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a())) {
        break label256;
      }
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView()).addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt2, paramInt3, paramInt4);
      if (this.jdField_a_of_type_Ajoe != null) {
        this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
      }
      return;
      label213:
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label224:
      ((LinearLayout.LayoutParams)localObject).leftMargin = (arrayOfInt[0] + bhtq.a(73.0F) / 2);
      break label93;
      label245:
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
      break label142;
      label256:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindowManager().addView(this.b, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
  }
  
  public void c()
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()))
      {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView()).removeView(this.b);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindowManager().removeView(this.b);
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
      if (ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a())) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView()).removeView(this.b);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindowManager().removeView(this.b);
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
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */