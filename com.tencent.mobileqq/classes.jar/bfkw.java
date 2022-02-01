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

public class bfkw
  extends bfku
{
  private agne jdField_a_of_type_Agne;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private bfkv jdField_a_of_type_Bfkv;
  private bfll jdField_a_of_type_Bfll;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<bfkl> a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean;
  
  public bfkw(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, agma paramagma)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bfkx(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bfky(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new bfkz(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bfla(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372143));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372134));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372141));
    this.jdField_a_of_type_Agne = ((agne)paramagma);
    this.jdField_a_of_type_Bfkv = new bfkv(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Agne);
  }
  
  private void a(View paramView, bfld parambfld, ArrayList<bfkl> paramArrayList)
  {
    paramView.setTag(parambfld);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    parambfld = (TextView)paramView.findViewById(2131377443);
    if (bool)
    {
      parambfld.setTextColor(Color.parseColor("#ffffff"));
      parambfld = (LinearLayout)paramView.findViewById(2131377440);
      if (!bool) {
        break label154;
      }
      parambfld.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838626));
    }
    for (;;)
    {
      parambfld = (ImageView)paramView.findViewById(2131377441);
      if (bool) {
        parambfld.setColorFilter(1996488704);
      }
      paramView = (TextView)paramView.findViewById(2131377428);
      paramView.setVisibility(0);
      paramView.setText(String.valueOf(paramArrayList.size()));
      paramView.setBackgroundResource(2130846200);
      return;
      parambfld.setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label154:
      parambfld.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838625));
    }
  }
  
  private void a(bfkl parambfkl, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(parambfkl);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131377437);
    ((TextView)localObject).setText(parambfkl.a());
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131377435);
      if (!bool2) {
        break label210;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838626));
      label98:
      localObject = (URLImageView)paramView.findViewById(2131377436);
      if (!bool2) {
        break label233;
      }
      ((URLImageView)localObject).setColorFilter(1996488704);
      label121:
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
      String str = parambfkl.b();
      if (parambfkl.a() != 1) {
        break label242;
      }
      label144:
      bfqq.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
      paramView = (ImageView)paramView.findViewById(2131377434);
      if (!bool2) {
        break label247;
      }
      paramView.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView.setTag(parambfkl);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription("关闭");
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label210:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838625));
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
  
  private void a(bfld parambfld, ArrayList<bfkl> paramArrayList)
  {
    if (parambfld == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561598, null);
        a(localView, parambfld, paramArrayList);
        this.jdField_a_of_type_AndroidViewView = localView;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Bfkv.a();
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          return;
        }
      }
      catch (OutOfMemoryError parambfld)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + parambfld.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambfld)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImportantMessageShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + parambfld.getMessage());
        }
        System.gc();
      }
    }
  }
  
  private void b(ArrayList<bfkl> paramArrayList)
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
      localObject = (bfkl)paramArrayList.next();
    }
    label285:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bfkv != null) {
          this.jdField_a_of_type_Bfkv.b(Long.valueOf(((bfkl)localObject).a()), Long.valueOf(((bfkl)localObject).c()));
        }
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561597, null);
        a((bfkl)localObject, localView);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if (i == 0) {
          break label285;
        }
        localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
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
      this.jdField_a_of_type_Agne.g();
      return;
    }
  }
  
  private void c(ArrayList<bfkl> paramArrayList)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agne == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bfll == null) || ((this.jdField_a_of_type_Bfll != null) && (!this.jdField_a_of_type_Bfll.a())))
      {
        this.jdField_a_of_type_Bfll = new bfll(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Agne, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_Bfkv);
        this.jdField_a_of_type_Bfll.a();
      }
      this.jdField_a_of_type_Bfll.a(paramArrayList);
    } while ((!this.jdField_a_of_type_Bfll.a()) || (this.jdField_a_of_type_AndroidViewView == null));
    paramArrayList = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramArrayList);
    if (this.jdField_a_of_type_Bfll.a() > 5) {}
    for (int i = bgtn.a(247.0F);; i = bgtn.a(this.jdField_a_of_type_Bfll.a() * 40 + 7))
    {
      this.jdField_a_of_type_Bfll.a(this.jdField_a_of_type_AndroidViewView, paramArrayList[0] - bgtn.a(175.0F) / 2, paramArrayList[1] - i - 5, bgtn.a(175.0F), i);
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
    if (this.jdField_a_of_type_Bfkv != null)
    {
      this.jdField_a_of_type_Bfkv.c();
      this.jdField_a_of_type_Bfkv.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Agne = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArrayList<bfkl> paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_Agne.h();
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
      a(new bfld(0L, 0L, "更多", "", "", 0L, 0), localArrayList2);
      return;
    }
    if ((this.jdField_a_of_type_Bfll != null) && (this.jdField_a_of_type_Bfll.a())) {
      this.jdField_a_of_type_Bfll.d();
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
    if (this.jdField_a_of_type_Bfll != null) {
      this.jdField_a_of_type_Bfll.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Agne == null)) {}
    for (;;)
    {
      return;
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_Agne.a()) != null)
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
            if ((localObject instanceof bfld))
            {
              localObject = (bfld)localObject;
              if ((localObject != null) && (this.jdField_a_of_type_Bfkv != null)) {
                this.jdField_a_of_type_Bfkv.c(Long.valueOf(((bfld)localObject).a()), Long.valueOf(((bfld)localObject).c()));
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
 * Qualified Name:     bfkw
 * JD-Core Version:    0.7.0.1
 */