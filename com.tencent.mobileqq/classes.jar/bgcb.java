import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bgcb
  extends bgbq
{
  private agkb jdField_a_of_type_Agkb;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private bgbr jdField_a_of_type_Bgbr;
  private bgch jdField_a_of_type_Bgch;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<bgba> a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean;
  
  public bgcb(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, agin paramagin)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bgcc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bgcd(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new bgce(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bgcf(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372414));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372404));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372412));
    this.jdField_a_of_type_Agkb = ((agkb)paramagin);
    this.jdField_a_of_type_Bgbr = new bgbr(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Agkb);
  }
  
  private void a(View paramView, bgbu parambgbu, ArrayList<bgba> paramArrayList)
  {
    paramView.setTag(parambgbu);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    parambgbu = (TextView)paramView.findViewById(2131377638);
    if (bool)
    {
      parambgbu.setTextColor(Color.parseColor("#ffffff"));
      parambgbu = (LinearLayout)paramView.findViewById(2131377635);
      if (!bool) {
        break label154;
      }
      parambgbu.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838680));
    }
    for (;;)
    {
      parambgbu = (ImageView)paramView.findViewById(2131377636);
      if (bool) {
        parambgbu.setColorFilter(1996488704);
      }
      paramView = (TextView)paramView.findViewById(2131377623);
      paramView.setVisibility(0);
      paramView.setText(String.valueOf(paramArrayList.size()));
      paramView.setBackgroundResource(2130846203);
      return;
      parambgbu.setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label154:
      parambgbu.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838679));
    }
  }
  
  private void a(bgba parambgba, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambgba);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    Object localObject = (TextView)paramView.findViewById(2131377632);
    ((TextView)localObject).setText(parambgba.a());
    ((TextView)localObject).setContentDescription(parambgba.a());
    label107:
    Context localContext;
    label130:
    String str;
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377630);
      if (!bool2) {
        break label202;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838680));
      localObject = (URLImageView)paramView.findViewById(2131377631);
      if (!bool2) {
        break label225;
      }
      ((URLImageView)localObject).setColorFilter(1996488704);
      localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext;
      str = parambgba.b();
      if (parambgba.b() != 1) {
        break label234;
      }
    }
    for (;;)
    {
      bgil.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
      paramView = (ImageView)paramView.findViewById(2131377629);
      if (parambgba.a()) {
        break label239;
      }
      paramView.setVisibility(8);
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label202:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838679));
      break label107;
      label225:
      ((URLImageView)localObject).setColorFilter(null);
      break label130;
      label234:
      bool1 = false;
    }
    label239:
    if (bool2) {
      paramView.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView.setTag(parambgba);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription("关闭");
      return;
      paramView.setColorFilter(null);
    }
  }
  
  private void a(bgbu parambgbu, ArrayList<bgba> paramArrayList)
  {
    if (parambgbu == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561581, null);
        a(localView, parambgbu, paramArrayList);
        this.jdField_a_of_type_AndroidViewView = localView;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Bgbr.a();
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          return;
        }
      }
      catch (OutOfMemoryError parambgbu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + parambgbu.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambgbu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + parambgbu.getMessage());
        }
        System.gc();
      }
    }
  }
  
  private void b(ArrayList<bgba> paramArrayList)
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("LeftAppShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    } while (paramArrayList == null);
    paramArrayList = paramArrayList.iterator();
    boolean bool = false;
    int i = 1;
    Object localObject;
    if (paramArrayList.hasNext()) {
      localObject = (bgba)paramArrayList.next();
    }
    label285:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bgbr != null) {
          this.jdField_a_of_type_Bgbr.b(Long.valueOf(((bgba)localObject).a()), Long.valueOf(((bgba)localObject).b()));
        }
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561580, null);
        a((bgba)localObject, localView);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if (i == 0) {
          break label285;
        }
        localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().getResources()), 0, 0, 0);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = 0;
        bool = true;
      }
      catch (OutOfMemoryError paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      this.jdField_c_of_type_Boolean = bool;
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_Agkb.h();
      return;
    }
  }
  
  private void c(ArrayList<bgba> paramArrayList)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_Agkb == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bgch == null) || ((this.jdField_a_of_type_Bgch != null) && (!this.jdField_a_of_type_Bgch.a())))
      {
        this.jdField_a_of_type_Bgch = new bgch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Agkb, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_Bgbr);
        this.jdField_a_of_type_Bgch.a();
      }
      this.jdField_a_of_type_Bgch.a(paramArrayList);
    } while ((!this.jdField_a_of_type_Bgch.a()) || (this.jdField_a_of_type_AndroidViewView == null));
    paramArrayList = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramArrayList);
    if (this.jdField_a_of_type_Bgch.a() > 5) {}
    for (int i = ViewUtils.dip2px(247.0F);; i = ViewUtils.dip2px(this.jdField_a_of_type_Bgch.a() * 40 + 7))
    {
      this.jdField_a_of_type_Bgch.a(this.jdField_a_of_type_AndroidViewView, paramArrayList[0] - ViewUtils.dip2px(175.0F) / 2, paramArrayList[1] - i - 5, ViewUtils.dip2px(175.0F), i);
      return;
    }
  }
  
  public int a()
  {
    int j = 2;
    int i = j;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getChildCount() > 0) {
        i = 1;
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bgbr != null)
    {
      this.jdField_a_of_type_Bgbr.c();
      this.jdField_a_of_type_Bgbr.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Agkb = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArrayList<bgba> paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_Agkb.i();
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if ((paramArrayList.size() > 3) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      if (i < paramArrayList.size())
      {
        if (i < 2) {
          localArrayList1.add(paramArrayList.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList2.add(paramArrayList.get(i));
        }
      }
      b(localArrayList1);
      a(new bgbu(0L, 0L, "更多", "", "", 0L, 0), localArrayList2);
      return;
    }
    if ((this.jdField_a_of_type_Bgch != null) && (this.jdField_a_of_type_Bgch.a())) {
      this.jdField_a_of_type_Bgch.d();
    }
    b(paramArrayList);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bgch != null) {
      this.jdField_a_of_type_Bgch.b();
    }
  }
  
  public void d() {}
  
  public void e()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_Agkb == null)) {}
    for (;;)
    {
      return;
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_Agkb.a()) != null)
      {
        Rect localRect = new Rect();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
        int i = 0;
        while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
        {
          Object localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
          {
            localObject = ((View)localObject).getTag();
            if ((localObject instanceof bgbu))
            {
              localObject = (bgbu)localObject;
              if ((localObject != null) && (this.jdField_a_of_type_Bgbr != null)) {
                this.jdField_a_of_type_Bgbr.c(Long.valueOf(((bgbu)localObject).a()), Long.valueOf(((bgbu)localObject).b()));
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcb
 * JD-Core Version:    0.7.0.1
 */