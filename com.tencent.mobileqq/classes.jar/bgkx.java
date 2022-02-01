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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bgkx
  extends bgkv
{
  private agwg jdField_a_of_type_Agwg;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private bgkw jdField_a_of_type_Bgkw;
  private bglm jdField_a_of_type_Bglm;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<bgkm> a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean;
  
  public bgkx(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, agvc paramagvc)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bgky(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bgkz(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new bgla(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bglb(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372257));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372248));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372255));
    this.jdField_a_of_type_Agwg = ((agwg)paramagvc);
    this.jdField_a_of_type_Bgkw = new bgkw(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Agwg);
  }
  
  private void a(View paramView, bgle parambgle, ArrayList<bgkm> paramArrayList)
  {
    paramView.setTag(parambgle);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    parambgle = (TextView)paramView.findViewById(2131377597);
    if (bool)
    {
      parambgle.setTextColor(Color.parseColor("#ffffff"));
      parambgle = (LinearLayout)paramView.findViewById(2131377594);
      if (!bool) {
        break label154;
      }
      parambgle.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838639));
    }
    for (;;)
    {
      parambgle = (ImageView)paramView.findViewById(2131377595);
      if (bool) {
        parambgle.setColorFilter(1996488704);
      }
      paramView = (TextView)paramView.findViewById(2131377582);
      paramView.setVisibility(0);
      paramView.setText(String.valueOf(paramArrayList.size()));
      paramView.setBackgroundResource(2130846215);
      return;
      parambgle.setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label154:
      parambgle.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838638));
    }
  }
  
  private void a(bgkm parambgkm, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambgkm);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131377591);
    ((TextView)localObject).setText(parambgkm.a());
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377589);
      if (!bool2) {
        break label210;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838639));
      label98:
      localObject = (URLImageView)paramView.findViewById(2131377590);
      if (!bool2) {
        break label233;
      }
      ((URLImageView)localObject).setColorFilter(1996488704);
      label121:
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
      String str = parambgkm.b();
      if (parambgkm.a() != 1) {
        break label242;
      }
      label144:
      bgqr.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
      paramView = (ImageView)paramView.findViewById(2131377588);
      if (!bool2) {
        break label247;
      }
      paramView.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView.setTag(parambgkm);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription("关闭");
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label210:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838638));
      break label98;
      label233:
      ((URLImageView)localObject).setColorFilter(null);
      break label121;
      label242:
      bool1 = false;
      break label144;
      label247:
      paramView.setColorFilter(null);
    }
  }
  
  private void a(bgle parambgle, ArrayList<bgkm> paramArrayList)
  {
    if (parambgle == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561639, null);
        a(localView, parambgle, paramArrayList);
        this.jdField_a_of_type_AndroidViewView = localView;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Bgkw.a();
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          return;
        }
      }
      catch (OutOfMemoryError parambgle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + parambgle.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambgle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + parambgle.getMessage());
        }
        System.gc();
      }
    }
  }
  
  private void b(ArrayList<bgkm> paramArrayList)
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ImportantMessageShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
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
      localObject = (bgkm)paramArrayList.next();
    }
    label285:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bgkw != null) {
          this.jdField_a_of_type_Bgkw.b(Long.valueOf(((bgkm)localObject).a()), Long.valueOf(((bgkm)localObject).c()));
        }
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561638, null);
        a((bgkm)localObject, localView);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if (i == 0) {
          break label285;
        }
        localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(agej.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = 0;
        bool = true;
      }
      catch (OutOfMemoryError paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      this.jdField_c_of_type_Boolean = bool;
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_Agwg.g();
      return;
    }
  }
  
  private void c(ArrayList<bgkm> paramArrayList)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bglm == null) || ((this.jdField_a_of_type_Bglm != null) && (!this.jdField_a_of_type_Bglm.a())))
      {
        this.jdField_a_of_type_Bglm = new bglm(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Agwg, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_Bgkw);
        this.jdField_a_of_type_Bglm.a();
      }
      this.jdField_a_of_type_Bglm.a(paramArrayList);
    } while ((!this.jdField_a_of_type_Bglm.a()) || (this.jdField_a_of_type_AndroidViewView == null));
    paramArrayList = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramArrayList);
    if (this.jdField_a_of_type_Bglm.a() > 5) {}
    for (int i = bhtq.a(247.0F);; i = bhtq.a(this.jdField_a_of_type_Bglm.a() * 40 + 7))
    {
      this.jdField_a_of_type_Bglm.a(this.jdField_a_of_type_AndroidViewView, paramArrayList[0] - bhtq.a(175.0F) / 2, paramArrayList[1] - i - 5, bhtq.a(175.0F), i);
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
    if (this.jdField_a_of_type_Bgkw != null)
    {
      this.jdField_a_of_type_Bgkw.c();
      this.jdField_a_of_type_Bgkw.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Agwg = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArrayList<bgkm> paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_Agwg.h();
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
      a(new bgle(0L, 0L, "更多", "", "", 0L, 0), localArrayList2);
      return;
    }
    if ((this.jdField_a_of_type_Bglm != null) && (this.jdField_a_of_type_Bglm.a())) {
      this.jdField_a_of_type_Bglm.d();
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
    if (this.jdField_a_of_type_Bglm != null) {
      this.jdField_a_of_type_Bglm.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Agwg == null)) {}
    for (;;)
    {
      return;
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_Agwg.a()) != null)
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
            if ((localObject instanceof bgle))
            {
              localObject = (bgle)localObject;
              if ((localObject != null) && (this.jdField_a_of_type_Bgkw != null)) {
                this.jdField_a_of_type_Bgkw.c(Long.valueOf(((bgle)localObject).a()), Long.valueOf(((bgle)localObject).c()));
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
 * Qualified Name:     bgkx
 * JD-Core Version:    0.7.0.1
 */