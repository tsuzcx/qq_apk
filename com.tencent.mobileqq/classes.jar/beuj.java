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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class beuj
  extends beuh
{
  private afsn jdField_a_of_type_Afsn;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private beui jdField_a_of_type_Beui;
  private beuy jdField_a_of_type_Beuy;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<betu> a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean;
  
  public beuj(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, afrc paramafrc)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new beuk(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new beul(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new beum(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new beun(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372223));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372213));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372221));
    this.jdField_a_of_type_Afsn = ((afsn)paramafrc);
    this.jdField_a_of_type_Beui = new beui(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Afsn);
  }
  
  private void a(View paramView, beuq parambeuq, ArrayList<betu> paramArrayList)
  {
    paramView.setTag(parambeuq);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    parambeuq = (TextView)paramView.findViewById(2131377365);
    if (bool)
    {
      parambeuq.setTextColor(Color.parseColor("#ffffff"));
      parambeuq = (LinearLayout)paramView.findViewById(2131377362);
      if (!bool) {
        break label154;
      }
      parambeuq.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838664));
    }
    for (;;)
    {
      parambeuq = (ImageView)paramView.findViewById(2131377363);
      if (bool) {
        parambeuq.setColorFilter(1996488704);
      }
      paramView = (TextView)paramView.findViewById(2131377350);
      paramView.setVisibility(0);
      paramView.setText(String.valueOf(paramArrayList.size()));
      paramView.setBackgroundResource(2130846108);
      return;
      parambeuq.setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label154:
      parambeuq.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838663));
    }
  }
  
  private void a(betu parambetu, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambetu);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    Object localObject = (TextView)paramView.findViewById(2131377359);
    ((TextView)localObject).setText(parambetu.a());
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377357);
      if (!bool2) {
        break label210;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838664));
      label98:
      localObject = (URLImageView)paramView.findViewById(2131377358);
      if (!bool2) {
        break label233;
      }
      ((URLImageView)localObject).setColorFilter(1996488704);
      label121:
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext;
      String str = parambetu.b();
      if (parambetu.a() != 1) {
        break label242;
      }
      label144:
      bfaf.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
      paramView = (ImageView)paramView.findViewById(2131377356);
      if (!bool2) {
        break label247;
      }
      paramView.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView.setTag(parambetu);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription("关闭");
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label210:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext.getResources().getDrawable(2130838663));
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
  
  private void a(beuq parambeuq, ArrayList<betu> paramArrayList)
  {
    if (parambeuq == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561518, null);
        a(localView, parambeuq, paramArrayList);
        this.jdField_a_of_type_AndroidViewView = localView;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Beui.a();
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          return;
        }
      }
      catch (OutOfMemoryError parambeuq)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + parambeuq.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambeuq)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + parambeuq.getMessage());
        }
        System.gc();
      }
    }
  }
  
  private void b(ArrayList<betu> paramArrayList)
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
      localObject = (betu)paramArrayList.next();
    }
    label285:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Beui != null) {
          this.jdField_a_of_type_Beui.b(Long.valueOf(((betu)localObject).a()), Long.valueOf(((betu)localObject).c()));
        }
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131561517, null);
        a((betu)localObject, localView);
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
      this.jdField_a_of_type_Afsn.g();
      return;
    }
  }
  
  private void c(ArrayList<betu> paramArrayList)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_Afsn == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Beuy == null) || ((this.jdField_a_of_type_Beuy != null) && (!this.jdField_a_of_type_Beuy.a())))
      {
        this.jdField_a_of_type_Beuy = new beuy(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Afsn, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_Beui);
        this.jdField_a_of_type_Beuy.a();
      }
      this.jdField_a_of_type_Beuy.a(paramArrayList);
    } while ((!this.jdField_a_of_type_Beuy.a()) || (this.jdField_a_of_type_AndroidViewView == null));
    paramArrayList = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramArrayList);
    if (this.jdField_a_of_type_Beuy.a() > 5) {}
    for (int i = ViewUtils.dip2px(247.0F);; i = ViewUtils.dip2px(this.jdField_a_of_type_Beuy.a() * 40 + 7))
    {
      this.jdField_a_of_type_Beuy.a(this.jdField_a_of_type_AndroidViewView, paramArrayList[0] - ViewUtils.dip2px(175.0F) / 2, paramArrayList[1] - i - 5, ViewUtils.dip2px(175.0F), i);
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
    if (this.jdField_a_of_type_Beui != null)
    {
      this.jdField_a_of_type_Beui.c();
      this.jdField_a_of_type_Beui.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Afsn = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArrayList<betu> paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_Afsn.h();
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
      a(new beuq(0L, 0L, "更多", "", "", 0L, 0), localArrayList2);
      return;
    }
    if ((this.jdField_a_of_type_Beuy != null) && (this.jdField_a_of_type_Beuy.a())) {
      this.jdField_a_of_type_Beuy.d();
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
    if (this.jdField_a_of_type_Beuy != null) {
      this.jdField_a_of_type_Beuy.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_Afsn == null)) {}
    for (;;)
    {
      return;
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_Afsn.a()) != null)
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
            if ((localObject instanceof beuq))
            {
              localObject = (beuq)localObject;
              if ((localObject != null) && (this.jdField_a_of_type_Beui != null)) {
                this.jdField_a_of_type_Beui.c(Long.valueOf(((beuq)localObject).a()), Long.valueOf(((beuq)localObject).c()));
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
 * Qualified Name:     beuj
 * JD-Core Version:    0.7.0.1
 */